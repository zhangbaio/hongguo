# -*- coding: utf-8 -*-
"""Extract mKid/mSpadea pairs and nearby keybox kid->key votes from a memory dump.

The keybox entry observed in e4.bin is 32 bytes:
  6-byte type, 2-byte tag, 8 zero bytes, 16-byte value

For value entries with type 01 0d 01 00 00 00:
  - value ending in ebeb is a binary kid
  - value[8:16] == 0 and value[:8] != 0 is an IV/counter value
  - high-entropy 16-byte values near a kid are content-key candidates
"""
from __future__ import annotations

import argparse
import base64
import json
import mmap
import re
from collections import Counter, defaultdict
from pathlib import Path


ENTRY_PREFIX = b"\x01\x0d\x01\x00\x00\x00"
ZERO8 = b"\x00" * 8


def clean_json_escape(value: str) -> str:
    return value.replace("\\u003d", "=").replace("\\/", "/")


def classify_value(value: bytes) -> str:
    if value.endswith(b"\xeb\xeb"):
        return "kid"
    if value[:8] != ZERO8 and value[8:] == ZERO8:
        return "iv"
    if value != b"\x00" * 16 and len(set(value)) >= 10 and value.count(0) <= 3:
        return "key"
    return "other"


def extract_mkid_spade(mm: mmap.mmap, back_window: int = 8192) -> dict[str, set[str]]:
    out: dict[str, set[str]] = defaultdict(set)
    needle = b'"mSpadea":"'
    pos = 0
    while True:
        off = mm.find(needle, pos)
        if off < 0:
            break
        value_start = off + len(needle)
        value_end = mm.find(b'"', value_start)
        if value_end < 0:
            break

        spade = clean_json_escape(mm[value_start:value_end].decode("ascii", "ignore"))
        window = mm[max(0, off - back_window) : off]
        kids = re.findall(rb'"mKid":"([0-9a-f]{32})"', window)
        if kids:
            out[kids[-1].decode("ascii")].add(spade)
        pos = value_end + 1
    return out


def iter_keybox_entries(mm: mmap.mmap):
    off = mm.find(ENTRY_PREFIX)
    while off >= 0:
        if off + 32 <= len(mm) and mm[off + 8 : off + 16] == ZERO8:
            value = bytes(mm[off + 16 : off + 32])
            yield {
                "offset": off,
                "tag": bytes(mm[off + 6 : off + 8]).hex(),
                "value": value,
                "kind": classify_value(value),
            }
        off = mm.find(ENTRY_PREFIX, off + 1)


def extract_key_votes(entries: list[dict], lookahead_bytes: int, iv_window: int):
    key_votes: dict[str, Counter[str]] = defaultdict(Counter)
    key_offsets: dict[tuple[str, str], set[int]] = defaultdict(set)
    iv_candidates: dict[str, Counter[str]] = defaultdict(Counter)

    for index, entry in enumerate(entries):
        if entry["kind"] != "kid":
            continue
        kid = entry["value"].hex()
        kid_off = entry["offset"]

        for other in entries[index + 1 : index + 16]:
            delta = other["offset"] - kid_off
            if delta > lookahead_bytes:
                break
            if other["kind"] == "key":
                key_hex = other["value"].hex()
                key_votes[kid][key_hex] += 1
                key_offsets[(kid, key_hex)].add(other["offset"])
                break

        for other in entries[max(0, index - 64) : index + 65]:
            if abs(other["offset"] - kid_off) <= iv_window and other["kind"] == "iv":
                iv_candidates[kid][other["value"][:8].hex()] += 1

    return key_votes, key_offsets, iv_candidates


def decoded_spade_hex(spade: str) -> str | None:
    try:
        return base64.b64decode(spade).hex()
    except Exception:
        return None


def build_report(dump_path: Path, lookahead_bytes: int, iv_window: int) -> dict:
    with dump_path.open("rb") as f:
        mm = mmap.mmap(f.fileno(), 0, access=mmap.ACCESS_READ)
        spades = extract_mkid_spade(mm)
        entries = list(iter_keybox_entries(mm))
        key_votes, key_offsets, iv_candidates = extract_key_votes(
            entries, lookahead_bytes=lookahead_bytes, iv_window=iv_window
        )

    joined = []
    all_kids = sorted(set(spades) | set(key_votes))
    for kid in all_kids:
        spade_values = sorted(spades.get(kid, ()))
        keys = []
        for key_hex, count in key_votes.get(kid, Counter()).most_common():
            keys.append(
                {
                    "key": key_hex,
                    "votes": count,
                    "offsets": [hex(x) for x in key_offsets[(kid, key_hex)]],
                }
            )
        ivc = iv_candidates.get(kid, Counter())
        # base_iv64 = 主导6字节前缀组里数值最小的 iv8 (=最低样本索引; 窗口含sample0时即真base_iv)
        base_iv64 = None
        if ivc:
            pref = Counter(iv[:12] for iv in ivc).most_common(1)[0][0]  # 6字节=12 hex
            base_iv64 = min(iv for iv in ivc if iv[:12] == pref)
        joined.append(
            {
                "kid": kid,
                "spade_a": spade_values,
                "spade_bytes": [decoded_spade_hex(x) for x in spade_values],
                "keys": keys,
                "base_iv64": base_iv64,
                "iv8_candidates": [
                    {"iv8": iv, "votes": count}
                    for iv, count in ivc.most_common(16)
                ],
            }
        )

    return {
        "dump": str(dump_path),
        "entry_counts": dict(Counter(e["kind"] for e in entries)),
        "mspade_kids": len(spades),
        "keybox_kids": len(key_votes),
        "joined": joined,
    }


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("dump", nargs="?", default="capture/e4.bin")
    parser.add_argument("-o", "--output", default="capture/spade_key_pairs.auto.json")
    parser.add_argument("--lookahead-bytes", type=int, default=256)
    parser.add_argument("--iv-window", type=int, default=512)
    args = parser.parse_args()

    report = build_report(
        Path(args.dump),
        lookahead_bytes=args.lookahead_bytes,
        iv_window=args.iv_window,
    )
    Path(args.output).write_text(json.dumps(report, indent=2), encoding="utf-8")

    print(f"wrote {args.output}")
    print(f"entry_counts={report['entry_counts']}")
    print(f"mspade_kids={report['mspade_kids']} keybox_kids={report['keybox_kids']}")
    for item in report["joined"]:
        if item["keys"]:
            key = item["keys"][0]
            print(
                f"kid={item['kid']} key={key['key']} votes={key['votes']} "
                f"spade_count={len(item['spade_a'])}"
            )


if __name__ == "__main__":
    main()

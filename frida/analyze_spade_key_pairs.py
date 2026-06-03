# -*- coding: utf-8 -*-
"""Aggregate extracted spade/key reports and test simple unwrap hypotheses."""
from __future__ import annotations

import argparse
import base64
import glob
import json
from collections import defaultdict
from pathlib import Path


def load_pairs(pattern: str):
    pairs = []
    seen = set()
    for filename in sorted(glob.glob(pattern)):
        data = json.loads(Path(filename).read_text(encoding="utf-8"))
        for item in data.get("joined", []):
            if not item.get("keys") or not item.get("spade_a"):
                continue
            row = (item["kid"], item["spade_a"][0], item["keys"][0]["key"], filename)
            if row not in seen:
                seen.add(row)
                pairs.append(row)
    return pairs


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("pattern", nargs="?", default="capture/spade_key_pairs*.json")
    parser.add_argument("-o", "--output", default="capture/spade_key_pairs.aggregate.json")
    args = parser.parse_args()

    pairs = load_pairs(args.pattern)
    report = {
        "pairs": [
            {
                "kid": kid,
                "spade_a": spade,
                "spade_bytes": base64.b64decode(spade).hex(),
                "key": key,
                "source": source,
            }
            for kid, spade, key, source in pairs
        ],
        "tests": {},
    }

    subblock_hits = []
    constant_xor_masks = []
    byte_xor_candidates = []

    if pairs:
        for off in range(0, 37 - 16 + 1):
            hits = []
            masks = []
            for index, (_, spade, key, _) in enumerate(pairs):
                spade_bytes = base64.b64decode(spade)
                key_bytes = bytes.fromhex(key)
                if spade_bytes[off : off + 16] == key_bytes:
                    hits.append(index)
                masks.append(bytes(a ^ b for a, b in zip(spade_bytes[off : off + 16], key_bytes)))
            if hits:
                subblock_hits.append({"offset": off, "pair_indexes": hits})
            if len(set(masks)) == 1:
                constant_xor_masks.append({"offset": off, "mask": masks[0].hex()})

        for key_index in range(16):
            for spade_index in range(37):
                values = []
                for _, spade, key, _ in pairs:
                    values.append(bytes.fromhex(key)[key_index] ^ base64.b64decode(spade)[spade_index])
                if len(set(values)) == 1:
                    byte_xor_candidates.append(
                        {"key_index": key_index, "spade_index": spade_index, "xor": values[0]}
                    )

    same_key_groups = defaultdict(list)
    for kid, spade, key, source in pairs:
        same_key_groups[key].append({"kid": kid, "spade_a": spade, "source": source})

    report["tests"] = {
        "subblock_hits": subblock_hits,
        "constant_xor_masks": constant_xor_masks,
        "byte_xor_candidates": byte_xor_candidates,
        "same_key_groups": {k: v for k, v in same_key_groups.items() if len(v) > 1},
    }

    Path(args.output).write_text(json.dumps(report, indent=2), encoding="utf-8")

    print(f"pairs={len(pairs)}")
    for index, row in enumerate(report["pairs"]):
        print(f"{index}: kid={row['kid']} key={row['key']} source={row['source']}")
    print(f"subblock_hits={len(subblock_hits)}")
    print(f"constant_xor_masks={len(constant_xor_masks)}")
    print(f"byte_xor_candidates={len(byte_xor_candidates)}")
    print(f"same_key_groups={len(report['tests']['same_key_groups'])}")
    print(f"wrote {args.output}")


if __name__ == "__main__":
    main()

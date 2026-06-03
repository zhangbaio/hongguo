package com.dragon.read.multigenre.bean;

import com.bytedance.covode.number.Covode;
import js4.b;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CoverExtendViewType implements b {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CoverExtendViewType[] $VALUES;
    public static final CoverExtendViewType AUDIO_DETAIL_COVER_DISTINGUISH_TTS_AND_REAL_VOICE;
    public static final CoverExtendViewType AUDIO_DETAIL_COVER_VIP_ICON;
    public static final CoverExtendViewType TYPE_COMIC_HINT;
    public static final CoverExtendViewType TYPE_DARK_MASK;
    public static final CoverExtendViewType TYPE_FINISH;
    public static final CoverExtendViewType TYPE_PAID_BOOK;
    public static final CoverExtendViewType TYPE_SCORE;
    public static final CoverExtendViewType TYPE_SHADOW_DOWN;
    public static final CoverExtendViewType TYPE_SOLE_ICON;
    public static final CoverExtendViewType TYPE_TEXTURE_LAYER;
    public static final CoverExtendViewType TYPE_UPDATE;
    public static final CoverExtendViewType TYPE_VIDEO_RANK;

    private static final /* synthetic */ CoverExtendViewType[] $values() {
        return new CoverExtendViewType[]{TYPE_COMIC_HINT, TYPE_UPDATE, TYPE_FINISH, TYPE_SHADOW_DOWN, TYPE_SCORE, TYPE_SOLE_ICON, TYPE_TEXTURE_LAYER, TYPE_DARK_MASK, AUDIO_DETAIL_COVER_DISTINGUISH_TTS_AND_REAL_VOICE, AUDIO_DETAIL_COVER_VIP_ICON, TYPE_PAID_BOOK, TYPE_VIDEO_RANK};
    }

    public static EnumEntries<CoverExtendViewType> getEntries() {
        return $ENTRIES;
    }

    public static CoverExtendViewType[] values() {
        return (CoverExtendViewType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(612357);
        TYPE_COMIC_HINT = new CoverExtendViewType("TYPE_COMIC_HINT", 0);
        TYPE_UPDATE = new CoverExtendViewType("TYPE_UPDATE", 1);
        TYPE_FINISH = new CoverExtendViewType("TYPE_FINISH", 2);
        TYPE_SHADOW_DOWN = new CoverExtendViewType("TYPE_SHADOW_DOWN", 3);
        TYPE_SCORE = new CoverExtendViewType("TYPE_SCORE", 4);
        TYPE_SOLE_ICON = new CoverExtendViewType("TYPE_SOLE_ICON", 5);
        TYPE_TEXTURE_LAYER = new CoverExtendViewType("TYPE_TEXTURE_LAYER", 6);
        TYPE_DARK_MASK = new CoverExtendViewType("TYPE_DARK_MASK", 7);
        AUDIO_DETAIL_COVER_DISTINGUISH_TTS_AND_REAL_VOICE = new CoverExtendViewType("AUDIO_DETAIL_COVER_DISTINGUISH_TTS_AND_REAL_VOICE", 8);
        AUDIO_DETAIL_COVER_VIP_ICON = new CoverExtendViewType("AUDIO_DETAIL_COVER_VIP_ICON", 9);
        TYPE_PAID_BOOK = new CoverExtendViewType("TYPE_PAID_BOOK", 10);
        TYPE_VIDEO_RANK = new CoverExtendViewType("TYPE_VIDEO_RANK", 11);
        CoverExtendViewType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CoverExtendViewType valueOf(String str) {
        return (CoverExtendViewType) Enum.valueOf(CoverExtendViewType.class, str);
    }

    private CoverExtendViewType(String str, int i) {
    }
}

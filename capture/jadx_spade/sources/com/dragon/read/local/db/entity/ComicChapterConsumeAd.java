package com.dragon.read.local.db.entity;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ComicChapterConsumeAd {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ComicChapterConsumeAd[] $VALUES;
    public static final ComicChapterConsumeAd CONSUME_DEFAULT;
    public static final ComicChapterConsumeAd CONSUME_SUCCESS;
    private final int value;

    private static final /* synthetic */ ComicChapterConsumeAd[] $values() {
        return new ComicChapterConsumeAd[]{CONSUME_SUCCESS, CONSUME_DEFAULT};
    }

    public static EnumEntries<ComicChapterConsumeAd> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static ComicChapterConsumeAd[] values() {
        return (ComicChapterConsumeAd[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611571);
        CONSUME_SUCCESS = new ComicChapterConsumeAd("CONSUME_SUCCESS", 0, 1);
        CONSUME_DEFAULT = new ComicChapterConsumeAd("CONSUME_DEFAULT", 1, 0);
        ComicChapterConsumeAd[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ComicChapterConsumeAd valueOf(String str) {
        return (ComicChapterConsumeAd) Enum.valueOf(ComicChapterConsumeAd.class, str);
    }

    private ComicChapterConsumeAd(String str, int i, int i2) {
        this.value = i2;
    }
}

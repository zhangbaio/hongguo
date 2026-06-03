package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TagStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TagStyle[] $VALUES;
    public static final TagStyle HIGHLIGHT;
    public static final TagStyle NORMAL;
    public static final TagStyle WHEAT;

    private static final /* synthetic */ TagStyle[] $values() {
        return new TagStyle[]{NORMAL, HIGHLIGHT, WHEAT};
    }

    public static EnumEntries<TagStyle> getEntries() {
        return $ENTRIES;
    }

    public static TagStyle[] values() {
        return (TagStyle[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608588);
        NORMAL = new TagStyle("NORMAL", 0);
        HIGHLIGHT = new TagStyle("HIGHLIGHT", 1);
        WHEAT = new TagStyle("WHEAT", 2);
        TagStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TagStyle valueOf(String str) {
        return (TagStyle) Enum.valueOf(TagStyle.class, str);
    }

    private TagStyle(String str, int i) {
    }
}

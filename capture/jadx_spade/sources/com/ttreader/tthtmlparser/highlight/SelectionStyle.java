package com.ttreader.tthtmlparser.highlight;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectionStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionStyle[] $VALUES;
    public static final SelectionStyle SelectionParagraph;
    public static final SelectionStyle SelectionPartialWord;
    public static final SelectionStyle SelectionSentence;
    public static final SelectionStyle SelectionWord;

    private static final /* synthetic */ SelectionStyle[] $values() {
        return new SelectionStyle[]{SelectionParagraph, SelectionWord, SelectionPartialWord, SelectionSentence};
    }

    public static EnumEntries<SelectionStyle> getEntries() {
        return $ENTRIES;
    }

    public static SelectionStyle[] values() {
        return (SelectionStyle[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(654775);
        SelectionParagraph = new SelectionStyle("SelectionParagraph", 0);
        SelectionWord = new SelectionStyle("SelectionWord", 1);
        SelectionPartialWord = new SelectionStyle("SelectionPartialWord", 2);
        SelectionSentence = new SelectionStyle("SelectionSentence", 3);
        SelectionStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SelectionStyle valueOf(String str) {
        return (SelectionStyle) Enum.valueOf(SelectionStyle.class, str);
    }

    private SelectionStyle(String str, int i) {
    }
}

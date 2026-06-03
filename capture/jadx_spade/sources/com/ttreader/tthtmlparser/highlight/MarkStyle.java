package com.ttreader.tthtmlparser.highlight;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class MarkStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MarkStyle[] $VALUES;
    public static final MarkStyle Background;
    public static final MarkStyle Dotted;
    public static final MarkStyle IrregularWavyLines;
    public static final MarkStyle MarkerBackground;
    public static final MarkStyle PencilLine;
    public static final MarkStyle StraightLine;
    public static final MarkStyle WavyLines;

    private static final /* synthetic */ MarkStyle[] $values() {
        return new MarkStyle[]{StraightLine, WavyLines, Background, Dotted, IrregularWavyLines, MarkerBackground, PencilLine};
    }

    public static EnumEntries<MarkStyle> getEntries() {
        return $ENTRIES;
    }

    public static MarkStyle[] values() {
        return (MarkStyle[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(654773);
        StraightLine = new MarkStyle("StraightLine", 0);
        WavyLines = new MarkStyle("WavyLines", 1);
        Background = new MarkStyle("Background", 2);
        Dotted = new MarkStyle("Dotted", 3);
        IrregularWavyLines = new MarkStyle("IrregularWavyLines", 4);
        MarkerBackground = new MarkStyle("MarkerBackground", 5);
        PencilLine = new MarkStyle("PencilLine", 6);
        MarkStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static MarkStyle valueOf(String str) {
        return (MarkStyle) Enum.valueOf(MarkStyle.class, str);
    }

    private MarkStyle(String str, int i) {
    }
}

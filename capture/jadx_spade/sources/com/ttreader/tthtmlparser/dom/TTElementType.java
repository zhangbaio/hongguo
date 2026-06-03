package com.ttreader.tthtmlparser.dom;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTElementType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TTElementType[] $VALUES;
    public static final TTElementType NODE_CDATA;
    public static final TTElementType NODE_COMMENT;
    public static final TTElementType NODE_DOCUMENT;
    public static final TTElementType NODE_ELEMENT;
    public static final TTElementType NODE_TEMPLATE;
    public static final TTElementType NODE_TEXT;
    public static final TTElementType NODE_WHITESPACE;

    private static final /* synthetic */ TTElementType[] $values() {
        return new TTElementType[]{NODE_DOCUMENT, NODE_ELEMENT, NODE_TEXT, NODE_CDATA, NODE_COMMENT, NODE_WHITESPACE, NODE_TEMPLATE};
    }

    public static EnumEntries<TTElementType> getEntries() {
        return $ENTRIES;
    }

    public static TTElementType[] values() {
        return (TTElementType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(654765);
        NODE_DOCUMENT = new TTElementType("NODE_DOCUMENT", 0);
        NODE_ELEMENT = new TTElementType("NODE_ELEMENT", 1);
        NODE_TEXT = new TTElementType("NODE_TEXT", 2);
        NODE_CDATA = new TTElementType("NODE_CDATA", 3);
        NODE_COMMENT = new TTElementType("NODE_COMMENT", 4);
        NODE_WHITESPACE = new TTElementType("NODE_WHITESPACE", 5);
        NODE_TEMPLATE = new TTElementType("NODE_TEMPLATE", 6);
        TTElementType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TTElementType valueOf(String str) {
        return (TTElementType) Enum.valueOf(TTElementType.class, str);
    }

    private TTElementType(String str, int i) {
    }
}

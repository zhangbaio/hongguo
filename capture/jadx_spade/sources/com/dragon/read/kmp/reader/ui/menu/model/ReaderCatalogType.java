package com.dragon.read.kmp.reader.ui.menu.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderCatalogType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReaderCatalogType[] $VALUES;
    public static final ReaderCatalogType CATALOG;
    public static final ReaderCatalogType COMMENT;
    public static final ReaderCatalogType DETAIL;
    public static final ReaderCatalogType NOTE;
    public static final ReaderCatalogType NOT_SET;
    public static final ReaderCatalogType SEARCH;

    private static final /* synthetic */ ReaderCatalogType[] $values() {
        return new ReaderCatalogType[]{CATALOG, NOTE, SEARCH, DETAIL, COMMENT, NOT_SET};
    }

    public static EnumEntries<ReaderCatalogType> getEntries() {
        return $ENTRIES;
    }

    public static ReaderCatalogType[] values() {
        return (ReaderCatalogType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608611);
        CATALOG = new ReaderCatalogType("CATALOG", 0);
        NOTE = new ReaderCatalogType("NOTE", 1);
        SEARCH = new ReaderCatalogType("SEARCH", 2);
        DETAIL = new ReaderCatalogType("DETAIL", 3);
        COMMENT = new ReaderCatalogType("COMMENT", 4);
        NOT_SET = new ReaderCatalogType("NOT_SET", 5);
        ReaderCatalogType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ReaderCatalogType valueOf(String str) {
        return (ReaderCatalogType) Enum.valueOf(ReaderCatalogType.class, str);
    }

    private ReaderCatalogType(String str, int i) {
    }
}

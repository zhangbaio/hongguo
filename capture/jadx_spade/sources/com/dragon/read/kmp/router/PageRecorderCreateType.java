package com.dragon.read.kmp.router;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PageRecorderCreateType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PageRecorderCreateType[] $VALUES;
    public static final PageRecorderCreateType COPY_PARENT;
    public static final PageRecorderCreateType NEW;

    private static final /* synthetic */ PageRecorderCreateType[] $values() {
        return new PageRecorderCreateType[]{COPY_PARENT, NEW};
    }

    public static EnumEntries<PageRecorderCreateType> getEntries() {
        return $ENTRIES;
    }

    public static PageRecorderCreateType[] values() {
        return (PageRecorderCreateType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608708);
        COPY_PARENT = new PageRecorderCreateType("COPY_PARENT", 0);
        NEW = new PageRecorderCreateType("NEW", 1);
        PageRecorderCreateType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PageRecorderCreateType valueOf(String str) {
        return (PageRecorderCreateType) Enum.valueOf(PageRecorderCreateType.class, str);
    }

    private PageRecorderCreateType(String str, int i) {
    }
}

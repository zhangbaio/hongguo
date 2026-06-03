package com.dragon.read.kmp.reader.bookcover;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookCoverDataLoadState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BookCoverDataLoadState[] $VALUES;
    public static final BookCoverDataLoadState EMPTY;
    public static final BookCoverDataLoadState ERROR;
    public static final BookCoverDataLoadState INIT;
    public static final BookCoverDataLoadState SUCCESS;

    private static final /* synthetic */ BookCoverDataLoadState[] $values() {
        return new BookCoverDataLoadState[]{INIT, EMPTY, SUCCESS, ERROR};
    }

    public static EnumEntries<BookCoverDataLoadState> getEntries() {
        return $ENTRIES;
    }

    public static BookCoverDataLoadState[] values() {
        return (BookCoverDataLoadState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608262);
        INIT = new BookCoverDataLoadState("INIT", 0);
        EMPTY = new BookCoverDataLoadState("EMPTY", 1);
        SUCCESS = new BookCoverDataLoadState("SUCCESS", 2);
        ERROR = new BookCoverDataLoadState("ERROR", 3);
        BookCoverDataLoadState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BookCoverDataLoadState valueOf(String str) {
        return (BookCoverDataLoadState) Enum.valueOf(BookCoverDataLoadState.class, str);
    }

    private BookCoverDataLoadState(String str, int i) {
    }
}

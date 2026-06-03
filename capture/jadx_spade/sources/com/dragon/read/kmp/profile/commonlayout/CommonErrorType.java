package com.dragon.read.kmp.profile.commonlayout;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommonErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommonErrorType[] $VALUES;
    public static final CommonErrorType DefaultError;
    public static final CommonErrorType Empty;
    public static final CommonErrorType SPECIFIC_ERROR;

    private static final /* synthetic */ CommonErrorType[] $values() {
        return new CommonErrorType[]{Empty, DefaultError, SPECIFIC_ERROR};
    }

    public static EnumEntries<CommonErrorType> getEntries() {
        return $ENTRIES;
    }

    public static CommonErrorType[] values() {
        return (CommonErrorType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608033);
        Empty = new CommonErrorType("Empty", 0);
        DefaultError = new CommonErrorType("DefaultError", 1);
        SPECIFIC_ERROR = new CommonErrorType("SPECIFIC_ERROR", 2);
        CommonErrorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CommonErrorType valueOf(String str) {
        return (CommonErrorType) Enum.valueOf(CommonErrorType.class, str);
    }

    private CommonErrorType(String str, int i) {
    }
}

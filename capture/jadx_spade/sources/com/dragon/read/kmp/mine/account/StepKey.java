package com.dragon.read.kmp.mine.account;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StepKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StepKey[] $VALUES;
    public static final StepKey NEW_CODE;
    public static final StepKey NEW_PHONE;
    public static final StepKey OLD_CODE;
    public static final StepKey OLD_PHONE;

    private static final /* synthetic */ StepKey[] $values() {
        return new StepKey[]{OLD_PHONE, OLD_CODE, NEW_PHONE, NEW_CODE};
    }

    public static EnumEntries<StepKey> getEntries() {
        return $ENTRIES;
    }

    public static StepKey[] values() {
        return (StepKey[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607677);
        OLD_PHONE = new StepKey("OLD_PHONE", 0);
        OLD_CODE = new StepKey("OLD_CODE", 1);
        NEW_PHONE = new StepKey("NEW_PHONE", 2);
        NEW_CODE = new StepKey("NEW_CODE", 3);
        StepKey[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static StepKey valueOf(String str) {
        return (StepKey) Enum.valueOf(StepKey.class, str);
    }

    private StepKey(String str, int i) {
    }
}

package com.dragon.read.kmp.mine.profile;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VerifyStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VerifyStatus[] $VALUES;
    public static final a Companion;
    public static final VerifyStatus FAILED;
    public static final VerifyStatus NOT_VERIFY;
    public static final VerifyStatus REVIEWING;
    public static final VerifyStatus SUCCEED;
    private final int value;

    private static final /* synthetic */ VerifyStatus[] $values() {
        return new VerifyStatus[]{NOT_VERIFY, SUCCEED, REVIEWING, FAILED};
    }

    public static EnumEntries<VerifyStatus> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static VerifyStatus[] values() {
        return (VerifyStatus[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607742);
        NOT_VERIFY = new VerifyStatus("NOT_VERIFY", 0, 0);
        SUCCEED = new VerifyStatus("SUCCEED", 1, 1);
        REVIEWING = new VerifyStatus("REVIEWING", 2, 2);
        FAILED = new VerifyStatus("FAILED", 3, 3);
        VerifyStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static VerifyStatus valueOf(String str) {
        return (VerifyStatus) Enum.valueOf(VerifyStatus.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(607743);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VerifyStatus a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return VerifyStatus.NOT_VERIFY;
                        }
                        return VerifyStatus.FAILED;
                    }
                    return VerifyStatus.REVIEWING;
                }
                return VerifyStatus.SUCCEED;
            }
            return VerifyStatus.NOT_VERIFY;
        }
    }

    private VerifyStatus(String str, int i, int i2) {
        this.value = i2;
    }
}

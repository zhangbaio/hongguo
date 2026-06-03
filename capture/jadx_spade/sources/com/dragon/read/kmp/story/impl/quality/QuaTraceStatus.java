package com.dragon.read.kmp.story.impl.quality;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class QuaTraceStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QuaTraceStatus[] $VALUES;
    public static final QuaTraceStatus CANCEL;
    public static final a Companion;
    public static final QuaTraceStatus FAIL;
    public static final QuaTraceStatus LOADING;
    public static final QuaTraceStatus SUCCESS;
    private final int value;

    public static final class a {
        static {
            Covode.recordClassIndex(609379);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ QuaTraceStatus[] $values() {
        return new QuaTraceStatus[]{SUCCESS, FAIL, LOADING, CANCEL};
    }

    public static EnumEntries<QuaTraceStatus> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static QuaTraceStatus[] values() {
        return (QuaTraceStatus[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609378);
        SUCCESS = new QuaTraceStatus("SUCCESS", 0, 1);
        FAIL = new QuaTraceStatus("FAIL", 1, 2);
        LOADING = new QuaTraceStatus("LOADING", 2, 3);
        CANCEL = new QuaTraceStatus("CANCEL", 3, 4);
        QuaTraceStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static QuaTraceStatus valueOf(String str) {
        return (QuaTraceStatus) Enum.valueOf(QuaTraceStatus.class, str);
    }

    private QuaTraceStatus(String str, int i, int i2) {
        this.value = i2;
    }
}

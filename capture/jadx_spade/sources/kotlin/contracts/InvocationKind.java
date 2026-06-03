package kotlin.contracts;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InvocationKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InvocationKind[] $VALUES;
    public static final InvocationKind AT_LEAST_ONCE;
    public static final InvocationKind AT_MOST_ONCE;
    public static final InvocationKind EXACTLY_ONCE;
    public static final InvocationKind UNKNOWN;

    private static final /* synthetic */ InvocationKind[] $values() {
        return new InvocationKind[]{AT_MOST_ONCE, AT_LEAST_ONCE, EXACTLY_ONCE, UNKNOWN};
    }

    public static EnumEntries<InvocationKind> getEntries() {
        return $ENTRIES;
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(658286);
        AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);
        AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);
        EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);
        UNKNOWN = new InvocationKind("UNKNOWN", 3);
        InvocationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static InvocationKind valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    private InvocationKind(String str, int i) {
    }
}

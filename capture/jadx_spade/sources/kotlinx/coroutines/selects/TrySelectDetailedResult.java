package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TrySelectDetailedResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TrySelectDetailedResult[] $VALUES;
    public static final TrySelectDetailedResult ALREADY_SELECTED;
    public static final TrySelectDetailedResult CANCELLED;
    public static final TrySelectDetailedResult REREGISTER;
    public static final TrySelectDetailedResult SUCCESSFUL;

    private static final /* synthetic */ TrySelectDetailedResult[] $values() {
        return new TrySelectDetailedResult[]{SUCCESSFUL, REREGISTER, CANCELLED, ALREADY_SELECTED};
    }

    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return $ENTRIES;
    }

    public static TrySelectDetailedResult valueOf(String str) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, str);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659357);
        SUCCESSFUL = new TrySelectDetailedResult("SUCCESSFUL", 0);
        REREGISTER = new TrySelectDetailedResult("REREGISTER", 1);
        CANCELLED = new TrySelectDetailedResult("CANCELLED", 2);
        ALREADY_SELECTED = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        TrySelectDetailedResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private TrySelectDetailedResult(String str, int i) {
    }
}

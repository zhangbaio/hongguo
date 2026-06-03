package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CopyActionResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CopyActionResult[] $VALUES;
    public static final CopyActionResult CONTINUE;
    public static final CopyActionResult SKIP_SUBTREE;
    public static final CopyActionResult TERMINATE;

    private static final /* synthetic */ CopyActionResult[] $values() {
        return new CopyActionResult[]{CONTINUE, SKIP_SUBTREE, TERMINATE};
    }

    public static EnumEntries<CopyActionResult> getEntries() {
        return $ENTRIES;
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(658410);
        CONTINUE = new CopyActionResult("CONTINUE", 0);
        SKIP_SUBTREE = new CopyActionResult("SKIP_SUBTREE", 1);
        TERMINATE = new CopyActionResult("TERMINATE", 2);
        CopyActionResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CopyActionResult valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    private CopyActionResult(String str, int i) {
    }
}

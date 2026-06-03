package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BufferOverflow {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BufferOverflow[] $VALUES;
    public static final BufferOverflow DROP_LATEST;
    public static final BufferOverflow DROP_OLDEST;
    public static final BufferOverflow SUSPEND;

    private static final /* synthetic */ BufferOverflow[] $values() {
        return new BufferOverflow[]{SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    public static EnumEntries<BufferOverflow> getEntries() {
        return $ENTRIES;
    }

    public static BufferOverflow valueOf(String str) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, str);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659066);
        SUSPEND = new BufferOverflow("SUSPEND", 0);
        DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
        DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);
        BufferOverflow[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BufferOverflow(String str, int i) {
    }
}

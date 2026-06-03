package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TickerMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TickerMode[] $VALUES;
    public static final TickerMode FIXED_DELAY;
    public static final TickerMode FIXED_PERIOD;

    private static final /* synthetic */ TickerMode[] $values() {
        return new TickerMode[]{FIXED_PERIOD, FIXED_DELAY};
    }

    public static EnumEntries<TickerMode> getEntries() {
        return $ENTRIES;
    }

    public static TickerMode valueOf(String str) {
        return (TickerMode) Enum.valueOf(TickerMode.class, str);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659103);
        FIXED_PERIOD = new TickerMode("FIXED_PERIOD", 0);
        FIXED_DELAY = new TickerMode("FIXED_DELAY", 1);
        TickerMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private TickerMode(String str, int i) {
    }
}

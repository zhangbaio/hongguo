package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AmPmMarker {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AmPmMarker[] $VALUES;
    public static final AmPmMarker AM;
    public static final AmPmMarker PM;

    private static final /* synthetic */ AmPmMarker[] $values() {
        return new AmPmMarker[]{AM, PM};
    }

    public static EnumEntries<AmPmMarker> getEntries() {
        return $ENTRIES;
    }

    public static AmPmMarker[] values() {
        return (AmPmMarker[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659445);
        AM = new AmPmMarker("AM", 0);
        PM = new AmPmMarker("PM", 1);
        AmPmMarker[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AmPmMarker valueOf(String str) {
        return (AmPmMarker) Enum.valueOf(AmPmMarker.class, str);
    }

    private AmPmMarker(String str, int i) {
    }
}

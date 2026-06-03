package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Padding {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Padding[] $VALUES;
    public static final Padding NONE;
    public static final Padding SPACE;
    public static final Padding ZERO;

    private static final /* synthetic */ Padding[] $values() {
        return new Padding[]{NONE, ZERO, SPACE};
    }

    public static EnumEntries<Padding> getEntries() {
        return $ENTRIES;
    }

    public static Padding[] values() {
        return (Padding[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659508);
        NONE = new Padding("NONE", 0);
        ZERO = new Padding("ZERO", 1);
        SPACE = new Padding("SPACE", 2);
        Padding[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Padding valueOf(String str) {
        return (Padding) Enum.valueOf(Padding.class, str);
    }

    private Padding(String str, int i) {
    }
}

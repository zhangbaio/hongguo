package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class WhenToOutput {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WhenToOutput[] $VALUES;
    public static final WhenToOutput ALWAYS;
    public static final WhenToOutput IF_NONZERO;
    public static final WhenToOutput NEVER;

    private static final /* synthetic */ WhenToOutput[] $values() {
        return new WhenToOutput[]{NEVER, IF_NONZERO, ALWAYS};
    }

    public static EnumEntries<WhenToOutput> getEntries() {
        return $ENTRIES;
    }

    public static WhenToOutput[] values() {
        return (WhenToOutput[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(659577);
        NEVER = new WhenToOutput("NEVER", 0);
        IF_NONZERO = new WhenToOutput("IF_NONZERO", 1);
        ALWAYS = new WhenToOutput("ALWAYS", 2);
        WhenToOutput[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static WhenToOutput valueOf(String str) {
        return (WhenToOutput) Enum.valueOf(WhenToOutput.class, str);
    }

    private WhenToOutput(String str, int i) {
    }
}

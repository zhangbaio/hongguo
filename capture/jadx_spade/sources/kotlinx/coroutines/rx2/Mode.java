package kotlinx.coroutines.rx2;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class Mode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Mode[] $VALUES;
    public static final Mode FIRST;
    public static final Mode FIRST_OR_DEFAULT;
    public static final Mode LAST;
    public static final Mode SINGLE;
    private final String s;

    private static final /* synthetic */ Mode[] $values() {
        return new Mode[]{FIRST, FIRST_OR_DEFAULT, LAST, SINGLE};
    }

    public static EnumEntries<Mode> getEntries() {
        return $ENTRIES;
    }

    public static Mode valueOf(String str) {
        return (Mode) Enum.valueOf(Mode.class, str);
    }

    public static Mode[] values() {
        return (Mode[]) $VALUES.clone();
    }

    public final String getS() {
        return this.s;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.s;
    }

    static {
        Covode.recordClassIndex(659298);
        FIRST = new Mode("FIRST", 0, "awaitFirst");
        FIRST_OR_DEFAULT = new Mode("FIRST_OR_DEFAULT", 1, "awaitFirstOrDefault");
        LAST = new Mode("LAST", 2, "awaitLast");
        SINGLE = new Mode("SINGLE", 3, "awaitSingle");
        Mode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Mode(String str, int i, String str2) {
        this.s = str2;
    }
}

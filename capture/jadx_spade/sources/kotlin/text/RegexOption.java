package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class RegexOption implements d {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;
    public static final RegexOption LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    @Override // kotlin.text.d
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.d
    public int getValue() {
        return this.value;
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(658774);
        int i = 0;
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, i, i2, defaultConstructorMarker);
        int i3 = 0;
        int i4 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, i3, i4, defaultConstructorMarker2);
        LITERAL = new RegexOption("LITERAL", 2, 16, i, i2, defaultConstructorMarker);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, i3, i4, defaultConstructorMarker2);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, i, i2, defaultConstructorMarker);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, i3, i4, defaultConstructorMarker2);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, i, i2, defaultConstructorMarker);
        RegexOption[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    private RegexOption(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }
}

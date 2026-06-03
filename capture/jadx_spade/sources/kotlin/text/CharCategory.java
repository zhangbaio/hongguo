package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CharCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CharCategory[] $VALUES;
    public static final CharCategory COMBINING_SPACING_MARK;
    public static final CharCategory CONNECTOR_PUNCTUATION;
    public static final CharCategory CONTROL;
    public static final CharCategory CURRENCY_SYMBOL;
    public static final a Companion;
    public static final CharCategory DASH_PUNCTUATION;
    public static final CharCategory DECIMAL_DIGIT_NUMBER;
    public static final CharCategory ENCLOSING_MARK;
    public static final CharCategory END_PUNCTUATION;
    public static final CharCategory FINAL_QUOTE_PUNCTUATION;
    public static final CharCategory FORMAT;
    public static final CharCategory INITIAL_QUOTE_PUNCTUATION;
    public static final CharCategory LETTER_NUMBER;
    public static final CharCategory LINE_SEPARATOR;
    public static final CharCategory LOWERCASE_LETTER;
    public static final CharCategory MATH_SYMBOL;
    public static final CharCategory MODIFIER_LETTER;
    public static final CharCategory MODIFIER_SYMBOL;
    public static final CharCategory NON_SPACING_MARK;
    public static final CharCategory OTHER_LETTER;
    public static final CharCategory OTHER_NUMBER;
    public static final CharCategory OTHER_PUNCTUATION;
    public static final CharCategory OTHER_SYMBOL;
    public static final CharCategory PARAGRAPH_SEPARATOR;
    public static final CharCategory PRIVATE_USE;
    public static final CharCategory SPACE_SEPARATOR;
    public static final CharCategory START_PUNCTUATION;
    public static final CharCategory SURROGATE;
    public static final CharCategory TITLECASE_LETTER;
    public static final CharCategory UNASSIGNED;
    public static final CharCategory UPPERCASE_LETTER;
    private final String code;
    private final int value;

    private static final /* synthetic */ CharCategory[] $values() {
        return new CharCategory[]{UNASSIGNED, UPPERCASE_LETTER, LOWERCASE_LETTER, TITLECASE_LETTER, MODIFIER_LETTER, OTHER_LETTER, NON_SPACING_MARK, ENCLOSING_MARK, COMBINING_SPACING_MARK, DECIMAL_DIGIT_NUMBER, LETTER_NUMBER, OTHER_NUMBER, SPACE_SEPARATOR, LINE_SEPARATOR, PARAGRAPH_SEPARATOR, CONTROL, FORMAT, PRIVATE_USE, SURROGATE, DASH_PUNCTUATION, START_PUNCTUATION, END_PUNCTUATION, CONNECTOR_PUNCTUATION, OTHER_PUNCTUATION, MATH_SYMBOL, CURRENCY_SYMBOL, MODIFIER_SYMBOL, OTHER_SYMBOL, INITIAL_QUOTE_PUNCTUATION, FINAL_QUOTE_PUNCTUATION};
    }

    public static EnumEntries<CharCategory> getEntries() {
        return $ENTRIES;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }

    public static CharCategory[] values() {
        return (CharCategory[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(658738);
        UNASSIGNED = new CharCategory("UNASSIGNED", 0, 0, "Cn");
        UPPERCASE_LETTER = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
        LOWERCASE_LETTER = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
        TITLECASE_LETTER = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
        MODIFIER_LETTER = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
        OTHER_LETTER = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
        NON_SPACING_MARK = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
        ENCLOSING_MARK = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
        COMBINING_SPACING_MARK = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
        DECIMAL_DIGIT_NUMBER = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
        LETTER_NUMBER = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
        OTHER_NUMBER = new CharCategory("OTHER_NUMBER", 11, 11, "No");
        SPACE_SEPARATOR = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
        LINE_SEPARATOR = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
        PARAGRAPH_SEPARATOR = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
        CONTROL = new CharCategory("CONTROL", 15, 15, "Cc");
        FORMAT = new CharCategory("FORMAT", 16, 16, "Cf");
        PRIVATE_USE = new CharCategory("PRIVATE_USE", 17, 18, "Co");
        SURROGATE = new CharCategory("SURROGATE", 18, 19, "Cs");
        DASH_PUNCTUATION = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
        START_PUNCTUATION = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
        END_PUNCTUATION = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
        CONNECTOR_PUNCTUATION = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
        OTHER_PUNCTUATION = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
        MATH_SYMBOL = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
        CURRENCY_SYMBOL = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
        MODIFIER_SYMBOL = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
        OTHER_SYMBOL = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
        INITIAL_QUOTE_PUNCTUATION = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
        FINAL_QUOTE_PUNCTUATION = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
        CharCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static CharCategory valueOf(String str) {
        return (CharCategory) Enum.valueOf(CharCategory.class, str);
    }

    public final boolean contains(char c) {
        if (Character.getType(c) == this.value) {
            return true;
        }
        return false;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658739);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CharCategory a(int i) {
            boolean z;
            boolean z2 = false;
            if (i >= 0 && i < 17) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return (CharCategory) CharCategory.getEntries().get(i);
            }
            if (18 <= i && i < 31) {
                z2 = true;
            }
            if (z2) {
                return (CharCategory) CharCategory.getEntries().get(i - 1);
            }
            throw new IllegalArgumentException("Category #" + i + " is not defined.");
        }
    }

    private CharCategory(String str, int i, int i2, String str2) {
        this.value = i2;
        this.code = str2;
    }
}

package kotlin.annotation;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AnnotationTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnnotationTarget[] $VALUES;
    public static final AnnotationTarget ANNOTATION_CLASS;
    public static final AnnotationTarget CLASS;
    public static final AnnotationTarget CONSTRUCTOR;
    public static final AnnotationTarget EXPRESSION;
    public static final AnnotationTarget FIELD;
    public static final AnnotationTarget FILE;
    public static final AnnotationTarget FUNCTION;
    public static final AnnotationTarget LOCAL_VARIABLE;
    public static final AnnotationTarget PROPERTY;
    public static final AnnotationTarget PROPERTY_GETTER;
    public static final AnnotationTarget PROPERTY_SETTER;
    public static final AnnotationTarget TYPE;
    public static final AnnotationTarget TYPEALIAS;
    public static final AnnotationTarget TYPE_PARAMETER;
    public static final AnnotationTarget VALUE_PARAMETER;

    private static final /* synthetic */ AnnotationTarget[] $values() {
        return new AnnotationTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS};
    }

    public static EnumEntries<AnnotationTarget> getEntries() {
        return $ENTRIES;
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(658147);
        CLASS = new AnnotationTarget("CLASS", 0);
        ANNOTATION_CLASS = new AnnotationTarget("ANNOTATION_CLASS", 1);
        TYPE_PARAMETER = new AnnotationTarget("TYPE_PARAMETER", 2);
        PROPERTY = new AnnotationTarget("PROPERTY", 3);
        FIELD = new AnnotationTarget("FIELD", 4);
        LOCAL_VARIABLE = new AnnotationTarget("LOCAL_VARIABLE", 5);
        VALUE_PARAMETER = new AnnotationTarget("VALUE_PARAMETER", 6);
        CONSTRUCTOR = new AnnotationTarget("CONSTRUCTOR", 7);
        FUNCTION = new AnnotationTarget("FUNCTION", 8);
        PROPERTY_GETTER = new AnnotationTarget("PROPERTY_GETTER", 9);
        PROPERTY_SETTER = new AnnotationTarget("PROPERTY_SETTER", 10);
        TYPE = new AnnotationTarget("TYPE", 11);
        EXPRESSION = new AnnotationTarget("EXPRESSION", 12);
        FILE = new AnnotationTarget("FILE", 13);
        TYPEALIAS = new AnnotationTarget("TYPEALIAS", 14);
        AnnotationTarget[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AnnotationTarget valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    private AnnotationTarget(String str, int i) {
    }
}

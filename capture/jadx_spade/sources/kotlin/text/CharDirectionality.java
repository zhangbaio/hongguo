package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CharDirectionality {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CharDirectionality[] $VALUES;
    public static final CharDirectionality ARABIC_NUMBER;
    public static final CharDirectionality BOUNDARY_NEUTRAL;
    public static final CharDirectionality COMMON_NUMBER_SEPARATOR;
    public static final a Companion;
    public static final CharDirectionality EUROPEAN_NUMBER;
    public static final CharDirectionality EUROPEAN_NUMBER_SEPARATOR;
    public static final CharDirectionality EUROPEAN_NUMBER_TERMINATOR;
    public static final CharDirectionality LEFT_TO_RIGHT;
    public static final CharDirectionality LEFT_TO_RIGHT_EMBEDDING;
    public static final CharDirectionality LEFT_TO_RIGHT_OVERRIDE;
    public static final CharDirectionality NONSPACING_MARK;
    public static final CharDirectionality OTHER_NEUTRALS;
    public static final CharDirectionality PARAGRAPH_SEPARATOR;
    public static final CharDirectionality POP_DIRECTIONAL_FORMAT;
    public static final CharDirectionality RIGHT_TO_LEFT;
    public static final CharDirectionality RIGHT_TO_LEFT_ARABIC;
    public static final CharDirectionality RIGHT_TO_LEFT_EMBEDDING;
    public static final CharDirectionality RIGHT_TO_LEFT_OVERRIDE;
    public static final CharDirectionality SEGMENT_SEPARATOR;
    public static final CharDirectionality UNDEFINED;
    public static final CharDirectionality WHITESPACE;
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    private final int value;

    private static final /* synthetic */ CharDirectionality[] $values() {
        return new CharDirectionality[]{UNDEFINED, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_LEFT_ARABIC, EUROPEAN_NUMBER, EUROPEAN_NUMBER_SEPARATOR, EUROPEAN_NUMBER_TERMINATOR, ARABIC_NUMBER, COMMON_NUMBER_SEPARATOR, NONSPACING_MARK, BOUNDARY_NEUTRAL, PARAGRAPH_SEPARATOR, SEGMENT_SEPARATOR, WHITESPACE, OTHER_NEUTRALS, LEFT_TO_RIGHT_EMBEDDING, LEFT_TO_RIGHT_OVERRIDE, RIGHT_TO_LEFT_EMBEDDING, RIGHT_TO_LEFT_OVERRIDE, POP_DIRECTIONAL_FORMAT};
    }

    public static EnumEntries<CharDirectionality> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658741);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<Integer, CharDirectionality> a() {
            return (Map) CharDirectionality.directionalityMap$delegate.getValue();
        }

        public final CharDirectionality b(int i) {
            CharDirectionality charDirectionality = a().get(Integer.valueOf(i));
            if (charDirectionality != null) {
                return charDirectionality;
            }
            throw new IllegalArgumentException("Directionality #" + i + " is not defined.");
        }
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map directionalityMap_delegate$lambda$1() {
        int mapCapacity;
        int coerceAtLeast;
        EnumEntries<CharDirectionality> entries = getEntries();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(entries, 10));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : entries) {
            linkedHashMap.put(Integer.valueOf(((CharDirectionality) obj).value), obj);
        }
        return linkedHashMap;
    }

    static {
        Lazy<Map<Integer, CharDirectionality>> lazy;
        Covode.recordClassIndex(658740);
        UNDEFINED = new CharDirectionality("UNDEFINED", 0, -1);
        LEFT_TO_RIGHT = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
        RIGHT_TO_LEFT = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
        RIGHT_TO_LEFT_ARABIC = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
        EUROPEAN_NUMBER = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
        EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
        EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
        ARABIC_NUMBER = new CharDirectionality("ARABIC_NUMBER", 7, 6);
        COMMON_NUMBER_SEPARATOR = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
        NONSPACING_MARK = new CharDirectionality("NONSPACING_MARK", 9, 8);
        BOUNDARY_NEUTRAL = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
        PARAGRAPH_SEPARATOR = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
        SEGMENT_SEPARATOR = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
        WHITESPACE = new CharDirectionality("WHITESPACE", 13, 12);
        OTHER_NEUTRALS = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
        LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
        LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
        RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
        RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
        POP_DIRECTIONAL_FORMAT = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
        CharDirectionality[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kotlin.text.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map directionalityMap_delegate$lambda$1;
                directionalityMap_delegate$lambda$1 = CharDirectionality.directionalityMap_delegate$lambda$1();
                return directionalityMap_delegate$lambda$1;
            }
        });
        directionalityMap$delegate = lazy;
    }

    public static CharDirectionality valueOf(String str) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, str);
    }

    private CharDirectionality(String str, int i, int i2) {
        this.value = i2;
    }
}

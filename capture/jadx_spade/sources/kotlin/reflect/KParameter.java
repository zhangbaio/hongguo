package kotlin.reflect;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface KParameter extends KAnnotatedElement {
    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Kind {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind EXTENSION_RECEIVER;
        public static final Kind INSTANCE;
        public static final Kind VALUE;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, EXTENSION_RECEIVER, VALUE};
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(658679);
            INSTANCE = new Kind("INSTANCE", 0);
            EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 1);
            VALUE = new Kind("VALUE", 2);
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        private Kind(String str, int i) {
        }
    }
}

package kotlinx.serialization.protobuf;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProtoIntegerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProtoIntegerType[] $VALUES;
    public static final ProtoIntegerType DEFAULT;
    public static final ProtoIntegerType FIXED;
    public static final ProtoIntegerType SIGNED;
    private final long signature;

    private static final /* synthetic */ ProtoIntegerType[] $values() {
        return new ProtoIntegerType[]{DEFAULT, SIGNED, FIXED};
    }

    public static EnumEntries<ProtoIntegerType> getEntries() {
        return $ENTRIES;
    }

    public final long getSignature$kotlinx_serialization_protobuf() {
        return this.signature;
    }

    public static ProtoIntegerType[] values() {
        return (ProtoIntegerType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(660108);
        DEFAULT = new ProtoIntegerType("DEFAULT", 0, 0L);
        SIGNED = new ProtoIntegerType("SIGNED", 1, 8589934592L);
        FIXED = new ProtoIntegerType("FIXED", 2, 17179869184L);
        ProtoIntegerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ProtoIntegerType valueOf(String str) {
        return (ProtoIntegerType) Enum.valueOf(ProtoIntegerType.class, str);
    }

    private ProtoIntegerType(String str, int i, long j) {
        this.signature = j;
    }
}

package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProtoWireType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProtoWireType[] $VALUES;
    public static final a Companion;
    public static final ProtoWireType INVALID;
    public static final ProtoWireType SIZE_DELIMITED;
    public static final ProtoWireType VARINT;
    public static final ProtoWireType i32;
    public static final ProtoWireType i64;
    private final int typeId;

    private static final /* synthetic */ ProtoWireType[] $values() {
        return new ProtoWireType[]{INVALID, VARINT, i64, SIZE_DELIMITED, i32};
    }

    public static EnumEntries<ProtoWireType> getEntries() {
        return $ENTRIES;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public static ProtoWireType[] values() {
        return (ProtoWireType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + '(' + this.typeId + ')';
    }

    static {
        Covode.recordClassIndex(660132);
        INVALID = new ProtoWireType("INVALID", 0, -1);
        VARINT = new ProtoWireType("VARINT", 1, 0);
        i64 = new ProtoWireType("i64", 2, 1);
        SIZE_DELIMITED = new ProtoWireType("SIZE_DELIMITED", 3, 2);
        i32 = new ProtoWireType("i32", 4, 5);
        ProtoWireType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public final int wireIntWithTag(int i) {
        return (i << 3) | this.typeId;
    }

    public static ProtoWireType valueOf(String str) {
        return (ProtoWireType) Enum.valueOf(ProtoWireType.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(660133);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProtoWireType a(int i) {
            Object obj;
            boolean z;
            Iterator<E> it2 = ProtoWireType.getEntries().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((ProtoWireType) obj).getTypeId() == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ProtoWireType protoWireType = (ProtoWireType) obj;
            if (protoWireType == null) {
                return ProtoWireType.INVALID;
            }
            return protoWireType;
        }
    }

    private ProtoWireType(String str, int i, int i2) {
        this.typeId = i2;
    }
}

package kotlin.reflect;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a implements GenericArrayType, Type {
    private final Type a;

    static {
        Covode.recordClassIndex(658657);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    public String toString() {
        return getTypeName();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String typeToString;
        StringBuilder sb = new StringBuilder();
        typeToString = TypesJVMKt.typeToString(this.a);
        sb.append(typeToString);
        sb.append("[]");
        return sb.toString();
    }

    public a(Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.a = elementType;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GenericArrayType) && Intrinsics.areEqual(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType())) {
            return true;
        }
        return false;
    }
}

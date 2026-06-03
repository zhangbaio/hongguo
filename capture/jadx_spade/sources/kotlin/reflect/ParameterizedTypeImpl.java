package kotlin.reflect;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ParameterizedTypeImpl implements ParameterizedType, Type {
    private final Class<?> a;
    private final Type b;
    private final Type[] c;

    static {
        Covode.recordClassIndex(658698);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.a;
    }

    public String toString() {
        return getTypeName();
    }

    public int hashCode() {
        int i;
        int hashCode = this.a.hashCode();
        Type type = this.b;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return (hashCode ^ i) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String typeToString;
        boolean z;
        String typeToString2;
        StringBuilder sb = new StringBuilder();
        Type type = this.b;
        if (type != null) {
            typeToString2 = TypesJVMKt.typeToString(type);
            sb.append(typeToString2);
            sb.append("$");
            sb.append(this.a.getSimpleName());
        } else {
            typeToString = TypesJVMKt.typeToString(this.a);
            sb.append(typeToString);
        }
        Type[] typeArr = this.c;
        if (typeArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ArraysKt.joinTo$default(typeArr, sb, (CharSequence) null, "<", ">", 0, (CharSequence) null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, (Object) null);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.areEqual(this.a, parameterizedType.getRawType()) && Intrinsics.areEqual(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    public ParameterizedTypeImpl(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.a = rawType;
        this.b = type;
        this.c = (Type[]) typeArguments.toArray(new Type[0]);
    }
}

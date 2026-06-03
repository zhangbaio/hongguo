package kotlin.reflect;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d implements WildcardType, Type {
    public static final a c;
    private static final d d;
    private final Type a;
    private final Type b;

    public static final class a {
        static {
            Covode.recordClassIndex(658705);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return d.d;
        }
    }

    public String toString() {
        return getTypeName();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.b;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    static {
        Covode.recordClassIndex(658704);
        c = new a(null);
        d = new d(null, null);
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String typeToString;
        String typeToString2;
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            typeToString2 = TypesJVMKt.typeToString(this.b);
            sb.append(typeToString2);
            return sb.toString();
        }
        Type type = this.a;
        if (type != null && !Intrinsics.areEqual(type, Object.class)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("? extends ");
            typeToString = TypesJVMKt.typeToString(this.a);
            sb2.append(typeToString);
            return sb2.toString();
        }
        return "?";
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    public d(Type type, Type type2) {
        this.a = type;
        this.b = type2;
    }
}

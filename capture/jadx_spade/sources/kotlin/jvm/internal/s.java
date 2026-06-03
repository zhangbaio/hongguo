package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s implements KTypeParameter {
    public static final a f;
    private final Object a;
    private final String b;
    private final KVariance c;
    private final boolean d;
    private volatile List<? extends KType> e;

    static {
        Covode.recordClassIndex(658570);
        f = new a(null);
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.b;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.c;
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return this.d;
    }

    public String toString() {
        return f.a(this);
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        List list = this.e;
        if (list == null) {
            List<KType> listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.nullableTypeOf(Object.class));
            this.e = listOf;
            return listOf;
        }
        return list;
    }

    public int hashCode() {
        int i;
        Object obj = this.a;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return (i * 31) + getName().hashCode();
    }

    public static final class a {

        /* renamed from: kotlin.jvm.internal.s$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0205a {
            public static final /* synthetic */ int[] a;

            static {
                Covode.recordClassIndex(658572);
                int[] iArr = new int[KVariance.values().length];
                try {
                    iArr[KVariance.INVARIANT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[KVariance.IN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[KVariance.OUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        static {
            Covode.recordClassIndex(658571);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C0205a.a[typeParameter.getVariance().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        sb.append("out ");
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    sb.append("in ");
                }
            } else {
                Unit unit = Unit.INSTANCE;
            }
            sb.append(typeParameter.getName());
            return sb.toString();
        }
    }

    public final void a(List<? extends KType> upperBounds) {
        Intrinsics.checkNotNullParameter(upperBounds, "upperBounds");
        if (this.e == null) {
            this.e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (Intrinsics.areEqual(this.a, sVar.a) && Intrinsics.areEqual(getName(), sVar.getName())) {
                return true;
            }
        }
        return false;
    }

    public s(Object obj, String name, KVariance variance, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.a = obj;
        this.b = name;
        this.c = variance;
        this.d = z;
    }
}

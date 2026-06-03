package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u implements KType {
    public static final a e;
    private final KClassifier a;
    private final List<KTypeProjection> b;
    public final KType c;
    public final int d;

    public static final class a {
        static {
            Covode.recordClassIndex(658574);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(658575);
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
        Covode.recordClassIndex(658573);
        e = new a(null);
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.a;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        if ((this.d & 1) != 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + this.d;
    }

    public String toString() {
        return d(false) + " (Kotlin reflection is not available)";
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (Intrinsics.areEqual(getClassifier(), uVar.getClassifier()) && Intrinsics.areEqual(getArguments(), uVar.getArguments()) && Intrinsics.areEqual(this.c, uVar.c) && this.d == uVar.d) {
                return true;
            }
        }
        return false;
    }

    private final String c(KTypeProjection kTypeProjection) {
        u uVar;
        String valueOf;
        int i;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        if (type instanceof u) {
            uVar = (u) type;
        } else {
            uVar = null;
        }
        if (uVar == null || (valueOf = uVar.d(true)) == null) {
            valueOf = String.valueOf(kTypeProjection.getType());
        }
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            i = -1;
        } else {
            i = b.a[variance.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "out " + valueOf;
                }
                throw new NoWhenBranchMatchedException();
            }
            return "in " + valueOf;
        }
        return valueOf;
    }

    private final String f(Class<?> cls) {
        if (Intrinsics.areEqual(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.areEqual(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.areEqual(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.areEqual(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.areEqual(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.areEqual(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.areEqual(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        if (Intrinsics.areEqual(cls, double[].class)) {
            return "kotlin.DoubleArray";
        }
        return "kotlin.Array";
    }

    private final String d(boolean z) {
        KClass kClass;
        String name;
        String joinToString$default;
        KClassifier classifier = getClassifier();
        Class<?> cls = null;
        if (classifier instanceof KClass) {
            kClass = (KClass) classifier;
        } else {
            kClass = null;
        }
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        if (cls == null) {
            name = getClassifier().toString();
        } else if ((this.d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            name = f(cls);
        } else if (z && cls.isPrimitive()) {
            KClassifier classifier2 = getClassifier();
            Intrinsics.checkNotNull(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.getJavaObjectType((KClass) classifier2).getName();
        } else {
            name = cls.getName();
        }
        String str = "";
        if (getArguments().isEmpty()) {
            joinToString$default = "";
        } else {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new Function1() { // from class: kotlin.jvm.internal.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence e2;
                    e2 = u.e(u.this, (KTypeProjection) obj);
                    return e2;
                }
            }, 24, null);
        }
        if (isMarkedNullable()) {
            str = "?";
        }
        String str2 = name + joinToString$default + str;
        KType kType = this.c;
        if (kType instanceof u) {
            String d = ((u) kType).d(true);
            if (!Intrinsics.areEqual(d, str2)) {
                if (Intrinsics.areEqual(d, str2 + '?')) {
                    return str2 + '!';
                }
                return '(' + str2 + ".." + d + ')';
            }
            return str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(u uVar, KTypeProjection it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return uVar.c(it2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(KClassifier classifier, List<KTypeProjection> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
    }

    public u(KClassifier classifier, List<KTypeProjection> arguments, KType kType, int i) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.a = classifier;
        this.b = arguments;
        this.c = kType;
        this.d = i;
    }
}

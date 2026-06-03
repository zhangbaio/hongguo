package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.format.e;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p1 extends kotlinx.datetime.format.a<zm6.o, h0> {
    public static final b b;
    private final kotlinx.datetime.internal.format.f<o1> a;

    static {
        Covode.recordClassIndex(659567);
        b = new b(null);
    }

    private static final class a implements kotlinx.datetime.format.b<o1, a>, e {
        private final kotlinx.datetime.internal.format.d<o1> a;

        static {
            Covode.recordClassIndex(659568);
        }

        @Override // kotlinx.datetime.format.b
        public kotlinx.datetime.internal.format.d<o1> f() {
            return this.a;
        }

        public kotlinx.datetime.internal.format.f<o1> B() {
            return b.a.c(this);
        }

        @Override // kotlinx.datetime.format.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.y.e
        public void A(Padding padding) {
            e.a.b(this, padding);
        }

        @Override // kotlinx.datetime.format.y.e
        public void h(Padding padding) {
            e.a.c(this, padding);
        }

        @Override // kotlinx.datetime.format.y.e
        public void n(Padding padding) {
            e.a.d(this, padding);
        }

        @Override // kotlinx.datetime.format.y
        public void q(String str) {
            b.a.d(this, str);
        }

        public a(kotlinx.datetime.internal.format.d<o1> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.e
        public void b(kotlinx.datetime.internal.format.n<? super o1> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            f().a(structure);
        }

        @Override // kotlinx.datetime.format.b
        public void s(String str, Function1<? super a, Unit> function1) {
            b.a.b(this, str, function1);
        }

        @Override // kotlinx.datetime.format.b
        public void t(Function1<? super a, Unit>[] function1Arr, Function1<? super a, Unit> function1) {
            b.a.a(this, function1Arr, function1);
        }
    }

    @Override // kotlinx.datetime.format.a
    public kotlinx.datetime.internal.format.f<h0> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public h0 c() {
        h0 h0Var;
        h0Var = l2.d;
        return h0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public p1(kotlinx.datetime.internal.format.f<? super o1> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.a = actualFormat;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public zm6.o e(h0 intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.e();
    }

    public static final class b {
        static {
            Covode.recordClassIndex(659569);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p1 a(Function1<? super y.e, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            a aVar = new a(new kotlinx.datetime.internal.format.d());
            block.invoke(aVar);
            return new p1(aVar.B());
        }
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h0 d(zm6.o value) {
        Intrinsics.checkNotNullParameter(value, "value");
        h0 h0Var = new h0(null, null, null, null, 15, null);
        h0Var.b(value);
        return h0Var;
    }
}

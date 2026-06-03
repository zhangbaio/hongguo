package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.format.c;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i0 extends kotlinx.datetime.format.a<kotlinx.datetime.c, e0> {
    public static final b b;
    private final kotlinx.datetime.internal.format.f<g> a;

    static {
        Covode.recordClassIndex(659488);
        b = new b(null);
    }

    public static final class a implements kotlinx.datetime.format.b<g, a>, c {
        private final kotlinx.datetime.internal.format.d<g> a;

        static {
            Covode.recordClassIndex(659489);
        }

        @Override // kotlinx.datetime.format.b
        public kotlinx.datetime.internal.format.d<g> f() {
            return this.a;
        }

        public kotlinx.datetime.internal.format.f<g> B() {
            return b.a.c(this);
        }

        @Override // kotlinx.datetime.format.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public a k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.y.a
        public void a(Padding padding) {
            c.a.e(this, padding);
        }

        @Override // kotlinx.datetime.format.y.a
        public void g(int i) {
            c.a.g(this, i);
        }

        @Override // kotlinx.datetime.format.y.a
        public void l(Padding padding) {
            c.a.f(this, padding);
        }

        @Override // kotlinx.datetime.format.y.a
        public void m(Padding padding) {
            c.a.b(this, padding);
        }

        @Override // kotlinx.datetime.format.y
        public void q(String str) {
            b.a.d(this, str);
        }

        public a(kotlinx.datetime.internal.format.d<g> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.c
        public void z(kotlinx.datetime.internal.format.n<? super g> structure) {
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
    public kotlinx.datetime.internal.format.f<e0> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e0 c() {
        e0 e0Var;
        e0Var = n0.c;
        return e0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i0(kotlinx.datetime.internal.format.f<? super g> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.a = actualFormat;
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public kotlinx.datetime.c e(e0 intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.d();
    }

    public static final class b {
        static {
            Covode.recordClassIndex(659490);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x<kotlinx.datetime.c> a(Function1<? super y.a, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            a aVar = new a(new kotlinx.datetime.internal.format.d());
            block.invoke(aVar);
            return new i0(aVar.B());
        }
    }

    @Override // kotlinx.datetime.format.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e0 d(kotlinx.datetime.c value) {
        Intrinsics.checkNotNullParameter(value, "value");
        e0 e0Var = new e0(null, null, null, null, 15, null);
        e0Var.c(value);
        return e0Var;
    }
}

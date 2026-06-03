package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ReducedIntFieldDirective<Target> implements k<Target> {
    private final m<Target, Integer> a;
    private final int b;
    private final int c;

    static {
        Covode.recordClassIndex(659617);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, Integer> c() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return kotlinx.datetime.internal.format.parser.t.b(this.b, this.c, this.a.b(), this.a.getName());
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        return new bn6.f(new ReducedIntFieldDirective$formatter$1(this.a.b()), this.b, this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntFieldDirective(m<? super Target, Integer> field, int i, int i2) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.a = field;
        this.b = i;
        this.c = i2;
    }
}

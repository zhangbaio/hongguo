package xi6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e implements a {
    public boolean a;
    private f b;
    private d c = new d(d.f.a());

    static {
        Covode.recordClassIndex(652777);
    }

    protected abstract void c(c cVar);

    protected abstract boolean d();

    public f e() {
        return this.b;
    }

    @Override // xi6.a
    public boolean isStarted() {
        return this.a;
    }

    @Override // xi6.a
    public final void start() {
        if (isStarted()) {
            return;
        }
        this.a = d();
    }

    @Override // xi6.a
    public void b(f fVar) {
        this.b = fVar;
    }

    public void f(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.c = dVar;
    }

    @Override // xi6.a
    public final void a(c input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!isStarted()) {
            return;
        }
        c(input);
    }

    protected final void g(d result) {
        Intrinsics.checkNotNullParameter(result, "result");
        f(result);
        f e = e();
        if (e != null) {
            e.a(result);
        }
    }
}

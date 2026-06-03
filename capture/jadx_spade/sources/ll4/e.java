package ll4;

import com.bytedance.covode.number.Covode;
import gk4.o0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends o0 {
    public static final int i;
    public final d h;

    static {
        Covode.recordClassIndex(608136);
        i = 8;
    }

    @Override // gk4.o0, bl4.a
    public String A() {
        return this.h.A();
    }

    @Override // gk4.o0, bl4.a
    public String C() {
        return this.h.C();
    }

    @Override // gk4.o0, bl4.a
    public String G() {
        return this.h.G();
    }

    @Override // gk4.o0, bl4.a
    public List<String> J() {
        return this.h.J();
    }

    @Override // gk4.o0, bl4.a
    public String y() {
        return this.h.y();
    }

    @Override // gk4.o0, bl4.a
    public String z() {
        return this.h.z();
    }

    @Override // gk4.o0, bl4.a
    public ym4.a w(int i2) {
        return this.h.w(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d model) {
        super(model.c, model.h.g, model.i, false, 8, null);
        Intrinsics.checkNotNullParameter(model, "model");
        this.h = model;
    }
}

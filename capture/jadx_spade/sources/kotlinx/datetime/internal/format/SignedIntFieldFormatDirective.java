package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class SignedIntFieldFormatDirective<Target> implements k<Target> {
    private final m<Target, Integer> a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Integer e;

    static {
        Covode.recordClassIndex(659619);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, Integer> c() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return kotlinx.datetime.internal.format.parser.t.c(this.b, this.c, this.d, this.a.b(), this.a.getName(), this.e);
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        int i;
        SignedIntFieldFormatDirective$formatter$formatter$1 signedIntFieldFormatDirective$formatter$formatter$1 = new SignedIntFieldFormatDirective$formatter$formatter$1(this.a.b());
        Integer num = this.b;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        bn6.h hVar = new bn6.h(signedIntFieldFormatDirective$formatter$formatter$1, i, this.e);
        if (this.d != null) {
            return new bn6.i(hVar, this.d.intValue());
        }
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SignedIntFieldFormatDirective(m<? super Target, Integer> field, Integer num, Integer num2, Integer num3, Integer num4) {
        boolean z;
        Intrinsics.checkNotNullParameter(field, "field");
        this.a = field;
        this.b = num;
        this.c = num2;
        this.d = num3;
        this.e = num4;
        if (num != null && num.intValue() < 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (num2 == null || num == null || num2.intValue() >= num.intValue()) {
                return;
            }
            throw new IllegalArgumentException(("The maximum number of digits (" + num2 + ") is less than the minimum number of digits (" + num + ')').toString());
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + num + ") is negative").toString());
    }
}

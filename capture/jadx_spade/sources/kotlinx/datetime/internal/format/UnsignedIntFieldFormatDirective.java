package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class UnsignedIntFieldFormatDirective<Target> implements k<Target> {
    public final x<Target> a;
    private final int b;
    private final Integer c;
    private final int d;

    static {
        Covode.recordClassIndex(659623);
    }

    @Override // kotlinx.datetime.internal.format.k
    public /* bridge */ /* synthetic */ m c() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return kotlinx.datetime.internal.format.parser.t.h(Integer.valueOf(this.b), Integer.valueOf(this.d), this.c, this.a.b(), this.a.getName(), false, 32, null);
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        bn6.k kVar = new bn6.k(new UnsignedIntFieldFormatDirective$formatter$formatter$1(this.a.b()), this.b);
        if (this.c != null) {
            return new bn6.i(kVar, this.c.intValue());
        }
        return kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnsignedIntFieldFormatDirective(x<? super Target> field, int i, Integer num) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(field, "field");
        this.a = field;
        this.b = i;
        this.c = num;
        int i2 = field.g;
        this.d = i2;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 >= i) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (num != null) {
                    if (!(num.intValue() > i)) {
                        throw new IllegalArgumentException(("The space padding (" + num + ") should be more than the minimum number of digits (" + i + ')').toString());
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("The maximum number of digits (" + i2 + ") is less than the minimum number of digits (" + i + ')').toString());
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + i + ") is negative").toString());
    }
}

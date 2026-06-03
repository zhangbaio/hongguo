package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y<Receiver> extends e<Receiver> {
    private final int c;
    private final a<Receiver, Integer> d;
    public final int e;
    private final int f;
    private final int g;
    private final int h;

    static {
        Covode.recordClassIndex(659660);
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public Integer b() {
        return Integer.valueOf(this.c);
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public g a(Receiver receiver, CharSequence input, int i, int i2) {
        int d;
        int i3;
        g f;
        Intrinsics.checkNotNullParameter(input, "input");
        d = f.d(input, i, i2);
        a<Receiver, Integer> aVar = this.d;
        if (d >= this.g) {
            i3 = this.h;
        } else {
            i3 = this.h + this.f;
        }
        f = f.f(aVar, receiver, Integer.valueOf(i3 + d));
        return f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y(int i, a<? super Receiver, Integer> setter, String name, int i2) {
        super(Integer.valueOf(i), name, null);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.c = i;
        this.d = setter;
        this.e = i2;
        int i3 = an6.d.b()[b().intValue()];
        this.f = i3;
        int i4 = i2 % i3;
        this.g = i4;
        this.h = i2 - i4;
        int intValue = b().intValue();
        boolean z = false;
        if (1 <= intValue && intValue < 10) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Invalid length for field " + this.b + ": " + b().intValue()).toString());
    }
}

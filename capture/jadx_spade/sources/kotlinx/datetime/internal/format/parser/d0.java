package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d0<Receiver> extends e<Receiver> {
    private final Integer c;
    private final Integer d;
    private final a<Receiver, Integer> e;
    private final boolean f;

    static {
        Covode.recordClassIndex(659665);
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public g a(Receiver receiver, CharSequence input, int i, int i2) {
        Integer e;
        g f;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer num = this.d;
        if (num != null && i2 - i > num.intValue()) {
            return new g.d(this.d.intValue());
        }
        Integer num2 = this.c;
        if (num2 == null || i2 - i >= num2.intValue()) {
            e = f.e(input, i, i2);
            if (e == null) {
                return g.b.a;
            }
            a<Receiver, Integer> aVar = this.e;
            boolean z = this.f;
            int intValue = e.intValue();
            if (z) {
                intValue = -intValue;
            }
            f = f.f(aVar, receiver, Integer.valueOf(intValue));
            return f;
        }
        return new g.c(this.c.intValue());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d0(java.lang.Integer r3, java.lang.Integer r4, kotlinx.datetime.internal.format.parser.a<? super Receiver, java.lang.Integer> r5, java.lang.String r6, boolean r7) {
        /*
            r2 = this;
            java.lang.String r0 = "setter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            r1 = 0
            if (r0 == 0) goto L13
            r0 = r3
            goto L14
        L13:
            r0 = r1
        L14:
            r2.<init>(r0, r6, r1)
            r2.c = r3
            r2.d = r4
            r2.e = r5
            r2.f = r7
            java.lang.Integer r3 = r2.b()
            r4 = 1
            if (r3 == 0) goto L3d
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            r5 = 9
            r3.<init>(r4, r5)
            java.lang.Integer r5 = r2.b()
            int r5 = r5.intValue()
            boolean r3 = r3.contains(r5)
            if (r3 == 0) goto L3c
            goto L3d
        L3c:
            r4 = 0
        L3d:
            if (r4 == 0) goto L40
            return
        L40:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid length for field "
            r3.append(r4)
            java.lang.String r4 = r2.b
            r3.append(r4)
            java.lang.String r4 = ": "
            r3.append(r4)
            java.lang.Integer r4 = r2.b()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.format.parser.d0.<init>(java.lang.Integer, java.lang.Integer, kotlinx.datetime.internal.format.parser.a, java.lang.String, boolean):void");
    }
}

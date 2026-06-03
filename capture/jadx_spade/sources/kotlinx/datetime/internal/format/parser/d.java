package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<Receiver> extends e<Receiver> {
    private final int c;
    private final int d;
    private final a<Receiver, an6.a> e;

    static {
        Covode.recordClassIndex(659639);
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public g a(Receiver receiver, CharSequence input, int i, int i2) {
        int d;
        g f;
        Intrinsics.checkNotNullParameter(input, "input");
        int i3 = i2 - i;
        if (i3 < this.c) {
            return new g.c(this.c);
        }
        if (i3 > this.d) {
            return new g.d(this.d);
        }
        a<Receiver, an6.a> aVar = this.e;
        d = f.d(input, i, i2);
        f = f.f(aVar, receiver, new an6.a(d, i3));
        return f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(int r4, int r5, kotlinx.datetime.internal.format.parser.a<? super Receiver, an6.a> r6, java.lang.String r7) {
        /*
            r3 = this;
            java.lang.String r0 = "setter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            if (r4 != r5) goto L12
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L13
        L12:
            r1 = r0
        L13:
            r3.<init>(r1, r7, r0)
            r3.c = r4
            r3.d = r5
            r3.e = r6
            r6 = 10
            r7 = 1
            r0 = 0
            if (r7 > r4) goto L26
            if (r4 >= r6) goto L26
            r1 = 1
            goto L27
        L26:
            r1 = 0
        L27:
            java.lang.String r2 = " for field "
            if (r1 == 0) goto L64
            if (r4 > r5) goto L30
            if (r5 >= r6) goto L30
            goto L31
        L30:
            r7 = 0
        L31:
            if (r7 == 0) goto L34
            return
        L34:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid maximum length "
            r6.append(r7)
            r6.append(r5)
            r6.append(r2)
            java.lang.String r5 = r3.b
            r6.append(r5)
            java.lang.String r5 = ": expected "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "..9"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L64:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Invalid minimum length "
            r5.append(r6)
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r3.b
            r5.append(r4)
            java.lang.String r4 = ": expected 1..9"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.format.parser.d.<init>(int, int, kotlinx.datetime.internal.format.parser.a, java.lang.String):void");
    }
}

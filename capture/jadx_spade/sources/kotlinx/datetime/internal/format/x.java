package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x<Target> extends a<Target, Integer> {
    private final b<Target, Integer> a;
    public final int b;
    public final int c;
    private final String d;
    public final Integer e;
    private final l<Target> f;
    public final int g;

    static {
        Covode.recordClassIndex(659622);
    }

    @Override // kotlinx.datetime.internal.format.m
    public /* bridge */ /* synthetic */ Object a() {
        return this.e;
    }

    @Override // kotlinx.datetime.internal.format.m
    public b<Target, Integer> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.m
    public String getName() {
        return this.d;
    }

    @Override // kotlinx.datetime.internal.format.m
    public l<Target> getSign() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(b<? super Target, Integer> accessor, int i, int i2, String name, Integer num, l<? super Target> lVar) {
        int i3;
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = accessor;
        this.b = i;
        this.c = i2;
        this.d = name;
        this.e = num;
        this.f = lVar;
        if (i2 < 10) {
            i3 = 1;
        } else if (i2 < 100) {
            i3 = 2;
        } else if (i2 < 1000) {
            i3 = 3;
        } else {
            throw new IllegalArgumentException("Max value " + i2 + " is too large");
        }
        this.g = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ x(kotlinx.datetime.internal.format.b r8, int r9, int r10, java.lang.String r11, java.lang.Integer r12, kotlinx.datetime.internal.format.l r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 8
            if (r15 == 0) goto L8
            java.lang.String r11 = r8.getName()
        L8:
            r4 = r11
            r11 = r14 & 16
            r15 = 0
            if (r11 == 0) goto L10
            r5 = r15
            goto L11
        L10:
            r5 = r12
        L11:
            r11 = r14 & 32
            if (r11 == 0) goto L17
            r6 = r15
            goto L18
        L17:
            r6 = r13
        L18:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.format.x.<init>(kotlinx.datetime.internal.format.b, int, int, java.lang.String, java.lang.Integer, kotlinx.datetime.internal.format.l, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

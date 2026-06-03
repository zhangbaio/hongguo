package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public static final a j;
    private static final t k;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final long f;
    public final androidx.compose.ui.text.font.c0 g;
    public final long h;
    public final long i;

    public /* synthetic */ t(float f, float f2, float f3, float f4, float f5, long j2, androidx.compose.ui.text.font.c0 c0Var, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, j2, c0Var, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return x0.i.i(this.a, tVar.a) && x0.i.i(this.b, tVar.b) && x0.i.i(this.c, tVar.c) && x0.i.i(this.d, tVar.d) && x0.i.i(this.e, tVar.e) && x0.w.e(this.f, tVar.f) && Intrinsics.areEqual(this.g, tVar.g) && androidx.compose.ui.graphics.l0.p(this.h, tVar.h) && androidx.compose.ui.graphics.l0.p(this.i, tVar.i);
    }

    public int hashCode() {
        return (((((((((((((((x0.i.k(this.a) * 31) + x0.i.k(this.b)) * 31) + x0.i.k(this.c)) * 31) + x0.i.k(this.d)) * 31) + x0.i.k(this.e)) * 31) + x0.w.i(this.f)) * 31) + this.g.hashCode()) * 31) + androidx.compose.ui.graphics.l0.v(this.h)) * 31) + androidx.compose.ui.graphics.l0.v(this.i);
    }

    public String toString() {
        return "CommonCoverTagStyle(outerHorizontalPadding=" + ((Object) x0.i.l(this.a)) + ", outerVerticalPadding=" + ((Object) x0.i.l(this.b)) + ", innerHorizontalPadding=" + ((Object) x0.i.l(this.c)) + ", innerVerticalPadding=" + ((Object) x0.i.l(this.d)) + ", cornerRadius=" + ((Object) x0.i.l(this.e)) + ", fontSize=" + ((Object) x0.w.k(this.f)) + ", fontWeight=" + this.g + ", defaultBackgroundColor=" + ((Object) androidx.compose.ui.graphics.l0.w(this.h)) + ", defaultTextColor=" + ((Object) androidx.compose.ui.graphics.l0.w(this.i)) + ')';
    }

    public static final class a {
        static {
            Covode.recordClassIndex(609637);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a() {
            return t.k;
        }
    }

    static {
        Covode.recordClassIndex(609636);
        j = new a(null);
        k = new t(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, 0L, 0L, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null);
    }

    private t(float f, float f2, float f3, float f4, float f5, long j2, androidx.compose.ui.text.font.c0 fontWeight, long j3, long j4) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = j2;
        this.g = fontWeight;
        this.h = j3;
        this.i = j4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ t(float r14, float r15, float r16, float r17, float r18, long r19, androidx.compose.ui.text.font.c0 r21, long r22, long r24, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 10
            if (r1 == 0) goto Le
            float r1 = (float) r2
            float r1 = x0.i.g(r1)
            goto Lf
        Le:
            r1 = r14
        Lf:
            r3 = r0 & 2
            if (r3 == 0) goto L19
            float r2 = (float) r2
            float r2 = x0.i.g(r2)
            goto L1a
        L19:
            r2 = r15
        L1a:
            r3 = r0 & 4
            r4 = 4
            if (r3 == 0) goto L25
            float r3 = (float) r4
            float r3 = x0.i.g(r3)
            goto L27
        L25:
            r3 = r16
        L27:
            r5 = r0 & 8
            if (r5 == 0) goto L32
            r5 = 3
            float r5 = (float) r5
            float r5 = x0.i.g(r5)
            goto L34
        L32:
            r5 = r17
        L34:
            r6 = r0 & 16
            if (r6 == 0) goto L3e
            float r4 = (float) r4
            float r4 = x0.i.g(r4)
            goto L40
        L3e:
            r4 = r18
        L40:
            r6 = r0 & 32
            if (r6 == 0) goto L4b
            r6 = 9
            long r6 = x0.x.h(r6)
            goto L4d
        L4b:
            r6 = r19
        L4d:
            r8 = r0 & 64
            if (r8 == 0) goto L58
            androidx.compose.ui.text.font.c0$a r8 = androidx.compose.ui.text.font.c0.b
            androidx.compose.ui.text.font.c0 r8 = r8.i()
            goto L5a
        L58:
            r8 = r21
        L5a:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L65
            qg4.l r9 = qg4.l.a
            long r9 = r9.h()
            goto L67
        L65:
            r9 = r22
        L67:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L72
            androidx.compose.ui.graphics.l0$a r0 = androidx.compose.ui.graphics.l0.b
            long r11 = r0.i()
            goto L74
        L72:
            r11 = r24
        L74:
            r0 = 0
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r4
            r20 = r6
            r22 = r8
            r23 = r9
            r25 = r11
            r27 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r22, r23, r25, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.t.<init>(float, float, float, float, float, long, androidx.compose.ui.text.font.c0, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

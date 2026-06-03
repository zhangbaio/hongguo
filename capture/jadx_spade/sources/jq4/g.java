package jq4;

import androidx.compose.animation.m;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.h;
import w0.i;
import w0.s;
import x0.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int p = 0;
    public final Modifier a;
    public final long b;
    public final long c;
    public final y d;
    public final c0 e;
    public final j f;
    public final long g;
    public final i h;
    public final h i;
    public final long j;
    public final int k;
    public final boolean l;
    public final int m;
    public final int n;
    public final g3 o;

    static {
        Covode.recordClassIndex(609700);
    }

    public /* synthetic */ g(Modifier modifier, long j, long j2, y yVar, c0 c0Var, j jVar, long j3, i iVar, h hVar, long j4, int i, boolean z, int i2, int i3, g3 g3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(modifier, j, j2, yVar, c0Var, jVar, j3, iVar, hVar, j4, i, z, i2, i3, g3Var);
    }

    public final g a(Modifier modifier, long j, long j2, y yVar, c0 c0Var, j jVar, long j3, i iVar, h hVar, long j4, int i, boolean z, int i2, int i3, g3 g3Var) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return new g(modifier, j, j2, yVar, c0Var, jVar, j3, iVar, hVar, j4, i, z, i2, i3, g3Var, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && l0.p(this.b, gVar.b) && w.e(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e) && Intrinsics.areEqual(this.f, gVar.f) && w.e(this.g, gVar.g) && Intrinsics.areEqual(this.h, gVar.h) && Intrinsics.areEqual(this.i, gVar.i) && w.e(this.j, gVar.j) && s.i(this.k, gVar.k) && this.l == gVar.l && this.m == gVar.m && this.n == gVar.n && Intrinsics.areEqual(this.o, gVar.o);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + l0.v(this.b)) * 31) + w.i(this.c)) * 31;
        y yVar = this.d;
        int g = (hashCode + (yVar == null ? 0 : y.g(yVar.i()))) * 31;
        c0 c0Var = this.e;
        int hashCode2 = (g + (c0Var == null ? 0 : c0Var.hashCode())) * 31;
        j jVar = this.f;
        int hashCode3 = (((hashCode2 + (jVar == null ? 0 : jVar.hashCode())) * 31) + w.i(this.g)) * 31;
        i iVar = this.h;
        int hashCode4 = (hashCode3 + (iVar == null ? 0 : iVar.hashCode())) * 31;
        h hVar = this.i;
        int l = (((((((((((hashCode4 + (hVar == null ? 0 : h.l(hVar.n()))) * 31) + w.i(this.j)) * 31) + s.j(this.k)) * 31) + m.a(this.l)) * 31) + this.m) * 31) + this.n) * 31;
        g3 g3Var = this.o;
        return l + (g3Var != null ? g3Var.hashCode() : 0);
    }

    public String toString() {
        return "TextUiParams(modifier=" + this.a + ", color=" + ((Object) l0.w(this.b)) + ", fontSize=" + ((Object) w.k(this.c)) + ", fontStyle=" + this.d + ", fontWeight=" + this.e + ", fontFamily=" + this.f + ", letterSpacing=" + ((Object) w.k(this.g)) + ", textDecoration=" + this.h + ", textAlign=" + this.i + ", lineHeight=" + ((Object) w.k(this.j)) + ", overflow=" + ((Object) s.k(this.k)) + ", softWrap=" + this.l + ", maxLines=" + this.m + ", minLines=" + this.n + ", style=" + this.o + ')';
    }

    private g(Modifier modifier, long j, long j2, y yVar, c0 c0Var, j jVar, long j3, i iVar, h hVar, long j4, int i, boolean z, int i2, int i3, g3 g3Var) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.a = modifier;
        this.b = j;
        this.c = j2;
        this.d = yVar;
        this.e = c0Var;
        this.f = jVar;
        this.g = j3;
        this.h = iVar;
        this.i = hVar;
        this.j = j4;
        this.k = i;
        this.l = z;
        this.m = i2;
        this.n = i3;
        this.o = g3Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ g(androidx.compose.ui.Modifier r21, long r22, long r24, androidx.compose.ui.text.font.y r26, androidx.compose.ui.text.font.c0 r27, androidx.compose.ui.text.font.j r28, long r29, w0.i r31, w0.h r32, long r33, int r35, boolean r36, int r37, int r38, androidx.compose.ui.text.g3 r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jq4.g.<init>(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.y, androidx.compose.ui.text.font.c0, androidx.compose.ui.text.font.j, long, w0.i, w0.h, long, int, boolean, int, int, androidx.compose.ui.text.g3, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

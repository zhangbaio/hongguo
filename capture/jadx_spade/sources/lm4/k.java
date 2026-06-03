package lm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public static final int m;
    private final com.dragon.read.kmp.i a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;

    static {
        Covode.recordClassIndex(608487);
        m = 8;
    }

    public k() {
        this.a = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("BDReaderProperties"));
        this.b = "";
        this.c = 2;
        this.d = 2;
        this.e = 1;
        this.f = pn4.a.a(24);
        this.g = pn4.a.a(27);
        this.h = 3;
        this.i = 3;
        this.k = true;
        this.l = true;
    }

    public final k b() {
        k kVar = new k();
        kVar.b = this.b;
        kVar.c = this.c;
        kVar.d = this.d;
        kVar.e = this.e;
        kVar.f = this.f;
        kVar.g = this.g;
        kVar.h = this.h;
        kVar.i = this.i;
        kVar.j = this.j;
        kVar.k = this.k;
        kVar.l = this.l;
        return kVar;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void a(cm4.i reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        j g = reader.f().g();
        i f = reader.f().f();
        d b = reader.f().b();
        g e = reader.f().e();
        f c = reader.f().c();
        c a = reader.f().a();
        int c2 = e.c();
        int d = c.d();
        int g2 = b.g();
        int g3 = g.g();
        String c3 = b.c();
        int e2 = a.e();
        boolean t = f.t();
        boolean q = f.q();
        if (this.d != c2 || this.e != d || this.f != g2 || this.c != g3 || !Intrinsics.areEqual(this.b, c3) || this.j != e2 || this.k != t || this.l != q) {
            this.a.d("change with pageTurnMode,old = " + this.d + ",new = " + c2);
            this.a.d("change with spacingMode,old = " + this.e + ",new = " + d);
            this.a.d("change with textSize,old = " + this.f + ",new = " + g2);
            this.a.d("change with theme,old = " + this.c + ",new = " + g3);
            this.a.d("change with font,old = " + this.b + ",new = " + c3);
            this.a.d("change with readerBgType,old = " + this.j + ",new = " + e2);
            this.a.d("change with content pic show switch,old = " + this.k + ",new = " + t);
            this.a.d("change with eyeProtection,old = " + this.l + ",new = " + q);
            reader.f().update(reader);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(String fontName, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2) {
        this();
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        this.b = fontName;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.i = i7;
        this.j = i8;
        this.k = z;
        this.l = z2;
    }
}

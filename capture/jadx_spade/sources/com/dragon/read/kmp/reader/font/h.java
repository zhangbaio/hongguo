package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public String a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public String t;

    static {
        Covode.recordClassIndex(608429);
    }

    public h() {
        this.a = "";
        this.b = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = "";
        this.t = "";
    }

    public final lr4.r0 n() {
        lr4.r0 r0Var = new lr4.r0();
        r0Var.b = this.a;
        r0Var.h = this.b;
        r0Var.a = this.c;
        r0Var.c = this.d;
        r0Var.d = this.e;
        r0Var.e = this.f;
        r0Var.f = this.g;
        r0Var.g = this.h;
        r0Var.i = this.i;
        r0Var.j = this.j;
        r0Var.k = this.k;
        r0Var.l = this.l;
        r0Var.m = this.m;
        r0Var.n = this.n;
        r0Var.o = this.o;
        r0Var.p = this.p;
        r0Var.q = this.q;
        r0Var.r = this.r;
        r0Var.s = this.s;
        r0Var.t = this.t;
        return r0Var;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.p = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.s = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.o = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.q = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.t = str;
    }

    public h(lr4.r0 config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.a = "";
        this.b = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = "";
        this.t = "";
        String str = config.b;
        this.a = str == null ? "" : str;
        String str2 = config.h;
        this.b = str2 == null ? "" : str2;
        this.c = config.a;
        String str3 = config.c;
        this.d = str3 == null ? "" : str3;
        String str4 = config.d;
        this.e = str4 == null ? "" : str4;
        String str5 = config.e;
        this.f = str5 == null ? "" : str5;
        String str6 = config.f;
        this.g = str6 == null ? "" : str6;
        String str7 = config.g;
        this.h = str7 == null ? "" : str7;
        String str8 = config.i;
        this.i = str8 == null ? "" : str8;
        this.j = config.j;
        this.k = config.k;
        this.l = config.l;
        this.m = config.m;
        this.n = config.n;
        String str9 = config.o;
        this.o = str9 == null ? "" : str9;
        String str10 = config.p;
        this.p = str10 == null ? "" : str10;
        String str11 = config.q;
        this.q = str11 == null ? "" : str11;
        this.r = config.r;
        String str12 = config.s;
        this.s = str12 == null ? "" : str12;
        String str13 = config.t;
        this.t = str13 != null ? str13 : "";
    }
}

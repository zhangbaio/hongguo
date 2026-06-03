package com.dragon.read.kmp.service;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g1 {
    public static final int q;
    public String a;
    public boolean b;
    public boolean c;
    public h d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Context h;
    public boolean i;
    public boolean j;
    public String k;
    public float l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Function1<? super Boolean, Unit> p;

    static {
        Covode.recordClassIndex(608897);
        q = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.k = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public g1(boolean z, boolean z2, h hVar, boolean z3) {
        this.a = "";
        this.f = true;
        this.i = true;
        this.k = "#00000000";
        this.l = 12.0f;
        this.o = true;
        this.b = z;
        this.c = z2;
        this.d = hVar;
        this.e = z3;
    }

    public /* synthetic */ g1(boolean z, boolean z2, h hVar, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? null : hVar, (i & 8) != 0 ? false : z3);
    }
}

package com.dragon.read.kmp.story.impl.feeds.progress;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lr4.c1;
import wf4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609341);
    }

    public static final a c(c1 c1Var) {
        Intrinsics.checkNotNullParameter(c1Var, "<this>");
        return new a(c1Var.b, rj4.a.a(c1Var), c1Var.c, c1Var.d, c1Var.e, c1Var.f, c1Var.j, c1Var.k, c1Var.l, c1Var.m, c1Var.n, c1Var.o);
    }

    public static final c1 b(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        c1 c1Var = new c1();
        c1Var.i(aVar.a);
        rj4.a.b(c1Var, aVar.b);
        c1Var.l(aVar.c);
        c1Var.d = aVar.d;
        c1Var.p(aVar.e);
        c1Var.f = aVar.f;
        c1Var.k = aVar.h;
        c1Var.l = aVar.i;
        c1Var.j = aVar.g;
        c1Var.m = aVar.j;
        c1Var.n = aVar.k;
        c1Var.o = aVar.l;
        c1Var.i = e.a.a();
        return c1Var;
    }

    public static final Float a(kp4.b bVar, gp4.b anchorPage, float f) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(anchorPage, "anchorPage");
        List<np4.e> i = bVar.i();
        Iterator<T> it2 = i.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            i3 += ((np4.e) it2.next()).i();
        }
        if (i3 == 0) {
            return null;
        }
        Iterator it4 = CollectionsKt___CollectionsKt.take(i, anchorPage.b()).iterator();
        while (it4.hasNext()) {
            i2 += ((np4.e) it4.next()).i();
        }
        return Float.valueOf((i2 + f) / i3);
    }
}

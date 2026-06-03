package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lr4.q1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n implements m {
    public static final int b;
    public final m a;

    static {
        Covode.recordClassIndex(611533);
        b = 8;
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> j() {
        List<q1> j = this.a.j();
        Intrinsics.checkNotNullExpressionValue(j, "queryAllDeletedUnderlines(...)");
        return j;
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> k() {
        List<q1> k = this.a.k();
        Intrinsics.checkNotNullExpressionValue(k, "queryAllUnderlines(...)");
        return k;
    }

    @Override // com.dragon.read.local.db.m
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.dragon.read.local.db.m
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // com.dragon.read.local.db.m
    public int d(String str) {
        return this.a.d(str);
    }

    @Override // com.dragon.read.local.db.m
    public void g(String str) {
        this.a.g(str);
    }

    public n(m iUnderlineRemoteDao) {
        Intrinsics.checkNotNullParameter(iUnderlineRemoteDao, "iUnderlineRemoteDao");
        this.a = iUnderlineRemoteDao;
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> h(String str) {
        List<q1> h = this.a.h(str);
        Intrinsics.checkNotNullExpressionValue(h, "queryDeletedUnderlines(...)");
        return h;
    }

    @Override // com.dragon.read.local.db.m
    public List<q1> i(String str) {
        List<q1> i = this.a.i(str);
        Intrinsics.checkNotNullExpressionValue(i, "queryUnderlines(...)");
        return i;
    }

    @Override // com.dragon.read.local.db.m
    public void c(List<q1> list) {
        Iterator it2 = e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // com.dragon.read.local.db.m
    public void f(List<q1> list) {
        Iterator it2 = e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.f((List) it2.next());
        }
    }

    @Override // com.dragon.read.local.db.m
    public List<Long> e(List<q1> list) {
        List a = e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            List<Long> e = this.a.e((List) it2.next());
            Intrinsics.checkNotNullExpressionValue(e, "insertOrReplaceUnderlines(...)");
            arrayList.addAll(e);
        }
        return arrayList;
    }
}

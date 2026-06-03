package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lr4.o1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements j {
    public static final int b;
    public final j a;

    static {
        Covode.recordClassIndex(611530);
        b = 8;
    }

    @Override // com.dragon.read.local.db.j
    public List<o1> g() {
        List<o1> g = this.a.g();
        Intrinsics.checkNotNullExpressionValue(g, "queryAllUnderlineCacheData(...)");
        return g;
    }

    @Override // com.dragon.read.local.db.j
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.dragon.read.local.db.j
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // com.dragon.read.local.db.j
    public int d(String str) {
        return this.a.d(str);
    }

    public k(j iUnderlineLocalDao) {
        Intrinsics.checkNotNullParameter(iUnderlineLocalDao, "iUnderlineLocalDao");
        this.a = iUnderlineLocalDao;
    }

    @Override // com.dragon.read.local.db.j
    public List<o1> e(String str) {
        List<o1> e = this.a.e(str);
        Intrinsics.checkNotNullExpressionValue(e, "queryUnderlineCacheData(...)");
        return e;
    }

    @Override // com.dragon.read.local.db.j
    public void c(List<o1> list) {
        Iterator it2 = e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // com.dragon.read.local.db.j
    public List<Long> f(List<o1> list) {
        List a = e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            List<Long> f = this.a.f((List) it2.next());
            Intrinsics.checkNotNullExpressionValue(f, "insertOrReplaceUnderlineCache(...)");
            arrayList.addAll(f);
        }
        return arrayList;
    }
}

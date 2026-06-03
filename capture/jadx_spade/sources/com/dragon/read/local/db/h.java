package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lr4.i0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h implements g {
    private final g a;

    static {
        Covode.recordClassIndex(611527);
    }

    @Override // com.dragon.read.local.db.g
    public List<i0> g() {
        return this.a.g();
    }

    public h(g gVar) {
        this.a = gVar;
    }

    @Override // com.dragon.read.local.db.g
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.dragon.read.local.db.g
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // com.dragon.read.local.db.g
    public int d(String str) {
        return this.a.d(str);
    }

    @Override // com.dragon.read.local.db.g
    public List<i0> e(String str) {
        return this.a.e(str);
    }

    @Override // com.dragon.read.local.db.g
    public void c(List<i0> list) {
        Iterator it2 = e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // com.dragon.read.local.db.g
    public List<Long> f(List<i0> list) {
        List a = e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.f((List) it2.next()));
        }
        return arrayList;
    }
}

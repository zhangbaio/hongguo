package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    private final ArrayList<IRunDelegate> a;
    private final ArrayList<g> b;
    private final ArrayList<e> c;
    private final Map<Object, Integer> d;

    static {
        Covode.recordClassIndex(654797);
    }

    public j() {
        ArrayList<IRunDelegate> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(null);
        ArrayList<g> arrayList2 = new ArrayList<>();
        this.b = arrayList2;
        arrayList2.add(null);
        ArrayList<e> arrayList3 = new ArrayList<>();
        this.c = arrayList3;
        arrayList3.add(null);
        this.d = new Hashtable();
    }

    public int d(k kVar) {
        if (kVar == null) {
            return 0;
        }
        return JavaFontManager.GetInstance().RegisterFont(kVar);
    }

    private int e(Object obj) {
        Integer num;
        if (obj == null || (num = this.d.get(obj)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public e f(int i) {
        if (i >= 0 && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    public g g(int i) {
        if (i >= 0 && i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    public IRunDelegate h(int i) {
        if (i >= 0 && i < this.a.size()) {
            return this.a.get(i);
        }
        return null;
    }

    public int a(e eVar) {
        if (eVar == null) {
            return 0;
        }
        int e = e(eVar);
        if (e != -1) {
            return e;
        }
        this.c.add(eVar);
        int size = this.c.size() - 1;
        this.d.put(eVar, Integer.valueOf(size));
        return size;
    }

    public int b(g gVar) {
        if (gVar == null) {
            return 0;
        }
        int e = e(gVar);
        if (e != -1) {
            return e;
        }
        this.b.add(gVar);
        int size = this.b.size() - 1;
        this.d.put(gVar, Integer.valueOf(size));
        return size;
    }

    public int c(IRunDelegate iRunDelegate) {
        if (iRunDelegate == null) {
            return 0;
        }
        int e = e(iRunDelegate);
        if (e != -1) {
            return e;
        }
        this.a.add(iRunDelegate);
        int size = this.a.size() - 1;
        this.d.put(iRunDelegate, Integer.valueOf(size));
        return size;
    }
}

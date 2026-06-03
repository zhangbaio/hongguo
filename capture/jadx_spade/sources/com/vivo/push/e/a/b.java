package com.vivo.push.e.a;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<b> a;
    private String b;
    private List<com.vivo.push.e.b> c;
    private int d;

    static {
        Covode.recordClassIndex(655025);
        a = new c();
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.e.b> it2 = this.c.iterator();
        while (it2.hasNext()) {
            String b = it2.next().b();
            if (!TextUtils.isEmpty(b)) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
        aVar.a(this.d);
        aVar.a(this.c);
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.c = new ArrayList();
        this.b = aVar.c();
        this.d = aVar.a();
        aVar.a(com.vivo.push.e.b.a, this.c);
    }

    public b(String str, List<com.vivo.push.e.b> list, int i) {
        new ArrayList();
        this.b = str;
        this.d = i;
        this.c = list;
    }
}

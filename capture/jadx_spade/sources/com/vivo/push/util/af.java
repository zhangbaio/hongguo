package com.vivo.push.util;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class af implements e {
    private static final HashMap<String, Integer> a;
    private static final HashMap<String, Long> b;
    private static final HashMap<String, String> c;
    private static af d;
    private Context e;
    private e f;
    private boolean g;

    static {
        Covode.recordClassIndex(655182);
        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();
    }

    public final void a() {
        ae aeVar = new ae();
        if (!aeVar.a(this.e)) {
            return;
        }
        aeVar.a();
        t.d("SystemCache", "sp cache is cleared");
    }

    public static synchronized af b(Context context) {
        af afVar;
        synchronized (af.class) {
            if (d == null) {
                d = new af(context.getApplicationContext());
            }
            afVar = d;
        }
        return afVar;
    }

    private af(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        t.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        ac acVar = new ac();
        this.f = acVar;
        boolean a2 = acVar.a(context);
        if (!a2) {
            ae aeVar = new ae();
            this.f = aeVar;
            a2 = aeVar.a(context);
        }
        if (!a2) {
            this.f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = c.get(str);
        if (str3 == null && (eVar = this.f) != null) {
            return eVar.a(str, str2);
        }
        return str3;
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class p {
    private static volatile p a;

    /* renamed from: a, reason: collision with other field name */
    private Context f62a;

    /* renamed from: a, reason: collision with other field name */
    private List<n> f63a = new ArrayList();

    static {
        Covode.recordClassIndex(655316);
        a = null;
    }

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f62a = applicationContext;
        if (applicationContext == null) {
            this.f62a = context;
        }
    }

    public static p a(Context context) {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p(context);
                }
            }
        }
        return a;
    }

    public void c(String str) {
        synchronized (this.f63a) {
            n nVar = new n();
            nVar.f60a = str;
            if (this.f63a.contains(nVar)) {
                this.f63a.remove(nVar);
            }
        }
    }

    public int a(String str) {
        synchronized (this.f63a) {
            n nVar = new n();
            nVar.f60a = str;
            if (this.f63a.contains(nVar)) {
                for (n nVar2 : this.f63a) {
                    if (nVar2.equals(nVar)) {
                        return nVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public void b(String str) {
        synchronized (this.f63a) {
            n nVar = new n();
            nVar.f60a = str;
            if (this.f63a.contains(nVar)) {
                Iterator<n> it2 = this.f63a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    n next = it2.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.a++;
            this.f63a.remove(nVar);
            this.f63a.add(nVar);
        }
    }

    public synchronized String a(v vVar) {
        return this.f62a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m108a(String str) {
        synchronized (this.f63a) {
            n nVar = new n();
            nVar.a = 0;
            nVar.f60a = str;
            if (this.f63a.contains(nVar)) {
                this.f63a.remove(nVar);
            }
            this.f63a.add(nVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m109a(String str) {
        synchronized (this.f63a) {
            n nVar = new n();
            nVar.f60a = str;
            if (this.f63a.contains(nVar)) {
                return true;
            }
            return false;
        }
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f62a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}

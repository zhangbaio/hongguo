package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ah {
    private static volatile ah a;

    /* renamed from: a, reason: collision with other field name */
    protected SharedPreferences f920a;

    /* renamed from: a, reason: collision with other field name */
    private HashSet<a> f921a = new HashSet<>();
    protected SharedPreferences b;

    static {
        Covode.recordClassIndex(655669);
    }

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        static {
            Covode.recordClassIndex(655670);
        }

        protected abstract void onCallback();

        public int hashCode() {
            return this.mId;
        }

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || this.mId != ((a) obj).mId) {
                return false;
            }
            return true;
        }

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }
    }

    public synchronized void a(a aVar) {
        if (!this.f921a.contains(aVar)) {
            this.f921a.add(aVar);
        }
    }

    public void a(List<Pair<gk, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.y.a(list) || com.xiaomi.push.y.a(list2)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f920a.edit();
        edit.clear();
        for (Pair<gk, Integer> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                edit.putInt(a((gk) obj), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            Object obj2 = pair2.first;
            if (obj2 != null && pair2.second != null) {
                a(edit, pair2, a(((Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.y.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String a2 = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(a2);
                } else {
                    a(edit, pair, a2);
                }
            }
        }
        edit.apply();
    }

    public String a(int i, String str) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getString(a2, null);
            }
            return this.f920a.contains(a2) ? this.f920a.getString(a2, null) : str;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(i + " oc string error " + e);
            return str;
        }
    }

    public boolean a(int i, boolean z) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getBoolean(a2, false);
            }
            return this.f920a.contains(a2) ? this.f920a.getBoolean(a2, false) : z;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(i + " oc boolean error " + e);
            return z;
        }
    }

    public synchronized void a() {
        this.f921a.clear();
    }

    void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f921a);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    private ah(Context context) {
        this.f920a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static ah a(Context context) {
        if (a == null) {
            synchronized (ah.class) {
                if (a == null) {
                    a = new ah(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return "oc_" + i;
    }

    private String a(gk gkVar) {
        return "oc_version_" + gkVar.a();
    }

    public int a(int i, int i2) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getInt(a2, 0);
            }
            if (this.f920a.contains(a2)) {
                return this.f920a.getInt(a2, 0);
            }
            return i2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(i + " oc int error " + e);
            return i2;
        }
    }

    public int a(gk gkVar, int i) {
        try {
            return this.f920a.getInt(a(gkVar), i);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(gkVar + " version error " + e);
            return i;
        }
    }

    public long a(int i, long j) {
        try {
            String a2 = a(i);
            if (this.b.contains(a2)) {
                return this.b.getLong(a2, 0L);
            }
            if (this.f920a.contains(a2)) {
                return this.f920a.getLong(a2, 0L);
            }
            return j;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a(i + " oc long error " + e);
            return j;
        }
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(a(gj.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.ax.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }
}

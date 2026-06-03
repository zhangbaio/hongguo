package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static volatile b a;

    /* renamed from: a, reason: collision with other field name */
    private Context f41a;

    /* renamed from: a, reason: collision with other field name */
    private a f42a;

    /* renamed from: a, reason: collision with other field name */
    String f43a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, a> f44a;

    static {
        Covode.recordClassIndex(655298);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m83a() {
        Context context = this.f41a;
        return !TextUtils.equals(com.xiaomi.push.g.m456a(context, context.getPackageName()), this.f42a.e);
    }

    public boolean a(String str, String str2) {
        return this.f42a.m94a(str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.f42a.a(str, str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m84a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f46a) && TextUtils.equals(str2, a2.b);
    }

    public void a(boolean z) {
        this.f42a.a(z);
        a(this.f41a).edit().putBoolean("paused", z).commit();
    }

    public String b() {
        return this.f42a.b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m87c() {
        return this.f42a.c;
    }

    public String d() {
        return this.f42a.d;
    }

    public String e() {
        return this.f42a.g;
    }

    public String f() {
        return this.f42a.h;
    }

    public static class a {

        /* renamed from: a, reason: collision with other field name */
        private Context f45a;

        /* renamed from: a, reason: collision with other field name */
        public String f46a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a, reason: collision with other field name */
        public boolean f47a = true;

        /* renamed from: b, reason: collision with other field name */
        public boolean f48b = false;
        public int a = 1;

        static {
            Covode.recordClassIndex(655299);
        }

        private String a() {
            Context context = this.f45a;
            return com.xiaomi.push.g.m456a(context, context.getPackageName());
        }

        public void b() {
            this.f47a = false;
            b.a(this.f45a).edit().putBoolean("valid", this.f47a).commit();
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m92a() {
            b.a(this.f45a).edit().clear().commit();
            this.f46a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f47a = false;
            this.f48b = false;
            this.h = null;
            this.a = 1;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m93a() {
            return m94a(this.f46a, this.b);
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(boolean z) {
            this.f48b = z;
        }

        public a(Context context) {
            this.f45a = context;
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f46a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f47a);
                jSONObject.put("paused", aVar.f48b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f45a);
            this.e = a();
            this.f47a = true;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f46a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f47a = jSONObject.getBoolean("valid");
                aVar.f48b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m94a(String str, String str2) {
            boolean z;
            boolean z2;
            boolean equals = TextUtils.equals(this.f46a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z3 = !TextUtils.isEmpty(this.c);
            boolean z4 = !TextUtils.isEmpty(this.d);
            if (TextUtils.isEmpty(com.xiaomi.push.i.b(this.f45a)) || TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f45a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f45a))) {
                z = true;
            } else {
                z = false;
            }
            if (equals && equals2 && z3 && z4 && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z)));
            }
            return z2;
        }

        public void c(String str, String str2, String str3) {
            this.f46a = str;
            this.b = str2;
            this.g = str3;
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f45a);
            this.e = a();
            this.f47a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f45a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void a(String str, String str2, String str3) {
            this.f46a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f45a).edit();
            edit.putString("appId", this.f46a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }
    }

    public int a() {
        return this.f42a.a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m85b() {
        this.f42a.b();
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m88c() {
        return this.f42a.m93a();
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m90e() {
        return this.f42a.f48b;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m91f() {
        return !this.f42a.f47a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m80a() {
        return this.f42a.f46a;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m89d() {
        if (!TextUtils.isEmpty(this.f42a.f46a) && !TextUtils.isEmpty(this.f42a.b) && !TextUtils.isEmpty(this.f42a.c) && !TextUtils.isEmpty(this.f42a.d)) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m86b() {
        if (!this.f42a.m93a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Don't send message before initialization succeeded!");
            return false;
        }
        return true;
    }

    private void c() {
        this.f42a = new a(this.f41a);
        this.f44a = new HashMap();
        SharedPreferences a2 = a(this.f41a);
        this.f42a.f46a = a2.getString("appId", null);
        this.f42a.b = a2.getString("appToken", null);
        this.f42a.c = a2.getString("regId", null);
        this.f42a.d = a2.getString("regSec", null);
        this.f42a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f42a.f) && com.xiaomi.push.i.a(this.f42a.f)) {
            this.f42a.f = com.xiaomi.push.i.h(this.f41a);
            a2.edit().putString("devId", this.f42a.f).commit();
        }
        this.f42a.e = a2.getString("vName", null);
        this.f42a.f47a = a2.getBoolean("valid", true);
        this.f42a.f48b = a2.getBoolean("paused", false);
        this.f42a.a = a2.getInt("envType", 1);
        this.f42a.g = a2.getString("regResource", null);
        this.f42a.h = a2.getString("appRegion", null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m81a() {
        this.f42a.m92a();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    private b(Context context) {
        this.f41a = context;
        c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static b m79a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    public void b(String str) {
        this.f44a.remove(str);
        a(this.f41a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public a a(String str) {
        if (this.f44a.containsKey(str)) {
            return this.f44a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f41a);
        if (!a2.contains(str2)) {
            return null;
        }
        a a3 = a.a(this.f41a, a2.getString(str2, ""));
        this.f44a.put(str2, a3);
        return a3;
    }

    public void a(int i) {
        this.f42a.a(i);
        a(this.f41a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m82a(String str) {
        SharedPreferences.Editor edit = a(this.f41a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f42a.e = str;
    }

    public void a(String str, a aVar) {
        this.f44a.put(str, aVar);
        a(this.f41a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f42a.b(str, str2, str3);
    }
}

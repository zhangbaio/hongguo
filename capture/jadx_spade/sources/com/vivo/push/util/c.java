package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    protected Context a;
    private String b;
    private volatile SharedPreferences c;
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<String, Long> e = new HashMap<>();
    private HashMap<String, Integer> f = new HashMap<>();
    private HashMap<String, Boolean> g = new HashMap<>();

    static {
        Covode.recordClassIndex(655188);
    }

    public final SharedPreferences a() {
        c();
        return this.c;
    }

    private synchronized void c() {
        if (this.c == null) {
            Context context = this.a;
            if (context != null) {
                this.c = context.getSharedPreferences(this.b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    public final void b() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.clear();
            a(edit);
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a(String str) {
        this.g.put(str, Boolean.TRUE);
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putBoolean(str, true);
            a(edit);
        }
    }

    public final void c(String str) {
        this.e.remove(str);
        this.f.remove(str);
        this.g.remove(str);
        this.d.remove(str);
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            if (this.c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public final boolean b(String str) {
        Boolean bool = this.g.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        c();
        Boolean bool2 = Boolean.FALSE;
        if (this.c != null) {
            Boolean valueOf = Boolean.valueOf(this.c.getBoolean(str, false));
            if (valueOf != null && !valueOf.equals(bool2)) {
                this.g.put(str, valueOf);
            }
            bool2 = valueOf;
        }
        return bool2.booleanValue();
    }

    public final void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            this.c = context.getSharedPreferences(str, 0);
            this.a = context;
            return;
        }
        throw new RuntimeException("sharedFileName can't be null");
    }

    public final int b(String str, int i) {
        Integer num = this.f.get(str);
        if (num != null) {
            return num.intValue();
        }
        c();
        if (this.c != null) {
            num = Integer.valueOf(this.c.getInt(str, i));
            if (!num.equals(Integer.valueOf(i))) {
                this.f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final long b(String str, long j) {
        Long l = this.e.get(str);
        if (l != null) {
            return l.longValue();
        }
        c();
        if (this.c != null) {
            l = Long.valueOf(this.c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void a(String str, int i) {
        this.f.put(str, Integer.valueOf(i));
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    public final String b(String str, String str2) {
        String str3 = this.d.get(str);
        if (str3 != null) {
            return str3;
        }
        c();
        if (this.c != null) {
            str3 = this.c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.d.put(str, str3);
            }
        }
        return str3;
    }

    public final void a(String str, long j) {
        this.e.put(str, Long.valueOf(j));
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final void a(String str, String str2) {
        this.d.put(str, str2);
        c();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }
}

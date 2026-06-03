package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bl {
    private static volatile bl a;

    /* renamed from: a, reason: collision with other field name */
    private Context f148a;

    static {
        Covode.recordClassIndex(655381);
    }

    private bl(Context context) {
        this.f148a = context;
    }

    public static bl a(Context context) {
        if (a == null) {
            synchronized (bl.class) {
                if (a == null) {
                    a = new bl(context);
                }
            }
        }
        return a;
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f148a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f148a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m191a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f148a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m192a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f148a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}

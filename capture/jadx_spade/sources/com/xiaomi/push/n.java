package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class n {
    private static volatile n a;

    /* renamed from: a, reason: collision with other field name */
    private Context f843a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f844a = new HandlerDelegate(Looper.getMainLooper());

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f845a = new HashMap();

    static {
        Covode.recordClassIndex(655622);
    }

    private n(Context context) {
        this.f843a = context;
    }

    public static n a(Context context) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f845a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f845a.get(str);
                    if (map != null) {
                        return map.get(str2);
                    }
                    return "";
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f845a == null) {
            this.f845a = new HashMap();
        }
        Map<String, String> map = this.f845a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f845a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.f843a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m639a(final String str, final String str2, final String str3) {
        b(str, str2, str3);
        this.f844a.post(new Runnable() { // from class: com.xiaomi.push.n.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = n.this.f843a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }
}

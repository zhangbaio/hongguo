package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class am implements ah {
    private static volatile am a;

    /* renamed from: a, reason: collision with other field name */
    private int f117a = al.a;

    /* renamed from: a, reason: collision with other field name */
    private ah f118a;

    static {
        Covode.recordClassIndex(655346);
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo140a() {
        return a(this.f118a.mo140a());
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo141a() {
        return this.f118a.mo141a();
    }

    public static am a(Context context) {
        if (a == null) {
            synchronized (am.class) {
                if (a == null) {
                    a = new am(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private am(Context context) {
        this.f118a = al.a(context);
        com.xiaomi.channel.commonutils.logger.b.m54a("create id manager is: " + this.f117a);
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            map.put("udid", b);
        }
        String mo140a = mo140a();
        if (!TextUtils.isEmpty(mo140a)) {
            map.put("oaid", mo140a);
        }
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            map.put("vaid", c);
        }
        String d = d();
        if (!TextUtils.isEmpty(d)) {
            map.put("aaid", d);
        }
        map.put("oaid_type", String.valueOf(this.f117a));
    }
}

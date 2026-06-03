package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ap {
    private static ap a;

    /* renamed from: a, reason: collision with other field name */
    private int f943a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Context f944a;

    static {
        Covode.recordClassIndex(655687);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Uri m704a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    public int a() {
        int i = this.f943a;
        if (i != 0) {
            return i;
        }
        try {
            this.f943a = Settings.Global.getInt(this.f944a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f943a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m705a() {
        String str = com.xiaomi.push.w.f1038a;
        if (!str.contains("xmsf") && !str.contains("xiaomi") && !str.contains("miui")) {
            return false;
        }
        return true;
    }

    private ap(Context context) {
        this.f944a = context.getApplicationContext();
    }

    public static ap a(Context context) {
        if (a == null) {
            a = new ap(context);
        }
        return a;
    }
}

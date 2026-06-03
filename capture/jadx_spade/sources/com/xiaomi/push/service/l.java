package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ha;
import com.xiaomi.push.hf;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class l {
    static {
        Covode.recordClassIndex(655720);
    }

    public static hf a(ha haVar) {
        byte[] m539a = haVar.m539a();
        hf hfVar = new hf();
        try {
            ho.a(hfVar, m539a);
            return hfVar;
        } catch (ht unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.b(com.xiaomi.push.ax.m165a(str), bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.a(com.xiaomi.push.ax.m165a(str), bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e);
            return null;
        }
    }

    static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            try {
                byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
                if (b != null) {
                    x.m757a(context, u.a(b), b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m54a("notify fcm notification error ：dencrypt failed");
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
        }
    }
}

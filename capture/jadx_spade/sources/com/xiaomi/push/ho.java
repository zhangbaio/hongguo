package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hv;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ho {
    static {
        Covode.recordClassIndex(655591);
    }

    public static <T extends hp<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new hu(new hv.a()).a(t);
        } catch (ht e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }

    public static short a(Context context, String str) {
        return m600a(context, str, (String) null);
    }

    public static <T extends hp<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new hs(new Cif.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new ht("the message byte is empty.");
    }

    public static short a(Context context, ha haVar) {
        String str;
        gr m533a = haVar.m533a();
        if (m533a != null && m533a.m500a() != null) {
            str = m533a.m500a().get("channel_id");
        } else {
            str = null;
        }
        return m600a(context, haVar.f656b, str);
    }

    private static int a(Context context, String str, String str2) {
        com.xiaomi.push.service.af a;
        NotificationChannel m685a;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && (a = com.xiaomi.push.service.af.a(context, str)) != null && (m685a = a.m685a(a.m688a(str2))) != null) {
            if (m685a.getImportance() != 0) {
                return 32;
            }
            return 64;
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static short m600a(Context context, String str, String str2) {
        int i;
        int i2;
        int i3 = 0;
        int a = g.a(context, str, false).a() + 0;
        if (ac.b(context)) {
            i = 4;
        } else {
            i = 0;
        }
        int i4 = a + i;
        if (ac.a(context)) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        int i5 = i4 + i2;
        if (com.xiaomi.push.service.af.m683a(context)) {
            i3 = 16;
        }
        return (short) (i5 + i3 + a(context, str, str2));
    }
}

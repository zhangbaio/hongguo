package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ad extends c {
    private static ad b;
    private static com.vivo.push.f.a d;
    private Map<String, byte[]> c = new ConcurrentHashMap();

    static {
        Covode.recordClassIndex(655180);
    }

    public static synchronized ad c() {
        ad adVar;
        synchronized (ad.class) {
            if (b == null) {
                b = new ad();
            }
            if (d == null) {
                d = new com.vivo.push.f.a();
            }
            adVar = b;
        }
        return adVar;
    }

    public final byte[] d() {
        byte[] bArr = this.c.get("com.vivo.push.c");
        if (bArr == null || bArr.length <= 0) {
            return d.a(this.a);
        }
        return bArr;
    }

    public final byte[] e() {
        byte[] bArr = this.c.get("com.vivo.push.d");
        if (bArr == null || bArr.length <= 0) {
            return d.b(this.a);
        }
        return bArr;
    }

    private static byte[] d(String str) {
        int i;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = Byte.parseByte(split[i2].trim());
            }
        } catch (Exception e) {
            t.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }

    private synchronized void b(Context context) {
        if (!b("data_clear") && context != null) {
            Iterator<Map.Entry<String, ?>> it2 = a().getAll().entrySet().iterator();
            while (it2.hasNext()) {
                String key = it2.next().getKey();
                if (!TextUtils.isEmpty(key) && (key.contains("_sub_") || key.contains("_cache_"))) {
                    c(key);
                }
            }
            t.c("SharePreferenceManager", " old data clear ");
            a("data_clear");
        }
    }

    private List<String> e(String str) {
        Object a;
        String[] split;
        if (this.a == null) {
            t.c("SharePreferenceManager", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.a;
            a = ah.a(context, context.getPackageName(), str);
        } catch (Exception e) {
            t.c("SharePreferenceManager", " parsLocalIv error e =" + e.getMessage());
        }
        if (a == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final synchronized void a(Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
            List<String> e = e("local_iv");
            if (e != null && e.size() >= 4) {
                this.c.put("com.vivo.push.a", d(e.get(1)));
                this.c.put("com.vivo.push.b", d(e.get(2)));
                this.c.put("com.vivo.push.c", d(e.get(3)));
                this.c.put("com.vivo.push.d", d(e.get(0)));
                b(this.a);
            }
            t.a("SharePreferenceManager", " initSecureCode error list is null ");
            b(this.a);
        }
    }
}

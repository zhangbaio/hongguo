package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gc {
    private static volatile gc a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f489a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, gd> f490a = new HashMap();

    static {
        Covode.recordClassIndex(655552);
    }

    /* renamed from: a, reason: collision with other method in class */
    Map<String, gd> m463a() {
        return this.f490a;
    }

    gd a() {
        gd gdVar = this.f490a.get("UPLOADER_PUSH_CHANNEL");
        if (gdVar != null) {
            return gdVar;
        }
        gd gdVar2 = this.f490a.get("UPLOADER_HTTP");
        if (gdVar2 != null) {
            return gdVar2;
        }
        return null;
    }

    private gc(Context context) {
        this.f489a = context;
    }

    public static gc a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (gc.class) {
                if (a == null) {
                    a = new gc(context);
                }
            }
        }
        return a;
    }

    public void a(gd gdVar, String str) {
        if (gdVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m463a().put(str, gdVar);
        }
    }

    public boolean a(gi giVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.az.a(giVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(giVar.d())) {
            giVar.f(com.xiaomi.push.service.az.a());
        }
        giVar.g(str);
        com.xiaomi.push.service.ba.a(this.f489a, giVar);
        return true;
    }
}

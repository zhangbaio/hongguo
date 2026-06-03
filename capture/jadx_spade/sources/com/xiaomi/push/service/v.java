package com.xiaomi.push.service;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class v {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static b f1020a;

    public interface a {
        Map<String, String> a(Context context, ha haVar);

        /* renamed from: a, reason: collision with other method in class */
        void m754a(Context context, ha haVar);

        void a(Context context, ha haVar, hd hdVar);

        boolean a(Context context, ha haVar, boolean z);
    }

    public interface b {
        void a(ha haVar);

        void a(String str);

        /* renamed from: a, reason: collision with other method in class */
        boolean m755a(ha haVar);
    }

    static {
        Covode.recordClassIndex(655743);
    }

    public static void a(ha haVar) {
        b bVar = f1020a;
        if (bVar != null && haVar != null) {
            bVar.a(haVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("pepa clearMessage is null");
        }
    }

    public static void a(String str) {
        b bVar = f1020a;
        if (bVar != null && str != null) {
            bVar.a(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("pepa clearMessage is null");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m753a(ha haVar) {
        b bVar = f1020a;
        if (bVar != null && haVar != null) {
            return bVar.m755a(haVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("pepa handleReceiveMessage is null");
        return false;
    }

    public static Map<String, String> a(Context context, ha haVar) {
        a aVar = a;
        if (aVar != null && haVar != null) {
            return aVar.a(context, haVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m752a(Context context, ha haVar) {
        a aVar = a;
        if (aVar != null && haVar != null) {
            aVar.m754a(context, haVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("handle msg wrong");
        }
    }

    public static void a(Context context, ha haVar, hd hdVar) {
        a aVar = a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, haVar, hdVar);
        }
    }

    public static boolean a(Context context, ha haVar, boolean z) {
        a aVar = a;
        if (aVar != null && haVar != null) {
            return aVar.a(context, haVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("pepa judement listener or container is null");
        return false;
    }
}

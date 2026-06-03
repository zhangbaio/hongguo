package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.hd;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static b f978a;

    public interface a {
        boolean a(hd hdVar);
    }

    public interface b {
    }

    static {
        Covode.recordClassIndex(655713);
    }

    public static void a(b bVar) {
        f978a = bVar;
    }

    public static boolean a(hd hdVar) {
        if (a != null && hdVar != null) {
            if (!com.xiaomi.push.j.m631a(com.xiaomi.push.q.m640a())) {
                com.xiaomi.channel.commonutils.logger.b.m54a("rc app not permission to cpra");
                return false;
            }
            return a.a(hdVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("rc params is null, not cpra");
        return false;
    }
}

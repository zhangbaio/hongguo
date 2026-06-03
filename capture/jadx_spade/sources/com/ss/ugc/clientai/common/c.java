package com.ss.ugc.clientai.common;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private static ExecutorService a;
    private static ScheduledExecutorService b;

    private static class a {
        private static boolean a;

        static {
            Covode.recordClassIndex(652805);
            a = false;
        }

        /* renamed from: com.ss.ugc.clientai.common.c$a$a, reason: collision with other inner class name */
        private static class C0097a {
            public static ScheduledExecutorService a;

            static {
                Covode.recordClassIndex(652806);
                a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("MLTask$Default$Holder"));
            }
        }

        public static ScheduledExecutorService a() {
            if (b.a && !a) {
                a = true;
                b.f("ml#task", "use Default ScheduledExecutorService!", new Throwable("for debug!!"));
            }
            return C0097a.a;
        }
    }

    static {
        Covode.recordClassIndex(652804);
        a = null;
        b = null;
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService scheduledExecutorService = b;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        Context context = com.ss.ugc.clientai.common.a.a;
        return a.a();
    }

    public static void b(Runnable runnable) {
        a().execute(runnable);
    }

    public static void c(Runnable runnable, long j) {
        if (j <= 0) {
            b(runnable);
        } else {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }
}

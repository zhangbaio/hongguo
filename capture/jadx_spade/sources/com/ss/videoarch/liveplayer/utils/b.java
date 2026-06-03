package com.ss.videoarch.liveplayer.utils;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static volatile ExecutorService a;
    private static volatile ExecutorService b;
    private static volatile boolean c;
    private static d d;
    private static d e;

    public static ExecutorService d() {
        return a;
    }

    public static ExecutorService e() {
        return b;
    }

    public static boolean g() {
        return c;
    }

    static class d {
        int a;
        int b;
        int c;

        static {
            Covode.recordClassIndex(653097);
        }

        d() {
        }

        static d a() {
            d dVar = new d();
            dVar.a = 5;
            dVar.b = 1;
            dVar.c = 2;
            return dVar;
        }

        static d b() {
            d dVar = new d();
            dVar.a = 4;
            dVar.b = 2;
            dVar.c = 4;
            return dVar;
        }

        void c() {
            com.ss.videoarch.liveplayer.log.a.a("GlobalLiveThreadPool", "ThreadPoolConfig, priority:" + this.a + ", core:" + this.b + ", max:" + this.c);
        }
    }

    static {
        Covode.recordClassIndex(653094);
        c = false;
    }

    public static Future c(Runnable runnable) {
        if (c && runnable != null) {
            return a.submit(runnable);
        }
        return null;
    }

    /* renamed from: com.ss.videoarch.liveplayer.utils.b$b, reason: collision with other inner class name */
    private static class ThreadFactoryC0101b implements ThreadFactory {
        static {
            Covode.recordClassIndex(653095);
        }

        private ThreadFactoryC0101b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "VideoLiveManager-H");
            thread.setPriority(b.d.a);
            return thread;
        }
    }

    private static class c implements ThreadFactory {
        static {
            Covode.recordClassIndex(653096);
        }

        private c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "VideoLiveManager-L");
            thread.setPriority(b.e.a);
            return thread;
        }
    }

    private static void h(JSONObject jSONObject, d dVar) {
        if (jSONObject != null && dVar != null) {
            if (jSONObject.has("priority")) {
                dVar.a = jSONObject.optInt("priority");
            }
            if (jSONObject.has("core_size")) {
                dVar.b = jSONObject.optInt("core_size");
            }
            if (jSONObject.has("max_size")) {
                dVar.c = jSONObject.optInt("max_size");
            }
            dVar.c();
        }
    }

    public static void f(String str, int i) {
        int i2;
        if (c) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("live_sdk_use_global_threadpool")) {
                i2 = jSONObject.optInt("live_sdk_use_global_threadpool");
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                com.ss.videoarch.liveplayer.log.a.c("GlobalLiveThreadPool", "Not enable threadpool");
                return;
            }
            synchronized (b.class) {
                if (!c) {
                    d = d.a();
                    e = d.b();
                    h(jSONObject.optJSONObject("high"), d);
                    h(jSONObject.optJSONObject("low"), e);
                    if (i > 0) {
                        int min = Math.min(10, Math.max(1, i));
                        d dVar = d;
                        dVar.a = Math.min(dVar.a, min);
                        d dVar2 = e;
                        dVar2.a = Math.min(dVar2.a, min);
                    }
                    d dVar3 = d;
                    int i3 = dVar3.b;
                    int i4 = dVar3.c;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    a = new PThreadPoolExecutorDelegate(i3, i4, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC0101b());
                    d dVar4 = e;
                    b = new PThreadPoolExecutorDelegate(dVar4.b, dVar4.c, 60L, timeUnit, new LinkedBlockingQueue(), new c());
                    c = true;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.ss.videoarch.liveplayer.log.a.b("GlobalLiveThreadPool", "init fail, input config is not valid json.");
        }
    }
}

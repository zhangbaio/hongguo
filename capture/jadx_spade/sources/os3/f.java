package os3;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsCommunityApi;
import com.dragon.read.report.ReportManager;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import os3.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;
    private static HandlerThread b;
    private static Handler c;
    private static c d;
    private static boolean e;
    public static final int f;

    static {
        Covode.recordClassIndex(599021);
        a = new f();
        f = 8;
    }

    private f() {
    }

    private final boolean f() {
        return NsCommunityApi.IMPL.danmakuCpuMonitorEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        c cVar = d;
        if (cVar != null) {
            cVar.m("");
        }
    }

    public final void c() {
        Handler handler = c;
        if (e && handler != null) {
            handler.post(new Runnable() { // from class: os3.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str) {
        c cVar = d;
        if (cVar != null) {
            cVar.m(str);
        }
    }

    public final void g(final String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Handler handler = c;
        if (e && handler != null) {
            handler.post(new Runnable() { // from class: os3.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(scene);
                }
            });
        }
    }

    public static final class a implements c.InterfaceC0252c {
        a() {
        }

        @Override // os3.c.InterfaceC0252c
        public void a(List<c.b> samples) {
            Intrinsics.checkNotNullParameter(samples, "samples");
            Iterator<T> it2 = samples.iterator();
            while (it2.hasNext()) {
                ReportManager.onReport("prf_power_sample_report", c.j.a((c.b) it2.next()));
            }
        }
    }

    public final void e(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!e && f()) {
            HandlerThread handlerThread = new HandlerThread("cpu_power_handler");
            handlerThread.start();
            b = handlerThread;
            HandlerThread handlerThread2 = b;
            Intrinsics.checkNotNull(handlerThread2);
            c = new HandlerDelegate(handlerThread2.getLooper());
            Handler handler = c;
            Intrinsics.checkNotNull(handler);
            c cVar = new c(ctx, handler, new a(), 0L, 0L, 24, null);
            d = cVar;
            cVar.k("");
            e = true;
        }
    }
}

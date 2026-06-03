package com.xs.fm.player.sdk.play.player.audio.engine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EngineLooperMonitor {
    static final /* synthetic */ KProperty[] i;
    private static int j;
    public static final a k;
    private final bl6.a a = new bl6.a("EngineLooperMonitor");
    private final Lazy b;
    private final Lazy c;
    public HandlerThread d;
    private Handler e;
    private boolean f;
    public boolean g;
    private Runnable h;

    static {
        Covode.recordClassIndex(655951);
        i = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(EngineLooperMonitor.class), "assistHandlerThread", "getAssistHandlerThread()Landroid/os/HandlerThread;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(EngineLooperMonitor.class), "assistHandler", "getAssistHandler()Landroid/os/Handler;"))};
        k = new a(null);
    }

    private final Handler e() {
        Lazy lazy = this.c;
        KProperty kProperty = i[1];
        return (Handler) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread f() {
        Lazy lazy = this.b;
        KProperty kProperty = i[0];
        return (HandlerThread) lazy.getValue();
    }

    public static final int g() {
        return j;
    }

    public static final void i(boolean z) {
        k.a(z);
    }

    public static final void j(PlayEngineInfo playEngineInfo, boolean z, boolean z2) {
        k.b(playEngineInfo, z, z2);
    }

    public static final void k(int i2) {
        j = i2;
    }

    public EngineLooperMonitor() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.EngineLooperMonitor$assistHandlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HandlerThread invoke() {
                return a.a();
            }
        });
        this.b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.EngineLooperMonitor$assistHandler$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                HandlerThread f;
                f = EngineLooperMonitor.this.f();
                if (f != null) {
                    return new HandlerDelegate(f.getLooper());
                }
                return null;
            }
        });
        this.c = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        Handler e;
        Handler handler = this.e;
        if (handler != null && (e = e()) != null) {
            Looper looper = handler.getLooper();
            Intrinsics.checkExpressionValueIsNotNull(looper, "it.looper");
            Thread thread = looper.getThread();
            Intrinsics.checkExpressionValueIsNotNull(thread, "it.looper.thread");
            if (thread.isAlive()) {
                handler.sendEmptyMessage(1000000);
                b bVar = new b(handler, this);
                this.h = bVar;
                e.postDelayed(bVar, 3000L);
                return;
            }
            m();
        }
    }

    public final void m() {
        Handler e;
        this.a.d("EngineLooperMonitor", "stopAndReset EngineLooperMonitor=" + k);
        Runnable runnable = this.h;
        if (runnable != null && (e = e()) != null) {
            e.removeCallbacksAndMessages(runnable);
        }
        this.f = false;
        this.g = false;
    }

    static final class b implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ EngineLooperMonitor b;

        b(Handler handler, EngineLooperMonitor engineLooperMonitor) {
            this.a = handler;
            this.b = engineLooperMonitor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.f) {
                EngineLooperMonitor engineLooperMonitor = this.b;
                boolean z = false;
                if (this.a.hasMessages(1000000)) {
                    this.a.removeMessages(1000000);
                    this.b.a.d("isBlocked = true EngineLooperMonitor=" + EngineLooperMonitor.k, new Object[0]);
                    z = true;
                } else {
                    EngineLooperMonitor engineLooperMonitor2 = this.b;
                    if (engineLooperMonitor2.g) {
                        engineLooperMonitor2.a.d("isBlocked = false EngineLooperMonitor=" + EngineLooperMonitor.k, new Object[0]);
                    }
                }
                engineLooperMonitor.g = z;
                this.b.h();
            }
        }
    }

    public static final class a {
        static {
            Covode.recordClassIndex(655952);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z) {
            ik6.a aVar;
            try {
                JSONObject jSONObject = new JSONObject();
                int i = 1;
                jSONObject.putOpt("recreate", 1);
                if (!z) {
                    i = 0;
                }
                jSONObject.putOpt("is_tts", Integer.valueOf(i));
                lk6.b bVar = lk6.c.a;
                if (bVar != null && (aVar = bVar.f) != null) {
                    aVar.onEvent("engine_looper_monitor", jSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void b(PlayEngineInfo playEngineInfo, boolean z, boolean z2) {
            int i;
            ik6.a aVar;
            if (playEngineInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    int i2 = 1;
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.putOpt("is_block", Integer.valueOf(i));
                    if (!z2) {
                        i2 = 0;
                    }
                    jSONObject.putOpt("is_tts", Integer.valueOf(i2));
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.f) != null) {
                        aVar.onEvent("engine_looper_monitor", jSONObject);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void l(HandlerThread handlerThread) {
        this.a.d("startMonitor monitoredThread=" + handlerThread + " EngineLooperMonitor=" + k, new Object[0]);
        if (!Intrinsics.areEqual(this.d, handlerThread)) {
            m();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        this.e = new HandlerDelegate(handlerThread.getLooper());
        h();
    }
}

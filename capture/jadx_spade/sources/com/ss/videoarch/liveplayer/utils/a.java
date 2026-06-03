package com.ss.videoarch.liveplayer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static AudioManager a;
    private static int b;
    private static int c;
    private static boolean d;
    private static C0100a e;

    static {
        Covode.recordClassIndex(653091);
        b = -1;
        c = -1;
        d = false;
        e = null;
    }

    public static double g(Context context) {
        return h(context);
    }

    /* renamed from: com.ss.videoarch.liveplayer.utils.a$a, reason: collision with other inner class name */
    public static class C0100a extends BroadcastReceiver {
        private WeakReference<AudioManager> a;

        static {
            Covode.recordClassIndex(653092);
        }

        public C0100a(AudioManager audioManager) {
            this.a = new WeakReference<>(audioManager);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int streamVolume;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && this.a.get() != null && (streamVolume = this.a.get().getStreamVolume(3)) >= 0) {
                    int unused = a.c = streamVolume;
                }
            } catch (Exception unused2) {
                int unused3 = a.c = -1;
            }
        }
    }

    public static void l(Context context) {
        if (d) {
            try {
                b(context, e);
                e = null;
                d = false;
            } catch (Exception unused) {
            }
        }
    }

    public static int e(Context context) {
        if (i(context)) {
            return -1;
        }
        if (b < 0) {
            b = a.getStreamMaxVolume(3);
        }
        return b;
    }

    private static double h(Context context) {
        if (i(context)) {
            return 0.0d;
        }
        try {
            if (c < 0 || !d) {
                c = f(context, 3);
            }
            return c;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private static boolean i(Context context) {
        if (a == null) {
            try {
                a = (AudioManager) context.getSystemService("audio");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (a == null) {
            return true;
        }
        return false;
    }

    public static void j(Context context) {
        if (!d) {
            try {
                if (i(context)) {
                    return;
                }
                e = new C0100a(a);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                c(context, e, intentFilter);
                d = true;
            } catch (Exception unused) {
            }
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void b(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    public static int f(Context context, int i) {
        if (i(context)) {
            return -1;
        }
        try {
            return a.getStreamVolume(i);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean k(Context context, int i, int i2) {
        if (i(context)) {
            return false;
        }
        try {
            a.setStreamVolume(3, i, i2);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e2;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(context instanceof Context)) {
                context = null;
            }
            if (context == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
        }
        return a(context, broadcastReceiver, filter);
    }
}

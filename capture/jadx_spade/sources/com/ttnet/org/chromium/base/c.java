package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.a1;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

@JNINamespace("base::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private static Context a;

    private static class a {
        private static SharedPreferences a;

        static {
            Covode.recordClassIndex(654180);
            a = c.d();
        }
    }

    public static Context f() {
        return a;
    }

    public static SharedPreferences e() {
        return a.a;
    }

    static {
        Covode.recordClassIndex(654179);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences d() {
        o d = o.d();
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
            if (d != null) {
                d.close();
            }
            return defaultSharedPreferences;
        } catch (Throwable th) {
            if (d != null) {
                try {
                    d.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void g(Context context) {
        h(context);
    }

    private static void h(Context context) {
        if (xj6.a.a && (context instanceof Application)) {
            context = new ContextWrapper(context);
        }
        a = context;
    }

    public static Intent j(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return i(context, broadcastReceiver, intentFilter, null, null, 4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Exception e) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            }
            throw e;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter, String str, Handler handler) {
        Context context2;
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (a1.T(34)) {
            if (context instanceof Context) {
                context2 = context;
            } else {
                context2 = null;
            }
            if (context2 == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return context2.registerReceiver(broadcastReceiver, filter, str, handler, 2);
        }
        return a(context, broadcastReceiver, filter, str, handler);
    }

    private static Intent i(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return vj6.c.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i);
        }
        return b(context, broadcastReceiver, intentFilter, str, handler);
    }
}

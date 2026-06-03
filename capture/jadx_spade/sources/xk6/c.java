package xk6;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c extends BroadcastReceiver {
    private static final bl6.a a;
    private static volatile boolean b;
    private static AudioManager c;
    private static List<a> d;
    public static final c e;

    public interface a {
        void a(int i);
    }

    private c() {
    }

    public final int d() {
        try {
            AudioManager audioManager = c;
            if (audioManager == null) {
                return 0;
            }
            return audioManager.getStreamVolume(3);
        } catch (Throwable unused) {
            a.b("getCurrentVolume exception!", new Object[0]);
            return 0;
        }
    }

    public final int e() {
        try {
            AudioManager audioManager = c;
            if (audioManager == null) {
                return 0;
            }
            return audioManager.getStreamMaxVolume(3);
        } catch (Throwable unused) {
            a.b("getMaxVolume exception!", new Object[0]);
            return 0;
        }
    }

    static {
        Covode.recordClassIndex(655866);
        e = new c();
        a = new bl6.a("FMVolumeManager");
        d = Collections.synchronizedList(new ArrayList());
    }

    public final synchronized void c() {
        Object obj;
        Application application;
        Application application2;
        Context applicationContext;
        a.d("FMVolumeManager", "doInit, hasInit = " + b);
        if (!b) {
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (application2 = bVar.b) != null && (applicationContext = application2.getApplicationContext()) != null) {
                obj = applicationContext.getSystemService("audio");
            } else {
                obj = null;
            }
            c = (AudioManager) obj;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (application = bVar2.b) != null) {
                b(application, this, intentFilter);
            }
            b = true;
        }
    }

    public final void f(a aVar) {
        a.d("FMVolumeManager", "registerVolumeChangeListener");
        if (aVar != null) {
            d.add(aVar);
        }
    }

    public final void g(a aVar) {
        a.d("FMVolumeManager", "unregisterVolumeChangeListener");
        if (aVar != null) {
            d.remove(aVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (TextUtils.equals(str, "android.media.VOLUME_CHANGED_ACTION")) {
            if ((intent != null && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) || (intent != null && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 10)) {
                a.d("FMVolumeManager", "onReceive volume changed, currentVolume = " + d());
                int d2 = d();
                List<a> mVolumeChangeListenerList = d;
                Intrinsics.checkExpressionValueIsNotNull(mVolumeChangeListenerList, "mVolumeChangeListenerList");
                synchronized (mVolumeChangeListenerList) {
                    for (a aVar : d) {
                        if (aVar != null) {
                            aVar.a(d2);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent a(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return application.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return application.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e2;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(application instanceof Context)) {
                application = null;
            }
            if (application == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(application, broadcastReceiver, filter, 2);
        }
        return a(application, broadcastReceiver, filter);
    }
}

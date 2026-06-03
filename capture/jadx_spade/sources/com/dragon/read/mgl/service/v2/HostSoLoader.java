package com.dragon.read.mgl.service.v2;

import android.os.Build;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.plugin.common.PluginServiceManager;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HostSoLoader {
    public static final int $stable = 0;
    public static final HostSoLoader INSTANCE;

    static {
        Covode.recordClassIndex(611984);
        INSTANCE = new HostSoLoader();
    }

    private HostSoLoader() {
    }

    public static final void loadSo(String libName) {
        Object m773constructorimpl;
        Intrinsics.checkNotNullParameter(libName, "libName");
        try {
            Result.Companion companion = Result.Companion;
            System.loadLibrary(libName);
            m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            LogWrapper.e("HostSoLoader", new Object[]{"loadso fail:" + m776exceptionOrNullimpl.getMessage()});
        }
    }

    public final void loadSo1(String libName) {
        Map mutableMapOf;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(libName, "libName");
        try {
            CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"napi", "kryptonogg", "kryptonlive", "audioeffect"});
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("audioeffect", "audioeffect_plugin"));
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) libName, (CharSequence) libName, false, 2, (Object) null);
            if (contains$default) {
                Class q = a.q("com.xxx.HostSoLoader");
                String str = (String) mutableMapOf.get(libName);
                if (str != null) {
                    Method declaredMethod = q.getDeclaredMethod("loadSo", String.class, String.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, str, libName);
                    return;
                } else {
                    Method declaredMethod2 = q.getDeclaredMethod("loadSo", String.class);
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(null, "libName");
                    return;
                }
            }
            if (((String) mutableMapOf.get(libName)) != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    System.loadLibrary(libName);
                } else {
                    System.load("xxx");
                }
            } else {
                System.loadLibrary(libName);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            Log.e("HostSoLoader", "load so " + libName + " error. " + th.getMessage());
        }
    }

    public final void loadSo(String pluginName, String libName) {
        Object m773constructorimpl;
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(libName, "libName");
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(Boolean.valueOf(PluginServiceManager.ins().loadLibrary(pluginName, "bytenn")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            LogWrapper.e("HostSoLoader", new Object[]{"loadso fail:" + m776exceptionOrNullimpl.getMessage()});
        }
    }
}

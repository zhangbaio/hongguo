package er4;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.NsBaseMmkvDependImpl;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.facebook.soloader.SoLoader;
import com.ss.android.common.util.ToolUtils;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public static final y a;
    private static volatile v b;
    private static final Lazy c;
    public static volatile boolean d;
    public static final int e;

    private y() {
    }

    public final v e() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m() {
        return NsBaseMmkvDependImpl.INSTANCE.mmkvReportEnableV715();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(611475);
        a = new y();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: er4.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean m;
                m = y.m();
                return Boolean.valueOf(m);
            }
        });
        c = lazy;
        e = 8;
    }

    public static final void j() {
        if (!ToolUtils.isMainProcess(AppUtils.context())) {
            return;
        }
        if (b != null) {
            LogWrapper.w("MMKVProxy.injectCacheFileObserver", new Object[]{"cacheFileObserver is not null, ignore"});
        } else {
            b = new a();
        }
    }

    public static final class a implements v {
        a() {
        }

        @Override // er4.v
        public void a(String cacheId) {
            Intrinsics.checkNotNullParameter(cacheId, "cacheId");
            v mmkvFileObserverForPreload = NsBaseMmkvDependImpl.INSTANCE.mmkvFileObserverForPreload();
            if (mmkvFileObserverForPreload != null) {
                mmkvFileObserverForPreload.a(cacheId);
            }
        }

        @Override // er4.v
        public void b(String cacheId, MMKV mmkv, boolean z, long j) {
            Intrinsics.checkNotNullParameter(cacheId, "cacheId");
            Intrinsics.checkNotNullParameter(mmkv, "mmkv");
            NsBaseMmkvDependImpl nsBaseMmkvDependImpl = NsBaseMmkvDependImpl.INSTANCE;
            v mmkvFileObserverForPreload = nsBaseMmkvDependImpl.mmkvFileObserverForPreload();
            if (mmkvFileObserverForPreload != null) {
                mmkvFileObserverForPreload.b(cacheId, mmkv, z, j);
            }
            if (y.a.f() && j > 0) {
                long j2 = mmkv.totalSize();
                long count = mmkv.count();
                long actualSize = mmkv.actualSize();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", cacheId);
                jSONObject.put("kvCount", count);
                jSONObject.put("totalByte", j2);
                jSONObject.put("actualByte", actualSize);
                jSONObject.put("costTime", j / 1000);
                jSONObject.put("isMultiProcess", z);
                Unit unit = Unit.INSTANCE;
                nsBaseMmkvDependImpl.onReport("mmkv_info", jSONObject);
            }
        }
    }

    private static final synchronized void g(final Context context) {
        synchronized (y.class) {
            MMKV.initialize(context.getFilesDir().getAbsolutePath() + "/mmkv", new MMKV.LibLoader() { // from class: er4.x
                @Override // com.tencent.mmkv.MMKV.LibLoader
                public final void loadLibrary(String str) {
                    y.h(context, str);
                }
            });
        }
    }

    public final List<String> d(SharedPreferences sharedPreferences) {
        String[] strArr;
        List<String> list;
        if (sharedPreferences instanceof MMKV) {
            strArr = ((MMKV) sharedPreferences).allKeys();
        } else if (sharedPreferences instanceof d0) {
            strArr = (String[]) ((d0) sharedPreferences).k().toArray(new String[0]);
        } else {
            strArr = null;
        }
        if (strArr == null || (list = ArraysKt___ArraysKt.toList(strArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public static final synchronized void i(Context application) {
        synchronized (y.class) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (!d) {
                synchronized (a) {
                    if (!d) {
                        try {
                            MMKV.initialize(application);
                            LogWrapper.info("mmkvNoLock", "MMKV.initialize", new Object[0]);
                        } catch (Throwable th) {
                            LogWrapper.error("mmkvNoLock", "无法使用默认方式初始化MMKV，error = %s", new Object[]{th});
                            g(application);
                        }
                        MMKV.setLogLevel(MMKVLogLevel.LevelWarning);
                        MMKV.enableAutoCloseFd(true);
                        d = true;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String str) {
        try {
            LogWrapper.w("尝试使用 SoLoader初始化MMKV，已属于极端情况，故每次同步init", new Object[0]);
            SoLoader.k(context, 0);
        } catch (Exception e2) {
            LogWrapper.e("SoLoader初始化MMKV失败，error = %s", new Object[]{Log.getStackTraceString(e2)});
            com.dragon.read.base.depend.g.b.b(e2);
        }
        SoLoader.p(str);
    }

    public static final synchronized SharedPreferences k(Context ctx, String cacheId) {
        Context context;
        d0 d0Var;
        synchronized (y.class) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(cacheId, "cacheId");
            if (ctx instanceof Application) {
                context = (Application) ctx;
            } else {
                context = null;
            }
            if (context == null) {
                context = ctx.getApplicationContext();
            }
            try {
                d0Var = new d0(cacheId);
            } catch (Exception e2) {
                LogWrapper.w("MMKV may be not initialized and try to initialize, error = " + e2, new Object[0]);
                try {
                    MMKV.initialize(context);
                } catch (Throwable th) {
                    LogWrapper.e("无法使用默认方式初始化MMKV，error = %s", new Object[]{th});
                    Intrinsics.checkNotNull(context);
                    g(context);
                }
                MMKV.setLogLevel(MMKVLogLevel.LevelWarning);
                MMKV.enableAutoCloseFd(true);
                d0Var = new d0(cacheId);
            }
        }
        return d0Var;
    }

    public static final SharedPreferences l(Context ctx, String cacheId) {
        Context context;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        if (ctx instanceof Application) {
            context = (Application) ctx;
        } else {
            context = null;
        }
        if (context == null) {
            context = ctx.getApplicationContext();
        }
        try {
            return new d0(cacheId);
        } catch (Exception e2) {
            LogWrapper.warn("mmkvNoLock", "MMKV may be not initialized and try to initialize, error = " + e2, new Object[0]);
            Intrinsics.checkNotNull(context);
            i(context);
            return new d0(cacheId);
        }
    }
}

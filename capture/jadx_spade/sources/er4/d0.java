package er4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.NsBaseMmkvDependImpl;
import com.dragon.read.base.util.LogHelper;
import com.tencent.mmkv.MMKV;
import er4.d0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 implements SharedPreferences, SharedPreferences.Editor {
    public static final b b;
    private static final LogHelper c;
    private static final Map<String, e0> d;
    private static final int e;
    private static final Lazy<ExecutorService> f;
    private static c g;
    private static final Lazy<Handler> h;
    private static final a i;
    private final String a;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public final MMKV l() {
        return j();
    }

    public static final class b {
        static {
            Covode.recordClassIndex(611477);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Handler f() {
            return (Handler) d0.h.getValue();
        }

        public final ExecutorService k() {
            Object value = d0.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (ExecutorService) value;
        }

        private final boolean l(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return NsBaseMmkvDependImpl.INSTANCE.getMultiProcessIds().contains(str);
        }

        private final e0 g(final String str) {
            e0 e0Var;
            boolean z;
            Map map = d0.d;
            Intrinsics.checkNotNullExpressionValue(map, "access$getMmkvCacheMap$cp(...)");
            synchronized (map) {
                e0Var = (e0) d0.d.get(str);
                if (e0Var == null) {
                    final boolean l = d0.b.l(str);
                    FutureTask futureTask = new FutureTask(new Callable() { // from class: er4.c0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Pair h;
                            h = d0.b.h(str, l);
                            return h;
                        }
                    });
                    if (!l) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t tVar = new t(futureTask, null, 0L, z, 4, null);
                    Map map2 = d0.d;
                    Intrinsics.checkNotNullExpressionValue(map2, "access$getMmkvCacheMap$cp(...)");
                    map2.put(str, tVar);
                    e0Var = tVar;
                }
            }
            return e0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [T, er4.u] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        private final e0 i(final String str) {
            e0 e0Var;
            boolean z;
            Map map = d0.d;
            Intrinsics.checkNotNullExpressionValue(map, "access$getMmkvCacheMap$cp(...)");
            synchronized (map) {
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ?? r2 = d0.d.get(str);
                ref$ObjectRef.element = r2;
                if (r2 == 0) {
                    final boolean l = d0.b.l(str);
                    Runnable runnable = new Runnable() { // from class: er4.b0
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0.b.j(str, l, ref$ObjectRef);
                        }
                    };
                    if (!l) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ref$ObjectRef.element = new u(runnable, null, 0L, z, 4, null);
                    Map map2 = d0.d;
                    Intrinsics.checkNotNullExpressionValue(map2, "access$getMmkvCacheMap$cp(...)");
                    map2.put(str, ref$ObjectRef.element);
                }
                e0Var = (e0) ref$ObjectRef.element;
            }
            return e0Var;
        }

        public final MMKV e(String cacheId) {
            Object m773constructorimpl;
            long j;
            Intrinsics.checkNotNullParameter(cacheId, "cacheId");
            e0 i = i(cacheId);
            if (i.a == null) {
                synchronized (i) {
                    if (i.a == null) {
                        boolean l = d0.b.l(cacheId);
                        long j2 = 0;
                        if (i instanceof u) {
                            try {
                                Result.Companion companion = Result.Companion;
                                long nanoTime = System.nanoTime();
                                ((u) i).e.run();
                                j2 = System.nanoTime() - nanoTime;
                                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                            }
                            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                            if (m776exceptionOrNullimpl != null) {
                                d0.c.e(cacheId + " create Runnable fail:" + Log.getStackTraceString(m776exceptionOrNullimpl), new Object[0]);
                            }
                        }
                        if (i.a == null) {
                            Pair<MMKV, Long> m = d0.b.m(cacheId, l);
                            MMKV component1 = m.component1();
                            j = m.component2().longValue();
                            i.a = component1;
                            d0.c.i("MmkvCacheRunnable create real mmkv fallback :" + cacheId, new Object[0]);
                        } else {
                            j = j2;
                        }
                        v e = y.a.e();
                        if (e != null) {
                            MMKV mmkv = i.a;
                            Intrinsics.checkNotNull(mmkv);
                            e.b(cacheId, mmkv, l, j);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            if (i.a != null) {
                i.b = SystemClock.elapsedRealtime();
            }
            return i.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Pair h(String str, boolean z) {
            return d0.b.m(str, z);
        }

        private final Pair<MMKV, Long> m(String str, boolean z) {
            try {
                return new Pair<>(f0.a(str, z), Long.valueOf(System.nanoTime() - System.nanoTime()));
            } catch (Throwable th) {
                d0.c.e("MMKV may be not initialized and try to initialize, error = " + th, new Object[0]);
                Context context = NsBaseMmkvDependImpl.INSTANCE.getContext();
                Intrinsics.checkNotNull(context);
                y.i(context);
                return new Pair<>(f0.a(str, z), Long.valueOf(System.nanoTime() - System.nanoTime()));
            }
        }

        public final MMKV d(String cacheId, boolean z) {
            Object m773constructorimpl;
            long j;
            Intrinsics.checkNotNullParameter(cacheId, "cacheId");
            e0 g = g(cacheId);
            if (z && g.a == null) {
                synchronized (g) {
                    if (g.a == null) {
                        boolean l = d0.b.l(cacheId);
                        long j2 = 0;
                        if (g instanceof t) {
                            try {
                                Result.Companion companion = Result.Companion;
                                Pair<MMKV, Long> pair = ((t) g).e.get();
                                g.a = pair.getFirst();
                                j2 = pair.getSecond().longValue();
                                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                            }
                            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                            if (m776exceptionOrNullimpl != null) {
                                d0.c.e(cacheId + " get future fail:" + Log.getStackTraceString(m776exceptionOrNullimpl), new Object[0]);
                            }
                        }
                        if (g.a == null) {
                            Pair<MMKV, Long> m = d0.b.m(cacheId, l);
                            MMKV component1 = m.component1();
                            j = m.component2().longValue();
                            g.a = component1;
                            d0.c.i("create real mmkv fallback :" + cacheId, new Object[0]);
                        } else {
                            j = j2;
                        }
                        v e = y.a.e();
                        if (e != null) {
                            MMKV mmkv = g.a;
                            Intrinsics.checkNotNull(mmkv);
                            e.b(cacheId, mmkv, l, j);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            if (g.a != null) {
                g.b = SystemClock.elapsedRealtime();
            }
            return g.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void j(String str, boolean z, Ref$ObjectRef ref$ObjectRef) {
            MMKV component1 = d0.b.m(str, z).component1();
            d0.c.i("create real mmkv in Runnable :" + str, new Object[0]);
            T t = ref$ObjectRef.element;
            Intrinsics.checkNotNull(t);
            ((e0) t).a = component1;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        j().edit().apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        SharedPreferences.Editor edit = j().edit();
        edit.clear();
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return j().edit().commit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("use getAllKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public final List<String> k() {
        return y.a.d(j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler i() {
        HandlerThread handlerThread = new HandlerThread("MmkvAutoCloseWrapper");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExecutorService o() {
        int mmkvThreadExecutorType = NsBaseMmkvDependImpl.INSTANCE.mmkvThreadExecutorType();
        if (mmkvThreadExecutorType != 1) {
            if (mmkvThreadExecutorType != 2) {
                return TTExecutors.getIOThreadPool();
            }
            return Executors.newSingleThreadScheduledExecutor();
        }
        int i2 = e;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static {
        int coerceAtLeast;
        Lazy<ExecutorService> lazy;
        Lazy<Handler> lazy2;
        Covode.recordClassIndex(611476);
        b bVar = new b(null);
        b = bVar;
        LogHelper logHelper = new LogHelper("MmkvAutoCloseWrapper");
        c = logHelper;
        d = Collections.synchronizedMap(new HashMap());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() * 2, 6);
        e = coerceAtLeast;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: er4.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ExecutorService o;
                o = d0.o();
                return o;
            }
        });
        f = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: er4.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler i2;
                i2 = d0.i();
                return i2;
            }
        });
        h = lazy2;
        a aVar = new a();
        i = aVar;
        if (!NsBaseMmkvDependImpl.INSTANCE.mmkvAutoCloseDisable()) {
            bVar.f().postDelayed(aVar, 15000L);
        } else {
            logHelper.i("auto close disable", new Object[0]);
        }
    }

    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d0.g == null) {
                d0.g = new c(0, 0, 0, 7, null);
                d0.c.i("config:" + d0.g, new Object[0]);
            }
            c cVar = d0.g;
            Intrinsics.checkNotNull(cVar);
            if (cVar.a == 0) {
                d0.c.i("auto close not enable", new Object[0]);
                return;
            }
            c cVar2 = d0.g;
            Intrinsics.checkNotNull(cVar2);
            int i = cVar2.b;
            Map map = d0.d;
            Intrinsics.checkNotNullExpressionValue(map, "access$getMmkvCacheMap$cp(...)");
            synchronized (map) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Map map2 = d0.d;
                Intrinsics.checkNotNullExpressionValue(map2, "access$getMmkvCacheMap$cp(...)");
                Iterator it2 = map2.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    String str = (String) entry.getKey();
                    e0 e0Var = (e0) entry.getValue();
                    if (e0Var.c) {
                        break;
                    }
                    if (elapsedRealtime - e0Var.b >= i) {
                        MMKV mmkv = e0Var.a;
                        if (mmkv != null) {
                            mmkv.close();
                        }
                        v e = y.a.e();
                        if (e != null) {
                            Intrinsics.checkNotNull(str);
                            e.a(str);
                        }
                        it2.remove();
                        d0.c.i("auto close mmkv:" + str + ", cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime), new Object[0]);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            Handler f = d0.b.f();
            Intrinsics.checkNotNull(d0.g);
            f.postDelayed(this, r1.c);
        }
    }

    private final MMKV j() {
        NsBaseMmkvDependImpl nsBaseMmkvDependImpl = NsBaseMmkvDependImpl.INSTANCE;
        if (nsBaseMmkvDependImpl.getContext() != null && nsBaseMmkvDependImpl.mmkvLockOptEnable()) {
            if (nsBaseMmkvDependImpl.mmkvAsyncOptEnable()) {
                MMKV d2 = b.d(this.a, true);
                Intrinsics.checkNotNull(d2);
                return d2;
            }
            MMKV e2 = b.e(this.a);
            Intrinsics.checkNotNull(e2);
            return e2;
        }
        Map<String, e0> mmkvCacheMap = d;
        e0 e0Var = mmkvCacheMap.get(this.a);
        if (e0Var == null) {
            c.i("create mmkv:" + this.a, new Object[0]);
            boolean n = n(this.a);
            long nanoTime = System.nanoTime();
            MMKV a2 = f0.a(this.a, n);
            long nanoTime2 = System.nanoTime() - nanoTime;
            e0Var = new e0(a2, 0L, !n, 2, null);
            Intrinsics.checkNotNullExpressionValue(mmkvCacheMap, "mmkvCacheMap");
            mmkvCacheMap.put(this.a, e0Var);
            v e3 = y.a.e();
            if (e3 != null) {
                String str = this.a;
                MMKV mmkv = e0Var.a;
                Intrinsics.checkNotNull(mmkv);
                e3.b(str, mmkv, n, nanoTime2);
            }
        }
        e0Var.b = SystemClock.elapsedRealtime();
        MMKV mmkv2 = e0Var.a;
        Intrinsics.checkNotNull(mmkv2);
        return mmkv2;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        j().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        j().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return j().contains(str);
    }

    public final int m(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return j().getValueActualSize(key);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        SharedPreferences.Editor edit = j().edit();
        edit.remove(str);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    public final boolean n(String cacheId) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        if (TextUtils.isEmpty(cacheId)) {
            return false;
        }
        return NsBaseMmkvDependImpl.INSTANCE.getMultiProcessIds().contains(cacheId);
    }

    public d0(String cacheId) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        this.a = cacheId;
        NsBaseMmkvDependImpl nsBaseMmkvDependImpl = NsBaseMmkvDependImpl.INSTANCE;
        if (nsBaseMmkvDependImpl.getContext() != null && nsBaseMmkvDependImpl.mmkvLockOptEnable()) {
            if (nsBaseMmkvDependImpl.mmkvAsyncOptEnable()) {
                b.d(cacheId, false);
                return;
            } else {
                b.e(cacheId);
                return;
            }
        }
        j();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return j().getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return j().getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return j().getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return j().getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return j().getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return j().getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = j().edit();
        edit.putBoolean(str, z);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        SharedPreferences.Editor edit = j().edit();
        edit.putFloat(str, f2);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        SharedPreferences.Editor edit = j().edit();
        edit.putInt(str, i2);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        SharedPreferences.Editor edit = j().edit();
        edit.putLong(str, j);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        SharedPreferences.Editor edit = j().edit();
        edit.putString(str, str2);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor edit = j().edit();
        edit.putStringSet(str, set);
        Intrinsics.checkNotNull(edit);
        return edit;
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;

        static {
            Covode.recordClassIndex(611478);
        }

        public c() {
            this(0, 0, 0, 7, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public String toString() {
            return "MmkvAutoCloseConfig(enable=" + this.a + ", clearLimit=" + this.b + ", delayGap=" + this.c + ')';
        }

        public c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public /* synthetic */ c(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? 30000 : i2, (i4 & 4) != 0 ? 5000 : i3);
        }
    }
}

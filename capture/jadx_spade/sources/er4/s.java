package er4;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.StreamUtils;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.local.file.JsonCache;
import com.dragon.read.util.FileUtils;
import com.dragon.read.util.f7;
import com.ss.android.ugc.bytex.taskmonitor.proxy.CompletableDelegate;
import com.ss.android.ugc.bytex.taskmonitor.proxy.SingleDelegate;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class s {
    private static final LogHelper a;

    class e implements Runnable {
        final /* synthetic */ RuntimeException a;

        @Override // java.lang.Runnable
        public void run() {
            throw this.a;
        }

        e(RuntimeException runtimeException) {
            this.a = runtimeException;
        }
    }

    static {
        Covode.recordClassIndex(611469);
        a = new LogHelper("FileCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        if (AppUtils.isOfficialBuild() || Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException("file operation in main thread is forbidden!");
        ThreadUtils.postInForeground(new e(runtimeException));
        throw runtimeException;
    }

    class a implements Action {
        final /* synthetic */ rr4.e a;

        @Override // io.reactivex.functions.Action
        public void run() {
            s.d();
            f7 f7Var = new f7();
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(s.f(this.a.getUserId(), this.a.getDirName()), this.a.fileName);
            String json = JSONUtils.toJson(new JsonCache(JSONUtils.toJson(this.a.a), this.a.b));
            StreamUtils.save(json, polarisFileWrapper);
            s.a.i("save json cacheFile=%s,info=%s, jsonCache=%s, time=%s", new Object[]{polarisFileWrapper, this.a, json, Long.valueOf(f7Var.a())});
        }

        a(rr4.e eVar) {
            this.a = eVar;
        }
    }

    class d implements Action {
        final /* synthetic */ rr4.c a;

        @Override // io.reactivex.functions.Action
        public void run() {
            s.d();
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(s.f(this.a.getUserId(), this.a.getDirName()), this.a.fileName);
            s.a.i("remove json from cacheDir=%s, key=%s,exist[%s],delete[%s] ", new Object[]{polarisFileWrapper, this.a, Boolean.valueOf(polarisFileWrapper.exists()), Boolean.valueOf(polarisFileWrapper.delete())});
        }

        d(rr4.c cVar) {
            this.a = cVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> implements Callable<rr4.b<T>> {
        final /* synthetic */ rr4.d a;

        @Override // java.util.concurrent.Callable
        public rr4.b<T> call() {
            boolean z;
            s.d();
            f7 f7Var = new f7();
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(s.f(this.a.getUserId(), this.a.getDirName()), this.a.fileName);
            JsonCache jsonCache = (JsonCache) JSONUtils.getSafeObject(StreamUtils.read(polarisFileWrapper), JsonCache.class);
            Object obj = null;
            if (jsonCache == null) {
                s.a.i("get json from cacheFile=%s, cacheKey = %s, value=%s, time=%s", new Object[]{polarisFileWrapper, this.a, null, Long.valueOf(f7Var.a())});
                return null;
            }
            if (jsonCache.survivalSeconds > 0 && System.currentTimeMillis() - polarisFileWrapper.lastModified() > jsonCache.survivalSeconds * 1000) {
                z = true;
            } else {
                z = false;
            }
            if (z && !this.a.useExpiredData) {
                polarisFileWrapper.delete();
            } else {
                obj = JSONUtils.fromJson(jsonCache.json, JSONUtils.getSuperclassTypeParameter(this.a.getClass()));
            }
            s.a.i("get json from cacheFile=%s, cacheKey = %s, value=%s , jsonCache = %s, isExpired =%s, time=%s", new Object[]{polarisFileWrapper, this.a, obj, jsonCache, Boolean.valueOf(z), Long.valueOf(f7Var.a())});
            return new rr4.b<>(obj, polarisFileWrapper);
        }

        c(rr4.d dVar) {
            this.a = dVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements Function<Throwable, rr4.b<T>> {
        final /* synthetic */ rr4.d a;

        b(rr4.d dVar) {
            this.a = dVar;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rr4.b<T> apply(Throwable th) {
            s.a.e("fail to get json onErrorReturn  key=%s , error = %s", new Object[]{this.a, Log.getStackTraceString(th)});
            return new rr4.b<>(null, null);
        }
    }

    public static Completable h(rr4.c cVar) {
        return CompletableDelegate.fromAction(new d(cVar));
    }

    public static Completable j(rr4.e eVar) {
        return CompletableDelegate.fromAction(new a(eVar));
    }

    public static <T> Single<rr4.b<T>> e(rr4.d<T> dVar) {
        return SingleDelegate.fromCallable(new c(dVar)).onErrorReturn(new b(dVar));
    }

    public static File g(String str) {
        return FileUtils.createDir(new PolarisFileWrapper(AppUtils.context().getFilesDir(), str), false);
    }

    public static void i(rr4.e eVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            j(eVar).subscribeOn(Schedulers.io()).subscribe();
        } else {
            j(eVar).subscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = AppUtils.getUserId();
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "public_dir";
        }
        return FileUtils.createDir(new PolarisFileWrapper(g(str), "prefix_public_" + str2), false);
    }
}

package com.ss.videoarch.live.ttquic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadManager {
    private static boolean mInitialized;
    private Context mContext;
    private c mCurrentTask;
    private int mEnableCancelAll;
    private Handler mEventHandler;
    private HandlerThread mEventThread;
    private final Object mListenerLock;
    private final HashMap<Integer, PreloadListener> mListeners;
    private int mMpdPreloadMinSec;
    private long mNativePtr;
    private int mOptCancelTask;
    private int mPlayCacheMaxAgeSec;
    private final Stack<Integer> mPlayerIds;
    private int mPreloadCacheMaxAgeSec;
    private final ThreadPoolExecutor mPreloadExecutor;
    private final Set<String> mPreloadList;
    private String mQuicScfgPath;
    private int mRequestOpenTimeout;
    private int mRequestReadTimeout;
    private final Object mTaskLock;
    private final LruCache<String, c> mTasks;

    private native int native_cancel(long j, String str);

    private native int native_destroy(long j);

    private native long native_init(TTEngineParam tTEngineParam, Handler handler);

    /* JADX INFO: Access modifiers changed from: private */
    public native int native_preload(long j, TTRequestParam tTRequestParam);

    private static class b {
        private static final PreloadManager a;

        static {
            Covode.recordClassIndex(652884);
            a = new PreloadManager(null);
        }
    }

    public static PreloadManager getInstance() {
        return b.a;
    }

    static {
        Covode.recordClassIndex(652883);
        mInitialized = false;
    }

    private void destroyEvent() {
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mEventHandler = null;
        }
        HandlerThread handlerThread = this.mEventThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mEventThread = null;
        }
    }

    public void destroy() {
        long j = this.mNativePtr;
        if (j != 0) {
            native_destroy(j);
            this.mNativePtr = 0L;
        }
        destroyEvent();
        synchronized (this.mListenerLock) {
            this.mListeners.clear();
        }
        mInitialized = false;
    }

    public int getCurrentTaskState() {
        int i;
        synchronized (this.mTaskLock) {
            c cVar = this.mCurrentTask;
            if (cVar != null) {
                i = cVar.c.get();
            } else {
                i = 0;
            }
        }
        return i;
    }

    private int initEvent() {
        try {
            HandlerThread handlerThread = new HandlerThread("tt_preload_event");
            this.mEventThread = handlerThread;
            handlerThread.start();
            this.mEventHandler = new HandlerDelegate(this.mEventThread.getLooper(), new a());
            return 0;
        } catch (Exception e2) {
            Log.w("tt_preload", "initEvent : " + e2);
            return -4003;
        }
    }

    public int getActivePlayer() {
        try {
            if (this.mPlayerIds.isEmpty()) {
                return 0;
            }
            return this.mPlayerIds.peek().intValue();
        } catch (Exception e2) {
            Log.w("tt_preload", "getActivePlayer failed : " + e2.toString());
            return 0;
        }
    }

    private class c implements Runnable {
        String a;
        int b;
        AtomicInteger c;
        long d;
        long e;
        int f;
        int g;
        TTRequestParam h;
        Bundle i;
        CountDownLatch j;

        static {
            Covode.recordClassIndex(652885);
        }

        @Override // java.lang.Runnable
        public void run() {
            int native_preload;
            String str;
            if (this.c.get() != 1 && this.c.get() != 6) {
                str = String.format("PreloadTask state invalid : %d", Integer.valueOf(this.c.get()));
                native_preload = -3007;
            } else {
                PreloadManager preloadManager = PreloadManager.this;
                native_preload = preloadManager.native_preload(preloadManager.mNativePtr, this.h);
                if (native_preload != 0) {
                    str = "invoke native_preload error";
                } else {
                    try {
                        this.j.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    str = "";
                }
            }
            if (native_preload != 0) {
                TTEvent tTEvent = new TTEvent();
                tTEvent.what = 2;
                tTEvent.url = this.a;
                tTEvent.error = str;
                tTEvent.code = native_preload;
                Message obtainMessage = PreloadManager.this.mEventHandler.obtainMessage();
                obtainMessage.what = tTEvent.what;
                obtainMessage.obj = tTEvent;
                PreloadManager.this.mEventHandler.sendMessage(obtainMessage);
            }
        }

        public String toString() {
            return "PreloadTask{url='" + this.a + "', playerId=" + this.b + ", state=" + this.c + ", cachedTime=" + this.d + ", code=" + this.f + ", mode=" + this.g + ", requestParam=" + this.h + ", scheduleTime=" + this.e + '}';
        }

        private c() {
            this.a = "";
            this.b = -1;
            this.c = new AtomicInteger(0);
            this.d = -1L;
            this.e = -1L;
            this.f = 0;
            this.g = -1;
            this.j = new CountDownLatch(1);
        }

        /* synthetic */ c(PreloadManager preloadManager, a aVar) {
            this();
        }
    }

    private PreloadManager() {
        this.mNativePtr = 0L;
        a aVar = null;
        this.mEventThread = null;
        this.mEventHandler = null;
        this.mPreloadCacheMaxAgeSec = 600;
        this.mPlayCacheMaxAgeSec = 600;
        this.mRequestOpenTimeout = 5000;
        this.mRequestReadTimeout = 5000;
        this.mEnableCancelAll = 1;
        this.mMpdPreloadMinSec = -1;
        this.mOptCancelTask = 0;
        this.mListenerLock = new Object();
        this.mListeners = new HashMap<>();
        this.mPreloadList = new HashSet();
        this.mTasks = new LruCache<>(64);
        this.mTaskLock = new Object();
        this.mCurrentTask = null;
        this.mPlayerIds = new Stack<>();
        this.mPreloadExecutor = new PThreadPoolExecutorDelegate(1, 1, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue(64, new e(aVar)), new d(aVar));
    }

    private int initContext() {
        try {
            Class q = l3.a.q("com.ss.videoarch.live.ttquic.ContextUtils");
            if (q != null) {
                Method method = q.getMethod("initApplicationContext", Context.class);
                method.setAccessible(true);
                method.invoke(null, this.mContext.getApplicationContext());
            }
            Class q2 = l3.a.q("com.ss.videoarch.live.ttquic.JNIUtils");
            if (q2 != null) {
                Method method2 = q2.getMethod("setClassLoader", ClassLoader.class);
                method2.setAccessible(true);
                method2.invoke(null, this.mContext.getClassLoader());
            }
            return 0;
        } catch (Throwable th) {
            Log.w("tt_preload", "initContext : " + th);
            return -4002;
        }
    }

    public int cancelAll() {
        Log.d("tt_preload", "invoke PreloadManager cancelAll");
        if (this.mEnableCancelAll == 1 && this.mNativePtr != 0) {
            String str = "";
            synchronized (this.mTaskLock) {
                c cVar = this.mCurrentTask;
                if (cVar != null) {
                    cVar.c.set(3);
                    str = this.mCurrentTask.a;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                Log.d("tt_preload", "cancel all task");
                native_cancel(this.mNativePtr, str);
                return 0;
            }
            return 0;
        }
        return -1;
    }

    private int loadLibrary() {
        try {
            com.ss.videoarch.live.ttquic.a.a("ttffmpeg");
            try {
                com.ss.videoarch.live.ttquic.a.a("ffmpeg_dashdec");
                try {
                    com.ss.videoarch.live.ttquic.a.a("ttmcmaf");
                    try {
                        com.ss.videoarch.live.ttquic.a.a("vcbasekit");
                        try {
                            com.ss.videoarch.live.ttquic.a.a("ttquic");
                            try {
                                com.ss.videoarch.live.ttquic.a.a("ttpreload");
                                return 0;
                            } catch (Throwable th) {
                                Log.w("tt_preload", "ttpreload lib is load failed : " + th);
                                return -1004;
                            }
                        } catch (Throwable th2) {
                            Log.w("tt_preload", "ttquic lib is load failed : " + th2);
                            return -1001;
                        }
                    } catch (Throwable th3) {
                        Log.w("tt_preload", "vcbasekit lib is load failed : " + th3);
                        return -1006;
                    }
                } catch (Throwable th4) {
                    Log.w("tt_preload", "ttmcmaf lib is load failed : " + th4);
                    return -1002;
                }
            } catch (Throwable th5) {
                Log.w("tt_preload", "ffmpeg_dashdec lib is load failed : " + th5);
                return -1005;
            }
        } catch (Throwable th6) {
            Log.w("tt_preload", "ttffmpeg lib is load failed : " + th6);
            return -1003;
        }
    }

    /* synthetic */ PreloadManager(a aVar) {
        this();
    }

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar;
            TTEvent tTEvent = (TTEvent) message.obj;
            PreloadManager.this.updateTaskState(tTEvent);
            if (!TextUtils.isEmpty(tTEvent.url) && (cVar = (c) PreloadManager.this.mTasks.get(PreloadManager.this.cacheKey(tTEvent.url))) != null) {
                tTEvent.bundle = cVar.i;
                tTEvent.mode = cVar.g;
                synchronized (PreloadManager.this.mListenerLock) {
                    PreloadListener preloadListener = (PreloadListener) PreloadManager.this.mListeners.get(Integer.valueOf(cVar.b));
                    if (preloadListener != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("preload_event", tTEvent.what);
                        bundle.putString("preload_url", tTEvent.url);
                        bundle.putString("preload_error", tTEvent.error);
                        bundle.putInt("preload_code", tTEvent.code);
                        bundle.putInt("preload_sub_code", tTEvent.subCode);
                        bundle.putInt("preload_num", tTEvent.preloadNum);
                        bundle.putInt("video_cached_num", tTEvent.videoCachedNum);
                        bundle.putInt("audio_cached_num", tTEvent.audioCachedNum);
                        bundle.putInt("video_init_section_cached", tTEvent.videoInitSectionCached);
                        bundle.putInt("audio_init_section_cached", tTEvent.audioInitSectionCached);
                        bundle.putLong("cache_read_bytes", tTEvent.cacheReadBytes);
                        bundle.putLong("cache_write_bytes", tTEvent.cacheWriteBytes);
                        bundle.putInt("cache_mode", tTEvent.cacheMode);
                        bundle.putInt("cache_frame_count", tTEvent.cacheFrameCount);
                        bundle.putLong("cache_duration", tTEvent.cacheDuration);
                        bundle.putInt("cache_size", tTEvent.cacheSize);
                        bundle.putLong("cancel_cost_time", tTEvent.cancelCostTime);
                        bundle.putInt("opt_cancel_task", tTEvent.optCancelTask);
                        bundle.putInt("mode", tTEvent.mode);
                        bundle.putBundle("ext_info", tTEvent.bundle);
                        preloadListener.onPreloadEvent(tTEvent.what, bundle);
                    }
                }
                return true;
            }
            return true;
        }
    }

    private static class d implements ThreadFactory {
        static {
            Covode.recordClassIndex(652886);
        }

        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "PreloadExecutor");
        }
    }

    private static class e implements Comparator<c> {
        static {
            Covode.recordClassIndex(652887);
        }

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            long j;
            long j2;
            int i = cVar.g;
            int i2 = cVar2.g;
            if (i == i2) {
                j = cVar.e;
                j2 = cVar2.e;
            } else {
                if (i == 1) {
                    return -1;
                }
                if (i2 == 1) {
                    return 1;
                }
                j = cVar.e;
                j2 = cVar2.e;
            }
            return (int) (j - j2);
        }
    }

    public void attachPlayer(int i) {
        this.mPlayerIds.push(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cacheKey(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.clearQuery();
        return buildUpon.build().getPath();
    }

    public void removeListener(int i) {
        synchronized (this.mListenerLock) {
            this.mListeners.remove(Integer.valueOf(i));
        }
    }

    public void detachPlayer(int i) {
        try {
            this.mPlayerIds.remove(Integer.valueOf(i));
        } catch (Exception e2) {
            Log.w("tt_preload", "detach player failed : " + e2.toString());
        }
    }

    public void recordResource(String str) {
        this.mPreloadList.add(str);
        Log.d("tt_preload", "PreloadList size = " + this.mPreloadList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTaskState(TTEvent tTEvent) {
        c cVar;
        if (tTEvent.what == 0 || TextUtils.isEmpty(tTEvent.url) || (cVar = this.mTasks.get(cacheKey(tTEvent.url))) == null) {
            return;
        }
        synchronized (this.mTaskLock) {
            this.mCurrentTask = null;
        }
        int i = tTEvent.what;
        if (1 == i) {
            cVar.c.set(4);
            cVar.d = System.currentTimeMillis();
            cVar.j.countDown();
        } else if (2 == i) {
            cVar.c.set(5);
            cVar.f = tTEvent.code;
            cVar.j.countDown();
        }
    }

    public int cancelAll(int i) {
        Log.d("tt_preload", "cancelAll : [new playerId = " + i + "]");
        if (this.mEnableCancelAll == 1 && this.mNativePtr != 0 && this.mCurrentTask != null) {
            Log.d("tt_preload", "cancel all task");
            this.mCurrentTask.c.set(3);
            native_cancel(this.mNativePtr, this.mCurrentTask.a);
            return 0;
        }
        return -1;
    }

    public void addListener(int i, Object obj) {
        synchronized (this.mListenerLock) {
            if (obj instanceof PreloadListener) {
                this.mListeners.put(Integer.valueOf(i), (PreloadListener) obj);
            }
        }
    }

    public int cancel(int i, String str) {
        c cVar = this.mTasks.get(cacheKey(str));
        if (cVar == null) {
            return -3002;
        }
        if (cVar.b != i) {
            return -3003;
        }
        if (1 != cVar.c.get()) {
            return -3004;
        }
        cVar.c.set(3);
        native_cancel(this.mNativePtr, str);
        return 0;
    }

    public int init(Context context, String str) {
        if (mInitialized) {
            return 0;
        }
        this.mContext = context.getApplicationContext();
        this.mQuicScfgPath = context.getFilesDir().getAbsolutePath() + "/pullstream.scfg";
        int loadLibrary = loadLibrary();
        if (loadLibrary != 0) {
            return loadLibrary;
        }
        TTEngineParam tTEngineParam = new TTEngineParam();
        int parseEngineParam = parseEngineParam(str, tTEngineParam);
        if (parseEngineParam != 0) {
            return parseEngineParam;
        }
        int initContext = initContext();
        if (initContext != 0) {
            return initContext;
        }
        int initEvent = initEvent();
        if (initEvent != 0) {
            return initEvent;
        }
        long native_init = native_init(tTEngineParam, this.mEventHandler);
        this.mNativePtr = native_init;
        if (native_init == 0) {
            return -4000;
        }
        mInitialized = true;
        return 0;
    }

    public Bundle getPreloadInfo(String str, int i) {
        int i2;
        Bundle bundle = new Bundle();
        long j = 0;
        int i3 = -1;
        String str2 = "";
        if (i != 0 && 1 != i) {
            i2 = -2;
        } else {
            String cacheKey = cacheKey(str);
            c cVar = this.mTasks.get(cacheKey);
            if (cVar == null) {
                if (this.mPreloadList.contains(cacheKey)) {
                    i2 = -3002;
                } else {
                    i2 = -3009;
                }
            } else if (4 != cVar.c.get() && 6 != cVar.c.get()) {
                if (1 == cVar.c.get()) {
                    i2 = -3001;
                } else if (5 == cVar.c.get()) {
                    i2 = cVar.f;
                } else {
                    i2 = -999;
                }
            } else if (cVar.d > 0) {
                j = System.currentTimeMillis() - cVar.d;
                if (j < this.mPlayCacheMaxAgeSec * 1000) {
                    int i4 = cVar.g;
                    if (i4 == -1) {
                        i2 = -3005;
                    } else {
                        int i5 = 0;
                        if (i4 == 1) {
                            if (j >= cVar.h.cmafPreloadMPDExpMs) {
                                i5 = -8002;
                            }
                            i2 = i5;
                        } else {
                            str2 = cVar.i.getString("resolution", "");
                            i2 = 0;
                        }
                        i3 = cVar.g;
                    }
                } else {
                    i2 = -8000;
                }
            } else {
                i2 = -8001;
            }
        }
        bundle.putInt("preload_result", i2);
        bundle.putLong("time_delta", j);
        bundle.putInt("preload_mode", i3);
        bundle.putString("preload_resolution", str2);
        return bundle;
    }

    private int parseEngineParam(String str, TTEngineParam tTEngineParam) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cacheMaxSize")) {
                tTEngineParam.cacheMaxSize = jSONObject.optInt("cacheMaxSize");
            }
            if (jSONObject.has("PreloadCacheMaxAge")) {
                this.mPreloadCacheMaxAgeSec = jSONObject.optInt("PreloadCacheMaxAge");
            }
            if (jSONObject.has("PlayCacheMaxAge")) {
                this.mPlayCacheMaxAgeSec = jSONObject.optInt("PlayCacheMaxAge");
            }
            if (jSONObject.has("openTimeout")) {
                this.mRequestOpenTimeout = jSONObject.optInt("openTimeout");
            }
            if (jSONObject.has("readTimeout")) {
                this.mRequestReadTimeout = jSONObject.optInt("readTimeout");
            }
            if (jSONObject.has("EnableCancelAll")) {
                this.mEnableCancelAll = jSONObject.optInt("EnableCancelAll");
            }
            if (jSONObject.has("MpdPreloadMinSec")) {
                this.mMpdPreloadMinSec = jSONObject.optInt("MpdPreloadMinSec");
            }
            if (jSONObject.has("optCancelTask")) {
                this.mOptCancelTask = jSONObject.optInt("optCancelTask");
            }
            if (tTEngineParam.cacheMaxSize <= 0) {
                tTEngineParam.cacheMaxSize = 209715200;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.mContext.getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("live_preload");
            tTEngineParam.cachePath = sb.toString();
            tTEngineParam.flvCachePath = tTEngineParam.cachePath + str2 + "flv";
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(tTEngineParam.cachePath);
            if (!polarisFileWrapper.exists() && !polarisFileWrapper.mkdirs()) {
                Log.w("tt_preload", "create live preload dir failed.");
                return -1;
            }
            PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(tTEngineParam.flvCachePath);
            if (!polarisFileWrapper2.exists() && !polarisFileWrapper2.mkdirs()) {
                Log.w("tt_preload", "create live flv preload dir failed.");
                return -1;
            }
            if (this.mPreloadCacheMaxAgeSec <= 0) {
                this.mPreloadCacheMaxAgeSec = 600;
            }
            if (this.mPlayCacheMaxAgeSec <= 0) {
                this.mPlayCacheMaxAgeSec = 600;
            }
            if (this.mRequestOpenTimeout <= 0) {
                this.mRequestOpenTimeout = 5000;
            }
            if (this.mRequestReadTimeout <= 0) {
                this.mRequestReadTimeout = 5000;
                return 0;
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011d A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0165 A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0173 A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0181 A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018f A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019f A[Catch: Exception -> 0x01b8, TryCatch #1 {Exception -> 0x01b8, blocks: (B:50:0x010e, B:51:0x0115, B:53:0x011d, B:55:0x012c, B:56:0x0133, B:58:0x013b, B:59:0x0142, B:61:0x014a, B:62:0x0151, B:64:0x0159, B:65:0x015d, B:67:0x0165, B:68:0x016b, B:70:0x0173, B:71:0x0179, B:73:0x0181, B:74:0x0187, B:76:0x018f, B:77:0x0197, B:79:0x019f, B:80:0x01a7), top: B:49:0x010e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseSdkParams(java.lang.String r23, java.lang.String r24, com.ss.videoarch.live.ttquic.TTRequestParam r25) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.ttquic.PreloadManager.parseSdkParams(java.lang.String, java.lang.String, com.ss.videoarch.live.ttquic.TTRequestParam):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
    
        if (6 != r14) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (1 == r14) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int preload(int r21, java.lang.String r22, java.lang.String r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.ttquic.PreloadManager.preload(int, java.lang.String, java.lang.String, android.os.Bundle):int");
    }
}

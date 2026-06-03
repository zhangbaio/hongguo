package com.ss.videoarch.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.videoarch.strategy.dataCenter.config.PlatformDataFetcher;
import com.ss.videoarch.strategy.dataCenter.strategyData.DataWarehouse;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.c;
import com.ss.videoarch.strategy.strategy.mpdPreload.MpdPreloadManager;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnDataHandle;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.JniTask;
import com.ss.videoarch.strategy.utils.TTClassLoad;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LiveStrategyManager extends NativeObject {
    private static List<String> mLibraryList;
    public static pj6.a mLiveIOEngine;
    public static long mLoadLibraryTime;
    private static boolean mLoadSoSuccess;
    public static com.ss.videoarch.strategy.strategy.smartStrategy.k mSRPredictEngine;
    private static long mStartStrategyTime;
    private static volatile LiveStrategyManager sInstance;
    public Intent mBatteryIntent;
    private Handler mChildHandler;
    public Context mContext;
    public String mDeviceId;
    private boolean mDidLocalDNS;
    private com.ss.videoarch.strategy.a mEngine;
    public boolean mFirstStart;
    private boolean mFirstUpdate;
    private com.ss.videoarch.strategy.b mFunctionStartPTYInit;
    public Handler mHandler;
    public Map<Integer, IAppInfoBundle> mHashCodeToBundleMap;
    public JSONObject mInitInfo;
    private final LSPreconnManager.d mLSPreconnListener;
    private String mLatestSessionId;
    public Map<String, IAppInfoBundle> mListenerMap;
    private DnsOptimizer.m mOnDoPreconnectListener;
    private DnsOptimizer.n mOnParseDnsCompletionListener;
    private Boolean mPTYSetUpAlready;
    private Boolean mRetryFlag;
    private ThreadPoolExecutor mThreadPool;
    private final BroadcastReceiver networkReceiver;
    public long mTTLMs = 300000;
    public int mReceiveMessage = 0;
    public long mLastEndTS = 0;
    public boolean mIsRunning = false;
    private c.d mSettingsListener = null;

    private native void nativeCreate();

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeExecuteCommand(int i2, int i3, int i4, String str);

    private native void nativeSetNextRoomInfo(String str, int i2, long j2);

    private native void nativeSetStreamInfo(String str);

    private native void nativeStart();

    private native void nativeStop();

    private native void nativeStopSession(JSONObject jSONObject);

    public <T> T getInfo(String str, T t) {
        return null;
    }

    public void setFunctionStartPTYInit(com.ss.videoarch.strategy.b bVar) {
    }

    class i extends HandlerDelegate {

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                LiveStrategyManager.access$100(LiveStrategyManager.this);
            }

            a() {
            }
        }

        class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a && lj6.a.m().r.e.mEnableUsePTY == 1 && PitayaWrapper.f().d()) {
                    com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a = false;
                    com.ss.videoarch.strategy.strategy.smartStrategy.e.a().runStrategy();
                    com.ss.videoarch.strategy.strategy.smartStrategy.e.a().b(-1L);
                }
            }

            b() {
            }
        }

        public void handleMessage(Message message) {
            if (message != null) {
                switch (message.what) {
                    case 1024:
                        LiveStrategyManager.this.mReceiveMessage++;
                        if (lj6.a.m().r.e.mEnableDnsOptimizer == 1 && lj6.a.m().r.e.mNodeLocalDnsRequestInterval != 0 && LiveStrategyManager.this.mReceiveMessage % lj6.a.m().r.e.mNodeLocalDnsRequestInterval == 0) {
                            Set<String> g = TopNHostStrategy.f().g(TopNHostStrategy.f().runStrategy());
                            if (g != null && g.size() > 0) {
                                DnsOptimizer.O().s = g;
                            }
                            DnsOptimizer.O().U(LiveStrategyManager.this.mOnParseDnsCompletionListener, null);
                            break;
                        } else {
                            LSNetworkManager.inst().settingsApi().e(null, false);
                            break;
                        }
                    case 1026:
                        LiveStrategyManager.this.mThreadPool.submit(new a());
                        break;
                    case 1027:
                        TypePlayFeaturesCollector.h().f();
                        Log.d("LiveStrategyManager", "clock MSG_WHAT_RT_FEATURES_CLOCK:" + lj6.a.m().r.e.mEnableCollectTime);
                        LiveStrategyManager.this.mHandler.removeMessages(1027);
                        if (lj6.a.m().r.e.mEnableCollectTime != -1) {
                            LiveStrategyManager.this.mHandler.sendEmptyMessageDelayed(1027, lj6.a.m().r.e.mEnableCollectTime);
                            break;
                        }
                        break;
                    case 1028:
                        LiveStrategyManager.this.mThreadPool.submit(new b());
                        break;
                    case 1029:
                        if (lj6.a.m().r.e.mEnableUpdateCharToLiveIO == 1) {
                            Log.d("LiveStrategyManager", "clock - MSG_WHAT_CHAR_FETCH_CLOCK: " + lj6.a.m().r.e.mUpdateCharToLiveIOTimer);
                            com.ss.videoarch.strategy.strategy.smartStrategy.b.a().runStrategy();
                        }
                        LiveStrategyManager.this.mHandler.removeMessages(1029);
                        if (lj6.a.m().r.e.mUpdateCharToLiveIOTimer != -1) {
                            LiveStrategyManager.this.mHandler.sendEmptyMessageDelayed(1029, lj6.a.m().r.e.mUpdateCharToLiveIOTimer);
                            break;
                        }
                        break;
                }
            }
        }

        i(Looper looper) {
            super(looper);
        }
    }

    class m extends HandlerDelegate {

        class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                LiveStrategyManager.access$100(LiveStrategyManager.this);
            }

            b() {
            }
        }

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (lj6.a.m().r.e.mEnableDnsOptimizer == 1 && lj6.a.m().r.e.mNodeLocalDnsRequestInterval != 0 && LiveStrategyManager.this.mReceiveMessage % lj6.a.m().r.e.mNodeLocalDnsRequestInterval == 0) {
                    Set<String> g = TopNHostStrategy.f().g(TopNHostStrategy.f().runStrategy());
                    if (g != null && g.size() > 0) {
                        DnsOptimizer.O().s = g;
                    }
                    if (lj6.a.m().r.e.mEnableIPv6ProbeLoop == 1) {
                        DnsOptimizer.O().F = false;
                        DnsOptimizer.O().G = -1;
                    }
                    DnsOptimizer.O().U(LiveStrategyManager.this.mOnParseDnsCompletionListener, null);
                    return;
                }
                LSNetworkManager.inst().settingsApi().e(null, true);
            }

            a() {
            }
        }

        public void handleMessage(Message message) {
            if (message != null) {
                switch (message.what) {
                    case 1024:
                        LiveStrategyManager.this.mReceiveMessage++;
                        if (lj6.a.m().v == 1) {
                            long currentTimeMillis = System.currentTimeMillis();
                            LiveStrategyManager liveStrategyManager = LiveStrategyManager.this;
                            if ((currentTimeMillis - liveStrategyManager.mLastEndTS) - (liveStrategyManager.mTTLMs + lj6.a.m().H) > 0) {
                                lj6.a.m().I++;
                            } else {
                                lj6.a m = lj6.a.m();
                                lj6.a m2 = lj6.a.m();
                                int i = m2.I - 1;
                                m2.I = i;
                                m.I = Math.max(i, 0);
                            }
                            lj6.a.m().H = Math.min(lj6.a.m().I * lj6.a.m().I, 10) * 60 * 1000;
                            LiveStrategyManager.this.mHandler.postDelayed(new a(), lj6.a.m().H);
                            break;
                        } else if (lj6.a.m().r.e.mEnableDnsOptimizer == 1 && lj6.a.m().r.e.mNodeLocalDnsRequestInterval != 0 && LiveStrategyManager.this.mReceiveMessage % lj6.a.m().r.e.mNodeLocalDnsRequestInterval == 0) {
                            DnsOptimizer.O().U(LiveStrategyManager.this.mOnParseDnsCompletionListener, null);
                            break;
                        } else {
                            LSNetworkManager.inst().settingsApi().e(null, false);
                            break;
                        }
                        break;
                    case 1025:
                        if (LiveStrategyManager.mSRPredictEngine != null && !com.ss.videoarch.strategy.strategy.smartStrategy.l.g().e()) {
                            LiveStrategyManager.mSRPredictEngine.b(false);
                            break;
                        } else {
                            com.ss.videoarch.strategy.strategy.smartStrategy.l.g().b(false);
                            break;
                        }
                        break;
                    case 1026:
                        LiveStrategyManager.this.mThreadPool.submit(new b());
                        break;
                    case 1027:
                        TypePlayFeaturesCollector.h().f();
                        Log.d("LiveStrategyManager", "clock");
                        LiveStrategyManager.this.mHandler.removeMessages(1027);
                        if (lj6.a.m().r.e.mEnableCollectTime != -1) {
                            LiveStrategyManager.this.mHandler.sendEmptyMessageDelayed(1027, lj6.a.m().r.e.mEnableCollectTime);
                            break;
                        }
                        break;
                    case 1028:
                        if (com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a && lj6.a.m().r.e.mEnableUsePTY == 1 && PitayaWrapper.f().d()) {
                            com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a = false;
                            com.ss.videoarch.strategy.strategy.smartStrategy.e.a().runStrategy();
                            com.ss.videoarch.strategy.strategy.smartStrategy.e.a().b(-1L);
                            break;
                        }
                        break;
                    case 1029:
                        if (lj6.a.m().r.e.mEnableUpdateCharToLiveIO == 1) {
                            Log.d("LiveStrategyManager", "clock - CharacterFetchStrategy");
                            com.ss.videoarch.strategy.strategy.smartStrategy.b.a().runStrategy();
                        }
                        LiveStrategyManager.this.mHandler.removeMessages(1029);
                        if (lj6.a.m().r.e.mUpdateCharToLiveIOTimer != -1) {
                            LiveStrategyManager.this.mHandler.sendEmptyMessageDelayed(1029, lj6.a.m().r.e.mUpdateCharToLiveIOTimer);
                            break;
                        }
                        break;
                }
            }
        }

        m(Looper looper) {
            super(looper);
        }
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            DnsOptimizer.O().V();
        }

        a() {
        }
    }

    class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.videoarch.strategy.strategy.smartStrategy.k kVar = LiveStrategyManager.mSRPredictEngine;
            if (kVar != null) {
                kVar.i();
            }
        }

        d() {
        }
    }

    class f implements DnsOptimizer.n {

        class a implements Runnable {
            final /* synthetic */ String a;

            @Override // java.lang.Runnable
            public void run() {
                LSNetworkManager.inst().settingsApi().e(this.a, true);
            }

            a(String str) {
                this.a = str;
            }
        }

        f() {
        }

        @Override // com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.n
        public void a(String str) {
            if (lj6.a.m().v == 1) {
                LiveStrategyManager.this.mHandler.post(new a(str));
            } else {
                LSNetworkManager.inst().settingsApi().e(str, false);
            }
        }
    }

    class j extends BroadcastReceiver {

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                DnsOptimizer.O().P();
                DnsOptimizer.O().P = true;
            }

            a() {
            }
        }

        class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                DnsOptimizer.O().T = com.ss.videoarch.strategy.network.d.e().c();
                DnsOptimizer.O().P();
                DnsOptimizer.O().P = true;
                DnsOptimizer.O().F = false;
                DnsOptimizer.O().G = -1;
                DnsOptimizer.O().U(LiveStrategyManager.this.mOnParseDnsCompletionListener, null);
            }

            b() {
            }
        }

        j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast() || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            if (!LiveStrategyManager.isNetworkAvailable(context)) {
                if (DnsOptimizer.O().q) {
                    LiveStrategyManager.this.mHandler.removeMessages(1024);
                    LiveStrategyManager.this.mHandler.post(new a());
                    return;
                }
                return;
            }
            if (DnsOptimizer.O().q) {
                LiveStrategyManager.this.mHandler.removeMessages(1024);
                LiveStrategyManager.this.mHandler.post(new b());
            }
            pj6.a aVar = LiveStrategyManager.mLiveIOEngine;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    public void createHandleForChildThread() {
        this.mHandler = new m(Looper.myLooper());
    }

    public String getStrategyCenterABTraceInfo() {
        if (!this.mIsRunning) {
            return "";
        }
        return lj6.a.m().h();
    }

    public String getStrategyCenterCommonTraceInfo() {
        if (!this.mIsRunning) {
            return "";
        }
        return lj6.a.m().i();
    }

    class e implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            LiveStrategyManager.this.mHandler.removeMessages(this.a);
            LiveStrategyManager.this.mHandler.sendEmptyMessage(this.a);
        }

        e(int i) {
            this.a = i;
        }
    }

    public static LiveStrategyManager inst() {
        if (sInstance == null) {
            synchronized (LiveStrategyManager.class) {
                if (sInstance == null) {
                    sInstance = new LiveStrategyManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLiveIOStarted() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("liveio_started", 1);
            com.ss.videoarch.strategy.strategy.networkStrategy.a.a().c(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static class n implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;
        private final String c;

        static {
            Covode.recordClassIndex(653110);
        }

        private n() {
            ThreadGroup threadGroup;
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.a = threadGroup;
            this.c = "live-stream-strategy-";
        }

        /* synthetic */ n(e eVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 1) {
                thread.setPriority(1);
            }
            return thread;
        }
    }

    private void loadQuicLibrary() {
        if (!loadLibrary("vcbasekit")) {
            Log.e("LiveStrategyManager", "load vcbasekit failed!");
            return;
        }
        if (!loadLibrary("ttquic")) {
            Log.e("LiveStrategyManager", "load ttquic failed!");
        }
        Log.i("LiveStrategyManager", "load ttquic success");
    }

    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (lj6.a.m().r.e.mEnableDnsOptimizer == 1) {
                Log.w("LiveStrategyManager", "enable dns optimizer");
                DnsOptimizer.O().a = LiveStrategyManager.this.mOnParseDnsCompletionListener;
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.j.b().a();
            if (LiveStrategyManager.this.mChildHandler != null) {
                LiveStrategyManager liveStrategyManager = LiveStrategyManager.this;
                liveStrategyManager.initPitaya(liveStrategyManager.mChildHandler);
            } else {
                LiveStrategyManager liveStrategyManager2 = LiveStrategyManager.this;
                liveStrategyManager2.initPitaya(liveStrategyManager2.mHandler);
            }
        }

        c() {
        }
    }

    static {
        Covode.recordClassIndex(653109);
        mLoadSoSuccess = false;
        mLoadLibraryTime = -1L;
        mStartStrategyTime = -1L;
        List asList = Arrays.asList("livestrategy");
        ArrayList arrayList = new ArrayList();
        mLibraryList = arrayList;
        arrayList.addAll(asList);
        Iterator<String> it2 = mLibraryList.iterator();
        while (it2.hasNext()) {
            mLoadSoSuccess = loadLibrary(it2.next());
        }
        if (mLoadLibraryTime == -1) {
            mLoadLibraryTime = System.currentTimeMillis();
        }
        com.ss.videoarch.strategy.utils.b.b(mLoadSoSuccess);
    }

    LiveStrategyManager() {
        Boolean bool = Boolean.FALSE;
        this.mRetryFlag = bool;
        this.mEngine = null;
        this.mPTYSetUpAlready = bool;
        this.mListenerMap = new ConcurrentHashMap();
        this.mHashCodeToBundleMap = new ConcurrentHashMap();
        this.mFirstStart = true;
        this.mFirstUpdate = true;
        this.mChildHandler = null;
        this.mDeviceId = "";
        this.mDidLocalDNS = false;
        this.mLatestSessionId = "";
        this.mOnParseDnsCompletionListener = new f();
        this.mOnDoPreconnectListener = new g();
        this.mLSPreconnListener = new h();
        this.mHandler = new i(Looper.getMainLooper());
        this.networkReceiver = new j();
        TTClassLoad.init();
    }

    private int getSuggestSendingRate() {
        int i2 = 0;
        JSONObject jSONObject = (JSONObject) inst().getConfigAndStrategyByKeyInt(0, 20, null, new JSONObject());
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            String str = "";
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                String optString = jSONObject.optString(valueOf);
                if (!TextUtils.equals(valueOf, "BandwidthDecision")) {
                    if (TextUtils.equals(valueOf, "Bandwidth")) {
                        i2 = Integer.valueOf(optString).intValue();
                    }
                    if (!str.equals("")) {
                        str = str + "&";
                    }
                    str = str + valueOf + "=" + optString;
                }
            }
        }
        return i2;
    }

    public void stop() {
        if (!this.mIsRunning) {
            return;
        }
        this.mIsRunning = false;
        this.mHandler.removeMessages(1024);
        this.mHandler.removeMessages(1025);
        this.mHandler.removeMessages(1026);
        INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.networkReceiver);
        this.mHandler.post(new a());
        if (this.mSettingsListener != null) {
            LSNetworkManager.inst().settingsApi().f(this.mSettingsListener);
            this.mSettingsListener = null;
        }
        if (mLoadSoSuccess) {
            nativeStop();
        }
    }

    class l implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.videoarch.strategy.strategy.smartStrategy.k kVar;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            LiveStrategyManager.this.createHandleForChildThread();
            lj6.a.m().c0 = LiveStrategyManager.this.mHandler;
            DnsOptimizer.O().j = LiveStrategyManager.this.mHandler;
            if (lj6.a.m().C == 1 && (kVar = LiveStrategyManager.mSRPredictEngine) != null) {
                kVar.e = LiveStrategyManager.this.mHandler;
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.l g = com.ss.videoarch.strategy.strategy.smartStrategy.l.g();
            LiveStrategyManager liveStrategyManager = LiveStrategyManager.this;
            Handler handler = liveStrategyManager.mHandler;
            g.e = handler;
            liveStrategyManager.mChildHandler = handler;
            long j = lj6.a.m().G;
            lj6.a.m().getClass();
            if (j != 0) {
                try {
                    ThreadMonitor.sleepMonitor(lj6.a.m().G);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LSNetworkManager.inst().settingsApi().e = LiveStrategyManager.this.mHandler;
            LSNetworkManager.inst().settingsApi().e(null, true);
            Looper.loop();
        }

        l() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGlobalSettings() {
        if (lj6.a.m().r.e.mPerfOptAsync != 1) {
            if (this.mFirstUpdate) {
                this.mFirstUpdate = false;
                if (lj6.a.m().r.e.mEnableDnsOptimizer == 1) {
                    Log.w("LiveStrategyManager", "enable dns optimizer");
                    DnsOptimizer.O().a = this.mOnParseDnsCompletionListener;
                }
                com.ss.videoarch.strategy.strategy.smartStrategy.j.b().a();
                Handler handler = this.mChildHandler;
                if (handler != null) {
                    initPitaya(handler);
                } else {
                    initPitaya(this.mHandler);
                }
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.k kVar = mSRPredictEngine;
            if (kVar != null) {
                kVar.i();
            }
        } else {
            if (this.mFirstUpdate) {
                this.mFirstUpdate = false;
                this.mThreadPool.execute(new c());
            }
            this.mThreadPool.execute(new d());
        }
        long j2 = 300000;
        if (lj6.a.m().F * 1000 >= 300000) {
            j2 = lj6.a.m().F * 1000;
        }
        this.mTTLMs = j2;
        if (lj6.a.m().r.e.mEnableDnsOptimizer == 1) {
            DnsOptimizer.O().X(null);
        }
        this.mHandler.removeMessages(1024);
        this.mHandler.sendEmptyMessageDelayed(1024, this.mTTLMs);
    }

    class b implements Callable<String> {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ int d;

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            String str;
            int i = this.a;
            int i2 = 1;
            if (i != 54) {
                if (i != 55) {
                    if (i != 57) {
                        if (i != 58) {
                            switch (i) {
                                case 401:
                                    com.ss.videoarch.strategy.strategy.networkStrategy.a.a().e(this.c);
                                    return null;
                                case 402:
                                    JSONObject b = com.ss.videoarch.strategy.strategy.networkStrategy.a.a().b(this.c);
                                    if (b == null) {
                                        return null;
                                    }
                                    return b.toString();
                                case 403:
                                    com.ss.videoarch.strategy.strategy.networkStrategy.a.a().c(this.c);
                                    return null;
                                case 404:
                                    JSONObject b2 = com.ss.videoarch.strategy.strategy.networkStrategy.a.a().b(null);
                                    if (b2 == null) {
                                        return null;
                                    }
                                    return b2.toString();
                                case 405:
                                    LiveStrategyManager.this.onLiveIOStarted();
                                    return null;
                            }
                        }
                        if (this.c.has("host")) {
                            JSONObject R = DnsOptimizer.O().R(this.c.optString("host"));
                            Log.d("LiveStrategyManager", "sendDnsRequestByHost result:" + R);
                            if (R != null) {
                                return R.toString();
                            }
                        } else {
                            Log.e("LiveStrategyManager", "sendDnsRequestByHost has no host");
                        }
                        return null;
                    }
                    Log.d("LiveStrategyManager", "SendDnsRequest");
                    LiveStrategyManager.this.mHandler.removeMessages(1024);
                    LiveStrategyManager.this.mHandler.sendEmptyMessageDelayed(1024, 0L);
                    return null;
                }
                if (lj6.a.m().i == null) {
                    i2 = 0;
                }
                String str2 = "{\"result\":" + i2 + "}";
                Log.d("LiveStrategyManager", "SDKType:" + this.d + ", executeCommand:" + this.a + ", result:" + str2);
                return str2;
            }
            if (lj6.a.m().Y != 1) {
                Log.d("LiveStrategyManager", "SetConfigToLiveIO toggle off");
                return null;
            }
            IAppInfoBundle iAppInfoBundle = LiveStrategyManager.this.mHashCodeToBundleMap.get(Integer.valueOf(this.b));
            if (iAppInfoBundle != null) {
                String str3 = (String) iAppInfoBundle.getAppInfoForKey("LiveIOSessionId", "LiveIOSessionId");
                if (str3 != null) {
                    try {
                        this.c.put("session_id", str3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("LiveStrategyManager", "null LiveIOSessionId: " + this.b);
                }
            } else {
                Log.e("LiveStrategyManager", "null bundle for: " + this.b);
            }
            JSONObject jSONObject = this.c;
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = "";
            }
            String nativeExecuteCommand = LiveStrategyManager.this.nativeExecuteCommand(this.d, this.a, this.b, str);
            Log.d("LiveStrategyManager", "SDKType:" + this.d + ", executeCommand:" + this.a + ", result:" + nativeExecuteCommand);
            return nativeExecuteCommand;
        }

        b(int i, int i2, JSONObject jSONObject, int i3) {
            this.a = i;
            this.b = i2;
            this.c = jSONObject;
            this.d = i3;
        }
    }

    public void start() {
        boolean z;
        if (this.mIsRunning) {
            Log.w("LiveStrategyManager", "livestrategy is already running");
            return;
        }
        this.mIsRunning = true;
        Log.w("LiveStrategyManager", "start livestrategy");
        INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_dragon_read_aop_BroadcastAop_registerReceiver(this.mContext, this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.mBatteryIntent = INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_dragon_read_aop_BroadcastAop_registerReceiver(this.mContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (lj6.a.m().s.b == 1 && lj6.a.m().s.f == 1) {
            nj6.c.j(this.mContext);
            List<SessionCacheInfos> h2 = nj6.c.h();
            if (h2 != null && h2.size() > 0) {
                nj6.c.i(h2);
                nj6.c.g();
            }
        }
        com.ss.videoarch.strategy.log.strategyMonitor.a.a().a = System.currentTimeMillis() - mLoadLibraryTime;
        oj6.b.a();
        if (lj6.a.m().w == 1) {
            DnsOptimizer.O().b = this.mOnDoPreconnectListener;
            if (lj6.a.m().x == 1 && lj6.a.m().y == 1) {
                pj6.a aVar = new pj6.a(this.mEngine);
                mLiveIOEngine = aVar;
                aVar.g(this.mContext.getFilesDir().getAbsolutePath() + "/pullstream.scfg");
            }
            if (lj6.a.m().B == 1 || lj6.a.m().J == 1) {
                LSPreconnManager.h().g = this.mLSPreconnListener;
                LSPreconnManager.h().k(this.mContext);
                loadQuicLibrary();
                if (mLoadSoSuccess) {
                    LSPreconnDataHandle.b bVar = new LSPreconnDataHandle.b();
                    if (lj6.a.m().K == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.b = z;
                    bVar.c = lj6.a.m().L;
                    bVar.d = lj6.a.m().N;
                    bVar.e = lj6.a.m().P;
                    LSPreconnManager.h().l(bVar);
                }
            }
        }
        if (lj6.a.m().C == 1) {
            com.ss.videoarch.strategy.strategy.smartStrategy.k kVar = new com.ss.videoarch.strategy.strategy.smartStrategy.k();
            mSRPredictEngine = kVar;
            kVar.f();
        }
        if (lj6.a.m().v == 1) {
            this.mThreadPool.execute(new l());
        } else {
            LSNetworkManager.inst().settingsApi().e(null, false);
        }
        if (mLoadSoSuccess) {
            nativeStart();
            JniTask.c().a();
            if (lj6.a.m().s.b == 1) {
                SettingsManager.getInstance().loadDB();
                if (!this.mDidLocalDNS) {
                    DnsOptimizer.O().J(TopNHostStrategy.f().runStrategy());
                }
            }
        }
    }

    class g implements DnsOptimizer.m {
        g() {
        }

        @Override // com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.m
        public void a(String str, String str2) {
            pj6.a aVar = LiveStrategyManager.mLiveIOEngine;
            if (aVar != null) {
                aVar.a(str, str2);
            }
            if (lj6.a.m().B == 1) {
                LSPreconnManager.h().j(str, str2);
            }
        }
    }

    class h implements LSPreconnManager.d {
        h() {
        }

        @Override // com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager.d
        public String a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = new JSONObject().put("host", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject N = DnsOptimizer.O().N(jSONObject, null);
            if (N == null) {
                return null;
            }
            Log.d("LiveStrategyManager", " LSPreconn did get dns optimizer info " + N);
            if (N.has("Ip")) {
                return N.optString("Ip");
            }
            Log.w("LiveStrategyManager", " LSPreconn didn't get ip for:" + str);
            return "";
        }
    }

    class k implements c.d {
        k() {
        }

        @Override // com.ss.videoarch.strategy.network.c.d
        public void a(String str) {
            if (str == null) {
                LiveStrategyManager.this.updateGlobalSettings();
            } else if (lj6.a.m().r.e.mEnableDnsOptimizer == 1) {
                DnsOptimizer.O().X(str);
            }
        }
    }

    static /* synthetic */ com.ss.videoarch.strategy.b access$100(LiveStrategyManager liveStrategyManager) {
        liveStrategyManager.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (!activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setSupportSRScene(boolean z) {
        if (mSRPredictEngine != null && !com.ss.videoarch.strategy.strategy.smartStrategy.l.g().e()) {
            mSRPredictEngine.setSupportSRScene(z);
        }
        com.ss.videoarch.strategy.strategy.smartStrategy.l.g().setSupportSRScene(z);
    }

    public void triggerSRPredict(JSONObject jSONObject) {
        if (mSRPredictEngine != null && !com.ss.videoarch.strategy.strategy.smartStrategy.l.g().e()) {
            mSRPredictEngine.triggerSRPredict(jSONObject);
        } else {
            com.ss.videoarch.strategy.strategy.smartStrategy.l.g().triggerSRPredict(jSONObject);
        }
    }

    private String getStrategyConfigByName(String str) {
        if (lj6.a.m().n == null) {
            Log.e("LiveStrategyManager", "null mStrategyConfigJSON");
            return "";
        }
        return SettingsManager.getInstance().getStrategyConfigByName(lj6.a.m().n.toString(), str);
    }

    private void sendEmptyMsg(int i2) {
        ThreadPoolExecutor threadPoolExecutor;
        if (lj6.a.m().v == 1 && (threadPoolExecutor = this.mThreadPool) != null) {
            threadPoolExecutor.execute(new e(i2));
        } else {
            this.mHandler.removeMessages(i2);
            this.mHandler.sendEmptyMessage(i2);
        }
    }

    private void setHashCodeToBundleMap(IAppInfoBundle iAppInfoBundle) {
        if (lj6.a.m().Y == 1 && iAppInfoBundle != null) {
            Integer num = (Integer) iAppInfoBundle.getAppInfoForKey("HashCode", 0);
            Log.d("LiveStrategyManager", "setHashCodeToBundleMap " + num);
            this.mHashCodeToBundleMap.put(num, iAppInfoBundle);
        }
    }

    public void doLocalDnsOperator(Context context) {
        Log.d("LiveStrategyManager", "start into do local dns operator");
        this.mDidLocalDNS = true;
        nj6.f.c(context);
        DataWarehouse.init(context);
        SettingsManager.getInstance().loadDB();
        DnsOptimizer.O().J(TopNHostStrategy.f().runStrategy());
    }

    public String getPreconnResult(String str) {
        if (!mLoadSoSuccess) {
            Log.e("LiveStrategyManager", "Load so failed");
            return "";
        }
        if (lj6.a.m().J != 1 || lj6.a.m().O != 1) {
            return "";
        }
        return LSPreconnManager.h().g(str);
    }

    public void releaseFeatureDataBundle(String str) {
        Log.d("LiveStrategyManager", "releaseFeatureDataBundle " + str);
        releaseHashCodeToBundleMap(str);
        this.mListenerMap.remove(str);
        Log.d("LiveStrategyManager", "FeatureDataBundle size:" + this.mListenerMap.size());
    }

    public String setConfigToLiveIO(String str) {
        String nativeExecuteCommand = nativeExecuteCommand(0, 54, 0, str);
        Log.d("LiveStrategyManager", "sendDataToLiveIO:" + str + ", res:" + nativeExecuteCommand);
        return nativeExecuteCommand;
    }

    public void setIFunctionCalledByStrategyEngine(com.ss.videoarch.strategy.a aVar) {
        Log.d("LiveStrategyManager", "setIFunctionCalledByStrategyEngine, engine: " + aVar);
        this.mEngine = aVar;
        if (mLiveIOEngine != null) {
            Log.w("LiveStrategyManager", "set liveio engine");
            mLiveIOEngine.f(aVar);
        }
    }

    public void stopSession(JSONObject jSONObject) {
        if (mLoadSoSuccess) {
            nativeStopSession(jSONObject);
        }
        if (mSRPredictEngine != null && !com.ss.videoarch.strategy.strategy.smartStrategy.l.g().e()) {
            mSRPredictEngine.stopSession(jSONObject);
        } else {
            com.ss.videoarch.strategy.strategy.smartStrategy.k.g().stopSession(jSONObject);
        }
    }

    private static boolean loadLibrary(String str) {
        try {
            com.ss.videoarch.strategy.utils.a.a(str);
            Log.d("LiveStrategyManager", "load library: " + str + ".so success");
            return true;
        } catch (Throwable th) {
            Log.e("LiveStrategyManager", "load library: " + str + ".so fail! " + th.getMessage());
            return false;
        }
    }

    private void releaseHashCodeToBundleMap(String str) {
        if (lj6.a.m().Y != 1) {
            return;
        }
        IAppInfoBundle iAppInfoBundle = this.mListenerMap.get(str);
        if (iAppInfoBundle != null) {
            Integer num = (Integer) iAppInfoBundle.getAppInfoForKey("HashCode", 0);
            Log.d("LiveStrategyManager", "releaseHashCodeToBundleMap " + num);
            this.mHashCodeToBundleMap.remove(num);
            return;
        }
        Log.d("LiveStrategyManager", "releaseHashCodeToBundleMap: null bundle: " + str);
    }

    public void initPitaya(Handler handler) {
        if (lj6.a.m().r.e.mEnableUsePTY == 1) {
            Log.w("LiveStrategyManager", "enable pitaya");
            PitayaWrapper.f().a = this.mHandler;
            PitayaWrapper.f().i = lj6.a.m().r.e.mEnableInitPtyByStrategy;
            PitayaWrapper f2 = PitayaWrapper.f();
            Context context = this.mContext;
            JSONObject jSONObject = this.mInitInfo;
            com.ss.videoarch.strategy.log.strategyMonitor.a.a();
            f2.e(context, jSONObject, com.ss.videoarch.strategy.log.strategyMonitor.a.b);
            if (lj6.a.m().r.e.mEnableRegisterPtyFeatureCenter == 1) {
                PitayaWrapper.f().g();
            }
        }
    }

    public void setAppInfoBundle(IAppInfoBundle iAppInfoBundle) {
        lj6.a.m().l(iAppInfoBundle);
        if (lj6.a.m().s.b == 1) {
            Log.w("LiveStrategyManager", "enable persistence");
            nj6.f.c(this.mContext);
        }
        oj6.a.a(this.mContext, this.mInitInfo);
        PlatformDataFetcher.init(iAppInfoBundle);
        if (iAppInfoBundle != null) {
            if (((Integer) iAppInfoBundle.getAppInfoForKey("live_sdk_enable_mpd_prelaod", 0)).intValue() == 1) {
                MpdPreloadManager.getInstance().init(this.mContext);
            }
            if (((Integer) iAppInfoBundle.getAppInfoForKey("live_sdk_enable_data_warehouse", 0)).intValue() == 1) {
                DataWarehouse.init(this.mContext);
            }
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    public void registerStrategyConfigUpdate(String str, SettingsManager.StrategyConfigUpdateCallBack strategyConfigUpdateCallBack) {
        SettingsManager.getInstance().registerStrategyConfigUpdate(str, strategyConfigUpdateCallBack);
    }

    public <T> T getAppInfoForKey(String str, T t) {
        if (str != null) {
            return (T) lj6.a.m().b(str, t);
        }
        return t;
    }

    public long getInt64Value(String str, long j2) {
        return ((Long) getAppInfoForKey(str, Long.valueOf(j2))).longValue();
    }

    public float getFloatValue(int i2, float f2) {
        String str;
        if (i2 != 12) {
            str = null;
        } else {
            str = "attenuation_coefficient";
        }
        try {
            return ((Float) getAppInfoForKey(str, Float.valueOf(f2))).floatValue();
        } catch (Exception unused) {
            return f2;
        }
    }

    public String getConfigAndStrategyBundle(int i2, JSONObject jSONObject) {
        String str;
        JSONObject e2;
        if (!this.mIsRunning) {
            return null;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 3) {
                    str = null;
                }
            } else {
                com.ss.videoarch.strategy.featureCenter.featureType.d.e().c = jSONObject;
                str = "1";
            }
            if (str != null || (e2 = lj6.a.m().e(str, i2)) == null) {
                return null;
            }
            return e2.toString();
        }
        TypePlayFeaturesCollector.h().i(jSONObject);
        str = "2";
        if (str != null) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject getConfigAndStrategyJson(int r3, org.json.JSONObject r4) {
        /*
            r2 = this;
            boolean r0 = r2.mIsRunning
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            if (r3 == 0) goto L19
            r0 = 1
            if (r3 == r0) goto L10
            r0 = 3
            if (r3 == r0) goto L19
            r4 = r1
            goto L22
        L10:
            com.ss.videoarch.strategy.featureCenter.featureType.d r0 = com.ss.videoarch.strategy.featureCenter.featureType.d.e()
            r0.c = r4
            java.lang.String r4 = "1"
            goto L22
        L19:
            com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector r0 = com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector.h()
            r0.i(r4)
            java.lang.String r4 = "2"
        L22:
            if (r4 == 0) goto L2c
            lj6.a r0 = lj6.a.m()
            org.json.JSONObject r1 = r0.e(r4, r3)
        L2c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.LiveStrategyManager.getConfigAndStrategyJson(int, org.json.JSONObject):org.json.JSONObject");
    }

    public int getIntValue(int i2, int i3) {
        String str;
        switch (i2) {
            case 9:
                str = "min_start_play_buffer";
                break;
            case 10:
                str = "max_start_play_buffer";
                break;
            case 11:
                str = "attenuation_time_offset";
                break;
            default:
                str = null;
                break;
        }
        return ((Integer) getAppInfoForKey(str, Integer.valueOf(i3))).intValue();
    }

    public void setFeatureDataBundle(String str, IAppInfoBundle iAppInfoBundle) {
        Log.d("LiveStrategyManager", "setFeatureDataBundle " + str);
        if (this.mListenerMap.size() > lj6.a.m().r.e.mDataBundleCount) {
            Log.e("LiveStrategyManager", "Clear mListenerMap");
            this.mListenerMap.clear();
            this.mHashCodeToBundleMap.clear();
        }
        this.mLatestSessionId = str;
        this.mListenerMap.put(str, iAppInfoBundle);
        setHashCodeToBundleMap(iAppInfoBundle);
        Log.d("LiveStrategyManager", "FeatureDataBundle size:" + this.mListenerMap.size());
    }

    public void init(Context context, JSONObject jSONObject) throws Exception {
        this.mContext = context;
        if (mLoadSoSuccess) {
            nativeCreate();
        }
        if (jSONObject != null) {
            this.mInitInfo = jSONObject;
            if (jSONObject.has("host_aid") && (jSONObject.optString("host_aid").equals("1233") || jSONObject.optString("host_aid").equals("1180"))) {
                com.ss.videoarch.strategy.log.strategyMonitor.a.a();
                com.ss.videoarch.strategy.log.strategyMonitor.a.b = "330360";
            }
            if (jSONObject.has("device_id")) {
                this.mDeviceId = jSONObject.optString("device_id");
            }
        }
        if (this.mSettingsListener == null) {
            this.mSettingsListener = new k();
            LSNetworkManager.inst().settingsApi().c(this.mSettingsListener);
        }
        ThreadPoolExecutor customThreadPool = LSNetworkManager.inst().customThreadPool();
        if (customThreadPool == null) {
            PThreadPoolExecutorDelegate pThreadPoolExecutorDelegate = new PThreadPoolExecutorDelegate(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new n(null));
            this.mThreadPool = pThreadPoolExecutorDelegate;
            pThreadPoolExecutorDelegate.allowCoreThreadTimeOut(true);
            return;
        }
        this.mThreadPool = customThreadPool;
    }

    public void setEventInfo(int i2, JSONObject jSONObject) {
        Log.d("LiveStrategyManager", "setEventInfo: " + i2);
        FeatureFactory.inst().setFeature(i2, jSONObject);
        if (i2 == 61) {
            Log.d("LiveStrategyManager", "setEventInfo: LIVE_PULL_EVENT_OF_FIRST_FRAME");
            if (this.mFirstStart) {
                synchronized (this) {
                    if (this.mFirstStart) {
                        this.mFirstStart = false;
                        com.ss.videoarch.strategy.strategy.smartStrategy.e.a().b(System.currentTimeMillis() - mLoadLibraryTime);
                        if (lj6.a.m().r.e.mEnableCollectTime != -1) {
                            sendEmptyMsg(1027);
                        }
                        if (lj6.a.m().r.e.mUpdateCharToLiveIOTimer != -1) {
                            Log.d("LiveStrategyManager", "CharacterFetchStrategy timer: " + lj6.a.m().r.e.mUpdateCharToLiveIOTimer);
                            sendEmptyMsg(1029);
                        }
                    } else {
                        return;
                    }
                }
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.f.a().runStrategy();
        }
        if (i2 == 63) {
            if (mLoadSoSuccess) {
                inst().nativeStopSession(jSONObject);
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.k kVar = mSRPredictEngine;
            if (kVar != null) {
                kVar.stopSession(jSONObject);
            }
            com.ss.videoarch.strategy.strategy.smartStrategy.l.g().stopSession(jSONObject);
        }
    }

    public void setStreamInfo(String str, String str2, String str3) {
        if (mLoadSoSuccess) {
            nativeSetStreamInfo(str3);
        }
    }

    public void notifyInfo(int i2, int i3, String str) {
        pj6.a aVar;
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2 && i3 == 0 && (aVar = mLiveIOEngine) != null) {
                aVar.e(str);
                return;
            }
            return;
        }
        if (i3 == 500) {
            DnsOptimizer.O().W(str);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    public static Intent INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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
        return INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }

    public <T> T fireNotifyToPlayer(String str, T t, String str2) {
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mLatestSessionId;
        }
        if (this.mListenerMap.containsKey(str2)) {
            IAppInfoBundle iAppInfoBundle = this.mListenerMap.get(str2);
            if (iAppInfoBundle != null) {
                Log.d("LiveStrategyManager", "fireNotifyToPlayer:" + str);
                return (T) iAppInfoBundle.getAppInfoForKey(str, t);
            }
            Log.e("LiveStrategyManager", "fireNotifyToPlayer:bundle == null" + str);
            return t;
        }
        Log.e("LiveStrategyManager", "fireNotifyToPlayer:no Listener" + str);
        return t;
    }

    public void setRoomInfo(String str, int i2, long j2) {
        if (!mLoadSoSuccess) {
            Log.e("LiveStrategyManager", "Load so failed");
            return;
        }
        SettingsManager.getInstance().SetSDKParams(str);
        Log.d("LiveStrategyManager", "setRoomInfo type:" + i2 + ", arg1: " + j2 + ", roomInfo size: " + str.length());
        if (i2 == 50) {
            if (lj6.a.m().J == 1) {
                LSPreconnManager.h().m(str, getSuggestSendingRate(), com.ss.videoarch.strategy.network.d.e().d());
                LSPreconnManager.h().i(str);
            }
            nativeSetNextRoomInfo(str, i2, j2);
        }
    }

    private void uploadNodeOptimizeService(JSONObject jSONObject, JSONObject jSONObject2, int i2) {
        if (lj6.a.m().r.e.mEnableDnsOptimizer == 1) {
            DnsOptimizer.O().h.b++;
            if (jSONObject2.has("hostList")) {
                DnsOptimizer.O().h.c = -1;
            } else if (jSONObject2.has("host")) {
                DnsOptimizer.O().h.c = i2;
                DnsOptimizer.O().h.l = jSONObject2.optString("host");
                DnsOptimizer.O().h.n = jSONObject2.optString("stream_session_vv_id", "none");
                if (jSONObject != null) {
                    String optString = jSONObject.optString("Ip", "none");
                    DnsOptimizer.O().h.a = !optString.equals("none") ? 1 : 0;
                    DnsOptimizer.O().h.m = optString;
                    DnsOptimizer.O().h.k = jSONObject.optString("EvaluatorSymbol", "none");
                    DnsOptimizer.O().h.d = com.ss.videoarch.strategy.log.strategyMonitor.a.a().a;
                    if (DnsOptimizer.O().h.a == 0) {
                        DnsOptimizer.O().h.e = jSONObject.optBoolean("HasGetDomainInfos", false) ? 1 : 0;
                        DnsOptimizer.O().h.f = jSONObject.optBoolean("IsHostContained", false) ? 1 : 0;
                        DnsOptimizer.O().h.g = jSONObject.optBoolean("HasLocalDNSResult", false) ? 1 : 0;
                        DnsOptimizer.O().h.h = jSONObject.optBoolean("HasResetDNSResults", false) ? 1 : 0;
                        DnsOptimizer.O().h.i = jSONObject.optBoolean("RetryFailStopSchedule", false) ? 1 : 0;
                    }
                }
            }
            DnsOptimizer.O().h.uploadMonitorLog();
        }
    }

    public JSONObject executeCommand(int i2, int i3, int i4, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (!mLoadSoSuccess) {
            Log.e("LiveStrategyManager", "Load so failed");
            return null;
        }
        ThreadPoolExecutor threadPoolExecutor = this.mThreadPool;
        if (threadPoolExecutor == null) {
            return null;
        }
        try {
            String str = (String) threadPoolExecutor.submit(new b(i3, i4, jSONObject, i2)).get();
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject2 = new JSONObject(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (InterruptedException | ExecutionException e3) {
            e3.printStackTrace();
            Log.i("LiveStrategyManager", "executeCommand timeout");
        }
        Log.d("LiveStrategyManager", "SDKType:" + i2 + ", executeCommand:" + i3 + ", result:" + jSONObject2);
        return jSONObject2;
    }

    public <T> T getConfigAndStrategyByKeyStr(int i2, String str, T t, JSONObject jSONObject) {
        String str2;
        String str3 = null;
        if (i2 != 0) {
            if (i2 != 1) {
                str2 = null;
            } else {
                com.ss.videoarch.strategy.featureCenter.featureType.d.e().c = jSONObject;
                str2 = "1";
            }
        } else {
            TypePlayFeaturesCollector.h().i(jSONObject);
            str2 = "2";
        }
        if (jSONObject != null && jSONObject.has("host") && jSONObject.has("stream_session_vv_id")) {
            jSONObject.optString("host");
            str3 = jSONObject.optString("stream_session_vv_id");
        }
        if (str2 != null) {
            Map<String, IAppInfoBundle> map = this.mListenerMap;
            if (map != null && map.containsKey(str3) && lj6.a.m().Z.contains(str)) {
                List<String> arrayList = new ArrayList<>();
                if (lj6.a.m().a0 != null && lj6.a.m().a0.containsKey(str3)) {
                    arrayList = lj6.a.m().a0.get(str3);
                }
                arrayList.add(str);
                lj6.a.m().a0.put(str3, arrayList);
            }
            T t2 = (T) lj6.a.m().c(str);
            if (t2 == null) {
                return t;
            }
            if (JSONObject.class.equals(t2.getClass())) {
                return (T) t2.toString();
            }
            return t2;
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0385, code lost:
    
        if (r5 != false) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T getConfigAndStrategyByKeyInt(int r12, int r13, T r14, org.json.JSONObject r15) {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.LiveStrategyManager.getConfigAndStrategyByKeyInt(int, int, java.lang.Object, org.json.JSONObject):java.lang.Object");
    }
}

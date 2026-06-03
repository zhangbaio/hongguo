package com.ss.videoarch.strategy.network;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.network.LSSDKConfig;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSNetworkManager {
    private static volatile LSNetworkManager sInstance;
    private LSSDKConfig mConfig;
    private ThreadPoolExecutor mCustomThreadPool;
    private a mHttpApi;
    private c mSettingsApi;
    private final e mThreadPoolApi = new e();

    static {
        Covode.recordClassIndex(653148);
    }

    public ThreadPoolExecutor customThreadPool() {
        return this.mCustomThreadPool;
    }

    public a httpApi() {
        return this.mHttpApi;
    }

    public c settingsApi() {
        return this.mSettingsApi;
    }

    public e threadApi() {
        return this.mThreadPoolApi;
    }

    public LSNetworkManager() {
        init(new LSSDKConfig.Builder().build());
    }

    public static LSNetworkManager inst() {
        if (sInstance == null) {
            synchronized (LSNetworkManager.class) {
                if (sInstance == null) {
                    sInstance = new LSNetworkManager();
                }
            }
        }
        return sInstance;
    }

    public void init(LSSDKConfig lSSDKConfig) {
        if (lSSDKConfig == null) {
            return;
        }
        this.mConfig = lSSDKConfig;
        this.mHttpApi = new a(this.mConfig);
        this.mSettingsApi = new c(this.mThreadPoolApi, this.mHttpApi);
        this.mCustomThreadPool = lSSDKConfig.mCustomThreadPool;
        VeLSNetworkManagerImpl.getInstance().init(lSSDKConfig);
    }
}

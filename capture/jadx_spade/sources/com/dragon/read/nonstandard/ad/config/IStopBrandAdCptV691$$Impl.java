package com.dragon.read.nonstandard.ad.config;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.news.common.settings.internal.InstanceCreator;
import com.bytedance.news.common.settings.internal.LocalCache;
import com.bytedance.news.common.settings.internal.MetaInfo;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IStopBrandAdCptV691$$Impl implements IStopBrandAdCptV691 {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -340720105;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691
    public StopBrandAdCptV691 getConfig() {
        this.mExposedManager.markExposed("stop_brand_ad_cpt_v691");
        if (ExposedManager.needsReporting("stop_brand_ad_cpt_v691") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "stop_brand_ad_cpt_v691");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = stop_brand_ad_cpt_v691", hashMap);
        }
        if (this.mCachedSettings.containsKey("stop_brand_ad_cpt_v691")) {
            return (StopBrandAdCptV691) this.mCachedSettings.get("stop_brand_ad_cpt_v691");
        }
        Storage storage = this.mStorage;
        StopBrandAdCptV691 stopBrandAdCptV691 = null;
        if (storage != null && storage.contains("stop_brand_ad_cpt_v691")) {
            try {
                stopBrandAdCptV691 = (StopBrandAdCptV691) GSON.fromJson(this.mStorage.getString("stop_brand_ad_cpt_v691"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StopBrandAdCptV691 stopBrandAdCptV6912 = stopBrandAdCptV691;
        if (stopBrandAdCptV6912 != null) {
            this.mCachedSettings.put("stop_brand_ad_cpt_v691", stopBrandAdCptV6912);
            return stopBrandAdCptV6912;
        }
        return stopBrandAdCptV6912;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<StopBrandAdCptV691> {
        b() {
        }
    }

    public IStopBrandAdCptV691$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691");
                    }
                } catch (Throwable th2) {
                    IEnsure iEnsure2 = this.iEnsure;
                    if (iEnsure2 != null) {
                        iEnsure2.ensureNotReachHere(th2, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            }
        }
        if (settingsData != null && this.mStorage != null) {
            JSONObject appSettings = settingsData.getAppSettings();
            if (appSettings != null && appSettings.has("stop_brand_ad_cpt_v691")) {
                this.mStorage.putString("stop_brand_ad_cpt_v691", appSettings.optString("stop_brand_ad_cpt_v691"));
                this.mCachedSettings.remove("stop_brand_ad_cpt_v691");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("stop_brand_ad_cpt_v691_com.dragon.read.nonstandard.ad.config.IStopBrandAdCptV691", settingsData.getToken());
        }
    }
}

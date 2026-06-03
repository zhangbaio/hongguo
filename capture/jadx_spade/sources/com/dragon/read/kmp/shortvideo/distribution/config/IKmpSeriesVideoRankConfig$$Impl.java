package com.dragon.read.kmp.shortvideo.distribution.config;

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
public class IKmpSeriesVideoRankConfig$$Impl implements IKmpSeriesVideoRankConfig {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -929088090;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig
    public KmpSeriesVideoRankConfig getConfig() {
        this.mExposedManager.markExposed("kmp_series_video_rank_config_v689");
        if (ExposedManager.needsReporting("kmp_series_video_rank_config_v689") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "kmp_series_video_rank_config_v689");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = kmp_series_video_rank_config_v689", hashMap);
        }
        if (this.mCachedSettings.containsKey("kmp_series_video_rank_config_v689")) {
            return (KmpSeriesVideoRankConfig) this.mCachedSettings.get("kmp_series_video_rank_config_v689");
        }
        Storage storage = this.mStorage;
        KmpSeriesVideoRankConfig kmpSeriesVideoRankConfig = null;
        if (storage != null && storage.contains("kmp_series_video_rank_config_v689")) {
            try {
                kmpSeriesVideoRankConfig = (KmpSeriesVideoRankConfig) GSON.fromJson(this.mStorage.getString("kmp_series_video_rank_config_v689"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        KmpSeriesVideoRankConfig kmpSeriesVideoRankConfig2 = kmpSeriesVideoRankConfig;
        if (kmpSeriesVideoRankConfig2 != null) {
            this.mCachedSettings.put("kmp_series_video_rank_config_v689", kmpSeriesVideoRankConfig2);
            return kmpSeriesVideoRankConfig2;
        }
        return kmpSeriesVideoRankConfig2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<KmpSeriesVideoRankConfig> {
        b() {
        }
    }

    public IKmpSeriesVideoRankConfig$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig");
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
            if (appSettings != null && appSettings.has("kmp_series_video_rank_config_v689")) {
                this.mStorage.putString("kmp_series_video_rank_config_v689", appSettings.optString("kmp_series_video_rank_config_v689"));
                this.mCachedSettings.remove("kmp_series_video_rank_config_v689");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("kmp_series_video_rank_config_v689_com.dragon.read.kmp.shortvideo.distribution.config.IKmpSeriesVideoRankConfig", settingsData.getToken());
        }
    }
}

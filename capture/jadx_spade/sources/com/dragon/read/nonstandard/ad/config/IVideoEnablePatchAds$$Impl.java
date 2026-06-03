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
public class IVideoEnablePatchAds$$Impl implements IVideoEnablePatchAds {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1261195583;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds
    public VideoEnablePatchAds getConfig() {
        this.mExposedManager.markExposed("video_enable_patch_ads_v647");
        if (ExposedManager.needsReporting("video_enable_patch_ads_v647") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "video_enable_patch_ads_v647");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = video_enable_patch_ads_v647", hashMap);
        }
        if (this.mCachedSettings.containsKey("video_enable_patch_ads_v647")) {
            return (VideoEnablePatchAds) this.mCachedSettings.get("video_enable_patch_ads_v647");
        }
        Storage storage = this.mStorage;
        VideoEnablePatchAds videoEnablePatchAds = null;
        if (storage != null && storage.contains("video_enable_patch_ads_v647")) {
            try {
                videoEnablePatchAds = (VideoEnablePatchAds) GSON.fromJson(this.mStorage.getString("video_enable_patch_ads_v647"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        VideoEnablePatchAds videoEnablePatchAds2 = videoEnablePatchAds;
        if (videoEnablePatchAds2 != null) {
            this.mCachedSettings.put("video_enable_patch_ads_v647", videoEnablePatchAds2);
            return videoEnablePatchAds2;
        }
        return videoEnablePatchAds2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<VideoEnablePatchAds> {
        b() {
        }
    }

    public IVideoEnablePatchAds$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds");
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
            if (appSettings != null && appSettings.has("video_enable_patch_ads_v647")) {
                this.mStorage.putString("video_enable_patch_ads_v647", appSettings.optString("video_enable_patch_ads_v647"));
                this.mCachedSettings.remove("video_enable_patch_ads_v647");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("video_enable_patch_ads_v647_com.dragon.read.nonstandard.ad.config.IVideoEnablePatchAds", settingsData.getToken());
        }
    }
}

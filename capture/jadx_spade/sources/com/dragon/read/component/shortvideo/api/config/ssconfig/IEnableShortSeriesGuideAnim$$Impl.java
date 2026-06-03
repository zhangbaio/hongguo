package com.dragon.read.component.shortvideo.api.config.ssconfig;

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
public class IEnableShortSeriesGuideAnim$$Impl implements IEnableShortSeriesGuideAnim {
    private static final Gson GSON = new Gson();
    private static final int VERSION = 859367332;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim
    public m getConfig() {
        this.mExposedManager.markExposed("enable_short_series_guide_anim_v657");
        if (ExposedManager.needsReporting("enable_short_series_guide_anim_v657") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "enable_short_series_guide_anim_v657");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = enable_short_series_guide_anim_v657", hashMap);
        }
        if (this.mCachedSettings.containsKey("enable_short_series_guide_anim_v657")) {
            return (m) this.mCachedSettings.get("enable_short_series_guide_anim_v657");
        }
        Storage storage = this.mStorage;
        m mVar = null;
        if (storage != null && storage.contains("enable_short_series_guide_anim_v657")) {
            try {
                mVar = (m) GSON.fromJson(this.mStorage.getString("enable_short_series_guide_anim_v657"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m mVar2 = mVar;
        if (mVar2 != null) {
            this.mCachedSettings.put("enable_short_series_guide_anim_v657", mVar2);
            return mVar2;
        }
        return mVar2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<m> {
        b() {
        }
    }

    public IEnableShortSeriesGuideAnim$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim");
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
            if (appSettings != null && appSettings.has("enable_short_series_guide_anim_v657")) {
                this.mStorage.putString("enable_short_series_guide_anim_v657", appSettings.optString("enable_short_series_guide_anim_v657"));
                this.mCachedSettings.remove("enable_short_series_guide_anim_v657");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("enable_short_series_guide_anim_v657_com.dragon.read.component.shortvideo.api.config.ssconfig.IEnableShortSeriesGuideAnim", settingsData.getToken());
        }
    }
}

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
public class IComicVideoRelateBookEntranceConfigV679$$Impl implements IComicVideoRelateBookEntranceConfigV679 {
    private static final Gson GSON = new Gson();
    private static final int VERSION = 1432452110;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679
    public h getConfig() {
        this.mExposedManager.markExposed("comic_video_relate_book_entrance_config_v679");
        if (ExposedManager.needsReporting("comic_video_relate_book_entrance_config_v679") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "comic_video_relate_book_entrance_config_v679");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = comic_video_relate_book_entrance_config_v679", hashMap);
        }
        if (this.mCachedSettings.containsKey("comic_video_relate_book_entrance_config_v679")) {
            return (h) this.mCachedSettings.get("comic_video_relate_book_entrance_config_v679");
        }
        Storage storage = this.mStorage;
        h hVar = null;
        if (storage != null && storage.contains("comic_video_relate_book_entrance_config_v679")) {
            try {
                hVar = (h) GSON.fromJson(this.mStorage.getString("comic_video_relate_book_entrance_config_v679"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        h hVar2 = hVar;
        if (hVar2 != null) {
            this.mCachedSettings.put("comic_video_relate_book_entrance_config_v679", hVar2);
            return hVar2;
        }
        return hVar2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<h> {
        b() {
        }
    }

    public IComicVideoRelateBookEntranceConfigV679$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679");
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
            if (appSettings != null && appSettings.has("comic_video_relate_book_entrance_config_v679")) {
                this.mStorage.putString("comic_video_relate_book_entrance_config_v679", appSettings.optString("comic_video_relate_book_entrance_config_v679"));
                this.mCachedSettings.remove("comic_video_relate_book_entrance_config_v679");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("comic_video_relate_book_entrance_config_v679_com.dragon.read.component.shortvideo.api.config.ssconfig.IComicVideoRelateBookEntranceConfigV679", settingsData.getToken());
        }
    }
}

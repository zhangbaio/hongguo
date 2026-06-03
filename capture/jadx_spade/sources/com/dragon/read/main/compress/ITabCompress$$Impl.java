package com.dragon.read.main.compress;

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
public class ITabCompress$$Impl implements ITabCompress {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1850880097;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.main.compress.ITabCompress
    public TabCompress getConfig() {
        this.mExposedManager.markExposed("tab_compress_673");
        if (ExposedManager.needsReporting("tab_compress_673") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "tab_compress_673");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = tab_compress_673", hashMap);
        }
        if (this.mCachedSettings.containsKey("tab_compress_673")) {
            return (TabCompress) this.mCachedSettings.get("tab_compress_673");
        }
        Storage storage = this.mStorage;
        TabCompress tabCompress = null;
        if (storage != null && storage.contains("tab_compress_673")) {
            try {
                tabCompress = (TabCompress) GSON.fromJson(this.mStorage.getString("tab_compress_673"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TabCompress tabCompress2 = tabCompress;
        if (tabCompress2 != null) {
            this.mCachedSettings.put("tab_compress_673", tabCompress2);
            return tabCompress2;
        }
        return tabCompress2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<TabCompress> {
        b() {
        }
    }

    public ITabCompress$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("tab_compress_673_com.dragon.read.main.compress.ITabCompress")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("tab_compress_673_com.dragon.read.main.compress.ITabCompress", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("tab_compress_673_com.dragon.read.main.compress.ITabCompress", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("tab_compress_673_com.dragon.read.main.compress.ITabCompress", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("tab_compress_673_com.dragon.read.main.compress.ITabCompress", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("tab_compress_673_com.dragon.read.main.compress.ITabCompress")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("tab_compress_673_com.dragon.read.main.compress.ITabCompress");
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
            if (appSettings != null && appSettings.has("tab_compress_673")) {
                this.mStorage.putString("tab_compress_673", appSettings.optString("tab_compress_673"));
                this.mCachedSettings.remove("tab_compress_673");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("tab_compress_673_com.dragon.read.main.compress.ITabCompress", settingsData.getToken());
        }
    }
}

package com.dragon.read.component.biz.impl;

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
public class IEggplantMyTabGame$$Impl implements IEggplantMyTabGame {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1536013730;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.component.biz.impl.IEggplantMyTabGame
    public EggplantMyTabGame getConfig() {
        this.mExposedManager.markExposed("eggplant_my_tab_game_center");
        if (ExposedManager.needsReporting("eggplant_my_tab_game_center") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "eggplant_my_tab_game_center");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = eggplant_my_tab_game_center", hashMap);
        }
        if (this.mCachedSettings.containsKey("eggplant_my_tab_game_center")) {
            return (EggplantMyTabGame) this.mCachedSettings.get("eggplant_my_tab_game_center");
        }
        Storage storage = this.mStorage;
        EggplantMyTabGame eggplantMyTabGame = null;
        if (storage != null && storage.contains("eggplant_my_tab_game_center")) {
            try {
                eggplantMyTabGame = (EggplantMyTabGame) GSON.fromJson(this.mStorage.getString("eggplant_my_tab_game_center"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        EggplantMyTabGame eggplantMyTabGame2 = eggplantMyTabGame;
        if (eggplantMyTabGame2 != null) {
            this.mCachedSettings.put("eggplant_my_tab_game_center", eggplantMyTabGame2);
            return eggplantMyTabGame2;
        }
        return eggplantMyTabGame2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<EggplantMyTabGame> {
        b() {
        }
    }

    public IEggplantMyTabGame$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame");
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
            if (appSettings != null && appSettings.has("eggplant_my_tab_game_center")) {
                this.mStorage.putString("eggplant_my_tab_game_center", appSettings.optString("eggplant_my_tab_game_center"));
                this.mCachedSettings.remove("eggplant_my_tab_game_center");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("eggplant_my_tab_game_center_com.dragon.read.component.biz.impl.IEggplantMyTabGame", settingsData.getToken());
        }
    }
}

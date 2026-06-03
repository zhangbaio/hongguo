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
public class IMiniGameRetainDialog$$Impl implements IMiniGameRetainDialog {
    private static final Gson GSON = new Gson();
    private static final int VERSION = -1098333579;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.component.biz.impl.IMiniGameRetainDialog
    public MiniGameRetainDialog getConfig() {
        this.mExposedManager.markExposed("mini_game_retain_dialog_711");
        if (ExposedManager.needsReporting("mini_game_retain_dialog_711") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "mini_game_retain_dialog_711");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = mini_game_retain_dialog_711", hashMap);
        }
        if (this.mCachedSettings.containsKey("mini_game_retain_dialog_711")) {
            return (MiniGameRetainDialog) this.mCachedSettings.get("mini_game_retain_dialog_711");
        }
        Storage storage = this.mStorage;
        MiniGameRetainDialog miniGameRetainDialog = null;
        if (storage != null && storage.contains("mini_game_retain_dialog_711")) {
            try {
                miniGameRetainDialog = (MiniGameRetainDialog) GSON.fromJson(this.mStorage.getString("mini_game_retain_dialog_711"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MiniGameRetainDialog miniGameRetainDialog2 = miniGameRetainDialog;
        if (miniGameRetainDialog2 != null) {
            this.mCachedSettings.put("mini_game_retain_dialog_711", miniGameRetainDialog2);
            return miniGameRetainDialog2;
        }
        return miniGameRetainDialog2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<MiniGameRetainDialog> {
        b() {
        }
    }

    public IMiniGameRetainDialog$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog");
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
            if (appSettings != null && appSettings.has("mini_game_retain_dialog_711")) {
                this.mStorage.putString("mini_game_retain_dialog_711", appSettings.optString("mini_game_retain_dialog_711"));
                this.mCachedSettings.remove("mini_game_retain_dialog_711");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("mini_game_retain_dialog_711_com.dragon.read.component.biz.impl.IMiniGameRetainDialog", settingsData.getToken());
        }
    }
}

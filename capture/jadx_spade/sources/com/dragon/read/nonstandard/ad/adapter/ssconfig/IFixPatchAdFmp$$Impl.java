package com.dragon.read.nonstandard.ad.adapter.ssconfig;

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
public class IFixPatchAdFmp$$Impl implements IFixPatchAdFmp {
    private static final Gson GSON = new Gson();
    private static final int VERSION = 2119039923;
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mCachedSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new a();
    private ExposedManager mExposedManager = ExposedManager.getInstance(GlobalConfig.getContext());
    private IEnsure iEnsure = IEnsureWrapper.getInstance();

    public void updateSettings() {
    }

    @Override // com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp
    public FixPatchAdFmp getConfig() {
        this.mExposedManager.markExposed("fix_patch_ad_fmp_v701");
        if (ExposedManager.needsReporting("fix_patch_ad_fmp_v701") && this.iEnsure != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("settings_key", "fix_patch_ad_fmp_v701");
            hashMap.put("settings_time", String.valueOf(ExposedManager.getSettingsUsingTime()));
            hashMap.put("settings_thread_name", Thread.currentThread().getName());
            this.iEnsure.ensureNotReachHere("get settings key = fix_patch_ad_fmp_v701", hashMap);
        }
        if (this.mCachedSettings.containsKey("fix_patch_ad_fmp_v701")) {
            return (FixPatchAdFmp) this.mCachedSettings.get("fix_patch_ad_fmp_v701");
        }
        Storage storage = this.mStorage;
        FixPatchAdFmp fixPatchAdFmp = null;
        if (storage != null && storage.contains("fix_patch_ad_fmp_v701")) {
            try {
                fixPatchAdFmp = (FixPatchAdFmp) GSON.fromJson(this.mStorage.getString("fix_patch_ad_fmp_v701"), new b().getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FixPatchAdFmp fixPatchAdFmp2 = fixPatchAdFmp;
        if (fixPatchAdFmp2 != null) {
            this.mCachedSettings.put("fix_patch_ad_fmp_v701", fixPatchAdFmp2);
            return fixPatchAdFmp2;
        }
        return fixPatchAdFmp2;
    }

    class a implements InstanceCreator {
        public <T> T create(Class<T> cls) {
            return null;
        }

        a() {
        }
    }

    class b extends TypeToken<FixPatchAdFmp> {
        b() {
        }
    }

    public IFixPatchAdFmp$$Impl(Storage storage) {
        this.mStorage = storage;
    }

    public void updateSettings(SettingsData settingsData) {
        MetaInfo metaInfo = MetaInfo.getInstance(GlobalConfig.getContext());
        if (settingsData == null) {
            if (VERSION != metaInfo.getSettingsVersion("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic()) {
                        if (settingsData != null) {
                            metaInfo.setSettingsVersion("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp", VERSION);
                        }
                    } else {
                        metaInfo.setSettingsVersion("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp", VERSION);
                    }
                } catch (Throwable th) {
                    if (settingsData != null) {
                        metaInfo.setSettingsVersion("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp", VERSION);
                    }
                    IEnsure iEnsure = this.iEnsure;
                    if (iEnsure != null) {
                        iEnsure.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
                    }
                }
            } else if (metaInfo.needUpdate("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp", "")) {
                settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
            } else if (settingsData == null) {
                try {
                    if (ExposedManager.isUseOneSpForAppSettingsStatic() && !metaInfo.isOneSpMigrateDone("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp")) {
                        settingsData = LocalCache.getInstance(GlobalConfig.getContext()).getLocalSettingsData("");
                        metaInfo.setOneSpMigrateDone("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp");
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
            if (appSettings != null && appSettings.has("fix_patch_ad_fmp_v701")) {
                this.mStorage.putString("fix_patch_ad_fmp_v701", appSettings.optString("fix_patch_ad_fmp_v701"));
                this.mCachedSettings.remove("fix_patch_ad_fmp_v701");
            }
            this.mStorage.apply();
            metaInfo.setStorageKeyUpdateToken("fix_patch_ad_fmp_v701_com.dragon.read.nonstandard.ad.adapter.ssconfig.IFixPatchAdFmp", settingsData.getToken());
        }
    }
}

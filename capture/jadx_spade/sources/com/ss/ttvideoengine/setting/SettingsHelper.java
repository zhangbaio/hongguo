package com.ss.ttvideoengine.setting;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vodsetting.SettingsManager;
import com.bytedance.vodsetting.a;
import com.bytedance.vodsetting.e;
import com.bytedance.vodsetting.f;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.BaseAppInfo;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.configcenter.ConfigCenter;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.DeviceUtil;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SettingsHelper {
    public static int HARDWARE_CONFIG_SETTINGS;
    public static int HARDWARE_CONFIG_VIDEO_MODEL;
    public static String MODULE_ALL;
    public static String MODULE_BIZ_PORTRAIT;
    public static String MODULE_MDL;
    public static String MODULE_VOD;
    public static String REGION_CN;
    public static String REGION_SG;
    public static String REGION_US;
    private Context mContext;
    private boolean mDebug;
    private String mDeviceId;
    private int mEnable;
    private final ReentrantReadWriteLock mListenerLock;
    private final ArrayList<ISettingsListener> mListeners;
    private String mMdlVersion;
    private TTVNetClient mNetClient;
    private final List<TTVNetClient> mNetClients;
    private String mPlayerVersion;
    private final SettingsManager mSettingsManager;
    private JSONObject mVodCustomJSONObject;

    private String _sdkVersion() {
        return "1.10.252.100-novel";
    }

    private String _settingsVersion() {
        return "2.1.3";
    }

    private static class HelperHolder {
        private static final SettingsHelper Instance;

        private HelperHolder() {
        }

        static {
            Covode.recordClassIndex(652677);
            Instance = new SettingsHelper();
        }
    }

    public SettingsManager settings() {
        return this.mSettingsManager;
    }

    public static SettingsHelper helper() {
        return HelperHolder.Instance;
    }

    public SettingsHelper loadMDLCache() {
        if (this.mContext == null) {
            return this;
        }
        SettingsManager settingsManager = this.mSettingsManager;
        if (settingsManager != null) {
            settingsManager.w(2);
        }
        return this;
    }

    private String _mdlVersion() {
        if (this.mMdlVersion == null) {
            this.mMdlVersion = DataLoaderHelper.getDataLoader().getStringValue(6);
        }
        return this.mMdlVersion;
    }

    private String _playerVersion() {
        if (this.mPlayerVersion == null) {
            this.mPlayerVersion = TTPlayerConfiger.getValue(14, "");
        }
        return this.mPlayerVersion;
    }

    static {
        Covode.recordClassIndex(652676);
        REGION_CN = a.a;
        REGION_US = a.b;
        REGION_SG = a.c;
        MODULE_VOD = "vod";
        MODULE_MDL = "mdl";
        MODULE_ALL = "all";
        MODULE_BIZ_PORTRAIT = "biz_portrait";
        HARDWARE_CONFIG_VIDEO_MODEL = 2;
        HARDWARE_CONFIG_SETTINGS = 3;
    }

    private SettingsHelper() {
        this.mContext = null;
        this.mPlayerVersion = null;
        this.mMdlVersion = null;
        this.mDebug = false;
        this.mEnable = 0;
        this.mNetClient = null;
        this.mNetClients = Collections.synchronizedList(new ArrayList());
        this.mListenerLock = new ReentrantReadWriteLock();
        this.mListeners = new ArrayList<>();
        SettingsManager C = SettingsManager.C();
        this.mSettingsManager = C;
        C.o(new MyListener());
    }

    public SettingsHelper config() {
        if (!TextUtils.isEmpty(BaseAppInfo.mRegion)) {
            if (BaseAppInfo.mRegion.equals("cn-north-1")) {
                a.k(a.a);
            } else if (BaseAppInfo.mRegion.equals("singapore")) {
                a.k(a.c);
            } else {
                a.k(BaseAppInfo.mRegion);
            }
        }
        this.mDeviceId = AppInfo.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("aid", Integer.valueOf(BaseAppInfo.mAppID));
        hashMap.put("app_name", BaseAppInfo.mAppName);
        hashMap.put("device_id", this.mDeviceId);
        hashMap.put("app_channel", BaseAppInfo.mAppChannel);
        hashMap.put("app_version", BaseAppInfo.mAppVersion);
        a.g(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sdk_version", _sdkVersion());
        hashMap2.put("player_version", _playerVersion());
        hashMap2.put("settings_version", _settingsVersion());
        a.l(hashMap2);
        return this;
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void setEnableNotLoad(int i) {
        this.mEnable = i;
    }

    public void addListener(f fVar) {
        this.mSettingsManager.o(fVar);
    }

    public void setNetClient(TTVNetClient tTVNetClient) {
        synchronized (this) {
            this.mNetClient = tTVNetClient;
        }
    }

    public void setVodCustomJSONObject(JSONObject jSONObject) {
        synchronized (this) {
            this.mVodCustomJSONObject = jSONObject;
        }
    }

    private void addDeviceInfo(Map<String, Object> map) {
        Context context = this.mContext;
        if (context != null) {
            map.put("player_unique_id", TTVideoEngine.getEngineUniqueId(context));
        }
    }

    public JSONObject getJsonObject(String str) {
        if (this.mEnable == 0) {
            return null;
        }
        return this.mSettingsManager.r(str);
    }

    public JSONObject getMDLJsonObject(String str) {
        if (this.mEnable == 0) {
            return null;
        }
        return this.mSettingsManager.s("mdl", str);
    }

    public JSONArray getVodJsonArray(String str) {
        if (this.mEnable == 0) {
            return null;
        }
        return this.mSettingsManager.v(str);
    }

    public JSONObject getVodJsonObject(String str) {
        if (this.mEnable == 0) {
            return null;
        }
        return this.mSettingsManager.s("vod", str);
    }

    public void addListener(ISettingsListener iSettingsListener) {
        if (iSettingsListener == null) {
            return;
        }
        this.mListenerLock.writeLock().lock();
        this.mListeners.add(iSettingsListener);
        this.mListenerLock.writeLock().unlock();
    }

    public SettingsHelper load(String str) {
        if (this.mEnable == 0) {
            return this;
        }
        if (this.mContext == null) {
            return this;
        }
        SettingsManager settingsManager = this.mSettingsManager;
        if (settingsManager != null) {
            settingsManager.x(str, true);
        }
        return this;
    }

    public void removeListener(ISettingsListener iSettingsListener) {
        if (iSettingsListener == null) {
            return;
        }
        this.mListenerLock.writeLock().lock();
        this.mListeners.remove(iSettingsListener);
        this.mListenerLock.writeLock().unlock();
    }

    public SettingsHelper setContext(Context context) {
        this.mContext = context;
        SettingsManager settingsManager = this.mSettingsManager;
        if (settingsManager != null) {
            settingsManager.z(context);
            this.mSettingsManager.A(this.mDebug);
            this.mSettingsManager.B(new e() { // from class: com.ss.ttvideoengine.setting.SettingsHelper.2
                public void cancel() {
                    if (SettingsHelper.this.mNetClient != null) {
                        SettingsHelper.this.mNetClient.cancel();
                    }
                }

                public void start(String str, Map<String, String> map, final e.a aVar) {
                    synchronized (this) {
                        if (SettingsHelper.this.mNetClient == null) {
                            TTVNetClient tTVNetClient = TTVideoEngineConfig.gNetClient;
                            if (tTVNetClient != null) {
                                SettingsHelper.this.mNetClient = tTVNetClient;
                            } else {
                                SettingsHelper.this.mNetClient = new TTHTTPNetwork();
                            }
                        }
                        String buildURLString = SettingsHelper.this.buildURLString(str, map);
                        TTVideoEngineLog.d("VodSettings", "setting query " + buildURLString);
                        SettingsHelper.this.mNetClient.startTask(buildURLString, null, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.setting.SettingsHelper.2.1
                            @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
                            public void onCompletion(JSONObject jSONObject, Error error) {
                                TTVideoEngineLog.d("VodSettings", "setting result " + jSONObject);
                                if (error != null) {
                                    aVar.a((JSONObject) null, new Error(" fail. info: " + error));
                                    return;
                                }
                                if (jSONObject != null) {
                                    aVar.a(jSONObject, (Error) null);
                                }
                            }
                        });
                    }
                }
            });
        }
        return this;
    }

    public void setEnable(int i) {
        this.mEnable = i;
        if (a.e() != null) {
            config().load(MODULE_ALL);
        }
    }

    private void addLicenseInfo(Map<String, Object> map) {
        List<String> licenseIds = InfoWrapper.getLicenseIds();
        if (licenseIds != null && !licenseIds.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < licenseIds.size(); i++) {
                String str = licenseIds.get(i);
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
            map.put("volc_license_ids", sb);
        }
    }

    private void addSignatureInfo(Map<String, Object> map) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        String md5 = TTHelper.md5(context.getPackageName());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String signature = getSignature(md5, currentTimeMillis);
        map.put("bundle_id", md5);
        map.put("timestamp", Long.valueOf(currentTimeMillis));
        map.put("signature", signature);
    }

    public int getMDLInt(String str, int i) {
        if (this.mEnable == 0) {
            return i;
        }
        return this.mSettingsManager.p("mdl", str, i);
    }

    public long getMDLLong(String str, long j) {
        if (this.mEnable == 0) {
            return j;
        }
        return this.mSettingsManager.t("mdl", str, j);
    }

    public String getMDLString(String str, String str2) {
        if (this.mEnable == 0) {
            return str2;
        }
        return this.mSettingsManager.u("mdl", str, str2);
    }

    public int getVodInt(String str, int i) {
        if (this.mEnable == 0) {
            return i;
        }
        return this.mSettingsManager.p("vod", str, i);
    }

    public long getVodLong(String str, long j) {
        if (this.mEnable == 0) {
            return j;
        }
        return this.mSettingsManager.t("vod", str, j);
    }

    public String getVodString(String str, String str2) {
        if (this.mEnable == 0) {
            return str2;
        }
        return this.mSettingsManager.u("vod", str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ss.ttvideoengine.setting.SettingsHelper setRegionHost(int r1, java.lang.String r2) {
        /*
            r0 = this;
            switch(r1) {
                case 116: goto Lc;
                case 117: goto L8;
                case 118: goto L4;
                default: goto L3;
            }
        L3:
            goto Lf
        L4:
            com.bytedance.vodsetting.a.j(r2)
            goto Lf
        L8:
            com.bytedance.vodsetting.a.i(r2)
            goto Lf
        Lc:
            com.bytedance.vodsetting.a.h(r2)
        Lf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.setting.SettingsHelper.setRegionHost(int, java.lang.String):com.ss.ttvideoengine.setting.SettingsHelper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifyListener(String str, int i) {
        this.mListenerLock.readLock().lock();
        ArrayList arrayList = new ArrayList(this.mListeners);
        this.mListenerLock.readLock().unlock();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ISettingsListener iSettingsListener = (ISettingsListener) it2.next();
            if (i == 1000 && str == MODULE_BIZ_PORTRAIT) {
                iSettingsListener.onNotify(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildURLString(String str, Map<String, String> map) {
        if (str != null && map != null && !map.isEmpty()) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return buildUpon.build().toString();
        }
        return str;
    }

    private String getSignature(String str, long j) {
        return TTHelper.hmacSha1(str + "&" + BaseAppInfo.mAppID + "&" + this.mDeviceId + "&" + DeviceUtil.getDeviceModel().toLowerCase() + "&" + j);
    }

    private static class MyListener implements f {
        static {
            Covode.recordClassIndex(652678);
        }

        private MyListener() {
        }

        public void onNotify(String str, int i) {
            JSONObject jsonObject = HelperHolder.Instance.getJsonObject(str);
            if (jsonObject != null) {
                StrategyHelper.helper().getCenter().J(str, jsonObject.toString());
                PortraitEngine.getInstance().updateLabelBySettings(str, jsonObject.toString());
                if (str.equals("vod") || str.equals("mdl")) {
                    ConfigCenter.getInstance().updateVodSettings(str, jsonObject);
                }
            }
            SettingsHelper.helper()._notifyListener(str, i);
        }
    }
}

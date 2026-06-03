package com.ss.ttvideoengine.strategrycenter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.strategy.ILogCallback;
import com.bytedance.vcloud.strategy.IStrategyEventListener;
import com.bytedance.vcloud.strategy.IStrategyStateSupplier;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.database.IKVStorage;
import com.ss.ttvideoengine.database.IKVStorageProvider;
import com.ss.ttvideoengine.database.KVDBManager;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.model.BareVideoModel;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.portrait.PortraitChangeListener;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preload.PreloadScene;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategyContext;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyHelper {
    private IStrategyEventListener mEventListener;
    private com.bytedance.vcloud.strategy.StrategyCenter mCenter = null;
    private IStrategyStateSupplier mSupplier = null;
    private IPortraitService mPortraitService = null;
    private boolean mDidSetAppInfo = false;
    private long mIOManager = 0;
    private long mIOManagerVersion = 0;
    private Context mContext = null;
    private int mLogLevel = 5;
    private int mAppID = 0;
    private boolean mCheckPlayerVer = false;
    private boolean mPlayerIsMatch = false;
    private TTNetworkStateCallback mNetWorkChangeCb = null;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr = null;
    private final ReentrantLock mLock = new ReentrantLock();
    private DBHelper mDBHelper = null;
    private Map<Integer, Integer> mModuleSwitchMap = new ConcurrentHashMap(5);
    private StrategyEvent mInnerEvent = new StrategyEvent();
    private Map<Integer, Integer> mSettingMap = new ConcurrentHashMap();
    private Map<Integer, String> mJsonStringMap = new ConcurrentHashMap();
    private IKVStorageProvider mStorageProvider = null;
    private int mEnableSpeedInfoUpdate = 0;
    private boolean mSpeedInfoUpdate = true;
    private float mLastBandwidth = -1.0f;
    private ReentrantLock mSpeedLock = new ReentrantLock();

    static {
        Covode.recordClassIndex(652716);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _netState(int i) {
        if (i == -1) {
            return 0;
        }
        if (i == 0) {
            return 20;
        }
        return (i == 2 || i == 3 || i == 1 || i == 4) ? 10 : -1;
    }

    private static class StrategyHelperHolder {
        private static final StrategyHelper Instance;

        private StrategyHelperHolder() {
        }

        static {
            Covode.recordClassIndex(652721);
            Instance = new StrategyHelper();
        }
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public IStrategyStateSupplier getSupplier() {
        return this.mSupplier;
    }

    public boolean playerIsMatch() {
        return this.mPlayerIsMatch;
    }

    public static StrategyHelper helper() {
        return StrategyHelperHolder.Instance;
    }

    public boolean isRunning() {
        return getCenter().b;
    }

    public boolean needCheckPlayerVersion() {
        return !this.mCheckPlayerVer;
    }

    private final class DBHelper {
        Context mContext;
        private final ArrayList<String> mIndexArray = new ArrayList<>();
        IKVStorage mKVStorage = null;
        final int mMaxCacheNum = 2000;
        WeakReference<StrategyHelper> mSHelper;

        static {
            Covode.recordClassIndex(652717);
        }

        private void _saveDataIndexes() {
            this.mKVStorage.putString("data_index", indexToString(this.mIndexArray));
        }

        public void loadDB() {
            try {
                if (!_create()) {
                    TTVideoEngineLog.e("VCStrategy", "create db fail.");
                } else {
                    _loadData();
                }
            } catch (Throwable th) {
                TTVideoEngineLog.d(th);
            }
        }

        public void clear() {
            try {
                this.mKVStorage.clear();
            } catch (Throwable th) {
                TTVideoEngineLog.e("VCStrategy", "clear fail. " + th.toString());
            }
        }

        private boolean _create() {
            if (this.mKVStorage == null) {
                if (StrategyHelper.this.mStorageProvider != null) {
                    this.mKVStorage = StrategyHelper.this.mStorageProvider.getKVStorage("TTVideoEngine_vod_strategy_database_v01");
                    TTVideoEngineLog.d("VCStrategy", "use kv storage provider");
                } else {
                    this.mKVStorage = new KVDBManager(this.mContext, "TTVideoEngine_vod_strategy_database_v01");
                    TTVideoEngineLog.d("VCStrategy", "use KVDBManager");
                    return ((KVDBManager) this.mKVStorage).isCreateDBSuccess();
                }
            }
            if (this.mKVStorage != null) {
                return true;
            }
            return false;
        }

        private void _loadData() {
            ArrayList<String> stringToStringArray;
            StrategyHelper strategyHelper = this.mSHelper.get();
            if (strategyHelper != null && (stringToStringArray = stringToStringArray(this.mKVStorage.getString("data_index"))) != null && !stringToStringArray.isEmpty()) {
                this.mIndexArray.addAll(stringToStringArray);
                Iterator<String> it2 = stringToStringArray.iterator();
                while (it2.hasNext()) {
                    String string = this.mKVStorage.getString(it2.next());
                    if (!TextUtils.isEmpty(string)) {
                        strategyHelper.getCenter().h(31210, string);
                    }
                }
            }
        }

        private String indexToString(ArrayList<String> arrayList) {
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder(arrayList.size());
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i));
                    if (i < arrayList.size() - 1) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            return null;
        }

        private ArrayList<String> stringToStringArray(String str) {
            ArrayList<String> arrayList = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split(",");
                if (split == null || split.length <= 0) {
                    return null;
                }
                ArrayList<String> arrayList2 = new ArrayList<>();
                try {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList2.add(str2);
                        }
                    }
                    return arrayList2;
                } catch (Throwable th) {
                    th = th;
                    arrayList = arrayList2;
                    TTVideoEngineLog.d(th);
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public void removeData(String str) {
            try {
                this.mIndexArray.remove(str);
                this.mKVStorage.removeString(str);
                _saveDataIndexes();
            } catch (Throwable th) {
                TTVideoEngineLog.e("VCStrategy", "remove data fail. " + th.toString());
            }
        }

        public void loadKeyValue(String str) {
            try {
                if (!_create()) {
                    TTVideoEngineLog.e("VCStrategy", "create db fail.");
                    return;
                }
                StrategyHelper strategyHelper = this.mSHelper.get();
                if (strategyHelper == null) {
                    return;
                }
                strategyHelper.getCenter().h(31212, this.mKVStorage.getString(str));
            } catch (Throwable th) {
                TTVideoEngineLog.e("VCStrategy", "load key value fail. " + th.toString());
            }
        }

        public void saveKeyValue(String str, String str2) {
            try {
                this.mKVStorage.putString(str, str2);
            } catch (Throwable th) {
                TTVideoEngineLog.e("VCStrategy", "save key value fail. " + th.toString());
            }
        }

        public void saveData(String str, String str2) {
            try {
                this.mIndexArray.add(str);
                if (this.mIndexArray.size() > 2000) {
                    this.mKVStorage.removeString(this.mIndexArray.remove(0));
                }
                _saveDataIndexes();
                this.mKVStorage.putString(str, str2);
            } catch (Throwable th) {
                TTVideoEngineLog.e("VCStrategy", "save data fail. " + th.toString());
            }
        }

        public DBHelper(Context context, StrategyHelper strategyHelper) {
            this.mSHelper = null;
            this.mContext = context;
            this.mSHelper = new WeakReference<>(strategyHelper);
        }

        public void event(int i, String str, String str2) {
            switch (i) {
                case 1:
                    loadDB();
                    break;
                case 2:
                    saveData(str, str2);
                    break;
                case 3:
                    removeData(str);
                    break;
                case 4:
                    saveKeyValue(str, str2);
                    break;
                case 5:
                    loadKeyValue(str);
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    clear();
                    break;
            }
        }
    }

    public void speedInfoUpdate() {
        this.mSpeedLock.lock();
        try {
            TTVideoEngineLog.d("VCStrategy", "speed info update");
            this.mSpeedInfoUpdate = true;
        } finally {
            this.mSpeedLock.unlock();
        }
    }

    private void _netStateListener() {
        if (this.mNetWorkChangeCb != null) {
            return;
        }
        this.mNetWorkChangeCb = new TTNetworkStateCallback() { // from class: com.ss.ttvideoengine.strategrycenter.StrategyHelper.3
            @Override // com.ss.ttvideoengine.TTNetworkStateCallback
            public void onAccessChanged(int i, int i2, int i3) {
                if (i == 0) {
                    StrategyHelper.this.getCenter().e(1202, StrategyHelper._netState(i3));
                }
            }
        };
        if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 16L)) {
            this.mNetWorkChangeCbr = new WeakReference<>(this.mNetWorkChangeCb);
            TTNetWorkListener.getInstance().startListen(this.mNetWorkChangeCbr);
        }
    }

    public com.bytedance.vcloud.strategy.StrategyCenter getCenter() {
        if (this.mCenter == null) {
            this.mLock.lock();
            try {
                if (this.mCenter == null) {
                    this.mCenter = new com.bytedance.vcloud.strategy.StrategyCenter(new MyIStrategyEventListener(this));
                }
            } finally {
                this.mLock.unlock();
            }
        }
        return this.mCenter;
    }

    private void _configParams() {
        this.mDBHelper = new DBHelper(this.mContext, this);
        getCenter().G(10000, this.mLogLevel);
        getCenter().G(801, StrategyKeys.mInteractionBlockDurationPreloaded);
        getCenter().G(802, StrategyKeys.mInteractionBlockDurationNonPreloaded);
        for (Map.Entry<Integer, String> entry : this.mJsonStringMap.entrySet()) {
            getCenter().C(entry.getKey().intValue(), entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry2 : this.mSettingMap.entrySet()) {
            getCenter().G(entry2.getKey().intValue(), entry2.getValue().intValue());
        }
    }

    public float getNetworkSpeed() {
        if (this.mEnableSpeedInfoUpdate == 0) {
            return helper().getCenter().n(20401, -1.0f);
        }
        this.mSpeedLock.lock();
        try {
            if (!this.mSpeedInfoUpdate && this.mLastBandwidth > 0.0f) {
                TTVideoEngineLog.d("VCStrategy", "speed doesnt need to be updated, update: " + this.mSpeedInfoUpdate + ", last: " + this.mLastBandwidth);
                return this.mLastBandwidth;
            }
            float n = helper().getCenter().n(20401, -1.0f);
            if (n > 0.0f) {
                TTVideoEngineLog.d("VCStrategy", "speed update success, result: " + n);
                this.mLastBandwidth = n;
                this.mSpeedInfoUpdate = false;
            }
            return this.mLastBandwidth;
        } finally {
            this.mSpeedLock.unlock();
        }
    }

    public void enableSpeedInfoUpdate(int i) {
        this.mEnableSpeedInfoUpdate = i;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setKVStorageProvider(IKVStorageProvider iKVStorageProvider) {
        this.mStorageProvider = iKVStorageProvider;
    }

    public void setSupplier(IStrategyStateSupplier iStrategyStateSupplier) {
        this.mSupplier = iStrategyStateSupplier;
    }

    static class MyALogCallBak implements ILogCallback {
        static {
            Covode.recordClassIndex(652718);
        }

        MyALogCallBak() {
        }

        public void log(String str) {
            TTVideoEngineLog.i("VCStrategy", str);
        }
    }

    public Map<String, Object> getLogData(String str) {
        return this.mInnerEvent.getLogData(str);
    }

    public Map<String, Object> popOneEventLog(String str) {
        return this.mInnerEvent.popLogData(1, str);
    }

    public Map<String, Object> popOnePlayLog(String str) {
        return this.mInnerEvent.popLogData(0, str);
    }

    public void removeLogData(String str) {
        this.mInnerEvent.removeLogData(str);
    }

    public void setLogLevel(int i) {
        getCenter().G(10000, i);
        this.mLogLevel = i;
    }

    public void setEventListener(IStrategyEventListener iStrategyEventListener) {
        this.mLock.lock();
        try {
            this.mEventListener = iStrategyEventListener;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String _mapToString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    jSONObject.put(key, value);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private String _objectMapToString(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    jSONObject.put(key, value);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private Map<String, Integer> _stringToIntValueMap(String str) {
        if (str != null && str.length() >= 2) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                try {
                    try {
                        String[] split = str2.split(":");
                        if (split.length == 2) {
                            hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                        }
                    } catch (NumberFormatException e) {
                        TTVideoEngineLog.d(e);
                        return hashMap;
                    }
                } catch (Throwable unused) {
                    return hashMap;
                }
            }
            return hashMap;
        }
        return null;
    }

    public boolean checkPlayerVersion(int i) {
        if (i != -1 && getCenter().s()) {
            boolean z = true;
            this.mCheckPlayerVer = true;
            if (getCenter().q() != i) {
                z = false;
            }
            this.mPlayerIsMatch = z;
        }
        return this.mPlayerIsMatch;
    }

    public boolean loadPluginLibrary(LibraryLoaderProxy libraryLoaderProxy) {
        this.mLock.lock();
        try {
            return libraryLoaderProxy.loadLibrary("preload");
        } catch (Throwable th) {
            try {
                TTVideoEngineLog.i("VCStrategy", th.toString());
                this.mLock.unlock();
                return false;
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void setPortraitService(IPortraitService iPortraitService) {
        this.mLock.lock();
        try {
            if (this.mPortraitService == null && iPortraitService != null) {
                getCenter().E(new MyAppServer(this));
            }
            this.mPortraitService = iPortraitService;
        } finally {
            this.mLock.unlock();
        }
    }

    public void start(boolean z) {
        getCenter();
        this.mLock.lock();
        try {
            internalStart(z);
        } finally {
            try {
            } finally {
            }
        }
    }

    public int moduleSwitch(int i) {
        if (i < 803 || i > 807) {
            TTVideoEngineLog.i("VCStrategy", "get module switch key is wrong" + i);
        }
        if (!this.mModuleSwitchMap.containsKey(Integer.valueOf(i))) {
            if (!getCenter().b) {
                return 0;
            }
            this.mModuleSwitchMap.put(Integer.valueOf(i), Integer.valueOf(getCenter().o(i, 0)));
        }
        return ((Integer) TTHelper.nonNullElse(this.mModuleSwitchMap.get(Integer.valueOf(i)), 0)).intValue();
    }

    private void internalStart(boolean z) {
        String str;
        TTVideoEngineLog.i("VCStrategy", "internalStart needLoadLibrary=" + z);
        getCenter().i(this.mContext, z);
        if (!getCenter().s()) {
            TTVideoEngineLog.i("VCStrategy", "internalStart isLoadLibrarySucceed false");
            return;
        }
        _configParams();
        _netStateListener();
        if (this.mJsonStringMap.get(31001) == null) {
            if (this.mAppID == 32) {
                str = "{\"strategy_center_v1\":{\"feed\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"fullscreen_immersive\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"story\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}}}}";
            } else {
                str = "{\"strategy_center_v1\":{\"engine_default\":{\"preload_strategy\":{\"name\":\"default\",\"tasks\":[{\"download_progress\":100,\"count\":5,\"offset\":0,\"size\":800}]}},\"video_range_request\":{\"enable_concurrent_download\":0,\"allowed_segment_download\":0,\"fixed_size\":3000,\"fixed_duration\":10}}}";
            }
            setAlgorithmJson(31001, str);
        }
        getCenter().F(this.mIOManager, this.mIOManagerVersion);
        if (!getCenter().r()) {
            TTVideoEngineLog.i("VCStrategy", "io manager interface not match, start fail.");
            return;
        }
        getCenter().H(new MyALogCallBak());
        if (this.mPortraitService != null) {
            getCenter().E(new MyAppServer(this));
        }
        JSONObject jsonObject = SettingsHelper.helper().getJsonObject(SettingsHelper.MODULE_VOD);
        if (jsonObject != null) {
            getCenter().J(SettingsHelper.MODULE_VOD, jsonObject.toString());
        }
        PreloadScene preloadScene = new PreloadScene("engine_default");
        preloadScene.mSceneId = "engine_default";
        preloadScene.mBriefSceneId = "engine_brief_default";
        preloadScene.mAutoPlay = 1;
        preloadScene.mMute = 0;
        preloadScene.mMaxVisibleCardCnt = 1;
        preloadScene.setAlgorithmName("engine_default");
        helper().getCenter().k(preloadScene.toJsonString());
        getCenter().L(new com.bytedance.vcloud.strategy.IStrategyStateSupplier() { // from class: com.ss.ttvideoengine.strategrycenter.StrategyHelper.1
            public /* synthetic */ String downloadSourceJsonString(String str2) {
                return IStrategyStateSupplier.-CC.$default$downloadSourceJsonString(this, str2);
            }

            public double getNetworkScore() {
                return PortraitNetworkScore.getInstance().getLastTargetBitrate();
            }

            public int getNetworkType() {
                return StrategyHelper._netState(TTNetWorkListener.getInstance().getCurrentAccessType());
            }

            public double getNetworkSpeed() {
                if (StrategyHelper.this.mSupplier != null) {
                    return StrategyHelper.this.mSupplier.getNetworkSpeed();
                }
                return 0.0d;
            }

            public String mediaInfoJsonString(String str2) {
                Map<String, Object> mediaInfo;
                if (StrategyHelper.this.mSupplier == null || (mediaInfo = StrategyHelper.this.mSupplier.mediaInfo(str2)) == null) {
                    return null;
                }
                try {
                    return new JSONObject(mediaInfo).toString();
                } catch (Throwable th) {
                    TTVideoEngineLog.d(th);
                    return null;
                }
            }

            public String selectBitrateJsonString(String str2, int i) {
                Map<String, Integer> selectBitrate;
                if (StrategyHelper.this.mSupplier == null || (selectBitrate = StrategyHelper.this.mSupplier.selectBitrate(str2, i)) == null) {
                    return null;
                }
                try {
                    return new JSONObject(selectBitrate).toString();
                } catch (Throwable th) {
                    TTVideoEngineLog.d(th);
                    return null;
                }
            }

            public String selectBitrateJsonString(String str2, String str3, int i) {
                Map<String, Integer> selectBitrate;
                if (StrategyHelper.this.mSupplier == null || (selectBitrate = StrategyHelper.this.mSupplier.selectBitrate(new StrategyMediaParam(str2, str3, i))) == null) {
                    return null;
                }
                try {
                    return new JSONObject(selectBitrate).toString();
                } catch (Throwable th) {
                    TTVideoEngineLog.d(th);
                    return null;
                }
            }

            public String onAfterSelect(String str2, String str3, int i, Object obj) {
                IGearStrategyListener iGearStrategyListener;
                GearStrategyContext gearStrategyContext;
                TTVideoEngine tTVideoEngine;
                Object obj2;
                GearStrategyConfig gearStrategyConfig;
                TTVideoEngineLog.i("VCStrategy", "[GearStrategy] StrategyHelper.onAfterSelect type=" + i + " context=" + obj);
                if (obj instanceof GearStrategyContext) {
                    gearStrategyContext = (GearStrategyContext) obj;
                    iGearStrategyListener = gearStrategyContext.getGearStrategyListener();
                } else {
                    iGearStrategyListener = null;
                    gearStrategyContext = null;
                }
                if (iGearStrategyListener == null && (gearStrategyConfig = TTVideoEngine.getGearStrategyConfig()) != null) {
                    iGearStrategyListener = gearStrategyConfig.getGearStrategyListener();
                }
                if (iGearStrategyListener == null) {
                    TTVideoEngineLog.i("VCStrategy", "listener is null");
                    return str3;
                }
                if (gearStrategyContext != null) {
                    obj2 = gearStrategyContext.getUserData();
                    WeakReference<TTVideoEngine> videoEngineRef = gearStrategyContext.getVideoEngineRef();
                    if (videoEngineRef != null) {
                        tTVideoEngine = videoEngineRef.get();
                    } else {
                        tTVideoEngine = null;
                    }
                } else {
                    tTVideoEngine = null;
                    obj2 = null;
                }
                HashMap hashMap = new HashMap();
                StrategyHelper.this._stringToMap(str3, hashMap);
                if (tTVideoEngine != null) {
                    tTVideoEngine.setLoggerLongOption(109, System.currentTimeMillis());
                }
                iGearStrategyListener.onAfterSelect(null, hashMap, i, obj2);
                if (tTVideoEngine != null) {
                    tTVideoEngine.setLoggerLongOption(110, System.currentTimeMillis());
                    if (hashMap.containsKey("video_bitrarte_user_selected")) {
                        try {
                            tTVideoEngine.setLoggerLongOption(101, Long.parseLong(hashMap.get("video_bitrarte_user_selected")));
                        } catch (NumberFormatException unused) {
                        }
                        tTVideoEngine.setLoggerIntOption(102, 9);
                        return "";
                    }
                    if (hashMap.containsKey("video_bitrate")) {
                        try {
                            tTVideoEngine.setLoggerLongOption(101, Long.parseLong(hashMap.get("video_bitrate")));
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    if (hashMap.containsKey("select_reason")) {
                        try {
                            tTVideoEngine.setLoggerIntOption(102, Integer.parseInt(hashMap.get("select_reason")));
                        } catch (NumberFormatException unused3) {
                        }
                    }
                    if (hashMap.containsKey("speed")) {
                        try {
                            tTVideoEngine.setLoggerLongOption(103, Long.parseLong(hashMap.get("speed")));
                        } catch (NumberFormatException unused4) {
                        }
                    }
                    if (hashMap.containsKey(104)) {
                        try {
                            tTVideoEngine.setLoggerIntOption(104, Integer.parseInt(hashMap.get("error_code")));
                            return "";
                        } catch (NumberFormatException unused5) {
                            return "";
                        }
                    }
                    return "";
                }
                return "";
            }

            public String onBeforeSelect(String str2, String str3, int i, Object obj) {
                GearStrategyContext gearStrategyContext;
                IGearStrategyListener iGearStrategyListener;
                TTVideoEngine tTVideoEngine;
                Object obj2;
                GearStrategyConfig gearStrategyConfig;
                TTVideoEngineLog.i("VCStrategy", "[GearStrategy] StrategyHelper.onBeforeSelect type=" + i + " context=" + obj);
                IVideoModel iVideoModel = null;
                TTVideoEngine tTVideoEngine2 = null;
                if (obj instanceof GearStrategyContext) {
                    gearStrategyContext = (GearStrategyContext) obj;
                    iGearStrategyListener = gearStrategyContext.getGearStrategyListener();
                } else {
                    gearStrategyContext = null;
                    iGearStrategyListener = null;
                }
                if (iGearStrategyListener == null && (gearStrategyConfig = TTVideoEngine.getGearStrategyConfig()) != null) {
                    iGearStrategyListener = gearStrategyConfig.getGearStrategyListener();
                }
                if (iGearStrategyListener == null) {
                    TTVideoEngineLog.i("VCStrategy", "listener is null");
                    return str3;
                }
                if (gearStrategyContext != null) {
                    obj2 = gearStrategyContext.getUserData();
                    IVideoModel videoModel = gearStrategyContext.getVideoModel();
                    WeakReference<TTVideoEngine> videoEngineRef = gearStrategyContext.getVideoEngineRef();
                    if (videoEngineRef != null) {
                        tTVideoEngine2 = videoEngineRef.get();
                    }
                    tTVideoEngine = tTVideoEngine2;
                    iVideoModel = videoModel;
                } else {
                    tTVideoEngine = null;
                    obj2 = null;
                }
                if (iVideoModel == null) {
                    iVideoModel = new BareVideoModel.Builder().build();
                    iVideoModel.fromMediaInfoJsonString(str2);
                }
                HashMap hashMap = new HashMap();
                StrategyHelper.this._stringToMap(str3, hashMap);
                if (tTVideoEngine != null) {
                    tTVideoEngine.setLoggerLongOption(107, System.currentTimeMillis());
                }
                iGearStrategyListener.onBeforeSelect(iVideoModel, hashMap, i, obj2);
                if (tTVideoEngine != null) {
                    tTVideoEngine.setLoggerLongOption(108, System.currentTimeMillis());
                }
                StrategyHelper.this.getCenter().P(iVideoModel.getVideoRefStr(2), "", iVideoModel.toMediaInfoJsonString());
                return StrategyHelper.this._mapToString(hashMap);
            }
        });
        getCenter().N(this.mContext, z);
        helper().getCenter().O("engine_default");
        Map<String, Object> allLabels = PortraitEngine.getInstance().getAllLabels();
        if (allLabels != null) {
            try {
                getCenter().h(31214, new JSONObject(allLabels).toString());
            } catch (Exception unused) {
            }
        }
        PortraitEngine.getInstance().addPortraitListener(new PortraitChangeListener() { // from class: com.ss.ttvideoengine.strategrycenter.StrategyHelper.2
            @Override // com.ss.ttvideoengine.portrait.PortraitChangeListener
            public void onPortraitChange(String str2, Object obj) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(str2, obj);
                } catch (Exception unused2) {
                }
                StrategyHelper.this.getCenter().h(31214, jSONObject.toString());
            }
        });
    }

    public void setDaspNonPlaySignal(int i, List<DaspSignal> list) {
        _setDaspSignal(i, list, null);
    }

    public void setDaspPlaySignal(String str, List<DaspSignal> list) {
        _setDaspSignal(31224, list, str);
    }

    class MyAppServer implements IAppService {
        private WeakReference<StrategyHelper> mHelper;

        static {
            Covode.recordClassIndex(652719);
        }

        MyAppServer(StrategyHelper strategyHelper) {
            this.mHelper = null;
            this.mHelper = new WeakReference<>(strategyHelper);
        }

        public String getPortraits(String str, String str2) {
            StrategyHelper strategyHelper = this.mHelper.get();
            if (strategyHelper != null && strategyHelper.mPortraitService != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "group");
                hashMap.put("name", str2);
                hashMap.put("from", str);
                Map<String, String> portraits = strategyHelper.mPortraitService.getPortraits(hashMap);
                if (portraits != null) {
                    return new JSONObject(portraits).toString();
                }
            }
            return null;
        }

        public String getPortrait(String str, String str2) {
            StrategyHelper strategyHelper = this.mHelper.get();
            if (strategyHelper != null && strategyHelper.mPortraitService != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "one");
                hashMap.put("from", str);
                hashMap.put("name", str2);
                Map<String, String> portraits = strategyHelper.mPortraitService.getPortraits(hashMap);
                if (portraits != null && portraits.containsKey(str2)) {
                    return portraits.get(str2);
                }
                return "";
            }
            return null;
        }

        public void addGroupConfig(String str, String str2, String str3) {
            StrategyHelper strategyHelper = this.mHelper.get();
            if (strategyHelper != null && strategyHelper.mPortraitService != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                } catch (Throwable unused) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put("from", str);
                hashMap.put("name", str2);
                strategyHelper.mPortraitService.addGroupConfig(hashMap, arrayList);
            }
        }

        public String getMediaPortrait(String str, String str2, String str3) {
            StrategyHelper strategyHelper = this.mHelper.get();
            if (strategyHelper != null && strategyHelper.mPortraitService != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "one");
                hashMap.put("name", str3);
                hashMap.put("video_id", str2);
                hashMap.put("from", str);
                Map<String, String> portraits = strategyHelper.mPortraitService.getPortraits(hashMap);
                if (portraits != null) {
                    return new JSONObject(portraits).toString();
                }
            }
            return null;
        }

        public String getMediaPortraits(String str, String str2, String str3) {
            StrategyHelper strategyHelper = this.mHelper.get();
            if (strategyHelper != null && strategyHelper.mPortraitService != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "group");
                hashMap.put("name", str3);
                hashMap.put("video_id", str2);
                hashMap.put("from", str);
                Map<String, String> portraits = strategyHelper.mPortraitService.getPortraits(hashMap);
                if (portraits != null) {
                    return new JSONObject(portraits).toString();
                }
            }
            return null;
        }
    }

    class MyIStrategyEventListener implements com.bytedance.vcloud.strategy.IStrategyEventListener {
        private WeakReference<StrategyHelper> mHelper;

        static {
            Covode.recordClassIndex(652720);
        }

        public /* bridge */ /* synthetic */ void strategyConfigGlobalOption(int i, int i2, Object obj) {
            IStrategyEventListener.-CC.$default$strategyConfigGlobalOption(this, i, i2, obj);
        }

        MyIStrategyEventListener(StrategyHelper strategyHelper) {
            this.mHelper = null;
            this.mHelper = new WeakReference<>(strategyHelper);
        }

        public void onEventLog(String str, String str2) {
            TTVideoEngineLog.d("VCStrategy", "eventName: " + str + ", logInfo: " + str2);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    VideoEventManager.instance.addEventV2(true, new JSONObject(str2), str);
                } catch (JSONException e) {
                    TTVideoEngineLog.d(e);
                }
            }
        }

        public void onEvent(String str, int i, int i2, String str2) {
            TTVideoEngineLog.i("VCStrategy", "on event, videoID = " + str + ", key = " + i + ", value = " + i2 + ", info = " + str2);
            if (i == 2019) {
                StrategyHelper strategyHelper = this.mHelper.get();
                if (strategyHelper != null && strategyHelper.mDBHelper != null) {
                    strategyHelper.mDBHelper.event(i2, str, str2);
                    return;
                }
                return;
            }
            StrategyHelper.this.mInnerEvent.event(str, i, i2, str2);
            StrategyHelper.this.mLock.lock();
            if (StrategyHelper.this.mEventListener != null) {
                StrategyHelper.this.mLock.unlock();
                if (i == 2012 || i >= 2500) {
                    StrategyHelper.this.mEventListener.onEvent(str, i, i2, str2);
                    return;
                }
                return;
            }
            StrategyHelper.this.mLock.unlock();
        }
    }

    public Map<String, Object> getLogData(String str, String str2) {
        return this.mInnerEvent.getLogData(str, str2);
    }

    public void setIOManager(long j, long j2) {
        this.mLock.lock();
        try {
            this.mIOManager = j;
            this.mIOManagerVersion = j2;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> _stringToMap(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                        map.put(next, string);
                    }
                }
            } catch (Exception unused) {
            }
            return map;
        }
        return null;
    }

    public void configAppInfo(String str, Map map) {
        if (!this.mDidSetAppInfo && getCenter().s()) {
            getCenter().D(str);
            this.mDidSetAppInfo = true;
        }
        if (map != null && map.containsKey("appid")) {
            this.mAppID = TTHelper.parseInt(map.get("appid"));
        }
    }

    public void setAlgorithmJson(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.i("VCStrategy", "[preload] Algorithm json " + str);
            return;
        }
        if (getCenter().s()) {
            getCenter().C(i, str);
        } else {
            this.mJsonStringMap.put(Integer.valueOf(i), str);
        }
    }

    public void setIntValue(int i, int i2) {
        if (i > 50000 && i < 60000) {
            if (i >= 58000 && i <= 58999 && i == 58001) {
                enableSpeedInfoUpdate(i2);
            }
            if (getCenter().s()) {
                getCenter().G(i, i2);
            } else {
                this.mSettingMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public void setStringValue(int i, String str) {
        if (i > 50000 && i < 60000) {
            if (getCenter().s()) {
                getCenter().M(i, str);
            } else {
                this.mJsonStringMap.put(Integer.valueOf(i), str);
            }
        }
    }

    public Map<String, String> selectResolutionStringMapV2(IVideoModel iVideoModel, int i, Map<String, Object> map) {
        TTVideoEngineLog.i("VCStrategy", "[GearStrategy]GearStrategy called");
        String B = getCenter().B(iVideoModel.getMediaInfo(), i, _objectMapToString(map), (Object) null);
        if (TextUtils.isEmpty(B)) {
            TTVideoEngineLog.d("VCStrategy", "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + B);
            return null;
        }
        HashMap hashMap = new HashMap();
        _stringToMap(B, hashMap);
        return hashMap;
    }

    public static void buildMaskInfo(Map map, String str, String str2) {
        List arrayList;
        try {
            if (map.containsKey("infos")) {
                arrayList = (List) map.get("infos");
            } else {
                arrayList = new ArrayList();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("file_hash", str2);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("urls", new String[]{str});
            }
            hashMap.put("media_type", "mask");
            arrayList.add(hashMap);
            map.put("infos", arrayList);
        } catch (Throwable th) {
            TTVideoEngineLog.e("VCStrategy", th.toString());
        }
    }

    private void _setDaspSignal(int i, List<DaspSignal> list, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (DaspSignal daspSignal : list) {
                if (daspSignal != null && daspSignal.name != null && daspSignal.value != null) {
                    TTVideoEngineLog.d("DaspSignal", "name: " + daspSignal.name + ", value: " + daspSignal.value);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("value", daspSignal.value);
                    if (str != null) {
                        jSONObject2.put("traceId", str);
                    }
                    jSONObject.put(daspSignal.name, jSONObject2);
                }
            }
            String jSONObject3 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject3)) {
                TTVideoEngineLog.d("DaspSignal", "key: " + i + ", traceId: " + str + ", signalJson: " + jSONObject3);
                getCenter().h(i, jSONObject3);
            }
        } catch (JSONException e) {
            TTVideoEngineLog.e("DaspSignal", "Failed to create Dasp signal JSON: " + e);
        }
    }

    public Map<String, Integer> selectResolution(IVideoModel iVideoModel, int i, Map<String, String> map, GearStrategyContext gearStrategyContext) {
        String z = getCenter().z(iVideoModel.toMediaInfoJsonString(), i, _mapToString(map), gearStrategyContext);
        if (TextUtils.isEmpty(z)) {
            TTVideoEngineLog.d("VCStrategy", "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + z);
            return null;
        }
        return _stringToIntValueMap(z);
    }

    public static void buildMediaInfo(Map map, String str, String str2, String[] strArr) {
        List arrayList;
        try {
            if (map.containsKey("infos")) {
                arrayList = (List) map.get("infos");
            } else {
                arrayList = new ArrayList();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("urls", strArr);
            hashMap.put("file_hash", str2);
            arrayList.add(hashMap);
            if (TextUtils.isEmpty(str)) {
                str = str2;
            }
            map.put("vid", str);
            map.put("infos", arrayList);
        } catch (Throwable th) {
            TTVideoEngineLog.e("VCStrategy", th.toString());
        }
    }

    public Map<String, Integer> selectResolutionStringMap(IVideoModel iVideoModel, int i, Map<String, String> map, GearStrategyContext gearStrategyContext) {
        String A;
        String str;
        String str2;
        TTVideoEngineLog.i("VCStrategy", "[GearStrategy]GearStrategy called");
        if (EngineGlobalConfig.getInstance().getEnableSelectUseObject() == 1) {
            A = getCenter().B(iVideoModel.getMediaInfo(), i, _mapToString(map), gearStrategyContext);
        } else {
            A = getCenter().A(iVideoModel.toMediaInfoJsonString(), i, _mapToString(map), gearStrategyContext);
        }
        if (TextUtils.isEmpty(A)) {
            TTVideoEngineLog.d("VCStrategy", "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + A);
            return null;
        }
        HashMap hashMap = new HashMap();
        _stringToMap(A, hashMap);
        if (map != null) {
            map.putAll(hashMap);
        }
        HashMap hashMap2 = new HashMap();
        if (hashMap.containsKey("video") && (str2 = hashMap.get("video")) != null) {
            hashMap2.put("video", Integer.valueOf(Integer.parseInt(str2)));
        }
        if (hashMap.containsKey("audio") && (str = hashMap.get("audio")) != null) {
            hashMap2.put("audio", Integer.valueOf(Integer.parseInt(str)));
        }
        return hashMap2;
    }
}

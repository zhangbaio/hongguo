package com.ss.ttvideoengine.log;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.SessionIDGenerator;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventBase {
    public static String appSessionId;
    public static volatile String gNetworkType;
    public static volatile String gSigStrength;
    private static TTNetWorkListener mTTNetWorkListener;
    public boolean isUploadLogEnabled;
    public int is_multi_dimensions;
    public int is_multi_dimensionsInput;
    public Context mContext;
    public String mCurHost;
    public String mCurIP;
    public String mCurQuality;
    public String mCurResolution;
    public String mCurURL;
    public EventLoggerSource mDataSource;
    public String mDeviceId;
    public String mInitialHost;
    public String mInitialIP;
    public String mInitialURL;
    private Map mVideoInfo;
    public IVideoModel mVideoModel;
    public int speed_predict_type;
    private TTNetworkStateCallback mNetWorkChangeCb = null;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr = null;
    public String pv = "";
    public String pc = "";
    public String sv = "";
    public ArrayList<String> mGearinfoList = null;
    public String sdk_version = "";
    public String ffmpeg_version = "";
    public String libvcn_version = "";
    public String texturender_version = "";
    public String preload_version = "";
    public String abr_version = "";
    public String predict_version = "";
    public String mDNSType = "";
    public int mPlayType = Integer.MIN_VALUE;
    public String mVid = "";
    public String mMediaID = "";
    public String mSourceTypeStr = "";
    public int mVideoHW = Integer.MIN_VALUE;
    public int mVideoHWUser = Integer.MIN_VALUE;
    public int mAudioHwUser = Integer.MIN_VALUE;
    public int vd = Integer.MIN_VALUE;
    public long vs = -2147483648L;
    public String codec_type = "";
    public String a_codec_type = "";
    public int audioCodecNameId = Integer.MIN_VALUE;
    public int videoCodecNameId = Integer.MIN_VALUE;
    public int formatType = Integer.MIN_VALUE;
    public String vtype = "";
    public String dynamic_type = "";
    public String mLastResolution = "";
    public String mCurrentResolution = "";
    public int mCurrentConfigBitrate = Integer.MIN_VALUE;
    public int mP2PCDNType = Integer.MIN_VALUE;
    public String mTag = "";
    public String mSubTag = "";
    public int mReuseSocket = Integer.MIN_VALUE;
    public int mDrmType = Integer.MIN_VALUE;
    public String mDrmTokenUrl = "";
    public float mPlaySpeed = Float.MIN_VALUE;
    public String mTraceID = "";
    public String mNetworkType = "";
    public String mMdlVersion = "";
    public String mInitialQualityDesc = "";
    public String mCurrentQualityDesc = "";
    public String mOriginVid = null;
    public boolean mEnableTmpLog = false;
    public boolean mEnablePowerReport = false;
    public boolean mHasGetPreloadTraceId = false;
    public volatile int mCurDashAudioInfoId = -1;
    public MDLTrackInfo mdlVideoInfo = new MDLTrackInfo();
    public MDLTrackInfo mdlAudioInfo = new MDLTrackInfo();
    public boolean hasAudioTrackInfo = false;
    public int mdl_cur_task_num = Integer.MIN_VALUE;
    public int mdl_conc_count = Integer.MIN_VALUE;
    public String mdl_preload_info = "";
    public Map abrInfo = null;
    public Map selectResultInfo = null;
    public int is_enable_abr = Integer.MIN_VALUE;
    public int is_enable_select_bitrate = Integer.MIN_VALUE;
    public Map<String, Object> abrGeneralInfo = null;
    public int mEnableMDL = Integer.MIN_VALUE;
    public Map mdlFeatures = null;
    public int mdlP2pLoader = -1;
    public String mSessionID = SessionIDGenerator.generateSessionID(null);

    private static String _switchNetworkStrength(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "excellent" : "good" : "medium" : "weak";
    }

    private static String _switchNetworkType(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "5G" : "3G" : "2G" : "4G" : "WIFI";
    }

    public String getCurHost() {
        return this.mCurHost;
    }

    public String getCurIP() {
        return this.mCurIP;
    }

    public String getCurQuality() {
        return this.mCurQuality;
    }

    public String getCurResolution() {
        return this.mCurResolution;
    }

    public String getCurURL() {
        return this.mCurURL;
    }

    public Map getVideoInfo() {
        return this.mVideoInfo;
    }

    public void movieFinish() {
        updateVideoInfo(null);
    }

    public float getBatteryCurrent() {
        if (!this.mEnablePowerReport) {
            return -1.0f;
        }
        return DeviceMonitorUtils.getGalvanicNow(this.mContext);
    }

    public double getCPURate() {
        if (!this.mEnablePowerReport) {
            return -1.0d;
        }
        return DeviceMonitorUtils.getCPURate();
    }

    public double getCPUSpeed() {
        if (!this.mEnablePowerReport) {
            return -1.0d;
        }
        return DeviceMonitorUtils.getCPUSpeed();
    }

    public HashMap<String, Object> getChargingState() {
        if (!this.mEnablePowerReport) {
            return null;
        }
        return DeviceMonitorUtils.getChargingState(this.mContext);
    }

    public DeviceMonitorUtils.CPUInfo getCurrentCPUInfo() {
        if (!this.mEnablePowerReport) {
            return null;
        }
        return DeviceMonitorUtils.getCurrentCPUInfo();
    }

    public void reset() {
        this.mSessionID = SessionIDGenerator.generateSessionID(this.mDeviceId);
    }

    public void unregisterNetwork() {
        TTNetWorkListener tTNetWorkListener = mTTNetWorkListener;
        if (tTNetWorkListener != null) {
            tTNetWorkListener.stopListen(this.mNetWorkChangeCbr);
        }
    }

    static {
        Covode.recordClassIndex(652489);
        gNetworkType = "unknown";
        gSigStrength = "unknown";
        mTTNetWorkListener = null;
        appSessionId = null;
    }

    public static String getNetType() {
        TTNetWorkListener tTNetWorkListener;
        if (gNetworkType.equals("unknown") && (tTNetWorkListener = mTTNetWorkListener) != null) {
            gNetworkType = _switchNetworkType(tTNetWorkListener.getCurrentAccessType());
        }
        return gNetworkType;
    }

    private void initParametersIfNeeded() {
        this.mPlayType = 0;
        this.mVideoHW = 0;
        this.mVideoHWUser = 0;
        this.mAudioHwUser = 0;
        this.mTag = "default";
        this.mSubTag = "default";
        this.mPlaySpeed = 1.0f;
        this.mdlVideoInfo.mdl_cache_type = 0;
        this.mdlAudioInfo.mdl_cache_type = 0;
    }

    public static String getSignalStrength() {
        TTNetWorkListener tTNetWorkListener;
        if (gNetworkType.equals("unknown")) {
            return "unknown";
        }
        if (gSigStrength.equals("unknown") && (tTNetWorkListener = mTTNetWorkListener) != null) {
            gSigStrength = _switchNetworkStrength(tTNetWorkListener.getCurrentAccessStrength());
        }
        return gSigStrength;
    }

    public String getCodecType() {
        Map map = this.mVideoInfo;
        String str = "";
        String str2 = str;
        if (map != null) {
            Map map2 = (Map) map.get("codec");
            str2 = str;
            if (map2 != null) {
                Object obj = str;
                if (map2.get(this.mCurrentResolution) != null) {
                    obj = map2.get(this.mCurrentResolution);
                }
                str2 = (String) obj;
            }
        }
        if (this.mDataSource != null && TextUtils.isEmpty(str2)) {
            return this.mDataSource.getLogValueStr(0);
        }
        return str2;
    }

    public JSONObject getMDLInfo() {
        String mediaLoaderInfo;
        if (this.mDataSource == null) {
            return null;
        }
        synchronized (this) {
            mediaLoaderInfo = this.mDataSource.getMediaLoaderInfo();
        }
        TTVideoEngineLog.d("VideoEventBase", "update mdl info: " + mediaLoaderInfo);
        if (TextUtils.isEmpty(mediaLoaderInfo)) {
            return null;
        }
        try {
            return new JSONObject(mediaLoaderInfo);
        } catch (JSONException e) {
            TTVideoEngineLog.e("VideoEventBase", e.toString());
            return null;
        }
    }

    public void registerNetwork() {
        if (this.mContext != null) {
            synchronized ("VideoEventBase") {
                if (mTTNetWorkListener == null) {
                    TTNetWorkListener tTNetWorkListener = TTNetWorkListener.getInstance();
                    mTTNetWorkListener = tTNetWorkListener;
                    tTNetWorkListener.init(this.mContext);
                }
                if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 64L)) {
                    this.mNetWorkChangeCb = new TTNetworkStateCallback() { // from class: com.ss.ttvideoengine.log.VideoEventBase.1
                        @Override // com.ss.ttvideoengine.TTNetworkStateCallback
                        public void onAccessChanged(int i, int i2, int i3) {
                            if (i == 0) {
                                VideoEventBase.this._changeNetworkType(i2, i3);
                            } else if (i == 1) {
                                VideoEventBase.this._changeSignalStrength(i2, i3);
                            }
                        }
                    };
                    WeakReference<TTNetworkStateCallback> weakReference = new WeakReference<>(this.mNetWorkChangeCb);
                    this.mNetWorkChangeCbr = weakReference;
                    mTTNetWorkListener.startListen(weakReference);
                    gNetworkType = _switchNetworkType(mTTNetWorkListener.getCurrentAccessType());
                    gSigStrength = _switchNetworkStrength(mTTNetWorkListener.getCurrentAccessStrength());
                }
            }
        }
    }

    public void showedOneFrame() {
        Object obj;
        long j;
        Object obj2;
        Object obj3;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            this.codec_type = eventLoggerSource.getLogValueStr(0);
            this.a_codec_type = this.mDataSource.getLogValueStr(146);
            if (this.formatType < 0) {
                this.formatType = this.mDataSource.getLogValueInt(49);
            }
        }
        Map map = this.mVideoInfo;
        if (map != null) {
            Map map2 = (Map) map.get("size");
            if (map2 == null) {
                obj = null;
            } else {
                obj = map2.get(this.mCurrentResolution);
            }
            long j2 = 0;
            if (obj != null) {
                j = ((Number) obj).longValue();
            } else {
                j = 0;
            }
            Map map3 = (Map) this.mVideoInfo.get("audio_size");
            if (map3 != null && map3.size() > 0 && this.mCurDashAudioInfoId != -1 && (obj3 = map3.get(Integer.valueOf(this.mCurDashAudioInfoId))) != null) {
                j2 = ((Number) obj3).longValue();
            }
            this.vs = j + j2;
            Map map4 = (Map) this.mVideoInfo.get("vtype");
            if (map4 != null && (obj2 = map4.get(this.mCurrentResolution)) != null) {
                this.vtype = (String) obj2;
                TTVideoEngineLog.i("VideoEventBase", "showedOneFrame vtype:" + this.vtype + ", currentResolution:" + this.mCurrentResolution);
            }
        }
    }

    public void updateMDLInfo() {
        int i;
        JSONObject mDLInfo = getMDLInfo();
        if (mDLInfo != null) {
            boolean z = false;
            try {
                this.hasAudioTrackInfo = false;
                if (!mDLInfo.isNull("audio")) {
                    this.hasAudioTrackInfo = true;
                    this.mdlAudioInfo.update(mDLInfo.getJSONObject("audio"));
                    z = true;
                }
                if (!mDLInfo.isNull("video")) {
                    TTVideoEngineLog.d("VideoEventBase", "found video: " + mDLInfo.getJSONObject("video").toString());
                    this.mdlVideoInfo.update(mDLInfo.getJSONObject("video"));
                    z = true;
                }
                if (!z) {
                    this.mdlVideoInfo.update(mDLInfo);
                }
                if (!mDLInfo.isNull("cur_task_num")) {
                    this.mdl_cur_task_num = ((Integer) mDLInfo.get("cur_task_num")).intValue();
                }
                if (!mDLInfo.isNull("conc_count")) {
                    this.mdl_conc_count = ((Integer) mDLInfo.get("conc_count")).intValue();
                }
                if (!mDLInfo.isNull("mdl_preload_info")) {
                    this.mdl_preload_info = mDLInfo.get("mdl_preload_info").toString();
                }
                if (!mDLInfo.isNull("dns_type")) {
                    i = ((Integer) mDLInfo.get("dns_type")).intValue();
                } else {
                    i = -1;
                }
                if (i != 0) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                EventLoggerSource eventLoggerSource = this.mDataSource;
                                if (eventLoggerSource != null && eventLoggerSource.getLogValueInt(85) == 1) {
                                    this.mDNSType = "customDNSInnerByteDanceHTTPDNS";
                                } else {
                                    this.mDNSType = "customDNS";
                                }
                            }
                        } else {
                            this.mDNSType = "httpDNS_google";
                        }
                    } else {
                        this.mDNSType = "httpDNS_own";
                    }
                } else {
                    this.mDNSType = "localDNS";
                }
                if (!mDLInfo.isNull("mdl_features")) {
                    updateMdlFeatures(mDLInfo.getJSONObject("mdl_features"));
                }
            } catch (Exception e) {
                TTVideoEngineLog.d(e);
            }
        }
    }

    public void setCurHost(String str) {
        this.mCurHost = str;
    }

    public void setCurIP(String str) {
        this.mCurIP = str;
    }

    public void setCurQuality(String str) {
        this.mCurQuality = str;
    }

    public void setCurResolution(String str) {
        this.mCurResolution = str;
    }

    public void setCurURL(String str) {
        this.mCurURL = str;
    }

    public void setP2PCDNType(int i) {
        this.mP2PCDNType = i;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public void useVideoHW(int i) {
        this.mVideoHW = i;
        this.mVideoHWUser = i;
    }

    public class MDLTrackInfo {
        public long mdl_cur_req_pos = -2147483648L;
        public long mdl_cur_end_pos = -2147483648L;
        public long mdl_cur_cache_pos = -2147483648L;
        public int mdl_cache_type = Integer.MIN_VALUE;
        public String mdl_cur_ip = "";
        public String mdl_cur_host = "";
        public String mdl_cur_url = "";
        public long mdl_reply_size = -2147483648L;
        public long mdl_down_pos = -2147483648L;
        public long mdl_player_wait_time = -2147483648L;
        public int mdl_player_wait_num = Integer.MIN_VALUE;
        public int mdl_stage = Integer.MIN_VALUE;
        public int mdl_error_code = Integer.MIN_VALUE;
        public int mdl_speed = Integer.MIN_VALUE;
        public String mdl_file_key = "";
        public int mdl_is_socrf = Integer.MIN_VALUE;
        public int mdl_url_index = Integer.MIN_VALUE;
        public String mdl_re_url = "";
        public int mdl_cur_soure = Integer.MIN_VALUE;
        public String mdl_extra_info = "";
        public int mdl_http_code = Integer.MIN_VALUE;
        public long mdl_req_t = -2147483648L;
        public long mdl_end_t = -2147483648L;
        public long mdl_dns_t = -2147483648L;
        public long mdl_tcp_start_t = -2147483648L;
        public long mdl_tcp_end_t = -2147483648L;
        public long mdl_ttfp = -2147483648L;
        public long mdl_httpfb = -2147483648L;
        public long mdl_http_open_end_t = -2147483648L;
        public long mdl_fs = -2147483648L;
        public int mdl_pcdn_full_speed = Integer.MIN_VALUE;
        public long mdl_tbs = -2147483648L;
        public long mdl_lbs = -2147483648L;
        public int mdl_res_err = Integer.MIN_VALUE;
        public int mdl_read_src = Integer.MIN_VALUE;
        public int mdl_seek_num = Integer.MIN_VALUE;
        public String mdl_last_msg = "";
        public String mdl_server_timing = "";
        public int mdl_v_lt = Integer.MIN_VALUE;
        public int mdl_v_p2p_ier = Integer.MIN_VALUE;
        public String mdl_ip_list = "";
        public String mdl_blocked_ips = "";
        public int mdl_req_num = Integer.MIN_VALUE;
        public String mdl_cdn_cache = "";
        public String mdl_client_info = "";
        public int mdl_disable_seek = Integer.MIN_VALUE;
        public int mdl_mem_buffer_len = Integer.MIN_VALUE;
        public long mdl_disk_buffer_len = -2147483648L;
        public long mdl_send_offset = -2147483648L;
        public long mdl_last_req_offset = -2147483648L;
        public int mdl_cdn_type = Integer.MIN_VALUE;
        public long mdl_last_read_time = -2147483648L;
        public String mdl_last_ip_list = "";
        public int mdl_downloading = Integer.MIN_VALUE;
        public String mdl_n80_host = "";
        public int mdl_mixed_cdn_type = Integer.MIN_VALUE;

        static {
            Covode.recordClassIndex(652490);
        }

        public void update(JSONObject jSONObject) throws Exception {
            if (!TTVideoEngine.sBuryDataOptimize) {
                updateOld(jSONObject);
            } else {
                updateNew(jSONObject);
            }
        }

        public MDLTrackInfo() {
        }

        public void updateNew(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                if (!jSONObject.isNull("err_code")) {
                    this.mdl_error_code = ((Number) jSONObject.get("err_code")).intValue();
                }
                if (!jSONObject.isNull("reply_size")) {
                    this.mdl_reply_size = ((Number) jSONObject.get("reply_size")).longValue();
                }
                if (!jSONObject.isNull("cur_host")) {
                    this.mdl_cur_host = jSONObject.get("cur_host").toString();
                }
                if (!jSONObject.isNull("cur_ip")) {
                    this.mdl_cur_ip = jSONObject.get("cur_ip").toString();
                }
                if (!jSONObject.isNull("speed")) {
                    this.mdl_speed = ((Number) jSONObject.get("speed")).intValue();
                }
                if (!jSONObject.isNull("cdn_type")) {
                    this.mdl_cdn_type = ((Number) jSONObject.get("cdn_type")).intValue();
                }
                if (!jSONObject.isNull("url")) {
                    this.mdl_cur_url = jSONObject.get("url").toString();
                }
                if (!jSONObject.isNull("file_key")) {
                    this.mdl_file_key = jSONObject.get("file_key").toString();
                }
                if (!jSONObject.isNull("re_url")) {
                    this.mdl_re_url = jSONObject.get("re_url").toString();
                }
                if (!jSONObject.isNull("end_t")) {
                    this.mdl_end_t = ((Number) jSONObject.get("end_t")).longValue();
                }
                if (!jSONObject.isNull("dns_t")) {
                    this.mdl_dns_t = ((Number) jSONObject.get("dns_t")).longValue();
                }
                if (!jSONObject.isNull("tbs")) {
                    this.mdl_tbs = ((Number) jSONObject.get("tbs")).longValue();
                }
                if (!jSONObject.isNull("lbs")) {
                    this.mdl_lbs = ((Number) jSONObject.get("lbs")).longValue();
                }
                if (!jSONObject.isNull("v_p2p_ier")) {
                    this.mdl_v_p2p_ier = ((Number) jSONObject.get("v_p2p_ier")).intValue();
                }
                if (!jSONObject.isNull("ip_list")) {
                    this.mdl_ip_list = jSONObject.get("ip_list").toString();
                }
                if (!jSONObject.isNull("blocked_ip")) {
                    this.mdl_blocked_ips = jSONObject.get("blocked_ip").toString();
                }
                if (!jSONObject.isNull("cdn_cache")) {
                    this.mdl_cdn_cache = jSONObject.get("cdn_cache").toString();
                }
                if (!jSONObject.isNull("client_info")) {
                    this.mdl_client_info = jSONObject.get("client_info").toString();
                }
                if (!jSONObject.isNull("disable_seek")) {
                    this.mdl_disable_seek = ((Number) jSONObject.get("disable_seek")).intValue();
                }
                if (!jSONObject.isNull("mem_buffer_len")) {
                    this.mdl_mem_buffer_len = ((Number) jSONObject.get("mem_buffer_len")).intValue();
                }
                if (!jSONObject.isNull("disk_buffer_len")) {
                    this.mdl_disk_buffer_len = ((Number) jSONObject.get("disk_buffer_len")).longValue();
                }
                if (!jSONObject.isNull("send_offset")) {
                    this.mdl_send_offset = ((Number) jSONObject.get("send_offset")).longValue();
                }
                if (!jSONObject.isNull("last_req_offset")) {
                    this.mdl_last_req_offset = ((Number) jSONObject.get("last_req_offset")).longValue();
                }
                if (TTVideoEngine.sBuryDataOptimizeV2 == 0 && !jSONObject.isNull("last_ip_list")) {
                    this.mdl_last_ip_list = jSONObject.get("last_ip_list").toString();
                }
                if (!jSONObject.isNull("last_read_time")) {
                    this.mdl_last_read_time = ((Number) jSONObject.get("last_read_time")).longValue();
                }
                if (!jSONObject.isNull("downloading")) {
                    this.mdl_downloading = ((Number) jSONObject.get("downloading")).intValue();
                }
                if (!jSONObject.isNull("n80_host")) {
                    this.mdl_n80_host = jSONObject.get("n80_host").toString();
                }
                if (!jSONObject.isNull("mixed_cdn_type")) {
                    this.mdl_mixed_cdn_type = ((Number) jSONObject.get("mixed_cdn_type")).intValue();
                }
            }
        }

        public void updateOld(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                if (!jSONObject.isNull("cur_req_pos")) {
                    this.mdl_cur_req_pos = ((Number) jSONObject.get("cur_req_pos")).longValue();
                }
                if (!jSONObject.isNull("cur_end_pos")) {
                    this.mdl_cur_end_pos = ((Number) jSONObject.get("cur_end_pos")).longValue();
                }
                if (!jSONObject.isNull("cur_cache_pos")) {
                    this.mdl_cur_cache_pos = ((Number) jSONObject.get("cur_cache_pos")).longValue();
                }
                if (!jSONObject.isNull("cache_type")) {
                    this.mdl_cache_type = ((Number) jSONObject.get("cache_type")).intValue();
                }
                if (!jSONObject.isNull("down_pos")) {
                    this.mdl_down_pos = ((Number) jSONObject.get("down_pos")).longValue();
                }
                if (!jSONObject.isNull("err_code")) {
                    this.mdl_error_code = ((Number) jSONObject.get("err_code")).intValue();
                }
                if (!jSONObject.isNull("player_wait_num")) {
                    this.mdl_player_wait_num = ((Number) jSONObject.get("player_wait_num")).intValue();
                }
                if (!jSONObject.isNull("player_wait_time")) {
                    this.mdl_player_wait_time = ((Number) jSONObject.get("player_wait_time")).longValue();
                }
                if (!jSONObject.isNull("reply_size")) {
                    this.mdl_reply_size = ((Number) jSONObject.get("reply_size")).longValue();
                }
                if (!jSONObject.isNull("stage")) {
                    this.mdl_stage = ((Number) jSONObject.get("stage")).intValue();
                }
                if (!jSONObject.isNull("cur_host")) {
                    this.mdl_cur_host = jSONObject.get("cur_host").toString();
                }
                if (!jSONObject.isNull("cur_ip")) {
                    this.mdl_cur_ip = jSONObject.get("cur_ip").toString();
                }
                if (!jSONObject.isNull("speed")) {
                    this.mdl_speed = ((Number) jSONObject.get("speed")).intValue();
                }
                if (!jSONObject.isNull("cdn_type")) {
                    this.mdl_cdn_type = ((Number) jSONObject.get("cdn_type")).intValue();
                }
                if (!jSONObject.isNull("url")) {
                    this.mdl_cur_url = jSONObject.get("url").toString();
                }
                if (!jSONObject.isNull("file_key")) {
                    this.mdl_file_key = jSONObject.get("file_key").toString();
                }
                if (!jSONObject.isNull("is_socrf")) {
                    this.mdl_is_socrf = ((Number) jSONObject.get("is_socrf")).intValue();
                }
                if (!jSONObject.isNull("url_index")) {
                    this.mdl_url_index = ((Number) jSONObject.get("url_index")).intValue();
                }
                if (!jSONObject.isNull("re_url")) {
                    this.mdl_re_url = jSONObject.get("re_url").toString();
                }
                if (!jSONObject.isNull("cur_source")) {
                    this.mdl_cur_soure = ((Number) jSONObject.get("cur_source")).intValue();
                }
                if (!jSONObject.isNull("extra_info")) {
                    this.mdl_extra_info = jSONObject.get("extra_info").toString();
                }
                if (!jSONObject.isNull("status_code")) {
                    this.mdl_http_code = ((Number) jSONObject.get("status_code")).intValue();
                }
                if (!jSONObject.isNull("req_t")) {
                    this.mdl_req_t = ((Number) jSONObject.get("req_t")).longValue();
                }
                if (!jSONObject.isNull("end_t")) {
                    this.mdl_end_t = ((Number) jSONObject.get("end_t")).longValue();
                }
                if (!jSONObject.isNull("dns_t")) {
                    this.mdl_dns_t = ((Number) jSONObject.get("dns_t")).longValue();
                }
                if (!jSONObject.isNull("tcp_con_start_t")) {
                    this.mdl_tcp_start_t = ((Number) jSONObject.get("tcp_con_start_t")).longValue();
                }
                if (!jSONObject.isNull("tcp_con_t")) {
                    this.mdl_tcp_end_t = ((Number) jSONObject.get("tcp_con_t")).longValue();
                }
                if (!jSONObject.isNull("tcp_first_pack_t")) {
                    this.mdl_ttfp = ((Number) jSONObject.get("tcp_first_pack_t")).longValue();
                }
                if (!jSONObject.isNull("http_first_body_t")) {
                    this.mdl_httpfb = ((Number) jSONObject.get("http_first_body_t")).longValue();
                }
                if (!jSONObject.isNull("http_open_end_t")) {
                    this.mdl_http_open_end_t = ((Number) jSONObject.get("http_open_end_t")).longValue();
                }
                if (!jSONObject.isNull("fs")) {
                    this.mdl_fs = ((Number) jSONObject.get("fs")).longValue();
                }
                if (!jSONObject.isNull("full_speed")) {
                    this.mdl_pcdn_full_speed = ((Number) jSONObject.get("full_speed")).intValue();
                }
                if (!jSONObject.isNull("tbs")) {
                    this.mdl_tbs = ((Number) jSONObject.get("tbs")).longValue();
                }
                if (!jSONObject.isNull("lbs")) {
                    this.mdl_lbs = ((Number) jSONObject.get("lbs")).longValue();
                }
                if (!jSONObject.isNull("req_err")) {
                    this.mdl_res_err = ((Number) jSONObject.get("req_err")).intValue();
                }
                if (!jSONObject.isNull("read_src")) {
                    this.mdl_read_src = ((Number) jSONObject.get("read_src")).intValue();
                }
                if (!jSONObject.isNull("seek_times")) {
                    this.mdl_seek_num = ((Number) jSONObject.get("seek_times")).intValue();
                }
                if (!jSONObject.isNull("last_msg")) {
                    this.mdl_last_msg = jSONObject.get("last_msg").toString();
                }
                if (!jSONObject.isNull("server_timing")) {
                    this.mdl_server_timing = jSONObject.get("server_timing").toString();
                }
                if (!jSONObject.isNull("v_lt")) {
                    this.mdl_v_lt = ((Number) jSONObject.get("v_lt")).intValue();
                }
                if (!jSONObject.isNull("v_p2p_ier")) {
                    this.mdl_v_p2p_ier = ((Number) jSONObject.get("v_p2p_ier")).intValue();
                }
                if (!jSONObject.isNull("req_num")) {
                    this.mdl_req_num = ((Number) jSONObject.get("req_num")).intValue();
                }
                if (!jSONObject.isNull("ip_list")) {
                    this.mdl_ip_list = jSONObject.get("ip_list").toString();
                }
                if (!jSONObject.isNull("blocked_ip")) {
                    this.mdl_blocked_ips = jSONObject.get("blocked_ip").toString();
                }
                if (!jSONObject.isNull("cdn_cache")) {
                    this.mdl_cdn_cache = jSONObject.get("cdn_cache").toString();
                }
                if (!jSONObject.isNull("client_info")) {
                    this.mdl_client_info = jSONObject.get("client_info").toString();
                }
                if (!jSONObject.isNull("disable_seek")) {
                    this.mdl_disable_seek = ((Number) jSONObject.get("disable_seek")).intValue();
                }
                if (!jSONObject.isNull("mem_buffer_len")) {
                    this.mdl_mem_buffer_len = ((Number) jSONObject.get("mem_buffer_len")).intValue();
                }
                if (!jSONObject.isNull("disk_buffer_len")) {
                    this.mdl_disk_buffer_len = ((Number) jSONObject.get("disk_buffer_len")).longValue();
                }
                if (!jSONObject.isNull("send_offset")) {
                    this.mdl_send_offset = ((Number) jSONObject.get("send_offset")).longValue();
                }
                if (!jSONObject.isNull("last_req_offset")) {
                    this.mdl_last_req_offset = ((Number) jSONObject.get("last_req_offset")).longValue();
                }
                if (TTVideoEngine.sBuryDataOptimizeV2 == 0 && !jSONObject.isNull("last_ip_list")) {
                    this.mdl_last_ip_list = jSONObject.get("last_ip_list").toString();
                }
                if (!jSONObject.isNull("last_read_time")) {
                    this.mdl_last_read_time = ((Number) jSONObject.get("last_read_time")).longValue();
                }
                if (!jSONObject.isNull("downloading")) {
                    this.mdl_downloading = ((Number) jSONObject.get("downloading")).intValue();
                }
                if (!jSONObject.isNull("n80_host")) {
                    this.mdl_n80_host = jSONObject.get("n80_host").toString();
                }
                if (!jSONObject.isNull("mixed_cdn_type")) {
                    this.mdl_mixed_cdn_type = ((Number) jSONObject.get("mixed_cdn_type")).intValue();
                }
            }
        }
    }

    public MDLTrackInfo getMdlTrackInfo(JSONObject jSONObject) throws Exception {
        MDLTrackInfo mDLTrackInfo = new MDLTrackInfo();
        mDLTrackInfo.update(jSONObject);
        return mDLTrackInfo;
    }

    public void setCurrentQualityDesc(String str) {
        if (TextUtils.isEmpty(this.mInitialQualityDesc)) {
            this.mInitialQualityDesc = str;
        }
        this.mCurrentQualityDesc = str;
    }

    private void updateMdlFeatures(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                int i = jSONObject.getInt(next);
                hashMap.put(next, Integer.valueOf(i));
                if (this.mdlP2pLoader == -1 && next.equals("mdl_p2p_loader")) {
                    this.mdlP2pLoader = i;
                }
            }
        } catch (JSONException e) {
            TTVideoEngineLog.d(e);
        }
        if (!hashMap.isEmpty()) {
            this.mdlFeatures = hashMap;
        }
    }

    public void setVideoInfo(IVideoModel iVideoModel) {
        Object obj;
        List<VideoInfo> videoInfoList;
        if (iVideoModel == null) {
            return;
        }
        this.mVideoModel = iVideoModel;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        HashMap hashMap7 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (iVideoModel.hasData() && (videoInfoList = iVideoModel.getVideoInfoList()) != null && videoInfoList.size() > 0) {
            Iterator<VideoInfo> it2 = videoInfoList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                VideoInfo next = it2.next();
                int mediatype = next.getMediatype();
                Iterator<VideoInfo> it4 = it2;
                long valueLong = next.getValueLong(12);
                String valueStr = next.getValueStr(8);
                HashMap hashMap8 = hashMap2;
                int valueInt = next.getValueInt(3);
                String resolution = next.getResolution().toString(mediatype);
                ArrayList arrayList3 = arrayList2;
                String valueStr2 = next.getValueStr(6);
                ArrayList arrayList4 = arrayList;
                hashMap.put(resolution, Long.valueOf(valueLong));
                hashMap3.put(resolution, valueStr);
                hashMap4.put(resolution, Integer.valueOf(valueInt));
                hashMap5.put(Integer.valueOf(next.getValueInt(3)), next.getValueStr(15));
                hashMap6.put(Integer.valueOf(next.getValueInt(3)), Integer.valueOf(i));
                hashMap7.put(resolution, valueStr2);
                if (mediatype == 1) {
                    arrayList4.add(Integer.valueOf(next.getValueInt(3)));
                } else {
                    arrayList4 = arrayList4;
                    arrayList3.add(Integer.valueOf(next.getValueInt(3)));
                }
                HashMap hashMap9 = hashMap6;
                if (this.mEnableTmpLog) {
                    TTVideoEngineLog.i("VideoEventBase", "setVideoInfo i:" + i + ", resolution:" + resolution + ", size:" + valueLong + ",codec_type:" + valueStr + ", bitrate:" + valueInt);
                }
                i++;
                int valueInt2 = next.getValueInt(42);
                if (mediatype == VideoRef.TYPE_AUDIO && ("dash".equals(valueStr2) || "bash".equals(valueStr2))) {
                    hashMap2 = hashMap8;
                    hashMap2.put(Integer.valueOf(valueInt2), Long.valueOf(valueLong));
                } else {
                    hashMap2 = hashMap8;
                }
                it2 = it4;
                arrayList2 = arrayList3;
                arrayList = arrayList4;
                hashMap6 = hashMap9;
            }
        }
        HashMap hashMap10 = new HashMap();
        String dynamicType = iVideoModel.getDynamicType();
        hashMap10.put("duration", Integer.valueOf(iVideoModel.getVideoRefInt(3)));
        hashMap10.put("size", hashMap);
        hashMap10.put("audio_size", hashMap2);
        hashMap10.put("codec", hashMap3);
        hashMap10.put("vtype", hashMap7);
        hashMap10.put("dynamic_type", dynamicType);
        hashMap10.put("bitrate", hashMap4);
        hashMap10.put("fileKey", hashMap5);
        hashMap10.put("bitrateMapTable", hashMap6);
        hashMap10.put("audio_bitrate", arrayList);
        hashMap10.put("video_bitrate", arrayList2);
        this.mVideoInfo = hashMap10;
        if (!TextUtils.isEmpty(this.mCurrentResolution) && (obj = hashMap4.get(this.mCurrentResolution)) != null) {
            this.mCurrentConfigBitrate = ((Integer) obj).intValue();
        }
        this.dynamic_type = dynamicType;
    }

    public void updateVideoInfo(VideoModel videoModel) {
        Map<String, String> versionInfo;
        Map map;
        Object obj;
        Object obj2;
        long j;
        long j2;
        Object obj3;
        if (videoModel != null) {
            setVideoInfo(videoModel);
        }
        Map map2 = this.mVideoInfo;
        if (map2 != null) {
            if (this.vd <= 0) {
                this.vd = ((Integer) map2.get("duration")).intValue() * 1000;
            }
            if (this.vs <= 0) {
                Object obj4 = ((Map) this.mVideoInfo.get("size")).get(this.mCurrentResolution);
                if (obj4 != null) {
                    j = ((Number) obj4).longValue();
                } else {
                    j = 0;
                }
                Map map3 = (Map) this.mVideoInfo.get("audio_size");
                if (map3 != null && map3.size() > 0 && this.mCurDashAudioInfoId != -1 && (obj3 = map3.get(Integer.valueOf(this.mCurDashAudioInfoId))) != null) {
                    j2 = ((Number) obj3).longValue();
                } else {
                    j2 = 0;
                }
                this.vs = j + j2;
            }
            if (TextUtils.isEmpty(this.codec_type)) {
                Map map4 = (Map) this.mVideoInfo.get("codec");
                if (map4.get(this.mCurrentResolution) != null) {
                    obj2 = map4.get(this.mCurrentResolution);
                } else {
                    obj2 = "";
                }
                this.codec_type = (String) obj2;
                TTVideoEngineLog.i("VideoEventBase", "brian codec_type:" + this.codec_type + ", for resolution:" + this.mCurrentResolution + ", quality desc:" + this.mCurrentQualityDesc);
            }
            if (TextUtils.isEmpty(this.vtype) && (map = (Map) this.mVideoInfo.get("vtype")) != null && (obj = map.get(this.mCurrentResolution)) != null) {
                this.vtype = (String) obj;
            }
        }
        if (this.mDataSource != null) {
            String str = this.pv;
            if ((str == null || str.isEmpty()) && (versionInfo = this.mDataSource.versionInfo()) != null) {
                this.pv = versionInfo.get("pv");
                this.pc = versionInfo.get("pc");
                this.sv = versionInfo.get("sv");
                this.sdk_version = versionInfo.get("sdk_version");
                this.ffmpeg_version = versionInfo.get("ffv");
                this.libvcn_version = versionInfo.get("vcnv");
                this.texturender_version = versionInfo.get("trv");
                this.abr_version = versionInfo.get("abrv");
                this.predict_version = versionInfo.get("prdtv");
                this.preload_version = versionInfo.get("prldv");
            }
            if (TextUtils.isEmpty(this.codec_type)) {
                this.codec_type = this.mDataSource.getLogValueStr(0);
            }
            if (TextUtils.isEmpty(this.a_codec_type)) {
                this.a_codec_type = this.mDataSource.getLogValueStr(146);
            }
            String logValueStr = this.mDataSource.getLogValueStr(37);
            if (!TextUtils.isEmpty(logValueStr)) {
                this.mMdlVersion = logValueStr;
            }
            TTVideoEngineLog.i("VideoEventBase", "video_type:" + this.vtype);
            if (TextUtils.isEmpty(this.vtype)) {
                String logValueStr2 = this.mDataSource.getLogValueStr(65);
                TTVideoEngineLog.i("VideoEventBase", "get video_type from player:" + logValueStr2);
                if (!TextUtils.isEmpty(logValueStr2)) {
                    if (logValueStr2.indexOf("mp4") > 0) {
                        this.vtype = "mp4";
                    } else {
                        int indexOf = logValueStr2.indexOf(",");
                        if (indexOf < 0) {
                            this.vtype = logValueStr2;
                        } else {
                            this.vtype = logValueStr2.substring(0, indexOf);
                        }
                    }
                }
            }
            TTVideoEngineLog.i("VideoEventBase", "video_size :" + this.vs);
            if (this.vs <= 0) {
                this.vs = this.mDataSource.getLogValueLong(66);
                TTVideoEngineLog.i("VideoEventBase", "get video_size from player:" + this.vs);
            }
            this.videoCodecNameId = this.mDataSource.getLogValueInt(24);
            this.audioCodecNameId = this.mDataSource.getLogValueInt(25);
            switch (this.videoCodecNameId) {
                case 2:
                    this.mVideoHW = 1;
                    break;
                case 3:
                case 4:
                case 5:
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                case 7:
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                case 9:
                    this.mVideoHW = 0;
                    break;
            }
            this.formatType = this.mDataSource.getLogValueInt(49);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _changeNetworkType(int i, int i2) {
        String _switchNetworkType = _switchNetworkType(i);
        String _switchNetworkType2 = _switchNetworkType(i2);
        TTVideoEngineLog.d("VideoEventBase", String.format("receive network type changed, from:%s to:%s", _switchNetworkType, _switchNetworkType2));
        gNetworkType = _switchNetworkType2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _changeSignalStrength(int i, int i2) {
        String _switchNetworkStrength = _switchNetworkStrength(i);
        String _switchNetworkStrength2 = _switchNetworkStrength(i2);
        TTVideoEngineLog.d("VideoEventBase", String.format("receive signal strength changed, from:%s to:%s", _switchNetworkStrength, _switchNetworkStrength2));
        gSigStrength = _switchNetworkStrength2;
    }

    public void beginToPlay(String str, String str2) {
        String str3;
        this.mVid = str;
        this.mDeviceId = str2;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            str3 = eventLoggerSource.getLogValueStr(139);
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            this.mSessionID = SessionIDGenerator.generateTrackID(this.mDeviceId);
            this.mHasGetPreloadTraceId = false;
        } else {
            this.mSessionID = str3;
            this.mHasGetPreloadTraceId = true;
        }
        this.mTraceID = this.mSessionID;
        if (TextUtils.isEmpty(appSessionId)) {
            appSessionId = SessionIDGenerator.generateSessionID(this.mDeviceId);
        }
    }

    public void configResolution(String str, String str2) {
        Object obj;
        this.mLastResolution = str2;
        this.mCurrentResolution = str;
        Map map = this.mVideoInfo;
        if (map != null) {
            Map map2 = (Map) map.get("bitrate");
            if (map2 == null) {
                obj = null;
            } else {
                obj = map2.get(this.mCurrentResolution);
            }
            if (obj != null) {
                this.mCurrentConfigBitrate = ((Integer) obj).intValue();
            }
        }
    }

    public void setSourceType(int i, String str) {
        switch (i) {
            case 0:
                this.mSourceTypeStr = "local_url";
                break;
            case 1:
                this.mSourceTypeStr = "dir_url";
                break;
            case 2:
                this.mSourceTypeStr = "playitem";
                break;
            case 3:
                this.mSourceTypeStr = "preload";
                break;
            case 4:
                this.mSourceTypeStr = "feed";
                break;
            case 5:
                this.mSourceTypeStr = "vid";
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                this.mSourceTypeStr = "fd";
                break;
            case 7:
                this.mSourceTypeStr = "mds";
                break;
        }
        this.mVid = str;
    }

    VideoEventBase(EventLoggerSource eventLoggerSource, boolean z, Context context) {
        this.mDataSource = eventLoggerSource;
        this.isUploadLogEnabled = z;
        this.mContext = context;
        initParametersIfNeeded();
    }
}

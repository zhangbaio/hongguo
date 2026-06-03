package com.ss.ttvideoengine.log;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.log.VideoEventBase;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventOneEvent {
    public VideoEventBase mEventBase;
    public EventContext mEventContext;
    private VideoEventOneOpera mEventOpera;
    private HashMap mLastEventTimeMap;
    public long mAccuCostTime = 0;
    public ArrayList<String> mRebufList = new ArrayList<>();
    public long mFirstFrameTime = -2147483648L;
    public int mIsAVBadInterlaced = 0;

    static {
        Covode.recordClassIndex(652501);
    }

    public void onAVBadInterlaced() {
        this.mIsAVBadInterlaced = 1;
    }

    public int getMovieStalledType() {
        return this.mEventContext.mBufferingType;
    }

    public long getStalledVideoBufferTime() {
        return this.mEventContext.mVideoLenBeforeMS;
    }

    public long getStatlledAudioBufferTime() {
        return this.mEventContext.mAudioLenBeforeMS;
    }

    public void showedFirstFrame() {
        this.mFirstFrameTime = System.currentTimeMillis();
    }

    public void movieShouldRetry() {
        this.mEventContext.mRetryCount++;
    }

    public void sendOneEvent() {
        this.mEventBase.updateVideoInfo(null);
        TTVideoEngineLog.i("VideoEventOneEvent", "report async");
        VideoEventBase videoEventBase = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(videoEventBase.mContext, this, videoEventBase, this.mEventContext));
    }

    private static class StatisticDataRunnable implements Runnable {
        private final WeakReference<EventContext> rEvent;
        private final WeakReference<VideoEventBase> rEventBase;

        static {
            Covode.recordClassIndex(652504);
        }

        @Override // java.lang.Runnable
        public void run() {
            DeviceMonitorUtils.CPUInfo currentCPUInfo;
            EventContext eventContext = this.rEvent.get();
            VideoEventBase videoEventBase = this.rEventBase.get();
            if (eventContext != null && videoEventBase != null && (currentCPUInfo = videoEventBase.getCurrentCPUInfo()) != null) {
                double d = currentCPUInfo.cpuAppRate;
                double d2 = 1.401298464324817E-45d;
                if (d <= 0.0d) {
                    d = 1.401298464324817E-45d;
                }
                eventContext.mCpuRate = d;
                double d3 = currentCPUInfo.cpuAppSpeed;
                if (d3 > 0.0d) {
                    d2 = d3;
                }
                eventContext.mCpuSpeed = d2;
            }
        }

        public StatisticDataRunnable(EventContext eventContext, VideoEventBase videoEventBase) {
            this.rEvent = new WeakReference<>(eventContext);
            this.rEventBase = new WeakReference<>(videoEventBase);
        }
    }

    public long getLastRebufTime() {
        if (this.mEventContext.mStartT > 0) {
            return 0L;
        }
        synchronized (this.mLastEventTimeMap) {
            if (this.mLastEventTimeMap.containsKey("block_net")) {
                return ((Long) this.mLastEventTimeMap.get("block_net")).longValue();
            }
            return -1L;
        }
    }

    public void reset() {
        synchronized (this.mLastEventTimeMap) {
            this.mLastEventTimeMap = new HashMap();
        }
        this.mAccuCostTime = 0L;
        this.mRebufList = new ArrayList<>();
        this.mFirstFrameTime = -2147483648L;
        this.mIsAVBadInterlaced = 0;
    }

    private static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventOneEvent rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler = new HandlerDelegate(Looper.getMainLooper());

        static {
            Covode.recordClassIndex(652502);
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            VideoEventOneEvent videoEventOneEvent = this.rEvent;
            if (videoEventOneEvent == null) {
                return;
            }
            VideoEventBase videoEventBase = this.rEventBase;
            if (videoEventBase != null && videoEventBase.isUploadLogEnabled) {
                z = true;
            } else {
                z = false;
            }
            final JSONObject jsonObject = videoEventOneEvent.toJsonObject(this.rEventContext, videoEventBase);
            Handler handler = this.rHandler;
            if (handler != null && handler.getLooper() != null) {
                this.rHandler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventOneEvent.AsyncGetLogDataRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneevent");
                    }
                });
                synchronized (this.rEvent.mLastEventTimeMap) {
                    this.rEvent.mLastEventTimeMap.remove(this.rEventContext.mEventType);
                    HashMap hashMap = this.rEvent.mLastEventTimeMap;
                    EventContext eventContext = this.rEventContext;
                    hashMap.put(eventContext.mEventType, Long.valueOf(eventContext.mEndT));
                }
                return;
            }
            VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneevent");
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventOneEvent videoEventOneEvent, VideoEventBase videoEventBase, EventContext eventContext) {
            this.rEvent = videoEventOneEvent;
            this.rEventBase = videoEventBase;
            this.rContext = context;
            this.rEventContext = eventContext;
        }
    }

    public void triggerBufferStartCb() {
        String str;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && videoEventBase.mDataSource != null) {
            HashMap hashMap = new HashMap();
            VideoEventBase videoEventBase2 = this.mEventBase;
            if (videoEventBase2.mEnableMDL > 0) {
                hashMap.put("cur_url", videoEventBase2.mdlVideoInfo.mdl_cur_url);
                hashMap.put("cur_ip", this.mEventBase.mdlVideoInfo.mdl_cur_ip);
                str = this.mEventBase.mdlVideoInfo.mdl_cur_url;
            } else {
                hashMap.put("cur_url", videoEventBase2.mCurURL);
                hashMap.put("cur_ip", this.mEventBase.mCurIP);
                str = this.mEventBase.mCurURL;
            }
            try {
                hashMap.put("cur_host", Uri.parse(str).getHost());
            } catch (Exception e) {
                TTVideoEngineLog.i("VideoEventOneEvent", "triggerBufferStartCb:" + e.toString());
            }
            this.mEventBase.mDataSource.onInfo(0, hashMap);
        }
    }

    public void _triggerBufferEndCb() {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && videoEventBase.mDataSource != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cost_time", Long.valueOf(this.mEventContext.mCostTime));
            hashMap.put("exit_type", this.mEventContext.mEndType);
            JSONObject mDLInfo = this.mEventBase.getMDLInfo();
            if (mDLInfo != null) {
                if (!mDLInfo.isNull("video")) {
                    try {
                        VideoEventBase.MDLTrackInfo mdlTrackInfo = this.mEventBase.getMdlTrackInfo(mDLInfo.getJSONObject("video"));
                        hashMap.put("cur_url", mdlTrackInfo.mdl_cur_url);
                        hashMap.put("cur_ip", mdlTrackInfo.mdl_cur_ip);
                        hashMap.put("cur_host", Uri.parse(mdlTrackInfo.mdl_cur_url).getHost());
                    } catch (Exception e) {
                        TTVideoEngineLog.d(e);
                    }
                }
            } else {
                hashMap.put("cur_url", this.mEventBase.mCurURL);
                hashMap.put("cur_ip", this.mEventBase.mCurIP);
                try {
                    hashMap.put("cur_host", Uri.parse(this.mEventBase.mCurURL).getHost());
                } catch (Exception e2) {
                    TTVideoEngineLog.i("VideoEventOneEvent", "_triggerBufferEndCb:" + e2.toString());
                }
            }
            this.mEventBase.mDataSource.onInfo(1, hashMap);
        }
    }

    private class EventContext {
        public long mAudioLenAfterMS;
        public long mAudioLenBaseAfterMs;
        public long mAudioLenBaseBeforeMs;
        public long mAudioLenBeforeMS;
        public long mAudioLenDecAfterMs;
        public long mAudioLenDecBeforeMs;
        public long mAudioLenOnlyBefore;
        public int mBufferingType;
        public long mBytesFromMDL;
        public int mConfigBitrateAfter;
        public int mConfigBitrateBefore;
        public long mCostTime;
        public double mCpuRate;
        public double mCpuSpeed;
        public float mCurrent;
        public long mEndT;
        public String mEndType;
        public String mEventType;
        public int mIndex;
        public int mIsABR;
        public long mLastSeekTime;
        public long mPlayerAudioReqOffset;
        public long mPlayerReadState;
        public long mPlayerReqOffset;
        public int mPowerSaveMode;
        public long mPreStartT;
        public String mQualityDescAfter;
        public String mQualityDescBefore;
        public String mResolutionAfter;
        public String mResolutionBefore;
        public int mRetryCount;
        public long mStartT;
        public long mVideoAudioGap;
        public long mVideoLenAfterMS;
        public long mVideoLenBaseAfterMs;
        public long mVideoLenBaseBeforeMs;
        public long mVideoLenBeforeMS;
        public long mVideoLenDecAfterMs;
        public long mVideoLenDecBeforeMs;
        public long mVideoLenOnlyBefore;
        public int mVideoPos;

        static {
            Covode.recordClassIndex(652503);
        }

        private EventContext() {
            this.mEventType = "";
            this.mCostTime = -2147483648L;
            this.mEndType = "";
            this.mPreStartT = -2147483648L;
            this.mBufferingType = -1;
            this.mStartT = -2147483648L;
            this.mEndT = -2147483648L;
            this.mLastSeekTime = -2147483648L;
            this.mVideoPos = Integer.MIN_VALUE;
            this.mRetryCount = 0;
            this.mVideoLenBeforeMS = -1L;
            this.mAudioLenBeforeMS = -1L;
            this.mVideoLenAfterMS = 0L;
            this.mAudioLenAfterMS = 0L;
            this.mBytesFromMDL = 0L;
            this.mIndex = 0;
            this.mVideoLenDecBeforeMs = 0L;
            this.mVideoLenDecAfterMs = 0L;
            this.mAudioLenDecBeforeMs = 0L;
            this.mAudioLenDecAfterMs = 0L;
            this.mVideoLenBaseBeforeMs = 0L;
            this.mVideoLenBaseAfterMs = 0L;
            this.mAudioLenBaseBeforeMs = 0L;
            this.mAudioLenBaseAfterMs = 0L;
            this.mVideoLenOnlyBefore = -2147483648L;
            this.mAudioLenOnlyBefore = -2147483648L;
            this.mPlayerReqOffset = -2147483648L;
            this.mPlayerAudioReqOffset = -2147483648L;
            this.mPlayerReadState = -2147483648L;
            this.mVideoAudioGap = 0L;
            this.mResolutionBefore = "";
            this.mResolutionAfter = "";
            this.mConfigBitrateBefore = Integer.MIN_VALUE;
            this.mConfigBitrateAfter = Integer.MIN_VALUE;
            this.mIsABR = Integer.MIN_VALUE;
            this.mQualityDescBefore = "";
            this.mQualityDescAfter = "";
            this.mCpuRate = 1.401298464324817E-45d;
            this.mCpuSpeed = 1.401298464324817E-45d;
            this.mPowerSaveMode = Integer.MIN_VALUE;
            this.mCurrent = Float.MIN_VALUE;
        }
    }

    public void moviePreStalled(int i) {
        EventLoggerSource eventLoggerSource;
        this.mEventContext.mPreStartT = System.currentTimeMillis();
        this.mEventContext.mBufferingType = i;
        TTVideoEngineLog.d("VideoEventOneEvent", "movie stall type:" + i);
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.updateMDLInfo();
        }
        VideoEventBase videoEventBase2 = this.mEventBase;
        if (videoEventBase2 != null && (eventLoggerSource = videoEventBase2.mDataSource) != null) {
            this.mEventContext.mPlayerReqOffset = eventLoggerSource.getLogValueLong(144);
            this.mEventContext.mPlayerAudioReqOffset = this.mEventBase.mDataSource.getLogValueLong(149);
            this.mEventContext.mPlayerReadState = this.mEventBase.mDataSource.getLogValueLong(150);
        }
    }

    public void movieStallEnd(String str) {
        EventLoggerSource eventLoggerSource;
        EventContext eventContext = this.mEventContext;
        if (eventContext.mStartT > 0 && !eventContext.mEventType.isEmpty()) {
            this.mEventContext.mEndT = System.currentTimeMillis();
            TTVideoEngineLog.d("VideoEventOneEvent", "movieStallEnd");
            EventContext eventContext2 = this.mEventContext;
            long j = eventContext2.mEndT - eventContext2.mStartT;
            eventContext2.mCostTime = j;
            if (j > 0) {
                this.mAccuCostTime += j;
            }
            eventContext2.mEndType = str;
            eventContext2.mLastSeekTime = this.mEventOpera.getLastSeekTime();
            EventContext eventContext3 = this.mEventContext;
            if (eventContext3.mLastSeekTime == 0) {
                eventContext3.mLastSeekTime = eventContext3.mStartT;
            }
            VideoEventBase videoEventBase = this.mEventBase;
            if (videoEventBase != null && (eventLoggerSource = videoEventBase.mDataSource) != null) {
                eventContext3.mResolutionAfter = videoEventBase.mCurrentResolution;
                eventContext3.mConfigBitrateAfter = videoEventBase.mCurrentConfigBitrate;
                eventContext3.mQualityDescAfter = videoEventBase.mCurrentQualityDesc;
                Map<String, Long> bytesInfo = eventLoggerSource.bytesInfo();
                if (bytesInfo != null) {
                    this.mEventContext.mVideoLenAfterMS = TTHelper.safelyUnbox(bytesInfo.get("vlen"));
                    this.mEventContext.mAudioLenAfterMS = TTHelper.safelyUnbox(bytesInfo.get("alen"));
                    this.mEventContext.mVideoLenDecAfterMs = TTHelper.safelyUnbox(bytesInfo.get("vDecLen"));
                    this.mEventContext.mVideoLenBaseAfterMs = TTHelper.safelyUnbox(bytesInfo.get("vBaseLen"));
                    this.mEventContext.mAudioLenDecAfterMs = TTHelper.safelyUnbox(bytesInfo.get("aDecLen"));
                    this.mEventContext.mAudioLenBaseAfterMs = TTHelper.safelyUnbox(bytesInfo.get("aBaseLen"));
                    this.mEventContext.mVideoAudioGap = TTHelper.safelyUnbox(bytesInfo.get("avGap"));
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("p", Integer.valueOf(this.mEventContext.mVideoPos));
            hashMap.put("t", Long.valueOf(this.mEventContext.mEndT));
            hashMap.put("c", Long.valueOf(this.mEventContext.mCostTime));
            this.mRebufList.add(new JSONObject(hashMap).toString());
            sendOneEvent();
            _triggerBufferEndCb();
            this.mEventContext = new EventContext();
            return;
        }
        TTVideoEngineLog.d("VideoEventOneEvent", "movieStallEnd without movieStalled, return.");
        EventContext eventContext4 = this.mEventContext;
        eventContext4.mPreStartT = -2147483648L;
        eventContext4.mBufferingType = -1;
    }

    VideoEventOneEvent(VideoEventBase videoEventBase, VideoEventOneOpera videoEventOneOpera) {
        this.mLastEventTimeMap = null;
        this.mEventContext = null;
        this.mEventBase = videoEventBase;
        this.mEventOpera = videoEventOneOpera;
        this.mLastEventTimeMap = new HashMap();
        this.mEventContext = new EventContext();
    }

    public void movieStalled(int i, int i2) {
        int isPowerSaveMode;
        Object obj;
        TTVideoEngineLog.d("VideoEventOneEvent", "movieStalled");
        this.mEventContext.mStartT = System.currentTimeMillis();
        EventContext eventContext = this.mEventContext;
        eventContext.mVideoPos = i;
        eventContext.mIndex = i2;
        eventContext.mEventType = "block_net";
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && videoEventBase.mDataSource != null) {
            eventContext.mResolutionBefore = videoEventBase.mCurrentResolution;
            eventContext.mConfigBitrateBefore = videoEventBase.mCurrentConfigBitrate;
            eventContext.mQualityDescBefore = videoEventBase.mCurrentQualityDesc;
            Map map = videoEventBase.abrInfo;
            if (map != null && (obj = map.get("abr_used")) != null) {
                this.mEventContext.mIsABR = ((Integer) obj).intValue();
            }
            this.mEventContext.mBytesFromMDL = this.mEventBase.mDataSource.getLogValueLong(56);
            Map<String, Long> parsePlayerBufferString = LoggerUtils.parsePlayerBufferString(this.mEventBase.mDataSource.getLogValueStr(55));
            if (parsePlayerBufferString.get("fvl") != null) {
                this.mEventContext.mVideoLenBeforeMS = parsePlayerBufferString.get("fvl").longValue();
            }
            if (parsePlayerBufferString.get("fal") != null) {
                this.mEventContext.mAudioLenBeforeMS = parsePlayerBufferString.get("fal").longValue();
            }
            if (parsePlayerBufferString.get("dvl") != null) {
                this.mEventContext.mVideoLenDecBeforeMs = parsePlayerBufferString.get("dvl").longValue();
            }
            if (parsePlayerBufferString.get("dal") != null) {
                this.mEventContext.mAudioLenDecBeforeMs = parsePlayerBufferString.get("dal").longValue();
            }
            if (parsePlayerBufferString.get("bvl") != null) {
                this.mEventContext.mVideoLenBaseBeforeMs = parsePlayerBufferString.get("bvl").longValue();
            }
            if (parsePlayerBufferString.get("bal") != null) {
                this.mEventContext.mAudioLenBaseBeforeMs = parsePlayerBufferString.get("bal").longValue();
            }
            if (parsePlayerBufferString.get("fvlim") != null) {
                this.mEventContext.mVideoLenOnlyBefore = parsePlayerBufferString.get("fvlim").longValue();
            }
            if (parsePlayerBufferString.get("falim") != null) {
                this.mEventContext.mAudioLenOnlyBefore = parsePlayerBufferString.get("falim").longValue();
            }
            this.mEventBase.mNetworkType = VideoEventBase.getNetType();
            VideoEventBase videoEventBase2 = this.mEventBase;
            if (videoEventBase2.mEnablePowerReport) {
                double cPURate = videoEventBase2.getCPURate();
                double cPUSpeed = this.mEventBase.getCPUSpeed();
                if (cPURate > 0.0d && cPUSpeed > 0.0d) {
                    EventContext eventContext2 = this.mEventContext;
                    eventContext2.mCpuRate = cPURate;
                    eventContext2.mCpuSpeed = cPUSpeed;
                } else {
                    EngineThreadPool.addExecuteTask(new StatisticDataRunnable(this.mEventContext, this.mEventBase));
                }
                this.mEventContext.mCurrent = this.mEventBase.getBatteryCurrent();
            }
            if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 2L) && (isPowerSaveMode = DeviceMonitorUtils.isPowerSaveMode(this.mEventBase.mContext)) >= 0) {
                this.mEventContext.mPowerSaveMode = isPowerSaveMode;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject toJsonObject(EventContext eventContext, VideoEventBase videoEventBase) {
        long j;
        long j2;
        HashMap hashMap = new HashMap();
        if (videoEventBase != null) {
            LoggerUtils.putToMap(hashMap, "player_sessionid", videoEventBase.mSessionID);
            String str = videoEventBase.mCurURL;
            if (str != null && !str.isEmpty()) {
                LoggerUtils.putToMap(hashMap, "cdn_url", videoEventBase.mCurURL);
            } else {
                LoggerUtils.putToMap(hashMap, "cdn_url", videoEventBase.mInitialURL);
            }
            String str2 = videoEventBase.mCurIP;
            if (str2 != null && !str2.isEmpty()) {
                LoggerUtils.putToMap(hashMap, "cdn_ip", videoEventBase.mCurIP);
            } else {
                LoggerUtils.putToMap(hashMap, "cdn_ip", videoEventBase.mInitialIP);
            }
            LoggerUtils.putToMap(hashMap, "resolution", videoEventBase.mCurrentResolution);
            LoggerUtils.putToMap(hashMap, "source_type", videoEventBase.mSourceTypeStr);
            LoggerUtils.putToMap(hashMap, "v", videoEventBase.mVid);
            LoggerUtils.putToMap(hashMap, "pv", videoEventBase.pv);
            LoggerUtils.putToMap(hashMap, "pc", videoEventBase.pc);
            LoggerUtils.putToMap(hashMap, "sv", videoEventBase.sv);
            LoggerUtils.putToMap(hashMap, "sdk_version", videoEventBase.sdk_version);
            LoggerUtils.putToMap(hashMap, "vtype", videoEventBase.vtype);
            LoggerUtils.putToMap(hashMap, "tag", videoEventBase.mTag);
            LoggerUtils.putToMap(hashMap, "subtag", videoEventBase.mSubTag);
            LoggerUtils.putToMap((Map) hashMap, "p2p_cdn_type", videoEventBase.mP2PCDNType);
            LoggerUtils.putToMap(hashMap, "codec", videoEventBase.codec_type);
            LoggerUtils.putToMap((Map) hashMap, "video_codec_nameid", videoEventBase.videoCodecNameId);
            LoggerUtils.putToMap((Map) hashMap, "audio_codec_nameid", videoEventBase.audioCodecNameId);
            LoggerUtils.putToMap((Map) hashMap, "format_type", videoEventBase.formatType);
            LoggerUtils.putToMap((Map) hashMap, "drm_type", videoEventBase.mDrmType);
            LoggerUtils.putToMap(hashMap, "play_speed", videoEventBase.mPlaySpeed);
            LoggerUtils.putToMap(hashMap, "net_type", videoEventBase.mNetworkType);
            LoggerUtils.putToMap(hashMap, "mdl_version", videoEventBase.mMdlVersion);
            LoggerUtils.putToMap((Map) hashMap, "enable_mdl", videoEventBase.mEnableMDL);
            LoggerUtils.putToMap((Map) hashMap, "video_hw", videoEventBase.mVideoHW);
            LoggerUtils.putToMap((Map) hashMap, "user_hw", videoEventBase.mVideoHWUser);
            LoggerUtils.putToMap((Map) hashMap, "reuse_socket", videoEventBase.mReuseSocket);
            LoggerUtils.putToMap((Map) hashMap, "cur_task_num", videoEventBase.mdl_cur_task_num);
            LoggerUtils.putToMap((Map) hashMap, "mdl_conc_count", videoEventBase.mdl_conc_count);
            LoggerUtils.putToMap((Map) hashMap, "mdl_dns_t", videoEventBase.mdlVideoInfo.mdl_dns_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_downloading", videoEventBase.mdlVideoInfo.mdl_downloading);
            LoggerUtils.putToMap((Map) hashMap, "mdl_last_read_time", videoEventBase.mdlVideoInfo.mdl_last_read_time);
            LoggerUtils.putToMap((Map) hashMap, "mdl_cdn_type", videoEventBase.mdlVideoInfo.mdl_cdn_type);
            LoggerUtils.putToMap((Map) hashMap, "mdl_mem_buffer_len", videoEventBase.mdlVideoInfo.mdl_mem_buffer_len);
            LoggerUtils.putToMap((Map) hashMap, "mdl_disk_buffer_len", videoEventBase.mdlVideoInfo.mdl_disk_buffer_len);
            LoggerUtils.putToMap((Map) hashMap, "mdl_send_offset", videoEventBase.mdlVideoInfo.mdl_send_offset);
            LoggerUtils.putToMap((Map) hashMap, "mdl_last_req_offset", videoEventBase.mdlVideoInfo.mdl_last_req_offset);
            LoggerUtils.putToMap((Map) hashMap, "cache_type", videoEventBase.mdlVideoInfo.mdl_cache_type);
            LoggerUtils.putToMap(hashMap, "cur_ip", videoEventBase.mdlVideoInfo.mdl_cur_ip);
            LoggerUtils.putToMap(hashMap, "cur_host", videoEventBase.mdlVideoInfo.mdl_cur_host);
            LoggerUtils.putToMap((Map) hashMap, "reply_size", videoEventBase.mdlVideoInfo.mdl_reply_size);
            LoggerUtils.putToMap((Map) hashMap, "mdl_ec", videoEventBase.mdlVideoInfo.mdl_error_code);
            LoggerUtils.putToMap((Map) hashMap, "mdl_speed", videoEventBase.mdlVideoInfo.mdl_speed);
            LoggerUtils.putToMap(hashMap, "mdl_file_key", videoEventBase.mdlVideoInfo.mdl_file_key);
            LoggerUtils.putToMap(hashMap, "mdl_re_url", videoEventBase.mdlVideoInfo.mdl_re_url);
            LoggerUtils.putToMap((Map) hashMap, "mdl_tbs", videoEventBase.mdlVideoInfo.mdl_tbs);
            LoggerUtils.putToMap((Map) hashMap, "mdl_lbs", videoEventBase.mdlVideoInfo.mdl_lbs);
            LoggerUtils.putToMap(hashMap, "mdl_response_cache", videoEventBase.mdlVideoInfo.mdl_cdn_cache);
            LoggerUtils.putToMap(hashMap, "mdl_response_cinfo", videoEventBase.mdlVideoInfo.mdl_client_info);
            LoggerUtils.putToMap((Map) hashMap, "a_cache_type", videoEventBase.mdlAudioInfo.mdl_cache_type);
            LoggerUtils.putToMap(hashMap, "a_cur_ip", videoEventBase.mdlAudioInfo.mdl_cur_ip);
            LoggerUtils.putToMap(hashMap, "a_cur_host", videoEventBase.mdlAudioInfo.mdl_cur_host);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_speed", videoEventBase.mdlAudioInfo.mdl_speed);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_tbs", videoEventBase.mdlAudioInfo.mdl_tbs);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_lbs", videoEventBase.mdlAudioInfo.mdl_lbs);
            LoggerUtils.putToMap(hashMap, "a_mdl_response_cache", videoEventBase.mdlAudioInfo.mdl_cdn_cache);
            LoggerUtils.putToMap(hashMap, "a_mdl_response_cinfo", videoEventBase.mdlAudioInfo.mdl_client_info);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_mem_buffer_len", videoEventBase.mdlAudioInfo.mdl_mem_buffer_len);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_disk_buffer_len", videoEventBase.mdlAudioInfo.mdl_disk_buffer_len);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_send_offset", videoEventBase.mdlAudioInfo.mdl_send_offset);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_last_req_offset", videoEventBase.mdlAudioInfo.mdl_last_req_offset);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_cdn_type", videoEventBase.mdlAudioInfo.mdl_cdn_type);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_last_read_time", videoEventBase.mdlAudioInfo.mdl_last_read_time);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_downloading", videoEventBase.mdlAudioInfo.mdl_downloading);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_dns_t", videoEventBase.mdlAudioInfo.mdl_dns_t);
            if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                LoggerUtils.putToMap(hashMap, "mdl_last_ip_list", videoEventBase.mdlVideoInfo.mdl_last_ip_list);
                LoggerUtils.putToMap(hashMap, "a_mdl_last_ip_list", videoEventBase.mdlAudioInfo.mdl_last_ip_list);
                LoggerUtils.putToMap((Map) hashMap, "a_cur_req_pos", videoEventBase.mdlAudioInfo.mdl_cur_req_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_cur_end_pos", videoEventBase.mdlAudioInfo.mdl_cur_end_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_cur_cache_pos", videoEventBase.mdlAudioInfo.mdl_cur_cache_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_reply_size", videoEventBase.mdlAudioInfo.mdl_reply_size);
                LoggerUtils.putToMap((Map) hashMap, "a_down_pos", videoEventBase.mdlAudioInfo.mdl_down_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_player_wait_time", videoEventBase.mdlAudioInfo.mdl_player_wait_time);
                LoggerUtils.putToMap((Map) hashMap, "a_player_wait_num", videoEventBase.mdlAudioInfo.mdl_player_wait_num);
                LoggerUtils.putToMap(hashMap, "a_mdl_file_key", videoEventBase.mdlAudioInfo.mdl_file_key);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_is_socrf", videoEventBase.mdlAudioInfo.mdl_is_socrf);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_req_num", videoEventBase.mdlAudioInfo.mdl_req_num);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_url_index", videoEventBase.mdlAudioInfo.mdl_url_index);
                LoggerUtils.putToMap(hashMap, "a_mdl_re_url", videoEventBase.mdlAudioInfo.mdl_re_url);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_cur_source", videoEventBase.mdlAudioInfo.mdl_cur_soure);
                LoggerUtils.putToMap(hashMap, "a_mdl_extra_info", videoEventBase.mdlAudioInfo.mdl_extra_info);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_fs", videoEventBase.mdlAudioInfo.mdl_fs);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_ec", videoEventBase.mdlAudioInfo.mdl_error_code);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_stage", videoEventBase.mdlAudioInfo.mdl_stage);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_p2p_sp", videoEventBase.mdlAudioInfo.mdl_pcdn_full_speed);
                LoggerUtils.putToMap((Map) hashMap, "cur_req_pos", videoEventBase.mdlVideoInfo.mdl_cur_req_pos);
                LoggerUtils.putToMap((Map) hashMap, "cur_end_pos", videoEventBase.mdlVideoInfo.mdl_cur_end_pos);
                LoggerUtils.putToMap((Map) hashMap, "cur_cache_pos", videoEventBase.mdlVideoInfo.mdl_cur_cache_pos);
                LoggerUtils.putToMap((Map) hashMap, "down_pos", videoEventBase.mdlVideoInfo.mdl_down_pos);
                LoggerUtils.putToMap((Map) hashMap, "player_wait_time", videoEventBase.mdlVideoInfo.mdl_player_wait_time);
                LoggerUtils.putToMap((Map) hashMap, "player_wait_num", videoEventBase.mdlVideoInfo.mdl_player_wait_num);
                LoggerUtils.putToMap((Map) hashMap, "mdl_is_socrf", videoEventBase.mdlVideoInfo.mdl_is_socrf);
                LoggerUtils.putToMap((Map) hashMap, "mdl_stage", videoEventBase.mdlVideoInfo.mdl_stage);
                LoggerUtils.putToMap((Map) hashMap, "mdl_req_num", videoEventBase.mdlVideoInfo.mdl_req_num);
                LoggerUtils.putToMap((Map) hashMap, "mdl_url_index", videoEventBase.mdlVideoInfo.mdl_url_index);
                LoggerUtils.putToMap((Map) hashMap, "mdl_cur_source", videoEventBase.mdlVideoInfo.mdl_cur_soure);
                LoggerUtils.putToMap(hashMap, "mdl_extra_info", videoEventBase.mdlVideoInfo.mdl_extra_info);
                LoggerUtils.putToMap((Map) hashMap, "mdl_fs", videoEventBase.mdlVideoInfo.mdl_fs);
                LoggerUtils.putToMap((Map) hashMap, "mdl_p2p_sp", videoEventBase.mdlVideoInfo.mdl_pcdn_full_speed);
            }
        }
        LoggerUtils.putToMap(hashMap, "event_type", eventContext.mEventType);
        LoggerUtils.putToMap((Map) hashMap, "cost_time", eventContext.mCostTime);
        LoggerUtils.putToMap(hashMap, "end_type", eventContext.mEndType);
        LoggerUtils.putToMap((Map) hashMap, "index", eventContext.mIndex);
        long j3 = this.mFirstFrameTime;
        long j4 = -1;
        if (j3 > 0) {
            j = eventContext.mStartT - j3;
        } else {
            j = -1;
        }
        LoggerUtils.putToMap((Map) hashMap, "first_frame_interval", j);
        long j5 = eventContext.mLastSeekTime;
        if (j5 > 0) {
            j2 = eventContext.mStartT - j5;
        } else {
            j2 = -1;
        }
        LoggerUtils.putToMap((Map) hashMap, "last_seek_interval", j2);
        if (this.mLastEventTimeMap.containsKey(eventContext.mEventType)) {
            long longValue = ((Long) this.mLastEventTimeMap.get(eventContext.mEventType)).longValue();
            if (longValue > 0) {
                j4 = eventContext.mStartT - longValue;
            }
        }
        LoggerUtils.putToMap((Map) hashMap, "last_event_interval", j4);
        LoggerUtils.putToMap((Map) hashMap, "last_switch_interval", -1);
        LoggerUtils.putToMap((Map) hashMap, "video_pos", eventContext.mVideoPos);
        LoggerUtils.putToMap((Map) hashMap, "retry_count", eventContext.mRetryCount);
        LoggerUtils.putToMap((Map) hashMap, "read_count_mdl", eventContext.mBytesFromMDL);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_before", eventContext.mAudioLenBeforeMS);
        LoggerUtils.putToMap((Map) hashMap, "video_len_before", eventContext.mVideoLenBeforeMS);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_after", eventContext.mAudioLenAfterMS);
        LoggerUtils.putToMap((Map) hashMap, "video_len_after", eventContext.mVideoLenAfterMS);
        LoggerUtils.putToMap((Map) hashMap, "vlen_dec_before", eventContext.mVideoLenDecBeforeMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_base_before", eventContext.mVideoLenBaseBeforeMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_dec_before", eventContext.mAudioLenDecBeforeMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_base_before", eventContext.mAudioLenBaseBeforeMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_dec_after", eventContext.mVideoLenDecAfterMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_base_after", eventContext.mVideoLenBaseAfterMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_dec_after", eventContext.mAudioLenDecAfterMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_base_after", eventContext.mAudioLenBaseAfterMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_only_before", eventContext.mVideoLenOnlyBefore);
        LoggerUtils.putToMap((Map) hashMap, "alen_only_before", eventContext.mAudioLenOnlyBefore);
        LoggerUtils.putToMap((Map) hashMap, "player_req_offset", eventContext.mPlayerReqOffset);
        LoggerUtils.putToMap((Map) hashMap, "a_player_req_offset", eventContext.mPlayerAudioReqOffset);
        LoggerUtils.putToMap((Map) hashMap, "player_read_state", eventContext.mPlayerReadState);
        LoggerUtils.putToMap((Map) hashMap, "av_gap", eventContext.mVideoAudioGap);
        LoggerUtils.putToMap((Map) hashMap, "buffer_reason", eventContext.mBufferingType);
        LoggerUtils.putToMap((Map) hashMap, "pst", eventContext.mPreStartT);
        LoggerUtils.putToMap((Map) hashMap, "st", eventContext.mStartT);
        LoggerUtils.putToMap((Map) hashMap, "et", eventContext.mEndT);
        LoggerUtils.putToMap(hashMap, "resolution_before", eventContext.mResolutionBefore);
        LoggerUtils.putToMap(hashMap, "resolution_after", eventContext.mResolutionAfter);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_before", eventContext.mConfigBitrateBefore);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_after", eventContext.mConfigBitrateAfter);
        LoggerUtils.putToMap((Map) hashMap, "is_abr", eventContext.mIsABR);
        LoggerUtils.putToMap(hashMap, "quality_desc_before", eventContext.mQualityDescBefore);
        LoggerUtils.putToMap(hashMap, "quality_desc_after", eventContext.mQualityDescAfter);
        LoggerUtils.putToMap((Map) hashMap, "bad_interlaced", this.mIsAVBadInterlaced);
        LoggerUtils.putToMap(hashMap, "cpu_rate", (float) eventContext.mCpuRate);
        LoggerUtils.putToMap(hashMap, "cpu_speed", (float) eventContext.mCpuSpeed);
        LoggerUtils.putToMap((Map) hashMap, "power_save_mode", eventContext.mPowerSaveMode);
        LoggerUtils.putToMap(hashMap, "battery_current", eventContext.mCurrent);
        LoggerUtils.putToMap((Map) hashMap, "network_score", PortraitNetworkScore.getInstance().getLastPortraitResult());
        LoggerUtils.putToMap(hashMap, "target_bitrate", (float) PortraitNetworkScore.getInstance().getLastTargetBitrate());
        Map<String, Object> popOneEventLog = StrategyHelper.helper().popOneEventLog(videoEventBase.mTraceID);
        if (popOneEventLog != null && !popOneEventLog.isEmpty()) {
            hashMap.putAll(popOneEventLog);
        }
        TTVideoEngineLog.d("VideoEventOneEvent", "OneEvent:" + hashMap);
        return new JSONObject(hashMap);
    }
}

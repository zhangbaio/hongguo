package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventOneOutSync {
    public EventContext mContext;
    public VideoEventBase mEventBase;
    public ArrayList<String> mList = new ArrayList<>();
    public int mAVOutSyncCount = 0;
    public int mIndex = 0;
    public long mFirstFrameTime = -2147483648L;
    public long mLastEventTime = -2147483648L;
    public long mVideoStreamDuration = -2147483648L;
    public long mAudioStreamDuration = -2147483648L;
    public int mIsAVBadInterlaced = 0;

    static {
        Covode.recordClassIndex(652512);
    }

    public void onAVBadInterlaced() {
        this.mIsAVBadInterlaced = 1;
    }

    public void showedFirstFrame() {
        this.mFirstFrameTime = System.currentTimeMillis();
    }

    private void _triggerOutSyncStartCb() {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && videoEventBase.mDataSource != null) {
            this.mEventBase.mDataSource.onInfo(3, new HashMap());
        }
    }

    public void reset() {
        this.mList = new ArrayList<>();
        this.mAVOutSyncCount = 0;
        this.mIndex = 0;
        this.mFirstFrameTime = -2147483648L;
        this.mLastEventTime = -2147483648L;
        this.mIsAVBadInterlaced = 0;
    }

    public void sendOutSyncEvent() {
        TTVideoEngineLog.i("VideoEventOneOutSync", "report oussync event");
        this.mEventBase.updateVideoInfo(null);
        VideoEventBase videoEventBase = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(videoEventBase.mContext, this, videoEventBase, this.mContext));
    }

    private static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventOneOutSync rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler = new HandlerDelegate(Looper.getMainLooper());

        static {
            Covode.recordClassIndex(652513);
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            VideoEventOneOutSync videoEventOneOutSync = this.rEvent;
            if (videoEventOneOutSync == null) {
                return;
            }
            VideoEventBase videoEventBase = this.rEventBase;
            if (videoEventBase != null && videoEventBase.isUploadLogEnabled) {
                z = true;
            } else {
                z = false;
            }
            final JSONObject jsonObject = videoEventOneOutSync.toJsonObject(this.rEventContext, videoEventBase);
            Handler handler = this.rHandler;
            if (handler != null && handler.getLooper() != null) {
                this.rHandler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventOneOutSync.AsyncGetLogDataRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneevent");
                    }
                });
                this.rEvent.mLastEventTime = this.rEventContext.mEndT;
                return;
            }
            VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneevent");
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventOneOutSync videoEventOneOutSync, VideoEventBase videoEventBase, EventContext eventContext) {
            this.rEvent = videoEventOneOutSync;
            this.rEventBase = videoEventBase;
            this.rContext = context;
            this.rEventContext = eventContext;
        }
    }

    private static class StatisticDataRunnable implements Runnable {
        private final WeakReference<EventContext> rEvent;
        private final WeakReference<VideoEventBase> rEventBase;

        static {
            Covode.recordClassIndex(652515);
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

    private void _triggerOutSyncEndCb() {
        long j;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && videoEventBase.mDataSource != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("begin_pos", Integer.valueOf(this.mContext.mBeginPos));
            hashMap.put("end_pos", Integer.valueOf(this.mContext.mEndPos));
            hashMap.put("render_drop_cnt", Integer.valueOf(this.mContext.mDropCount));
            hashMap.put("container_fps", Float.valueOf(this.mEventBase.mDataSource.getLogValueFloat(82)));
            hashMap.put("video_out_fps", Float.valueOf(this.mEventBase.mDataSource.getLogValueFloat(83)));
            hashMap.put("clock_diff", Long.valueOf(this.mEventBase.mDataSource.getLogValueLong(45)));
            int logValueInt = this.mEventBase.mDataSource.getLogValueInt(84);
            if (logValueInt > 0) {
                j = 1000 / logValueInt;
            } else {
                j = 0;
            }
            hashMap.put("decode_time", Long.valueOf(j));
            this.mEventBase.mDataSource.onInfo(4, hashMap);
        }
    }

    private class EventContext {
        private long mAudioBaseLenMs;
        private long mAudioDecoderLenMs;
        private long mAudioFormaterLenMs;
        private int mBeginPos;
        private int mBitrateAfter;
        private int mBitrateBefore;
        public int mBt;
        private long mCostTime;
        public double mCpuRate;
        public double mCpuSpeed;
        public float mCurrent;
        private int mDropCount;
        private int mEndPos;
        private long mEndT;
        private String mEndType;
        public int mHeadset;
        public int mIsABR;
        public int mIsBackground;
        public int mIsCharging;
        public int mIsRadioMode;
        public long mLastAVSwitchInterval;
        public long mLastForebackSwitchInterval;
        public long mLastHeadsetSwitchInterval;
        private long mLastRebufT;
        public long mLastResSwitchInterval;
        private long mLastSeekT;
        public long mMaxAVDiff;
        private ArrayList<Long> mPauseTimeList;
        public int mPower;
        public int mPowerSaveMode;
        private String mPtsList;
        private String mQualityDescAfter;
        private String mQualityDescBefore;
        private String mResolultionAfter;
        private String mResolutionBefore;
        private long mStartT;
        private long mVideoBaseLenMs;
        private String mVideoDecFpsList;
        private long mVideoDecoderLenMs;
        private long mVideoFormaterLenMS;

        static {
            Covode.recordClassIndex(652514);
        }

        private EventContext() {
            this.mStartT = -2147483648L;
            this.mEndT = -2147483648L;
            this.mPtsList = null;
            this.mDropCount = Integer.MIN_VALUE;
            this.mAudioFormaterLenMs = -2147483648L;
            this.mVideoFormaterLenMS = -2147483648L;
            this.mAudioDecoderLenMs = -2147483648L;
            this.mVideoDecoderLenMs = -2147483648L;
            this.mAudioBaseLenMs = -2147483648L;
            this.mVideoBaseLenMs = -2147483648L;
            this.mResolutionBefore = null;
            this.mResolultionAfter = null;
            this.mBitrateBefore = Integer.MIN_VALUE;
            this.mBitrateAfter = Integer.MIN_VALUE;
            this.mVideoDecFpsList = null;
            this.mLastRebufT = -2147483648L;
            this.mLastSeekT = -2147483648L;
            this.mBeginPos = Integer.MIN_VALUE;
            this.mEndPos = Integer.MIN_VALUE;
            this.mCostTime = -2147483648L;
            this.mEndType = null;
            this.mIsABR = Integer.MIN_VALUE;
            this.mQualityDescBefore = "";
            this.mQualityDescAfter = "";
            this.mIsRadioMode = Integer.MIN_VALUE;
            this.mLastAVSwitchInterval = -2147483648L;
            this.mLastResSwitchInterval = -2147483648L;
            this.mHeadset = Integer.MIN_VALUE;
            this.mBt = Integer.MIN_VALUE;
            this.mLastHeadsetSwitchInterval = -2147483648L;
            this.mPower = Integer.MIN_VALUE;
            this.mIsCharging = Integer.MIN_VALUE;
            this.mMaxAVDiff = -2147483648L;
            this.mIsBackground = Integer.MIN_VALUE;
            this.mLastForebackSwitchInterval = -2147483648L;
            this.mPauseTimeList = new ArrayList<>();
            this.mCpuRate = 1.401298464324817E-45d;
            this.mCpuSpeed = 1.401298464324817E-45d;
            this.mPowerSaveMode = Integer.MIN_VALUE;
            this.mCurrent = Float.MIN_VALUE;
        }
    }

    public VideoEventOneOutSync(VideoEventBase videoEventBase) {
        this.mContext = null;
        this.mEventBase = videoEventBase;
        this.mContext = new EventContext();
    }

    public void setLongValue(int i, long j) {
        if (i == 1) {
            this.mContext.mPauseTimeList.add(Long.valueOf(j));
        }
    }

    public void AVOutSyncEnd(int i, String str) {
        if (this.mContext.mStartT <= 0) {
            TTVideoEngineLog.w("VideoEventOneOutSync", "Invalid start time, return." + this.mContext.mStartT);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mContext.mStartT;
        if (j > 200) {
            this.mContext.mEndType = str;
            this.mContext.mEndPos = i;
            this.mContext.mEndT = currentTimeMillis;
            this.mContext.mCostTime = j;
            this.mIndex++;
            this.mAVOutSyncCount++;
            VideoEventBase videoEventBase = this.mEventBase;
            if (videoEventBase != null) {
                this.mContext.mResolultionAfter = videoEventBase.mCurrentResolution;
                this.mContext.mBitrateAfter = this.mEventBase.mCurrentConfigBitrate;
                this.mContext.mQualityDescAfter = this.mEventBase.mCurrentQualityDesc;
                EventLoggerSource eventLoggerSource = this.mEventBase.mDataSource;
                if (eventLoggerSource != null) {
                    this.mContext.mDropCount = eventLoggerSource.getLogValueInt(79);
                    if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                        this.mContext.mPtsList = this.mEventBase.mDataSource.getLogValueStr(78);
                        this.mContext.mVideoDecFpsList = this.mEventBase.mDataSource.getLogValueStr(80);
                    }
                    this.mContext.mMaxAVDiff = this.mEventBase.mDataSource.getLogValueLong(96);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ps", Integer.valueOf(this.mContext.mBeginPos));
            hashMap.put("pe", Integer.valueOf(this.mContext.mEndPos));
            hashMap.put("st", Long.valueOf(this.mContext.mStartT));
            hashMap.put("c", Long.valueOf(this.mContext.mCostTime));
            this.mList.add(new JSONObject(hashMap).toString());
            sendOutSyncEvent();
            _triggerOutSyncEndCb();
            this.mContext = new EventContext();
            return;
        }
        _triggerOutSyncEndCb();
        this.mContext = new EventContext();
    }

    public JSONObject toJsonObject(EventContext eventContext, VideoEventBase videoEventBase) {
        long j;
        HashMap hashMap = new HashMap();
        if (videoEventBase != null) {
            LoggerUtils.putToMap(hashMap, "player_sessionid", this.mEventBase.mSessionID);
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
        }
        LoggerUtils.putToMap(hashMap, "event_type", "av_outsync");
        LoggerUtils.putToMap((Map) hashMap, "st", eventContext.mStartT);
        LoggerUtils.putToMap((Map) hashMap, "et", eventContext.mEndT);
        LoggerUtils.putToMap((Map) hashMap, "cost_time", eventContext.mCostTime);
        LoggerUtils.putToMap(hashMap, "end_type", eventContext.mEndType);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_before", eventContext.mAudioFormaterLenMs);
        LoggerUtils.putToMap((Map) hashMap, "video_len_before", eventContext.mVideoFormaterLenMS);
        LoggerUtils.putToMap((Map) hashMap, "alen_dec_before", eventContext.mAudioDecoderLenMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_dec_before", eventContext.mVideoDecoderLenMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_base_before", eventContext.mAudioBaseLenMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_base_before", eventContext.mVideoBaseLenMs);
        LoggerUtils.putToMap(hashMap, "resolution_before", eventContext.mResolutionBefore);
        LoggerUtils.putToMap(hashMap, "resolution_after", eventContext.mResolultionAfter);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_before", eventContext.mBitrateBefore);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_after", eventContext.mBitrateAfter);
        LoggerUtils.putToMap((Map) hashMap, "index", this.mIndex);
        LoggerUtils.putToMap((Map) hashMap, "radio_mode", eventContext.mIsRadioMode);
        LoggerUtils.putToMap((Map) hashMap, "last_av_switch_interval", eventContext.mLastAVSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "last_res_switch_interval", eventContext.mLastResSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "headset", eventContext.mHeadset);
        LoggerUtils.putToMap((Map) hashMap, "bt", eventContext.mBt);
        LoggerUtils.putToMap((Map) hashMap, "last_headset_switch_interval", eventContext.mLastHeadsetSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "power", eventContext.mPower);
        LoggerUtils.putToMap((Map) hashMap, "is_charging", eventContext.mIsCharging);
        LoggerUtils.putToMap((Map) hashMap, "max_av_diff", eventContext.mMaxAVDiff);
        LoggerUtils.putToMap((Map) hashMap, "is_background", eventContext.mIsBackground);
        LoggerUtils.putToMap((Map) hashMap, "last_foreback_switch_interval", eventContext.mLastForebackSwitchInterval);
        long j2 = -1;
        if (this.mFirstFrameTime > 0) {
            j = eventContext.mStartT - this.mFirstFrameTime;
        } else {
            j = -1;
        }
        LoggerUtils.putToMap((Map) hashMap, "first_frame_interval", j);
        if (this.mLastEventTime > 0) {
            j2 = eventContext.mStartT - this.mLastEventTime;
        }
        LoggerUtils.putToMap((Map) hashMap, "last_event_interval", j2);
        LoggerUtils.putToMap((Map) hashMap, "begin_pos", eventContext.mBeginPos);
        LoggerUtils.putToMap((Map) hashMap, "end_pos", eventContext.mEndPos);
        LoggerUtils.putToMap((Map) hashMap, "drop_cnt", eventContext.mDropCount);
        if (eventContext.mLastRebufT > 0) {
            LoggerUtils.putToMap((Map) hashMap, "last_rebuf_interval", eventContext.mStartT - eventContext.mLastRebufT);
        }
        if (eventContext.mLastSeekT > 0) {
            LoggerUtils.putToMap((Map) hashMap, "last_seek_interval", eventContext.mStartT - eventContext.mLastSeekT);
        }
        LoggerUtils.putToMap((Map) hashMap, "is_abr", eventContext.mIsABR);
        LoggerUtils.putToMap(hashMap, "quality_desc_before", eventContext.mQualityDescBefore);
        LoggerUtils.putToMap(hashMap, "quality_desc_after", eventContext.mQualityDescAfter);
        LoggerUtils.putToMap((Map) hashMap, "bad_interlaced", this.mIsAVBadInterlaced);
        LoggerUtils.putToMap((Map) hashMap, "v_duration", this.mVideoStreamDuration);
        LoggerUtils.putToMap((Map) hashMap, "a_duration", this.mAudioStreamDuration);
        LoggerUtils.putToMap(hashMap, "cpu_rate", (float) eventContext.mCpuRate);
        LoggerUtils.putToMap(hashMap, "cpu_speed", (float) eventContext.mCpuSpeed);
        LoggerUtils.putToMap((Map) hashMap, "power_save_mode", eventContext.mPowerSaveMode);
        LoggerUtils.putToMap(hashMap, "battery_current", eventContext.mCurrent);
        if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
            LoggerUtils.putToMap(hashMap, "v_dec_fps_list", eventContext.mVideoDecFpsList);
            LoggerUtils.putToMap(hashMap, "pts_list", eventContext.mPtsList);
            LoggerUtils.putToMap(hashMap, "pause_time_list", eventContext.mPauseTimeList);
        }
        return new JSONObject(hashMap);
    }

    public void AVOutSyncStart(int i, long j, long j2, long j3) {
        int isPowerSaveMode;
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext.mStartT = currentTimeMillis;
        this.mContext.mBeginPos = i;
        if (j != 0) {
            this.mContext.mLastRebufT = j;
        } else {
            EventContext eventContext = this.mContext;
            eventContext.mLastRebufT = eventContext.mStartT;
        }
        if (j2 != 0) {
            this.mContext.mLastSeekT = j2;
        } else {
            EventContext eventContext2 = this.mContext;
            eventContext2.mLastSeekT = eventContext2.mStartT;
        }
        if (j3 > 0) {
            this.mContext.mLastHeadsetSwitchInterval = currentTimeMillis - j3;
        }
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            this.mContext.mResolutionBefore = videoEventBase.mCurrentResolution;
            this.mContext.mBitrateBefore = this.mEventBase.mCurrentConfigBitrate;
            this.mContext.mQualityDescBefore = this.mEventBase.mCurrentQualityDesc;
            Map map = this.mEventBase.abrInfo;
            if (map != null && (obj = map.get("abr_used")) != null) {
                this.mContext.mIsABR = ((Integer) obj).intValue();
            }
            EventLoggerSource eventLoggerSource = this.mEventBase.mDataSource;
            if (eventLoggerSource != null) {
                Map<String, Long> parsePlayerBufferString = LoggerUtils.parsePlayerBufferString(eventLoggerSource.getLogValueStr(55));
                if (parsePlayerBufferString.get("fvl") != null) {
                    this.mContext.mVideoFormaterLenMS = parsePlayerBufferString.get("fvl").longValue();
                }
                if (parsePlayerBufferString.get("fal") != null) {
                    this.mContext.mAudioFormaterLenMs = parsePlayerBufferString.get("fal").longValue();
                }
                if (parsePlayerBufferString.get("dvl") != null) {
                    this.mContext.mVideoDecoderLenMs = parsePlayerBufferString.get("dvl").longValue();
                }
                if (parsePlayerBufferString.get("dal") != null) {
                    this.mContext.mAudioDecoderLenMs = parsePlayerBufferString.get("dal").longValue();
                }
                if (parsePlayerBufferString.get("bvl") != null) {
                    this.mContext.mVideoBaseLenMs = parsePlayerBufferString.get("bvl").longValue();
                }
                if (parsePlayerBufferString.get("bal") != null) {
                    this.mContext.mAudioBaseLenMs = parsePlayerBufferString.get("bal").longValue();
                }
                this.mContext.mIsRadioMode = this.mEventBase.mDataSource.getLogValueInt(88);
                this.mContext.mHeadset = this.mEventBase.mDataSource.getLogValueInt(89);
                this.mContext.mBt = this.mEventBase.mDataSource.getLogValueInt(90);
                this.mContext.mIsBackground = this.mEventBase.mDataSource.getLogValueInt(94);
                long logValueLong = this.mEventBase.mDataSource.getLogValueLong(91);
                if (logValueLong > 0) {
                    this.mContext.mLastAVSwitchInterval = currentTimeMillis - logValueLong;
                }
                long logValueLong2 = this.mEventBase.mDataSource.getLogValueLong(92);
                if (logValueLong2 > 0) {
                    this.mContext.mLastResSwitchInterval = currentTimeMillis - logValueLong2;
                }
                long logValueLong3 = this.mEventBase.mDataSource.getLogValueLong(95);
                if (logValueLong3 > 0) {
                    this.mContext.mLastForebackSwitchInterval = currentTimeMillis - logValueLong3;
                }
                HashMap<String, Object> chargingState = this.mEventBase.getChargingState();
                if (chargingState != null) {
                    this.mContext.mPower = ((Integer) chargingState.get("power")).intValue();
                    this.mContext.mIsCharging = ((Integer) chargingState.get("isCharging")).intValue();
                }
            }
            VideoEventBase videoEventBase2 = this.mEventBase;
            if (videoEventBase2.mEnablePowerReport) {
                double cPURate = videoEventBase2.getCPURate();
                double cPUSpeed = this.mEventBase.getCPUSpeed();
                if (cPURate > 0.0d && cPUSpeed > 0.0d) {
                    EventContext eventContext3 = this.mContext;
                    eventContext3.mCpuRate = cPURate;
                    eventContext3.mCpuSpeed = cPUSpeed;
                } else {
                    EngineThreadPool.addExecuteTask(new StatisticDataRunnable(this.mContext, this.mEventBase));
                }
                this.mContext.mCurrent = this.mEventBase.getBatteryCurrent();
            }
            if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 2L) && (isPowerSaveMode = DeviceMonitorUtils.isPowerSaveMode(this.mEventBase.mContext)) >= 0) {
                this.mContext.mPowerSaveMode = isPowerSaveMode;
            }
        }
        _triggerOutSyncStartCb();
    }
}

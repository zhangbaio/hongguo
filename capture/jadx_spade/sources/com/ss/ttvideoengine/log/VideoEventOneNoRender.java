package com.ss.ttvideoengine.log;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.log.VideoEventOneNoRender;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventOneNoRender {
    private int index;
    private boolean isStarted;
    private ArrayList<String> mAudioHistoryList;
    private VideoEventBase mEventBase;
    private ArrayList<String> mVideoHistoryList;
    public long mFirstFrameTime = -2147483648L;
    public int mIsAVBadInterlaced = 0;
    private EventContext mEventContext = new EventContext();

    static {
        Covode.recordClassIndex(652505);
    }

    public static int unifyReason(int i) {
        return i != 0 ? 2 : 1;
    }

    public void onAVBadInterlaced() {
        this.mIsAVBadInterlaced = 1;
    }

    public ArrayList<String> getAudioHistory() {
        return this.mAudioHistoryList;
    }

    public ArrayList<String> getVideoHistory() {
        return this.mVideoHistoryList;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public String getRenderStageError() {
        return this.mEventContext.stageError;
    }

    public int getType() {
        return this.mEventContext.noRenderType;
    }

    public void showedFirstFrame() {
        this.mFirstFrameTime = System.currentTimeMillis();
    }

    public void reset() {
        this.mEventContext = new EventContext();
        this.mVideoHistoryList = null;
        this.mAudioHistoryList = null;
        this.isStarted = false;
        this.index = 0;
        this.mFirstFrameTime = -2147483648L;
        this.mIsAVBadInterlaced = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class AsyncGetLogDataRunnable implements Runnable {
        private final VideoEventOneNoRender event;
        private final VideoEventBase eventBase;
        private final EventContext eventContext;
        private final Handler handler = new HandlerDelegate(Looper.getMainLooper());

        static {
            Covode.recordClassIndex(652506);
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            VideoEventOneNoRender videoEventOneNoRender = this.event;
            if (videoEventOneNoRender == null) {
                return;
            }
            VideoEventBase videoEventBase = this.eventBase;
            if (videoEventBase != null && videoEventBase.isUploadLogEnabled) {
                z = true;
            } else {
                z = false;
            }
            final JSONObject jsonObject = videoEventOneNoRender.toJsonObject(videoEventBase, this.eventContext);
            this.handler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.q
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEventOneNoRender.AsyncGetLogDataRunnable.lambda$run$0(z, jsonObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(boolean z, JSONObject jSONObject) {
            VideoEventManager.instance.addEventV2(z, jSONObject, "videoplayer_oneevent");
        }

        public AsyncGetLogDataRunnable(VideoEventOneNoRender videoEventOneNoRender, VideoEventBase videoEventBase, EventContext eventContext) {
            this.event = videoEventOneNoRender;
            this.eventBase = videoEventBase;
            this.eventContext = eventContext;
        }
    }

    private static class StatisticDataRunnable implements Runnable {
        private final WeakReference<EventContext> rEvent;
        private final WeakReference<VideoEventBase> rEventBase;

        static {
            Covode.recordClassIndex(652508);
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

    private void addToHistory() {
        String generateHistory = generateHistory(this.mEventContext);
        if (TextUtils.isEmpty(generateHistory)) {
            return;
        }
        int i = this.mEventContext.noRenderType;
        if (i == 0) {
            if (this.mVideoHistoryList == null) {
                this.mVideoHistoryList = new ArrayList<>();
            }
            this.mVideoHistoryList.add(generateHistory);
        } else if (i == 1) {
            if (this.mAudioHistoryList == null) {
                this.mAudioHistoryList = new ArrayList<>();
            }
            this.mAudioHistoryList.add(generateHistory);
        }
    }

    private void maybeSendEvent() {
        if (this.mEventContext.costTime < 1000) {
            TTVideoEngineLog.d("VideoEventOneNoRender", "duration less than threshold, abort event");
            return;
        }
        this.index++;
        this.mEventBase.updateVideoInfo(null);
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(this, this.mEventBase, this.mEventContext));
    }

    private static class EventContext {
        long audioBaseLengthMs;
        long audioDecoderLengthMs;
        long audioFormatLengthMs;
        long costTime;
        int mBeginPos;
        int mBt;
        double mCpuRate;
        double mCpuSpeed;
        float mCurrent;
        long mDequeueOutputBufferCountInEnd;
        long mDequeueOutputBufferCountInStart;
        int mEnableGloablMuteFeature;
        int mEndPos;
        long mEndT;
        String mEndType;
        int mGlobalMute;
        int mHeadset;
        int mIsABR;
        int mIsBackground;
        int mIsRadioMode;
        long mLastAVSwitchInterval;
        long mLastForebackSwitchInterval;
        long mLastHeadsetSwitchInterval;
        long mLastRebufT;
        long mLastResSwitchInterval;
        long mLastSeekT;
        long mLastSetSurfaceNullInterval;
        int mMcMonitorQueueSizeInEnd;
        int mMcMonitorQueueSizeInStart;
        int mPowerSaveMode;
        String mQualityDescBefore;
        long mQueueInputBufferCountInEnd;
        long mQueueInputBufferCountInStart;
        String mResolutionBefore;
        int mSetValidSurfaceTimeout;
        int noRenderType;
        int reason;
        String stageError;
        long startTime;
        long videoBaseLengthMs;
        long videoDecoderLengthMs;
        long videoFormatLengthMs;

        static {
            Covode.recordClassIndex(652507);
        }

        private EventContext() {
            this.noRenderType = Integer.MIN_VALUE;
            this.reason = Integer.MIN_VALUE;
            this.videoFormatLengthMs = -2147483648L;
            this.audioFormatLengthMs = -2147483648L;
            this.videoDecoderLengthMs = -2147483648L;
            this.audioDecoderLengthMs = -2147483648L;
            this.videoBaseLengthMs = -2147483648L;
            this.audioBaseLengthMs = -2147483648L;
            this.startTime = -2147483648L;
            this.costTime = -2147483648L;
            this.mEndT = -2147483648L;
            this.mResolutionBefore = null;
            this.mLastRebufT = -2147483648L;
            this.mLastSeekT = -2147483648L;
            this.mBeginPos = Integer.MIN_VALUE;
            this.mEndPos = Integer.MIN_VALUE;
            this.mEndType = null;
            this.mIsABR = Integer.MIN_VALUE;
            this.mQualityDescBefore = "";
            this.mIsRadioMode = Integer.MIN_VALUE;
            this.mLastAVSwitchInterval = -2147483648L;
            this.mLastResSwitchInterval = -2147483648L;
            this.mHeadset = Integer.MIN_VALUE;
            this.mBt = Integer.MIN_VALUE;
            this.mLastHeadsetSwitchInterval = -2147483648L;
            this.mIsBackground = Integer.MIN_VALUE;
            this.mLastForebackSwitchInterval = -2147483648L;
            this.mLastSetSurfaceNullInterval = -2147483648L;
            this.mSetValidSurfaceTimeout = Integer.MIN_VALUE;
            this.mEnableGloablMuteFeature = 0;
            this.mGlobalMute = 0;
            this.mCpuRate = 1.401298464324817E-45d;
            this.mCpuSpeed = 1.401298464324817E-45d;
            this.mPowerSaveMode = Integer.MIN_VALUE;
            this.mCurrent = Float.MIN_VALUE;
            this.mQueueInputBufferCountInStart = -2147483648L;
            this.mDequeueOutputBufferCountInStart = -2147483648L;
            this.mMcMonitorQueueSizeInStart = Integer.MIN_VALUE;
            this.mQueueInputBufferCountInEnd = -2147483648L;
            this.mDequeueOutputBufferCountInEnd = -2147483648L;
            this.mMcMonitorQueueSizeInEnd = Integer.MIN_VALUE;
        }
    }

    public void updateEventBase(VideoEventBase videoEventBase) {
        this.mEventBase = videoEventBase;
    }

    public boolean isType(int i) {
        if (this.mEventContext.noRenderType == i) {
            return true;
        }
        return false;
    }

    public void updateReason(int i) {
        EventContext eventContext = this.mEventContext;
        if (eventContext.reason != 0 && i == 0) {
            eventContext.reason = 0;
        }
    }

    public VideoEventOneNoRender(VideoEventBase videoEventBase) {
        this.mEventBase = videoEventBase;
    }

    private static String generateHistory(EventContext eventContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("st", Long.valueOf(eventContext.startTime));
        hashMap.put("c", Long.valueOf(eventContext.costTime));
        hashMap.put("reason", Integer.valueOf(eventContext.reason));
        try {
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String parseNoRenderError(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split(";|=");
        if (split == null || split.length == 0) {
            return null;
        }
        for (int i = 0; i < split.length - 1; i += 2) {
            try {
                hashMap.put(split[i], Integer.valueOf(Integer.parseInt(split[i + 1])));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return new JSONObject(hashMap).toString();
    }

    public void end(int i, String str) {
        EventLoggerSource eventLoggerSource;
        if (!isStarted()) {
            return;
        }
        this.isStarted = false;
        long currentTimeMillis = System.currentTimeMillis();
        EventContext eventContext = this.mEventContext;
        long j = eventContext.startTime;
        if (j > 0) {
            eventContext.costTime = currentTimeMillis - j;
        }
        eventContext.mEndType = str;
        eventContext.mEndPos = i;
        eventContext.mEndT = currentTimeMillis;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && (eventLoggerSource = videoEventBase.mDataSource) != null) {
            eventContext.mSetValidSurfaceTimeout = eventLoggerSource.getLogValueInt(113);
            EventContext eventContext2 = this.mEventContext;
            if (eventContext2.noRenderType == 0) {
                eventContext2.mQueueInputBufferCountInEnd = this.mEventBase.mDataSource.getLogValueLong(152);
                this.mEventContext.mDequeueOutputBufferCountInEnd = this.mEventBase.mDataSource.getLogValueLong(153);
                this.mEventContext.mMcMonitorQueueSizeInEnd = this.mEventBase.mDataSource.getLogValueInt(154);
            }
        }
        addToHistory();
        maybeSendEvent();
        this.mEventContext = new EventContext();
    }

    public JSONObject toJsonObject(VideoEventBase videoEventBase, EventContext eventContext) {
        long j;
        HashMap hashMap = new HashMap();
        LoggerUtils.putToMap(hashMap, "event_type", "av_norender");
        if (videoEventBase != null) {
            LoggerUtils.putToMap(hashMap, "player_sessionid", videoEventBase.mSessionID);
            LoggerUtils.putToMap(hashMap, "sdk_version", videoEventBase.sdk_version);
        }
        LoggerUtils.putToMap(hashMap, "r_stage_errcs", eventContext.stageError);
        LoggerUtils.putToMap((Map) hashMap, "video_len_before", eventContext.videoFormatLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_before", eventContext.audioFormatLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_dec_before", eventContext.videoDecoderLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_dec_before", eventContext.audioDecoderLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "vlen_base_before", eventContext.videoBaseLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "alen_base_before", eventContext.audioBaseLengthMs);
        LoggerUtils.putToMap((Map) hashMap, "cost_time", eventContext.costTime);
        LoggerUtils.putToMap((Map) hashMap, "index", this.index);
        LoggerUtils.putToMap((Map) hashMap, "norender_type", eventContext.noRenderType);
        LoggerUtils.putToMap((Map) hashMap, "reason", eventContext.reason);
        if (videoEventBase != null) {
            String str = videoEventBase.mCurURL;
            if (str != null && !str.isEmpty()) {
                LoggerUtils.putToMap(hashMap, "cdn_url", videoEventBase.mCurURL);
            } else {
                LoggerUtils.putToMap(hashMap, "cdn_url", videoEventBase.mInitialURL);
            }
            LoggerUtils.putToMap(hashMap, "source_type", videoEventBase.mSourceTypeStr);
            LoggerUtils.putToMap(hashMap, "v", videoEventBase.mVid);
            LoggerUtils.putToMap(hashMap, "vtype", videoEventBase.vtype);
            LoggerUtils.putToMap(hashMap, "tag", videoEventBase.mTag);
            LoggerUtils.putToMap(hashMap, "subtag", videoEventBase.mSubTag);
            LoggerUtils.putToMap(hashMap, "codec", videoEventBase.codec_type);
            LoggerUtils.putToMap((Map) hashMap, "video_codec_nameid", videoEventBase.videoCodecNameId);
            LoggerUtils.putToMap((Map) hashMap, "audio_codec_nameid", videoEventBase.audioCodecNameId);
            LoggerUtils.putToMap((Map) hashMap, "format_type", videoEventBase.formatType);
            LoggerUtils.putToMap((Map) hashMap, "drm_type", videoEventBase.mDrmType);
            LoggerUtils.putToMap(hashMap, "play_speed", videoEventBase.mPlaySpeed);
            LoggerUtils.putToMap((Map) hashMap, "enable_mdl", videoEventBase.mEnableMDL);
            LoggerUtils.putToMap((Map) hashMap, "video_hw", videoEventBase.mVideoHW);
            LoggerUtils.putToMap((Map) hashMap, "user_hw", videoEventBase.mVideoHWUser);
        }
        LoggerUtils.putToMap((Map) hashMap, "st", eventContext.startTime);
        LoggerUtils.putToMap((Map) hashMap, "et", eventContext.mEndT);
        LoggerUtils.putToMap(hashMap, "end_type", eventContext.mEndType);
        LoggerUtils.putToMap(hashMap, "resolution_before", eventContext.mResolutionBefore);
        LoggerUtils.putToMap((Map) hashMap, "radio_mode", eventContext.mIsRadioMode);
        LoggerUtils.putToMap((Map) hashMap, "setvalidsurface_timeout", eventContext.mSetValidSurfaceTimeout);
        LoggerUtils.putToMap((Map) hashMap, "last_av_switch_interval", eventContext.mLastAVSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "last_res_switch_interval", eventContext.mLastResSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "headset", eventContext.mHeadset);
        LoggerUtils.putToMap((Map) hashMap, "bt", eventContext.mBt);
        LoggerUtils.putToMap((Map) hashMap, "last_headset_switch_interval", eventContext.mLastHeadsetSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "is_background", eventContext.mIsBackground);
        LoggerUtils.putToMap((Map) hashMap, "last_foreback_switch_interval", eventContext.mLastForebackSwitchInterval);
        LoggerUtils.putToMap((Map) hashMap, "last_setsurfacenull_interval", eventContext.mLastSetSurfaceNullInterval);
        long j2 = this.mFirstFrameTime;
        if (j2 > 0) {
            j = eventContext.startTime - j2;
        } else {
            j = -1;
        }
        LoggerUtils.putToMap((Map) hashMap, "first_frame_interval", j);
        LoggerUtils.putToMap((Map) hashMap, "begin_pos", eventContext.mBeginPos);
        LoggerUtils.putToMap((Map) hashMap, "end_pos", eventContext.mEndPos);
        long j3 = eventContext.mLastRebufT;
        if (j3 > 0) {
            LoggerUtils.putToMap((Map) hashMap, "last_rebuf_interval", eventContext.startTime - j3);
        }
        long j4 = eventContext.mLastSeekT;
        if (j4 > 0) {
            LoggerUtils.putToMap((Map) hashMap, "last_seek_interval", eventContext.startTime - j4);
        }
        LoggerUtils.putToMap((Map) hashMap, "is_abr", eventContext.mIsABR);
        LoggerUtils.putToMap(hashMap, "quality_desc_before", eventContext.mQualityDescBefore);
        LoggerUtils.putToMap((Map) hashMap, "bad_interlaced", this.mIsAVBadInterlaced);
        LoggerUtils.putToMap((Map) hashMap, "enable_global_mute_feature", eventContext.mEnableGloablMuteFeature);
        LoggerUtils.putToMap((Map) hashMap, "global_mute", eventContext.mGlobalMute);
        LoggerUtils.putToMap(hashMap, "cpu_rate", (float) eventContext.mCpuRate);
        LoggerUtils.putToMap(hashMap, "cpu_speed", (float) eventContext.mCpuSpeed);
        LoggerUtils.putToMap((Map) hashMap, "power_save_mode", eventContext.mPowerSaveMode);
        LoggerUtils.putToMap(hashMap, "battery_current", eventContext.mCurrent);
        LoggerUtils.putToMap((Map) hashMap, "queue_input_buffer_in_start", eventContext.mQueueInputBufferCountInStart);
        LoggerUtils.putToMap((Map) hashMap, "queue_input_buffer_in_end", eventContext.mQueueInputBufferCountInEnd);
        LoggerUtils.putToMap((Map) hashMap, "dequeue_output_buffer_in_start", eventContext.mDequeueOutputBufferCountInStart);
        LoggerUtils.putToMap((Map) hashMap, "dequeue_output_buffer_in_end", eventContext.mDequeueOutputBufferCountInEnd);
        LoggerUtils.putToMap((Map) hashMap, "mc_monitor_queue_in_start", eventContext.mMcMonitorQueueSizeInStart);
        LoggerUtils.putToMap((Map) hashMap, "mc_monitor_queue_in_end", eventContext.mMcMonitorQueueSizeInEnd);
        return new JSONObject(hashMap);
    }

    public void start(int i, int i2, int i3, long j, long j2, long j3) {
        int isPowerSaveMode;
        Object obj;
        EventLoggerSource eventLoggerSource;
        this.isStarted = true;
        long currentTimeMillis = System.currentTimeMillis();
        EventContext eventContext = this.mEventContext;
        eventContext.startTime = currentTimeMillis;
        eventContext.noRenderType = i;
        eventContext.reason = i2;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null && (eventLoggerSource = videoEventBase.mDataSource) != null) {
            Map<String, Long> parsePlayerBufferString = LoggerUtils.parsePlayerBufferString(eventLoggerSource.getLogValueStr(55));
            if (parsePlayerBufferString.get("fvl") != null) {
                this.mEventContext.videoFormatLengthMs = parsePlayerBufferString.get("fvl").longValue();
            }
            if (parsePlayerBufferString.get("fal") != null) {
                this.mEventContext.audioFormatLengthMs = parsePlayerBufferString.get("fal").longValue();
            }
            if (parsePlayerBufferString.get("dvl") != null) {
                this.mEventContext.videoDecoderLengthMs = parsePlayerBufferString.get("dvl").longValue();
            }
            if (parsePlayerBufferString.get("dal") != null) {
                this.mEventContext.audioDecoderLengthMs = parsePlayerBufferString.get("dal").longValue();
            }
            if (parsePlayerBufferString.get("bvl") != null) {
                this.mEventContext.videoBaseLengthMs = parsePlayerBufferString.get("bvl").longValue();
            }
            if (parsePlayerBufferString.get("bal") != null) {
                this.mEventContext.audioBaseLengthMs = parsePlayerBufferString.get("bal").longValue();
            }
            String parseNoRenderError = parseNoRenderError(this.mEventBase.mDataSource.getLogValueStr(110));
            if (!TextUtils.isEmpty(parseNoRenderError)) {
                this.mEventContext.stageError = parseNoRenderError;
                TTVideoEngineLog.d("VideoEventOneNoRender", "stage error: " + this.mEventContext.stageError);
            }
        }
        EventContext eventContext2 = this.mEventContext;
        eventContext2.mBeginPos = i3;
        if (j == 0) {
            eventContext2.mLastRebufT = eventContext2.startTime;
        } else {
            eventContext2.mLastRebufT = j;
        }
        if (j2 == 0) {
            eventContext2.mLastSeekT = eventContext2.startTime;
        } else {
            eventContext2.mLastSeekT = j2;
        }
        if (j3 > 0) {
            eventContext2.mLastHeadsetSwitchInterval = currentTimeMillis - j3;
        }
        VideoEventBase videoEventBase2 = this.mEventBase;
        if (videoEventBase2 != null) {
            eventContext2.mResolutionBefore = videoEventBase2.mCurrentResolution;
            eventContext2.mQualityDescBefore = videoEventBase2.mCurrentQualityDesc;
            Map map = videoEventBase2.abrInfo;
            if (map != null && (obj = map.get("abr_used")) != null) {
                this.mEventContext.mIsABR = ((Integer) obj).intValue();
            }
            EventLoggerSource eventLoggerSource2 = this.mEventBase.mDataSource;
            if (eventLoggerSource2 != null) {
                this.mEventContext.mIsRadioMode = eventLoggerSource2.getLogValueInt(88);
                this.mEventContext.mHeadset = this.mEventBase.mDataSource.getLogValueInt(89);
                this.mEventContext.mBt = this.mEventBase.mDataSource.getLogValueInt(90);
                this.mEventContext.mIsBackground = this.mEventBase.mDataSource.getLogValueInt(94);
                EventContext eventContext3 = this.mEventContext;
                if (eventContext3.noRenderType == 0) {
                    eventContext3.mQueueInputBufferCountInStart = this.mEventBase.mDataSource.getLogValueLong(152);
                    this.mEventContext.mDequeueOutputBufferCountInStart = this.mEventBase.mDataSource.getLogValueLong(153);
                    this.mEventContext.mMcMonitorQueueSizeInStart = this.mEventBase.mDataSource.getLogValueInt(154);
                }
                long logValueLong = this.mEventBase.mDataSource.getLogValueLong(91);
                if (logValueLong > 0) {
                    this.mEventContext.mLastAVSwitchInterval = currentTimeMillis - logValueLong;
                }
                long logValueLong2 = this.mEventBase.mDataSource.getLogValueLong(92);
                if (logValueLong2 > 0) {
                    this.mEventContext.mLastResSwitchInterval = currentTimeMillis - logValueLong2;
                }
                long logValueLong3 = this.mEventBase.mDataSource.getLogValueLong(95);
                if (logValueLong3 > 0) {
                    this.mEventContext.mLastForebackSwitchInterval = currentTimeMillis - logValueLong3;
                }
                long logValueLong4 = this.mEventBase.mDataSource.getLogValueLong(112);
                if (logValueLong4 > 0) {
                    this.mEventContext.mLastSetSurfaceNullInterval = currentTimeMillis - logValueLong4;
                }
                this.mEventContext.mEnableGloablMuteFeature = this.mEventBase.mDataSource.getLogValueInt(121);
                this.mEventContext.mGlobalMute = this.mEventBase.mDataSource.getLogValueInt(122);
            }
            VideoEventBase videoEventBase3 = this.mEventBase;
            if (videoEventBase3.mEnablePowerReport) {
                double cPURate = videoEventBase3.getCPURate();
                double cPUSpeed = this.mEventBase.getCPUSpeed();
                if (cPURate > 0.0d && cPUSpeed > 0.0d) {
                    EventContext eventContext4 = this.mEventContext;
                    eventContext4.mCpuRate = cPURate;
                    eventContext4.mCpuSpeed = cPUSpeed;
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
}

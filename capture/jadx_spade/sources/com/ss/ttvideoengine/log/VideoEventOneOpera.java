package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventOneOpera {
    public VideoEventBase mEventBase;
    private HashMap mLastOperaTimeMap;
    public boolean mReportSeek;
    public long mLastBufferStartT = -2147483648L;
    public long mLastBufferEndT = -2147483648L;
    public int mAccuCostTime = 0;
    public ArrayList<String> mSeekList = new ArrayList<>();
    public OperaContext mOperaContext = new OperaContext();

    static {
        Covode.recordClassIndex(652509);
    }

    public void movieShouldRetry() {
        OperaContext.access$108(this.mOperaContext);
    }

    public void reset() {
        synchronized (this.mLastOperaTimeMap) {
            this.mLastOperaTimeMap = new HashMap();
        }
        this.mAccuCostTime = 0;
        this.mSeekList = new ArrayList<>();
    }

    private static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventOneOpera rEvent;
        private VideoEventBase rEventBase;
        private Handler rHandler = new HandlerDelegate(Looper.getMainLooper());
        private OperaContext rOperaContext;

        static {
            Covode.recordClassIndex(652510);
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            if (this.rEvent == null) {
                return;
            }
            VideoEventBase videoEventBase = this.rEventBase;
            if (videoEventBase != null) {
                videoEventBase.updateMDLInfo();
                this.rEventBase.mNetworkType = VideoEventBase.getNetType();
            }
            VideoEventBase videoEventBase2 = this.rEventBase;
            if (videoEventBase2 != null && videoEventBase2.isUploadLogEnabled) {
                z = true;
            } else {
                z = false;
            }
            final JSONObject jsonObject = this.rEvent.toJsonObject(this.rOperaContext, videoEventBase2);
            Handler handler = this.rHandler;
            if (handler == null) {
                VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneopera");
            } else {
                handler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventOneOpera.AsyncGetLogDataRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_oneopera");
                    }
                });
            }
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventOneOpera videoEventOneOpera, VideoEventBase videoEventBase, OperaContext operaContext) {
            this.rEvent = videoEventOneOpera;
            this.rEventBase = videoEventBase;
            this.rContext = context;
            this.rOperaContext = operaContext;
        }
    }

    public long getLastSeekTime() {
        if (this.mOperaContext.mStartT > 0) {
            return 0L;
        }
        synchronized (this.mLastOperaTimeMap) {
            if (this.mLastOperaTimeMap.containsKey("seek")) {
                return ((Long) this.mLastOperaTimeMap.get("seek")).longValue();
            }
            return -1L;
        }
    }

    public void sendOperaEvent() {
        this.mEventBase.updateVideoInfo(null);
        synchronized (this.mLastOperaTimeMap) {
            if (this.mLastOperaTimeMap.containsKey(this.mOperaContext.mOperaType)) {
                long longValue = ((Long) this.mLastOperaTimeMap.get(this.mOperaContext.mOperaType)).longValue();
                if (longValue > 0) {
                    OperaContext operaContext = this.mOperaContext;
                    operaContext.mLastInterval = operaContext.mStartT - longValue;
                }
            }
            this.mLastOperaTimeMap.remove(this.mOperaContext.mOperaType);
            HashMap hashMap = this.mLastOperaTimeMap;
            OperaContext operaContext2 = this.mOperaContext;
            hashMap.put(operaContext2.mOperaType, Long.valueOf(operaContext2.mEndT));
        }
        this.mLastBufferStartT = -2147483648L;
        this.mLastBufferEndT = -2147483648L;
        if (!this.mReportSeek) {
            return;
        }
        TTVideoEngineLog.i("VideoEventOneOpera", "report async");
        VideoEventBase videoEventBase = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(videoEventBase.mContext, this, videoEventBase, this.mOperaContext));
    }

    private class OperaContext {
        public long mAudioLenAfterMS;
        public long mAudioLenBeforeMS;
        public int mConfigBitrateAfter;
        public int mConfigBitrateBefore;
        public long mCostTime;
        public long mEndT;
        public String mEndType;
        private int mIndex;
        private int mIsSeekInCached;
        public long mLastInterval;
        public int mLoadTypeWhenSeek;
        public String mOperaType;
        public String mResolutionAfter;
        public String mResolutionBefore;
        private int mRetryCount;
        public long mSeekAVFormatSeekTime;
        public long mSeekCompleteTime;
        public long mSeekCoreCompleteTime;
        public long mSeekDecoderFirstAudioFrameTime;
        public long mSeekDecoderFirstAudioPacketTime;
        public long mSeekExeBeginTime;
        public long mSeekLoadingBeginTime;
        public long mSeekLoadingEndTime;
        public long mSeekLooperTime;
        public long mSeekOperateTime;
        public long mSeekReceiveFirstPacketTime;
        public long mSeekRenderFirstFrameTime;
        private long mStartT;
        public String mStateAfter;
        public String mStateBefore;
        public long mVideoLenAfterMS;
        public long mVideoLenBeforeMS;

        static {
            Covode.recordClassIndex(652511);
        }

        static /* synthetic */ int access$108(OperaContext operaContext) {
            int i = operaContext.mRetryCount;
            operaContext.mRetryCount = i + 1;
            return i;
        }

        private OperaContext() {
            this.mOperaType = "";
            this.mStateBefore = "";
            this.mStateAfter = "";
            this.mCostTime = -2147483648L;
            this.mEndType = "";
            this.mStartT = -2147483648L;
            this.mEndT = -2147483648L;
            this.mRetryCount = 0;
            this.mIsSeekInCached = 0;
            this.mVideoLenAfterMS = 0L;
            this.mAudioLenAfterMS = 0L;
            this.mVideoLenBeforeMS = -2147483648L;
            this.mAudioLenBeforeMS = -2147483648L;
            this.mIndex = 0;
            this.mResolutionBefore = "";
            this.mResolutionAfter = "";
            this.mConfigBitrateBefore = Integer.MIN_VALUE;
            this.mConfigBitrateAfter = Integer.MIN_VALUE;
            this.mLastInterval = -1L;
            this.mLoadTypeWhenSeek = Integer.MIN_VALUE;
            this.mSeekCompleteTime = -2147483648L;
            this.mSeekLoadingBeginTime = -2147483648L;
            this.mSeekLoadingEndTime = -2147483648L;
            this.mSeekLooperTime = -2147483648L;
            this.mSeekOperateTime = -2147483648L;
            this.mSeekExeBeginTime = -2147483648L;
            this.mSeekAVFormatSeekTime = -2147483648L;
            this.mSeekCoreCompleteTime = -2147483648L;
            this.mSeekReceiveFirstPacketTime = -2147483648L;
            this.mSeekDecoderFirstAudioPacketTime = -2147483648L;
            this.mSeekDecoderFirstAudioFrameTime = -2147483648L;
            this.mSeekRenderFirstFrameTime = -2147483648L;
        }
    }

    public void setLoadTypeWhenSeek(int i) {
        OperaContext operaContext = this.mOperaContext;
        if (operaContext != null) {
            operaContext.mLoadTypeWhenSeek = i;
        }
    }

    public void setSeekCompleteTime(long j) {
        OperaContext operaContext = this.mOperaContext;
        if (operaContext != null) {
            operaContext.mSeekCompleteTime = j;
        }
    }

    public void setSeekLoadingBeginTime(long j) {
        OperaContext operaContext = this.mOperaContext;
        if (operaContext != null) {
            operaContext.mSeekLoadingBeginTime = j;
        }
    }

    public void setSeekLoadingEndTime(long j) {
        OperaContext operaContext = this.mOperaContext;
        if (operaContext != null) {
            operaContext.mSeekLoadingEndTime = j;
        }
    }

    VideoEventOneOpera(VideoEventBase videoEventBase) {
        this.mLastOperaTimeMap = null;
        this.mEventBase = videoEventBase;
        this.mLastOperaTimeMap = new HashMap();
    }

    public void endSeek(String str, int i) {
        EventLoggerSource eventLoggerSource;
        if (this.mOperaContext.mStartT > 0 && !this.mOperaContext.mOperaType.isEmpty()) {
            TTVideoEngineLog.d("VideoEventOneOpera", "endSeek, from " + this.mOperaContext.mStateBefore + " to " + this.mOperaContext.mStateAfter);
            long currentTimeMillis = System.currentTimeMillis();
            OperaContext operaContext = this.mOperaContext;
            operaContext.mEndT = currentTimeMillis;
            operaContext.mCostTime = currentTimeMillis - operaContext.mStartT;
            OperaContext operaContext2 = this.mOperaContext;
            long j = operaContext2.mCostTime;
            if (j > 0) {
                this.mAccuCostTime = (int) (this.mAccuCostTime + j);
            }
            operaContext2.mEndType = str;
            operaContext2.mIsSeekInCached = i;
            VideoEventBase videoEventBase = this.mEventBase;
            if (videoEventBase != null && (eventLoggerSource = videoEventBase.mDataSource) != null) {
                Map<String, Long> parsePlayerStringToMap = LoggerUtils.parsePlayerStringToMap(eventLoggerSource.getLogValueStr(151), ";|=");
                if (parsePlayerStringToMap.get("s_looper_t") != null) {
                    this.mOperaContext.mSeekLooperTime = parsePlayerStringToMap.get("s_looper_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_operate_t") != null) {
                    this.mOperaContext.mSeekOperateTime = parsePlayerStringToMap.get("s_operate_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_exe_begin_t") != null) {
                    this.mOperaContext.mSeekExeBeginTime = parsePlayerStringToMap.get("s_exe_begin_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_avformat_seek_t") != null) {
                    this.mOperaContext.mSeekAVFormatSeekTime = parsePlayerStringToMap.get("s_avformat_seek_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_c_complete_t") != null) {
                    this.mOperaContext.mSeekCoreCompleteTime = parsePlayerStringToMap.get("s_c_complete_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_re_f_packet_t") != null) {
                    this.mOperaContext.mSeekReceiveFirstPacketTime = parsePlayerStringToMap.get("s_re_f_packet_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_de_f_audiopacket_t") != null) {
                    this.mOperaContext.mSeekDecoderFirstAudioPacketTime = parsePlayerStringToMap.get("s_de_f_audiopacket_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_de_f_audioframe_t") != null) {
                    this.mOperaContext.mSeekDecoderFirstAudioFrameTime = parsePlayerStringToMap.get("s_de_f_audioframe_t").longValue();
                }
                if (parsePlayerStringToMap.get("s_render_f_t") != null) {
                    this.mOperaContext.mSeekRenderFirstFrameTime = parsePlayerStringToMap.get("s_render_f_t").longValue();
                }
                OperaContext operaContext3 = this.mOperaContext;
                VideoEventBase videoEventBase2 = this.mEventBase;
                operaContext3.mResolutionAfter = videoEventBase2.mCurrentResolution;
                operaContext3.mConfigBitrateAfter = videoEventBase2.mCurrentConfigBitrate;
                Map<String, Long> bytesInfo = videoEventBase2.mDataSource.bytesInfo();
                if (bytesInfo != null) {
                    this.mOperaContext.mVideoLenAfterMS = ((Long) TTHelper.nonNullElse(bytesInfo.get("vlen"), Long.valueOf(this.mOperaContext.mVideoLenAfterMS))).longValue();
                    this.mOperaContext.mAudioLenAfterMS = ((Long) TTHelper.nonNullElse(bytesInfo.get("alen"), Long.valueOf(this.mOperaContext.mAudioLenAfterMS))).longValue();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("fr", this.mOperaContext.mStateBefore);
            hashMap.put("to", this.mOperaContext.mStateAfter);
            hashMap.put("t", Long.valueOf(this.mOperaContext.mEndT));
            hashMap.put("c", Long.valueOf(this.mOperaContext.mCostTime));
            this.mSeekList.add(new JSONObject(hashMap).toString());
            sendOperaEvent();
            this.mOperaContext = new OperaContext();
            return;
        }
        TTVideoEngineLog.d("VideoEventOneOpera", "endSeek without beginSeek, return.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject toJsonObject(OperaContext operaContext, VideoEventBase videoEventBase) {
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
            LoggerUtils.putToMap((Map) hashMap, "mdl_speed", videoEventBase.mdlVideoInfo.mdl_speed);
            LoggerUtils.putToMap(hashMap, "net_type", videoEventBase.mNetworkType);
            LoggerUtils.putToMap((Map) hashMap, "reuse_socket", videoEventBase.mReuseSocket);
            LoggerUtils.putToMap(hashMap, "mdl_version", videoEventBase.mMdlVersion);
            LoggerUtils.putToMap((Map) hashMap, "enable_mdl", videoEventBase.mEnableMDL);
            LoggerUtils.putToMap((Map) hashMap, "mdl_req_t", videoEventBase.mdlVideoInfo.mdl_req_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_end_t", videoEventBase.mdlVideoInfo.mdl_end_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_dns_t", videoEventBase.mdlVideoInfo.mdl_dns_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_tcp_start_t", videoEventBase.mdlVideoInfo.mdl_tcp_start_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_tcp_end_t", videoEventBase.mdlVideoInfo.mdl_tcp_end_t);
            LoggerUtils.putToMap((Map) hashMap, "mdl_ttfp", videoEventBase.mdlVideoInfo.mdl_ttfp);
            LoggerUtils.putToMap((Map) hashMap, "mdl_httpfb", videoEventBase.mdlVideoInfo.mdl_httpfb);
            LoggerUtils.putToMap(hashMap, "mdl_cur_ip", videoEventBase.mdlVideoInfo.mdl_cur_ip);
            LoggerUtils.putToMap((Map) hashMap, "mdl_cache_type", videoEventBase.mdlVideoInfo.mdl_cache_type);
            LoggerUtils.putToMap((Map) hashMap, "mdl_reply_size", videoEventBase.mdlVideoInfo.mdl_reply_size);
            LoggerUtils.putToMap((Map) hashMap, "mdl_error_code", videoEventBase.mdlVideoInfo.mdl_error_code);
            LoggerUtils.putToMap((Map) hashMap, "mdl_http_code", videoEventBase.mdlVideoInfo.mdl_http_code);
            LoggerUtils.putToMap(hashMap, "mdl_ip_list", videoEventBase.mdlVideoInfo.mdl_ip_list);
            LoggerUtils.putToMap(hashMap, "mdl_blocked_ips", videoEventBase.mdlVideoInfo.mdl_blocked_ips);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_req_t", videoEventBase.mdlAudioInfo.mdl_req_t);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_end_t", videoEventBase.mdlAudioInfo.mdl_end_t);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_dns_t", videoEventBase.mdlAudioInfo.mdl_dns_t);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_tcp_start_t", videoEventBase.mdlAudioInfo.mdl_tcp_start_t);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_tcp_end_t", videoEventBase.mdlAudioInfo.mdl_tcp_end_t);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_ttfp", videoEventBase.mdlAudioInfo.mdl_ttfp);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_httpfb", videoEventBase.mdlAudioInfo.mdl_httpfb);
            LoggerUtils.putToMap(hashMap, "a_mdl_cur_ip", videoEventBase.mdlAudioInfo.mdl_cur_ip);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_cache_type", videoEventBase.mdlAudioInfo.mdl_cache_type);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_reply_size", videoEventBase.mdlAudioInfo.mdl_reply_size);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_error_code", videoEventBase.mdlAudioInfo.mdl_error_code);
            LoggerUtils.putToMap((Map) hashMap, "a_mdl_http_code", videoEventBase.mdlAudioInfo.mdl_http_code);
            LoggerUtils.putToMap(hashMap, "a_mdl_ip_list", videoEventBase.mdlAudioInfo.mdl_ip_list);
            if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                LoggerUtils.putToMap(hashMap, "a_mdl_blocked_ips", videoEventBase.mdlAudioInfo.mdl_blocked_ips);
                LoggerUtils.putToMap((Map) hashMap, "mdl_cur_req_pos", videoEventBase.mdlVideoInfo.mdl_cur_req_pos);
                LoggerUtils.putToMap((Map) hashMap, "mdl_cur_end_pos", videoEventBase.mdlVideoInfo.mdl_cur_end_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_cur_req_pos", videoEventBase.mdlAudioInfo.mdl_cur_req_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_cur_end_pos", videoEventBase.mdlAudioInfo.mdl_cur_end_pos);
                LoggerUtils.putToMap((Map) hashMap, "mdl_cur_cache_pos", videoEventBase.mdlVideoInfo.mdl_cur_cache_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_cur_cache_pos", videoEventBase.mdlAudioInfo.mdl_cur_cache_pos);
                LoggerUtils.putToMap((Map) hashMap, "mdl_down_pos", videoEventBase.mdlVideoInfo.mdl_down_pos);
                LoggerUtils.putToMap((Map) hashMap, "a_mdl_down_pos", videoEventBase.mdlAudioInfo.mdl_down_pos);
            }
        }
        LoggerUtils.putToMap(hashMap, "opera_type", operaContext.mOperaType);
        LoggerUtils.putToMap(hashMap, "state_before", operaContext.mStateBefore);
        LoggerUtils.putToMap(hashMap, "state_after", operaContext.mStateAfter);
        LoggerUtils.putToMap((Map) hashMap, "cost_time", operaContext.mCostTime);
        LoggerUtils.putToMap(hashMap, "end_type", operaContext.mEndType);
        LoggerUtils.putToMap((Map) hashMap, "index", operaContext.mIndex);
        LoggerUtils.putToMap((Map) hashMap, "last_interval", operaContext.mLastInterval);
        LoggerUtils.putToMap((Map) hashMap, "retry_count", operaContext.mRetryCount);
        LoggerUtils.putToMap((Map) hashMap, "is_seek_in_buffer", operaContext.mIsSeekInCached);
        LoggerUtils.putToMap((Map) hashMap, "video_len_after", operaContext.mVideoLenAfterMS);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_after", operaContext.mAudioLenAfterMS);
        LoggerUtils.putToMap((Map) hashMap, "video_len_before", operaContext.mVideoLenBeforeMS);
        LoggerUtils.putToMap((Map) hashMap, "audio_len_before", operaContext.mAudioLenBeforeMS);
        LoggerUtils.putToMap((Map) hashMap, "loadtype_when_seek", operaContext.mLoadTypeWhenSeek);
        LoggerUtils.putToMap((Map) hashMap, "st", operaContext.mStartT);
        LoggerUtils.putToMap((Map) hashMap, "et", operaContext.mEndT);
        LoggerUtils.putToMap(hashMap, "resolution_before", operaContext.mResolutionBefore);
        LoggerUtils.putToMap(hashMap, "resolution_after", operaContext.mResolutionAfter);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_before", operaContext.mConfigBitrateBefore);
        LoggerUtils.putToMap((Map) hashMap, "bitrate_after", operaContext.mConfigBitrateAfter);
        LoggerUtils.putToMap((Map) hashMap, "s_looper_t", operaContext.mSeekLooperTime);
        LoggerUtils.putToMap((Map) hashMap, "s_operate_t", operaContext.mSeekOperateTime);
        LoggerUtils.putToMap((Map) hashMap, "s_exe_begin_t", operaContext.mSeekExeBeginTime);
        LoggerUtils.putToMap((Map) hashMap, "s_avformat_seek_t", operaContext.mSeekAVFormatSeekTime);
        LoggerUtils.putToMap((Map) hashMap, "s_c_complete_t", operaContext.mSeekCoreCompleteTime);
        LoggerUtils.putToMap((Map) hashMap, "s_complete_t", operaContext.mSeekCompleteTime);
        LoggerUtils.putToMap((Map) hashMap, "s_re_f_packet_t", operaContext.mSeekReceiveFirstPacketTime);
        LoggerUtils.putToMap((Map) hashMap, "s_de_f_audiopacket_t", operaContext.mSeekDecoderFirstAudioPacketTime);
        LoggerUtils.putToMap((Map) hashMap, "s_de_f_audioframe_t", operaContext.mSeekDecoderFirstAudioFrameTime);
        LoggerUtils.putToMap((Map) hashMap, "s_loading_begin_t", operaContext.mSeekLoadingBeginTime);
        LoggerUtils.putToMap((Map) hashMap, "s_loading_end_t", operaContext.mSeekLoadingEndTime);
        LoggerUtils.putToMap((Map) hashMap, "s_render_f_t", operaContext.mSeekRenderFirstFrameTime);
        LoggerUtils.putToMap((Map) hashMap, "last_buf_start_t", this.mLastBufferStartT);
        LoggerUtils.putToMap((Map) hashMap, "last_buf_end_t", this.mLastBufferEndT);
        return new JSONObject(hashMap);
    }

    public void beginSeek(int i, int i2, int i3) {
        TTVideoEngineLog.d("VideoEventOneOpera", "brian beginSeek from " + i + " to " + i2);
        this.mOperaContext.mStartT = System.currentTimeMillis();
        OperaContext operaContext = this.mOperaContext;
        operaContext.mOperaType = "seek";
        operaContext.mStateBefore = Integer.toString(i);
        this.mOperaContext.mStateAfter = Integer.toString(i2);
        OperaContext operaContext2 = this.mOperaContext;
        operaContext2.mCostTime = 0L;
        operaContext2.mIndex = i3;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            OperaContext operaContext3 = this.mOperaContext;
            operaContext3.mResolutionBefore = videoEventBase.mCurrentResolution;
            operaContext3.mConfigBitrateBefore = videoEventBase.mCurrentConfigBitrate;
            EventLoggerSource eventLoggerSource = videoEventBase.mDataSource;
            if (eventLoggerSource != null) {
                operaContext3.mVideoLenBeforeMS = eventLoggerSource.getLogValueLong(105);
                this.mOperaContext.mAudioLenBeforeMS = this.mEventBase.mDataSource.getLogValueLong(104);
            }
        }
    }
}

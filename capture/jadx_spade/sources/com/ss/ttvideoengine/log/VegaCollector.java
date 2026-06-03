package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VegaCollector {
    private Map<String, Object> mParamMap = new HashMap();

    static {
        Covode.recordClassIndex(652485);
    }

    public Map<String, Object> get() {
        return this.mParamMap;
    }

    public void reset() {
        if (!this.mParamMap.isEmpty()) {
            this.mParamMap = new HashMap();
        }
    }

    public void retrieveEventParam(VideoEventBase videoEventBase, VideoEventOnePlay videoEventOnePlay) {
        HashMap hashMap = new HashMap();
        LoggerUtils.putToMap((Map) hashMap, "setds_t", videoEventOnePlay.setds_t);
        LoggerUtils.putToMap((Map) hashMap, "surface_set_time", videoEventOnePlay.surfaceSetTime);
        LoggerUtils.putToMap((Map) hashMap, "ps_t", videoEventOnePlay.ps_t);
        LoggerUtils.putToMap((Map) hashMap, "pt", videoEventOnePlay.pt);
        LoggerUtils.putToMap((Map) hashMap, "at", videoEventOnePlay.at);
        LoggerUtils.putToMap((Map) hashMap, "prepare_start_time", videoEventOnePlay.prepare_start_time);
        LoggerUtils.putToMap((Map) hashMap, "formater_create_t", videoEventOnePlay.formater_create_t);
        LoggerUtils.putToMap((Map) hashMap, "demuxer_begin_t", videoEventOnePlay.demuxer_begin_t);
        LoggerUtils.putToMap((Map) hashMap, "tran_ct", videoEventOnePlay.tranConnectT);
        LoggerUtils.putToMap((Map) hashMap, "a_tran_ct", videoEventOnePlay.audioTranConnectT);
        LoggerUtils.putToMap((Map) hashMap, "tran_ft", videoEventOnePlay.tranFirstPacketT);
        LoggerUtils.putToMap((Map) hashMap, "a_tran_ft", videoEventOnePlay.audioTranFirstPacketT);
        LoggerUtils.putToMap((Map) hashMap, "avformat_open_t", videoEventOnePlay.avformat_open_t);
        LoggerUtils.putToMap((Map) hashMap, "demuxer_create_t", videoEventOnePlay.demuxer_create_t);
        LoggerUtils.putToMap((Map) hashMap, "dec_create_t", videoEventOnePlay.dec_create_t);
        LoggerUtils.putToMap((Map) hashMap, "outlet_create_t", videoEventOnePlay.outlet_create_t);
        LoggerUtils.putToMap((Map) hashMap, "prepare_end_time", videoEventOnePlay.prepare_end_time);
        LoggerUtils.putToMap((Map) hashMap, "dns_start_t", videoEventOnePlay.dns_start_t);
        LoggerUtils.putToMap((Map) hashMap, "a_dns_start_t", videoEventOnePlay.a_dns_start_t);
        LoggerUtils.putToMap((Map) hashMap, "dns_end_t", videoEventOnePlay.dns_end_t);
        LoggerUtils.putToMap((Map) hashMap, "a_dns_t", videoEventOnePlay.audioDnsT);
        LoggerUtils.putToMap((Map) hashMap, "v_dec_start_t", videoEventOnePlay.v_dec_start_t);
        LoggerUtils.putToMap((Map) hashMap, "a_dec_start_t", videoEventOnePlay.a_dec_start_t);
        LoggerUtils.putToMap((Map) hashMap, "v_dec_opened_t", videoEventOnePlay.v_dec_opened_t);
        LoggerUtils.putToMap((Map) hashMap, "a_dec_opened_t", videoEventOnePlay.a_dec_opened_t);
        LoggerUtils.putToMap((Map) hashMap, "video_device_start_t", videoEventOnePlay.videoDeviceStartTime);
        LoggerUtils.putToMap((Map) hashMap, "video_device_opened_t", videoEventOnePlay.videoDeviceOpenedTime);
        LoggerUtils.putToMap((Map) hashMap, "audio_device_start_t", videoEventOnePlay.audioDeviceStartTime);
        LoggerUtils.putToMap((Map) hashMap, "audio_device_opened_t", videoEventOnePlay.audioDeviceOpenedTime);
        LoggerUtils.putToMap((Map) hashMap, "re_f_videoframet", videoEventOnePlay.receiveFirstVideoFrameT);
        LoggerUtils.putToMap((Map) hashMap, "re_f_audioframet", videoEventOnePlay.receiveFirstAudioFrameT);
        LoggerUtils.putToMap((Map) hashMap, "de_f_videoframet", videoEventOnePlay.decodeFirstVideoFrameT);
        LoggerUtils.putToMap((Map) hashMap, "de_f_audioframet", videoEventOnePlay.decodeFirstAudioFrameT);
        LoggerUtils.putToMap((Map) hashMap, "v_render_f_t", videoEventOnePlay.v_render_f_t);
        LoggerUtils.putToMap((Map) hashMap, "a_render_f_t", videoEventOnePlay.a_render_f_t);
        this.mParamMap.put("req_phase", Integer.valueOf(videoEventOnePlay.leave_reason));
        this.mParamMap.put("req_phase_cost", hashMap);
        this.mParamMap.put("hw", Integer.valueOf(videoEventBase.mVideoHW));
        this.mParamMap.put("hw_user", Integer.valueOf(videoEventBase.mVideoHWUser));
    }
}

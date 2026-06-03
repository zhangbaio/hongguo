package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventSampleRecord {
    public VideoEventBase mEventBase;
    private EventContext mEventContext;
    public int mMaxWindowSize = 200;
    public float mSampingRate = 0.0f;
    public boolean mIsStarted = false;
    public int mSampleInterval = Integer.MIN_VALUE;
    private long mLastVideoDownBytes = 0;
    private long mLastAudioDownBytes = 0;
    private long mLastVideoTotalCachedLen = 0;
    private long mLastAudioTotalCachedLen = 0;
    private final ReentrantLock mLock = new ReentrantLock();

    static {
        Covode.recordClassIndex(652517);
    }

    public void startRecord() {
        if (Math.random() > this.mSampingRate) {
            this.mIsStarted = false;
        } else {
            this.mIsStarted = true;
        }
    }

    public void stopRecord() {
        this.mLock.lock();
        try {
            if (this.mIsStarted) {
                this.mIsStarted = false;
                _sendEvent(1);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    private static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventSampleRecord rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler = new HandlerDelegate(Looper.getMainLooper());

        static {
            Covode.recordClassIndex(652518);
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoEventSampleRecord videoEventSampleRecord = this.rEvent;
            if (videoEventSampleRecord == null) {
                return;
            }
            final JSONObject jsonObject = videoEventSampleRecord.toJsonObject(this.rEventContext);
            Handler handler = this.rHandler;
            if (handler != null && handler.getLooper() != null) {
                this.rHandler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventSampleRecord.AsyncGetLogDataRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEventManager.instance.addEventV2(true, jsonObject, "videoplayer_sample");
                    }
                });
            } else {
                VideoEventManager.instance.addEventV2(true, jsonObject, "videoplayer_sample");
            }
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventSampleRecord videoEventSampleRecord, VideoEventBase videoEventBase, EventContext eventContext) {
            this.rEvent = videoEventSampleRecord;
            this.rEventBase = videoEventBase;
            this.rContext = context;
            this.rEventContext = eventContext;
        }
    }

    private boolean checkCurrentPlayBackVideoIsLegal() {
        Map videoInfo = this.mEventBase.getVideoInfo();
        if (videoInfo == null) {
            return false;
        }
        Map map = (Map) videoInfo.get("fileKey");
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (String str : map.values()) {
                if (str.equals("") || str.equals("0")) {
                    return false;
                }
                arrayList.add(str);
            }
        }
        int i = 0;
        while (i < arrayList.size()) {
            String str2 = (String) arrayList.get(i);
            i++;
            for (int i2 = i; i2 < arrayList.size(); i2++) {
                if (str2.equals(arrayList.get(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void _updateEventBaseInfo() {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            EventLoggerSource eventLoggerSource = videoEventBase.mDataSource;
            if (eventLoggerSource != null) {
                this.mEventContext.play_pos_set.add(Integer.valueOf(eventLoggerSource.getLogValueInt(67)));
                this.mEventContext.buffer_len_set.add(Long.valueOf(this.mEventBase.mDataSource.getLogValueLong(68)));
                Map videoInfo = this.mEventBase.getVideoInfo();
                if (videoInfo != null) {
                    Map map = (Map) videoInfo.get("bitrate");
                    if (map != null) {
                        Integer num = (Integer) map.get(this.mEventBase.mCurrentResolution);
                        if (num == null) {
                            this.mEventContext.video_play_bitrate_set.add(-1);
                        } else if (num.intValue() == 0) {
                            this.mEventContext.video_play_bitrate_set.add(-1);
                        } else {
                            this.mEventContext.video_play_bitrate_set.add(_doBitrateMap(num));
                        }
                    }
                    ArrayList arrayList = (ArrayList) videoInfo.get("audio_bitrate");
                    if (arrayList != null && !arrayList.isEmpty()) {
                        if (arrayList.get(0) == null) {
                            this.mEventContext.audio_play_bitrate_set.add(-1);
                        } else if (((Integer) arrayList.get(0)).intValue() == 0) {
                            this.mEventContext.audio_play_bitrate_set.add(-1);
                        } else {
                            this.mEventContext.audio_play_bitrate_set.add(_doBitrateMap((Integer) arrayList.get(0)));
                        }
                    }
                }
            }
            this.mEventContext.play_speed_set.add(Float.valueOf(this.mEventBase.mPlaySpeed));
        }
    }

    private void _popHead() {
        EventContext eventContext = this.mEventContext;
        int i = eventContext.video_sample_count;
        int i2 = this.mMaxWindowSize;
        if (i > i2 || eventContext.audio_sample_count > i2) {
            if (!eventContext.play_pos_set.isEmpty()) {
                this.mEventContext.play_pos_set.remove(0);
            }
            if (!this.mEventContext.buffer_len_set.isEmpty()) {
                this.mEventContext.buffer_len_set.remove(0);
            }
            if (!this.mEventContext.play_speed_set.isEmpty()) {
                this.mEventContext.play_speed_set.remove(0);
            }
            if (!this.mEventContext.video_sample_interval.isEmpty()) {
                this.mEventContext.video_sample_interval.remove(0);
            }
            if (!this.mEventContext.video_speed_set.isEmpty()) {
                this.mEventContext.video_speed_set.remove(0);
            }
            if (!this.mEventContext.video_speed_load_type_set.isEmpty()) {
                this.mEventContext.video_speed_load_type_set.remove(0);
            }
            if (!this.mEventContext.video_predict_speed_set.isEmpty()) {
                this.mEventContext.video_predict_speed_set.remove(0);
            }
            if (!this.mEventContext.video_predict_speed_load_type_set.isEmpty()) {
                this.mEventContext.video_predict_speed_load_type_set.remove(0);
            }
            if (!this.mEventContext.video_download_bitrate_set.isEmpty()) {
                this.mEventContext.video_download_bitrate_set.remove(0);
            }
            if (!this.mEventContext.video_play_bitrate_set.isEmpty()) {
                this.mEventContext.video_play_bitrate_set.remove(0);
            }
            if (!this.mEventContext.video_download_size_set.isEmpty()) {
                this.mEventContext.video_download_size_set.remove(0);
            }
            if (!this.mEventContext.video_downLoad_cost_time_set.isEmpty()) {
                this.mEventContext.video_downLoad_cost_time_set.remove(0);
            }
            if (!this.mEventContext.video_tcpinfo_rtt_set.isEmpty()) {
                this.mEventContext.video_tcpinfo_rtt_set.remove(0);
            }
            if (!this.mEventContext.video_tcpinfo_lastRevDate.isEmpty()) {
                this.mEventContext.video_tcpinfo_lastRevDate.remove(0);
            }
            if (!this.mEventContext.video_protocol_set.isEmpty()) {
                this.mEventContext.video_protocol_set.remove(0);
            }
            r0.video_sample_count--;
            if (!this.mEventContext.audio_sample_interval.isEmpty()) {
                this.mEventContext.audio_sample_interval.remove(0);
            }
            if (!this.mEventContext.audio_speed_set.isEmpty()) {
                this.mEventContext.audio_speed_set.remove(0);
            }
            if (!this.mEventContext.audio_speed_load_type_set.isEmpty()) {
                this.mEventContext.audio_speed_load_type_set.remove(0);
            }
            if (!this.mEventContext.audio_predict_speed_set.isEmpty()) {
                this.mEventContext.audio_predict_speed_set.remove(0);
            }
            if (!this.mEventContext.audio_predict_speed_load_type_set.isEmpty()) {
                this.mEventContext.audio_predict_speed_load_type_set.remove(0);
            }
            if (!this.mEventContext.audio_play_bitrate_set.isEmpty()) {
                this.mEventContext.audio_play_bitrate_set.remove(0);
            }
            if (!this.mEventContext.audio_download_bitrate_set.isEmpty()) {
                this.mEventContext.audio_download_bitrate_set.remove(0);
            }
            if (!this.mEventContext.audio_download_size_set.isEmpty()) {
                this.mEventContext.audio_download_size_set.remove(0);
            }
            if (!this.mEventContext.audio_downLoad_cost_time_set.isEmpty()) {
                this.mEventContext.audio_downLoad_cost_time_set.remove(0);
            }
            if (!this.mEventContext.audio_tcpinfo_rtt_set.isEmpty()) {
                this.mEventContext.audio_tcpinfo_rtt_set.remove(0);
            }
            if (!this.mEventContext.audio_tcpinfo_lastRevDate.isEmpty()) {
                this.mEventContext.audio_tcpinfo_lastRevDate.remove(0);
            }
            if (!this.mEventContext.audio_protocol_set.isEmpty()) {
                this.mEventContext.audio_protocol_set.remove(0);
            }
            EventContext eventContext2 = this.mEventContext;
            eventContext2.audio_sample_count--;
        }
    }

    public void setSamplingRate(float f) {
        this.mSampingRate = f;
    }

    public void setInterval(int i) {
        if (i > 0) {
            this.mSampleInterval = i;
        }
    }

    public void setMaxWindowSize(int i) {
        if (i > 0) {
            this.mMaxWindowSize = i;
        }
    }

    VideoEventSampleRecord(VideoEventBase videoEventBase) {
        this.mEventContext = null;
        this.mEventBase = null;
        this.mEventContext = new EventContext();
        this.mEventBase = videoEventBase;
    }

    private Integer _doBitrateMap(Integer num) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase == null) {
            return num;
        }
        Map videoInfo = videoEventBase.getVideoInfo();
        if (videoInfo == null) {
            return num;
        }
        Map map = (Map) videoInfo.get("bitrateMapTable");
        if (map != null) {
            if (((Integer) map.get(num)) == null) {
                return -1;
            }
            return (Integer) map.get(num);
        }
        return num;
    }

    private class EventContext {
        public ArrayList<Integer> audio_biterate_set;
        public ArrayList<Long> audio_downLoad_cost_time_set;
        public ArrayList<Integer> audio_download_bitrate_set;
        public ArrayList<Float> audio_download_size_set;
        public ArrayList<Integer> audio_play_bitrate_set;
        public ArrayList<String> audio_predict_speed_load_type_set;
        public ArrayList<Float> audio_predict_speed_set;
        public ArrayList<String> audio_protocol_set;
        public int audio_sample_count;
        public ArrayList<Integer> audio_sample_interval;
        public ArrayList<String> audio_speed_load_type_set;
        public ArrayList<Float> audio_speed_set;
        public ArrayList<Long> audio_tcpinfo_lastRevDate;
        public ArrayList<Long> audio_tcpinfo_rtt_set;
        public JSONObject bitrate_compress_table;
        public ArrayList<Long> buffer_len_set;
        public int index;
        public int is_abr;
        public int is_multi_dimensions;
        public int is_multi_dimensions_input;
        public int is_select;
        public long local_time_ms;
        public ArrayList<Integer> play_pos_set;
        public ArrayList<Float> play_speed_set;
        public String player_sessionid;
        public int sample_interval;
        public String url;
        public ArrayList<Integer> video_biterate_set;
        public ArrayList<Long> video_downLoad_cost_time_set;
        public ArrayList<Integer> video_download_bitrate_set;
        public ArrayList<Float> video_download_size_set;
        public String video_id;
        public ArrayList<Integer> video_play_bitrate_set;
        public ArrayList<String> video_predict_speed_load_type_set;
        public ArrayList<Float> video_predict_speed_set;
        public ArrayList<String> video_protocol_set;
        public int video_sample_count;
        public ArrayList<Integer> video_sample_interval;
        public ArrayList<String> video_speed_load_type_set;
        public ArrayList<Float> video_speed_set;
        public ArrayList<Long> video_tcpinfo_lastRevDate;
        public ArrayList<Long> video_tcpinfo_rtt_set;
        public String vtype;

        static {
            Covode.recordClassIndex(652519);
        }

        private EventContext() {
            this.local_time_ms = -2147483648L;
            this.is_abr = -1;
            this.is_select = -1;
            this.sample_interval = Integer.MIN_VALUE;
            this.video_sample_count = 0;
            this.video_sample_interval = new ArrayList<>();
            this.video_speed_set = new ArrayList<>();
            this.video_speed_load_type_set = new ArrayList<>();
            this.video_predict_speed_set = new ArrayList<>();
            this.video_predict_speed_load_type_set = new ArrayList<>();
            this.video_play_bitrate_set = new ArrayList<>();
            this.video_download_bitrate_set = new ArrayList<>();
            this.video_download_size_set = new ArrayList<>();
            this.video_downLoad_cost_time_set = new ArrayList<>();
            this.video_tcpinfo_rtt_set = new ArrayList<>();
            this.video_tcpinfo_lastRevDate = new ArrayList<>();
            this.video_protocol_set = new ArrayList<>();
            this.audio_sample_count = 0;
            this.audio_sample_interval = new ArrayList<>();
            this.audio_speed_set = new ArrayList<>();
            this.audio_speed_load_type_set = new ArrayList<>();
            this.audio_predict_speed_set = new ArrayList<>();
            this.audio_predict_speed_load_type_set = new ArrayList<>();
            this.audio_play_bitrate_set = new ArrayList<>();
            this.audio_download_bitrate_set = new ArrayList<>();
            this.audio_download_size_set = new ArrayList<>();
            this.audio_downLoad_cost_time_set = new ArrayList<>();
            this.audio_tcpinfo_rtt_set = new ArrayList<>();
            this.audio_tcpinfo_lastRevDate = new ArrayList<>();
            this.audio_protocol_set = new ArrayList<>();
            this.buffer_len_set = new ArrayList<>();
            this.play_speed_set = new ArrayList<>();
            this.play_pos_set = new ArrayList<>();
            this.index = 0;
            this.player_sessionid = "";
            this.video_id = "";
            this.url = "";
            this.video_biterate_set = new ArrayList<>();
            this.audio_biterate_set = new ArrayList<>();
            this.vtype = "";
            this.is_multi_dimensions = -1;
            this.is_multi_dimensions_input = -1;
        }
    }

    private void _sendEvent(int i) {
        EventContext eventContext = this.mEventContext;
        if (eventContext.video_sample_count == 0 && eventContext.audio_sample_count == 0 && !checkCurrentPlayBackVideoIsLegal()) {
            return;
        }
        this.mEventContext.local_time_ms = System.currentTimeMillis();
        EventContext eventContext2 = this.mEventContext;
        eventContext2.sample_interval = this.mSampleInterval;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            eventContext2.is_abr = videoEventBase.is_enable_abr;
            eventContext2.is_select = videoEventBase.is_enable_select_bitrate;
            eventContext2.is_multi_dimensions = videoEventBase.is_multi_dimensions;
            eventContext2.is_multi_dimensions_input = videoEventBase.is_multi_dimensionsInput;
            eventContext2.player_sessionid = videoEventBase.mSessionID;
            eventContext2.video_id = videoEventBase.mVid;
            eventContext2.url = videoEventBase.mCurURL;
            eventContext2.vtype = videoEventBase.vtype;
            Map videoInfo = videoEventBase.getVideoInfo();
            if (videoInfo != null && videoInfo.get("bitrateMapTable") != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : ((Map) videoInfo.get("bitrateMapTable")).entrySet()) {
                        jSONObject.put(((Integer) entry.getKey()).toString(), entry.getValue());
                    }
                    this.mEventContext.bitrate_compress_table = jSONObject;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (videoInfo != null && videoInfo.get("video_bitrate") != null) {
                Iterator it2 = ((ArrayList) videoInfo.get("video_bitrate")).iterator();
                while (it2.hasNext()) {
                    this.mEventContext.video_biterate_set.add((Integer) it2.next());
                }
            }
            if (videoInfo != null && videoInfo.get("audio_bitrate") != null) {
                Iterator it4 = ((ArrayList) videoInfo.get("audio_bitrate")).iterator();
                while (it4.hasNext()) {
                    this.mEventContext.audio_biterate_set.add((Integer) it4.next());
                }
            }
        }
        VideoEventBase videoEventBase2 = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(videoEventBase2.mContext, this, videoEventBase2, this.mEventContext));
        EventContext eventContext3 = new EventContext();
        this.mEventContext = eventContext3;
        if (i == 0) {
            eventContext3.index = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject toJsonObject(EventContext eventContext) {
        HashMap hashMap = new HashMap();
        LoggerUtils.putToMap((Map) hashMap, "local_time_ms", eventContext.local_time_ms);
        LoggerUtils.putToMap((Map) hashMap, "is_abr", eventContext.is_abr);
        LoggerUtils.putToMap((Map) hashMap, "is_select", eventContext.is_select);
        LoggerUtils.putToMap(hashMap, "vtype", eventContext.vtype);
        LoggerUtils.putToMap((Map) hashMap, "sample_interval", eventContext.sample_interval);
        LoggerUtils.putToMap((Map) hashMap, "video_sample_count", eventContext.video_sample_count);
        LoggerUtils.putToMap(hashMap, "video_sample_interval", eventContext.video_sample_interval);
        LoggerUtils.putToMap(hashMap, "video_network_speed_sampling_set", eventContext.video_speed_set);
        LoggerUtils.putToMap(hashMap, "video_network_speed_sampling_load_types", eventContext.video_speed_load_type_set);
        LoggerUtils.putToMap(hashMap, "video_network_speed_predict_set", eventContext.video_predict_speed_set);
        LoggerUtils.putToMap(hashMap, "video_network_speed_predict_load_types", eventContext.video_predict_speed_load_type_set);
        LoggerUtils.putToMap(hashMap, "video_play_bitrate_set", eventContext.video_play_bitrate_set);
        LoggerUtils.putToMap(hashMap, "video_download_bitrate_set", eventContext.video_download_bitrate_set);
        LoggerUtils.putToMap(hashMap, "video_download_size_set", eventContext.video_download_size_set);
        LoggerUtils.putToMap(hashMap, "video_download_costtime_set", eventContext.video_downLoad_cost_time_set);
        LoggerUtils.putToMap(hashMap, "video_tcpInfo_rtt_set", eventContext.video_tcpinfo_rtt_set);
        LoggerUtils.putToMap(hashMap, "video_tcpInfo_lastRecvDate", eventContext.video_tcpinfo_lastRevDate);
        LoggerUtils.putToMap(hashMap, "video_mdl_loader_type", eventContext.video_protocol_set);
        LoggerUtils.putToMap((Map) hashMap, "audio_sample_count", eventContext.audio_sample_count);
        LoggerUtils.putToMap(hashMap, "audio_sample_interval", eventContext.audio_sample_interval);
        LoggerUtils.putToMap(hashMap, "audio_network_speed_sampling_set", eventContext.audio_speed_set);
        LoggerUtils.putToMap(hashMap, "audio_network_speed_sampling_load_types", eventContext.audio_speed_load_type_set);
        LoggerUtils.putToMap(hashMap, "audio_network_speed_predict_set", eventContext.audio_predict_speed_set);
        LoggerUtils.putToMap(hashMap, "audio_network_speed_predict_load_types", eventContext.audio_predict_speed_load_type_set);
        LoggerUtils.putToMap(hashMap, "audio_play_bitrate_set", eventContext.audio_play_bitrate_set);
        LoggerUtils.putToMap(hashMap, "audio_download_bitrate_set", eventContext.audio_download_bitrate_set);
        LoggerUtils.putToMap(hashMap, "audio_download_size_set", eventContext.audio_download_size_set);
        LoggerUtils.putToMap(hashMap, "audio_download_costtime_set", eventContext.audio_downLoad_cost_time_set);
        LoggerUtils.putToMap(hashMap, "audio_tcpInfo_rtt_set", eventContext.audio_tcpinfo_rtt_set);
        LoggerUtils.putToMap(hashMap, "audio_tcpInfo_lastRecvDate", eventContext.audio_tcpinfo_lastRevDate);
        LoggerUtils.putToMap(hashMap, "audio_mdl_loader_type", eventContext.audio_protocol_set);
        LoggerUtils.putToMap(hashMap, "buffer_len_set", eventContext.buffer_len_set);
        LoggerUtils.putToMap(hashMap, "play_speed_set", eventContext.play_speed_set);
        LoggerUtils.putToMap(hashMap, "play_pos_set", eventContext.play_pos_set);
        LoggerUtils.putToMap((Map) hashMap, "index", eventContext.index);
        LoggerUtils.putToMap(hashMap, "player_sessionid", eventContext.player_sessionid);
        LoggerUtils.putToMap(hashMap, "video_id", eventContext.video_id);
        LoggerUtils.putToMap(hashMap, "video_bitrate_set", eventContext.video_biterate_set);
        LoggerUtils.putToMap(hashMap, "audio_bitrate_set", eventContext.audio_biterate_set);
        LoggerUtils.putToMap((Map) hashMap, "is_multi_dimensions", eventContext.is_multi_dimensions);
        LoggerUtils.putToMap((Map) hashMap, "is_multi_dimensions_input", eventContext.is_multi_dimensions_input);
        JSONObject jSONObject = new JSONObject(hashMap);
        try {
            jSONObject.put("bitrate_map_table", eventContext.bitrate_compress_table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void _addResultItemToPredictorSet(ss1.o oVar, Integer num) {
        if (oVar == null) {
            return;
        }
        Iterator it2 = oVar.b.iterator();
        while (it2.hasNext()) {
            ss1.p pVar = (ss1.p) it2.next();
            String format = String.format("%s|%s|%s|%s", pVar.a, pVar.b, String.valueOf(num), String.valueOf(this.mEventBase.speed_predict_type));
            int i = pVar.d;
            if (i == 0) {
                this.mEventContext.video_predict_speed_set.add(Float.valueOf(pVar.c));
                this.mEventContext.video_predict_speed_load_type_set.add(format);
            } else if (i == 1) {
                this.mEventContext.audio_predict_speed_set.add(Float.valueOf(pVar.c));
                this.mEventContext.audio_predict_speed_load_type_set.add(format);
            }
        }
    }

    void addExtraMapInfoForTrackType(Map<String, String> map, int i) {
        if (map != null && map.size() > 0 && i <= 1) {
            if (i == 0) {
                String str = map.get("download_size");
                String str2 = map.get("download_time");
                String str3 = map.get("rtt");
                String str4 = map.get("last_data_recv");
                String str5 = map.get("mdl_loader_type");
                if (str != null) {
                    this.mEventContext.video_download_size_set.add(Float.valueOf(Float.parseFloat(str)));
                }
                if (str2 != null) {
                    this.mEventContext.video_downLoad_cost_time_set.add(Long.valueOf(Long.parseLong(str2)));
                }
                if (str3 != null) {
                    this.mEventContext.video_tcpinfo_rtt_set.add(Long.valueOf(Long.parseLong(str3)));
                }
                if (str4 != null) {
                    this.mEventContext.video_tcpinfo_lastRevDate.add(Long.valueOf(Long.parseLong(str4)));
                }
                if (str5 != null) {
                    this.mEventContext.video_protocol_set.add(str5);
                    return;
                }
                return;
            }
            if (i == 1) {
                String str6 = map.get("download_size");
                String str7 = map.get("download_time");
                String str8 = map.get("rtt");
                String str9 = map.get("last_data_recv");
                String str10 = map.get("mdl_loader_type");
                if (str6 != null) {
                    this.mEventContext.audio_download_size_set.add(Float.valueOf(Float.parseFloat(str6)));
                }
                if (str7 != null) {
                    this.mEventContext.audio_downLoad_cost_time_set.add(Long.valueOf(Long.parseLong(str7)));
                }
                if (str8 != null) {
                    this.mEventContext.audio_tcpinfo_rtt_set.add(Long.valueOf(Long.parseLong(str8)));
                }
                if (str9 != null) {
                    this.mEventContext.audio_tcpinfo_lastRevDate.add(Long.valueOf(Long.parseLong(str9)));
                }
                if (str10 != null) {
                    this.mEventContext.audio_protocol_set.add(str10);
                }
            }
        }
    }

    public void updateNetworkMutiSpeed(SpeedPredictorResultCollection speedPredictorResultCollection, SpeedPredictorResultCollection speedPredictorResultCollection2, long j) {
        Map map;
        String str;
        if (this.mIsStarted && this.mEventBase != null && speedPredictorResultCollection != null && speedPredictorResultCollection2 != null) {
            _updateEventBaseInfo();
            Map videoInfo = this.mEventBase.getVideoInfo();
            if (videoInfo != null && (map = (Map) videoInfo.get("fileKey")) != null && !map.isEmpty()) {
                Boolean bool = Boolean.FALSE;
                int i = 0;
                Boolean[] boolArr = {bool};
                Boolean[] boolArr2 = {bool};
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getValue();
                    Iterator it2 = speedPredictorResultCollection.a.iterator();
                    while (it2.hasNext()) {
                        ss1.o oVar = (ss1.o) it2.next();
                        if (oVar.a.equals(str2)) {
                            if (!oVar.b.isEmpty()) {
                                if (((ss1.p) oVar.b.get(i)).d == 0) {
                                    if (entry.getKey() == null) {
                                        this.mEventContext.video_download_bitrate_set.add(-1);
                                    } else if (((Integer) entry.getKey()).intValue() == 0) {
                                        this.mEventContext.video_download_bitrate_set.add(-1);
                                    } else {
                                        this.mEventContext.video_download_bitrate_set.add(_doBitrateMap((Integer) entry.getKey()));
                                    }
                                } else if (entry.getKey() == null) {
                                    this.mEventContext.audio_download_bitrate_set.add(-1);
                                } else if (((Integer) entry.getKey()).intValue() == 0) {
                                    this.mEventContext.audio_download_bitrate_set.add(-1);
                                } else {
                                    this.mEventContext.audio_download_bitrate_set.add(_doBitrateMap((Integer) entry.getKey()));
                                }
                            }
                            str = str2;
                            _addResultItemToSampleSet(oVar, (Integer) entry.getKey(), j, boolArr, boolArr2);
                        } else {
                            str = str2;
                        }
                        str2 = str;
                        i = 0;
                    }
                    String str3 = str2;
                    Iterator it4 = speedPredictorResultCollection2.a.iterator();
                    while (it4.hasNext()) {
                        ss1.o oVar2 = (ss1.o) it4.next();
                        if (oVar2.a.equals(str3)) {
                            _addResultItemToPredictorSet(oVar2, (Integer) entry.getKey());
                        }
                    }
                    i = 0;
                }
                EventContext eventContext = this.mEventContext;
                int i2 = eventContext.video_sample_count + 1;
                eventContext.video_sample_count = i2;
                int i3 = eventContext.audio_sample_count + 1;
                eventContext.audio_sample_count = i3;
                int i4 = this.mMaxWindowSize;
                if (i2 >= i4 || i3 >= i4) {
                    if (eventContext.index == 0) {
                        _sendEvent(0);
                    } else {
                        _popHead();
                    }
                }
            }
        }
    }

    private void _addResultItemToSampleSet(ss1.o oVar, Integer num, long j, Boolean[] boolArr, Boolean[] boolArr2) {
        if (oVar == null) {
            return;
        }
        Iterator it2 = oVar.b.iterator();
        while (it2.hasNext()) {
            ss1.p pVar = (ss1.p) it2.next();
            String format = String.format("%s|%s|%s", pVar.a, pVar.b, String.valueOf(num));
            int i = pVar.d;
            if (i == 0) {
                this.mEventContext.video_speed_set.add(Float.valueOf(pVar.c));
                this.mEventContext.video_speed_load_type_set.add(format);
                if (!boolArr[0].booleanValue()) {
                    this.mEventContext.video_sample_interval.add(Integer.valueOf((int) j));
                    boolArr[0] = Boolean.TRUE;
                } else {
                    this.mEventContext.video_sample_interval.add(0);
                }
            } else if (i == 1) {
                this.mEventContext.audio_speed_set.add(Float.valueOf(pVar.c));
                this.mEventContext.audio_speed_load_type_set.add(format);
                if (!boolArr2[0].booleanValue()) {
                    this.mEventContext.audio_sample_interval.add(Integer.valueOf((int) j));
                    boolArr2[0] = Boolean.TRUE;
                } else {
                    this.mEventContext.audio_sample_interval.add(0);
                }
            }
        }
    }

    public void updateNetworkSpeed(String str, String str2, float f, float f2, float f3, float f4, long j, Map<String, String> map, Map<String, String> map2) {
        Map videoInfo;
        if (this.mIsStarted && this.mEventBase != null) {
            _updateEventBaseInfo();
            String valueOf = String.valueOf(this.mEventBase.speed_predict_type);
            if (this.mEventBase != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (videoInfo = this.mEventBase.getVideoInfo()) != null && !str.equals("-1") && !str2.equals("-1")) {
                Map map3 = (Map) videoInfo.get("fileKey");
                if (map3 == null) {
                    map3 = new HashMap();
                }
                for (Map.Entry entry : map3.entrySet()) {
                    if (((String) entry.getValue()).equals(str)) {
                        if (entry.getKey() == null) {
                            this.mEventContext.video_download_bitrate_set.add(-1);
                        } else if (((Integer) entry.getKey()).intValue() == 0) {
                            this.mEventContext.video_download_bitrate_set.add(-1);
                        } else {
                            this.mEventContext.video_download_bitrate_set.add(_doBitrateMap((Integer) entry.getKey()));
                        }
                        this.mEventContext.video_sample_interval.add(Integer.valueOf((int) j));
                        this.mEventContext.video_speed_set.add(Float.valueOf(f));
                        this.mEventContext.video_predict_speed_set.add(Float.valueOf(f3));
                        this.mEventContext.video_predict_speed_load_type_set.add(valueOf);
                        addExtraMapInfoForTrackType(map, 0);
                    }
                    if (((String) entry.getValue()).equals(str2)) {
                        if (entry.getKey() == null) {
                            this.mEventContext.audio_download_bitrate_set.add(-1);
                        } else if (((Integer) entry.getKey()).intValue() == 0) {
                            this.mEventContext.audio_download_bitrate_set.add(-1);
                        } else {
                            this.mEventContext.audio_download_bitrate_set.add(_doBitrateMap((Integer) entry.getKey()));
                        }
                        this.mEventContext.audio_sample_interval.add(Integer.valueOf((int) j));
                        this.mEventContext.audio_speed_set.add(Float.valueOf(f2));
                        this.mEventContext.audio_predict_speed_set.add(Float.valueOf(f4));
                        this.mEventContext.audio_predict_speed_load_type_set.add(valueOf);
                        addExtraMapInfoForTrackType(map2, 1);
                    }
                }
            }
            EventContext eventContext = this.mEventContext;
            eventContext.video_sample_count++;
            eventContext.audio_sample_count++;
            TTVideoEngineLog.d("VideoEventSampleRecord", "brian video count:" + this.mEventContext.video_sample_count + ",audio count:" + this.mEventContext.audio_sample_count);
            EventContext eventContext2 = this.mEventContext;
            int i = eventContext2.video_sample_count;
            int i2 = this.mMaxWindowSize;
            if (i >= i2 || eventContext2.audio_sample_count >= i2) {
                if (eventContext2.index == 0) {
                    _sendEvent(0);
                } else {
                    _popHead();
                }
            }
        }
    }
}

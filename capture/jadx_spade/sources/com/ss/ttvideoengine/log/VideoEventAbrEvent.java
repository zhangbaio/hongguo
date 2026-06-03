package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventAbrEvent {
    public VideoEventBase mEventBase;
    private ArrayList<EventContext> mEventContexts = new ArrayList<>();

    static {
        Covode.recordClassIndex(652486);
    }

    public void reset() {
        this.mEventContexts.clear();
    }

    private static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventAbrEvent rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler = new HandlerDelegate(Looper.getMainLooper());

        static {
            Covode.recordClassIndex(652487);
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z;
            VideoEventAbrEvent videoEventAbrEvent = this.rEvent;
            if (videoEventAbrEvent == null) {
                return;
            }
            VideoEventBase videoEventBase = this.rEventBase;
            if (videoEventBase != null && videoEventBase.isUploadLogEnabled) {
                z = true;
            } else {
                z = false;
            }
            final JSONObject jsonObject = videoEventAbrEvent.toJsonObject(this.rEventContext, videoEventBase);
            Handler handler = this.rHandler;
            if (handler != null && handler.getLooper() != null) {
                this.rHandler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventAbrEvent.AsyncGetLogDataRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_abrswitch");
                    }
                });
            } else {
                VideoEventManager.instance.addEventV2(z, jsonObject, "videoplayer_abrswitch");
            }
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventAbrEvent videoEventAbrEvent, VideoEventBase videoEventBase, EventContext eventContext) {
            this.rEvent = videoEventAbrEvent;
            this.rEventBase = videoEventBase;
            this.rContext = context;
            this.rEventContext = eventContext;
        }
    }

    VideoEventAbrEvent(VideoEventBase videoEventBase) {
        this.mEventBase = videoEventBase;
    }

    public void sendAbrSwitchEvent(EventContext eventContext) {
        this.mEventBase.updateVideoInfo(null);
        VideoEventBase videoEventBase = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(videoEventBase.mContext, this, videoEventBase, eventContext));
    }

    private class EventContext {
        public String mAbrV;
        public long mAudioBufferLen;
        public long mCostTime;
        public long mDelayTime;
        public String mEndType;
        public long mEventTime;
        public long mMaxBufferLen;
        public long mNewBr;
        public long mOldBr;
        public int mReason;
        public float mSpeed;
        public int mSwitch2new;
        public long mVideoBufferLen;
        public long mWasteByte;

        static {
            Covode.recordClassIndex(652488);
        }

        private EventContext() {
            this.mEventTime = -2147483648L;
            this.mCostTime = -2147483648L;
            this.mEndType = "";
            this.mAbrV = "";
            this.mOldBr = -1L;
            this.mNewBr = -1L;
            this.mMaxBufferLen = -1L;
            this.mAudioBufferLen = -1L;
            this.mVideoBufferLen = -1L;
            this.mSpeed = -1.0f;
            this.mDelayTime = -1L;
            this.mWasteByte = -1L;
            this.mSwitch2new = 0;
            this.mReason = -1;
        }
    }

    public void abrSwitchEnd(long j) {
        if (this.mEventContexts == null) {
            return;
        }
        EventContext eventContext = null;
        while (!this.mEventContexts.isEmpty() && ((eventContext = this.mEventContexts.remove(0)) == null || eventContext.mNewBr != j)) {
        }
        if (eventContext == null) {
            return;
        }
        TTVideoEngineLog.d("VideoEventAbrEvent", "abrSwitchEnd");
        eventContext.mSwitch2new = (int) this.mEventBase.mDataSource.getLogValueLong(106);
        eventContext.mDelayTime = this.mEventBase.mDataSource.getLogValueLong(107);
        eventContext.mCostTime = System.currentTimeMillis() - eventContext.mEventTime;
        sendAbrSwitchEvent(eventContext);
    }

    public void abrSwitchStart(long j, long j2) {
        TTVideoEngineLog.d("VideoEventAbrEvent", "abrSwitchStart");
        EventContext eventContext = new EventContext();
        eventContext.mEventTime = System.currentTimeMillis();
        eventContext.mAbrV = this.mEventBase.mDataSource.getLogValueStr(102);
        eventContext.mOldBr = j;
        eventContext.mNewBr = j2;
        eventContext.mMaxBufferLen = this.mEventBase.mDataSource.getLogValueInt(103);
        eventContext.mAudioBufferLen = this.mEventBase.mDataSource.getLogValueLong(104);
        eventContext.mVideoBufferLen = this.mEventBase.mDataSource.getLogValueLong(105);
        eventContext.mReason = this.mEventBase.mDataSource.getLogValueInt(109);
        ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        if (bVar != null) {
            eventContext.mSpeed = bVar.d(0);
        }
        this.mEventContexts.add(eventContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject toJsonObject(EventContext eventContext, VideoEventBase videoEventBase) {
        HashMap hashMap = new HashMap();
        if (videoEventBase != null) {
            LoggerUtils.putToMap(hashMap, "player_sessionid", videoEventBase.mSessionID);
            LoggerUtils.putToMap(hashMap, "v", videoEventBase.mVid);
            LoggerUtils.putToMap(hashMap, "pc", videoEventBase.pc);
            LoggerUtils.putToMap(hashMap, "sv", videoEventBase.sv);
            LoggerUtils.putToMap(hashMap, "sdk_version", videoEventBase.sdk_version);
            LoggerUtils.putToMap(hashMap, "vtype", videoEventBase.vtype);
        }
        LoggerUtils.putToMap(hashMap, "abrv", eventContext.mAbrV);
        LoggerUtils.putToMap((Map) hashMap, "cost_time", eventContext.mCostTime);
        LoggerUtils.putToMap((Map) hashMap, "pr_time", eventContext.mEventTime);
        LoggerUtils.putToMap(hashMap, "end_type", eventContext.mEndType);
        LoggerUtils.putToMap((Map) hashMap, "old_br", eventContext.mOldBr);
        LoggerUtils.putToMap((Map) hashMap, "new_br", eventContext.mNewBr);
        LoggerUtils.putToMap((Map) hashMap, "max_buf", eventContext.mMaxBufferLen);
        LoggerUtils.putToMap((Map) hashMap, "abuf", eventContext.mAudioBufferLen);
        LoggerUtils.putToMap((Map) hashMap, "vbuf", eventContext.mVideoBufferLen);
        LoggerUtils.putToMap(hashMap, "netspeed", eventContext.mSpeed);
        LoggerUtils.putToMap((Map) hashMap, "delaytime", eventContext.mDelayTime);
        LoggerUtils.putToMap((Map) hashMap, "tonew", eventContext.mSwitch2new);
        LoggerUtils.putToMap((Map) hashMap, "reason", eventContext.mReason);
        TTVideoEngineLog.d("VideoEventAbrEvent", "AbrSwitch:" + hashMap.toString());
        return new JSONObject(hashMap);
    }
}

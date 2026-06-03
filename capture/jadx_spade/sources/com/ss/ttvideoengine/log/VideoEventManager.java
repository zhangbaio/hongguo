package com.ss.ttvideoengine.log;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum VideoEventManager {
    instance;

    private Context mContext;
    private VideoEventEngineUploader mEngineUploader;
    private IVideoEventUploader mUploader;
    private VideoEventListener mListener = null;
    private JSONArray mJsonArray = new JSONArray();
    private JSONArray mJsonArrayV2 = new JSONArray();
    private int mLoggerVersion = 2;

    public synchronized JSONArray popAllEvents() {
        JSONArray jSONArray;
        jSONArray = this.mJsonArray;
        this.mJsonArray = new JSONArray();
        return jSONArray;
    }

    static {
        Covode.recordClassIndex(652498);
    }

    public int getLoggerVersion() {
        TTVideoEngineLog.e("VideoEventManager", "getLoggerVersion: " + this.mLoggerVersion);
        return this.mLoggerVersion;
    }

    public JSONArray popAllEventsV2() {
        JSONArray jSONArray = this.mJsonArrayV2;
        synchronized (VideoEventManager.class) {
            this.mJsonArrayV2 = new JSONArray();
        }
        return jSONArray;
    }

    public void setListener(VideoEventListener videoEventListener) {
        this.mListener = videoEventListener;
    }

    public void setUploader(IVideoEventUploader iVideoEventUploader) {
        this.mUploader = iVideoEventUploader;
    }

    public void setContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.mEngineUploader = videoEventEngineUploader;
    }

    public void setLoggerVersion(int i) {
        TTVideoEngineLog.e("VideoEventManager", "setLoggerVersion: " + i);
        if (i == 1 || i == 2) {
            this.mLoggerVersion = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showEvent(JSONObject jSONObject) {
        if (((TTVideoEngineLog.getLogNotifyLevel() >> 1) & 1) == 1 || ((TTVideoEngineLog.getLogTurnOn() >> 1) & 1) == 1) {
            try {
                showLongLog(jSONObject.toString());
            } catch (ConcurrentModificationException e) {
                TTVideoEngineLog.e("VideoEventManager", e.toString());
            }
        }
    }

    private static void showLongLog(String str) {
        if (str != null) {
            int i = 3900;
            if (str.length() > 3900) {
                int length = str.length();
                int i2 = 0;
                while (i < length) {
                    TTVideoEngineLog.d("VideoEventManager", str.substring(i2, i));
                    i2 += 3900;
                    i = Math.min(i + 3900, length);
                }
                TTVideoEngineLog.d("VideoEventManager", str.substring(i2, i));
                return;
            }
        }
        TTVideoEngineLog.d("VideoEventManager", str);
    }

    VideoEventManager() {
    }

    protected void addEvent(boolean z, final JSONObject jSONObject) {
        synchronized (VideoEventManager.class) {
            if (jSONObject == null) {
                return;
            }
            TTVideoEngineLog.d("VideoEventManager", "addEvent  uploadLog = " + z);
            VideoEventEngineUploader videoEventEngineUploader = this.mEngineUploader;
            if (videoEventEngineUploader != null) {
                videoEventEngineUploader.onEvent("video_playq", jSONObject);
            } else {
                IVideoEventUploader iVideoEventUploader = this.mUploader;
                if (iVideoEventUploader != null && z) {
                    iVideoEventUploader.onUplaod("video_playq", jSONObject);
                    EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoEventManager.showEvent(jSONObject);
                        }
                    });
                } else {
                    if (this.mListener != null) {
                        this.mJsonArray.put(jSONObject);
                        this.mListener.onEvent();
                    } else {
                        TTVideoEngineLog.e("VideoEventManager", "no listener set");
                    }
                    EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoEventManager.showEvent(jSONObject);
                        }
                    });
                }
            }
        }
    }

    public void addEventV2(boolean z, final JSONObject jSONObject, String str) {
        synchronized (VideoEventManager.class) {
            if (jSONObject == null) {
                return;
            }
            TTVideoEngineLog.d("VideoEventManager", "addEventV2  uploadLog = " + z + ", listener:" + this.mListener + ", uploader:" + this.mUploader);
            VideoEventEngineUploader videoEventEngineUploader = this.mEngineUploader;
            if (videoEventEngineUploader != null) {
                videoEventEngineUploader.onEventV2(str, jSONObject);
            } else {
                IVideoEventUploader iVideoEventUploader = this.mUploader;
                if (iVideoEventUploader != null && z) {
                    iVideoEventUploader.onUplaod(str, jSONObject);
                    EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoEventManager.showEvent(jSONObject);
                        }
                    });
                } else {
                    if (this.mListener != null) {
                        this.mJsonArrayV2.put(jSONObject);
                        this.mListener.onEventV2(str);
                    } else {
                        TTVideoEngineLog.e("VideoEventManager", "no listener set");
                    }
                    EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoEventManager.showEvent(jSONObject);
                        }
                    });
                }
            }
        }
    }
}

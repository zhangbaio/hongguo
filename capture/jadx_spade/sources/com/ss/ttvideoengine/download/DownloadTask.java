package com.ss.ttvideoengine.download;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DownloadTask {
    protected boolean mFirstResumeCallback;
    protected String taskDescription = null;
    protected long taskIdentifier = -1;
    protected String taskType = "base_task";
    protected long bytesReceived = 0;
    protected long bytesExpectedToReceive = 0;
    private int state = 0;
    protected Error error = null;
    protected String availableLocalFilePath = null;
    protected ArrayList<String> mediaKeys = null;
    protected HashMap<String, List<String>> usingUrls = null;
    protected boolean finished = false;
    protected boolean canceled = false;
    protected String videoId = null;
    protected int mUseOriginalUrlEncode = -1;
    protected String authToken = null;
    protected Downloader downloader = null;
    protected long updateTs = 0;
    protected long updateBytesReceived = 0;
    protected HashMap<String, Long> bytesReceivedMap = null;
    protected HashMap<String, Long> bytesExpectedToReceiveMap = null;
    protected Handler mHandler = null;
    protected EncryptVersion encryptVersion = EncryptVersion.NONE;
    protected String customDir = null;
    protected MediaType mMediaType = MediaType.Unknown;

    static {
        Covode.recordClassIndex(652424);
    }

    public String getVideoId() {
        return null;
    }

    public enum EncryptVersion {
        NONE(0),
        MDL_VERSION_1(1);

        private int version;

        int getVersion() {
            return this.version;
        }

        static {
            Covode.recordClassIndex(652425);
        }

        EncryptVersion(int i) {
            this.version = i;
        }
    }

    public String getAvailableLocalFilePath() {
        return this.availableLocalFilePath;
    }

    public long getBytesExpectedToReceive() {
        return this.bytesExpectedToReceive;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getCustomDir() {
        return this.customDir;
    }

    public Error getError() {
        return this.error;
    }

    public MediaType getMediaType() {
        return this.mMediaType;
    }

    public int getState() {
        return this.state;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public void suspend() {
        setState(3);
    }

    void downloadEnd() {
        this.error = null;
        setState(5);
        Downloader downloader = this.downloader;
        if (downloader != null) {
            downloader.completeError(this, null);
        }
    }

    JSONObject jsonObject() {
        return new JSONObject(mapInfo());
    }

    public void resume() {
        initHandle();
        this.error = null;
        this.finished = false;
        this.updateTs = System.currentTimeMillis();
    }

    protected void initHandle() {
        if (this.mHandler != null) {
            return;
        }
        this.mHandler = new HandlerDelegate(TTHelper.getLooper()) { // from class: com.ss.ttvideoengine.download.DownloadTask.2
            /* JADX WARN: Multi-variable type inference failed */
            public void handleMessage(Message message) {
                if (message == null || this == null) {
                    return;
                }
                super/*android.os.Handler*/.handleMessage(message);
                int i = message.what;
                if (i == 111) {
                    this.setState(0);
                    DownloadTask downloadTask = this;
                    Downloader downloader = downloadTask.downloader;
                    if (downloader != null) {
                        downloader.cancel(downloadTask);
                        return;
                    }
                    return;
                }
                if (i == 112) {
                    DownloadTask downloadTask2 = this;
                    Error error = (Error) message.obj;
                    downloadTask2.error = error;
                    if (!DownloadTask.this._shouldRetry(error)) {
                        this.setState(5);
                    }
                    DownloadTask downloadTask3 = this;
                    Downloader downloader2 = downloadTask3.downloader;
                    if (downloader2 != null) {
                        downloader2.completeError(downloadTask3, downloadTask3.error);
                        return;
                    }
                    return;
                }
                if (i == 113) {
                    DownloadTask downloadTask4 = this;
                    downloadTask4.error = null;
                    downloadTask4.setState(5);
                    DownloadTask downloadTask5 = this;
                    Downloader downloader3 = downloadTask5.downloader;
                    if (downloader3 != null) {
                        downloader3.completeError(downloadTask5, null);
                    }
                }
            }
        };
    }

    public enum MediaType {
        Unknown,
        M3u8,
        Other;

        static {
            Covode.recordClassIndex(652426);
        }
    }

    void setupBaseFiled() {
        this.taskIdentifier = -1L;
        this.taskType = "base_task";
        this.bytesReceived = 0L;
        this.bytesExpectedToReceive = 0L;
        this.state = 0;
        this.error = null;
        this.availableLocalFilePath = null;
        this.mediaKeys = new ArrayList<>();
        this.usingUrls = null;
        this.finished = false;
        this.videoId = null;
        this.updateTs = 0L;
        this.bytesReceivedMap = new HashMap<>();
        this.bytesExpectedToReceiveMap = new HashMap<>();
    }

    public String toString() {
        return super.toString() + "   id = " + this.taskIdentifier + ", state = " + this.state + ",  videoId " + this.videoId;
    }

    public void invalidateAndCancel() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[downloader] did call invalidateAndCancel, key = ");
        ArrayList<String> arrayList = this.mediaKeys;
        if (arrayList != null) {
            str = arrayList.toString();
        } else {
            str = null;
        }
        sb.append(str);
        TTVideoEngineLog.d("TTVideoEngine.DownloadTask", sb.toString());
        if (this.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadTask", "[downloader] task did canceled, self.taskIdentifier = " + this.taskIdentifier);
            return;
        }
        this.canceled = true;
        this.finished = false;
        setState(4);
        initHandle();
        final ArrayList<String> arrayList2 = this.mediaKeys;
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.download.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList3 = arrayList2;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    for (int i = 0; i < arrayList2.size(); i++) {
                        String str2 = (String) arrayList2.get(i);
                        DataLoaderHelper.getDataLoader().suspendedDownload(str2);
                        DataLoaderHelper.getDataLoader().removeDownloadFile(str2);
                    }
                }
                Handler handler = DownloadTask.this.mHandler;
                if (handler != null) {
                    handler.sendMessage(Message.obtain(handler, TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE));
                }
            }
        });
    }

    Map mapInfo() {
        HashMap hashMap = new HashMap();
        putToMap(hashMap, "id", this.taskIdentifier);
        putToMap(hashMap, "des", this.taskDescription);
        putToMap(hashMap, "res_size", this.bytesReceived);
        putToMap(hashMap, "content_size", this.bytesExpectedToReceive);
        putToMap((Map) hashMap, "state", this.state);
        Error error = this.error;
        if (error != null) {
            putToMap(hashMap, "error", error.toMap());
        }
        putToMap(hashMap, "file_path", this.availableLocalFilePath);
        putToMap(hashMap, "media_keys", this.mediaKeys);
        putToMap(hashMap, "use_urls", this.usingUrls);
        putToMap(hashMap, "finish", this.finished);
        putToMap(hashMap, "cancel", this.canceled);
        putToMap(hashMap, "task_type", this.taskType);
        putToMap(hashMap, "vid", this.videoId);
        putToMap(hashMap, "auth_token", this.authToken);
        putToMap(hashMap, "bytes_rec_map", this.bytesReceivedMap);
        putToMap(hashMap, "bytes_expect_map", this.bytesExpectedToReceiveMap);
        putToMap((Map) hashMap, "encrypt_version", this.encryptVersion.getVersion());
        if (!TextUtils.isEmpty(this.customDir)) {
            putToMap(hashMap, "custom_dir", this.customDir);
        }
        return hashMap;
    }

    public void setDownloader(Downloader downloader) {
        this.downloader = downloader;
    }

    public void setTaskDescription(String str) {
        this.taskDescription = str;
    }

    public void setUseOriginalUrlEncode(int i) {
        this.mUseOriginalUrlEncode = i;
    }

    public void setCustomDir(String str) {
        if (!TextUtils.isEmpty(this.customDir)) {
            return;
        }
        this.customDir = str;
    }

    boolean _shouldRetry(Error error) {
        int i;
        if (error == null || (i = error.code) == -9995 || i == -9948 || i == -9949 || i == -9947 || i == -9946) {
            return false;
        }
        return true;
    }

    void receiveError(Error error) {
        initHandle();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(Message.obtain(handler, 112, error));
        }
    }

    public void setState(int i) {
        String str;
        if (i != this.state) {
            this.state = i;
            StringBuilder sb = new StringBuilder();
            sb.append("[downloader] state did changed. state = ");
            sb.append(i);
            sb.append(" key = ");
            ArrayList<String> arrayList = this.mediaKeys;
            if (arrayList != null) {
                str = arrayList.toString();
            } else {
                str = null;
            }
            sb.append(str);
            TTVideoEngineLog.d("TTVideoEngine.DownloadTask", sb.toString());
            Downloader downloader = this.downloader;
            if (downloader != null && downloader.getListener() != null) {
                TTVideoEngineLog.d("TTVideoEngine.DownloadTask", "[downloader] state did changed. and notify downloader state = " + i);
                this.downloader.getListener().downloaderStateChanged(this.downloader, this, i);
            }
        }
    }

    void assignWithJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.taskIdentifier = jSONObject.optLong("id");
        this.taskDescription = jSONObject.optString("des");
        long optLong = jSONObject.optLong("res_size");
        this.bytesReceived = optLong;
        this.updateBytesReceived = optLong;
        this.bytesExpectedToReceive = jSONObject.optLong("content_size");
        this.state = jSONObject.optInt("state");
        this.error = TTHelper.errorWithJson(jSONObject.optJSONObject("error"));
        this.availableLocalFilePath = jSONObject.optString("file_path");
        this.customDir = jSONObject.optString("custom_dir");
        JSONArray optJSONArray = jSONObject.optJSONArray("media_keys");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.mediaKeys = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.mediaKeys.add(optString);
                }
            }
        } else {
            this.mediaKeys = new ArrayList<>();
        }
        this.finished = jSONObject.optBoolean("finish");
        this.canceled = jSONObject.optBoolean("cancel");
        this.taskType = jSONObject.optString("task_type");
        this.videoId = jSONObject.optString("vid");
        this.authToken = jSONObject.optString("auth_token");
        if (jSONObject.optInt("encrypt_version", 0) == 1) {
            this.encryptVersion = EncryptVersion.MDL_VERSION_1;
        } else {
            this.encryptVersion = EncryptVersion.NONE;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("bytes_rec_map");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.bytesReceivedMap.put(next, Long.valueOf(optJSONObject.optLong(next)));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bytes_expect_map");
        if (optJSONObject2 != null && optJSONObject2.length() > 0) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                this.bytesExpectedToReceiveMap.put(next2, Long.valueOf(optJSONObject2.optLong(next2)));
            }
        }
    }

    public static void putToMap(Map map, String str, int i) {
        map.put(str, Integer.valueOf(i));
    }

    public static void putToMap(Map map, String str, long j) {
        map.put(str, Long.valueOf(j));
    }

    public static void putToMap(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static void putToMap(Map map, String str, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            map.put(str, arrayList);
        }
    }

    public static void putToMap(Map map, String str, Map map2) {
        if (map2 != null && !map2.isEmpty()) {
            map.put(str, map2);
        }
    }

    public static void putToMap(Map map, String str, boolean z) {
        map.put(str, Boolean.valueOf(z));
    }
}

package com.ss.ttvideoengine.download;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.download.DownloadTask;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DownloadURLTask extends DownloadTask {
    private ArrayList<String> urls = null;
    private String key = null;

    static {
        Covode.recordClassIndex(652427);
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    boolean _shouldRetry(Error error) {
        return false;
    }

    public String getKey() {
        return this.key;
    }

    public ArrayList<String> getUrls() {
        return this.urls;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public String getVideoId() {
        return this.videoId;
    }

    private DownloadURLTask() {
    }

    static DownloadURLTask taskItem() {
        DownloadURLTask downloadURLTask = new DownloadURLTask();
        downloadURLTask.setupBaseFiled();
        return downloadURLTask;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    void setupBaseFiled() {
        super.setupBaseFiled();
        updateUrls(null);
        this.key = null;
        this.taskType = "url_task";
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    JSONObject jsonObject() {
        HashMap hashMap = new HashMap();
        DownloadTask.putToMap(hashMap, "base_json", super.mapInfo());
        DownloadTask.putToMap(hashMap, "key", this.key);
        DownloadTask.putToMap(hashMap, "urls", this.urls);
        return new JSONObject(hashMap);
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public void resume() {
        TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] did call resume, key = " + this.mediaKeys.toString());
        if (this.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] task did canceled");
            return;
        }
        if (getState() == 2) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] state is running");
            return;
        }
        super.resume();
        Downloader downloader = this.downloader;
        if (downloader != null && !downloader.shouldResume(this)) {
            TTVideoEngineLog.i("TTVideoEngine.DownloadURLTask", "[downloader] not should resume task = " + toString());
            return;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        this.usingUrls = hashMap;
        hashMap.put(this.key, this.urls);
        setState(2);
        int useOriginalUrlEncode = getUseOriginalUrlEncode();
        DataLoaderHelper dataLoader = DataLoaderHelper.getDataLoader();
        String str = this.key;
        String str2 = this.videoId;
        ArrayList<String> arrayList = this.urls;
        String downloadUrl = dataLoader.downloadUrl(str, str2, (String[]) arrayList.toArray(new String[arrayList.size()]), this.encryptVersion.getVersion(), this.customDir, useOriginalUrlEncode);
        if (!DataLoaderHelper.getDataLoader().startDownload(downloadUrl, FormatProvider.FormatProviderHolder.isM3u8(this.urls.get(0)))) {
            receiveError(new Error("kTTVideoErrorDomainDownload", -9996, 0, "resume download fail. url = " + downloadUrl + " dataload state is " + DataLoaderHelper.getDataLoader().isRunning()));
            return;
        }
        TTVideoEngineLog.i("TTVideoEngine.DownloadURLTask", "[downloader] resume a task. key = " + this.key + " downloader url is " + downloadUrl);
        Downloader downloader2 = this.downloader;
        if (downloader2 != null) {
            downloader2.resume(this);
        }
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public void suspend() {
        TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] did call suspend, key = " + this.mediaKeys.toString());
        if (this.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] task did canceled");
            return;
        }
        if (getState() != 3 && getState() != 0 && getState() != 5) {
            if (!this.downloader.suspended(this)) {
                TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] suspend task, task in waiting, taskIdentifier: " + this.taskIdentifier);
                return;
            }
            super.suspend();
            ArrayList<String> arrayList = this.mediaKeys;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < this.mediaKeys.size(); i++) {
                    DataLoaderHelper.getDataLoader().suspendedDownload(this.mediaKeys.get(i));
                }
            }
            Downloader downloader = this.downloader;
            if (downloader != null) {
                downloader.tryNextWaitingTask(this);
                return;
            }
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] not need suspend, state = " + getState());
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    void assignWithJson(JSONObject jSONObject) {
        super.assignWithJson(jSONObject.optJSONObject("base_json"));
        this.key = jSONObject.optString("key");
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            updateUrls(arrayList);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (super.equals(obj)) {
            return true;
        }
        if (!obj.getClass().equals(DownloadURLTask.class)) {
            return false;
        }
        return ((DownloadURLTask) obj).key.equals(this.key);
    }

    public void updateUrls(ArrayList<String> arrayList) {
        DownloadTask.MediaType mediaType;
        this.urls = arrayList;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (FormatProvider.FormatProviderHolder.isM3u8(arrayList.get(0))) {
                mediaType = DownloadTask.MediaType.M3u8;
            } else {
                mediaType = DownloadTask.MediaType.Other;
            }
            this.mMediaType = mediaType;
            return;
        }
        this.mMediaType = DownloadTask.MediaType.Unknown;
    }

    static DownloadURLTask taskItem(String str, ArrayList<String> arrayList, String str2) {
        return taskItem(str, arrayList, str2, DownloadTask.EncryptVersion.NONE);
    }

    static DownloadURLTask taskItem(String str, ArrayList<String> arrayList, String str2, DownloadTask.EncryptVersion encryptVersion) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() >= 1) {
            DownloadURLTask taskItem = taskItem();
            taskItem.key = str;
            taskItem.updateUrls(arrayList);
            taskItem.videoId = str2;
            ArrayList<String> arrayList2 = taskItem.mediaKeys;
            if (arrayList2 != null) {
                arrayList2.add(str);
            }
            taskItem.encryptVersion = encryptVersion;
            return taskItem;
        }
        TTVideoEngineLog.d("TTVideoEngine.DownloadURLTask", "[downloader] key or urls is invalid.");
        return null;
    }
}

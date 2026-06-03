package com.ss.ttvideoengine.download;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.JniUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.download.DownloadTask;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DownloadVidTask extends DownloadTask {
    private Resolution resolution = null;
    private String codecType = "h264";
    private boolean baseDashEnable = false;
    private boolean httpsEnable = false;
    private boolean boeEnable = false;
    private VideoInfoFetcher fetcher = null;
    private VideoModel videoModel = null;
    private int apiVersion = 0;
    private Map<Integer, String> params = null;
    private HashMap<String, Resolution> resolutionMap = null;
    private Resolution currentResolution = null;
    private String apiString = null;
    private String authString = null;
    private String fallbackAPI = null;
    private String keySeed = null;
    Context mContext = null;
    private TTVNetClient netClient = null;
    private IDownloadVidTaskListener fetchListener = null;
    private int retryCount = 0;

    static {
        Covode.recordClassIndex(652428);
    }

    public int getApiVersion() {
        return this.apiVersion;
    }

    public Resolution getCurrentResolution() {
        return this.currentResolution;
    }

    public IDownloadVidTaskListener getFetchListener() {
        return this.fetchListener;
    }

    public TTVNetClient getNetClient() {
        return this.netClient;
    }

    public Map<Integer, String> getParams() {
        return this.params;
    }

    public Resolution getResolution() {
        return this.resolution;
    }

    public HashMap<String, Resolution> getResolutionMap() {
        return this.resolutionMap;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public String getVideoId() {
        return this.videoId;
    }

    public VideoModel getVideoModel() {
        return this.videoModel;
    }

    public boolean isBaseDashEnable() {
        return this.baseDashEnable;
    }

    public boolean isBoeEnable() {
        return this.boeEnable;
    }

    public boolean isHttpsEnable() {
        return this.httpsEnable;
    }

    static DownloadVidTask taskItem() {
        DownloadVidTask downloadVidTask = new DownloadVidTask();
        downloadVidTask.setupBaseFiled();
        return downloadVidTask;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public void invalidateAndCancel() {
        VideoInfoFetcher videoInfoFetcher = this.fetcher;
        if (videoInfoFetcher != null) {
            videoInfoFetcher.cancel();
        }
        super.invalidateAndCancel();
    }

    public boolean isBytevc1Enable() {
        return this.codecType.equals("bytevc1");
    }

    public boolean isBytevc2Enable() {
        return this.codecType.equals("bytevc2");
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public String getAvailableLocalFilePath() {
        if (this.baseDashEnable) {
            return null;
        }
        if (getVideoModel() != null && getVideoModel().getSpadea() != null) {
            return null;
        }
        return super.getAvailableLocalFilePath();
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    void setupBaseFiled() {
        super.setupBaseFiled();
        this.retryCount = 0;
        this.taskType = "vid_task";
        this.apiVersion = 0;
        this.resolution = Resolution.Standard;
    }

    private DownloadVidTask() {
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public void resume() {
        TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] did call resume, videoId = " + this.videoId);
        if (this.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] task did canceled");
            return;
        }
        if (getState() == 2) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] state is running");
            return;
        }
        super.resume();
        Downloader downloader = this.downloader;
        if (downloader != null && !downloader.shouldResume(this)) {
            return;
        }
        this.retryCount = 0;
        setState(2);
        Downloader downloader2 = this.downloader;
        if (downloader2 != null) {
            downloader2.resume(this);
        }
        if (getVideoModel() != null) {
            _downloadWithVideoModel(getVideoModel());
        } else {
            _fetchVideoModel();
        }
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    JSONObject jsonObject() {
        HashMap hashMap = new HashMap();
        DownloadTask.putToMap(hashMap, "base_json", super.mapInfo());
        DownloadTask.putToMap(hashMap, "codec_type", this.codecType);
        DownloadTask.putToMap(hashMap, "base_dash", this.baseDashEnable);
        DownloadTask.putToMap(hashMap, "https", this.httpsEnable);
        DownloadTask.putToMap(hashMap, "boe", this.boeEnable);
        DownloadTask.putToMap(hashMap, "resolution", Resolution.toString(this.resolution));
        DownloadTask.putToMap(hashMap, "param", this.params);
        HashMap<String, Resolution> hashMap2 = this.resolutionMap;
        if (hashMap2 != null && hashMap2.size() > 0) {
            HashMap hashMap3 = new HashMap();
            for (String str : this.resolutionMap.keySet()) {
                hashMap3.put(str, Resolution.toString(this.resolutionMap.get(str)));
            }
            DownloadTask.putToMap(hashMap, "resolution_map", hashMap3);
        }
        DownloadTask.putToMap((Map) hashMap, "api_version", this.apiVersion);
        DownloadTask.putToMap(hashMap, "curr_resolution", Resolution.toString(this.currentResolution));
        JSONObject jSONObject = new JSONObject(hashMap);
        try {
            try {
                if (getVideoModel() != null) {
                    jSONObject.putOpt("video_model", getVideoModel().getJsonInfo());
                }
                return jSONObject;
            } catch (JSONException unused) {
                TTVideoEngineLog.e("TTVideoEngine.DownloadVidTask", "[downloader] jsonObject fail.");
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    public void suspend() {
        TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] did call suspend, videoId = " + this.videoId);
        if (this.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] task did canceled");
            return;
        }
        if (getState() != 3 && getState() != 0 && getState() != 5) {
            if (!this.downloader.suspended(this)) {
                TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] suspend task, task in waiting, taskIdentifier: " + this.taskIdentifier);
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
            if (downloader != null && downloader.isEnableVidTaskSuspendReleaseSlot()) {
                this.downloader.tryNextWaitingTask(this);
                return;
            }
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] not need suspend, state = " + getState());
    }

    private void _fetchVideoModel() {
        int i;
        this.apiString = null;
        this.authString = null;
        this.fetcher = null;
        VideoInfoFetcher videoInfoFetcher = new VideoInfoFetcher(this.mContext, this.netClient);
        this.fetcher = videoInfoFetcher;
        videoInfoFetcher.setListener(new MyFetcherListener(this));
        this.fetcher.setResolutionMap(this.resolutionMap);
        this.fetcher.setVideoID(this.videoId);
        this.fetcher.setUseVideoModelCache(true);
        if (!TextUtils.isEmpty(this.fallbackAPI)) {
            try {
                i = JniUtils.getDecodeMethod();
            } catch (Exception unused) {
                i = 0;
            }
            String format = String.format("%s&method=%d", this.fallbackAPI, Integer.valueOf(i));
            this.apiString = format;
            if (this.boeEnable) {
                this.apiString = TTHelper.buildBoeUrl(format);
            }
            String BuildHttpsApi = TTVideoEngineUtils.BuildHttpsApi(this.apiString);
            this.apiString = BuildHttpsApi;
            TTVideoEngineLog.i("TTVideoEngine.DownloadVidTask", String.format("[downloader] api string from fallback api:%s ,keySeed = %s", BuildHttpsApi, this.keySeed));
            this.fetcher.setUseFallbakApi(Boolean.TRUE);
            this.fetcher.fetchInfo(this.apiString, null, 0, this.keySeed);
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.codecType.equals("bytevc2")) {
            hashMap.put("codec_type", "4");
        } else if (this.codecType.equals("bytevc1")) {
            hashMap.put("codec_type", "3");
        }
        if (this.baseDashEnable) {
            hashMap.put("format_type", "dash");
        }
        if (this.httpsEnable) {
            hashMap.put("ssl", "1");
        }
        IDownloadVidTaskListener iDownloadVidTaskListener = this.fetchListener;
        if (iDownloadVidTaskListener != null) {
            this.apiString = iDownloadVidTaskListener.apiString(hashMap, this.videoId, this.apiVersion);
            this.authString = this.fetchListener.authString(this.videoId, this.apiVersion);
            if (this.boeEnable) {
                this.apiString = TTHelper.buildBoeUrl(this.apiString);
            } else {
                this.apiString = this.apiString;
            }
        }
        String BuildHttpsApi2 = TTVideoEngineUtils.BuildHttpsApi(this.apiString);
        this.apiString = BuildHttpsApi2;
        this.fetcher.fetchInfo(BuildHttpsApi2, this.authString, this.apiVersion);
        TTVideoEngineLog.i("TTVideoEngine.DownloadVidTask", "[downloader] fetch videoModel, apiString = " + this.apiString);
    }

    public void setApiVersion(int i) {
        this.apiVersion = i;
    }

    public void setBoeEnable(boolean z) {
        this.boeEnable = z;
    }

    public void setFetchListener(IDownloadVidTaskListener iDownloadVidTaskListener) {
        this.fetchListener = iDownloadVidTaskListener;
    }

    public void setNetClient(TTVNetClient tTVNetClient) {
        this.netClient = tTVNetClient;
    }

    public void setParams(Map<Integer, String> map) {
        this.params = map;
    }

    public void setResolutionMap(HashMap<String, Resolution> hashMap) {
        this.resolutionMap = hashMap;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    boolean _shouldRetry(Error error) {
        if (!super._shouldRetry(error) || this.retryCount >= 10) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    void receiveError(Error error) {
        if (_shouldRetry(error)) {
            this.retryCount++;
            _fetchVideoModel();
        } else {
            super.receiveError(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _downloadWithVideoModel(VideoModel videoModel) {
        this.mediaKeys.clear();
        this.usingUrls = new HashMap<>();
        String dynamicType = videoModel.getDynamicType();
        if (!TextUtils.isEmpty(dynamicType) && dynamicType.equals("segment_base")) {
            VideoInfo videoInfo = videoModel.getVideoInfo(this.resolution, VideoRef.TYPE_AUDIO, this.params, true);
            if (videoInfo != null) {
                if (!_downloadUrlInfo(videoInfo)) {
                    return;
                } else {
                    this.currentResolution = videoInfo.getResolution();
                }
            }
            VideoInfo videoInfo2 = videoModel.getVideoInfo(this.resolution, VideoRef.TYPE_VIDEO, this.params, true);
            if (videoInfo2 == null || !_downloadUrlInfo(videoInfo2)) {
                return;
            }
            this.currentResolution = videoInfo2.getResolution();
            return;
        }
        VideoInfo videoInfo3 = videoModel.getVideoInfo(this.resolution, this.params, true);
        if (videoInfo3 == null || !_downloadUrlInfo(videoInfo3)) {
            return;
        }
        this.currentResolution = videoInfo3.getResolution();
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        ArrayList<String> arrayList;
        if (obj == null) {
            return false;
        }
        if (super.equals(obj)) {
            return true;
        }
        if (!obj.getClass().equals(DownloadVidTask.class)) {
            return false;
        }
        DownloadVidTask downloadVidTask = (DownloadVidTask) obj;
        ArrayList<String> arrayList2 = this.mediaKeys;
        if (arrayList2 != null && arrayList2.size() > 0 && (arrayList = downloadVidTask.mediaKeys) != null) {
            return this.mediaKeys.equals(arrayList);
        }
        String str2 = this.videoId;
        if (str2 != null && (str = downloadVidTask.videoId) != null) {
            z = str2.equals(str);
        } else if (str2 == null && downloadVidTask.videoId == null) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.baseDashEnable == downloadVidTask.baseDashEnable) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && this.codecType.equals(downloadVidTask.codecType)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 || this.resolution != downloadVidTask.resolution) {
            return false;
        }
        return true;
    }

    public void setVideoModel(VideoModel videoModel) {
        this.videoModel = videoModel;
        this.mMediaType = DownloadTask.MediaType.Unknown;
        String videoRefStr = videoModel.getVideoRefStr(217);
        String videoRefStr2 = videoModel.getVideoRefStr(218);
        if (!TextUtils.isEmpty(videoRefStr)) {
            this.fallbackAPI = videoRefStr;
            TTVideoEngineLog.i("TTVideoEngine.DownloadVidTask", "[downloader] set fallbackapi " + videoRefStr);
        }
        if (!TextUtils.isEmpty(videoRefStr2)) {
            this.keySeed = videoRefStr2;
            TTVideoEngineLog.i("TTVideoEngine.DownloadVidTask", "[downloader] set keyseed " + this.keySeed);
        }
    }

    private boolean _downloadUrlInfo(VideoInfo videoInfo) {
        String[] strArr;
        String str;
        DownloadTask.MediaType mediaType;
        if (videoInfo != null) {
            strArr = videoInfo.getValueStrArr(16);
            str = videoInfo.getValueStr(15);
        } else {
            strArr = null;
            str = null;
        }
        if (strArr != null && strArr.length >= 1 && !TextUtils.isEmpty(str)) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] download urlinfo videoId = " + this.videoId + " " + videoInfo.getResolution().toString() + " filehash = " + str);
            this.mediaKeys.add(str);
            int useOriginalUrlEncode = getUseOriginalUrlEncode();
            this.usingUrls.put(str, Arrays.asList(strArr));
            String downloadUrl = DataLoaderHelper.getDataLoader().downloadUrl(str, this.videoId, strArr, this.encryptVersion.getVersion(), this.customDir, useOriginalUrlEncode);
            boolean isM3u8 = FormatProvider.FormatProviderHolder.isM3u8(strArr[0]);
            if (isM3u8) {
                mediaType = DownloadTask.MediaType.M3u8;
            } else {
                mediaType = DownloadTask.MediaType.Other;
            }
            this.mMediaType = mediaType;
            if (DataLoaderHelper.getDataLoader().startDownload(downloadUrl, isM3u8)) {
                return true;
            }
            receiveError(new Error("kTTVideoErrorDomainDownload", -9996, 0, "resume download fail. url = " + downloadUrl + " dataloader state is " + DataLoaderHelper.getDataLoader().isRunning()));
            return false;
        }
        receiveError(new Error("kTTVideoErrorDomainFetchingInfo", -9996, 0, "error info  urls or filehash is null: apiString = " + this.apiString + " authString = " + this.authString + " filehash = " + str));
        return false;
    }

    @Override // com.ss.ttvideoengine.download.DownloadTask
    void assignWithJson(JSONObject jSONObject) {
        super.assignWithJson(jSONObject.optJSONObject("base_json"));
        this.codecType = jSONObject.optString("codec_type");
        this.baseDashEnable = jSONObject.optBoolean("base_dash");
        this.httpsEnable = jSONObject.optBoolean("https");
        this.boeEnable = jSONObject.optBoolean("boe");
        Resolution forString = Resolution.forString(jSONObject.optString("resolution"));
        this.resolution = forString;
        if (forString == Resolution.Undefine) {
            this.resolution = Resolution.Standard;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            this.params = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.params.put(Integer.valueOf(next), optJSONObject.optString(next));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("resolution_map");
        if (optJSONObject2 != null && optJSONObject2.length() > 0) {
            this.resolutionMap = new HashMap<>();
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                this.resolutionMap.put(next2, Resolution.forString(optJSONObject2.optString(next2)));
            }
        }
        this.apiVersion = jSONObject.optInt("api_version");
        this.currentResolution = Resolution.forString(jSONObject.optString("curr_resolution"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("video_model");
        if (optJSONObject3 != null && optJSONObject3.length() > 0) {
            VideoModel videoModel = new VideoModel();
            try {
                try {
                    videoModel.extractFields(optJSONObject3);
                } catch (Throwable unused) {
                    TTVideoEngineLog.e("TTVideoEngine.DownloadVidTask", "[downloader] ssignWithJson fail.");
                    setVideoModel(null);
                }
            } finally {
                setVideoModel(videoModel);
            }
        }
    }

    private class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<DownloadVidTask> mTaskItemRef;

        static {
            Covode.recordClassIndex(652429);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String str) {
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error error) {
        }

        public MyFetcherListener(DownloadVidTask downloadVidTask) {
            this.mTaskItemRef = new WeakReference<>(downloadVidTask);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel videoModel, Error error) {
            DownloadVidTask downloadVidTask = this.mTaskItemRef.get();
            if (downloadVidTask == null) {
                return;
            }
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "did fetch video modeo, videoId is " + downloadVidTask.videoId);
            if (downloadVidTask.getState() != 4 && downloadVidTask.getState() != 5) {
                if (videoModel != null) {
                    downloadVidTask.setVideoModel(videoModel);
                    if (downloadVidTask.getState() != 3) {
                        downloadVidTask._downloadWithVideoModel(videoModel);
                        return;
                    }
                    TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "but state is suspended. videoId = " + downloadVidTask.videoId);
                    return;
                }
                if (error != null) {
                    downloadVidTask.receiveError(error);
                    return;
                }
                return;
            }
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "but state is canceled. videoId = " + downloadVidTask.videoId);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int i, String str) {
            DownloadVidTask downloadVidTask = this.mTaskItemRef.get();
            if (downloadVidTask == null) {
                return;
            }
            downloadVidTask.receiveError(new Error("kTTVideoErrorDomainFetchingInfo", -9996, i, "error info: apiString = " + DownloadVidTask.this.apiString + " authString = " + DownloadVidTask.this.authString + " apiVersion = " + DownloadVidTask.this.apiVersion + " state = " + i));
        }
    }

    static DownloadVidTask taskItem(VideoModel videoModel, Resolution resolution) {
        if (videoModel != null && resolution != null) {
            String videoRefStr = videoModel.getVideoRefStr(2);
            if (TextUtils.isEmpty(videoRefStr)) {
                TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] videoId is invalid");
                return null;
            }
            DownloadVidTask taskItem = taskItem();
            taskItem.videoId = videoRefStr;
            taskItem.setVideoModel(videoModel);
            taskItem.resolution = resolution;
            if (Arrays.asList(videoModel.getCodecs()).contains("bytevc2")) {
                taskItem.codecType = "bytevc2";
            } else if (Arrays.asList(videoModel.getCodecs()).contains("bytevc1")) {
                taskItem.codecType = "bytevc1";
            }
            String dynamicType = videoModel.getDynamicType();
            if (dynamicType != null) {
                taskItem.baseDashEnable = dynamicType.equals("segment_base");
            }
            taskItem.httpsEnable = videoModel.getVideoRefBool(106);
            return taskItem;
        }
        TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] videoModel or resolution is invalid");
        return null;
    }

    static DownloadVidTask taskItem(String str, Resolution resolution, String str2, boolean z, boolean z2) {
        return taskItem(str, resolution, str2, z, z2, null);
    }

    static DownloadVidTask taskItem(String str, Resolution resolution, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z) {
            str2 = "bytevc1";
        } else {
            str2 = "h264";
        }
        return taskItem(str, resolution, str2, z2, z3);
    }

    static DownloadVidTask taskItem(String str, Resolution resolution, String str2, boolean z, boolean z2, String str3) {
        return taskItem(str, resolution, str2, z, z2, str3, DownloadTask.EncryptVersion.NONE);
    }

    static DownloadVidTask taskItem(String str, Resolution resolution, String str2, boolean z, boolean z2, String str3, DownloadTask.EncryptVersion encryptVersion) {
        TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "taskItem videoId:" + str + ", resolution:" + resolution + ", codecType:" + str2 + ", baseDashEnable:" + z + ", httpsEnable:" + z2 + ",authToken:" + str3);
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader] videoId is invalid");
            return null;
        }
        if (resolution == null) {
            TTVideoEngineLog.d("TTVideoEngine.DownloadVidTask", "[downloader]  resolution is invalid");
            return null;
        }
        DownloadVidTask taskItem = taskItem();
        taskItem.videoId = str;
        taskItem.resolution = resolution;
        if (TextUtils.isEmpty(str2)) {
            taskItem.codecType = "h264";
        } else {
            taskItem.codecType = str2;
        }
        taskItem.baseDashEnable = z;
        taskItem.httpsEnable = z2;
        taskItem.authToken = str3;
        taskItem.encryptVersion = encryptVersion;
        return taskItem;
    }
}

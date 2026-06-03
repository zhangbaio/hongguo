package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DubbedInfo {
    public int mMediaType = 0;
    public String mMainUrl = null;
    public String mBackupUrl1 = null;
    public String mBackupUrl2 = null;
    public String mBackupUrl3 = null;
    public String mCheckInfo = null;
    public int mInfoId = -1;
    public int mBitrate = 0;
    public float mLoudness = 0.0f;
    public float mPeak = 0.0f;
    public String mFileKey = null;

    static {
        Covode.recordClassIndex(652532);
    }

    public static class Builder {
        private int mMediaType = 0;
        private String mMainUrl = null;
        private String mBackupUrl1 = null;
        private String mBackupUrl2 = null;
        private String mBackupUrl3 = null;
        private String mCheckInfo = null;
        private int mInfoId = -1;
        private int mBitrate = 0;
        private float mLoudness = 0.0f;
        private float mPeak = 0.0f;
        private String mFileKey = null;

        static {
            Covode.recordClassIndex(652533);
        }

        public DubbedInfo build() {
            DubbedInfo dubbedInfo = new DubbedInfo();
            dubbedInfo.mMediaType = this.mMediaType;
            dubbedInfo.mMainUrl = this.mMainUrl;
            dubbedInfo.mBackupUrl1 = this.mBackupUrl1;
            dubbedInfo.mBackupUrl2 = this.mBackupUrl2;
            dubbedInfo.mBackupUrl3 = this.mBackupUrl3;
            dubbedInfo.mCheckInfo = this.mCheckInfo;
            dubbedInfo.mInfoId = this.mInfoId;
            dubbedInfo.mBitrate = this.mBitrate;
            dubbedInfo.mLoudness = this.mLoudness;
            dubbedInfo.mPeak = this.mPeak;
            dubbedInfo.mFileKey = this.mFileKey;
            return dubbedInfo;
        }

        public Builder backupUrl1(String str) {
            this.mBackupUrl1 = str;
            return this;
        }

        public Builder backupUrl2(String str) {
            this.mBackupUrl2 = str;
            return this;
        }

        public Builder backupUrl3(String str) {
            this.mBackupUrl3 = str;
            return this;
        }

        public Builder bitrate(int i) {
            this.mBitrate = i;
            return this;
        }

        public Builder checkInfo(String str) {
            this.mCheckInfo = str;
            return this;
        }

        public Builder fileKey(String str) {
            this.mFileKey = str;
            return this;
        }

        public Builder infoId(int i) {
            this.mInfoId = i;
            return this;
        }

        public Builder loudness(float f) {
            this.mLoudness = f;
            return this;
        }

        public Builder mainUrl(String str) {
            this.mMainUrl = str;
            return this;
        }

        public Builder mediaType(int i) {
            this.mMediaType = i;
            return this;
        }

        public Builder peak(float f) {
            this.mPeak = f;
            return this;
        }
    }

    public String[] getUrls() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.mMainUrl)) {
            arrayList.add(this.mMainUrl);
        }
        if (!TextUtils.isEmpty(this.mBackupUrl1)) {
            arrayList.add(this.mBackupUrl1);
        } else if (!TextUtils.isEmpty(this.mBackupUrl2)) {
            arrayList.add(this.mBackupUrl2);
        } else if (!TextUtils.isEmpty(this.mBackupUrl3)) {
            arrayList.add(this.mBackupUrl3);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public JSONObject toBashJsonObject() {
        try {
            if (TextUtils.isEmpty(this.mMainUrl)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("main_url", this.mMainUrl);
            String str = this.mBackupUrl1;
            if (str == null) {
                str = "";
            }
            jSONObject.put("backup_url_1", str);
            jSONObject.put("check_info", this.mCheckInfo);
            jSONObject.put("info_id", this.mInfoId);
            jSONObject.put("bitrate", this.mBitrate);
            jSONObject.put("loudness", this.mLoudness);
            jSONObject.put("peak", this.mPeak);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject toStrategyPreloadJsonObject() {
        String str;
        try {
            if (TextUtils.isEmpty(this.mMainUrl)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mMainUrl);
            String str2 = this.mBackupUrl1;
            if (str2 != null) {
                jSONArray.put(str2);
            }
            String str3 = this.mBackupUrl2;
            if (str3 != null) {
                jSONArray.put(str3);
            }
            String str4 = this.mBackupUrl3;
            if (str4 != null) {
                jSONArray.put(str4);
            }
            jSONObject.put("urls", jSONArray);
            jSONObject.put("info_id", this.mInfoId);
            jSONObject.put("bitrate", this.mBitrate);
            jSONObject.put("file_hash", this.mFileKey);
            if (this.mMediaType == 0) {
                str = "video";
            } else {
                str = "audio";
            }
            jSONObject.put("media_type", str);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

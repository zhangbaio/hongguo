package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BarrageMaskInfo {
    public String mMaskFileHash;
    public String mMaskFileId;
    public String mMaskUrl;
    public String mMaskVersion;
    public long mMaskFileSize = 0;
    public long mMaskUpdatedAt = 0;
    public int mMaskBitrate = 0;
    public int mMaskHeadLen = 0;

    static {
        Covode.recordClassIndex(652531);
    }

    public Map<String, Object> getMediaInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put("file_id", getValueStr(2));
        hashMap.put("media_type", "mask");
        hashMap.put("file_size", Long.valueOf(getValueLong(4)));
        hashMap.put("bitrate", Integer.valueOf(getValueInt(6)));
        String valueStr = getValueStr(1);
        if (!TextUtils.isEmpty(valueStr)) {
            hashMap.put("urls", new String[]{valueStr});
        }
        hashMap.put("file_hash", getValueStr(3));
        return hashMap;
    }

    public int getValueInt(int i) {
        if (i != 6) {
            if (i != 7) {
                return -1;
            }
            return this.mMaskHeadLen;
        }
        return this.mMaskBitrate;
    }

    public long getValueLong(int i) {
        if (i != 4) {
            if (i != 5) {
                return 0L;
            }
            return this.mMaskUpdatedAt;
        }
        return this.mMaskFileSize;
    }

    public String getValueStr(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "";
                    }
                    return this.mMaskFileHash;
                }
                return this.mMaskFileId;
            }
            return this.mMaskUrl;
        }
        return this.mMaskVersion;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mMaskVersion = jSONObject.optString(Constants.VERSION);
            this.mMaskUrl = jSONObject.optString("barrage_mask_url");
            this.mMaskFileId = jSONObject.optString("file_id");
            this.mMaskFileHash = jSONObject.optString("file_hash");
            this.mMaskFileSize = jSONObject.optLong("file_size");
            this.mMaskUpdatedAt = jSONObject.optLong("updated_at");
            this.mMaskBitrate = jSONObject.optInt("bitrate");
            this.mMaskHeadLen = jSONObject.optInt("head_len");
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
        }
    }

    public void extractFieldsV4(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mMaskVersion = jSONObject.optString("Version");
            this.mMaskUrl = jSONObject.optString("BarrageMaskUrl");
            this.mMaskFileId = jSONObject.optString("FileId");
            this.mMaskFileHash = jSONObject.optString("FileHash");
            this.mMaskFileSize = jSONObject.optLong("FileSize");
            this.mMaskUpdatedAt = jSONObject.optLong("UpdatedAt");
            this.mMaskBitrate = jSONObject.optInt("Bitrate");
            this.mMaskHeadLen = jSONObject.optInt("HeadLen");
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
        }
    }
}

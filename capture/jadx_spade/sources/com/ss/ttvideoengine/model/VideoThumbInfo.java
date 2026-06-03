package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoModelPb;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoThumbInfo {
    private int mCaptureNumVer4;
    private int mCellHeightVer4;
    private int mCellWidthVer4;
    public double mDuration;
    private double mDurationVer2;
    public String mFext;
    private String mFextVer2;
    private String mFormatVer4;
    public int mImgNum;
    private int mImgNumVer2;
    public String mImgUrl;
    public ArrayList<String> mImgUrlList;
    private String mImgUrlVer2;
    private int mImgXLenVer4;
    public int mImgXlen;
    private int mImgXlenVer2;
    public int mImgXsize;
    private int mImgXsizeVer2;
    private int mImgYLenVer4;
    public int mImgYlen;
    private int mImgYlenVer2;
    public int mImgYsize;
    private int mImgYsizeVer2;
    public double mInterval;
    private double mIntervalVer2;
    private double mIntervalVer4;
    private ArrayList<String> mStoreUrlsVer4;
    public String mUri;
    private String mUriVer2;
    private int mVersion = 1;

    static {
        Covode.recordClassIndex(652573);
    }

    public void parseFromPb(VideoModelPb.BigThumb bigThumb) {
    }

    public List<String> getUrls() {
        if (this.mVersion == 4 && this.mStoreUrlsVer4 != null) {
            return new ArrayList(this.mStoreUrlsVer4);
        }
        return null;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public double getValueDouble(int i) {
        int i2 = this.mVersion;
        if (i2 == 2) {
            if (i != 7) {
                if (i != 8) {
                    return -1.0d;
                }
                return this.mIntervalVer2;
            }
            return this.mDurationVer2;
        }
        if (i2 == 4) {
            if (i != 8) {
                return -1.0d;
            }
            return this.mIntervalVer4;
        }
        if (i != 7) {
            if (i != 8) {
                return -1.0d;
            }
            return this.mInterval;
        }
        return this.mDuration;
    }

    public String getValueStr(int i) {
        int i2 = this.mVersion;
        if (i2 == 2) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 9) {
                        return "";
                    }
                    return this.mFextVer2;
                }
                return this.mImgUrlVer2;
            }
            return this.mUriVer2;
        }
        if (i2 == 4) {
            if (i != 9) {
                return "";
            }
            return this.mFormatVer4;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 9) {
                    return "";
                }
                return this.mFext;
            }
            return this.mImgUrl;
        }
        return this.mUri;
    }

    public int getValueInt(int i) {
        int i2 = this.mVersion;
        if (i2 == 2) {
            if (i != 0) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                return -1;
                            }
                            return this.mImgYlenVer2;
                        }
                        return this.mImgXlenVer2;
                    }
                    return this.mImgYsizeVer2;
                }
                return this.mImgXsizeVer2;
            }
            return this.mImgNumVer2;
        }
        if (i2 == 4) {
            if (i != 0) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                return -1;
                            }
                            return this.mImgYLenVer4;
                        }
                        return this.mImgXLenVer4;
                    }
                    return this.mCellHeightVer4;
                }
                return this.mCellWidthVer4;
            }
            return this.mCaptureNumVer4;
        }
        if (i != 0) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            return -1;
                        }
                        return this.mImgYlen;
                    }
                    return this.mImgXlen;
                }
                return this.mImgYsize;
            }
            return this.mImgXsize;
        }
        return this.mImgNum;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("img_num")) {
            if (this.mVersion != 3) {
                this.mVersion = 1;
            }
        } else if (jSONObject.has("ImgUrl")) {
            this.mVersion = 2;
        }
        int i = this.mVersion;
        int i2 = 0;
        if (i != 1 && i != 3) {
            if (i == 2) {
                try {
                    this.mImgNumVer2 = jSONObject.getInt("ImgNum");
                    this.mUriVer2 = jSONObject.optString("Uri");
                    this.mImgUrlVer2 = jSONObject.optString("ImgUrl");
                    this.mImgXsizeVer2 = jSONObject.optInt("ImgXSize");
                    this.mImgYsizeVer2 = jSONObject.optInt("ImgYSize");
                    this.mImgXlenVer2 = jSONObject.optInt("ImgXLen");
                    this.mImgYlenVer2 = jSONObject.optInt("ImgYLen");
                    this.mDurationVer2 = jSONObject.optDouble("Duration");
                    this.mIntervalVer2 = jSONObject.optDouble("Interval");
                    this.mFextVer2 = jSONObject.optString("Fext");
                    return;
                } catch (JSONException e) {
                    TTVideoEngineLog.d(e);
                    return;
                }
            }
            if (i == 4) {
                this.mCaptureNumVer4 = jSONObject.optInt("CaptureNum");
                JSONArray optJSONArray = jSONObject.optJSONArray("StoreUrls");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.mStoreUrlsVer4 = new ArrayList<>();
                    while (i2 < optJSONArray.length()) {
                        this.mStoreUrlsVer4.add(optJSONArray.optString(i2));
                        i2++;
                    }
                }
                this.mCellWidthVer4 = jSONObject.optInt("CellWidth");
                this.mCellHeightVer4 = jSONObject.optInt("CellHeight");
                this.mImgXLenVer4 = jSONObject.optInt("ImgXLen");
                this.mImgYLenVer4 = jSONObject.optInt("ImgYLen");
                this.mIntervalVer4 = jSONObject.optDouble("Interval");
                this.mFormatVer4 = jSONObject.optString("Format");
                return;
            }
            return;
        }
        try {
            this.mImgNum = jSONObject.getInt("img_num");
            String optString = jSONObject.optString("uri");
            this.mUri = optString;
            if (TextUtils.isEmpty(optString)) {
                this.mUri = jSONObject.optString("img_uri");
            }
            this.mImgUrl = jSONObject.optString("img_url");
            this.mImgXsize = jSONObject.optInt("img_x_size");
            this.mImgYsize = jSONObject.optInt("img_y_size");
            this.mImgXlen = jSONObject.optInt("img_x_len");
            this.mImgYlen = jSONObject.optInt("img_y_len");
            this.mDuration = jSONObject.optDouble("duration");
            this.mInterval = jSONObject.optDouble("interval");
            this.mFext = jSONObject.optString("fext");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("img_urls");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.mImgUrlList = new ArrayList<>();
                while (i2 < optJSONArray2.length()) {
                    this.mImgUrlList.add(optJSONArray2.optString(i2));
                    i2++;
                }
            }
        } catch (JSONException e2) {
            TTVideoEngineLog.d(e2);
        }
    }
}

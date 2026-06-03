package com.ss.ttvideoengine;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoModelCache {
    private static final List<String> TOB_VIDEO_MODEL_KEYS;
    private static int mCacheNB;
    private static VideoModelCache mInstance;
    private static int mTimeOutSetByUser;
    private ConcurrentHashMap<String, VideoModelCacheInfo> mVideoModelCache = new ConcurrentHashMap<>();

    public static class VideoModelCacheInfo {
        public VideoModel model = null;
        public long modelGotTime = 0;
        public boolean isExpired = false;

        static {
            Covode.recordClassIndex(652394);
        }
    }

    public static VideoModelCache getInstance() {
        if (mInstance == null) {
            synchronized (VideoModelCache.class) {
                if (mInstance == null) {
                    mInstance = new VideoModelCache();
                }
            }
        }
        return mInstance;
    }

    public synchronized void clear() {
        mTimeOutSetByUser = -1;
        mCacheNB = 100;
        ConcurrentHashMap<String, VideoModelCacheInfo> concurrentHashMap = this.mVideoModelCache;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    static {
        Covode.recordClassIndex(652393);
        mTimeOutSetByUser = -1;
        mCacheNB = 100;
        TOB_VIDEO_MODEL_KEYS = Arrays.asList("Action", "Version", "Vid", "Format", "Codec", "Definition", "Quality", "FileType", "Ssl", "NeedThumbs", "NeedBarrageMask", "HDRDefinition", "UnionInfo", "DrmExpireTimestamp", "PlayScene");
    }

    public void setCacheNb(int i) {
        mCacheNB = i;
    }

    public void setTimeOutInSec(int i) {
        mTimeOutSetByUser = i;
    }

    private String getVideoModelCacheKey(String str, String str2) {
        return getVideoModelCacheKeyForInner(str, str2);
    }

    public synchronized void remove(String str, String str2) {
        if (this.mVideoModelCache != null) {
            String videoModelCacheKey = getVideoModelCacheKey(str, str2);
            if (TextUtils.isEmpty(videoModelCacheKey)) {
            } else {
                this.mVideoModelCache.remove(videoModelCacheKey);
            }
        }
    }

    private String getVideoModelCacheKeyForTob(String str, String str2) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str2)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : TOB_VIDEO_MODEL_KEYS) {
            String queryParameter = parse.queryParameter(str3);
            if (!TextUtils.isEmpty(queryParameter)) {
                sb.append(str3);
                sb.append("=");
                sb.append(queryParameter);
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public synchronized VideoModelCacheInfo get(String str, String str2) {
        if (this.mVideoModelCache != null) {
            String videoModelCacheKey = getVideoModelCacheKey(str, str2);
            if (TextUtils.isEmpty(videoModelCacheKey)) {
                return null;
            }
            VideoModelCacheInfo videoModelCacheInfo = this.mVideoModelCache.get(videoModelCacheKey);
            if (videoModelCacheInfo != null) {
                int i = mTimeOutSetByUser;
                if (i <= 0) {
                    VideoModel videoModel = videoModelCacheInfo.model;
                    if (videoModel != null) {
                        i = (videoModel.getVideoRefInt(3) + 3600) - 300;
                    } else {
                        i = 3600;
                    }
                }
                if (SystemClock.elapsedRealtime() - videoModelCacheInfo.modelGotTime > i * 1000) {
                    videoModelCacheInfo.isExpired = true;
                } else {
                    videoModelCacheInfo.isExpired = false;
                }
                return videoModelCacheInfo;
            }
        }
        return null;
    }

    private String getVideoModelCacheKeyForInner(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        char c;
        char c2;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String str10 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str2.split("[?]");
        if (split.length >= 2) {
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            for (String str11 : split[1].split("&")) {
                int indexOf = str11.indexOf("codec_type");
                if (indexOf == 0) {
                    str10 = str11.substring(indexOf + 11);
                } else {
                    int indexOf2 = str11.indexOf("CodecType");
                    if (indexOf2 == 0) {
                        str10 = str11.substring(indexOf2 + 10);
                    } else {
                        int indexOf3 = str11.indexOf("Codec");
                        if (indexOf3 == 0) {
                            str10 = str11.substring(indexOf3 + 6);
                        } else {
                            int indexOf4 = str11.indexOf("format_type");
                            if (indexOf4 == 0) {
                                str3 = str11.substring(indexOf4 + 12);
                            } else {
                                int indexOf5 = str11.indexOf("FormatType");
                                if (indexOf5 == 0) {
                                    str3 = str11.substring(indexOf5 + 11);
                                } else {
                                    int indexOf6 = str11.indexOf("Format");
                                    if (indexOf6 == 0) {
                                        str3 = str11.substring(indexOf6 + 7);
                                    } else {
                                        int indexOf7 = str11.indexOf("ptoken");
                                        if (indexOf7 == 0) {
                                            str4 = str11.substring(indexOf7 + 7);
                                        } else {
                                            int indexOf8 = str11.indexOf("PToken");
                                            if (indexOf8 == 0) {
                                                str4 = str11.substring(indexOf8 + 7);
                                            } else {
                                                int indexOf9 = str11.indexOf("ssl");
                                                if (indexOf9 == 0) {
                                                    str5 = str11.substring(indexOf9 + 4);
                                                } else {
                                                    int indexOf10 = str11.indexOf("Ssl");
                                                    if (indexOf10 == 0) {
                                                        str5 = str11.substring(indexOf10 + 4);
                                                    } else {
                                                        int indexOf11 = str11.indexOf("HDRDefinition");
                                                        if (indexOf11 == 0) {
                                                            str6 = str11.substring(indexOf11 + 14);
                                                        } else {
                                                            int indexOf12 = str11.indexOf("FileType");
                                                            if (indexOf12 == 0) {
                                                                str7 = str11.substring(indexOf12 + 9);
                                                            } else if (str11.indexOf("UnionInfo") == 0) {
                                                                str8 = str11.substring(10);
                                                            } else if (str11.indexOf("DrmExpireTimestamp") == 0) {
                                                                str9 = str11.substring(19);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
        }
        sb.append(str);
        if (!TextUtils.isEmpty(str10)) {
            c = 0;
            sb.append(String.format("/%s", str10));
        } else {
            c = 0;
        }
        if (!TextUtils.isEmpty(str3)) {
            Object[] objArr = new Object[1];
            objArr[c] = str3;
            sb.append(String.format("/%s", objArr));
        }
        if (!TextUtils.isEmpty(str4)) {
            Object[] objArr2 = new Object[1];
            objArr2[c] = str4;
            sb.append(String.format("/%s", objArr2));
        }
        if (!TextUtils.isEmpty(str5)) {
            Object[] objArr3 = new Object[1];
            objArr3[c] = str5;
            sb.append(String.format("/%s", objArr3));
        }
        if (!TextUtils.isEmpty(str6)) {
            c2 = 0;
            sb.append(String.format("/%s", "hdr_" + str6));
        } else {
            c2 = 0;
        }
        if (!TextUtils.isEmpty(str7)) {
            Object[] objArr4 = new Object[1];
            objArr4[c2] = str7;
            sb.append(String.format("/%s", objArr4));
        }
        if (!TextUtils.isEmpty(str8)) {
            Object[] objArr5 = new Object[1];
            objArr5[c2] = str8;
            sb.append(String.format("/%s", objArr5));
        }
        if (!TextUtils.isEmpty(str9)) {
            Object[] objArr6 = new Object[1];
            objArr6[c2] = str9;
            sb.append(String.format("/%s", objArr6));
        }
        return sb.toString();
    }

    public synchronized void put(String str, String str2, VideoModel videoModel) {
        if (this.mVideoModelCache != null && str != null && str2 != null) {
            VideoModelCacheInfo videoModelCacheInfo = new VideoModelCacheInfo();
            videoModelCacheInfo.model = videoModel;
            videoModelCacheInfo.modelGotTime = SystemClock.elapsedRealtime();
            put(str, str2, videoModelCacheInfo);
        }
    }

    public synchronized void put(String str, String str2, VideoModelCacheInfo videoModelCacheInfo) {
        String videoModelCacheKey = getVideoModelCacheKey(str, str2);
        if (TextUtils.isEmpty(videoModelCacheKey)) {
            return;
        }
        this.mVideoModelCache.put(videoModelCacheKey, videoModelCacheInfo);
        if (this.mVideoModelCache.size() > mCacheNB) {
            long j = Long.MAX_VALUE;
            String str3 = null;
            for (Map.Entry<String, VideoModelCacheInfo> entry : this.mVideoModelCache.entrySet()) {
                long j2 = entry.getValue().modelGotTime;
                if (j2 < j) {
                    str3 = entry.getKey();
                    j = j2;
                }
            }
            if (str3 != null) {
                this.mVideoModelCache.remove(str3);
            }
        }
    }
}

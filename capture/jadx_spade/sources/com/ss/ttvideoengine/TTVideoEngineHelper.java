package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TTVideoEngineHelper {
    static {
        Covode.recordClassIndex(652333);
    }

    TTVideoEngineHelper() {
    }

    static boolean isMayUseP2P(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.d("TTVideoEngine", "url null, may not use p2p");
            return false;
        }
        if (!str.contains("http://127.0.0.1") && !str.contains("mdl://")) {
            TTVideoEngineLog.d("TTVideoEngine", "url not 127 or mdl protocol, may not use p2p");
            return false;
        }
        if (!str.contains("cdn_type")) {
            TTVideoEngineLog.d("TTVideoEngine", "url not contain cdntype, may not use p2p");
            return false;
        }
        TTVideoEngineLog.d("TTVideoEngine", "url  may use p2p");
        return true;
    }

    static Map<Integer, String> paramsFromVideoInfo(IVideoInfo iVideoInfo) {
        if (iVideoInfo == null || TextUtils.isEmpty(iVideoInfo.getValueStr(32))) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(32, iVideoInfo.getValueStr(32));
        return hashMap;
    }

    static IVideoInfo infoFromBitrate(IVideoModel iVideoModel, long j) {
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (j > 0 && videoInfoList != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && videoInfo.getMediatype() != VideoRef.TYPE_AUDIO && videoInfo.getResolution() != null && videoInfo.getValueInt(3) == j) {
                    return videoInfo;
                }
            }
        }
        return null;
    }
}

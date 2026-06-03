package xk6;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.model.VideoSeekTs;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    public static final h a;

    private h() {
    }

    static {
        Covode.recordClassIndex(655875);
        a = new h();
    }

    public final VideoModel b(String str) {
        try {
            VideoRef videoRef = new VideoRef();
            JSONObject jSONObject = new JSONObject(str);
            videoRef.extractFields(jSONObject);
            if (videoRef.getSeekTs() == null && jSONObject.has("seek_ts")) {
                VideoSeekTs videoSeekTs = new VideoSeekTs();
                videoRef.mSeekTs = videoSeekTs;
                videoSeekTs.extractFields(jSONObject.getJSONObject("seek_ts"));
            }
            VideoModel videoModel = new VideoModel();
            videoModel.setVideoRef(videoRef);
            return videoModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean d(VideoModel videoModel, VideoModel videoModel2) {
        if (videoModel == null || videoModel2 == null) {
            return false;
        }
        return videoModel.getVideoRefStr(2).equals(videoModel2.getVideoRefStr(2));
    }

    public final VideoModel c(String str, String str2) {
        boolean z;
        lk6.b bVar;
        ik6.a aVar;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z && (bVar = lk6.c.a) != null && (aVar = bVar.f) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("from", str2);
            aVar.onEvent("video_model_extract_fallback", jSONObject);
        }
        return b(str);
    }

    public final float a(PlayAddress playAddress, Resolution resolution) {
        float f;
        float f2;
        List<VideoInfo> list;
        List<VideoInfo> list2;
        VideoModel videoModel = playAddress.videoModel;
        if (videoModel == null) {
            videoModel = a.c(playAddress.playVideoModel, "getSourceLoudness");
        }
        float f3 = 0.0f;
        if (videoModel == null) {
            return 0.0f;
        }
        if (resolution == null) {
            resolution = Resolution.Auto;
        }
        VideoInfo videoInfo = videoModel.getVideoInfo(resolution, true);
        if (videoInfo != null) {
            f = videoInfo.mLoudness;
        } else {
            f = 0.0f;
        }
        if (f == 0.0f) {
            VideoRef videoRef = videoModel.getVideoRef();
            if (videoRef != null) {
                f2 = videoRef.mLoudness;
            } else {
                f2 = 0.0f;
            }
            if (f2 >= 0.0f && (list2 = videoModel.getVideoRef().mDynamicVideoList) != null) {
                for (VideoInfo videoInfo2 : list2) {
                    Intrinsics.checkExpressionValueIsNotNull(videoInfo2, "videoInfo");
                    if (videoInfo2.getResolution() == resolution) {
                        float f4 = videoInfo2.mLoudness;
                        if (f4 != 0.0f) {
                            f2 = f4;
                        }
                    }
                }
            }
            if (f2 >= 0.0f && (list = videoModel.getVideoRef().mOriginalAudioInfo) != null) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    float f5 = ((VideoInfo) it2.next()).mLoudness;
                    if (f5 != 0.0f) {
                        f2 = f5;
                    }
                }
                return f2;
            }
            return f2;
        }
        VideoInfo videoInfo3 = videoModel.getVideoInfo(resolution, true);
        if (videoInfo3 != null) {
            f3 = videoInfo3.mLoudness;
        }
        return f3;
    }
}

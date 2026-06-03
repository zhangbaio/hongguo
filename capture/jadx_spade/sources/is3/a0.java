package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 extends x {
    public static final int d;

    static {
        Covode.recordClassIndex(598934);
        d = 8;
    }

    public a0() {
        super(NsShortVideoApi.IMPL.autoPlaySeries().c());
    }

    @Override // is3.x
    public VideoInfo selectVideoInfoToPlay(VideoModel videoModel) {
        List<VideoInfo> videoInfoList;
        if (videoModel != null && (videoInfoList = videoModel.getVideoInfoList()) != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.getResolution() == Resolution.High) {
                    return videoInfo;
                }
            }
        }
        return super.selectVideoInfoToPlay(videoModel);
    }
}

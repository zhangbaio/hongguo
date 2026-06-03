package bo4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoRanklistLandingPageStyle;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(608994);
    }

    public static final VideoRanklistLandingPageStyle a(Integer num) {
        VideoRanklistLandingPageStyle videoRanklistLandingPageStyle;
        boolean z;
        VideoRanklistLandingPageStyle[] values = VideoRanklistLandingPageStyle.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i < length) {
                videoRanklistLandingPageStyle = values[i];
                int value = videoRanklistLandingPageStyle.getValue();
                if (num != null && value == num.intValue()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                i++;
            } else {
                videoRanklistLandingPageStyle = null;
                break;
            }
        }
        if (videoRanklistLandingPageStyle == null) {
            return VideoRanklistLandingPageStyle.Default;
        }
        return videoRanklistLandingPageStyle;
    }
}

package is3;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class y implements q {
    public static final int b;
    public s a;

    static {
        Covode.recordClassIndex(598932);
        b = 8;
    }

    public boolean interceptPlay(NetworkUtils.NetworkType networkType) {
        return false;
    }

    public boolean interceptPlayWhenVideoInfoReady(VideoRef videoRef) {
        return false;
    }

    public VideoInfo selectVideoInfoToPlay(VideoRef videoRef) {
        return null;
    }

    @Override // is3.q
    public void a(s sVar) {
        this.a = sVar;
    }
}

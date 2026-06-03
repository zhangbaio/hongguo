package is3;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x implements q {
    public static final int c;
    private final q a;
    private s b;

    static {
        Covode.recordClassIndex(598931);
        c = 8;
    }

    @Override // is3.q
    public void a(s sVar) {
        this.b = sVar;
        this.a.a(sVar);
    }

    public boolean interceptPlay(NetworkUtils.NetworkType networkType) {
        return this.a.interceptPlay(networkType);
    }

    public boolean interceptPlayWhenVideoInfoReady(VideoRef videoRef) {
        return this.a.interceptPlayWhenVideoInfoReady(videoRef);
    }

    public VideoInfo selectVideoInfoToPlay(VideoModel videoModel) {
        return this.a.selectVideoInfoToPlay(videoModel);
    }

    public x(q realProvider) {
        Intrinsics.checkNotNullParameter(realProvider, "realProvider");
        this.a = realProvider;
    }

    public VideoInfo selectVideoInfoToPlay(VideoRef videoRef) {
        return this.a.selectVideoInfoToPlay(videoRef);
    }
}

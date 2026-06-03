package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z implements s {
    public static final int b;
    private final SaasVideoData a;

    static {
        Covode.recordClassIndex(598933);
        b = 8;
    }

    @Override // is3.s
    public SaasVideoData getVideoData() {
        return this.a;
    }

    public z(SaasVideoData saasVideoData) {
        this.a = saasVideoData;
    }
}

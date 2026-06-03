package us4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.video.layer.AbsVideoPlayEventLayer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a extends com.dragon.read.video.layer.b {
    public static final int e;

    static {
        Covode.recordClassIndex(612507);
        e = com.dragon.read.video.layer.b.d;
    }

    public AbsVideoPlayEventLayer d() {
        boolean z = ((com.dragon.read.video.layer.b) this).b.getBoolean("disable_video_reporter", false);
        j jVar = new j();
        jVar.g = Boolean.valueOf(z);
        return jVar;
    }
}

package us4;

import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.template.VideoOpen;
import com.dragon.read.base.ssconfig.model.VideoEngineAutoResolution;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends ct5.a {
    public static final c b;
    public static final int c;

    static {
        Covode.recordClassIndex(612509);
        b = new c();
        c = ct5.a.a;
    }

    private c() {
    }

    public ct5.f a() {
        VideoOpen a = VideoOpen.a.a();
        return new ct5.f(a.enable, a.downgrade, a.scaleType, a.downgradeTimes);
    }

    public ct5.e b() {
        VideoEngineAutoResolution a = VideoEngineAutoResolution.a.a();
        return new ct5.e(a.enable, a.startTime, a.endTime, a.forceStartTime, a.forceEndTime, a.forceUseEnable, a.forceUseType);
    }
}

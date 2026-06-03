package zr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface r extends cr3.d, ar3.f {
    public static final /* synthetic */ int v6 = 0;

    static {
        Covode.recordClassIndex(598872);
    }

    void B();

    void C0(float f);

    boolean D0();

    void R(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData);

    void f0(float f, u uVar);

    void g0(boolean z, boolean z2);

    float getCurrentProgress();

    t getProgressHighlightDragInfo();

    f getSeekBar();

    void o0(boolean z);

    void onLoadingEnd();

    void setCallback(s sVar);

    void setHolderDepend(ar3.l lVar);

    void setInterceptPlay(boolean z);

    void setSeekBarChangeListener(o oVar);

    void setSeriesController(rq3.n nVar);

    void setVideoScene(int i);

    void z();
}

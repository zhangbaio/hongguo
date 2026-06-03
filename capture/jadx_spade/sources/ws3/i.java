package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesReturnVisitPrefetchOptABValue;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.impl.v2.data.b2;
import com.dragon.read.component.shortvideo.impl.v2.data.f3;
import k44.e0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;
    public static i b;

    private i() {
    }

    static {
        Covode.recordClassIndex(599159);
        i iVar = new i();
        a = iVar;
        b = iVar;
    }

    public final void a(ar3.j holderDataProvider, boolean z) {
        Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
        e0.a.d().insertVideoRecordOnPlay(holderDataProvider, z, true);
    }

    public final void b(ar3.j holderDataProvider, boolean z) {
        com.dragon.read.component.shortvideo.data.saas.video.d dataProvider;
        SaasVideoData videoData;
        Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
        e0 e0Var = e0.a;
        tq3.d.Q(e0Var.d(), holderDataProvider, z, false, 4, null);
        if (SeriesReturnVisitPrefetchOptABValue.a.a() && (dataProvider = holderDataProvider.getDataProvider()) != null && (videoData = dataProvider.getVideoData()) != null) {
            boolean A3 = e0Var.d().A3(videoData.getSeriesId(), videoData.getVid());
            pr3.r g0 = f3.f.b().g0(videoData.getVid(), false);
            if (!A3 && g0 != null) {
                b2.a.l(g0);
            }
        }
    }

    public final void d(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, long j, long j2) {
        e0.a.d().w1(saasVideoDetailModel, saasVideoData, j, j2);
    }

    public final void c(String str, String str2, int i, long j, long j2, int i2, long j3) {
        e0.a.d().updateVideoRecordPlayProgress(str, str2, i, j, j2, i2, j3);
    }
}

package tq3;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.utils.Error;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface x extends lq3.a {
    public static final /* synthetic */ int b = 0;

    static {
        Covode.recordClassIndex(598645);
    }

    void A0(rq3.n nVar);

    void A4(rq3.n nVar);

    void B(ar3.j jVar, long j, VideoContentType videoContentType, int i, ar3.l lVar);

    void B0(SaasVideoData saasVideoData, boolean z, s sVar);

    void B3(rq3.n nVar);

    void C2(float f, rq3.n nVar);

    void C3(SaasVideoData saasVideoData, s sVar, boolean z);

    void C4(com.dragon.read.component.shortvideo.data.saas.video.d dVar, s sVar, boolean z);

    void E0(AbsRecyclerViewHolder<?> absRecyclerViewHolder, rq3.n nVar);

    void G2(Configuration configuration, rq3.n nVar);

    void H0(AbsRecyclerViewHolder<?> absRecyclerViewHolder, rq3.n nVar);

    void H1(rq3.n nVar, String str);

    void I1(int i, int i2, rq3.n nVar);

    void I3(rq3.n nVar);

    void K4(rq3.n nVar);

    void L0(rq3.n nVar);

    void N(rq3.n nVar, boolean z, Activity activity);

    void N2(SaasVideoDetailModel saasVideoDetailModel, rq3.n nVar);

    void O4(boolean z, Activity activity);

    void P0(SaasVideoData saasVideoData, Integer num);

    void Q2(rq3.n nVar, int i);

    void Q4(rq3.n nVar);

    Resources R0(Resources resources, rq3.n nVar);

    void R2(int i, rq3.n nVar);

    void S2(int i);

    boolean S4(rq3.n nVar, Resolution resolution, Resolution resolution2);

    void U(rq3.n nVar);

    void U1(rq3.n nVar);

    boolean V(AbsRecyclerViewHolder<?> absRecyclerViewHolder, boolean z, boolean z2);

    boolean V1(int i, String str, RelativeLayout relativeLayout, Function0<Unit> function0);

    void Z0(Activity activity, boolean z);

    void a(String str, boolean z);

    void d(String str, Error error);

    void d0(SaasVideoDetailModel saasVideoDetailModel);

    void d1(FrameLayout frameLayout, rq3.n nVar);

    void h0(rq3.n nVar);

    void i0(int i);

    boolean k4(Context context);

    void m0(rq3.n nVar);

    void m1(String str, List<? extends SaasVideoData> list, boolean z);

    void n2(String str, String str2);

    void o(String str, ar3.l lVar);

    void q1(rq3.n nVar);

    void r2(rq3.n nVar);

    void t2(String str, String str2);

    void u1(SaasVideoData saasVideoData, int i, int i2);

    void v1(com.dragon.read.component.shortvideo.data.saas.video.d dVar, s sVar, boolean z);

    AssetManager v4(AssetManager assetManager, rq3.n nVar);

    void w();

    void w0(rq3.n nVar);

    void w2(SaasVideoDetailModel saasVideoDetailModel);

    boolean y1(Context context);

    Pair<Context, Runnable> y2(Context context, rq3.n nVar);

    rq3.n z4(Context context);
}

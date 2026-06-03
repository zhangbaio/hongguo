package tq3;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ssconfig.CenterAnimationResConfigsWrap;
import com.dragon.read.component.shortvideo.api.datacenter.AbsSeriesDataCenter;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e extends lq3.a {
    public static final /* synthetic */ int a = 0;

    static {
        Covode.recordClassIndex(598629);
    }

    boolean A3(String str, String str2);

    long B1();

    String F();

    long F1();

    ct3.a F4();

    String J0();

    List<Class<? extends com.dragon.read.component.shortvideo.data.saas.video.d>> L4();

    void M2(SaasVideoData saasVideoData);

    boolean O0();

    gs3.a P(Context context);

    gt3.b T0();

    void T2();

    dt3.a U0();

    Map<String, Object> W(SaasVideoData saasVideoData);

    ys3.b Y();

    nq3.b Z();

    void a1();

    AbsSeriesDataCenter<DataSource> a2(rq3.n nVar);

    et3.b a3();

    void c();

    bt3.c c2();

    boolean e(String str);

    gt3.a e1();

    et3.a e2();

    boolean f2(String str, String str2);

    i g1();

    void g3(SimpleDraweeView simpleDraweeView, String str, ScalingUtils.ScaleType scaleType);

    String getToken();

    void h(String str, String str2);

    a0 h3();

    CenterAnimationResConfigsWrap h4();

    long i(String str, String str2);

    void insertVideoRecordOnPause(ar3.j jVar);

    void insertVideoRecordOnPlay(ar3.j jVar, boolean z, boolean z2);

    boolean j(String str, String str2);

    c j2();

    ft3.b j4();

    boolean k2(String str);

    boolean k3(Activity activity, com.dragon.read.component.shortvideo.data.saas.video.d dVar, rq3.n nVar);

    ss3.a l0();

    kr3.a m();

    Pair<String, String> o0(SaasVideoDetailModel saasVideoDetailModel);

    void o3(String str);

    boolean onShortSeriesAttribution();

    DataSource q0(int i);

    r s0();

    ys3.c s2();

    HashMap<String, Object> t1(String str);

    boolean u(String str, String str2, Context context);

    void updateVideoRecordPlayProgress(String str, String str2, int i, long j, long j2, int i2, long j3);

    int v0();

    void w1(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, long j, long j2);

    void x0();

    boolean x3();

    mr3.a y0();

    jr3.a z0(Context context, LifecycleOwner lifecycleOwner, ViewGroup viewGroup, Observable<Integer> observable, Observable<Boolean> observable2);
}

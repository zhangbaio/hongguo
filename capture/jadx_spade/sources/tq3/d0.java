package tq3;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.dragon.read.asyncinflate.PreloadViewInfo;
import com.dragon.read.base.util.callback.Callback;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesRelativeSeriesModel;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.List;
import java.util.Map;
import pq3.n0;
import seriessdk.com.dragon.read.saas.rpc.model.Celebrity;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface d0 extends lq3.a {
    View E3(Context context);

    int G0();

    cr3.b H2(Context context, rq3.n nVar, SaasVideoData saasVideoData);

    e0 H3(Context context, int i);

    bs3.e H4(Context context);

    int J4();

    Map<Class<?>, xq3.c> K2(rq3.n nVar);

    cr3.g M();

    int M3();

    cr3.b M4(Context context, rq3.n nVar, SaasVideoData saasVideoData);

    zr3.a O1();

    bs3.b Q0(Context context);

    dr3.b Q3(Context context);

    Class<? extends Fragment> U3(Context context);

    e0 V0(Context context);

    e0 V2(Context context, int i);

    e0 X1(Context context, int i);

    int Y0();

    LinearLayout Y2(Context context);

    e0 Y4(Context context, int i);

    e0 Z2(Context context, int i, ar3.l lVar);

    es3.a Z4(Context context, es3.b bVar);

    e0 b(Context context);

    Map<Integer, PreloadViewInfo> b0();

    void d3(FrameLayout frameLayout);

    dr3.a e3(Context context);

    zr3.b e4(zr3.f fVar, zr3.o oVar, View view, n0 n0Var, boolean z, boolean z2);

    Map<Class<?>, zq3.c> f0(rq3.n nVar);

    boolean f3();

    View g0(Context context);

    int h2();

    zr3.k i1();

    int i2();

    TextView k1(Context context, rq3.n nVar, Callback callback);

    View m2(Context context, View view, SaasVideoData saasVideoData, List<? extends Celebrity> list, int i, float f, int i2, String str);

    e0 m3(Context context);

    boolean n0();

    e0 p1(Context context, ShortSeriesRelativeSeriesModel shortSeriesRelativeSeriesModel, boolean z);

    TextView p2(Context context, rq3.n nVar, Callback callback);

    int q3();

    b0 r();

    int r3();

    e0 r4(Context context, int i);

    cr3.f u2(Context context);

    View x(Context context);

    int x4();

    ds3.c y(Context context);

    e0 z1(Context context);
}

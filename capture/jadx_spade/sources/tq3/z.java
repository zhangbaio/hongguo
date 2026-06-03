package tq3;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.api.model.SeriesEndRecData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.report.PageRecorder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface z extends lq3.a {
    void B2();

    void D1(int i, boolean z, long j);

    void F0(boolean z, rq3.n nVar);

    void F2(SaasVideoData saasVideoData, s sVar, boolean z);

    void I(rq3.n nVar);

    void I4(String str, int i, rq3.n nVar);

    void J1(MotionEvent motionEvent);

    void J2();

    void K0(boolean z);

    void L1(SeriesEndRecData seriesEndRecData, int i, com.dragon.read.component.shortvideo.data.saas.video.d dVar, View view);

    void N3(String str, com.dragon.read.component.shortvideo.data.saas.video.d dVar, PageRecorder pageRecorder, Args args);

    void O3(SeriesEndRecData seriesEndRecData, int i, com.dragon.read.component.shortvideo.data.saas.video.d dVar);

    void P2(Context context, View view);

    void T1(boolean z);

    void U2(rq3.g gVar);

    void W2(boolean z);

    void W4();

    void X2(Context context, String str, boolean z, cs3.a aVar, String str2);

    void a0(boolean z);

    void b2(String str, rq3.n nVar);

    void b4(String str, com.dragon.read.component.shortvideo.data.saas.video.d dVar, PageRecorder pageRecorder, Args args);

    void c0();

    boolean c1(rq3.n nVar);

    void clearDraftCache(Context context);

    void f1(Context context, View view);

    boolean g2(rq3.n nVar, rq3.g gVar);

    boolean i3(rq3.g gVar, rq3.e eVar, Activity activity, rq3.j jVar);

    void k();

    boolean o2(rq3.n nVar);

    void q(MotionEvent motionEvent);

    void w4(rq3.n nVar);

    void z(SaasVideoData saasVideoData, s sVar, boolean z);
}

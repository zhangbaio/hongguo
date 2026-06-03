package fr3;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import tq3.s;
import tq3.w;
import tq3.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m implements x {
    static {
        Covode.recordClassIndex(598728);
    }

    @Override // tq3.x
    public /* synthetic */ void A0(rq3.n nVar) {
        w.z(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void A4(rq3.n nVar) {
        w.l(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void B(ar3.j jVar, long j, VideoContentType videoContentType, int i, ar3.l lVar) {
        w.W(this, jVar, j, videoContentType, i, lVar);
    }

    @Override // tq3.x
    public /* synthetic */ void B0(SaasVideoData saasVideoData, boolean z, s sVar) {
        w.w(this, saasVideoData, z, sVar);
    }

    @Override // tq3.x
    public void B3(rq3.n nVar) {
    }

    @Override // tq3.x
    public /* synthetic */ void C2(float f, rq3.n nVar) {
        w.x(this, f, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void C3(SaasVideoData saasVideoData, s sVar, boolean z) {
        w.M(this, saasVideoData, sVar, z);
    }

    @Override // tq3.x
    public /* synthetic */ void C4(com.dragon.read.component.shortvideo.data.saas.video.d dVar, s sVar, boolean z) {
        w.Q(this, dVar, sVar, z);
    }

    @Override // tq3.x
    public /* synthetic */ void E0(AbsRecyclerViewHolder absRecyclerViewHolder, rq3.n nVar) {
        w.O(this, absRecyclerViewHolder, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void G2(Configuration configuration, rq3.n nVar) {
        w.o(this, configuration, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void H0(AbsRecyclerViewHolder absRecyclerViewHolder, rq3.n nVar) {
        w.N(this, absRecyclerViewHolder, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void H1(rq3.n nVar, String str) {
        w.J(this, nVar, str);
    }

    @Override // tq3.x
    public /* synthetic */ void I1(int i, int i2, rq3.n nVar) {
        w.H(this, i, i2, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void I3(rq3.n nVar) {
        w.k(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void K4(rq3.n nVar) {
        w.p(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void L0(rq3.n nVar) {
        w.h(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void N(rq3.n nVar, boolean z, Activity activity) {
        w.D(this, nVar, z, activity);
    }

    @Override // tq3.x
    public /* synthetic */ void N2(SaasVideoDetailModel saasVideoDetailModel, rq3.n nVar) {
        w.L(this, saasVideoDetailModel, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void O4(boolean z, Activity activity) {
        w.F(this, z, activity);
    }

    @Override // tq3.x
    public /* synthetic */ void P0(SaasVideoData saasVideoData, Integer num) {
        w.I(this, saasVideoData, num);
    }

    @Override // tq3.x
    public /* synthetic */ void Q2(rq3.n nVar, int i) {
        w.R(this, nVar, i);
    }

    @Override // tq3.x
    public /* synthetic */ void Q4(rq3.n nVar) {
        w.y(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ Resources R0(Resources resources, rq3.n nVar) {
        return w.b(this, resources, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void R2(int i, rq3.n nVar) {
        w.X(this, i, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void S2(int i) {
        w.G(this, i);
    }

    @Override // tq3.x
    public /* synthetic */ boolean S4(rq3.n nVar, Resolution resolution, Resolution resolution2) {
        return w.K(this, nVar, resolution, resolution2);
    }

    @Override // tq3.x
    public /* synthetic */ void U(rq3.n nVar) {
        w.n(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void U1(rq3.n nVar) {
        w.j(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ boolean V(AbsRecyclerViewHolder absRecyclerViewHolder, boolean z, boolean z2) {
        return w.E(this, absRecyclerViewHolder, z, z2);
    }

    @Override // tq3.x
    public /* synthetic */ boolean V1(int i, String str, RelativeLayout relativeLayout, Function0 function0) {
        return w.d(this, i, str, relativeLayout, function0);
    }

    @Override // tq3.x
    public /* synthetic */ void Z0(Activity activity, boolean z) {
        w.u(this, activity, z);
    }

    @Override // tq3.x
    public /* synthetic */ void a(String str, boolean z) {
        w.S(this, str, z);
    }

    @Override // tq3.x
    public /* synthetic */ void d(String str, Error error) {
        w.U(this, str, error);
    }

    @Override // tq3.x
    public void d0(SaasVideoDetailModel videoDetailModel) {
        Intrinsics.checkNotNullParameter(videoDetailModel, "videoDetailModel");
    }

    @Override // tq3.x
    public /* synthetic */ void d1(FrameLayout frameLayout, rq3.n nVar) {
        w.r(this, frameLayout, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void h0(rq3.n nVar) {
        w.t(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void i0(int i) {
        w.T(this, i);
    }

    @Override // tq3.x
    public /* synthetic */ boolean k4(Context context) {
        return w.f(this, context);
    }

    @Override // tq3.x
    public /* synthetic */ void m0(rq3.n nVar) {
        w.i(this, nVar);
    }

    @Override // tq3.x
    public void m1(String episodeId, List<? extends SaasVideoData> episodeList, boolean z) {
        Intrinsics.checkNotNullParameter(episodeId, "episodeId");
        Intrinsics.checkNotNullParameter(episodeList, "episodeList");
    }

    @Override // tq3.x
    public /* synthetic */ void n2(String str, String str2) {
        w.B(this, str, str2);
    }

    @Override // tq3.x
    public /* synthetic */ void o(String str, ar3.l lVar) {
        w.V(this, str, lVar);
    }

    @Override // tq3.x
    public /* synthetic */ void q1(rq3.n nVar) {
        w.q(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void r2(rq3.n nVar) {
        w.m(this, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void t2(String str, String str2) {
        w.C(this, str, str2);
    }

    @Override // tq3.x
    public /* synthetic */ void u1(SaasVideoData saasVideoData, int i, int i2) {
        w.s(this, saasVideoData, i, i2);
    }

    @Override // tq3.x
    public /* synthetic */ void v1(com.dragon.read.component.shortvideo.data.saas.video.d dVar, s sVar, boolean z) {
        w.P(this, dVar, sVar, z);
    }

    @Override // tq3.x
    public /* synthetic */ AssetManager v4(AssetManager assetManager, rq3.n nVar) {
        return w.a(this, assetManager, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ void w() {
        w.v(this);
    }

    @Override // tq3.x
    public /* synthetic */ void w0(rq3.n nVar) {
        w.Y(this, nVar);
    }

    @Override // tq3.x
    public void w2(SaasVideoDetailModel videoDetailModel) {
        Intrinsics.checkNotNullParameter(videoDetailModel, "videoDetailModel");
    }

    @Override // tq3.x
    public /* synthetic */ boolean y1(Context context) {
        return w.e(this, context);
    }

    @Override // tq3.x
    public /* synthetic */ Pair y2(Context context, rq3.n nVar) {
        return w.g(this, context, nVar);
    }

    @Override // tq3.x
    public /* synthetic */ rq3.n z4(Context context) {
        return w.c(this, context);
    }
}

package fr3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.api.config.ssconfig.CenterAnimationResConfigsWrap;
import com.dragon.read.component.shortvideo.api.datacenter.AbsSeriesDataCenter;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import com.dragon.read.report.PageRecorder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPayInfo;
import tq3.a0;
import tq3.i;
import tq3.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements tq3.e {

    public static final class a implements tq3.i {
        a() {
        }

        @Override // tq3.i
        public void T3(i.a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // tq3.i
        public void V4(i.a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    public static final class b implements et3.a {
        b() {
        }

        @Override // et3.a
        public void a(String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }

        @Override // et3.a
        public void b(String scene, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }

        @Override // et3.a
        public void c(String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }

        @Override // et3.a
        public void d(String scene, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }

        @Override // et3.a
        public void e(String str, String str2) {
        }

        @Override // et3.a
        public void f(String scene, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }

        @Override // et3.a
        public void g(int i, String scene, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }
    }

    /* renamed from: fr3.d$d, reason: collision with other inner class name */
    public static final class C0157d implements gt3.a {
        C0157d() {
        }

        @Override // gt3.a
        public void a() {
        }

        @Override // gt3.a
        public void b(Function1<? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    public static final class e implements gt3.b {
        e() {
        }

        @Override // gt3.b
        public VideoPayInfo a(String str) {
            return null;
        }

        @Override // gt3.b
        public Boolean b(String str) {
            return null;
        }

        @Override // gt3.b
        public boolean c(String str) {
            return false;
        }

        @Override // gt3.b
        public Long d(String str) {
            return null;
        }

        @Override // gt3.b
        public Drawable e(VideoPayInfo videoPayInfo) {
            return null;
        }

        @Override // gt3.b
        public boolean f(SaasVideoDetailModel saasVideoDetailModel, SaasVideoDetailModel videoDetailModel) {
            Intrinsics.checkNotNullParameter(videoDetailModel, "videoDetailModel");
            return false;
        }
    }

    static {
        Covode.recordClassIndex(598719);
    }

    @Override // tq3.e
    public /* synthetic */ boolean A3(String str, String str2) {
        return tq3.d.D(this, str, str2);
    }

    @Override // tq3.e
    public /* synthetic */ long B1() {
        return tq3.d.b(this);
    }

    @Override // tq3.e
    public /* synthetic */ String F() {
        return tq3.d.g(this);
    }

    @Override // tq3.e
    public /* synthetic */ long F1() {
        return tq3.d.r(this);
    }

    @Override // tq3.e
    public /* synthetic */ ct3.a F4() {
        return tq3.d.e(this);
    }

    @Override // tq3.e
    public String J0() {
        return "";
    }

    @Override // tq3.e
    public /* synthetic */ List L4() {
        return tq3.d.k(this);
    }

    @Override // tq3.e
    public /* synthetic */ void M2(SaasVideoData saasVideoData) {
        tq3.d.O(this, saasVideoData);
    }

    @Override // tq3.e
    public /* synthetic */ boolean O0() {
        return tq3.d.F(this);
    }

    @Override // tq3.e
    public /* synthetic */ gs3.a P(Context context) {
        return tq3.d.f(this, context);
    }

    @Override // tq3.e
    public void T2() {
    }

    @Override // tq3.e
    public /* synthetic */ dt3.a U0() {
        return tq3.d.y(this);
    }

    @Override // tq3.e
    public /* synthetic */ Map W(SaasVideoData saasVideoData) {
        return tq3.d.w(this, saasVideoData);
    }

    @Override // tq3.e
    public /* synthetic */ ys3.b Y() {
        return tq3.d.a(this);
    }

    @Override // tq3.e
    public /* synthetic */ nq3.b Z() {
        return tq3.d.v(this);
    }

    @Override // tq3.e
    public void a1() {
    }

    @Override // tq3.e
    public /* synthetic */ AbsSeriesDataCenter a2(rq3.n nVar) {
        return tq3.d.o(this, nVar);
    }

    @Override // tq3.e
    public /* synthetic */ void c() {
        tq3.d.M(this);
    }

    @Override // tq3.e
    public /* synthetic */ boolean e(String str) {
        return tq3.d.G(this, str);
    }

    @Override // tq3.e
    public /* synthetic */ boolean f2(String str, String str2) {
        return tq3.d.B(this, str, str2);
    }

    @Override // tq3.e
    public void g3(SimpleDraweeView simpleDraweeView, String str, ScalingUtils.ScaleType scaleType) {
    }

    @Override // tq3.e
    public /* synthetic */ String getToken() {
        return tq3.d.s(this);
    }

    @Override // tq3.e
    public /* synthetic */ void h(String str, String str2) {
        tq3.d.L(this, str, str2);
    }

    @Override // tq3.e
    public /* synthetic */ a0 h3() {
        return tq3.d.u(this);
    }

    @Override // tq3.e
    public /* synthetic */ CenterAnimationResConfigsWrap h4() {
        return tq3.d.d(this);
    }

    @Override // tq3.e
    public /* synthetic */ long i(String str, String str2) {
        return tq3.d.t(this, str, str2);
    }

    @Override // tq3.e
    public /* synthetic */ void insertVideoRecordOnPause(ar3.j jVar) {
        tq3.d.z(this, jVar);
    }

    @Override // tq3.e
    public /* synthetic */ void insertVideoRecordOnPlay(ar3.j jVar, boolean z, boolean z2) {
        tq3.d.A(this, jVar, z, z2);
    }

    @Override // tq3.e
    public /* synthetic */ boolean j(String str, String str2) {
        return tq3.d.E(this, str, str2);
    }

    @Override // tq3.e
    public /* synthetic */ tq3.c j2() {
        return tq3.d.j(this);
    }

    @Override // tq3.e
    public /* synthetic */ boolean k2(String str) {
        return tq3.d.I(this, str);
    }

    @Override // tq3.e
    public /* synthetic */ boolean k3(Activity activity, com.dragon.read.component.shortvideo.data.saas.video.d dVar, rq3.n nVar) {
        return tq3.d.C(this, activity, dVar, nVar);
    }

    @Override // tq3.e
    public /* synthetic */ ss3.a l0() {
        return tq3.d.p(this);
    }

    @Override // tq3.e
    public /* synthetic */ kr3.a m() {
        return tq3.d.x(this);
    }

    @Override // tq3.e
    public /* synthetic */ Pair o0(SaasVideoDetailModel saasVideoDetailModel) {
        return tq3.d.h(this, saasVideoDetailModel);
    }

    @Override // tq3.e
    public /* synthetic */ void o3(String str) {
        tq3.d.N(this, str);
    }

    @Override // tq3.e
    public boolean onShortSeriesAttribution() {
        return false;
    }

    @Override // tq3.e
    public /* synthetic */ DataSource q0(int i) {
        return tq3.d.n(this, i);
    }

    @Override // tq3.e
    public /* synthetic */ r s0() {
        return tq3.d.q(this);
    }

    @Override // tq3.e
    public /* synthetic */ ys3.c s2() {
        return tq3.d.c(this);
    }

    @Override // tq3.e
    public /* synthetic */ boolean u(String str, String str2, Context context) {
        return tq3.d.H(this, str, str2, context);
    }

    @Override // tq3.e
    public void updateVideoRecordPlayProgress(String str, String str2, int i, long j, long j2, int i2, long j3) {
    }

    @Override // tq3.e
    public /* synthetic */ int v0() {
        return tq3.d.i(this);
    }

    @Override // tq3.e
    public /* synthetic */ void w1(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, long j, long j2) {
        tq3.d.P(this, saasVideoDetailModel, saasVideoData, j, j2);
    }

    @Override // tq3.e
    public /* synthetic */ void x0() {
        tq3.d.K(this);
    }

    @Override // tq3.e
    public /* synthetic */ boolean x3() {
        return tq3.d.J(this);
    }

    @Override // tq3.e
    public /* synthetic */ mr3.a y0() {
        return tq3.d.m(this);
    }

    @Override // tq3.e
    public /* synthetic */ jr3.a z0(Context context, LifecycleOwner lifecycleOwner, ViewGroup viewGroup, Observable observable, Observable observable2) {
        return tq3.d.l(this, context, lifecycleOwner, viewGroup, observable, observable2);
    }

    public static final class c implements et3.b {

        public static final class b implements vr3.c {
            b() {
            }

            @Override // vr3.c
            public vr3.c a(int i) {
                return this;
            }

            @Override // vr3.c
            public String b() {
                return null;
            }

            @Override // vr3.c
            public vr3.c d(String str) {
                return this;
            }

            @Override // vr3.c
            public vr3.c e(String str) {
                return this;
            }

            @Override // vr3.c
            public vr3.c f(boolean z) {
                return this;
            }

            @Override // vr3.c
            public vr3.c g(Object obj) {
                return this;
            }

            @Override // vr3.c
            public int getEnterFrom() {
                return 1;
            }

            @Override // vr3.c
            public String getPosition() {
                return null;
            }

            @Override // vr3.c
            public void h(int i) {
            }

            @Override // vr3.c
            public vr3.c i(boolean z) {
                return this;
            }

            @Override // vr3.c
            public String j() {
                return null;
            }

            @Override // vr3.c
            public int k() {
                return 0;
            }

            @Override // vr3.c
            public vr3.c l(int i) {
                return this;
            }

            @Override // vr3.c
            public vr3.c m(int i) {
                return this;
            }

            @Override // vr3.c
            public String n() {
                return null;
            }

            @Override // vr3.c
            public String o() {
                return "";
            }

            @Override // vr3.c
            public boolean p() {
                return false;
            }

            @Override // vr3.c
            public String q(int i) {
                return null;
            }

            @Override // vr3.c
            public int r() {
                return 0;
            }

            @Override // vr3.c
            public vr3.c s(String str) {
                return this;
            }

            @Override // vr3.c
            public vr3.c setPageName(String str) {
                return this;
            }

            @Override // vr3.c
            public vr3.c setPosition(String str) {
                return this;
            }

            @Override // vr3.c
            public String t(int i) {
                return null;
            }

            @Override // vr3.c
            public vr3.c u(String str) {
                return this;
            }

            @Override // vr3.c
            public String v() {
                return null;
            }

            @Override // vr3.c
            public vr3.c w(int i, String filterType) {
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                return this;
            }

            @Override // vr3.c
            public vr3.c x(int i, String filterTagNames) {
                Intrinsics.checkNotNullParameter(filterTagNames, "filterTagNames");
                return this;
            }
        }

        c() {
        }

        @Override // et3.b
        public void onReport(String event, Args args) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(args, "args");
        }

        @Override // et3.b
        public void onReport(String event, JSONObject params) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
        }

        public static final class a implements vr3.e {
            a() {
            }

            @Override // vr3.e
            public vr3.e A(String str) {
                return this;
            }

            @Override // vr3.e
            public void B() {
            }

            @Override // vr3.e
            public void B0() {
            }

            @Override // vr3.e
            public vr3.e C(PageRecorder pageRecorder) {
                return this;
            }

            @Override // vr3.e
            public void C0(JSONObject param) {
                Intrinsics.checkNotNullParameter(param, "param");
            }

            @Override // vr3.e
            public String D() {
                return "";
            }

            @Override // vr3.e
            public vr3.e D0(String feedType) {
                Intrinsics.checkNotNullParameter(feedType, "feedType");
                return this;
            }

            @Override // vr3.e
            public void E() {
            }

            @Override // vr3.e
            public vr3.e E0(PageRecorder pageRecorder) {
                return this;
            }

            @Override // vr3.e
            public void F() {
            }

            @Override // vr3.e
            public void F0(Args args) {
            }

            @Override // vr3.e
            public vr3.e G(String str) {
                return this;
            }

            @Override // vr3.e
            public /* synthetic */ vr3.e G0(AlbumDetailModel albumDetailModel) {
                return vr3.d.a(this, albumDetailModel);
            }

            @Override // vr3.e
            public void H(boolean z) {
            }

            @Override // vr3.e
            public vr3.e H0(int i) {
                return this;
            }

            @Override // vr3.e
            public vr3.e I(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e I0(String str) {
                return this;
            }

            @Override // vr3.e
            public void J() {
            }

            @Override // vr3.e
            public void J0() {
            }

            @Override // vr3.e
            public void K() {
            }

            @Override // vr3.e
            public vr3.e K0() {
                return this;
            }

            @Override // vr3.e
            public /* synthetic */ vr3.e L(boolean z) {
                return vr3.d.d(this, z);
            }

            @Override // vr3.e
            public vr3.e L0(float f) {
                return this;
            }

            @Override // vr3.e
            public void M() {
            }

            @Override // vr3.e
            public /* synthetic */ vr3.e M0(SaaSUgcPostData saaSUgcPostData) {
                return vr3.d.e(this, saaSUgcPostData);
            }

            @Override // vr3.e
            public void N() {
            }

            @Override // vr3.e
            public void N0() {
            }

            @Override // vr3.e
            public vr3.e O(JSONObject param) {
                Intrinsics.checkNotNullParameter(param, "param");
                return this;
            }

            @Override // vr3.e
            public vr3.e O0() {
                return this;
            }

            @Override // vr3.e
            public vr3.e P0(String str) {
                return this;
            }

            @Override // vr3.e
            public void Q() {
            }

            @Override // vr3.e
            public vr3.e Q0(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e R() {
                return this;
            }

            @Override // vr3.e
            public void R0(Args args) {
            }

            @Override // vr3.e
            public vr3.e S(int i) {
                return this;
            }

            @Override // vr3.e
            public void S0(boolean z) {
            }

            @Override // vr3.e
            public void T(Args args) {
            }

            @Override // vr3.e
            public void T0(Args args) {
            }

            @Override // vr3.e
            public vr3.e U(Serializable percent) {
                Intrinsics.checkNotNullParameter(percent, "percent");
                return this;
            }

            @Override // vr3.e
            public vr3.e U0() {
                return this;
            }

            @Override // vr3.e
            public void V() {
            }

            @Override // vr3.e
            /* renamed from: V0, reason: merged with bridge method [inline-methods] */
            public a m0(String str) {
                return this;
            }

            @Override // vr3.e
            public /* synthetic */ vr3.e W(SaasVideoData saasVideoData) {
                return vr3.d.c(this, saasVideoData);
            }

            @Override // vr3.e
            public vr3.e X(int i) {
                return this;
            }

            @Override // vr3.e
            public vr3.e Y(String str) {
                return this;
            }

            @Override // vr3.e
            public void Z() {
            }

            @Override // vr3.e
            public vr3.e a(int i) {
                return this;
            }

            @Override // vr3.e
            public vr3.e a0(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e b(String event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return this;
            }

            @Override // vr3.e
            public void b0() {
            }

            @Override // vr3.e
            public vr3.e c(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e c0(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e d(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e d0(int i) {
                return this;
            }

            @Override // vr3.e
            public vr3.e e(String str) {
                return this;
            }

            @Override // vr3.e
            public void e0(Args args) {
            }

            @Override // vr3.e
            public vr3.e f(boolean z) {
                return this;
            }

            @Override // vr3.e
            public vr3.e f0(SaasVideoData saasVideoData) {
                return this;
            }

            @Override // vr3.e
            public vr3.e g(int i) {
                return this;
            }

            @Override // vr3.e
            public void g0() {
            }

            @Override // vr3.e
            public long getStartTime() {
                return 0L;
            }

            @Override // vr3.e
            public Object h(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return null;
            }

            @Override // vr3.e
            public vr3.e h0() {
                return this;
            }

            @Override // vr3.e
            public vr3.e i(String str) {
                return this;
            }

            @Override // vr3.e
            public void i0(boolean z, Args args) {
            }

            @Override // vr3.e
            public void j() {
            }

            @Override // vr3.e
            public void j0() {
            }

            @Override // vr3.e
            public vr3.e k(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e k0(String status) {
                Intrinsics.checkNotNullParameter(status, "status");
                return this;
            }

            @Override // vr3.e
            public vr3.e l(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e l0(String str) {
                return this;
            }

            @Override // vr3.e
            public void m() {
            }

            @Override // vr3.e
            public vr3.e n(int i) {
                return this;
            }

            @Override // vr3.e
            public void n0() {
            }

            @Override // vr3.e
            public vr3.e o(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e o0(String feedType) {
                Intrinsics.checkNotNullParameter(feedType, "feedType");
                return this;
            }

            @Override // vr3.e
            public vr3.e p() {
                return this;
            }

            @Override // vr3.e
            public vr3.e p0(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e q(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e q0(Args args) {
                return this;
            }

            @Override // vr3.e
            public vr3.e r(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e r0() {
                return this;
            }

            @Override // vr3.e
            public vr3.e removeParam(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return this;
            }

            @Override // vr3.e
            public void s() {
            }

            @Override // vr3.e
            public vr3.e s0(String str, Integer num) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setButtonName(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setClickTo(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setEnterFrom(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setModuleName(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setPageName(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setPosition(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setProfileUserId(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setRecommendInfo(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e setResult(Serializable serializable) {
                return this;
            }

            @Override // vr3.e
            public vr3.e t(long j) {
                return this;
            }

            @Override // vr3.e
            public void t0(Args args) {
            }

            @Override // vr3.e
            public vr3.e u(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e u0(String direction) {
                Intrinsics.checkNotNullParameter(direction, "direction");
                return this;
            }

            @Override // vr3.e
            public vr3.e v(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e v0(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e w(String forceReportEnterFrom) {
                Intrinsics.checkNotNullParameter(forceReportEnterFrom, "forceReportEnterFrom");
                return this;
            }

            @Override // vr3.e
            public void w0() {
            }

            @Override // vr3.e
            public vr3.e x(String str) {
                return this;
            }

            @Override // vr3.e
            public vr3.e x0(SecondaryInfo secondaryInfo) {
                return this;
            }

            @Override // vr3.e
            public void y() {
            }

            @Override // vr3.e
            public /* synthetic */ vr3.e y0(Serializable serializable) {
                return vr3.d.b(this, serializable);
            }

            @Override // vr3.e
            public vr3.e z() {
                return this;
            }

            @Override // vr3.e
            public vr3.e z0() {
                return this;
            }

            @Override // vr3.e
            public Map<String, Object> A0() {
                return new LinkedHashMap();
            }

            @Override // vr3.e
            public JSONObject getReportParams() {
                return new JSONObject();
            }

            @Override // vr3.e
            public void P() {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        }

        @Override // et3.b
        public vr3.c a() {
            return new b();
        }

        @Override // et3.b
        public vr3.e b() {
            return new a();
        }
    }

    public static final class g implements bt3.c {
        g() {
        }

        @Override // bt3.c
        public boolean a(String str) {
            return false;
        }

        @Override // bt3.c
        public void b() {
        }

        @Override // bt3.c
        public void c(bt3.a aVar) {
        }

        @Override // bt3.c
        public void d(bt3.a aVar) {
        }

        @Override // bt3.c
        public void e(oq3.a aVar) {
        }

        @Override // bt3.c
        public /* synthetic */ boolean f(com.dragon.read.component.shortvideo.data.saas.video.d dVar) {
            return bt3.b.b(this, dVar);
        }

        @Override // bt3.c
        public /* synthetic */ boolean g() {
            return bt3.b.c(this);
        }

        @Override // bt3.c
        public /* synthetic */ boolean h(com.dragon.read.component.shortvideo.data.saas.video.d dVar) {
            return bt3.b.a(this, dVar);
        }

        @Override // bt3.c
        public void i() {
        }

        @Override // bt3.c
        public /* synthetic */ void k(Context context, Object obj, Runnable runnable) {
            bt3.b.d(this, context, obj, runnable);
        }

        @Override // bt3.c
        public void l(oq3.a aVar) {
        }

        @Override // bt3.c
        public List<com.dragon.read.component.shortvideo.data.saas.video.d> j() {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @Override // tq3.e
    public gt3.b T0() {
        return new e();
    }

    @Override // tq3.e
    public et3.b a3() {
        return new c();
    }

    @Override // tq3.e
    public bt3.c c2() {
        return new g();
    }

    @Override // tq3.e
    public gt3.a e1() {
        return new C0157d();
    }

    @Override // tq3.e
    public et3.a e2() {
        return new b();
    }

    @Override // tq3.e
    public tq3.i g1() {
        return new a();
    }

    @Override // tq3.e
    public ft3.b j4() {
        return new f();
    }

    @Override // tq3.e
    public HashMap<String, Object> t1(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return new HashMap<>();
    }

    public static final class f implements ft3.b {
        f() {
        }

        @Override // ft3.b
        public /* synthetic */ void a(Dialog dialog) {
            ft3.a.a(this, dialog);
        }

        @Override // ft3.b
        public Drawable b(Drawable drawable, Context context, int i) {
            return null;
        }

        @Override // ft3.b
        public void c(ImageView imageView, int i) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
        }

        @Override // ft3.b
        public void d(ImageView imageView, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
        }

        @Override // ft3.b
        public /* synthetic */ void e(SimpleDraweeView simpleDraweeView, int i) {
            ft3.a.c(this, simpleDraweeView, i);
        }

        @Override // ft3.b
        public int f() {
            return 0;
        }

        @Override // ft3.b
        public Drawable getDrawable(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // ft3.b
        public /* synthetic */ void h(View view, int i, int i2, int i3) {
            ft3.a.b(this, view, i, i2, i3);
        }

        @Override // ft3.b
        public int i() {
            return 0;
        }

        @Override // ft3.b
        public boolean isNightMode() {
            return false;
        }

        @Override // ft3.b
        public void setTextColor(TextView textView, int i) {
        }

        @Override // ft3.b
        public int g(Context context, int i) {
            Resources resources;
            if (context != null && (resources = context.getResources()) != null) {
                return resources.getColor(i);
            }
            return -1;
        }
    }
}

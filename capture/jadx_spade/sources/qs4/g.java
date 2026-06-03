package qs4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import ar3.u;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.bullet.service.base.IPreLoadServiceKt;
import com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.AppRunningMode;
import com.dragon.read.app.SingleAppContext;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.component.biz.api.NsLiveECApi;
import com.dragon.read.component.biz.api.NsShortSeriesAdApi;
import com.dragon.read.component.biz.api.NsVipApi;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDataWrapper;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.nonstandard.ad.adapter.ssconfig.FixPatchAdFmp;
import com.dragon.read.nonstandard.ad.api.NonStandardAdApi;
import com.dragon.read.nonstandard.ad.config.VideoEnablePatchAds;
import com.dragon.read.pages.bullet.LynxCardView;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.PatchPlanAdData;
import com.dragon.read.rpc.model.PatchPlanItem;
import com.dragon.read.rpc.model.ReportAdRequest;
import com.dragon.read.rpc.model.ReportAdScene;
import com.dragon.read.rpc.model.VipCommonSubType;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.kotlin.ConvertKt;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.v3;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.messagebus.Subscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements br3.e<Object> {
    public static final a p;
    public static final int q;
    private rq3.n a;
    private rq3.n b;
    private PatchPlanAdData c;
    private b d = new b();
    private final LogHelper e = new LogHelper("NonStandardAd-AdDataProvider");
    private boolean f = true;
    private final Lazy g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;
    private final Lazy n;
    private int o;

    public static final class a {
        static {
            Covode.recordClassIndex(612455);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612454);
        p = new a(null);
        q = 8;
    }

    @Override // br3.e
    public Class<Object> J() {
        return null;
    }

    @Override // br3.e
    public /* synthetic */ void K(View view) {
        br3.d.e(this, view);
    }

    @Override // br3.e
    public /* synthetic */ void M(List list) {
        br3.d.h(this, list);
    }

    @Override // br3.e
    public /* synthetic */ void O(int i) {
        br3.d.n(this, i);
    }

    @Override // br3.e
    public /* synthetic */ void P(boolean z) {
        br3.d.i(this, z);
    }

    @Override // br3.e
    public void Q() {
    }

    @Override // br3.e
    public /* synthetic */ void S(int i) {
        br3.d.g(this, i);
    }

    @Override // br3.e
    public /* synthetic */ void U(int i) {
        br3.d.f(this, i);
    }

    @Override // br3.e
    public /* synthetic */ void V() {
        br3.d.b(this);
    }

    @Override // br3.e
    public /* synthetic */ void W(float f, boolean z) {
        br3.d.o(this, f, z);
    }

    @Override // br3.e
    public /* synthetic */ void X(boolean z) {
        br3.d.q(this, z);
    }

    @Override // br3.e
    public /* synthetic */ void Y() {
        br3.d.j(this);
    }

    @Override // br3.e
    public /* synthetic */ void Z(Object obj, AbsRecyclerViewHolder absRecyclerViewHolder) {
        br3.d.d(this, obj, absRecyclerViewHolder);
    }

    @Override // br3.e
    public /* synthetic */ Pair a0() {
        return br3.d.a(this);
    }

    @Override // br3.e
    public /* synthetic */ void b0() {
        br3.d.m(this);
    }

    @Override // br3.e
    public void c0() {
    }

    @Override // br3.e
    public /* synthetic */ void d0() {
        br3.d.l(this);
    }

    @Override // br3.e
    public void v() {
    }

    @Override // br3.e
    public void w() {
    }

    @Override // br3.e
    public void x() {
    }

    @Override // br3.e
    public cr3.e<Object> y() {
        return null;
    }

    public final class b {
        static {
            Covode.recordClassIndex(612456);
        }

        public final void a() {
            BusProvider.register(this);
        }

        public final void b() {
            BusProvider.unregister(this);
        }

        public b() {
        }

        @Subscriber
        public final void onHidePatchAd(rs4.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            g.this.e.d("[onHidePatchAd]-lynx, planId=" + event.a + ", materialId=" + event.b + ", pageCode=" + event.c + ", type=" + event.getType() + ", needResumePlay=" + event.e, new Object[0]);
            if (!Intrinsics.areEqual(event.getType(), "series")) {
                return;
            }
            g.this.p(event.a, event.b, Integer.valueOf(event.c));
        }
    }

    private final boolean B() {
        if (this.f) {
            return this.h;
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences C() {
        return KvCacheMgr.getPublic(App.context(), "key_series_nonstandard_ad_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float D() {
        return ScreenUtils.getScreenWidth(App.context()) / 390.0f;
    }

    private final SharedPreferences m() {
        return (SharedPreferences) this.g.getValue();
    }

    private final float n() {
        return ((Number) this.n.getValue()).floatValue();
    }

    private final rq3.n o() {
        if (this.f) {
            return this.a;
        }
        return this.b;
    }

    @Override // br3.e
    public void u() {
        if (!this.m) {
            this.d.b();
        } else {
            this.m = false;
        }
    }

    private final boolean A() {
        List list;
        PatchPlanAdData patchPlanAdData = this.c;
        if (patchPlanAdData != null) {
            list = patchPlanAdData.items;
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public g() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: qs4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SharedPreferences C;
                C = g.C();
                return C;
            }
        });
        this.g = lazy;
        this.j = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: qs4.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float D;
                D = g.D();
                return Float.valueOf(D);
            }
        });
        this.n = lazy2;
        this.o = -1;
    }

    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ Function0<Unit> a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        c(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Function0<Unit> function0 = this.a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final void F(boolean z) {
        if (this.f) {
            this.h = z;
        } else {
            this.i = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(LynxCardView lynxCardView) {
        if (lynxCardView != null) {
            lynxCardView.sendEvent("readingSeriesAdAppear", new JSONObject());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(LynxCardView lynxCardView) {
        if (lynxCardView != null) {
            lynxCardView.sendEvent("readingSeriesAdAppear", new JSONObject());
        }
        return Unit.INSTANCE;
    }

    private final Activity l(Context context) {
        if (context == null) {
            return ActivityRecordManager.inst().getCurrentActivity();
        }
        return ContextUtils.getActivity(context);
    }

    @Override // br3.e
    public void N(int i) {
        if (!A()) {
            g0(false);
        }
    }

    @Override // br3.e
    public void z(rq3.n seriesController) {
        Intrinsics.checkNotNullParameter(seriesController, "seriesController");
        if (this.f) {
            this.a = seriesController;
        } else {
            this.b = seriesController;
        }
    }

    @Override // br3.e
    public void I(int i) {
        if (A()) {
            return;
        }
        q(this, null, null, Integer.valueOf(i), 3, null);
    }

    @Override // br3.e
    public void L(com.dragon.read.component.shortvideo.data.saas.video.d dataProvider) {
        String str;
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.d.a();
        SaasVideoData videoData = dataProvider.getVideoData();
        if (videoData == null || (str = videoData.getSeriesId()) == null) {
            str = "";
        }
        k0(str);
    }

    @Override // br3.e
    public void T(SaasVideoData videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        this.c = null;
        String seriesId = videoData.getSeriesId();
        Intrinsics.checkNotNullExpressionValue(seriesId, "getSeriesId(...)");
        k0(seriesId);
    }

    private final void E(String str) {
        ReportAdRequest reportAdRequest = new ReportAdRequest();
        reportAdRequest.scene = ReportAdScene.AdPatchPlan;
        reportAdRequest.id = str;
        g65.d.B(reportAdRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    private final boolean H(PatchPlanItem patchPlanItem) {
        boolean z;
        List list = patchPlanItem.targetApps;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        List list2 = patchPlanItem.targetApps;
        Intrinsics.checkNotNull(list2);
        String str = (String) list2.get(0);
        if (str == null) {
            str = "";
        }
        return NsAdApi.IMPL.isInstalledApp(App.context(), str);
    }

    private final void k0(final String str) {
        this.j = str;
        if (NsLiveECApi.IMPL.getPicSearchConfigService().enableNonStandAd(VideoEnablePatchAds.a.a().enable)) {
            NonStandardAdApi.IMPL.getAdData(ConvertKt.toLongSafely(str), new Function2() { // from class: qs4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l0;
                    l0 = g.l0(g.this, str, (PatchPlanAdData) obj, ((Boolean) obj2).booleanValue());
                    return l0;
                }
            });
        }
    }

    @Override // br3.e
    public void e0(boolean z) {
        if (z && !this.f) {
            this.m = true;
        }
        if (A()) {
            return;
        }
        Integer num = null;
        Activity l = l(null);
        if (l != null) {
            num = Integer.valueOf(l.hashCode());
        }
        q(this, null, null, num, 3, null);
        this.f = z;
    }

    private final void g0(boolean z) {
        Object obj;
        rq3.e e;
        rq3.j b2;
        rq3.n o = o();
        ViewGroup viewGroup = null;
        if (o != null && (b2 = o.b()) != null) {
            obj = b2.s();
        } else {
            obj = null;
        }
        rq3.n o2 = o();
        if (o2 != null && (e = o2.e()) != null) {
            viewGroup = e.l1();
        }
        if ((obj instanceof SaasVideoDataWrapper) && viewGroup != null) {
            SaasVideoDataWrapper saasVideoDataWrapper = (SaasVideoDataWrapper) obj;
            SaasVideoData videoData = saasVideoDataWrapper.getVideoData();
            boolean z2 = false;
            if (videoData != null && !videoData.isSlideToNewRecommendFeed()) {
                z2 = true;
            }
            if (z2) {
                f0(saasVideoDataWrapper.getVideoData(), viewGroup, z);
            }
        }
    }

    private final void k(LynxCardView lynxCardView) {
        String sessionId;
        LogHelper logHelper = this.e;
        StringBuilder sb = new StringBuilder();
        sb.append("enable-fixLynxPreloadTrace: ");
        FixPatchAdFmp.a aVar = FixPatchAdFmp.a;
        sb.append(aVar.a().enable);
        logHelper.i(sb.toString(), new Object[0]);
        if (!aVar.a().enable) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (lynxCardView != null && (sessionId = lynxCardView.getSessionId()) != null) {
            ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "open_time", Long.valueOf(currentTimeMillis));
        }
    }

    private final void h0(int i) {
        ViewGroup viewGroup;
        boolean z;
        boolean z2;
        PatchPlanItem patchPlanItem;
        String str;
        String str2;
        final LynxCardView lynxCardView;
        Object obj;
        Integer num;
        int i2;
        AbsRecyclerViewHolder<Object> absRecyclerViewHolder;
        ar3.l lVar;
        rq3.e e;
        Object m773constructorimpl;
        Object obj2;
        List emptyList;
        cp3.b bVar;
        rq3.j b2;
        SaasVideoData l0;
        rq3.j b3;
        SaasVideoData l02;
        rq3.e e2;
        rq3.n o = o();
        Integer num2 = null;
        if (o != null && (e2 = o.e()) != null) {
            viewGroup = e2.l1();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && viewGroup.getVisibility() == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z && viewGroup.getChildCount() == 1) {
            if (viewGroup.getAlpha() == 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Object tag = viewGroup.getTag();
                if (tag instanceof PatchPlanItem) {
                    patchPlanItem = (PatchPlanItem) tag;
                } else {
                    patchPlanItem = null;
                }
                if (patchPlanItem != null) {
                    rq3.n o2 = o();
                    if (o2 != null && (b3 = o2.b()) != null && (l02 = b3.l0()) != null) {
                        str = l02.getSeriesId();
                    } else {
                        str = null;
                    }
                    rq3.n o3 = o();
                    if (o3 != null && (b2 = o3.b()) != null && (l0 = b2.l0()) != null) {
                        str2 = l0.getVid();
                    } else {
                        str2 = null;
                    }
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt instanceof LynxCardView) {
                        lynxCardView = (LynxCardView) childAt;
                    } else {
                        lynxCardView = null;
                    }
                    if (!B()) {
                        if (lynxCardView != null) {
                            obj = lynxCardView.getTag();
                        } else {
                            obj = null;
                        }
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            i2 = num.intValue();
                        } else {
                            i2 = 1;
                        }
                        if (j(patchPlanItem, i, str, str2, i2)) {
                            F(true);
                            this.e.i("[showAdView] adTag=" + viewGroup.getTag().hashCode(), new Object[0]);
                            k(lynxCardView);
                            if (!this.f) {
                                s(viewGroup, false, new Function0() { // from class: qs4.e
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit i0;
                                        i0 = g.i0(lynxCardView);
                                        return i0;
                                    }
                                });
                                cp3.b o4 = o();
                                if (o4 instanceof cp3.b) {
                                    bVar = o4;
                                } else {
                                    bVar = null;
                                }
                                if (bVar != null) {
                                    bVar.p("on_non_std_patch_ad_show");
                                }
                            } else {
                                rq3.n o5 = o();
                                if (o5 != null && (e = o5.e()) != null) {
                                    absRecyclerViewHolder = e.d3();
                                } else {
                                    absRecyclerViewHolder = null;
                                }
                                if (absRecyclerViewHolder instanceof ar3.l) {
                                    lVar = (ar3.l) absRecyclerViewHolder;
                                } else {
                                    lVar = null;
                                }
                                Bundle bundle = new Bundle();
                                u.a aVar = u.a;
                                bundle.putBoolean(aVar.Z(), true);
                                if (lVar != null) {
                                    ar3.k.q(lVar, aVar.C(), null, 2, null);
                                }
                                s(viewGroup, false, new Function0() { // from class: qs4.f
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit j0;
                                        j0 = g.j0(lynxCardView);
                                        return j0;
                                    }
                                });
                            }
                            try {
                                Result.Companion companion = Result.Companion;
                                JSONArray optJSONArray = new JSONObject(patchPlanItem.lynxData).optJSONArray("display_monitor_links");
                                if (optJSONArray == null || (emptyList = IPreLoadServiceKt.toStringList(optJSONArray)) == null) {
                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                }
                                NsAdApi.IMPL.onNonStanderAdShowTrackEvent(patchPlanItem.planId, emptyList);
                                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                            }
                            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                            if (m776exceptionOrNullimpl != null) {
                                this.e.e(String.valueOf(m776exceptionOrNullimpl.getMessage()), new Object[0]);
                            }
                            if (str != null) {
                                String str3 = str + '_' + patchPlanItem.materialId;
                                int i3 = m().getInt(str3, 0) + 1;
                                m().edit().putInt(str3, i3).putString(str3 + "_day", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date())).apply();
                                this.e.d("showCount=" + i3, new Object[0]);
                            }
                            E(String.valueOf(patchPlanItem.planId));
                            if (lynxCardView != null) {
                                obj2 = lynxCardView.getTag();
                            } else {
                                obj2 = null;
                            }
                            if (obj2 instanceof Integer) {
                                num2 = (Integer) obj2;
                            }
                            G("success", patchPlanItem, num2);
                            viewGroup.setVisibility(0);
                            viewGroup.setEnabled(true);
                            if (this.f) {
                                this.k = false;
                            } else {
                                this.l = false;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // br3.e
    public void R(SaasVideoData videoData, ViewGroup adContainer) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        this.e.d("[onBindData]", new Object[0]);
        if (A()) {
            return;
        }
        f0(videoData, adContainer, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(ViewGroup viewGroup, g gVar) {
        AbsRecyclerViewHolder<Object> absRecyclerViewHolder;
        ar3.l lVar;
        rq3.e e;
        LynxCardView lynxCardView;
        if (viewGroup.getChildCount() == 1) {
            LynxCardView childAt = viewGroup.getChildAt(0);
            if (childAt instanceof LynxCardView) {
                lynxCardView = childAt;
            } else {
                lynxCardView = null;
            }
            if (lynxCardView != null) {
                lynxCardView.sendEvent("readingSeriesAdDisAppear", new JSONObject());
            }
        }
        if (gVar.f) {
            rq3.n o = gVar.o();
            if (o != null && (e = o.e()) != null) {
                absRecyclerViewHolder = e.d3();
            } else {
                absRecyclerViewHolder = null;
            }
            if (absRecyclerViewHolder instanceof ar3.l) {
                lVar = (ar3.l) absRecyclerViewHolder;
            } else {
                lVar = null;
            }
            Bundle bundle = new Bundle();
            u.a aVar = u.a;
            bundle.putBoolean(aVar.Z(), true);
            if (lVar != null) {
                ar3.k.q(lVar, aVar.t0(), null, 2, null);
            }
        }
        viewGroup.setVisibility(4);
        viewGroup.setAlpha(0.0f);
        return Unit.INSTANCE;
    }

    @Override // br3.e
    public void t(int i, int i2) {
        String str;
        rq3.j b2;
        SaasVideoData l0;
        if (A()) {
            return;
        }
        h0(i);
        if (this.o / 1000 == i / 1000) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", i2);
            jSONObject.put("progress", i);
            jSONObject.put("appear_time", this.o);
            jSONObject.put("series_id", this.j);
            rq3.n o = o();
            if (o == null || (b2 = o.b()) == null || (l0 = b2.l0()) == null || (str = l0.getVid()) == null) {
                str = "";
            }
            jSONObject.put("video_id", str);
            ReportManager.onReport("key_nonstandard_patch_ad_match_time", jSONObject);
        }
    }

    private final void G(String str, PatchPlanItem patchPlanItem, Integer num) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msg", str);
        jSONObject.put("plan_id", patchPlanItem.planId);
        jSONObject.put("material_id", patchPlanItem.materialId);
        jSONObject.put("item_id", patchPlanItem.itemId);
        jSONObject.put("series_id", this.j);
        jSONObject.put("app_enabled", num);
        jSONObject.put("appear_time", patchPlanItem.appearTime / 1000);
        AppLogNewUtils.onEventV3("key_nonstandard_patch_ad_show", jSONObject);
    }

    private final void s(View view, boolean z, Function0<Unit> function0) {
        ViewPropertyAnimator animate;
        float f;
        if (view != null && (animate = view.animate()) != null) {
            if (z) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            ViewPropertyAnimator alpha = animate.alpha(f);
            if (alpha != null) {
                alpha.setDuration(300L);
                alpha.setInterpolator(v3.a());
                alpha.start();
                alpha.setListener(new c(function0));
            }
        }
        if (view != null) {
            view.setEnabled(false);
        }
    }

    private final void f0(SaasVideoData saasVideoData, ViewGroup viewGroup, boolean z) {
        boolean z2;
        boolean z3;
        PatchPlanAdData patchPlanAdData;
        List<PatchPlanItem> list;
        boolean z4;
        Map mapOf;
        String vid;
        boolean z5;
        viewGroup.setAlpha(0.0f);
        viewGroup.setVisibility(4);
        F(false);
        if (z) {
            if (viewGroup.getChildCount() != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                viewGroup.removeAllViews();
            }
        }
        if (saasVideoData != null && saasVideoData.isSlideToNewRecommendFeed()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        if (viewGroup.getChildCount() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && (patchPlanAdData = this.c) != null && (list = patchPlanAdData.items) != null) {
            for (PatchPlanItem patchPlanItem : list) {
                if (saasVideoData != null && (vid = saasVideoData.getVid()) != null && ConvertKt.toLongSafely(vid) == patchPlanItem.itemId) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    Activity l = l(viewGroup.getContext());
                    if (l == null) {
                        return;
                    }
                    LynxCardView seriesAttachedAdLynxView = NonStandardAdApi.IMPL.getSeriesAttachedAdLynxView(l);
                    Intrinsics.checkNotNull(patchPlanItem);
                    boolean H = H(patchPlanItem);
                    String str = patchPlanItem.lynxUrl;
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("data", patchPlanItem.lynxData), TuplesKt.to("extra_info", new JSONObject().put("target_app_enable", H ? 1 : 0).toString()));
                    seriesAttachedAdLynxView.A(str, mapOf);
                    seriesAttachedAdLynxView.setTag(Integer.valueOf(H ? 1 : 0));
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) (patchPlanItem.lynxConfig.phoneWidth.hdefault * n()), (int) (patchPlanItem.lynxConfig.phoneHeight.hdefault * n()));
                    if (!this.f) {
                        marginLayoutParams.setMarginStart(UIKt.getDp(80));
                        marginLayoutParams.bottomMargin = UIKt.getDp(20);
                    } else {
                        marginLayoutParams.setMarginStart(UIKt.getDp(16));
                        marginLayoutParams.bottomMargin = UIKt.getDp(73);
                    }
                    seriesAttachedAdLynxView.setLayoutParams(marginLayoutParams);
                    viewGroup.setTag(patchPlanItem);
                    viewGroup.addView((View) seriesAttachedAdLynxView, (ViewGroup.LayoutParams) marginLayoutParams);
                    this.e.i("[bindAdView] addView, itemId=" + patchPlanItem.itemId + ", matrialId=" + patchPlanItem.materialId + ", adContainer=" + viewGroup.hashCode(), new Object[0]);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String str, String str2, Integer num) {
        final ViewGroup viewGroup;
        Context context;
        Integer num2;
        boolean z;
        boolean z2;
        PatchPlanItem patchPlanItem;
        boolean z3;
        boolean z4;
        String str3;
        String str4;
        rq3.e e;
        rq3.n o = o();
        Integer num3 = null;
        if (o != null && (e = o.e()) != null) {
            viewGroup = e.l1();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            context = viewGroup.getContext();
        } else {
            context = null;
        }
        Activity l = l(context);
        if (l != null) {
            num2 = Integer.valueOf(l.hashCode());
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            this.e.w("[hideAd] pageCode is not equal!", new Object[0]);
            return;
        }
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (viewGroup.getAlpha() == 1.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Object tag = viewGroup.getTag();
                if (tag instanceof PatchPlanItem) {
                    patchPlanItem = (PatchPlanItem) tag;
                } else {
                    patchPlanItem = null;
                }
                if (str.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (str2.length() > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        if (patchPlanItem != null) {
                            str3 = Long.valueOf(patchPlanItem.planId).toString();
                        } else {
                            str3 = null;
                        }
                        if (!Intrinsics.areEqual(str3, str)) {
                            if (patchPlanItem == null || (str4 = patchPlanItem.materialId) == null) {
                                str4 = null;
                            }
                            if (!Intrinsics.areEqual(str4, str2)) {
                                String str5 = "[hideAd-fromLynx] ad can not match, planId=" + str + ", materialId=" + str2;
                                this.e.e(str5, new Object[0]);
                                if (SingleAppContext.inst(com.dragon.read.app.App.context()).isLocalTestChannel()) {
                                    ToastUtils.showCommonToast(str5);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                LogHelper logHelper = this.e;
                StringBuilder sb = new StringBuilder();
                sb.append("[hideAdView] adTag=");
                Object tag2 = viewGroup.getTag();
                if (tag2 != null) {
                    num3 = Integer.valueOf(tag2.hashCode());
                }
                sb.append(num3);
                logHelper.i(sb.toString(), new Object[0]);
                F(false);
                s(viewGroup, true, new Function0() { // from class: qs4.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit r;
                        r = g.r(viewGroup, this);
                        return r;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(g gVar, String str, PatchPlanAdData patchPlanAdData, boolean z) {
        int i;
        int i2;
        List list;
        List list2;
        Object firstOrNull;
        gVar.c = patchPlanAdData;
        gVar.g0(true);
        if (patchPlanAdData != null && (list2 = patchPlanAdData.items) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            PatchPlanItem patchPlanItem = (PatchPlanItem) firstOrNull;
            if (patchPlanItem != null) {
                i = patchPlanItem.appearTime;
                gVar.o = i;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hit_cache", z ? 1 : 0);
                if (patchPlanAdData == null && (list = patchPlanAdData.items) != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                jSONObject.put("ad_size", i2);
                jSONObject.put("series_id", str);
                AppLogNewUtils.onEventV3("key_nonstandard_patch_ad_send", jSONObject);
                return Unit.INSTANCE;
            }
        }
        i = -1;
        gVar.o = i;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("hit_cache", z ? 1 : 0);
        if (patchPlanAdData == null) {
        }
        i2 = 0;
        jSONObject2.put("ad_size", i2);
        jSONObject2.put("series_id", str);
        AppLogNewUtils.onEventV3("key_nonstandard_patch_ad_send", jSONObject2);
        return Unit.INSTANCE;
    }

    private final boolean j(PatchPlanItem patchPlanItem, int i, String str, String str2, int i2) {
        boolean z;
        SaasVideoData saasVideoData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        rq3.j b2;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        if (i2 == 0) {
            this.e.w("targetApp is not enabled", new Object[0]);
            G("app_not_installed", patchPlanItem, Integer.valueOf(i2));
            return false;
        }
        rq3.n o = o();
        if (o != null && (b2 = o.b()) != null) {
            saasVideoData = b2.l0();
        } else {
            saasVideoData = null;
        }
        if (saasVideoData != null) {
            z2 = Intrinsics.areEqual(saasVideoData.getShowBackToFirstGuide(), Boolean.TRUE);
        } else {
            z2 = false;
        }
        if (z2 && saasVideoData.getBackToFirstGuideShowTime() != 0) {
            this.e.i("内流展示回到首集按钮，不插入贴片广告", new Object[0]);
            return false;
        }
        int i3 = patchPlanItem.appearTime;
        if (i <= i3) {
            if (this.f) {
                this.k = true;
            } else {
                this.l = true;
            }
        }
        if (i3 / 1000 != i / 1000) {
            return false;
        }
        if ((!this.k && this.f) || (!this.l && !this.f)) {
            this.e.i("重复展示", new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 1000;
        if (patchPlanItem.beginTime * j < currentTimeMillis && patchPlanItem.endTime * j > currentTimeMillis) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            this.e.w("广告计划时间不匹配", new Object[0]);
            G("time_not_matched", patchPlanItem, Integer.valueOf(i2));
            return false;
        }
        NsVipApi nsVipApi = NsVipApi.IMPL;
        if (!nsVipApi.isVip(VipCommonSubType.Default) && !nsVipApi.isVip(VipCommonSubType.AdFree) && !nsVipApi.privilegeManager().hasNoAdFollAllScene() && !nsVipApi.privilegeManager().hasNoAdForShortSeries() && !NsCommonDepend.IMPL.basicFunctionMode().isEnabled() && !AppRunningMode.INSTANCE.isTeenMode()) {
            zz2.a a2 = NsShortSeriesAdApi.IMPL.getManagerProvider().a();
            if (str.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (str2 != null && str2.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5 && a2.r(str, str2)) {
                    G("inspire", patchPlanItem, Integer.valueOf(i2));
                    this.e.i("锁定集免广", new Object[0]);
                    return false;
                }
            }
            String str3 = str + '_' + patchPlanItem.materialId;
            String str4 = str3 + "_day";
            if (!Intrinsics.areEqual(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()), m().getString(str4, ""))) {
                m().edit().putString(str4, "").putInt(str3, 0).apply();
                return true;
            }
            if (m().getInt(str3, 0) < patchPlanItem.freqLimit) {
                return true;
            }
            G("limited_show_count", patchPlanItem, Integer.valueOf(i2));
            this.e.i("频控限制", new Object[0]);
            return false;
        }
        G("privilege", patchPlanItem, Integer.valueOf(i2));
        this.e.i("权益免广", new Object[0]);
        return false;
    }

    static /* synthetic */ void q(g gVar, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        gVar.p(str, str2, num);
    }
}

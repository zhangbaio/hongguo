package com.dragon.read.nonstandard.ad.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import br3.e;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.AppRunningMode;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.base.util.DateUtils;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.component.biz.api.NsVipApi;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.nonstandard.ad.api.NonStandardAdApi;
import com.dragon.read.nonstandard.ad.config.StopBrandAdCptV691;
import com.dragon.read.pages.bullet.LynxCardView;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.dragon.read.rpc.model.GetPatchPlanAdResponse;
import com.dragon.read.rpc.model.PatchPlanAdData;
import com.dragon.read.rpc.model.PatchPlanItem;
import com.dragon.read.rpc.model.ReportAdRequest;
import com.dragon.read.rpc.model.ReportAdScene;
import com.dragon.read.rpc.model.VipCommonSubType;
import com.dragon.read.util.kotlin.ConvertKt;
import com.dragon.read.widget.v3;
import com.google.gson.reflect.TypeToken;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.messagebus.Subscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rq3.j;
import rq3.l;
import rq3.n;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import tq3.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements e<Object> {
    public static final C0092a j;
    public static final int k;
    private static volatile SharedPreferences l;
    private static final Map<String, Integer> m;
    private final Lazy a;
    private n b;
    private b c;
    private final Map<String, PatchPlanItem> d;
    private final LinkedList<Pair<String, LynxCardView>> e;
    private final Set<String> f;
    private Disposable g;
    private boolean h;
    private final d i;

    /* renamed from: com.dragon.read.nonstandard.ad.adapter.a$a, reason: collision with other inner class name */
    public static final class C0092a {
        static {
            Covode.recordClassIndex(612458);
        }

        private C0092a() {
        }

        public /* synthetic */ C0092a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.dragon.read.nonstandard.ad.adapter.a$a$a, reason: collision with other inner class name */
        public static final class C0093a extends TypeToken<Map<String, ? extends Integer>> {
            C0093a() {
            }
        }

        public final void b() {
            SharedPreferences.Editor edit = c().edit();
            edit.clear();
            edit.apply();
            a.m.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SharedPreferences c() {
            SharedPreferences sharedPreferences = a.l;
            if (sharedPreferences == null) {
                sharedPreferences = KvCacheMgr.getPublic(App.context(), "key_series_nonstandard_pause_ad_info");
                try {
                    Map map = (Map) JSONUtils.fromJson(sharedPreferences.getString("key_series_id_freq_limit", null), new C0093a().getType());
                    if (map != null) {
                        a.m.putAll(map);
                    }
                } catch (Exception e) {
                    LogWrapper.error("SeriesNonStandardPauseAdDataProvider", "getKvCacheMgr, parse seriesIdFreeLimitMap error", new Object[]{e});
                }
                a.l = sharedPreferences;
                Intrinsics.checkNotNull(sharedPreferences);
            }
            return sharedPreferences;
        }
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
    public void L(com.dragon.read.component.shortvideo.data.saas.video.d videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
    }

    @Override // br3.e
    public /* synthetic */ void M(List list) {
        br3.d.h(this, list);
    }

    @Override // br3.e
    public void N(int i) {
    }

    @Override // br3.e
    public /* synthetic */ void P(boolean z) {
        br3.d.i(this, z);
    }

    @Override // br3.e
    public /* synthetic */ void R(SaasVideoData saasVideoData, ViewGroup viewGroup) {
        br3.d.c(this, saasVideoData, viewGroup);
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
    public /* synthetic */ void d0() {
        br3.d.l(this);
    }

    @Override // br3.e
    public void t(int i, int i2) {
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
            Covode.recordClassIndex(612459);
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
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "[onHidePatchAd]-lynx, planId=" + event.a + ", materialId=" + event.b + ", pageCode=" + event.c + ", type=" + event.getType() + ", needResumePlay=" + event.e, new Object[0]);
            if (Intrinsics.areEqual(event.getType(), "pause")) {
                a.m0(a.this, "", null, Integer.valueOf(event.c), event.e, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StopBrandAdCptV691 i0() {
        return StopBrandAdCptV691.a.a();
    }

    private final StopBrandAdCptV691 r() {
        return (StopBrandAdCptV691) this.a.getValue();
    }

    @Override // br3.e
    public void c0() {
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "onShortStop", new Object[0]);
    }

    static {
        Covode.recordClassIndex(612457);
        j = new C0092a(null);
        k = 8;
        m = new LinkedHashMap();
    }

    @Override // br3.e
    public void Q() {
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "onShortPlay", new Object[0]);
        this.h = true;
        k0();
    }

    public a() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: qs4.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StopBrandAdCptV691 i0;
                i0 = com.dragon.read.nonstandard.ad.adapter.a.i0();
                return i0;
            }
        });
        this.a = lazy;
        this.c = new b();
        this.d = new LinkedHashMap();
        this.e = new LinkedList<>();
        this.f = new LinkedHashSet();
        this.i = new d();
    }

    @Override // br3.e
    public void u() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        this.c.b();
        n nVar = this.b;
        if (nVar != null && (lifecycleOwner = nVar.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.i);
        }
        Iterator<Map.Entry<String, PatchPlanItem>> it2 = this.d.entrySet().iterator();
        while (it2.hasNext()) {
            NonStandardAdApi.IMPL.recordInsertPauseAd(it2.next().getKey(), null);
        }
    }

    private final void k0() {
        n nVar;
        j b2;
        SaasVideoData l0;
        String episodesId;
        PatchPlanItem patchPlanItem;
        Activity activity;
        Object obj;
        Map mapOf;
        s h;
        if (!r().enable || (nVar = this.b) == null || (b2 = nVar.b()) == null || (l0 = b2.l0()) == null || (episodesId = l0.getEpisodesId()) == null || (patchPlanItem = this.d.get(episodesId)) == null) {
            return;
        }
        Iterator<T> it2 = this.e.iterator();
        while (true) {
            activity = null;
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((Pair) obj).getFirst(), episodesId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return;
        }
        if (r().maxLynxviewCacheCount > 0 && this.e.size() >= r().maxLynxviewCacheCount) {
            LynxCardView second = this.e.pop().getSecond();
            p(second);
            C(second);
        }
        n nVar2 = this.b;
        if (nVar2 != null && (h = nVar2.h()) != null) {
            activity = h.getActivity();
        }
        Activity q = q(activity);
        if (q == null) {
            return;
        }
        LynxCardView seriesAttachedAdLynxView = NonStandardAdApi.IMPL.getSeriesAttachedAdLynxView(q);
        seriesAttachedAdLynxView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        this.e.add(TuplesKt.to(episodesId, seriesAttachedAdLynxView));
        boolean j0 = j0(patchPlanItem);
        String str = patchPlanItem.lynxUrl;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("data", patchPlanItem.lynxData), TuplesKt.to("extra_info", new JSONObject().put("target_app_enable", j0 ? 1 : 0).toString()));
        seriesAttachedAdLynxView.A(str, mapOf);
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

    public static final class d implements DefaultLifecycleObserver {
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
        }

        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.-CC.$default$onDestroy(this, lifecycleOwner);
        }

        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
        }

        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
        }

        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
        }

        d() {
        }

        public void onStop(LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DefaultLifecycleObserver.-CC.$default$onStop(this, owner);
            if ((owner instanceof Activity) && ((Activity) owner).isFinishing()) {
                a.m0(a.this, "quit", null, null, false, 14, null);
            }
        }
    }

    private final void C(LynxCardView lynxCardView) {
        if (lynxCardView != null) {
            lynxCardView.G();
        }
    }

    private final Activity q(Context context) {
        if (context == null) {
            return ActivityRecordManager.inst().getCurrentActivity();
        }
        return ContextUtils.getActivity(context);
    }

    @Override // br3.e
    public void I(int i) {
        br3.d.p(this, i);
        m0(this, "click_mask", null, null, false, 14, null);
    }

    @Override // br3.e
    public void e0(boolean z) {
        br3.d.k(this, z);
        m0(this, "orientation", null, null, false, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Throwable th) {
        LogWrapper.error("SeriesNonStandardPauseAdDataProvider", "requestAdData fail: " + th, new Object[0]);
        return Unit.INSTANCE;
    }

    private final void p(LynxCardView lynxCardView) {
        ViewParent viewParent;
        ViewGroup viewGroup = null;
        if (lynxCardView != null) {
            viewParent = lynxCardView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(lynxCardView);
        }
    }

    @Override // br3.e
    public void z(n seriesController) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(seriesController, "seriesController");
        this.b = seriesController;
        if (seriesController != null && (lifecycleOwner = seriesController.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this.i);
        }
        this.c.a();
    }

    private final void D(String str) {
        ReportAdRequest reportAdRequest = new ReportAdRequest();
        reportAdRequest.scene = ReportAdScene.AdStopPatch;
        reportAdRequest.id = str;
        g65.d.B(reportAdRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    private final boolean j0(PatchPlanItem patchPlanItem) {
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

    @Override // br3.e
    public void O(int i) {
        KeyEvent.Callback callback;
        rq3.e e;
        AbsRecyclerViewHolder<Object> g3;
        br3.d.n(this, i);
        n nVar = this.b;
        ViewGroup viewGroup = null;
        if (nVar != null && (e = nVar.e()) != null && (g3 = e.g3(i)) != null) {
            callback = ((RecyclerView.ViewHolder) g3).itemView;
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup = (ViewGroup) callback;
        }
        m0(this, "slide_out", viewGroup, null, false, 12, null);
    }

    @Override // br3.e
    public void T(SaasVideoData videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        this.h = false;
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "onSeriesChange, seriesId: " + videoData.getEpisodesId(), new Object[0]);
        E(videoData);
    }

    private final Pair<Boolean, LynxCardView> A(ViewGroup viewGroup) {
        j b2;
        SaasVideoData l0;
        String episodesId;
        n nVar = this.b;
        if (nVar != null && (b2 = nVar.b()) != null && (l0 = b2.l0()) != null && (episodesId = l0.getEpisodesId()) != null) {
            LynxCardView findViewWithTag = viewGroup.findViewWithTag("non_standard_pause_ad_" + episodesId);
            if (findViewWithTag == null) {
                return TuplesKt.to(Boolean.FALSE, null);
            }
            return TuplesKt.to(Boolean.TRUE, findViewWithTag);
        }
        return TuplesKt.to(Boolean.FALSE, null);
    }

    private final void E(SaasVideoData saasVideoData) {
        Disposable disposable;
        if (!m(saasVideoData)) {
            return;
        }
        Disposable disposable2 = this.g;
        if (disposable2 != null) {
            boolean z = false;
            if (disposable2 != null && !disposable2.isDisposed()) {
                z = true;
            }
            if (z && (disposable = this.g) != null) {
                disposable.dispose();
            }
        }
        final String episodesId = saasVideoData.getEpisodesId();
        NonStandardAdApi nonStandardAdApi = NonStandardAdApi.IMPL;
        Intrinsics.checkNotNull(episodesId);
        Observable<GetPatchPlanAdResponse> observeOn = nonStandardAdApi.getPauseAdData(ConvertKt.toLongSafely(episodesId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: qs4.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = com.dragon.read.nonstandard.ad.adapter.a.F(com.dragon.read.nonstandard.ad.adapter.a.this, episodesId, (GetPatchPlanAdResponse) obj);
                return F;
            }
        };
        Consumer<? super GetPatchPlanAdResponse> consumer = new Consumer() { // from class: qs4.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                com.dragon.read.nonstandard.ad.adapter.a.H(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: qs4.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f0;
                f0 = com.dragon.read.nonstandard.ad.adapter.a.f0((Throwable) obj);
                return f0;
            }
        };
        this.g = observeOn.subscribe(consumer, new Consumer() { // from class: qs4.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                com.dragon.read.nonstandard.ad.adapter.a.g0(Function1.this, obj);
            }
        });
    }

    private final boolean m(SaasVideoData saasVideoData) {
        boolean z;
        String episodesId = saasVideoData.getEpisodesId();
        if (episodesId != null && episodesId.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because episodesId is empty", new Object[0]);
            return false;
        }
        if (this.f.contains(saasVideoData.getEpisodesId())) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because seriesId is in cannotShowAdSeriesIdSet", new Object[0]);
            return false;
        }
        if (saasVideoData.getContentType() != VideoContentType.ShortSeriesPlay) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because contentType is not ShortSeriesPlay", new Object[0]);
            return false;
        }
        if (saasVideoData.isSlideToNewRecommendFeed()) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because isSlideToNewRecommendFeed", new Object[0]);
            return false;
        }
        if (!r().enable) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because ab not enable", new Object[0]);
            return false;
        }
        NsVipApi nsVipApi = NsVipApi.IMPL;
        if (!nsVipApi.isVip(VipCommonSubType.Default) && !nsVipApi.isVip(VipCommonSubType.AdFree) && !nsVipApi.privilegeManager().hasNoAdFollAllScene() && !nsVipApi.privilegeManager().hasNoAdForShortSeries() && !NsCommonDepend.IMPL.basicFunctionMode().isEnabled() && !AppRunningMode.INSTANCE.isTeenMode()) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData success", new Object[0]);
            return true;
        }
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "canRequestAdData fail because vip or teen or basic", new Object[0]);
        return false;
    }

    @Override // br3.e
    public void X(boolean z) {
        n nVar;
        j b2;
        SaasVideoData l0;
        String episodesId;
        PatchPlanItem patchPlanItem;
        LynxCardView lynxCardView;
        Object obj;
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "onVideoToggleClick, isPause: " + z, new Object[0]);
        if (!r().enable || !z || (nVar = this.b) == null || (b2 = nVar.b()) == null || (l0 = b2.l0()) == null || (episodesId = l0.getEpisodesId()) == null || (patchPlanItem = this.d.get(episodesId)) == null) {
            return;
        }
        Iterator<T> it2 = this.e.iterator();
        while (true) {
            lynxCardView = null;
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((Pair) obj).getFirst(), episodesId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            lynxCardView = (LynxCardView) pair.getSecond();
        }
        LynxCardView lynxCardView2 = lynxCardView;
        if (o(this, episodesId, patchPlanItem, lynxCardView2, false, null, 16, null)) {
            o0(episodesId, patchPlanItem, lynxCardView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    private final void B(String str, String str2) {
        SharedPreferences c2 = j.c();
        if (DateUtils.isToday(c2.getLong("key_last_show_time", 0L))) {
            Map<String, Integer> map = m;
            Integer num = map.get(str);
            if (num != null) {
                map.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                map.put(str, 1);
            }
            SharedPreferences.Editor edit = c2.edit();
            edit.putLong("key_last_show_time", System.currentTimeMillis());
            edit.putInt("key_show_time_daily", c2.getInt("key_show_time_daily", 0) + 1);
            edit.putString("key_series_id_freq_limit", JSONUtils.safeJsonString(map));
            edit.apply();
            return;
        }
        Map<String, Integer> map2 = m;
        map2.clear();
        map2.put(str, 1);
        SharedPreferences.Editor edit2 = c2.edit();
        edit2.putLong("key_last_show_time", System.currentTimeMillis());
        edit2.putInt("key_show_time_daily", 1);
        edit2.putString("key_series_id_freq_limit", JSONUtils.safeJsonString(map2));
        edit2.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(a aVar, LynxCardView lynxCardView, boolean z) {
        n nVar;
        rq3.e e;
        l d2;
        rq3.c a;
        n nVar2 = aVar.b;
        if (nVar2 != null && (a = nVar2.a()) != null) {
            a.w0(true);
        }
        n nVar3 = aVar.b;
        if (nVar3 != null && (d2 = nVar3.d()) != null) {
            d2.B5("SeriesNonStandardPauseAdDataProvider");
        }
        aVar.p(lynxCardView);
        if (z && (nVar = aVar.b) != null && (e = nVar.e()) != null) {
            e.i1();
        }
        return Unit.INSTANCE;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(a aVar, String sid, int i) {
        ViewParent viewParent;
        Object obj;
        LynxCardView lynxCardView;
        Intrinsics.checkNotNullParameter(sid, "sid");
        Iterator<T> it2 = aVar.e.iterator();
        while (true) {
            viewParent = null;
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((Pair) obj).getFirst(), sid)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            lynxCardView = (LynxCardView) pair.getSecond();
        } else {
            lynxCardView = null;
        }
        if (lynxCardView != null) {
            viewParent = lynxCardView.getParent();
        }
        if (viewParent != null) {
            return true;
        }
        return aVar.n(sid, aVar.d.get(sid), lynxCardView, true, Integer.valueOf(i));
    }

    private final void o0(final String str, final PatchPlanItem patchPlanItem, final LynxCardView lynxCardView) {
        KeyEvent.Callback callback;
        rq3.e e;
        AbsRecyclerViewHolder<Object> d3;
        if (lynxCardView == null || patchPlanItem == null) {
            return;
        }
        n nVar = this.b;
        ViewGroup viewGroup = null;
        if (nVar != null && (e = nVar.e()) != null && (d3 = e.d3()) != null) {
            callback = ((RecyclerView.ViewHolder) d3).itemView;
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup = (ViewGroup) callback;
        }
        if (viewGroup == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        lynxCardView.setLayoutParams(marginLayoutParams);
        lynxCardView.setTag("non_standard_pause_ad_" + str);
        viewGroup.addView((View) lynxCardView, (ViewGroup.LayoutParams) marginLayoutParams);
        h0(false, "success", patchPlanItem, str);
        s(lynxCardView, false, new Function0() { // from class: qs4.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit p0;
                p0 = com.dragon.read.nonstandard.ad.adapter.a.p0(com.dragon.read.nonstandard.ad.adapter.a.this, str, patchPlanItem, lynxCardView);
                return p0;
            }
        });
        D(String.valueOf(patchPlanItem.planId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(final a aVar, String str, GetPatchPlanAdResponse getPatchPlanAdResponse) {
        int i;
        boolean z;
        List list;
        List list2;
        PatchPlanItem patchPlanItem;
        List list3;
        List list4;
        StringBuilder sb = new StringBuilder();
        sb.append("requestAdData success: itemsListSize(");
        PatchPlanAdData patchPlanAdData = getPatchPlanAdResponse.data;
        int i2 = 0;
        if (patchPlanAdData != null && (list4 = patchPlanAdData.items) != null) {
            i = list4.size();
        } else {
            i = 0;
        }
        sb.append(i);
        sb.append(')');
        LogWrapper.info("SeriesNonStandardPauseAdDataProvider", sb.toString(), new Object[0]);
        PatchPlanAdData patchPlanAdData2 = getPatchPlanAdResponse.data;
        boolean z2 = true;
        if (patchPlanAdData2 != null && (list3 = patchPlanAdData2.items) != null && list3.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Set<String> set = aVar.f;
            Intrinsics.checkNotNull(str);
            set.add(str);
            return Unit.INSTANCE;
        }
        PatchPlanAdData patchPlanAdData3 = getPatchPlanAdResponse.data;
        if (patchPlanAdData3 != null && (list2 = patchPlanAdData3.items) != null && (patchPlanItem = (PatchPlanItem) CollectionsKt___CollectionsKt.getOrNull(list2, 0)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = 1000;
            if (patchPlanItem.beginTime * j2 >= currentTimeMillis || patchPlanItem.endTime * j2 <= currentTimeMillis) {
                z2 = false;
            }
            if (z2) {
                aVar.d.put(str, patchPlanItem);
                if (aVar.h) {
                    aVar.k0();
                }
            }
        }
        NonStandardAdApi nonStandardAdApi = NonStandardAdApi.IMPL;
        Intrinsics.checkNotNull(str);
        nonStandardAdApi.recordInsertPauseAd(str, new Function2() { // from class: qs4.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                boolean G;
                G = com.dragon.read.nonstandard.ad.adapter.a.G(com.dragon.read.nonstandard.ad.adapter.a.this, (String) obj, ((Integer) obj2).intValue());
                return Boolean.valueOf(G);
            }
        });
        JSONObject jSONObject = new JSONObject();
        PatchPlanAdData patchPlanAdData4 = getPatchPlanAdResponse.data;
        if (patchPlanAdData4 != null && (list = patchPlanAdData4.items) != null) {
            i2 = list.size();
        }
        jSONObject.put("ad_size", i2);
        jSONObject.put("series_id", str);
        jSONObject.put("type", "pause");
        AppLogNewUtils.onEventV3("key_nonstandard_patch_ad_send", jSONObject);
        return Unit.INSTANCE;
    }

    private final void h0(boolean z, String str, PatchPlanItem patchPlanItem, String str2) {
        Object obj;
        String str3;
        if (z) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msg", str);
        Object obj2 = "";
        if (patchPlanItem == null) {
            obj = "";
        } else {
            obj = Long.valueOf(patchPlanItem.planId);
        }
        jSONObject.put("plan_id", obj);
        if (patchPlanItem == null || (str3 = patchPlanItem.materialId) == null) {
            str3 = "";
        }
        jSONObject.put("material_id", str3);
        if (patchPlanItem != null) {
            obj2 = Long.valueOf(patchPlanItem.itemId);
        }
        jSONObject.put("item_id", obj2);
        jSONObject.put("series_id", str2);
        jSONObject.put("type", "pause");
        AppLogNewUtils.onEventV3("key_nonstandard_patch_ad_show", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(a aVar, String str, PatchPlanItem patchPlanItem, LynxCardView lynxCardView) {
        Integer num;
        j b2;
        l d2;
        rq3.c a;
        n nVar = aVar.b;
        if (nVar != null && (a = nVar.a()) != null) {
            a.w0(false);
        }
        n nVar2 = aVar.b;
        if (nVar2 != null && (d2 = nVar2.d()) != null) {
            d2.bc("SeriesNonStandardPauseAdDataProvider", true);
        }
        aVar.B(str, String.valueOf(patchPlanItem.planId));
        n nVar3 = aVar.b;
        if (nVar3 != null && (b2 = nVar3.b()) != null) {
            num = Integer.valueOf(b2.t0());
        } else {
            num = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("progress", num);
        Unit unit = Unit.INSTANCE;
        lynxCardView.sendEvent("readingSeriesAdAppear", jSONObject);
        return Unit.INSTANCE;
    }

    private final void l0(String str, ViewGroup viewGroup, Integer num, final boolean z) {
        View view;
        rq3.e e;
        AbsRecyclerViewHolder<Object> d3;
        if (!r().enable) {
            return;
        }
        Integer num2 = null;
        if (viewGroup == null) {
            n nVar = this.b;
            if (nVar != null && (e = nVar.e()) != null && (d3 = e.d3()) != null) {
                view = ((RecyclerView.ViewHolder) d3).itemView;
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
        }
        if (viewGroup == null) {
            LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "tryHideAd itemView is null!", new Object[0]);
            return;
        }
        if (num != null) {
            Activity q = q(viewGroup.getContext());
            if (q != null) {
                num2 = Integer.valueOf(q.hashCode());
            }
            if (!Intrinsics.areEqual(num, num2)) {
                LogWrapper.info("SeriesNonStandardPauseAdDataProvider", "tryHideAd pageCode is not equal!", new Object[0]);
                return;
            }
        }
        Pair<Boolean, LynxCardView> A = A(viewGroup);
        boolean booleanValue = A.component1().booleanValue();
        final LynxCardView component2 = A.component2();
        if (booleanValue) {
            if (component2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("disappear_type", str);
                Unit unit = Unit.INSTANCE;
                component2.sendEvent("readingSeriesAdDisAppear", jSONObject);
            }
            s(component2, true, new Function0() { // from class: qs4.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit n0;
                    n0 = com.dragon.read.nonstandard.ad.adapter.a.n0(com.dragon.read.nonstandard.ad.adapter.a.this, component2, z);
                    return n0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean n(java.lang.String r10, com.dragon.read.rpc.model.PatchPlanItem r11, com.dragon.read.pages.bullet.LynxCardView r12, boolean r13, java.lang.Integer r14) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.nonstandard.ad.adapter.a.n(java.lang.String, com.dragon.read.rpc.model.PatchPlanItem, com.dragon.read.pages.bullet.LynxCardView, boolean, java.lang.Integer):boolean");
    }

    static /* synthetic */ void m0(a aVar, String str, ViewGroup viewGroup, Integer num, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            viewGroup = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        aVar.l0(str, viewGroup, num, z);
    }

    static /* synthetic */ boolean o(a aVar, String str, PatchPlanItem patchPlanItem, LynxCardView lynxCardView, boolean z, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
        }
        return aVar.n(str, patchPlanItem, lynxCardView, z, num);
    }
}

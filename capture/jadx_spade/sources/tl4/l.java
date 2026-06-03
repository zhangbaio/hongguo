package tl4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import cl4.u;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SubscribeOpType;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.profile.commonlayout.CommonErrorType;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.guestprofile.tabContent.b0;
import com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState;
import com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel;
import com.dragon.read.kmp.s;
import com.dragon.read.kmp.subscribe.t;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.utils.p;
import com.dragon.read.kmp.utils.q0;
import com.dragon.read.kmp.utils.v0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.r4;
import dl4.r;
import gk4.o0;
import gk4.w;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l {
    public final rl4.c a;
    public final rl4.a b;
    private final com.dragon.read.kmp.i c;
    public final r d;
    public CoroutineScope e;
    public boolean f;
    public final MutableState<ql4.a> g;
    public final b0 h;
    public Disposable i;
    public Disposable j;
    public ProfileTabJustSawViewModel k;
    private boolean l;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608158);
            int[] iArr = new int[ProfileTab.values().length];
            try {
                iArr[ProfileTab.Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileTab.Select.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileTab.ProduceVideo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileTab.CelebrityWorks.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileTab.Digg.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileTab.Bookshelf.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608157);
    }

    protected void F(List<? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    protected void y(List<? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    private final boolean t() {
        ProfileTab profileTab = this.a.b;
        if (profileTab != ProfileTab.Select && profileTab != ProfileTab.Video) {
            return false;
        }
        return true;
    }

    public void H() {
        this.d.y();
        ProfileTabJustSawViewModel profileTabJustSawViewModel = this.k;
        if (profileTabJustSawViewModel != null) {
            profileTabJustSawViewModel.t();
        }
        Disposable disposable = this.i;
        if (disposable != null) {
            q0.a(disposable);
        }
        Disposable disposable2 = this.j;
        if (disposable2 != null) {
            q0.a(disposable2);
        }
    }

    private final void Z() {
        MutableState<ql4.a> mutableState = this.g;
        LoadStatus loadStatus = LoadStatus.Error;
        al4.a aVar = new al4.a();
        aVar.c(CommonErrorType.DefaultError);
        aVar.b("网络出错，请点击重试");
        aVar.h = new Function0() { // from class: tl4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a0;
                a0 = l.a0(l.this);
                return a0;
            }
        };
        Unit unit = Unit.INSTANCE;
        mutableState.setValue(new ql4.a(loadStatus, false, aVar, 2, null));
    }

    private final void s() {
        boolean z;
        rl4.c cVar = this.a;
        if (cVar.b == ProfileTab.Video) {
            if (cVar.t.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                rl4.c cVar2 = this.a;
                this.k = new ProfileTabJustSawViewModel(this, cVar2.t, cVar2.u);
            }
        }
    }

    public final String p() {
        int i;
        ProfileTab profileTab = this.a.b;
        if (profileTab == null) {
            i = -1;
        } else {
            i = a.a[profileTab.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    return "";
                }
                return "profile_starred_video";
            }
            return "profile_star_info";
        }
        return "profile_post";
    }

    private final void Y() {
        String str;
        MutableState<ql4.a> mutableState = this.g;
        LoadStatus loadStatus = LoadStatus.Empty;
        al4.a aVar = new al4.a();
        aVar.c(CommonErrorType.Empty);
        rl4.c cVar = this.a;
        if (cVar.f == ProfileTab.SubscribeWorks) {
            str = "暂无可预约内容";
        } else if (ol4.a.a(cVar.b)) {
            str = "暂无内容";
        } else {
            str = "暂无" + this.a.c + "内容";
        }
        aVar.b(str);
        Unit unit = Unit.INSTANCE;
        mutableState.setValue(new ql4.a(loadStatus, false, aVar, 2, null));
    }

    private final void d0() {
        int i;
        String str;
        Map<String, String> map;
        String str2;
        String str3;
        String str4;
        String str5;
        MutableState<ql4.a> mutableState = this.g;
        LoadStatus loadStatus = LoadStatus.Error;
        al4.a aVar = new al4.a();
        aVar.c(CommonErrorType.SPECIFIC_ERROR);
        ProfileTab profileTab = this.a.b;
        if (profileTab == null) {
            i = -1;
        } else {
            i = a.a[profileTab.ordinal()];
        }
        boolean z = true;
        String str6 = "";
        if (i != 1) {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        str = "";
                    } else {
                        com.dragon.read.kmp.profile.params.a aVar2 = this.a.p;
                        if (aVar2 == null || !aVar2.k()) {
                            z = false;
                        }
                        if (z) {
                            str = "该用户已设置隐藏收藏内容";
                        } else {
                            str = "该用户已设置隐藏追剧内容";
                        }
                    }
                } else {
                    str = "该用户已设置隐藏点赞内容";
                }
            } else {
                str = "该用户已设置隐藏出演短剧";
            }
        } else {
            str = "该用户已设置隐藏动态内容";
        }
        aVar.b(str);
        com.dragon.read.kmp.profile.params.a aVar3 = this.a.p;
        String str7 = null;
        if (aVar3 != null) {
            map = aVar3.c();
        } else {
            map = null;
        }
        v0 v0Var = v0.a;
        if (map != null) {
            str2 = map.get("lottie_light_url");
        } else {
            str2 = null;
        }
        if (!v0Var.a(str2)) {
            if (map != null) {
                str7 = map.get("lottie_dark_url");
            }
            if (!v0Var.a(str7)) {
                if (map == null || (str4 = map.get("lottie_light_url")) == null) {
                    str4 = "";
                }
                if (map != null && (str5 = map.get("lottie_dark_url")) != null) {
                    str6 = str5;
                }
                aVar.a = new Pair<>(str4, str6);
                Unit unit = Unit.INSTANCE;
                mutableState.setValue(new ql4.a(loadStatus, false, aVar, 2, null));
            }
        }
        if (map != null && (str3 = map.get("lottie_static_url")) != null) {
            str6 = str3;
        }
        aVar.a(str6);
        Unit unit2 = Unit.INSTANCE;
        mutableState.setValue(new ql4.a(loadStatus, false, aVar, 2, null));
    }

    private final void N(ym4.a aVar) {
        o.a.d("click_video", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(l lVar) {
        S(lVar, false, false, true, 3, null);
        return Unit.INSTANCE;
    }

    private final void c0(boolean z) {
        this.g.setValue(new ql4.a(LoadStatus.Loading, z, null, 4, null));
    }

    public void G(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.e = scope;
        if (this.a.m) {
            this.d.z();
        }
        this.c.d("onPageCreate start request");
    }

    private final ym4.a e0(ym4.a aVar) {
        Integer num;
        ProfileTab profileTab = this.a.d;
        Integer num2 = null;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        aVar.g("profile_tab_name", s.b(num));
        ProfileTab profileTab2 = this.a.f;
        if (profileTab2 != null) {
            num2 = Integer.valueOf(profileTab2.getValue());
        }
        aVar.g("profile_sub_tab_name", s.a(num2));
        return aVar;
    }

    private final ym4.k m(ym4.k kVar) {
        if (this.a.b == ProfileTab.Select) {
            boolean z = true;
            kVar.e("key_enable_mine_select_pic_text_consume_report", true);
            if (this.a.i.length() <= 0) {
                z = false;
            }
            if (z) {
                kVar.d("key_mine_select_profile_user_id", this.a.i);
            }
        }
        return kVar;
    }

    private final ym4.k n(ym4.k kVar) {
        if (this.a.b == ProfileTab.Select) {
            boolean z = true;
            kVar.e("key_enable_mine_select_video_consume_report", true);
            if (this.a.i.length() <= 0) {
                z = false;
            }
            if (z) {
                kVar.d("key_mine_select_profile_user_id", this.a.i);
            }
        }
        return kVar;
    }

    private final int q(String str) {
        int i = 0;
        for (Object obj : this.h.a) {
            if (obj instanceof o0) {
                if (Intrinsics.areEqual(((o0) obj).G(), str)) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    public final void I(FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        if (!this.l) {
            this.l = true;
            S(this, false, false, false, 7, null);
        } else if (this.a.j != filterOptionHeaderType) {
            S(this, false, true, false, 5, null);
            ProfileTabJustSawViewModel profileTabJustSawViewModel = this.k;
            if (profileTabJustSawViewModel != null) {
                profileTabJustSawViewModel.o(true);
            }
        }
        this.a.d(filterOptionHeaderType);
    }

    public final void Q(boolean z) {
        String str;
        ym4.a e0 = e0(new ym4.a());
        e0.j(k0.a.b().n());
        e0.g("profile_page_card", "multi_reserve_card");
        e0.g("card_size", "small_size");
        e0.g("profile_card_type", "multi_reserve_card");
        e0.g("click_to", "multi_reserve_card");
        o oVar = o.a;
        if (z) {
            str = "show_profile_page_card";
        } else {
            str = "click_profile_page_card";
        }
        oVar.d(str, e0);
    }

    public final void o(ym4.a args) {
        Integer num;
        String obj;
        boolean z;
        Intrinsics.checkNotNullParameter(args, "args");
        ProfileTab profileTab = this.a.d;
        Integer num2 = null;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        String b = s.b(num);
        args.g("profile_tab_name", b);
        args.g("profile_user_id", this.a.i);
        Object l = k0.a.b().l("enter_from");
        if (l != null && (obj = l.toString()) != null) {
            if (obj.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                obj = null;
            }
            if (obj != null) {
                b = obj;
            }
        }
        args.g("enter_from", b);
        ProfileTab profileTab2 = this.a.d;
        if (profileTab2 != null) {
            num2 = Integer.valueOf(profileTab2.getValue());
        }
        args.g("trace_enter_from", s.c(num2));
    }

    public final void z(final boolean z) {
        boolean z2;
        Disposable disposable = this.j;
        if (disposable != null && !disposable.isDisposed()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || this.a.b == null) {
            return;
        }
        if (!this.d.r()) {
            this.c.d("not more data");
            this.h.c(FootLoadingState.NOT_MORE);
            u(false, z);
            return;
        }
        this.h.c(FootLoadingState.LOADING);
        Single<List<Object>> s = this.d.s();
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Single<List<Object>> subscribeOn = s.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Single<List<Object>> observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: tl4.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit B;
                B = l.B(l.this, z, (List) obj);
                return B;
            }
        };
        Consumer<? super List<Object>> consumer = new Consumer() { // from class: tl4.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                l.C(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: tl4.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = l.D(l.this, z, (Throwable) obj);
                return D;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: tl4.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                l.E(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    private final void u(boolean z, boolean z2) {
        ProfileTabJustSawViewModel profileTabJustSawViewModel;
        ProfileTabJustSawViewModel profileTabJustSawViewModel2;
        if (z && (profileTabJustSawViewModel2 = this.k) != null) {
            profileTabJustSawViewModel2.s();
        }
        if (z2 && (profileTabJustSawViewModel = this.k) != null) {
            profileTabJustSawViewModel.q(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(bl4.a model, int i) {
        w wVar;
        Intrinsics.checkNotNullParameter(model, "model");
        ym4.a e0 = e0(model.w(i));
        if (model instanceof w) {
            wVar = (w) model;
        } else {
            wVar = null;
        }
        l(e0, wVar);
        if (model instanceof ll4.d) {
            e0.g("enter_from", "actor_page");
            o.a.d("show_reserve_card", e0);
        } else {
            o.a.d("show_video", e0);
        }
    }

    public final void l(ym4.a args, w wVar) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.a.b == ProfileTab.Select && wVar != null) {
            args.g("is_actor_interact", Integer.valueOf(!wVar.f().isEmpty() ? 1 : 0));
        }
    }

    public final void r(int i, ll4.d reservationItemModel) {
        String str;
        Intrinsics.checkNotNullParameter(reservationItemModel, "reservationItemModel");
        r4 r4Var = reservationItemModel.h.m;
        if (r4Var == null || (str = r4Var.j) == null) {
            str = "";
        }
        com.dragon.read.kmp.profile.params.a aVar = this.a.p;
        String G = reservationItemModel.G();
        ym4.k g = k0.a.b().g(e0(reservationItemModel.w(i)));
        if (aVar != null) {
            aVar.h(G, q(G), str, g);
        }
    }

    public final void x(FilterOptionHeaderType preType, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(preType, "preType");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        rl4.c cVar = this.a;
        if (cVar.j == filterOptionHeaderType) {
            return;
        }
        cVar.d(filterOptionHeaderType);
        ProfileTabJustSawViewModel profileTabJustSawViewModel = this.k;
        if (profileTabJustSawViewModel != null) {
            profileTabJustSawViewModel.o(true);
        }
        S(this, false, true, true, 1, null);
    }

    public l(rl4.c tabParam, rl4.a uiConfig) {
        Intrinsics.checkNotNullParameter(tabParam, "tabParam");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        this.a = tabParam;
        this.b = uiConfig;
        com.dragon.read.kmp.i iVar = new com.dragon.read.kmp.i("GuestProfileOneTabViewModel");
        this.c = iVar;
        this.d = new r(tabParam);
        this.e = com.dragon.read.kmp.n.a;
        this.g = SnapshotStateKt.mutableStateOf$default(new ql4.a(null, false, null, 7, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = new b0();
        iVar.d("进入客态个人页， " + tabParam);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(l lVar, Throwable th) {
        int i;
        com.dragon.read.kmp.i.c(lVar.c, "requestData error: " + th, (Throwable) null, 2, (Object) null);
        long a2 = p.a();
        yk4.b bVar = yk4.b.a;
        long a3 = a2 - bVar.a();
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        bVar.e(Integer.valueOf(i), th.getMessage(), a3, Integer.valueOf(lVar.a.b.getValue()));
        lVar.Z();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J(int i, gk4.e threeColumnSeriesPostModel) {
        w wVar;
        Intrinsics.checkNotNullParameter(threeColumnSeriesPostModel, "threeColumnSeriesPostModel");
        ym4.a p = threeColumnSeriesPostModel.p(i, "card");
        o(p);
        if (threeColumnSeriesPostModel instanceof w) {
            wVar = (w) threeColumnSeriesPostModel;
        } else {
            wVar = null;
        }
        l(p, wVar);
        ym4.k m = m(k0.a.b().g(p));
        o.a.d("click_post_card", new ym4.a().j(p));
        if (t()) {
            cl4.p a2 = u.a.a();
            rl4.c cVar = this.a;
            com.dragon.read.kmp.profile.params.a aVar = cVar.p;
            if (aVar != null) {
                aVar.f(threeColumnSeriesPostModel.a, cVar.i, m, a2);
                return;
            }
            return;
        }
        rl4.c cVar2 = this.a;
        com.dragon.read.kmp.profile.params.a aVar2 = cVar2.p;
        if (aVar2 != null) {
            aVar2.u(threeColumnSeriesPostModel.a, cVar2.i, m);
        }
    }

    public final void v(final ll4.d data, int i) {
        long j;
        SubscribeOpType subscribeOpType;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean booleanValue = ((Boolean) data.R().getValue()).booleanValue();
        String G = data.G();
        if (!(!StringsKt__StringsKt.isBlank(G))) {
            G = null;
        }
        if (G != null) {
            j = Long.parseLong(G);
        } else {
            j = 0;
        }
        long j2 = j;
        if (!booleanValue) {
            subscribeOpType = SubscribeOpType.Subscribe;
        } else {
            subscribeOpType = SubscribeOpType.CancelSubscribe;
        }
        t.f(t.a, j2, 1, subscribeOpType, null, null, new Function2() { // from class: tl4.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit w;
                w = l.w(ll4.d.this, (SubscribeOpType) obj, ((Boolean) obj2).booleanValue());
                return w;
            }
        }, 24, null);
        ym4.a w = data.w(i);
        if (booleanValue) {
            str = "reserve_cancel";
        } else {
            str = "reserve";
        }
        w.g("click_to", str);
        w.g("enter_from", "actor_page");
        o.a.d("click_reserve_card", w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(l lVar, List list) {
        FootLoadingState footLoadingState;
        Intrinsics.checkNotNull(list);
        lVar.y(list);
        boolean z = false;
        if (!list.isEmpty()) {
            long a2 = p.a();
            yk4.b bVar = yk4.b.a;
            bVar.e(0, "success size: " + list.size(), a2 - bVar.a(), Integer.valueOf(lVar.a.b.getValue()));
            com.dragon.read.kmp.i.f(lVar.c, "加载成功，" + lVar.a.c + ", " + lVar.a.b + "，size:" + list.size(), (Throwable) null, 2, (Object) null);
            lVar.h.b(list, true);
            lVar.g.setValue(new ql4.a(LoadStatus.Content, false, null, 6, null));
        } else {
            com.dragon.read.kmp.i.f(lVar.c, "请求数据为空，" + lVar.a.c + ", " + lVar.a.b, (Throwable) null, 2, (Object) null);
            lVar.Y();
        }
        dl4.b bVar2 = lVar.d.e;
        if (bVar2 != null) {
            z = bVar2.k();
        }
        b0 b0Var = lVar.h;
        if (z) {
            footLoadingState = FootLoadingState.INIT;
        } else {
            footLoadingState = FootLoadingState.GONE;
        }
        b0Var.c(footLoadingState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K(final int i, final bl4.a absVideoListItemModel) {
        w wVar;
        String str;
        Intrinsics.checkNotNullParameter(absVideoListItemModel, "absVideoListItemModel");
        com.dragon.read.kmp.profile.params.a aVar = this.a.p;
        ym4.a e0 = e0(absVideoListItemModel.w(i));
        if (absVideoListItemModel instanceof w) {
            wVar = (w) absVideoListItemModel;
        } else {
            wVar = null;
        }
        l(e0, wVar);
        dl4.b bVar = this.d.e;
        if (bVar != null) {
            bVar.g(i);
        }
        boolean z = absVideoListItemModel instanceof ll4.b;
        if (z) {
            ll4.b bVar2 = (ll4.b) absVideoListItemModel;
            Object O = bVar2.O();
            Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.dragon.read.kmp.base.model.VideoLikeModel");
            cc4.a aVar2 = (cc4.a) O;
            ym4.k g = k0.a.b().g(e0);
            if (aVar2.M) {
                if (aVar != null) {
                    aVar.n(bVar2.G(), g);
                }
            } else if (aVar != null) {
                aVar.v(bVar2.G(), aVar2, g);
            }
        } else if (absVideoListItemModel instanceof o0) {
            ym4.k g2 = k0.a.b().g(e0);
            if (absVideoListItemModel instanceof ll4.d) {
                ll4.d dVar = (ll4.d) absVideoListItemModel;
                r4 r4Var = dVar.h.m;
                if (r4Var == null || (str = r4Var.j) == null) {
                    str = "";
                }
                String str2 = str;
                String G = dVar.G();
                if (aVar != null) {
                    aVar.e(G, q(G), str2, g2, this.d.e, new Function1() { // from class: tl4.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit L;
                            L = l.L(l.this, i, absVideoListItemModel, (String) obj);
                            return L;
                        }
                    });
                }
            } else if (!(absVideoListItemModel instanceof ll4.f) && !z) {
                e0.g("clicked_content", "card");
                o.a.d("click_post_card", e0);
                String G2 = ((o0) absVideoListItemModel).G();
                n(g2);
                if (t()) {
                    cl4.p a2 = u.a.a();
                    if (aVar != null) {
                        aVar.q(G2, g2, q(G2), this.d.e, a2, this.a.b);
                    }
                } else if (aVar != null) {
                    aVar.g(G2, g2, q(G2), this.d.e, this.a.b);
                }
            } else if (this.a.b == ProfileTab.CelebrityWorks) {
                if (aVar != null) {
                    aVar.j(((o0) absVideoListItemModel).G(), g2, this.d.e);
                }
            } else if (aVar != null) {
                aVar.x(((o0) absVideoListItemModel).G(), g2);
            }
        } else if (absVideoListItemModel instanceof ul4.a) {
            ul4.a aVar3 = (ul4.a) absVideoListItemModel;
            Object O2 = aVar3.O();
            o.a.d("click_video", e0);
            if (O2 instanceof cc4.a) {
                ym4.k g3 = k0.a.b().g(e0);
                cc4.a aVar4 = (cc4.a) O2;
                if (aVar4.M) {
                    if (aVar != null) {
                        aVar.n(aVar3.G(), g3);
                    }
                } else if (aVar != null) {
                    aVar.v(aVar3.G(), aVar4, g3);
                }
            }
        } else {
            ym4.k g4 = k0.a.b().g(e0);
            if (aVar != null) {
                aVar.x(absVideoListItemModel.G(), g4);
            }
        }
        N(e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(ll4.d dVar, SubscribeOpType opType, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(opType, "opType");
        if (opType == SubscribeOpType.Subscribe) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            dVar.Q(z2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(l lVar, boolean z, Throwable th) {
        com.dragon.read.kmp.i.c(lVar.c, "load more on error " + th.getMessage(), (Throwable) null, 2, (Object) null);
        lVar.h.c(FootLoadingState.ERROR);
        lVar.u(false, z);
        return Unit.INSTANCE;
    }

    public final void M(int i, ll4.d reservationItemModel, String clickTo) {
        Intrinsics.checkNotNullParameter(reservationItemModel, "reservationItemModel");
        Intrinsics.checkNotNullParameter(clickTo, "clickTo");
        ym4.a w = reservationItemModel.w(i);
        w.g("click_to", clickTo);
        w.g("enter_from", "actor_page");
        o.a.d("click_reserve_card", w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(l lVar, boolean z, List list) {
        FootLoadingState footLoadingState;
        Intrinsics.checkNotNull(list);
        lVar.F(list);
        if (!list.isEmpty()) {
            lVar.h.a(list);
        }
        b0 b0Var = lVar.h;
        if (lVar.d.r()) {
            footLoadingState = FootLoadingState.INIT;
        } else {
            footLoadingState = FootLoadingState.NOT_MORE;
        }
        b0Var.c(footLoadingState);
        com.dragon.read.kmp.i.f(lVar.c, "load more success，load size: " + list.size() + ", total: " + lVar.h.a.size() + ", " + lVar.a.c + ", " + lVar.a.b, (Throwable) null, 2, (Object) null);
        lVar.u(true, z);
        return Unit.INSTANCE;
    }

    public final void R(boolean z, boolean z2, boolean z3) {
        rl4.c cVar = this.a;
        Integer num = null;
        boolean z4 = false;
        if (cVar.k) {
            this.c.d("当前为隐私tab： " + this.a.c + ", " + this.a.b);
            d0();
            yk4.b bVar = yk4.b.a;
            long a2 = p.a() - bVar.a();
            ProfileTab profileTab = this.a.b;
            if (profileTab != null) {
                num = Integer.valueOf(profileTab.getValue());
            }
            bVar.e(0, "隐私tab", a2, num);
            return;
        }
        if (cVar.b == null) {
            com.dragon.read.kmp.i.f(this.c, "tabParam.profileTab == null, showEmptyLayout： " + this.a.c + ", " + this.a.b, (Throwable) null, 2, (Object) null);
            Y();
            return;
        }
        if (z3) {
            this.c.a("show loading");
            c0(z2);
        }
        Disposable disposable = this.i;
        if (disposable != null && !disposable.isDisposed()) {
            z4 = true;
        }
        if (z4) {
            this.c.d("requestData isDisposed false");
            return;
        }
        Single<List<Object>> k = this.d.k(z2);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Single<List<Object>> subscribeOn = k.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Single<List<Object>> observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: tl4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T;
                T = l.T(l.this, (List) obj);
                return T;
            }
        };
        Consumer<? super List<Object>> consumer = new Consumer() { // from class: tl4.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                l.U(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: tl4.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W;
                W = l.W(l.this, (Throwable) obj);
                return W;
            }
        };
        this.i = observeOn.subscribe(consumer, new Consumer() { // from class: tl4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                l.X(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(l lVar, int i, bl4.a aVar, String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        lVar.M(i, (ll4.d) aVar, it2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void A(l lVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            lVar.z(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadMore");
    }

    public final void O(bl4.a model, int i, int i2, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(model, "model");
        ym4.a e0 = e0(model.w(i));
        e0.g("profile_page_card", "multi_reserve_card");
        if (i2 == 0) {
            str = "small_size";
        } else {
            str = "big_size";
        }
        e0.g("card_size", str);
        e0.g("profile_card_type", "multi_reserve_card");
        e0.g("click_to", "multi_reserve_card");
        e0.g("module_rank", Integer.valueOf(i));
        o oVar = o.a;
        if (z) {
            str2 = "show_profile_page_card";
        } else {
            str2 = "click_profile_page_card";
        }
        oVar.d(str2, e0);
    }

    public static /* synthetic */ void S(l lVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                z3 = true;
            }
            lVar.R(z, z2, z3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestData");
    }
}

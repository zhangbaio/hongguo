package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.TextExtType;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.bm0;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.dl0;
import com.bytedance.kmp.reading.model.ej;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.l10;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.q2;
import com.bytedance.kmp.reading.model.tl0;
import com.bytedance.kmp.reading.model.xk0;
import com.bytedance.kmp.reading.model.xm;
import com.bytedance.kmp.reading.model.ym;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.guestprofile.GuestProfileStarFansRewardUseCase;
import com.dragon.read.kmp.profile.guestprofile.n;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.b;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.e1;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.m0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import com.dragon.read.rpc.kmp.community.model.d7;
import gk4.k0;
import gk4.l0;
import gk4.u;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.v2;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class GuestProfileViewModel {
    public static final a U;
    private static int V;
    private boolean A;
    private Pair<Boolean, Integer> B;
    private Job C;
    private boolean D;
    private boolean E;
    private boolean F;
    private Job G;
    private String H;
    private Job I;
    private String J;
    private String K;
    private String L;
    private String M;
    private boolean N;
    public final MutableState<List<fl4.j>> O;
    public final MutableState<Boolean> P;
    private final List<String> Q;
    public final MutableState<Boolean> R;
    public final MutableState<Boolean> S;
    private long T;
    public com.dragon.read.kmp.profile.guestprofile.viewmodel.a a;
    public final com.dragon.read.kmp.i b;
    private final com.dragon.read.kmp.profile.guestprofile.n c;
    private final GuestProfileStarFansRewardUseCase d;
    public CoroutineScope e;
    public com.dragon.read.kmp.profile.params.a f;
    private final Lazy g;
    public dl4.t h;
    private String i;
    public final MutableState<g0> j;
    public final MutableState<List<c7>> k;
    public MutableStateFlow<f0> l;
    private final MutableSharedFlow<b> m;
    public final SharedFlow<b> n;
    public Function0<Unit> o;
    public androidx.compose.ui.layout.w p;
    private Disposable q;
    public final MutableState<LoadStatus> r;
    public final mg4.b s;
    public ProfileTab t;
    public final MutableState<Integer> u;
    private boolean v;
    private final Lazy w;
    private final Lazy x;
    public final MutableState<Pair<Boolean, Integer>> y;
    public final MutableState<Boolean> z;

    public final void J0(int i) {
    }

    public final boolean n1() {
        return false;
    }

    public final void A0() {
        m0().f();
    }

    public final void B0() {
        m0().g();
    }

    public final void X() {
        this.P.setValue(Boolean.TRUE);
    }

    public final String r0() {
        return this.a.b;
    }

    private final void V0() {
        if (k0()) {
            fl4.p.a.v(r0());
        }
    }

    private final void Z() {
        if (!this.N) {
            this.N = true;
            this.b.d("guardPrefetch disabled by star fans task");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a0() {
        return k0.Companion.a().a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0() {
        return l0.Companion.a().a;
    }

    private final boolean k0() {
        return ((Boolean) this.w.getValue()).booleanValue();
    }

    private final boolean l0() {
        return ((Boolean) this.x.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v0() {
        if (!gk4.u.Companion.a().a) {
            return true;
        }
        return this.A;
    }

    public final com.dragon.read.kmp.profile.guestprofile.o m0() {
        return (com.dragon.read.kmp.profile.guestprofile.o) this.g.getValue();
    }

    public final int q0() {
        return ((List) this.k.getValue()).size();
    }

    public final void z0() {
        Function0<Unit> function0 = this.o;
        if (function0 != null) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        zm4.d.a.b();
    }

    static {
        Covode.recordClassIndex(608185);
        U = new a(null);
        V = FilterOptionHeaderType.LATEST_TYPE.getValue();
    }

    private final void h1() {
        com.dragon.read.kmp.r.a.y(r0(), com.dragon.read.kmp.utils.k0.a.b(), p0());
    }

    public final void G0() {
        this.v = false;
        m0().h();
        this.E = false;
        Job job = this.G;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.G = null;
    }

    public final void I0() {
        Job job = this.G;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.I;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void Q0() {
        this.v = true;
        m0().i();
        i0();
        h0();
    }

    private final void h0() {
        String str = this.H;
        if (str == null) {
            return;
        }
        this.H = null;
        this.b.d("starFansToast flush pending fail effect, targetUserId=" + r0() + ", errTips=" + str);
        this.m.tryEmit(new b.C0032b(str));
    }

    private final void p1() {
        if (this.a.l && !this.F) {
            boolean z = true;
            this.F = true;
            if (!com.dragon.read.kmp.service.c0.a.isLogin()) {
                return;
            }
            g0 g0Var = (g0) this.j.getValue();
            if (g0Var == null || c0.c(g0Var)) {
                z = false;
            }
            if (!z) {
                return;
            }
            R0();
        }
    }

    public final void W() {
        com.dragon.read.kmp.r.a.h(r0(), "more");
        String b = e1.a.b(r0());
        if (b != null) {
            zm4.d.a.c(b, null, com.dragon.read.kmp.utils.k0.a.b());
        }
    }

    public final void b1() {
        String str;
        if (((Number) ((Pair) this.y.getValue()).getSecond()).intValue() == 2) {
            str = "profile_consume_duration";
        } else {
            str = "enter_profile_count";
        }
        com.dragon.read.kmp.r.o(com.dragon.read.kmp.r.a, true, "follow_guide_popup", str, "follow_user", (String) null, 16, (Object) null);
    }

    private final void Q() {
        if (!k0()) {
            return;
        }
        g0 g0Var = (g0) this.j.getValue();
        boolean z = false;
        if (g0Var != null && !c0.c(g0Var)) {
            z = true;
        }
        if (z) {
            return;
        }
        fl4.p pVar = fl4.p.a;
        if (pVar.r(r0()) && pVar.q(r0())) {
            if (v0()) {
                this.y.setValue(TuplesKt.to(Boolean.TRUE, 1));
                c1();
            } else {
                this.B = TuplesKt.to(Boolean.TRUE, 1);
            }
        }
    }

    private final void c0() {
        eo eoVar;
        String str;
        if (!l0()) {
            return;
        }
        fl4.p pVar = fl4.p.a;
        if (pVar.s() && (eoVar = this.l.getValue().a) != null) {
            cj0 cj0Var = eoVar.a;
            if (cj0Var == null || (str = cj0Var.a) == null) {
                str = "";
            }
            Observable f = UserApiService.f(UserApiService.a, new xm(str, (Integer) null, pVar.n(), 2, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
            KSchedulers kSchedulers = KSchedulers.INSTANCE;
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "io()");
            Observable subscribeOn = f.subscribeOn(io2);
            final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit d0;
                    d0 = GuestProfileViewModel.d0(GuestProfileViewModel.this, (ym) obj);
                    return d0;
                }
            };
            Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.r
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    GuestProfileViewModel.e0(Function1.this, obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit f0;
                    f0 = GuestProfileViewModel.f0(GuestProfileViewModel.this, (Throwable) obj);
                    return f0;
                }
            };
            subscribeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.t
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    GuestProfileViewModel.g0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        String str;
        this.z.setValue(Boolean.valueOf(gk4.q.Companion.a().c));
        if (((Number) ((Pair) this.y.getValue()).getSecond()).intValue() == 2) {
            str = "profile_consume_duration";
        } else {
            str = "enter_profile_count";
        }
        String str2 = str;
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        com.dragon.read.kmp.r.o(rVar, false, "follow_guide_popup", str2, (String) null, (String) null, 24, (Object) null);
        rVar.z(r0(), com.dragon.read.kmp.utils.k0.a.b(), p0(), "follow_guide_popup");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.c(r0) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i0() {
        /*
            r8 = this;
            boolean r0 = r8.k0()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8.D
            r1 = 0
            if (r0 == 0) goto L53
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> r0 = r8.j
            java.lang.Object r0 = r0.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 r0 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) r0
            if (r0 == 0) goto L1e
            boolean r0 = com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.c(r0)
            r2 = 1
            if (r0 != r2) goto L1e
            goto L1f
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L53
            fl4.p r0 = fl4.p.a
            java.lang.String r2 = r8.r0()
            boolean r0 = r0.q(r2)
            if (r0 == 0) goto L53
            boolean r0 = r8.v0()
            r2 = 2
            if (r0 == 0) goto L47
            androidx.compose.runtime.MutableState<kotlin.Pair<java.lang.Boolean, java.lang.Integer>> r0 = r8.y
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r3, r2)
            r0.setValue(r2)
            r8.c1()
            goto L53
        L47:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
            r8.B = r0
        L53:
            r8.D = r1
            kotlinx.coroutines.Job r0 = r8.C
            if (r0 != 0) goto L78
            gk4.j0$b r0 = gk4.j0.Companion
            gk4.j0 r0 = r0.a()
            int r0 = r0.f
            long r0 = (long) r0
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            kotlinx.coroutines.CoroutineScope r2 = r8.e
            r3 = 0
            r4 = 0
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$followTipsOnVisible$1 r5 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$followTipsOnVisible$1
            r6 = 0
            r5.<init>(r0, r8, r6)
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
            r8.C = r0
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.i0():void");
    }

    public final void E0() {
        Integer num;
        g0 g0Var = (g0) this.j.getValue();
        boolean z = false;
        if (g0Var != null && c0.c(g0Var)) {
            z = true;
        }
        if (!z) {
            R0();
            return;
        }
        g0 g0Var2 = (g0) this.j.getValue();
        if (g0Var2 != null && (num = g0Var2.d) != null) {
            com.dragon.read.kmp.profile.guestprofile.n.z(this.c, r0(), Integer.valueOf(num.intValue()), "profile", null, new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit F0;
                    F0 = GuestProfileViewModel.F0(GuestProfileViewModel.this);
                    return F0;
                }
            }, null, 40, null);
        }
    }

    public final void K0() {
        cj0 cj0Var;
        boolean d;
        Long l;
        Z();
        eo eoVar = this.l.getValue().a;
        Integer num = null;
        if (eoVar != null) {
            cj0Var = eoVar.a;
        } else {
            cj0Var = null;
        }
        if (cj0Var == null) {
            this.b.d("starFansToast onTaskDone skip, ugcUser not ready, targetUserId=" + r0());
            return;
        }
        d = c0.d(cj0Var);
        if (!d) {
            com.dragon.read.kmp.i iVar = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("starFansToast onTaskDone skip, not registered actor, userId=");
            sb.append(cj0Var.a);
            sb.append(", actorId=");
            ok0 ok0Var = cj0Var.b;
            if (ok0Var != null) {
                l = ok0Var.l;
            } else {
                l = null;
            }
            sb.append(l);
            sb.append(", actorType=");
            tl0 tl0Var = cj0Var.d;
            if (tl0Var != null) {
                num = tl0Var.j;
            }
            sb.append(num);
            iVar.d(sb.toString());
            return;
        }
        k1(cj0Var, "onTaskDone");
    }

    public final void e1() {
        String str;
        boolean z;
        cj0 cj0Var;
        ok0 ok0Var;
        f0 value = this.l.getValue();
        eo eoVar = value.a;
        String str2 = null;
        if (eoVar != null) {
            str = eoVar.h;
        } else {
            str = null;
        }
        boolean z2 = false;
        if (StringUtilsKt.a(str) && com.dragon.read.kmp.u.f()) {
            z = false;
        } else {
            z = true;
        }
        eo eoVar2 = value.a;
        if (eoVar2 != null && (cj0Var = eoVar2.a) != null && (ok0Var = cj0Var.b) != null) {
            str2 = ok0Var.f;
        }
        if (!StringUtilsKt.a(str2) || !com.dragon.read.kmp.u.f()) {
            z2 = true;
        }
        com.dragon.read.kmp.r.a.q(com.dragon.read.kmp.utils.k0.a.b(), r0(), z, z2);
    }

    public final void q1() {
        Job e;
        cj0 cj0Var;
        if (this.E) {
            this.b.d("starFansToast skip, already requested in current visible session");
            return;
        }
        eo eoVar = this.l.getValue().a;
        if (eoVar != null && (cj0Var = eoVar.a) != null) {
            this.b.d("starFansToast hit cached profile, userId=" + cj0Var.a);
            u0(cj0Var);
            return;
        }
        this.b.d("starFansToast wait profile loaded, targetUserId=" + r0());
        Job job = this.G;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        e = kotlinx.coroutines.i.e(this.e, null, null, new GuestProfileViewModel$tryCheckStarFansRewardToast$2(this, null), 3, null);
        this.G = e;
    }

    private final HashMap<String, Object> p0() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        cj0 cj0Var;
        tl0 tl0Var;
        List list;
        Object firstOrNull;
        Long l;
        HashMap<String, Object> hashMap = new HashMap<>();
        eo eoVar = this.l.getValue().a;
        if (eoVar != null && (cj0Var = eoVar.a) != null && (tl0Var = cj0Var.d) != null && (list = tl0Var.r) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            q2 q2Var = (q2) firstOrNull;
            if (q2Var != null && (l = q2Var.c) != null) {
                hashMap.put("decoration_id", Long.valueOf(l.longValue()));
            }
        }
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        Object l2 = b.l("profile_position");
        String str6 = null;
        if (l2 instanceof String) {
            str = (String) l2;
        } else {
            str = null;
        }
        if (str != null) {
            if (!StringUtilsKt.a(str)) {
                str = null;
            }
            if (str != null) {
                hashMap.put("profile_position", str);
            }
        }
        Object l3 = b.l("profile_tag");
        if (l3 instanceof String) {
            str2 = (String) l3;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            if (!StringUtilsKt.a(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                hashMap.put("profile_tag", str2);
            }
        }
        Object l4 = b.l("src_material_id");
        if (l4 instanceof String) {
            str3 = (String) l4;
        } else {
            str3 = null;
        }
        if (str3 != null) {
            if (!StringUtilsKt.a(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                hashMap.put("src_material_id", str3);
            }
        }
        Object l5 = b.l("material_id");
        if (l5 instanceof String) {
            str4 = (String) l5;
        } else {
            str4 = null;
        }
        if (str4 != null) {
            if (!StringUtilsKt.a(str4)) {
                str4 = null;
            }
            if (str4 != null) {
                hashMap.put("material_id", str4);
            }
        }
        Object l6 = b.l("post_card_id");
        if (l6 instanceof String) {
            str5 = (String) l6;
        } else {
            str5 = null;
        }
        if (str5 != null) {
            if (StringUtilsKt.a(str5)) {
                str6 = str5;
            }
            if (str6 != null) {
                hashMap.put("post_card_id", str6);
            }
        }
        return hashMap;
    }

    public final void R0() {
        String str;
        boolean z;
        String str2;
        String str3;
        cj0 cj0Var;
        String str4;
        cj0 cj0Var2;
        ok0 ok0Var;
        l10 l10Var;
        eo eoVar = this.l.getValue().a;
        String str5 = null;
        if (eoVar != null && (l10Var = eoVar.i) != null) {
            str = l10Var.d;
        } else {
            str = null;
        }
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.b.d("openGuardSchema skip, schema is null or empty");
            return;
        }
        com.dragon.read.kmp.service.c0 c0Var = com.dragon.read.kmp.service.c0.a;
        if (c0Var.isLogin()) {
            str2 = c0Var.getUserId();
        } else {
            str2 = "";
        }
        if (eoVar == null || (cj0Var2 = eoVar.a) == null || (ok0Var = cj0Var2.b) == null || (str3 = ok0Var.a) == null) {
            if (eoVar != null && (cj0Var = eoVar.a) != null) {
                str3 = cj0Var.a;
            } else {
                str3 = null;
            }
        }
        String str6 = this.M;
        if (str6 != null) {
            if (com.dragon.read.kmp.star_fans.f.Companion.a().c && !this.N && Intrinsics.areEqual(this.K, str2) && Intrinsics.areEqual(this.L, str3)) {
                z2 = true;
            }
            if (z2) {
                str5 = str6;
            }
            if (str5 != null) {
                str4 = str5;
                zm4.d.d(zm4.d.a, str4, null, m0.a(), 2, null);
            }
        }
        str4 = str;
        zm4.d.d(zm4.d.a, str4, null, m0.a(), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0() {
        /*
            r12 = this;
            com.dragon.read.kmp.star_fans.f$b r0 = com.dragon.read.kmp.star_fans.f.Companion
            com.dragon.read.kmp.star_fans.f r0 = r0.a()
            boolean r0 = r0.c
            if (r0 != 0) goto Lb
            return
        Lb:
            boolean r0 = r12.N
            if (r0 == 0) goto L10
            return
        L10:
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r0 = r12.l
            java.lang.Object r0 = r0.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r0 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r0
            com.bytedance.kmp.reading.model.eo r0 = r0.a
            if (r0 != 0) goto L1d
            return
        L1d:
            com.bytedance.kmp.reading.model.l10 r1 = r0.i
            r2 = 0
            if (r1 == 0) goto L25
            java.lang.String r1 = r1.d
            goto L26
        L25:
            r1 = r2
        L26:
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L33
            int r1 = r1.length()
            if (r1 != 0) goto L31
            goto L33
        L31:
            r1 = 0
            goto L34
        L33:
            r1 = 1
        L34:
            if (r1 == 0) goto L37
            return
        L37:
            com.bytedance.kmp.reading.model.cj0 r0 = r0.a
            if (r0 == 0) goto L43
            com.bytedance.kmp.reading.model.ok0 r1 = r0.b
            if (r1 == 0) goto L43
            java.lang.String r1 = r1.a
            if (r1 != 0) goto L47
        L43:
            if (r0 == 0) goto L49
            java.lang.String r1 = r0.a
        L47:
            r6 = r1
            goto L4a
        L49:
            r6 = r2
        L4a:
            if (r6 == 0) goto L55
            int r0 = r6.length()
            if (r0 != 0) goto L53
            goto L55
        L53:
            r0 = 0
            goto L56
        L55:
            r0 = 1
        L56:
            if (r0 == 0) goto L59
            return
        L59:
            com.dragon.read.kmp.service.c0 r0 = com.dragon.read.kmp.service.c0.a
            boolean r1 = r0.isLogin()
            if (r1 != 0) goto L62
            return
        L62:
            java.lang.String r8 = r0.getUserId()
            int r0 = r8.length()
            if (r0 != 0) goto L6d
            r3 = 1
        L6d:
            if (r3 == 0) goto L70
            return
        L70:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r0 = r12.R
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7f
            return
        L7f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r1 = 35
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r12.J
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r1 == 0) goto L9c
            return
        L9c:
            r12.J = r0
            r12.K = r2
            r12.L = r2
            r12.M = r2
            kotlinx.coroutines.Job r0 = r12.I
            if (r0 == 0) goto Lab
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, r2, r4, r2)
        Lab:
            long r9 = com.dragon.read.kmp.utils.p.a()
            kotlinx.coroutines.CoroutineScope r0 = r12.e
            r1 = 0
            r2 = 0
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1 r3 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1
            r11 = 0
            r5 = r3
            r7 = r12
            r5.<init>(r6, r7, r8, r9, r11)
            r4 = 3
            r5 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
            r12.I = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.U0():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608186);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i) {
            GuestProfileViewModel.V = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(GuestProfileViewModel guestProfileViewModel) {
        ig4.g.b("关注成功", (ToastDuration) null, 2, (Object) null);
        guestProfileViewModel.R0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.u1(guestProfileViewModel.r0());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.profile.guestprofile.o s0(GuestProfileViewModel guestProfileViewModel) {
        return new com.dragon.read.kmp.profile.guestprofile.o(guestProfileViewModel, guestProfileViewModel.a.c);
    }

    public final void f1(String clickedContent) {
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        com.dragon.read.kmp.r.a.x(r0(), clickedContent, com.dragon.read.kmp.utils.k0.a.b(), p0());
    }

    public final void E1(float f) {
        boolean z;
        u.b bVar = gk4.u.Companion;
        if (!bVar.a().a || this.A) {
            return;
        }
        if (bVar.a().b * b1.a.n() <= f) {
            z = true;
        } else {
            z = false;
        }
        this.A = z;
        Pair<Boolean, Integer> pair = this.B;
        if (pair != null && z) {
            this.y.setValue(pair);
            c1();
            this.B = null;
        }
    }

    public final void s1(boolean z) {
        if (this.l.getValue().a == null) {
            return;
        }
        MutableStateFlow<f0> mutableStateFlow = this.l;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), f0.b(this.l.getValue(), null, null, null, false, false, z, 31, null))) {
        }
    }

    private final JsonObject T0(String str) {
        Object m773constructorimpl;
        List listOfNotNull;
        List<String> distinct;
        Object m773constructorimpl2;
        JsonObject jsonObject;
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(com.bytedance.kmp.network.g.f(str, false, 2, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new String[]{str, (String) m773constructorimpl});
        distinct = CollectionsKt___CollectionsKt.distinct(listOfNotNull);
        for (String str2 : distinct) {
            try {
                Result.Companion companion3 = Result.Companion;
                JsonObject e = gn6.a.d.e(str2);
                if (e instanceof JsonObject) {
                    jsonObject = e;
                } else {
                    jsonObject = null;
                }
                m773constructorimpl2 = Result.m773constructorimpl(jsonObject);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                m773constructorimpl2 = Result.m773constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m779isFailureimpl(m773constructorimpl2)) {
                m773constructorimpl2 = null;
            }
            JsonObject jsonObject2 = (JsonObject) m773constructorimpl2;
            if (jsonObject2 != null) {
                return jsonObject2;
            }
        }
        return null;
    }

    private final String o1(HashMap<String, Object> hashMap) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Number) {
                gn6.e.b(jsonObjectBuilder, key, (Number) value);
            } else if (value instanceof String) {
                gn6.e.c(jsonObjectBuilder, key, (String) value);
            } else if (value instanceof Boolean) {
                gn6.e.a(jsonObjectBuilder, key, (Boolean) value);
            } else if (value instanceof JsonObject) {
                jsonObjectBuilder.put(key, (JsonElement) value);
            } else if (value instanceof JsonArray) {
                jsonObjectBuilder.put(key, (JsonElement) value);
            }
        }
        return jsonObjectBuilder.build().toString();
    }

    private final void t1(cj0 cj0Var) {
        tl0 tl0Var;
        List list;
        String str;
        List split$default;
        Map<String, ? extends Object> mapOf;
        if (cj0Var == null || (tl0Var = cj0Var.d) == null || (list = tl0Var.g) == null || list.isEmpty()) {
            return;
        }
        Object l = m0.a().l("profile_tag");
        if (l instanceof String) {
            str = (String) l;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) split$default);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = ((bm0) it2.next()).b;
            if (str2 != null && !mutableList.contains(str2)) {
                mutableList.add(str2);
            }
        }
        com.dragon.read.kmp.utils.k0 k0Var = com.dragon.read.kmp.utils.k0.a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("profile_tag", CollectionsKt___CollectionsKt.joinToString$default(mutableList, "/", null, null, 0, null, null, 62, null)));
        k0Var.d(mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(cj0 cj0Var) {
        boolean d;
        Long l;
        if (this.E) {
            this.b.d("starFansToast skip in handle, already requested in current visible session");
            return;
        }
        Job job = this.G;
        Integer num = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.G = null;
        d = c0.d(cj0Var);
        if (!d) {
            com.dragon.read.kmp.i iVar = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("starFansToast skip, not registered actor, userId=");
            sb.append(cj0Var.a);
            sb.append(", actorId=");
            ok0 ok0Var = cj0Var.b;
            if (ok0Var != null) {
                l = ok0Var.l;
            } else {
                l = null;
            }
            sb.append(l);
            sb.append(", actorType=");
            tl0 tl0Var = cj0Var.d;
            if (tl0Var != null) {
                num = tl0Var.j;
            }
            sb.append(num);
            iVar.d(sb.toString());
            return;
        }
        this.E = true;
        k1(cj0Var, "onVisible");
    }

    public GuestProfileViewModel(com.dragon.read.kmp.profile.guestprofile.viewmodel.a pageParam) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(pageParam, "pageParam");
        this.a = pageParam;
        this.b = new com.dragon.read.kmp.i("GuestProfileViewModel");
        this.c = new com.dragon.read.kmp.profile.guestprofile.n(this);
        com.dragon.read.kmp.i iVar = null;
        this.d = new GuestProfileStarFansRewardUseCase(iVar, 1, iVar);
        this.e = com.dragon.read.kmp.n.a;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.profile.guestprofile.o s0;
                s0 = GuestProfileViewModel.s0(GuestProfileViewModel.this);
                return s0;
            }
        });
        this.g = lazy;
        this.h = new dl4.t();
        this.i = "";
        this.j = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.k = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.l = StateFlowKt.MutableStateFlow(new f0(null, null, null, false, false, false, 62, null));
        MutableSharedFlow<b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.m = MutableSharedFlow$default;
        this.n = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.r = SnapshotStateKt.mutableStateOf$default(LoadStatus.Loading, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.s = new mg4.b((String) null, new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit S0;
                S0 = GuestProfileViewModel.S0(GuestProfileViewModel.this);
                return S0;
            }
        }, (String) null, (Function0) null, (androidx.compose.ui.graphics.l0) null, 29, (DefaultConstructorMarker) null);
        this.u = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.v = true;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean a0;
                a0 = GuestProfileViewModel.a0();
                return Boolean.valueOf(a0);
            }
        });
        this.w = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean b0;
                b0 = GuestProfileViewModel.b0();
                return Boolean.valueOf(b0);
            }
        });
        this.x = lazy3;
        Boolean bool = Boolean.FALSE;
        this.y = SnapshotStateKt.mutableStateOf$default(new Pair(bool, 0), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.z = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.O = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.P = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.Q = new ArrayList();
        this.R = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(com.dragon.read.kmp.u.a()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.S = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final void L0(String str) {
        cj0 cj0Var;
        boolean d;
        Long l;
        eo eoVar = this.l.getValue().a;
        Integer num = null;
        if (eoVar != null) {
            cj0Var = eoVar.a;
        } else {
            cj0Var = null;
        }
        if (cj0Var != null) {
            d = c0.d(cj0Var);
            if (!d) {
                com.dragon.read.kmp.i iVar = this.b;
                StringBuilder sb = new StringBuilder();
                sb.append("starFansToast onTaskDoneFailed skip, not registered actor, userId=");
                sb.append(cj0Var.a);
                sb.append(", actorId=");
                ok0 ok0Var = cj0Var.b;
                if (ok0Var != null) {
                    l = ok0Var.l;
                } else {
                    l = null;
                }
                sb.append(l);
                sb.append(", actorType=");
                tl0 tl0Var = cj0Var.d;
                if (tl0Var != null) {
                    num = tl0Var.j;
                }
                sb.append(num);
                iVar.d(sb.toString());
                return;
            }
            if (this.v) {
                this.b.d("starFansToast emit fail effect now, targetUserId=" + r0() + ", errTips=" + str);
                this.m.tryEmit(new b.C0032b(str));
                return;
            }
            this.b.d("starFansToast cache pending fail tip, targetUserId=" + r0() + ", errTips=" + str);
            this.H = str;
            return;
        }
        this.b.d("starFansToast onTaskDoneFailed skip, ugcUser not ready, targetUserId=" + r0());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x005e, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0065, code lost:
    
        if (r4.intValue() != r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        if (r4 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
    
        if (r3 >= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        r6.b.d("onStarTaskClaimed skip, target tab not shown, taskType=" + r7 + ", targetTab=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0092, code lost:
    
        r6.b.d("onStarTaskClaimed emit FocusTab, taskType=" + r7 + ", targetTab=" + r0 + ", index=" + r3);
        r6.m.tryEmit(new com.dragon.read.kmp.profile.guestprofile.viewmodel.b.a(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x001e, code lost:
    
        if (r7.equals("community_news_like_or_comment") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Select;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0028, code lost:
    
        if (r7.equals("community_browse_news") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0035, code lost:
    
        if (r7.equals("community_browse_feed") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r7.equals("community_feed_like_or_comment") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0039, code lost:
    
        r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Video;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003b, code lost:
    
        Z();
        r1 = ((java.util.List) r6.k.getValue()).iterator();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0050, code lost:
    
        if (r1.hasNext() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0052, code lost:
    
        r4 = ((com.dragon.read.rpc.kmp.community.model.c7) r1.next()).b;
        r5 = r0.getValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M0(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "taskType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.hashCode()
            switch(r0) {
                case -143821091: goto L2f;
                case -143582190: goto L22;
                case 987947733: goto L18;
                case 1906198432: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto Lc1
        Lf:
            java.lang.String r0 = "community_feed_like_or_comment"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto Lc1
            goto L39
        L18:
            java.lang.String r0 = "community_news_like_or_comment"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L2c
            goto Lc1
        L22:
            java.lang.String r0 = "community_browse_news"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L2c
            goto Lc1
        L2c:
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Select
            goto L3b
        L2f:
            java.lang.String r0 = "community_browse_feed"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L39
            goto Lc1
        L39:
            com.dragon.read.rpc.kmp.community.model.ProfileTab r0 = com.dragon.read.rpc.kmp.community.model.ProfileTab.Video
        L3b:
            r6.Z()
            androidx.compose.runtime.MutableState<java.util.List<com.dragon.read.rpc.kmp.community.model.c7>> r1 = r6.k
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L4c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L70
            java.lang.Object r4 = r1.next()
            com.dragon.read.rpc.kmp.community.model.c7 r4 = (com.dragon.read.rpc.kmp.community.model.c7) r4
            java.lang.Integer r4 = r4.b
            int r5 = r0.getValue()
            if (r4 != 0) goto L61
            goto L69
        L61:
            int r4 = r4.intValue()
            if (r4 != r5) goto L69
            r4 = 1
            goto L6a
        L69:
            r4 = 0
        L6a:
            if (r4 == 0) goto L6d
            goto L71
        L6d:
            int r3 = r3 + 1
            goto L4c
        L70:
            r3 = -1
        L71:
            java.lang.String r1 = ", targetTab="
            if (r3 >= 0) goto L92
            com.dragon.read.kmp.i r2 = r6.b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onStarTaskClaimed skip, target tab not shown, taskType="
            r3.append(r4)
            r3.append(r7)
            r3.append(r1)
            r3.append(r0)
            java.lang.String r7 = r3.toString()
            r2.d(r7)
            return
        L92:
            com.dragon.read.kmp.i r2 = r6.b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onStarTaskClaimed emit FocusTab, taskType="
            r4.append(r5)
            r4.append(r7)
            r4.append(r1)
            r4.append(r0)
            java.lang.String r7 = ", index="
            r4.append(r7)
            r4.append(r3)
            java.lang.String r7 = r4.toString()
            r2.d(r7)
            kotlinx.coroutines.flow.MutableSharedFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.b> r7 = r6.m
            com.dragon.read.kmp.profile.guestprofile.viewmodel.b$a r0 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.b$a
            r0.<init>(r3)
            r7.tryEmit(r0)
            return
        Lc1:
            com.dragon.read.kmp.i r0 = r6.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onStarTaskClaimed skip, unsupported taskType="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.d(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.M0(java.lang.String):void");
    }

    public final List<ej> o0(f0 profileState) {
        cj0 cj0Var;
        xk0 xk0Var;
        List<ej> list;
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        ArrayList arrayList = new ArrayList();
        eo eoVar = profileState.a;
        if (eoVar != null && (cj0Var = eoVar.a) != null && (xk0Var = cj0Var.g) != null && (list = xk0Var.d) != null) {
            ej ejVar = null;
            for (ej ejVar2 : list) {
                Integer num = ejVar2.a;
                int value = TextExtType.Workplace.getValue();
                if (num != null && num.intValue() == value) {
                    ejVar = ejVar2;
                } else {
                    Integer num2 = ejVar2.a;
                    int value2 = TextExtType.ProfessionalTitle.getValue();
                    if (num2 != null && num2.intValue() == value2) {
                        if (ejVar != null && StringUtilsKt.a(ejVar2.b)) {
                            ej ejVar3 = new ej((Integer) null, (String) null, (List) null, (List) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, 1023, (DefaultConstructorMarker) null);
                            ejVar3.b = ejVar.b + " · " + ejVar2.b;
                            arrayList.add(ejVar3);
                        } else if (StringUtilsKt.a(ejVar2.b)) {
                            arrayList.add(ejVar2);
                        }
                    } else {
                        arrayList.add(ejVar2);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void u1(final String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (Intrinsics.areEqual(userId, this.i)) {
            com.dragon.read.kmp.j.a.d("GuestProfile", "same userId, give up request!");
            m0().j();
            return;
        }
        this.r.setValue(LoadStatus.Loading);
        Observable<eo> q = this.c.q(userId);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<eo> observeOn = q.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v1;
                v1 = GuestProfileViewModel.v1(GuestProfileViewModel.this, userId, (eo) obj);
                return v1;
            }
        };
        Consumer<? super eo> consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.w1(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x1;
                x1 = GuestProfileViewModel.x1(GuestProfileViewModel.this, (Throwable) obj);
                return x1;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.y1(Function1.this, obj);
            }
        });
        final long a2 = com.dragon.read.kmp.utils.p.a();
        com.dragon.read.kmp.profile.guestprofile.viewmodel.a aVar = this.a;
        Integer num = aVar.m;
        aVar.m = null;
        Observable d = n.a.d(com.dragon.read.kmp.profile.guestprofile.n.d, userId, null, null, aVar.i, Boolean.valueOf(aVar.k), Boolean.valueOf(this.a.e), this.a.j, num, 6, null);
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = d.subscribeOn(io2);
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z1;
                z1 = GuestProfileViewModel.z1(a2, this, (d7) obj);
                return z1;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.A1(Function1.this, obj);
            }
        };
        final Function1 function14 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit B1;
                B1 = GuestProfileViewModel.B1(a2, this, userId, (Throwable) obj);
                return B1;
            }
        };
        this.q = subscribeOn.subscribe(consumer2, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.C1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(GuestProfileViewModel guestProfileViewModel, Throwable th) {
        com.dragon.read.kmp.i.c(guestProfileViewModel.b, "onGuardButtonClick requestLoginUserProfile error: " + th, (Throwable) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(GuestProfileViewModel guestProfileViewModel, Throwable th) {
        com.dragon.read.kmp.i.c(guestProfileViewModel.b, "onGuardButtonClick requestGuestProfile error: " + th, (Throwable) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(GuestProfileViewModel guestProfileViewModel, Throwable th) {
        com.dragon.read.kmp.i.c(guestProfileViewModel.b, "requestFollowGuideUserList error: " + th, (Throwable) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    private final HashMap<String, String> j0(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("enter_source", "other_user_profile_page");
        if (str == null) {
            str = "";
        }
        hashMap.put("current_click_honor_id", str);
        hashMap.put("enter_id", str2);
        return hashMap;
    }

    public final void H0(CoroutineScope scope, Context context) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = scope;
        u1(r0());
        V0();
    }

    public final void x0(String url, ym4.k pageRecorder) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        HashMap<String, Object> p0 = p0();
        pageRecorder.d("reportFrom", o1(p0));
        zm4.d.a.c(url, p0, pageRecorder);
    }

    private final void W0(final Function2<? super String, ? super String, Unit> function2, final Function2<? super String, ? super String, Unit> function22) {
        Observable<eo> q = this.c.q(r0());
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<eo> observeOn = q.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = GuestProfileViewModel.X0(GuestProfileViewModel.this, function2, function22, (eo) obj);
                return X0;
            }
        };
        Consumer<? super eo> consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.Y0(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Z0;
                Z0 = GuestProfileViewModel.Z0(GuestProfileViewModel.this, (Throwable) obj);
                return Z0;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.a1(Function1.this, obj);
            }
        });
    }

    public final void D1(String userId, Integer num) {
        g0 a2;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (Intrinsics.areEqual(userId, r0())) {
            g0 g0Var = (g0) this.j.getValue();
            if (g0Var != null && !Intrinsics.areEqual(num, g0Var.d)) {
                MutableState<g0> mutableState = this.j;
                a2 = g0Var.a((r16 & 1) != 0 ? g0Var.a : 0L, (r16 & 2) != 0 ? g0Var.b : 0L, (r16 & 4) != 0 ? g0Var.c : 0L, (r16 & 8) != 0 ? g0Var.d : num);
                mutableState.setValue(a2);
                return;
            }
            return;
        }
        r1(userId, num);
    }

    public final void N0(Integer num, String source) {
        cj0 cj0Var;
        Intrinsics.checkNotNullParameter(source, "source");
        eo eoVar = this.l.getValue().a;
        if (eoVar != null) {
            cj0Var = eoVar.a;
        } else {
            cj0Var = null;
        }
        if (cj0Var == null) {
            com.dragon.read.kmp.j.f(com.dragon.read.kmp.j.a, "GuestProfile", "subscribeOrCancel ugcUser is null", (Throwable) null, 4, (Object) null);
            return;
        }
        String str = cj0Var.a;
        if (str == null) {
            str = "";
        }
        m1(this, str, num, source, null, 8, null);
    }

    public final void g1(String targetUserId, int i) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        HashMap<String, Object> p0 = p0();
        p0.put("rank", Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        rVar.z(targetUserId, b, p0, "follow_guide_popup");
    }

    private final void R(final Function2<? super String, ? super String, Unit> function2, final Function2<? super String, ? super String, Unit> function22) {
        boolean z;
        String userId = com.dragon.read.kmp.service.c0.a.getUserId();
        if (userId.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.dragon.read.kmp.i.f(this.b, "onGuardButtonClick skip, loginUserId is empty after login", (Throwable) null, 2, (Object) null);
            return;
        }
        Observable<eo> q = this.c.q(userId);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<eo> observeOn = q.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit S;
                S = GuestProfileViewModel.S(GuestProfileViewModel.this, function2, function22, (eo) obj);
                return S;
            }
        };
        Consumer<? super eo> consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.T(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U2;
                U2 = GuestProfileViewModel.U(GuestProfileViewModel.this, (Throwable) obj);
                return U2;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GuestProfileViewModel.V(Function1.this, obj);
            }
        });
    }

    private final void k1(cj0 cj0Var, String str) {
        String str2;
        boolean z;
        com.dragon.read.kmp.service.c0 c0Var = com.dragon.read.kmp.service.c0.a;
        String userId = c0Var.getUserId();
        ok0 ok0Var = cj0Var.b;
        if (ok0Var != null && (str2 = ok0Var.a) != null) {
            if (c0Var.isLogin()) {
                if (userId.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    this.b.d("starFansToast start, currentUserId=" + userId + ", actorUid=" + str2 + ", triggerSource=" + str);
                    kotlinx.coroutines.i.e(this.e, null, null, new GuestProfileViewModel$requestStarFansRewardAndEmit$1(this, userId, str2, str, null), 3, null);
                    return;
                }
            }
            this.b.d("starFansToast skip, user not login, actorUid=" + str2 + ", triggerSource=" + str);
        }
    }

    private final Map<String, String> n0(jv5.c cVar, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tag_position", "profile_page");
        linkedHashMap.put("profile_user_id", r0());
        linkedHashMap.put("profile_type", this.h.b());
        if (cVar instanceof jv5.b) {
            linkedHashMap.put("tag_rank", String.valueOf(i));
            jv5.b bVar = (jv5.b) cVar;
            linkedHashMap.put("honor_id", bVar.a());
            linkedHashMap.put("honor_type", bVar.k);
            linkedHashMap.put("honor_from_type", "user");
            linkedHashMap.put("honor_name", bVar.f);
        }
        return linkedHashMap;
    }

    private final void r1(String str, Integer num) {
        if (num != null) {
            num.intValue();
            MutableState<List<fl4.j>> mutableState = this.O;
            Iterable<fl4.j> iterable = (Iterable) mutableState.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (fl4.j jVar : iterable) {
                if (Intrinsics.areEqual(jVar.a, str)) {
                    jVar = fl4.j.b(jVar, null, null, null, num.intValue(), null, 0, false, 119, null);
                }
                arrayList.add(jVar);
            }
            mutableState.setValue(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(GuestProfileViewModel guestProfileViewModel, Throwable th) {
        int i;
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "GuestProfile", "requestUserRelationInfo error: " + th, (Throwable) null, 4, (Object) null);
        long a2 = com.dragon.read.kmp.utils.p.a();
        yk4.b bVar = yk4.b.a;
        long a3 = a2 - bVar.a();
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        bVar.e(Integer.valueOf(i), th.getMessage(), a3, null);
        guestProfileViewModel.r.setValue(LoadStatus.Error);
        return Unit.INSTANCE;
    }

    public final void C0(final Function2<? super String, ? super String, Unit> onRequireFollowConfirm, final Function2<? super String, ? super String, Unit> onUnavailable) {
        Intrinsics.checkNotNullParameter(onRequireFollowConfirm, "onRequireFollowConfirm");
        Intrinsics.checkNotNullParameter(onUnavailable, "onUnavailable");
        long a2 = com.dragon.read.kmp.utils.p.a();
        if (a2 - this.T < 800) {
            this.b.d("onGuardButtonClick skip, click within 800ms");
            return;
        }
        this.T = a2;
        ym4.o.a.d("support_actor_ranking_boost", com.dragon.read.kmp.utils.k0.a.b().n());
        if (com.dragon.read.kmp.service.c0.a.isLogin()) {
            Y(onRequireFollowConfirm, onUnavailable);
        } else {
            com.dragon.read.kmp.u.n("support_actor_ranking_boost", new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit D0;
                    D0 = GuestProfileViewModel.D0(GuestProfileViewModel.this, onRequireFollowConfirm, onUnavailable);
                    return D0;
                }
            });
        }
    }

    public final void P0(String targetUserId, UserRelationType newRelationType) {
        long j;
        g0 a2;
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(newRelationType, "newRelationType");
        if (Intrinsics.areEqual(targetUserId, r0())) {
            g0 g0Var = (g0) this.j.getValue();
            if (g0Var != null) {
                long j2 = g0Var.a;
                UserRelationType userRelationType = UserRelationType.Follow;
                if (newRelationType != userRelationType && newRelationType != UserRelationType.MutualFollow) {
                    if (newRelationType == UserRelationType.None || newRelationType == UserRelationType.Followed) {
                        j = -1;
                    }
                    MutableState<g0> mutableState = this.j;
                    a2 = g0Var.a((r16 & 1) != 0 ? g0Var.a : j2, (r16 & 2) != 0 ? g0Var.b : 0L, (r16 & 4) != 0 ? g0Var.c : 0L, (r16 & 8) != 0 ? g0Var.d : Integer.valueOf(newRelationType.getValue()));
                    mutableState.setValue(a2);
                    if (newRelationType != userRelationType || newRelationType == UserRelationType.MutualFollow) {
                        c0();
                        return;
                    }
                    return;
                }
                j = 1;
                j2 += j;
                MutableState<g0> mutableState2 = this.j;
                a2 = g0Var.a((r16 & 1) != 0 ? g0Var.a : j2, (r16 & 2) != 0 ? g0Var.b : 0L, (r16 & 4) != 0 ? g0Var.c : 0L, (r16 & 8) != 0 ? g0Var.d : Integer.valueOf(newRelationType.getValue()));
                mutableState2.setValue(a2);
                if (newRelationType != userRelationType) {
                }
                c0();
                return;
            }
            return;
        }
        r1(targetUserId, Integer.valueOf(newRelationType.getValue()));
    }

    public final void d1(jv5.c honorBase, int i) {
        String str;
        Intrinsics.checkNotNullParameter(honorBase, "honorBase");
        if (this.Q.contains(honorBase.a())) {
            return;
        }
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        b.f(n0(honorBase, i));
        if (honorBase instanceof jv5.b) {
            str = "honor_tag_show";
        } else if (honorBase instanceof jv5.q) {
            str = "more_honor_tag_show";
        } else {
            str = "";
        }
        if (StringUtilsKt.a(str)) {
            ym4.o.a.c(str, b.i());
        }
        this.Q.add(honorBase.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
    
        if (r1 != null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Y(kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> r5, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> r6) {
        /*
            r4 = this;
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r0 = r4.l
            java.lang.Object r0 = r0.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r0 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r0
            com.bytedance.kmp.reading.model.eo r0 = r0.a
            r1 = 0
            if (r0 == 0) goto L14
            com.bytedance.kmp.reading.model.l10 r0 = r0.i
            if (r0 == 0) goto L14
            java.lang.String r0 = r0.d
            goto L15
        L14:
            r0 = r1
        L15:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L22
            int r0 = r0.length()
            if (r0 != 0) goto L20
            goto L22
        L20:
            r0 = 0
            goto L23
        L22:
            r0 = 1
        L23:
            if (r0 == 0) goto L50
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r5 = r4.l
            java.lang.Object r5 = r5.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r5 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r5
            com.bytedance.kmp.reading.model.eo r5 = r5.a
            if (r5 == 0) goto L46
            com.bytedance.kmp.reading.model.l10 r5 = r5.i
            if (r5 == 0) goto L46
            java.lang.String r5 = r5.e
            if (r5 == 0) goto L46
            int r0 = r5.length()
            if (r0 <= 0) goto L40
            r2 = 1
        L40:
            if (r2 == 0) goto L43
            r1 = r5
        L43:
            if (r1 == 0) goto L46
            goto L49
        L46:
            java.lang.String r1 = "今日你已守护50名演员，休息一下，明日继续"
        L49:
            java.lang.String r5 = "今日守护人数已达上限"
            r6.invoke(r5, r1)
            return
        L50:
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> r6 = r4.j
            java.lang.Object r6 = r6.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 r6 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) r6
            if (r6 == 0) goto L62
            boolean r6 = com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.c(r6)
            if (r6 != r3) goto L62
            r6 = 1
            goto L63
        L62:
            r6 = 0
        L63:
            if (r6 == 0) goto Lab
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r6 = r4.l
            java.lang.Object r6 = r6.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r6 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r6
            com.bytedance.kmp.reading.model.eo r6 = r6.a
            if (r6 == 0) goto L8a
            com.bytedance.kmp.reading.model.cj0 r6 = r6.a
            if (r6 == 0) goto L8a
            com.bytedance.kmp.reading.model.ok0 r6 = r6.b
            if (r6 == 0) goto L8a
            java.lang.String r6 = r6.b
            if (r6 == 0) goto L8a
            int r0 = r6.length()
            if (r0 <= 0) goto L84
            r2 = 1
        L84:
            if (r2 == 0) goto L87
            r1 = r6
        L87:
            if (r1 == 0) goto L8a
            goto L8c
        L8a:
            java.lang.String r1 = "TA"
        L8c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "请先关注演员“"
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "”，再为TA守护增加星光值"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "关注TA后才能守护"
            r5.invoke(r0, r6)
            goto Lae
        Lab:
            r4.R0()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.Y(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit d0(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r14, com.bytedance.kmp.reading.model.ym r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.d0(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.bytedance.kmp.reading.model.ym):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(GuestProfileViewModel guestProfileViewModel, Function2 function2, Function2 function22) {
        guestProfileViewModel.R(function2, function22);
        return Unit.INSTANCE;
    }

    public final void y0(String url, ym4.k pageRecorder, Map<String, String> initialData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        Intrinsics.checkNotNullParameter(initialData, "initialData");
        zm4.d.a.f(url, p0(), pageRecorder, initialData);
    }

    public final void i1(String targetUserId, int i, String profilePosition) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(profilePosition, "profilePosition");
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        HashMap<String, Object> p0 = p0();
        p0.put("rank", Integer.valueOf(i));
        p0.put("profile_position", profilePosition);
        Unit unit = Unit.INSTANCE;
        rVar.p(targetUserId, b, p0, "follow_guide_popup");
    }

    public final void j1(String targetUserId, int i, String profilePosition) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(profilePosition, "profilePosition");
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        HashMap<String, Object> p0 = p0();
        p0.put("rank", Integer.valueOf(i));
        p0.put("profile_position", profilePosition);
        Unit unit = Unit.INSTANCE;
        rVar.t(targetUserId, b, p0, "follow_guide_popup");
    }

    public final void w0(String userId, int i, boolean z) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        StringBuilder sb = new StringBuilder("sslocal://guest_profile");
        sb.append("?uid=");
        sb.append(userId);
        sb.append("&enter_from_type=20");
        if (gk4.q.Companion.a().b && z) {
            sb.append("&hightlight_tab_type=" + ProfileTab.Album.getValue());
            sb.append("&filter_option_header_type=" + FilterOptionHeaderType.HOTTEST_TYPE.getValue());
        }
        ym4.k a2 = m0.a();
        a2.c("rank", Integer.valueOf(i));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        x0(sb2, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
    
        if (r15.intValue() != r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit v1(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r13, java.lang.String r14, com.bytedance.kmp.reading.model.eo r15) {
        /*
            r13.i = r14
            com.bytedance.kmp.reading.model.cj0 r0 = r15.a
            r13.t1(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            com.dragon.read.kmp.profile.params.a r0 = r13.f
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r0 = com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.g(r15, r0)
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r1 = r13.l
        L12:
            java.lang.Object r2 = r1.getValue()
            r3 = r2
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r3 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r3
            boolean r2 = r1.compareAndSet(r2, r0)
            if (r2 == 0) goto L12
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.compose.common.load.LoadStatus> r1 = r13.r
            com.dragon.read.kmp.compose.common.load.LoadStatus r2 = com.dragon.read.kmp.compose.common.load.LoadStatus.Content
            r1.setValue(r2)
            dl4.t r1 = r13.h
            com.bytedance.kmp.reading.model.cj0 r2 = r15.a
            r1.e(r2)
            com.bytedance.kmp.reading.model.cj0 r1 = r15.a
            if (r1 == 0) goto L62
            com.bytedance.kmp.reading.model.dl0 r1 = r1.e
            if (r1 == 0) goto L62
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> r2 = r13.j
            java.lang.Integer r3 = r1.d
            r4 = 0
            if (r3 == 0) goto L41
            int r3 = r3.intValue()
            goto L42
        L41:
            r3 = 0
        L42:
            long r8 = (long) r3
            java.lang.Integer r3 = r1.c
            if (r3 == 0) goto L4c
            int r3 = r3.intValue()
            goto L4d
        L4c:
            r3 = 0
        L4d:
            long r6 = (long) r3
            java.lang.Integer r3 = r1.f
            if (r3 == 0) goto L56
            int r4 = r3.intValue()
        L56:
            long r10 = (long) r4
            java.lang.Integer r12 = r1.b
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 r1 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.g0
            r5 = r1
            r5.<init>(r6, r8, r10, r12)
            r2.setValue(r1)
        L62:
            r13.p1()
            com.bytedance.kmp.reading.model.cj0 r15 = r15.a
            if (r15 == 0) goto L70
            com.bytedance.kmp.reading.model.dl0 r15 = r15.e
            if (r15 == 0) goto L70
            java.lang.Integer r15 = r15.b
            goto L71
        L70:
            r15 = 0
        L71:
            com.bytedance.kmp.reading.model.UserRelationType r1 = com.bytedance.kmp.reading.model.UserRelationType.None
            int r1 = r1.getValue()
            if (r15 != 0) goto L7a
            goto L80
        L7a:
            int r2 = r15.intValue()
            if (r2 == r1) goto L8f
        L80:
            com.bytedance.kmp.reading.model.UserRelationType r1 = com.bytedance.kmp.reading.model.UserRelationType.Followed
            int r1 = r1.getValue()
            if (r15 != 0) goto L89
            goto La0
        L89:
            int r15 = r15.intValue()
            if (r15 != r1) goto La0
        L8f:
            com.dragon.read.kmp.r r15 = com.dragon.read.kmp.r.a
            com.dragon.read.kmp.utils.k0 r1 = com.dragon.read.kmp.utils.k0.a
            ym4.k r1 = r1.b()
            java.util.HashMap r2 = r13.p0()
            java.lang.String r3 = "profile"
            r15.z(r14, r1, r2, r3)
        La0:
            com.dragon.read.kmp.profile.guestprofile.viewmodel.a r14 = r13.a
            boolean r14 = r14.c
            if (r14 != 0) goto Lad
            com.dragon.read.kmp.profile.guestprofile.o r14 = r13.m0()
            r14.j()
        Lad:
            boolean r14 = r0.d
            if (r14 == 0) goto Lb8
            io.reactivex.disposables.Disposable r14 = r13.q
            if (r14 == 0) goto Lb8
            r14.dispose()
        Lb8:
            r13.Q()
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.v1(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, java.lang.String, com.bytedance.kmp.reading.model.eo):kotlin.Unit");
    }

    public final void t0(jv5.c honorBase, int i, String str) {
        String str2;
        String str3;
        String str4;
        cj0 cj0Var;
        Intrinsics.checkNotNullParameter(honorBase, "honorBase");
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        if (str != null) {
            ok0 ok0Var = null;
            if (!StringUtilsKt.a(str)) {
                str = null;
            }
            if (str != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(this.l.getValue().c.c);
                b.f(n0(honorBase, i));
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                String str5 = "";
                if (honorBase instanceof jv5.b) {
                    str2 = "honor_tag_click";
                } else if (!(honorBase instanceof jv5.q)) {
                    str2 = "";
                } else {
                    str2 = "more_honor_tag_click";
                }
                if (StringUtilsKt.a(str2)) {
                    ym4.o.a.c(str2, b.i());
                }
                linkedHashMap2.put("id", r0());
                eo eoVar = this.l.getValue().a;
                if (eoVar != null && (cj0Var = eoVar.a) != null) {
                    ok0Var = cj0Var.b;
                }
                if (ok0Var == null || (str3 = ok0Var.b) == null) {
                    str3 = "";
                }
                linkedHashMap2.put("name", str3);
                if (ok0Var != null && (str4 = ok0Var.c) != null) {
                    str5 = str4;
                }
                linkedHashMap2.put("img_url", str5);
                com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
                gn6.a c = com.dragon.read.kmp.base.h.c();
                c.getSerializersModule();
                v2 v2Var = v2.a;
                linkedHashMap.put("enter_info", c.a(new a1(v2Var, v2Var), linkedHashMap2));
                y0(wi4.a.a.b(str, j0(honorBase.a(), r0())), b, linkedHashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String P(String str, JsonObject jsonObject, long j) {
        boolean z;
        JsonObject jsonObject2;
        JsonElement jsonElement;
        JsonArray jsonArray;
        boolean z2;
        Object m773constructorimpl;
        com.dragon.read.kmp.base.l a2;
        JsonObject T0;
        boolean z3 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        Object obj = null;
        if (z) {
            return null;
        }
        Object obj2 = jsonObject.get("data");
        if (obj2 instanceof JsonObject) {
            jsonObject2 = (JsonObject) obj2;
        } else {
            jsonObject2 = null;
        }
        if (jsonObject2 != null) {
            jsonElement = (JsonElement) jsonObject2.get("task_list");
        } else {
            jsonElement = null;
        }
        if (jsonElement instanceof JsonArray) {
            jsonArray = (JsonArray) jsonElement;
        } else {
            jsonArray = null;
        }
        if (jsonArray != null && !jsonArray.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            a2 = com.dragon.read.kmp.base.m.a(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (a2 == null) {
            return null;
        }
        String d = a2.d("first_frame_data");
        if (d == null || d.length() == 0) {
            z3 = true;
        }
        if (z3 || (T0 = T0(d)) == null) {
            return null;
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry entry : T0.entrySet()) {
            jsonObjectBuilder.put((String) entry.getKey(), (JsonElement) entry.getValue());
        }
        jsonObjectBuilder.put("taskList", jsonArray);
        gn6.e.b(jsonObjectBuilder, "taskPrefetchTimestamp", Long.valueOf(j));
        a2.a("first_frame_data", jsonObjectBuilder.build().toString());
        String c = a2.c();
        if (c.length() > 20480) {
            com.dragon.read.kmp.i.f(this.b, "buildGuardSchemaWithTaskList fallback, schema too large, length=" + c.length(), (Throwable) null, 2, (Object) null);
            return null;
        }
        m773constructorimpl = Result.m773constructorimpl(c);
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            this.b.b("buildGuardSchemaWithTaskList error: " + m776exceptionOrNullimpl.getMessage(), m776exceptionOrNullimpl);
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r3.i(r4.b) == true) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit z1(long r9, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r11, com.dragon.read.rpc.kmp.community.model.d7 r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.z1(long, com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.dragon.read.rpc.kmp.community.model.d7):kotlin.Unit");
    }

    public final void l1(String userId, Integer num, String source, Map<String, Object> extraMap) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        com.dragon.read.kmp.profile.guestprofile.n.z(this.c, userId, num, source, extraMap, null, null, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(GuestProfileViewModel guestProfileViewModel, Function2 function2, Function2 function22, eo eoVar) {
        long j;
        boolean z;
        ok0 ok0Var;
        Long l;
        cj0 cj0Var = eoVar.a;
        if (cj0Var != null && (ok0Var = cj0Var.b) != null && (l = ok0Var.l) != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        guestProfileViewModel.R.setValue(Boolean.valueOf(z));
        if (z) {
            guestProfileViewModel.b.d("onGuardButtonClick login user is actor, hide guard button");
            return Unit.INSTANCE;
        }
        guestProfileViewModel.W0(function2, function22);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(long j, GuestProfileViewModel guestProfileViewModel, String str, Throwable th) {
        int i;
        String stackTraceToString;
        long a2 = com.dragon.read.kmp.utils.p.a() - j;
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        yk4.b.a.g(Integer.valueOf(i), th.getMessage(), a2);
        com.dragon.read.kmp.i iVar = guestProfileViewModel.b;
        StringBuilder sb = new StringBuilder();
        sb.append("fetchTabList ");
        sb.append(str);
        sb.append(" error ");
        Intrinsics.checkNotNull(th);
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th);
        sb.append(stackTraceToString);
        com.dragon.read.kmp.i.c(iVar, sb.toString(), (Throwable) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(GuestProfileViewModel guestProfileViewModel, Function2 function2, Function2 function22, eo eoVar) {
        dl0 dl0Var;
        int i;
        int i2;
        Intrinsics.checkNotNull(eoVar);
        f0 g = c0.g(eoVar, guestProfileViewModel.f);
        MutableStateFlow<f0> mutableStateFlow = guestProfileViewModel.l;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), g)) {
        }
        cj0 cj0Var = eoVar.a;
        if (cj0Var != null && (dl0Var = cj0Var.e) != null) {
            MutableState<g0> mutableState = guestProfileViewModel.j;
            Integer num = dl0Var.d;
            int i3 = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            long j = i;
            Integer num2 = dl0Var.c;
            if (num2 != null) {
                i2 = num2.intValue();
            } else {
                i2 = 0;
            }
            long j2 = i2;
            Integer num3 = dl0Var.f;
            if (num3 != null) {
                i3 = num3.intValue();
            }
            mutableState.setValue(new g0(j2, j, i3, dl0Var.b));
        }
        guestProfileViewModel.Y(function2, function22);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void O0(GuestProfileViewModel guestProfileViewModel, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "profile";
        }
        guestProfileViewModel.N0(num, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m1(GuestProfileViewModel guestProfileViewModel, String str, Integer num, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "profile";
        }
        if ((i & 8) != 0) {
            map = new LinkedHashMap();
        }
        guestProfileViewModel.l1(str, num, str2, map);
    }
}

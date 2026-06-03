package com.dragon.read.kmp.profile.guestprofile;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UgcActionType;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.fo;
import com.bytedance.kmp.reading.model.go;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.guestprofile.n;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.r;
import com.dragon.read.kmp.service.g0;
import com.dragon.read.kmp.u;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.utils.v0;
import com.dragon.read.rpc.kmp.community.model.CommentApiERR;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.UgcCommentChannelEnum;
import com.dragon.read.rpc.kmp.community.model.UgcCommentSourceEnum;
import com.dragon.read.rpc.kmp.community.model.d7;
import com.dragon.read.rpc.kmp.community.model.h1;
import com.dragon.read.rpc.kmp.community.model.h2;
import com.dragon.read.rpc.kmp.community.model.i2;
import com.dragon.read.rpc.kmp.community.rpc.CommentApiService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final a d;
    public static final int e;
    public final GuestProfileViewModel a;
    private boolean b;
    public final com.dragon.read.kmp.i c;

    static {
        Covode.recordClassIndex(608101);
        d = new a(null);
        e = 8;
    }

    public n(GuestProfileViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.a = viewModel;
        this.c = new com.dragon.read.kmp.i("SeriesGuestProfilePresenter");
    }

    private final void x(UgcActionType ugcActionType) {
        if (ugcActionType == UgcActionType.CancelSubscribe) {
            ig4.g.b("取消关注失败，请重试", (ToastDuration) null, 2, (Object) null);
        } else {
            ig4.g.b("关注失败，请重试", (ToastDuration) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eo r(go response) {
        Intrinsics.checkNotNullParameter(response, "response");
        bc4.b.d(bc4.b.a, response.a, response.b, response.c, false, 0, 24, (Object) null);
        eo eoVar = response.c;
        if (eoVar != null) {
            return eoVar;
        }
        throw new IllegalStateException("data is null".toString());
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608102);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ObservableSource e(i2 it2) {
            String str;
            Intrinsics.checkNotNullParameter(it2, "it");
            if (v0.a.a(it2.e)) {
                str = "网络错误，请稍后重试";
            } else {
                str = it2.e;
            }
            String str2 = str;
            if (it2.a != null) {
                Integer num = it2.d;
                int value = CommentApiERR.Success.getValue();
                if (num != null && num.intValue() == value) {
                    com.bytedance.kmp.rxkmp.b bVar = com.bytedance.kmp.rxkmp.b.a;
                    d7 d7Var = it2.a;
                    Intrinsics.checkNotNull(d7Var);
                    Observable just = Observable.just(d7Var);
                    Intrinsics.checkNotNullExpressionValue(just, "just(t)");
                    return just;
                }
                com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesGuestProfilePresenter", "fetchTabList fail code is " + it2.d, (Throwable) null, 4, (Object) null);
                throw new ErrorCodeException(it2.d, str2, (ErrorCodeException.ErrorCodeType) null, 4, (DefaultConstructorMarker) null);
            }
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesGuestProfilePresenter", "fetchTabList fail data is null", (Throwable) null, 4, (Object) null);
            throw new ErrorCodeException(it2.d, str2, (ErrorCodeException.ErrorCodeType) null, 4, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ObservableSource f(Function1 function1, Object p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return (ObservableSource) function1.invoke(p0);
        }

        public final Observable<d7> c(String userId, ProfileTab profileTab, ProfileTab profileTab2, String str, Boolean bool, Boolean bool2, Integer num, Integer num2) {
            Map map;
            Integer num3;
            Integer num4;
            String str2;
            Integer num5;
            Integer valueOf;
            Map mapOf;
            Intrinsics.checkNotNullParameter(userId, "userId");
            if (num2 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("hightlight_tab_type", String.valueOf(num2.intValue())));
                map = mapOf;
            } else {
                map = null;
            }
            int value = UgcCommentSourceEnum.VideoProfilePage.getValue();
            int appId = g0.a.getAppId();
            if (profileTab != null) {
                num3 = Integer.valueOf(profileTab.getValue());
            } else {
                num3 = null;
            }
            if (profileTab2 != null) {
                num4 = Integer.valueOf(profileTab2.getValue());
            } else {
                num4 = null;
            }
            if (u.d()) {
                str2 = FilterOptionHeaderType.Companion.d(FilterOptionHeaderType.LATEST_TYPE);
            } else {
                str2 = null;
            }
            Boolean bool3 = Boolean.TRUE;
            if (Intrinsics.areEqual(bool2, bool3)) {
                valueOf = Integer.valueOf(UgcCommentChannelEnum.SeriesSingleColPugc.getValue());
            } else if (Intrinsics.areEqual(bool, bool3)) {
                valueOf = Integer.valueOf(UgcCommentChannelEnum.DynamicTabGenre.getValue());
            } else {
                if (num != null && num.intValue() >= 0) {
                    num5 = num;
                } else {
                    num5 = null;
                }
                Observable z = CommentApiService.z(CommentApiService.a, new h2(Integer.valueOf(value), num5, userId, Integer.valueOf(appId), num3, num4, (Integer) null, (String) null, str2, (Integer) null, (String) null, str, map, (String) null, 9920, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
                final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ObservableSource e;
                        e = n.a.e((i2) obj);
                        return e;
                    }
                };
                Observable<d7> flatMap = z.flatMap(new Function() { // from class: com.dragon.read.kmp.profile.guestprofile.m
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        ObservableSource f;
                        f = n.a.f(Function1.this, obj);
                        return f;
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
                return flatMap;
            }
            num5 = valueOf;
            Observable z2 = CommentApiService.z(CommentApiService.a, new h2(Integer.valueOf(value), num5, userId, Integer.valueOf(appId), num3, num4, (Integer) null, (String) null, str2, (Integer) null, (String) null, str, map, (String) null, 9920, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
            final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ObservableSource e;
                    e = n.a.e((i2) obj);
                    return e;
                }
            };
            Observable<d7> flatMap2 = z2.flatMap(new Function() { // from class: com.dragon.read.kmp.profile.guestprofile.m
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource f;
                    f = n.a.f(Function1.this, obj);
                    return f;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap2, "flatMap(...)");
            return flatMap2;
        }

        public static /* synthetic */ Observable d(a aVar, String str, ProfileTab profileTab, ProfileTab profileTab2, String str2, Boolean bool, Boolean bool2, Integer num, Integer num2, int i, Object obj) {
            ProfileTab profileTab3;
            ProfileTab profileTab4;
            String str3;
            Boolean bool3;
            Boolean bool4;
            Integer num3;
            Integer num4 = null;
            if ((i & 2) != 0) {
                profileTab3 = null;
            } else {
                profileTab3 = profileTab;
            }
            if ((i & 4) != 0) {
                profileTab4 = null;
            } else {
                profileTab4 = profileTab2;
            }
            if ((i & 8) != 0) {
                str3 = null;
            } else {
                str3 = str2;
            }
            if ((i & 16) != 0) {
                bool3 = Boolean.FALSE;
            } else {
                bool3 = bool;
            }
            if ((i & 32) != 0) {
                bool4 = Boolean.FALSE;
            } else {
                bool4 = bool2;
            }
            if ((i & 64) != 0) {
                num3 = null;
            } else {
                num3 = num;
            }
            if ((i & 128) == 0) {
                num4 = num2;
            }
            return aVar.c(str, profileTab3, profileTab4, str3, bool3, bool4, num3, num4);
        }
    }

    public final Observable<eo> q(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        fo foVar = new fo(userId);
        final long a2 = com.dragon.read.kmp.utils.p.a();
        Observable n = UserApiService.n(UserApiService.a, foVar, (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = n.subscribeOn(io2);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                eo r;
                r = n.r((go) obj);
                return r;
            }
        };
        Observable map = subscribeOn.map(new Function() { // from class: com.dragon.read.kmp.profile.guestprofile.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                eo s;
                s = n.s(Function1.this, obj);
                return s;
            }
        });
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t;
                t = n.t(a2, (Throwable) obj);
                return t;
            }
        };
        Observable doOnError = map.doOnError(new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.u(Function1.this, obj);
            }
        });
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                eo v;
                v = n.v(a2, (eo) obj);
                return v;
            }
        };
        Observable<eo> map2 = doOnError.map(new Function() { // from class: com.dragon.read.kmp.profile.guestprofile.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                eo w;
                w = n.w(Function1.this, obj);
                return w;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(...)");
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eo s(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (eo) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eo w(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (eo) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eo v(long j, eo it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        yk4.b.a.h(0, "", com.dragon.read.kmp.utils.p.a() - j);
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(long j, Throwable th) {
        int i;
        long a2 = com.dragon.read.kmp.utils.p.a() - j;
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        yk4.b.a.h(Integer.valueOf(i), th.getMessage(), a2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(n nVar, UgcActionType ugcActionType, Function0 function0, Throwable th) {
        String stackTraceToString;
        nVar.b = false;
        nVar.c.d("doSubscribe error catch");
        com.dragon.read.kmp.i iVar = nVar.c;
        StringBuilder sb = new StringBuilder();
        sb.append(ugcActionType.name());
        sb.append(" error，");
        Intrinsics.checkNotNull(th);
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th);
        sb.append(stackTraceToString);
        com.dragon.read.kmp.i.c(iVar, sb.toString(), (Throwable) null, 2, (Object) null);
        nVar.x(ugcActionType);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final void y(final String targetUserId, final Integer num, final String source, final Map<String, Object> extraMap, final Function0<Unit> function0, final Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        u.n("guest_profile_subscribe", new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit A;
                A = n.A(n.this, targetUserId, num, source, extraMap, function0, function02);
                return A;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void l(final java.lang.String r43, final java.lang.Integer r44, final java.lang.String r45, final java.util.Map<java.lang.String, java.lang.Object> r46, final kotlin.jvm.functions.Function0<kotlin.Unit> r47, final kotlin.jvm.functions.Function0<kotlin.Unit> r48) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.n.l(java.lang.String, java.lang.Integer, java.lang.String, java.util.Map, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(n nVar, String str, Integer num, String str2, Map map, Function0 function0, Function0 function02) {
        nVar.l(str, num, str2, map, function0, function02);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void z(n nVar, String str, Integer num, String str2, Map map, Function0 function0, Function0 function02, int i, Object obj) {
        Function0 function03;
        Function0 function04;
        if ((i & 4) != 0) {
            str2 = "profile";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            map = new LinkedHashMap();
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i & 32) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        nVar.y(str, num, str3, map2, function03, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(n nVar, Integer num, UgcActionType ugcActionType, String str, Map map, String str2, Function0 function0, Function0 function02, h1 h1Var) {
        nVar.c.d("start doSubscribe finish, it.code = " + h1Var.c);
        nVar.b = false;
        Integer num2 = h1Var.c;
        int value = CommentApiERR.Success.getValue();
        cj0 cj0Var = null;
        if (num2 != null && num2.intValue() == value) {
            nVar.c.d("doSubscribe success code, currentType: " + num);
            nVar.c.d(ugcActionType.name() + " success");
            UserRelationType a2 = yk4.c.a(num);
            com.dragon.read.kmp.profile.params.a aVar = nVar.a.f;
            if (aVar != null) {
                aVar.m(a2.getValue(), str);
            }
            nVar.a.P0(str, a2);
            Map<String, Object> map2 = nVar.a.a.o.a;
            map2.putAll(map);
            if (ugcActionType == UgcActionType.CancelSubscribe) {
                r.a.f(str, k0.a.b(), map2, str2);
            } else if (ugcActionType == UgcActionType.Subscribe) {
                r.a.g(str, k0.a.b(), map2, str2);
                GuestProfileViewModel guestProfileViewModel = nVar.a;
                com.dragon.read.kmp.profile.params.a aVar2 = guestProfileViewModel.f;
                if (aVar2 != null) {
                    eo eoVar = guestProfileViewModel.l.getValue().a;
                    if (eoVar != null) {
                        cj0Var = eoVar.a;
                    }
                    aVar2.p(cj0Var, nVar.a.a);
                }
            }
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            nVar.c.d("doSubscribe error code");
            com.dragon.read.kmp.i.c(nVar.c, ugcActionType.name() + " fail，code:" + h1Var.c + ", msg:" + h1Var.d, (Throwable) null, 2, (Object) null);
            nVar.x(ugcActionType);
            if (function02 != null) {
                function02.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}

package com.dragon.read.kmp.subscribe;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.service.g0;
import com.dragon.read.kmp.service.m0;
import com.dragon.read.rpc.kmp.community.model.CommentApiERR;
import com.dragon.read.rpc.kmp.community.model.UgcActionObjectType;
import com.dragon.read.rpc.kmp.community.model.UgcActionType;
import com.dragon.read.rpc.kmp.community.model.UgcCommentGroupTypeOutter;
import com.dragon.read.rpc.kmp.community.model.c3;
import com.dragon.read.rpc.kmp.community.model.g1;
import com.dragon.read.rpc.kmp.community.model.h1;
import com.dragon.read.rpc.kmp.community.model.i1;
import com.dragon.read.rpc.kmp.community.model.j1;
import com.dragon.read.rpc.kmp.community.model.s2;
import com.dragon.read.rpc.kmp.community.model.z2;
import com.dragon.read.rpc.kmp.community.model.z5;
import com.dragon.read.rpc.kmp.community.rpc.ArticleApiService;
import com.dragon.read.rpc.kmp.community.rpc.CommentApiService;
import gk4.v;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;

    static {
        Covode.recordClassIndex(609439);
        a = new n();
    }

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean q(h1 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Boolean.valueOf(a.m(it2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean s(j1 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Boolean.valueOf(a.n(it2));
    }

    private final boolean m(h1 h1Var) {
        Integer num = h1Var.c;
        int value = CommentApiERR.Success.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = CommentApiERR.RepeatDiggError.getValue();
            if (num == null || num.intValue() != value2) {
                bc4.b.d(bc4.b.a, num, h1Var.d, (Object) null, false, 0, 24, (Object) null);
            }
        }
        return true;
    }

    private final boolean n(j1 j1Var) {
        Integer num = j1Var.d;
        int value = CommentApiERR.Success.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = CommentApiERR.RepeatDiggError.getValue();
            if (num == null || num.intValue() != value2) {
                bc4.b.d(bc4.b.a, num, j1Var.e, (Object) null, false, 0, 24, (Object) null);
            }
        }
        return true;
    }

    private final Single<Boolean> o(g1 g1Var) {
        Single singleOrError = CommentApiService.l(CommentApiService.a, g1Var, (zn0.g) null, 2, (Object) null).singleOrError();
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Single subscribeOn = singleOrError.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Single observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.subscribe.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean q;
                q = n.q((h1) obj);
                return q;
            }
        };
        Single<Boolean> map = observeOn.map(new Function() { // from class: com.dragon.read.kmp.subscribe.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean r;
                r = n.r(Function1.this, obj);
                return r;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    private final Single<Boolean> p(i1 i1Var) {
        Single singleOrError = ArticleApiService.f(ArticleApiService.a, i1Var, (zn0.g) null, 2, (Object) null).singleOrError();
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Single subscribeOn = singleOrError.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Single observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.subscribe.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean s;
                s = n.s((j1) obj);
                return s;
            }
        };
        Single<Boolean> map = observeOn.map(new Function() { // from class: com.dragon.read.kmp.subscribe.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean t;
                t = n.t(Function1.this, obj);
                return t;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean r(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Boolean) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean t(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Boolean) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function2 function2, boolean z, long j, Boolean bool) {
        function2.invoke(Boolean.valueOf(z), Long.valueOf(j));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function2 function2, boolean z, long j, Boolean bool) {
        function2.invoke(Boolean.valueOf(z), Long.valueOf(j));
        return Unit.INSTANCE;
    }

    public final void z(final v delegate, Function2<? super Boolean, ? super Long, Unit> onStart, final Function2<? super Boolean, ? super Long, Unit> onSuccess, final Function3<? super Boolean, ? super Long, ? super Throwable, Unit> onError) {
        final long j;
        int value;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final boolean e = delegate.e();
        final long diggCount = delegate.getDiggCount();
        final boolean e2 = delegate.e();
        final boolean z = !e;
        if (e) {
            j = diggCount - 1;
        } else {
            j = 1 + diggCount;
        }
        onStart.invoke(Boolean.valueOf(z), Long.valueOf(j));
        if (z) {
            value = UgcActionType.Like.getValue();
        } else {
            value = UgcActionType.CancelLike.getValue();
        }
        Single<Boolean> p = p(new i1(delegate.getObjectId(), Integer.valueOf(delegate.a()), Integer.valueOf(value), (String) null, (Integer) null, (Integer) null, (String) null, (Integer) null, new com.dragon.read.rpc.kmp.community.model.q((Map) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Map) null, (String) null, (Integer) null, (Integer) null, (String) null, (Long) null, (Boolean) null, (String) null, (String) null, 524286, (DefaultConstructorMarker) null), (String) null, 760, (DefaultConstructorMarker) null));
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.subscribe.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A;
                A = n.A(Function2.this, z, j, (Boolean) obj);
                return A;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: com.dragon.read.kmp.subscribe.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.B(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.subscribe.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C;
                C = n.C(v.this, diggCount, e2, onError, e, (Throwable) obj);
                return C;
            }
        };
        Intrinsics.checkNotNullExpressionValue(p.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.subscribe.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.D(Function1.this, obj);
            }
        }), "subscribe(...)");
    }

    public final void u(final v delegate, Function2<? super Boolean, ? super Long, Unit> onStart, final Function2<? super Boolean, ? super Long, Unit> onSuccess, final Function3<? super Boolean, ? super Long, ? super Throwable, Unit> onError) {
        final long j;
        Map<String, String> hashMap;
        String str;
        int value;
        xe4.b playletCommentService;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final boolean e = delegate.e();
        final long diggCount = delegate.getDiggCount();
        final boolean e2 = delegate.e();
        final boolean z = !e;
        if (z) {
            j = 1 + diggCount;
        } else {
            j = diggCount - 1;
        }
        onStart.invoke(Boolean.valueOf(z), Long.valueOf(j));
        com.dragon.read.kmp.service.q a2 = m0.a();
        if (a2 == null || (hashMap = a2.V()) == null) {
            hashMap = new HashMap<>();
        }
        HashMap hashMap2 = new HashMap(hashMap);
        xe4.a a3 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(xe4.a.class));
        if (a3 == null || (playletCommentService = a3.getPlayletCommentService()) == null || (str = playletCommentService.D8()) == null) {
            str = "";
        }
        hashMap2.put("comment_type", str);
        com.dragon.read.kmp.j.a.a("InteractiveHelper", "handleDramaReviewLikeOrDislike, sharkParam: " + hashMap2);
        if (z) {
            value = UgcActionType.Agree.getValue();
        } else {
            value = UgcActionType.CancelAgree.getValue();
        }
        Single<Boolean> o = o(new g1(delegate.getObjectId(), Integer.valueOf(UgcActionObjectType.Comment.getValue()), Integer.valueOf(value), (String) null, (Integer) null, (String) null, Integer.valueOf(UgcCommentGroupTypeOutter.Book.getValue()), Integer.valueOf(g0.a.getAppId()), new com.dragon.read.rpc.kmp.community.model.m((Integer) null, (Boolean) null, (Map) null, (String) null, (Integer) null, (c3) null, (String) null, (String) null, (z2) null, (String) null, (Boolean) null, hashMap2, (Boolean) null, (List) null, (Map) null, (String) null, (Integer) null, (Long) null, (Long) null, (List) null, (List) null, (String) null, (List) null, (String) null, (String) null, (String) null, (z5) null, 134215679, (DefaultConstructorMarker) null), (s2) null, 568, (DefaultConstructorMarker) null));
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.subscribe.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v;
                v = n.v(Function2.this, z, j, (Boolean) obj);
                return v;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: com.dragon.read.kmp.subscribe.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.w(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.subscribe.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x;
                x = n.x(v.this, diggCount, e2, onError, e, (Throwable) obj);
                return x;
            }
        };
        Intrinsics.checkNotNullExpressionValue(o.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.subscribe.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.y(Function1.this, obj);
            }
        }), "subscribe(...)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(v vVar, long j, boolean z, Function3 function3, boolean z2, Throwable th) {
        vVar.n(j);
        vVar.t(z);
        function3.invoke(Boolean.valueOf(z2), Long.valueOf(j), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(v vVar, long j, boolean z, Function3 function3, boolean z2, Throwable th) {
        vVar.n(j);
        vVar.t(z);
        function3.invoke(Boolean.valueOf(z2), Long.valueOf(j), th);
        return Unit.INSTANCE;
    }
}

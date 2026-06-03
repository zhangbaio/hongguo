package com.dragon.read.kmp.subscribe;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SubscribeOpType;
import com.bytedance.kmp.reading.model.y80;
import com.bytedance.kmp.reading.model.z80;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.u;
import com.dragon.read.kmp.utils.y;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public static final t a;

    static {
        Covode.recordClassIndex(609442);
        a = new t();
    }

    private t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function2 function2, SubscribeOpType subscribeOpType, long j, z80 z80Var) {
        bc4.b.a.b(z80Var.a, z80Var.b, z80Var, true, 0);
        Integer num = z80Var.a;
        if (num != null && num.intValue() == 0) {
            if (function2 != null) {
                function2.invoke(subscribeOpType, Boolean.TRUE);
            }
            u.q(subscribeOpType.getValue(), String.valueOf(j));
            if (subscribeOpType != SubscribeOpType.Subscribe) {
                ig4.g.b("预约已取消", (ToastDuration) null, 2, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function2 function2, SubscribeOpType subscribeOpType, String str, String str2, Throwable th) {
        if (function2 != null) {
            function2.invoke(subscribeOpType, Boolean.FALSE);
        }
        if (subscribeOpType == SubscribeOpType.Subscribe) {
            y yVar = y.a;
            Intrinsics.checkNotNull(th);
            if (!yVar.a(th)) {
                ig4.g.b(str, (ToastDuration) null, 2, (Object) null);
            }
        } else {
            ig4.g.b(str2, (ToastDuration) null, 2, (Object) null);
        }
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesSubscribeHelper", "requestSubscribe error: " + th.getMessage(), (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public final Disposable e(final long j, int i, final SubscribeOpType opType, final String subscribeFailToast, final String cancelSubscribeFailToast, final Function2<? super SubscribeOpType, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(subscribeFailToast, "subscribeFailToast");
        Intrinsics.checkNotNullParameter(cancelSubscribeFailToast, "cancelSubscribeFailToast");
        Observable Q = BookApiService.Q(BookApiService.a, new y80(Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(opType.getValue()), (String) null, (Integer) null, (List) null, u.j(), 56, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = Q.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.subscribe.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g;
                g = t.g(Function2.this, opType, j, (z80) obj);
                return g;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.subscribe.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                t.h(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.subscribe.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i2;
                i2 = t.i(Function2.this, opType, subscribeFailToast, cancelSubscribeFailToast, (Throwable) obj);
                return i2;
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.subscribe.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                t.j(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }

    public static /* synthetic */ Disposable f(t tVar, long j, int i, SubscribeOpType subscribeOpType, String str, String str2, Function2 function2, int i2, Object obj) {
        String str3;
        String str4;
        Function2 function22;
        if ((i2 & 8) != 0) {
            str3 = "预约失败";
        } else {
            str3 = str;
        }
        if ((i2 & 16) != 0) {
            str4 = "取消预约失败";
        } else {
            str4 = str2;
        }
        if ((i2 & 32) != 0) {
            function22 = null;
        } else {
            function22 = function2;
        }
        return tVar.e(j, i, subscribeOpType, str3, str4, function22);
    }
}

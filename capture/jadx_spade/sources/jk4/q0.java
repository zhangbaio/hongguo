package jk4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserEventReportType;
import com.bytedance.kmp.reading.model.a20;
import com.bytedance.kmp.reading.model.a4;
import com.bytedance.kmp.reading.model.a6;
import com.bytedance.kmp.reading.model.b20;
import com.bytedance.kmp.reading.model.b4;
import com.bytedance.kmp.reading.model.b50;
import com.bytedance.kmp.reading.model.b6;
import com.bytedance.kmp.reading.model.b60;
import com.bytedance.kmp.reading.model.bc0;
import com.bytedance.kmp.reading.model.cs;
import com.bytedance.kmp.reading.model.dm0;
import com.bytedance.kmp.reading.model.ee0;
import com.bytedance.kmp.reading.model.f2;
import com.bytedance.kmp.reading.model.fe0;
import com.bytedance.kmp.reading.model.fq;
import com.bytedance.kmp.reading.model.gg0;
import com.bytedance.kmp.reading.model.gj;
import com.bytedance.kmp.reading.model.hb0;
import com.bytedance.kmp.reading.model.j9;
import com.bytedance.kmp.reading.model.l8;
import com.bytedance.kmp.reading.model.lc0;
import com.bytedance.kmp.reading.model.m8;
import com.bytedance.kmp.reading.model.n8;
import com.bytedance.kmp.reading.model.nl0;
import com.bytedance.kmp.reading.model.q3;
import com.bytedance.kmp.reading.model.rp;
import com.bytedance.kmp.reading.model.se0;
import com.bytedance.kmp.reading.model.t4;
import com.bytedance.kmp.reading.model.tk0;
import com.bytedance.kmp.reading.model.ue0;
import com.bytedance.kmp.reading.model.uf0;
import com.bytedance.kmp.reading.model.uk0;
import com.bytedance.kmp.reading.model.xs;
import com.bytedance.kmp.reading.model.y3;
import com.bytedance.kmp.reading.model.yf0;
import com.bytedance.kmp.reading.model.z8;
import com.bytedance.kmp.reading.model.zb0;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.compose.ToastDuration;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q0 extends ViewModel {
    public static final a d;
    public static final int e;
    private final l a;
    public final MutableState<Boolean> b;
    public boolean c;

    public static final class a {
        static {
            Covode.recordClassIndex(607880);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607879);
        d = new a(null);
        e = 8;
    }

    public q0(l iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = iDepend;
        this.b = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(q0 q0Var, Throwable th) {
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesNpsViewModel", "onSubmit error: " + th, (Throwable) null, 4, (Object) null);
        q0Var.b.setValue(Boolean.FALSE);
        ig4.g.b("提交失败，网络异常", (ToastDuration) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    public final void I0(final List<String> selectedItems, z params) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!((Boolean) this.b.getValue()).booleanValue() && !this.c) {
            Integer valueOf = Integer.valueOf(UserEventReportType.UserResearch.getValue());
            String str = params.a;
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = Boolean.TRUE;
            tk0 tk0Var = new tk0(valueOf, (yf0) null, (m8) null, (l8) null, (b4) null, (List) null, (gg0) null, (Integer) null, (cs) null, (uf0) null, (n8) null, (t4) null, (xs) null, (b6) null, (com.bytedance.kmp.reading.model.m) null, (b50) null, (a4) null, (zb0) null, (gj) null, (dm0) null, (y3) null, new b60(str, bool, bool2, (String) null, (String) null, 24, (DefaultConstructorMarker) null), (ee0) null, (j9) null, (lc0) null, (se0) null, (hb0) null, (z8) null, (b20) null, (fe0) null, (fq) null, (a20) null, (rp) null, (ue0) null, (q3) null, (a6) null, (bc0) null, (f2) null, (nl0) null, -2097154, 127, (DefaultConstructorMarker) null);
            com.dragon.read.kmp.j.a.d("SeriesNpsViewModel", "onSubmit, selectedItems size: " + selectedItems.size());
            this.b.setValue(bool2);
            Observable z = UserApiService.z(UserApiService.a, tk0Var, (zn0.g) null, 2, (Object) null);
            KSchedulers kSchedulers = KSchedulers.INSTANCE;
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "io()");
            Observable subscribeOn = z.subscribeOn(io2);
            Scheduler mainThread = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
            Observable observeOn = subscribeOn.observeOn(mainThread);
            final Function1 function1 = new Function1() { // from class: jk4.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit J0;
                    J0 = q0.J0(q0.this, selectedItems, (uk0) obj);
                    return J0;
                }
            };
            Consumer consumer = new Consumer() { // from class: jk4.n0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    q0.K0(Function1.this, obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: jk4.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit L0;
                    L0 = q0.L0(q0.this, (Throwable) obj);
                    return L0;
                }
            };
            observeOn.subscribe(consumer, new Consumer() { // from class: jk4.p0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    q0.M0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(q0 q0Var, List list, uk0 uk0Var) {
        com.dragon.read.kmp.j.a.d("SeriesNpsViewModel", "onSubmit success");
        q0Var.c = true;
        q0Var.b.setValue(Boolean.FALSE);
        ig4.g.b("感谢反馈", (ToastDuration) null, 2, (Object) null);
        q0Var.a.b(list);
        return Unit.INSTANCE;
    }
}

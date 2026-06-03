package com.dragon.read.kmp.widget;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0<T> {
    public static final int g;
    private final Function2<Function1<? super T, Unit>, Function1<? super w, Unit>, Unit> a;
    public T b;
    public MutableState<CommonLayoutState> c;
    public w d;
    public final Function1<T, Unit> e;
    public final Function1<w, Unit> f;

    static {
        Covode.recordClassIndex(609644);
        g = 8;
    }

    public final void d() {
        this.c.setValue(CommonLayoutState.Empty);
    }

    public final void f() {
        this.c.setValue(CommonLayoutState.Success);
    }

    public final void c() {
        try {
            this.a.invoke(this.e, this.f);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            e(new w(-1, message));
        }
    }

    public final void g() {
        if (this.c.getValue() != CommonLayoutState.Success) {
            this.c.setValue(CommonLayoutState.Loading);
        }
        c();
    }

    public final void j() {
        if (this.b == null) {
            this.c.setValue(CommonLayoutState.Loading);
        } else {
            this.c.setValue(CommonLayoutState.Success);
        }
        c();
    }

    public final void e(w e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.c.setValue(CommonLayoutState.Failed);
        this.d = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit i(h0 h0Var, Object obj) {
        h0Var.b = obj;
        if (obj == 0) {
            h0Var.d();
        } else {
            h0Var.f();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(Function2<? super Function1<? super T, Unit>, ? super Function1<? super w, Unit>, Unit> loadData, T t) {
        Intrinsics.checkNotNullParameter(loadData, "loadData");
        this.a = loadData;
        this.b = t;
        this.c = SnapshotStateKt.mutableStateOf$default(CommonLayoutState.Init, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = new Function1() { // from class: com.dragon.read.kmp.widget.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i;
                i = h0.i(h0.this, obj);
                return i;
            }
        };
        this.f = new Function1() { // from class: com.dragon.read.kmp.widget.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = h0.h(h0.this, (w) obj);
                return h;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(h0 h0Var, w wVar) {
        if (wVar == null) {
            h0Var.e(new w(-2, "错误返回类型:" + wVar));
        } else {
            h0Var.e(wVar);
        }
        return Unit.INSTANCE;
    }
}

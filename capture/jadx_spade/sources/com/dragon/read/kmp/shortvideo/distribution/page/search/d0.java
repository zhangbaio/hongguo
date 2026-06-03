package com.dragon.read.kmp.shortvideo.distribution.page.search;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 {
    public final Function0<Unit> a;
    public final Function2<io4.a, Integer, Unit> b;
    public final Function2<io4.a, Integer, Unit> c;

    static {
        Covode.recordClassIndex(609067);
    }

    public d0() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Intrinsics.areEqual(this.a, d0Var.a) && Intrinsics.areEqual(this.b, d0Var.b) && Intrinsics.areEqual(this.c, d0Var.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SeriesRankSearchPageParams(onClose=" + this.a + ", onClickActor=" + this.b + ", onShowActor=" + this.c + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(io4.a aVar, int i) {
        Intrinsics.checkNotNullParameter(aVar, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(io4.a aVar, int i) {
        Intrinsics.checkNotNullParameter(aVar, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Function0<Unit> onClose, Function2<? super io4.a, ? super Integer, Unit> onClickActor, Function2<? super io4.a, ? super Integer, Unit> onShowActor) {
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onClickActor, "onClickActor");
        Intrinsics.checkNotNullParameter(onShowActor, "onShowActor");
        this.a = onClose;
        this.b = onClickActor;
        this.c = onShowActor;
    }

    public /* synthetic */ d0(Function0 function0, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d;
                d = d0.d();
                return d;
            }
        } : function0, (i & 2) != 0 ? new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.b0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit e;
                e = d0.e((io4.a) obj, ((Integer) obj2).intValue());
                return e;
            }
        } : function2, (i & 4) != 0 ? new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.c0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit f;
                f = d0.f((io4.a) obj, ((Integer) obj2).intValue());
                return f;
            }
        } : function22);
    }
}

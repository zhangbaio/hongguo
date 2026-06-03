package cl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import cl4.o;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    static {
        Covode.recordClassIndex(608052);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, gk4.w wVar, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, long j, long j2, boolean z, d0 d0Var, int i, int i2, Composer composer, int i3) {
        e(modifier, wVar, mutableState, mutableState2, mutableState3, j, j2, z, d0Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final class a implements com.dragon.read.kmp.service.f1 {
        final /* synthetic */ d0 a;
        final /* synthetic */ gk4.w b;
        final /* synthetic */ MutableState<Boolean> c;
        final /* synthetic */ boolean d;
        final /* synthetic */ d0.a e;
        final /* synthetic */ MutableState<Boolean> f;
        final /* synthetic */ MutableState<Long> g;
        final /* synthetic */ MutableState<Boolean> h;

        @Override // com.dragon.read.kmp.service.f1
        public void a() {
        }

        @Override // com.dragon.read.kmp.service.f1
        public void b() {
            this.f.setValue(Boolean.FALSE);
        }

        @Override // com.dragon.read.kmp.service.f1
        public void success() {
            final MutableState<Boolean> mutableState = this.c;
            final boolean z = this.d;
            final d0.a aVar = this.e;
            final MutableState<Boolean> mutableState2 = this.f;
            final MutableState<Long> mutableState3 = this.g;
            final MutableState<Boolean> mutableState4 = this.h;
            final gk4.w wVar = this.b;
            Function2<? super Boolean, ? super Long, Unit> function2 = new Function2() { // from class: cl4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = o.a.f(mutableState, z, aVar, mutableState2, mutableState3, mutableState4, wVar, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue());
                    return f;
                }
            };
            final MutableState<Boolean> mutableState5 = this.c;
            final MutableState<Long> mutableState6 = this.g;
            final MutableState<Boolean> mutableState7 = this.h;
            final gk4.w wVar2 = this.b;
            Function2<? super Boolean, ? super Long, Unit> function22 = new Function2() { // from class: cl4.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = o.a.g(mutableState5, mutableState6, mutableState7, wVar2, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue());
                    return g;
                }
            };
            final MutableState<Boolean> mutableState8 = this.c;
            final MutableState<Boolean> mutableState9 = this.f;
            final MutableState<Long> mutableState10 = this.g;
            final MutableState<Boolean> mutableState11 = this.h;
            final gk4.w wVar3 = this.b;
            this.a.a(this.b, function2, function22, new Function3() { // from class: cl4.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit h;
                    h = o.a.h(mutableState8, mutableState9, mutableState10, mutableState11, wVar3, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue(), (Throwable) obj3);
                    return h;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, gk4.w wVar, boolean z, long j) {
            o.k(mutableState2, mutableState3, wVar, z, j);
            mutableState.setValue(Boolean.FALSE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, gk4.w wVar, boolean z, long j, Throwable th) {
            o.k(mutableState3, mutableState4, wVar, z, j);
            Boolean bool = Boolean.FALSE;
            mutableState.setValue(bool);
            mutableState2.setValue(bool);
            return Unit.INSTANCE;
        }

        a(d0 d0Var, gk4.w wVar, MutableState<Boolean> mutableState, boolean z, d0.a aVar, MutableState<Boolean> mutableState2, MutableState<Long> mutableState3, MutableState<Boolean> mutableState4) {
            this.a = d0Var;
            this.b = wVar;
            this.c = mutableState;
            this.d = z;
            this.e = aVar;
            this.f = mutableState2;
            this.g = mutableState3;
            this.h = mutableState4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(MutableState mutableState, boolean z, d0.a aVar, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, gk4.w wVar, boolean z2, long j) {
            o.k(mutableState3, mutableState4, wVar, z2, j);
            Boolean bool = Boolean.TRUE;
            mutableState.setValue(bool);
            if (z) {
                aVar.a(d0.b.a.f());
            }
            if (z2) {
                mutableState2.setValue(bool);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ tb4.c a;

        public void dispose() {
            tb4.f.f3.a().I5(this.a);
        }

        public b(tb4.c cVar) {
            this.a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult j(tb4.c cVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        tb4.f.f3.a().r9(cVar);
        return new b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(gk4.w wVar, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, gk4.b0 model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.getType() == wVar.r() && Intrinsics.areEqual(model.b, wVar.getObjectId()) && !((Boolean) mutableState.getValue()).booleanValue()) {
            k(mutableState2, mutableState3, wVar, model.c, model.d);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MutableState<Long> mutableState, MutableState<Boolean> mutableState2, gk4.w wVar, boolean z, long j) {
        if (((Boolean) mutableState2.getValue()).booleanValue() == z && ((Number) mutableState.getValue()).longValue() == j) {
            return;
        }
        mutableState2.setValue(Boolean.valueOf(z));
        mutableState.setValue(Long.valueOf(j));
        wVar.n(j);
        wVar.t(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(MutableState mutableState, MutableState mutableState2, gk4.w wVar, d0 d0Var, boolean z, d0.a aVar, MutableState mutableState3, MutableState mutableState4) {
        f(mutableState, mutableState2, wVar, d0Var, z, aVar, mutableState3, mutableState4);
        return Unit.INSTANCE;
    }

    private static final void f(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, gk4.w wVar, d0 d0Var, boolean z, d0.a aVar, MutableState<Long> mutableState3, MutableState<Boolean> mutableState4) {
        if (!((Boolean) mutableState.getValue()).booleanValue() && !((Boolean) mutableState2.getValue()).booleanValue() && wVar.j()) {
            com.dragon.read.kmp.service.c0.a.K5("user_work_post", new a(d0Var, wVar, mutableState, z, aVar, mutableState2, mutableState3, mutableState4));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(androidx.compose.ui.Modifier r49, final gk4.w r50, final androidx.compose.runtime.MutableState<java.lang.Boolean> r51, final androidx.compose.runtime.MutableState<java.lang.Boolean> r52, androidx.compose.runtime.MutableState<java.lang.Long> r53, long r54, long r56, boolean r58, final cl4.d0 r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cl4.o.e(androidx.compose.ui.Modifier, gk4.w, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, long, long, boolean, cl4.d0, androidx.compose.runtime.Composer, int, int):void");
    }
}

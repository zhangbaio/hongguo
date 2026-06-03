package to4;

import androidx.compose.animation.core.n0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.material.a6;
import androidx.compose.material.h1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.e0;
import androidx.compose.ui.input.pointer.m0;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    static {
        Covode.recordClassIndex(609123);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(List list, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        f(list, function1, function12, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class b implements PointerInputEventHandler {
        final /* synthetic */ LazyListState a;
        final /* synthetic */ d0.a b;
        final /* synthetic */ gk4.n c;
        final /* synthetic */ int d;
        final /* synthetic */ MutableState<Integer> e;
        final /* synthetic */ MutableState<Object> f;
        final /* synthetic */ MutableState<Float> g;
        final /* synthetic */ List<gk4.n> h;
        final /* synthetic */ Function1<to4.a, Unit> i;

        /* JADX WARN: Multi-variable type inference failed */
        b(LazyListState lazyListState, d0.a aVar, gk4.n nVar, int i, MutableState<Integer> mutableState, MutableState<Object> mutableState2, MutableState<Float> mutableState3, List<gk4.n> list, Function1<? super to4.a, Unit> function1) {
            this.a = lazyListState;
            this.b = aVar;
            this.c = nVar;
            this.d = i;
            this.e = mutableState;
            this.f = mutableState2;
            this.g = mutableState3;
            this.h = list;
            this.i = function1;
        }

        /* renamed from: to4.n$b$b, reason: collision with other inner class name */
        static final class C0274b implements Function0<Unit> {
            final /* synthetic */ MutableState<Object> a;
            final /* synthetic */ MutableState<Float> b;

            C0274b(MutableState<Object> mutableState, MutableState<Float> mutableState2) {
                this.a = mutableState;
                this.b = mutableState2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }

            public final void a() {
                com.dragon.read.kmp.base.util.b.a("ChannelOrderList", "onDragEnd itemId=" + n.m(this.a) + " totalDragAmount=" + n.o(this.b));
                n.n(this.a, null);
                n.p(this.b, 0.0f);
            }
        }

        static final class c implements Function0<Unit> {
            final /* synthetic */ MutableState<Object> a;
            final /* synthetic */ MutableState<Float> b;

            c(MutableState<Object> mutableState, MutableState<Float> mutableState2) {
                this.a = mutableState;
                this.b = mutableState2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }

            public final void a() {
                com.dragon.read.kmp.base.util.b.a("ChannelOrderList", "onDragCancel itemId=" + n.m(this.a) + " totalDragAmount=" + n.o(this.b));
                n.n(this.a, null);
                n.p(this.b, 0.0f);
            }
        }

        static final class a implements Function1<a0.f, Unit> {
            final /* synthetic */ LazyListState a;
            final /* synthetic */ d0.a b;
            final /* synthetic */ gk4.n c;
            final /* synthetic */ int d;
            final /* synthetic */ MutableState<Integer> e;
            final /* synthetic */ MutableState<Object> f;
            final /* synthetic */ MutableState<Float> g;

            a(LazyListState lazyListState, d0.a aVar, gk4.n nVar, int i, MutableState<Integer> mutableState, MutableState<Object> mutableState2, MutableState<Float> mutableState3) {
                this.a = lazyListState;
                this.b = aVar;
                this.c = nVar;
                this.d = i;
                this.e = mutableState;
                this.f = mutableState2;
                this.g = mutableState3;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a0.f fVar) {
                a(fVar.t());
                return Unit.INSTANCE;
            }

            public final void a(long j) {
                Object obj;
                int i;
                List h = this.a.x().h();
                gk4.n nVar = this.c;
                Iterator it2 = h.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        if (Intrinsics.areEqual(((androidx.compose.foundation.lazy.o) obj).getKey(), nVar.a)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) obj;
                MutableState<Integer> mutableState = this.e;
                if (oVar != null) {
                    i = oVar.getOffset();
                } else {
                    i = 0;
                }
                n.h(mutableState, i);
                this.b.a(d0.b.a.f());
                n.n(this.f, this.c.a);
                n.p(this.g, 0.0f);
                com.dragon.read.kmp.base.util.b.a("ChannelOrderList", "onDragStart itemId=" + this.c.a + " index=" + this.d + " touchY=" + Float.intBitsToFloat((int) (j & 4294967295L)) + " initialOffset=" + n.q(this.e));
            }
        }

        static final class d implements Function2<w, a0.f, Unit> {
            final /* synthetic */ LazyListState a;
            final /* synthetic */ List<gk4.n> b;
            final /* synthetic */ Function1<to4.a, Unit> c;
            final /* synthetic */ MutableState<Float> d;
            final /* synthetic */ MutableState<Object> e;
            final /* synthetic */ MutableState<Integer> f;

            /* JADX WARN: Multi-variable type inference failed */
            d(LazyListState lazyListState, List<gk4.n> list, Function1<? super to4.a, Unit> function1, MutableState<Float> mutableState, MutableState<Object> mutableState2, MutableState<Integer> mutableState3) {
                this.a = lazyListState;
                this.b = list;
                this.c = function1;
                this.d = mutableState;
                this.e = mutableState2;
                this.f = mutableState3;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(w wVar, a0.f fVar) {
                a(wVar, fVar.t());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
            
                if (r9 != false) goto L35;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(androidx.compose.ui.input.pointer.w r8, long r9) {
                /*
                    Method dump skipped, instructions count: 279
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: to4.n.b.d.a(androidx.compose.ui.input.pointer.w, long):void");
            }
        }

        public final Object invoke(e0 e0Var, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object E = DragGestureDetectorKt.E(e0Var, new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g), new C0274b(this.f, this.g), new c(this.f, this.g), new d(this.a, this.h, this.i, this.g, this.f, this.e), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (E == coroutine_suspended) {
                return E;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c implements DisposableEffectResult {
        final /* synthetic */ boolean a;
        final /* synthetic */ Function1 b;

        public void dispose() {
            if (this.a) {
                this.b.invoke(Boolean.FALSE);
            }
        }

        public c(boolean z, Function1 function1) {
            this.a = z;
            this.b = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(boolean z) {
        return Unit.INSTANCE;
    }

    static final class a implements Function1<c1, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ LazyListState b;
        final /* synthetic */ gk4.n c;
        final /* synthetic */ MutableState<Integer> d;
        final /* synthetic */ MutableState<Float> e;

        a(boolean z, LazyListState lazyListState, gk4.n nVar, MutableState<Integer> mutableState, MutableState<Float> mutableState2) {
            this.a = z;
            this.b = lazyListState;
            this.c = nVar;
            this.d = mutableState;
            this.e = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(c1 c1Var) {
            a(c1Var);
            return Unit.INSTANCE;
        }

        public final void a(c1 graphicsLayer) {
            Object obj;
            int i;
            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
            if (this.a) {
                List h = this.b.x().h();
                gk4.n nVar = this.c;
                Iterator it2 = h.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        if (Intrinsics.areEqual(((androidx.compose.foundation.lazy.o) obj).getKey(), nVar.a)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) obj;
                if (oVar != null) {
                    i = oVar.getOffset();
                } else {
                    i = 0;
                }
                graphicsLayer.l((n.q(this.d) + n.o(this.e)) - i);
            }
        }
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public e(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            this.a.get(i);
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object m(MutableState<Object> mutableState) {
        return mutableState.getValue();
    }

    public static final class d implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public d(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MutableState<Object> mutableState, Object obj) {
        mutableState.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(int i, gk4.n item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MutableState<Float> mutableState, float f2) {
        mutableState.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult i(Function1 function1, MutableState mutableState, DisposableEffectScope DisposableEffect) {
        boolean z;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (m(mutableState) != null) {
            z = true;
        } else {
            z = false;
        }
        function1.invoke(Boolean.valueOf(z));
        return new c(z, function1);
    }

    public static final class f implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ LazyListState b;
        final /* synthetic */ d0.a c;
        final /* synthetic */ List d;
        final /* synthetic */ Function1 e;
        final /* synthetic */ MutableState f;
        final /* synthetic */ MutableState g;
        final /* synthetic */ MutableState h;

        public f(List list, LazyListState lazyListState, d0.a aVar, List list2, Function1 function1, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
            this.a = list;
            this.b = lazyListState;
            this.c = aVar;
            this.d = list2;
            this.e = function1;
            this.f = mutableState;
            this.g = mutableState2;
            this.h = mutableState3;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            float f;
            Modifier b;
            boolean z2;
            Modifier modifier;
            float f2;
            boolean z3;
            boolean z4;
            og4.a aVar;
            Modifier modifier2;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i2 | i5;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                gk4.n nVar = (gk4.n) this.a.get(i);
                composer.startReplaceGroup(-1341035194);
                boolean areEqual = Intrinsics.areEqual(n.m(this.f), nVar.a);
                Modifier modifier3 = Modifier.Companion;
                if (areEqual) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                Modifier h = SizeKt.h(androidx.compose.ui.o.a(modifier3, f), 0.0f, 1, (Object) null);
                if (areEqual) {
                    b = modifier3;
                } else {
                    b = androidx.compose.foundation.lazy.e.b(fVar, modifier3, (n0) null, 1, (Object) null);
                }
                Modifier then = h.then(b);
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(areEqual) | composer.changed(this.b);
                int i7 = (i6 & 896) ^ 384;
                if ((i7 > 256 && composer.changedInstance(nVar)) || (i6 & 384) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z5 = changed | z2;
                Object rememberedValue = composer.rememberedValue();
                if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(areEqual, this.b, nVar, this.g, this.h);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier a = b1.a(then, (Function1) rememberedValue);
                if (areEqual) {
                    modifier = androidx.compose.ui.draw.q.b(modifier3, x0.i.g(8), k.g.c(x0.i.g(12)), false, 0L, 0L, 24, (Object) null);
                } else {
                    modifier = modifier3;
                }
                Modifier then2 = a.then(modifier);
                if (nVar.c) {
                    f2 = 0.4f;
                } else {
                    f2 = 1.0f;
                }
                Modifier a2 = androidx.compose.ui.draw.a.a(then2, f2);
                og4.a aVar2 = og4.a.a;
                int i8 = og4.a.b;
                Modifier c = BackgroundKt.c(a2, aVar2.h(composer, i8).w(), k.g.c(x0.i.g(12)));
                composer.startReplaceGroup(926608821);
                if (nVar.c) {
                    aVar = aVar2;
                    modifier2 = modifier3;
                } else {
                    String str = nVar.a;
                    composer.startReplaceGroup(-1224400529);
                    boolean changed2 = composer.changed(this.b);
                    if ((i7 > 256 && composer.changedInstance(nVar)) || (i6 & 384) == 256) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean changedInstance = changed2 | z3 | composer.changedInstance(this.c);
                    if ((((i6 & 112) ^ 48) > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean changedInstance2 = changedInstance | z4 | composer.changedInstance(this.d) | composer.changed(this.e);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (!changedInstance2 && rememberedValue2 != Composer.Companion.getEmpty()) {
                        aVar = aVar2;
                        modifier2 = modifier3;
                    } else {
                        aVar = aVar2;
                        modifier2 = modifier3;
                        b bVar = new b(this.b, this.c, nVar, i, this.g, this.f, this.h, this.d, this.e);
                        composer.updateRememberedValue(bVar);
                        rememberedValue2 = bVar;
                    }
                    composer.endReplaceGroup();
                    modifier3 = m0.c(modifier2, str, (PointerInputEventHandler) rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier s = f2.s(c.then(modifier3), x0.i.g(16), x0.i.g(11));
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.i(), composer, 48);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, s);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a4 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a4);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, b2, companion.c());
                g5.e(b3, currentCompositionLocalMap, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                    b3.updateRememberedValue(Integer.valueOf(a3));
                    b3.apply(Integer.valueOf(a3), b4);
                }
                g5.e(b3, e, companion.d());
                og4.a aVar4 = aVar;
                a6.j(nVar.b, u2.a(w2.b, modifier2, 1.0f, false, 2, (Object) null), aVar4.h(composer, i8).T2(), x.h(15), (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131056);
                Modifier s2 = SizeKt.s(modifier2, x0.i.g(24));
                p0 i9 = androidx.compose.foundation.layout.m.i(aVar3.e(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, s2);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b5 = g5.b(composer);
                g5.e(b5, i9, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                    b5.updateRememberedValue(Integer.valueOf(a5));
                    b5.apply(Integer.valueOf(a5), b6);
                }
                g5.e(b5, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                h1.d(org.jetbrains.compose.resources.c.b(b4.s(d4.a), composer, 0), "Drag", (Modifier) null, aVar4.h(composer, i8).h(), composer, 48, 4);
                composer.endNode();
                composer.endNode();
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final java.util.List<gk4.n> r25, final kotlin.jvm.functions.Function1<? super to4.a, kotlin.Unit> r26, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: to4.n.f(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(List list, LazyListState lazyListState, d0.a aVar, Function1 function1, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.f(list.size(), new d(new Function2() { // from class: to4.m
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object k;
                k = n.k(((Integer) obj).intValue(), (gk4.n) obj2);
                return k;
            }
        }, list), new e(list), t.c(2039820996, true, new f(list, lazyListState, aVar, list, function1, mutableState, mutableState2, mutableState3)));
        return Unit.INSTANCE;
    }
}

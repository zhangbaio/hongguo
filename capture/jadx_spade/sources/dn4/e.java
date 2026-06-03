package dn4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import dn4.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(608743);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(MutableState mutableState, Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        b(mutableState, function1, function12, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<Integer, Unit> a;
        final /* synthetic */ f b;
        final /* synthetic */ Function1<Integer, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Integer, Unit> function1, f fVar, Function1<? super Integer, Unit> function12) {
            this.a = function1;
            this.b = fVar;
            this.c = function12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(c1 graphicsLayer) {
            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
            graphicsLayer.r(false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Function1 function1, f fVar) {
            function1.invoke(Integer.valueOf(fVar.a.a));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(Function1 function1, f fVar) {
            function1.invoke(Integer.valueOf(fVar.a.a));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            d(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void d(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1793336394, i, -1, "com.dragon.read.kmp.search.card.IpAudioBookCard.<anonymous> (IpAudioBookCard.kt:41)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier D = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.a) | composer.changedInstance(this.b);
                final Function1<Integer, Unit> function1 = this.a;
                final f fVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e;
                            e = e.a.e(Function1.this, fVar);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(D, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                final f fVar2 = this.b;
                final Function1<Integer, Unit> function12 = this.c;
                e.m i2 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a3);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                composer.startReplaceGroup(1849434622);
                Object rememberedValue2 = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: dn4.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit f;
                            f = e.a.f((c1) obj);
                            return f;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier a4 = b1.a(aVar, (Function1) rememberedValue2);
                float f = 3;
                Modifier v = f2.v(a4, 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, v);
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
                Composer b3 = g5.b(composer);
                g5.e(b3, i3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                z.d(fVar2.a, composer, 0);
                Modifier e3 = u1.e(boxScopeInstance.b(aVar, aVar2.c()), x0.i.g(f), x0.i.g((float) (-5.5d)));
                composer.startReplaceGroup(-1633490746);
                boolean changed2 = composer.changed(function12) | composer.changedInstance(fVar2);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: dn4.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit g;
                            g = e.a.g(Function1.this, fVar2);
                            return g;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                com.dragon.read.kmp.widget.b.b(ClickableKt.clickable-oSLSa3U$default(e3, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), new com.dragon.read.kmp.widget.c(fVar2.a.b, pg4.j.c(30, composer, 6), pg4.j.c(20, composer, 6), pg4.j.c(20, composer, 6), pg4.j.c(16, composer, 6), fVar2.b, null), composer, com.dragon.read.kmp.widget.c.g << 3, 0);
                composer.endNode();
                z.f(fVar2.a, composer, 0);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void b(final MutableState<f> state, final Function1<? super Integer, Unit> click, final Function1<? super Integer, Unit> onPlayClick, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(onPlayClick, "onPlayClick");
        Composer startRestartGroup = composer.startRestartGroup(-63509497);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(state)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(click)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onPlayClick)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-63509497, i2, -1, "com.dragon.read.kmp.search.card.IpAudioBookCard (IpAudioBookCard.kt:38)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(-1793336394, true, new a(click, (f) state.getValue(), onPlayClick), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = e.c(state, click, onPlayClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}

package cl4;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    static {
        Covode.recordClassIndex(608060);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(MutableState mutableState, MutableState mutableState2, int i, Composer composer, int i2) {
        b(mutableState, mutableState2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a extends jg4.b {
        private Integer b = 216;
        private Integer c = 216;
        private Integer d = 0;
        final /* synthetic */ MutableState<Boolean> e;

        public Integer a() {
            return this.c;
        }

        public Integer b() {
            return this.d;
        }

        public Integer c() {
            return this.b;
        }

        public void d() {
            super.d();
            this.e.setValue(Boolean.FALSE);
        }

        a(MutableState<Boolean> mutableState) {
            this.e = mutableState;
        }
    }

    public static final void b(final MutableState<Boolean> stateShowLikeLottie, final MutableState<Boolean> isLike, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(stateShowLikeLottie, "stateShowLikeLottie");
        Intrinsics.checkNotNullParameter(isLike, "isLike");
        Composer startRestartGroup = composer.startRestartGroup(-174515518);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(stateShowLikeLottie)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(isLike)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-174515518, i2, -1, "com.dragon.read.kmp.profile.container.double_column.LikeLottieInfoItem (LikeLottieInfoItem.kt:25)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier F = SizeKt.F(SizeKt.x(aVar, x0.i.g(48)), (e.b) null, true, 1, (Object) null);
            e.m i5 = androidx.compose.foundation.layout.e.a.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i5, aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, F);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a4 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, a2, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier D = SizeKt.D(SizeKt.s(aVar, x0.i.g(20)), (androidx.compose.ui.e) null, true, 1, (Object) null);
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, D);
            Function0 a6 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i6, companion.c());
            g5.e(b3, currentCompositionLocalMap2, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                b3.updateRememberedValue(Integer.valueOf(a5));
                b3.apply(Integer.valueOf(a5), b4);
            }
            g5.e(b3, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(-251518951);
            if (((Boolean) stateShowLikeLottie.getValue()).booleanValue() && ((Boolean) isLike.getValue()).booleanValue()) {
                if (com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b))) {
                    str = "comment_like/hg_video_comment_like_dark.json";
                } else {
                    str = "comment_like/hg_video_comment_like.json";
                }
                com.dragon.read.kmp.compose.common.b.q(str, (String) null, new a(stateShowLikeLottie), startRestartGroup, 48, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: cl4.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = a0.c(stateShowLikeLottie, isLike, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}

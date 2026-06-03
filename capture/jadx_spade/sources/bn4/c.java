package bn4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchTabType;
import com.dragon.read.component.biz.impl.search.feed.holder.h2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.h;
import x0.i;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements kn4.a {
    static {
        Covode.recordClassIndex(608733);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(c cVar, h2 h2Var, int i, Composer composer, int i2) {
        cVar.q9(h2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    @Override // kn4.a
    public int A8() {
        return 4;
    }

    @Override // kn4.a
    public int D6() {
        return 1;
    }

    @Override // kn4.a
    public int Z2() {
        return 8;
    }

    @Override // kn4.a
    public int Z8() {
        return 12;
    }

    @Override // kn4.a
    public boolean a0() {
        return false;
    }

    @Override // kn4.a
    public String getDesc() {
        return "hg search";
    }

    @Override // kn4.a
    public int l8() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(h2 h2Var) {
        ai3.a.a.a(h2Var.n);
        return Unit.INSTANCE;
    }

    @Override // kn4.a
    public String F9(int i) {
        if (SearchTabType.Topic.getValue() == i) {
            return "去书荒广场逛逛";
        }
        if (SearchTabType.Comic.getValue() != i && SearchTabType.ShortPlay.getValue() != i && SearchTabType.ShortPlaySingle.getValue() != i && SearchTabType.Community.getValue() != i && SearchTabType.LongVideo.getValue() != i) {
            SearchTabType.DynamicComic.getValue();
        }
        return "去剧场逛逛";
    }

    @Override // kn4.a
    public void q9(final h2 data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        List listOf;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1601564926);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1601564926, i2, -1, "com.dragon.read.kmp.search.HongguoSearchBs.SearchEmptyButton (HongguoSearchBs.kt:32)");
            }
            e.c i4 = androidx.compose.ui.e.a.i();
            e.f d = androidx.compose.foundation.layout.e.a.d();
            Modifier i5 = SizeKt.i(androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.c(i.g(8))), i.g(40));
            c0.a aVar = c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(n0.d(4294928488L)), l0.j(n0.d(4160703597L)), l0.j(n0.d(4293899874L))});
            Modifier t = f2.t(BackgroundKt.b(i5, c0.a.h(aVar, listOf, 0L, 0L, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), i.g(16), 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(data);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: bn4.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit J0;
                        J0 = c.J0(data);
                        return J0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            p0 b = r2.b(d, i4, startRestartGroup, 54);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            composer2 = startRestartGroup;
            a6.j(data.o, (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).r(), x.h(16), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, h.h(h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 130546);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bn4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit s1;
                    s1 = c.s1(c.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return s1;
                }
            });
        }
    }
}

package bk4;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.rm0;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o extends e0 {
    public static final int v;
    private final xh4.a u;

    static {
        Covode.recordClassIndex(607756);
        v = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(o oVar, androidx.compose.foundation.layout.r rVar, ck4.d dVar, int i, Composer composer, int i2) {
        oVar.s0(rVar, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    @Override // bk4.e
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public boolean w0(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return false;
    }

    @Override // bk4.e
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public boolean x0(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return false;
    }

    @Override // bk4.e0
    public void j1(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ym4.o.a.d("show_post_card", f1(data).n());
    }

    @Override // bk4.e0
    public ym4.k f1(ck4.d data) {
        String str;
        rm0 rm0Var;
        cj0 cj0Var;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        om0 om0Var = data.q;
        String str3 = "";
        if (om0Var == null || (str = om0Var.p) == null) {
            str = "";
        }
        ym4.k d = super.f1(data).d("src_material_show_name", J0()).d("card_type", "video").d("post_card_id", str).d("src_material_id", str);
        om0 om0Var2 = data.q;
        if (om0Var2 != null && (rm0Var = om0Var2.g0) != null && (cj0Var = rm0Var.R) != null && (str2 = cj0Var.a) != null) {
            str3 = str2;
        }
        return d.d("card_user_id", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(wh4.i depend, xh4.a aVar) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.u = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // bk4.e0
    /* renamed from: i1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W(int r136, ck4.d r137, android.content.Context r138) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.o.W(int, ck4.d, android.content.Context):void");
    }

    @Override // bk4.e0, bk4.e
    /* renamed from: Y0 */
    public void s0(final androidx.compose.foundation.layout.r rVar, final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        long j;
        Long l;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1274381082);
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(this)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & 145) != 144) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274381082, i2, -1, "com.dragon.read.kmp.mine.search.holder.PostVideoSearchHolder.ComposeInCover (PostVideoSearchHolder.kt:54)");
            }
            int i5 = i2 >> 3;
            V0(data, startRestartGroup, (i5 & 112) | (i5 & 14));
            om0 om0Var = data.q;
            if (om0Var != null && (l = om0Var.C) != null) {
                j = l.longValue();
            } else {
                j = -1;
            }
            if (j > 0) {
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, f);
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
                Composer b = g5.b(startRestartGroup);
                g5.e(b, i6, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String a3 = ic4.b.a.a(j);
                Modifier b3 = boxScopeInstance.b(f2.v(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), 0.0f, 0.0f, x0.i.g(8), x0.i.g(7), 3, (Object) null), aVar2.c());
                p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b3);
                Function0 a5 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, b4, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e2, companion.d());
                w2 w2Var = w2.b;
                e1 a6 = org.jetbrains.compose.resources.c.a(o1.g(w6.a), startRestartGroup, 0);
                Modifier s = SizeKt.s(aVar, x0.i.g(12));
                m0.a aVar3 = m0.b;
                og4.a aVar4 = og4.a.a;
                int i7 = og4.a.b;
                composer2 = startRestartGroup;
                z0.g(a6, "digg count", s, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, aVar4.h(startRestartGroup, i7).r(), 0, 2, (Object) null), 0, startRestartGroup, 432, 184);
                androidx.compose.foundation.layout.m.b(SizeKt.x(aVar, x0.i.g(2)), composer2, 6);
                a6.j(a3, (Modifier) null, aVar4.h(composer2, i7).r(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3072, 122866);
                composer2.endNode();
                composer2.endNode();
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o1;
                    o1 = o.o1(o.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o1;
                }
            });
        }
    }
}

package cn4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.i;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.material.h1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import cn4.f;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImage_androidKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sh3.i1;
import sh3.k1;
import w0.h;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(608740);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(g gVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        c(gVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(g gVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        c(gVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ g b;
        final /* synthetic */ cn4.a c;

        a(Modifier modifier, g gVar, cn4.a aVar) {
            this.a = modifier;
            this.b = gVar;
            this.c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(g gVar) {
            gVar.F0();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            org.jetbrains.compose.resources.b w;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-651292000, i, -1, "com.dragon.read.kmp.search.aisearch.AISearchBannerViewKmp.<anonymous> (AISearchBannerViewKmp.kt:44)");
                }
                Modifier B = SizeKt.B(SizeKt.h(this.a, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.b);
                final g gVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: cn4.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = f.a.d(g.this);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(B, false, (String) null, (Role) null, (i) null, (Function0) rememberedValue, 15, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance2 = composer.changedInstance(this.c) | composer.changedInstance(this.b);
                final cn4.a aVar = this.c;
                final g gVar2 = this.b;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: cn4.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e;
                            e = f.a.e(a.this, gVar2, (w) obj);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier a = d1.a(modifier, (Function1) rememberedValue2);
                cn4.a aVar2 = this.c;
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 i2 = m.i(aVar3.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, a);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier.a aVar4 = Modifier.Companion;
                float f = 44;
                float f2 = 8;
                LoadImage_androidKt.j("img_675_search_book_robot_entrance.png", (String) null, (androidx.compose.ui.e) null, (n) null, androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(aVar4, 0.0f, 1, (Object) null), x0.i.g(f)), k.g.c(x0.i.g(f2))), composer, 6, 14);
                Modifier s = f2.s(SizeKt.i(SizeKt.B(SizeKt.h(aVar4, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f)), x0.i.g(12), x0.i.g(f2));
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.i(), composer, 48);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, s);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b4 = g5.b(composer);
                g5.e(b4, b3, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e2, companion.d());
                w2 w2Var = w2.b;
                if (com.dragon.read.kmp.service.d1.d((Theme) composer.consume(rg4.e.l()))) {
                    w = i1.v(k1.a);
                } else {
                    w = i1.w(k1.a);
                }
                float f3 = 28;
                z0.c(org.jetbrains.compose.resources.c.b(w, composer, 0), "", SizeKt.u(aVar4, x0.i.g(f3), x0.i.g(f3)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, composer, 432, 120);
                a3.a(SizeKt.x(aVar4, x0.i.g(f2)), composer, 6);
                String str = aVar2.a;
                if (str == null) {
                    str = "";
                }
                Modifier D = SizeKt.D(aVar4, (androidx.compose.ui.e) null, false, 3, (Object) null);
                og4.a aVar5 = og4.a.a;
                int i3 = og4.a.b;
                a6.j(str, D, aVar5.h(composer, i3).k(), x.h(14), (y) null, (c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3120, 0, 131056);
                a3.a(SizeKt.x(aVar4, x0.i.g(f2)), composer, 6);
                String str2 = aVar2.b;
                if (str2 == null) {
                    str2 = "";
                }
                a6.j(str2, SizeKt.D(aVar4, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar5.h(composer, i3).X0(), x.h(12), (y) null, (c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3120, 0, 131056);
                a3.a(u2.a(w2Var, aVar4, 1.0f, false, 2, (Object) null), composer, 0);
                h1.d(org.jetbrains.compose.resources.c.b(i1.d(k1.a), composer, 0), "", (Modifier) null, aVar5.h(composer, i3).k(), composer, 48, 4);
                composer.endNode();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(cn4.a aVar, g gVar, w it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            if (!aVar.d) {
                gVar.G0();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final cn4.g r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            r0 = r17
            r1 = r20
            r2 = r21
            java.lang.String r3 = "viewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -840408847(0xffffffffcde860f1, float:-4.873334E8)
            r4 = r19
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            r5 = r2 & 1
            if (r5 == 0) goto L1c
            r5 = r1 | 6
            goto L2c
        L1c:
            r5 = r1 & 6
            if (r5 != 0) goto L2b
            boolean r5 = r4.changedInstance(r0)
            if (r5 == 0) goto L28
            r5 = 4
            goto L29
        L28:
            r5 = 2
        L29:
            r5 = r5 | r1
            goto L2c
        L2b:
            r5 = r1
        L2c:
            r6 = r2 & 2
            if (r6 == 0) goto L33
            r5 = r5 | 48
            goto L46
        L33:
            r7 = r1 & 48
            if (r7 != 0) goto L46
            r7 = r18
            boolean r8 = r4.changed(r7)
            if (r8 == 0) goto L42
            r8 = 32
            goto L44
        L42:
            r8 = 16
        L44:
            r5 = r5 | r8
            goto L48
        L46:
            r7 = r18
        L48:
            r8 = r5 & 19
            r9 = 18
            r10 = 1
            if (r8 == r9) goto L51
            r8 = 1
            goto L52
        L51:
            r8 = 0
        L52:
            r9 = r5 & 1
            boolean r8 = r4.shouldExecute(r8, r9)
            if (r8 == 0) goto Lb7
            if (r6 == 0) goto L5f
            androidx.compose.ui.Modifier$a r6 = androidx.compose.ui.Modifier.Companion
            goto L60
        L5f:
            r6 = r7
        L60:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L6c
            r7 = -1
            java.lang.String r8 = "com.dragon.read.kmp.search.aisearch.AISearchBannerViewKmp (AISearchBannerViewKmp.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r5, r7, r8)
        L6c:
            androidx.compose.runtime.State<cn4.a> r3 = r0.b
            java.lang.Object r3 = r3.getValue()
            cn4.a r3 = (cn4.a) r3
            if (r3 != 0) goto L8e
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L7f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L7f:
            androidx.compose.runtime.t3 r3 = r4.endRestartGroup()
            if (r3 == 0) goto L8d
            cn4.b r4 = new cn4.b
            r4.<init>()
            r3.a(r4)
        L8d:
            return
        L8e:
            pg4.h r5 = new pg4.h
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7
            r16 = 0
            r11 = r5
            r11.<init>(r12, r13, r14, r15, r16)
            cn4.f$a r7 = new cn4.f$a
            r7.<init>(r6, r0, r3)
            r3 = 54
            r8 = -651292000(0xffffffffd92e12a0, float:-3.0623203E15)
            androidx.compose.runtime.internal.a r3 = androidx.compose.runtime.internal.t.e(r8, r10, r7, r4, r3)
            r7 = 48
            pg4.p.e(r5, r3, r4, r7)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto Lbb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto Lbb
        Lb7:
            r4.skipToGroupEnd()
            r6 = r7
        Lbb:
            androidx.compose.runtime.t3 r3 = r4.endRestartGroup()
            if (r3 == 0) goto Lc9
            cn4.c r4 = new cn4.c
            r4.<init>()
            r3.a(r4)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn4.f.c(cn4.g, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}

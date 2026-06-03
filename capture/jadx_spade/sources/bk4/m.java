package bk4;

import android.content.Context;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.di0;
import com.bytedance.kmp.reading.model.ga;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.kmp.basenovel.ui.widget.staggered.RecyclerHolder;
import com.dragon.read.kmp.utils.k0;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends e<ck4.c> {
    public static final int r;

    static {
        Covode.recordClassIndex(607755);
        r = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(m mVar, androidx.compose.foundation.layout.r rVar, ck4.c cVar, int i, Composer composer, int i2) {
        mVar.s0(rVar, cVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(m mVar, ck4.c cVar, int i, int i2, Composer composer, int i3) {
        mVar.A0(cVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public void Z() {
        super.Z();
        ck4.c cVar = (ck4.c) ((RecyclerHolder) this).d;
        if (cVar == null) {
            return;
        }
        ym4.o.a.d("show_post_card", a1(cVar).n());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
    }

    @Override // bk4.e
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public boolean w0(ck4.c data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return !data.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long b1(ck4.c r6) {
        /*
            r5 = this;
            boolean r0 = r6.o
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L2a
            com.bytedance.kmp.reading.model.di0 r0 = r6.n
            java.lang.Integer r0 = r0.r
            com.bytedance.kmp.ugc.model.UgcCloudStatus r4 = com.bytedance.kmp.ugc.model.UgcCloudStatus.Reject
            int r4 = r4.getValue()
            if (r0 != 0) goto L14
            goto L1a
        L14:
            int r0 = r0.intValue()
            if (r0 == r4) goto L2a
        L1a:
            com.bytedance.kmp.reading.model.di0 r6 = r6.n
            java.lang.Integer r6 = r6.v0
            if (r6 == 0) goto L42
            int r6 = r6.intValue()
            long r0 = (long) r6
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L42
        L2a:
            boolean r0 = r6.p
            if (r0 == 0) goto L3e
            com.bytedance.kmp.reading.model.di0 r6 = r6.n
            java.lang.Integer r6 = r6.h
            if (r6 == 0) goto L42
            int r6 = r6.intValue()
            long r0 = (long) r6
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L42
        L3e:
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
        L42:
            if (r1 == 0) goto L48
            long r2 = r1.longValue()
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.m.b1(ck4.c):long");
    }

    private final ym4.k a1(ck4.c cVar) {
        String str;
        ym4.k b = k0.a.b();
        b.g(hn4.c.a.a(cVar.g));
        b.c("module_rank", Integer.valueOf(((RecyclerHolder) this).b + 1));
        b.c("rank", Integer.valueOf(((RecyclerHolder) this).b + 1));
        b.d("search_entrance", "mine_tab");
        b.d("cover_url", C0());
        b.d("src_material_show_name", J0());
        b.d("card_type", "video");
        if (!cVar.o) {
            b.d("sub_title", F0());
            b.d("upper_right_info", I0());
        }
        b.d("card_type", "picture");
        String str2 = cVar.n.a;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        b.d("post_card_id", str2);
        ga gaVar = cVar.n.l;
        if (gaVar != null && (str = gaVar.a) != null) {
            str3 = str;
        }
        b.d("card_user_id", str3);
        return b;
    }

    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void W(int i, ck4.c data, Context context) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        super.W(i, data, context);
        ym4.k a1 = a1(data);
        ym4.o.a.d("click_post_card", a1.n());
        tb4.l a = eo0.c.a.a(Reflection.getOrCreateKotlinClass(tb4.l.class));
        if (a != null) {
            di0 di0Var = data.n;
            String str2 = di0Var.a;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            ga gaVar = di0Var.l;
            if (gaVar != null && (str = gaVar.a) != null) {
                str3 = str;
            }
            a.Z5(str2, str3, context, a1);
        }
    }

    @Override // bk4.e
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void A0(final ck4.c data, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        String str;
        boolean changedInstance;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1636875191);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(this);
            } else {
                changedInstance = startRestartGroup.changedInstance(this);
            }
            if (changedInstance) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1636875191, i3, -1, "com.dragon.read.kmp.mine.search.holder.PicPostSearchHolder.bindHistoryContent (PicPostSearchHolder.kt:51)");
            }
            super.A0(data, i, startRestartGroup, (i3 & 14) | (i3 & 112) | (yh4.g.l << 6) | (i3 & 896));
            S0(data.n.k);
            P0(data.n.Y);
            String str2 = null;
            if (data.o) {
                str = null;
            } else {
                str = "图文";
            }
            R0(str);
            if (!data.o) {
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                ga gaVar = data.n.l;
                if (gaVar != null) {
                    str2 = gaVar.c;
                }
                sb.append(str2);
                str2 = sb.toString();
            }
            Q0(str2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Z0;
                    Z0 = m.Z0(m.this, data, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return Z0;
                }
            });
        }
    }

    @Override // bk4.e
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public void s0(final androidx.compose.foundation.layout.r rVar, final ck4.c data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        Painter h;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-914489715);
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
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(this);
            } else {
                changedInstance = startRestartGroup.changedInstance(this);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-914489715, i2, -1, "com.dragon.read.kmp.mine.search.holder.PicPostSearchHolder.ComposeInCover (PicPostSearchHolder.kt:72)");
            }
            startRestartGroup.startReplaceGroup(1643682905);
            if (data.o) {
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
                g5.e(b, i5, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                float f2 = 4;
                Modifier v = f2.v(BoxScopeInstance.a.b(aVar, aVar2.n()), 0.0f, x0.i.g(f2), x0.i.g(f2), 0.0f, 9, (Object) null);
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
                Composer b3 = g5.b(startRestartGroup);
                g5.e(b3, i6, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                    b3.updateRememberedValue(Integer.valueOf(a3));
                    b3.apply(Integer.valueOf(a3), b4);
                }
                g5.e(b3, e2, companion.d());
                e1 a5 = org.jetbrains.compose.resources.c.a(o1.f(w6.a), startRestartGroup, 0);
                Modifier s = SizeKt.s(aVar, x0.i.g(20));
                composer2 = startRestartGroup;
                z0.g(a5, "pic post tag", s, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 432, 248);
                composer2.endNode();
                composer2.endNode();
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            long b1 = b1(data);
            if (b1 > 0) {
                Modifier.a aVar3 = Modifier.Companion;
                Modifier f3 = SizeKt.f(aVar3, 0.0f, 1, (Object) null);
                e.a aVar4 = androidx.compose.ui.e.a;
                p0 i7 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
                int a6 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer2, f3);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a7 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a7);
                } else {
                    composer2.useNode();
                }
                Composer b5 = g5.b(composer2);
                g5.e(b5, i7, companion2.c());
                g5.e(b5, currentCompositionLocalMap3, companion2.e());
                Function2 b6 = companion2.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                    b5.updateRememberedValue(Integer.valueOf(a6));
                    b5.apply(Integer.valueOf(a6), b6);
                }
                g5.e(b5, e3, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String a8 = ic4.b.a.a(b1);
                Modifier b7 = boxScopeInstance.b(f2.v(SizeKt.D(aVar3, (androidx.compose.ui.e) null, false, 3, (Object) null), 0.0f, 0.0f, x0.i.g(8), x0.i.g(7), 3, (Object) null), aVar4.c());
                p0 b8 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar4.i(), composer2, 48);
                int a9 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer2, b7);
                Function0 a10 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a10);
                } else {
                    composer2.useNode();
                }
                Composer b9 = g5.b(composer2);
                g5.e(b9, b8, companion2.c());
                g5.e(b9, currentCompositionLocalMap4, companion2.e());
                Function2 b10 = companion2.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a9))) {
                    b9.updateRememberedValue(Integer.valueOf(a9));
                    b9.apply(Integer.valueOf(a9), b10);
                }
                g5.e(b9, e4, companion2.d());
                w2 w2Var = w2.b;
                if (data.o) {
                    composer2.startReplaceGroup(1168306822);
                    e1 a11 = org.jetbrains.compose.resources.c.a(o1.g(w6.a), composer2, 0);
                    composer2.startReplaceGroup(5004770);
                    boolean changed = composer2.changed(a11);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = androidx.compose.ui.graphics.painter.b.b(a11, 0L, 0L, androidx.compose.ui.graphics.drawscope.f.h0.b(), 6, (Object) null);
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
                    h = (androidx.compose.ui.graphics.painter.a) rememberedValue;
                } else {
                    composer2.startReplaceGroup(1168666019);
                    h = VectorPainterKt.h(org.jetbrains.compose.resources.c.c(o1.p(w6.a), composer2, 0), composer2, 0);
                    composer2.endReplaceGroup();
                }
                Modifier s2 = SizeKt.s(aVar3, x0.i.g(12));
                m0.a aVar5 = m0.b;
                og4.a aVar6 = og4.a.a;
                int i8 = og4.a.b;
                z0.c(h, "digg count", s2, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar5, aVar6.h(composer2, i8).r(), 0, 2, (Object) null), composer2, 432, 56);
                androidx.compose.foundation.layout.m.b(SizeKt.x(aVar3, x0.i.g(2)), composer2, 6);
                a6.j(a8, (Modifier) null, aVar6.h(composer2, i8).r(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3072, 122866);
                composer2.endNode();
                composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: bk4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit W0;
                    W0 = m.W0(m.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return W0;
                }
            });
        }
    }
}

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
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.rm0;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t extends e0 {
    public static final a u;
    public static final int v;

    public static final class a {
        static {
            Covode.recordClassIndex(607759);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607758);
        u = new a(null);
        v = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(t tVar, androidx.compose.foundation.layout.r rVar, ck4.d dVar, int i, Composer composer, int i2) {
        tVar.s0(rVar, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(t tVar, ck4.d dVar, int i, int i2, Composer composer, int i3) {
        tVar.A0(dVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
    }

    private final void r1(om0 om0Var) {
        long j;
        String str;
        String str2;
        rm0 rm0Var;
        cj0 cj0Var;
        ok0 ok0Var;
        rm0 rm0Var2;
        List list;
        om0 om0Var2;
        Long l;
        boolean z = false;
        if (om0Var != null && (rm0Var2 = om0Var.g0) != null && (list = rm0Var2.i) != null && (om0Var2 = (om0) CollectionsKt___CollectionsKt.getOrNull(list, 0)) != null && (l = om0Var2.b0) != null) {
            j = l.longValue();
        } else {
            j = -2;
        }
        if (om0Var != null && (rm0Var = om0Var.g0) != null && (cj0Var = rm0Var.R) != null && (ok0Var = cj0Var.b) != null) {
            str = ok0Var.b;
        } else {
            str = null;
        }
        if (om0Var != null) {
            Integer num = om0Var.y;
            int value = VideoContentType.PUGC.getValue();
            if (num != null && num.intValue() == value) {
                z = true;
            }
        }
        if (z) {
            str2 = '@' + str;
        } else if (j != -2) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) 31532);
            sb.append(j);
            sb.append((char) 38598);
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        Q0(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // bk4.e0
    /* renamed from: i1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W(int r8, ck4.d r9, android.content.Context r10) {
        /*
            r7 = this;
            java.lang.String r8 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r8)
            com.bytedance.kmp.reading.model.om0 r8 = r9.q
            if (r8 != 0) goto La
            return
        La:
            ld4.b r9 = r7.m1(r9)
            r9.m()
            com.dragon.read.kmp.utils.k0 r0 = com.dragon.read.kmp.utils.k0.a
            ym4.k r0 = r0.b()
            ym4.a r9 = r9.b
            ym4.k r5 = r0.g(r9)
            com.bytedance.kmp.reading.model.rm0 r9 = r8.g0
            r0 = 0
            if (r9 == 0) goto L2b
            java.lang.Long r9 = r9.d0
            if (r9 == 0) goto L2b
            java.lang.String r9 = r9.toString()
            goto L2c
        L2b:
            r9 = r0
        L2c:
            if (r9 != 0) goto L58
            java.lang.Integer r1 = r8.y
            com.bytedance.kmp.reading.model.VideoContentType r2 = com.bytedance.kmp.reading.model.VideoContentType.Album
            int r2 = r2.getValue()
            java.lang.String r3 = ""
            if (r1 != 0) goto L3b
            goto L50
        L3b:
            int r1 = r1.intValue()
            if (r1 != r2) goto L50
            com.bytedance.kmp.reading.model.jm0 r1 = r8.R0
            if (r1 == 0) goto L54
            java.lang.Long r1 = r1.a
            if (r1 == 0) goto L54
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L56
            goto L54
        L50:
            java.lang.String r1 = r8.p
            if (r1 != 0) goto L56
        L54:
            r2 = r3
            goto L59
        L56:
            r2 = r1
            goto L59
        L58:
            r2 = r9
        L59:
            if (r9 == 0) goto L64
            int r9 = r9.length()
            if (r9 != 0) goto L62
            goto L64
        L62:
            r9 = 0
            goto L65
        L64:
            r9 = 1
        L65:
            if (r9 == 0) goto L73
            java.lang.Integer r9 = r8.y
            if (r9 == 0) goto L70
            int r9 = r9.intValue()
            goto L79
        L70:
            com.bytedance.kmp.reading.model.VideoContentType r9 = com.bytedance.kmp.reading.model.VideoContentType.ShortSeriesPlay
            goto L75
        L73:
            com.bytedance.kmp.reading.model.VideoContentType r9 = com.bytedance.kmp.reading.model.VideoContentType.Album
        L75:
            int r9 = r9.getValue()
        L79:
            r4 = r9
            eo0.c r9 = eo0.c.a
            java.lang.Class<tb4.l> r1 = tb4.l.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            eo0.a r9 = r9.a(r1)
            r1 = r9
            tb4.l r1 = (tb4.l) r1
            if (r1 == 0) goto La4
            com.bytedance.kmp.reading.model.rm0 r8 = r8.g0
            if (r8 == 0) goto L9f
            java.util.List r8 = r8.i
            if (r8 == 0) goto L9f
            java.lang.Object r8 = kotlin.collections.CollectionsKt.firstOrNull(r8)
            com.bytedance.kmp.reading.model.om0 r8 = (com.bytedance.kmp.reading.model.om0) r8
            if (r8 == 0) goto L9f
            java.lang.String r8 = r8.a
            r3 = r8
            goto La0
        L9f:
            r3 = r0
        La0:
            r6 = r10
            r1.N1(r2, r3, r4, r5, r6)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.t.W(int, ck4.d, android.content.Context):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if (r2 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0102, code lost:
    
        if (r4 != false) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010d  */
    @Override // bk4.e0, bk4.e
    /* renamed from: Z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0(final ck4.d r8, final int r9, androidx.compose.runtime.Composer r10, final int r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.t.A0(ck4.d, int, androidx.compose.runtime.Composer, int):void");
    }

    @Override // bk4.e0, bk4.e
    /* renamed from: Y0 */
    public void s0(final androidx.compose.foundation.layout.r rVar, final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        om0 om0Var;
        long j;
        boolean z2;
        Long l;
        rm0 rm0Var;
        List list;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-575555412);
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
                ComposerKt.traceEventStart(-575555412, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoLikeSearchHolder.ComposeInCover (VideoLikeSearchHolder.kt:65)");
            }
            int i5 = i2 >> 3;
            V0(data, startRestartGroup, (i5 & 112) | (i5 & 14) | (yh4.g.l << 3));
            om0 om0Var2 = data.q;
            if (om0Var2 != null && (rm0Var = om0Var2.g0) != null && (list = rm0Var.i) != null) {
                om0Var = (om0) CollectionsKt___CollectionsKt.getOrNull(list, 0);
            } else {
                om0Var = null;
            }
            if (om0Var != null && (l = om0Var.q) != null) {
                j = l.longValue();
            } else {
                j = -1;
            }
            if (e1().length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && j > 0) {
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, f);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b = g5.b(startRestartGroup);
                g5.e(b, i6, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String a4 = ic4.b.a.a(j);
                Modifier b3 = boxScopeInstance.b(f2.v(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), 0.0f, 0.0f, x0.i.g(8), x0.i.g(7), 3, (Object) null), aVar2.c());
                p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b3);
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, b4, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                    b5.updateRememberedValue(Integer.valueOf(a5));
                    b5.apply(Integer.valueOf(a5), b6);
                }
                g5.e(b5, e2, companion.d());
                w2 w2Var = w2.b;
                androidx.compose.ui.graphics.vector.c c = org.jetbrains.compose.resources.c.c(o1.p(w6.a), startRestartGroup, 0);
                Modifier s = SizeKt.s(aVar, x0.i.g(12));
                m0.a aVar3 = m0.b;
                og4.a aVar4 = og4.a.a;
                int i7 = og4.a.b;
                z0.d(c, "digg count", s, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, aVar4.h(startRestartGroup, i7).r(), 0, 2, (Object) null), startRestartGroup, 432, 56);
                composer2 = startRestartGroup;
                a6.j(a4, (Modifier) null, aVar4.h(startRestartGroup, i7).r(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3072, 122866);
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
            endRestartGroup.a(new Function2() { // from class: bk4.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p1;
                    p1 = t.p1(t.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return p1;
                }
            });
        }
    }
}

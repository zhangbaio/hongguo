package bk4;

import android.content.Context;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.d1;
import com.dragon.read.kmp.basenovel.ui.widget.staggered.RecyclerHolder;
import com.dragon.read.kmp.service.j0;
import com.dragon.read.kmp.utils.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class i extends e<ck4.a> {
    public static final int s;
    private final MutableState<Boolean> r;

    static {
        Covode.recordClassIndex(607753);
        s = yh4.g.l;
    }

    public void Z() {
        super.Z();
        ck4.a aVar = (ck4.a) ((RecyclerHolder) this).d;
        if (aVar == null) {
            return;
        }
        Z0(aVar).e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.r = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    protected final hd4.a Z0(ck4.a data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        hd4.a f = new hd4.a().f(data.p);
        d1 d1Var = data.p;
        if (d1Var != null) {
            str = d1Var.v;
        } else {
            str = null;
        }
        return f.h(str).g(b1(data).i());
    }

    @Override // bk4.e
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public i2 B0(ck4.a data) {
        Integer num;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        d1 d1Var = data.p;
        nc4.a aVar = nc4.a.a;
        if (d1Var != null && (str = d1Var.X) != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        } else {
            num = null;
        }
        if (aVar.m(num)) {
            return f2.j(0.0f, 0.0f, x0.i.g(2), x0.i.g(5), 3, (Object) null);
        }
        return super.B0(data);
    }

    private final ym4.k b1(ck4.a aVar) {
        return k0.a.b().g(hn4.c.a.a(aVar.g)).c("module_rank", Integer.valueOf(((RecyclerHolder) this).b + 1)).c("rank", Integer.valueOf(((RecyclerHolder) this).b + 1)).d("search_entrance", "mine_tab").d("cover_url", C0()).d("src_material_show_name", J0()).d("side_title", F0()).d("upper_right_info", I0());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X0(ck4.a r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1445207662(0x56241e6e, float:4.511265E13)
            r13.startReplaceGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L17
            r1 = -1
            java.lang.String r2 = "com.dragon.read.kmp.mine.search.holder.BookSearchHolder.bindSubTitle (BookSearchHolder.kt:53)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L17:
            com.bytedance.kmp.reading.model.d1 r14 = r12.p
            r0 = 0
            if (r14 == 0) goto L25
            java.lang.String r1 = r14.J
            if (r1 == 0) goto L25
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
            goto L26
        L25:
            r1 = r0
        L26:
            if (r14 == 0) goto L37
            java.lang.String r2 = r14.y
            if (r2 == 0) goto L37
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L37
            int r2 = r2.intValue()
            goto L38
        L37:
            r2 = 0
        L38:
            com.dragon.read.kmp.mine.data.b r3 = r12.n
            com.dragon.read.kmp.mine.data.a r3 = (com.dragon.read.kmp.mine.data.a) r3
            nc4.a r4 = nc4.a.a
            boolean r1 = r4.s(r1)
            if (r1 == 0) goto L4e
            ak4.l r12 = ak4.l.a
            java.lang.String r12 = r12.b(r3)
            r11.Q0(r12)
            goto La6
        L4e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "观看至"
            r1.append(r2)
            com.dragon.read.kmp.mine.data.b r12 = r12.n
            if (r12 == 0) goto L64
            int r12 = r12.e
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L65
        L64:
            r12 = r0
        L65:
            r1.append(r12)
            r12 = 37
            r1.append(r12)
            java.lang.String r5 = r1.toString()
            if (r14 == 0) goto L7c
            java.lang.String r12 = r14.X
            if (r12 == 0) goto L7c
            java.lang.Integer r12 = kotlin.text.StringsKt.toIntOrNull(r12)
            goto L7d
        L7c:
            r12 = r0
        L7d:
            boolean r12 = r4.m(r12)
            if (r12 == 0) goto La3
            java.lang.String r6 = "看"
            java.lang.String r7 = "听"
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r5 = kotlin.text.StringsKt.replace$default(r5, r6, r7, r8, r9, r10)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r12 = r11.r
            com.dragon.read.kmp.service.j0 r1 = com.dragon.read.kmp.service.j0.a
            if (r14 == 0) goto L98
            java.lang.String r0 = r14.c
        L98:
            boolean r14 = r1.a(r0)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            r12.setValue(r14)
        La3:
            r11.Q0(r5)
        La6:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto Laf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Laf:
            r13.endReplaceGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.i.X0(ck4.a, androidx.compose.runtime.Composer, int):void");
    }

    public void Y0(ck4.a data, Composer composer, int i) {
        Integer num;
        Integer num2;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(993613480);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(993613480, i, -1, "com.dragon.read.kmp.mine.search.holder.BookSearchHolder.bindTagInfo (BookSearchHolder.kt:124)");
        }
        d1 d1Var = data.p;
        String str5 = null;
        if (d1Var != null && (str4 = d1Var.J) != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str4);
        } else {
            num = null;
        }
        if (d1Var != null && (str3 = d1Var.m) != null) {
            num2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
        } else {
            num2 = null;
        }
        if (d1Var != null) {
            str = d1Var.i;
        } else {
            str = null;
        }
        nc4.a aVar = nc4.a.a;
        if (aVar.s(num)) {
            str2 = "短篇";
        } else if (aVar.p(num2)) {
            str2 = "出版";
        } else {
            if (d1Var != null) {
                str5 = d1Var.T;
            }
            if (aVar.n(str5)) {
                str2 = "已下架";
            } else if (aVar.f(num2, num)) {
                str2 = "古籍";
            } else if (aVar.g(str)) {
                str2 = "断更";
            } else if (aVar.l(str)) {
                str2 = "完结";
            } else {
                str2 = "连载";
            }
        }
        R0(str2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void W(int i, ck4.a data, Context context) {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Intrinsics.checkNotNullParameter(data, "data");
        d1 d1Var = data.p;
        Z0(data).d();
        nc4.a aVar = nc4.a.a;
        String str11 = null;
        if (d1Var != null && (str10 = d1Var.X) != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str10);
        } else {
            num = null;
        }
        if (aVar.m(num)) {
            j0 j0Var = j0.a;
            if (d1Var == null || (str9 = d1Var.c) == null) {
                str4 = "";
            } else {
                str4 = str9;
            }
            if (d1Var == null || (str8 = d1Var.C) == null) {
                str5 = "";
            } else {
                str5 = str8;
            }
            if (d1Var == null || (str7 = d1Var.d) == null) {
                str6 = "";
            } else {
                str6 = str7;
            }
            j0.c(j0Var, str4, str5, str6, "click_book_history_item_play_duration", b1(data), null, null, 32, null);
            return;
        }
        ak4.l lVar = ak4.l.a;
        if (d1Var != null) {
            str = d1Var.c;
        } else {
            str = null;
        }
        if (d1Var != null) {
            str2 = d1Var.d;
        } else {
            str2 = null;
        }
        if (d1Var != null) {
            str3 = d1Var.C;
        } else {
            str3 = null;
        }
        if (d1Var != null) {
            str11 = d1Var.J;
        }
        lVar.e(str, str2, str3, str11, b1(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(d1 d1Var, i iVar, ck4.a aVar, Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        j0 j0Var = j0.a;
        if (d1Var != null) {
            str = d1Var.c;
        } else {
            str = null;
        }
        if (j0Var.a(str)) {
            j0Var.e();
            iVar.r.setValue(Boolean.FALSE);
        } else {
            if (d1Var == null || (str2 = d1Var.c) == null) {
                str2 = "";
            }
            String C0 = iVar.C0();
            if (d1Var == null || (str4 = d1Var.d) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            j0.c(j0Var, str2, C0, str3, "click_book_history_item_play_duration", iVar.b1(aVar), null, null, 32, null);
        }
        return Unit.INSTANCE;
    }

    @Override // bk4.e
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void A0(ck4.a data, int i, Composer composer, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(1618048414);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1618048414, i2, -1, "com.dragon.read.kmp.mine.search.holder.BookSearchHolder.bindHistoryContent (BookSearchHolder.kt:44)");
        }
        d1 d1Var = data.p;
        String str2 = null;
        if (d1Var != null) {
            str = d1Var.d;
        } else {
            str = null;
        }
        S0(str);
        int i3 = i2 & 14;
        int i4 = yh4.g.l;
        int i5 = (i2 >> 3) & 112;
        X0(data, composer, (i4 << 3) | i3 | i5);
        Y0(data, composer, i5 | i3 | (i4 << 3));
        if (d1Var != null) {
            str2 = d1Var.C;
        }
        P0(str2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // bk4.e
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void s0(androidx.compose.foundation.layout.r rVar, final ck4.a data, Composer composer, int i) {
        Integer num;
        String str;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(501636130);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(501636130, i, -1, "com.dragon.read.kmp.mine.search.holder.BookSearchHolder.ComposeInCover (BookSearchHolder.kt:88)");
        }
        final d1 d1Var = data.p;
        nc4.a aVar = nc4.a.a;
        if (d1Var != null && (str = d1Var.X) != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        } else {
            num = null;
        }
        if (aVar.m(num)) {
            Modifier.a aVar2 = Modifier.Companion;
            boolean z = true;
            Modifier f = SizeKt.f(aVar2, 0.0f, 1, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 i2 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(composer, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(composer, f);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a2);
            } else {
                composer.useNode();
            }
            Composer b = g5.b(composer);
            g5.e(b, i2, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            Modifier b3 = BoxScopeInstance.a.b(aVar2, aVar3.c());
            composer.startReplaceGroup(-1746271574);
            boolean changedInstance = composer.changedInstance(d1Var);
            if ((((i & 896) ^ 384) <= 256 || !composer.changedInstance(this)) && (i & 384) != 256) {
                z = false;
            }
            boolean changedInstance2 = changedInstance | z | composer.changedInstance(data);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: bk4.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit V0;
                        V0 = i.V0(d1Var, this, data, (Context) obj);
                        return V0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            com.dragon.read.kmp.widget.b.b(tc4.f.e(b3, false, (String) null, (Role) null, (Function1) rememberedValue, composer, 0, 7), new com.dragon.read.kmp.widget.c(C0(), x0.i.g(25), x0.i.g(16), x0.i.g(10), x0.i.g(13), ((Boolean) this.r.getValue()).booleanValue(), null), composer, com.dragon.read.kmp.widget.c.g << 3, 0);
            composer.endNode();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}

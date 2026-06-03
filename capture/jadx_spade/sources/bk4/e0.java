package bk4;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.rm0;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.basenovel.ui.widget.staggered.RecyclerHolder;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.k0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tb4.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e0 extends e<ck4.d> {
    public static final int t;
    private final MutableState r;
    private final MutableState s;

    static {
        Covode.recordClassIndex(607762);
        t = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(e0 e0Var, ck4.d dVar, int i, Composer composer, int i2) {
        e0Var.V0(dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(e0 e0Var, ck4.d dVar, int i, Composer composer, int i2) {
        e0Var.V0(dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private final boolean d1() {
        return ((Boolean) this.s.getValue()).booleanValue();
    }

    public void Z() {
        super.Z();
        ck4.d dVar = (ck4.d) ((RecyclerHolder) this).d;
        if (dVar == null) {
            return;
        }
        j1(dVar);
    }

    protected final String e1() {
        return (String) this.r.getValue();
    }

    private final void k1(boolean z) {
        this.s.setValue(Boolean.valueOf(z));
    }

    public void j1(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        m1(data).r();
    }

    protected final void l1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.r.setValue(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.r = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.s = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // bk4.e
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public int H0(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (d1()) {
            return w0.s.b.a();
        }
        return w0.s.b.b();
    }

    protected ld4.b m1(ck4.d data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        ld4.b I = new ld4.b().I(data.q);
        om0 om0Var = data.q;
        if (om0Var != null) {
            str = om0Var.A;
        } else {
            str = null;
        }
        return I.G(str).w(f1(data).i());
    }

    public ym4.k f1(ck4.d data) {
        boolean z;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z2 = true;
        ym4.k d = k0.a.b().g(hn4.c.a.a(data.g)).c("module_rank", Integer.valueOf(((RecyclerHolder) this).b + 1)).c("rank", Integer.valueOf(((RecyclerHolder) this).b + 1)).d("search_entrance", "mine_tab").d("cover_url", C0()).d("src_material_show_name", J0()).d("side_title", F0()).d("upper_right_info", E0(data));
        String D0 = D0(data);
        if (D0.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            D0 = null;
        }
        if (D0 != null) {
            d.d("lower_left_info", D0);
        }
        if (e1().length() <= 0) {
            z2 = false;
        }
        if (z2) {
            d.d("upper_info", StringUtilsKt.b(e1()));
        }
        if (d1()) {
            d.d("side_title", StringUtilsKt.b(F0()));
        }
        return d;
    }

    private final String c1(om0 om0Var, com.dragon.read.kmp.mine.data.b bVar) {
        String str;
        boolean z = false;
        if (om0Var != null) {
            Integer num = om0Var.y;
            int value = VideoContentType.PUGC.getValue();
            if (num != null && num.intValue() == value) {
                z = true;
            }
        }
        if (!z) {
            return "";
        }
        if (!tj4.a.c()) {
            return "短视频";
        }
        if (bVar != null) {
            str = bVar.l;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "pugc_preview_video")) {
            return "预告";
        }
        if (!Intrinsics.areEqual(str, "pugc_push_video")) {
            return "短视频";
        }
        return "高光";
    }

    protected void b1(om0 om0Var, com.dragon.read.kmp.mine.data.b bVar) {
        Integer num;
        String str;
        if (om0Var != null) {
            num = om0Var.y;
        } else {
            num = null;
        }
        int value = VideoContentType.TelePlay.getValue();
        if (num != null && num.intValue() == value) {
            str = "电视剧";
        } else {
            int value2 = VideoContentType.Movie.getValue();
            if (num != null && num.intValue() == value2) {
                str = "电影";
            } else {
                int value3 = VideoContentType.ShortSeriesPlay.getValue();
                if (num != null && num.intValue() == value3) {
                    str = "短剧";
                } else {
                    int value4 = VideoContentType.PUGC.getValue();
                    if (num != null && num.intValue() == value4) {
                        str = c1(om0Var, bVar);
                    } else {
                        int value5 = VideoContentType.Album.getValue();
                        if (num != null && num.intValue() == value5) {
                            str = "合集";
                        } else {
                            int value6 = VideoContentType.MotionComic.getValue();
                            if (num != null && num.intValue() == value6) {
                                str = "漫剧";
                            } else {
                                str = "";
                            }
                        }
                    }
                }
            }
        }
        R0(str);
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1756380068, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoSearchHolder.CommonInCover.<anonymous>.<anonymous> (VideoSearchHolder.kt:156)");
                }
                com.dragon.read.kmp.util.n nVar = com.dragon.read.kmp.util.n.a;
                String str = this.a;
                float g = x0.i.g(BoxWithConstraints.g() - x0.i.g(8));
                long h = x0.x.h(12);
                c0.a aVar = androidx.compose.ui.text.font.c0.b;
                a6.j(nVar.a(str, g, new g3(0L, h, aVar.i(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777209, (DefaultConstructorMarker) null), false, null, null, composer, (com.dragon.read.kmp.util.n.b << 18) | 384, 56), f2.t(BoxWithConstraints.b(Modifier.Companion, androidx.compose.ui.e.a.e()), x0.i.g(4), 0.0f, 2, (Object) null), og4.a.a.h(composer, og4.a.b).r(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.a(), false, 1, 0, (Function1) null, (g3) null, composer, 199680, 3120, 120784);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // 
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void W(int i, ck4.d data, Context context) {
        String str;
        int value;
        jm0 jm0Var;
        Long l;
        Intrinsics.checkNotNullParameter(data, "data");
        om0 om0Var = data.q;
        if (om0Var == null) {
            return;
        }
        ld4.b m1 = m1(data);
        m1.m();
        ym4.k g = k0.a.b().g(m1.b);
        tb4.l a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(tb4.l.class));
        if (a2 != null) {
            Integer num = om0Var.y;
            int value2 = VideoContentType.Album.getValue();
            String str2 = "";
            if (num != null && num.intValue() == value2 ? !((jm0Var = om0Var.R0) == null || (l = jm0Var.a) == null || (str = l.toString()) == null) : (str = om0Var.p) != null) {
                str2 = str;
            }
            Integer num2 = om0Var.y;
            if (num2 != null) {
                value = num2.intValue();
            } else {
                value = VideoContentType.ShortSeriesPlay.getValue();
            }
            l.a.a(a2, str2, (String) null, value, g, context, 2, (Object) null);
        }
    }

    public final void V0(final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        List listOf;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-1660830792);
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(this);
            } else {
                changedInstance = startRestartGroup.changedInstance(this);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1660830792, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoSearchHolder.CommonInCover (VideoSearchHolder.kt:138)");
            }
            String e1 = e1();
            if (e1.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: bk4.c0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit W0;
                            W0 = e0.W0(e0.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                            return W0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            Modifier i5 = SizeKt.i(SizeKt.h(BoxScopeInstance.a.b(aVar, aVar2.d()), 0.0f, 1, (Object) null), x0.i.g(32));
            c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
            l0.a aVar4 = androidx.compose.ui.graphics.l0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar4.g()), androidx.compose.ui.graphics.l0.j(aVar4.a())});
            float f2 = 12;
            androidx.compose.foundation.layout.u.c(BackgroundKt.b(i5, c0.a.p(aVar3, listOf, 0.0f, 0.0f, 0, 14, (Object) null), k.g.e(0.0f, 0.0f, x0.i.g(f2), x0.i.g(f2), 3, (Object) null), 0.0f, 4, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-1756380068, true, new a(e1), startRestartGroup, 54), startRestartGroup, 3072, 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: bk4.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit X0;
                    X0 = e0.X0(e0.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return X0;
                }
            });
        }
    }

    public void a1(ck4.d data, Composer composer, int i) {
        Integer num;
        boolean z;
        int i2;
        int i3;
        String d;
        rm0 rm0Var;
        Integer num2;
        String str;
        rm0 rm0Var2;
        cj0 cj0Var;
        ok0 ok0Var;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(-254671922);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-254671922, i, -1, "com.dragon.read.kmp.mine.search.holder.VideoSearchHolder.bindSubTitle (VideoSearchHolder.kt:175)");
        }
        com.dragon.read.kmp.mine.data.b bVar = data.n;
        String str3 = null;
        if (bVar != null) {
            num = Integer.valueOf(bVar.a);
        } else {
            om0 om0Var = data.q;
            if (om0Var != null) {
                num = om0Var.y;
            } else {
                num = null;
            }
        }
        int value = VideoContentType.PUGC.getValue();
        if (num != null && num.intValue() == value) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            if (bVar == null || (str2 = bVar.b) == null || (str = StringUtilsKt.takeIfNotEmpty(str2)) == null) {
                om0 om0Var2 = data.q;
                if (om0Var2 != null && (rm0Var2 = om0Var2.g0) != null && (cj0Var = rm0Var2.R) != null && (ok0Var = cj0Var.b) != null) {
                    str3 = ok0Var.b;
                }
                if (str3 == null) {
                    str = "";
                } else {
                    str = str3;
                }
            }
            sb.append(str);
            d = sb.toString();
        } else {
            om0 om0Var3 = data.q;
            if (om0Var3 != null && (rm0Var = om0Var3.g0) != null && (num2 = rm0Var.l) != null) {
                i2 = num2.intValue();
            } else if (bVar != null) {
                i2 = bVar.c;
            } else {
                i2 = 0;
            }
            int value2 = VideoContentType.Movie.getValue();
            if (num != null && num.intValue() == value2 && i2 <= 1 && bVar != null) {
                composer.startReplaceGroup(-2018339942);
                d = ak4.l.a.a(bVar, composer, 48);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2018197373);
                if (bVar != null) {
                    i3 = bVar.e;
                } else {
                    i3 = 0;
                }
                if (ak4.l.a.d(bVar)) {
                    composer.startReplaceGroup(-2018045597);
                    d = org.jetbrains.compose.resources.j.d(y6.w(x6.a), new Object[]{String.valueOf(i3), String.valueOf(i2)}, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-2017801875);
                    d = org.jetbrains.compose.resources.j.d(y6.v(x6.a), new Object[]{String.valueOf(i3)}, composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            }
        }
        Q0(d);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // bk4.e
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void s0(androidx.compose.foundation.layout.r rVar, ck4.d data, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(366770586);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(366770586, i, -1, "com.dragon.read.kmp.mine.search.holder.VideoSearchHolder.ComposeInCover (VideoSearchHolder.kt:133)");
        }
        int i2 = i >> 3;
        V0(data, composer, (i2 & 112) | (i2 & 14) | (yh4.g.l << 3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015a  */
    @Override // bk4.e
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0(ck4.d r10, int r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.e0.A0(ck4.d, int, androidx.compose.runtime.Composer, int):void");
    }

    @Override // bk4.e
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public String G0(ck4.d data, String rawSubTitle, float f, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawSubTitle, "rawSubTitle");
        composer.startReplaceGroup(-623452528);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-623452528, i, -1, "com.dragon.read.kmp.mine.search.holder.VideoSearchHolder.getSubTitleDisplayText (VideoSearchHolder.kt:119)");
        }
        if (!d1()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return rawSubTitle;
        }
        int i2 = i >> 3;
        String a2 = com.dragon.read.kmp.util.n.a.a(rawSubTitle, f, new g3(0L, x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777213, (DefaultConstructorMarker) null), false, null, null, composer, (i2 & 112) | (i2 & 14) | 384 | (com.dragon.read.kmp.util.n.b << 18), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return a2;
    }
}

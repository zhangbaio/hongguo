package bk4;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.z0;
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
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.e50;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.qn0;
import com.bytedance.kmp.reading.model.rm0;
import com.bytedance.kmp.reading.model.w40;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.widget.TagListViewKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 extends e0 {
    public static final a v;
    public static final int w;
    private final MutableState u;

    public static final class a {
        static {
            Covode.recordClassIndex(607761);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607760);
        v = new a(null);
        w = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(b0 b0Var, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        b0Var.y1(list, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(b0 b0Var, ck4.d dVar, int i, Composer composer, int i2) {
        b0Var.a1(dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(b0 b0Var, ck4.d dVar, String str, float f, int i, Composer composer, int i2) {
        b0Var.K0(dVar, str, f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(b0 b0Var, androidx.compose.foundation.layout.r rVar, ck4.d dVar, int i, Composer composer, int i2) {
        b0Var.s0(rVar, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(b0 b0Var, androidx.compose.foundation.layout.r rVar, ck4.d dVar, int i, Composer composer, int i2) {
        b0Var.v0(rVar, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(b0 b0Var, androidx.compose.foundation.layout.r rVar, ck4.d dVar, int i, Composer composer, int i2) {
        b0Var.v0(rVar, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(b0 b0Var, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        b0Var.y1(list, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private final qn0 H1() {
        return (qn0) this.u.getValue();
    }

    private final void Q1(qn0 qn0Var) {
        this.u.setValue(qn0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.u = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final ym4.k D1(ck4.d dVar) {
        return f1(dVar).d("detail_page_type", "preview").d("reserve_card_type", P1(dVar)).d("enter_from", "reserve_record");
    }

    private final void M1(ck4.d dVar) {
        ym4.a E1 = E1(dVar);
        ym4.o oVar = ym4.o.a;
        oVar.d("click_reserve_record", E1);
        oVar.d("click_search_mine_reserve_record", E1);
    }

    private final void N1(ck4.d dVar) {
        ym4.a E1 = E1(dVar);
        ym4.o oVar = ym4.o.a;
        oVar.d("show_reserve_record", E1);
        oVar.d("show_search_mine_reserve_record", E1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bk4.e
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public String D0(ck4.d data) {
        String str;
        e50 e50Var;
        Intrinsics.checkNotNullParameter(data, "data");
        om0 om0Var = data.q;
        if (om0Var != null && (e50Var = om0Var.N0) != null) {
            str = e50Var.a;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bk4.e
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public String E0(ck4.d data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        qn0 H1 = H1();
        if (H1 == null || (str = H1.a) == null) {
            return super.E0(data);
        }
        return str;
    }

    @Override // bk4.e0
    public void j1(ck4.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        N1(data);
        if (!I1(data)) {
            m1(data).r();
        }
    }

    private final boolean I1(ck4.d dVar) {
        Integer num;
        Integer[] numArr = {Integer.valueOf(VideoContentType.UnrealShortPlay.getValue()), Integer.valueOf(VideoContentType.UnrealMotionComic.getValue())};
        om0 om0Var = dVar.q;
        if (om0Var != null) {
            num = om0Var.y;
        } else {
            num = null;
        }
        return ArraysKt___ArraysKt.contains(numArr, num);
    }

    private final boolean J1(ck4.d dVar) {
        boolean z;
        boolean z2;
        String str;
        om0 om0Var = dVar.q;
        if (om0Var != null) {
            z = Intrinsics.areEqual(om0Var.P0, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        om0 om0Var2 = dVar.q;
        if (om0Var2 != null && (str = om0Var2.i) != null && (!StringsKt__StringsKt.isBlank(str))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        return true;
    }

    private final String P1(ck4.d dVar) {
        Integer num;
        om0 om0Var = dVar.q;
        if (om0Var != null) {
            num = om0Var.y;
        } else {
            num = null;
        }
        int value = VideoContentType.UnrealMotionComic.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = VideoContentType.MotionComic.getValue();
            if (num == null || num.intValue() != value2) {
                return "playlet";
            }
        }
        return "motion_comic";
    }

    private final ym4.a E1(ck4.d dVar) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        e50 e50Var;
        om0 om0Var = dVar.q;
        ym4.a h = new ym4.a().h(f1(dVar).i());
        String J0 = J0();
        if (J0.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        String str6 = null;
        String str7 = "";
        if (z) {
            if (om0Var != null) {
                J0 = om0Var.e;
            } else {
                J0 = null;
            }
            if (J0 == null) {
                J0 = "";
            }
        }
        ym4.a g = h.g("material_name", J0);
        if (om0Var != null) {
            str = om0Var.p;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        ym4.a g2 = g.g("virtual_src_material_id", str).g("upper_left_info", "");
        if (om0Var != null && (e50Var = om0Var.N0) != null) {
            str2 = e50Var.a;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        ym4.a g3 = g2.g("lower_left_info", str2).g("lower_right_info", "");
        hn4.d dVar2 = dVar.g;
        if (dVar2 != null) {
            str3 = dVar2.b;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        ym4.a g4 = g3.g("module_name", str3);
        hn4.d dVar3 = dVar.g;
        if (dVar3 != null) {
            str4 = dVar3.c;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        }
        ym4.a g5 = g4.g("sub_module_name", str4).g("detail_page_type", "preview").g("reserve_card_type", P1(dVar)).g("enter_from", "reserve_record");
        om0 om0Var2 = dVar.q;
        if (om0Var2 != null) {
            str5 = om0Var2.z;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str5 = "";
        }
        ym4.a g6 = g5.g("recommend_info", str5);
        om0 om0Var3 = dVar.q;
        if (om0Var3 != null) {
            str6 = om0Var3.A;
        }
        if (str6 == null) {
            str6 = "";
        }
        ym4.a g7 = g6.g("recommend_group_id", str6);
        String str8 = ((yh4.b) dVar).d.H;
        if (str8 != null) {
            str7 = str8;
        }
        ym4.a g8 = g7.g("search_attached_info", str7);
        g8.k("search_source_id");
        return g8;
    }

    @Override // bk4.e0
    public ym4.k f1(ck4.d data) {
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        String str5;
        Long l;
        Intrinsics.checkNotNullParameter(data, "data");
        ym4.k f1 = super.f1(data);
        om0 om0Var = data.q;
        Integer num = null;
        if (om0Var != null) {
            str = om0Var.p;
        } else {
            str = null;
        }
        String str6 = "";
        if (str == null) {
            str = "";
        }
        ym4.k d = f1.d("virtual_src_material_id", str).d("is_landing_page", "0");
        om0 om0Var2 = data.q;
        if (om0Var2 != null) {
            str2 = om0Var2.z;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        ym4.k d2 = d.d("recommend_info", str2);
        om0 om0Var3 = data.q;
        if (om0Var3 != null) {
            str3 = om0Var3.A;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        ym4.k d3 = d2.d("recommend_group_id", str3);
        String str7 = ((yh4.b) data).d.H;
        if (str7 == null) {
            str7 = "";
        }
        ym4.k d4 = d3.d("search_attached_info", str7).d("upper_right_info", E0(data)).d("lower_left_info", D0(data));
        String J0 = J0();
        int i = 0;
        if (J0.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            om0 om0Var4 = data.q;
            if (om0Var4 != null) {
                J0 = om0Var4.e;
            } else {
                J0 = null;
            }
            if (J0 == null) {
                J0 = "";
            }
        }
        ym4.k d5 = d4.d("material_name", J0);
        om0 om0Var5 = data.q;
        if (om0Var5 != null) {
            str4 = om0Var5.a;
        } else {
            str4 = null;
        }
        if (str4 != null) {
            str6 = str4;
        }
        ym4.k d6 = d5.d("material_id", str6);
        om0 om0Var6 = data.q;
        if (om0Var6 != null && (l = om0Var6.b0) != null) {
            i = (int) l.longValue();
        }
        ym4.k c = d6.c("material_rank", Integer.valueOf(i));
        ld4.a aVar = ld4.a.a;
        om0 om0Var7 = data.q;
        if (om0Var7 != null) {
            num = om0Var7.y;
        }
        ym4.k d7 = c.d("material_type", aVar.d(num));
        if (I1(data)) {
            str5 = "trailer";
        } else {
            str5 = "single";
        }
        return d7.d("feed_type", str5);
    }

    @Override // bk4.e0
    protected ld4.b m1(ck4.d data) {
        String str;
        String str2;
        Map mapOf;
        String str3;
        Intrinsics.checkNotNullParameter(data, "data");
        ld4.b m1 = super.m1(data);
        Pair[] pairArr = new Pair[7];
        om0 om0Var = data.q;
        Integer num = null;
        if (om0Var != null) {
            str = om0Var.z;
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        int i = 0;
        pairArr[0] = TuplesKt.to("recommend_info", str);
        om0 om0Var2 = data.q;
        if (om0Var2 != null) {
            str2 = om0Var2.A;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        boolean z = true;
        pairArr[1] = TuplesKt.to("recommend_group_id", str2);
        String str5 = ((yh4.b) data).d.H;
        if (str5 == null) {
            str5 = "";
        }
        pairArr[2] = TuplesKt.to("search_attached_info", str5);
        pairArr[3] = TuplesKt.to("is_landing_page", 0);
        com.dragon.read.kmp.mine.data.b bVar = data.n;
        if (bVar != null) {
            Integer valueOf = Integer.valueOf(bVar.k);
            if (valueOf.intValue() < 0) {
                z = false;
            }
            if (!z) {
                valueOf = null;
            }
            if (valueOf != null) {
                i = valueOf.intValue();
            }
        }
        pairArr[4] = TuplesKt.to("material_rank", Integer.valueOf(i));
        om0 om0Var3 = data.q;
        if (om0Var3 != null && (str3 = om0Var3.a) != null) {
            str4 = str3;
        }
        pairArr[5] = TuplesKt.to("material_id", str4);
        ld4.a aVar = ld4.a.a;
        om0 om0Var4 = data.q;
        if (om0Var4 != null) {
            num = om0Var4.y;
        }
        pairArr[6] = TuplesKt.to("material_type", aVar.d(num));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return m1.w(mapOf);
    }

    @Override // bk4.e0
    protected void b1(om0 om0Var, com.dragon.read.kmp.mine.data.b bVar) {
        qn0 qn0Var;
        String str = null;
        if (om0Var != null) {
            qn0Var = om0Var.y0;
        } else {
            qn0Var = null;
        }
        Q1(qn0Var);
        if (H1() != null) {
            qn0 H1 = H1();
            if (H1 != null) {
                str = H1.a;
            }
            R0(str);
            return;
        }
        super.b1(om0Var, bVar);
    }

    static final class b implements Function3<e90, Composer, Integer, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 info, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(818453560, i, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.ReservationSecondaryInfoTagLayout.<anonymous> (VideoReservationHolder.kt:158)");
            }
            a6.j(TagListViewKt.u(info), (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, new g3(b0.this.O1(info, composer, (i & 14) | (yh4.g.l << 3)), x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(12), (w0.q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null), composer, 0, 3120, 55294);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long O1(e90 e90Var, Composer composer, int i) {
        composer.startReplaceGroup(-1664683294);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1664683294, i, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.reservationSecondaryInfoTextColor (VideoReservationHolder.kt:187)");
        }
        og4.a aVar = og4.a.a;
        int i2 = og4.a.b;
        boolean d = d1.d(aVar.e(composer, i2));
        String str = null;
        w40 w40Var = e90Var.o;
        if (d) {
            if (w40Var != null) {
                str = w40Var.g;
            }
        } else if (w40Var != null) {
            str = w40Var.c;
        }
        long e = com.dragon.read.kmp.utils.j.e(str, aVar.h(composer, i2).h());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return e;
    }

    @Override // bk4.e0
    public void a1(final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        List list;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1069342534);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
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
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1069342534, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.bindSubTitle (VideoReservationHolder.kt:88)");
            }
            om0 om0Var = data.q;
            if (om0Var != null) {
                list = om0Var.t0;
            } else {
                list = null;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String u = TagListViewKt.u((e90) it2.next());
                if (!(!StringsKt__StringsKt.isBlank(u))) {
                    u = null;
                }
                if (u != null) {
                    arrayList.add(u);
                }
            }
            Q0(CollectionsKt___CollectionsKt.joinToString$default(arrayList, "·", null, null, 0, null, null, 62, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit C1;
                    C1 = b0.C1(b0.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return C1;
                }
            });
        }
    }

    @Override // bk4.e0
    /* renamed from: i1 */
    public void W(int i, ck4.d data, Context context) {
        String str;
        String str2;
        int value;
        List list;
        Object firstOrNull;
        String str3;
        jm0 jm0Var;
        Long l;
        Long l2;
        String str4;
        Intrinsics.checkNotNullParameter(data, "data");
        om0 om0Var = data.q;
        if (om0Var == null) {
            return;
        }
        M1(data);
        boolean z = true;
        String str5 = null;
        if (I1(data)) {
            String str6 = om0Var.i;
            if (str6 != null) {
                if (!StringsKt__StringsKt.isBlank(str6)) {
                    str4 = str6;
                } else {
                    str4 = null;
                }
                if (str4 != null) {
                    if (!J1(data)) {
                        zm4.d.d(zm4.d.a, str4, null, D1(data), 2, null);
                        return;
                    } else {
                        zm4.d.d(zm4.d.a, str4, null, k0.a.b().g(m1(data).b), 2, null);
                        return;
                    }
                }
                return;
            }
            return;
        }
        ld4.b m1 = m1(data);
        m1.m();
        ym4.k g = k0.a.b().g(m1.b);
        rm0 rm0Var = om0Var.g0;
        if (rm0Var != null && (l2 = rm0Var.d0) != null) {
            str = l2.toString();
        } else {
            str = null;
        }
        if (str == null) {
            Integer num = om0Var.y;
            int value2 = VideoContentType.Album.getValue();
            str2 = "";
            if (num != null && num.intValue() == value2 ? !((jm0Var = om0Var.R0) == null || (l = jm0Var.a) == null || (str3 = l.toString()) == null) : (str3 = om0Var.p) != null) {
                str2 = str3;
            }
        } else {
            str2 = str;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            Integer num2 = om0Var.y;
            if (num2 != null) {
                value = num2.intValue();
            } else {
                value = VideoContentType.ShortSeriesPlay.getValue();
            }
        } else {
            value = VideoContentType.Album.getValue();
        }
        int i2 = value;
        tb4.l a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(tb4.l.class));
        if (a2 != null) {
            rm0 rm0Var2 = om0Var.g0;
            if (rm0Var2 != null && (list = rm0Var2.i) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                om0 om0Var2 = (om0) firstOrNull;
                if (om0Var2 != null) {
                    str5 = om0Var2.a;
                }
            }
            a2.N1(str2, str5, i2, g, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bk4.e
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void v0(final androidx.compose.foundation.layout.r rVar, final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-488832967);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
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
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-488832967, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.RenderCoverTag (VideoReservationHolder.kt:118)");
            }
            qn0 H1 = H1();
            startRestartGroup.startReplaceGroup(-1617041673);
            if (H1 == null) {
                p0(rVar, data, startRestartGroup, (i2 & 14) | (i2 & 112) | (yh4.g.l << 6) | (i2 & 896));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: bk4.y
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit w1;
                            w1 = b0.w1(b0.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                            return w1;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            Integer num = H1.l;
            e.a aVar2 = androidx.compose.ui.e.a;
            Modifier p = f2.p(rVar.b(aVar, xc4.m.l(num, aVar2.n())), f2.f(x0.i.g(6)));
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, p);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            xc4.j jVar = new xc4.j(5, 3, 12, x0.x.h(10), androidx.compose.ui.text.font.c0.b.i(), 18, new xc4.n(x0.i.d(x0.i.g(4)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
            l0.a aVar3 = androidx.compose.ui.graphics.l0.b;
            composer2 = startRestartGroup;
            xc4.m.i(jVar, H1, aVar3.i(), aVar3.i(), 0L, startRestartGroup, 3456, 16);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: bk4.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x1;
                    x1 = b0.x1(b0.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return x1;
                }
            });
        }
    }

    @Override // bk4.e0, bk4.e
    /* renamed from: Y0 */
    public void s0(final androidx.compose.foundation.layout.r rVar, final ck4.d data, Composer composer, final int i) {
        int i2;
        boolean z;
        e50 e50Var;
        String str;
        boolean z2;
        Modifier modifier;
        int i3;
        List listOf;
        boolean changedInstance;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1278707218);
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 = i5 | i;
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
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i2 & 145) != 144) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1278707218, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.ComposeInCover (VideoReservationHolder.kt:194)");
            }
            om0 om0Var = data.q;
            if (om0Var != null) {
                e50Var = om0Var.N0;
            } else {
                e50Var = null;
            }
            Modifier modifier2 = Modifier.Companion;
            Modifier f = SizeKt.f(modifier2, 0.0f, 1, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (e50Var != null) {
                str = e50Var.a;
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsKt.isBlank(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                startRestartGroup.startReplaceGroup(-735017373);
                Modifier i7 = SizeKt.i(SizeKt.h(boxScopeInstance.b(modifier2, aVar.d()), 0.0f, 1, (Object) null), x0.i.g(30));
                c0.a aVar2 = androidx.compose.ui.graphics.c0.b;
                l0.a aVar3 = androidx.compose.ui.graphics.l0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar3.g()), androidx.compose.ui.graphics.l0.j(aVar3.a())});
                float f2 = 8;
                Modifier t = f2.t(BackgroundKt.b(i7, c0.a.p(aVar2, listOf, 0.0f, 0.0f, 0, 14, (Object) null), k.g.e(0.0f, 0.0f, x0.i.g(f2), x0.i.g(f2), 3, (Object) null), 0.0f, 4, (Object) null), x0.i.g(6), 0.0f, 2, (Object) null);
                p0 i8 = androidx.compose.foundation.layout.m.i(aVar.h(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, i8, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e2, companion.d());
                e50 e50Var2 = e50Var;
                modifier = modifier2;
                i3 = 0;
                xc4.c.c(modifier2, e50Var2, x0.x.h(11), aVar3.i(), startRestartGroup, 3462, 0);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            } else {
                modifier = modifier2;
                i3 = 0;
                startRestartGroup.startReplaceGroup(-734098905);
                int i9 = i2 >> 3;
                V0(data, startRestartGroup, (i9 & 112) | (i9 & 14) | (yh4.g.l << 3));
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.startReplaceGroup(946153974);
            if (!I1(data) || J1(data)) {
                z0.c(org.jetbrains.compose.resources.c.b(d2.J(f2.a.a), startRestartGroup, i3), (String) null, SizeKt.s(boxScopeInstance.b(modifier, aVar.e()), x0.i.g(32)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, startRestartGroup, 48, 120);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u1;
                    u1 = b0.u1(b0.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u1;
                }
            });
        }
    }

    @Override // bk4.e
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void K0(final ck4.d data, final String rawSubTitle, final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        List<e90> list;
        List<e90> list2;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawSubTitle, "rawSubTitle");
        Composer startRestartGroup = composer.startRestartGroup(2019875688);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 3072) == 0) {
            if ((i & 4096) == 0) {
                changedInstance = startRestartGroup.changed(this);
            } else {
                changedInstance = startRestartGroup.changedInstance(this);
            }
            if (changedInstance) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1027) != 1026) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2019875688, i2, -1, "com.dragon.read.kmp.mine.search.holder.VideoReservationHolder.renderSubTitle (VideoReservationHolder.kt:106)");
            }
            om0 om0Var = data.q;
            if (om0Var != null && (list2 = om0Var.t0) != null && (!list2.isEmpty())) {
                list = list2;
            } else {
                list = null;
            }
            if (list != null) {
                y1(list, androidx.compose.foundation.layout.f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, x0.i.g(6), 0.0f, 0.0f, 13, (Object) null), startRestartGroup, (yh4.g.l << 6) | 48 | ((i2 >> 3) & 896), 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L1;
                    L1 = b0.L1(b0.this, data, rawSubTitle, f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return L1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y1(final java.util.List<com.bytedance.kmp.reading.model.e90> r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.b0.y1(java.util.List, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}

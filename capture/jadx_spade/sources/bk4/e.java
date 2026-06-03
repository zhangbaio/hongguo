package bk4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.ss.ttm.player.MediaPlayer;
import gn4.c;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class e<T extends gn4.c> extends yh4.g<T> {
    public static final int q;
    private final MutableState m;
    private final MutableState n;
    private final MutableState o;
    private final MutableState p;

    static {
        Covode.recordClassIndex(607751);
        q = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(e eVar, androidx.compose.foundation.layout.r rVar, gn4.c cVar, int i, Composer composer, int i2) {
        eVar.p0(rVar, cVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(e eVar, androidx.compose.foundation.layout.r rVar, gn4.c cVar, int i, Composer composer, int i2) {
        eVar.p0(rVar, cVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(e eVar, gn4.c cVar, int i, Composer composer, int i2) {
        eVar.t0(cVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public void A0(T data, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(-407847302);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-407847302, i2, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.bindHistoryContent (BaseMineSearchHolder.kt:75)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    protected String D0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return "";
    }

    public String G0(T data, String rawSubTitle, float f, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawSubTitle, "rawSubTitle");
        composer.startReplaceGroup(-1071246044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1071246044, i, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.getSubTitleDisplayText (BaseMineSearchHolder.kt:132)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rawSubTitle;
    }

    public abstract void s0(androidx.compose.foundation.layout.r rVar, T t, Composer composer, int i);

    public boolean w0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return true;
    }

    public boolean x0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return true;
    }

    public final String C0() {
        return (String) this.p.getValue();
    }

    public final String F0() {
        return (String) this.n.getValue();
    }

    public final String I0() {
        return (String) this.o.getValue();
    }

    public final String J0() {
        return (String) this.m.getValue();
    }

    protected final void P0(String str) {
        if (str == null) {
            str = "";
        }
        L0(str);
    }

    protected final void Q0(String str) {
        if (str == null) {
            str = "";
        }
        M0(str);
    }

    protected final void R0(String str) {
        if (str == null) {
            str = "";
        }
        N0(str);
    }

    protected final void S0(String str) {
        if (str == null) {
            str = "";
        }
        O0(str);
    }

    public i2 B0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return f2.f(x0.i.g(0));
    }

    protected String E0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return I0();
    }

    public int H0(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return w0.s.b.b();
    }

    public final void L0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.p.setValue(str);
    }

    public final void M0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n.setValue(str);
    }

    public final void N0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.o.setValue(str);
    }

    public final void O0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m.setValue(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.m = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.n = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.o = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.p = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(gn4.c cVar, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        Integer num;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        qf3.a aVar = qf3.a.g;
        hn4.d dVar = cVar.g;
        if (dVar != null) {
            num = Integer.valueOf(dVar.a);
        } else {
            num = null;
        }
        aVar.c(num);
        drawWithContent.E1();
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ e<T> a;
        final /* synthetic */ T b;

        a(e<T> eVar, T t) {
            this.a = eVar;
            this.b = t;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            boolean z2 = false;
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-550956002, i, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.ContentInfo.<anonymous>.<anonymous> (BaseMineSearchHolder.kt:237)");
                }
                String F0 = this.a.F0();
                if (F0.length() > 0) {
                    z2 = true;
                }
                if (!z2) {
                    F0 = null;
                }
                if (F0 == null) {
                    F0 = " ";
                }
                this.a.K0(this.b, F0, BoxWithConstraints.g(), composer, yh4.g.l << 9);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private final void t0(final T t, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        List list;
        int i3;
        boolean z3;
        Composer composer3;
        List list2;
        boolean changedInstance;
        int i4;
        boolean changedInstance2;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1091165056);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance2 = startRestartGroup.changed(t);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(t);
            }
            if (changedInstance2) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
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
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        int i6 = i2;
        if ((i6 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091165056, i6, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.ContentInfo (BaseMineSearchHolder.kt:199)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            e.m i7 = androidx.compose.foundation.layout.e.a.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 a2 = androidx.compose.foundation.layout.x.a(i7, aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            Modifier b3 = AspectRatioKt.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.71428573f, false, 2, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, i8, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(178901663);
            if (C0().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                list = null;
                i3 = i6;
                LoadImageKt.g(C0(), (String) null, (com.dragon.read.kmp.compose.common.image.n) null, androidx.compose.ui.draw.e.a(SizeKt.f(f2.p(aVar, B0(t)), 0.0f, 1, (Object) null), k.g.c(x0.i.g(12))), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 118);
            } else {
                list = null;
                i3 = i6;
            }
            startRestartGroup.endReplaceGroup();
            int i9 = i3 << 3;
            int i10 = (i9 & 112) | 6;
            int i11 = yh4.g.l;
            int i12 = i9 & 896;
            v0(boxScopeInstance, t, startRestartGroup, (i11 << 6) | i10 | i12);
            s0(boxScopeInstance, t, startRestartGroup, i12 | i10 | (i11 << 6));
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-667621087);
            if (J0().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                String J0 = J0();
                com.dragon.read.kmp.base.e eVar = t.i;
                if (eVar != null) {
                    list2 = eVar.c;
                } else {
                    list2 = list;
                }
                og4.a aVar3 = og4.a.a;
                int i13 = og4.a.b;
                composer3 = startRestartGroup;
                a6.k(com.dragon.read.kmp.base.f.a(J0, list2, true, aVar3.h(startRestartGroup, i13).f(), startRestartGroup, 384, 0), f2.v(aVar, 0.0f, x0.i.g(8), 0.0f, 0.0f, 13, (Object) null), aVar3.h(startRestartGroup, i13).T2(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Map) null, (Function1) null, (g3) null, composer3, 199728, 3120, 251856);
            } else {
                composer3 = startRestartGroup;
            }
            composer3.endReplaceGroup();
            composer2 = composer3;
            composer2.startReplaceGroup(-667598566);
            if (w0(t)) {
                androidx.compose.foundation.layout.u.c((Modifier) null, (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-550956002, true, new a(this, t), composer2, 54), composer2, 3072, 7);
            }
            composer2.endReplaceGroup();
            float g = x0.i.g(16);
            composer2.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g), composer2, 0);
            composer2.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: bk4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u0;
                    u0 = e.u0(e.this, t, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u0;
                }
            });
        }
    }

    protected void v0(androidx.compose.foundation.layout.r rVar, T data, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(-1777819529);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1777819529, i, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.RenderCoverTag (BaseMineSearchHolder.kt:124)");
        }
        p0(rVar, data, composer, (i & 896) | (i & 14) | (i & 112) | (yh4.g.l << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void H(final T data, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        composer.startReplaceGroup(-1925722568);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1925722568, i2, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.bindContent (BaseMineSearchHolder.kt:57)");
        }
        boolean z = true;
        Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
        composer.startReplaceGroup(5004770);
        int i3 = i2 & 14;
        if (((i3 ^ 6) <= 4 || !composer.changedInstance(data)) && (i2 & 6) != 4) {
            z = false;
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: bk4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z0;
                    z0 = e.z0(gn4.c.this, (androidx.compose.ui.graphics.drawscope.c) obj);
                    return z0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier d = androidx.compose.ui.draw.i.d(h, (Function1) rememberedValue);
        p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
        int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
        androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier e = ComposedModifierKt.e(composer, d);
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
        g5.e(b, i4, companion.c());
        g5.e(b, currentCompositionLocalMap, companion.e());
        Function2 b2 = companion.b();
        if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
            b.updateRememberedValue(Integer.valueOf(a2));
            b.apply(Integer.valueOf(a2), b2);
        }
        g5.e(b, e, companion.d());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
        int i5 = yh4.g.l;
        A0(data, i, composer, (i2 & 112) | i3 | (i5 << 6) | (i2 & 896));
        t0(data, composer, (i5 << 3) | i3 | ((i2 >> 3) & 112));
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    protected final void p0(final androidx.compose.foundation.layout.r rVar, final T data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean changedInstance;
        int i3;
        boolean changedInstance2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-1605353076);
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
            if ((i & 64) == 0) {
                changedInstance2 = startRestartGroup.changed(data);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(data);
            }
            if (changedInstance2) {
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
        boolean z2 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1605353076, i2, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.CommonCoverTag (BaseMineSearchHolder.kt:172)");
            }
            if (x0(data)) {
                if (I0().length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    float f = 6;
                    Modifier v = f2.v(Modifier.Companion, 0.0f, x0.i.g(f), x0.i.g(f), 0.0f, 9, (Object) null);
                    og4.a aVar = og4.a.a;
                    int i6 = og4.a.b;
                    float f2 = 4;
                    Modifier s = f2.s(BackgroundKt.c(v, aVar.h(startRestartGroup, i6).A(), k.g.c(x0.i.g(f2))), x0.i.g(f2), x0.i.g(2));
                    e.a aVar2 = androidx.compose.ui.e.a;
                    Modifier b = rVar.b(s, aVar2.n());
                    p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(startRestartGroup, b);
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
                    g5.e(b2, i7, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                        b2.updateRememberedValue(Integer.valueOf(a2));
                        b2.apply(Integer.valueOf(a2), b3);
                    }
                    g5.e(b2, e, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    composer2 = startRestartGroup;
                    a6.j(I0(), (Modifier) null, aVar.h(startRestartGroup, i6).r(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3120, 120786);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            t3 endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.a(new Function2() { // from class: bk4.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit q0;
                        q0 = e.q0(e.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                        return q0;
                    }
                });
                return;
            }
            return;
        }
        composer2 = startRestartGroup;
        composer2.skipToGroupEnd();
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: bk4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r0;
                    r0 = e.r0(e.this, rVar, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r0;
                }
            });
        }
    }

    public void K0(T data, String rawSubTitle, float f, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawSubTitle, "rawSubTitle");
        composer.startReplaceGroup(308237438);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308237438, i, -1, "com.dragon.read.kmp.mine.search.holder.BaseMineSearchHolder.renderSubTitle (BaseMineSearchHolder.kt:140)");
        }
        a6.j(G0(data, rawSubTitle, f, composer, (i & 14) | (i & 112) | (i & 896) | (yh4.g.l << 9) | (i & 7168)), f2.v(Modifier.Companion, 0.0f, x0.i.g(4), 0.0f, 0.0f, 13, (Object) null), og4.a.a.h(composer, og4.a.b).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, H0(data), false, 1, 0, (Function1) null, (g3) null, composer, 3120, 3072, 120816);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}

package uj4;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.kmp.compose.common.image.LoadImage_androidKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.service.g1;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pg4.p;
import ym4.o;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    private static String a;
    private static String b;
    private static String c;
    private static String d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        z(str, str2, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, String str2, String str3, String str4, Function0 function0, int i, Composer composer, int i2) {
        l(str, str2, str3, str4, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z, String str, int i, int i2, Composer composer, int i3) {
        n(z, str, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        q(z, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(boolean z, List list, Function1 function1, int i, int i2, Composer composer, int i3) {
        u(z, list, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void C() {
        KmpDialogServiceKt.h(d);
    }

    public static final void D() {
        KmpDialogServiceKt.h(b);
    }

    public static final void E() {
        KmpDialogServiceKt.h(c);
    }

    public static final void F() {
        KmpDialogServiceKt.h(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o() {
        D();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        E();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w() {
        F();
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(607683);
        a = "select_phone_code_dialog_v707";
        b = "can_not_received_code_dialog_v707";
        c = "old_phone_unavailable_dialog_v707";
        d = "douyin_bind_dialog_v703";
    }

    public static final void G(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        b = str;
    }

    public static final void H(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        c = str;
    }

    public static final void I(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Function0<Unit> e;

        a(String str, String str2, String str3, String str4, Function0<Unit> function0) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            String str;
            boolean z2;
            Modifier modifier;
            og4.a aVar;
            int i2;
            boolean z3;
            Composer composer2;
            Modifier modifier2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1416895424, i, -1, "com.dragon.read.kmp.mine.dialog.KmpBindDialogPanel.<anonymous> (KmpBindingDialog.kt:269)");
                }
                og4.a aVar2 = og4.a.a;
                int i3 = og4.a.b;
                boolean d = d1.d(aVar2.e(composer, i3));
                composer.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                Object obj = rememberedValue;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    n nVar = new n();
                    nVar.a(com.bytedance.kmp.image.options.l.b.e());
                    composer.updateRememberedValue(nVar);
                    obj = nVar;
                }
                n nVar2 = (n) obj;
                composer.endReplaceGroup();
                Modifier modifier3 = Modifier.Companion;
                float f = 16;
                Modifier d2 = BackgroundKt.d(SizeKt.B(androidx.compose.ui.draw.e.a(modifier3, k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null)), (e.c) null, false, 3, (Object) null), aVar2.h(composer, i3).D(), (f2) null, 2, (Object) null);
                String str2 = this.a;
                String str3 = this.b;
                String str4 = this.c;
                String str5 = this.d;
                Function0<Unit> function0 = this.e;
                e.m i4 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 a = x.a(i4, aVar3.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, d2);
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
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                c0 c0Var = c0.b;
                if (d) {
                    str = "img_719_bind_douyin_pannel_header_dark.png";
                } else {
                    str = "img_719_bind_douyin_pannel_header.png";
                }
                LoadImage_androidKt.j(str, "bind_top_background", (androidx.compose.ui.e) null, nVar2, AspectRatioKt.b(SizeKt.h(modifier3, 0.0f, 1, (Object) null), 2.0526316f, false, 2, (Object) null), composer, 27696, 4);
                float g = x0.i.g(f);
                composer.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(modifier3, g), composer, 0);
                composer.endReplaceGroup();
                long k = aVar2.h(composer, i3).k();
                long h = x0.x.h(16);
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                float f2 = (float) 23.5d;
                a6.j("绑定抖音账号", androidx.compose.foundation.layout.f2.t(SizeKt.h(modifier3, 0.0f, 1, (Object) null), x0.i.g(f2), 0.0f, 2, (Object) null), k, h, (y) null, aVar4.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199734, 0, 130512);
                composer.startReplaceGroup(-1811194831);
                if (str2.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    float g2 = x0.i.g(12);
                    composer.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(modifier3, g2), composer, 0);
                    composer.endReplaceGroup();
                    i2 = i3;
                    aVar = aVar2;
                    modifier = modifier3;
                    a6.j(str2, androidx.compose.foundation.layout.f2.t(c0Var.b(modifier3, aVar3.g()), x0.i.g(f2), 0.0f, 2, (Object) null), aVar2.h(composer, i3).h(), x0.x.h(14), (y) null, aVar4.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131024);
                } else {
                    modifier = modifier3;
                    aVar = aVar2;
                    i2 = i3;
                }
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1811180873);
                if (str3.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    float g3 = x0.i.g(12);
                    composer.startReplaceGroup(-1814856593);
                    Modifier modifier4 = modifier;
                    a3.a(SizeKt.i(modifier4, g3), composer, 0);
                    composer.endReplaceGroup();
                    modifier2 = modifier4;
                    composer2 = composer;
                    a6.j(str3, androidx.compose.foundation.layout.f2.t(c0Var.b(modifier4, aVar3.g()), x0.i.g(f2), 0.0f, 2, (Object) null), aVar.h(composer, i2).h(), x0.x.h(14), (y) null, aVar4.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131024);
                } else {
                    composer2 = composer;
                    modifier2 = modifier;
                }
                composer.endReplaceGroup();
                float g4 = x0.i.g(f);
                composer2.startReplaceGroup(-1814856593);
                Modifier modifier5 = modifier2;
                a3.a(SizeKt.i(modifier5, g4), composer2, 0);
                composer.endReplaceGroup();
                l.z(str4, str5, function0, composer2, 0);
                float g5 = x0.i.g(20);
                composer2.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(modifier5, g5), composer2, 0);
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, com.dragon.read.kmp.mine.model.h it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        function1.invoke(it2);
        F();
        return Unit.INSTANCE;
    }

    static final class b implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Function0<Unit> e;

        b(String str, String str2, String str3, String str4, Function0<Unit> function0) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            a(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(com.dragon.read.kmp.service.g it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1303799576, i, -1, "com.dragon.read.kmp.mine.dialog.showBindDialog.<anonymous> (KmpBindingDialog.kt:349)");
                }
                l.l(this.a, this.b, this.c, this.d, this.e, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function0 function0, String str, Context context) {
        function0.invoke();
        o.a.d("popup_click", new ym4.a((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("popup_type", "douyin_login_verify"), TuplesKt.to("position", str), TuplesKt.to("clicked_content", "agree")}));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(final String str, final String str2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        List listOf;
        e1 a2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(892569255);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892569255, i6, -1, "com.dragon.read.kmp.mine.dialog.buildBindingButton (KmpBindingDialog.kt:359)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i6 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i6 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: uj4.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit A;
                        A = l.A(Function0.this, str, (Context) obj);
                        return A;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier e = tc4.f.e(h, false, (String) null, (Role) null, (Function1) rememberedValue, startRestartGroup, 6, 7);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.f d2 = eVar.d();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 b2 = r2.b(d2, aVar2.l(), startRestartGroup, 6);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, e);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e2, companion.d());
            w2 w2Var = w2.b;
            e.c i7 = aVar2.i();
            e.f d3 = eVar.d();
            Modifier a5 = androidx.compose.ui.draw.e.a(aVar, k.g.c(x0.i.g(12)));
            c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
            og4.a aVar4 = og4.a.a;
            int i8 = og4.a.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(aVar4.h(startRestartGroup, i8).a()), l0.j(aVar4.h(startRestartGroup, i8).e())});
            Modifier F = SizeKt.F(SizeKt.B(androidx.compose.foundation.layout.f2.s(BackgroundKt.b(a5, c0.a.d(aVar3, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null), x0.i.g(57), x0.i.g(11)), (e.c) null, false, 3, (Object) null), (e.b) null, false, 3, (Object) null);
            p0 b5 = r2.b(d3, i7, startRestartGroup, 54);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, F);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, b5, companion.c());
            g5.e(b6, currentCompositionLocalMap2, companion.e());
            Function2 b7 = companion.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a6))) {
                b6.updateRememberedValue(Integer.valueOf(a6));
                b6.apply(Integer.valueOf(a6), b7);
            }
            g5.e(b6, e3, companion.d());
            if (d1.d(aVar4.e(startRestartGroup, i8))) {
                startRestartGroup.startReplaceGroup(1175166050);
                a2 = org.jetbrains.compose.resources.c.a(o1.r(w6.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1175169539);
                a2 = org.jetbrains.compose.resources.c.a(o1.s(w6.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            z0.g(a2, "douyin_icon", SizeKt.s(aVar, x0.i.g(20)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar4.h(startRestartGroup, i8).r()), 0, startRestartGroup, 432, 184);
            float g = x0.i.g(4);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(str2, (Modifier) null, aVar4.h(startRestartGroup, i8).r(), x0.x.h(16), (y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, ((i6 >> 3) & 14) | 199680, 0, 130514);
            composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: uj4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit B;
                    B = l.B(str, str2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return B;
                }
            });
        }
    }

    public static final void n(boolean z, final String firstLineText, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        int i4;
        int i5;
        boolean z3;
        Composer composer2;
        boolean z4;
        float f;
        e1 a2;
        Intrinsics.checkNotNullParameter(firstLineText, "firstLineText");
        Composer startRestartGroup = composer.startRestartGroup(-978594619);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            if (startRestartGroup.changed(z2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(firstLineText)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i7 = i3;
        if ((i7 & 19) != 18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (startRestartGroup.shouldExecute(z3, i7 & 1)) {
            if (i6 != 0) {
                z4 = true;
            } else {
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-978594619, i7, -1, "com.dragon.read.kmp.mine.dialog.KmpCanNotReceivedDialogPanel (KmpBindingDialog.kt:83)");
            }
            if (z4) {
                f = 16;
            } else {
                f = 12;
            }
            float g = x0.i.g(f);
            Modifier.a aVar = Modifier.Companion;
            Modifier k = SizeKt.k(androidx.compose.ui.draw.e.a(aVar, k.g.e(g, g, 0.0f, 0.0f, 12, (Object) null)), x0.i.g(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES), 0.0f, 2, (Object) null);
            og4.a aVar2 = og4.a.a;
            int i8 = og4.a.b;
            Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(k, aVar2.h(startRestartGroup, i8).D(), (f2) null, 2, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i9 = eVar.i();
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 a3 = x.a(i9, aVar3.k(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a3, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier h = SizeKt.h(SizeKt.i(aVar, x0.i.g(56)), 0.0f, 1, (Object) null);
            p0 b4 = r2.b(eVar.h(), aVar3.i(), startRestartGroup, 54);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                b5.updateRememberedValue(Integer.valueOf(a6));
                b5.apply(Integer.valueOf(a6), b6);
            }
            g5.e(b5, e2, companion.d());
            w2 w2Var = w2.b;
            if (z4) {
                startRestartGroup.startReplaceGroup(-51368479);
                a2 = org.jetbrains.compose.resources.c.a(o1.q(w6.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-51365028);
                a2 = org.jetbrains.compose.resources.c.a(d2.G(f2.a.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            e1 e1Var = a2;
            float f2 = 24;
            Modifier s = SizeKt.s(aVar, x0.i.g(f2));
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: uj4.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit o;
                        o = l.o();
                        return o;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(e1Var, "close", com.dragon.read.kmp.utils.g.e(s, false, 0L, null, null, (Function0) rememberedValue, startRestartGroup, 196614, 15), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar2.h(startRestartGroup, i8).k()), 0, startRestartGroup, 48, 184);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            long k2 = aVar2.h(startRestartGroup, i8).k();
            long h2 = x0.x.h(16);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            a6.j("收不到验证码？", (Modifier) null, k2, h2, (y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            float g2 = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            float g3 = x0.i.g(12);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g3), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            a6.j(firstLineText, (Modifier) null, aVar2.h(startRestartGroup, i8).h(), x0.x.h(14), (y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, ((i7 >> 3) & 14) | 199680, 0, 131026);
            p0 b7 = r2.b(eVar.h(), aVar3.l(), startRestartGroup, 0);
            int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar);
            Function0 a9 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a9);
            } else {
                startRestartGroup.useNode();
            }
            Composer b8 = g5.b(startRestartGroup);
            g5.e(b8, b7, companion.c());
            g5.e(b8, currentCompositionLocalMap3, companion.e());
            Function2 b9 = companion.b();
            if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a8))) {
                b8.updateRememberedValue(Integer.valueOf(a8));
                b8.apply(Integer.valueOf(a8), b9);
            }
            g5.e(b8, e3, companion.d());
            composer2 = startRestartGroup;
            a6.j("2.检查短信是否被安全软件拦截", (Modifier) null, aVar2.h(startRestartGroup, i8).h(), x0.x.h(14), (y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131026);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z4;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: uj4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = l.p(z2, firstLineText, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }

    public static final void q(boolean z, Function0<Unit> openFeedbackPage, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        int i4;
        int i5;
        boolean z3;
        final Function0<Unit> function0;
        Composer composer2;
        boolean z4;
        float f;
        e1 a2;
        boolean z5;
        Intrinsics.checkNotNullParameter(openFeedbackPage, "openFeedbackPage");
        Composer startRestartGroup = composer.startRestartGroup(892806781);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            if (startRestartGroup.changed(z2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(openFeedbackPage)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i7 = i3;
        if ((i7 & 19) != 18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (startRestartGroup.shouldExecute(z3, i7 & 1)) {
            if (i6 != 0) {
                z4 = true;
            } else {
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892806781, i7, -1, "com.dragon.read.kmp.mine.dialog.KmpOldPhoneUnavailableDialog (KmpBindingDialog.kt:198)");
            }
            if (z4) {
                f = 16;
            } else {
                f = 12;
            }
            float g = x0.i.g(f);
            Modifier.a aVar = Modifier.Companion;
            Modifier k = SizeKt.k(androidx.compose.ui.draw.e.a(aVar, k.g.e(g, g, 0.0f, 0.0f, 12, (Object) null)), x0.i.g(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES), 0.0f, 2, (Object) null);
            og4.a aVar2 = og4.a.a;
            int i8 = og4.a.b;
            Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(k, aVar2.h(startRestartGroup, i8).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i9 = eVar.i();
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 a3 = x.a(i9, aVar3.k(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a3, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier h = SizeKt.h(SizeKt.i(aVar, x0.i.g(56)), 0.0f, 1, (Object) null);
            p0 b4 = r2.b(eVar.h(), aVar3.i(), startRestartGroup, 54);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                b5.updateRememberedValue(Integer.valueOf(a6));
                b5.apply(Integer.valueOf(a6), b6);
            }
            g5.e(b5, e2, companion.d());
            w2 w2Var = w2.b;
            if (z4) {
                startRestartGroup.startReplaceGroup(1345201317);
                a2 = org.jetbrains.compose.resources.c.a(o1.q(w6.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1345204768);
                a2 = org.jetbrains.compose.resources.c.a(d2.G(f2.a.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            e1 e1Var = a2;
            float f2 = 24;
            Modifier s = SizeKt.s(aVar, x0.i.g(f2));
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.Companion;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = new Function0() { // from class: uj4.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit r;
                        r = l.r();
                        return r;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(e1Var, "close", com.dragon.read.kmp.utils.g.e(s, false, 0L, null, null, (Function0) rememberedValue, startRestartGroup, 196614, 15), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar2.h(startRestartGroup, i8).k()), 0, startRestartGroup, 48, 184);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            long k2 = aVar2.h(startRestartGroup, i8).k();
            long h2 = x0.x.h(16);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            a6.j("手机号不能正常使用", (Modifier) null, k2, h2, (y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            float g2 = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            float g3 = x0.i.g(12);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g3), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            a6.j("1.如果手机卡丢失，请携带办卡时的身份证去营业厅处理", (Modifier) null, aVar2.h(startRestartGroup, i8).h(), x0.x.h(14), (y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
            p0 b7 = r2.b(eVar.h(), aVar3.l(), startRestartGroup, 0);
            int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar);
            Function0 a9 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a9);
            } else {
                startRestartGroup.useNode();
            }
            Composer b8 = g5.b(startRestartGroup);
            g5.e(b8, b7, companion.c());
            g5.e(b8, currentCompositionLocalMap3, companion.e());
            Function2 b9 = companion.b();
            if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a8))) {
                b8.updateRememberedValue(Integer.valueOf(a8));
                b8.apply(Integer.valueOf(a8), b9);
            }
            g5.e(b8, e3, companion.d());
            a6.j("2.其他情况可进入客服中心问询", (Modifier) null, aVar2.h(startRestartGroup, i8).h(), x0.x.h(14), (y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
            float g4 = x0.i.g(2);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g4), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            long H = aVar2.h(startRestartGroup, i8).H();
            long h3 = x0.x.h(14);
            androidx.compose.ui.text.font.c0 h4 = aVar4.h();
            startRestartGroup.startReplaceGroup(5004770);
            if ((i7 & 112) == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5 && rememberedValue2 != companion2.getEmpty()) {
                function0 = openFeedbackPage;
            } else {
                function0 = openFeedbackPage;
                rememberedValue2 = new Function0() { // from class: uj4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s2;
                        s2 = l.s(Function0.this);
                        return s2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
            composer2 = startRestartGroup;
            a6.j("前往客服中心", modifier, H, h3, (y) null, h4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131024);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z4;
        } else {
            function0 = openFeedbackPage;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: uj4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t2;
                    t2 = l.t(z2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return t2;
                }
            });
        }
    }

    public static final void u(boolean z, final List<com.dragon.read.kmp.mine.model.h> phoneCodeList, final Function1<? super com.dragon.read.kmp.mine.model.h, Unit> onPhoneCodeSelect, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z3;
        Composer composer2;
        final boolean z4;
        boolean z5;
        float f;
        e1 a2;
        boolean z6;
        Intrinsics.checkNotNullParameter(phoneCodeList, "phoneCodeList");
        Intrinsics.checkNotNullParameter(onPhoneCodeSelect, "onPhoneCodeSelect");
        Composer startRestartGroup = composer.startRestartGroup(-1050514598);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            if (startRestartGroup.changed(z2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(phoneCodeList)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onPhoneCodeSelect)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (startRestartGroup.shouldExecute(z3, i3 & 1)) {
            if (i7 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050514598, i3, -1, "com.dragon.read.kmp.mine.dialog.KmpSelectPhoneCodeDialogPanel (KmpBindingDialog.kt:143)");
            }
            if (z5) {
                f = 16;
            } else {
                f = 12;
            }
            float g = x0.i.g(f);
            Modifier.a aVar = Modifier.Companion;
            Modifier B = SizeKt.B(androidx.compose.ui.draw.e.a(aVar, k.g.e(g, g, 0.0f, 0.0f, 12, (Object) null)), (e.c) null, false, 3, (Object) null);
            og4.a aVar2 = og4.a.a;
            int i8 = og4.a.b;
            Modifier d2 = BackgroundKt.d(B, aVar2.h(startRestartGroup, i8).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i9 = eVar.i();
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 a3 = x.a(i9, aVar3.k(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a3, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(SizeKt.i(aVar, x0.i.g(56)), 0.0f, 1, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            p0 b4 = r2.b(eVar.h(), aVar3.i(), startRestartGroup, 54);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                b5.updateRememberedValue(Integer.valueOf(a6));
                b5.apply(Integer.valueOf(a6), b6);
            }
            g5.e(b5, e2, companion.d());
            w2 w2Var = w2.b;
            if (z5) {
                startRestartGroup.startReplaceGroup(1986576834);
                a2 = org.jetbrains.compose.resources.c.a(o1.q(w6.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1986580285);
                a2 = org.jetbrains.compose.resources.c.a(d2.G(f2.a.a), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            e1 e1Var = a2;
            float f2 = 24;
            Modifier s = SizeKt.s(aVar, x0.i.g(f2));
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.Companion;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = new Function0() { // from class: uj4.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit w;
                        w = l.w();
                        return w;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            z0.g(e1Var, "close", com.dragon.read.kmp.utils.g.e(s, false, 0L, null, null, (Function0) rememberedValue, startRestartGroup, 196614, 15), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar2.h(startRestartGroup, i8).k()), 0, startRestartGroup, 48, 184);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            long k = aVar2.h(startRestartGroup, i8).k();
            long h = x0.x.h(16);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            a6.j("选择国家和地区", (Modifier) null, k, h, (y) null, aVar4.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131026);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            float g2 = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            Modifier k2 = SizeKt.k(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(600), 1, (Object) null);
            vj4.a aVar5 = new vj4.a(aVar4.h());
            startRestartGroup.startReplaceGroup(5004770);
            if ((i3 & 896) == 256) {
                z6 = true;
            } else {
                z6 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uj4.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit v;
                        v = l.v(Function1.this, (com.dragon.read.kmp.mine.model.h) obj);
                        return v;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            vj4.d.b(k2, phoneCodeList, aVar5, (Function1) rememberedValue2, startRestartGroup, (i3 & 112) | 6, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: uj4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = l.x(z4, phoneCodeList, onPhoneCodeSelect, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    public static final void J(String position, String content, String subContent, String actionText, Context context, Function0<Unit> onItemClick, com.dragon.read.kmp.service.h hVar) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(subContent, "subContent");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        g1 g1Var = new g1(false, false, hVar, true, 3, null);
        g1Var.g = true;
        g1Var.h = context;
        d = KmpDialogServiceKt.l(g1Var, t.c(1303799576, true, new b(position, content, subContent, actionText, onItemClick)));
        o.a.d("popup_show", new ym4.a((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("popup_type", "douyin_login_verify"), TuplesKt.to("position", position)}));
    }

    public static final void l(final String position, final String content, final String subContent, final String actionText, final Function0<Unit> onItemClick, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(subContent, "subContent");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(-1643653489);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(position)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(content)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(subContent)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(actionText)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i2 |= i4;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onItemClick)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            i2 |= i3;
        }
        if ((i2 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643653489, i2, -1, "com.dragon.read.kmp.mine.dialog.KmpBindDialogPanel (KmpBindingDialog.kt:267)");
            }
            p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), t.e(1416895424, true, new a(content, subContent, position, actionText, onItemClick), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: uj4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = l.m(position, content, subContent, actionText, onItemClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    public static /* synthetic */ void K(String str, String str2, String str3, String str4, Context context, Function0 function0, com.dragon.read.kmp.service.h hVar, int i, Object obj) {
        Context context2;
        com.dragon.read.kmp.service.h hVar2;
        if ((i & 16) != 0) {
            context2 = null;
        } else {
            context2 = context;
        }
        if ((i & 64) != 0) {
            hVar2 = null;
        } else {
            hVar2 = hVar;
        }
        J(str, str2, str3, str4, context2, function0, hVar2);
    }
}

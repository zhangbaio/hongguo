package dn4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.q1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.q0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import dn4.v;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    static {
        Covode.recordClassIndex(608749);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(List list, int i, Composer composer, int i2) {
        g(list, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(List list, int i, Composer composer, int i2) {
        g(list, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(List list, int i, Composer composer, int i2) {
        g(list, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        k(str, f, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i, List list, String str, String str2, String str3, String str4, Function1 function1, Function1 function12, int i2, int i3, Composer composer, int i4) {
        m(i, list, str, str2, str3, str4, function1, function12, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<Integer, Unit> a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ androidx.compose.ui.text.font.j d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;
        final /* synthetic */ Modifier g;
        final /* synthetic */ List<String> h;
        final /* synthetic */ boolean i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Integer, Unit> function1, int i, String str, androidx.compose.ui.text.font.j jVar, String str2, long j, Modifier modifier, List<String> list, boolean z, String str3, String str4) {
            this.a = function1;
            this.b = i;
            this.c = str;
            this.d = jVar;
            this.e = str2;
            this.f = j;
            this.g = modifier;
            this.h = list;
            this.i = z;
            this.j = str3;
            this.k = str4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function1 function1, int i) {
            function1.invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(long j, androidx.compose.ui.graphics.drawscope.f Canvas) {
            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
            float M0 = Canvas.M0(x0.i.g((float) 0.5d));
            float intBitsToFloat = Float.intBitsToFloat((int) (Canvas.e() & 4294967295L)) / 2;
            float f = 4;
            DrawScope.-CC.k(Canvas, j, a0.f.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), a0.f.e((4294967295L & Float.floatToRawIntBits(intBitsToFloat)) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.e() >> 32))) << 32)), M0, 0, q1.a.b(q1.a, new float[]{Canvas.M0(x0.i.g(f)), Canvas.M0(x0.i.g(f))}, 0.0f, 2, (Object) null), 0.0f, (androidx.compose.ui.graphics.m0) null, 0, 464, (Object) null);
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            String str;
            float g;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1181034426, i, -1, "com.dragon.read.kmp.search.card.IpHotOriginalCard.<anonymous> (IpHotOriginalCard.kt:73)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 6;
                Modifier a = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, pg4.j.c(250, composer, 6)), pg4.j.c(186, composer, 6)), k.g.c(x0.i.g(f)));
                og4.a aVar2 = og4.a.a;
                int i2 = og4.a.b;
                Modifier d = BackgroundKt.d(a, aVar2.h(composer, i2).o(), (f2) null, 2, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.a) | composer.changed(this.b);
                final Function1<Integer, Unit> function1 = this.a;
                final int i3 = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d2;
                            d2 = v.a.d(Function1.this, i3);
                            return d2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                String str2 = this.c;
                androidx.compose.ui.text.font.j jVar = this.d;
                String str3 = this.e;
                final long j = this.f;
                Modifier modifier2 = this.g;
                List<String> list = this.h;
                boolean z2 = this.i;
                String str4 = this.j;
                String str5 = this.k;
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                float f2 = 16;
                Modifier u = androidx.compose.foundation.layout.f2.u(boxScopeInstance.a(aVar), x0.i.g(f2), x0.i.g(f2), x0.i.g(f2), x0.i.g(0));
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar3.k(), composer, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, u);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, x0.i.g(26), x0.i.g(8), 3, (Object) null);
                s.a aVar4 = w0.s.b;
                int b5 = aVar4.b();
                a6.j(str2, v, aVar2.h(composer, i2).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), jVar, 0L, (w0.i) null, (w0.h) null, x0.x.h(20), b5, false, 1, 0, (Function1) null, (g3) null, composer, 199680, 3126, 119696);
                a6.j(str3, SizeKt.k(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(15), 7, (Object) null), vg4.c.i(88, composer, 6).d, 0.0f, 2, (Object) null), aVar2.h(composer, i2).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, jVar, 0L, (w0.i) null, (w0.h) null, x0.x.h(22), aVar4.b(), false, 4, 0, (Function1) null, (g3) null, composer, 3072, 3126, 119728);
                Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(1));
                composer.startReplaceGroup(5004770);
                boolean changed2 = composer.changed(j);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: dn4.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e3;
                            e3 = v.a.e(j, (androidx.compose.ui.graphics.drawscope.f) obj);
                            return e3;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.z.b(i5, (Function1) rememberedValue2, composer, 6);
                p0 b6 = r2.b(eVar.h(), aVar3.i(), composer, 48);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, modifier2);
                Function0 a8 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a8);
                } else {
                    composer.useNode();
                }
                Composer b7 = g5.b(composer);
                g5.e(b7, b6, companion.c());
                g5.e(b7, currentCompositionLocalMap3, companion.e());
                Function2 b8 = companion.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a7))) {
                    b7.updateRememberedValue(Integer.valueOf(a7));
                    b7.apply(Integer.valueOf(a7), b8);
                }
                g5.e(b7, e3, companion.d());
                w2 w2Var = w2.b;
                composer.startReplaceGroup(240105895);
                if (!list.isEmpty()) {
                    v.g(list, composer, 0);
                    if (z2) {
                        g = x0.i.g(4);
                    } else {
                        g = x0.i.g(f);
                    }
                    a3.a(SizeKt.x(aVar, g), composer, 0);
                }
                composer.endReplaceGroup();
                a6.j(str4, u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), aVar2.h(composer, i2).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer, 3072, 3120, 120816);
                composer.endNode();
                composer.endNode();
                Modifier b9 = boxScopeInstance.b(aVar, aVar3.n());
                float f3 = 4;
                float f4 = 2;
                Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.d(androidx.compose.ui.draw.e.a(androidx.compose.foundation.layout.f2.v(b9, 0.0f, x0.i.g(f3), x0.i.g(f3), 0.0f, 9, (Object) null), k.g.c(x0.i.g(f4))), aVar2.h(composer, i2).h(), (f2) null, 2, (Object) null), x0.i.g(f3), x0.i.g(f4));
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar3.e(), false);
                int a9 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer, s);
                Function0 a10 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a10);
                } else {
                    composer.useNode();
                }
                Composer b10 = g5.b(composer);
                g5.e(b10, i6, companion.c());
                g5.e(b10, currentCompositionLocalMap4, companion.e());
                Function2 b11 = companion.b();
                if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a9))) {
                    b10.updateRememberedValue(Integer.valueOf(a9));
                    b10.apply(Integer.valueOf(a9), b11);
                }
                g5.e(b10, e4, companion.d());
                if (StringsKt__StringsKt.isBlank(str5)) {
                    str = "原文";
                } else {
                    str = str5;
                }
                a6.j(str, (Modifier) null, aVar2.h(composer, i2).r(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(12), 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 6, 130034);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1, int i) {
        function1.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final List<String> list, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(533268013);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        int i4 = 0;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533268013, i2, -1, "com.dragon.read.kmp.search.card.AvatarGroup (IpHotOriginalCard.kt:168)");
            }
            if (list.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: dn4.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit h;
                            h = v.h(list, i, (Composer) obj, ((Integer) obj2).intValue());
                            return h;
                        }
                    });
                    return;
                }
                return;
            }
            float g = x0.i.g(16);
            startRestartGroup.startReplaceGroup(1369457118);
            if (list.size() == 1) {
                k((String) CollectionsKt___CollectionsKt.first((List) list), g, null, startRestartGroup, 48, 4);
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: dn4.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit i5;
                            i5 = v.i(list, i, (Composer) obj, ((Integer) obj2).intValue());
                            return i5;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            float g2 = x0.i.g(g - x0.i.g(6));
            Modifier i5 = SizeKt.i(SizeKt.x(Modifier.Companion, x0.i.g(x0.i.g((list.size() - 1) * g2) + g)), g);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i5);
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
            startRestartGroup.startReplaceGroup(603893618);
            for (Object obj : list) {
                int i7 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                k((String) obj, g, androidx.compose.foundation.layout.f2.v(Modifier.Companion, x0.i.g(i4 * g2), 0.0f, 0.0f, 0.0f, 14, (Object) null), startRestartGroup, 48, 0);
                i4 = i7;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: dn4.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit j;
                    j = v.j(list, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return j;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void k(final java.lang.String r16, final float r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dn4.v.k(java.lang.String, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void m(final int i, final List<String> avatarList, final String tagText, final String content, final String title, final String bottomText, final Function1<? super Integer, Unit> click, Function1<? super Integer, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Function1<? super Integer, Unit> function12;
        int i12;
        boolean z;
        Composer composer2;
        final Function1<? super Integer, Unit> function13;
        final Function1<? super Integer, Unit> function14;
        boolean z2;
        boolean z3;
        Modifier modifier;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bottomText, "bottomText");
        Intrinsics.checkNotNullParameter(click, "click");
        Composer startRestartGroup = composer.startRestartGroup(-893045481);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i4 = i5 | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(avatarList)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(tagText)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(content)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(title)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i4 |= i9;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            if (startRestartGroup.changed(bottomText)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i4 |= i10;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (startRestartGroup.changedInstance(click)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        int i13 = i3 & 128;
        if (i13 != 0) {
            i4 |= 12582912;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 12582912) == 0) {
                if (startRestartGroup.changedInstance(function12)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
        }
        if ((i4 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i13 != 0) {
                function14 = null;
            } else {
                function14 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-893045481, i4, -1, "com.dragon.read.kmp.search.card.IpHotOriginalCard (IpHotOriginalCard.kt:57)");
            }
            q0 q0Var = (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(Font.FZShengShiKaiShuS_M_GB.getFontFamily(), startRestartGroup, 0).getValue();
            if (q0Var == null) {
                q0Var = androidx.compose.ui.text.font.j.b.b();
            }
            q0 q0Var2 = q0Var;
            long t = og4.a.a.h(startRestartGroup, og4.a.b).t();
            if (avatarList.size() > 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            startRestartGroup.startReplaceGroup(776768695);
            Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(776770130);
            if (function14 == null) {
                modifier = null;
            } else {
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed = startRestartGroup.changed(function14);
                if ((i4 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z4 = z3 | changed;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit n;
                            n = v.n(Function1.this, i);
                            return n;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                modifier = ClickableKt.clickable-oSLSa3U$default(h, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            }
            startRestartGroup.endReplaceGroup();
            if (modifier == null) {
                modifier2 = h;
            } else {
                modifier2 = modifier;
            }
            startRestartGroup.endReplaceGroup();
            Function1<? super Integer, Unit> function15 = function14;
            composer2 = startRestartGroup;
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-1181034426, true, new a(click, i, title, q0Var2, content, t, SizeKt.k(androidx.compose.foundation.layout.f2.v(modifier2, 0.0f, x0.i.g(10), 0.0f, x0.i.g(12), 5, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null), avatarList, z2, bottomText, tagText), composer2, 54), composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function13 = function15;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            function13 = function12;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = v.o(i, avatarList, tagText, content, title, bottomText, click, function13, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }
}

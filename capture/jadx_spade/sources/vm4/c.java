package vm4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.image.options.i;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k.g;
import kg4.h;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608667);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(vm4.a aVar, State state, State state2, Function0 function0, i iVar, Function1 function1, int i, int i2, Composer composer, int i3) {
        b(aVar, state, state2, function0, iVar, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ vm4.a b;
        final /* synthetic */ Function1<Integer, Integer> c;
        final /* synthetic */ State<Integer> d;
        final /* synthetic */ State<Float> e;
        final /* synthetic */ i f;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<Unit> function0, vm4.a aVar, Function1<? super Integer, Integer> function1, State<Integer> state, State<Float> state2, i iVar) {
            this.a = function0;
            this.b = aVar;
            this.c = function1;
            this.d = state;
            this.e = state2;
            this.f = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Composer composer, int i) {
            boolean z;
            Map mutableMapOf;
            int i2;
            boolean z2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(315511813, i, -1, "com.dragon.read.kmp.reader.view.ShortSeriesParaCoverCard.<anonymous> (ShortSeriesParaCoverView.kt:75)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(SizeKt.h(aVar, 0.0f, 1, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, this.a, 15, (Object) null);
                vm4.a aVar2 = this.b;
                Function1<Integer, Integer> function1 = this.c;
                State<Integer> state = this.d;
                State<Float> state2 = this.e;
                i iVar = this.f;
                e eVar = e.a;
                e.m i3 = eVar.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 a = x.a(i3, aVar3.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
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
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                c0 c0Var = c0.b;
                float f = 8;
                Modifier b3 = AspectRatioKt.b(androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), g.c(x0.i.g(f))), 1.8617021f, false, 2, (Object) null);
                p0 i4 = m.i(aVar3.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, b3);
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
                g5.e(b4, i4, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String str = aVar2.a;
                Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                kg4.i iVar2 = kg4.i.a;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("scene_tag", "paragraph_series_cover"));
                LoadImageKt.g(str, (String) null, (n) null, f2, iVar, (kg4.b) null, new kg4.a(iVar2, new h(hs4.b.b("reader_single_line", 0, 0, null, null, 0, 0, mutableMapOf, 126, null), (ImageOriginListener) null, false, (String) null, (kg4.e) null, 22, (DefaultConstructorMarker) null), false, false, 12, (DefaultConstructorMarker) null), composer, ((kg4.a.e | h.f) << 18) | 3072, 38);
                Modifier s = f2.s(BackgroundKt.c(f2.v(boxScopeInstance.b(aVar, aVar3.c()), 0.0f, 0.0f, x0.i.g(11), x0.i.g(f), 3, (Object) null), og4.a.a.b(composer, og4.a.b).y(), g.c(x0.i.g(24))), x0.i.g(f), x0.i.g((float) 3.5d));
                p0 b6 = r2.b(eVar.h(), aVar3.i(), composer, 48);
                int a6 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, s);
                Function0 a7 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a7);
                } else {
                    composer.useNode();
                }
                Composer b7 = g5.b(composer);
                g5.e(b7, b6, companion.c());
                g5.e(b7, currentCompositionLocalMap3, companion.e());
                Function2 b8 = companion.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a6))) {
                    b7.updateRememberedValue(Integer.valueOf(a6));
                    b7.apply(Integer.valueOf(a6), b8);
                }
                g5.e(b7, e3, companion.d());
                w2 w2Var = w2.b;
                z0.g(org.jetbrains.compose.resources.c.a(b4.k(d4.a), composer, 0), "Play icon", SizeKt.s(aVar, x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 432, 248);
                a6.j(aVar2.c, (Modifier) null, l0.b.i(), x0.x.h(12), (y) null, androidx.compose.ui.text.font.c0.b.d(), (j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(17), 0, false, 0, 0, (Function1) null, (g3) null, composer, 200064, 6, 130002);
                composer.endNode();
                composer.endNode();
                List<String> list = aVar2.b;
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(list);
                Object rememberedValue = composer.rememberedValue();
                if (!changed && rememberedValue != Composer.Companion.getEmpty()) {
                    i2 = 1;
                } else {
                    List<String> list2 = aVar2.b;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list2) {
                        if (!StringsKt__StringsKt.isBlank((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    i2 = 1;
                    rememberedValue = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "· ", null, null, 0, null, null, 62, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                String str2 = (String) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1574786676);
                if (str2.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Modifier.a aVar4 = Modifier.Companion;
                    a3.a(SizeKt.i(aVar4, x0.i.g(f)), composer, 6);
                    a6.j(str2, SizeKt.h(aVar4, 0.0f, i2, (Object) null), n0.b(((Number) function1.invoke(state.getValue())).intValue()), x0.x.g(((Number) state2.getValue()).floatValue()), (y) null, (androidx.compose.ui.text.font.c0) null, (j) KmpFontServiceKt.a(Font.FZShengShiKaiShuS_M_GB.getFontFamily(), composer, 0).getValue(), 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 2, 0, (Function1) null, (g3) null, composer, 48, 3120, 120752);
                }
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final vm4.a r23, final androidx.compose.runtime.State<java.lang.Integer> r24, final androidx.compose.runtime.State<java.lang.Float> r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, com.bytedance.kmp.image.options.i r27, final kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Integer> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vm4.c.b(vm4.a, androidx.compose.runtime.State, androidx.compose.runtime.State, kotlin.jvm.functions.Function0, com.bytedance.kmp.image.options.i, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}

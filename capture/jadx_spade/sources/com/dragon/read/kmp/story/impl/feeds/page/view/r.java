package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.e0;
import androidx.compose.ui.input.pointer.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.rp;
import com.bytedance.kmp.ugc.model.sp;
import com.bytedance.kmp.ugc.model.ts;
import com.bytedance.kmp.ugc.model.us;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.page.view.r;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    static {
        Covode.recordClassIndex(609326);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(np4.c cVar, kp4.b bVar, int i, Composer composer, int i2) {
        b(cVar, bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements PointerInputEventHandler {
        final /* synthetic */ kp4.b a;
        final /* synthetic */ KmpStoryFeedsVM b;

        a(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
            this.a = bVar;
            this.b = kmpStoryFeedsVM;
        }

        public final Object invoke(e0 e0Var, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            final kp4.b bVar = this.a;
            final KmpStoryFeedsVM kmpStoryFeedsVM = this.b;
            Object m = TapGestureDetectorKt.m(e0Var, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b;
                    b = r.a.b(kp4.b.this, kmpStoryFeedsVM, (a0.f) obj);
                    return b;
                }
            }, continuation, 7, (Object) null);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (m == coroutine_suspended) {
                return m;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit b(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM, a0.f fVar) {
            if (!bVar.m()) {
                KmpStoryFeedsVM.p1(kmpStoryFeedsVM, bVar, null, 2, null);
            } else {
                kmpStoryFeedsVM.f2();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3 e(boolean z, Composer composer, int i, int i2) {
        boolean z2;
        long j;
        composer.startReplaceGroup(702073125);
        if ((i2 & 1) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(702073125, i, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.tagTextStyle (ContentTitlePageView.kt:128)");
        }
        if (z2) {
            composer.startReplaceGroup(-1030150904);
            j = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).u();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1030092531);
            j = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).j();
            composer.endReplaceGroup();
        }
        g3 g3Var = new g3(j, x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(16), (w0.q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    public static final void b(final np4.c page, final kp4.b story, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        Composer composer3;
        Modifier modifier;
        int i3;
        boolean z2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(story, "story");
        Composer startRestartGroup = composer.startRestartGroup(-1384418527);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(page)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(story)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1384418527, i2, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.ContentTitlePageView (ContentTitlePageView.kt:33)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier modifier2 = Modifier.Companion;
                float f = 16;
                Modifier s = f2.s(modifier2, x0.i.g(f), x0.i.g(f));
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(story) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(story, kmpStoryFeedsVM);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier c2 = m0.c(s, unit, (PointerInputEventHandler) rememberedValue);
                e.a aVar = androidx.compose.ui.e.a;
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, c2);
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
                Modifier h = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
                float f2 = 4;
                p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.p(x0.i.g(f2)), aVar.k(), startRestartGroup, 6);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
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
                Composer b3 = g5.b(startRestartGroup);
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                String str = page.d;
                long h2 = x0.x.h(20);
                long h3 = x0.x.h(32);
                c0.a aVar2 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 d = aVar2.d();
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                a6.j(str, (Modifier) null, cVar.b(startRestartGroup, 6).k(), h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h3, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 6, 130002);
                if (story.d().c.c && page.e.isEmpty()) {
                    composer3 = startRestartGroup;
                    composer3.startReplaceGroup(833922329);
                    modifier = modifier2;
                    i3 = 6;
                    androidx.compose.foundation.layout.m.b(SizeKt.i(SizeKt.x(modifier, x0.i.g(200)), x0.i.g(18)), composer3, 6);
                    composer3.endReplaceGroup();
                } else {
                    composer3 = startRestartGroup;
                    modifier = modifier2;
                    i3 = 6;
                    composer3.startReplaceGroup(834145436);
                    List<us> list = page.e;
                    if (list.isEmpty() && story.l()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        list = CollectionsKt__CollectionsJVMKt.listOf(new us("一口气读完", (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (ts) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (sp) null, (Integer) null, (rp) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483646, (DefaultConstructorMarker) null));
                    }
                    List<us> list2 = list;
                    Modifier h4 = SizeKt.h(modifier, 0.0f, 1, (Object) null);
                    f fVar = f.a;
                    com.dragon.read.kmp.story.impl.widget.h.d(h4, list2, fVar.b(), fVar.a(), composer3, 3462);
                    composer3.endReplaceGroup();
                }
                composer3.endNode();
                composer3.startReplaceGroup(-935956230);
                if (com.dragon.read.kmp.story.impl.feeds.config.b.a.b()) {
                    composer2 = composer3;
                    a6.j(page.c(), f2.v(boxScopeInstance.b(modifier, aVar.c()), 0.0f, 0.0f, x0.i.g(f2), x0.i.g(f2), 3, (Object) null), cVar.b(composer3, i3).M(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar2.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
                } else {
                    composer2 = composer3;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c3;
                    c3 = r.c(np4.c.this, story, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c3;
                }
            });
        }
    }
}

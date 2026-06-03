package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.enums.PageShadeStyle;
import com.dragon.read.kmp.story.impl.feeds.page.view.c0;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609330);
            int[] iArr = new int[PageShadeStyle.values().length];
            try {
                iArr[PageShadeStyle.Load.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageShadeStyle.Fold.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609329);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(np4.e eVar, kp4.b bVar, int i, int i2, Composer composer, int i3) {
        e(eVar, bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, kp4.b bVar, LoadStatus loadStatus, int i, int i2, Composer composer, int i3) {
        g(modifier, bVar, loadStatus, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, kp4.b bVar, LoadStatus loadStatus, int i, int i2, Composer composer, int i3) {
        g(modifier, bVar, loadStatus, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, kp4.b bVar, LoadStatus loadStatus, int i, int i2, Composer composer, int i3) {
        g(modifier, bVar, loadStatus, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class b implements Function3<mg4.b, Composer, Integer, Unit> {
        final /* synthetic */ KmpStoryFeedsVM a;
        final /* synthetic */ kp4.b b;

        b(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar) {
            this.a = kmpStoryFeedsVM;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar) {
            kmpStoryFeedsVM.Q1(bVar);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(mg4.b bVar, Composer composer, Integer num) {
            b(bVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(mg4.b it2, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(it2, "it");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1247926354, i, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.StoryLoadLayout.<anonymous> (KmpRichTextPageView.kt:175)");
                }
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance = composer.changedInstance(this.a) | composer.changedInstance(this.b);
                final KmpStoryFeedsVM kmpStoryFeedsVM = this.a;
                final kp4.b bVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = c0.b.c(KmpStoryFeedsVM.this, bVar);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(f, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 14, (Object) null);
                p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                a6.j("加载失败，请点击重试", (Modifier) null, com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3078, 0, 131058);
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

    static final class a implements PointerInputEventHandler {
        final /* synthetic */ kp4.b a;
        final /* synthetic */ KmpStoryFeedsVM b;

        a(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
            this.a = bVar;
            this.b = kmpStoryFeedsVM;
        }

        public final Object invoke(androidx.compose.ui.input.pointer.e0 e0Var, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            final kp4.b bVar = this.a;
            final KmpStoryFeedsVM kmpStoryFeedsVM = this.b;
            Object m = TapGestureDetectorKt.m(e0Var, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.b0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b;
                    b = c0.a.b(kp4.b.this, kmpStoryFeedsVM, (a0.f) obj);
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

    public static final void e(final np4.e page, final kp4.b story, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        List listOf;
        Modifier modifier;
        int i4;
        int i5;
        int i6;
        boolean changedInstance;
        int i7;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(story, "story");
        Composer startRestartGroup = composer.startRestartGroup(-1990015860);
        if ((i2 & 6) == 0) {
            if ((i2 & 8) == 0) {
                changedInstance = startRestartGroup.changed(page);
            } else {
                changedInstance = startRestartGroup.changedInstance(page);
            }
            if (changedInstance) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(story)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990015860, i3, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.KmpRichTextPageView (KmpRichTextPageView.kt:37)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                int o = kmpStoryFeedsVM.k.o(page.c());
                Modifier modifier2 = Modifier.Companion;
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(story) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(story, kmpStoryFeedsVM);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier c3 = m0.c(modifier2, unit, (PointerInputEventHandler) rememberedValue);
                e.a aVar = androidx.compose.ui.e.a;
                p0 i8 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, c3);
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
                g5.e(b2, i8, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier2);
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
                g5.e(b4, a4, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier h = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
                if (page.g() && page.e() > 0) {
                    h = SizeKt.i(h, x0.i.g(page.e()));
                }
                Modifier b6 = androidx.compose.ui.draw.e.b(h);
                p0 i9 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, b6);
                Function0 a8 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b7 = g5.b(startRestartGroup);
                g5.e(b7, i9, companion.c());
                g5.e(b7, currentCompositionLocalMap3, companion.e());
                Function2 b8 = companion.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a7))) {
                    b7.updateRememberedValue(Integer.valueOf(a7));
                    b7.apply(Integer.valueOf(a7), b8);
                }
                g5.e(b7, e3, companion.d());
                int i10 = page.f;
                nn0.b bVar = page.e;
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                pn0.f.d(i10, bVar, new s(cVar.b(startRestartGroup, 6).g(), pm4.q.a.a(cVar.a(startRestartGroup, 6)), null), (Modifier) null, (kn0.a) null, startRestartGroup, nn0.b.b << 3, 24);
                c0.a aVar2 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(l0.b.g()), l0.j(cVar.b(startRestartGroup, 6).z())});
                androidx.compose.ui.graphics.c0 p = c0.a.p(aVar2, listOf, 0.0f, 0.0f, 0, 14, (Object) null);
                int i11 = c.a[page.f().ordinal()];
                if (i11 != 1) {
                    if (i11 != 2) {
                        startRestartGroup.startReplaceGroup(-1038430442);
                        startRestartGroup.endReplaceGroup();
                        modifier = modifier2;
                    } else {
                        startRestartGroup.startReplaceGroup(-1039199242);
                        Modifier b9 = boxScopeInstance.b(modifier2, aVar.b());
                        p0 a9 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar.k(), startRestartGroup, 0);
                        int a10 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                        e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier e4 = ComposedModifierKt.e(startRestartGroup, b9);
                        Function0 a11 = companion.a();
                        if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(a11);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer b10 = g5.b(startRestartGroup);
                        g5.e(b10, a9, companion.c());
                        g5.e(b10, currentCompositionLocalMap4, companion.e());
                        Function2 b11 = companion.b();
                        if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a10))) {
                            b10.updateRememberedValue(Integer.valueOf(a10));
                            b10.apply(Integer.valueOf(a10), b11);
                        }
                        g5.e(b10, e4, companion.d());
                        modifier = modifier2;
                        androidx.compose.foundation.layout.m.b(BackgroundKt.b(SizeKt.i(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(20)), p, (f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
                        androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.h(modifier, 0.0f, 1, (Object) null), x0.i.g(8)), cVar.b(startRestartGroup, 6).z(), (f2) null, 2, (Object) null), startRestartGroup, 0);
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceGroup();
                    }
                    i4 = 0;
                } else {
                    modifier = modifier2;
                    startRestartGroup.startReplaceGroup(-1039597344);
                    i4 = 0;
                    androidx.compose.foundation.layout.m.b(boxScopeInstance.b(BackgroundKt.b(SizeKt.i(SizeKt.h(modifier, 0.0f, 1, (Object) null), x0.i.g(98)), p, (f2) null, 0.0f, 6, (Object) null), aVar.b()), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.startReplaceGroup(243598652);
                if (com.dragon.read.kmp.story.impl.feeds.config.b.a.b()) {
                    float f = 8;
                    a6.j("page: " + o + " - " + page.f + ", pos: " + i, androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(modifier, aVar.o()), x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null), cVar.b(startRestartGroup, 6).p(), x0.x.h(24), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131024);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                int i12 = i3 & 112;
                Modifier modifier3 = modifier;
                composer2 = startRestartGroup;
                g(SizeKt.i(SizeKt.f(modifier, 0.0f, 1, (Object) null), x0.i.g(117)), story, page.d(), startRestartGroup, i12 | 6, 0);
                composer2.endNode();
                composer2.startReplaceGroup(-1455531101);
                if (page.g()) {
                    e.e(androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(modifier3, aVar.c()), 0.0f, 0.0f, x0.i.g(16), x0.i.g(44), 3, (Object) null), story, composer2, i12, i4);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f2;
                    f2 = c0.f(np4.e.this, story, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return f2;
                }
            });
        }
    }

    public static final void g(Modifier modifier, final kp4.b story, LoadStatus loadStatus, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int ordinal;
        int i6;
        boolean z;
        Modifier modifier3;
        LoadStatus loadStatus2;
        LoadStatus loadStatus3;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(story, "story");
        Composer startRestartGroup = composer.startRestartGroup(-1887029942);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(story)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (loadStatus == null) {
                ordinal = -1;
            } else {
                ordinal = loadStatus.ordinal();
            }
            if (startRestartGroup.changed(ordinal)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        int i9 = i3;
        if ((i9 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i9 & 1)) {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i8 != 0) {
                loadStatus3 = LoadStatus.Init;
            } else {
                loadStatus3 = loadStatus;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1887029942, i9, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.StoryLoadLayout (KmpRichTextPageView.kt:158)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                if (!story.m()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        final LoadStatus loadStatus4 = loadStatus3;
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.y
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit h;
                                h = c0.h(modifier4, story, loadStatus4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return h;
                            }
                        });
                        return;
                    }
                    return;
                }
                if (loadStatus3 != LoadStatus.Loading && loadStatus3 != LoadStatus.Error) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        final Modifier modifier5 = modifier3;
                        final LoadStatus loadStatus5 = loadStatus3;
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.z
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit i10;
                                i10 = c0.i(modifier5, story, loadStatus5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return i10;
                            }
                        });
                        return;
                    }
                    return;
                }
                LoadStatus loadStatus6 = loadStatus3;
                mg4.k.r(loadStatus3, (mg4.b) null, l0.b.g(), modifier3, (Function2) null, false, (Function3) null, androidx.compose.runtime.internal.t.e(-1247926354, true, new b(kmpStoryFeedsVM, story), startRestartGroup, 54), (Function2) null, startRestartGroup, ((i9 >> 6) & 14) | 12583296 | ((i9 << 9) & 7168), 370);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                loadStatus2 = loadStatus6;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            loadStatus2 = loadStatus;
        }
        t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            final LoadStatus loadStatus7 = loadStatus2;
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = c0.j(modifier6, story, loadStatus7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }
}

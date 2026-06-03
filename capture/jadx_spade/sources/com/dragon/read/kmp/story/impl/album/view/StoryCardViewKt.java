package com.dragon.read.kmp.story.impl.album.view;

import a0.l;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.b1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.font.z;
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
import com.dragon.read.kmp.story.impl.album.r;
import com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import w0.p;
import w0.q;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryCardViewKt {
    static {
        Covode.recordClassIndex(609220);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(List list, pp4.d dVar, int i, Composer composer, int i2) {
        e(list, dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ep4.b bVar, int i, com.dragon.read.kmp.story.impl.album.a aVar, ep4.a aVar2, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar3, int i2, Composer composer, int i3) {
        g(bVar, i, aVar, aVar2, aVar3, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ pp4.d a;

        b(pp4.d dVar) {
            this.a = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-782926731, i, -1, "com.dragon.read.kmp.story.impl.album.view.RecTagLayout.<anonymous>.<anonymous> (StoryCardView.kt:159)");
                }
                float f = 3;
                float f2 = 2;
                a3.a(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.s(f2.v(Modifier.Companion, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), x0.i.g(f2)), k.g.c(x0.i.g(f2))), this.a.h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void m(com.dragon.read.kmp.story.impl.album.a depend, String storyId) {
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        depend.c(storyId, new LinkedHashMap());
    }

    static final class a implements Function3<us, Composer, Integer, Unit> {
        final /* synthetic */ pp4.d a;

        a(pp4.d dVar) {
            this.a = dVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(us usVar, Composer composer, Integer num) {
            a(usVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(us tagInfo, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-746356190, i, -1, "com.dragon.read.kmp.story.impl.album.view.RecTagLayout.<anonymous>.<anonymous> (StoryCardView.kt:151)");
            }
            String str = tagInfo.a;
            if (str == null) {
                str = "";
            }
            a6.j(str, (Modifier) null, 0L, 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, StoryCardViewKt.n(this.a, Intrinsics.areEqual(tagInfo.c, Boolean.TRUE), composer, 0, 0), composer, 0, 3120, 55294);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void l(ep4.b contentData, int i, ep4.a storyAlbumParam) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(storyAlbumParam, "storyAlbumParam");
        kx1.c cVar = new kx1.c();
        cVar.j(storyAlbumParam.f);
        cVar.g("album_inner_rank", Integer.valueOf(i));
        r.a.e(contentData, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(StoryAlbumViewModel storyAlbumViewModel, ep4.b bVar, int i, w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        storyAlbumViewModel.Y0();
        storyAlbumViewModel.X0(bVar, i);
        return Unit.INSTANCE;
    }

    private static final void e(final List<us> list, final pp4.d dVar, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-620626688);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
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
                changedInstance = startRestartGroup.changed(dVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(dVar);
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
                ComposerKt.traceEventStart(-620626688, i2, -1, "com.dragon.read.kmp.story.impl.album.view.RecTagLayout (StoryCardView.kt:143)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier v = f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(6), 0.0f, 0.0f, 13, (Object) null);
            p0 i5 = m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, i5, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            com.dragon.read.kmp.story.impl.widget.d.d(SizeKt.h(aVar, 0.0f, 1, (Object) null), list, t.e(-746356190, true, new a(dVar), startRestartGroup, 54), t.e(-782926731, true, new b(dVar), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 3462);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.view.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = StoryCardViewKt.f(list, dVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(com.dragon.read.kmp.story.impl.album.a aVar, ep4.b bVar, int i, ep4.a aVar2, CoroutineScope coroutineScope) {
        m(aVar, bVar.a.a);
        l(bVar, i, aVar2);
        kotlinx.coroutines.i.e(coroutineScope, null, null, new StoryCardViewKt$StoryCardView$3$1$1(aVar, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3 n(pp4.d dVar, boolean z, Composer composer, int i, int i2) {
        boolean z2;
        long h;
        composer.startReplaceGroup(756472808);
        if ((i2 & 2) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(756472808, i, -1, "com.dragon.read.kmp.story.impl.album.view.tagTextStyle (StoryCardView.kt:171)");
        }
        if (z2) {
            h = dVar.u();
        } else {
            h = dVar.h();
        }
        g3 g3Var = new g3(h, x.h(12), (c0) null, (y) null, (z) null, (j) null, (String) null, 0L, (w0.a) null, (p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x.h(16), (q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    public static final void g(final ep4.b contentData, final int i, final com.dragon.read.kmp.story.impl.album.a depend, final ep4.a storyAlbumParam, final com.dragon.read.kmp.story.impl.album.viewmodel.a feedListState, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        boolean z4;
        Modifier modifier;
        char c;
        int i4;
        String str;
        long k;
        String str2;
        boolean z5;
        int i5;
        int i6;
        boolean changedInstance;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(storyAlbumParam, "storyAlbumParam");
        Intrinsics.checkNotNullParameter(feedListState, "feedListState");
        Composer startRestartGroup = composer.startRestartGroup(919047886);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(contentData)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i3 = i9 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i3 |= i8;
        }
        if ((i2 & 384) == 0) {
            if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(depend);
            } else {
                changedInstance = startRestartGroup.changedInstance(depend);
            }
            if (changedInstance) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(storyAlbumParam)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changedInstance(feedListState)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(919047886, i3, -1, "com.dragon.read.kmp.story.impl.album.view.StoryCardView (StoryCardView.kt:54)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final StoryAlbumViewModel storyAlbumViewModel = (StoryAlbumViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(StoryAlbumViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                pp4.d a2 = pp4.e.a(feedListState.h);
                Modifier modifier2 = Modifier.Companion;
                float f = 8;
                Modifier c3 = BackgroundKt.c(SizeKt.h(modifier2, 0.0f, 1, (Object) null), a2.S(), k.g.c(x0.i.g(f)));
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance2 = startRestartGroup.changedInstance(storyAlbumViewModel) | startRestartGroup.changedInstance(contentData);
                int i10 = i3 & 112;
                if (i10 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = changedInstance2 | z2;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.story.impl.album.view.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit h;
                            h = StoryCardViewKt.h(StoryAlbumViewModel.this, contentData, i, (w) obj);
                            return h;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier r = f2.r(d1.a(c3, (Function1) rememberedValue2), x0.i.g(16));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = androidx.compose.foundation.interaction.h.a();
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1224400529);
                if ((i3 & 896) != 256 && ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(depend))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                boolean changedInstance3 = z3 | startRestartGroup.changedInstance(contentData);
                if (i10 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean changedInstance4 = changedInstance3 | z4 | startRestartGroup.changedInstance(storyAlbumParam) | startRestartGroup.changedInstance(coroutineScope);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance4 && rememberedValue4 != companion.getEmpty()) {
                    modifier = modifier2;
                    composer2 = startRestartGroup;
                    i4 = 16;
                    c = ' ';
                } else {
                    modifier = modifier2;
                    c = ' ';
                    i4 = 16;
                    composer2 = startRestartGroup;
                    Function0 function0 = new Function0() { // from class: com.dragon.read.kmp.story.impl.album.view.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit j;
                            j = StoryCardViewKt.j(com.dragon.read.kmp.story.impl.album.a.this, contentData, i, storyAlbumParam, coroutineScope);
                            return j;
                        }
                    };
                    composer2.updateRememberedValue(function0);
                    rememberedValue4 = function0;
                }
                composer2.endReplaceGroup();
                Modifier modifier3 = ClickableKt.combinedClickable-auXiCPI$default(r, iVar, (b1) null, false, (String) null, (Role) null, (String) null, (Function0) null, (Function0) null, false, (Function0) rememberedValue4, 508, (Object) null);
                e.a aVar = androidx.compose.ui.e.a;
                p0 i11 = m.i(aVar.o(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                e0 currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer2, modifier3);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a4 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a4);
                } else {
                    composer2.useNode();
                }
                Composer b2 = g5.b(composer2);
                g5.e(b2, i11, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                    b2.updateRememberedValue(Integer.valueOf(a3));
                    b2.apply(Integer.valueOf(a3), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                boolean areEqual = Intrinsics.areEqual(contentData.a.a, feedListState.g);
                Modifier h = SizeKt.h(modifier, 0.0f, 1, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar.k(), composer2, 0);
                int a6 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                e0 currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer2, h);
                Function0 a7 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a7);
                } else {
                    composer2.useNode();
                }
                Composer b4 = g5.b(composer2);
                g5.e(b4, a5, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                    b4.updateRememberedValue(Integer.valueOf(a6));
                    b4.apply(Integer.valueOf(a6), b5);
                }
                g5.e(b4, e2, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                String str3 = contentData.a.d;
                if (str3 == null) {
                    str = "";
                } else {
                    str = str3;
                }
                if (areEqual) {
                    k = a2.u();
                } else {
                    k = a2.k();
                }
                long h2 = x.h(i4);
                long h3 = x.h(24);
                Modifier h4 = SizeKt.h(modifier, 0.0f, 1, (Object) null);
                s.a aVar2 = s.b;
                int b6 = aVar2.b();
                c0.a aVar3 = c0.b;
                Modifier modifier4 = modifier;
                a6.j(str, h4, k, h2, (y) null, aVar3.a(), (j) null, 0L, (w0.i) null, (w0.h) null, h3, b6, false, 0, 0, (Function1) null, (g3) null, composer2, 199728, 54, 127952);
                a3.a(SizeKt.i(modifier4, x0.i.g(4)), composer2, 6);
                Modifier h5 = SizeKt.h(modifier4, 0.0f, 1, (Object) null);
                p0 b7 = r2.b(eVar.h(), aVar.l(), composer2, 0);
                int a8 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer2, h5);
                Function0 a9 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a9);
                } else {
                    composer2.useNode();
                }
                Composer b8 = g5.b(composer2);
                g5.e(b8, b7, companion2.c());
                g5.e(b8, currentCompositionLocalMap3, companion2.e());
                Function2 b9 = companion2.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a8))) {
                    b8.updateRememberedValue(Integer.valueOf(a8));
                    b8.apply(Integer.valueOf(a8), b9);
                }
                g5.e(b8, e3, companion2.d());
                Modifier a10 = u2.a(w2.b, modifier4, 1.0f, false, 2, (Object) null);
                p0 a11 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar.k(), composer2, 0);
                int a12 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                e0 currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer2, a10);
                Function0 a13 = companion2.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a13);
                } else {
                    composer2.useNode();
                }
                Composer b10 = g5.b(composer2);
                g5.e(b10, a11, companion2.c());
                g5.e(b10, currentCompositionLocalMap4, companion2.e());
                Function2 b11 = companion2.b();
                if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a12))) {
                    b10.updateRememberedValue(Integer.valueOf(a12));
                    b10.apply(Integer.valueOf(a12), b11);
                }
                g5.e(b10, e4, companion2.d());
                String str4 = contentData.b;
                if (str4 == null) {
                    str2 = "";
                } else {
                    str2 = str4;
                }
                a6.j(str2, SizeKt.h(modifier4, 0.0f, 1, (Object) null), a2.j(), x.h(14), (y) null, aVar3.e(), (j) null, 0L, (w0.i) null, (w0.h) null, x.h(24), aVar2.b(), false, 2, 0, (Function1) null, (g3) null, composer2, 199728, 3126, 119760);
                ArrayList arrayList = new ArrayList();
                if (areEqual) {
                    arrayList.add(new us("当前阅读", (Boolean) null, Boolean.TRUE, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (ts) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (sp) null, (Integer) null, (rp) null, (List) null, (Integer) null, (Map) null, (Integer) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Integer) null, (Boolean) null, 2147483642, (DefaultConstructorMarker) null));
                }
                List<us> list = contentData.c;
                if (list != null) {
                    arrayList.addAll(list);
                }
                e(arrayList, a2, composer2, 0);
                composer2.endNode();
                String str5 = contentData.a.m;
                composer2.startReplaceGroup(-987477146);
                if (str5 != null && str5.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    a3.a(SizeKt.x(modifier4, x0.i.g(f)), composer2, 6);
                    op4.f.c(str5, l.d((Float.floatToRawIntBits(44.0f) << c) | (Float.floatToRawIntBits(62.0f) & 4294967295L)), composer2, 48);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.view.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i12;
                    i12 = StoryCardViewKt.i(ep4.b.this, i, depend, storyAlbumParam, feedListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return i12;
                }
            });
        }
    }
}

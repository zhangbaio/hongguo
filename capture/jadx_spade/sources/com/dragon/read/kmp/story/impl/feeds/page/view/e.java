package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(609322);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, kp4.b bVar, int i, int i2, Composer composer, int i3) {
        e(modifier, bVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final boolean f(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void h(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar) {
        kmpStoryFeedsVM.t1(bVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
        bVar.f.a.h();
        KmpStoryFeedsVM.p1(kmpStoryFeedsVM, bVar, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(kp4.b bVar, MutableState mutableState, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!f(mutableState)) {
            bVar.f.a.f();
            h(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    public static final void e(Modifier modifier, final kp4.b story, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        boolean z;
        final Modifier modifier3;
        Modifier modifier4;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(story, "story");
        Composer startRestartGroup = composer.startRestartGroup(1912044290);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
        boolean z2 = true;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1912044290, i3, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.AttachedBoxViewWrapper (AttachedBoxViewWrapper.kt:23)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                CreationExtras creationExtras2 = creationExtras;
                modifier3 = modifier4;
                final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras2, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(story);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit i7;
                            i7 = e.i(kp4.b.this, mutableState, (androidx.compose.ui.layout.w) obj);
                            return i7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a = d1.a(modifier3, (Function1) rememberedValue2);
                p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, a);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a4 = companion2.a();
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
                g5.e(b, a2, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                if (!story.d().k) {
                    z2 = false;
                }
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(kmpStoryFeedsVM) | startRestartGroup.changedInstance(story);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit j;
                            j = e.j(KmpStoryFeedsVM.this, story);
                            return j;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                hp4.d.b(z2, (Function0) rememberedValue3, startRestartGroup, 0);
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(12)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance3 = startRestartGroup.changedInstance(story) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit k;
                            k = e.k(kp4.b.this, kmpStoryFeedsVM);
                            return k;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                hp4.b.b("展开", false, (Function0) rememberedValue4, startRestartGroup, 54, 0);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = e.g(modifier3, story, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }
}

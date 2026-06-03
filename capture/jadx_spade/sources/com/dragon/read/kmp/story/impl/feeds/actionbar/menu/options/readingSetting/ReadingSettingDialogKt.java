package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.c4;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.v1;
import androidx.compose.runtime.x1;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.j1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.uicontext.KmpStoryReadingSettingManager;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReadingSettingDialogKt {
    static {
        Covode.recordClassIndex(609236);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Modifier modifier, List list, Object obj, int i, Function1 function1, Function1 function12, boolean z, int i2, int i3, Composer composer, int i4) {
        A(modifier, list, obj, i, function1, function12, z, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(y yVar, int i, Composer composer, int i2) {
        P(yVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, List list, com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar, Function1 function1, int i, int i2, Composer composer, int i3) {
        r(modifier, list, aVar, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0133, code lost:
    
        if (r14 == r28.getEmpty()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void P(final com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.y r67, androidx.compose.runtime.Composer r68, final int r69) {
        /*
            Method dump skipped, instructions count: 2401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.ReadingSettingDialogKt.P(com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.y, androidx.compose.runtime.Composer, int):void");
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ s a;
        final /* synthetic */ kp4.b b;
        final /* synthetic */ KmpStoryFeedsVM c;

        public void dispose() {
            boolean z;
            String str;
            int i = this.a.b.b;
            KmpStoryReadingSettingManager kmpStoryReadingSettingManager = KmpStoryReadingSettingManager.a;
            boolean z2 = false;
            if (i == kmpStoryReadingSettingManager.h().b && this.a.a == kmpStoryReadingSettingManager.e()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                HashMap hashMap = new HashMap();
                hashMap.put("page_id", this.c.a.e());
                kmpStoryReadingSettingManager.l(hashMap);
            }
            if (this.a.c != kmpStoryReadingSettingManager.i()) {
                z2 = true;
            }
            if (!z && !z2) {
                str = "0";
            } else {
                str = "1";
            }
            lp4.b bVar = this.b.f.a;
            ym4.a aVar = new ym4.a();
            aVar.g("font_size", String.valueOf(kmpStoryReadingSettingManager.e()));
            aVar.g("line_space", kmpStoryReadingSettingManager.h().c);
            aVar.g("background", kmpStoryReadingSettingManager.j());
            aVar.g("if_adjusted", str);
            Unit unit = Unit.INSTANCE;
            bVar.l("post_setting_result", aVar);
            this.a.F0();
        }

        public a(s sVar, kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
            this.a = sVar;
            this.b = bVar;
            this.c = kmpStoryFeedsVM;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState Q(s sVar) {
        return sVar.e;
    }

    private static final <T> T C(MutableState<T> mutableState) {
        return (T) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float G(v1 v1Var) {
        return v1Var.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(y yVar) {
        yVar.c.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String S(int i) {
        return String.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V(ec4.k it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    private static final MutableState<com.dragon.read.kmp.story.impl.feeds.uicontext.a> a0(State<? extends MutableState<com.dragon.read.kmp.story.impl.feeds.uicontext.a>> state) {
        return (MutableState) state.getValue();
    }

    private static final boolean E(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float I(MutableState<x0.i> mutableState) {
        return ((x0.i) mutableState.getValue()).m();
    }

    private static final float K(MutableState<x0.i> mutableState) {
        return ((x0.i) mutableState.getValue()).m();
    }

    private static final float v(MutableState<x0.i> mutableState) {
        return ((x0.i) mutableState.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void D(MutableState<T> mutableState, T t) {
        mutableState.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(v1 v1Var, float f) {
        v1Var.setFloatValue(f);
    }

    private static final void t(x1 x1Var, int i) {
        x1Var.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void J(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    private static final void L(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    private static final void u(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    private static final void w(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(kp4.b bVar, State state, com.dragon.read.kmp.story.impl.feeds.uicontext.a color) {
        Intrinsics.checkNotNullParameter(color, "color");
        lp4.b bVar2 = bVar.f.a;
        ym4.a aVar = new ym4.a();
        aVar.g("setting_item", "background");
        Unit unit = Unit.INSTANCE;
        bVar2.l("click_post_setting", aVar);
        b1 b1Var = b1.a;
        if (b1Var.v()) {
            pm4.q qVar = pm4.q.a;
            if (qVar.a(((com.dragon.read.kmp.story.impl.feeds.uicontext.a) a0(state).getValue()).a) || qVar.a(color.a)) {
                b1Var.C();
                return Unit.INSTANCE;
            }
        }
        KmpStoryReadingSettingManager.a.c(color.a);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult b0(s sVar, kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        sVar.E0();
        return new a(sVar, bVar, kmpStoryFeedsVM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(x0.e eVar, MutableState mutableState, MutableState mutableState2, x0.t tVar) {
        J(mutableState, eVar.v1((int) (tVar.j() >> 32)));
        L(mutableState2, eVar.v1((int) (tVar.j() & 4294967295L)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(kp4.b bVar, final MutableState mutableState, KmpStoryFeedsVM kmpStoryFeedsVM, int i) {
        lp4.b bVar2 = bVar.f.a;
        ym4.a aVar = new ym4.a();
        aVar.g("setting_item", "font_size");
        Unit unit = Unit.INSTANCE;
        bVar2.l("click_post_setting", aVar);
        KmpStoryReadingSettingManager.a.m(i);
        mutableState.setValue(Boolean.FALSE);
        kmpStoryFeedsVM.O1(true, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit U;
                U = ReadingSettingDialogKt.U(mutableState);
                return U;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(kp4.b bVar, final MutableState mutableState, KmpStoryFeedsVM kmpStoryFeedsVM, ec4.k option) {
        Intrinsics.checkNotNullParameter(option, "option");
        lp4.b bVar2 = bVar.f.a;
        ym4.a aVar = new ym4.a();
        aVar.g("setting_item", "line_space");
        Unit unit = Unit.INSTANCE;
        bVar2.l("click_post_setting", aVar);
        KmpStoryReadingSettingManager.a.o(option);
        mutableState.setValue(Boolean.FALSE);
        kmpStoryFeedsVM.O1(true, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit X;
                X = ReadingSettingDialogKt.X(mutableState);
                return X;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(x0.e eVar, MutableState mutableState, MutableState mutableState2, x0.t tVar) {
        u(mutableState, eVar.v1((int) (tVar.j() >> 32)));
        w(mutableState2, eVar.v1((int) (tVar.j() & 4294967295L)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar, com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar2, List list, Function1 function1, x1 x1Var) {
        s(aVar2, list, function1, x1Var, aVar);
        return Unit.INSTANCE;
    }

    private static final void s(com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar, List<com.dragon.read.kmp.story.impl.feeds.uicontext.a> list, Function1<? super com.dragon.read.kmp.story.impl.feeds.uicontext.a, Unit> function1, x1 x1Var, com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar2) {
        if (Intrinsics.areEqual(aVar2, aVar)) {
            return;
        }
        t(x1Var, list.indexOf(aVar2));
        function1.invoke(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Object obj, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, List list, v1 v1Var, Function1 function1) {
        B(coroutineScope, mutableState, mutableState2, list, v1Var, function1, obj);
        return Unit.INSTANCE;
    }

    private static final <T> void B(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<T> mutableState2, List<? extends T> list, v1 v1Var, Function1<? super T, Unit> function1, T t) {
        if (!E(mutableState) && !Intrinsics.areEqual(t, C(mutableState2))) {
            kotlinx.coroutines.i.e(coroutineScope, null, null, new ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1(list, t, mutableState, v1Var, function1, mutableState2, null), 3, null);
        }
    }

    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    private static final void r(Modifier modifier, final List<com.dragon.read.kmp.story.impl.feeds.uicontext.a> list, final com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar, final Function1<? super com.dragon.read.kmp.story.impl.feeds.uicontext.a, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        Modifier modifier4;
        int i8;
        Modifier modifier5;
        boolean z2;
        boolean z3;
        Modifier modifier6;
        Modifier modifier7;
        MutableState mutableState;
        ?? r12;
        MutableState mutableState2;
        int i9;
        com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar2;
        Modifier modifier8;
        Composer composer3;
        int i10;
        int i11;
        Object obj;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(683024579);
        int i13 = i2 & 1;
        if (i13 != 0) {
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
            if (startRestartGroup.changedInstance(list)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(aVar)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        int i14 = i3;
        int i15 = 1;
        if ((i14 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i14 & 1)) {
            if (i13 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(683024579, i14, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.ColorOptionSelector (ReadingSettingDialog.kt:424)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = c4.a(list.indexOf(aVar));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final x1 x1Var = (x1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            final x0.e eVar = (x0.e) startRestartGroup.consume(CompositionLocalsKt.f());
            Modifier f = SizeKt.f(modifier4, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(eVar);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit x;
                        x = ReadingSettingDialogKt.x(eVar, mutableState3, mutableState4, (x0.t) obj2);
                        return x;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = j1.a(f, (Function1) rememberedValue4);
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion2.d());
            w2 w2Var = w2.b;
            startRestartGroup.startReplaceGroup(1668184274);
            int i16 = 0;
            for (Object obj2 : list) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                final com.dragon.read.kmp.story.impl.feeds.uicontext.a aVar3 = (com.dragon.read.kmp.story.impl.feeds.uicontext.a) obj2;
                boolean areEqual = Intrinsics.areEqual(aVar3, aVar);
                Modifier modifier9 = Modifier.Companion;
                float f2 = 2;
                Modifier d = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.d(u2.a(w2Var, modifier9, 1.0f, false, 2, (Object) null), 0.0f, i15, (Object) null), k.g.c(x0.i.g(v(mutableState4) / f2))), aVar3.a(), (f2) null, 2, (Object) null);
                startRestartGroup.startReplaceGroup(1668194745);
                if (areEqual) {
                    i8 = i16;
                    modifier5 = androidx.compose.foundation.o.h(modifier9, x0.i.g((float) 1.3d), com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).g(), k.g.c(x0.i.g(v(mutableState4) / f2)));
                } else {
                    i8 = i16;
                    modifier5 = modifier9;
                }
                startRestartGroup.endReplaceGroup();
                Modifier then = d.then(modifier5);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                Composer.Companion companion3 = Composer.Companion;
                if (rememberedValue5 == companion3.getEmpty()) {
                    rememberedValue5 = androidx.compose.foundation.interaction.h.a();
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1224400529);
                if ((i14 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance = z2 | startRestartGroup.changedInstance(list);
                if ((i14 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changed2 = changedInstance | z3 | startRestartGroup.changed(aVar3);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed2 && rememberedValue6 != companion3.getEmpty()) {
                    modifier6 = modifier4;
                    modifier7 = modifier9;
                    mutableState = mutableState4;
                    r12 = 0;
                } else {
                    modifier6 = modifier4;
                    modifier7 = modifier9;
                    mutableState = mutableState4;
                    r12 = 0;
                    rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit y;
                            y = ReadingSettingDialogKt.y(com.dragon.read.kmp.story.impl.feeds.uicontext.a.this, aVar, list, function1, x1Var);
                            return y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier10 = ClickableKt.clickable-O2vRcR0$default(then, iVar, (androidx.compose.foundation.b1) null, false, (String) null, (Role) null, (Function0) rememberedValue6, 28, (Object) null);
                p0 i18 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), (boolean) r12);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, (int) r12));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier10);
                ComposeUiNode.Companion companion4 = ComposeUiNode.o0;
                Function0 a6 = companion4.a();
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
                g5.e(b4, i18, companion4.c());
                g5.e(b4, currentCompositionLocalMap2, companion4.e());
                Function2 b5 = companion4.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion4.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                startRestartGroup.startReplaceGroup(390761428);
                org.jetbrains.compose.resources.b bVar = aVar3.b;
                if (bVar != null) {
                    i9 = i14;
                    obj = null;
                    aVar2 = aVar3;
                    mutableState2 = mutableState;
                    modifier8 = modifier7;
                    i11 = 1;
                    i10 = i8;
                    composer3 = startRestartGroup;
                    z0.g(org.jetbrains.compose.resources.c.a(bVar, startRestartGroup, (int) r12), "主题色图标", SizeKt.D(modifier7, (androidx.compose.ui.e) null, (boolean) r12, 3, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer3, 432, 248);
                } else {
                    mutableState2 = mutableState;
                    i9 = i14;
                    aVar2 = aVar3;
                    modifier8 = modifier7;
                    composer3 = startRestartGroup;
                    i10 = i8;
                    i11 = 1;
                    obj = null;
                }
                composer3.endReplaceGroup();
                Composer composer4 = composer3;
                composer4.startReplaceGroup(390771222);
                pm4.q qVar = pm4.q.a;
                if (!qVar.a(aVar2.a) && qVar.a(aVar.a)) {
                    i12 = 6;
                    androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.f(modifier8, 0.0f, i11, obj), l0.n(l0.b.a(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (f2) null, 2, (Object) null), composer4, 6);
                } else {
                    i12 = 6;
                }
                composer4.endReplaceGroup();
                composer4.endNode();
                composer4.startReplaceGroup(1668237646);
                if (i10 < CollectionsKt__CollectionsKt.getLastIndex(list)) {
                    a3.a(SizeKt.x(modifier8, x0.i.g(16)), composer4, i12);
                }
                composer4.endReplaceGroup();
                mutableState4 = mutableState2;
                startRestartGroup = composer4;
                modifier4 = modifier6;
                i14 = i9;
                i16 = i17;
                i15 = 1;
            }
            Modifier modifier11 = modifier4;
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier11;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit z4;
                    z4 = ReadingSettingDialogKt.z(modifier3, list, aVar, function1, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    return z4;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final <T> void A(androidx.compose.ui.Modifier r46, final java.util.List<? extends T> r47, final T r48, int r49, final kotlin.jvm.functions.Function1<? super T, java.lang.String> r50, final kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r51, final boolean r52, androidx.compose.runtime.Composer r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.ReadingSettingDialogKt.A(androidx.compose.ui.Modifier, java.util.List, java.lang.Object, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}

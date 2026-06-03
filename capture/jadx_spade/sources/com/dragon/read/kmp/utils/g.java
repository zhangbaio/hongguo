package com.dragon.read.kmp.utils;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    static {
        Covode.recordClassIndex(609525);
    }

    public static final <T> MutableSharedFlow<T> k(int i) {
        return SharedFlowKt.MutableSharedFlow(0, i, BufferOverflow.DROP_LATEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(MutableState<Long> mutableState) {
        return ((Number) mutableState.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(MutableState<Long> mutableState) {
        return ((Number) mutableState.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    static final class a implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ Role c;
        final /* synthetic */ long d;
        final /* synthetic */ Function0<Unit> e;
        final /* synthetic */ MutableState<Long> f;

        a(boolean z, String str, Role role, long j, Function0<Unit> function0, MutableState<Long> mutableState) {
            this.a = z;
            this.b = str;
            this.c = role;
            this.d = j;
            this.e = function0;
            this.f = mutableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return b(modifier, composer, num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(long j, Function0 function0, MutableState mutableState) {
            long n = a1.n(a1.a, null, null, 3, null);
            if (n - g.g(mutableState) >= j) {
                function0.invoke();
                g.h(mutableState, n);
            }
            return Unit.INSTANCE;
        }

        public final Modifier b(Modifier composed, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(composed, "$this$composed");
            composer.startReplaceGroup(-457434101);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-457434101, i, -1, "com.dragon.read.kmp.utils.debounceClick.<anonymous> (ClickUtil.kt:29)");
            }
            Modifier.a aVar = Modifier.Companion;
            boolean z = this.a;
            String str = this.b;
            Role role = this.c;
            composer.startReplaceGroup(-1746271574);
            boolean changed = composer.changed(this.d) | composer.changed(this.e);
            final long j = this.d;
            final Function0<Unit> function0 = this.e;
            final MutableState<Long> mutableState = this.f;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.utils.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c;
                        c = g.a.c(j, function0, mutableState);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier then = composed.then(ClickableKt.clickable-XHw0xAI(aVar, z, str, role, (Function0) rememberedValue));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return then;
        }
    }

    static final class b implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ androidx.compose.foundation.interaction.i a;
        final /* synthetic */ androidx.compose.foundation.b1 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ Role e;
        final /* synthetic */ long f;
        final /* synthetic */ Function0<Unit> g;
        final /* synthetic */ MutableState<Long> h;

        b(androidx.compose.foundation.interaction.i iVar, androidx.compose.foundation.b1 b1Var, boolean z, String str, Role role, long j, Function0<Unit> function0, MutableState<Long> mutableState) {
            this.a = iVar;
            this.b = b1Var;
            this.c = z;
            this.d = str;
            this.e = role;
            this.f = j;
            this.g = function0;
            this.h = mutableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return b(modifier, composer, num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(long j, Function0 function0, MutableState mutableState) {
            long n = a1.n(a1.a, null, null, 3, null);
            if (n - g.i(mutableState) >= j) {
                function0.invoke();
                g.j(mutableState, n);
            }
            return Unit.INSTANCE;
        }

        public final Modifier b(Modifier composed, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(composed, "$this$composed");
            composer.startReplaceGroup(-1758196800);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1758196800, i, -1, "com.dragon.read.kmp.utils.debounceClick.<anonymous> (ClickUtil.kt:60)");
            }
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.foundation.interaction.i iVar = this.a;
            androidx.compose.foundation.b1 b1Var = this.b;
            boolean z = this.c;
            String str = this.d;
            Role role = this.e;
            composer.startReplaceGroup(-1746271574);
            boolean changed = composer.changed(this.f) | composer.changed(this.g);
            final long j = this.f;
            final Function0<Unit> function0 = this.g;
            final MutableState<Long> mutableState = this.h;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.utils.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c;
                        c = g.b.c(j, function0, mutableState);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier then = composed.then(ClickableKt.clickable-O2vRcR0(aVar, iVar, b1Var, z, str, role, (Function0) rememberedValue));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return then;
        }
    }

    public static /* synthetic */ MutableSharedFlow l(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return k(i);
    }

    public static final Modifier e(Modifier debounceClick, boolean z, long j, String str, Role role, Function0<Unit> onClick, Composer composer, int i, int i2) {
        boolean z2;
        long j2;
        String str2;
        Role role2;
        Intrinsics.checkNotNullParameter(debounceClick, "$this$debounceClick");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        composer.startReplaceGroup(-1631976381);
        if ((i2 & 1) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i2 & 2) != 0) {
            j2 = 1000;
        } else {
            j2 = j;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i2 & 8) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1631976381, i, -1, "com.dragon.read.kmp.utils.debounceClick (ClickUtil.kt:26)");
        }
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(Long.valueOf(a1.n(a1.a, null, null, 3, null) - j2), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier c = ComposedModifierKt.c(debounceClick, (Function1) null, new a(z2, str2, role2, j2, onClick, (MutableState) rememberedValue), 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return c;
    }

    public static final Modifier f(Modifier debounceClick, androidx.compose.foundation.interaction.i interactionSource, androidx.compose.foundation.b1 b1Var, boolean z, long j, String str, Role role, Function0<Unit> onClick, Composer composer, int i, int i2) {
        boolean z2;
        long j2;
        String str2;
        Role role2;
        Intrinsics.checkNotNullParameter(debounceClick, "$this$debounceClick");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        composer.startReplaceGroup(991180792);
        if ((i2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i2 & 8) != 0) {
            j2 = 1000;
        } else {
            j2 = j;
        }
        if ((i2 & 16) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i2 & 32) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(991180792, i, -1, "com.dragon.read.kmp.utils.debounceClick (ClickUtil.kt:57)");
        }
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(Long.valueOf(a1.n(a1.a, null, null, 3, null) - j2), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier c = ComposedModifierKt.c(debounceClick, (Function1) null, new b(interactionSource, b1Var, z2, str2, role2, j2, onClick, (MutableState) rememberedValue), 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return c;
    }
}

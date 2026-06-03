package com.dragon.read.kmp.mine.preference.widget;

import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.j00;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class WatchPreferencePinLayoutKt {
    static {
        Covode.recordClassIndex(607725);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(CollapsibleListState collapsibleListState, int i, Composer composer, int i2) {
        c(collapsibleListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final int d(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    public static final void c(final CollapsibleListState collapsingState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Composer startRestartGroup = composer.startRestartGroup(817605961);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(collapsingState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsingState);
            }
            if (changedInstance) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(817605961, i2, -1, "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayout (WatchPreferencePinLayout.kt:29)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final List<j00> list = watchPreferenceViewModel.a.e;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                LazyListState lazyListState = collapsingState.k().a;
                startRestartGroup.startReplaceGroup(-259675622);
                if (lazyListState != null) {
                    startRestartGroup.startReplaceGroup(-1746271574);
                    boolean changed = startRestartGroup.changed(lazyListState) | startRestartGroup.changedInstance(list);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1(lazyListState, list, mutableState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(lazyListState, (Function2) rememberedValue2, startRestartGroup, 0);
                    Unit unit = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                Modifier i4 = SizeKt.i(Modifier.Companion, x0.i.g(40));
                e.c i5 = androidx.compose.ui.e.a.i();
                e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(24));
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance2 = startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(watchPreferenceViewModel);
                if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changedInstance(collapsingState))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                boolean z3 = changedInstance2 | z2;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.mine.preference.widget.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit f;
                            f = WatchPreferencePinLayoutKt.f(list, mutableState, watchPreferenceViewModel, collapsingState, (o0) obj);
                            return f;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                androidx.compose.foundation.lazy.d.e(i4, (LazyListState) null, (i2) null, false, p, i5, (l1) null, false, (y1) null, (Function1) rememberedValue3, startRestartGroup, 221190, 462);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.preference.widget.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = WatchPreferencePinLayoutKt.g(collapsingState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(List list, MutableState mutableState, WatchPreferenceViewModel watchPreferenceViewModel, CollapsibleListState collapsibleListState, o0 LazyRow) {
        boolean z;
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                j00 j00Var = (j00) obj;
                if (d(mutableState) == i) {
                    z = true;
                } else {
                    z = false;
                }
                n0.a(LazyRow, (Object) null, (Object) null, t.c(-1452882242, true, new WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1(watchPreferenceViewModel, collapsibleListState, i, j00Var, z)), 3, (Object) null);
                i = i2;
            }
        }
        return Unit.INSTANCE;
    }
}

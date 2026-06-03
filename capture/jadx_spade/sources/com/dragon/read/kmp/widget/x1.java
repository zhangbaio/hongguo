package com.dragon.read.kmp.widget;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.rpc.model.CellViewData;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x1 {
    static {
        Covode.recordClassIndex(609664);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(x7 x7Var, int i, int i2, int i3, Composer composer, int i4) {
        e(x7Var, i, i2, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(View view) {
        return Unit.INSTANCE;
    }

    private static final int f(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final int g(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(State state, State state2, View view) {
        NsCommonDepend.IMPL.updateSearchDoubleTextLayout(view, f(state), g(state2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View h(x7 x7Var, State state, State state2, Context context) {
        String a;
        Intrinsics.checkNotNullParameter(context, "context");
        com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
        if (x7Var == null) {
            a = "";
        } else {
            gn6.a c = com.dragon.read.kmp.base.h.c();
            c.getSerializersModule();
            a = c.a(x7.Companion.serializer(), x7Var);
        }
        return NsCommonDepend.IMPL.getSearchDoubleTextLayout(context, (CellViewData) JSONUtils.fromJson(a, CellViewData.class), f(state), g(state2));
    }

    public static final void e(final x7 cellViewData, final int i, final int i2, Composer composer, final int i3) {
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        Composer startRestartGroup = composer.startRestartGroup(635118546);
        if ((i3 & 6) == 0) {
            if (startRestartGroup.changedInstance(cellViewData)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i4 = i7 | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        if ((i3 & 384) == 0) {
            if (startRestartGroup.changed(i2)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i4 |= i5;
        }
        if ((i4 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(635118546, i4, -1, "com.dragon.read.kmp.widget.SearchDoubleTextLayout (SearchDoubleTextLayout.android.kt:18)");
            }
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(i), startRestartGroup, (i4 >> 3) & 14);
            final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(i2), startRestartGroup, (i4 >> 6) & 14);
            Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changedInstance = startRestartGroup.changedInstance(cellViewData) | startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changed(rememberUpdatedState2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.widget.t1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        View h2;
                        h2 = x1.h(cellViewData, rememberUpdatedState, rememberUpdatedState2, (Context) obj);
                        return h2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.widget.u1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i8;
                        i8 = x1.i((View) obj);
                        return i8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changed(rememberUpdatedState2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.widget.v1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit j;
                        j = x1.j(rememberUpdatedState, rememberUpdatedState2, (View) obj);
                        return j;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            AndroidView_androidKt.b(function1, h, (Function1) null, function12, (Function1) rememberedValue3, startRestartGroup, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = x1.k(cellViewData, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }
}

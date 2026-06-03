package com.dragon.read.kmp.profile.guestprofile.view;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ug0;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesGuestProfilePage_androidKt {
    static {
        Covode.recordClassIndex(608174);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(ug0 ug0Var, Modifier modifier, Function0 function0, int i, Composer composer, int i2) {
        d(ug0Var, modifier, function0, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(p3 p3Var, int i, Composer composer, int i2) {
        g(p3Var, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View e(ug0 ug0Var, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NsShortVideoApi.IMPL.getRankActivityEntranceViewFromKmp(context, ug0Var);
    }

    public static final void g(final p3 state, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(-1431007110);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(state)) {
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
                ComposerKt.traceEventStart(-1431007110, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.SubscribeStateText (SeriesGuestProfilePage.android.kt:17)");
            }
            org.jetbrains.compose.resources.b bVar = state.c;
            startRestartGroup.startReplaceGroup(-808294899);
            if (bVar != null) {
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(bVar, startRestartGroup, 0), "关注", SizeKt.s(androidx.compose.foundation.layout.f2.v(Modifier.Companion, 0.0f, 0.0f, x0.i.g(3), 0.0f, 11, (Object) null), x0.i.g(10)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, state.d, 0, startRestartGroup, 432, 184);
                Unit unit = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(state.a, BackgroundKt.d(Modifier.Companion, androidx.compose.ui.graphics.l0.b.g(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), state.b, x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer2, 199728, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.o3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = SeriesGuestProfilePage_androidKt.h(p3.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    public static final void d(final ug0 ug0Var, final Modifier modifier, final Function0<Unit> reportShowEvent, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(reportShowEvent, "reportShowEvent");
        Composer startRestartGroup = composer.startRestartGroup(-1904896450);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(ug0Var)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(reportShowEvent)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        boolean z2 = false;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904896450, i6, -1, "com.dragon.read.kmp.profile.guestprofile.view.ActivityEntranceView (SeriesGuestProfilePage.android.kt:37)");
            }
            if (ug0Var != null) {
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(ug0Var);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.m3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            View e;
                            e = SeriesGuestProfilePage_androidKt.e(ug0Var, (Context) obj);
                            return e;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                AndroidView_androidKt.a((Function1) rememberedValue, modifier, (Function1) null, startRestartGroup, i6 & 112, 4);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                if ((i6 & 896) == 256) {
                    z2 = true;
                }
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new SeriesGuestProfilePage_androidKt$ActivityEntranceView$1$2$1(reportShowEvent, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue2, startRestartGroup, 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.n3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = SeriesGuestProfilePage_androidKt.f(ug0Var, modifier, reportShowEvent, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }
}

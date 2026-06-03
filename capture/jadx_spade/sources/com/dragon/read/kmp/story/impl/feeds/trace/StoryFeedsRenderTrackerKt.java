package com.dragon.read.kmp.story.impl.feeds.trace;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.x;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.w;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryFeedsRenderTrackerKt {
    static {
        Covode.recordClassIndex(609350);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(String str, Function1 function1, int i, Composer composer, int i2) {
        e(str, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x f(LazyListState lazyListState) {
        return lazyListState.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(MutableState mutableState, Function1 function1, String str, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.E1();
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState.setValue(Boolean.TRUE);
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final void e(final String pageName, final Function1<? super String, Unit> onFirstScreenRenderComplete, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        State state;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(onFirstScreenRenderComplete, "onFirstScreenRenderComplete");
        Composer startRestartGroup = composer.startRestartGroup(-987045907);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(pageName)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onFirstScreenRenderComplete)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-987045907, i2, -1, "com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsRenderTracker (StoryFeedsRenderTracker.kt:17)");
            }
            tp4.b bVar = new tp4.b("FeedsRenderTracker");
            final LazyListState c = y0.c(0, 0, startRestartGroup, 0, 3);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        x f;
                        f = StoryFeedsRenderTrackerKt.f(c);
                        return f;
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            State state2 = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed = startRestartGroup.changed(c);
            int i7 = i2 & 112;
            if (i7 == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z6 = changed | z2;
            int i8 = i2 & 14;
            if (i8 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z7 = z6 | z3;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z7 && rememberedValue3 != companion.getEmpty()) {
                i3 = i8;
                i4 = i7;
                state = state2;
            } else {
                i3 = i8;
                i4 = i7;
                state = state2;
                StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1 storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1 = new StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1(c, mutableState, onFirstScreenRenderComplete, pageName, null);
                startRestartGroup.updateRememberedValue(storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1);
                rememberedValue3 = storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$2$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(state, (Function2) rememberedValue3, startRestartGroup, 6);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed2 = startRestartGroup.changed(c);
            if (i4 == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z8 = changed2 | z4;
            if (i3 == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean changed3 = z8 | z5 | startRestartGroup.changed(bVar);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == companion.getEmpty()) {
                StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$3$1 storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$3$1 = new StoryFeedsRenderTrackerKt$StoryFeedsRenderTracker$3$1(c, mutableState, onFirstScreenRenderComplete, pageName, bVar, null);
                startRestartGroup.updateRememberedValue(storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$3$1);
                rememberedValue4 = storyFeedsRenderTrackerKt$StoryFeedsRenderTracker$3$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue4, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = StoryFeedsRenderTrackerKt.g(pageName, onFirstScreenRenderComplete, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    public static final Modifier h(Modifier modifier, final String pageName, final Function1<? super String, Unit> onRenderComplete, Composer composer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(onRenderComplete, "onRenderComplete");
        composer.startReplaceGroup(1790219716);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1790219716, i, -1, "com.dragon.read.kmp.story.impl.feeds.trace.pageRenderTracker (StoryFeedsRenderTracker.kt:56)");
        }
        new tp4.b("PageRenderTracker");
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1849434622);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j;
                    j = StoryFeedsRenderTrackerKt.j((w) obj);
                    return j;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier a = d1.a(modifier, (Function1) rememberedValue2);
        composer.startReplaceGroup(-1746271574);
        boolean z2 = false;
        if ((((i & 896) ^ 384) > 256 && composer.changed(onRenderComplete)) || (i & 384) == 256) {
            z = true;
        } else {
            z = false;
        }
        if ((((i & 112) ^ 48) > 32 && composer.changed(pageName)) || (i & 48) == 32) {
            z2 = true;
        }
        boolean z3 = z | z2;
        Object rememberedValue3 = composer.rememberedValue();
        if (z3 || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i2;
                    i2 = StoryFeedsRenderTrackerKt.i(mutableState, onRenderComplete, pageName, (androidx.compose.ui.graphics.drawscope.c) obj);
                    return i2;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier d = androidx.compose.ui.draw.i.d(a, (Function1) rememberedValue3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return d;
    }
}

package op4;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.service.e1;
import com.dragon.read.kmp.story.impl.KmpStoryPlatformHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(609334);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(String str, long j, int i, Composer composer, int i2) {
        c(str, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, long j, int i, Composer composer, int i2) {
        c(str, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void c(final String url, final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer startRestartGroup = composer.startRestartGroup(356430058);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(url)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(356430058, i2, -1, "com.dragon.read.kmp.story.impl.feeds.paging.StoryImageView (StoryImageView.kt:17)");
            }
            tp4.b bVar = new tp4.b("StoryImageView");
            bVar.d("url = " + url);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = KmpStoryPlatformHelper.a.h(url);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            String a = e1.a.a((String) rememberedValue);
            int i5 = (int) (j >> 32);
            if (Float.intBitsToFloat(i5) == 0.0f) {
                z3 = true;
            }
            if (z3) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: op4.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit d;
                            d = f.d(url, j, i, (Composer) obj, ((Integer) obj2).intValue());
                            return d;
                        }
                    });
                    return;
                }
                return;
            }
            bVar.d("parseUrl = " + a);
            LoadImageKt.g(a, "故事插图", (n) null, androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(Modifier.Companion, i.g(Float.intBitsToFloat(i5))), i.g(Float.intBitsToFloat((int) (4294967295L & j)))), k.g.c(i.g((float) 4))), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 48, 116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: op4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = f.e(url, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}

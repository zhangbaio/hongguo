package com.dragon.read.kmp.reader.download;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.state.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DownloadButtonKt {
    static {
        Covode.recordClassIndex(608408);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(DownloadUiState downloadUiState, int i, Composer composer, int i2) {
        d(downloadUiState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(DownloadUiState downloadUiState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        f(downloadUiState, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DownloadUiState a;

        a(DownloadUiState downloadUiState) {
            this.a = downloadUiState;
        }

        /* renamed from: com.dragon.read.kmp.reader.download.DownloadButtonKt$a$a, reason: collision with other inner class name */
        static final class C0048a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ DownloadUiState a;

            C0048a(DownloadUiState downloadUiState) {
                this.a = downloadUiState;
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
                        ComposerKt.traceEventStart(-46451794, i, -1, "com.dragon.read.kmp.reader.download.DownloadButton.<anonymous>.<anonymous> (DownloadButton.kt:87)");
                    }
                    DownloadButtonKt.f(this.a, null, composer, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
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
                    ComposerKt.traceEventStart(-295328577, i, -1, "com.dragon.read.kmp.reader.download.DownloadButton.<anonymous> (DownloadButton.kt:86)");
                }
                t.f(androidx.compose.runtime.internal.t.e(-46451794, true, new C0048a(this.a), composer, 54), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(CoroutineScope coroutineScope, DownloadUiState downloadUiState, cm4.i iVar) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new DownloadButtonKt$DownloadButtonContent$1$1$1$1(downloadUiState, iVar, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final void d(final DownloadUiState state, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(1074784714);
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
                ComposerKt.traceEventStart(1074784714, i2, -1, "com.dragon.read.kmp.reader.download.DownloadButton (DownloadButton.kt:84)");
            }
            ym4.f.c("DownloadButton", state, androidx.compose.runtime.internal.t.e(-295328577, true, new a(state), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.download.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = DownloadButtonKt.e(DownloadUiState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final com.dragon.read.kmp.reader.download.DownloadUiState r24, androidx.compose.ui.Modifier r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.DownloadButtonKt.f(com.dragon.read.kmp.reader.download.DownloadUiState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}

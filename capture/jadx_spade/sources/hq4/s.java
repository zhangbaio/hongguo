package hq4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final s a;
    public static final int b = 0;

    static {
        Covode.recordClassIndex(609671);
        a = new s();
    }

    private s() {
    }

    public final r a(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        composer.startReplaceGroup(1929101745);
        if ((i2 & 1) != 0) {
            j8 = og4.a.a.h(composer, 6).D();
        } else {
            j8 = j;
        }
        if ((i2 & 2) != 0) {
            j9 = og4.a.a.h(composer, 6).P0();
        } else {
            j9 = j2;
        }
        if ((i2 & 4) != 0) {
            j10 = og4.a.a.h(composer, 6).j();
        } else {
            j10 = j3;
        }
        if ((i2 & 8) != 0) {
            j11 = og4.a.a.h(composer, 6).f();
        } else {
            j11 = j4;
        }
        if ((i2 & 16) != 0) {
            j12 = og4.a.a.h(composer, 6).P0();
        } else {
            j12 = j5;
        }
        if ((i2 & 32) != 0) {
            j13 = og4.a.a.h(composer, 6).i();
        } else {
            j13 = j6;
        }
        if ((i2 & 64) != 0) {
            j14 = og4.a.a.h(composer, 6).d();
        } else {
            j14 = j7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929101745, i, -1, "com.dragon.read.kmp.widget.dialog.ConfirmDialogDefaults.colors (ConfirmDialog.kt:60)");
        }
        r rVar = new r(j8, j9, j10, j11, j12, j13, j14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rVar;
    }
}

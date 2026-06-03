package com.dragon.read.kmp.share.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    static {
        Covode.recordClassIndex(608987);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, vn4.a aVar, List list, boolean z, Function0 function0, Function0 function02, Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        b(str, aVar, list, z, function0, function02, function1, function12, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class b implements Function3<Function0<? extends Unit>, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ Function1<bh1.a, Unit> c;
        final /* synthetic */ boolean d;
        final /* synthetic */ vn4.a e;
        final /* synthetic */ Function1<Boolean, Unit> f;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z, vn4.a aVar, Function1<? super Boolean, Unit> function12) {
            this.a = str;
            this.b = list;
            this.c = function1;
            this.d = z;
            this.e = aVar;
            this.f = function12;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Function0<Unit> animatedCloseClick, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(animatedCloseClick, "animatedCloseClick");
            if ((i & 6) == 0) {
                if (composer.changedInstance(animatedCloseClick)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1210349355, i2, -1, "com.dragon.read.kmp.share.view.PostShareFullscreenView.<anonymous> (PostShareFullscreenView.kt:29)");
                }
                PostShareChannelPanelKt.c(this.a, this.b, this.c, this.d, this.e.k(), this.e.l(), animatedCloseClick, this.f, composer, 3670016 & (i2 << 18));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function4<Modifier, x0.i, Composer, Integer, Unit> {
        final /* synthetic */ vn4.a a;

        a(vn4.a aVar) {
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, x0.i iVar, Composer composer, Integer num) {
            a(modifier, iVar.m(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Modifier modifier, float f, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            if ((i & 6) == 0) {
                if (composer.changed(modifier)) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                i2 = i4 | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                if (composer.changed(f)) {
                    i3 = 32;
                } else {
                    i3 = 16;
                }
                i2 |= i3;
            }
            if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1051525631, i2, -1, "com.dragon.read.kmp.share.view.PostShareFullscreenView.<anonymous> (PostShareFullscreenView.kt:22)");
                }
                int i5 = i2 << 3;
                r.e(this.a, modifier, f, composer, (i5 & 112) | (i5 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void b(final String title, final vn4.a shareParams, final List<bh1.a> shareChannelList, final boolean z, final Function0<Unit> onMaskClick, final Function0<Unit> onCloseClick, final Function1<? super Boolean, Unit> onQrScanChange, final Function1<? super bh1.a, Unit> onClickListener, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onMaskClick, "onMaskClick");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Intrinsics.checkNotNullParameter(onQrScanChange, "onQrScanChange");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Composer startRestartGroup = composer.startRestartGroup(576585938);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(title)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i2 = i10 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(shareParams)) {
                i9 = 32;
            } else {
                i9 = 16;
            }
            i2 |= i9;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(shareChannelList)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i2 |= i8;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(z)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i2 |= i7;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onMaskClick)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i2 |= i6;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onCloseClick)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i2 |= i5;
        }
        if ((1572864 & i) == 0) {
            if (startRestartGroup.changedInstance(onQrScanChange)) {
                i4 = 1048576;
            } else {
                i4 = 524288;
            }
            i2 |= i4;
        }
        if ((12582912 & i) == 0) {
            if (startRestartGroup.changedInstance(onClickListener)) {
                i3 = 8388608;
            } else {
                i3 = 4194304;
            }
            i2 |= i3;
        }
        int i11 = i2;
        if ((4793491 & i11) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576585938, i11, -1, "com.dragon.read.kmp.share.view.PostShareFullscreenView (PostShareFullscreenView.kt:17)");
            }
            int i12 = i11 >> 12;
            composer2 = startRestartGroup;
            PostShareFullscreenPanelKt.c(onMaskClick, onCloseClick, null, androidx.compose.runtime.internal.t.e(-1051525631, true, new a(shareParams), startRestartGroup, 54), androidx.compose.runtime.internal.t.e(1210349355, true, new b(title, shareChannelList, onClickListener, z, shareParams, onQrScanChange), startRestartGroup, 54), composer2, (i12 & 112) | (i12 & 14) | 27648, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.share.view.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = l.c(title, shareParams, shareChannelList, z, onMaskClick, onCloseClick, onQrScanChange, onClickListener, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}

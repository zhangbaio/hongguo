package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.community.common.dialog.report.ReportDialogKt;
import com.dragon.read.kmp.community.common.dialog.report.y;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.g;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import pg4.p;
import pg4.t;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    private static String a;
    private static int b;

    static final class a implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ kp4.b a;
        final /* synthetic */ Function2<com.dragon.read.kmp.community.common.dialog.report.f, String, Unit> b;

        a(kp4.b bVar, Function2<? super com.dragon.read.kmp.community.common.dialog.report.f, ? super String, Unit> function2) {
            this.a = bVar;
            this.b = function2;
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.g$a$a, reason: collision with other inner class name */
        static final class C0071a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ com.dragon.read.kmp.service.g a;
            final /* synthetic */ kp4.b b;
            final /* synthetic */ Function2<com.dragon.read.kmp.community.common.dialog.report.f, String, Unit> c;

            C0071a(com.dragon.read.kmp.service.g gVar, kp4.b bVar, Function2<? super com.dragon.read.kmp.community.common.dialog.report.f, ? super String, Unit> function2) {
                this.a = gVar;
                this.b = bVar;
                this.c = function2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit d() {
                g.d();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit e() {
                g.d();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                c(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void c(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-556480643, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.showBookReportDialog.<anonymous>.<anonymous> (BookReportOption.kt:88)");
                    }
                    com.dragon.read.kmp.service.g gVar = this.a;
                    List a = com.dragon.read.kmp.community.common.dialog.report.g.a();
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    Composer.Companion companion = Composer.Companion;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.e
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit d;
                                d = g.a.C0071a.d();
                                return d;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    y yVar = new y(a, (Function0) rememberedValue);
                    kp4.b bVar = this.b;
                    Function2<com.dragon.read.kmp.community.common.dialog.report.f, String, Unit> function2 = this.c;
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit e;
                                e = g.a.C0071a.e();
                                return e;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    ReportDialogKt.z(gVar, yVar, new BookReportDialogContentViewModel(bVar, function2, (Function0) rememberedValue2), composer, com.dragon.read.kmp.service.g.b | (y.c << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            a(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(com.dragon.read.kmp.service.g dialogController, Composer composer, int i) {
            boolean z;
            boolean changedInstance;
            int i2;
            Intrinsics.checkNotNullParameter(dialogController, "dialogController");
            if ((i & 6) == 0) {
                if ((i & 8) == 0) {
                    changedInstance = composer.changed(dialogController);
                } else {
                    changedInstance = composer.changedInstance(dialogController);
                }
                if (changedInstance) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1667570316, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.showBookReportDialog.<anonymous> (BookReportOption.kt:87)");
                }
                p.e(new pg4.h((t) null, (t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-556480643, true, new C0071a(dialogController, this.a, this.b), composer, 54), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static {
        Covode.recordClassIndex(609243);
        a = "";
        b = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        if (StringsKt__StringsKt.isBlank(a)) {
            return;
        }
        KmpDialogServiceKt.h(a);
        a = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(g1 g1Var, kp4.b bVar, Function2<? super com.dragon.read.kmp.community.common.dialog.report.f, ? super String, Unit> function2) {
        d();
        a = KmpDialogServiceKt.l(g1Var, androidx.compose.runtime.internal.t.c(1667570316, true, new a(bVar, function2)));
    }
}

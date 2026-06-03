package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.g1;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.x;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x {
    private static String a;

    static final class a implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ KmpStoryFeedsVM a;
        final /* synthetic */ kp4.b b;

        a(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar) {
            this.a = kmpStoryFeedsVM;
            this.b = bVar;
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.x$a$a, reason: collision with other inner class name */
        static final class C0070a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ KmpStoryFeedsVM a;
            final /* synthetic */ kp4.b b;

            C0070a(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar) {
                this.a = kmpStoryFeedsVM;
                this.b = bVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c() {
                x.c();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                b(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void b(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-308345650, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.showReadingSettingDialog.<anonymous>.<anonymous> (ReadingSettingOption.kt:55)");
                    }
                    KmpStoryFeedsVM kmpStoryFeedsVM = this.a;
                    kp4.b bVar = this.b;
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.w
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c;
                                c = x.a.C0070a.c();
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    ReadingSettingDialogKt.P(new y(kmpStoryFeedsVM, bVar, (Function0) rememberedValue), composer, 0);
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
            Intrinsics.checkNotNullParameter(dialogController, "dialogController");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1121866045, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.showReadingSettingDialog.<anonymous> (ReadingSettingOption.kt:54)");
                }
                rp4.e.d(androidx.compose.runtime.internal.t.e(-308345650, true, new C0070a(this.a, this.b), composer, 54), composer, 6);
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
        Covode.recordClassIndex(609239);
        a = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        if (StringsKt__StringsKt.isBlank(a)) {
            return;
        }
        KmpDialogServiceKt.h(a);
        a = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g1 g1Var, kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
        c();
        a = KmpDialogServiceKt.l(g1Var, androidx.compose.runtime.internal.t.c(-1121866045, true, new a(kmpStoryFeedsVM, bVar)));
    }
}

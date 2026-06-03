package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanelKt;
import com.dragon.read.kmp.reader.ui.menu.moresettings.model.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z extends sm4.g {
    public static final int h;

    static {
        Covode.recordClassIndex(608636);
        h = sm4.g.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(int i) {
        return i == 1 ? "显示百分比" : "显示页码";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(cm4.i reader) {
        super("阅读进度设置", "", "", "read_progress");
        Intrinsics.checkNotNullParameter(reader, "reader");
        d(i(reader.f().f().j()));
        e(new Function3() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.x
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit g;
                g = z.g(z.this, (cm4.i) obj, (com.dragon.read.kmp.reader.ui.menu.ui.c) obj2, (CoroutineScope) obj3);
                return g;
            }
        });
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.y a;
        final /* synthetic */ z b;

        a(com.dragon.read.kmp.reader.ui.menu.moresettings.y yVar, z zVar) {
            this.a = yVar;
            this.b = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(z zVar, int i) {
            zVar.d(zVar.i(i));
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
                    ComposerKt.traceEventStart(1679828763, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.model.ReaderProgressItem.<anonymous>.<anonymous>.<anonymous> (ReaderProgressItem.kt:27)");
                }
                com.dragon.read.kmp.reader.ui.menu.moresettings.y yVar = this.a;
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.b);
                final z zVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.y
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit c;
                            c = z.a.c(z.this, ((Integer) obj).intValue());
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                ProgressTypePanelKt.f(yVar, (Function1) rememberedValue, composer, 0);
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
    public static final Unit g(z zVar, cm4.i reader, com.dragon.read.kmp.reader.ui.menu.ui.c panelStack, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(panelStack, "panelStack");
        Intrinsics.checkNotNullParameter(coroutineScope, "<unused var>");
        com.dragon.read.kmp.reader.ui.menu.moresettings.y yVar = new com.dragon.read.kmp.reader.ui.menu.moresettings.y(reader.f().f().j());
        panelStack.e(yVar, androidx.compose.runtime.internal.t.c(1679828763, true, new a(yVar, zVar)));
        return Unit.INSTANCE;
    }
}

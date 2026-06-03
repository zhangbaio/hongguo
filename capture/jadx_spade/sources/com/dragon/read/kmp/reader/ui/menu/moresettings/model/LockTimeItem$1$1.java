package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LockTimeItem$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.o a;
    final /* synthetic */ cm4.i b;
    final /* synthetic */ CoroutineScope c;
    final /* synthetic */ LockTimeItem d;
    final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.ui.c e;

    LockTimeItem$1$1(com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar, cm4.i iVar, CoroutineScope coroutineScope, LockTimeItem lockTimeItem, com.dragon.read.kmp.reader.ui.menu.ui.c cVar) {
        this.a = oVar;
        this.b = iVar;
        this.c = coroutineScope;
        this.d = lockTimeItem;
        this.e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(com.dragon.read.kmp.reader.ui.menu.ui.c cVar, com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar) {
        cVar.a(oVar, true);
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
                ComposerKt.traceEventStart(1911839350, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.model.LockTimeItem.<anonymous>.<anonymous> (LockTimeItem.kt:32)");
            }
            com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar = this.a;
            composer.startReplaceGroup(-1224400529);
            boolean changedInstance = composer.changedInstance(this.b) | composer.changedInstance(this.c) | composer.changedInstance(this.d) | composer.changedInstance(this.e) | composer.changed(this.a);
            final cm4.i iVar = this.b;
            final CoroutineScope coroutineScope = this.c;
            final LockTimeItem lockTimeItem = this.d;
            final com.dragon.read.kmp.reader.ui.menu.ui.c cVar = this.e;
            final com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar2 = this.a;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.o
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit d;
                        d = LockTimeItem$1$1.d(cm4.i.this, coroutineScope, lockTimeItem, cVar, oVar2, (String) obj, ((Integer) obj2).intValue());
                        return d;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function2 function2 = (Function2) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-1633490746);
            boolean changedInstance2 = composer.changedInstance(this.e) | composer.changed(this.a);
            final com.dragon.read.kmp.reader.ui.menu.ui.c cVar2 = this.e;
            final com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar3 = this.a;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.model.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit e;
                        e = LockTimeItem$1$1.e(com.dragon.read.kmp.reader.ui.menu.ui.c.this, oVar3);
                        return e;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            LockTimePickerPanelKt.l(oVar, function2, (Function0) rememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(cm4.i iVar, CoroutineScope coroutineScope, LockTimeItem lockTimeItem, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, com.dragon.read.kmp.reader.ui.menu.moresettings.o oVar, String text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        iVar.f().f().A(sm4.c.b(text));
        kotlinx.coroutines.i.e(coroutineScope, null, null, new LockTimeItem$1$1$1$1$1(null), 3, null);
        u0.a.X();
        lockTimeItem.d(text);
        cVar.a(oVar, true);
        return Unit.INSTANCE;
    }
}

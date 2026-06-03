package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookCoverSheetContentKt$BookCoverSheetContent$3$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope a;
    final /* synthetic */ n2 b;

    BookCoverSheetContentKt$BookCoverSheetContent$3$2(CoroutineScope coroutineScope, n2 n2Var) {
        this.a = coroutineScope;
        this.b = n2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        b(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(CoroutineScope coroutineScope, n2 n2Var) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new BookCoverSheetContentKt$BookCoverSheetContent$3$2$1$1$1(n2Var, null), 3, null);
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
                ComposerKt.traceEventStart(-2119887563, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContent.<anonymous>.<anonymous> (BookCoverSheetContent.kt:103)");
            }
            Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
            composer.startReplaceGroup(-1633490746);
            boolean changedInstance = composer.changedInstance(this.a) | composer.changedInstance(this.b);
            final CoroutineScope coroutineScope = this.a;
            final n2 n2Var = this.b;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c;
                        c = BookCoverSheetContentKt$BookCoverSheetContent$3$2.c(CoroutineScope.this, n2Var);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            androidx.compose.foundation.layout.m.b(ClickableKt.clickable-oSLSa3U$default(f, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}

package com.dragon.read.kmp.reader.detail.catalog;

import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.y1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3;
import com.dragon.read.kmp.reader.detail.p2;
import com.dragon.read.kmp.utils.k0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3 implements Function3<com.dragon.read.kmp.reader.detail.catalog.b, Composer, Integer, Unit> {
    final /* synthetic */ String a;
    final /* synthetic */ s b;
    final /* synthetic */ String c;
    final /* synthetic */ p2 d;
    final /* synthetic */ t3 e;

    BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3(String str, s sVar, String str2, p2 p2Var, t3 t3Var) {
        this.a = str;
        this.b = sVar;
        this.c = str2;
        this.d = p2Var;
        this.e = t3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState g() {
        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState k() {
        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final int i(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final int l(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    static final class b implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.detail.catalog.a a;
        final /* synthetic */ p2 b;
        final /* synthetic */ t3 c;

        b(com.dragon.read.kmp.reader.detail.catalog.a aVar, p2 p2Var, t3 t3Var) {
            this.a = aVar;
            this.b = p2Var;
            this.c = t3Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            b(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(p2 p2Var, com.dragon.read.kmp.reader.detail.catalog.a aVar, t3 t3Var) {
            p2.e(p2Var, aVar.a, "item", null, 4, null);
            new com.dragon.read.kmp.reader.utils.o(ig4.f.b(), aVar.a, t3Var.f, t3Var.M).i(k0.a.b()).f(null).b(aVar.b).a();
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1374791878, i, -1, "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogSheetContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookDetailCatalogDialog.kt:169)");
                }
                com.dragon.read.kmp.reader.detail.catalog.a aVar = this.a;
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance = composer.changedInstance(this.b) | composer.changed(this.a) | composer.changedInstance(this.c);
                final p2 p2Var = this.b;
                final com.dragon.read.kmp.reader.detail.catalog.a aVar2 = this.a;
                final t3 t3Var = this.c;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.b.c(p2.this, aVar2, t3Var);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                BookDetailCatalogDialogKt.o(aVar, (Function0) rememberedValue, composer, 0);
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
    public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.reader.detail.catalog.b bVar, Composer composer, Integer num) {
        f(bVar, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void f(com.dragon.read.kmp.reader.detail.catalog.b it2, Composer composer, int i) {
        Boolean bool;
        final t3 t3Var;
        final p2 p2Var;
        Intrinsics.checkNotNullParameter(it2, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1482895813, i, -1, "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogSheetContent.<anonymous>.<anonymous> (BookDetailCatalogDialog.kt:120)");
        }
        Modifier.a aVar = Modifier.Companion;
        Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
        String str = this.a;
        final s sVar = this.b;
        String str2 = this.c;
        p2 p2Var2 = this.d;
        t3 t3Var2 = this.e;
        p0 a2 = x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
        int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
        e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier e = ComposedModifierKt.e(composer, f);
        ComposeUiNode.Companion companion = ComposeUiNode.o0;
        Function0 a4 = companion.a();
        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
            androidx.compose.runtime.i.d();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(a4);
        } else {
            composer.useNode();
        }
        Composer b2 = g5.b(composer);
        g5.e(b2, a2, companion.c());
        g5.e(b2, currentCompositionLocalMap, companion.e());
        Function2 b3 = companion.b();
        if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
            b2.updateRememberedValue(Integer.valueOf(a3));
            b2.apply(Integer.valueOf(a3), b3);
        }
        g5.e(b2, e, companion.d());
        c0 c0Var = c0.b;
        Object[] objArr = {str};
        composer.startReplaceGroup(1849434622);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.Companion;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState g;
                    g = BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.g();
                    return g;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        MutableState mutableState = (MutableState) y.d.d(objArr, (Function0) rememberedValue, composer, 48);
        Object[] objArr2 = {str};
        composer.startReplaceGroup(1849434622);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState k;
                    k = BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.k();
                    return k;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        MutableState mutableState2 = (MutableState) y.d.d(objArr2, (Function0) rememberedValue2, composer, 48);
        LazyListState c = y0.c(i(mutableState), l(mutableState2), composer, 0, 0);
        composer.startReplaceGroup(-1746271574);
        boolean changed = composer.changed(c) | composer.changed(mutableState) | composer.changed(mutableState2);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion2.getEmpty()) {
            rememberedValue3 = new BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$1$1(c, mutableState, mutableState2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(c, (Function2) rememberedValue3, composer, 0);
        Boolean valueOf = Boolean.valueOf(sVar.b);
        composer.startReplaceGroup(-1224400529);
        boolean changed2 = composer.changed(mutableState) | composer.changed(mutableState2) | composer.changedInstance(sVar) | composer.changed(c);
        Object rememberedValue4 = composer.rememberedValue();
        if (!changed2 && rememberedValue4 != companion2.getEmpty()) {
            bool = valueOf;
            t3Var = t3Var2;
            p2Var = p2Var2;
        } else {
            bool = valueOf;
            t3Var = t3Var2;
            p2Var = p2Var2;
            BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1 bookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1 = new BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1(sVar, c, mutableState, mutableState2, null);
            composer.updateRememberedValue(bookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1);
            rememberedValue4 = bookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3$1$2$1;
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue4, composer, 0);
        BookDetailCatalogDialogKt.r(str2, composer, 0);
        Modifier a5 = a0.a(c0Var, SizeKt.h(aVar, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
        composer.startReplaceGroup(-1746271574);
        boolean changedInstance = composer.changedInstance(sVar) | composer.changedInstance(p2Var) | composer.changedInstance(t3Var);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance || rememberedValue5 == companion2.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.reader.detail.catalog.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h;
                    h = BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3.h(s.this, p2Var, t3Var, (o0) obj);
                    return h;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        androidx.compose.foundation.lazy.d.c(a5, c, (i2) null, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue5, composer, 0, 508);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    static final class a implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.detail.catalog.a a;

        a(com.dragon.read.kmp.reader.detail.catalog.a aVar) {
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f stickyHeader, int i, Composer composer, int i2) {
            boolean z;
            Intrinsics.checkNotNullParameter(stickyHeader, "$this$stickyHeader");
            if ((i2 & 129) != 128) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(703065533, i2, -1, "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogSheetContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BookDetailCatalogDialog.kt:162)");
                }
                BookDetailCatalogDialogKt.x(this.a, composer, 0);
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
    public static final Unit h(s sVar, p2 p2Var, t3 t3Var, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        int i = 0;
        boolean z = false;
        for (Object obj : sVar.c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.dragon.read.kmp.reader.detail.catalog.a aVar = (com.dragon.read.kmp.reader.detail.catalog.a) obj;
            if (aVar.g) {
                if (z) {
                    n0.a(LazyColumn, "volume_space_" + i, (Object) null, t.a.b(), 2, (Object) null);
                }
                n0.c(LazyColumn, "volume_" + i, (Object) null, androidx.compose.runtime.internal.t.c(703065533, true, new a(aVar)), 2, (Object) null);
                z = true;
            } else {
                n0.a(LazyColumn, "chapter_" + aVar.b + '_' + i, (Object) null, androidx.compose.runtime.internal.t.c(-1374791878, true, new b(aVar, p2Var, t3Var)), 2, (Object) null);
            }
            i = i2;
        }
        n0.a(LazyColumn, (Object) null, (Object) null, t.a.d(), 3, (Object) null);
        return Unit.INSTANCE;
    }
}

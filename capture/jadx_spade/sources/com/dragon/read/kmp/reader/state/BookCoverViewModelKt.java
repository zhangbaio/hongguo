package com.dragon.read.kmp.reader.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookCoverViewModelKt {
    private static final String a;

    static {
        Covode.recordClassIndex(608569);
        a = "BookCover-ViewModel";
    }

    public static final class a implements ViewModelProvider.Factory {
        a() {
        }

        public /* synthetic */ ViewModel create(Class cls) {
            return ViewModelProvider.Factory.-CC.$default$create(this, cls);
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
        }

        public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            cm4.i a = xf4.e.p3.a().readerLifecycleService().O().a();
            if (a != null) {
                return (T) v.a.a(a, modelClass);
            }
            throw new IllegalArgumentException("Current reader activity is null");
        }
    }

    public static final b b(Composer composer, int i) {
        CreationExtras creationExtras;
        composer.startReplaceGroup(-2058786540);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2058786540, i, -1, "com.dragon.read.kmp.reader.state.getBookCoverViewModel (BookCoverViewModel.kt:243)");
        }
        a aVar = new a();
        HasDefaultViewModelProviderFactory c = f2.b.a.c(composer, 6);
        if (c != null) {
            if (c instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = c.getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.b.a;
            }
            b bVar = (b) f2.d.c(Reflection.getOrCreateKotlinClass(b.class), c, (String) null, aVar, creationExtras, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return bVar;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    public static final State<com.dragon.read.kmp.reader.state.a> c(Composer composer, int i) {
        composer.startReplaceGroup(642100945);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642100945, i, -1, "com.dragon.read.kmp.reader.state.rememberBookCoverState (BookCoverViewModel.kt:229)");
        }
        b b = b(composer, 0);
        zl4.s sVar = zl4.s.a;
        int c = sVar.c(composer, 6);
        ReaderBgColorType a2 = sVar.a(composer, 6);
        Integer valueOf = Integer.valueOf(c);
        composer.startReplaceGroup(-1746271574);
        boolean changedInstance = composer.changedInstance(b) | composer.changed(c) | composer.changed(a2.ordinal());
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BookCoverViewModelKt$rememberBookCoverState$1$1(b, c, a2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(valueOf, a2, (Function2) rememberedValue, composer, 0);
        State<com.dragon.read.kmp.reader.state.a> state = b.b;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return state;
    }
}

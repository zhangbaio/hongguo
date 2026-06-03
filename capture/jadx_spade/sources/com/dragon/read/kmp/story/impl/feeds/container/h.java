package com.dragon.read.kmp.story.impl.feeds.container;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h implements ViewModelProvider.Factory {
    public static final int e;
    public final yo4.d a;
    public final LazyListState b;
    public final float c;
    public final CoroutineScope d;

    static {
        Covode.recordClassIndex(609257);
        e = 8;
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
        return new KmpStoryFeedsVM(this.a, this.b, this.c, this.d);
    }

    public h(yo4.d clientParam, LazyListState lazyListState, float f, CoroutineScope composeContext) {
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.a = clientParam;
        this.b = lazyListState;
        this.c = f;
        this.d = composeContext;
    }
}

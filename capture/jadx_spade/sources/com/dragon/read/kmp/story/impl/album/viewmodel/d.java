package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements ViewModelProvider.Factory {
    public static final int e;
    private final ep4.a a;
    private final LazyListState b;
    private final com.dragon.read.kmp.story.impl.album.a c;
    private final dp4.a d;

    static {
        Covode.recordClassIndex(609223);
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
        return new StoryAlbumViewModel(this.a, this.b, this.c, this.d);
    }

    public d(ep4.a storyAlbumParam, LazyListState lazyListState, com.dragon.read.kmp.story.impl.album.a depend, dp4.a dataProvider) {
        Intrinsics.checkNotNullParameter(storyAlbumParam, "storyAlbumParam");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.a = storyAlbumParam;
        this.b = lazyListState;
        this.c = depend;
        this.d = dataProvider;
    }
}

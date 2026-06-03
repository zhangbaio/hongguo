package com.dragon.read.kmp.story.impl.widget.follow;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.d6;
import com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i implements ViewModelProvider.Factory {
    public static final int d;
    public final d6 a;
    public final KmpStoryFollowViewModel.a b;
    public final String c;

    static {
        Covode.recordClassIndex(609433);
        d = 8;
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
        return new KmpStoryFollowViewModel(this.a, this.b, this.c);
    }

    public i(d6 userInfo, KmpStoryFollowViewModel.a aVar, String str) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.a = userInfo;
        this.b = aVar;
        this.c = str;
    }
}

package com.dragon.read.kmp.profile.guestprofile.aicontent;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t implements ViewModelProvider.Factory {
    static {
        Covode.recordClassIndex(608119);
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
        return new AiGeneratedVideoViewModel();
    }
}

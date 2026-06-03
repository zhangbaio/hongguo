package com.dragon.read.kmp.mine.preference.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import wj4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements ViewModelProvider.Factory {
    public static final int c;
    public final c a;
    public final wj4.a b;

    static {
        Covode.recordClassIndex(607720);
        c = 8;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    public a(c watchPreferencePageParams, wj4.a iDepend) {
        Intrinsics.checkNotNullParameter(watchPreferencePageParams, "watchPreferencePageParams");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = watchPreferencePageParams;
        this.b = iDepend;
    }

    public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new WatchPreferenceViewModel(this.a, this.b);
    }
}

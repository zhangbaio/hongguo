package com.dragon.read.leftslidepage;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f2 implements ViewModelProvider.Factory {
    public static final int c;
    public final s a;
    public final d b;

    static {
        Covode.recordClassIndex(611279);
        c = 8;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    public f2(s sidebarInfo, d funDepend) {
        Intrinsics.checkNotNullParameter(sidebarInfo, "sidebarInfo");
        Intrinsics.checkNotNullParameter(funDepend, "funDepend");
        this.a = sidebarInfo;
        this.b = funDepend;
    }

    public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new e2(this.a, this.b);
    }
}

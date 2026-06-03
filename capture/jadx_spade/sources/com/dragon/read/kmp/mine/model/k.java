package com.dragon.read.kmp.mine.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements ViewModelProvider.Factory {
    public static final int c;
    public final fk4.a a;
    public final StateFlow<fk4.c> b;

    static {
        Covode.recordClassIndex(607706);
        c = 8;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    public k(fk4.a iDepend, StateFlow<fk4.c> sidebarPageParams) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Intrinsics.checkNotNullParameter(sidebarPageParams, "sidebarPageParams");
        this.a = iDepend;
        this.b = sidebarPageParams;
    }

    public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new j(this.a, this.b);
    }
}

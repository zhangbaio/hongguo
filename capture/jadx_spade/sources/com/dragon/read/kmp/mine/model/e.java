package com.dragon.read.kmp.mine.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.mine.profile.a0;
import com.dragon.read.kmp.mine.profile.y;
import com.dragon.read.kmp.mine.profile.z;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements ViewModelProvider.Factory {
    private final a0 a;
    private final y b;
    private final z c;

    static {
        Covode.recordClassIndex(607697);
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
        return new ChangeProfilePageViewModel(this.a, this.b, this.c);
    }

    public e(a0 userInfo, y iDepend, z zVar) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = userInfo;
        this.b = iDepend;
        this.c = zVar;
    }
}

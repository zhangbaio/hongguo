package com.dragon.read.kmp.mine.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.mine.profile.ProfileItemType;
import com.dragon.read.kmp.mine.profile.a0;
import com.dragon.read.kmp.mine.profile.x;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements ViewModelProvider.Factory {
    public static final int d;
    private final a0 a;
    private final ProfileItemType b;
    private final x c;

    static {
        Covode.recordClassIndex(607693);
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
        return new ChangeProfileItemPageViewModel(this.a, this.b, this.c);
    }

    public c(a0 userInfo, ProfileItemType profileItemType, x iDepend) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = userInfo;
        this.b = profileItemType;
        this.c = iDepend;
    }
}

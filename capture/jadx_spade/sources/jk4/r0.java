package jk4;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r0 implements ViewModelProvider.Factory {
    public static final int b;
    private final l a;

    static {
        Covode.recordClassIndex(607881);
        b = 8;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    public r0(l iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = iDepend;
    }

    public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new q0(this.a);
    }
}

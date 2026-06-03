package bo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.util.kotlin.ContextKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    static {
        Covode.recordClassIndex(608996);
    }

    public static final boolean a(com.dragon.read.kmp.shortvideo.distribution.infinite.g infiniteFilterData, FilterType filterType) {
        Intrinsics.checkNotNullParameter(infiniteFilterData, "infiniteFilterData");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        new go4.c(ContextKt.getCurrentContext(), infiniteFilterData, filterType).show();
        return true;
    }
}

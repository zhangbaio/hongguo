package pn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.kmp.service.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements r {
    public static final b a;

    static {
        Covode.recordClassIndex(608903);
        a = new b();
    }

    private b() {
    }

    @Override // com.dragon.read.kmp.service.r
    public int a(float f) {
        return ContextUtils.dp2px(AppUtils.context(), f);
    }

    @Override // com.dragon.read.kmp.service.r
    public float d(float f) {
        return ContextUtils.px2dip(AppUtils.context(), f);
    }

    @Override // com.dragon.read.kmp.service.r
    public int e(float f) {
        return ScreenUtils.pxToDpInt(AppUtils.context(), f);
    }
}

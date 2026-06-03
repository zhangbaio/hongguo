package om4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.AppScaleManager;
import com.dragon.read.base.depend.y;
import com.dragon.read.base.ssconfig.template.ReaderLargeFont;
import com.dragon.read.base.ssconfig.template.ReaderLargeFontAdapt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608502);
        a = new a();
    }

    private a() {
    }

    public static final boolean b() {
        if (!y.b.needFitPadScreen() && ReaderLargeFont.a.a().catalog) {
            return true;
        }
        return false;
    }

    public static final float a() {
        if (!b()) {
            return 1.0f;
        }
        if (AppScaleManager.inst().enableSuperLarge()) {
            return ReaderLargeFontAdapt.a.b().extraLargeScale;
        }
        return AppScaleManager.inst().getScaleTimes();
    }
}

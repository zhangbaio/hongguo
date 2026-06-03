package pn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.AppFontScale;
import com.dragon.read.base.basescale.AppScaleManager;
import com.dragon.read.kmp.service.x;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements x {
    public static final c a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608905);
            int[] iArr = new int[AppFontScale.values().length];
            try {
                iArr[AppFontScale.LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppFontScale.SUPER_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppFontScale.STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608904);
        a = new c();
    }

    private c() {
    }

    @Override // com.dragon.read.kmp.service.x
    public boolean b() {
        return AppScaleManager.inst().enableLarge();
    }

    @Override // com.dragon.read.kmp.service.x
    public boolean c() {
        return AppScaleManager.inst().enableStandard();
    }

    @Override // com.dragon.read.kmp.service.x
    public boolean d() {
        return AppScaleManager.inst().enableSuperLarge();
    }

    @Override // com.dragon.read.kmp.service.x
    public com.dragon.read.kmp.base.basescale.a a() {
        int i;
        AppFontScale curAppFontScale = AppScaleManager.inst().getCurAppFontScale();
        if (curAppFontScale == null) {
            i = -1;
        } else {
            i = a.a[curAppFontScale.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return com.dragon.read.kmp.base.basescale.a.b.b();
                }
                throw new NoWhenBranchMatchedException();
            }
            return com.dragon.read.kmp.base.basescale.a.b.c();
        }
        return com.dragon.read.kmp.base.basescale.a.b.a();
    }
}

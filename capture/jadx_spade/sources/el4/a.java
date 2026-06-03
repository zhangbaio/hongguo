package el4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {

    /* renamed from: el4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0151a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608088);
            int[] iArr = new int[FilterOptionHeaderType.values().length];
            try {
                iArr[FilterOptionHeaderType.LATEST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilterOptionHeaderType.HOTTEST_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608087);
    }

    public static final String a(FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "<this>");
        int i = C0151a.a[filterOptionHeaderType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "最热";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "最新";
    }
}

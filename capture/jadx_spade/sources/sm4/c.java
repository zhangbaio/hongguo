package sm4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static final List<String> b;
    public static final int c;

    private c() {
    }

    public static final String a(int i) {
        return i != -1 ? i != 0 ? i != 900 ? i != 1800 ? i != 3600 ? "系统时间" : "60分钟" : "30分钟" : "15分钟" : "系统时间" : "常亮";
    }

    public static final int d(int i) {
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 900) {
            return 2;
        }
        if (i != 1800) {
            return i != 3600 ? 0 : 4;
        }
        return 3;
    }

    public final List<String> e() {
        return b;
    }

    static {
        Covode.recordClassIndex(608605);
        a = new c();
        ArrayList arrayList = new ArrayList();
        arrayList.add("系统时间");
        arrayList.add("常亮");
        arrayList.add("15分钟");
        arrayList.add("30分钟");
        arrayList.add("60分钟");
        b = arrayList;
        c = 8;
    }

    public final int c(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return 0;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(b.get(i), str)) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static final int b(String stringLockScreenTime) {
        Intrinsics.checkNotNullParameter(stringLockScreenTime, "stringLockScreenTime");
        switch (stringLockScreenTime.hashCode()) {
            case 767862:
                if (!stringLockScreenTime.equals("常亮")) {
                }
                break;
            case 2199677:
                if (!stringLockScreenTime.equals("15分钟")) {
                }
                break;
            case 2254454:
                if (!stringLockScreenTime.equals("30分钟")) {
                }
                break;
            case 2343827:
                if (!stringLockScreenTime.equals("60分钟")) {
                }
                break;
            case 985222914:
                stringLockScreenTime.equals("系统时间");
                break;
        }
        return 0;
    }
}

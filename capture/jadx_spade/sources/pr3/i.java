package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.PrefetchScope;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    static {
        Covode.recordClassIndex(598784);
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
    public static final int a(PrefetchScope prefetchScope) {
        Intrinsics.checkNotNullParameter(prefetchScope, "<this>");
        String scope = prefetchScope.getScope();
        switch (scope.hashCode()) {
            case -1732147403:
                if (!scope.equals("single_feed")) {
                }
                break;
            case -309425751:
                if (!scope.equals("profile")) {
                }
                break;
            case 106069776:
                scope.equals("other");
                break;
            case 2043291544:
                if (!scope.equals("bookstore")) {
                }
                break;
        }
        return 1;
    }
}

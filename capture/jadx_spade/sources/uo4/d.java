package uo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.SpringFestivalClient;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(609131);
        a = new d();
    }

    private d() {
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
    public static final vo4.b a(String actionKey) {
        Intrinsics.checkNotNullParameter(actionKey, "actionKey");
        switch (actionKey.hashCode()) {
            case -1596055788:
                if (actionKey.equals("watch_fanqie_shiji_tab")) {
                    return new vo4.b("watch_fanqie_shiji_tab", 1100034L, "浏览番茄柿集", SpringFestivalClient.a.a().taskConfig.shijiMallTabTime * 1000);
                }
                break;
            case -1234161574:
                if (actionKey.equals("watch_mall_tab")) {
                    return new vo4.b("watch_mall_tab", 1100033L, "浏览商城", SpringFestivalClient.a.a().taskConfig.polarisMallTabTime * 1000);
                }
                break;
            case -878766632:
                if (actionKey.equals("watch_short_story_tab")) {
                    return new vo4.b("watch_short_story_tab", 1100041L, "逛短篇频道", SpringFestivalClient.a.a().taskConfig.shortStoryTabTime * 1000);
                }
                break;
            case 1057235325:
                if (actionKey.equals("watch_comic_video_tab")) {
                    return new vo4.b("watch_comic_video_tab", 1100038L, "逛漫剧频道", SpringFestivalClient.a.a().taskConfig.comicTabTime * 1000);
                }
                break;
        }
        return new vo4.b("", 0L, "", 0L);
    }
}

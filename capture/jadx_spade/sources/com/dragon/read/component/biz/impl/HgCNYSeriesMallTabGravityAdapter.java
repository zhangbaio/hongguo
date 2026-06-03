package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsCNYSeriesMallTabGravityAdapter;
import com.dragon.read.widget.tab.SlidingTabLayout;
import com.dragon.read.widget.tab.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HgCNYSeriesMallTabGravityAdapter implements BsCNYSeriesMallTabGravityAdapter {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588068);
    }

    public void setTabGravityForCNY(boolean z, SlidingTabLayout slidingTab) {
        Intrinsics.checkNotNullParameter(slidingTab, "slidingTab");
        if (z) {
            int tabCount = slidingTab.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                if (slidingTab.K(i) instanceof b) {
                    b K = slidingTab.K(i);
                    Intrinsics.checkNotNull(K, "null cannot be cast to non-null type com.dragon.read.widget.tab.CustomTabView");
                    K.setContentLayoutGravity(17);
                }
            }
        }
    }
}

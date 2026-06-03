package com.dragon.read.component.biz.impl;

import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.brickservice.StaggeredActorCardService;
import com.dragon.read.util.j1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGStaggeredActorCardServiceImpl implements StaggeredActorCardService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588067);
    }

    public boolean bookCardNeedChangeScoreLocation() {
        return true;
    }

    public void applyActorNameTvStyle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        j1.a.d(textView);
    }
}

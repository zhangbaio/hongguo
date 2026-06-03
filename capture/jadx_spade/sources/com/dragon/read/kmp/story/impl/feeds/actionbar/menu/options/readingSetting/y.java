package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public static final int d;
    public final KmpStoryFeedsVM a;
    public final kp4.b b;
    public final Function0<Unit> c;

    static {
        Covode.recordClassIndex(609240);
        d = 8;
    }

    public y(KmpStoryFeedsVM viewModel, kp4.b kmpStory, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(kmpStory, "kmpStory");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.a = viewModel;
        this.b = kmpStory;
        this.c = onDismiss;
    }
}

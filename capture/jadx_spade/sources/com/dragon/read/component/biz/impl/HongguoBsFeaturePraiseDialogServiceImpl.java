package com.dragon.read.component.biz.impl;

import android.app.Activity;
import android.app.Application;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsFeaturePraiseDialogService;
import fz4.m;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoBsFeaturePraiseDialogServiceImpl implements BsFeaturePraiseDialogService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588075);
    }

    public boolean enablePraiseDialog() {
        return BsFeaturePraiseDialogService.b.a(this);
    }

    public void tryShowOnPositiveAction(String str) {
        BsFeaturePraiseDialogService.b.c(this, str);
    }

    public void registerActivityCallback(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        m.a.q(app);
    }

    public void testShow(Activity activity, String str) {
        BsFeaturePraiseDialogService.b.b(this, activity, str);
    }

    public void tryShowPraiseDialogV1(Activity activity, String str) {
        BsFeaturePraiseDialogService.b.d(this, activity, str);
    }
}

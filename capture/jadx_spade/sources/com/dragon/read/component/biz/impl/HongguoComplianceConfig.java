package com.dragon.read.component.biz.impl;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BaseComplianceConfigService;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import o03.r;
import ws2.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoComplianceConfig extends BaseComplianceConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588077);
    }

    public Single<List<r>> getPermissionSettingItems(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Single<List<r>> just = Single.just(a.a.a(context));
        Intrinsics.checkNotNullExpressionValue(just, "just(...)");
        return just;
    }
}

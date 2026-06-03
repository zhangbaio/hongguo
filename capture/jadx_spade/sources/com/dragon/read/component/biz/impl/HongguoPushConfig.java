package com.dragon.read.component.biz.impl;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsPushConfigService;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.NotificationClickedActivity;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import kotlin.jvm.internal.Intrinsics;
import qe.a;
import re.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HongguoPushConfig implements BsPushConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588083);
    }

    public void requestAnShowContentFromWidget() {
        BsPushConfigService.b.k(this);
    }

    public boolean disableReportTerminateEvent() {
        return a.a();
    }

    public boolean isPushEnable() {
        return BsPushConfigService.b.g(this);
    }

    public boolean isSupportGoogleAlert() {
        return BsPushConfigService.b.h(this);
    }

    public boolean enableNewUserPushInitOpt() {
        Boolean a = nb0.a.a(true);
        Intrinsics.checkNotNullExpressionValue(a, "enableNewUserPushInitOptHongguo(...)");
        return a.booleanValue();
    }

    public boolean enableNewUserPushInitOptSkipCheckSysSettings() {
        Boolean b = nb0.a.b(true);
        Intrinsics.checkNotNullExpressionValue(b, "enableNewUserPushInitOptSkipCheckSysHongguo(...)");
        return b.booleanValue();
    }

    public boolean enableNewUserPushPermissionOpt() {
        Boolean c = nb0.a.c(true);
        Intrinsics.checkNotNullExpressionValue(c, "enableNewUserPushPermissionOptHongguo(...)");
        return c.booleanValue();
    }

    public String getXiaomiPushActivityName() {
        String name = NotificationClickedActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public boolean isAllianceActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof b;
    }

    public boolean isXiaomiPushActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof NotificationClickedActivity;
    }

    public boolean isXiaoMiPushService(Object service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!(service instanceof MessageHandleService) && !(service instanceof PushMessageHandler)) {
            return false;
        }
        return true;
    }
}

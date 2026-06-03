package com.xiaomi.mipush.sdk;

import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SmpPushMessageHandler extends PushMessageHandler {
    static {
        Covode.recordClassIndex(655294);
    }

    public int SmpPushMessageHandler__onStartCommand$___twin___(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageHandler, com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_xiaomi_mipush_sdk_SmpPushMessageHandler_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_mipush_sdk_SmpPushMessageHandler_com_dragon_read_base_lancet_ServiceAop_onStartCommand(SmpPushMessageHandler smpPushMessageHandler, Intent intent, int i, int i2) {
        int SmpPushMessageHandler__onStartCommand$___twin___ = smpPushMessageHandler.SmpPushMessageHandler__onStartCommand$___twin___(intent, i, i2);
        boolean a = ko2.u.a(SmpPushMessageHandler__onStartCommand$___twin___, smpPushMessageHandler);
        if (a) {
            String name = smpPushMessageHandler.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a) {
            return 2;
        }
        return SmpPushMessageHandler__onStartCommand$___twin___;
    }
}

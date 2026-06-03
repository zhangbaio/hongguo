package com.vivo.push.sdk.service;

import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import ko2.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import xo2.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MainCommandClientService extends CommandClientService {
    static {
        Covode.recordClassIndex(655155);
    }

    @Override // com.vivo.push.sdk.service.CommandClientService, com.vivo.push.sdk.service.CommandService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_vivo_push_sdk_service_MainCommandClientService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    public int MainCommandClientService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_vivo_push_sdk_service_MainCommandClientService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(MainCommandClientService mainCommandClientService, Intent intent, int i, int i2) {
        int MainCommandClientService__onStartCommand$___twin___ = mainCommandClientService.MainCommandClientService__onStartCommand$___twin___(intent, i, i2);
        boolean a = u.a(MainCommandClientService__onStartCommand$___twin___, mainCommandClientService);
        if (a) {
            String name = mainCommandClientService.getClass().getName();
            j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a) {
            return 2;
        }
        return MainCommandClientService__onStartCommand$___twin___;
    }
}

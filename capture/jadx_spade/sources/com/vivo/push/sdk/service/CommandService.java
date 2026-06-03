package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.vivo.push.sdk.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.t;
import ko2.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import xo2.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CommandService extends Service {
    static {
        Covode.recordClassIndex(655154);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_vivo_push_sdk_service_CommandService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onCreate() {
        t.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        a.a().a(ContextDelegate.getContext(getApplicationContext()));
    }

    protected boolean a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        t.c("CommandService", "onBind initSuc: ");
        return null;
    }

    public int CommandService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        t.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (!a(intent.getAction())) {
            t.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
            stopSelf();
            return 2;
        }
        try {
            a.a().a(getClass().getName());
            a.a().a(intent);
        } catch (Exception e) {
            t.a("CommandService", "onStartCommand -- error", e);
        }
        stopSelf();
        return 2;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_vivo_push_sdk_service_CommandService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(CommandService commandService, Intent intent, int i, int i2) {
        int CommandService__onStartCommand$___twin___ = commandService.CommandService__onStartCommand$___twin___(intent, i, i2);
        boolean a = u.a(CommandService__onStartCommand$___twin___, commandService);
        if (a) {
            String name = commandService.getClass().getName();
            j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a) {
            return 2;
        }
        return CommandService__onStartCommand$___twin___;
    }
}

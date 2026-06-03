package com.vivo.push.sdk.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.pushmanager.setting.b;
import com.vivo.push.sdk.a;
import com.vivo.push.util.t;
import com.vv.VvPushAdapter;
import je6.e;
import ke6.g;
import ko2.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import pz0.l;
import v01.h;
import xo2.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CommandClientService extends CommandService {
    private final String TAG = "CommandClientService";

    static {
        Covode.recordClassIndex(655153);
    }

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_vivo_push_sdk_service_CommandClientService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    @Override // com.vivo.push.sdk.service.CommandService
    protected final boolean a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public IBinder onBind(Intent intent) {
        h.d("CommandClientService", "CommandClientService.onBind: intent is " + intent.toString());
        if (g.R(this)) {
            handleIntent(intent);
        }
        return super.onBind(intent);
    }

    private void handleIntent(Intent intent) {
        boolean z;
        if (intent != null) {
            h.d("CommandClientService", "CommandClientService.handleIntent: intent is " + intent.toString());
            ComponentName component = intent.getComponent();
            if (component != null) {
                h.d("CommandClientService", "CommandClientService.handleIntent: component is " + component.toString());
            }
            if (g.Y(this)) {
                l.d = true;
                boolean hasTryRegistered = VvPushAdapter.hasTryRegistered();
                h.d("CommandClientService", "[CommandClientService.onStartCommand]hasTryRegistered:" + hasTryRegistered);
                if (!hasTryRegistered) {
                    h.d("CommandClientService", "CommandClientService.handleIntent: redirect to main process ");
                    ComponentName componentName = new ComponentName(getPackageName(), MainCommandClientService.class.getName());
                    h.d("CommandClientService", "CommandClientService.onStartCommand: main process component is " + componentName.toString());
                    intent.setComponent(componentName);
                    h.d("CommandClientService", "hasWaked:" + PushServiceManager.get().getIAllianceService().hasWaked());
                    try {
                        ComponentName startService = startService(intent);
                        StringBuilder sb = new StringBuilder();
                        sb.append("startService result: ");
                        if (startService != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        sb.append(z);
                        h.d("CommandClientService", sb.toString());
                    } catch (Throwable th) {
                        h.d("CommandClientService", "startService failed , try bind : " + th.getMessage());
                        h.d("CommandClientService", "bindService result:" + bindService(intent, new ServiceConnection() { // from class: com.vivo.push.sdk.service.CommandClientService.1
                            @Override // android.content.ServiceConnection
                            public void onServiceDisconnected(ComponentName componentName2) {
                                h.d("CommandClientService", "CommandClientService: onServiceDisconnected for MainCommandClientService ");
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceConnected(ComponentName componentName2, IBinder iBinder) {
                                h.d("CommandClientService", "CommandClientService: onServiceConnected for MainCommandClientService ");
                            }
                        }, 1));
                    }
                    e.d().e(new Runnable() { // from class: com.vivo.push.sdk.service.CommandClientService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean Q0 = b.g().l().Q0();
                            h.d("CommandClientService", "killSmpAfterVvPush:" + Q0);
                            if (Q0) {
                                e.d().f(new Runnable() { // from class: com.vivo.push.sdk.service.CommandClientService.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        g.c0();
                                    }
                                }, 10000L);
                            }
                        }
                    });
                    return;
                }
                h.d("CommandClientService", "CommandClientService.onStartCommand: execute callback on smp process ");
            }
            t.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
            if (!a(intent.getAction())) {
                t.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
                return;
            }
            try {
                a.a().a(getClass().getName());
                a.a().a(intent);
            } catch (Exception e) {
                t.a("CommandService", "onStartCommand -- error", e);
            }
        }
    }

    public int CommandClientService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        h.d("CommandClientService", "CommandClientService.onStartCommand: intent is " + intent);
        handleIntent(intent);
        stopSelf();
        return 2;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_vivo_push_sdk_service_CommandClientService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(CommandClientService commandClientService, Intent intent, int i, int i2) {
        int CommandClientService__onStartCommand$___twin___ = commandClientService.CommandClientService__onStartCommand$___twin___(intent, i, i2);
        boolean a = u.a(CommandClientService__onStartCommand$___twin___, commandClientService);
        if (a) {
            String name = commandClientService.getClass().getName();
            j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a) {
            return 2;
        }
        return CommandClientService__onStartCommand$___twin___;
    }
}

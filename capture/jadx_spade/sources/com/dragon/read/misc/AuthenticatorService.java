package com.dragon.read.misc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import fs4.a;
import ko2.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import xo2.j;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AuthenticatorService extends Service {
    private a a;

    static {
        Covode.recordClassIndex(611989);
    }

    public int a(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return b(this, intent, i, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        this.a = new a(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.getIBinder();
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int b(AuthenticatorService authenticatorService, Intent intent, int i, int i2) {
        int a = authenticatorService.a(intent, i, i2);
        boolean a2 = u.a(a, authenticatorService);
        if (a2) {
            String name = authenticatorService.getClass().getName();
            j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return a;
    }
}

package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class BaseService extends Service {
    private a a;

    static {
        Covode.recordClassIndex(655257);
    }

    /* renamed from: a */
    protected abstract boolean mo78a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_xiaomi_mipush_sdk_BaseService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    public static class a extends HandlerDelegate {
        private WeakReference<BaseService> a;

        static {
            Covode.recordClassIndex(655258);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        public a(WeakReference<BaseService> weakReference) {
            this.a = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.a) != null && (baseService = weakReference.get()) != null) {
                com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.mo78a()) {
                    baseService.stopSelf();
                } else {
                    com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
                    sendEmptyMessageDelayed(1001, 1000L);
                }
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.a == null) {
            this.a = new a(new WeakReference(this));
        }
        this.a.a();
    }

    public int BaseService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (!com.xiaomi.push.j.m631a((Context) this)) {
            return 2;
        }
        return onStartCommand;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_mipush_sdk_BaseService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(BaseService baseService, Intent intent, int i, int i2) {
        int BaseService__onStartCommand$___twin___ = baseService.BaseService__onStartCommand$___twin___(intent, i, i2);
        boolean a2 = ko2.u.a(BaseService__onStartCommand$___twin___, baseService);
        if (a2) {
            String name = baseService.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return BaseService__onStartCommand$___twin___;
    }
}

package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xiaomi.push.dy;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class XMJobService extends Service {
    static Service a;

    /* renamed from: a, reason: collision with other field name */
    private IBinder f866a = null;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_xiaomi_push_service_XMJobService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }

    static {
        Covode.recordClassIndex(655632);
        a = null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f866a = new a(this).a;
        a = this;
    }

    static class a extends JobService {
        Binder a;

        /* renamed from: a, reason: collision with other field name */
        private Handler f867a;

        static {
            Covode.recordClassIndex(655633);
        }

        public int XMJobService$a__onStartCommand$___twin___(Intent intent, int i, int i2) {
            return super.onStartCommand(intent, i, i2);
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            return com_xiaomi_push_service_XMJobService$a_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
        }

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        private static class C0131a extends HandlerDelegate {
            JobService a;

            static {
                Covode.recordClassIndex(655634);
            }

            C0131a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    com.xiaomi.channel.commonutils.logger.b.m54a("Job finished " + jobParameters.getJobId());
                    this.a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        dy.a(false);
                    }
                }
            }
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Job stop " + jobParameters.getJobId());
            return false;
        }

        a(Service service) {
            this.a = null;
            this.a = (Binder) com.xiaomi.push.av.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.av.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f867a == null) {
                this.f867a = new C0131a(this);
            }
            Handler handler = this.f867a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @TargetClass(scope = Scope.ALL, value = "android.app.Service")
        @Insert(mayCreateSuper = true, value = "onStartCommand")
        public static int com_xiaomi_push_service_XMJobService$a_com_dragon_read_base_lancet_ServiceAop_onStartCommand(a aVar, Intent intent, int i, int i2) {
            int XMJobService$a__onStartCommand$___twin___ = aVar.XMJobService$a__onStartCommand$___twin___(intent, i, i2);
            boolean a = ko2.u.a(XMJobService$a__onStartCommand$___twin___, aVar);
            if (a) {
                String name = aVar.getClass().getName();
                xo2.j.a("intercept_sticky_service", "class_name", name);
                LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
            }
            if (a) {
                return 2;
            }
            return XMJobService$a__onStartCommand$___twin___;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f866a;
        if (iBinder != null) {
            return iBinder;
        }
        return new Binder();
    }

    public int XMJobService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (!com.xiaomi.push.j.m631a((Context) this)) {
            return 2;
        }
        return onStartCommand;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_push_service_XMJobService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(XMJobService xMJobService, Intent intent, int i, int i2) {
        int XMJobService__onStartCommand$___twin___ = xMJobService.XMJobService__onStartCommand$___twin___(intent, i, i2);
        boolean a2 = ko2.u.a(XMJobService__onStartCommand$___twin___, xMJobService);
        if (a2) {
            String name = xMJobService.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return XMJobService__onStartCommand$___twin___;
    }
}

package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsPushService;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ad;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a;

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f25a;

    public int MessageHandleService__onStartCommand$___twin___(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_xiaomi_mipush_sdk_MessageHandleService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    public static class a {
        private Intent a;

        /* renamed from: a, reason: collision with other field name */
        private PushMessageReceiver f27a;

        static {
            Covode.recordClassIndex(655268);
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m72a() {
            return this.f27a;
        }

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f27a = pushMessageReceiver;
            this.a = intent;
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo78a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655267);
        a = new ConcurrentLinkedQueue<>();
        f25a = new PThreadPoolExecutorDelegate(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("MessageHandleService"));
    }

    private static void b(final Context context) {
        if (!f25a.isShutdown()) {
            f25a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageHandleService.c(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, a.poll());
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MessageHandleService$1_com_dragon_read_aop_ContextAop_startService(context, intent);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a(e.getMessage());
                }
            }

            @Proxy("startService")
            @TargetClass("android.content.Context")
            public static ComponentName INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MessageHandleService$1_com_dragon_read_aop_ContextAop_startService(Context context2, Intent intent2) {
                if (!(context2 instanceof Context)) {
                    return context2.startService(intent2);
                }
                if (lz4.b.a()) {
                    lz4.b.b(context2, intent2);
                } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context2, intent2)) {
                    return null;
                }
                return context2.startService(intent2);
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    protected static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver m72a = aVar.m72a();
            Intent a2 = aVar.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && "error_lack_of_permission".equals(a2.getStringExtra("error_type")) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                        m72a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a2.getSerializableExtra("key_command");
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                m72a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), ec.COMMAND_REGISTER.f356a)) {
                    m72a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        f.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a a3 = t.a(context).a(a2);
            int intExtra2 = a2.getIntExtra("eventMessageType", -1);
            if (a3 != null) {
                if (a3 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) a3;
                    if (!miPushMessage.isArrivedMessage()) {
                        m72a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        ds.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m72a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            ds.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                        } else {
                            ds.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        m72a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    m72a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (a3 instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a3;
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    m72a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ec.COMMAND_REGISTER.f356a)) {
                        m72a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            f.b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "unknown raw message: " + a3);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a("MessageHandleService", e);
        }
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_mipush_sdk_MessageHandleService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(MessageHandleService messageHandleService, Intent intent, int i, int i2) {
        int MessageHandleService__onStartCommand$___twin___ = messageHandleService.MessageHandleService__onStartCommand$___twin___(intent, i, i2);
        boolean a2 = ko2.u.a(MessageHandleService__onStartCommand$___twin___, messageHandleService);
        if (a2) {
            String name = messageHandleService.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return MessageHandleService__onStartCommand$___twin___;
    }
}

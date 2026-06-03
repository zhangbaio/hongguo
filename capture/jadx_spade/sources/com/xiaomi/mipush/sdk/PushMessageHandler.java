package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
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
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import com.xiaomi.push.gi;
import com.xiaomi.push.ho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PushMessageHandler extends BaseService {
    private static List<MiPushClient.ICallbackResult> a;

    /* renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f39a;
    private static List<MiPushClient.MiPushClientCallback> b;

    interface a extends Serializable {
    }

    public int PushMessageHandler__onStartCommand$___twin___(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return com_xiaomi_mipush_sdk_PushMessageHandler_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i, i2);
    }

    protected static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    protected static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a, reason: collision with other method in class */
    protected boolean mo78a() {
        ThreadPoolExecutor threadPoolExecutor = f39a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f39a.getQueue().size() <= 0) ? false : true;
    }

    protected static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    protected static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m77b() {
        return b.isEmpty();
    }

    protected static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    protected static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    static {
        Covode.recordClassIndex(655288);
        a = new ArrayList();
        b = new ArrayList();
        f39a = new PThreadPoolExecutorDelegate(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("PushMessageHandler"));
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            INVOKEVIRTUAL_com_xiaomi_mipush_sdk_PushMessageHandler_com_dragon_read_aop_ContextAop_startService(context, intent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageHandler", e.getMessage());
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, c.a(context));
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageHandler", "callback sync error" + e);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }

    @Proxy("startService")
    @TargetClass("android.content.Context")
    public static ComponentName INVOKEVIRTUAL_com_xiaomi_mipush_sdk_PushMessageHandler_com_dragon_read_aop_ContextAop_startService(Context context, Intent intent) {
        if (!(context instanceof Context)) {
            return context.startService(intent);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context, intent)) {
            return null;
        }
        return context.startService(intent);
    }

    private static void c(final Context context, final Intent intent) {
        String str;
        if (intent != null && !f39a.isShutdown()) {
            f39a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.b(context, intent);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("-->scheduleJob() fail, case");
        if (intent == null) {
            str = "0";
        } else {
            str = "1";
        }
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.d("PushMessageHandler", sb.toString());
    }

    public static void a(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.m59b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    protected static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (MiPushClient.ICallbackResult iCallbackResult : a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }

    protected static void b(Context context, Intent intent) {
        boolean z;
        ResolveInfo resolveInfo;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m55a("PushMessageHandler", "intent unparcel error:" + th);
            z = false;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.m56a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gi giVar = new gi();
                ho.a(giVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.m59b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + giVar.d());
                MiTinyDataClient.upload(context, giVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m77b()) {
                    com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "receive a message before application calling initialize");
                    if (z) {
                        b(context);
                        return;
                    }
                    return;
                }
                a a2 = t.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                        while (it2.hasNext()) {
                            resolveInfo = it2.next();
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.q.a(context, resolveInfo.activityInfo.name))) {
                                break;
                            }
                        }
                    }
                    resolveInfo = null;
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, z);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        ds.a(context).a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", e);
                    ds.a(context).a(context.getPackageName(), intent, "9");
                }
            }
            if (!z) {
            }
        } catch (Throwable th2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", th2);
                ds.a(context).a(context.getPackageName(), intent, "10");
            } finally {
                if (z) {
                    b(context);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ec.COMMAND_REGISTER.f356a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!ec.COMMAND_SET_ALIAS.f356a.equals(command) && !ec.COMMAND_UNSET_ALIAS.f356a.equals(command) && !ec.COMMAND_SET_ACCEPT_TIME.f356a.equals(command)) {
                if (ec.COMMAND_SUBSCRIBE_TOPIC.f356a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                if (ec.COMMAND_UNSUBSCRIBE_TOPIC.f356a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                return;
            }
            a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it2 = b.iterator();
            while (it2.hasNext()) {
                it2.next().onInitializeResult(j, str, str2);
            }
        }
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_mipush_sdk_PushMessageHandler_com_dragon_read_base_lancet_ServiceAop_onStartCommand(PushMessageHandler pushMessageHandler, Intent intent, int i, int i2) {
        int PushMessageHandler__onStartCommand$___twin___ = pushMessageHandler.PushMessageHandler__onStartCommand$___twin___(intent, i, i2);
        boolean a2 = ko2.u.a(PushMessageHandler__onStartCommand$___twin___, pushMessageHandler);
        if (a2) {
            String name = pushMessageHandler.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return PushMessageHandler__onStartCommand$___twin___;
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.push.q.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }
}

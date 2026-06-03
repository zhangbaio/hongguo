package com.vivo.push.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.component.biz.api.NsPushService;
import com.ss.android.common.util.ToolUtils;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.vivo.push.b.n;
import com.vivo.push.d;
import com.vivo.push.i;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.t;
import com.vivo.push.v;
import java.util.List;
import lz4.b;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(654977);
    }

    @Proxy("startService")
    @TargetClass("android.content.Context")
    public static ComponentName INVOKEVIRTUAL_com_vivo_push_a_a_com_dragon_read_aop_ContextAop_startService(Context context, Intent intent) {
        if (!(context instanceof Context)) {
            return context.startService(intent);
        }
        if (b.a()) {
            b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context, intent)) {
            return null;
        }
        return context.startService(intent);
    }

    public static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                INVOKEVIRTUAL_com_vivo_push_a_a_com_dragon_read_aop_ContextAop_startService(context, intent);
                return;
            } catch (Exception e) {
                t.a("CommandBridge", "start service error", e);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        t.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, String str, v vVar) {
        String str2;
        String str3;
        boolean d = vVar.d();
        if (d) {
            str2 = "com.vivo.vms.upstageservice";
        } else {
            str2 = "com.vivo.vms.aidlservice";
        }
        i a = i.a(context, str2);
        boolean a2 = a.a();
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        if (a2 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            d dVar = new d(vVar.a(), str, new Bundle());
            vVar.a(dVar);
            if (a.a(dVar.b())) {
                return;
            }
            t.b("CommandBridge", "send command error by aidl");
            t.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        if (d) {
            str3 = "com.vivo.push.sdk.service.UpstageService";
        } else {
            str3 = "com.vivo.push.sdk.service.PushService";
        }
        intent.setClassName(str, str3);
        vVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e) {
            t.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    public static void a(Context context, n nVar, String str) {
        String str2;
        String str3;
        try {
            boolean d = aa.d(context, str);
            if (d) {
                str2 = "com.vivo.pushservice.action.RECEIVE";
            } else {
                str2 = "com.vivo.pushclient.action.RECEIVE";
            }
            if (!TextUtils.isEmpty(str)) {
                if (d || a(context, str2, str)) {
                    if (TextUtils.isEmpty(nVar.a())) {
                        nVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    if (d) {
                        str3 = "com.vivo.push.sdk.service.CommandService";
                    } else {
                        str3 = "com.vivo.push.sdk.service.CommandClientService";
                    }
                    intent.setClassName(str, str3);
                    nVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    intent.putExtra("security_avoid_pull_rsa", com.vivo.push.g.b.a().a(context).a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", ab.a(com.vivo.push.g.b.a().a(context).a()));
                    a(context, intent);
                    return;
                }
                return;
            }
            t.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e) {
            t.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            t.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            t.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}

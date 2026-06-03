package com.vivo.push.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j extends com.vivo.push.s {
    static {
        Covode.recordClassIndex(655063);
    }

    j(com.vivo.push.v vVar) {
        super(vVar);
    }

    private static List<ResolveInfo> a(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
        } catch (Exception unused) {
            list = null;
        }
        if (list == null || list.size() <= 0) {
            Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
            intent2.setPackage(context.getPackageName());
            try {
                return context.getPackageManager().queryBroadcastReceivers(intent2, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            } catch (Exception unused2) {
                return list;
            }
        }
        return list;
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (this.a.getPackageName().equals(com.vivo.push.util.aa.a(this.a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) vVar;
        int e = jVar.e();
        int f = jVar.f();
        com.vivo.push.util.t.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + e + " ; receiverStatus is " + f);
        if (e == 2) {
            Context context = this.a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "disableService push service.");
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has disabled");
                }
            } else {
                com.vivo.push.util.t.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            }
        } else if (e == 1) {
            Context context2 = this.a;
            Intent intent2 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent2.setPackage(context2.getPackageName());
            List<ResolveInfo> queryIntentServices2 = context2.getPackageManager().queryIntentServices(intent2, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            if (queryIntentServices2 != null && queryIntentServices2.size() > 0) {
                PackageManager packageManager2 = context2.getPackageManager();
                ComponentName componentName2 = new ComponentName(context2, queryIntentServices2.get(0).serviceInfo.name);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 1) {
                    packageManager2.setComponentEnabledSetting(componentName2, 1, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "enableService push service.");
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has enabled");
                }
            } else {
                com.vivo.push.util.t.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            }
        } else if (e == 0) {
            Context context3 = this.a;
            Intent intent3 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent3.setPackage(context3.getPackageName());
            List<ResolveInfo> queryIntentServices3 = context3.getPackageManager().queryIntentServices(intent3, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            if (queryIntentServices3 != null && queryIntentServices3.size() > 0) {
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, queryIntentServices3.get(0).serviceInfo.name);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 0) {
                    packageManager3.setComponentEnabledSetting(componentName3, 0, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                com.vivo.push.util.t.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (f == 2) {
            Context context4 = this.a;
            List<ResolveInfo> a = a(context4);
            if (a != null && a.size() > 0) {
                String str = a.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 2) {
                    packageManager4.setComponentEnabledSetting(componentName4, 2, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service disableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.t.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            return;
        }
        if (f == 1) {
            Context context5 = this.a;
            List<ResolveInfo> a2 = a(context5);
            if (a2 != null && a2.size() > 0) {
                String str2 = a2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager5 = context5.getPackageManager();
                ComponentName componentName5 = new ComponentName(context5, str2);
                if (packageManager5.getComponentEnabledSetting(componentName5) != 1) {
                    packageManager5.setComponentEnabledSetting(componentName5, 1, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.t.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (f == 0) {
            Context context6 = this.a;
            List<ResolveInfo> a3 = a(context6);
            if (a3 != null && a3.size() > 0) {
                String str3 = a3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager6 = context6.getPackageManager();
                ComponentName componentName6 = new ComponentName(context6, str3);
                if (packageManager6.getComponentEnabledSetting(componentName6) != 0) {
                    packageManager6.setComponentEnabledSetting(componentName6, 0, 1);
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            com.vivo.push.util.t.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}

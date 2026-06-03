package com.vivo.push.restructure.b;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.vivo.push.util.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f implements b {
    static {
        Covode.recordClassIndex(655127);
    }

    @Override // com.vivo.push.util.n
    public final List<String> a(Context context) {
        if (t.b() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: findAllCoreClientPush in main thread!", new Throwable());
        }
        List<ResolveInfo> list = null;
        if (!com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement()) {
            t.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
        } catch (Exception unused) {
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = list.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            t.d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }

    @Override // com.vivo.push.util.n
    public final boolean b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class q = l3.a.q(AppOpsManager.class.getName());
            Class<?> cls = Integer.TYPE;
            if (((Integer) q.getMethod("checkOpNoThrow", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) q.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            t.a("PushSystemRelyImpl", "isNotifySwitchOpen error", e);
            return true;
        }
    }
}

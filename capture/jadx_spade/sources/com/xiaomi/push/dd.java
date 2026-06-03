package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dd implements Application.ActivityLifecycleCallbacks {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private String f257a;
    private String b;

    static {
        Covode.recordClassIndex(655439);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private void a(String str) {
        gm gmVar = new gm();
        gmVar.a(str);
        gmVar.a(System.currentTimeMillis());
        gmVar.a(gg.ActivityActiveTimeStamp);
        dk.a(this.a, gmVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f257a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f257a) && !TextUtils.isEmpty(localClassName)) {
            this.b = "";
            if (!TextUtils.isEmpty("") && !TextUtils.equals(this.b, localClassName)) {
                this.f257a = "";
                return;
            }
            a(this.a.getPackageName() + "|" + localClassName + ":" + this.f257a + "," + String.valueOf(System.currentTimeMillis() / 1000));
            this.f257a = "";
            this.b = "";
        }
    }

    public dd(Context context, String str) {
        this.a = context;
        this.f257a = str;
    }
}

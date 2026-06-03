package com.vivo.push.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import java.util.Map;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Map b;
    final /* synthetic */ e c;

    static {
        Covode.recordClassIndex(655059);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage = INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(this.a.getPackageManager(), this.a.getPackageName());
        if (INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage != null) {
            INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage.setFlags(268435456);
            e.b(INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage, this.b);
            this.a.startActivity(INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage);
            return;
        }
        com.vivo.push.util.t.a("NotifyOpenClientTask", "LaunchIntent is null");
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_vivo_push_h_f_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    f(e eVar, Context context, Map map) {
        this.c = eVar;
        this.a = context;
        this.b = map;
    }
}

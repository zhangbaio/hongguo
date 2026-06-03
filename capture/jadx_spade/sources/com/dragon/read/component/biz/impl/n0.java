package com.dragon.read.component.biz.impl;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.article.common.monitor.stack.ExceptionMonitor;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.push.BDPush;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.template.PushProcessOpt;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.i;
import com.dragon.read.component.biz.depend.NsPushFrontierDependService;
import com.dragon.read.push.l;
import com.dragon.read.push.opt.c;
import com.dragon.read.push.opt.d;
import kotlin.jvm.internal.Intrinsics;
import m01.b;
import uz4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n0 implements i {
    public static final n0 a;
    private static final e3 b;
    public static final int c;

    private n0() {
    }

    public final e3 c() {
        return b;
    }

    public void r() {
        l.h();
    }

    public void s() {
        l.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        a.a().e();
    }

    public void x() {
        d66.a.c().onAttachBaseContext(App.context());
    }

    static {
        Covode.recordClassIndex(588087);
        a = new n0();
        b = new e3();
        c = 8;
    }

    public void t() {
        if (PushProcessOpt.a.a().enable) {
            c.r(c.a, (Context) null, 1, (Object) null);
        }
        if (NsPushFrontierDependService.IMPL.enablePushProcessDelay()) {
            d.p(d.a, (Context) null, 1, (Object) null);
        }
    }

    public boolean v(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return b.a(application);
    }

    public void w(i.a dynamicConfig) {
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        b.c(dynamicConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SettingsData settingsData) {
        LogWrapper.info("PushInitService", "onSettingsUpdate thread=%s, data=%s", new Object[]{Thread.currentThread().getName(), settingsData});
        a.a().b();
        BDPush.getPushService().updateSettings(App.context(), settingsData.getAppSettings());
    }

    public void u(boolean z) {
        try {
            SettingsManager.registerListener(new SettingsUpdateListener() { // from class: com.dragon.read.component.biz.impl.l0
                public final void onSettingsUpdate(SettingsData settingsData) {
                    n0.d(settingsData);
                }
            }, false);
        } catch (Exception e) {
            LogWrapper.e("settings 更新有异常，但不影响后续使用，error = %s", new Object[]{Log.getStackTraceString(e)});
            ExceptionMonitor.ensureNotReachHere(e);
        }
        TTExecutors.getNormalExecutor().execute(new Runnable() { // from class: com.dragon.read.component.biz.impl.m0
            @Override // java.lang.Runnable
            public final void run() {
                n0.e();
            }
        });
        App.context().registerActivityLifecycleCallbacks(new com.dragon.read.push.c());
        b.a = z;
    }
}

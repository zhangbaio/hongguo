package tr4;

import android.content.Intent;
import android.util.Log;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.settings.template.LaunchOptV613;
import com.dragon.read.base.ssconfig.settings.template.SeriesLaunchOptV709;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.component.biz.api.NsLiveECApi;
import com.dragon.read.component.biz.api.NsUgApi;
import com.dragon.read.component.biz.api.lynx.ILynxInitialize;
import com.dragon.read.component.biz.api.lynx.NsLynxApi;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.ExtractColorHost;
import com.dragon.read.util.ImageLoadHost;
import com.dragon.read.util.SetStatusBarHost;
import tr4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c {
    static {
        Covode.recordClassIndex(611948);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        NsLynxApi.Companion.getImplOrPlugin().initDevTool(false);
    }

    class a extends ILynxInitialize {
        final /* synthetic */ ILynxInitialize a;

        public void onStart() {
            LogWrapper.info("LynxInitializer", "Lynx初始化开始", new Object[0]);
            r.a.onInitStart();
            ILynxInitialize iLynxInitialize = this.a;
            if (iLynxInitialize != null) {
                iLynxInitialize.onStart();
            }
        }

        public void onSuccess() {
            if (NsCommonDepend.IMPL.isLandingSeriesMallTabByReadConfig() && SeriesLaunchOptV709.b().c("initLynx") && com.dragon.read.app.launch.apiboost.b.c()) {
                com.dragon.read.app.launch.n.H(new Runnable() { // from class: tr4.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a.this.b();
                    }
                });
            } else {
                b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            LogWrapper.info("LynxInitializer", "Lynx初始化成功", new Object[0]);
            r.a.onInitSuccess();
            NsUgApi.IMPL.getLuckyService().updateAppInfo();
            c.d();
            com.bytedance.sdk.bridge.g.i.m();
            ILynxInitialize iLynxInitialize = this.a;
            if (iLynxInitialize != null) {
                iLynxInitialize.onSuccess();
            }
            com.dragon.read.ecomtab.a.a.M(true);
            App.sendLocalBroadcast(new Intent("action_lynx_init_success"));
            NsLiveECApi.IMPL.getMonitor().a(true);
            NsLynxApi.Companion companion = NsLynxApi.Companion;
            companion.getImplOrPlugin().initLynxFont();
            companion.getImplOrPlugin().initLynxElement();
        }

        a(ILynxInitialize iLynxInitialize) {
            this.a = iLynxInitialize;
        }

        public void onError(Throwable th) {
            LogWrapper.error("LynxInitializer", "Lynx插件初始化失败: %s", new Object[]{Log.getStackTraceString(th)});
            r.a.i(-1);
            ILynxInitialize iLynxInitialize = this.a;
            if (iLynxInitialize != null) {
                iLynxInitialize.onError(th);
            }
            NsLiveECApi.IMPL.getMonitor().a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        if (DebugManager.isOfficialBuild()) {
            if (LaunchOptV613.b().enableOthers) {
                TTExecutors.getNormalExecutor().execute(new Runnable() { // from class: tr4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.e();
                    }
                });
                return;
            } else {
                NsLynxApi.Companion.getImplOrPlugin().initDevTool(false);
                return;
            }
        }
        NsLynxApi.Companion.getImplOrPlugin().initDevTool(KvCacheMgr.getPrivate(App.context(), "lynx_debug").getBoolean("is_lynx_debug", true));
    }

    public static synchronized void c(ILynxInitialize iLynxInitialize) {
        synchronized (c.class) {
            yr2.c.b();
            yr2.c.a();
            NsAdApi.IMPL.registerRifleHostService();
            ImageLoadHost.registerImageLoadHostService();
            SetStatusBarHost.registerSetStatusBarHostService();
            ExtractColorHost.registerExtractColorHostService();
            NsLynxApi.Companion.getImplOrPlugin().doInit(App.context(), new a(iLynxInitialize));
        }
    }
}

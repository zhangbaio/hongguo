package vr4;

import android.app.Application;
import android.content.Context;
import com.byted.mgl.merge.service.api.host.IAppBrandPluginInitService;
import com.bytedance.bdp.bdpbase.core.BdpPluginService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.plugin.common.IPluginLoadListener;
import com.dragon.read.plugin.common.PluginServiceManager;
import com.dragon.read.plugin.common.api.appbrand.IAppbrandInitDoneCallback;
import com.dragon.read.plugin.common.api.appbrand.IAppbrandPlugin;
import com.dragon.read.util.ToastUtils;
import kotlin.jvm.internal.Intrinsics;
import vr4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements IAppBrandPluginInitService {
    private final String a = "FanqieAppBrandPluginInitServiceImpl";

    static {
        Covode.recordClassIndex(611966);
    }

    public static final class a implements IPluginLoadListener {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ IAppBrandPluginInitService.AppBrandPluginInitCallback d;

        public void onLoadFinish(boolean z) {
            LogWrapper.info(c.this.a, "initAppBrandPlugin onLoadFinish pluginName: " + this.b + ", result: " + z, new Object[0]);
            if (z) {
                Application hostApplication = BdpManager.getInst().getService(BdpContextService.class).getHostApplication();
                if (hostApplication == null) {
                    LogWrapper.error(c.this.a, "initAppBrandPlugin application is null", new Object[0]);
                    return;
                }
                IAppbrandPlugin appBrandPlugin = PluginServiceManager.ins().getAppBrandPlugin();
                String str = this.c;
                final c cVar = c.this;
                final IAppBrandPluginInitService.AppBrandPluginInitCallback appBrandPluginInitCallback = this.d;
                appBrandPlugin.init(hostApplication, str, new IAppbrandInitDoneCallback() { // from class: vr4.b
                    public final void onComplete() {
                        c.a.b(c.this, appBrandPluginInitCallback);
                    }
                });
                return;
            }
            ToastUtils.showCommonToastSafely("插件加载中，请稍后再试");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c cVar, IAppBrandPluginInitService.AppBrandPluginInitCallback appBrandPluginInitCallback) {
            LogWrapper.info(cVar.a, "initAppBrandPlugin complete", new Object[0]);
            appBrandPluginInitCallback.onComplete();
        }

        a(String str, String str2, IAppBrandPluginInitService.AppBrandPluginInitCallback appBrandPluginInitCallback) {
            this.b = str;
            this.c = str2;
            this.d = appBrandPluginInitCallback;
        }
    }

    public void initAppBrandPlugin(Context context, String str, IAppBrandPluginInitService.AppBrandPluginInitCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String miniGamePluginName = BdpManager.getInst().getService(BdpPluginService.class).getMiniGamePluginName();
        LogWrapper.info(this.a, "initAppBrandPlugin schema: " + str + "，pluginName: " + miniGamePluginName, new Object[0]);
        PluginServiceManager.ins().tryLoadSyncWithDialog(context, miniGamePluginName, new a(miniGamePluginName, str, callback));
    }
}

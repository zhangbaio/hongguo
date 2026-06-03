package wr4;

import android.app.Application;
import com.byted.mgl.service.api.host.IMglHostAppService;
import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.bdpbase.core.BdpPluginConfig;
import com.bytedance.minigame.bdpbase.core.BdpPluginService;
import com.bytedance.minigame.bdpbase.core.IBdpPluginInstallListener;
import com.bytedance.minigame.bdpbase.manager.BdpManager;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.plugin.common.IPluginEventListener;
import com.dragon.read.plugin.common.PluginServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements BdpPluginService {
    public static final int e;
    private IBdpPluginInstallListener b;
    private final String a = "BdpPluginServiceImpl";
    private final String c = "com.dragon.read.plugin.minigame";
    private final IPluginEventListener d = new C0289a();

    static {
        Covode.recordClassIndex(611970);
        e = 8;
    }

    public Application getHostApplication() {
        Application hostApplication = BdpManager.getInst().getService(IMglHostAppService.class).getHostApplication();
        Intrinsics.checkNotNullExpressionValue(hostApplication, "getHostApplication(...)");
        return hostApplication;
    }

    /* renamed from: wr4.a$a, reason: collision with other inner class name */
    public static final class C0289a implements IPluginEventListener {
        C0289a() {
        }

        public void onPluginLoaded(String s) {
            Intrinsics.checkNotNullParameter(s, "s");
            IBdpPluginInstallListener iBdpPluginInstallListener = a.this.b;
            if (Intrinsics.areEqual(a.this.c, s) && iBdpPluginInstallListener != null) {
                iBdpPluginInstallListener.onSuccess();
            }
        }

        public void onPluginInstallResult(String s, boolean z) {
            Intrinsics.checkNotNullParameter(s, "s");
            IBdpPluginInstallListener iBdpPluginInstallListener = a.this.b;
            if (iBdpPluginInstallListener != null && Intrinsics.areEqual(a.this.c, s)) {
                if (z) {
                    iBdpPluginInstallListener.onSuccess();
                } else {
                    iBdpPluginInstallListener.onFailed(false);
                }
            }
        }
    }

    public boolean isPluginReady(String pluginName) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        return PluginServiceManager.ins().isPluginInstalled(pluginName);
    }

    public void install(BdpPluginConfig bdpPluginConfig) {
        if (bdpPluginConfig != null) {
            this.b = bdpPluginConfig.getListener();
            PluginServiceManager.ins().tryLoadSync(bdpPluginConfig.getPackageName());
        }
        PluginServiceManager.ins().registerPluginEventListener(this.d);
    }

    public Class<?> loadClass(String moduleName, String className) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            return l3.a.q(className);
        } catch (ClassNotFoundException e2) {
            LogWrapper.e(this.a, new Object[]{"loadClass:  ClassNotFoundException " + e2});
            return null;
        }
    }

    public Class<?> loadPluginClass(String pluginName, String className) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            return l3.a.q(className);
        } catch (ClassNotFoundException e2) {
            LogWrapper.e(this.a, new Object[]{" class.forName Failed " + e2});
            return null;
        }
    }

    public boolean isPluginReady(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        return isPluginReady(str);
    }
}

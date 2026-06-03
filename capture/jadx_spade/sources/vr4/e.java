package vr4;

import android.app.Application;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.ProcessUtil;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.plugin.common.PluginServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final String[] b;
    private static final AtomicBoolean c;
    public static final int d;

    private e() {
    }

    static {
        Covode.recordClassIndex(611969);
        a = new e();
        b = new String[]{"bytenn", "kryptoneffect", "kryptonogg"};
        c = new AtomicBoolean(false);
        d = 8;
    }

    public static final void a() {
        Application hostApplication = BdpManager.getInst().getService(BdpContextService.class).getHostApplication();
        if (hostApplication == null) {
            return;
        }
        if (!ProcessUtil.isMiniAppProcess(hostApplication)) {
            LogWrapper.info("PluginSoLoadHelper", "need minigame process", new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("plugin so load init start ");
        AtomicBoolean atomicBoolean = c;
        sb.append(atomicBoolean.get());
        LogWrapper.info("PluginSoLoadHelper", sb.toString(), new Object[0]);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String nativeLibraryDir = PluginServiceManager.ins().getNativeLibraryDir("com.dragon.read.plugin.minigame", PluginServiceManager.ins().getPluginVersionCodeSafely("com.dragon.read.plugin.minigame"));
                for (String str : b) {
                    System.load(nativeLibraryDir + '/' + System.mapLibraryName(str));
                }
                LogWrapper.info("PluginSoLoadHelper", "plugin so load init end", new Object[0]);
            } catch (Throwable th) {
                LogWrapper.error("OpenMiniGameAction", "host load so error " + th.getMessage(), new Object[0]);
            }
        }
    }
}

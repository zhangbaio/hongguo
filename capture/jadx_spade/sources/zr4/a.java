package zr4;

import android.os.Build;
import android.util.SparseArray;
import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.serviceapi.hostimpl.info.BdpHostInfo;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.dragon.read.app.App;
import com.dragon.read.mgl.service.shortcut.MglShortCutActivity;
import com.dragon.read.util.AbiUtil;
import com.ss.android.common.applog.TeaAgent;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements BdpHostInfo {
    public static final int b;
    private final AppCommonContext a = (AppCommonContext) ServiceManager.getService(AppCommonContext.class);

    static {
        Covode.recordClassIndex(611974);
        b = 8;
    }

    public String getDevicePlatform() {
        return "Android";
    }

    public String getFeedbackKey() {
        return "novelapp_android";
    }

    public long getHostStartUpElapsedRealtime() {
        return 0L;
    }

    public String getPluginVersion() {
        return "";
    }

    public String getUaName() {
        return "";
    }

    public String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public SparseArray<String> extraInfo() {
        return new SparseArray<>();
    }

    public String getDeviceId() {
        return TeaAgent.getServerDeviceId();
    }

    public String getHostAbi() {
        return AbiUtil.getHostAbi();
    }

    public String getInstallId() {
        return TeaAgent.getInstallId();
    }

    public String getShortcutClassName() {
        return MglShortCutActivity.class.getName();
    }

    public String getAppName() {
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext != null) {
            return appCommonContext.getAppName();
        }
        return null;
    }

    public String getChannel() {
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext != null) {
            return appCommonContext.getChannel();
        }
        return null;
    }

    public String getVersionName() {
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext != null) {
            return appCommonContext.getVersion();
        }
        return null;
    }

    public String getAppId() {
        String num;
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext == null || (num = Integer.valueOf(appCommonContext.getAid()).toString()) == null) {
            return "";
        }
        return num;
    }

    public String getFileProvider() {
        return App.context().getPackageName() + ".file_provider";
    }

    public String getUpdateVersionCode() {
        String num;
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext == null || (num = Integer.valueOf(appCommonContext.getUpdateVersionCode()).toString()) == null) {
            return "";
        }
        return num;
    }

    public String getVersionCode() {
        String num;
        AppCommonContext appCommonContext = this.a;
        if (appCommonContext == null || (num = Integer.valueOf(appCommonContext.getVersionCode()).toString()) == null) {
            return "";
        }
        return num;
    }

    public boolean isDebugMode() {
        return x10.a.b(((AppCommonContext) ServiceManager.getService(AppCommonContext.class)).getContext());
    }
}

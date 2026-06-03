package vr4;

import android.app.Application;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.service.init.AbsBdpGlobalInitializerService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.covode.number.Covode;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.plugin.common.api.minigame.IMiniGameHostSettingConfigService;
import com.ss.android.common.util.ToolUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends AbsBdpGlobalInitializerService {
    public static final a b;
    public static final int c;

    public static final class a {
        static {
            Covode.recordClassIndex(611968);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611967);
        b = new a(null);
        c = 8;
    }

    public void onInit() {
        boolean contains$default;
        boolean z;
        Application hostApplication = BdpManager.getInst().getService(BdpContextService.class).getHostApplication();
        if (hostApplication == null) {
            return;
        }
        String curProcessName = ToolUtils.getCurProcessName(hostApplication);
        IMiniGameHostSettingConfigService iMiniGameHostSettingConfigService = (IMiniGameHostSettingConfigService) ServiceManager.getService(IMiniGameHostSettingConfigService.class);
        Intrinsics.checkNotNull(curProcessName);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) curProcessName, (CharSequence) ":minigame", false, 2, (Object) null);
        if (contains$default) {
            if (iMiniGameHostSettingConfigService != null && iMiniGameHostSettingConfigService.isJumpOverCookieInit()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                NetworkParams.setCookieMgrInited(true);
                LogWrapper.info("tma_minigame_init", "setCookieMgrInited:  true    " + curProcessName, new Object[0]);
            }
        }
        e.a();
    }
}

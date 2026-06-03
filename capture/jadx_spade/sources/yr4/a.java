package yr4;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.byted.mgl.service.api.common.MglTechType;
import com.byted.mgl.service.api.host.IMglHostAppService;
import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.bdpbase.schema.SchemaInfo;
import com.bytedance.minigame.serviceapi.hostimpl.info.BdpHostInfo;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.dragon.read.app.ActivityRecordManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements IMglHostAppService {
    static {
        Covode.recordClassIndex(611973);
    }

    public String getMglPluginPkg(SchemaInfo schemaInfo, MglTechType mglTechType) {
        return "com.dragon.read.plugin.minigame";
    }

    public JSONObject getSpecialConfig() {
        return null;
    }

    public BdpHostInfo getHostInfo() {
        return new zr4.a();
    }

    public Activity getHostActivity() {
        return ActivityRecordManager.inst().getCurrentVisibleActivity();
    }

    public Application getHostApplication() {
        Context applicationContext = ((AppCommonContext) ServiceManager.getService(AppCommonContext.class)).getContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }
}

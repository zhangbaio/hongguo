package us4;

import android.app.Activity;
import android.content.Context;
import com.bytedance.apm.ApmAgent;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.NsUtilsDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.util.DebugManager;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements ct5.d {
    public static final d a;

    static {
        Covode.recordClassIndex(612510);
        a = new d();
    }

    private d() {
    }

    public Context getAppContext() {
        return App.context();
    }

    public boolean isLowDevice() {
        return NsUtilsDepend.IMPL.isLowDevice();
    }

    public boolean isMiddleLowDevice() {
        return NsUtilsDepend.IMPL.isMiddleLowDevice();
    }

    public boolean isOfficialBuild() {
        return DebugManager.isOfficialBuild();
    }

    public ct5.b b() {
        b e = b.e();
        Intrinsics.checkNotNullExpressionValue(e, "getInstance(...)");
        return e;
    }

    public Activity getCurrentVisibleActivity() {
        return ActivityRecordManager.inst().getCurrentVisibleActivity();
    }

    public boolean isCurrentPlayerPlaying() {
        return NsCommonDepend.IMPL.audioPlayManager().isCurrentPlayerPlaying();
    }

    public String c(SimpleMediaView simpleMediaView) {
        return e.c(simpleMediaView);
    }

    public boolean a(SimpleMediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        if (e.d(mediaView) && mediaView.isPlayCompleted()) {
            return true;
        }
        return false;
    }

    public void monitorEvent(String serviceName, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        ApmAgent.monitorEvent(serviceName, jSONObject, jSONObject2, jSONObject3);
    }
}

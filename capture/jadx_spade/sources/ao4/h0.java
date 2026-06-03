package ao4;

import android.content.Intent;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.dragon.read.app.App;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.ToastUtils;
import com.ss.android.common.util.ToolUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 extends a {
    static {
        Covode.recordClassIndex(608984);
    }

    @Override // ao4.a
    public boolean a() {
        if (!ToolUtils.isInstalledApp(App.context(), "com.xingin.xhs") && !ToolUtils.isInstalledApp(App.context(), "com.xingin.xhs.lite")) {
            return false;
        }
        return true;
    }

    @Override // ao4.a
    public void b(un4.e kmpShareContent) {
        boolean z;
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        if (kmpShareContent.a != 2) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        String str = kmpShareContent.e;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        tq1.g.b(App.context(), qn4.a.a.b(ShareChannelType.IMAGE_SHARE, str).f());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("xhsdiscover://post/"));
        intent.setFlags(268435456);
        ContextUtils.startActivity(App.context(), intent);
    }
}

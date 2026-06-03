package ao4;

import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.dragon.read.app.App;
import com.dragon.read.util.ToastUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends a {
    static {
        Covode.recordClassIndex(608979);
    }

    @Override // ao4.a
    public boolean a() {
        return true;
    }

    @Override // ao4.a
    public void b(un4.e kmpShareContent) {
        boolean z;
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        if (kmpShareContent.a == 2) {
            String str = kmpShareContent.e;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
                return;
            } else {
                tq1.g.b(App.context(), qn4.a.a.b(ShareChannelType.IMAGE_SHARE, str).f());
                return;
            }
        }
        ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
    }
}

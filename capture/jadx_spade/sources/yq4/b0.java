package yq4;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public static final int f;
    public final View a;
    public final View b;
    public final ProgressBar c;
    public final TextView d;
    public final int e;

    static {
        Covode.recordClassIndex(611405);
        f = 8;
    }

    public b0(View toastView, View toastContent, ProgressBar progressBar, TextView msgTv, int i) {
        Intrinsics.checkNotNullParameter(toastView, "toastView");
        Intrinsics.checkNotNullParameter(toastContent, "toastContent");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(msgTv, "msgTv");
        this.a = toastView;
        this.b = toastContent;
        this.c = progressBar;
        this.d = msgTv;
        this.e = i;
    }
}

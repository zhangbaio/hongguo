package cr3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tq3.e0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class b extends e0 {
    public static final a d;

    public static final class a {
        static {
            Covode.recordClassIndex(598704);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598703);
        d = new a(null);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e(boolean z) {
    }

    public void f(SaasVideoData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void g(Bundle data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void h(boolean z) {
    }

    public void update(int i, boolean z, String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
    }

    public void update(boolean z, boolean z2) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, ViewGroup.LayoutParams layoutParams, HashMap<String, String> extra) {
        super(view, layoutParams, extra);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(extra, "extra");
    }
}

package tq3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class e0 {
    public final View a;
    public final ViewGroup.LayoutParams b;
    public final HashMap<String, String> c;

    static {
        Covode.recordClassIndex(598661);
    }

    public void a(int i) {
    }

    public e0(View view, ViewGroup.LayoutParams layoutParams, HashMap<String, String> extra) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.a = view;
        this.b = layoutParams;
        this.c = extra;
    }
}

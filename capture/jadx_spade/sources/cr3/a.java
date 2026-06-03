package cr3;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a<T> extends AbsRecyclerViewHolder<T> {
    public boolean d;

    static {
        Covode.recordClassIndex(598702);
    }

    public void A2(float f, int i) {
    }

    public void w2() {
        this.d = true;
    }

    public void x2() {
        this.d = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }
}

package vs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.nps.ui.b1;
import com.dragon.read.rpc.model.OptionInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends b1 {
    public static final int k;
    private final b1.a j;

    static {
        Covode.recordClassIndex(612543);
        k = 8;
    }

    @Override // com.dragon.read.nps.ui.b1
    public b1.a F3() {
        return this.j;
    }

    @Override // com.dragon.read.nps.ui.b1
    public int getItemCount() {
        int i;
        List list;
        OptionInfo optionInfo = this.e;
        if (optionInfo != null && (list = optionInfo.optionsName) != null) {
            i = list.size();
        } else {
            i = 0;
        }
        return i + 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b1.a listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.j = listener;
    }
}

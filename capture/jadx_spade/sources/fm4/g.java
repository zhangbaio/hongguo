package fm4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements c {
    public static final g a;

    static {
        Covode.recordClassIndex(608459);
        a = new g();
    }

    private g() {
    }

    @Override // fm4.c
    public i a() {
        NsReaderActivity topReaderActivity = NsReaderServiceApi.IMPL.readerLifecycleService().O().getTopReaderActivity();
        if (topReaderActivity != null) {
            return topReaderActivity.h2();
        }
        return null;
    }
}

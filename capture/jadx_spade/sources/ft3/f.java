package ft3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.depend.context.App;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(599205);
    }

    public static final String a(int i) {
        try {
            String string = App.context().getString(i);
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }
}

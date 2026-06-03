package as4;

import com.bytedance.covode.number.Covode;
import com.bytedance.minigame.serviceapi.defaults.log.BdpLogService;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements BdpLogService {
    public static final int b;
    private boolean a = true;

    static {
        Covode.recordClassIndex(611975);
        b = 8;
    }

    public void flush() {
    }

    public void isEnabled(boolean z) {
        this.a = z;
    }

    public void d(String tag, String messages) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (this.a) {
            LogWrapper.debug(tag, messages, new Object[0]);
        }
    }

    public void e(String tag, String messages) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (this.a) {
            LogWrapper.error(tag, messages, new Object[0]);
        }
    }

    public void i(String tag, String messages) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (this.a) {
            LogWrapper.info(tag, messages, new Object[0]);
        }
    }

    public void w(String tag, String messages) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (this.a) {
            LogWrapper.warn(tag, messages, new Object[0]);
        }
    }
}

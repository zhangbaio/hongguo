package zl4;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608247);
    }

    public static final qg4.n a(int i) {
        if (i == 5) {
            return qg4.d.a;
        }
        return qg4.l.a;
    }

    public static final b b(int i) {
        switch (i) {
            case 2:
                return t.a;
            case 3:
                return g.a;
            case 4:
                return a.a;
            case 5:
                return d.a;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return e.a;
            case 7:
                return f.a;
            default:
                return h.a;
        }
    }
}

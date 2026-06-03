package em6;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e {
    static {
        Covode.recordClassIndex(656163);
    }

    public static int a(Context context, int i) {
        int round = Math.round(context.getResources().getDisplayMetrics().widthPixels / i);
        if (round == 0) {
            return 1;
        }
        return round;
    }
}

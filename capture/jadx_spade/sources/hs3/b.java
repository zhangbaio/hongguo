package hs3;

import android.view.View;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {

    public static final class a {
        static {
            Covode.recordClassIndex(598903);
        }

        public static void a(b bVar, Function0<Unit> function0) {
        }
    }

    void a(Function0<Unit> function0);

    View asView();

    void dismiss();

    void show();
}

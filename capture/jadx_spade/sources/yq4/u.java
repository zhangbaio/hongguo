package yq4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface u {
    void L();

    b0 M();

    void N();

    void O(Context context, String str, String str2, Function0<Unit> function0, Function1<? super Boolean, Unit> function1);

    void showToast(String str);

    void y(String str);

    public static final class a {
        static {
            Covode.recordClassIndex(611388);
        }

        public static /* synthetic */ void a(u uVar, Context context, String str, String str2, Function0 function0, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    function1 = null;
                }
                uVar.O(context, str, str2, function0, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showActionToast");
        }
    }
}

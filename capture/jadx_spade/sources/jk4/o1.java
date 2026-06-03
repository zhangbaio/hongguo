package jk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.UserResearchOptionInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface o1 {

    public static final class a {
        static {
            Covode.recordClassIndex(607891);
        }

        public static void a(o1 o1Var, List<String> editContent) {
            Intrinsics.checkNotNullParameter(editContent, "editContent");
        }
    }

    String G();

    UserResearchOptionInfo S();

    void W(List<String> list);

    void X(String str);

    List<s0> a0();

    void j(s0 s0Var);
}

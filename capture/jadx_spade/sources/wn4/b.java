package wn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {

    public static final class a {
        static {
            Covode.recordClassIndex(608948);
        }

        public static void a(b bVar, String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        }
    }

    void C(String str, List<bh1.a> list, Function1<? super bh1.a, Unit> function1);

    void dismiss(String str);

    void init(Function1<? super String, Unit> function1);

    void show();
}

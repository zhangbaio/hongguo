package wn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wn4.b;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a extends b {
    un4.h x();

    /* renamed from: wn4.a$a, reason: collision with other inner class name */
    public static final class C0288a {
        static {
            Covode.recordClassIndex(608946);
        }

        public static void a(a aVar, String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            b.a.a(aVar, title, shareChannelList, onClickListener);
        }
    }
}

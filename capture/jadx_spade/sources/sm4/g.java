package sm4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g extends h {
    public static final int g;
    private final MutableState e;
    public Function3<? super cm4.i, ? super com.dragon.read.kmp.reader.ui.menu.ui.c, ? super CoroutineScope, Unit> f;

    static {
        Covode.recordClassIndex(608612);
        g = 8;
    }

    public final String b() {
        return (String) this.e.getValue();
    }

    public final void e(Function3<? super cm4.i, ? super com.dragon.read.kmp.reader.ui.menu.ui.c, ? super CoroutineScope, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f = function3;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(cm4.i iVar, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(iVar, "<unused var>");
        Intrinsics.checkNotNullParameter(cVar, "<unused var>");
        Intrinsics.checkNotNullParameter(coroutineScope, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String name, String str, String reportContent, String type) {
        super(name, str, reportContent, type);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.e = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = new Function3() { // from class: sm4.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit c;
                c = g.c((cm4.i) obj, (com.dragon.read.kmp.reader.ui.menu.ui.c) obj2, (CoroutineScope) obj3);
                return c;
            }
        };
    }
}

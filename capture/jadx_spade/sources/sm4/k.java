package sm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k extends h {
    public static final int g;
    public boolean e;
    public Function3<? super Boolean, ? super Context, ? super CoroutineScope, Unit> f;

    static {
        Covode.recordClassIndex(608616);
        g = 8;
    }

    public final void c(Function3<? super Boolean, ? super Context, ? super CoroutineScope, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(boolean z, Context context, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String name, String str, String reportContent, String type) {
        super(name, str, reportContent, type);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.e = true;
        this.f = new Function3() { // from class: sm4.j
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit b;
                b = k.b(((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                return b;
            }
        };
    }
}

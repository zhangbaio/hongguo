package jk4;

import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.kmp.nps.DoubleColSimilarNpsModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t1 extends com.dragon.read.kmp.base.b<DoubleColSimilarNpsModel, f1> {
    public static final int A;
    private final q64.r x;
    private final az2.c y;
    private final Lazy z;

    static {
        Covode.recordClassIndex(607894);
        A = 8;
    }

    /* renamed from: f5, reason: merged with bridge method [inline-methods] */
    public q1 b5() {
        return (q1) this.z.getValue();
    }

    protected void r4() {
        super/*u64.l*/.r4();
        b5().L0();
        q1.b1(b5(), null, 1, null);
        b5().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i5(t1 t1Var) {
        t1Var.T3();
        return Unit.INSTANCE;
    }

    public Args a5(int i) {
        Args a5 = super.a5(i);
        a5.put("unlimited_content_type", "nps");
        return a5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q1 j5(t1 t1Var) {
        return new ViewModelProvider(((com.dragon.read.kmp.base.b) t1Var).v).get(Reflection.getOrCreateKotlinClass(q1.class));
    }

    /* renamed from: h5, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void onBind(DoubleColSimilarNpsModel data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.m4(data, i);
        b5().d1(new Function0() { // from class: jk4.r1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit i5;
                i5 = t1.i5(t1.this);
                return i5;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(ViewGroup parent, q64.r staggeredFeedDepend, az2.c viewModelService) {
        super(parent, staggeredFeedDepend, viewModelService);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(staggeredFeedDepend, "staggeredFeedDepend");
        Intrinsics.checkNotNullParameter(viewModelService, "viewModelService");
        this.x = staggeredFeedDepend;
        this.y = viewModelService;
        ((com.dragon.read.kmp.base.b) this).v.setContent(a.a.a());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: jk4.s1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                q1 j5;
                j5 = t1.j5(t1.this);
                return j5;
            }
        });
        this.z = lazy;
    }
}

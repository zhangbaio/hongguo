package jk4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.compose.NovelComposeHolderView;
import com.dragon.read.kmp.nps.DoubleColSimilarNpsModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x1 extends u64.l<DoubleColSimilarNpsModel> {
    public static final int x;
    private final q64.r t;
    private final Function1<String, Unit> u;
    public final NovelComposeHolderView<f1> v;
    public final y w;

    static {
        Covode.recordClassIndex(607895);
        x = 8;
    }

    protected void r4() {
        super.r4();
        this.w.L0();
        q1.b1(this.w, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h5(x1 x1Var) {
        x1Var.T3();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c5(x1 x1Var) {
        String str;
        Function1<String, Unit> function1 = x1Var.u;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = x1Var.w.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    public final Args d5(int i) {
        Args args = new Args();
        args.put("card_left_right_position", F3());
        args.put("rank", Integer.valueOf(i));
        args.put("display_card", "dual_column_card");
        args.put("category_tab_type", Integer.valueOf(v64.a.h(this.t)));
        args.put("tab_name", "store");
        args.put("module_name", "无限流");
        args.put("position", "related_content");
        args.put("unlimited_content_type", "nps");
        args.put("src_material_id", this.w.k);
        return args;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Args f5(x1 x1Var, int i) {
        return x1Var.d5(i);
    }

    /* renamed from: e5, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void onBind(DoubleColSimilarNpsModel data, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.m4(data, i);
        this.w.J0(new Function0() { // from class: jk4.v1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Args f5;
                f5 = x1.f5(x1.this, i);
                return f5;
            }
        });
        this.w.F0(data);
        this.w.d1(new Function0() { // from class: jk4.w1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h5;
                h5 = x1.h5(x1.this);
                return h5;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x1(ViewGroup parent, q64.r staggeredFeedDepend, Function1<? super String, Unit> onRemove) {
        super(LayoutInflater.from(parent.getContext()).inflate(2131037037, parent, false), staggeredFeedDepend);
        androidx.compose.ui.graphics.l0 l0Var;
        androidx.compose.ui.graphics.l0 l0Var2;
        long S1;
        Integer num;
        Integer num2;
        Integer num3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(staggeredFeedDepend, "staggeredFeedDepend");
        Intrinsics.checkNotNullParameter(onRemove, "onRemove");
        this.t = staggeredFeedDepend;
        this.u = onRemove;
        NovelComposeHolderView<f1> findViewById = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131825001);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        NovelComposeHolderView<f1> novelComposeHolderView = findViewById;
        this.v = novelComposeHolderView;
        y yVar = new ViewModelProvider(novelComposeHolderView).get(Reflection.getOrCreateKotlinClass(y.class));
        this.w = yVar;
        yVar.k = String.valueOf(staggeredFeedDepend.h().get("from_src_material_id"));
        q64.c0 g = staggeredFeedDepend.a().a().g();
        androidx.compose.ui.graphics.l0 l0Var3 = null;
        if (g != null && (num3 = g.a) != null) {
            l0Var = androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.b(num3.intValue()));
        } else {
            l0Var = null;
        }
        if (g != null && (num2 = g.b) != null) {
            l0Var2 = androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.b(num2.intValue()));
        } else {
            l0Var2 = null;
        }
        if (g != null && (num = g.e) != null) {
            l0Var3 = androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.b(num.intValue()));
        }
        if (l0Var3 != null) {
            S1 = l0Var3.x();
        } else if (SkinManager.isNightMode()) {
            S1 = og4.a.a.d().T0();
        } else {
            S1 = og4.a.a.d().S1();
        }
        androidx.compose.ui.graphics.l0 j = androidx.compose.ui.graphics.l0.j(S1);
        og4.a aVar = og4.a.a;
        yVar.f1(new m(false, 16, l0Var, l0Var2, new u0(j, l0Var2, androidx.compose.ui.graphics.l0.j(aVar.d().Y2()), androidx.compose.ui.graphics.l0.j(aVar.d().r()), null), null));
        yVar.e1(new Function0() { // from class: jk4.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit c5;
                c5 = x1.c5(x1.this);
                return c5;
            }
        });
        novelComposeHolderView.setContent(b.a.b());
    }
}

package wm4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.compose.NovelComposeHolderView;
import com.dragon.read.kmp.relatedwrok.RelatedWork2ColModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import q64.c0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s extends u64.l<RelatedWork2ColModel> {
    public static final int x;
    private final q64.r t;
    private final az2.c u;
    private final NovelComposeHolderView<fe4.n> v;
    private final Lazy w;

    static {
        Covode.recordClassIndex(608671);
        x = 8;
    }

    private final t d5() {
        return (t) this.w.getValue();
    }

    protected void r4() {
        super.r4();
        t.Z0(d5(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f5(s sVar) {
        sVar.T3();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t i5(s sVar) {
        return (t) new ViewModelProvider(sVar.v).get(Reflection.getOrCreateKotlinClass(t.class));
    }

    private final Args c5(int i) {
        Args args = new Args();
        args.put("card_left_right_position", F3());
        az2.c cVar = this.u;
        if (cVar != null) {
            i = cVar.a(i);
        }
        args.put("rank", Integer.valueOf(i));
        args.put("display_card", "dual_column_card");
        args.put("category_tab_type", Integer.valueOf(v64.a.h(this.t)));
        args.put("module_name", "无限流");
        args.put("unlimited_content_type", "related_content_list");
        args.put("is_quick_respond_card", "1");
        args.put("responded_src_material_id", d5().I0());
        args.putAll(this.t.h());
        return args;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Args h5(s sVar, int i) {
        return sVar.c5(i);
    }

    /* renamed from: e5, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void onBind(RelatedWork2ColModel relatedWork2ColModel, final int i) {
        Integer num;
        l0 l0Var;
        l0 l0Var2;
        Integer num2;
        Integer num3;
        super.m4(relatedWork2ColModel, i);
        if (relatedWork2ColModel == null) {
            return;
        }
        c0 g = this.t.a().a().g();
        l0 l0Var3 = null;
        if (g != null) {
            num = g.a;
        } else {
            num = null;
        }
        if (num != null) {
            l0Var = l0.j(n0.b(num.intValue()));
        } else {
            l0Var = null;
        }
        relatedWork2ColModel.m37setCardBgColorY2TPw74(l0Var);
        if (num != null) {
            relatedWork2ColModel.setCardBgUrl("");
        }
        if (g != null && (num3 = g.b) != null) {
            l0Var2 = l0.j(n0.b(num3.intValue()));
        } else {
            l0Var2 = null;
        }
        if (g != null && (num2 = g.c) != null) {
            l0Var3 = l0.j(n0.b(num2.intValue()));
        }
        relatedWork2ColModel.m38setCardMainTitleColorY2TPw74(l0Var2);
        relatedWork2ColModel.m39setCardSubInfoColor1Y2TPw74(l0Var3);
        d5().G0(relatedWork2ColModel);
        az2.c cVar = this.u;
        if (cVar != null) {
            cVar.b(i);
        }
        d5().c1(new Function0() { // from class: wm4.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f5;
                f5 = s.f5(s.this);
                return f5;
            }
        });
        d5().b1(new Function0() { // from class: wm4.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Args h5;
                h5 = s.h5(s.this, i);
                return h5;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ViewGroup parent, q64.r staggeredFeedDepend, az2.c cVar) {
        super(LayoutInflater.from(parent.getContext()).inflate(2131037037, parent, false), staggeredFeedDepend);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(staggeredFeedDepend, "staggeredFeedDepend");
        this.t = staggeredFeedDepend;
        this.u = cVar;
        NovelComposeHolderView<fe4.n> findViewById = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131825001);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        NovelComposeHolderView<fe4.n> novelComposeHolderView = findViewById;
        this.v = novelComposeHolderView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: wm4.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                t i5;
                i5 = s.i5(s.this);
                return i5;
            }
        });
        this.w = lazy;
        novelComposeHolderView.setContent(a.a.a());
    }
}

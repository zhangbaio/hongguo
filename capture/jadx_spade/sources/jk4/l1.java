package jk4;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.ScaleTextView;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.ui.util.callback.SimpleAnimatorListener;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsCommunityApi;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.dragon.read.recyler.IHolderFactory;
import com.dragon.read.recyler.RecyclerClient;
import com.dragon.read.util.NetworkUtils;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.q6;
import com.dragon.read.widget.brandbutton.BrandTextButton;
import com.dragon.read.widget.dialog.AnimationBottomDialog;
import com.dragon.read.widget.swipeback.SwipeBackLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jk4.l1;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l1 extends AnimationBottomDialog implements p1 {
    public static final a l;
    public static final int m;
    private final Context a;
    private final o1 b;
    private View c;
    private ScaleTextView d;
    private RecyclerView e;
    private EditText f;
    private BrandTextButton g;
    private ScaleTextView h;
    private SwipeBackLayout i;
    private final Lazy j;
    private final Lazy k;

    public static final class a {
        static {
            Covode.recordClassIndex(607888);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607887);
        l = new a(null);
        m = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerClient v0() {
        return new RecyclerClient();
    }

    protected boolean shouldAdaptForPad() {
        return xs4.e.t();
    }

    private final RecyclerClient l0() {
        return (RecyclerClient) this.j.getValue();
    }

    private final f m0() {
        return (f) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int k0() {
        int screenWidth;
        int coerceAtLeast;
        int coerceAtLeast2;
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            screenWidth = recyclerView.getWidth();
        } else {
            screenWidth = ScreenUtils.getScreenWidth(getContext()) - UIKt.getDp(32);
        }
        int dp = UIKt.getDp(66) * l0().getDataList().size();
        if (dp > screenWidth) {
            return 0;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(screenWidth - dp, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(l0().getDataList().size() - 1, 1);
        return coerceAtLeast / coerceAtLeast2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o0() {
        int i;
        IBinder iBinder;
        int screenHeight = ScreenUtils.getScreenHeight(getContext());
        View contentView = getContentView();
        if (contentView != null) {
            i = contentView.getHeight();
        } else {
            i = 0;
        }
        if (screenHeight - i > UIKt.getDp(200)) {
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            EditText editText = this.f;
            if (editText != null) {
                iBinder = editText.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            EditText editText2 = this.f;
            if (editText2 != null) {
                editText2.clearFocus();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        setContentView(2131035653);
        this.c = findViewById(2131821113);
        this.d = findViewById(2131820953);
        RecyclerView findViewById = findViewById(2131825930);
        findViewById.setAdapter(l0());
        findViewById.setLayoutManager(new LinearLayoutManager(findViewById.getContext(), 0, false));
        findViewById.addItemDecoration(new c());
        this.e = findViewById;
        this.f = (EditText) findViewById(2131831064);
        this.g = findViewById(2131824953);
        this.h = findViewById(2131820846);
        l0().register(s0.class, new IHolderFactory() { // from class: jk4.i1
            public final AbsRecyclerViewHolder createHolder(ViewGroup viewGroup) {
                AbsRecyclerViewHolder s0;
                s0 = l1.s0(l1.this, viewGroup);
                return s0;
            }
        });
        BrandTextButton brandTextButton = this.g;
        if (brandTextButton != null) {
            brandTextButton.setOnClickListener(new View.OnClickListener() { // from class: jk4.j1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l1.t0(l1.this, view);
                }
            });
        }
        EditText editText = this.f;
        if (editText != null) {
            editText.addTextChangedListener(m0());
        }
        EditText editText2 = this.f;
        if (editText2 != null) {
            UIKt.setMaxLength(editText2, 501);
        }
        EditText editText3 = this.f;
        if (editText3 != null) {
            editText3.setOnTouchListener(new View.OnTouchListener() { // from class: jk4.k1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean u0;
                    u0 = l1.u0(l1.this, view, motionEvent);
                    return u0;
                }
            });
        }
        q6.e(getContentView(), 16.0f);
        SwipeBackLayout findViewById2 = findViewById(2131832974);
        findViewById2.setMaskDrawEnabled(false);
        findViewById2.setBackgroundDrawEnabled(false);
        findViewById2.H(false);
        findViewById2.B(new d());
        findViewById2.B(new e());
        this.i = findViewById2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0() {
        boolean z;
        int i;
        String str;
        Editable text;
        Editable text2;
        String obj;
        BrandTextButton brandTextButton = this.g;
        if (brandTextButton != null && !brandTextButton.isSelected()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogWrapper.debug("SimilarNpsDialog", "handleSubmit: 未选中任何选项", new Object[0]);
            ToastUtils.showCommonToast("请评分后再提交");
            return;
        }
        EditText editText = this.f;
        if (editText != null && (text2 = editText.getText()) != null && (obj = text2.toString()) != null) {
            i = obj.length();
        } else {
            i = 0;
        }
        if (i > 500) {
            LogWrapper.debug("SimilarNpsDialog", "handleSubmit: 字数超过500", new Object[0]);
            ToastUtils.showCommonToast("最多输入500个字");
            return;
        }
        if (!NetworkUtils.isNetworkAvailable()) {
            LogWrapper.debug("SimilarNpsDialog", "handleSubmit: 网络异常", new Object[0]);
            ToastUtils.showCommonToast(getContext().getResources().getString(2131107331));
            return;
        }
        o1 o1Var = this.b;
        EditText editText2 = this.f;
        if (editText2 == null || (text = editText2.getText()) == null || (str = text.toString()) == null) {
            str = "";
        }
        o1Var.X(str);
        ToastUtils.showCommonToast(2131106829);
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q0() {
        boolean z;
        Object obj;
        String string;
        List<s0> a0 = this.b.a0();
        l0().dispatchDataUpdate(a0);
        EditText editText = this.f;
        if (editText != null) {
            Iterator<T> it2 = a0.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((s0) obj).b) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            s0 s0Var = (s0) obj;
            if (s0Var == null || (string = s0Var.e) == null) {
                string = getContext().getResources().getString(2131106828);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            editText.setHint(string);
        }
        BrandTextButton brandTextButton = this.g;
        boolean z2 = true;
        if (brandTextButton != null) {
            if (!(a0 instanceof Collection) || !a0.isEmpty()) {
                Iterator<T> it4 = a0.iterator();
                while (it4.hasNext()) {
                    if (((s0) it4.next()).b) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            brandTextButton.setSelected(z);
        }
        BrandTextButton brandTextButton2 = this.g;
        if (brandTextButton2 == null || !brandTextButton2.isSelected()) {
            z2 = false;
        }
        if (z2) {
            BrandTextButton brandTextButton3 = this.g;
            if (brandTextButton3 != null) {
                brandTextButton3.setAlpha(1.0f);
            }
        } else {
            BrandTextButton brandTextButton4 = this.g;
            if (brandTextButton4 != null) {
                brandTextButton4.setAlpha(0.5f);
            }
        }
        ScaleTextView scaleTextView = this.d;
        if (scaleTextView != null) {
            scaleTextView.setText(this.b.G());
        }
    }

    public static final class b extends AbsRecyclerViewHolder<s0> {
        public static final int k;
        private final p1 d;
        private final LottieAnimationView e;
        private final ImageView f;
        private final ImageView g;
        private final ScaleTextView h;
        private boolean i;
        private final a j;

        static {
            Covode.recordClassIndex(607889);
            k = 8;
        }

        public static final class a extends SimpleAnimatorListener {
            a() {
            }

            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UIKt.visible(b.this.g);
                UIKt.gone(b.this.e);
            }

            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                UIKt.visible(b.this.e);
                UIKt.gone(b.this.f);
                UIKt.gone(b.this.g);
            }
        }

        private final void F2(s0 s0Var, int i) {
            this.d.j(s0Var);
        }

        /* renamed from: G2, reason: merged with bridge method [inline-methods] */
        public void onBind(final s0 data, final int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.onBind(data, i);
            this.h.setText(data.d);
            M2(data, i);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new View.OnClickListener() { // from class: jk4.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l1.b.H2(l1.b.this, data, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L2(int i, Throwable th) {
            LogWrapper.error("SimilarNpsDialog", "playLottie failed, " + th + " index " + i, new Object[0]);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ViewGroup parent, p1 itemAbility) {
            super(LayoutInflater.from(parent.getContext()).inflate(2131035922, parent, false));
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(itemAbility, "itemAbility");
            this.d = itemAbility;
            LottieAnimationView findViewById = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131830879);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.e = findViewById;
            View findViewById2 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131830880);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.f = (ImageView) findViewById2;
            View findViewById3 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131830881);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.g = (ImageView) findViewById3;
            ScaleTextView findViewById4 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131825936);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.h = findViewById4;
            this.i = true;
            this.j = new a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
        
            if (r8 == true) goto L48;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void M2(jk4.s0 r8, int r9) {
            /*
                r7 = this;
                android.widget.ImageView r0 = r7.f
                r1 = 2130843883(0x7f0218eb, float:1.7292902E38)
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r9 == 0) goto L27
                if (r9 == r5) goto L23
                if (r9 == r4) goto L1f
                if (r9 == r3) goto L1b
                if (r9 == r2) goto L17
                r6 = 2130843883(0x7f0218eb, float:1.7292902E38)
                goto L2a
            L17:
                r6 = 2130844910(0x7f021cee, float:1.7294985E38)
                goto L2a
            L1b:
                r6 = 2130844399(0x7f021aef, float:1.7293949E38)
                goto L2a
            L1f:
                r6 = 2130843195(0x7f02163b, float:1.7291507E38)
                goto L2a
            L23:
                r6 = 2130844890(0x7f021cda, float:1.7294945E38)
                goto L2a
            L27:
                r6 = 2130844912(0x7f021cf0, float:1.729499E38)
            L2a:
                r0.setImageResource(r6)
                android.widget.ImageView r0 = r7.g
                if (r9 == 0) goto L4a
                if (r9 == r5) goto L46
                if (r9 == r4) goto L42
                if (r9 == r3) goto L3e
                if (r9 == r2) goto L3a
                goto L4d
            L3a:
                r1 = 2130844911(0x7f021cef, float:1.7294987E38)
                goto L4d
            L3e:
                r1 = 2130844400(0x7f021af0, float:1.729395E38)
                goto L4d
            L42:
                r1 = 2130843196(0x7f02163c, float:1.7291509E38)
                goto L4d
            L46:
                r1 = 2130844891(0x7f021cdb, float:1.7294947E38)
                goto L4d
            L4a:
                r1 = 2130844913(0x7f021cf1, float:1.7294991E38)
            L4d:
                r0.setImageResource(r1)
                com.dragon.read.component.biz.api.NsCommunityApi r0 = com.dragon.read.component.biz.api.NsCommunityApi.IMPL
                jz2.q r0 = r0.seriesCommentService()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "video_comment_atmosphere/"
                r1.append(r2)
                java.lang.String r2 = r8.c
                r1.append(r2)
                java.lang.String r2 = ".json"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r0 = r0.s(r1)
                r1 = 0
                if (r0 == 0) goto L7f
                int r2 = r0.length()
                if (r2 != 0) goto L7d
                goto L7f
            L7d:
                r2 = 0
                goto L80
            L7f:
                r2 = 1
            L80:
                if (r2 == 0) goto L8e
                java.lang.String r2 = "localJsonPath is null"
                java.lang.Object[] r3 = new java.lang.Object[r1]
                java.lang.String r4 = "SimilarNpsDialog"
                com.dragon.read.base.util.LogWrapper.error(r4, r2, r3)
                r7.i = r1
                goto L90
            L8e:
                r7.i = r5
            L90:
                boolean r8 = r8.b
                if (r8 == 0) goto Lbf
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                boolean r8 = r7.i
                if (r8 == 0) goto Lb4
                if (r0 == 0) goto Lab
                int r8 = r0.length()
                if (r8 <= 0) goto La7
                r8 = 1
                goto La8
            La7:
                r8 = 0
            La8:
                if (r8 != r5) goto Lab
                goto Lac
            Lab:
                r5 = 0
            Lac:
                if (r5 == 0) goto Lb4
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                r7.J2(r8, r9, r0)
                goto Lce
            Lb4:
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.gone(r8)
                android.widget.ImageView r8 = r7.g
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                goto Lce
            Lbf:
                android.widget.ImageView r8 = r7.f
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                android.widget.ImageView r8 = r7.g
                com.dragon.read.util.kotlin.UIKt.gone(r8)
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.gone(r8)
            Lce:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jk4.l1.b.M2(jk4.s0, int):void");
        }

        private final void J2(LottieAnimationView lottieAnimationView, final int i, String str) {
            LottieListener lottieListener = new LottieListener() { // from class: jk4.n1
                public final void onResult(Object obj) {
                    l1.b.L2(i, (Throwable) obj);
                }
            };
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
            NsCommunityApi.IMPL.seriesCommentService().t(lottieAnimationView, str, this.j, lottieListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H2(b bVar, s0 s0Var, int i, View view) {
            bVar.F2(s0Var, i);
        }
    }

    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) > 0) {
                outRect.left = l1.this.k0();
            }
        }
    }

    public static final class d extends com.dragon.read.widget.swipeback.b {
        d() {
            super(false);
        }

        public void f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            l1.this.dismiss();
        }
    }

    public static final class e implements SwipeBackLayout.f {
        public void b(SwipeBackLayout swipeBackLayout, View view, int i) {
        }

        public void c(SwipeBackLayout swipeBackLayout, int i) {
        }

        e() {
        }

        public void a(SwipeBackLayout swipeBackLayout, View view, float f) {
            l1.this.o0();
        }
    }

    public static final class f implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            EditText editText;
            EditText editText2;
            int i2;
            String obj;
            String obj2;
            boolean z = false;
            if (editable != null && (obj2 = editable.toString()) != null) {
                i = obj2.length();
            } else {
                i = 0;
            }
            if (i > 500) {
                ScaleTextView scaleTextView = l1.this.h;
                if (scaleTextView != null) {
                    scaleTextView.setTextColor(l1.this.getContext().getResources().getColor(2131560567));
                }
                ToastUtils.showCommonToast("最多输入500个字");
            } else {
                ScaleTextView scaleTextView2 = l1.this.h;
                if (scaleTextView2 != null) {
                    scaleTextView2.setTextColor(SkinDelegate.getColor(l1.this.getContext(), 2131558445));
                }
            }
            if (i > 490) {
                ScaleTextView scaleTextView3 = l1.this.h;
                if (scaleTextView3 != null) {
                    StringBuilder sb = new StringBuilder();
                    if (editable != null && (obj = editable.toString()) != null) {
                        i2 = obj.length();
                    } else {
                        i2 = 0;
                    }
                    sb.append(i2);
                    sb.append("/500");
                    scaleTextView3.setText(sb.toString());
                }
                ScaleTextView scaleTextView4 = l1.this.h;
                if (scaleTextView4 != null) {
                    UIKt.visible(scaleTextView4);
                }
                EditText editText3 = l1.this.f;
                if (editText3 != null && editText3.getPaddingBottom() == UIKt.getDp(25)) {
                    z = true;
                }
                if (!z && (editText2 = l1.this.f) != null) {
                    UIKt.updatePadding$default(editText2, (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(25)), 7, (Object) null);
                    return;
                }
                return;
            }
            ScaleTextView scaleTextView5 = l1.this.h;
            if (scaleTextView5 != null) {
                UIKt.gone(scaleTextView5);
            }
            EditText editText4 = l1.this.f;
            if (editText4 != null && editText4.getPaddingBottom() == UIKt.getDp(12)) {
                z = true;
            }
            if (!z && (editText = l1.this.f) != null) {
                UIKt.updatePadding$default(editText, (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(12)), 7, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f w0(l1 l1Var) {
        return l1Var.new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        initView();
        q0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jk4.p1
    public void j(s0 data) {
        boolean z;
        Object obj;
        String string;
        Intrinsics.checkNotNullParameter(data, "data");
        this.b.j(data);
        List<s0> a0 = this.b.a0();
        l0().dispatchDataUpdate(a0);
        EditText editText = this.f;
        if (editText != null) {
            Iterator<T> it2 = a0.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((s0) obj).b) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            s0 s0Var = (s0) obj;
            if (s0Var == null || (string = s0Var.e) == null) {
                string = getContext().getResources().getString(2131106828);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            editText.setHint(string);
        }
        BrandTextButton brandTextButton = this.g;
        boolean z2 = true;
        if (brandTextButton != null) {
            if (!(a0 instanceof Collection) || !a0.isEmpty()) {
                Iterator<T> it4 = a0.iterator();
                while (it4.hasNext()) {
                    if (((s0) it4.next()).b) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            brandTextButton.setSelected(z);
        }
        BrandTextButton brandTextButton2 = this.g;
        if (brandTextButton2 == null || !brandTextButton2.isSelected()) {
            z2 = false;
        }
        if (z2) {
            BrandTextButton brandTextButton3 = this.g;
            if (brandTextButton3 != null) {
                brandTextButton3.setAlpha(1.0f);
                return;
            }
            return;
        }
        BrandTextButton brandTextButton4 = this.g;
        if (brandTextButton4 != null) {
            brandTextButton4.setAlpha(0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(l1 l1Var, View view) {
        l1Var.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbsRecyclerViewHolder s0(l1 l1Var, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new b(viewGroup, l1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(Context activity, o1 ability) {
        super(activity);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ability, "ability");
        this.a = activity;
        this.b = ability;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: jk4.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RecyclerClient v0;
                v0 = l1.v0();
                return v0;
            }
        });
        this.j = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: jk4.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                l1.f w0;
                w0 = l1.w0(l1.this);
                return w0;
            }
        });
        this.k = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r3 != 3) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean u0(jk4.l1 r2, android.view.View r3, android.view.MotionEvent r4) {
        /*
            int r3 = r4.getAction()
            r4 = 0
            r0 = 1
            if (r3 == 0) goto L19
            if (r3 == r0) goto L11
            r1 = 2
            if (r3 == r1) goto L19
            r0 = 3
            if (r3 == r0) goto L11
            goto L20
        L11:
            com.dragon.read.widget.swipeback.SwipeBackLayout r2 = r2.i
            if (r2 == 0) goto L20
            r2.requestDisallowInterceptTouchEvent(r4)
            goto L20
        L19:
            com.dragon.read.widget.swipeback.SwipeBackLayout r2 = r2.i
            if (r2 == 0) goto L20
            r2.requestDisallowInterceptTouchEvent(r0)
        L20:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.l1.u0(jk4.l1, android.view.View, android.view.MotionEvent):boolean");
    }
}

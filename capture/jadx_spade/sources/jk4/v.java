package jk4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
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
import com.dragon.read.widget.flow.ButtonLayout;
import com.dragon.read.widget.swipeback.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import jk4.v;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v extends AnimationBottomDialog implements p1 {
    public static final a q;
    public static final int r;
    private final Context a;
    private final o1 b;
    private View c;
    private ScaleTextView d;
    private RecyclerView e;
    private ButtonLayout f;
    private EditText g;
    private BrandTextButton h;
    private ScaleTextView i;
    private SwipeBackLayout j;
    private List<String> k;
    private final LinkedHashSet<String> l;
    private String m;
    private boolean n;
    private final Lazy o;
    private final Lazy p;

    public static final class a {
        static {
            Covode.recordClassIndex(607874);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607873);
        q = new a(null);
        r = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerClient C0() {
        return new RecyclerClient();
    }

    protected boolean shouldAdaptForPad() {
        return xs4.e.t();
    }

    private final RecyclerClient s0() {
        return (RecyclerClient) this.o.getValue();
    }

    private final f t0() {
        return (f) this.p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int q0() {
        int coerceAtLeast;
        int coerceAtLeast2;
        int screenWidth = ScreenUtils.getScreenWidth(getContext()) - UIKt.getDp(24);
        int dp = UIKt.getDp(66) * s0().getDataList().size();
        if (dp > screenWidth) {
            return 0;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(screenWidth - dp, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(s0().getDataList().size() - 1, 1);
        return coerceAtLeast / coerceAtLeast2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0() {
        IBinder iBinder;
        boolean z = true;
        if (this.l.contains(this.m)) {
            EditText editText = this.g;
            if (editText == null || editText.getVisibility() != 0) {
                z = false;
            }
            if (!z) {
                EditText editText2 = this.g;
                if (editText2 != null) {
                    UIKt.visible(editText2);
                }
                EditText editText3 = this.g;
                if (editText3 != null) {
                    editText3.requestFocus();
                }
                EditText editText4 = this.g;
                if (editText4 != null) {
                    editText4.post(new Runnable() { // from class: jk4.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            v.N0(v.this);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        EditText editText5 = this.g;
        if (editText5 == null || editText5.getVisibility() != 0) {
            z = false;
        }
        if (z) {
            ScaleTextView scaleTextView = this.i;
            if (scaleTextView != null) {
                UIKt.gone(scaleTextView);
            }
            EditText editText6 = this.g;
            if (editText6 != null) {
                editText6.setText("");
            }
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            EditText editText7 = this.g;
            if (editText7 != null) {
                iBinder = editText7.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            EditText editText8 = this.g;
            if (editText8 != null) {
                editText8.clearFocus();
            }
            H0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u0() {
        boolean z;
        int i;
        Editable text;
        String obj;
        BrandTextButton brandTextButton = this.h;
        if (brandTextButton != null && !brandTextButton.isSelected()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LogWrapper.debug("SeriesDetailNpsDialog", "handleSubmit: 未选中任何选项", new Object[0]);
            ToastUtils.showCommonToast("请评分后再提交");
            return;
        }
        EditText editText = this.g;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
            i = obj.length();
        } else {
            i = 0;
        }
        if (i > 500) {
            LogWrapper.debug("SeriesDetailNpsDialog", "handleSubmit: 字数超过500", new Object[0]);
            ToastUtils.showCommonToast("最多输入500个字");
        } else if (!NetworkUtils.isNetworkAvailable()) {
            LogWrapper.debug("SeriesDetailNpsDialog", "handleSubmit: 网络异常", new Object[0]);
            ToastUtils.showCommonToast(getContext().getResources().getString(2131107331));
        } else {
            this.b.W(o0());
            ToastUtils.showCommonToast(2131106829);
            this.n = true;
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v0() {
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
            EditText editText = this.g;
            if (editText != null) {
                iBinder = editText.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            EditText editText2 = this.g;
            if (editText2 != null) {
                editText2.clearFocus();
            }
        }
    }

    public void dismiss() {
        boolean z;
        Editable text;
        String obj;
        if (!this.n) {
            BrandTextButton brandTextButton = this.h;
            int i = 0;
            if (brandTextButton != null && brandTextButton.isSelected()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                EditText editText = this.g;
                if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
                    i = obj.length();
                }
                if (i <= 500 && NetworkUtils.isNetworkAvailable()) {
                    this.b.W(o0());
                    ToastUtils.showCommonToast(2131106829);
                    this.n = true;
                }
            }
        }
        super.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        setContentView(2131035654);
        this.c = findViewById(2131821113);
        this.d = findViewById(2131820953);
        RecyclerView findViewById = findViewById(2131825930);
        findViewById.setAdapter(s0());
        findViewById.setLayoutManager(new LinearLayoutManager(findViewById.getContext(), 0, false));
        findViewById.addItemDecoration(new c());
        this.e = findViewById;
        this.f = findViewById(2131830895);
        this.g = (EditText) findViewById(2131831064);
        this.h = findViewById(2131824953);
        this.i = findViewById(2131820846);
        s0().register(s0.class, new IHolderFactory() { // from class: jk4.o
            public final AbsRecyclerViewHolder createHolder(ViewGroup viewGroup) {
                AbsRecyclerViewHolder x0;
                x0 = v.x0(v.this, viewGroup);
                return x0;
            }
        });
        BrandTextButton brandTextButton = this.h;
        if (brandTextButton != null) {
            brandTextButton.setOnClickListener(new View.OnClickListener() { // from class: jk4.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.y0(v.this, view);
                }
            });
        }
        EditText editText = this.g;
        if (editText != null) {
            editText.addTextChangedListener(t0());
        }
        EditText editText2 = this.g;
        if (editText2 != null) {
            UIKt.setMaxLength(editText2, 500);
        }
        EditText editText3 = this.g;
        if (editText3 != null) {
            editText3.setOnTouchListener(new View.OnTouchListener() { // from class: jk4.q
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean B0;
                    B0 = v.B0(v.this, view, motionEvent);
                    return B0;
                }
            });
        }
        q6.h(getContentView(), 16.0f);
        SwipeBackLayout findViewById2 = findViewById(2131832974);
        findViewById2.setMaskDrawEnabled(false);
        findViewById2.setBackgroundDrawEnabled(false);
        findViewById2.H(false);
        findViewById2.B(new d());
        findViewById2.B(new e());
        this.j = findViewById2;
    }

    private final List<String> o0() {
        String str;
        boolean z;
        Editable text;
        String obj;
        LinkedHashSet<String> linkedHashSet = this.l;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : linkedHashSet) {
            if (true ^ Intrinsics.areEqual((String) obj2, this.m)) {
                arrayList.add(obj2);
            }
        }
        if (!this.l.contains(this.m)) {
            return arrayList;
        }
        EditText editText = this.g;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
            str = StringsKt__StringsKt.trim((CharSequence) obj).toString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!arrayList.isEmpty()) {
                return CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt__CollectionsJVMKt.listOf(this.m + ':' + str));
            }
            return CollectionsKt__CollectionsJVMKt.listOf(this.m + ':' + str);
        }
        if (!(!arrayList.isEmpty())) {
            return CollectionsKt__CollectionsJVMKt.listOf(this.m);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w0() {
        Object obj;
        String string;
        List<s0> a0 = this.b.a0();
        s0().dispatchDataUpdate(a0);
        EditText editText = this.g;
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
        BrandTextButton brandTextButton = this.h;
        if (brandTextButton != null) {
            boolean z = false;
            if (!(a0 instanceof Collection) || !a0.isEmpty()) {
                Iterator<T> it4 = a0.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    } else if (((s0) it4.next()).b) {
                        z = true;
                        break;
                    }
                }
            }
            brandTextButton.setSelected(z);
        }
        ScaleTextView scaleTextView = this.d;
        if (scaleTextView != null) {
            scaleTextView.setText(this.b.G());
        }
        D0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r3 == null) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void D0() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.v.D0():void");
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
            Covode.recordClassIndex(607875);
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

        private final void F2(s0 s0Var) {
            this.d.j(s0Var);
        }

        /* renamed from: G2, reason: merged with bridge method [inline-methods] */
        public void onBind(final s0 data, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.onBind(data, i);
            this.h.setText(data.d);
            M2(data, i);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new View.OnClickListener() { // from class: jk4.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.b.H2(v.b.this, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L2(int i, Throwable th) {
            LogWrapper.error("SeriesDetailNpsDialog", "playLottie failed, " + th + " index " + i, new Object[0]);
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

        /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        
            if (r8 == true) goto L45;
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
                r2 = r2 ^ r5
                r7.i = r2
                boolean r8 = r8.b
                if (r8 == 0) goto Lb2
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                boolean r8 = r7.i
                if (r8 == 0) goto La7
                if (r0 == 0) goto L9e
                int r8 = r0.length()
                if (r8 <= 0) goto L9a
                r8 = 1
                goto L9b
            L9a:
                r8 = 0
            L9b:
                if (r8 != r5) goto L9e
                goto L9f
            L9e:
                r5 = 0
            L9f:
                if (r5 == 0) goto La7
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                r7.J2(r8, r9, r0)
                goto Lc1
            La7:
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.gone(r8)
                android.widget.ImageView r8 = r7.g
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                goto Lc1
            Lb2:
                android.widget.ImageView r8 = r7.f
                com.dragon.read.util.kotlin.UIKt.visible(r8)
                android.widget.ImageView r8 = r7.g
                com.dragon.read.util.kotlin.UIKt.gone(r8)
                com.airbnb.lottie.LottieAnimationView r8 = r7.e
                com.dragon.read.util.kotlin.UIKt.gone(r8)
            Lc1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jk4.v.b.M2(jk4.s0, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H2(b bVar, s0 s0Var, View view) {
            bVar.F2(s0Var);
        }

        private final void J2(LottieAnimationView lottieAnimationView, final int i, String str) {
            LottieListener lottieListener = new LottieListener() { // from class: jk4.x
                public final void onResult(Object obj) {
                    v.b.L2(i, (Throwable) obj);
                }
            };
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
            NsCommunityApi.IMPL.seriesCommentService().t(lottieAnimationView, str, this.j, lottieListener);
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
                outRect.left = v.this.q0();
            }
        }
    }

    public static final class d extends com.dragon.read.widget.swipeback.b {
        d() {
            super(false);
        }

        public void f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            v.this.dismiss();
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
            v.this.v0();
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
                ScaleTextView scaleTextView = v.this.i;
                if (scaleTextView != null) {
                    scaleTextView.setTextColor(v.this.getContext().getResources().getColor(2131560567));
                }
                ToastUtils.showCommonToast("最多输入500个字");
            } else {
                ScaleTextView scaleTextView2 = v.this.i;
                if (scaleTextView2 != null) {
                    scaleTextView2.setTextColor(SkinDelegate.getColor(v.this.getContext(), 2131558445));
                }
            }
            if (i > 99) {
                ScaleTextView scaleTextView3 = v.this.i;
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
                ScaleTextView scaleTextView4 = v.this.i;
                if (scaleTextView4 != null) {
                    UIKt.visible(scaleTextView4);
                }
                EditText editText3 = v.this.g;
                if (editText3 != null && editText3.getPaddingBottom() == UIKt.getDp(25)) {
                    z = true;
                }
                if (!z && (editText2 = v.this.g) != null) {
                    UIKt.updatePadding$default(editText2, (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(25)), 7, (Object) null);
                    return;
                }
                return;
            }
            ScaleTextView scaleTextView5 = v.this.i;
            if (scaleTextView5 != null) {
                UIKt.gone(scaleTextView5);
            }
            EditText editText4 = v.this.g;
            if (editText4 != null && editText4.getPaddingBottom() == UIKt.getDp(12)) {
                z = true;
            }
            if (!z && (editText = v.this.g) != null) {
                UIKt.updatePadding$default(editText, (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(12)), 7, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f J0(v vVar) {
        return vVar.new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N0(v vVar) {
        Object systemService = vVar.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(vVar.g, 1);
        vVar.H0(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        initView();
        w0();
    }

    private final void H0(boolean z) {
        final View view;
        int i;
        EditText editText = this.g;
        if (editText == null || (view = this.c) == null) {
            return;
        }
        int minHeight = editText.getMinHeight() + UIKt.getDp(16);
        float translationY = view.getTranslationY();
        if (z) {
            i = 0;
        } else {
            i = minHeight;
        }
        if (z) {
            UIKt.visible(editText);
        } else {
            UIKt.invisible(editText);
        }
        if (minHeight <= 0) {
            UIKt.gone(editText);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt((int) translationY, i);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: jk4.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v.I0(view, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jk4.p1
    public void j(s0 data) {
        Object obj;
        String string;
        Intrinsics.checkNotNullParameter(data, "data");
        this.b.j(data);
        List<s0> a0 = this.b.a0();
        s0().dispatchDataUpdate(a0);
        EditText editText = this.g;
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
        BrandTextButton brandTextButton = this.h;
        if (brandTextButton != null) {
            boolean z = false;
            if (!(a0 instanceof Collection) || !a0.isEmpty()) {
                Iterator<T> it4 = a0.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    } else if (((s0) it4.next()).b) {
                        z = true;
                        break;
                    }
                }
            }
            brandTextButton.setSelected(z);
        }
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(v vVar, View view) {
        vVar.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbsRecyclerViewHolder x0(v vVar, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new b(viewGroup, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(View view, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNull(animator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        view.setTranslationY(((Integer) r2).intValue());
    }

    private final void L0(String str, TextView textView) {
        boolean z;
        if (this.l.contains(str)) {
            this.l.remove(str);
            z = false;
        } else {
            this.l.add(str);
            z = true;
        }
        n0(textView, z);
        M0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context activity, o1 ability) {
        super(activity);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ability, "ability");
        this.a = activity;
        this.b = ability;
        this.l = new LinkedHashSet<>();
        this.m = "我要吐槽";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: jk4.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RecyclerClient C0;
                C0 = v.C0();
                return C0;
            }
        });
        this.o = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: jk4.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                v.f J0;
                J0 = v.J0(v.this);
                return J0;
            }
        });
        this.p = lazy2;
    }

    private final void K0(TextView textView, int i) {
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "getCompoundDrawablesRelative(...)");
        Drawable drawable = compoundDrawablesRelative[2];
        if (drawable == null) {
            return;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(...)");
        wrap.setBounds(drawable.getBounds());
        DrawableCompat.setTint(wrap, i);
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], wrap, compoundDrawablesRelative[3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0(TextView textView, boolean z) {
        int color;
        int color2;
        if (z) {
            color = SkinDelegate.getColor(getContext(), 2131558442);
            color2 = SkinDelegate.getColor(getContext(), 2131558488);
        } else {
            color = SkinDelegate.getColor(getContext(), 2131558458);
            color2 = SkinDelegate.getColor(getContext(), 2131558449);
        }
        textView.setTextColor(color);
        textView.setBackgroundTintList(ColorStateList.valueOf(color2));
        K0(textView, color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r3 != 3) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean B0(jk4.v r2, android.view.View r3, android.view.MotionEvent r4) {
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
            com.dragon.read.widget.swipeback.SwipeBackLayout r2 = r2.j
            if (r2 == 0) goto L20
            r2.requestDisallowInterceptTouchEvent(r4)
            goto L20
        L19:
            com.dragon.read.widget.swipeback.SwipeBackLayout r2 = r2.j
            if (r2 == 0) goto L20
            r2.requestDisallowInterceptTouchEvent(r0)
        L20:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.v.B0(jk4.v, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(v vVar, String str, TextView textView, View view) {
        Intrinsics.checkNotNull(str);
        vVar.L0(str, textView);
    }
}

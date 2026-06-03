package com.dragon.read.nps.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.AbsBroadcastReceiver;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.base.Args;
import com.dragon.read.base.basescale.ScaleTextView;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ssconfig.template.C2FeedNpsReportConfig;
import com.dragon.read.base.transition.ActivityAnimType;
import com.dragon.read.base.ui.util.KeyBoardUtils;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.nps.ui.FiveStarScoreView;
import com.dragon.read.nps.ui.NpsFeedbackDialogFragment;
import com.dragon.read.nps.ui.b1;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.OptionInfo;
import com.dragon.read.rpc.model.ResearchEvent;
import com.dragon.read.rpc.model.UserEventReportRequest;
import com.dragon.read.rpc.model.UserEventReportResponse;
import com.dragon.read.rpc.model.UserEventReportType;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.util.NetworkUtils;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.kotlin.CollectionKt;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.u2;
import com.dragon.read.widget.brandbutton.BrandTextButton;
import com.dragon.read.widget.swipeback.SwipeBackLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NpsFeedbackDialogFragment extends AbsFragment implements u2.a {
    public static final int A;
    public final UserResearchData a;
    public final a b;
    private final Map<String, String> c;
    private final String d;
    public final int e;
    public STATE f;
    public ConstraintLayout g;
    public FiveStarScoreView h;
    public ConstraintLayout i;
    public TextView j;
    public RecyclerView k;
    public EditText l;
    private ScaleTextView m;
    public TextView n;
    private int o;
    private final int p;
    private final int q;
    private final int r;
    private int s;
    private int t;
    private int u;
    private final Lazy v;
    public b1.a w;
    private final j x;
    private final View.OnClickListener y;
    public final AbsBroadcastReceiver z;

    public interface a {

        /* renamed from: com.dragon.read.nps.ui.NpsFeedbackDialogFragment$a$a, reason: collision with other inner class name */
        public static final class C0094a {
            static {
                Covode.recordClassIndex(612574);
            }

            public static Args a(a aVar) {
                return null;
            }
        }

        long a();

        long b();

        Args c();

        void d(int i);

        void onCommit();
    }

    static {
        Covode.recordClassIndex(612572);
        A = 8;
    }

    public static final class d extends ViewOutlineProvider {
        d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i;
            int i2;
            if (outline != null) {
                if (view != null) {
                    i = view.getWidth();
                } else {
                    i = 0;
                }
                if (view != null) {
                    i2 = view.getHeight();
                } else {
                    i2 = 0;
                }
                outline.setRoundRect(0, 0, i, i2, UIKt.getDp(12));
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class STATE {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ STATE[] $VALUES;
        public static final STATE enum_high_score_state;
        public static final STATE enum_init_state;
        public static final STATE enum_low_score_with_edit_text;
        public static final STATE enum_low_score_without_edit_text;
        public static final STATE enum_no_select_state;

        private static final /* synthetic */ STATE[] $values() {
            return new STATE[]{enum_init_state, enum_no_select_state, enum_high_score_state, enum_low_score_without_edit_text, enum_low_score_with_edit_text};
        }

        public static EnumEntries<STATE> getEntries() {
            return $ENTRIES;
        }

        public static STATE[] values() {
            return (STATE[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(612575);
            enum_init_state = new STATE("enum_init_state", 0);
            enum_no_select_state = new STATE("enum_no_select_state", 1);
            enum_high_score_state = new STATE("enum_high_score_state", 2);
            enum_low_score_without_edit_text = new STATE("enum_low_score_without_edit_text", 3);
            enum_low_score_with_edit_text = new STATE("enum_low_score_with_edit_text", 4);
            STATE[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static STATE valueOf(String str) {
            return (STATE) Enum.valueOf(STATE.class, str);
        }

        private STATE(String str, int i) {
        }
    }

    public static final class i implements b1.a {
        @Override // com.dragon.read.nps.ui.b1.a
        public int getTheme() {
            if (SkinManager.isNightMode()) {
                return 5;
            }
            return 1;
        }

        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(NpsFeedbackDialogFragment npsFeedbackDialogFragment) {
            KeyBoardUtils.showKeyBoard(npsFeedbackDialogFragment.ug());
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public boolean c(String item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Boolean bool = com.dragon.read.nps.ui.h.a.e().get(item);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public void b(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
            hVar.i(Intrinsics.areEqual(hVar.e().get(text), Boolean.TRUE));
            if (hVar.d()) {
                NpsFeedbackDialogFragment.this.og(STATE.enum_low_score_with_edit_text);
                NpsFeedbackDialogFragment.this.ug().setSelection(0);
                final NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
                ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.nps.ui.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NpsFeedbackDialogFragment.i.e(NpsFeedbackDialogFragment.this);
                    }
                }, 200L);
                return;
            }
            NpsFeedbackDialogFragment.this.og(STATE.enum_low_score_without_edit_text);
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public void a(boolean z, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            com.dragon.read.nps.ui.h.a.e().put(text, Boolean.valueOf(z));
        }
    }

    private final int rg() {
        return UIKt.getDp(257) + this.o;
    }

    public TextWatcher Ag() {
        return (TextWatcher) this.v.getValue();
    }

    public final FiveStarScoreView tg() {
        FiveStarScoreView fiveStarScoreView = this.h;
        if (fiveStarScoreView != null) {
            return fiveStarScoreView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fiveScoreView");
        return null;
    }

    public final EditText ug() {
        EditText editText = this.l;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
        return null;
    }

    public final RecyclerView vg() {
        RecyclerView recyclerView = this.k;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
        return null;
    }

    public final TextView wg() {
        TextView textView = this.n;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("researchTitle");
        return null;
    }

    public final ConstraintLayout xg() {
        ConstraintLayout constraintLayout = this.g;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    public final ConstraintLayout yg() {
        ConstraintLayout constraintLayout = this.i;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scoreTipsContainer");
        return null;
    }

    public final TextView zg() {
        TextView textView = this.j;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scoreTipsText");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qg() {
        BrandTextButton findViewById = findViewById(2131824953);
        findViewById.setOnClickListener(this.y);
        findViewById.setSelected(true);
    }

    private final void Vg() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = false;
        researchEvent.isSubmitted = true;
        userEventReportRequest.researchEvent = researchEvent;
        Observable subscribeOn = g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io());
        final Function1 function1 = new Function1() { // from class: com.dragon.read.nps.ui.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Xg;
                Xg = NpsFeedbackDialogFragment.Xg((UserEventReportResponse) obj);
                return Xg;
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: com.dragon.read.nps.ui.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NpsFeedbackDialogFragment.Wg(Function1.this, obj);
            }
        });
    }

    public b1 Cg() {
        vs4.e eVar = new vs4.e(this.w);
        Map scoreOptionInfo = this.a.scoreOptionInfo;
        Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
        Iterator it2 = scoreOptionInfo.entrySet().iterator();
        if (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            eVar.e = (OptionInfo) entry.getValue();
            RecyclerView.Adapter adapter = vg().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        return eVar;
    }

    public void onDestroyView() {
        boolean z;
        super.onDestroyView();
        if (ug().getText().toString().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.dragon.read.nps.ui.h.a.h(ug().getText().toString());
        }
        App.unregisterLocalReceiver(new BroadcastReceiver[]{this.z});
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;
        final /* synthetic */ NpsFeedbackDialogFragment b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            UIKt.removeOnGlobalLayoutListener(this.a, this);
            String str = this.b.d;
            StringBuilder sb = new StringBuilder();
            sb.append("NPS弹窗初始星星数量:");
            com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
            sb.append(hVar);
            sb.append(".starCount");
            LogWrapper.info(str, sb.toString(), new Object[0]);
            this.b.kh(hVar.f());
            if (this.b.wg().getLineCount() == 2) {
                this.b.o = UIKt.getDp(26);
            }
        }

        g(View view, NpsFeedbackDialogFragment npsFeedbackDialogFragment) {
            this.a = view;
            this.b = npsFeedbackDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bg() {
        int i2;
        Object obj;
        int screenHeight = ScreenUtils.getScreenHeight(getContext());
        View view = getView();
        if (view != null) {
            i2 = view.getHeight();
        } else {
            i2 = 0;
        }
        if (screenHeight - i2 > UIKt.getDp(200)) {
            Context context = getContext();
            if (context != null) {
                obj = context.getSystemService("input_method");
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) obj).hideSoftInputFromWindow(ug().getWindowToken(), 0);
            ug().clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void eg() {
        final int i2;
        final int height = xg().getHeight();
        com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
        if (hVar.d()) {
            i2 = this.t + this.u;
        } else {
            i2 = 0;
        }
        LogWrapper.info(this.d, "高分面板切换低分面板，编辑框状态:" + hVar.d() + " 高度：" + (((this.s + height) + i2) - UIKt.getDp(8)), new Object[0]);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dragon.read.nps.ui.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NpsFeedbackDialogFragment.fg(NpsFeedbackDialogFragment.this, i2, height, valueAnimator);
            }
        });
        ofFloat.addListener(new b());
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    private final void Lg() {
        LogWrapper.info(this.d, "call initHighScoreState", new Object[0]);
        xg().getLayoutParams().height = -2;
        wg().setText(this.a.researchTitle);
        ?? r0 = (FiveStarScoreView) findViewById(2131826346);
        ViewGroup.LayoutParams layoutParams = r0.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.q;
        r0.getLayoutParams().width = UIKt.getDp(260);
        r0.getLayoutParams().height = UIKt.getDp(40);
        r0.a2(UIKt.getDp(260), UIKt.getDp(40));
        ConstraintLayout yg = yg();
        yg.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = yg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (ScreenUtils.getScreenWidth(yg.getContext()) / 2) - UIKt.getDp(50);
        vg().setVisibility(8);
        EditText ug = ug();
        if (ug != null) {
            ug.setVisibility(8);
            ug.setFocusable(false);
        }
        BrandTextButton findViewById = findViewById(2131824953);
        findViewById.setOnClickListener(this.y);
        findViewById.setSelected(true);
        this.f = STATE.enum_high_score_state;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    private final void Mg() {
        LogWrapper.info(this.d, "call initLowScoreWithEditText", new Object[0]);
        FlexboxLayoutManager layoutManager = vg().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayoutManager");
        List flexLines = layoutManager.getFlexLines();
        xg().getLayoutParams().height = -2;
        wg().setText(this.a.researchTitle);
        ?? tg = tg();
        ViewGroup.LayoutParams layoutParams = tg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.r;
        tg.getLayoutParams().width = UIKt.getDp(164);
        tg.getLayoutParams().height = UIKt.getDp(28);
        tg.a2(UIKt.getDp(164), UIKt.getDp(28));
        yg().setVisibility(8);
        RecyclerView vg = vg();
        vg.getLayoutParams().height = this.p * flexLines.size();
        vg.setVisibility(0);
        com.dragon.read.nps.ui.h.a.i(true);
        RecyclerView.Adapter adapter = vg.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
        ((b1) adapter).notifyDataSetChanged();
        EditText ug = ug();
        ug.setVisibility(0);
        ug.setFocusable(true);
        ug.setFocusableInTouchMode(true);
        BrandTextButton findViewById = findViewById(2131824953);
        findViewById.setOnClickListener(this.y);
        findViewById.setSelected(true);
        this.f = STATE.enum_low_score_with_edit_text;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    private final void Ng() {
        LogWrapper.info(this.d, "call initLowScoreWithoutEditText", new Object[0]);
        FlexboxLayoutManager layoutManager = vg().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayoutManager");
        layoutManager.getFlexLines();
        xg().getLayoutParams().height = -2;
        wg().setText(this.a.researchTitle);
        ?? tg = tg();
        ViewGroup.LayoutParams layoutParams = tg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.r;
        tg.getLayoutParams().width = UIKt.getDp(164);
        tg.getLayoutParams().height = UIKt.getDp(28);
        tg.a2(UIKt.getDp(164), UIKt.getDp(28));
        yg().setVisibility(8);
        RecyclerView vg = vg();
        vg.getLayoutParams().height = -2;
        vg.setVisibility(0);
        com.dragon.read.nps.ui.h.a.i(false);
        RecyclerView.Adapter adapter = vg.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
        ((b1) adapter).notifyDataSetChanged();
        EditText ug = ug();
        if (ug != null) {
            ug.setVisibility(8);
            ug.setFocusable(false);
        }
        qg();
        this.f = STATE.enum_low_score_without_edit_text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jg() {
        final int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        final int height = xg().getHeight();
        this.s = vg().getHeight();
        com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
        if (hVar.d()) {
            this.t = ug().getHeight();
            ViewGroup.LayoutParams layoutParams = ug().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.topMargin;
            } else {
                i3 = 0;
            }
            this.u = i3;
        }
        if (hVar.d()) {
            i2 = this.t + this.u;
        } else {
            i2 = 0;
        }
        LogWrapper.info(this.d, "低分面板切换高分面板，编辑框状态:" + hVar.d() + " 高度：" + (height - ((this.s + i2) - UIKt.getDp(8))), new Object[0]);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dragon.read.nps.ui.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NpsFeedbackDialogFragment.kg(NpsFeedbackDialogFragment.this, i2, height, valueAnimator);
            }
        });
        ofFloat.addListener(new c());
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        Bg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Xg(UserEventReportResponse userEventReportResponse) {
        return Unit.INSTANCE;
    }

    public static final class b implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(NpsFeedbackDialogFragment npsFeedbackDialogFragment) {
            npsFeedbackDialogFragment.ug().setFocusable(true);
            npsFeedbackDialogFragment.ug().setFocusableInTouchMode(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p0) {
            ScaleTextView scaleTextView;
            Intrinsics.checkNotNullParameter(p0, "p0");
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(true);
            ConstraintLayout yg = NpsFeedbackDialogFragment.this.yg();
            yg.setAlpha(1.0f);
            yg.setVisibility(8);
            NpsFeedbackDialogFragment.this.vg().setAlpha(1.0f);
            if (com.dragon.read.nps.ui.h.a.d()) {
                NpsFeedbackDialogFragment.this.ug().setAlpha(1.0f);
                int length = NpsFeedbackDialogFragment.this.ug().length();
                NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
                if (length > npsFeedbackDialogFragment.e - 10 && (scaleTextView = npsFeedbackDialogFragment.m) != null) {
                    UIKt.visible(scaleTextView);
                }
                final NpsFeedbackDialogFragment npsFeedbackDialogFragment2 = NpsFeedbackDialogFragment.this;
                ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.nps.ui.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NpsFeedbackDialogFragment.b.e(NpsFeedbackDialogFragment.this);
                    }
                }, 100L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p0) {
            STATE state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ConstraintLayout yg = NpsFeedbackDialogFragment.this.yg();
            yg.setAlpha(1.0f);
            yg.setVisibility(0);
            RecyclerView vg = NpsFeedbackDialogFragment.this.vg();
            vg.setAlpha(0.0f);
            vg.setVisibility(0);
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(false);
            NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
            com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
            if (hVar.d()) {
                state = STATE.enum_low_score_with_edit_text;
            } else {
                state = STATE.enum_low_score_without_edit_text;
            }
            npsFeedbackDialogFragment.ah(state);
            NpsFeedbackDialogFragment.this.qg();
            if (hVar.d()) {
                EditText ug = NpsFeedbackDialogFragment.this.ug();
                ug.setAlpha(0.0f);
                ug.setVisibility(0);
            }
        }
    }

    public static final class c implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(true);
            NpsFeedbackDialogFragment.this.yg().setAlpha(1.0f);
            RecyclerView vg = NpsFeedbackDialogFragment.this.vg();
            vg.setAlpha(1.0f);
            vg.setVisibility(8);
            if (com.dragon.read.nps.ui.h.a.d()) {
                EditText ug = NpsFeedbackDialogFragment.this.ug();
                ug.setAlpha(1.0f);
                ug.setVisibility(8);
                ug.setFocusable(false);
                ScaleTextView scaleTextView = NpsFeedbackDialogFragment.this.m;
                if (scaleTextView != null) {
                    UIKt.gone(scaleTextView);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ConstraintLayout yg = NpsFeedbackDialogFragment.this.yg();
            yg.setAlpha(0.0f);
            yg.setVisibility(0);
            RecyclerView vg = NpsFeedbackDialogFragment.this.vg();
            vg.setAlpha(1.0f);
            vg.setVisibility(0);
            NpsFeedbackDialogFragment.this.ah(STATE.enum_high_score_state);
            NpsFeedbackDialogFragment.this.tg().setTouchEnable(false);
            NpsFeedbackDialogFragment.this.qg();
            if (com.dragon.read.nps.ui.h.a.d()) {
                EditText ug = NpsFeedbackDialogFragment.this.ug();
                ug.setAlpha(1.0f);
                ug.setVisibility(0);
            }
        }
    }

    public static final class e extends com.dragon.read.widget.swipeback.b {
        e() {
            super(false);
        }

        public void f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ActivityAnimType.FADE_IN_FADE_OUT.finish(NpsFeedbackDialogFragment.this.getActivity());
        }
    }

    public static final class f implements SwipeBackLayout.f {
        public void b(SwipeBackLayout swipeBackLayout, View view, int i) {
        }

        public void c(SwipeBackLayout swipeBackLayout, int i) {
        }

        f() {
        }

        public void a(SwipeBackLayout swipeBackLayout, View view, float f) {
            NpsFeedbackDialogFragment.this.Bg();
        }
    }

    public static final class h extends AbsBroadcastReceiver {
        h() {
        }

        public void onReceive(Context context, Intent intent, String action) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(action, "action");
            if (Intrinsics.areEqual(action, "action_skin_type_change")) {
                if (SkinManager.isNightMode()) {
                    NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
                    npsFeedbackDialogFragment.bh(npsFeedbackDialogFragment.getView());
                } else {
                    NpsFeedbackDialogFragment npsFeedbackDialogFragment2 = NpsFeedbackDialogFragment.this;
                    npsFeedbackDialogFragment2.dh(npsFeedbackDialogFragment2.getView());
                }
                Activity previousActivity = ActivityRecordManager.inst().getPreviousActivity();
                if (previousActivity != null) {
                    eq2.b.h().onActivityResume(previousActivity);
                }
            }
        }
    }

    public static final class j implements FiveStarScoreView.a {
        j() {
        }

        @Override // com.dragon.read.nps.ui.FiveStarScoreView.a
        public void onChanged(int i) {
            List split$default;
            LogWrapper.info(NpsFeedbackDialogFragment.this.d, "评分数量变化count:%d", new Object[]{Integer.valueOf(i)});
            if (i > 0 && i <= 5) {
                com.dragon.read.nps.ui.h.a.j(i);
                NpsFeedbackDialogFragment.this.b.d(i);
                Map scoreOptionInfo = NpsFeedbackDialogFragment.this.a.scoreOptionInfo;
                Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
                Iterator it2 = scoreOptionInfo.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    String str = (String) entry.getKey();
                    OptionInfo optionInfo = (OptionInfo) entry.getValue();
                    Intrinsics.checkNotNull(str);
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
                    if (split$default.contains(String.valueOf(i))) {
                        NpsFeedbackDialogFragment.this.ug().setHint(optionInfo.optionNameWithInput + "...");
                        break;
                    }
                }
                if (NpsFeedbackDialogFragment.this.sg(i) == null) {
                    NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
                    STATE state = npsFeedbackDialogFragment.f;
                    if (state == STATE.enum_low_score_without_edit_text || state == STATE.enum_low_score_with_edit_text) {
                        ConstraintLayout yg = npsFeedbackDialogFragment.yg();
                        ViewGroup.LayoutParams layoutParams = yg.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ((ScreenUtils.getScreenWidth(yg.getContext()) / 2) - UIKt.getDp(50)) + ((i - 3) * UIKt.getDp(55));
                        NpsFeedbackDialogFragment.this.zg().setText((CharSequence) NpsFeedbackDialogFragment.this.a.scoreRemarks.get(String.valueOf(i)));
                        NpsFeedbackDialogFragment.this.jg();
                        return;
                    }
                    npsFeedbackDialogFragment.og(STATE.enum_high_score_state);
                    ConstraintLayout yg2 = NpsFeedbackDialogFragment.this.yg();
                    ViewGroup.LayoutParams layoutParams2 = yg2.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ((ScreenUtils.getScreenWidth(yg2.getContext()) / 2) - UIKt.getDp(50)) + ((i - 3) * UIKt.getDp(55));
                    NpsFeedbackDialogFragment.this.zg().setText((CharSequence) NpsFeedbackDialogFragment.this.a.scoreRemarks.get(String.valueOf(i)));
                    return;
                }
                NpsFeedbackDialogFragment npsFeedbackDialogFragment2 = NpsFeedbackDialogFragment.this;
                STATE state2 = npsFeedbackDialogFragment2.f;
                if (state2 != STATE.enum_no_select_state && state2 != STATE.enum_high_score_state) {
                    RecyclerView.Adapter adapter = npsFeedbackDialogFragment2.vg().getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
                    b1 b1Var = (b1) adapter;
                    b1Var.e = NpsFeedbackDialogFragment.this.sg(i);
                    b1Var.notifyDataSetChanged();
                    if (com.dragon.read.nps.ui.h.a.d()) {
                        NpsFeedbackDialogFragment.this.og(STATE.enum_low_score_with_edit_text);
                        return;
                    } else {
                        NpsFeedbackDialogFragment.this.og(STATE.enum_low_score_without_edit_text);
                        return;
                    }
                }
                RecyclerView.Adapter adapter2 = npsFeedbackDialogFragment2.vg().getAdapter();
                Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
                b1 b1Var2 = (b1) adapter2;
                b1Var2.e = NpsFeedbackDialogFragment.this.sg(i);
                b1Var2.notifyDataSetChanged();
                NpsFeedbackDialogFragment.this.eg();
            }
        }
    }

    public static final class k implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            String str;
            String obj;
            String str2 = NpsFeedbackDialogFragment.this.d;
            StringBuilder sb = new StringBuilder();
            sb.append("afterTextChanged: ");
            if (editable != null && (obj = editable.toString()) != null) {
                i = obj.length();
            } else {
                i = 0;
            }
            sb.append(i);
            LogWrapper.debug(str2, sb.toString(), new Object[0]);
            NpsFeedbackDialogFragment npsFeedbackDialogFragment = NpsFeedbackDialogFragment.this;
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            npsFeedbackDialogFragment.mh(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qg(View view) {
        ToastUtils.showCommonToast("请评分后再提交");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k lh(NpsFeedbackDialogFragment npsFeedbackDialogFragment) {
        return npsFeedbackDialogFragment.new k();
    }

    public final void ah(STATE state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.f = state;
    }

    public final void ch(FiveStarScoreView fiveStarScoreView) {
        Intrinsics.checkNotNullParameter(fiveStarScoreView, "<set-?>");
        this.h = fiveStarScoreView;
    }

    public final void eh(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.l = editText;
    }

    public final void fh(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.k = recyclerView;
    }

    public final void gh(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.n = textView;
    }

    public final void hh(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.g = constraintLayout;
    }

    public final void ih(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.i = constraintLayout;
    }

    public final void jh(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.j = textView;
    }

    private final void Dg(View view) {
        ((ImageView) view.findViewById(2131820985)).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsFeedbackDialogFragment.Eg(NpsFeedbackDialogFragment.this, view2);
            }
        });
    }

    private final void Og(View view) {
        TextView textView = (TextView) view.findViewById(2131831329);
        textView.setText(this.a.researchTitle);
        gh(textView);
    }

    private final void Tg(View view) {
        ih((ConstraintLayout) view.findViewById(2131831764));
        jh((TextView) view.findViewById(2131831763));
    }

    public void o6(int i2) {
        LogWrapper.info(this.d, "onHeightChanged height:" + i2, new Object[0]);
    }

    private final void Fg(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131821115);
        constraintLayout.setClipToOutline(true);
        constraintLayout.setOutlineProvider(new d());
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsFeedbackDialogFragment.Gg(NpsFeedbackDialogFragment.this, view2);
            }
        });
        hh(constraintLayout);
        final ConstraintLayout findViewById = view.findViewById(2131831770);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsFeedbackDialogFragment.Hg(findViewById, this, view2);
            }
        });
    }

    private final void Kg(View view) {
        FiveStarScoreView fiveStarScoreView = (FiveStarScoreView) view.findViewById(2131826346);
        fiveStarScoreView.a2(UIKt.getDp(180), UIKt.getDp(32));
        fiveStarScoreView.setChangedListener(this.x);
        ch(fiveStarScoreView);
        com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
        hVar.j(hVar.f());
    }

    private final void Rg(View view) {
        fh((RecyclerView) view.findViewById(2131831167));
        vg().setAdapter(Cg());
        RecyclerView vg = vg();
        final Context context = getContext();
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(context) { // from class: com.dragon.read.nps.ui.NpsFeedbackDialogFragment$initRecyclerReasonList$1
            public boolean canScrollHorizontally() {
                return false;
            }

            public boolean canScrollVertically() {
                return false;
            }
        };
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setJustifyContent(2);
        flexboxLayoutManager.setAlignItems(2);
        vg.setLayoutManager(flexboxLayoutManager);
    }

    private final void Sg(View view) {
        SwipeBackLayout findViewById = view.findViewById(2131832974);
        findViewById.setMaskDrawEnabled(false);
        findViewById.setBackgroundDrawEnabled(false);
        findViewById.H(false);
        findViewById.B(new e());
        findViewById.B(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OptionInfo sg(int i2) {
        boolean contains$default;
        Map scoreOptionInfo = this.a.scoreOptionInfo;
        Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
        for (Map.Entry entry : scoreOptionInfo.entrySet()) {
            String str = (String) entry.getKey();
            OptionInfo optionInfo = (OptionInfo) entry.getValue();
            Intrinsics.checkNotNull(str);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) String.valueOf(i2), false, 2, (Object) null);
            if (contains$default) {
                return optionInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void og(STATE state) {
        LogWrapper.info(this.d, "changeState:" + com.dragon.read.nps.ui.h.a.d(), new Object[0]);
        if (state == STATE.enum_no_select_state) {
            Pg(getView());
        } else if (state == STATE.enum_high_score_state) {
            Lg();
        } else if (state == STATE.enum_low_score_without_edit_text) {
            Ng();
        } else if (state == STATE.enum_low_score_with_edit_text) {
            Mg();
        }
        View view = getView();
        if (view != null) {
            view.invalidate();
        }
        View view2 = getView();
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    public final void Ug(View view) {
        Intrinsics.checkNotNull(view);
        Fg(view);
        Sg(view);
        Og(view);
        Kg(view);
        Rg(view);
        Ig(view);
        Tg(view);
        Dg(view);
        Pg(view);
        if (SkinManager.isNightMode()) {
            LogWrapper.info(this.d, "NPS弹窗 黑夜模式", new Object[0]);
            bh(view);
        }
        Activity previousActivity = ActivityRecordManager.inst().getPreviousActivity();
        if (previousActivity != null) {
            eq2.b.h().onActivityResume(previousActivity);
        }
        if (com.dragon.read.nps.ui.h.a.f() != 0) {
            UIKt.addOnGlobalLayoutListener(view, new g(view, this));
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    private final void Pg(View view) {
        BrandTextButton findViewById;
        ViewGroup.LayoutParams layoutParams;
        LogWrapper.info(this.d, "call initNoSelectState", new Object[0]);
        ConstraintLayout xg = xg();
        if (xg != null && (layoutParams = xg.getLayoutParams()) != null) {
            layoutParams.height = rg();
        }
        TextView wg = wg();
        if (wg != null) {
            wg.setText(this.a.researchTitle);
        }
        ?? tg = tg();
        if (tg != 0) {
            ViewGroup.LayoutParams layoutParams2 = tg.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = this.q;
            tg.getLayoutParams().width = UIKt.getDp(260);
            tg.getLayoutParams().height = UIKt.getDp(40);
            tg.W1();
            tg.a2(UIKt.getDp(260), UIKt.getDp(40));
        }
        ConstraintLayout yg = yg();
        if (yg != null) {
            yg.setVisibility(0);
            ViewGroup.LayoutParams layoutParams3 = yg.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (ScreenUtils.getScreenWidth(yg.getContext()) / 2) - UIKt.getDp(50);
        }
        TextView zg = zg();
        if (zg != null) {
            String str = (String) this.a.scoreRemarks.get("0");
            if (str == null) {
                str = "轻触评分";
            }
            zg.setText(str);
        }
        RecyclerView vg = vg();
        if (vg != null) {
            vg.setVisibility(8);
        }
        EditText ug = ug();
        if (ug != null) {
            ug.setVisibility(8);
            ug.setFocusable(false);
        }
        if (view != null && (findViewById = view.findViewById(2131824953)) != null) {
            UIKt.setClickListener(findViewById, new View.OnClickListener() { // from class: com.dragon.read.nps.ui.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NpsFeedbackDialogFragment.Qg(view2);
                }
            });
            findViewById.setSelected(false);
        }
        this.f = STATE.enum_no_select_state;
    }

    private final void Zg(int i2) {
        Integer num;
        Integer b2 = com.dragon.read.nps.ui.h.a.b();
        if (b2 == null) {
            b2 = 0;
        }
        Args args = new Args();
        String str = vs4.p.a.a().get(b2);
        String str2 = null;
        if (str == null) {
            Map<String, String> map = this.c;
            UserResearchData userResearchData = this.a;
            if (userResearchData != null) {
                num = Integer.valueOf(userResearchData.sceneType);
            } else {
                num = null;
            }
            str = map.get(String.valueOf(num));
            if (str == null) {
                str = "unknown";
            }
        }
        args.put("position", str);
        args.put("score", String.valueOf(i2));
        args.put("research_title", this.a.researchTitle);
        UserResearchData userResearchData2 = this.a;
        if (userResearchData2 != null) {
            str2 = userResearchData2.researchId;
        }
        args.put("research_id", str2);
        Map scoreRemarks = this.a.scoreRemarks;
        Intrinsics.checkNotNullExpressionValue(scoreRemarks, "scoreRemarks");
        args.put("submit_content", CollectionKt.getOrNull(scoreRemarks, String.valueOf(i2)));
        args.put("read_duration", Long.valueOf(this.b.a()));
        args.put("listen_duration", Long.valueOf(this.b.b()));
        vs4.r rVar = vs4.r.a;
        String b3 = rVar.b();
        if (b3 != null) {
            args.put("book_id", b3);
        }
        String c2 = rVar.c();
        if (c2 != null) {
            args.put("group_id", c2);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        Args c3 = this.b.c();
        if (c3 != null) {
            args.putAll(c3);
        }
        ReportManager.onReport("nps_query_score_result", args);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bh(View view) {
        BrandTextButton findViewById;
        BrandTextButton findViewById2;
        EditText editText;
        Resources resources;
        TextView textView;
        ImageView imageView;
        Drawable drawable;
        Resources resources2;
        ImageView imageView2;
        ConstraintLayout findViewById3;
        if (view != null && (findViewById3 = view.findViewById(2131821115)) != null) {
            findViewById3.setBackground(new ColorDrawable(Color.parseColor("#242424")));
        }
        if (view != null && (imageView2 = (ImageView) view.findViewById(2131822181)) != null) {
            imageView2.setBackground(new ColorDrawable(Color.parseColor("#242424")));
        }
        Drawable drawable2 = null;
        if (view != null && (imageView = (ImageView) view.findViewById(2131820985)) != null) {
            Context context = getContext();
            if (context != null && (resources2 = context.getResources()) != null) {
                drawable = resources2.getDrawable(2130847435);
            } else {
                drawable = null;
            }
            imageView.setBackground(drawable);
        }
        if (view != null && (textView = (TextView) view.findViewById(2131831329)) != null) {
            textView.setTextColor(Color.parseColor("#CECECE"));
        }
        RecyclerView.Adapter adapter = vg().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        if (view != null && (editText = (EditText) view.findViewById(2131831064)) != null) {
            editText.setTextColor(-1);
            Context context2 = editText.getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                drawable2 = resources.getDrawable(2130848410);
            }
            editText.setBackground(drawable2);
            editText.setHintTextColor(Color.parseColor("#99FFFFFF"));
        }
        STATE state = this.f;
        if (state != STATE.enum_no_select_state && state != STATE.enum_init_state) {
            if (view != null && (findViewById2 = view.findViewById(2131824953)) != null) {
                findViewById2.setSelected(true);
                return;
            }
            return;
        }
        if (view != null && (findViewById = view.findViewById(2131824953)) != null) {
            findViewById.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dh(View view) {
        BrandTextButton findViewById;
        BrandTextButton findViewById2;
        EditText editText;
        Resources resources;
        TextView textView;
        ImageView imageView;
        Drawable drawable;
        Resources resources2;
        ImageView imageView2;
        ConstraintLayout findViewById3;
        if (view != null && (findViewById3 = view.findViewById(2131821115)) != null) {
            findViewById3.setBackground(new ColorDrawable(-1));
        }
        if (view != null && (imageView2 = (ImageView) view.findViewById(2131822181)) != null) {
            imageView2.setBackground(new ColorDrawable(-1));
        }
        Drawable drawable2 = null;
        if (view != null && (imageView = (ImageView) view.findViewById(2131820985)) != null) {
            Context context = getContext();
            if (context != null && (resources2 = context.getResources()) != null) {
                drawable = resources2.getDrawable(2130847439);
            } else {
                drawable = null;
            }
            imageView.setBackground(drawable);
        }
        if (view != null && (textView = (TextView) view.findViewById(2131831329)) != null) {
            textView.setTextColor(-16777216);
        }
        RecyclerView.Adapter adapter = vg().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        if (view != null && (editText = (EditText) view.findViewById(2131831064)) != null) {
            editText.setTextColor(-16777216);
            Context context2 = editText.getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                drawable2 = resources.getDrawable(2130848411);
            }
            editText.setBackground(drawable2);
            editText.setHintTextColor(Color.parseColor("#66000000"));
        }
        STATE state = this.f;
        if (state != STATE.enum_no_select_state && state != STATE.enum_init_state) {
            if (view != null && (findViewById2 = view.findViewById(2131824953)) != null) {
                findViewById2.setSelected(true);
                return;
            }
            return;
        }
        if (view != null && (findViewById = view.findViewById(2131824953)) != null) {
            findViewById.setSelected(false);
        }
    }

    public void Ig(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        EditText editText = (EditText) root.findViewById(2131831064);
        Intrinsics.checkNotNull(editText);
        UIKt.setMaxLength(editText, Integer.valueOf(this.e + 1));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.dragon.read.nps.ui.s
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                NpsFeedbackDialogFragment.Jg(NpsFeedbackDialogFragment.this, view, z);
            }
        });
        eh(editText);
        this.m = root.findViewById(2131820846);
        com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
        if (hVar.c() != null) {
            ug().setText(hVar.c());
        }
        Map scoreOptionInfo = this.a.scoreOptionInfo;
        Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
        Iterator it2 = scoreOptionInfo.entrySet().iterator();
        if (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            OptionInfo optionInfo = (OptionInfo) entry.getValue();
            ug().setHint(optionInfo.optionNameWithInput + "...");
        }
        ug().addTextChangedListener(Ag());
        mh(ug().getText().toString(), false);
    }

    public final void kh(int i2) {
        if (i2 > 0 && i2 <= 5) {
            tg().e2(i2);
            if (sg(i2) == null) {
                og(STATE.enum_high_score_state);
                ConstraintLayout yg = yg();
                ViewGroup.LayoutParams layoutParams = yg.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ((ScreenUtils.getScreenWidth(yg.getContext()) / 2) - UIKt.getDp(50)) + ((i2 - 3) * UIKt.getDp(55));
                zg().setText((CharSequence) this.a.scoreRemarks.get(String.valueOf(i2)));
                return;
            }
            RecyclerView.Adapter adapter = vg().getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
            b1 b1Var = (b1) adapter;
            b1Var.e = sg(i2);
            b1Var.notifyDataSetChanged();
            if (com.dragon.read.nps.ui.h.a.d()) {
                og(STATE.enum_low_score_with_edit_text);
            } else {
                og(STATE.enum_low_score_without_edit_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, View view) {
        npsFeedbackDialogFragment.Bg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wg(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, View view) {
        ActivityAnimType.FADE_IN_FADE_OUT.finish(npsFeedbackDialogFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ig(NpsFeedbackDialogFragment npsFeedbackDialogFragment, ValueAnimator valueAnimator) {
        ConstraintLayout yg = npsFeedbackDialogFragment.yg();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        yg.setAlpha(1.0f - ((Float) animatedValue).floatValue());
        RecyclerView vg = npsFeedbackDialogFragment.vg();
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        vg.setAlpha(((Float) animatedValue2).floatValue());
        if (com.dragon.read.nps.ui.h.a.d()) {
            EditText ug = npsFeedbackDialogFragment.ug();
            Object animatedValue3 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
            ug.setAlpha(((Float) animatedValue3).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ng(NpsFeedbackDialogFragment npsFeedbackDialogFragment, ValueAnimator valueAnimator) {
        ConstraintLayout yg = npsFeedbackDialogFragment.yg();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        yg.setAlpha(((Float) animatedValue).floatValue());
        RecyclerView vg = npsFeedbackDialogFragment.vg();
        float f2 = 1;
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        vg.setAlpha(f2 - ((Float) animatedValue2).floatValue());
        if (com.dragon.read.nps.ui.h.a.d()) {
            EditText ug = npsFeedbackDialogFragment.ug();
            Object animatedValue3 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
            ug.setAlpha(f2 - ((Float) animatedValue3).floatValue());
        }
    }

    public NpsFeedbackDialogFragment(UserResearchData data, a npsListener) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(npsListener, "npsListener");
        this.a = data;
        this.b = npsListener;
        this.c = C2FeedNpsReportConfig.a.a().scenePositionMapping;
        this.d = "NPS_GLOBAL | NPS_FEEDBACK_DIALOG";
        this.e = 500;
        this.f = STATE.enum_init_state;
        this.o = UIKt.getDp(0);
        this.p = UIKt.getDp(38);
        this.q = UIKt.getDp(32);
        this.r = UIKt.getDp(12);
        this.s = UIKt.getDp(75);
        this.t = UIKt.getDp(43);
        this.u = UIKt.getDp(28);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.nps.ui.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NpsFeedbackDialogFragment.k lh;
                lh = NpsFeedbackDialogFragment.lh(NpsFeedbackDialogFragment.this);
                return lh;
            }
        });
        this.v = lazy;
        this.w = new i();
        this.x = new j();
        this.y = new View.OnClickListener() { // from class: com.dragon.read.nps.ui.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NpsFeedbackDialogFragment.pg(NpsFeedbackDialogFragment.this, view);
            }
        };
        this.z = new h();
    }

    private final void Yg(int i2, String str) {
        boolean z;
        Integer num;
        if (i2 <= 3) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Integer b2 = com.dragon.read.nps.ui.h.a.b();
                if (b2 == null) {
                    b2 = 0;
                }
                Args args = new Args();
                String str2 = vs4.p.a.a().get(b2);
                String str3 = null;
                if (str2 == null) {
                    Map<String, String> map = this.c;
                    UserResearchData userResearchData = this.a;
                    if (userResearchData != null) {
                        num = Integer.valueOf(userResearchData.sceneType);
                    } else {
                        num = null;
                    }
                    str2 = map.get(String.valueOf(num));
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                }
                args.put("position", str2);
                args.put("score", String.valueOf(i2));
                UserResearchData userResearchData2 = this.a;
                if (userResearchData2 != null) {
                    str3 = userResearchData2.researchId;
                }
                args.put("research_id", str3);
                args.put("research_title", this.a.researchTitle);
                args.put("reason", str);
                Map scoreRemarks = this.a.scoreRemarks;
                Intrinsics.checkNotNullExpressionValue(scoreRemarks, "scoreRemarks");
                args.put("submit_content", CollectionKt.getOrNull(scoreRemarks, String.valueOf(i2)));
                args.put("read_duration", Long.valueOf(this.b.a()));
                args.put("listen_duration", Long.valueOf(this.b.b()));
                vs4.r rVar = vs4.r.a;
                String b3 = rVar.b();
                if (b3 != null) {
                    args.put("book_id", b3);
                }
                String c2 = rVar.c();
                if (c2 != null) {
                    args.put("group_id", c2);
                }
                if (rVar.d() != -1) {
                    args.put("group_index", Integer.valueOf(rVar.d()));
                }
                Args c3 = this.b.c();
                if (c3 != null) {
                    args.putAll(c3);
                }
                ReportManager.onReport("nps_query_reason_result", args);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    public static final void hg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, ValueAnimator valueAnimator) {
        int dp = UIKt.getDp(260) - UIKt.getDp(164);
        int dp2 = UIKt.getDp(40) - UIKt.getDp(28);
        int i2 = npsFeedbackDialogFragment.q - npsFeedbackDialogFragment.r;
        float dp3 = UIKt.getDp(260);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = dp3 - (dp * ((Float) animatedValue).floatValue());
        float dp5 = UIKt.getDp(40);
        float f2 = dp2;
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = dp5 - (f2 * ((Float) animatedValue2).floatValue());
        float f3 = npsFeedbackDialogFragment.q;
        Object animatedValue3 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        float floatValue3 = f3 - (i2 * ((Float) animatedValue3).floatValue());
        ?? tg = npsFeedbackDialogFragment.tg();
        ViewGroup.LayoutParams layoutParams = tg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) floatValue3;
        int i3 = (int) floatValue;
        tg.getLayoutParams().width = i3;
        int i4 = (int) floatValue2;
        tg.getLayoutParams().height = i4;
        tg.a2(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.ViewGroup, com.dragon.read.nps.ui.FiveStarScoreView] */
    public static final void mg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, ValueAnimator valueAnimator) {
        int dp = UIKt.getDp(260) - UIKt.getDp(164);
        int dp2 = UIKt.getDp(40) - UIKt.getDp(28);
        int i2 = npsFeedbackDialogFragment.q - npsFeedbackDialogFragment.r;
        float dp3 = UIKt.getDp(164);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = dp3 + (dp * ((Float) animatedValue).floatValue());
        float dp5 = UIKt.getDp(28);
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = dp5 + (dp2 * ((Float) animatedValue2).floatValue());
        float f2 = npsFeedbackDialogFragment.r;
        Object animatedValue3 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        float floatValue3 = f2 + (i2 * ((Float) animatedValue3).floatValue());
        ?? tg = npsFeedbackDialogFragment.tg();
        ViewGroup.LayoutParams layoutParams = tg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) floatValue3;
        int i3 = (int) floatValue;
        tg.getLayoutParams().width = i3;
        int i4 = (int) floatValue2;
        tg.getLayoutParams().height = i4;
        tg.a2(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mh(String str, boolean z) {
        int length = str.length();
        if (length > this.e) {
            ScaleTextView scaleTextView = this.m;
            if (scaleTextView != null) {
                Context context = getContext();
                if (context == null) {
                    context = AppUtils.context();
                }
                scaleTextView.setTextColor(context.getResources().getColor(2131560567));
            }
        } else {
            ScaleTextView scaleTextView2 = this.m;
            if (scaleTextView2 != null) {
                scaleTextView2.setTextColor(SkinDelegate.getColor(getContext(), 2131558445));
            }
        }
        if (length > this.e - 10) {
            ScaleTextView scaleTextView3 = this.m;
            if (scaleTextView3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.length());
                sb.append('/');
                sb.append(this.e);
                scaleTextView3.setText(sb.toString());
            }
            ScaleTextView scaleTextView4 = this.m;
            if (scaleTextView4 != null) {
                UIKt.visible(scaleTextView4);
            }
            if (ug().getPaddingBottom() != UIKt.getDp(25)) {
                UIKt.updatePadding$default(ug(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(25)), 7, (Object) null);
            }
        } else {
            ScaleTextView scaleTextView5 = this.m;
            if (scaleTextView5 != null) {
                UIKt.gone(scaleTextView5);
            }
            if (ug().getPaddingBottom() != UIKt.getDp(12)) {
                UIKt.updatePadding$default(ug(), (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(UIKt.getDp(12)), 7, (Object) null);
            }
        }
        if (str.length() > this.e && z) {
            ToastUtils.showCommonToast("最多输入" + this.e + "个字");
            ug().setSelection(this.e + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, View view) {
        int i2;
        String str;
        String obj;
        if (!NetworkUtils.isNetworkAvailable()) {
            ToastUtils.showCommonToast(npsFeedbackDialogFragment.getString(2131107331));
            return;
        }
        Editable text = npsFeedbackDialogFragment.ug().getText();
        if (text != null && (obj = text.toString()) != null) {
            i2 = obj.length();
        } else {
            i2 = 0;
        }
        if (i2 > npsFeedbackDialogFragment.e) {
            LogWrapper.debug(npsFeedbackDialogFragment.d, "handleSubmit: 字数超过" + npsFeedbackDialogFragment.e, new Object[0]);
            ToastUtils.showCommonToast("最多输入" + npsFeedbackDialogFragment.e + "个字");
            return;
        }
        String str2 = "";
        for (Map.Entry<String, Boolean> entry : com.dragon.read.nps.ui.h.a.e().entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                str2 = str2 + ' ' + key;
                npsFeedbackDialogFragment.Yg(com.dragon.read.nps.ui.h.a.f(), key);
            }
        }
        com.dragon.read.nps.ui.h hVar = com.dragon.read.nps.ui.h.a;
        if (hVar.d()) {
            str2 = str2 + " [吐槽内容]" + ((Object) npsFeedbackDialogFragment.ug().getText());
            hVar.h(npsFeedbackDialogFragment.ug().getText().toString());
            StringBuilder sb = new StringBuilder();
            OptionInfo sg = npsFeedbackDialogFragment.sg(npsFeedbackDialogFragment.a.scoreOptionInfo.size());
            if (sg == null || (str = sg.optionNameWithInput) == null) {
                str = "我要吐槽";
            }
            sb.append(str);
            sb.append(':');
            String sb2 = sb.toString();
            String c2 = hVar.c();
            if (c2 != null) {
                npsFeedbackDialogFragment.Yg(hVar.f(), sb2 + c2);
            }
        }
        npsFeedbackDialogFragment.b.onCommit();
        npsFeedbackDialogFragment.Zg(hVar.f());
        LogWrapper.info(npsFeedbackDialogFragment.d, "提交评分:" + hVar.f() + "|标签:" + str2, new Object[0]);
        npsFeedbackDialogFragment.Vg();
        ToastUtils.showCommonToast("提交成功，感谢反馈");
        npsFeedbackDialogFragment.Bg();
        ActivityAnimType.FADE_IN_FADE_OUT.finish(npsFeedbackDialogFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, View view, boolean z) {
        LogWrapper.info(npsFeedbackDialogFragment.d, "isFocus:" + z + ' ' + view, new Object[0]);
    }

    public View onCreateContent(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LogWrapper.info(this.d, "NPS弹窗 onCreateContent", new Object[0]);
        View inflate = inflater.inflate(2131038815, viewGroup, false);
        Ug(inflate);
        App.registerLocalReceiver(this.z, new String[]{"action_skin_type_change"});
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hg(ConstraintLayout constraintLayout, NpsFeedbackDialogFragment npsFeedbackDialogFragment, View view) {
        if (ScreenUtils.getScreenHeight(constraintLayout.getContext()) - view.getHeight() > UIKt.getDp(200)) {
            Object systemService = constraintLayout.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(npsFeedbackDialogFragment.ug().getWindowToken(), 0);
            ActivityAnimType.FADE_IN_FADE_OUT.finish(npsFeedbackDialogFragment.getActivity());
            return;
        }
        ActivityAnimType.FADE_IN_FADE_OUT.finish(npsFeedbackDialogFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fg(final NpsFeedbackDialogFragment npsFeedbackDialogFragment, final int i2, final int i3, final ValueAnimator it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        new Runnable() { // from class: com.dragon.read.nps.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.gg(NpsFeedbackDialogFragment.this, i2, it2, i3);
            }
        }.run();
        new Runnable() { // from class: com.dragon.read.nps.ui.p
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.hg(NpsFeedbackDialogFragment.this, it2);
            }
        }.run();
        new Runnable() { // from class: com.dragon.read.nps.ui.q
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.ig(NpsFeedbackDialogFragment.this, it2);
            }
        }.run();
        View view = npsFeedbackDialogFragment.getView();
        if (view != null) {
            view.invalidate();
        }
        View view2 = npsFeedbackDialogFragment.getView();
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, int i2, ValueAnimator valueAnimator, int i3) {
        float dp = (npsFeedbackDialogFragment.s + i2) - UIKt.getDp(8);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        npsFeedbackDialogFragment.xg().getLayoutParams().height = i3 + ((int) (dp * ((Float) animatedValue).floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kg(final NpsFeedbackDialogFragment npsFeedbackDialogFragment, final int i2, final int i3, final ValueAnimator it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        new Runnable() { // from class: com.dragon.read.nps.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.lg(NpsFeedbackDialogFragment.this, i2, it2, i3);
            }
        }.run();
        new Runnable() { // from class: com.dragon.read.nps.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.mg(NpsFeedbackDialogFragment.this, it2);
            }
        }.run();
        new Runnable() { // from class: com.dragon.read.nps.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                NpsFeedbackDialogFragment.ng(NpsFeedbackDialogFragment.this, it2);
            }
        }.run();
        View view = npsFeedbackDialogFragment.getView();
        if (view != null) {
            view.invalidate();
        }
        View view2 = npsFeedbackDialogFragment.getView();
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lg(NpsFeedbackDialogFragment npsFeedbackDialogFragment, int i2, ValueAnimator valueAnimator, int i3) {
        float dp = (npsFeedbackDialogFragment.s + i2) - UIKt.getDp(8);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        npsFeedbackDialogFragment.xg().getLayoutParams().height = i3 - ((int) (dp * ((Float) animatedValue).floatValue()));
    }
}

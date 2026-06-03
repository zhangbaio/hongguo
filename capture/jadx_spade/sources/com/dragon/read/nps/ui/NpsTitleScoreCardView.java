package com.dragon.read.nps.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.AbsBroadcastReceiver;
import com.dragon.read.base.Args;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.nps.ui.FiveStarScoreView;
import com.dragon.read.nps.ui.NpsFeedbackDialogFragment;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.ResearchEvent;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserEventReportRequest;
import com.dragon.read.rpc.model.UserEventReportType;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.util.UiUtils;
import com.dragon.read.util.kotlin.UIKt;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import vs4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NpsTitleScoreCardView extends ConstraintLayout implements vs4.d {
    public static final int p;
    private d.a g;
    private d.c h;
    private UserResearchData i;
    private int j;
    private int k;
    private int l;
    private ResearchSceneType m;
    private final String n;
    private final AbsBroadcastReceiver o;

    static {
        Covode.recordClassIndex(612582);
        p = 8;
    }

    public static final class b extends ViewOutlineProvider {
        b() {
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
                outline.setRoundRect(0, 0, i, i2, UIKt.getDp(8));
            }
        }
    }

    private final void f2() {
        vs4.n.a.h();
    }

    public static final class d implements FiveStarScoreView.a {
        final /* synthetic */ FiveStarScoreView b;

        public static final class a implements NpsFeedbackDialogFragment.a {
            final /* synthetic */ NpsTitleScoreCardView a;
            final /* synthetic */ FiveStarScoreView b;

            @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
            public long a() {
                Long todayReadingTime = NsCommonDepend.IMPL.getTodayReadingTime();
                Intrinsics.checkNotNullExpressionValue(todayReadingTime, "getTodayReadingTime(...)");
                return todayReadingTime.longValue();
            }

            @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
            public long b() {
                Long todayAudioTime = NsCommonDepend.IMPL.getTodayAudioTime();
                Intrinsics.checkNotNullExpressionValue(todayAudioTime, "getTodayAudioTime(...)");
                return todayAudioTime.longValue();
            }

            @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
            public Args c() {
                d.a aVar = this.a.g;
                if (aVar != null) {
                    return aVar.c();
                }
                return null;
            }

            @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
            public void onCommit() {
                LogWrapper.info(this.a.n, "收到提交消息，卡片将关闭", new Object[0]);
                this.a.g2();
                d.c cVar = this.a.h;
                if (cVar != null) {
                    cVar.onCommit();
                }
            }

            @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
            public void d(int i) {
                LogWrapper.info(this.a.n, "星星数量变更，卡片星星将调整：" + i, new Object[0]);
                this.b.e2(i);
            }

            a(NpsTitleScoreCardView npsTitleScoreCardView, FiveStarScoreView fiveStarScoreView) {
                this.a = npsTitleScoreCardView;
                this.b = fiveStarScoreView;
            }
        }

        @Override // com.dragon.read.nps.ui.FiveStarScoreView.a
        public void onChanged(int i) {
            LogWrapper.info(NpsTitleScoreCardView.this.n, "NPS卡片分数发生变化，打开弹窗:" + NpsTitleScoreCardView.this.i, new Object[0]);
            h.a.j(i);
            vs4.f fVar = vs4.f.a;
            UserResearchData userResearchData = NpsTitleScoreCardView.this.i;
            Intrinsics.checkNotNull(userResearchData);
            fVar.a(userResearchData, new a(NpsTitleScoreCardView.this, this.b));
            d.c cVar = NpsTitleScoreCardView.this.h;
            if (cVar != null) {
                cVar.b();
            }
        }

        d(FiveStarScoreView fiveStarScoreView) {
            this.b = fiveStarScoreView;
        }
    }

    public static final class c implements NpsFeedbackDialogFragment.a {
        final /* synthetic */ ConstraintLayout b;

        @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
        public long a() {
            Long todayReadingTime = NsCommonDepend.IMPL.getTodayReadingTime();
            Intrinsics.checkNotNullExpressionValue(todayReadingTime, "getTodayReadingTime(...)");
            return todayReadingTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
        public long b() {
            Long todayAudioTime = NsCommonDepend.IMPL.getTodayAudioTime();
            Intrinsics.checkNotNullExpressionValue(todayAudioTime, "getTodayAudioTime(...)");
            return todayAudioTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
        public Args c() {
            d.a aVar = NpsTitleScoreCardView.this.g;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }

        @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
        public void onCommit() {
            LogWrapper.info(NpsTitleScoreCardView.this.n, "收到提交消息，卡片将关闭", new Object[0]);
            NpsTitleScoreCardView.this.g2();
            d.c cVar = NpsTitleScoreCardView.this.h;
            if (cVar != null) {
                cVar.onCommit();
            }
        }

        @Override // com.dragon.read.nps.ui.NpsFeedbackDialogFragment.a
        public void d(int i) {
            LogWrapper.info(NpsTitleScoreCardView.this.n, "星星数量变更，卡片星星将调整：" + i, new Object[0]);
            ((FiveStarScoreView) this.b.findViewById(2131826346)).e2(i);
        }

        c(ConstraintLayout constraintLayout) {
            this.b = constraintLayout;
        }
    }

    private final void q2() {
        l2();
        j2();
        n2();
        p2();
        E2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        App.registerLocalReceiver(this.o, new String[]{"action_skin_type_change"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        App.unregisterLocalReceiver(new BroadcastReceiver[]{this.o});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l2() {
        final ConstraintLayout findViewById = findViewById(2131821115);
        findViewById.setClipToOutline(true);
        findViewById.setOutlineProvider(new b());
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NpsTitleScoreCardView.m2(NpsTitleScoreCardView.this, findViewById, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p2() {
        String str;
        TextView textView = (TextView) findViewById(2131820710);
        UserResearchData userResearchData = this.i;
        if (userResearchData == null || (str = userResearchData.researchTitle) == null) {
            str = "";
        }
        textView.setText(str);
    }

    @Override // vs4.d
    public void onShow() {
        LogWrapper.info(this.n, "NPS标题分数卡片曝光展示", new Object[0]);
        i2();
        v2();
        f2();
    }

    private final void i2() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        UserResearchData userResearchData = this.i;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = true;
        researchEvent.isSubmitted = false;
        userEventReportRequest.researchEvent = researchEvent;
        g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io()).subscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j2() {
        A2(getContext().getResources().getColor(2131558447));
        ((ImageView) findViewById(2131827188)).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NpsTitleScoreCardView.k2(NpsTitleScoreCardView.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n2() {
        FiveStarScoreView fiveStarScoreView = (FiveStarScoreView) findViewById(2131826346);
        fiveStarScoreView.setStarSelectUIChange(false);
        fiveStarScoreView.a2(UIKt.getDp(108), UIKt.getDp(20));
        fiveStarScoreView.setChangedListener(new d(fiveStarScoreView));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w2() {
        ConstraintLayout findViewById = findViewById(2131821115);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        findViewById.setLayoutParams(findViewById.getLayoutParams());
        UiUtils.updateLayoutMargin((TextView) findViewById(2131820710), -3, UIKt.getDp(16), -3, UIKt.getDp(16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void g2() {
        int dp;
        ConstraintLayout findViewById = findViewById(2131821115);
        if (findViewById.getLayoutParams().height == -2 && findViewById.getHeight() > 0) {
            dp = findViewById.getHeight();
        } else {
            dp = UIKt.getDp(76);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ValueAnimator ofInt = ValueAnimator.ofInt(dp, 0);
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dragon.read.nps.ui.a1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NpsTitleScoreCardView.h2(layoutParams, this, valueAnimator);
            }
        });
        ofInt.addListener(new a());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofInt);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o2() {
        Context context;
        UserResearchData t = vs4.n.a.t();
        this.i = t;
        if (t == null) {
            Context context2 = getContext();
            vs4.r rVar = vs4.r.a;
            WeakReference<Context> j = rVar.j();
            if (j != null) {
                context = j.get();
            } else {
                context = null;
            }
            if (Intrinsics.areEqual(context2, context)) {
                LogWrapper.info(this.n, "取得ReaderNpsDataCacher缓存Data", new Object[0]);
                this.i = rVar.e();
            }
        }
        if (this.i == null) {
            LogWrapper.info(this.n, "getNpsData 为空，卡片不展示", new Object[0]);
            setVisibility(8);
        }
    }

    private final void r2() {
        String str;
        Args c2;
        String str2 = vs4.p.a.a().get(this.m);
        if (str2 == null) {
            str2 = "unknown";
        }
        Args args = new Args();
        args.put("position", str2);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.i;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c3 = rVar.c();
        if (c3 != null) {
            args.put("group_id", c3);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        d.a aVar = this.g;
        if (aVar != null && (c2 = aVar.c()) != null) {
            args.putAll(c2);
        }
        ReportManager.onReport("nps_query_close", args);
    }

    private final void v2() {
        String str;
        Args c2;
        String str2 = vs4.p.a.a().get(this.m);
        if (str2 == null) {
            str2 = "unknown";
        }
        Args args = new Args();
        args.put("position", str2);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.i;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c3 = rVar.c();
        if (c3 != null) {
            args.put("group_id", c3);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        d.a aVar = this.g;
        if (aVar != null && (c2 = aVar.c()) != null) {
            args.putAll(c2);
        }
        ReportManager.onReport("nps_query_show", args);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E2() {
        ((FiveStarScoreView) findViewById(2131826346)).c2();
        if (SkinManager.isNightMode()) {
            if (this.k == 0) {
                ((TextView) findViewById(2131820710)).setTextColor(Color.parseColor("#CCFFFFFF"));
            }
            if (this.j == 0) {
                findViewById(2131821115).setBackground(new ColorDrawable(getContext().getResources().getColor(2131561869)));
            }
            if (this.l == 0) {
                A2(getContext().getResources().getColor(2131562011));
                return;
            }
            return;
        }
        if (this.k == 0) {
            ((TextView) findViewById(2131820710)).setTextColor(-16777216);
        }
        if (this.j == 0) {
            findViewById(2131821115).setBackground(new ColorDrawable(-1));
        }
        if (this.l == 0) {
            A2(getContext().getResources().getColor(2131558447));
        }
    }

    public static final class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            NpsTitleScoreCardView.this.getLayoutParams().height = 0;
            NpsTitleScoreCardView.this.setVisibility(8);
            d.a aVar = NpsTitleScoreCardView.this.g;
            if (aVar != null) {
                aVar.onClose();
            }
        }
    }

    public static final class e extends AbsBroadcastReceiver {
        e() {
        }

        public void onReceive(Context context, Intent intent, String action) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(action, "action");
            if (Intrinsics.areEqual(action, "action_skin_type_change")) {
                NpsTitleScoreCardView.this.E2();
            }
        }
    }

    public final void B2(int i) {
        A2(i);
        this.l = i;
    }

    public void setListener(d.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public void setOperationListener(d.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.h = listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F2(int i) {
        ((TextView) findViewById(2131820710)).setTextColor(i);
        this.k = i;
    }

    public final void setScene(ResearchSceneType scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.m = scene;
        h.a.g(scene);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateData(UserResearchData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.i = data;
        q2();
        setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x2(int i) {
        findViewById(2131821115).setBackground(new ColorDrawable(i));
        this.j = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A2(int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), 2130845577);
        if (drawable != null) {
            drawable.mutate();
        }
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
        ((ImageView) findViewById(2131827188)).setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(NpsTitleScoreCardView npsTitleScoreCardView, View view) {
        npsTitleScoreCardView.g2();
        npsTitleScoreCardView.r2();
        d.c cVar = npsTitleScoreCardView.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NpsTitleScoreCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.m = ResearchSceneType.BookStoreMainFeed;
        this.n = "NPS_GLOBAL | NPS_TITLE_SCORE_CARD";
        this.o = new e();
        LogWrapper.info("NPS_GLOBAL | NPS_TITLE_SCORE_CARD", "NpsTitleScoreCardView 初始化 context:" + context, new Object[0]);
        ViewGroup.inflate(context, 2131038817, this);
        o2();
        q2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h2(ViewGroup.LayoutParams layoutParams, NpsTitleScoreCardView npsTitleScoreCardView, ValueAnimator it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        Object animatedValue = it2.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        npsTitleScoreCardView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(NpsTitleScoreCardView npsTitleScoreCardView, ConstraintLayout constraintLayout, View view) {
        LogWrapper.info(npsTitleScoreCardView.n, "点击空白区域，打开默认弹窗", new Object[0]);
        h.a.j(0);
        vs4.f fVar = vs4.f.a;
        UserResearchData userResearchData = npsTitleScoreCardView.i;
        Intrinsics.checkNotNull(userResearchData);
        fVar.a(userResearchData, npsTitleScoreCardView.new c(constraintLayout));
        d.c cVar = npsTitleScoreCardView.h;
        if (cVar != null) {
            cVar.b();
        }
    }
}

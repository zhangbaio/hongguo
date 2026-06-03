package com.dragon.read.component.shortvideo.danmaku;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ui.util.ViewUtil;
import com.dragon.read.base.ui.util.callback.SimpleAnimatorListener;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.component.biz.api.NsCommunityApi;
import com.dragon.read.component.shortvideo.danmaku.PublishDanmakuEntranceView;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.impl.config.HeaderViewTagBgColorOptV691;
import com.dragon.read.component.shortvideo.impl.rightview.comment.ICommentDialogHelperApi;
import com.dragon.read.component.shortvideo.impl.rightview.x2;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.util.UiUtils;
import com.dragon.read.util.kotlin.ResourcesKt;
import com.dragon.read.util.kotlin.UIKt;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.messagebus.Subscriber;
import jz2.y;
import k92.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import ns3.l;
import org.json.JSONObject;
import rq3.n;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PublishDanmakuEntranceView extends ConstraintLayout {
    public static final a t;
    public static final int u;
    private static final Lazy<SharedPreferences> v;
    private b g;
    private Runnable h;
    private MessageQueue.IdleHandler i;
    private Runnable j;
    private ValueAnimator k;
    private ValueAnimator l;
    private final ImageView m;
    private final View n;
    private final int o;
    private final boolean p;
    private Boolean q;
    private ViewTreeObserver.OnPreDrawListener r;
    private final Runnable s;

    public interface b {
        com.dragon.read.pages.video.a a();

        cp3.b b();

        String getSeriesId();

        String getVideoId();

        int getVideoScene();
    }

    public static final class c extends l {

        public static final class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LogWrapper.info("PublishDanmakuEntranceView", "doHideGuideAnimation onAnimationEnd hideGuideAlphaAnimator", new Object[0]);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LogWrapper.info("PublishDanmakuEntranceView", "doHideGuideAnimation onAnimationStart hideGuideAlphaAnimator", new Object[0]);
            }
        }

        c() {
        }

        public void onTransitionEnd(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
            LogWrapper.info("PublishDanmakuEntranceView", "doHideGuideAnimation onTransitionEnd", new Object[0]);
        }

        public void onTransitionStart(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
            LogWrapper.info("PublishDanmakuEntranceView", "doHideGuideAnimation onTransitionStart", new Object[0]);
            PublishDanmakuEntranceView.this.l = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(150L);
            ValueAnimator valueAnimator = PublishDanmakuEntranceView.this.l;
            if (valueAnimator != null) {
                final PublishDanmakuEntranceView publishDanmakuEntranceView = PublishDanmakuEntranceView.this;
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ns3.i
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        PublishDanmakuEntranceView.c.b(PublishDanmakuEntranceView.this, valueAnimator2);
                    }
                });
            }
            ValueAnimator valueAnimator2 = PublishDanmakuEntranceView.this.l;
            if (valueAnimator2 != null) {
                valueAnimator2.addListener(new a());
            }
            ValueAnimator valueAnimator3 = PublishDanmakuEntranceView.this.l;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PublishDanmakuEntranceView publishDanmakuEntranceView, ValueAnimator it2) {
            Float f;
            float f2;
            float coerceAtLeast;
            float coerceAtMost;
            Intrinsics.checkNotNullParameter(it2, "it");
            Object animatedValue = it2.getAnimatedValue();
            if (animatedValue instanceof Float) {
                f = (Float) animatedValue;
            } else {
                f = null;
            }
            if (f != null) {
                f2 = f.floatValue();
            } else {
                f2 = 1.0f;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f2, 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
            publishDanmakuEntranceView.n.setAlpha(coerceAtMost);
            publishDanmakuEntranceView.m.setAlpha(1 - coerceAtMost);
        }
    }

    public static final class d extends l {

        public static final class a extends SimpleAnimatorListener {
            a() {
            }

            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LogWrapper.info("PublishDanmakuEntranceView", "doShowGuideAnimation onAnimationEnd showGuideAlphaAnimator", new Object[0]);
            }

            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                LogWrapper.info("PublishDanmakuEntranceView", "doShowGuideAnimation onAnimationStart showGuideAlphaAnimator", new Object[0]);
            }
        }

        d() {
        }

        public void onTransitionEnd(Transition transition) {
            boolean z;
            Intrinsics.checkNotNullParameter(transition, "transition");
            LogWrapper.info("PublishDanmakuEntranceView", "doShowGuideAnimation onTransitionEnd", new Object[0]);
            a aVar = PublishDanmakuEntranceView.t;
            SharedPreferences b = aVar.b();
            Intrinsics.checkNotNullExpressionValue(b, "access$getKv(...)");
            PublishDanmakuEntranceView publishDanmakuEntranceView = PublishDanmakuEntranceView.this;
            SharedPreferences.Editor edit = b.edit();
            b depend = publishDanmakuEntranceView.getDepend();
            if (depend != null && depend.getVideoScene() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                edit.putInt("outer_show_count", aVar.b().getInt("outer_show_count", 0) + 1);
            } else {
                edit.putInt("show_count", aVar.b().getInt("show_count", 0) + 1);
            }
            edit.apply();
        }

        public void onTransitionStart(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
            LogWrapper.info("PublishDanmakuEntranceView", "doShowGuideAnimation onTransitionStart", new Object[0]);
            PublishDanmakuEntranceView.this.k = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
            ValueAnimator valueAnimator = PublishDanmakuEntranceView.this.k;
            if (valueAnimator != null) {
                final PublishDanmakuEntranceView publishDanmakuEntranceView = PublishDanmakuEntranceView.this;
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ns3.j
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        PublishDanmakuEntranceView.d.b(PublishDanmakuEntranceView.this, valueAnimator2);
                    }
                });
            }
            ValueAnimator valueAnimator2 = PublishDanmakuEntranceView.this.k;
            if (valueAnimator2 != null) {
                valueAnimator2.addListener(new a());
            }
            ValueAnimator valueAnimator3 = PublishDanmakuEntranceView.this.k;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PublishDanmakuEntranceView publishDanmakuEntranceView, ValueAnimator it2) {
            Float f;
            float f2;
            float coerceAtLeast;
            float coerceAtMost;
            Intrinsics.checkNotNullParameter(it2, "it");
            Object animatedValue = it2.getAnimatedValue();
            if (animatedValue instanceof Float) {
                f = (Float) animatedValue;
            } else {
                f = null;
            }
            if (f != null) {
                f2 = f.floatValue();
            } else {
                f2 = 1.0f;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f2, 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
            publishDanmakuEntranceView.n.setAlpha(coerceAtMost);
            publishDanmakuEntranceView.m.setAlpha(1 - coerceAtMost);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishDanmakuEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final b getDepend() {
        return this.g;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599014);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SharedPreferences b() {
            return (SharedPreferences) PublishDanmakuEntranceView.v.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences H2() {
        return KvCacheMgr.getPrivate(App.context(), "video_danmaku_publish_guide");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.p) {
            BusProvider.register(this);
        }
    }

    public static final class f implements ViewTreeObserver.OnPreDrawListener {
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!UiUtils.isViewVisibleRatioMeetReqCompat(PublishDanmakuEntranceView.this, 0.0f)) {
                return true;
            }
            PublishDanmakuEntranceView.this.E2();
            PublishDanmakuEntranceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            PublishDanmakuEntranceView.this.r = null;
            return true;
        }

        f() {
        }
    }

    public static final class g implements MessageQueue.IdleHandler {
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            final PublishDanmakuEntranceView publishDanmakuEntranceView = PublishDanmakuEntranceView.this;
            publishDanmakuEntranceView.j = new Runnable() { // from class: ns3.k
                @Override // java.lang.Runnable
                public final void run() {
                    PublishDanmakuEntranceView.g.b(PublishDanmakuEntranceView.this);
                }
            };
            ThreadUtils.postInForeground(PublishDanmakuEntranceView.this.j, 300L);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PublishDanmakuEntranceView publishDanmakuEntranceView) {
            publishDanmakuEntranceView.B2();
        }

        g() {
        }
    }

    static {
        Lazy<SharedPreferences> lazy;
        Covode.recordClassIndex(599013);
        t = new a(null);
        u = 8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ns3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SharedPreferences H2;
                H2 = PublishDanmakuEntranceView.H2();
                return H2;
            }
        });
        v = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T2() {
        if (this.r != null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        f fVar = new f();
        this.r = fVar;
        viewTreeObserver.addOnPreDrawListener(fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        if (this.p) {
            BusProvider.unregister(this);
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.r;
        if (onPreDrawListener != null && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        com.dragon.read.pages.video.a aVar;
        String str;
        b bVar = this.g;
        if (bVar != null) {
            aVar = bVar.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.o2(0);
        }
        if (aVar != null) {
            if (this.p && Intrinsics.areEqual(this.q, Boolean.FALSE)) {
                str = "switch";
            } else {
                str = "edit";
            }
            aVar.O1(str);
        }
        if (aVar != null) {
            aVar.F1();
        }
    }

    private final void U2() {
        com.dragon.read.pages.video.a a2;
        y.a.c(NsCommunityApi.IMPL.videoDanmakuService(), true, "video_player", false, 4, (Object) null);
        Z2(true);
        Y2();
        b bVar = this.g;
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.o2(0);
            a2.O1("switch");
            vr3.d.i(a2, "open_danmu", null, 2, null);
            a2.s1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V2() {
        final com.dragon.read.pages.video.a aVar;
        b bVar = this.g;
        if (bVar != null) {
            aVar = bVar.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.o2(0);
            aVar.i("edit");
            aVar.O1("edit");
            aVar.s1();
        }
        x2 x2Var = x2.a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        x2Var.h(context, "click_danmu_button", new Runnable() { // from class: ns3.e
            @Override // java.lang.Runnable
            public final void run() {
                PublishDanmakuEntranceView.W2(aVar, this);
            }
        });
    }

    private final i72.d getPresetTextDataModel() {
        nb5.a aVar;
        nb5.b bVar;
        cp3.b b2;
        ICommentDialogHelperApi n;
        b bVar2 = this.g;
        if (bVar2 != null && (b2 = bVar2.b()) != null && (n = b2.n(ICommentDialogHelperApi.class)) != null) {
            aVar = n.getCurCommentCountData();
        } else {
            aVar = null;
        }
        if (aVar == null || (bVar = aVar.j) == null) {
            return null;
        }
        return bVar.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B2() {
        TextView textView = (TextView) findViewById(2131834153);
        if (textView != null) {
            UIKt.setFontWeight(textView, 600);
        }
        ConstraintSet constraintSet = new ConstraintSet();
        v2(constraintSet);
        constraintSet.clear(2131834153, 7);
        constraintSet.connect(2131834153, 6, 0, 6);
        constraintSet.connect(2131834153, 7, 0, 7, UIKt.getDp(8));
        constraintSet.clear(2131827886, 6);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(300L);
        changeBounds.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        changeBounds.addListener(new d());
        TransitionManager.beginDelayedTransition(this, changeBounds);
        constraintSet.applyTo(this);
        ThreadUtils.getForegroundHandler().postDelayed(this.s, 3000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w2() {
        ConstraintSet constraintSet = new ConstraintSet();
        v2(constraintSet);
        constraintSet.clear(2131834153, 6);
        constraintSet.clear(2131834153, 7);
        constraintSet.connect(2131834153, 7, 0, 6);
        constraintSet.connect(2131827886, 6, 0, 6);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(300L);
        changeBounds.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        changeBounds.addListener(new c());
        TransitionManager.beginDelayedTransition(this, changeBounds);
        constraintSet.applyTo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G2() {
        int color;
        if (isAttachedToWindow()) {
            UiUtils.expandClickArea(this, UIKt.getDp(8));
        } else {
            addOnAttachStateChangeListener(new e(this, this));
        }
        float dimension = getContext().getResources().getDimension(2131494081);
        Integer b2 = HeaderViewTagBgColorOptV691.a.b();
        if (b2 != null) {
            color = b2.intValue();
        } else {
            color = ResourcesKt.getColor(2131560741);
        }
        setBackground(ViewUtil.getDrawable(color, dimension));
        Z2(NsCommunityApi.IMPL.videoDanmakuService().i());
    }

    public final void Y2() {
        Integer num;
        b bVar = this.g;
        if (bVar != null) {
            num = Integer.valueOf(bVar.getVideoScene());
        } else {
            num = null;
        }
        a aVar = t;
        int i = aVar.b().getInt("outer_show_count", 0);
        if ((num == null || num.intValue() != 1) && i <= 0) {
            i = aVar.b().getInt("show_count", 0);
        }
        int y = NsCommunityApi.IMPL.videoDanmakuService().y();
        if (i >= y) {
            LogWrapper.info("PublishDanmakuEntranceView", "tryPlayGuideAnimation , videoScene: " + num + ", showCountByScene:" + i + ",  publishGuideMaxCount:" + y, new Object[0]);
            return;
        }
        g gVar = new g();
        this.i = gVar;
        Looper.myQueue().addIdleHandler(gVar);
    }

    private final void r2() {
        boolean z;
        boolean z2;
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.l;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.k = null;
        this.l = null;
        boolean z3 = true;
        if (this.n.getAlpha() == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.m.getAlpha() == 1.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                z3 = false;
            }
        }
        if (z3) {
            ConstraintSet constraintSet = new ConstraintSet();
            v2(constraintSet);
            constraintSet.clear(2131834153, 6);
            constraintSet.clear(2131834153, 7);
            constraintSet.connect(2131834153, 7, 0, 6);
            constraintSet.connect(2131827886, 6, 0, 6);
            constraintSet.applyTo(this);
            this.n.setAlpha(0.0f);
            this.m.setAlpha(1.0f);
        }
        Runnable runnable = this.j;
        if (runnable != null) {
            ThreadUtils.getForegroundHandler().removeCallbacks(runnable);
        }
        this.j = null;
        MessageQueue.IdleHandler idleHandler = this.i;
        if (idleHandler != null) {
            Looper.myQueue().removeIdleHandler(idleHandler);
        }
        this.i = null;
        ThreadUtils.getForegroundHandler().removeCallbacks(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(PublishDanmakuEntranceView publishDanmakuEntranceView) {
        publishDanmakuEntranceView.w2();
    }

    public final void setDepend(b bVar) {
        this.g = bVar;
    }

    @Subscriber
    public final void onVideoDanmakuSwitchChangeEvent(cj5.a event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Z2(event.a);
    }

    public static final class e implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ PublishDanmakuEntranceView b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            UiUtils.expandClickArea(this.b, UIKt.getDp(8));
        }

        public e(View view, PublishDanmakuEntranceView publishDanmakuEntranceView) {
            this.a = view;
            this.b = publishDanmakuEntranceView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void L2(PublishDanmakuEntranceView publishDanmakuEntranceView) {
        boolean z;
        if (publishDanmakuEntranceView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!publishDanmakuEntranceView.p || Intrinsics.areEqual(publishDanmakuEntranceView.q, Boolean.TRUE)) {
                publishDanmakuEntranceView.Y2();
            }
        }
    }

    private final void v2(ConstraintSet constraintSet) {
        int dp = UIKt.getDp(32);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = dp;
            layoutParams.height = dp;
        }
        constraintSet.clone(this);
    }

    public final void M2(SaasVideoData saasVideoData) {
        String str;
        y videoDanmakuService = NsCommunityApi.IMPL.videoDanmakuService();
        if (saasVideoData != null) {
            str = saasVideoData.getVid();
        } else {
            str = null;
        }
        videoDanmakuService.j(str);
        r2();
    }

    public final void S2(SaasVideoData saasVideoData) {
        String str;
        y videoDanmakuService = NsCommunityApi.IMPL.videoDanmakuService();
        if (saasVideoData != null) {
            str = saasVideoData.getVid();
        } else {
            str = null;
        }
        videoDanmakuService.j(str);
    }

    private final void A2(n nVar) {
        if (NsCommunityApi.IMPL.videoDanmakuService().s()) {
            rq3.e e2 = nVar.e();
            if (e2 != null) {
                e2.B0();
                return;
            }
            return;
        }
        rq3.e e3 = nVar.e();
        if (e3 != null) {
            e3.h1(1, "danmaku_publish_dialog");
        }
    }

    private final void x2(n nVar) {
        if (NsCommunityApi.IMPL.videoDanmakuService().s()) {
            rq3.e e2 = nVar.e();
            if (e2 != null) {
                e2.i1();
                return;
            }
            return;
        }
        rq3.e e3 = nVar.e();
        if (e3 != null) {
            e3.h1(0, "danmaku_publish_dialog");
        }
    }

    public final void q2(SaasVideoData saasVideoData) {
        if (this.h != null) {
            LogWrapper.info("PublishDanmakuEntranceView", "bindData, run pendingGuideRunnableAfterBindData, videoData is " + saasVideoData, new Object[0]);
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
            }
            this.h = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J2(SaasVideoData saasVideoData) {
        boolean z;
        if (this.p) {
            Z2(NsCommunityApi.IMPL.videoDanmakuService().i());
        }
        if (saasVideoData == null) {
            LogWrapper.warn("PublishDanmakuEntranceView", "onHolderSelected called before bindData, videoData not ready", new Object[0]);
            this.h = new Runnable() { // from class: ns3.h
                @Override // java.lang.Runnable
                public final void run() {
                    PublishDanmakuEntranceView.L2(PublishDanmakuEntranceView.this);
                }
            };
            return;
        }
        if (getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!this.p || Intrinsics.areEqual(this.q, Boolean.TRUE)) {
                LogWrapper.info("PublishDanmakuEntranceView", "onHolderSelected called after bindData, videoData is ready", new Object[0]);
                Y2();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N2(vr3.e eVar) {
        final cp3.b b2;
        long j;
        JSONObject jSONObject;
        b bVar = this.g;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return;
        }
        String seriesId = bVar.getSeriesId();
        String videoId = bVar.getVideoId();
        if (k92.g.a(seriesId) && k92.g.a(videoId)) {
            rq3.g l = b2.l();
            if (l != null) {
                j = l.t0();
            } else {
                j = 0;
            }
            long j2 = j;
            LogWrapper.info("PublishDanmakuEntranceView", "openPublishDialog currentProgress:" + j2, new Object[0]);
            if (eVar == null || (jSONObject = eVar.getReportParams()) == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            jSONObject2.put("comment_from_position", "normal_publish_button");
            mu3.d.i(mu3.d.a, (String) null, (String) null, false, 7, (Object) null);
            y videoDanmakuService = NsCommunityApi.IMPL.videoDanmakuService();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Intrinsics.checkNotNull(seriesId);
            Intrinsics.checkNotNull(videoId);
            y.a.b(videoDanmakuService, context, seriesId, videoId, j2, false, jSONObject2, new DialogInterface.OnShowListener() { // from class: ns3.f
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    PublishDanmakuEntranceView.O2(PublishDanmakuEntranceView.this, b2, dialogInterface);
                }
            }, new DialogInterface.OnDismissListener() { // from class: ns3.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PublishDanmakuEntranceView.P2(PublishDanmakuEntranceView.this, b2, dialogInterface);
                }
            }, getPresetTextDataModel(), 16, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z2(boolean z) {
        if (Intrinsics.areEqual(Boolean.valueOf(z), this.q)) {
            return;
        }
        this.q = Boolean.valueOf(z);
        int i = 2130844941;
        if (this.p && !z) {
            LogWrapper.info("PublishDanmakuEntranceView", "updateDanmakuEntranceState, off state", new Object[0]);
            ImageView imageView = this.m;
            Resources resources = getContext().getResources();
            int i2 = this.o;
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 2130844944;
                }
            } else {
                i = 2130844943;
            }
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, i, (Resources.Theme) null));
            o.N(this, new View.OnClickListener() { // from class: ns3.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishDanmakuEntranceView.c3(PublishDanmakuEntranceView.this, view);
                }
            });
            return;
        }
        LogWrapper.info("PublishDanmakuEntranceView", "updateDanmakuEntranceState, on state, allowOffState=" + this.p + ", onState=" + z + ' ', new Object[0]);
        this.m.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), 2130844941, (Resources.Theme) null));
        o.N(this, new View.OnClickListener() { // from class: ns3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishDanmakuEntranceView.d3(PublishDanmakuEntranceView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(PublishDanmakuEntranceView publishDanmakuEntranceView, View view) {
        publishDanmakuEntranceView.U2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(PublishDanmakuEntranceView publishDanmakuEntranceView, View view) {
        publishDanmakuEntranceView.V2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(com.dragon.read.pages.video.a aVar, PublishDanmakuEntranceView publishDanmakuEntranceView) {
        if (aVar != null) {
            aVar.n1("clicked_content");
        }
        publishDanmakuEntranceView.N2(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(PublishDanmakuEntranceView publishDanmakuEntranceView, cp3.b bVar, DialogInterface dialogInterface) {
        publishDanmakuEntranceView.A2(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(PublishDanmakuEntranceView publishDanmakuEntranceView, cp3.b bVar, DialogInterface dialogInterface) {
        publishDanmakuEntranceView.x2(bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublishDanmakuEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        int n = NsCommunityApi.IMPL.videoDanmakuService().n();
        this.o = n;
        if (n != 0) {
            z = true;
        } else {
            z = false;
        }
        this.p = z;
        LayoutInflater.from(context).inflate(2131039308, (ViewGroup) this, true);
        View findViewById = findViewById(2131827886);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.m = (ImageView) findViewById;
        View findViewById2 = findViewById(2131834153);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.n = findViewById2;
        this.s = new Runnable() { // from class: ns3.d
            @Override // java.lang.Runnable
            public final void run() {
                PublishDanmakuEntranceView.F2(PublishDanmakuEntranceView.this);
            }
        };
    }

    public /* synthetic */ PublishDanmakuEntranceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

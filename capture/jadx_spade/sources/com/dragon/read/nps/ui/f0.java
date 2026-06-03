package com.dragon.read.nps.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.Args;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.util.CubicBezierInterpolator;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.nps.INpsViewProxy;
import com.dragon.read.nps.ui.NpsPopDialogFragment;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.BottomPopupContainerActivity;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import vs4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f0 extends com.dragon.read.nps.ui.a implements vs4.d {
    public static final int w;
    private d.a q;
    private d.c r;
    private boolean s;
    private final ConstraintLayout t;
    private final TextView u;
    private final ImageView v;

    static {
        Covode.recordClassIndex(612576);
        w = 8;
    }

    @Override // com.dragon.read.nps.ui.a
    protected String getLogTag() {
        return "NPS_GLOBAL | NPS_FIVE_EMOTION_CARD";
    }

    public final void setChangeIndexListener(d.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
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

    public static final class e implements NpsPopDialogFragment.a {
        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public String getPosition() {
            return f0.this.getOpenPosition();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public Args h() {
            return new Args();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public long a() {
            Long todayReadingTime = NsCommonDepend.IMPL.getTodayReadingTime();
            Intrinsics.checkNotNullExpressionValue(todayReadingTime, "getTodayReadingTime(...)");
            return todayReadingTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public long b() {
            Long todayAudioTime = NsCommonDepend.IMPL.getTodayAudioTime();
            Intrinsics.checkNotNullExpressionValue(todayAudioTime, "getTodayAudioTime(...)");
            return todayAudioTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public void onCommit() {
            LogWrapper.info(f0.this.getLogTag(), "收到提交消息，卡片将关闭", new Object[0]);
            f0.this.j2();
        }

        e() {
        }
    }

    private final void v2() {
        n2();
        l2();
        q2();
        r2();
        V1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l2() {
        B2(getContext().getResources().getColor(2131558438));
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f0.m2(f0.this, view);
            }
        });
    }

    private final void n2() {
        ConstraintLayout constraintLayout = this.t;
        constraintLayout.setClipToOutline(true);
        constraintLayout.setOutlineProvider(new b());
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f0.o2(f0.this, view);
            }
        });
    }

    private final void q2() {
        INpsViewProxy npsHeadView = getNpsHeadView();
        if (npsHeadView != null) {
            if (this.s) {
                npsHeadView.setClickSelectUIChangeEnable(false);
            }
            UserResearchData data = getData();
            if (data != null) {
                npsHeadView.updateData(data);
            }
            npsHeadView.setOnSelectChangedListener(new c());
        }
    }

    private final void r2() {
        String str;
        TextView textView = this.u;
        UserResearchData data = getData();
        if (data == null || (str = data.researchTitle) == null) {
            str = "";
        }
        textView.setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        App.registerLocalReceiver(getReceiver(), new String[]{"action_skin_type_change"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        NpsPopMemoryCache.a.a();
        App.unregisterLocalReceiver(new BroadcastReceiver[]{getReceiver()});
    }

    @Override // vs4.d
    public void onShow() {
        LogWrapper.info(getLogTag(), "NPS表情页卡曝光展示", new Object[0]);
        Q1();
        T1();
        vs4.n.a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.dragon.read.nps.ui.f0$e] */
    public final void w2() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new e();
        d dVar = new d(ref$ObjectRef);
        Intent intent = new Intent(ActivityRecordManager.inst().getCurrentActivity(), (Class<?>) BottomPopupContainerActivity.class);
        BottomPopupContainerActivity.i.a(dVar);
        intent.addFlags(268435456);
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p2() {
        ResearchSceneType researchSceneType;
        Context context;
        setData(vs4.n.a.t());
        if (getData() == null) {
            Context context2 = getContext();
            vs4.r rVar = vs4.r.a;
            WeakReference<Context> j = rVar.j();
            if (j != null) {
                context = j.get();
            } else {
                context = null;
            }
            if (Intrinsics.areEqual(context2, context)) {
                LogWrapper.info(getLogTag(), "取得ReaderNpsDataCacher缓存Data", new Object[0]);
                setData(rVar.e());
            }
        }
        if (getData() == null) {
            LogWrapper.info(getLogTag(), "getNpsData 为空，卡片不展示", new Object[0]);
            setVisibility(8);
            j2();
        }
        Map<ResearchSceneType, String> a2 = vs4.p.a.a();
        UserResearchData data = getData();
        if (data == null || (researchSceneType = data.scene) == null) {
            researchSceneType = 0;
        }
        String str = a2.get(researchSceneType);
        if (str == null) {
            str = "unknown";
        }
        setPosition(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j2() {
        int dp;
        if (getLayoutParams() == null) {
            LogWrapper.info(getLogTag(), "layoutParams 为空，不执行关闭动画", new Object[0]);
            setVisibility(8);
            d.a aVar = this.q;
            if (aVar != null) {
                aVar.onClose();
                return;
            }
            return;
        }
        if (getLayoutParams().height > 0) {
            dp = getLayoutParams().height;
        } else {
            dp = UIKt.getDp(140);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f).setDuration(250L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        ValueAnimator ofInt = ValueAnimator.ofInt(dp, 0);
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dragon.read.nps.ui.c0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f0.k2(layoutParams, this, valueAnimator);
            }
        });
        ofInt.addListener(new a());
        ofInt.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, ofInt);
        animatorSet.setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        animatorSet.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dragon.read.nps.ui.a
    public void V1() {
        if (SkinManager.isNightMode()) {
            INpsViewProxy npsHeadView = getNpsHeadView();
            if (npsHeadView != null) {
                npsHeadView.updateTheme(5);
            }
            if (getTextColor() == 0) {
                this.u.setTextColor(Color.parseColor("#CCFFFFFF"));
            }
            if (getBgColor() == 0) {
                this.t.setBackground(new ColorDrawable(ContextCompat.getColor(getContext(), 2131561869)));
            }
            if (getCloseColor() == 0) {
                A2(getContext().getResources().getColor(2131562011));
                return;
            }
            return;
        }
        INpsViewProxy npsHeadView2 = getNpsHeadView();
        if (npsHeadView2 != null) {
            npsHeadView2.updateTheme(1);
        }
        if (getTextColor() == 0) {
            this.u.setTextColor(-16777216);
        }
        if (getBgColor() == 0) {
            this.t.setBackground(new ColorDrawable(-1));
        }
        if (getCloseColor() == 0) {
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
            f0.this.getLayoutParams().height = 0;
            f0.this.setVisibility(8);
            d.a aVar = f0.this.q;
            if (aVar != null) {
                aVar.onClose();
            }
        }
    }

    public static final class c implements INpsViewProxy.IOnSelectChanged {
        c() {
        }

        @Override // com.dragon.read.nps.INpsViewProxy.IOnSelectChanged
        public void onChanged(int i) {
            LogWrapper.info(f0.this.getLogTag(), "NPS卡片选择发生变化，打开弹窗:" + f0.this.getData(), new Object[0]);
            NpsPopMemoryCache.a.k(i);
            if (f0.this.s) {
                f0.this.w2();
            }
            f0.g2(f0.this);
            d.c cVar = f0.this.r;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public static final /* synthetic */ d.b g2(f0 f0Var) {
        f0Var.getClass();
        return null;
    }

    public void B2(int i) {
        A2(i);
        setCloseColor(i);
    }

    public void setListener(d.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.q = listener;
    }

    public void setOperationListener(d.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.r = listener;
    }

    @Override // com.dragon.read.nps.ui.a
    public void setPosition(String str) {
        if (str == null) {
            return;
        }
        setOpenPosition(str);
    }

    public void E2(int i) {
        this.u.setTextColor(i);
        setTextColor(i);
    }

    public final void setEnableShowDialog(boolean z) {
        this.s = z;
        INpsViewProxy npsHeadView = getNpsHeadView();
        if (npsHeadView != null) {
            npsHeadView.setClickSelectUIChangeEnable(!this.s);
        }
    }

    @Override // com.dragon.read.nps.ui.a
    public void setSceneType(ResearchSceneType scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        setScene(scene);
        NpsPopMemoryCache.a.h(scene);
    }

    public void x2(int i) {
        this.t.setBackground(new ColorDrawable(i));
        setBgColor(i);
    }

    public static final class d implements BottomPopupContainerActivity.b {
        final /* synthetic */ Ref$ObjectRef<e> b;

        public boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return false;
        }

        public void onCreate(Bundle bundle) {
        }

        public void onDestroy() {
        }

        public Fragment c(BottomPopupContainerActivity.c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            UserResearchData data = f0.this.getData();
            Intrinsics.checkNotNull(data);
            NpsPopDialogFragment npsPopDialogFragment = new NpsPopDialogFragment(data, null, this.b.element, f0.this.getHideSysTemBar());
            npsPopDialogFragment.kg(true);
            return npsPopDialogFragment;
        }

        d(Ref$ObjectRef<e> ref$ObjectRef) {
            this.b = ref$ObjectRef;
        }

        public void b(BottomPopupContainerActivity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(2131820917);
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A2(int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), 2130837650);
        if (drawable != null) {
            drawable.mutate();
        }
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
        this.v.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(f0 f0Var, View view) {
        f0Var.j2();
        f0Var.S1();
        d.c cVar = f0Var.r;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(f0 f0Var, View view) {
        LogWrapper.info(f0Var.getLogTag(), "点击空白区域，打开默认弹窗", new Object[0]);
        NpsPopMemoryCache.a.k(NpsPopMemoryCache.ResultKey.enum_none.getNumber());
        if (f0Var.s) {
            f0Var.w2();
        }
        d.c cVar = f0Var.r;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.s = true;
        LogWrapper.info(getLogTag(), "NpsFiveEmotionCardView 初始化 context:" + context, new Object[0]);
        View inflate = ViewGroup.inflate(context, 2131038812, this);
        setNpsHeadView((INpsViewProxy) inflate.findViewById(2131826345));
        ConstraintLayout findViewById = inflate.findViewById(2131821115);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.t = findViewById;
        View findViewById2 = inflate.findViewById(2131820710);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.u = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(2131827188);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.v = (ImageView) findViewById3;
        p2();
        v2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k2(ViewGroup.LayoutParams layoutParams, f0 f0Var, ValueAnimator it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        Object animatedValue = it2.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        f0Var.setLayoutParams(layoutParams);
    }
}

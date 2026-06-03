package es4;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdp.appbase.ui.image.RoundedImageView;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.UIUtils;
import com.bytedance.bdp.serviceapi.defaults.ui.model.BdpLoadImageOptions;
import com.bytedance.bdp.serviceapi.hostimpl.ui.BdpImageService;
import com.bytedance.covode.number.Covode;
import com.dragon.read.biz.common.GlobalFontService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j extends RelativeLayout {
    public static final int f;
    private String a;
    private String b;
    private RoundedImageView c;
    private TextView d;
    private View e;

    static {
        Covode.recordClassIndex(611987);
        f = 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z;
            if (j.this.c.getMeasuredHeight() != 0) {
                j.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = j.this.c.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                j.this.c.setLayoutParams((RelativeLayout.LayoutParams) layoutParams);
                j.this.c.setCornerRadius(j.this.c.getHeight() / 2);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(-723466);
                String str = j.this.b;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    BdpManager.getInst().getService(BdpImageService.class).loadImage(j.this.getContext(), new BdpLoadImageOptions(j.this.b).placeholder(gradientDrawable).into(j.this.c));
                } else {
                    j.this.c.setBackground(gradientDrawable);
                }
                j.this.d.setTypeface(a(1));
                TextView textView = j.this.d;
                String str2 = j.this.a;
                if (str2 == null) {
                    str2 = "小游戏";
                }
                textView.setText(str2);
                ((TextView) j.this.findViewById(2131829791)).setVisibility(8);
            }
        }

        a() {
        }

        @Proxy("defaultFromStyle")
        @TargetClass("android.graphics.Typeface")
        public static Typeface a(int i) {
            Typeface regularTypeface;
            GlobalFontService globalFontService = GlobalFontService.IMPL;
            if (globalFontService.isGlobalFontReplace()) {
                if (i == 1) {
                    regularTypeface = globalFontService.getBoldTypeface();
                } else {
                    regularTypeface = globalFontService.getRegularTypeface();
                }
                if (regularTypeface != null) {
                    return regularTypeface;
                }
            }
            return Typeface.defaultFromStyle(i);
        }
    }

    public final void setOnClickListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setOnClickListener(new View.OnClickListener() { // from class: es4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.f(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, String str, String str2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(2131039903, this);
        this.a = str;
        this.b = str2;
        RoundedImageView findViewById = findViewById(2131829794);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.c = findViewById;
        View findViewById2 = findViewById(2131829789);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.d = (TextView) findViewById2;
        View findViewById3 = findViewById(2131829793);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.e = findViewById3;
        ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = UIUtils.getScreenHeight(context) / 3;
        this.e.setLayoutParams(layoutParams2);
        this.e.requestLayout();
    }
}

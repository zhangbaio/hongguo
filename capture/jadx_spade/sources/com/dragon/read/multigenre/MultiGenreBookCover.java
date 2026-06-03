package com.dragon.read.multigenre;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import bq2.a;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.NsUiDepend;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.skin.IViewThemeObserver;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.ResourcesKt;
import com.dragon.read.util.kotlin.UIKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ls4.d;
import ms4.b;
import ns4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MultiGenreBookCover extends FrameLayout implements IViewThemeObserver {
    public static final int f;
    private final SimpleDraweeView a;
    private final SimpleDraweeView b;
    private boolean c;
    private boolean d;
    private boolean e;

    static {
        Covode.recordClassIndex(612353);
        f = 8;
    }

    public final SimpleDraweeView getDarkMask() {
        return this.b;
    }

    public final boolean getEnableDarkMask() {
        return this.c;
    }

    public final boolean getForceUseDarkMode() {
        return this.d;
    }

    public final SimpleDraweeView getOriginalCover() {
        return this.a;
    }

    private final UiConfigSetter getUiSetter() {
        return UiConfigSetter.j.c();
    }

    private final boolean b() {
        if (!SkinManager.enableDarkMask() && !this.d) {
            return false;
        }
        return true;
    }

    public final void c() {
        boolean z;
        if (this.c) {
            z = b();
        } else {
            z = false;
        }
        getUiSetter().t0(z).p(this.a).n(new View[]{this.b});
    }

    public final float getCornerRadius() {
        float[] cornersRadii;
        Float orNull;
        RoundingParams roundingParams = this.a.getHierarchy().getRoundingParams();
        if (roundingParams != null && (cornersRadii = roundingParams.getCornersRadii()) != null && (orNull = ArraysKt___ArraysKt.getOrNull(cornersRadii, 0)) != null) {
            return orNull.floatValue();
        }
        return 0.0f;
    }

    public void notifyUpdateTheme() {
        IViewThemeObserver iViewThemeObserver;
        int i;
        getUiSetter().t0(b()).n(new View[]{this.b});
        if (!this.e) {
            if (b()) {
                i = 2130848278;
            } else {
                i = 2130848279;
            }
            getUiSetter().h0(ResourcesKt.getDrawable(i), ScalingUtils.ScaleType.FIT_XY).n(new View[]{this.a});
        }
        for (IViewThemeObserver iViewThemeObserver2 : UIKt.getChildren(this)) {
            if (iViewThemeObserver2 instanceof IViewThemeObserver) {
                iViewThemeObserver = iViewThemeObserver2;
            } else {
                iViewThemeObserver = null;
            }
            if (iViewThemeObserver != null) {
                iViewThemeObserver.notifyUpdateTheme();
            }
        }
    }

    public final void setForceUseDarkMode(boolean z) {
        this.d = z;
    }

    public final void setCornerRadius(float f2) {
        getUiSetter().J(f2).n(new View[]{this.a, this.b});
    }

    public final void setEnableDarkMask(boolean z) {
        if (NsUiDepend.IMPL.enableDarkMask()) {
            this.c = z;
            if (z) {
                notifyUpdateTheme();
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    private final void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (!TextUtils.isEmpty(attributeName) && a.a(attributeName) && a.b(attributeValue, getResources()) && TextUtils.equals(attributeName, "placeholderImage")) {
                Intrinsics.checkNotNull(attributeValue);
                String substring = attributeValue.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                SkinDelegate.setPlaceholderImage(this.a, Integer.parseInt(substring));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiGenreBookCover(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiGenreBookCover(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = NsUiDepend.IMPL.enableDarkMask();
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context, attributeSet, i);
        simpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a = simpleDraweeView;
        a(attributeSet);
        this.e = simpleDraweeView.getHierarchy().hasPlaceholderImage();
        addView(simpleDraweeView);
        if (NsCommonDepend.IMPL.enableOnlyPreloadSeriesXml()) {
            View e = new b().e(context);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type com.dragon.read.multigenre.extendview.DarkMaskExtendView");
            this.b = ((d) e).getDarkMaskImpl();
            addView(e);
        } else {
            b bVar = new b();
            f.m(this, bVar);
            View e2 = bVar.e(context);
            Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type com.dragon.read.multigenre.extendview.DarkMaskExtendView");
            this.b = ((d) e2).getDarkMaskImpl();
        }
        getUiSetter().p(simpleDraweeView).t0(false).n(new View[]{this.b});
        notifyUpdateTheme();
    }

    public final void d(float f2, float f3, float f4, float f5) {
        getUiSetter().K(f2, f3, f4, f5).n(new View[]{this.a, this.b});
    }
}

package com.dragon.read.nps.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsUiDepend;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.util.CdnLargeImageLoader;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NpsEmojiView extends LinearLayout {
    public static final int h;
    private final LottieAnimationView a;
    private final ImageView b;
    private final TextView c;
    private final View d;
    private boolean e;
    private String f;
    private int g;

    static {
        Covode.recordClassIndex(612571);
        h = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
    }

    public final void d() {
        c(false);
    }

    private final void setUnSelectedImage(int i) {
        this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public final void setText(String str) {
        if (str == null) {
            return;
        }
        this.c.setText(str);
    }

    public final void c(boolean z) {
        this.e = z;
        if (z) {
            UIKt.setFontWeight(this.c, 500);
            UIKt.gone(this.b);
            UIKt.visible(this.a);
            this.a.playAnimation();
        } else {
            UIKt.setFontWeight(this.c, 400);
            UIKt.visible(this.b);
            this.a.cancelAnimation();
            UIKt.gone(this.a);
        }
        int i = this.g;
        if (i == 0) {
            if (SkinManager.isNightMode()) {
                e(5);
                return;
            } else {
                e(1);
                return;
            }
        }
        e(i);
    }

    public final void e(int i) {
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        if (nsUiDepend.isBlackTheme(i)) {
            if (this.e) {
                this.c.setTextColor(ContextCompat.getColor(getContext(), 2131558602));
            } else {
                this.c.setTextColor(ContextCompat.getColor(getContext(), 2131558592));
            }
            this.d.setBackgroundColor(ColorUtils.setAlphaComponent(nsUiDepend.getReaderCommonColor().b(i), 51));
            UIKt.visible(this.d);
        } else {
            if (this.e) {
                this.c.setTextColor(ContextCompat.getColor(getContext(), 2131558438));
            } else {
                this.c.setTextColor(ContextCompat.getColor(getContext(), 2131558445));
            }
            UIKt.gone(this.d);
        }
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NpsEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout.inflate(context, 2131038452, this);
        LottieAnimationView findViewById = findViewById(2131825922);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        LottieAnimationView lottieAnimationView = findViewById;
        this.a = lottieAnimationView;
        View findViewById2 = findViewById(2131825937);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.c = (TextView) findViewById2;
        View findViewById3 = findViewById(2131825919);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.d = findViewById3;
        View findViewById4 = findViewById(2131825939);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.b = (ImageView) findViewById4;
        int[] NpsEmojiView = {2130772583, 2130772584, 2130772585, 2130772586};
        Intrinsics.checkNotNullExpressionValue(NpsEmojiView, "NpsEmojiView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NpsEmojiView, 0, 0);
        String string = obtainStyledAttributes.getString(1);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        String string2 = obtainStyledAttributes.getString(3);
        String cdnFileImageUrl = CdnLargeImageLoader.getCdnFileImageUrl(string2 == null ? "file_video_tab_tip_guide_1967.json" : string2);
        this.f = cdnFileImageUrl;
        lottieAnimationView.setAnimationFromUrl(cdnFileImageUrl);
        setText(string);
        setUnSelectedImage(resourceId);
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NpsEmojiView.b(view);
            }
        });
    }
}

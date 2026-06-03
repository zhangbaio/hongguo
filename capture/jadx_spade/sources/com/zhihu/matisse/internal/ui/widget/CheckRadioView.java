package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CheckRadioView extends AppCompatImageView {
    private Drawable a;
    private int b;
    private int c;

    static {
        Covode.recordClassIndex(656148);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        this.b = ResourcesCompat.getColor(getResources(), 2131562989, getContext().getTheme());
        this.c = ResourcesCompat.getColor(getResources(), 2131562988, getContext().getTheme());
        setChecked(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColor(int i) {
        if (this.a == null) {
            this.a = getDrawable();
        }
        this.a.setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setChecked(boolean z) {
        if (z) {
            setImageResource(2130842858);
            Drawable drawable = getDrawable();
            this.a = drawable;
            if (drawable != null) {
                drawable.setColorFilter(this.b, PorterDuff.Mode.SRC_IN);
                return;
            }
            return;
        }
        setImageResource(2130842857);
        Drawable drawable2 = getDrawable();
        this.a = drawable2;
        if (drawable2 != null) {
            drawable2.setColorFilter(this.c, PorterDuff.Mode.SRC_IN);
        }
    }

    public CheckRadioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}

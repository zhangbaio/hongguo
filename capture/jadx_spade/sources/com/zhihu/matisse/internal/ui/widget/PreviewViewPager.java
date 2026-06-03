package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.covode.number.Covode;
import it.sephiroth.android.library.imagezoom.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreviewViewPager extends ViewPager {
    static {
        Covode.recordClassIndex(656157);
    }

    public PreviewViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof a) {
            if (!((a) view).I(i) && !super.canScroll(view, z, i, i2, i3)) {
                return false;
            }
            return true;
        }
        return super.canScroll(view, z, i, i2, i3);
    }
}

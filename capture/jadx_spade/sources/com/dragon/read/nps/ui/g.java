package com.dragon.read.nps.ui;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsUiDepend;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.nps.ui.b1;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g extends ConstraintLayout {
    public static final int j;
    private boolean g;
    private boolean h;
    private b1.a i;

    static {
        Covode.recordClassIndex(612569);
        j = 8;
    }

    public static final class a extends ViewOutlineProvider {
        a() {
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
                outline.setRoundRect(0, 0, i, i2, UIKt.getDp(4));
            }
        }
    }

    protected final boolean getEditableState() {
        return this.g;
    }

    protected final boolean getSelectState() {
        return this.h;
    }

    protected final b1.a getSelectlistener() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void T1() {
        S1();
        setSelect(false);
        setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.V1(g.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void S1() {
        ConstraintLayout findViewById = findViewById(2131820545);
        if (findViewById != null) {
            findViewById.setClipToOutline(true);
            findViewById.setOutlineProvider(new a());
        }
    }

    protected final void setEditableState(boolean z) {
        this.g = z;
    }

    public final void setListener(b1.a aVar) {
        this.i = aVar;
    }

    protected final void setSelectState(boolean z) {
        this.h = z;
    }

    protected final void setSelectlistener(b1.a aVar) {
        this.i = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSize(float f) {
        ((TextView) findViewById(2131820788)).setTextSize(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEditable(boolean z) {
        if (z) {
            ((ImageView) findViewById(2131824901)).setVisibility(0);
        } else {
            ((ImageView) findViewById(2131824901)).setVisibility(8);
        }
        this.g = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ((TextView) findViewById(2131820788)).setText(text);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSelect(boolean z) {
        int i;
        this.h = z;
        b1.a aVar = this.i;
        if (aVar != null) {
            i = aVar.getTheme();
        } else if (SkinManager.isNightMode()) {
            i = 5;
        } else {
            i = 1;
        }
        if (z) {
            ConstraintLayout findViewById = findViewById(2131820545);
            NsUiDepend nsUiDepend = NsUiDepend.IMPL;
            findViewById.setBackgroundColor(nsUiDepend.getReaderCommonColor().d(i));
            ((TextView) findViewById(2131820788)).setTextColor(nsUiDepend.getReaderCommonColor().a(i));
            ((TextView) findViewById(2131820788)).setTypeface(null, 1);
            ((ImageView) findViewById(2131824901)).setBackground(getContext().getResources().getDrawable(2130845850));
            return;
        }
        ConstraintLayout findViewById2 = findViewById(2131820545);
        NsUiDepend nsUiDepend2 = NsUiDepend.IMPL;
        findViewById2.setBackgroundColor(nsUiDepend2.getReaderCommonColor().e(i));
        ((TextView) findViewById(2131820788)).setTextColor(nsUiDepend2.getReaderCommonColor().c(i));
        ((TextView) findViewById(2131820788)).setTypeface(null, 0);
        if (SkinManager.isNightMode()) {
            ((ImageView) findViewById(2131824901)).setBackground(getContext().getResources().getDrawable(2130845849));
        } else {
            ((ImageView) findViewById(2131824901)).setBackground(getContext().getResources().getDrawable(2130845848));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void V1(g gVar, View view) {
        b1.a aVar;
        gVar.setSelect(!gVar.h);
        b1.a aVar2 = gVar.i;
        if (aVar2 != null) {
            aVar2.a(gVar.h, ((TextView) gVar.findViewById(2131820788)).getText().toString());
        }
        if (gVar.g && (aVar = gVar.i) != null) {
            aVar.b(((TextView) gVar.findViewById(2131820788)).getText().toString());
        }
    }
}

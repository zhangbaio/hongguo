package com.dragon.read.nps.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsUiDepend;
import com.dragon.read.nps.INpsViewProxy;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.rpc.model.UserResearchData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f1 extends ConstraintLayout implements INpsViewProxy {
    public static final int n;
    private INpsViewProxy.IOnSelectChanged g;
    public TextView h;
    public TextView i;
    public TextView j;
    private boolean k;
    private boolean l;
    private int m;

    static {
        Covode.recordClassIndex(612586);
        n = 8;
    }

    private final void g2() {
        e2();
        c2();
        f2();
    }

    public final TextView getTextAverage() {
        TextView textView = this.i;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textAverage");
        return null;
    }

    public final TextView getTextDissatisfied() {
        TextView textView = this.h;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textDissatisfied");
        return null;
    }

    public final TextView getTextSatisfied() {
        TextView textView = this.j;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textSatisfied");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V1() {
        setTextDissatisfied((TextView) findViewById(2131833238));
        setTextAverage((TextView) findViewById(2131833224));
        setTextSatisfied((TextView) findViewById(2131833269));
        findViewById(2131825598).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.W1(f1.this, view);
            }
        });
        findViewById(2131821990).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.Y1(f1.this, view);
            }
        });
        findViewById(2131831701).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.a2(f1.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c2() {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (NpsPopMemoryCache.a.e() == NpsPopMemoryCache.ResultKey.enum_average) {
            Drawable background = findViewById(2131821990).getBackground();
            background.mutate();
            if (background instanceof GradientDrawable) {
                gradientDrawable2 = (GradientDrawable) background;
            } else {
                gradientDrawable2 = null;
            }
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(NsUiDepend.IMPL.getReaderCommonColor().d(this.m));
            }
            TextView textView = (TextView) findViewById(2131833224);
            textView.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().a(this.m));
            textView.setTypeface(null, 1);
            return;
        }
        Drawable background2 = findViewById(2131821990).getBackground();
        background2.mutate();
        if (background2 instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background2;
        } else {
            gradientDrawable = null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(NsUiDepend.IMPL.getReaderCommonColor().e(this.m));
        }
        TextView textView2 = (TextView) findViewById(2131833224);
        textView2.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().c(this.m));
        textView2.setTypeface(null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e2() {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (NpsPopMemoryCache.a.e() == NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied) {
            Drawable background = findViewById(2131825598).getBackground();
            background.mutate();
            if (background instanceof GradientDrawable) {
                gradientDrawable2 = (GradientDrawable) background;
            } else {
                gradientDrawable2 = null;
            }
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(NsUiDepend.IMPL.getReaderCommonColor().d(this.m));
            }
            TextView textView = (TextView) findViewById(2131833238);
            textView.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().a(this.m));
            textView.setTypeface(null, 1);
            return;
        }
        Drawable background2 = findViewById(2131825598).getBackground();
        background2.mutate();
        if (background2 instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background2;
        } else {
            gradientDrawable = null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(NsUiDepend.IMPL.getReaderCommonColor().e(this.m));
        }
        TextView textView2 = (TextView) findViewById(2131833238);
        textView2.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().c(this.m));
        textView2.setTypeface(null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f2() {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (NpsPopMemoryCache.a.e() == NpsPopMemoryCache.ResultKey.enum_extremely_satisfied) {
            Drawable background = findViewById(2131831701).getBackground();
            background.mutate();
            if (background instanceof GradientDrawable) {
                gradientDrawable2 = (GradientDrawable) background;
            } else {
                gradientDrawable2 = null;
            }
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(NsUiDepend.IMPL.getReaderCommonColor().d(this.m));
            }
            TextView textView = (TextView) findViewById(2131833269);
            textView.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().a(this.m));
            textView.setTypeface(null, 1);
            return;
        }
        Drawable background2 = findViewById(2131831701).getBackground();
        background2.mutate();
        if (background2 instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background2;
        } else {
            gradientDrawable = null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(NsUiDepend.IMPL.getReaderCommonColor().e(this.m));
        }
        TextView textView2 = (TextView) findViewById(2131833269);
        textView2.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().c(this.m));
        textView2.setTypeface(null, 0);
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setClickSelectUIChangeEnable(boolean z) {
        this.k = z;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setTouchEnable(boolean z) {
        this.l = z;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setOnSelectChangedListener(INpsViewProxy.IOnSelectChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    public final void setTextAverage(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.i = textView;
    }

    public final void setTextDissatisfied(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.h = textView;
    }

    public final void setTextSatisfied(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.j = textView;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void updateTheme(int i) {
        this.m = i;
        g2();
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setCurrentIndex(int i) {
        boolean z = true;
        int i2 = i + 1;
        int number = NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied.getNumber();
        if (i2 > NpsPopMemoryCache.ResultKey.enum_extremely_satisfied.getNumber() || number > i2) {
            z = false;
        }
        if (!z) {
            return;
        }
        NpsPopMemoryCache.a.k(i2);
        g2();
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void updateData(UserResearchData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String str = (String) data.scoreRemarks.get(String.valueOf(NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied.getNumber()));
        String str2 = (String) data.scoreRemarks.get(String.valueOf(NpsPopMemoryCache.ResultKey.enum_average.getNumber()));
        String str3 = (String) data.scoreRemarks.get(String.valueOf(NpsPopMemoryCache.ResultKey.enum_extremely_satisfied.getNumber()));
        if (str != null) {
            getTextDissatisfied().setText(str);
        }
        if (str2 != null) {
            getTextAverage().setText(str2);
        }
        if (str3 != null) {
            getTextSatisfied().setText(str3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.k = true;
        this.l = true;
        ViewGroup.inflate(context, 2131039129, this);
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(f1 f1Var, View view) {
        INpsViewProxy.IOnSelectChanged iOnSelectChanged = f1Var.g;
        if (iOnSelectChanged != null) {
            iOnSelectChanged.onChanged(NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied.getNumber());
        }
        if (f1Var.k) {
            NpsPopMemoryCache.a.l(NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied);
            f1Var.g2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y1(f1 f1Var, View view) {
        INpsViewProxy.IOnSelectChanged iOnSelectChanged = f1Var.g;
        if (iOnSelectChanged != null) {
            iOnSelectChanged.onChanged(NpsPopMemoryCache.ResultKey.enum_average.getNumber());
        }
        if (f1Var.k) {
            NpsPopMemoryCache.a.l(NpsPopMemoryCache.ResultKey.enum_average);
            f1Var.g2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(f1 f1Var, View view) {
        INpsViewProxy.IOnSelectChanged iOnSelectChanged = f1Var.g;
        if (iOnSelectChanged != null) {
            iOnSelectChanged.onChanged(NpsPopMemoryCache.ResultKey.enum_extremely_satisfied.getNumber());
        }
        if (f1Var.k) {
            NpsPopMemoryCache.a.l(NpsPopMemoryCache.ResultKey.enum_extremely_satisfied);
            f1Var.g2();
        }
    }
}

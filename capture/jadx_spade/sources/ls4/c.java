package ls4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends AppCompatTextView {
    public static final int a;

    static {
        Covode.recordClassIndex(612367);
        a = 8;
    }

    public static final class a implements UiConfigSetter.e {
        private final Integer a;

        static {
            Covode.recordClassIndex(612368);
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public a(Integer num) {
            this.a = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(View view) {
            AppCompatTextView appCompatTextView;
            Drawable background;
            Intrinsics.checkNotNullParameter(view, "view");
            if (this.a == null) {
                return;
            }
            if (view instanceof c) {
                appCompatTextView = (c) view;
            } else {
                appCompatTextView = null;
            }
            if (appCompatTextView != null && (background = appCompatTextView.getBackground()) != null) {
                background.setTint(this.a.intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ContextUtils.dp2px(context, 32.0f), ContextUtils.dp2px(context, 20.0f));
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = ContextUtils.dp2px(context, 4.0f);
        layoutParams.rightMargin = ContextUtils.dp2px(context, 4.0f);
        setLayoutParams(layoutParams);
        setBackground(ContextCompat.getDrawable(context, 2130841054));
        setPadding(0, 0, ContextUtils.dp2px(context, 1.0f), 0);
        setText(context.getString(2131100425));
        setGravity(17);
        setTextColor(ContextCompat.getColor(context, 2131558431));
        setTextSize(10.0f);
    }
}

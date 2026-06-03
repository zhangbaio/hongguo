package ls4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.dragon.read.asyncinflate.w;
import com.dragon.read.base.ssconfig.settings.template.LaunchOptV701;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends FrameLayout {
    public static final int b;
    private final SimpleDraweeView a;

    static {
        Covode.recordClassIndex(612369);
        b = 8;
    }

    public final SimpleDraweeView getDarkMaskImpl() {
        return this.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SimpleDraweeView simpleDraweeView = null;
        if (LaunchOptV701.a.a().enable) {
            View d = w.d(2131037241, (ViewGroup) null, context, false);
            if (d instanceof SimpleDraweeView) {
                simpleDraweeView = (SimpleDraweeView) d;
            }
        } else {
            View inflate = View.inflate(context, 2131037241, null);
            if (inflate instanceof SimpleDraweeView) {
                simpleDraweeView = (SimpleDraweeView) inflate;
            }
        }
        if (simpleDraweeView == null) {
            simpleDraweeView = new SimpleDraweeView(context);
            simpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            simpleDraweeView.setBackgroundColor(ContextCompat.getColor(context, 2131559417));
        }
        this.a = simpleDraweeView;
        addView(simpleDraweeView);
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

package ls4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.ScaleSimpleDraweeView;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends FrameLayout {
    public static final int c;
    private final ScaleSimpleDraweeView a;
    private a b;

    static {
        Covode.recordClassIndex(612373);
        c = 8;
    }

    public static final class b implements UiConfigSetter.e {
        public static final int b;
        public final a a;

        static {
            Covode.recordClassIndex(612375);
            b = UiConfigSetter.k;
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public b(a uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.a = uiConfig;
        }

        public void a(View view) {
            f fVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof f) {
                fVar = (f) view;
            } else {
                fVar = null;
            }
            if (fVar == null) {
                return;
            }
            fVar.setUiConfig(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiConfig(a aVar) {
        int hashCode;
        String str = aVar.a;
        if (str != null && ((hashCode = str.hashCode()) == 92457424 ? str.equals("authorize_type") : hashCode == 94843483 ? str.equals("comic") : !(hashCode != 1686617758 || !str.equals("exclusive")))) {
            UiConfigSetter uiConfigSetter = aVar.b;
            if (uiConfigSetter != null) {
                uiConfigSetter.n(new View[]{this.a});
            }
            this.b = aVar;
            return;
        }
        this.a.setVisibility(8);
    }

    public static final class a {
        public static final int c;
        public final String a;
        public final UiConfigSetter b;

        static {
            Covode.recordClassIndex(612374);
            c = UiConfigSetter.k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            UiConfigSetter uiConfigSetter = this.b;
            return hashCode + (uiConfigSetter != null ? uiConfigSetter.hashCode() : 0);
        }

        public String toString() {
            return "UiConfig(iconTag=" + this.a + ", simpleDraweeViewUiConfigSetter=" + this.b + ')';
        }

        public a(String str, UiConfigSetter uiConfigSetter) {
            this.a = str;
            this.b = uiConfigSetter;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View scaleSimpleDraweeView = new ScaleSimpleDraweeView(context, attributeSet, i);
        this.a = scaleSimpleDraweeView;
        addView(scaleSimpleDraweeView);
        UiConfigSetter.j.c().x0(new UiConfigSetter.c(UIKt.getDp(16), UIKt.getDp(31))).V(8388661).a0(new UiConfigSetter.h(0, 0, ContextUtils.dp2px(context, 3.0f), 0, 11, (DefaultConstructorMarker) null)).r0(8).n(new View[]{scaleSimpleDraweeView});
    }

    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

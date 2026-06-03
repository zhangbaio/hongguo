package ls4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.skin.IViewThemeObserver;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.ResourcesKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i extends FrameLayout implements IViewThemeObserver {
    public static final int c;
    private final SimpleDraweeView a;
    private a b;

    static {
        Covode.recordClassIndex(612379);
        c = 8;
    }

    public void notifyUpdateTheme() {
        int i;
        if (SkinManager.isNightMode()) {
            i = 2130847313;
        } else {
            i = 2130847312;
        }
        UiConfigSetter.i0(UiConfigSetter.j.c(), ResourcesKt.getDrawable(i), (ScalingUtils.ScaleType) null, 2, (Object) null).J(this.b.a).n(new View[]{this.a});
    }

    public static final class b implements UiConfigSetter.e {
        public final a a;

        static {
            Covode.recordClassIndex(612381);
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public b(a uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.a = uiConfig;
        }

        public void a(View view) {
            i iVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof i) {
                iVar = (i) view;
            } else {
                iVar = null;
            }
            if (iVar != null) {
                iVar.setUiConfig(this.a);
            }
        }
    }

    public static final class a {
        public final float a;

        static {
            Covode.recordClassIndex(612380);
        }

        public a() {
            this(0.0f, 1, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.a, ((a) obj).a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        public String toString() {
            return "UiConfig(radius=" + this.a + ')';
        }

        public a(float f) {
            this.a = f;
        }

        public /* synthetic */ a(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f);
        }
    }

    public final void setUiConfig(a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.b = config;
        notifyUpdateTheme();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = 0.0f;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.b = new a(f, i2, defaultConstructorMarker);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View simpleDraweeView = new SimpleDraweeView(context);
        this.a = simpleDraweeView;
        UiConfigSetter.l(UiConfigSetter.j.c(), this, 0, 2, (Object) null).v0(-1).R(-1).V(17).n(new View[]{simpleDraweeView});
        a aVar = new a(f, i2, defaultConstructorMarker);
        this.b = aVar;
        setUiConfig(aVar);
    }

    public /* synthetic */ i(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

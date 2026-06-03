package ls4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.MultiGenreBookCover;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.ScaleBookCover;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h extends View {
    public static final int c;
    private a a;
    private FrameLayout b;

    static {
        Covode.recordClassIndex(612376);
        c = 8;
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ FrameLayout b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.a.invoke();
            UIKt.removeOnGlobalLayoutListener(this.b, this);
        }

        c(Function0<Unit> function0, FrameLayout frameLayout) {
            this.a = function0;
            this.b = frameLayout;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ FrameLayout a;
        final /* synthetic */ int b;
        final /* synthetic */ h c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            UIUtils.updateLayout(((MultiGenreBookCover) this.a).getDarkMask(), -3, this.b);
            UIKt.removeOnGlobalLayoutListener(this.c, this);
        }

        d(FrameLayout frameLayout, int i, h hVar) {
            this.a = frameLayout;
            this.b = i;
            this.c = hVar;
        }
    }

    private final void c() {
        final FrameLayout frameLayout = this.b;
        if (frameLayout == null) {
            return;
        }
        setBackground(ContextCompat.getDrawable(getContext(), this.a.a));
        Function0 function0 = new Function0() { // from class: ls4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d2;
                d2 = h.d(h.this, frameLayout);
                return d2;
            }
        };
        if (frameLayout.getWidth() > 0) {
            function0.invoke();
        } else {
            UIKt.addOnGlobalLayoutListener(frameLayout, new c(function0, frameLayout));
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        FrameLayout frameLayout;
        Object obj;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        ViewGroup viewGroup = null;
        if (parent instanceof FrameLayout) {
            frameLayout = (FrameLayout) parent;
        } else {
            frameLayout = null;
        }
        this.b = frameLayout;
        if (frameLayout != null) {
            frameLayout.setClipChildren(false);
        }
        FrameLayout frameLayout2 = this.b;
        if (frameLayout2 != null) {
            obj = frameLayout2.getParent();
        } else {
            obj = null;
        }
        if (obj instanceof ViewGroup) {
            viewGroup = (ViewGroup) obj;
        }
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        c();
    }

    public static final class b implements UiConfigSetter.e {
        public final a a;

        static {
            Covode.recordClassIndex(612378);
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public b(a uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.a = uiConfig;
        }

        public void a(View view) {
            h hVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof h) {
                hVar = (h) view;
            } else {
                hVar = null;
            }
            if (hVar == null) {
                return;
            }
            hVar.setUiConfig(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiConfig(a aVar) {
        this.a = aVar;
        c();
    }

    public static final class a {
        public final int a;
        public final float b;

        static {
            Covode.recordClassIndex(612377);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && Float.compare(this.b, aVar.b) == 0;
        }

        public int hashCode() {
            return (this.a * 31) + Float.floatToIntBits(this.b);
        }

        public String toString() {
            return "UiConfig(bgDrawableId=" + this.a + ", marginBottomScale=" + this.b + ')';
        }

        public a(int i, float f) {
            this.a = i;
            this.b = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(h hVar, FrameLayout frameLayout) {
        UIUtils.updateLayout(hVar, frameLayout.getWidth(), frameLayout.getHeight());
        int height = (int) (hVar.getHeight() * (1.0f - hVar.a.b));
        if (frameLayout instanceof MultiGenreBookCover) {
            MultiGenreBookCover multiGenreBookCover = (MultiGenreBookCover) frameLayout;
            UIUtils.updateLayout(multiGenreBookCover.getOriginalCover(), -3, height);
            if (multiGenreBookCover.getDarkMask().getHeight() > 0) {
                UIUtils.updateLayout(multiGenreBookCover.getDarkMask(), -3, height);
            } else {
                UIKt.addOnGlobalLayoutListener(multiGenreBookCover.getDarkMask(), new d(frameLayout, height, hVar));
            }
            UIUtils.updateLayout(multiGenreBookCover.getDarkMask(), -3, height);
        } else if (frameLayout instanceof ScaleBookCover) {
            UIUtils.updateLayout(((ScaleBookCover) frameLayout).getOriginalCover(), -3, height);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new a(2130841062, 0.062015504f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setBackgroundColor(ContextCompat.getColor(context, 2131560364));
    }

    public /* synthetic */ h(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

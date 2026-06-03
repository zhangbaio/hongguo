package ls4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.skin.IViewThemeObserver;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.w1;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends FrameLayout implements IViewThemeObserver {
    public static final int g;
    private final ImageView a;
    private final ImageView b;
    private final ImageView c;
    private final ImageView d;
    private final FrameLayout e;
    private a f;

    static {
        Covode.recordClassIndex(612364);
        g = 8;
    }

    public void notifyUpdateTheme() {
        if (SkinManager.isNightMode()) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    /* renamed from: ls4.b$b, reason: collision with other inner class name */
    public static final class C0241b implements UiConfigSetter.e {
        public final a a;

        static {
            Covode.recordClassIndex(612366);
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public C0241b(a uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.a = uiConfig;
        }

        public void a(View view) {
            b bVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof b) {
                bVar = (b) view;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return;
            }
            bVar.setUiConfig(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiConfig(a aVar) {
        this.f = aVar;
        e(aVar);
        notifyUpdateTheme();
    }

    private final void e(a aVar) {
        int i;
        if (aVar.d) {
            i = 8;
        } else {
            i = 0;
        }
        setVisibility(i);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2130841056);
        Bitmap c = c(aVar.a);
        ImageView imageView = this.a;
        Intrinsics.checkNotNull(decodeResource);
        imageView.setImageBitmap(b(decodeResource, c));
        this.c.setImageDrawable(d(aVar.b));
        this.d.setImageDrawable(d(aVar.c));
    }

    private final Bitmap c(float f) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.HSVToColor(w1.q(f)), Color.HSVToColor(w1.r(f))});
        Bitmap createBitmap = Bitmap.createBitmap(ScreenUtils.dpToPxInt(getContext(), 47.0f), ScreenUtils.dpToPxInt(getContext(), 24.0f), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        gradientDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        gradientDrawable.draw(canvas);
        return createBitmap;
    }

    private final Drawable d(int i) {
        int i2;
        Context context = getContext();
        switch (i) {
            case 0:
                i2 = 2130841284;
                break;
            case 1:
                i2 = 2130841285;
                break;
            case 2:
                i2 = 2130841286;
                break;
            case 3:
                i2 = 2130841287;
                break;
            case 4:
                i2 = 2130841288;
                break;
            case 5:
                i2 = 2130841289;
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                i2 = 2130841290;
                break;
            case 7:
                i2 = 2130841291;
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                i2 = 2130841292;
                break;
            default:
                i2 = 2130841293;
                break;
        }
        Drawable drawable = context.getDrawable(i2);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
        return mutate;
    }

    private final Bitmap b(Bitmap bitmap, Bitmap bitmap2) {
        int width;
        int height;
        if (bitmap.getWidth() > bitmap2.getWidth()) {
            width = bitmap.getWidth();
        } else {
            width = bitmap2.getWidth();
        }
        if (bitmap.getHeight() > bitmap2.getHeight()) {
            height = bitmap.getHeight();
        } else {
            height = bitmap2.getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(2131037233, this);
        View findViewById = findViewById(2131822204);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.a = (ImageView) findViewById;
        View findViewById2 = findViewById(2131829732);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.b = (ImageView) findViewById2;
        View findViewById3 = findViewById(2131826339);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.c = (ImageView) findViewById3;
        View findViewById4 = findViewById(2131831999);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.d = (ImageView) findViewById4;
        View findViewById5 = findViewById(2131821114);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.e = (FrameLayout) findViewById5;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ScreenUtils.dpToPxInt(getContext(), 47.0f), ScreenUtils.dpToPxInt(getContext(), 24.0f));
        layoutParams.gravity = 8388691;
        layoutParams.leftMargin = ContextUtils.dp2px(context, -3.0f);
        layoutParams.bottomMargin = ContextUtils.dp2px(context, -6.0f);
        setLayoutParams(layoutParams);
    }

    public static final class a {
        public final float a;
        public final int b;
        public final int c;
        public final boolean d;

        static {
            Covode.recordClassIndex(612365);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.a, aVar.a) == 0 && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c) * 31) + m.a(this.d);
        }

        public String toString() {
            return "UiConfig(h=" + this.a + ", firstIndex=" + this.b + ", secondIndex=" + this.c + ", hideScore=" + this.d + ')';
        }

        public a(float f, int i, int i2, boolean z) {
            this.a = f;
            this.b = i;
            this.c = i2;
            this.d = z;
        }
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

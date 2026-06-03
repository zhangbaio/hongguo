package ft3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    void a(Dialog dialog);

    Drawable b(Drawable drawable, Context context, int i);

    void c(ImageView imageView, int i);

    void d(ImageView imageView, int i, int i2);

    void e(SimpleDraweeView simpleDraweeView, int i);

    int f();

    int g(Context context, int i);

    Drawable getDrawable(Context context, int i);

    void h(View view, int i, int i2, int i3);

    int i();

    boolean isNightMode();

    void setTextColor(TextView textView, int i);
}

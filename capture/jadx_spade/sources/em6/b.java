package em6;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private final WeakReference<Activity> a;
    private final WeakReference<Fragment> b = null;
    public Uri c;

    static {
        Covode.recordClassIndex(656160);
    }

    public void a(Context context, int i) {
    }

    public b(Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    public static boolean b(Context context) {
        return context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera");
    }
}

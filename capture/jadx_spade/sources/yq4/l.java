package yq4;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.ImageData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface l {

    public interface a {
        void onSuccess(String str);
    }

    void a(View view, String str, ImageData imageData);

    void b(y82.c cVar);

    void c();

    void d(String str);

    void e(ImageData imageData, int i);

    void f(Activity activity);

    void g(View view, MotionEvent motionEvent, String str, ImageData imageData);

    void h(a aVar);

    public static final class b {
        static {
            Covode.recordClassIndex(611376);
        }

        public static /* synthetic */ void a(l lVar, Activity activity, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    activity = null;
                }
                lVar.f(activity);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToastCollectStart");
        }
    }
}

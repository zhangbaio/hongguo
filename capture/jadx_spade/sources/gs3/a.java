package gs3;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.docker.viewmamanager.HandlerStyleType;
import com.dragon.read.widget.dialog.AdaptedToDialogInfo;
import com.dragon.read.widget.dialog.j0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a extends j0 {
    boolean E9();

    void K6();

    void O8();

    void addView(View view);

    void j8(HandlerStyleType handlerStyleType);

    void removeView(View view);

    void sb();

    void stop();

    void w8();

    /* renamed from: gs3.a$a, reason: collision with other inner class name */
    public static final class C0165a {
        static {
            Covode.recordClassIndex(598900);
        }

        public static void a(a aVar, AdaptedToDialogInfo adaptedToDialogInfo) {
            j0.a.a(aVar, adaptedToDialogInfo);
        }

        public static void b(a aVar, AdaptedToDialogInfo adaptedToDialogInfo, boolean z) {
            j0.a.b(aVar, adaptedToDialogInfo, z);
        }
    }
}

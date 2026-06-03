package dr3;

import android.view.View;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {

    /* renamed from: dr3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0145a {
        void a(boolean z);

        void b();

        void c();
    }

    void b(boolean z);

    void destroy();

    void g();

    boolean h();

    void hide();

    boolean isShowing();

    void r(SaasVideoData saasVideoData, int i, boolean z);

    void s(boolean z);

    void show();

    void t(InterfaceC0145a interfaceC0145a);

    void update(String str, boolean z);

    View view();
}

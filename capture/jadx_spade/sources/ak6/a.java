package ak6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends RelativeLayout {

    /* renamed from: ak6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0002a {
        void a(com.ss.android.videoshop.mediaview.b bVar, boolean z);

        void b(boolean z);

        void c(int i);

        boolean d();

        void e();

        void f(MotionEvent motionEvent);

        boolean g();

        void h(com.ss.android.videoshop.mediaview.b bVar);

        void i();

        boolean isFullScreen();
    }

    static {
        Covode.recordClassIndex(654952);
    }

    public void setGestureCallback(InterfaceC0002a interfaceC0002a) {
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

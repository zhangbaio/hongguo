package sr3;

import android.content.Context;
import android.widget.FrameLayout;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import io.reactivex.Observable;
import pr3.f;
import pr3.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {

    /* renamed from: sr3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0267a {
        boolean a(String str, int i);

        void onError();
    }

    void a(Context context, SaasVideoData saasVideoData, InterfaceC0267a interfaceC0267a, FrameLayout frameLayout);

    Observable<r> b(f fVar);

    void c();

    void d(Context context, SaasVideoData saasVideoData, boolean z, int i);

    void prepareVideoFeedABValue();
}

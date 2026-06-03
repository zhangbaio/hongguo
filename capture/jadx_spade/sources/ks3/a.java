package ks3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {

    /* renamed from: ks3.a$a, reason: collision with other inner class name */
    public static final class C0232a {
        static {
            Covode.recordClassIndex(598947);
        }

        public static boolean a(a aVar) {
            return false;
        }

        public static void b(a aVar, dv4.a record) {
            Intrinsics.checkNotNullParameter(record, "record");
        }
    }

    com.dragon.read.pages.video.a a();

    js3.c b();

    boolean c();

    int d();

    Integer e(String str);

    void f(dv4.a aVar);

    void g(int i, String str);

    hs4.a getCallerContext();

    float getCardWidth();

    String getCover();

    String getTag();

    VideoTabModel.VideoData getVideoData();
}

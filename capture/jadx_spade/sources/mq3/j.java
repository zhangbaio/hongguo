package mq3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.rpc.model.BookGroup;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface j extends dp3.a {

    public interface a {

        /* renamed from: mq3.j$a$a, reason: collision with other inner class name */
        public static final class C0244a {
            static {
                Covode.recordClassIndex(598208);
            }

            public static void a(a aVar, Map<Long, ? extends BookGroup> dataMap) {
                Intrinsics.checkNotNullParameter(dataMap, "dataMap");
            }

            public static void b(a aVar, List<? extends SaasVideoData> videoData) {
                Intrinsics.checkNotNullParameter(videoData, "videoData");
            }
        }

        void J(Map<Long, ? extends BookGroup> map);

        void l(List<? extends SaasVideoData> list);
    }

    void K(String str);

    void d(a aVar);

    void h(a aVar);

    BookGroup z(long j);
}

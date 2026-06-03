package hn4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.s80;
import com.dragon.read.feed.staggeredfeed.FeedScene;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    uh4.d a();

    FeedScene b();

    boolean c();

    String e();

    String h();

    String i();

    List<uh4.c> j(hn4.a aVar);

    int k(xs4.f fVar);

    boolean l();

    List<yh4.b> m(s80 s80Var, d dVar, boolean z);

    public static final class a {
        static {
            Covode.recordClassIndex(608767);
        }

        public static String a(b bVar) {
            return null;
        }

        public static boolean b(b bVar) {
            return false;
        }

        public static boolean c(b bVar) {
            return false;
        }

        public static String d(b bVar) {
            return null;
        }

        public static String f(b bVar) {
            return "general";
        }

        public static uh4.d g(b bVar) {
            return null;
        }

        public static FeedScene e(b bVar) {
            return FeedScene.SEARCH_COMMON;
        }

        public static int h(b bVar, xs4.f fVar) {
            if (fVar != null) {
                return fVar.d;
            }
            return 2;
        }
    }
}

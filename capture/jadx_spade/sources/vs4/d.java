package vs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface d {

    public interface a {

        /* renamed from: vs4.d$a$a, reason: collision with other inner class name */
        public static final class C0282a {
            static {
                Covode.recordClassIndex(612536);
            }

            public static Args a(a aVar) {
                return null;
            }
        }

        Args c();

        void onClose();
    }

    public interface b {
    }

    public interface c {

        public static final class a {
            static {
                Covode.recordClassIndex(612539);
            }

            public static void a(c cVar) {
            }
        }

        void a();

        void b();

        void onCommit();
    }

    void onShow();
}

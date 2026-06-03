package nr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e2 {
    void insert(lr4.n0 n0Var);

    lr4.n0 query(String str);

    public static final class a implements e2 {
        public static final int b;
        private final e2 a;

        static {
            Covode.recordClassIndex(611717);
            b = 8;
        }

        public a(e2 readerBookProgressDao) {
            Intrinsics.checkNotNullParameter(readerBookProgressDao, "readerBookProgressDao");
            this.a = readerBookProgressDao;
        }

        @Override // nr4.e2
        public void insert(lr4.n0 progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.a.insert(progress);
        }

        @Override // nr4.e2
        public lr4.n0 query(String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            return this.a.query(bookId);
        }
    }
}

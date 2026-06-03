package nr4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface k2 {
    List<lr4.q0> a();

    List<lr4.q0> b(String str);

    void c(List<lr4.q0> list);

    void insert(lr4.q0 q0Var);

    lr4.q0 query(String str, String str2);

    public static final class a implements k2 {
        public static final int b;
        private final k2 a;

        static {
            Covode.recordClassIndex(611726);
            b = 8;
        }

        @Override // nr4.k2
        public List<lr4.q0> a() {
            return this.a.a();
        }

        public a(k2 readerChapterProgressDao) {
            Intrinsics.checkNotNullParameter(readerChapterProgressDao, "readerChapterProgressDao");
            this.a = readerChapterProgressDao;
        }

        @Override // nr4.k2
        public List<lr4.q0> b(String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            return this.a.b(bookId);
        }

        @Override // nr4.k2
        public void insert(lr4.q0 progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.a.insert(progress);
        }

        @Override // nr4.k2
        public void c(List<lr4.q0> progresses) {
            Intrinsics.checkNotNullParameter(progresses, "progresses");
            for (List<lr4.q0> list : com.dragon.read.local.db.p.a(progresses)) {
                k2 k2Var = this.a;
                Intrinsics.checkNotNull(list);
                k2Var.c(list);
            }
        }

        @Override // nr4.k2
        public lr4.q0 query(String bookId, String chapterId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            Intrinsics.checkNotNullParameter(chapterId, "chapterId");
            return this.a.query(bookId, chapterId);
        }
    }
}

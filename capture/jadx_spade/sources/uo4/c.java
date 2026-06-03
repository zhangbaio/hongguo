package uo4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface c {

    public static final class a {
        static {
            Covode.recordClassIndex(609129);
        }

        public static void a(c cVar) {
        }

        public static void b(c cVar) {
        }

        public static void c(c cVar) {
        }

        public static void d(c cVar) {
        }

        public static void e(c cVar, long j, long j2) {
        }
    }

    void b();

    void h();

    void n();

    void p();

    void updateProgress(long j, long j2);

    public static class b implements c {
        static {
            Covode.recordClassIndex(609130);
        }

        @Override // uo4.c
        public void b() {
            a.a(this);
        }

        @Override // uo4.c
        public void h() {
            a.d(this);
        }

        @Override // uo4.c
        public void updateProgress(long j, long j2) {
            a.e(this, j, j2);
        }
    }
}

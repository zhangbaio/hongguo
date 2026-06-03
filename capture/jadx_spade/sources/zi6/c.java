package zi6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    final String a;
    final String b;
    final int c;
    final float d;

    static {
        Covode.recordClassIndex(652855);
    }

    public static class b {
        private String a;
        private String b;
        private int c;
        private float d;

        static {
            Covode.recordClassIndex(652856);
        }

        public c e() {
            return new c(this);
        }

        public b f(int i) {
            this.c = i;
            return this;
        }

        public b g(String str) {
            this.b = str;
            return this;
        }

        public b h(float f) {
            this.d = f;
            return this;
        }

        public b i(String str) {
            this.a = str;
            return this;
        }
    }

    private c(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
    }
}

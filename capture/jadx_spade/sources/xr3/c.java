package xr3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface c {
    public static final a a;

    public static final class a {
        static final /* synthetic */ a a;
        private static final c b;
        private static final c c;
        private static final c d;

        private a() {
        }

        /* renamed from: xr3.c$a$a, reason: collision with other inner class name */
        public static final class C0294a implements c {
            private float b = 1.3f;
            private float c = 1.3f;
            private float d = 1.3f;

            @Override // xr3.c
            public float a() {
                return this.c;
            }

            @Override // xr3.c
            public float b() {
                return this.d;
            }

            @Override // xr3.c
            public float getFontScale() {
                return this.b;
            }

            C0294a() {
            }
        }

        public static final class b implements c {
            private float b = 1.15f;
            private float c = 1.15f;
            private float d = 1.15f;

            @Override // xr3.c
            public float a() {
                return this.c;
            }

            @Override // xr3.c
            public float b() {
                return this.d;
            }

            @Override // xr3.c
            public float getFontScale() {
                return this.b;
            }

            b() {
            }
        }

        /* renamed from: xr3.c$a$c, reason: collision with other inner class name */
        public static final class C0295c implements c {
            private float b = 1.0f;
            private float c = 1.0f;
            private float d = 1.0f;

            @Override // xr3.c
            public float a() {
                return this.c;
            }

            @Override // xr3.c
            public float b() {
                return this.d;
            }

            @Override // xr3.c
            public float getFontScale() {
                return this.b;
            }

            C0295c() {
            }
        }

        public final c a() {
            return d;
        }

        public final c b() {
            return c;
        }

        public final c c() {
            return b;
        }

        static {
            Covode.recordClassIndex(598839);
            a = new a();
            b = new C0295c();
            c = new b();
            d = new C0294a();
        }
    }

    static {
        Covode.recordClassIndex(598838);
        a = a.a;
    }

    float a();

    float b();

    float getFontScale();
}

package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import java.util.Date;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class t {

    public static abstract class b {
        static {
            Covode.recordClassIndex(654513);
        }

        public abstract Date A();

        public abstract Long B();

        public abstract Long C();

        public abstract int D();

        public abstract Long a();

        public abstract boolean b();

        public abstract Date c();

        public abstract Date d();

        public abstract Date e();

        public abstract Date f();

        public abstract String g();

        public abstract Long h();

        public abstract boolean i();

        public abstract Date j();

        public abstract Date k();

        public abstract Long l();

        public abstract Integer m();

        public abstract Date n();

        public abstract String o();

        public abstract String p();

        public abstract Date q();

        public abstract String r();

        public abstract Date s();

        public abstract Long t();

        public abstract Long u();

        public abstract Date v();

        public abstract Date w();

        public abstract Long x();

        public abstract boolean y();

        public abstract Date z();
    }

    static {
        Covode.recordClassIndex(654511);
    }

    public abstract b a();

    public static abstract class a {
        private final Executor a;

        static {
            Covode.recordClassIndex(654512);
        }

        public abstract void b(t tVar);

        public Executor a() {
            return this.a;
        }

        public a(Executor executor) {
            if (executor != null) {
                this.a = executor;
                return;
            }
            throw new IllegalStateException("Executor must not be null");
        }
    }
}

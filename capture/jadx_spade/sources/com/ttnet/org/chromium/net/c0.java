package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c0 {

    public static abstract class a {
        static {
            Covode.recordClassIndex(654545);
        }

        public abstract c0 a();

        public abstract a b(int i);

        public abstract a c(String str);

        public abstract a d(int i);

        public abstract a e(Map<String, String> map);

        public abstract a f(Map<String, String> map);

        public abstract a g(long j);

        public abstract a h(int i);

        public abstract a i(long j);

        public abstract a j(String str);

        public abstract a k(boolean z);

        public abstract a l(List<String> list);

        public abstract a m(boolean z);
    }

    public static abstract class b {
        static {
            Covode.recordClassIndex(654546);
        }

        public abstract void a(c0 c0Var, int i, String str, String str2);

        public abstract void b(c0 c0Var, int i, String str);

        public void c(c0 c0Var, String str) {
        }

        public abstract void d(c0 c0Var, ByteBuffer byteBuffer, int i) throws Exception;

        public abstract void e(c0 c0Var, String str, long j, long j2, boolean z);
    }

    static {
        Covode.recordClassIndex(654544);
    }

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void b(String str);

    public abstract void c();

    public abstract boolean d();

    public abstract void e();

    public abstract void f();
}

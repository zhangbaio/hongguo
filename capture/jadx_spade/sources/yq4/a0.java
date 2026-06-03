package yq4;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yq4.v;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 implements r {
    static {
        Covode.recordClassIndex(611404);
    }

    @Override // yq4.r
    public v a(String str) {
        return null;
    }

    @Override // yq4.r
    public void c(String str, String str2) {
    }

    @Override // yq4.r
    public void d(String str, String str2) {
    }

    @Override // yq4.r
    public w e(String str, String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return null;
    }

    @Override // yq4.r
    public void f(String str, String path, String str2) {
        Intrinsics.checkNotNullParameter(path, "path");
    }

    public static final class a implements v {
        a() {
        }

        @Override // yq4.v
        public void cancel() {
            v.a.c(this);
        }

        @Override // yq4.v
        public String e() {
            return v.a.g(this);
        }

        @Override // yq4.v
        public long getStartTime() {
            return v.a.e(this);
        }

        @Override // yq4.v
        public String getTraceId() {
            return v.a.f(this);
        }

        @Override // yq4.v
        public void b(String str) {
            v.a.h(this, str);
        }

        @Override // yq4.v
        public void c(Map<String, ? extends Object> map) {
            v.a.b(this, map);
        }

        @Override // yq4.v
        public void d(String str) {
            v.a.i(this, str);
        }

        @Override // yq4.v
        public void endSpan(String str) {
            v.a.d(this, str);
        }

        @Override // yq4.v
        public w startSpan(String str) {
            return v.a.j(this, str);
        }

        @Override // yq4.v
        public void a(String str, Serializable serializable) {
            v.a.a(this, str, serializable);
        }
    }

    @Override // yq4.r
    public v b(String traceName) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        return new a();
    }
}

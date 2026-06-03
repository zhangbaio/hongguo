package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.b;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.f0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.h0;
import com.ttnet.org.chromium.net.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VersionSafeCallbacks {

    public static final class a extends b.a {
    }

    public static final class c extends com.ttnet.org.chromium.net.l {
        private final com.ttnet.org.chromium.net.l a;

        static {
            Covode.recordClassIndex(654672);
        }

        @Override // com.ttnet.org.chromium.net.l
        public Executor a() {
            return this.a.a();
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                return this.a.equals(((c) obj).a);
            }
            return false;
        }

        @Override // com.ttnet.org.chromium.net.l
        public void b(int i, long j, int i2) {
            this.a.b(i, j, i2);
        }
    }

    public static final class d extends com.ttnet.org.chromium.net.m {
        private final com.ttnet.org.chromium.net.m a;

        static {
            Covode.recordClassIndex(654673);
        }

        @Override // com.ttnet.org.chromium.net.m
        public Executor a() {
            return this.a.a();
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof d)) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        @Override // com.ttnet.org.chromium.net.m
        public void b(int i, long j, int i2) {
            this.a.b(i, j, i2);
        }
    }

    public static final class e extends t.a {
        private final t.a b;

        static {
            Covode.recordClassIndex(654674);
        }

        @Override // com.ttnet.org.chromium.net.t.a
        public Executor a() {
            return this.b.a();
        }

        @Override // com.ttnet.org.chromium.net.t.a
        public void b(com.ttnet.org.chromium.net.t tVar) {
            this.b.b(tVar);
        }

        public e(t.a aVar) {
            super(aVar.a());
            this.b = aVar;
        }
    }

    public static final class f extends e0 {
        private final e0 a;

        static {
            Covode.recordClassIndex(654675);
        }

        @Override // com.ttnet.org.chromium.net.e0
        public long a() throws IOException {
            return this.a.a();
        }

        @Override // com.ttnet.org.chromium.net.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.a.close();
        }

        public f(e0 e0Var) {
            this.a = e0Var;
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void d(f0 f0Var) throws IOException {
            this.a.d(f0Var);
        }

        @Override // com.ttnet.org.chromium.net.e0
        public void c(f0 f0Var, ByteBuffer byteBuffer) throws IOException {
            this.a.c(f0Var, byteBuffer);
        }
    }

    public static final class UrlRequestStatusListener extends g0.c {
        private final g0.c a;

        static {
            Covode.recordClassIndex(654677);
        }

        public UrlRequestStatusListener(g0.c cVar) {
            this.a = cVar;
        }

        @Override // com.ttnet.org.chromium.net.g0.c
        public void onStatus(int i) {
            this.a.onStatus(i);
        }
    }

    public static final class b extends c.a.b {
        private final c.a.b a;

        static {
            Covode.recordClassIndex(654671);
        }

        public b(c.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.ttnet.org.chromium.net.c.a.b
        public void loadLibrary(String str) {
            this.a.loadLibrary(str);
        }
    }

    public static final class g extends g0.b {
        private final g0.b a;

        static {
            Covode.recordClassIndex(654676);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void e(g0 g0Var, h0 h0Var, String str) throws Exception {
            j(this, g0Var, h0Var, str);
        }

        public g(g0.b bVar) {
            this.a = bVar;
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void a(g0 g0Var, h0 h0Var) {
            this.a.a(g0Var, h0Var);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void f(g0 g0Var, h0 h0Var) {
            this.a.f(g0Var, h0Var);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void b(g0 g0Var, h0 h0Var, CronetException cronetException) {
            this.a.b(g0Var, h0Var, cronetException);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void c(g0 g0Var, h0 h0Var, ByteBuffer byteBuffer) throws Exception {
            this.a.c(g0Var, h0Var, byteBuffer);
        }

        public void g(g0 g0Var, h0 h0Var, String str) throws Exception {
            this.a.e(g0Var, h0Var, str);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void d(g0 g0Var, h0 h0Var, String str, String str2) throws Exception {
            this.a.d(g0Var, h0Var, str, str2);
        }

        @TargetClass("com.ttnet.org.chromium.net.impl.VersionSafeCallbacks$UrlRequestCallback")
        @Insert("onResponseStarted")
        public static void j(g gVar, g0 g0Var, h0 h0Var, String str) throws Exception {
            if (u55.k.o()) {
                g0.b bVar = gVar.a;
                if (!(bVar instanceof u55.n) && (bVar instanceof g0.b)) {
                    gVar.a = new u55.n(bVar);
                }
            }
            gVar.g(g0Var, h0Var, str);
        }
    }
}

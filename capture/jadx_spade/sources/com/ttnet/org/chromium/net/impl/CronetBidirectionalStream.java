package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.h0;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import com.ttnet.org.chromium.net.impl.z;
import com.ttnet.org.chromium.net.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CronetBidirectionalStream extends com.ttnet.org.chromium.net.e {
    private final CronetUrlRequestContext a;
    private final Executor b;
    private final String c;
    private final String d;
    private final Collection<Object> e;
    private CronetException f;
    private final Object g;
    private LinkedList<ByteBuffer> h;
    private LinkedList<ByteBuffer> i;
    private boolean j;
    private boolean k;
    private t.b l;
    private long m;
    private int n;
    private int o;
    private z p;
    public Runnable q;

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    interface f {
        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean a(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void b(long j, CronetBidirectionalStream cronetBidirectionalStream, boolean z);
    }

    class e implements Runnable {
        final /* synthetic */ CronetException a;

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.this.q(this.a);
        }

        e(CronetException cronetException) {
            this.a = cronetException;
        }
    }

    static {
        Covode.recordClassIndex(654571);
    }

    private void onCanceled() {
        u(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        if (this.n != 0 && this.m == 0) {
            return true;
        }
        return false;
    }

    class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetBidirectionalStream.j(CronetBidirectionalStream.this);
                z unused = CronetBidirectionalStream.this.p;
                throw null;
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in onCanceled method", e);
            }
        }

        d() {
        }
    }

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.g) {
                if (CronetBidirectionalStream.this.s()) {
                    return;
                }
                CronetBidirectionalStream.this.n = 2;
                try {
                    CronetBidirectionalStream.j(CronetBidirectionalStream.this);
                    z unused = CronetBidirectionalStream.this.p;
                    throw null;
                } catch (Exception e) {
                    CronetBidirectionalStream.this.t(e);
                }
            }
        }

        b() {
        }
    }

    class c implements Runnable {
        final /* synthetic */ h0.a a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.g) {
                if (CronetBidirectionalStream.this.s()) {
                    return;
                }
                try {
                    CronetBidirectionalStream.j(CronetBidirectionalStream.this);
                    z unused = CronetBidirectionalStream.this.p;
                    throw null;
                } catch (Exception e) {
                    CronetBidirectionalStream.this.t(e);
                }
            }
        }

        c(h0.a aVar) {
            this.a = aVar;
        }
    }

    private final class g implements Runnable {
        private ByteBuffer a;
        private final boolean b;

        static {
            Covode.recordClassIndex(654574);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a = null;
                synchronized (CronetBidirectionalStream.this.g) {
                    if (CronetBidirectionalStream.this.s()) {
                        return;
                    }
                    if (this.b) {
                        CronetBidirectionalStream.this.o = 10;
                        int unused = CronetBidirectionalStream.this.n;
                    }
                    CronetBidirectionalStream.j(CronetBidirectionalStream.this);
                    z unused2 = CronetBidirectionalStream.this.p;
                    throw null;
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.t(e);
            }
        }

        g(ByteBuffer byteBuffer, boolean z) {
            this.a = byteBuffer;
            this.b = z;
        }
    }

    class a implements Runnable {
        final /* synthetic */ boolean a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.g) {
                if (CronetBidirectionalStream.this.s()) {
                    return;
                }
                CronetBidirectionalStream.this.k = this.a;
                CronetBidirectionalStream.this.n = 2;
                if (CronetBidirectionalStream.o(CronetBidirectionalStream.this.d) || !CronetBidirectionalStream.this.k) {
                    CronetBidirectionalStream.this.o = 8;
                } else {
                    CronetBidirectionalStream.this.o = 10;
                }
                try {
                    CronetBidirectionalStream.j(CronetBidirectionalStream.this);
                    throw null;
                } catch (Exception e) {
                    CronetBidirectionalStream.this.t(e);
                }
            }
        }

        a(boolean z) {
            this.a = z;
        }
    }

    private void w() {
        boolean z;
        int size = this.i.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.i.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        this.o = 9;
        this.k = true;
        f c2 = com.ttnet.org.chromium.net.impl.a.c();
        long j = this.m;
        if (this.j && this.h.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (c2.a(j, this, byteBufferArr, iArr, iArr2, z)) {
            return;
        }
        this.o = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    }

    static /* synthetic */ VersionSafeCallbacks.a j(CronetBidirectionalStream cronetBidirectionalStream) {
        cronetBidirectionalStream.getClass();
        return null;
    }

    private void onStreamReady(boolean z) {
        u(new a(z));
    }

    private void p(CronetException cronetException) {
        u(new e(cronetException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(String str) {
        if (!str.equals("GET") && !str.equals("HEAD")) {
            return true;
        }
        return false;
    }

    private void onResponseTrailersReceived(String[] strArr) {
        u(new c(new z.a(r(strArr))));
    }

    private static ArrayList<Map.Entry<String, String>> r(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("CalledByNative method has thrown an exception", exc);
        com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in CalledByNative method", exc);
        q(callbackExceptionImpl);
    }

    private void n(boolean z) {
        com.ttnet.org.chromium.base.h.h(CronetUrlRequestContext.Q, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.m == 0) {
            return;
        }
        com.ttnet.org.chromium.net.impl.a.c().b(this.m, this, z);
        this.a.p0();
        this.m = 0L;
        Runnable runnable = this.q;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(CronetException cronetException) {
        this.f = cronetException;
        synchronized (this.g) {
            if (s()) {
                return;
            }
            this.o = 6;
            this.n = 6;
            n(false);
            try {
                throw null;
            } catch (Exception e2) {
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception notifying of failed request", e2);
            }
        }
    }

    private void u(Runnable runnable) {
        try {
            this.b.execute(runnable);
        } catch (RejectedExecutionException e2) {
            com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception posting task to executor", e2);
            synchronized (this.g) {
                this.o = 6;
                this.n = 6;
                n(false);
            }
        }
    }

    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.p = v(i, str, strArr, j);
            u(new b());
        } catch (Exception unused) {
            p(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
        }
    }

    private z v(int i, String str, String[] strArr, long j) {
        return new z(Arrays.asList(this.c), i, "", r(strArr), false, str, null, j);
    }

    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        boolean z2;
        synchronized (this.g) {
            if (s()) {
                return;
            }
            this.o = 8;
            if (!this.i.isEmpty()) {
                w();
            }
            for (int i = 0; i < byteBufferArr.length; i++) {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer.position() == iArr[i] && byteBuffer.limit() == iArr2[i]) {
                    byteBuffer.position(byteBuffer.limit());
                    if (z) {
                        z2 = true;
                        if (i == byteBufferArr.length - 1) {
                            u(new g(byteBuffer, z2));
                        }
                    }
                    z2 = false;
                    u(new g(byteBuffer, z2));
                } else {
                    p(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
                    return;
                }
            }
        }
    }

    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        int i4;
        this.p.j(j);
        if (byteBuffer.position() == i2 && byteBuffer.limit() == i3) {
            if (i >= 0 && (i4 = i2 + i) <= i3) {
                byteBuffer.position(i4);
                throw null;
            }
            p(new CronetExceptionImpl("Invalid number of bytes read", null));
            return;
        }
        p(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
    }

    private void onError(int i, int i2, int i3, String str, long j) {
        z zVar = this.p;
        if (zVar != null) {
            zVar.j(j);
        }
        if (i != 10 && i != 3) {
            p(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + str, i, i2));
            return;
        }
        p(new QuicExceptionImpl("Exception in BidirectionalStream: " + str, i, i2, i3));
    }

    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15, String str, long j16) {
        int i;
        synchronized (this.g) {
            if (this.l == null) {
                this.l = new com.ttnet.org.chromium.net.impl.f(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15, str, j16, 0L, "", "", 0L, 0L, -1, false, false, -1);
                int i2 = this.n;
                if (i2 == 7) {
                    i = 0;
                } else if (i2 == 5) {
                    i = 2;
                } else {
                    i = 1;
                }
                this.a.s0(new RequestFinishedInfoImpl(this.c, this.e, this.l, i, this.p, this.f));
            } else {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
        }
    }
}

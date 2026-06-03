package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.c0;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CronetWebsocketConnection extends c0 {
    private static final String t;
    private long a;
    private final c0.b b;
    private final Executor c;
    private List<String> d;
    private int e;
    private String f;
    private long g;
    private int h;
    private long i;
    private String j;
    private int k;
    private String l;
    private Map<String, String> m;
    private Map<String, String> n;
    private boolean o;
    private boolean p;
    private final CronetUrlRequestContext q;
    private final Object r;
    private AtomicInteger s;

    interface f {
        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void a(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void b(long j, CronetWebsocketConnection cronetWebsocketConnection, int i, String str, long j2, int i2, long j3, String str2, int i3, String str3, boolean z);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void c(long j, CronetWebsocketConnection cronetWebsocketConnection, String str);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void d(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void e(long j, CronetWebsocketConnection cronetWebsocketConnection, boolean z);

        long f(CronetWebsocketConnection cronetWebsocketConnection, long j);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void g(long j, CronetWebsocketConnection cronetWebsocketConnection, ByteBuffer byteBuffer);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void h(long j, CronetWebsocketConnection cronetWebsocketConnection, String str);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void i(long j, CronetWebsocketConnection cronetWebsocketConnection);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void j(long j, CronetWebsocketConnection cronetWebsocketConnection);
    }

    static {
        Covode.recordClassIndex(654619);
        t = CronetWebsocketConnection.class.getSimpleName();
    }

    @Override // com.ttnet.org.chromium.net.c0
    public boolean d() {
        if (this.s.get() == 4) {
            return true;
        }
        return false;
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetWebsocketConnection.this.b.c(CronetWebsocketConnection.this, this.a);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetWebsocketConnection.t, "Exception in callback: ", e);
            }
        }

        d(String str) {
            this.a = str;
        }
    }

    @Override // com.ttnet.org.chromium.net.c0
    public void c() {
        synchronized (this.r) {
            if (this.a == 0) {
                return;
            }
            k.k().i(this.a, this);
            this.a = 0L;
        }
    }

    @Override // com.ttnet.org.chromium.net.c0
    public void f() {
        synchronized (this.r) {
            if (this.a == 0) {
                return;
            }
            k.k().j(this.a, this);
        }
    }

    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetWebsocketConnection.this.b.b(CronetWebsocketConnection.this, this.a, this.b);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetWebsocketConnection.t, "Exception in callback: ", e);
            }
        }

        a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetWebsocketConnection.this.b.a(CronetWebsocketConnection.this, this.a, this.b, this.c);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetWebsocketConnection.t, "Exception in callback: ", e);
            }
        }

        b(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }
    }

    class c implements Runnable {
        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ int b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetWebsocketConnection.this.b.d(CronetWebsocketConnection.this, this.a, this.b);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetWebsocketConnection.t, "Exception in callback: ", e);
            }
        }

        c(ByteBuffer byteBuffer, int i) {
            this.a = byteBuffer;
            this.b = i;
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ boolean d;

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetWebsocketConnection.this.b.e(CronetWebsocketConnection.this, this.a, this.b, this.c, this.d);
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetWebsocketConnection.t, "Exception in callback: ", e);
            }
        }

        e(String str, long j, long j2, boolean z) {
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = z;
        }
    }

    @Override // com.ttnet.org.chromium.net.c0
    public void e() {
        Object obj;
        Object obj2 = this.r;
        synchronized (obj2) {
            try {
                try {
                    if (this.a == 0) {
                        this.a = k.k().f(this, this.q.j0());
                    }
                    Iterator<String> it2 = this.d.iterator();
                    while (it2.hasNext()) {
                        k.k().h(this.a, this, it2.next());
                    }
                    Map<String, String> map = this.m;
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            k.k().d(this.a, this, entry.getKey(), entry.getValue());
                        }
                    }
                    Map<String, String> map2 = this.n;
                    if (map2 != null) {
                        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                            k.k().a(this.a, this, entry2.getKey(), entry2.getValue());
                        }
                    }
                    try {
                        if (this.p) {
                            try {
                                obj = obj2;
                                k.k().b(this.a, this, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.o);
                            } catch (Throwable th) {
                                th = th;
                                obj = obj2;
                                throw th;
                            }
                        } else {
                            obj = obj2;
                            k.k().e(this.a, this, this.o);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = obj2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private ByteBuffer i(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        allocate.flip();
        return allocate;
    }

    private void j(Runnable runnable) {
        try {
            this.c.execute(runnable);
        } catch (RejectedExecutionException e2) {
            com.ttnet.org.chromium.base.h.b(t, "Exception posting task to executor", e2);
        }
    }

    private void onFeedbackLog(String str) {
        com.ttnet.org.chromium.base.h.l(t, "OnFeedbackLog", new Object[0]);
        j(new d(str));
    }

    @Override // com.ttnet.org.chromium.net.c0
    public void a(ByteBuffer byteBuffer) {
        synchronized (this.r) {
            if (this.a == 0) {
                return;
            }
            k.k().g(this.a, this, byteBuffer);
        }
    }

    @Override // com.ttnet.org.chromium.net.c0
    public void b(String str) {
        synchronized (this.r) {
            if (this.a == 0) {
                return;
            }
            k.k().c(this.a, this, str);
        }
    }

    private void onMessageReceived(ByteBuffer byteBuffer, int i) {
        com.ttnet.org.chromium.base.h.l(t, "onMessageReceived", new Object[0]);
        j(new c(i(byteBuffer), i));
    }

    private void onConnectionStateChanged(int i, String str) {
        com.ttnet.org.chromium.base.h.a(t, "onConnectionStateChanged: state = " + i + ", url = " + str, new Object[0]);
        this.s.set(i);
        j(new a(i, str));
    }

    private void onConnectionError(int i, String str, String str2) {
        com.ttnet.org.chromium.base.h.a(t, "onConnectionError: " + str2, new Object[0]);
        this.s.set(i);
        j(new b(i, str, str2));
    }

    private void onTrafficChanged(String str, long j, long j2, boolean z) {
        com.ttnet.org.chromium.base.h.l(t, "OnTrafficChanged", new Object[0]);
        j(new e(str, j, j2, z));
    }

    CronetWebsocketConnection(CronetUrlRequestContext cronetUrlRequestContext, c0.b bVar, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z) {
        this.p = true;
        this.r = new Object();
        this.s = new AtomicInteger(-1);
        this.q = cronetUrlRequestContext;
        this.b = bVar;
        this.c = executor;
        this.d = list;
        this.m = map;
        this.n = map2;
        this.o = z;
        this.p = false;
    }

    CronetWebsocketConnection(CronetUrlRequestContext cronetUrlRequestContext, c0.b bVar, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        this.p = true;
        this.r = new Object();
        this.s = new AtomicInteger(-1);
        this.q = cronetUrlRequestContext;
        this.b = bVar;
        this.c = executor;
        this.d = list;
        this.e = i;
        this.f = str;
        this.g = j;
        this.h = i2;
        this.i = j2;
        this.j = str2;
        this.k = i3;
        this.l = str3;
        this.m = map;
        this.n = map2;
        this.o = z;
    }
}

package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CronetFrontierClient {
    private static final String v;
    private int a;
    private int b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private Map<String, String> k;
    private TransportMode l;
    private Map<Integer, TTServiceInfo> m;
    private c n;
    private List<Integer> o;
    private String p;
    private String q;
    private boolean r;
    private long s;
    private final Object t;
    private AtomicInteger u;

    public interface c {
        void a(int i, String str, String str2);

        void b(int i, String str);

        void c(String str, long j, long j2, boolean z);
    }

    public interface d {
        void a(int i, String str);

        void b(int i, long j, String str, Boolean bool);

        void c(int i, int i2, String str);

        void d(int i, Map<String, String> map, byte[] bArr);
    }

    interface e {
        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void a(long j, CronetFrontierClient cronetFrontierClient, int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, int i4, int i5, int i6, boolean z, String str6, String str7);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void b(long j, CronetFrontierClient cronetFrontierClient, boolean z);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void c(long j, CronetFrontierClient cronetFrontierClient, int i);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void d(long j, CronetFrontierClient cronetFrontierClient, int i, String[] strArr, ByteBuffer byteBuffer);

        long e(CronetFrontierClient cronetFrontierClient);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void f(long j, CronetFrontierClient cronetFrontierClient, String[] strArr, ByteBuffer byteBuffer, int i, int i2, boolean z);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void g(long j, CronetFrontierClient cronetFrontierClient);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void h(long j, CronetFrontierClient cronetFrontierClient, String str, String str2);
    }

    public enum TransportMode {
        UNKNOWN(-1),
        QUIC(0),
        TLS(1),
        HTTP2(2),
        SPDY(3);

        final int mode;

        public int getValue() {
            return this.mode;
        }

        static {
            Covode.recordClassIndex(654592);
        }

        TransportMode(int i) {
            this.mode = i;
        }
    }

    public static final class b {
        private int a;
        private int b;
        private String c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i;
        private int j;
        private Map<String, String> k;
        private TransportMode l = TransportMode.UNKNOWN;
        private c m;
        private List<Integer> n;
        private String o;
        private String p;
        private boolean q;

        static {
            Covode.recordClassIndex(654588);
        }

        public CronetFrontierClient r() {
            return new CronetFrontierClient(this);
        }

        public b A(List<Integer> list) {
            this.n = list;
            return this;
        }

        public b query(String str) {
            this.o = str;
            return this;
        }

        public b s(c cVar) {
            this.m = cVar;
            return this;
        }

        public b u(Map<String, String> map) {
            this.k = map;
            return this;
        }

        public b v(String str) {
            this.p = str;
            return this;
        }

        public b w(int i) {
            this.i = i;
            return this;
        }

        public b x(boolean z) {
            this.q = z;
            return this;
        }

        public b y(int i) {
            this.j = i;
            return this;
        }

        public b z(TransportMode transportMode) {
            this.l = transportMode;
            return this;
        }

        public static b t(int i, int i2, String str, int i3, String str2, String str3, String str4) {
            return new b(i, i2, str, i3, str2, str3, str4);
        }

        b(int i, int i2, String str, int i3, String str2, String str3, String str4) {
            if (i > 0 && i2 > 0 && i3 > 0) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    this.a = i;
                    this.b = i2;
                    this.d = i3;
                    this.c = str;
                    this.e = str2;
                    this.f = str3;
                    this.g = str4;
                    return;
                }
                throw new IllegalArgumentException("Host, appVersion, appKey and deviceId must not be empty.");
            }
            throw new IllegalArgumentException("Appid, fpid and port must be set greater than 0.");
        }
    }

    static {
        Covode.recordClassIndex(654587);
        v = CronetFrontierClient.class.getSimpleName();
    }

    public boolean c() {
        if (this.u.get() == 2) {
            return true;
        }
        return false;
    }

    public void b() {
        synchronized (this.t) {
            if (this.s == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.b.i().g(this.s, this);
            this.s = 0L;
        }
    }

    private void a() {
        synchronized (this.t) {
            try {
                try {
                    if (this.s == 0) {
                        this.s = com.ttnet.org.chromium.net.impl.b.i().e(this);
                    }
                    Map<String, String> map = this.k;
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            com.ttnet.org.chromium.net.impl.b.i().h(this.s, this, entry.getKey(), entry.getValue());
                        }
                    }
                    List<Integer> list = this.o;
                    if (list != null) {
                        Iterator<Integer> it2 = list.iterator();
                        while (it2.hasNext()) {
                            com.ttnet.org.chromium.net.impl.b.i().c(this.s, this, it2.next().intValue());
                        }
                    }
                    com.ttnet.org.chromium.net.impl.b.i().a(this.s, this, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.l.getValue(), this.r, this.p, this.q);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public boolean d(int i) {
        return this.m.containsKey(Integer.valueOf(i));
    }

    public void f(boolean z) {
        synchronized (this.t) {
            if (this.s == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.b.i().b(this.s, this, z);
        }
    }

    private CronetFrontierClient(b bVar) {
        this.l = TransportMode.UNKNOWN;
        this.m = new ConcurrentHashMap();
        this.t = new Object();
        this.u = new AtomicInteger(0);
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.n = bVar.m;
        this.o = bVar.n;
        this.p = bVar.o;
        this.q = bVar.p;
        this.r = bVar.q;
        a();
    }

    private void onServiceReady(int i, String str) {
        TTServiceInfo tTServiceInfo = this.m.get(Integer.valueOf(i));
        if (tTServiceInfo == null) {
            return;
        }
        tTServiceInfo.c = true;
        tTServiceInfo.e.a(i, str);
    }

    private void onConnectionStateChanged(int i, String str) {
        Log.v(v, "onConnectionStateChanged: state = " + i + ", url = " + str);
        this.u.set(i);
        try {
            this.n.b(i, str);
        } catch (Exception e2) {
            Log.e(v, "Exception in callback: ", e2);
        }
    }

    private void onError(int i, int i2, String str) {
        TTServiceInfo tTServiceInfo = this.m.get(Integer.valueOf(i));
        if (tTServiceInfo == null) {
            return;
        }
        tTServiceInfo.c = false;
        tTServiceInfo.e.c(i, i2, str);
    }

    public void g(int i, String[] strArr, ByteBuffer byteBuffer) {
        synchronized (this.t) {
            if (this.s == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.b.i().d(this.s, this, i, strArr, byteBuffer);
        }
    }

    private void onConnectionError(int i, String str, String str2) {
        Log.e(v, "onConnectionError: " + str2);
        this.u.set(i);
        try {
            this.n.a(i, str, str2);
        } catch (Exception e2) {
            Log.e(v, "Exception in callback: ", e2);
        }
    }

    public void e(TTServiceInfo tTServiceInfo, ByteBuffer byteBuffer, String[] strArr) {
        synchronized (this.t) {
            if (this.s == 0) {
                return;
            }
            this.m.put(Integer.valueOf(tTServiceInfo.a), tTServiceInfo);
            com.ttnet.org.chromium.net.impl.b.i().f(this.s, this, strArr, byteBuffer, tTServiceInfo.a, tTServiceInfo.d.getValue(), tTServiceInfo.b);
        }
    }

    private void onReceivedAck(int i, long j, String str, boolean z) {
        TTServiceInfo tTServiceInfo;
        if (z || (tTServiceInfo = this.m.get(Integer.valueOf(i))) == null) {
            return;
        }
        tTServiceInfo.e.b(i, j, str, Boolean.valueOf(z));
    }

    private void onTrafficChanged(String str, long j, long j2, boolean z) {
        Log.v(v, "OnTrafficChanged");
        try {
            this.n.c(str, j, j2, z);
        } catch (Exception e2) {
            Log.e(v, "Exception in callback: ", e2);
        }
    }

    private void onReceivedMessage(int i, String[] strArr, ByteBuffer byteBuffer, int i2) {
        TTServiceInfo tTServiceInfo = this.m.get(Integer.valueOf(i));
        if (tTServiceInfo == null) {
            return;
        }
        int length = strArr.length;
        if (length % 2 != 0) {
            Log.e(v, "length is not even number:" + length);
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < length; i3 += 2) {
            if (!TextUtils.isEmpty(strArr[i3])) {
                int i4 = i3 + 1;
                if (!TextUtils.isEmpty(strArr[i4])) {
                    hashMap.put(strArr[i3], strArr[i4]);
                }
            }
        }
        byte[] bArr = new byte[byteBuffer.capacity()];
        byteBuffer.get(bArr);
        if (i2 >= 0) {
            i = i2;
        }
        tTServiceInfo.e.d(i, hashMap, bArr);
    }
}

package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttnet.org.chromium.base.i;
import com.ttnet.org.chromium.base.l;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.g;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.h0;
import com.ttnet.org.chromium.net.t;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String I;
    private long A;
    private int B;
    private String C;
    private String D;
    private int E;
    private final AtomicBoolean F;
    private final AtomicBoolean G;
    private boolean H;
    private final com.ttnet.org.chromium.net.c a;
    private final g b;
    private g0 c;
    private final List<Pair<String, String>> d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private d i;
    private f j;
    private h0 k;
    private IOException l;
    private boolean m;
    private boolean n;
    private List<Map.Entry<String, String>> o;
    private Map<String, List<String>> p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    public int v;
    private int w;
    public t.a x;
    private CookieHandler y;
    private int z;

    public void enableFixCancelRequestReport() {
        this.H = true;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    private boolean J() {
        if (((HttpURLConnection) this).chunkLength > 0) {
            return true;
        }
        return false;
    }

    public void K() {
        g0 g0Var = this.c;
        if (g0Var != null) {
            g0Var.c();
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        N();
    }

    static {
        Covode.recordClassIndex(654684);
        I = CronetHttpURLConnection.class.getSimpleName();
    }

    private long H() {
        long j = ((HttpURLConnection) this).fixedContentLength;
        long j2 = ((HttpURLConnection) this).fixedContentLengthLong;
        if (j2 != -1) {
            return j2;
        }
        return j;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            G();
            return B();
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        G();
        return this.k.c();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        G();
        return this.k.d();
    }

    private boolean I() {
        String requestProperty = getRequestProperty("x-ttnet-bypass-cookie");
        if (!TextUtils.isEmpty(requestProperty) && "0".equals(requestProperty)) {
            return false;
        }
        return true;
    }

    private void w() throws IOException {
        if (this.n) {
            IOException iOException = this.l;
            if (iOException == null) {
                if (this.k != null) {
                    return;
                } else {
                    throw new NullPointerException("Response info is null when there is no exception.");
                }
            }
            throw iOException;
        }
        throw new IllegalStateException("No response.");
    }

    private boolean x() {
        if (this.e) {
            return true;
        }
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (threadStatsTag != -1) {
            this.f = threadStatsTag;
            this.e = true;
        }
        return this.e;
    }

    private boolean y() {
        if (this.g) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        int threadStatsUid = TrafficStats.getThreadStatsUid();
        if (threadStatsUid != -1) {
            this.h = threadStatsUid;
            this.g = true;
        }
        return this.g;
    }

    public int D() {
        IOException iOException = this.l;
        if (iOException instanceof NetworkException) {
            return ((NetworkException) iOException).getCronetInternalErrorCode();
        }
        if (iOException instanceof TTRequestCanceledException) {
            return ((TTRequestCanceledException) iOException).getCronetInternalErrorCode();
        }
        return 0;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            G();
            if (this.k.c() < 400) {
                return null;
            }
            return this.i;
        } catch (IOException unused) {
            return null;
        }
    }

    private List<Map.Entry<String, String>> C() {
        List<Map.Entry<String, String>> list = this.o;
        if (list != null) {
            return list;
        }
        this.o = new ArrayList();
        Iterator<Map.Entry<String, String>> it2 = this.k.b().iterator();
        while (it2.hasNext()) {
            this.o.add(new AbstractMap.SimpleImmutableEntry(it2.next()));
        }
        List<Map.Entry<String, String>> unmodifiableList = Collections.unmodifiableList(this.o);
        this.o = unmodifiableList;
        return unmodifiableList;
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        g0 g0Var;
        if (((HttpURLConnection) this).connected && (g0Var = this.c) != null) {
            g0Var.d();
            try {
                if (this.F.compareAndSet(false, true) && this.H && !this.G.get() && this.b.b()) {
                    g gVar = this.b;
                    if (!gVar.b) {
                        gVar.a(50);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        G();
        if (!((HttpURLConnection) this).instanceFollowRedirects && this.m) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.k.c() < 400) {
            return this.i;
        }
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<String>> B() {
        Map<String, List<String>> map = this.p;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : C()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
        this.p = unmodifiableMap;
        return unmodifiableMap;
    }

    private void G() throws IOException {
        f fVar = this.j;
        if (fVar != null) {
            fVar.d();
            if (J()) {
                this.j.close();
            }
        }
        if (!this.n) {
            N();
            if (i.b()) {
                i.a("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
            }
            z(getConnectTimeout() + getReadTimeout());
            this.n = true;
        }
        w();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!((HttpURLConnection) this).connected) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Pair<String, String> pair : this.d) {
                if (!treeMap.containsKey(pair.first)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((String) pair.second);
                    treeMap.put((String) pair.first, Collections.unmodifiableList(arrayList));
                } else {
                    throw new IllegalStateException("Should not have multiple values.");
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.j == null && ((HttpURLConnection) this).doOutput) {
            if (!((HttpURLConnection) this).connected) {
                if (J()) {
                    this.j = new b(this, ((HttpURLConnection) this).chunkLength, this.b);
                    N();
                } else {
                    long H = H();
                    if (H != -1) {
                        c cVar = new c(this, H, this.w, this.b);
                        this.j = cVar;
                        if (H == 0) {
                            setFixedLengthStreamingMode((int) cVar.e().a());
                            if (getRequestProperty("Content-Length") == null) {
                                addRequestProperty("Content-Length", Long.toString(this.j.e().a()));
                            } else {
                                setRequestProperty("Content-Length", Long.toString(this.j.e().a()));
                            }
                        }
                        N();
                    } else {
                        com.ttnet.org.chromium.base.h.a(I, "Outputstream is being buffered in memory.", new Object[0]);
                        String requestProperty = getRequestProperty("Content-Length");
                        if (requestProperty == null) {
                            this.j = new com.ttnet.org.chromium.net.urlconnection.a(this);
                        } else {
                            this.j = new com.ttnet.org.chromium.net.urlconnection.a(this, Long.parseLong(requestProperty));
                        }
                    }
                }
            } else {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
        }
        return this.j;
    }

    private void N() throws IOException {
        String str;
        if (((HttpURLConnection) this).connected) {
            return;
        }
        if (i.b()) {
            i.a("CronetHttpURLConnection", "start request url = " + getURL().toString());
        }
        g.a aVar = (g.a) this.a.c(getURL().toString(), new a(), this.b);
        if (((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).method.equals("GET")) {
                ((HttpURLConnection) this).method = "POST";
            }
            f fVar = this.j;
            if (fVar != null) {
                aVar.m(fVar.e(), this.b);
                if (getRequestProperty("Content-Length") == null && !J()) {
                    addRequestProperty("Content-Length", Long.toString(this.j.e().a()));
                }
                this.j.f();
            } else if (getRequestProperty("Content-Length") == null) {
                addRequestProperty("Content-Length", "0");
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        long nanoTime = System.nanoTime();
        Map<String, String> a2 = a(P(getURL()));
        if (a2 != null && !a2.isEmpty()) {
            for (Map.Entry<String, String> entry : a2.entrySet()) {
                aVar.e(entry.getKey(), entry.getValue());
            }
        }
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000;
        for (Pair<String, String> pair : this.d) {
            aVar.e((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            aVar.g();
        }
        aVar.h(((HttpURLConnection) this).method);
        if (x()) {
            aVar.k(this.f);
        }
        if (y()) {
            aVar.l(this.h);
        }
        aVar.i(this.q);
        aVar.b(this.r);
        aVar.c(this.s);
        aVar.d(this.t);
        aVar.a(this.u);
        aVar.j(this.x);
        com.ttnet.org.chromium.net.g f = aVar.f();
        this.c = f;
        int i = this.z;
        if (i != 0) {
            f.k(i);
        }
        int i2 = this.B;
        if (i2 > 0) {
            this.c.l(i2);
        }
        String str2 = this.C;
        if (str2 != null && (str = this.D) != null) {
            this.c.i(str2, str);
        }
        this.c.h(nanoTime2);
        this.c.j(this.E);
        this.c.o();
        long j = this.A;
        if (j > 0) {
            this.c.n(j);
        }
        ((HttpURLConnection) this).connected = true;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        super.setConnectTimeout(i);
    }

    public void setInputStreamBufferSize(int i) {
        this.v = i;
    }

    public void setOutputStreamBufferSize(int i) {
        this.w = i;
    }

    public void setRequestFlag(int i) {
        this.z = i;
    }

    public void setRequestPriority(int i) {
        this.q = i;
    }

    public void setRequestTimeout(int i) {
        this.u = i;
    }

    public void setSocketConnectTimeout(int i) {
        this.r = i;
    }

    public void setSocketReadTimeout(int i) {
        this.s = i;
    }

    public void setSocketWriteTimeout(int i) {
        this.t = i;
    }

    private class a extends g0.b {
        static {
            Covode.recordClassIndex(654685);
        }

        public a() {
        }

        private void g(IOException iOException) {
            CronetHttpURLConnection.this.l = iOException;
            if (CronetHttpURLConnection.this.i != null) {
                CronetHttpURLConnection.this.i.d(iOException);
            }
            if (CronetHttpURLConnection.this.j != null) {
                CronetHttpURLConnection.this.j.g(iOException);
            }
            CronetHttpURLConnection.this.n = true;
            CronetHttpURLConnection.this.G.set(true);
            CronetHttpURLConnection.this.b.quit();
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void f(g0 g0Var, h0 h0Var) {
            CronetHttpURLConnection.this.k = h0Var;
            g(null);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void a(g0 g0Var, h0 h0Var) {
            CronetHttpURLConnection.this.k = h0Var;
            if (i.b()) {
                i.a("CronetHttpURLConnection", "onCanceled loop quit url = " + CronetHttpURLConnection.this.getURL().toString());
            }
            if (CronetHttpURLConnection.this.l == null && !CronetHttpURLConnection.this.m) {
                CronetHttpURLConnection.this.l = new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999");
            }
            g(CronetHttpURLConnection.this.l);
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void c(g0 g0Var, h0 h0Var, ByteBuffer byteBuffer) {
            CronetHttpURLConnection.this.k = h0Var;
            CronetHttpURLConnection.this.b.quit();
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void b(g0 g0Var, h0 h0Var, CronetException cronetException) {
            if (cronetException != null) {
                CronetHttpURLConnection cronetHttpURLConnection = CronetHttpURLConnection.this;
                cronetHttpURLConnection.l = cronetHttpURLConnection.O(cronetException);
                CronetHttpURLConnection.this.k = h0Var;
                g(cronetException);
                return;
            }
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void e(g0 g0Var, h0 h0Var, String str) {
            CronetHttpURLConnection.this.k = h0Var;
            CronetHttpURLConnection.this.n = true;
            if (CronetHttpURLConnection.this.k != null) {
                long nanoTime = System.nanoTime();
                CronetHttpURLConnection cronetHttpURLConnection = CronetHttpURLConnection.this;
                cronetHttpURLConnection.L(str, cronetHttpURLConnection.B());
                long nanoTime2 = (System.nanoTime() - nanoTime) / 1000;
                if (g0Var != null) {
                    g0Var.m(nanoTime2);
                }
            }
            if (i.b()) {
                i.a("CronetHttpURLConnection", "onResponseStarted loop quit url = " + CronetHttpURLConnection.this.getURL().toString());
            }
            CronetHttpURLConnection.this.b.quit();
        }

        @Override // com.ttnet.org.chromium.net.g0.b
        public void d(g0 g0Var, h0 h0Var, String str, String str2) {
            boolean z = true;
            CronetHttpURLConnection.this.m = true;
            if (h0Var != null) {
                CronetHttpURLConnection.this.L(str2, h0Var.a());
            }
            URL url = ((HttpURLConnection) CronetHttpURLConnection.this).url;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    url = new URL(str2);
                } catch (Throwable unused) {
                }
            }
            try {
                URL url2 = new URL(str);
                if (((HttpURLConnection) CronetHttpURLConnection.this).instanceFollowRedirects) {
                    ((HttpURLConnection) CronetHttpURLConnection.this).url = url2;
                }
                if (((HttpURLConnection) CronetHttpURLConnection.this).instanceFollowRedirects) {
                    if (CronetHttpURLConnection.this.c != null) {
                        if (!"http".equals(url2.getProtocol()) || !"https".equals(url.getProtocol())) {
                            z = false;
                        }
                        if (!url2.getHost().equals(url.getHost()) || z) {
                            CronetHttpURLConnection.this.c.b();
                            URL url3 = new URL(str);
                            CronetHttpURLConnection cronetHttpURLConnection = CronetHttpURLConnection.this;
                            Map a = cronetHttpURLConnection.a(cronetHttpURLConnection.P(url3));
                            if (a != null && !a.isEmpty()) {
                                for (Map.Entry entry : a.entrySet()) {
                                    CronetHttpURLConnection.this.c.a((String) entry.getKey(), (String) entry.getValue());
                                }
                            }
                        }
                        CronetHttpURLConnection.this.c.f();
                        return;
                    }
                    return;
                }
            } catch (MalformedURLException unused2) {
            }
            CronetHttpURLConnection.this.k = h0Var;
            if (CronetHttpURLConnection.this.c != null) {
                CronetHttpURLConnection.this.c.d();
            }
        }
    }

    public void setRequestTypeFlags(int i) {
        this.B = i | this.B;
    }

    void F(ByteBuffer byteBuffer) throws IOException {
        g0 g0Var = this.c;
        if (g0Var == null) {
            return;
        }
        g0Var.g(byteBuffer);
        z(getReadTimeout());
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        Map.Entry<String, String> E = E(i);
        if (E == null) {
            return null;
        }
        return E.getValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        Map.Entry<String, String> E = E(i);
        if (E == null) {
            return null;
        }
        return E.getKey();
    }

    public void setThrottleNetSpeed(long j) {
        this.A = j;
        g0 g0Var = this.c;
        if (g0Var != null) {
            g0Var.n(j);
        }
    }

    private Map.Entry<String, String> E(int i) {
        try {
            G();
            List<Map.Entry<String, String>> C = C();
            if (i >= C.size()) {
                return null;
            }
            return C.get(i);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        int A = A(str);
        if (A >= 0) {
            return (String) this.d.get(A).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if ("PATCH".equals(str)) {
            if (!((HttpURLConnection) this).connected) {
                ((HttpURLConnection) this).method = str;
                return;
            }
            throw new ProtocolException("Can't reset method: already connected");
        }
        super.setRequestMethod(str);
    }

    public void setTrafficStatsTag(int i) {
        if (!((HttpURLConnection) this).connected) {
            this.e = true;
            this.f = i;
            return;
        }
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int i) {
        if (!((HttpURLConnection) this).connected) {
            this.g = true;
            this.h = i;
            return;
        }
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    private int A(String str) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((String) this.d.get(i).first).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    private void z(int i) throws IOException {
        try {
            this.b.a(i);
        } catch (SocketTimeoutException unused) {
            g0 g0Var = this.c;
            if (g0Var != null) {
                g0Var.c();
                this.b.c();
                this.b.a(i / 2);
            }
        } catch (Exception e) {
            v("Unexpected request usage, caught in CronetHttpURLConnection.", e);
            this.b.c();
            this.b.a(i / 2);
        }
    }

    public URI P(URL url) {
        if (url == null) {
            return null;
        }
        String url2 = url.toString();
        try {
            return new URI(url2);
        } catch (URISyntaxException e) {
            try {
                try {
                    return URI.create(url2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                } catch (Exception unused) {
                    throw new RuntimeException(e);
                }
            } catch (Exception unused2) {
                return URI.create(url2.substring(0, url2.indexOf("?")));
            }
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            G();
            Map<String, List<String>> B = B();
            if (!B.containsKey(str)) {
                return null;
            }
            return B.get(str).get(r4.size() - 1);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOException O(CronetException cronetException) {
        IOException unknownHostException;
        if (!(cronetException instanceof NetworkException)) {
            return cronetException;
        }
        switch (((NetworkException) cronetException).getErrorCode()) {
            case 1:
                unknownHostException = new UnknownHostException(cronetException.getMessage());
                break;
            case 2:
            case 3:
                unknownHostException = new ConnectException(cronetException.getMessage());
                break;
            case 4:
                unknownHostException = new SocketTimeoutException(cronetException.getMessage());
                break;
            case 5:
            case 7:
                unknownHostException = new ConnectException(cronetException.getMessage());
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                unknownHostException = new ConnectTimeoutException(cronetException.getMessage());
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                unknownHostException = new SocketException("reset by peer " + cronetException.getMessage());
                break;
            case 9:
                unknownHostException = new NoRouteToHostException(cronetException.getMessage());
                break;
            default:
                return cronetException;
        }
        return unknownHostException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(URI uri) {
        HashMap hashMap = new HashMap();
        if ((this.B & 2) <= 0 && I()) {
            HashMap hashMap2 = new HashMap();
            List<Pair<String, String>> list = this.d;
            if (list != null) {
                for (Pair<String, String> pair : list) {
                    String str = (String) pair.first;
                    String str2 = (String) pair.second;
                    List list2 = (List) hashMap2.get(str);
                    if (list2 == null) {
                        list2 = new LinkedList();
                    }
                    list2.add(str2);
                    hashMap2.put(str, list2);
                }
            }
            hashMap2.put("x-tt-get-cookie-source", new LinkedList());
            Map<String, List<String>> map = null;
            try {
                if (this.y == null) {
                    this.y = CookieHandler.getDefault();
                }
                CookieHandler cookieHandler = this.y;
                if (cookieHandler != null) {
                    map = cookieHandler.get(uri, hashMap2);
                }
            } catch (Exception e) {
                if (i.b()) {
                    i.a(I, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
                }
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    int i = 0;
                    if ("x-tt-get-cookie-source".equals(key) && !entry.getValue().isEmpty()) {
                        try {
                            this.E = Integer.parseInt(entry.getValue().get(0));
                        } catch (Throwable unused) {
                            this.E = -1;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    if ("X-SS-Cookie".equalsIgnoreCase(key) || "Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                        if (!entry.getValue().isEmpty()) {
                            for (String str3 : entry.getValue()) {
                                if (i > 0) {
                                    sb.append("; ");
                                }
                                sb.append(str3);
                                i++;
                            }
                            hashMap.put(key, sb.toString());
                        }
                    }
                }
            }
            return hashMap;
        }
        if (i.b()) {
            i.a(I, "Do not read cookie from TTNet, url:" + uri);
        }
        return hashMap;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        M(str, str2, false);
    }

    public void setAuthCredentials(String str, String str2) {
        this.C = str;
        this.D = str2;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        M(str, str2, true);
    }

    public void v(String str, Throwable th) {
        g0 g0Var = this.c;
        if (g0Var != null) {
            g0Var.e(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, Map<String, List<String>> map) {
        String str2;
        if (!I()) {
            if (i.b()) {
                i.a(I, "Do not write cookie from TTNet, url:" + str);
                return;
            }
            return;
        }
        if (i.b()) {
            String str3 = I;
            StringBuilder sb = new StringBuilder();
            sb.append("Saving cookies for url: ");
            if (TextUtils.isEmpty(str)) {
                str2 = getURL().toString();
            } else {
                str2 = str;
            }
            sb.append(str2);
            i.a(str3, sb.toString());
        }
        try {
            if (this.y == null) {
                this.y = CookieHandler.getDefault();
            }
            if (this.y != null) {
                if (TextUtils.isEmpty(str)) {
                    this.y.put(P(getURL()), map);
                    return;
                }
                URI P = P(new URL(str));
                if ((this.B & 1) == 1) {
                    TreeMap treeMap = new TreeMap(map);
                    treeMap.put("webview-origin-url", Collections.singletonList(getURL().getHost()));
                    this.y.put(P, treeMap);
                    return;
                }
                this.y.put(P, map);
            }
        } catch (Exception e) {
            if (i.b()) {
                String str4 = I;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Saving cookies failed for ");
                if (TextUtils.isEmpty(str)) {
                    str = getURL().toString();
                }
                sb2.append(str);
                sb2.append(" e = ");
                sb2.append(e.getMessage());
                i.a(str4, sb2.toString());
            }
        }
    }

    public void configureConnection(String str, Object... objArr) {
        str.hashCode();
        switch (str) {
            case "setSocketConnectTimeout":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.r = ((Integer) objArr[0]).intValue();
                return;
            case "setInputStreamBufferSize":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.v = ((Integer) objArr[0]).intValue();
                return;
            case "setRequestFlag":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.z = ((Integer) objArr[0]).intValue();
                return;
            case "setOutputStreamBufferSize":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.w = ((Integer) objArr[0]).intValue();
                return;
            case "setThrottleNetSpeed":
                l.a(new Class[]{Long.TYPE}, objArr);
                long longValue = ((Long) objArr[0]).longValue();
                this.A = longValue;
                g0 g0Var = this.c;
                if (g0Var != null) {
                    g0Var.n(longValue);
                    return;
                }
                return;
            case "setSocketReadTimeout":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.s = ((Integer) objArr[0]).intValue();
                return;
            case "setRequestTimeout":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.u = ((Integer) objArr[0]).intValue();
                return;
            case "setAuthCredentials":
                l.a(new Class[]{String.class, String.class}, objArr);
                this.C = (String) objArr[0];
                this.D = (String) objArr[1];
                return;
            case "setRequestTypeFlags":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.B = ((Integer) objArr[0]).intValue();
                return;
            case "setSocketWriteTimeout":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.t = ((Integer) objArr[0]).intValue();
                return;
            case "setRequestPriority":
                l.a(new Class[]{Integer.TYPE}, objArr);
                this.q = ((Integer) objArr[0]).intValue();
                return;
            case "enableFixCancelRequestReport":
                l.a(new Class[0], objArr);
                this.H = true;
                return;
            default:
                throw new IllegalArgumentException("Unknown method name: " + str);
        }
    }

    public CronetHttpURLConnection(URL url, com.ttnet.org.chromium.net.c cVar, boolean z) {
        super(url);
        this.F = new AtomicBoolean(false);
        this.G = new AtomicBoolean(false);
        this.H = false;
        this.a = cVar;
        this.b = new g();
        if (z) {
            this.i = new e(this);
        } else {
            this.i = new d(this);
        }
        this.d = new ArrayList();
        this.y = CookieHandler.getDefault();
        this.E = -1;
    }

    private final void M(String str, String str2, boolean z) {
        if (!((HttpURLConnection) this).connected) {
            int A = A(str);
            if (A >= 0) {
                if (z) {
                    this.d.remove(A);
                } else {
                    throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
                }
            }
            this.d.add(Pair.create(str, str2));
            return;
        }
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }
}

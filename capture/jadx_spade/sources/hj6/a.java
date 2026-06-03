package hj6;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.INetworkClient;
import com.ss.videoarch.liveplayer.log.LiveError;
import hj6.b;
import hj6.e;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static volatile long k;
    private static final Pattern l;
    private static final Pattern m;
    private final ExecutorService a;
    public INetworkClient b;
    private Context c;
    private Future d;
    private volatile d h;
    public volatile String j;
    private volatile boolean e = false;
    private String f = null;
    private volatile boolean g = false;
    private int i = 600000;

    public interface d {
        void a(String str, String str2, LiveError liveError, boolean z);
    }

    public String i() {
        v();
        return this.j;
    }

    /* renamed from: hj6.a$a, reason: collision with other inner class name */
    class RunnableC0166a implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ List c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                a.this.g(this.b);
            } else {
                a.this.h(this.b, this.c);
            }
        }

        RunnableC0166a(boolean z, String str, List list) {
            this.a = z;
            this.b = str;
            this.c = list;
        }
    }

    static {
        Covode.recordClassIndex(653071);
        l = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        m = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public void e() {
        this.h = null;
        Future future = this.d;
        if (future != null && !future.isDone()) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                if (byName != null) {
                    a.this.j = byName.getHostAddress();
                    long unused = a.k = SystemClock.elapsedRealtime();
                    com.ss.videoarch.liveplayer.log.a.a("DnsHelper", "update dns server ip:" + a.this.j);
                }
            } catch (UnknownHostException unused2) {
            }
        }

        c() {
        }
    }

    public void v() {
        ExecutorService executorService;
        if (SystemClock.elapsedRealtime() - k < 300000 || (executorService = this.a) == null || executorService.isShutdown()) {
            return;
        }
        this.a.submit(new c());
    }

    class b implements e.a {
        final /* synthetic */ String a;

        @Override // hj6.e.a
        public void onError(LiveError liveError) {
            a.this.s(true, this.a, null, liveError, true);
        }

        @Override // hj6.e.a
        public void a(JSONObject jSONObject) {
            String str;
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                try {
                    str = optJSONArray.getString(0);
                } catch (Exception e) {
                    com.ss.videoarch.liveplayer.log.a.a("DnsHelper", e.toString());
                    str = null;
                }
                a.this.s(true, this.a, str, null, true);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.a);
            a.this.s(true, this.a, null, new LiveError(-100011, "http dns response ip empty", hashMap), true);
        }

        b(String str) {
            this.a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        hj6.e.a(this.b, j(str), this.f, new b(str));
    }

    private String j(String str) {
        return String.format("https://%s/q?host=%s", this.f, str);
    }

    public static String m(String str) {
        if (str != null && str.length() != 0) {
            e k2 = k(str);
            return str.substring(k2.a, k2.b);
        }
        return null;
    }

    public static boolean p(String str) {
        if (str != null && str.length() >= 7 && str.length() <= 15 && !"".equals(str)) {
            try {
                return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static e k(String str) {
        if (str != null && str.length() != 0) {
            int indexOf = str.indexOf("://") + 3;
            int length = str.length();
            int i = indexOf;
            int i2 = -1;
            while (indexOf < length) {
                char charAt = str.charAt(indexOf);
                if (charAt == '#' || charAt == '/') {
                    break;
                }
                if (charAt != ':') {
                    if (charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        i = indexOf + 1;
                    }
                } else {
                    i2 = indexOf;
                }
                indexOf++;
            }
            if (i2 == -1) {
                i2 = indexOf;
            }
            return new e(i, i2, indexOf);
        }
        return null;
    }

    public static boolean q(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.ss.videoarch.liveplayer.log.a.c("DnsHelper", "IP address is null");
            return false;
        }
        if (z) {
            return str.contains(".");
        }
        try {
            return Pattern.compile("(([0-9])|([1-9]\\d)|(([1]\\d{2})|(([2][0-4]\\d)|([2][5][0-5]))))(.(([0-9])|([1-9]\\d)|(([1]\\d{2})|(([2][0-4]\\d)|([2][5][0-5]))))){3}").matcher(Normalizer.normalize(str, Normalizer.Form.NFKC)).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean r(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.ss.videoarch.liveplayer.log.a.a("DnsHelper", "IP address is null");
            return false;
        }
        if (z) {
            return str.contains(":");
        }
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        try {
            if (!l.matcher(normalize).matches()) {
                if (!m.matcher(normalize).matches()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void f(boolean z, String str) {
        boolean z2;
        if (z && this.b != null && !TextUtils.isEmpty(str) && !str.equals("null")) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.e = z2;
        this.f = str;
        com.ss.videoarch.liveplayer.log.a.c("DnsHelper", this.e + this.f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003a, code lost:
    
        if (r8 == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static hj6.a.e l(java.lang.String r7, boolean r8) {
        /*
            if (r7 == 0) goto L4c
            int r0 = r7.length()
            if (r0 != 0) goto L9
            goto L4c
        L9:
            java.lang.String r0 = "://"
            int r0 = r7.indexOf(r0)
            int r0 = r0 + 3
            int r1 = r7.length()
            r2 = -1
            r3 = r0
            r4 = -1
        L18:
            if (r0 >= r1) goto L43
            char r5 = r7.charAt(r0)
            r6 = 35
            if (r5 == r6) goto L43
            r6 = 47
            if (r5 == r6) goto L43
            r6 = 58
            if (r5 == r6) goto L3a
            r6 = 93
            if (r5 == r6) goto L3d
            r6 = 63
            if (r5 == r6) goto L43
            r6 = 64
            if (r5 == r6) goto L37
            goto L40
        L37:
            int r3 = r0 + 1
            goto L40
        L3a:
            if (r8 != 0) goto L3d
            goto L3f
        L3d:
            if (r8 == 0) goto L40
        L3f:
            r4 = r0
        L40:
            int r0 = r0 + 1
            goto L18
        L43:
            if (r4 != r2) goto L46
            r4 = r0
        L46:
            hj6.a$e r7 = new hj6.a$e
            r7.<init>(r3, r4, r0)
            return r7
        L4c:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: hj6.a.l(java.lang.String, boolean):hj6.a$e");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<String> list) {
        InetAddress inetAddress;
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null && allByName.length > 0) {
                inetAddress = allByName[0];
                for (InetAddress inetAddress2 : allByName) {
                    String hostAddress = inetAddress2.getHostAddress();
                    if (list != null) {
                        list.add(hostAddress);
                    }
                }
            } else {
                inetAddress = null;
            }
            if (inetAddress == null) {
                s(false, str, null, new LiveError(-100010, "", null), true);
                return;
            }
            String hostAddress2 = inetAddress.getHostAddress();
            if (inetAddress instanceof Inet6Address) {
                hostAddress2 = String.format("[%s]", hostAddress2);
            }
            t(false, str, hostAddress2, list, null, true);
        } catch (UnknownHostException e2) {
            com.ss.videoarch.liveplayer.log.a.b("DnsHelper", "UnknownHostException :" + e2);
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "Unknown host name");
            hashMap.put("host", str);
            hashMap.put("exception", e2.toString());
            s(false, str, null, new LiveError(-100010, "Unknown Host", hashMap), true);
        }
    }

    private static final class e {
        int a;
        int b;
        int c;

        static {
            Covode.recordClassIndex(653073);
        }

        e(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public a(Context context, ExecutorService executorService, INetworkClient iNetworkClient) {
        this.c = context;
        this.a = executorService;
        this.b = iNetworkClient;
    }

    public static String o(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            e l2 = l(str, z);
            str.startsWith("http");
            String str3 = str.substring(0, l2.a) + str2;
            int i = l2.b;
            if (l2.c != -1) {
                str3 = str3 + str.substring(l2.b, l2.c);
                i = l2.c;
            }
            return str3 + str.substring(i);
        }
        return null;
    }

    public static String n(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            e k2 = k(str);
            boolean startsWith = str.startsWith("http");
            boolean r = r(str2, z);
            if (z) {
                if (r && !str2.contains("[")) {
                    str2 = String.format("[%s]", str2);
                }
            } else if (r) {
                str2 = String.format("[%s]", str2);
            }
            String str3 = str.substring(0, k2.a) + str2;
            int i = k2.b;
            if (k2.c != -1) {
                str3 = str3 + str.substring(k2.b, k2.c);
                i = k2.c;
            }
            if (!startsWith) {
                str3 = str3 + "/" + m(str);
            }
            return str3 + str.substring(i);
        }
        return null;
    }

    public void u(String str, List<String> list, d dVar) {
        int i;
        if (!TextUtils.isEmpty(str) && dVar != null) {
            if (this.a != null) {
                boolean z = this.e;
                e();
                this.h = dVar;
                NetworkInfo j = hj6.d.j(this.c);
                if (j != null && j.isAvailable()) {
                    i = j.getType();
                } else {
                    i = -1;
                }
                int d2 = hj6.b.e().d();
                boolean z2 = true;
                if (i != -1) {
                    if (i == d2) {
                        z2 = false;
                    }
                } else {
                    com.ss.videoarch.liveplayer.log.a.a("DnsHelper", "start: NetWork may have some problems");
                }
                if (z2) {
                    hj6.b.e().a();
                    hj6.b.e().i(i);
                }
                b.a c2 = hj6.b.e().c(str);
                if (c2 != null && System.currentTimeMillis() - c2.b <= this.i && !c2.c) {
                    try {
                        list.addAll(hj6.b.e().f(str));
                    } catch (Exception e2) {
                        com.ss.videoarch.liveplayer.log.a.b("DnsHelper", e2.toString());
                    }
                    s(this.e, str, c2.a, null, false);
                    return;
                }
                if (!this.a.isShutdown()) {
                    this.d = this.a.submit(new RunnableC0166a(z, str, list));
                    return;
                } else {
                    s(false, str, null, null, false);
                    return;
                }
            }
            throw new IllegalStateException("mExecutor should not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str, String str2, LiveError liveError, boolean z2) {
        t(z, str, str2, null, liveError, z2);
    }

    private void t(boolean z, String str, String str2, List<String> list, LiveError liveError, boolean z2) {
        d dVar;
        if (this.e == z && (dVar = this.h) != null) {
            if (z2 && str2 != null) {
                b.a aVar = new b.a();
                aVar.b = System.currentTimeMillis();
                aVar.a = str2;
                aVar.c = false;
                hj6.b.e().g(str, aVar);
                hj6.b.e().h(str, list);
            }
            dVar.a(str, str2, liveError, z2);
        }
    }
}

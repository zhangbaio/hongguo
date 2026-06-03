package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class at {
    private static final AtomicReference<a<au>> a;

    /* renamed from: a, reason: collision with other field name */
    public static final Pattern f129a;
    public static final Pattern b;
    public static final Pattern c;

    /* renamed from: a, reason: collision with other method in class */
    public static void m154a() {
        b();
    }

    public static void a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m54a("exception occurred in removing network callback :" + th);
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb.append(cArr, 0, read);
                    } else {
                        v.a((Closeable) inputStream);
                        return sb.toString();
                    }
                }
            } catch (Throwable th) {
                th = th;
                v.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, az.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_xiaomi_push_at_com_dragon_read_aop_NetworkTrafficAop_openConnection(new URL(str)));
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = polarisFileInputStreamWrapper.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuffer.append(readLine);
                            } else {
                                String stringBuffer2 = stringBuffer.toString();
                                v.a((Closeable) polarisFileInputStreamWrapper);
                                v.a(bufferedReader);
                                return stringBuffer2;
                            }
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                v.a((Closeable) null);
                v.a((Closeable) file);
                throw th3;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m152a(Context context, URL url) {
        return (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_xiaomi_push_at_com_dragon_read_aop_NetworkTrafficAop_openConnection(url));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m155a(Context context) {
        return a(context) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m151a(Context context) {
        if (d(context)) {
            return "wifi";
        }
        au m148a = m148a();
        if (m148a == null) {
            return "";
        }
        return (m148a.m158a() + "-" + m148a.m160b()).toLowerCase();
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("Failed to convert from params map to string: " + e);
                    com.xiaomi.channel.commonutils.logger.b.m54a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static URL m153a(String str) {
        return new URL(str);
    }

    private static class a<T> extends FutureTask<T> {
        private long a;

        static {
            Covode.recordClassIndex(655357);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.a = SystemClock.elapsedRealtime();
            super.run();
        }

        public boolean a() {
            if (!j.m631a(q.m640a()) && (!isDone() || Math.abs(SystemClock.elapsedRealtime() - this.a) <= 1800000)) {
                return false;
            }
            return true;
        }

        public a(Callable<T> callable) {
            super(callable);
        }
    }

    public static void b() {
        a.set(a());
    }

    public static class c {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public Map<String, String> f130a;

        static {
            Covode.recordClassIndex(655359);
        }

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f130a.toString());
        }
    }

    static {
        Covode.recordClassIndex(655356);
        a = new AtomicReference<>(a());
        f129a = Pattern.compile("([^\\s;]+)(.*)");
        b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    }

    private static a<au> a() {
        return new a<>(new Callable<au>() { // from class: com.xiaomi.push.at.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public au call() {
                NetworkInfo activeNetworkInfo;
                Context m640a = q.m640a();
                if (m640a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) m640a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new au(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public static au m148a() {
        AtomicReference<a<au>> atomicReference = a;
        a<au> aVar = atomicReference.get();
        if (aVar != null) {
            try {
                if (aVar.a()) {
                    aVar = a();
                    atomicReference.set(aVar);
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final class b extends FilterInputStream {
        private boolean a;

        static {
            Covode.recordClassIndex(655358);
        }

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.a = true;
            return -1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static au m149a(Context context) {
        return m148a();
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection INVOKEVIRTUAL_com_xiaomi_push_at_com_dragon_read_aop_NetworkTrafficAop_openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!u55.k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }

    public static int a(Context context) {
        au m148a = m148a();
        if (m148a == null) {
            return -1;
        }
        return m148a.a();
    }

    public static boolean c(Context context) {
        au m148a = m148a();
        if (m148a != null && m148a.m159a()) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        au m148a = m148a();
        if (m148a == null || 1 != m148a.a()) {
            return false;
        }
        return true;
    }

    public static boolean e(Context context) {
        au m149a = m149a(context);
        if (m149a == null || m149a.a() != 0 || 20 != m149a.b()) {
            return false;
        }
        return true;
    }

    public static boolean f(Context context) {
        au m149a = m149a(context);
        if (m149a == null || m149a.a() != 0 || 13 != m149a.b()) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = m155a(context);
            }
            if (!z && c(context)) {
                return true;
            }
        }
        z = false;
        return !z ? false : false;
    }

    public static boolean h(Context context) {
        au m149a = m149a(context);
        if (m149a == null || m149a.a() != 0) {
            return false;
        }
        int b2 = m149a.b();
        if (b2 != 1 && b2 != 2 && b2 != 4 && b2 != 7 && b2 != 11) {
            return false;
        }
        return true;
    }

    public static boolean g(Context context) {
        au m149a = m149a(context);
        if (m149a == null || m149a.a() != 0) {
            return false;
        }
        String m160b = m149a.m160b();
        if (!"TD-SCDMA".equalsIgnoreCase(m160b) && !"CDMA2000".equalsIgnoreCase(m160b) && !"WCDMA".equalsIgnoreCase(m160b)) {
            switch (m149a.b()) {
            }
            return false;
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Object m150a(Context context) {
        if (context == null) {
            context = q.m640a();
        }
        ConnectivityManager.NetworkCallback networkCallback = null;
        if (context == null || j.m631a(context)) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest build = new NetworkRequest.Builder().build();
            ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.at.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    at.b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    at.b();
                }
            };
            try {
                connectivityManager.registerNetworkCallback(build, networkCallback2);
                return networkCallback2;
            } catch (Throwable th) {
                th = th;
                networkCallback = networkCallback2;
                com.xiaomi.channel.commonutils.logger.b.m54a("exception occurred in adding network callback :" + th);
                return networkCallback;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ar a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ar a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        ar arVar = new ar();
        try {
            try {
                try {
                    HttpURLConnection m152a = m152a(context, m153a(str));
                    m152a.setConnectTimeout(10000);
                    m152a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m152a.setRequestMethod(str4);
                    int i = 0;
                    if (map != null) {
                        z = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            m152a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m152a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (z) {
                            outputStream = new GZIPOutputStream(m152a.getOutputStream());
                        } else {
                            outputStream = m152a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                            throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    arVar.a = m152a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m54a("Http POST Response Code: " + arVar.a);
                    while (true) {
                        String headerFieldKey = m152a.getHeaderFieldKey(i);
                        String headerField = m152a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(m152a.getErrorStream())));
                            }
                        } else {
                            arVar.f128a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(m152a.getInputStream())));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                arVar.f127a = stringBuffer.toString();
                bufferedReader.close();
                v.a((Closeable) null);
                v.a((Closeable) null);
                return arVar;
            } catch (IOException e3) {
                e = e3;
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
        } catch (Throwable th4) {
            v.a((Closeable) null);
            v.a((Closeable) str2);
            throw th4;
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) {
        URL url2;
        if (context != null) {
            if (url != null) {
                if (!z) {
                    url2 = new URL(a(url.toString()));
                } else {
                    url2 = url;
                }
                try {
                    HttpURLConnection.setFollowRedirects(true);
                    HttpURLConnection m152a = m152a(context, url2);
                    m152a.setConnectTimeout(10000);
                    m152a.setReadTimeout(15000);
                    if (!TextUtils.isEmpty(str)) {
                        m152a.setRequestProperty("User-Agent", str);
                    }
                    if (str2 != null) {
                        m152a.setRequestProperty("Cookie", str2);
                    }
                    if (map != null) {
                        for (String str3 : map.keySet()) {
                            m152a.setRequestProperty(str3, map.get(str3));
                        }
                    }
                    if (cVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                        cVar.a = m152a.getResponseCode();
                        if (cVar.f130a == null) {
                            cVar.f130a = new HashMap();
                        }
                        int i = 0;
                        while (true) {
                            String headerFieldKey = m152a.getHeaderFieldKey(i);
                            String headerField = m152a.getHeaderField(i);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                                cVar.f130a.put(headerFieldKey, headerField);
                            }
                            i++;
                        }
                    }
                    return new b(m152a.getInputStream());
                } catch (IOException e) {
                    throw new IOException("IOException:" + e.getClass().getSimpleName());
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }
            throw new IllegalArgumentException("url");
        }
        throw new IllegalArgumentException("context");
    }
}

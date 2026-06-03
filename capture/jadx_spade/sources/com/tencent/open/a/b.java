package com.tencent.open.a;

import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import u55.k;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class b implements a {
    private int a = 15000;
    private int b = 30000;
    private final String c;

    static {
        Covode.recordClassIndex(653500);
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 == null || map2.size() <= 0) {
            return a(str, map);
        }
        Iterator<Map.Entry<String, byte[]>> it2 = map2.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Map.Entry<String, byte[]> next = it2.next();
        return a(str, map, next.getKey(), next.getValue());
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    public b(String str) {
        this.c = str;
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_open_a_b_com_dragon_read_aop_NetworkTrafficAop_openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", this.c);
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    @Override // com.tencent.open.a.a
    public void a(long j, long j2) {
        if (j > 0 && j2 > 0) {
            this.a = (int) j;
            this.b = (int) j2;
        }
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return a(str, str2.length());
    }

    private g a(String str, int i) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_tencent_open_a_b_com_dragon_read_aop_NetworkTrafficAop_openConnection(new URL(str)));
            try {
                httpURLConnection.setRequestMethod("GET");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } else {
                                    c cVar = new c(httpURLConnection, byteArrayOutputStream2.toString(), httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), "");
                                    a(byteArrayOutputStream2);
                                    a(inputStream);
                                    b(httpURLConnection);
                                    return cVar;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(inputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    c cVar2 = new c(httpURLConnection, "", httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                    b(httpURLConnection);
                    return cVar2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append('&');
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb2 = sb.toString();
        return a(str, sb2.length(), sb2);
    }

    private g a(String str, int i, String str2) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_tencent_open_a_b_com_dragon_read_aop_NetworkTrafficAop_openConnection(new URL(str)));
            try {
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                c cVar = new c(httpURLConnection, byteArrayOutputStream.toString(), contentLength, i, httpURLConnection.getResponseCode(), "");
                                a(byteArrayOutputStream);
                                a(inputStream);
                                b(httpURLConnection);
                                return cVar;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        a(byteArrayOutputStream2);
                        a(inputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    c cVar2 = new c(httpURLConnection, "", 0, i, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                    b(httpURLConnection);
                    return cVar2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    public g a(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        int i;
        String str3;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        DataOutputStream dataOutputStream2;
        Map<String, String> map2 = map;
        SLog.i("DefaultHttpServiceImpl", "文件上传");
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_tencent_open_a_b_com_dragon_read_aop_NetworkTrafficAop_openConnection(new URL(str)));
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                try {
                    a(httpURLConnection);
                    httpURLConnection.connect();
                    DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                    if (map2 != null) {
                        try {
                            if (map.size() > 0) {
                                Iterator<String> it2 = map.keySet().iterator();
                                while (it2.hasNext()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String encode = URLEncoder.encode(it2.next(), "UTF-8");
                                    String encode2 = URLEncoder.encode(map2.get(encode), "UTF-8");
                                    stringBuffer.append("--");
                                    stringBuffer.append(uuid);
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append("Content-Disposition: form-data; name=\"");
                                    stringBuffer.append(encode);
                                    stringBuffer.append("\"");
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append(encode2);
                                    stringBuffer.append("\r\n");
                                    String stringBuffer2 = stringBuffer.toString();
                                    SLog.i("DefaultHttpServiceImpl", encode + "=" + stringBuffer2 + "##");
                                    dataOutputStream3.write(stringBuffer2.getBytes());
                                    map2 = map;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataOutputStream = dataOutputStream3;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            a(dataOutputStream);
                            a(inputStream);
                            a(byteArrayOutputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    }
                    if (bArr != null && bArr.length > 0) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("--");
                        stringBuffer3.append(uuid);
                        stringBuffer3.append("\r\n");
                        stringBuffer3.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n");
                        StringBuilder sb = new StringBuilder();
                        sb.append("Content-Type: application/octet-stream; charset=UTF-8");
                        sb.append("\r\n");
                        stringBuffer3.append(sb.toString());
                        stringBuffer3.append("\r\n");
                        dataOutputStream3.write(stringBuffer3.toString().getBytes());
                        dataOutputStream3.write(bArr, 0, bArr.length);
                        dataOutputStream3.write("\r\n".getBytes());
                        byte[] bytes = ("--" + uuid + "--\r\n").getBytes();
                        dataOutputStream3.write(bytes);
                        int length = bytes.length + 0;
                        dataOutputStream3.flush();
                        i = length;
                    } else {
                        i = 0;
                    }
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        SLog.i("DefaultHttpServiceImpl", responseCode + "");
                        if (responseCode == 200) {
                            InputStream inputStream3 = httpURLConnection.getInputStream();
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int read = inputStream3.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                    str3 = byteArrayOutputStream.toString();
                                    inputStream2 = inputStream3;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = inputStream3;
                                    dataOutputStream = dataOutputStream3;
                                    a(dataOutputStream);
                                    a(inputStream);
                                    a(byteArrayOutputStream);
                                    b(httpURLConnection);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = inputStream3;
                                dataOutputStream = dataOutputStream3;
                                byteArrayOutputStream = null;
                            }
                        } else {
                            str3 = httpURLConnection.getResponseCode() + "";
                            inputStream2 = null;
                            byteArrayOutputStream2 = null;
                        }
                        try {
                            dataOutputStream2 = dataOutputStream3;
                            try {
                                c cVar = new c(httpURLConnection, str3, httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), "");
                                a(dataOutputStream2);
                                a(inputStream2);
                                a(byteArrayOutputStream2);
                                b(httpURLConnection);
                                return cVar;
                            } catch (Throwable th4) {
                                th = th4;
                                InputStream inputStream4 = inputStream2;
                                dataOutputStream = dataOutputStream2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                inputStream = inputStream4;
                                a(dataOutputStream);
                                a(inputStream);
                                a(byteArrayOutputStream);
                                b(httpURLConnection);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            dataOutputStream2 = dataOutputStream3;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        dataOutputStream = dataOutputStream3;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        a(dataOutputStream);
                        a(inputStream);
                        a(byteArrayOutputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    byteArrayOutputStream = null;
                    dataOutputStream = null;
                    inputStream = null;
                    a(dataOutputStream);
                    a(inputStream);
                    a(byteArrayOutputStream);
                    b(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            httpURLConnection = null;
        }
    }
}

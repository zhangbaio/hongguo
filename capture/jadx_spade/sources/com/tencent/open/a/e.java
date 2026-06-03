package com.tencent.open.a;

import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.OkHttp3Instrumentation;
import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class e implements com.tencent.open.a.a {
    private OkHttpClient a;

    static {
        Covode.recordClassIndex(653503);
    }

    private void a(OkHttpClient.Builder builder) {
    }

    private static class a implements Interceptor {
        private final String a;

        static {
            Covode.recordClassIndex(653504);
        }

        public a(String str) {
            this.a = str;
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.a).build());
        }
    }

    public e(String str) throws NoClassDefFoundError {
        a(str);
    }

    private void a(String str) {
        OkHttpClient build;
        String userAgent = Version.userAgent();
        if (userAgent != null && userAgent.startsWith("okhttp/3")) {
            a aVar = new a(str);
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder addInterceptor = connectionSpecs.connectTimeout(15000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).cache((Cache) null).addInterceptor(aVar);
            a(addInterceptor);
            if (!(addInterceptor instanceof OkHttpClient.Builder)) {
                build = addInterceptor.build();
            } else {
                build = OkHttp3Instrumentation.build(addInterceptor);
            }
            this.a = build;
            return;
        }
        throw new NoClassDefFoundError();
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new d(this.a.newCall(new Request.Builder().url(str).get().build()).execute(), str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    builder.add(str2, str3);
                }
            }
        }
        FormBody build = builder.build();
        return new d(this.a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
    }

    @Override // com.tencent.open.a.a
    public void a(long j, long j2) {
        OkHttpClient build;
        if (j > 0 && j2 > 0) {
            if (this.a.connectTimeoutMillis() != j || this.a.readTimeoutMillis() != j2) {
                SLog.i("OkHttpServiceImpl", "setTimeout changed.");
                OkHttpClient.Builder newBuilder = this.a.newBuilder();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                OkHttpClient.Builder writeTimeout = newBuilder.connectTimeout(j, timeUnit).readTimeout(j2, timeUnit).writeTimeout(j2, timeUnit);
                if (!(writeTimeout instanceof OkHttpClient.Builder)) {
                    build = writeTimeout.build();
                } else {
                    build = OkHttp3Instrumentation.build(writeTimeout);
                }
                this.a = build;
            }
        }
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("OkHttpServiceImpl", "post data, has byte data");
            MultipartBody.Builder builder = new MultipartBody.Builder();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        builder.addFormDataPart(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    builder.addFormDataPart(str4, str4, RequestBody.create(MediaType.get("content/unknown"), bArr));
                    SLog.w("OkHttpServiceImpl", "post byte data.");
                }
            }
            MultipartBody build = builder.build();
            return new d(this.a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
        }
        return a(str, map);
    }
}

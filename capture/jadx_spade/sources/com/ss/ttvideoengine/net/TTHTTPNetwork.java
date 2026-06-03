package com.ss.ttvideoengine.net;

import android.os.SystemClock;
import com.bytedance.apm.agent.instrumentation.OkHttp3Instrumentation;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionSpec;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTHTTPNetwork extends TTVNetClient {
    public static final MediaType JSON;
    private static OkHttpClient mClient;
    private static boolean mClientParamsChanged;
    private static boolean mIsRetryWhenFail;
    private static int mMaxRetryTimeOut;
    private static boolean mTLSv1_2;
    private Call mCall;
    private long mStartTime;
    private int mStatus = 0;

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void cancel() {
        Call call = this.mCall;
        if (call != null && !call.isCanceled()) {
            this.mCall.cancel();
        }
    }

    static {
        Covode.recordClassIndex(652587);
        mClient = null;
        JSON = MediaType.parse("application/json");
        mIsRetryWhenFail = true;
        mMaxRetryTimeOut = 10;
        mTLSv1_2 = false;
        mClientParamsChanged = false;
    }

    public TTHTTPNetwork() {
        if (mClient == null || mClientParamsChanged) {
            synchronized (TTHTTPNetwork.class) {
                setupClient();
            }
        }
    }

    private void setupClient() {
        OkHttpClient build;
        if (mClientParamsChanged) {
            mClient = null;
        }
        if (mClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder readTimeout = builder.connectTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).readTimeout(10L, timeUnit);
            if (mTLSv1_2) {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, null);
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                    X509TrustManager x509TrustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
                    ConnectionSpec build2 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).build();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(build2);
                    arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                    arrayList.add(ConnectionSpec.CLEARTEXT);
                    readTimeout.connectionSpecs(arrayList);
                    readTimeout.sslSocketFactory(new TLSSocketFactory(sSLContext.getSocketFactory()), x509TrustManager);
                    TTVideoEngineLog.i("TTHTTPNetwork", "tls1.2 enabled");
                } catch (Exception unused) {
                    TTVideoEngineLog.e("TTHTTPNetwork", "enable tls1.2 error");
                }
            }
            if (!(readTimeout instanceof OkHttpClient.Builder)) {
                build = readTimeout.build();
            } else {
                build = OkHttp3Instrumentation.build(readTimeout);
            }
            mClient = build;
            mClientParamsChanged = false;
        }
    }

    public static void enableTLSv1_2(boolean z) {
        if (mTLSv1_2 != z) {
            mTLSv1_2 = z;
            mClientParamsChanged = true;
        }
    }

    public static void isRetryWhenFail(int i) {
        TTVideoEngineLog.d("TTHTTPNetwork", "isRetryWhenFail:" + i);
        if (i >= 0) {
            boolean z = true;
            if (i <= 1) {
                if (i != 1) {
                    z = false;
                }
                mIsRetryWhenFail = z;
            }
        }
    }

    public static void setMaxRetryTimeOut(int i) {
        TTVideoEngineLog.d("TTHTTPNetwork", "setMaxRetryTimeOut:" + i);
        if (i >= 0 && i <= 60) {
            mMaxRetryTimeOut = i;
        } else {
            mMaxRetryTimeOut = 10;
        }
    }

    private void _startTask(Request request, final TTVNetClient.CompletionListener completionListener) {
        synchronized (TTHTTPNetwork.class) {
            int i = this.mStatus;
            if (i != 3 && i != 1) {
                this.mStatus = 1;
                Call newCall = mClient.newCall(request);
                this.mCall = newCall;
                newCall.enqueue(new Callback() { // from class: com.ss.ttvideoengine.net.TTHTTPNetwork.2
                    public void onFailure(Call call, IOException iOException) {
                        TTHTTPNetwork.this.mStatus = 2;
                        completionListener.onCompletion(null, new Error("", -9994, iOException.toString()));
                    }

                    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:16:0x001c, B:18:0x0025, B:20:0x004d, B:22:0x0053, B:36:0x0044), top: B:15:0x001c }] */
                    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void onResponse(okhttp3.Call r8, okhttp3.Response r9) throws java.io.IOException {
                        /*
                            r7 = this;
                            java.lang.Class<com.ss.ttvideoengine.net.TTHTTPNetwork> r8 = com.ss.ttvideoengine.net.TTHTTPNetwork.class
                            monitor-enter(r8)
                            com.ss.ttvideoengine.net.TTHTTPNetwork r0 = com.ss.ttvideoengine.net.TTHTTPNetwork.this     // Catch: java.lang.Throwable -> L80
                            int r0 = com.ss.ttvideoengine.net.TTHTTPNetwork.access$000(r0)     // Catch: java.lang.Throwable -> L80
                            r1 = 3
                            if (r0 != r1) goto Le
                            monitor-exit(r8)     // Catch: java.lang.Throwable -> L80
                            return
                        Le:
                            com.ss.ttvideoengine.net.TTHTTPNetwork r0 = com.ss.ttvideoengine.net.TTHTTPNetwork.this     // Catch: java.lang.Throwable -> L80
                            r1 = 2
                            com.ss.ttvideoengine.net.TTHTTPNetwork.access$002(r0, r1)     // Catch: java.lang.Throwable -> L80
                            monitor-exit(r8)     // Catch: java.lang.Throwable -> L80
                            r8 = 0
                            okhttp3.ResponseBody r0 = r9.body()     // Catch: java.lang.Throwable -> L77
                            r1 = -9994(0xffffffffffffd8f6, float:NaN)
                            java.lang.String r2 = r0.string()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                            r3.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                            java.lang.String r4 = "TTHTTPNetwork"
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            r5.<init>()     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            java.lang.String r6 = "startTask onResponse body:"
                            r5.append(r6)     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            r5.append(r2)     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            java.lang.String r2 = r5.toString()     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r4, r2)     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> L40
                            r2 = -1
                            r4 = r8
                            goto L4d
                        L3e:
                            r2 = move-exception
                            goto L44
                        L40:
                            r8 = move-exception
                            goto L7a
                        L42:
                            r2 = move-exception
                            r3 = r8
                        L44:
                            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L40
                            r2.printStackTrace()     // Catch: java.lang.Throwable -> L40
                            r2 = -9994(0xffffffffffffd8f6, float:NaN)
                        L4d:
                            boolean r5 = r9.isSuccessful()     // Catch: java.lang.Throwable -> L40
                            if (r5 != 0) goto L5b
                            java.lang.String r4 = r9.message()     // Catch: java.lang.Throwable -> L40
                            int r2 = r9.code()     // Catch: java.lang.Throwable -> L40
                        L5b:
                            if (r0 == 0) goto L62
                            r0.close()     // Catch: java.lang.Exception -> L61
                            goto L62
                        L61:
                        L62:
                            if (r4 != 0) goto L6a
                            com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r9 = r2
                            r9.onCompletion(r3, r8)
                            goto L76
                        L6a:
                            com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r8 = r2
                            com.ss.ttvideoengine.utils.Error r9 = new com.ss.ttvideoengine.utils.Error
                            java.lang.String r0 = ""
                            r9.<init>(r0, r1, r2, r4)
                            r8.onCompletion(r3, r9)
                        L76:
                            return
                        L77:
                            r9 = move-exception
                            r0 = r8
                            r8 = r9
                        L7a:
                            if (r0 == 0) goto L7f
                            r0.close()     // Catch: java.lang.Exception -> L7f
                        L7f:
                            throw r8
                        L80:
                            r9 = move-exception
                            monitor-exit(r8)     // Catch: java.lang.Throwable -> L80
                            throw r9
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.net.TTHTTPNetwork.AnonymousClass2.onResponse(okhttp3.Call, okhttp3.Response):void");
                    }
                });
                return;
            }
            TTVideoEngineLog.i("TTHTTPNetwork", "_startTask status error, return. " + this.mStatus);
        }
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, final TTVNetClient.CompletionListener completionListener) {
        synchronized (TTHTTPNetwork.class) {
            setupClient();
        }
        Call newCall = mClient.newCall(new Request.Builder().url(str).build());
        this.mCall = newCall;
        newCall.enqueue(new Callback() { // from class: com.ss.ttvideoengine.net.TTHTTPNetwork.1
            public void onFailure(Call call, IOException iOException) {
                TTHTTPNetwork.this.mStatus = 2;
                completionListener.onCompletion(null, new Error("", -9994, iOException.toString()));
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponse(okhttp3.Call r6, okhttp3.Response r7) {
                /*
                    r5 = this;
                    r6 = 0
                    okhttp3.ResponseBody r0 = r7.body()     // Catch: java.lang.Throwable -> L51
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
                    java.lang.String r2 = r0.string()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
                    r2 = -1
                    r2 = r1
                    r3 = -1
                    r1 = r6
                    goto L1e
                L13:
                    r6 = move-exception
                    goto L54
                L15:
                    r1 = move-exception
                    com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r1)     // Catch: java.lang.Throwable -> L13
                    r2 = -9979(0xffffffffffffd905, float:NaN)
                    r2 = r6
                    r3 = -9979(0xffffffffffffd905, float:NaN)
                L1e:
                    if (r1 != 0) goto L31
                    boolean r4 = r7.isSuccessful()     // Catch: java.lang.Throwable -> L13
                    if (r4 != 0) goto L31
                    java.lang.Exception r1 = new java.lang.Exception     // Catch: java.lang.Throwable -> L13
                    java.lang.String r3 = "http fail"
                    r1.<init>(r3)     // Catch: java.lang.Throwable -> L13
                    int r3 = r7.code()     // Catch: java.lang.Throwable -> L13
                L31:
                    if (r0 == 0) goto L38
                    r0.close()     // Catch: java.lang.Exception -> L37
                    goto L38
                L37:
                L38:
                    if (r1 != 0) goto L40
                    com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r7 = r2
                    r7.onCompletion(r2, r6)
                    goto L50
                L40:
                    com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r6 = r2
                    com.ss.ttvideoengine.utils.Error r7 = new com.ss.ttvideoengine.utils.Error
                    java.lang.String r0 = ""
                    java.lang.String r1 = r1.toString()
                    r7.<init>(r0, r3, r1)
                    r6.onCompletion(r2, r7)
                L50:
                    return
                L51:
                    r7 = move-exception
                    r0 = r6
                    r6 = r7
                L54:
                    if (r0 == 0) goto L59
                    r0.close()     // Catch: java.lang.Exception -> L59
                L59:
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.net.TTHTTPNetwork.AnonymousClass1.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }

    private void _receivedError(Call call, IOException iOException, TTVNetClient.CompletionListener completionListener) {
        if (!mIsRetryWhenFail) {
            completionListener.onCompletion(null, new Error("", -9994, iOException.toString()));
            return;
        }
        Request request = call.request();
        if (SystemClock.elapsedRealtime() - this.mStartTime < (mMaxRetryTimeOut * 1000) - 500) {
            try {
                ThreadMonitor.sleepMonitor(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            _startTask(request, completionListener);
            return;
        }
        completionListener.onCompletion(null, new Error("", -9994, iOException.toString()));
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, Map<String, String> map, TTVNetClient.CompletionListener completionListener) {
        synchronized (TTHTTPNetwork.class) {
            setupClient();
        }
        Request.Builder url = new Request.Builder().url(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    url.header(entry.getKey(), entry.getValue());
                }
            }
        }
        _startTask(url.build(), completionListener);
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, TTVNetClient.CompletionListener completionListener) {
        synchronized (TTHTTPNetwork.class) {
            setupClient();
        }
        Request.Builder url = new Request.Builder().url(str);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        if (i == 1) {
            url.post(RequestBody.create(JSON, String.valueOf(jSONObject)));
        }
        _startTask(url.build(), completionListener);
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final TTVNetClient.RawCompletionListener rawCompletionListener) {
        synchronized (TTHTTPNetwork.class) {
            setupClient();
        }
        Request.Builder url = new Request.Builder().url(str);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        if (i == 1) {
            url.post(RequestBody.create(JSON, String.valueOf(jSONObject)));
        }
        Call newCall = mClient.newCall(url.build());
        this.mCall = newCall;
        newCall.enqueue(new Callback() { // from class: com.ss.ttvideoengine.net.TTHTTPNetwork.3
            public void onFailure(Call call, IOException iOException) {
                TTVideoEngineLog.d("TTHTTPNetwork", "startTask onFailure: " + iOException.toString());
                rawCompletionListener.onCompletion(null, new Error("", -9994, iOException.toString()));
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody;
                Throwable th;
                int i2;
                String str2;
                try {
                    responseBody = response.body();
                    try {
                        String string = responseBody.string();
                        TTVideoEngineLog.d("TTHTTPNetwork", "startTask onResponse body:" + string);
                        if (!response.isSuccessful()) {
                            str2 = response.message();
                            i2 = response.code();
                        } else {
                            i2 = -1;
                            str2 = null;
                        }
                        responseBody.close();
                        if (str2 == null) {
                            rawCompletionListener.onCompletion(string, null);
                        } else if (i2 == -9979) {
                            rawCompletionListener.onCompletion(null, new Error("", -9979, i2, str2));
                        } else {
                            rawCompletionListener.onCompletion(string, new Error("", -9994, i2, str2));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (responseBody != null) {
                            responseBody.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    responseBody = null;
                    th = th3;
                }
            }
        });
    }
}

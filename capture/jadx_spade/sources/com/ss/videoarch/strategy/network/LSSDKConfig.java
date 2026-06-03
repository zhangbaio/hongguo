package com.ss.videoarch.strategy.network;

import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import u55.k;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSSDKConfig {
    static String TAG;
    final String mApiHost;
    final List<Pair<String, String>> mCommonParams;
    final ThreadPoolExecutor mCustomThreadPool;
    final IHttpExecutor mHttpExecutor;

    public static class Builder {
        private String mApiHost;
        private List<Pair<String, String>> mCommonParams = new ArrayList();
        private ThreadPoolExecutor mCustomThreadPool;
        private IHttpExecutor mHttpExecutor;

        static {
            Covode.recordClassIndex(653150);
        }

        public LSSDKConfig build() {
            return new LSSDKConfig(this);
        }

        public Builder setApiHost(String str) {
            this.mApiHost = str;
            return this;
        }

        public Builder setCommonParams(List<Pair<String, String>> list) {
            this.mCommonParams = list;
            return this;
        }

        public Builder setCustomThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mCustomThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setHttpExecutor(IHttpExecutor iHttpExecutor) {
            this.mHttpExecutor = iHttpExecutor;
            return this;
        }
    }

    static {
        Covode.recordClassIndex(653149);
        TAG = "VeLSSettingsManager";
    }

    private class b implements IHttpExecutor {
        private int a;

        static {
            Covode.recordClassIndex(653151);
        }

        private b() {
            this.a = 10;
        }

        @Proxy("openConnection")
        @TargetClass("java.net.URL")
        @Skip({"com.bytedance.crash.upload.CrashUploader"})
        public static URLConnection a(URL url) throws IOException {
            URLConnection openConnection = url.openConnection();
            if (!k.o()) {
                return openConnection;
            }
            return u55.b.a(openConnection);
        }

        @Override // com.ss.videoarch.strategy.network.IHttpExecutor
        public String executeGet(String str) throws Exception {
            InputStream inputStream;
            HttpURLConnection b = b("GET", str);
            InputStream inputStream2 = null;
            try {
                if (b == null) {
                    Log.i(LSSDKConfig.TAG, "Get connection error");
                    return null;
                }
                try {
                } catch (Exception e) {
                    e = e;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    b.disconnect();
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
                if (b.getResponseCode() == 200) {
                    inputStream = b.getInputStream();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        String sb2 = sb.toString();
                        b.disconnect();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return sb2;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        b.disconnect();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                b.disconnect();
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private HttpURLConnection b(String str, String str2) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(a(new URL(str2)));
            } catch (Exception e) {
                e = e;
            }
            try {
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(this.a * 1000);
                httpURLConnection.setReadTimeout(this.a * 1000);
                httpURLConnection.setDoInput(true);
                return httpURLConnection;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection2 = httpURLConnection;
                e.printStackTrace();
                return httpURLConnection2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.ss.videoarch.strategy.network.IHttpExecutor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String executePost(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8) throws java.lang.Exception {
            /*
                r4 = this;
                java.lang.String r7 = "POST"
                java.net.HttpURLConnection r5 = r4.b(r7, r5)
                r7 = 0
                if (r5 != 0) goto L11
                java.lang.String r5 = com.ss.videoarch.strategy.network.LSSDKConfig.TAG
                java.lang.String r6 = "Post connection error"
                android.util.Log.i(r5, r6)
                return r7
            L11:
                java.io.OutputStream r8 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
                r8.write(r6)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L67
                int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L67
                r0 = 200(0xc8, float:2.8E-43)
                if (r6 != r0) goto L59
                java.io.InputStream r6 = r5.getInputStream()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L67
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                r1.<init>(r6)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                r0.<init>(r1)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                r1.<init>()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
            L33:
                java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                if (r2 == 0) goto L3d
                r1.append(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                goto L33
            L3d:
                java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L8d
                r8.close()     // Catch: java.io.IOException -> L45
                goto L49
            L45:
                r8 = move-exception
                r8.printStackTrace()
            L49:
                if (r6 == 0) goto L53
                r6.close()     // Catch: java.io.IOException -> L4f
                goto L53
            L4f:
                r6 = move-exception
                r6.printStackTrace()
            L53:
                r5.disconnect()
                return r7
            L57:
                r0 = move-exception
                goto L72
            L59:
                r8.close()     // Catch: java.io.IOException -> L5d
                goto L89
            L5d:
                r6 = move-exception
                r6.printStackTrace()
                goto L89
            L62:
                r6 = move-exception
                r3 = r7
                r7 = r6
                r6 = r3
                goto L8e
            L67:
                r0 = move-exception
                r6 = r7
                goto L72
            L6a:
                r6 = move-exception
                r8 = r7
                r7 = r6
                r6 = r8
                goto L8e
            L6f:
                r0 = move-exception
                r6 = r7
                r8 = r6
            L72:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L8d
                if (r8 == 0) goto L7f
                r8.close()     // Catch: java.io.IOException -> L7b
                goto L7f
            L7b:
                r8 = move-exception
                r8.printStackTrace()
            L7f:
                if (r6 == 0) goto L89
                r6.close()     // Catch: java.io.IOException -> L85
                goto L89
            L85:
                r6 = move-exception
                r6.printStackTrace()
            L89:
                r5.disconnect()
                return r7
            L8d:
                r7 = move-exception
            L8e:
                if (r8 == 0) goto L98
                r8.close()     // Catch: java.io.IOException -> L94
                goto L98
            L94:
                r8 = move-exception
                r8.printStackTrace()
            L98:
                if (r6 == 0) goto La2
                r6.close()     // Catch: java.io.IOException -> L9e
                goto La2
            L9e:
                r6 = move-exception
                r6.printStackTrace()
            La2:
                r5.disconnect()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.network.LSSDKConfig.b.executePost(java.lang.String, byte[], java.lang.String, java.lang.String):java.lang.String");
        }
    }

    private LSSDKConfig(Builder builder) {
        this.mApiHost = builder.mApiHost;
        if (builder.mHttpExecutor == null) {
            this.mHttpExecutor = new b();
            Log.i(TAG, "use DefaultHttpExecutor");
        } else {
            this.mHttpExecutor = builder.mHttpExecutor;
        }
        this.mCommonParams = builder.mCommonParams;
        this.mCustomThreadPool = builder.mCustomThreadPool;
    }
}

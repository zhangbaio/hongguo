package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.vivo.push.h.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends PthreadAsyncTask<String, Void, List<Bitmap>> {
    private Context a;
    private InsideNotificationItem b;
    private long c;
    private boolean d;
    private int e = 0;
    private NotifyArriveCallbackByUser f;
    private u.a g;

    static {
        Covode.recordClassIndex(655200);
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection INVOKEVIRTUAL_com_vivo_push_util_o_com_dragon_read_aop_NetworkTrafficAop_openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!u55.k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final /* synthetic */ void onPostExecute(Object obj) {
        List list = (List) obj;
        super/*android.os.AsyncTask*/.onPostExecute(list);
        t.c("ImageDownTask", "onPostExecute");
        com.vivo.push.t.b(new p(this, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
    
        if (r5 == null) goto L31;
     */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<android.graphics.Bitmap> doInBackground(java.lang.String... r10) {
        /*
            r9 = this;
            com.vivo.push.model.InsideNotificationItem r0 = r9.b
            int r0 = r0.getNotifyDisplayStatus()
            r9.e = r0
            boolean r0 = r9.d
            r1 = 0
            java.lang.String r2 = "ImageDownTask"
            if (r0 != 0) goto L15
            java.lang.String r10 = "bitmap is not display by forbid net"
            com.vivo.push.util.t.d(r2, r10)
            return r1
        L15:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = 0
            r4 = 0
        L1c:
            r5 = 2
            if (r4 >= r5) goto Lb1
            r5 = r10[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "imgUrl="
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r7 = " i="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.vivo.push.util.t.d(r2, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto La8
            java.net.URL r6 = new java.net.URL     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            java.net.URLConnection r5 = INVOKEVIRTUAL_com_vivo_push_util_o_com_dragon_read_aop_NetworkTrafficAop_openConnection(r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            java.net.URLConnection r5 = com.bytedance.apm.agent.instrumentation.HttpInstrumentation.openConnection(r5)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r6 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r6 = 1
            r5.setDoInput(r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r5.setUseCaches(r3)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r5.connect()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            java.lang.String r7 = "code="
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            java.lang.String r7 = r7.concat(r8)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            com.vivo.push.util.t.c(r2, r7)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L7c
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L86 java.net.MalformedURLException -> L92
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.io.IOException -> L87 java.net.MalformedURLException -> L93 java.lang.Throwable -> La0
            goto L7e
        L7c:
            r5 = r1
            r6 = r5
        L7e:
            if (r5 == 0) goto L9c
            r5.close()     // Catch: java.lang.Exception -> L9c
            goto L9c
        L84:
            r10 = move-exception
            goto La2
        L86:
            r5 = r1
        L87:
            java.lang.String r6 = "IOException"
            com.vivo.push.util.t.a(r2, r6)     // Catch: java.lang.Throwable -> La0
            if (r5 == 0) goto L9b
        L8e:
            r5.close()     // Catch: java.lang.Exception -> L9b
            goto L9b
        L92:
            r5 = r1
        L93:
            java.lang.String r6 = "MalformedURLException"
            com.vivo.push.util.t.a(r2, r6)     // Catch: java.lang.Throwable -> La0
            if (r5 == 0) goto L9b
            goto L8e
        L9b:
            r6 = r1
        L9c:
            r0.add(r6)
            goto Lad
        La0:
            r10 = move-exception
            r1 = r5
        La2:
            if (r1 == 0) goto La7
            r1.close()     // Catch: java.lang.Exception -> La7
        La7:
            throw r10
        La8:
            if (r4 != 0) goto Lad
            r0.add(r1)
        Lad:
            int r4 = r4 + 1
            goto L1c
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.o.doInBackground(java.lang.String[]):java.util.List");
    }

    public o(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, com.vivo.push.h.w wVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.a = context;
        this.b = insideNotificationItem;
        this.c = j;
        this.d = z;
        this.g = wVar;
        this.f = notifyArriveCallbackByUser;
    }
}

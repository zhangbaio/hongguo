package com.xs.fm.player.sdk.play.player.audio.engine;

import android.util.Pair;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.covode.number.Covode;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k extends TTVNetClient {
    private Call<String> a;

    static {
        Covode.recordClassIndex(655956);
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void cancel() {
        Call<String> call = this.a;
        if (call != null && !call.isCanceled()) {
            this.a.cancel();
        }
        this.a = null;
    }

    class a extends ThreadPlus {
        final /* synthetic */ String a;
        final /* synthetic */ Map b;
        final /* synthetic */ TTVNetClient.CompletionListener c;

        public void run() {
            Exception exc;
            JSONObject jSONObject;
            int i;
            SsResponse execute;
            String str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Pair parseUrl = UrlUtils.parseUrl(this.a, linkedHashMap);
                String str2 = (String) parseUrl.first;
                String str3 = (String) parseUrl.second;
                INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
                LinkedList linkedList = new LinkedList();
                Map map = this.b;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry entry : this.b.entrySet()) {
                        linkedList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
                if (iNetworkApi != null) {
                    k.this.a = iNetworkApi.doGet(true, 20480, str3, linkedHashMap, linkedList, (Object) null);
                    try {
                        execute = k.this.a.execute();
                        str = (String) execute.body();
                    } catch (Exception e) {
                        e.printStackTrace();
                        exc = e;
                        jSONObject = null;
                    }
                    if (execute.isSuccessful()) {
                        try {
                            jSONObject = new JSONObject(str);
                            exc = null;
                            i = -1;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            exc = e2;
                            jSONObject = null;
                            i = -9994;
                        }
                    } else {
                        exc = new Exception("http fail");
                        i = execute.code();
                        jSONObject = null;
                    }
                    if (exc == null) {
                        TTVNetClient.CompletionListener completionListener = this.c;
                        if (completionListener != null) {
                            if (jSONObject != null) {
                                completionListener.onCompletion(jSONObject, null);
                                return;
                            } else {
                                completionListener.onCompletion(null, new Error("", i, "null json"));
                                return;
                            }
                        }
                        return;
                    }
                    TTVNetClient.CompletionListener completionListener2 = this.c;
                    if (completionListener2 != null) {
                        completionListener2.onCompletion(null, new Error("", i, exc.toString()));
                    }
                }
            } catch (IOException e3) {
                TTVNetClient.CompletionListener completionListener3 = this.c;
                if (completionListener3 != null) {
                    completionListener3.onCompletion(null, new Error("", -1, e3.toString()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, Map map, TTVNetClient.CompletionListener completionListener) {
            super(str);
            this.a = str2;
            this.b = map;
            this.c = completionListener;
        }
    }

    class b extends ThreadPlus {
        final /* synthetic */ String a;
        final /* synthetic */ TTVNetClient.CompletionListener b;

        /* JADX WARN: Removed duplicated region for block: B:11:0x0078 A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0009, B:5:0x0027, B:7:0x0040, B:11:0x0078, B:14:0x007e, B:17:0x0082, B:20:0x008d, B:22:0x0091, B:9:0x005e, B:31:0x0055, B:32:0x006d, B:26:0x004c), top: B:2:0x0009, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0009, B:5:0x0027, B:7:0x0040, B:11:0x0078, B:14:0x007e, B:17:0x0082, B:20:0x008d, B:22:0x0091, B:9:0x005e, B:31:0x0055, B:32:0x006d, B:26:0x004c), top: B:2:0x0009, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r11 = this;
                java.lang.String r0 = ""
                java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
                r5.<init>()
                r8 = -1
                r9 = 0
                java.lang.String r1 = r11.a     // Catch: java.lang.Exception -> L9e
                android.util.Pair r1 = com.bytedance.frameworks.baselib.network.http.util.UrlUtils.parseUrl(r1, r5)     // Catch: java.lang.Exception -> L9e
                java.lang.Object r2 = r1.first     // Catch: java.lang.Exception -> L9e
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L9e
                java.lang.Object r1 = r1.second     // Catch: java.lang.Exception -> L9e
                r4 = r1
                java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L9e
                java.lang.Class<com.bytedance.ttnet.INetworkApi> r1 = com.bytedance.ttnet.INetworkApi.class
                java.lang.Object r1 = com.bytedance.ttnet.utils.RetrofitUtils.createSsService(r2, r1)     // Catch: java.lang.Exception -> L9e
                com.bytedance.ttnet.INetworkApi r1 = (com.bytedance.ttnet.INetworkApi) r1     // Catch: java.lang.Exception -> L9e
                java.util.LinkedList r6 = new java.util.LinkedList     // Catch: java.lang.Exception -> L9e
                r6.<init>()     // Catch: java.lang.Exception -> L9e
                if (r1 == 0) goto Laf
                com.xs.fm.player.sdk.play.player.audio.engine.k r10 = com.xs.fm.player.sdk.play.player.audio.engine.k.this     // Catch: java.lang.Exception -> L9e
                r2 = 1
                r3 = 20480(0x5000, float:2.8699E-41)
                r7 = 0
                com.bytedance.retrofit2.Call r1 = r1.doGet(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L9e
                com.xs.fm.player.sdk.play.player.audio.engine.k.b(r10, r1)     // Catch: java.lang.Exception -> L9e
                com.xs.fm.player.sdk.play.player.audio.engine.k r1 = com.xs.fm.player.sdk.play.player.audio.engine.k.this     // Catch: java.lang.Exception -> L9e
                com.bytedance.retrofit2.Call r1 = com.xs.fm.player.sdk.play.player.audio.engine.k.a(r1)     // Catch: java.lang.Exception -> L9e
                com.bytedance.retrofit2.SsResponse r1 = r1.execute()     // Catch: java.lang.Exception -> L9e
                if (r1 == 0) goto L6d
                java.lang.Object r2 = r1.body()     // Catch: java.lang.Exception -> L9e
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L9e
                boolean r3 = r1.isSuccessful()     // Catch: java.lang.Exception -> L9e
                if (r3 == 0) goto L5e
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L54
                r1.<init>(r2)     // Catch: java.lang.Exception -> L54
                r2 = r1
                r1 = r9
                goto L75
            L54:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Exception -> L9e
                r2 = -9994(0xffffffffffffd8f6, float:NaN)
                r2 = r9
                r3 = -9994(0xffffffffffffd8f6, float:NaN)
                goto L76
            L5e:
                java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Exception -> L9e
                java.lang.String r3 = "http fail"
                r2.<init>(r3)     // Catch: java.lang.Exception -> L9e
                int r1 = r1.code()     // Catch: java.lang.Exception -> L9e
                r3 = r1
                r1 = r2
                r2 = r9
                goto L76
            L6d:
                java.lang.Exception r1 = new java.lang.Exception     // Catch: java.lang.Exception -> L9e
                java.lang.String r2 = "null response"
                r1.<init>(r2)     // Catch: java.lang.Exception -> L9e
                r2 = r9
            L75:
                r3 = -1
            L76:
                if (r1 != 0) goto L8d
                com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r1 = r11.b     // Catch: java.lang.Exception -> L9e
                if (r1 == 0) goto Laf
                if (r2 == 0) goto L82
                r1.onCompletion(r2, r9)     // Catch: java.lang.Exception -> L9e
                goto Laf
            L82:
                com.ss.ttvideoengine.utils.Error r2 = new com.ss.ttvideoengine.utils.Error     // Catch: java.lang.Exception -> L9e
                java.lang.String r4 = "null json"
                r2.<init>(r0, r3, r4)     // Catch: java.lang.Exception -> L9e
                r1.onCompletion(r9, r2)     // Catch: java.lang.Exception -> L9e
                goto Laf
            L8d:
                com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r2 = r11.b     // Catch: java.lang.Exception -> L9e
                if (r2 == 0) goto Laf
                com.ss.ttvideoengine.utils.Error r4 = new com.ss.ttvideoengine.utils.Error     // Catch: java.lang.Exception -> L9e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L9e
                r4.<init>(r0, r3, r1)     // Catch: java.lang.Exception -> L9e
                r2.onCompletion(r9, r4)     // Catch: java.lang.Exception -> L9e
                goto Laf
            L9e:
                r1 = move-exception
                com.ss.ttvideoengine.net.TTVNetClient$CompletionListener r2 = r11.b
                if (r2 == 0) goto Laf
                com.ss.ttvideoengine.utils.Error r3 = new com.ss.ttvideoengine.utils.Error
                java.lang.String r1 = r1.toString()
                r3.<init>(r0, r8, r1)
                r2.onCompletion(r9, r3)
            Laf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xs.fm.player.sdk.play.player.audio.engine.k.b.run():void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, TTVNetClient.CompletionListener completionListener) {
            super(str);
            this.a = str2;
            this.b = completionListener;
        }
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, TTVNetClient.CompletionListener completionListener) {
        new b("MediaPlayer-NetClient", str, completionListener).start();
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String str, Map<String, String> map, TTVNetClient.CompletionListener completionListener) {
        new a("MediaPlayer-NetClient", str, map, completionListener).start();
    }
}

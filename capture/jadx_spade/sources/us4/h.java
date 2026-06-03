package us4;

import com.bytedance.apm.util.ReflectionUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineImpl;
import com.ss.ttvideoengine.VideoEngineGetInfoListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    static {
        Covode.recordClassIndex(612516);
    }

    public static final VideoEngineGetInfoListener b(TTVideoEngineImpl tTVideoEngineImpl) {
        Intrinsics.checkNotNullParameter(tTVideoEngineImpl, "<this>");
        try {
            Object fieldValue = ReflectionUtils.getFieldValue(tTVideoEngineImpl, "mVideoEngineGetInfoListener");
            if (!(fieldValue instanceof VideoEngineGetInfoListener)) {
                return null;
            }
            return (VideoEngineGetInfoListener) fieldValue;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r0 = new org.json.JSONObject();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(com.ss.ttvideoengine.TTVideoEngine r5, java.lang.String r6, java.lang.Object r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r6.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L18
            return
        L18:
            java.lang.String r0 = "mVideoEngine"
            java.lang.Object r0 = com.bytedance.apm.util.ReflectionUtils.getFieldValue(r5, r0)     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            boolean r3 = r0 instanceof com.ss.ttvideoengine.TTVideoEngineImpl     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            r4 = 0
            if (r3 == 0) goto L26
            com.ss.ttvideoengine.TTVideoEngineImpl r0 = (com.ss.ttvideoengine.TTVideoEngineImpl) r0     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            goto L27
        L26:
            r0 = r4
        L27:
            if (r0 == 0) goto L2e
            com.ss.ttvideoengine.log.IVideoEventLogger r0 = r0.getLogger()     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            goto L2f
        L2e:
            r0 = r4
        L2f:
            boolean r3 = r0 instanceof com.ss.ttvideoengine.log.VideoEventLoggerV2     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            if (r3 == 0) goto L36
            r4 = r0
            com.ss.ttvideoengine.log.VideoEventLoggerV2 r4 = (com.ss.ttvideoengine.log.VideoEventLoggerV2) r4     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
        L36:
            if (r4 != 0) goto L39
            return
        L39:
            java.lang.String r0 = "mCustomStr"
            java.lang.Object r0 = com.bytedance.apm.util.ReflectionUtils.getFieldValue(r4, r0)     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            if (r0 == 0) goto L4b
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            if (r3 != 0) goto L4a
            goto L4b
        L4a:
            r1 = 0
        L4b:
            if (r1 == 0) goto L53
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            r0.<init>()     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            goto L59
        L53:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            r0 = r1
        L59:
            r0.put(r6, r7)     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            r5.setCustomStr(r6)     // Catch: java.lang.Throwable -> L64 org.json.JSONException -> L69
            goto L6d
        L64:
            r5 = move-exception
            r5.printStackTrace()
            goto L6d
        L69:
            r5 = move-exception
            r5.printStackTrace()
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us4.h.a(com.ss.ttvideoengine.TTVideoEngine, java.lang.String, java.lang.Object):void");
    }
}

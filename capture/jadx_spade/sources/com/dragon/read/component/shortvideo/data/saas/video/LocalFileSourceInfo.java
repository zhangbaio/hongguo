package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.model.VideoModel;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LocalFileSourceInfo implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final String encryptInfo;
    private boolean isEncrypt;
    private final String localFilePath;
    private String spadea;
    private final pr3.r videoModeInfo;
    private final VideoModel videoModel;

    public static final class a {
        static {
            Covode.recordClassIndex(599114);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599113);
        Companion = new a(null);
    }

    public final String getEncryptInfo() {
        return this.encryptInfo;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getSpadea() {
        return this.spadea;
    }

    public final pr3.r getVideoModeInfo() {
        return this.videoModeInfo;
    }

    public final VideoModel getVideoModel() {
        return this.videoModel;
    }

    public final boolean isEncrypt() {
        return this.isEncrypt;
    }

    public String toString() {
        return "LocalFileSourceInfo(localFilePath='" + this.localFilePath + "', isEncrypt=" + this.isEncrypt + ", mSpadea=" + this.spadea + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (r0 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isDataValid() {
        /*
            r5 = this;
            java.lang.String r0 = "file_play"
            r1 = 0
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r2 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r5.localFilePath     // Catch: java.lang.Exception -> L77
            r2.<init>(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r2.getName()     // Catch: java.lang.Exception -> L77
            java.util.regex.Pattern r4 = a54.e.g()     // Catch: java.lang.Exception -> L77
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch: java.lang.Exception -> L77
            boolean r4 = r4.find()     // Catch: java.lang.Exception -> L77
            if (r4 != 0) goto L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            r2.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r4 = "isFileValid = false, fileName("
            r2.append(r4)     // Catch: java.lang.Exception -> L77
            r2.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = ") must endsWith vid+${vid}!"
            r2.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L77
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L77
            com.dragon.read.base.util.LogWrapper.error(r0, r2, r3)     // Catch: java.lang.Exception -> L77
            return r1
        L38:
            boolean r2 = r2.exists()     // Catch: java.lang.Exception -> L77
            if (r2 != 0) goto L5c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            r2.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = "isFileValid = false, file("
            r2.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r5.localFilePath     // Catch: java.lang.Exception -> L77
            r2.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = ") not exists!"
            r2.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L77
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L77
            com.dragon.read.base.util.LogWrapper.error(r0, r2, r3)     // Catch: java.lang.Exception -> L77
            return r1
        L5c:
            boolean r0 = r5.isEncrypt
            r2 = 1
            if (r0 == 0) goto L71
            java.lang.String r0 = r5.spadea
            if (r0 == 0) goto L6e
            int r0 = r0.length()
            if (r0 != 0) goto L6c
            goto L6e
        L6c:
            r0 = 0
            goto L6f
        L6e:
            r0 = 1
        L6f:
            if (r0 == 0) goto L75
        L71:
            boolean r0 = r5.isEncrypt
            if (r0 != 0) goto L76
        L75:
            r1 = 1
        L76:
            return r1
        L77:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isFileValid = false, e:"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            com.dragon.read.base.util.LogWrapper.error(r0, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.data.saas.video.LocalFileSourceInfo.isDataValid():boolean");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalFileSourceInfo(String localFilePath, String str) {
        this(localFilePath, null, str);
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("encrypt", false);
            this.isEncrypt = optBoolean;
            if (optBoolean) {
                this.spadea = jSONObject.optString("spade_a");
            }
        } catch (Exception e) {
            LogWrapper.error("file_play", "parse LocalFileSourceInfo encryptInfo err:" + e, new Object[0]);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalFileSourceInfo(String localFilePath, pr3.r videoModeInfo) {
        this(localFilePath, videoModeInfo, null);
        boolean z;
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        Intrinsics.checkNotNullParameter(videoModeInfo, "videoModeInfo");
        VideoModel videoModel = this.videoModel;
        String spadea = videoModel != null ? videoModel.getSpadea() : null;
        this.spadea = spadea;
        if (spadea != null && spadea.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = true ^ z;
        this.isEncrypt = z2;
        if (!z2) {
            LogWrapper.error("file_play", "parse LocalFileSourceInfo, spade_a=" + this.spadea + ", video not encrypt!", new Object[0]);
        }
    }

    private LocalFileSourceInfo(String str, pr3.r rVar, String str2) {
        VideoModel videoModel;
        this.localFilePath = str;
        this.videoModeInfo = rVar;
        this.encryptInfo = str2;
        if (rVar != null) {
            videoModel = rVar.a;
        } else {
            videoModel = null;
        }
        this.videoModel = videoModel;
    }
}

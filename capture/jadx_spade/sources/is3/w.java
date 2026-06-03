package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.ss.android.videoshop.api.IVideoEngineFactory;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    public static final int i;
    public final SaasVideoData a;
    public final String b;
    public final String c;
    public final int d;
    public IVideoEngineFactory e;
    public final long f;
    public final boolean g;
    public Function2<? super VideoModel, ? super SaasVideoData, ? extends Resolution> h;

    static {
        Covode.recordClassIndex(598930);
        i = 8;
    }

    public w(SaasVideoData data, String tag, String subTag, int i2, IVideoEngineFactory iVideoEngineFactory, long j, boolean z, Function2<? super VideoModel, ? super SaasVideoData, ? extends Resolution> function2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        this.a = data;
        this.b = tag;
        this.c = subTag;
        this.d = i2;
        this.e = iVideoEngineFactory;
        this.f = j;
        this.g = z;
        this.h = function2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ w(com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData r14, java.lang.String r15, java.lang.String r16, int r17, com.ss.android.videoshop.api.IVideoEngineFactory r18, long r19, boolean r21, kotlin.jvm.functions.Function2 r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L9
            r8 = r2
            goto Lb
        L9:
            r8 = r18
        Lb:
            r1 = r0 & 32
            if (r1 == 0) goto L13
            r3 = 0
            r9 = r3
            goto L15
        L13:
            r9 = r19
        L15:
            r1 = r0 & 64
            if (r1 == 0) goto L1c
            r1 = 0
            r11 = 0
            goto L1e
        L1c:
            r11 = r21
        L1e:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L24
            r12 = r2
            goto L26
        L24:
            r12 = r22
        L26:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: is3.w.<init>(com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData, java.lang.String, java.lang.String, int, com.ss.android.videoshop.api.IVideoEngineFactory, long, boolean, kotlin.jvm.functions.Function2, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

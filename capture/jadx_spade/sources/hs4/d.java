package hs4;

import com.bytedance.covode.number.Covode;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements ImageOriginListener {
    public static final int b;
    public final a a;

    static {
        Covode.recordClassIndex(612340);
        b = 8;
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public void onImageLoaded(String str, int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.g = i;
        }
    }
}

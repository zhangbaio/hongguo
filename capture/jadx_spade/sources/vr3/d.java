package vr3;

import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import java.io.Serializable;
import vr3.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class d {
    static {
        e.a aVar = e.a;
    }

    public static e a(e eVar, AlbumDetailModel albumDetailModel) {
        return eVar;
    }

    public static e b(e eVar, Serializable serializable) {
        return eVar;
    }

    public static e c(e eVar, SaasVideoData saasVideoData) {
        return eVar;
    }

    public static e d(e eVar, boolean z) {
        return eVar;
    }

    public static e e(e eVar, SaaSUgcPostData saaSUgcPostData) {
        return eVar;
    }

    public static /* synthetic */ void g(e eVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            eVar.H(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportVideoOverNew");
    }

    public static /* synthetic */ void h(e eVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            eVar.S0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportVideoPlayNew");
    }

    public static /* synthetic */ void f(e eVar, boolean z, Args args, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                args = null;
            }
            eVar.i0(z, args);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportRestoreButton");
    }

    public static /* synthetic */ e i(e eVar, String str, Integer num, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                num = null;
            }
            return eVar.s0(str, num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setClickedContent");
    }
}

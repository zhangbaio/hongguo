package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.ss.android.videoshop.api.IVideoEngineFactory;
import is3.m;
import iw5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ls3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e implements m {
    static {
        Covode.recordClassIndex(598909);
    }

    @Override // is3.m
    public IVideoEngineFactory c() {
        return null;
    }

    @Override // is3.m
    public q e() {
        return null;
    }

    @Override // is3.m
    public o g() {
        return null;
    }

    @Override // is3.m
    public String getSubTag() {
        return "";
    }

    @Override // is3.m
    public String getTag() {
        return "ShortPlay";
    }

    @Override // is3.m
    public g d() {
        return new c();
    }

    @Override // is3.m
    public boolean h() {
        return m.a.a(this);
    }

    @Override // is3.m
    public a.C0240a b(SaasVideoData saasVideoData) {
        return m.a.b(this, saasVideoData);
    }

    @Override // is3.m
    public b.c.b i(SaasVideoData saasVideoData) {
        String cover;
        boolean z;
        String str;
        if (saasVideoData == null || (cover = saasVideoData.getCover()) == null) {
            return null;
        }
        if (cover.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = cover;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return new b.c.b(0, str, saasVideoData.getTitle(), false, false, 2130848275, 0, (b.c.a) null, (Object) null, 472, (DefaultConstructorMarker) null);
    }
}

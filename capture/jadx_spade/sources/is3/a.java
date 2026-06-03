package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.ss.android.videoshop.api.IVideoEngineFactory;
import is3.m;
import ls3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a implements m {
    public static final int b;
    public m a;

    static {
        Covode.recordClassIndex(598905);
        b = 8;
    }

    @Override // is3.m
    public boolean h() {
        return m.a.a(this);
    }

    @Override // is3.m
    public IVideoEngineFactory c() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // is3.m
    public g d() {
        g d;
        m mVar = this.a;
        if (mVar == null || (d = mVar.d()) == null) {
            return new c();
        }
        return d;
    }

    @Override // is3.m
    public q e() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.e();
        }
        return null;
    }

    @Override // is3.m
    public k f() {
        k f;
        m mVar = this.a;
        if (mVar == null || (f = mVar.f()) == null) {
            return new d();
        }
        return f;
    }

    @Override // is3.m
    public o g() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.g();
        }
        return null;
    }

    @Override // is3.m
    public String getSubTag() {
        String subTag;
        m mVar = this.a;
        if (mVar == null || (subTag = mVar.getSubTag()) == null) {
            return "";
        }
        return subTag;
    }

    @Override // is3.m
    public String getTag() {
        String tag;
        m mVar = this.a;
        if (mVar == null || (tag = mVar.getTag()) == null) {
            return "";
        }
        return tag;
    }

    public a(m mVar) {
        this.a = mVar;
    }

    @Override // is3.m
    public a.C0240a b(SaasVideoData saasVideoData) {
        return m.a.b(this, saasVideoData);
    }
}

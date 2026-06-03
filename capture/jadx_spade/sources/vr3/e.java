package vr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import com.dragon.read.report.PageRecorder;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e {
    public static final a a;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598833);
            a = new a();
        }

        private a() {
        }
    }

    static {
        Covode.recordClassIndex(598832);
        a = a.a;
    }

    e A(String str);

    Map<String, Object> A0();

    void B();

    void B0();

    e C(PageRecorder pageRecorder);

    void C0(JSONObject jSONObject);

    String D();

    e D0(String str);

    void E();

    e E0(PageRecorder pageRecorder);

    void F();

    void F0(Args args);

    e G(String str);

    e G0(AlbumDetailModel albumDetailModel);

    void H(boolean z);

    e H0(int i);

    e I(String str);

    e I0(String str);

    void J();

    void J0();

    void K();

    e K0();

    e L(boolean z);

    e L0(float f);

    void M();

    e M0(SaaSUgcPostData saaSUgcPostData);

    void N();

    void N0();

    e O(JSONObject jSONObject);

    e O0();

    void P();

    e P0(String str);

    void Q();

    e Q0(String str);

    e R();

    void R0(Args args);

    e S(int i);

    void S0(boolean z);

    void T(Args args);

    void T0(Args args);

    e U(Serializable serializable);

    e U0();

    void V();

    e W(SaasVideoData saasVideoData);

    e X(int i);

    e Y(String str);

    void Z();

    e a(int i);

    e a0(String str);

    e b(String str);

    void b0();

    e c(String str);

    e c0(String str);

    e d(String str);

    e d0(int i);

    e e(String str);

    void e0(Args args);

    e f(boolean z);

    e f0(SaasVideoData saasVideoData);

    e g(int i);

    void g0();

    JSONObject getReportParams();

    long getStartTime();

    Object h(String str);

    e h0();

    e i(String str);

    void i0(boolean z, Args args);

    void j();

    void j0();

    e k(String str);

    e k0(String str);

    e l(String str);

    e l0(String str);

    void m();

    e m0(String str);

    e n(int i);

    void n0();

    e o(String str);

    e o0(String str);

    e p();

    e p0(String str);

    e q(String str);

    e q0(Args args);

    e r(String str);

    e r0();

    e removeParam(String str);

    void s();

    e s0(String str, Integer num);

    e setButtonName(String str);

    e setClickTo(String str);

    e setEnterFrom(String str);

    e setModuleName(String str);

    e setPageName(String str);

    e setPosition(String str);

    e setProfileUserId(String str);

    e setRecommendInfo(String str);

    e setResult(Serializable serializable);

    e t(long j);

    void t0(Args args);

    e u(String str);

    e u0(String str);

    e v(String str);

    e v0(String str);

    e w(String str);

    void w0();

    e x(String str);

    e x0(SecondaryInfo secondaryInfo);

    void y();

    e y0(Serializable serializable);

    e z();

    e z0();
}

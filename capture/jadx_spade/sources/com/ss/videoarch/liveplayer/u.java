package com.ss.videoarch.liveplayer;

import android.graphics.Bitmap;
import android.view.Surface;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface u extends IABRObserver {
    void A(o oVar, Surface surface);

    void B(o oVar, boolean z);

    void C(o oVar, String str);

    void D(o oVar, q qVar);

    void E(o oVar, int i, int i2, int i3);

    void F(o oVar, t tVar);

    void G(o oVar, int i, String str);

    void H(o oVar, VeLivePlayerDef$VeLivePlayerStatus veLivePlayerDef$VeLivePlayerStatus);

    void a(o oVar, boolean z, int i);

    void b(o oVar, float f, float f2, float f3, float f4, float f5, float f6, float f7);

    void c(o oVar, JSONObject jSONObject, String str);

    void d(o oVar, n nVar);

    void e(o oVar, m mVar);

    void f(o oVar, y yVar);

    void g(o oVar, ByteBuffer byteBuffer);

    void h(o oVar, x xVar);

    void i(o oVar, t tVar);

    void j(o oVar, VeLivePlayerDef$VeLivePlayerStreamType veLivePlayerDef$VeLivePlayerStreamType, t tVar);

    void k(o oVar, s sVar);

    void l(o oVar, int i, String str);

    void m(o oVar);

    void n(o oVar);

    void p(o oVar, Bitmap bitmap);

    void q(o oVar, s sVar, t tVar, VeLivePlayerDef$VeLivePlayerResolutionSwitchReason veLivePlayerDef$VeLivePlayerResolutionSwitchReason);

    void r(o oVar, boolean z);

    void t(o oVar, long j);

    void u(o oVar, int i, int i2);

    void v(o oVar);

    void w(o oVar, p pVar);

    void x(o oVar, v vVar);

    void y(o oVar);

    void z(o oVar, long j);
}

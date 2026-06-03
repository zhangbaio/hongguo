package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider$TTSlaSamplingSetting;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.c;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class q extends CronetEngineBuilderImpl {
    static {
        Covode.recordClassIndex(654641);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h k() {
        return super.k();
    }

    @Override // com.ttnet.org.chromium.net.h
    public com.ttnet.org.chromium.net.f b() {
        if (this.e == null) {
            M(a0());
        }
        CronetUrlRequestContext cronetUrlRequestContext = new CronetUrlRequestContext(this);
        this.m = 0L;
        return cronetUrlRequestContext;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h B(String str) {
        return super.B(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h C(String str) {
        return super.C(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h D(TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting) {
        return super.D(tTSamplingSettingProvider$TTSlaSamplingSetting);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h F(String str) {
        return super.F(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h G(String str) {
        return super.G(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h H(TTAppInfoProvider.AppInfo appInfo) {
        return super.H(appInfo);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h I(long j) {
        return super.I(j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h J(b0 b0Var) {
        return super.J(b0Var);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h K(ArrayList arrayList) {
        return super.K(arrayList);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h L(int i) {
        return super.L(i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h M(String str) {
        return super.M(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h c(boolean z) {
        return super.c(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h d(boolean z) {
        return super.d(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h e(boolean z) {
        return super.e(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h g(boolean z) {
        return super.g(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h h(boolean z) {
        return super.h(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h i(boolean z) {
        return super.i(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h j(boolean z) {
        return super.j(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h l(boolean z) {
        return super.l(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h m(long j) {
        return super.m(j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h n(TTAppInfoProvider tTAppInfoProvider) {
        return super.n(tTAppInfoProvider);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h o(com.ttnet.org.chromium.net.x xVar) {
        return super.o(xVar);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h p(int i) {
        return super.p(i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h q(String str) {
        return super.q(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h r(Map map) {
        return super.r(map);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h t(com.ttnet.org.chromium.net.w wVar) {
        return super.t(wVar);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h u(String str) {
        return super.u(str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h v(boolean z) {
        return super.v(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h w(boolean z) {
        return super.w(z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h x(c.a.b bVar) {
        return super.x(bVar);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h y(ArrayList arrayList) {
        return super.y(arrayList);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h z(boolean z) {
        return super.z(z);
    }

    public q(Context context, boolean z) {
        super(context, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h A(boolean z, boolean z2) {
        return super.A(z, z2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h E(boolean z, String str) {
        return super.E(z, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h f(int i, long j) {
        return super.f(i, j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    public /* bridge */ /* synthetic */ com.ttnet.org.chromium.net.h a(String str, int i, int i2) {
        return super.a(str, i, i2);
    }
}

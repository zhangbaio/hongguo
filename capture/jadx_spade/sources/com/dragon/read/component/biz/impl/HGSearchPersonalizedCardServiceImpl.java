package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.brickservice.ISearchPersonalizedCardService;
import com.dragon.read.util.u0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGSearchPersonalizedCardServiceImpl implements ISearchPersonalizedCardService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588065);
    }

    public boolean enableUpdateTopAreaColor() {
        return true;
    }

    public u0 getLColorParamMappingConfig() {
        u0 u0Var = new u0();
        u0Var.a = 0.25f;
        u0Var.b = 1.0f;
        u0Var.c = 0.625f;
        u0Var.d = 0.4f;
        u0Var.e = 0.5f;
        u0Var.f = 0.45f;
        return u0Var;
    }

    public u0 getSColorParamMappingConfig() {
        u0 u0Var = new u0();
        u0Var.a = 0.25f;
        u0Var.b = 1.0f;
        u0Var.c = 0.625f;
        u0Var.d = 0.6f;
        u0Var.e = 0.7f;
        u0Var.f = 0.65f;
        return u0Var;
    }
}

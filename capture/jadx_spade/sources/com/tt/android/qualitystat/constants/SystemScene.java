package com.tt.android.qualitystat.constants;

import com.bytedance.covode.number.Covode;
import sj6.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum SystemScene implements b {
    App,
    Page,
    Event,
    NULL;

    static {
        Covode.recordClassIndex(654060);
    }

    @Override // sj6.a
    public String getMainScene() {
        return "System";
    }

    @Override // sj6.b
    public String getDetailScene() {
        return b.a.a(this);
    }

    @Override // sj6.b, sj6.a
    public String getScene() {
        return b.a.b(this);
    }

    @Override // sj6.b
    public String getSceneMatchKey() {
        return b.a.c(this);
    }

    @Override // sj6.a
    public String getSubScene() {
        return name();
    }
}

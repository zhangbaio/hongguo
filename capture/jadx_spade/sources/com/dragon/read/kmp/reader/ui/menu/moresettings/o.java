package com.dragon.read.kmp.reader.ui.menu.moresettings;

import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o extends sm4.d {
    public int f;
    private String g;
    private boolean h;
    private boolean i;
    public List<String> j;

    static {
        Covode.recordClassIndex(608618);
    }

    @Override // sm4.d
    public boolean c() {
        return this.i;
    }

    @Override // sm4.d
    public String d() {
        return this.g;
    }

    @Override // sm4.d
    public boolean e() {
        return this.h;
    }

    public o(int i) {
        super(null, 1, null);
        this.f = i;
        this.g = "lock_time";
        this.i = true;
        this.j = sm4.c.a.e();
    }
}

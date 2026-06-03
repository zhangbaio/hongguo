package com.xs.fm.player.sdk.play.player.audio.engine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i {
    public static final i a;

    private i() {
    }

    static {
        Covode.recordClassIndex(655953);
        a = new i();
    }

    public final void a(TTVideoEngine tTVideoEngine, boolean z, boolean z2, String str) {
        nk6.b bVar;
        nk6.f fVar;
        gl6.c cVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null) {
            bVar = bVar2.l;
        } else {
            bVar = null;
        }
        if (!z2) {
            if (bVar != null && bVar.x()) {
                tTVideoEngine.setIntOption(42141, 1);
            }
            if (bVar != null && bVar.d()) {
                tTVideoEngine.setIntOption(42141, 1);
                tTVideoEngine.setIntOption(1416, -1);
            }
        }
        if (z2) {
            if (bVar != null && bVar.b()) {
                tTVideoEngine.setIntOption(42122, bVar.Z() ? 1 : 0);
                if (bVar.m() > 0) {
                    tTVideoEngine.setIntOption(42121, bVar.m());
                }
            }
            if (bVar != null && bVar.x()) {
                tTVideoEngine.setIntOption(1416, bVar.U());
            }
            if (bVar != null && bVar.d()) {
                tTVideoEngine.setIntOption(1416, 0);
            }
            if (bVar != null && bVar.T()) {
                tTVideoEngine.setIntOption(313, 1);
                tTVideoEngine.setIntOption(427, bVar.d0() ? 1 : 0);
                tTVideoEngine.setIntOption(42120, bVar.o0());
                tTVideoEngine.setIntOption(184, bVar.t0() ? 1 : 0);
                tTVideoEngine.setIntOption(42057, bVar.v0() ? 1 : 0);
            }
        }
        lk6.b bVar3 = lk6.c.a;
        if (bVar3 != null && (cVar = bVar3.t) != null) {
            if (cVar.f()) {
                tTVideoEngine.setIntOption(5021, 1);
            }
            if (cVar.m()) {
                tTVideoEngine.setIntOption(42054, 1);
            }
            if (cVar.k(str)) {
                tTVideoEngine.setIntOption(46023, 1000);
            }
            if (cVar.e(str)) {
                tTVideoEngine.setIntOption(478, 1);
                tTVideoEngine.setIntOption(1221, 1);
                tTVideoEngine.setIntOption(42609, 1);
                tTVideoEngine.setIntOption(42610, 1);
                tTVideoEngine.setIntOption(42604, 1);
            }
        }
        lk6.b bVar4 = lk6.c.a;
        if (bVar4 != null && (fVar = bVar4.o) != null && fVar.l()) {
            tTVideoEngine.setIntOption(42079, fVar.s());
        }
    }
}

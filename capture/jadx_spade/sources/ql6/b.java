package ql6;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.PlayEngineInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements g {
    private static g a;
    public static final b b;

    private b() {
    }

    @Override // ql6.g
    public void release() {
        a.release();
    }

    static {
        g dVar;
        nk6.f fVar;
        Covode.recordClassIndex(655974);
        b = new b();
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (fVar = bVar.o) != null && fVar.p()) {
            dVar = new c();
        } else {
            dVar = new d();
        }
        a = dVar;
    }

    @Override // ql6.g
    public void a(PlayEngineInfo playEngineInfo) {
        a.a(playEngineInfo);
    }

    @Override // ql6.g
    public boolean b(PlayEngineInfo playEngineInfo) {
        return a.b(playEngineInfo);
    }

    @Override // ql6.g
    public void c(f fVar) {
        a.c(fVar);
    }

    @Override // ql6.g
    public h e(PlayEngineInfo playEngineInfo) {
        return a.e(playEngineInfo);
    }

    @Override // ql6.g
    public void d(Context context, PlayEngineInfo playEngineInfo) {
        a.d(context, playEngineInfo);
    }
}

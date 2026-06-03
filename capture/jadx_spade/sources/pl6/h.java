package pl6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.sdk.play.player.audio.engine.j;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    private static volatile boolean a;
    private static final HashSet<String> b;

    static {
        Covode.recordClassIndex(655972);
        b = new HashSet<>();
    }

    public static final synchronized HashSet<String> c() {
        HashSet<String> hashSet;
        synchronized (h.class) {
            hashSet = b;
        }
        return hashSet;
    }

    public static final synchronized void a() {
        synchronized (h.class) {
            jl6.a.g.j();
            b.clear();
        }
    }

    public static final synchronized void g() {
        synchronized (h.class) {
            if (a) {
                return;
            }
            if (lk6.c.a.n.m()) {
                j.f();
                f.d.i();
            }
            a = true;
        }
    }

    public static final synchronized boolean d(String str) {
        boolean contains;
        synchronized (h.class) {
            contains = b.contains(str);
        }
        return contains;
    }

    public static final synchronized void e(String str) {
        synchronized (h.class) {
            b.add(str);
        }
    }

    public static final synchronized void f(String str) {
        synchronized (h.class) {
            b.add(str);
        }
    }

    public static final String b(pk6.c cVar) {
        qk6.a a2 = lk6.c.a.a(cVar.a, cVar.k);
        if (a2 != null && cVar.a != null) {
            AbsPlayList absPlayList = cVar.a;
            Intrinsics.checkExpressionValueIsNotNull(absPlayList, "playParam.playList");
            String str = cVar.b;
            Intrinsics.checkExpressionValueIsNotNull(str, "playParam.playItem");
            String str2 = cVar.k;
            Intrinsics.checkExpressionValueIsNotNull(str2, "playParam.playFrom");
            String j = a2.j(new jl6.d(absPlayList, str, str2, cVar.c, cVar.e, false, false, false, null, 480, null));
            Intrinsics.checkExpressionValueIsNotNull(j, "playStrategy.getPlayAddr…bgNoiseId\n        )\n    )");
            return j;
        }
        return "";
    }
}

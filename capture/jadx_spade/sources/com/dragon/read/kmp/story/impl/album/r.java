package com.dragon.read.kmp.story.impl.album;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static final Map<String, Set<String>> b;
    public static final int c;

    private r() {
    }

    static {
        Covode.recordClassIndex(609204);
        a = new r();
        b = new LinkedHashMap();
        c = 8;
    }

    public final void a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        b.remove(sessionId);
    }

    private final kx1.c b(ep4.b bVar) {
        kx1.c cVar = new kx1.c();
        cVar.g("book_id", bVar.a.getBookId());
        cVar.g("book_type", "short_story_album");
        cVar.g("genre", "902");
        return cVar;
    }

    public final boolean c(String sessionId, String id) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(id, "id");
        Set<String> set = b.get(sessionId);
        if (set == null || !set.contains(id)) {
            return false;
        }
        return true;
    }

    public final void d(String sessionId, String id) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(id, "id");
        Map<String, Set<String>> map = b;
        Set<String> set = map.get(sessionId);
        if (set == null) {
            set = new LinkedHashSet<>();
            map.put(sessionId, set);
        }
        set.add(id);
    }

    public final void e(ep4.b contentData, kx1.c extraArgs) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        kx1.c cVar = new kx1.c();
        cVar.j(extraArgs);
        cVar.j(a.b(contentData));
        kx1.f.a.b("click_book", cVar);
    }

    public final void f(ep4.b contentData, kx1.c extraArgs) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        kx1.c cVar = new kx1.c();
        cVar.j(extraArgs);
        cVar.j(a.b(contentData));
        kx1.f.a.b("show_book", cVar);
    }
}

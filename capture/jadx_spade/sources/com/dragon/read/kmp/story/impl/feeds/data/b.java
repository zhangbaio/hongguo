package com.dragon.read.kmp.story.impl.feeds.data;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int e;
    public final e a;
    public d b;
    public final List<bp4.a> c;
    public final List<op4.c> d;

    static {
        Covode.recordClassIndex(609266);
        e = 8;
    }

    public final int b() {
        return this.d.size();
    }

    public final String e() {
        return this.a.a;
    }

    public b(e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = new d();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public final int c(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        op4.c a = a(chapterId);
        if (a != null) {
            return a.b();
        }
        return -1;
    }

    public final String d(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        op4.c a = a(chapterId);
        if (a != null) {
            return a.c();
        }
        return null;
    }

    public final op4.c a(String chapterId) {
        Object obj;
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Iterator<T> it2 = this.d.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((op4.c) obj).a(), chapterId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (op4.c) obj;
    }
}

package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import dm4.l;
import dm4.m;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements xf4.d {
    public static final k a;

    static {
        Covode.recordClassIndex(608732);
        a = new k();
    }

    private k() {
    }

    public dm4.g P4() {
        return d.a;
    }

    public dm4.b bookshelfDepend() {
        return a.a;
    }

    public dm4.c catalogDepend() {
        return b.a;
    }

    public dm4.d chapterDepend() {
        return c.a;
    }

    public dm4.a downloadDepend() {
        return KmpDownloadDependImpl.a;
    }

    public dm4.h navigatorDepend() {
        return e.a;
    }

    public dm4.i networkDepend() {
        return f.a;
    }

    public m playerDepend() {
        return g.a;
    }

    public dm4.j reporterDepend() {
        return h.a;
    }

    public dm4.k skinDepend() {
        return i.a;
    }

    public l userInfoDepend() {
        return j.a;
    }
}

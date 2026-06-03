package com.dragon.read.nps.ui;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.ResearchSceneType;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final h a;
    private static Map<String, Boolean> b;
    private static String c;
    private static boolean d;
    private static int e;
    private static ResearchSceneType f;
    public static final int g;

    private h() {
    }

    public final ResearchSceneType b() {
        return f;
    }

    public final String c() {
        return c;
    }

    public final boolean d() {
        return d;
    }

    public final Map<String, Boolean> e() {
        return b;
    }

    public final int f() {
        return e;
    }

    public final void a() {
        b.clear();
        c = null;
        d = false;
        e = 0;
        f = null;
    }

    static {
        Covode.recordClassIndex(612570);
        a = new h();
        b = new LinkedHashMap();
        g = 8;
    }

    public final void g(ResearchSceneType researchSceneType) {
        f = researchSceneType;
    }

    public final void h(String str) {
        c = str;
    }

    public final void i(boolean z) {
        d = z;
    }

    public final void j(int i) {
        e = i;
    }
}

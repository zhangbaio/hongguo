package com.dragon.read.kmp.reader.bookcover.epub;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e {

    public static final class a {
        static {
            Covode.recordClassIndex(608269);
        }

        public static void a(e eVar) {
        }

        public static void b(e eVar, a0.h rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
        }
    }

    void a(a0.h hVar);

    void b();

    void c();

    void d();

    void e(com.dragon.read.kmp.reader.state.i iVar);

    void f(boolean z);

    void g(com.dragon.read.kmp.reader.state.i iVar);

    void h(a0.h hVar);
}

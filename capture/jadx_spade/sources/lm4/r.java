package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.AppUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static final gj4.a b;
    public static final int c;

    private r() {
    }

    static {
        Covode.recordClassIndex(608495);
        a = new r();
        b = com.dragon.read.kmp.local.a.a.c(AppUtils.a.a(), "reader_lib_config_cache");
        c = 8;
    }

    public final int a(String str) {
        if (str == null) {
            return pm4.p.a.a();
        }
        return b.getInt("key_reader_type" + str, pm4.p.a.a());
    }

    public final void b(String bookId, int i) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        b.edit().putInt("key_reader_type" + bookId, i).apply();
    }
}

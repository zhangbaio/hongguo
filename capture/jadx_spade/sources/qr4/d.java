package qr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.utils.p;
import com.dragon.read.local.db.ReaderDBManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lr4.r0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(611924);
        a = new d();
    }

    private d() {
    }

    public final List<r0> b() {
        p.g().d("访问saas数据库表：FontConfig，action:queryFontConfig");
        return ReaderDBManager.q().a();
    }

    public final Long[] a(List<r0> fontConfigs) {
        Intrinsics.checkNotNullParameter(fontConfigs, "fontConfigs");
        Long[] b = ReaderDBManager.q().b(fontConfigs);
        Intrinsics.checkNotNull(b);
        return b;
    }
}

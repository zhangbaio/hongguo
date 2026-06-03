package mp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import yo4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends a {
    public static final int f;

    static {
        Covode.recordClassIndex(609310);
        f = 8;
    }

    @Override // mp4.a
    public String s() {
        return "novel";
    }

    @Override // mp4.a
    public String t() {
        return null;
    }

    @Override // lp4.b
    public void c(ym4.a extraArgs) {
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        String str = "show_book_" + this.a.a();
        if (v(str)) {
            return;
        }
        w(str);
        g(extraArgs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(kp4.b story, d clientParam) {
        super(story, clientParam);
        Intrinsics.checkNotNullParameter(story, "story");
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
    }

    @Override // lp4.b
    public void n(String timing, String str, String barType, int i) {
        Intrinsics.checkNotNullParameter(timing, "timing");
        Intrinsics.checkNotNullParameter(barType, "barType");
        ym4.a u = u();
        u.g("timing", timing);
        u.g("next_book_id", str);
        u.g("bar_type", barType);
        if (i > 0) {
            u.g("percent", Integer.valueOf(i));
        }
        zp4.a.b(zp4.a.a, "show_nextpost_bar", u, false, null, 12, null);
    }

    @Override // lp4.b
    public void b(String timing, String str, String barType, String clickType, int i) {
        Intrinsics.checkNotNullParameter(timing, "timing");
        Intrinsics.checkNotNullParameter(barType, "barType");
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        ym4.a u = u();
        u.g("timing", timing);
        u.g("next_book_id", str);
        u.g("bar_type", barType);
        u.g("click_type", clickType);
        if (i > 0) {
            u.g("percent", Integer.valueOf(i));
        }
        zp4.a.b(zp4.a.a, "click_nextpost_bar", u, false, null, 12, null);
    }

    @Override // lp4.b
    public void m(long j, int i, int i2, boolean z, ym4.a aVar) {
        ym4.a aVar2 = new ym4.a();
        aVar2.j(r());
        aVar2.j(u());
        if (aVar != null) {
            aVar2.j(aVar);
        }
        aVar2.g("detail_type", "item");
        aVar2.g("stay_time", Long.valueOf(j));
        aVar2.g("read_pct", Integer.valueOf(i));
        aVar2.g("read_word_num", Integer.valueOf(i2));
        zp4.a.b(zp4.a.a, "stay_page", aVar2, false, null, 12, null);
    }
}

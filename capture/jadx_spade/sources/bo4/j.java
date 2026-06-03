package bo4;

import android.content.Context;
import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity;
import com.dragon.read.kmp.shortvideo.distribution.config.KmpSeriesVideoRankConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final j a;

    static {
        Covode.recordClassIndex(608999);
        a = new j();
    }

    private j() {
    }

    public final boolean b() {
        Boolean isEnableRankKmpActivity;
        ho4.a c = ho4.c.c();
        if (c != null && (isEnableRankKmpActivity = c.isEnableRankKmpActivity()) != null) {
            return isEnableRankKmpActivity.booleanValue();
        }
        return KmpSeriesVideoRankConfig.a.b();
    }

    public final void a(Context content, com.bytedance.router.c routeIntent) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(routeIntent, "routeIntent");
        oo4.e.b.startTrace();
        mo4.f.a.a(routeIntent);
        Intent intent = new Intent(content, (Class<?>) ShortSeriesKmpRankingActivity.class);
        intent.putExtras(routeIntent.b);
        ContextUtils.startActivity(content, intent);
    }
}

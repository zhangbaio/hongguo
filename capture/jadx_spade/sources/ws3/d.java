package ws3;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;
    private static final tq3.a b;

    private d() {
    }

    static {
        Covode.recordClassIndex(599154);
        a = new d();
        b = (tq3.a) ShortSeriesApi.Companion.c().getDocker().d(tq3.a.class);
    }

    public final List<String> a(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        return b.R(sharedPreferences);
    }

    public final SharedPreferences b(Context context, String cacheId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        return b.getPrivate(context, cacheId);
    }

    public final SharedPreferences c(Context context, String cacheId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        return b.t4(context, cacheId);
    }
}

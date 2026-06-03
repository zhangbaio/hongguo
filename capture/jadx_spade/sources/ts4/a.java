package ts4;

import android.util.LruCache;
import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.DeliveryPlanScene;
import com.dragon.read.rpc.model.GetPatchPlanAdRequest;
import com.dragon.read.rpc.model.GetPatchPlanAdResponse;
import com.dragon.read.rpc.model.PatchPlanAdData;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final LruCache<Long, PatchPlanAdData> b;
    public static final int c;

    private a() {
    }

    static {
        Covode.recordClassIndex(612500);
        a = new a();
        b = new LruCache<>(5);
        c = 8;
    }

    public final PatchPlanAdData a(long j) {
        return b.get(Long.valueOf(j));
    }

    public final void b(long j, PatchPlanAdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        b.put(Long.valueOf(j), adData);
    }

    public final Observable<GetPatchPlanAdResponse> c(long j, DeliveryPlanScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        GetPatchPlanAdRequest getPatchPlanAdRequest = new GetPatchPlanAdRequest();
        getPatchPlanAdRequest.bookId = j;
        getPatchPlanAdRequest.scene = scene;
        Observable<GetPatchPlanAdResponse> s = g65.d.s(getPatchPlanAdRequest);
        Intrinsics.checkNotNullExpressionValue(s, "getPatchPlanAdRxJava(...)");
        return s;
    }
}

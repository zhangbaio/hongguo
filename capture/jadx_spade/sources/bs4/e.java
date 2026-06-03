package bs4;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends com.bytedance.bdp.service.plug.network.ttnet.b {
    public static final int d;

    static {
        Covode.recordClassIndex(611977);
        d = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Observer observer) {
        b.a.getType().observeForever(observer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Observer observer) {
        b.a.getType().removeObserver(observer);
        return Unit.INSTANCE;
    }

    public void observeNetworkState(final Observer<Pair<Integer, Integer>> observer) {
        if (observer != null) {
            BdpPool.runOnMain(new Function0() { // from class: bs4.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit j;
                    j = e.j(observer);
                    return j;
                }
            });
        }
    }

    public void removeObserveNetworkState(final Observer<Pair<Integer, Integer>> observer) {
        if (observer != null) {
            BdpPool.runOnMain(new Function0() { // from class: bs4.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit k;
                    k = e.k(observer);
                    return k;
                }
            });
        }
    }
}

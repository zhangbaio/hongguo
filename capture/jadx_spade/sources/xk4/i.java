package xk4;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import pr3.n;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;

    static {
        Covode.recordClassIndex(608015);
        a = new i();
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(List list) {
        NsShortVideoApi.IMPL.enqueue(list);
        return false;
    }

    public final void b(List<String> seriesIdList, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seriesIdList, "seriesIdList");
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(seriesIdList, 10));
        Iterator<T> it2 = seriesIdList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new n((String) it2.next(), null, i, null, null, 24, null));
        }
        arrayList.addAll(arrayList2);
        if (z) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: xk4.h
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean c;
                    c = i.c(arrayList);
                    return c;
                }
            });
        } else {
            NsShortVideoApi.IMPL.enqueue(arrayList);
        }
    }
}

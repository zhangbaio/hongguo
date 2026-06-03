package ps3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.CollectionKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final int a;
    public final List<Object> b;
    private final HashMap<Object, Integer> c;
    private final HashSet<Object> d;

    static {
        Covode.recordClassIndex(599029);
    }

    public final int b() {
        return this.d.size();
    }

    public final void a(Object videoDetailModelWrapper) {
        Intrinsics.checkNotNullParameter(videoDetailModelWrapper, "videoDetailModelWrapper");
        this.d.add(videoDetailModelWrapper);
    }

    public final int c(Object videoDetailModelWrapper) {
        Integer num;
        Intrinsics.checkNotNullParameter(videoDetailModelWrapper, "videoDetailModelWrapper");
        if (!this.c.containsKey(videoDetailModelWrapper) || (num = this.c.get(videoDetailModelWrapper)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public final void d(int i) {
        List<Object> list = this.b;
        e(CollectionKt.safeSubList(list, i, list.size()));
        this.d.clear();
    }

    private final HashMap<Object, Integer> f(List<? extends Object> list) {
        HashMap<Object, Integer> hashMap = new HashMap<>();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            hashMap.put(obj, Integer.valueOf(i));
            i = i2;
        }
        return hashMap;
    }

    public final void e(List<? extends Object> videoDetailModelList) {
        Intrinsics.checkNotNullParameter(videoDetailModelList, "videoDetailModelList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : videoDetailModelList) {
            if (this.c.containsKey(obj)) {
                arrayList.add(obj);
            }
        }
        this.c.clear();
        this.c.putAll(f(arrayList));
    }

    public f(int i, List<? extends Object> videoDetailModelList) {
        Intrinsics.checkNotNullParameter(videoDetailModelList, "videoDetailModelList");
        this.a = i;
        this.b = videoDetailModelList;
        this.c = f(videoDetailModelList);
        this.d = new HashSet<>();
    }
}

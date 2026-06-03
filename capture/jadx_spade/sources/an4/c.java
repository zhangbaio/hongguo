package an4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.ApiBookInfo;
import readersaas.com.dragon.read.saas.rpc.model.DirectoryItemData;
import readersaas.com.dragon.read.saas.rpc.model.GetDirectoryForItemIdData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int f;
    public final GetDirectoryForItemIdData a;
    public a b;
    public Map<String, String> c;
    public List<String> d;
    public List<b> e;

    static {
        Covode.recordClassIndex(608716);
        f = 8;
    }

    public c(GetDirectoryForItemIdData impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.a = impl;
        ApiBookInfo bookInfo = impl.bookInfo;
        Intrinsics.checkNotNullExpressionValue(bookInfo, "bookInfo");
        this.b = new a(bookInfo);
        this.c = impl.cssMap;
        this.d = impl.itemList;
        List<DirectoryItemData> itemDataList = impl.itemDataList;
        Intrinsics.checkNotNullExpressionValue(itemDataList, "itemDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(itemDataList, 10));
        for (DirectoryItemData directoryItemData : itemDataList) {
            Intrinsics.checkNotNull(directoryItemData);
            arrayList.add(new b(directoryItemData));
        }
        this.e = arrayList;
    }
}

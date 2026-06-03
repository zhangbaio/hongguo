package ur3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SaasBookInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRelateBook;
import ur3.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(598829);
        a = new c();
    }

    private c() {
    }

    public final b a(VideoRelateBook relateBook) {
        Intrinsics.checkNotNullParameter(relateBook, "relateBook");
        SaasBookInfo saasBookInfo = relateBook.bookInfo;
        if (saasBookInfo == null) {
            return null;
        }
        String bookId = saasBookInfo.bookId;
        Intrinsics.checkNotNullExpressionValue(bookId, "bookId");
        b.a aVar = new b.a(bookId);
        aVar.b = saasBookInfo.bookName;
        aVar.c = saasBookInfo.bookShortName;
        aVar.d = saasBookInfo.tags;
        aVar.e = saasBookInfo.thumbUrl;
        aVar.f = saasBookInfo.reputationThumbUrl;
        aVar.g = saasBookInfo.creationStatus;
        aVar.h = saasBookInfo.readCount;
        aVar.i = saasBookInfo.bookType;
        aVar.j = saasBookInfo.secondaryInfo;
        aVar.k = saasBookInfo.genreType;
        aVar.l = saasBookInfo.relatePostID;
        b bVar = new b();
        bVar.a = aVar;
        bVar.b = relateBook.showInEpisodeIndex;
        return bVar;
    }
}

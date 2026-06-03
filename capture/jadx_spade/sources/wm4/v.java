package wm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.rpc.model.ApiBookInfo;
import com.dragon.read.rpc.model.SecondaryInfo;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    public static final int d;
    public ApiBookInfo a;
    public VideoTabModel.VideoData b;
    public int c;

    static {
        Covode.recordClassIndex(608676);
        d = 8;
    }

    public v() {
        this(null, null, 0, 7, null);
    }

    public final boolean f() {
        if (this.b != null) {
            return true;
        }
        return false;
    }

    public final String a() {
        String str;
        String str2;
        ApiBookInfo apiBookInfo = this.a;
        if (apiBookInfo == null || (str2 = apiBookInfo.thumbUrl) == null) {
            VideoTabModel.VideoData videoData = this.b;
            if (videoData != null) {
                str = videoData.getCover();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return str2;
    }

    public final String c() {
        String str;
        String str2;
        ApiBookInfo apiBookInfo = this.a;
        if (apiBookInfo == null || (str2 = apiBookInfo.bookId) == null) {
            VideoTabModel.VideoData videoData = this.b;
            if (videoData != null) {
                str = videoData.getSeriesId();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return str2;
    }

    public final String e() {
        String str;
        String str2;
        ApiBookInfo apiBookInfo = this.a;
        if (apiBookInfo == null || (str2 = apiBookInfo.bookName) == null) {
            VideoTabModel.VideoData videoData = this.b;
            if (videoData != null) {
                str = videoData.getTitle();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return str2;
    }

    public final String b() {
        List recTags;
        SecondaryInfo secondaryInfo;
        String str;
        List list;
        Object firstOrNull;
        String str2;
        ApiBookInfo apiBookInfo = this.a;
        if (apiBookInfo != null) {
            if (apiBookInfo == null || (list = apiBookInfo.recommendReasonList) == null) {
                return "";
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            SecondaryInfo secondaryInfo2 = (SecondaryInfo) firstOrNull;
            if (secondaryInfo2 == null || (str2 = secondaryInfo2.content) == null) {
                return "";
            }
            return str2;
        }
        VideoTabModel.VideoData videoData = this.b;
        if (videoData == null || (recTags = videoData.getRecTags()) == null || (secondaryInfo = (SecondaryInfo) CollectionsKt___CollectionsKt.getOrNull(recTags, 0)) == null || (str = secondaryInfo.content) == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if ((!r0.isEmpty()) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d() {
        /*
            r3 = this;
            com.dragon.read.rpc.model.ApiBookInfo r0 = r3.a
            r1 = 0
            if (r0 == 0) goto L12
            java.util.List r0 = r0.secondaryInfoList
            if (r0 == 0) goto L12
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto L12
            goto L13
        L12:
            r2 = 0
        L13:
            java.lang.String r0 = ""
            if (r2 == 0) goto L2e
            com.dragon.read.rpc.model.ApiBookInfo r2 = r3.a
            if (r2 == 0) goto L2d
            java.util.List r2 = r2.secondaryInfoList
            if (r2 == 0) goto L2d
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r2, r1)
            com.dragon.read.rpc.model.SecondaryInfo r1 = (com.dragon.read.rpc.model.SecondaryInfo) r1
            if (r1 == 0) goto L2d
            java.lang.String r1 = r1.content
            if (r1 != 0) goto L2c
            goto L2d
        L2c:
            r0 = r1
        L2d:
            return r0
        L2e:
            com.dragon.read.pages.bookmall.model.VideoTabModel$VideoData r2 = r3.b
            if (r2 == 0) goto L46
            java.util.List r2 = r2.getSubTitleList()
            if (r2 == 0) goto L46
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r2, r1)
            com.dragon.read.rpc.model.SecondaryInfo r1 = (com.dragon.read.rpc.model.SecondaryInfo) r1
            if (r1 == 0) goto L46
            java.lang.String r1 = r1.content
            if (r1 != 0) goto L45
            goto L46
        L45:
            r0 = r1
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wm4.v.d():java.lang.String");
    }

    public v(ApiBookInfo apiBookInfo, VideoTabModel.VideoData videoData, int i) {
        this.a = apiBookInfo;
        this.b = videoData;
        this.c = i;
    }

    public /* synthetic */ v(ApiBookInfo apiBookInfo, VideoTabModel.VideoData videoData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : apiBookInfo, (i2 & 2) != 0 ? null : videoData, (i2 & 4) != 0 ? 1 : i);
    }
}

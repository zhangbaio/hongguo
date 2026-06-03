package wo4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import com.dragon.read.component.shortvideo.api.p;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements p {
    public static final int b;
    private final List<om0> a;

    static {
        Covode.recordClassIndex(609142);
        b = 8;
    }

    @Override // com.dragon.read.component.shortvideo.api.p
    public Single<DataSource> L1() {
        return p.a.d(this);
    }

    @Override // com.dragon.read.component.shortvideo.api.p
    public Single<DataSource> K1() {
        List<SaaSUgcPostDataWrapper> c = c();
        DataSource dataSource = new DataSource();
        dataSource.mDataProviderList = c;
        return Single.just(dataSource);
    }

    @Override // com.dragon.read.component.shortvideo.api.p
    public Single<DataSource> e() {
        Single<DataSource> just = Single.just(new DataSource());
        Intrinsics.checkNotNullExpressionValue(just, "just(...)");
        return just;
    }

    private final List<SaaSUgcPostDataWrapper> c() {
        ArrayList arrayList = new ArrayList();
        for (om0 om0Var : this.a) {
            Integer num = om0Var.y;
            int value = VideoContentType.PUGC.getValue();
            if (num != null && num.intValue() == value) {
                arrayList.add(g(om0Var));
            }
        }
        return arrayList;
    }

    public a(List<om0> curDataList) {
        Intrinsics.checkNotNullParameter(curDataList, "curDataList");
        this.a = curDataList;
    }

    @Override // com.dragon.read.component.shortvideo.api.p
    public int M1(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Iterator<om0> it2 = this.a.iterator();
        int i = 0;
        while (true) {
            if (it2.hasNext()) {
                if (Intrinsics.areEqual(it2.next().p, seriesId)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:12:0x0007, B:14:0x001e, B:20:0x002b), top: B:11:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper g(com.bytedance.kmp.reading.model.om0 r5) {
        /*
            r4 = this;
            com.dragon.read.kmp.utils.x r0 = com.dragon.read.kmp.utils.x.a
            r0 = 0
            if (r5 != 0) goto L7
        L5:
            r5 = r0
            goto L58
        L7:
            com.dragon.read.kmp.utils.v r1 = com.dragon.read.kmp.utils.v.a     // Catch: java.lang.Exception -> L32
            gn6.a r1 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Exception -> L32
            r1.getSerializersModule()     // Catch: java.lang.Exception -> L32
            com.bytedance.kmp.reading.model.om0$b r2 = com.bytedance.kmp.reading.model.om0.Companion     // Catch: java.lang.Exception -> L32
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: java.lang.Exception -> L32
            kotlinx.serialization.SerializationStrategy r2 = (kotlinx.serialization.SerializationStrategy) r2     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = r1.a(r2, r5)     // Catch: java.lang.Exception -> L32
            if (r1 == 0) goto L27
            int r2 = r1.length()     // Catch: java.lang.Exception -> L32
            if (r2 != 0) goto L25
            goto L27
        L25:
            r2 = 0
            goto L28
        L27:
            r2 = 1
        L28:
            if (r2 == 0) goto L2b
            goto L5
        L2b:
            java.lang.Class<com.dragon.read.rpc.model.VideoData> r2 = com.dragon.read.rpc.model.VideoData.class
            java.lang.Object r5 = com.dragon.read.base.util.JSONUtils.fromJson(r1, r2)     // Catch: java.lang.Exception -> L32
            goto L58
        L32:
            r1 = move-exception
            com.dragon.read.kmp.utils.q r2 = com.dragon.read.kmp.utils.q.a
            boolean r2 = r2.a()
            if (r2 != 0) goto L8f
            com.dragon.read.kmp.j r5 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "convertKmpToAndroidData,error = "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KmpDataConvertUtil"
            r5.d(r2, r1)
            goto L5
        L58:
            com.dragon.read.rpc.model.VideoData r5 = (com.dragon.read.rpc.model.VideoData) r5
            com.dragon.read.pages.bookmall.model.VideoTabModel$VideoData r5 = com.dragon.read.pages.bookmall.model.VideoTabModel.VideoData.parseVideoData(r5)
            com.dragon.read.video.VideoDetailModel r1 = r5.getVideoDetailModel()
            com.dragon.read.video.VideoDetailModel r1 = r1.getBindVideoDetail()
            r2 = 7
            if (r1 != 0) goto L7c
            com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData r1 = new com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData
            r1.<init>()
            com.dragon.read.component.shortvideo.api.NsShortVideoApi r3 = com.dragon.read.component.shortvideo.api.NsShortVideoApi.IMPL
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r3.parseUgcPostData(r1, r5)
            com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper r5 = new com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper
            r5.<init>(r0, r1, r2)
            goto L8e
        L7c:
            com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostData r1 = new com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostData
            r1.<init>()
            com.dragon.read.component.shortvideo.api.NsShortVideoApi r3 = com.dragon.read.component.shortvideo.api.NsShortVideoApi.IMPL
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r3.parseSeriesUgcPostData(r1, r5)
            com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostDataWrapper r5 = new com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostDataWrapper
            r5.<init>(r0, r1, r2)
        L8e:
            return r5
        L8f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "convertKmpToAndroidData data:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = ", error:"
            r2.append(r5)
            r2.append(r1)
            java.lang.String r5 = r2.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wo4.a.g(com.bytedance.kmp.reading.model.om0):com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper");
    }
}

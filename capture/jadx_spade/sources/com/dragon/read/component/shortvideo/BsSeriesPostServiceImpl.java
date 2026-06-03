package com.dragon.read.component.shortvideo;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.BsSeriesPostServiceImpl;
import com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService;
import com.dragon.read.component.shortvideo.pictext.config.ContentCommunityCommonConfig;
import com.dragon.read.saas.ugc.model.ArticleApiERR;
import com.dragon.read.saas.ugc.model.UgcActionType;
import h44.a;
import h44.l;
import h44.o;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l34.d;
import n34.q;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BsSeriesPostServiceImpl implements BsSeriesPostService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(598100);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public boolean canShowSeriesPostTabInCollect() {
        return q.a.e();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public List<String> getSeriesPostPreloadFontList() {
        return ContentCommunityCommonConfig.a.c().preloadFontList;
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public void setHasCreateSeriesPost(boolean z) {
        q.a.o(z);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public void onBookMallTabListLoaded(List<Integer> bookMallTabTypeList) {
        Intrinsics.checkNotNullParameter(bookMallTabTypeList, "bookMallTabTypeList");
        q.a.m(bookMallTabTypeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d doPostAction$lambda$1(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (d) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d doPostAction$lambda$0(UgcActionType ugcActionType, a it2) {
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        Integer num2 = null;
        if (ugcActionType != null) {
            num = Integer.valueOf(ugcActionType.getValue());
        } else {
            num = null;
        }
        ArticleApiERR articleApiERR = it2.b;
        if (articleApiERR != null) {
            num2 = Integer.valueOf(articleApiERR.getValue());
        }
        return new d(num, num2, it2.c);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public Single<Boolean> diggPicTextLike(String postId, boolean z, String str) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        return l.a.d(postId, z, str);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService
    public Single<d> doPostAction(String postId, final UgcActionType ugcActionType, Boolean bool) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        Single g = o.a.g(postId, ugcActionType, bool);
        final Function1 function1 = new Function1() { // from class: jq3.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                l34.d doPostAction$lambda$0;
                doPostAction$lambda$0 = BsSeriesPostServiceImpl.doPostAction$lambda$0(ugcActionType, (h44.a) obj);
                return doPostAction$lambda$0;
            }
        };
        Single<d> map = g.map(new Function() { // from class: jq3.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                l34.d doPostAction$lambda$1;
                doPostAction$lambda$1 = BsSeriesPostServiceImpl.doPostAction$lambda$1(Function1.this, obj);
                return doPostAction$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }
}

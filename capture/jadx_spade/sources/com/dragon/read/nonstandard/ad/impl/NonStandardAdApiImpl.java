package com.dragon.read.nonstandard.ad.impl;

import android.app.Activity;
import android.app.Application;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.download.JumpSchemaCallback;
import com.dragon.read.nonstandard.ad.api.NonStandardAdApi;
import com.dragon.read.nonstandard.ad.config.VideoEnablePatchAds;
import com.dragon.read.nonstandard.ad.impl.NonStandardAdApiImpl;
import com.dragon.read.pages.bullet.LynxCardView;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.rpc.model.DeliveryPlanScene;
import com.dragon.read.rpc.model.GetPatchPlanAdResponse;
import com.dragon.read.rpc.model.PatchPlanAdData;
import com.dragon.read.util.NetReqUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ts4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NonStandardAdApiImpl implements NonStandardAdApi {
    public static final int $stable;
    private final Map<Long, Function1<Boolean, Unit>> detectTask = new LinkedHashMap();
    private final Map<String, Function2<String, Integer, Boolean>> pauseAddetectTaskMap = new LinkedHashMap();

    static {
        Covode.recordClassIndex(612506);
        $stable = 8;
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public PatchPlanAdData getAdData(long j) {
        return a.a.a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetPatchPlanAdResponse getPauseAdData$lambda$4(GetPatchPlanAdResponse it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        NetReqUtil.assertRspDataOk(it2);
        return it2;
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public LynxCardView getSeriesAttachedAdLynxView(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new LynxCardView(activity);
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public void releaseDetectTask(long j) {
        this.detectTask.remove(Long.valueOf(j));
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public Observable<GetPatchPlanAdResponse> getPauseAdData(long j) {
        Observable<GetPatchPlanAdResponse> c = a.a.c(j, DeliveryPlanScene.StopPatch);
        final Function1 function1 = new Function1() { // from class: ts4.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetPatchPlanAdResponse pauseAdData$lambda$4;
                pauseAdData$lambda$4 = NonStandardAdApiImpl.getPauseAdData$lambda$4((GetPatchPlanAdResponse) obj);
                return pauseAdData$lambda$4;
            }
        };
        Observable map = c.map(new Function() { // from class: ts4.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GetPatchPlanAdResponse pauseAdData$lambda$5;
                pauseAdData$lambda$5 = NonStandardAdApiImpl.getPauseAdData$lambda$5(Function1.this, obj);
                return pauseAdData$lambda$5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetPatchPlanAdResponse getPauseAdData$lambda$5(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (GetPatchPlanAdResponse) function1.invoke(p0);
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public boolean checkPauseAdInserted(String seriesId, int i) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Function2<String, Integer, Boolean> function2 = this.pauseAddetectTaskMap.get(seriesId);
        if (function2 != null) {
            return function2.invoke(seriesId, Integer.valueOf(i)).booleanValue();
        }
        return false;
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public void detectNonStandardAd(long j, Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!VideoEnablePatchAds.a.a().enable) {
            result.invoke(Boolean.FALSE);
        } else {
            this.detectTask.put(Long.valueOf(j), result);
        }
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public void recordInsertPauseAd(String seriesId, Function2<? super String, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        if (function2 == null) {
            this.pauseAddetectTaskMap.remove(seriesId);
        } else {
            this.pauseAddetectTaskMap.put(seriesId, function2);
        }
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public void getAdData(final long j, final Function2<? super PatchPlanAdData, ? super Boolean, Unit> result) {
        boolean z;
        Intrinsics.checkNotNullParameter(result, "result");
        a aVar = a.a;
        PatchPlanAdData a = aVar.a(j);
        if (a == null) {
            Observable<GetPatchPlanAdResponse> observeOn = aVar.c(j, DeliveryPlanScene.SeriesPatch).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final Function1 function1 = new Function1() { // from class: ts4.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit adData$lambda$0;
                    adData$lambda$0 = NonStandardAdApiImpl.getAdData$lambda$0(Function2.this, j, this, (GetPatchPlanAdResponse) obj);
                    return adData$lambda$0;
                }
            };
            Consumer<? super GetPatchPlanAdResponse> consumer = new Consumer() { // from class: ts4.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Function1.this.invoke(obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: ts4.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit adData$lambda$2;
                    adData$lambda$2 = NonStandardAdApiImpl.getAdData$lambda$2(Function2.this, this, j, (Throwable) obj);
                    return adData$lambda$2;
                }
            };
            observeOn.subscribe(consumer, new Consumer() { // from class: ts4.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Function1.this.invoke(obj);
                }
            });
            return;
        }
        result.invoke(a, Boolean.TRUE);
        Function1<Boolean, Unit> remove = this.detectTask.remove(Long.valueOf(j));
        if (remove != null) {
            List list = a.items;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            remove.invoke(Boolean.valueOf(!z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAdData$lambda$2(Function2 function2, NonStandardAdApiImpl nonStandardAdApiImpl, long j, Throwable th) {
        Boolean bool = Boolean.FALSE;
        function2.invoke(null, bool);
        Function1<Boolean, Unit> remove = nonStandardAdApiImpl.detectTask.remove(Long.valueOf(j));
        if (remove != null) {
            remove.invoke(bool);
        }
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.nonstandard.ad.api.NonStandardAdApi
    public void handleJumpSchema(String openUrl, String webUrl, List<String> clickList, long j) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Intrinsics.checkNotNullParameter(clickList, "clickList");
        NsAdApi nsAdApi = NsAdApi.IMPL;
        Application context = App.context();
        jf2.a aVar = new jf2.a(openUrl, webUrl, clickList, j);
        PageRecorder currentPageRecorder = PageRecorderUtils.getCurrentPageRecorder();
        Intrinsics.checkNotNullExpressionValue(currentPageRecorder, "getCurrentPageRecorder(...)");
        NsAdApi.b.a(nsAdApi, context, aVar, currentPageRecorder, (JumpSchemaCallback) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAdData$lambda$0(Function2 function2, long j, NonStandardAdApiImpl nonStandardAdApiImpl, GetPatchPlanAdResponse getPatchPlanAdResponse) {
        List list;
        boolean z;
        function2.invoke(getPatchPlanAdResponse.data, Boolean.FALSE);
        a aVar = a.a;
        PatchPlanAdData data = getPatchPlanAdResponse.data;
        Intrinsics.checkNotNullExpressionValue(data, "data");
        aVar.b(j, data);
        Function1<Boolean, Unit> remove = nonStandardAdApiImpl.detectTask.remove(Long.valueOf(j));
        if (remove != null) {
            PatchPlanAdData patchPlanAdData = getPatchPlanAdResponse.data;
            if (patchPlanAdData != null) {
                list = patchPlanAdData.items;
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            remove.invoke(Boolean.valueOf(!z));
        }
        return Unit.INSTANCE;
    }
}

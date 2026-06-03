package com.dragon.read.nonstandard.ad.api;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.pages.bullet.LynxCardView;
import com.dragon.read.rpc.model.GetPatchPlanAdResponse;
import com.dragon.read.rpc.model.PatchPlanAdData;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface NonStandardAdApi extends IService {
    public static final a Companion;
    public static final NonStandardAdApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(612490);
            a = new a();
        }

        private a() {
        }
    }

    boolean checkPauseAdInserted(String str, int i);

    void detectNonStandardAd(long j, Function1<? super Boolean, Unit> function1);

    PatchPlanAdData getAdData(long j);

    void getAdData(long j, Function2<? super PatchPlanAdData, ? super Boolean, Unit> function2);

    Observable<GetPatchPlanAdResponse> getPauseAdData(long j);

    LynxCardView getSeriesAttachedAdLynxView(Activity activity);

    void handleJumpSchema(String str, String str2, List<String> list, long j);

    void recordInsertPauseAd(String str, Function2<? super String, ? super Integer, Boolean> function2);

    void releaseDetectTask(long j);

    static {
        Covode.recordClassIndex(612489);
        Companion = a.a;
        Object service = ServiceManager.getService(NonStandardAdApi.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (NonStandardAdApi) service;
    }
}

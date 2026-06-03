package com.dragon.read.component.biz.impl;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import b33.p;
import b33.z;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsGotoFeedTabTipsInSeriesMall;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qs3.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoGotoFeedTabTipsInSeriesMallImpl implements BsGotoFeedTabTipsInSeriesMall {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588082);
    }

    public p getGotoFeedTabTipsVCInSeriesMall(LifecycleOwner parentLifecycle, Observable<Boolean> containerVisibilityObservable, Observable<d> exitFromShortSeriesObservable, Observable<Boolean> videoFlowTabSelectedObservable, Activity activity, Function0<z> videoFeedTabConfigCallback) {
        Intrinsics.checkNotNullParameter(parentLifecycle, "parentLifecycle");
        Intrinsics.checkNotNullParameter(containerVisibilityObservable, "containerVisibilityObservable");
        Intrinsics.checkNotNullParameter(exitFromShortSeriesObservable, "exitFromShortSeriesObservable");
        Intrinsics.checkNotNullParameter(videoFlowTabSelectedObservable, "videoFlowTabSelectedObservable");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(videoFeedTabConfigCallback, "videoFeedTabConfigCallback");
        return null;
    }

    public p createGotoFeedTabTipsVCInBookMall(LifecycleOwner parentLifecycle, Observable<Boolean> containerVisibilityObservable, Observable<d> exitFromShortSeriesObservable, Observable<Boolean> videoFlowTabSelectedObservable, Activity activity, Function0<z> videoFeedTabConfigCallback) {
        Intrinsics.checkNotNullParameter(parentLifecycle, "parentLifecycle");
        Intrinsics.checkNotNullParameter(containerVisibilityObservable, "containerVisibilityObservable");
        Intrinsics.checkNotNullParameter(exitFromShortSeriesObservable, "exitFromShortSeriesObservable");
        Intrinsics.checkNotNullParameter(videoFlowTabSelectedObservable, "videoFlowTabSelectedObservable");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(videoFeedTabConfigCallback, "videoFeedTabConfigCallback");
        return new p(parentLifecycle, containerVisibilityObservable, exitFromShortSeriesObservable, videoFlowTabSelectedObservable, activity, videoFeedTabConfigCallback);
    }
}

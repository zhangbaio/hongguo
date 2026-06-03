package com.dragon.read.component.biz.impl;

import android.content.Context;
import cn2.l;
import com.bytedance.covode.number.Covode;
import com.dragon.read.appwidget.AppWidgetProviderType;
import com.dragon.read.appwidget.multigenre.MultiGenreShortVideoAppWidget;
import com.dragon.read.appwidget.multigenre.h0;
import com.dragon.read.appwidget.multigenre.j4;
import com.dragon.read.appwidget.multigenre.x0;
import com.dragon.read.appwidget.spi.BsAppWidgetExtensionService;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pm2.a1;
import pm2.z0;
import wm2.k;
import wm2.m;
import wm2.n;
import wm2.o;
import wm2.p;
import wm2.q;
import y44.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongGuoDefaultAppWidgetServiceImpl implements BsAppWidgetExtensionService {
    public static final int $stable;
    private final k catchDramasGuide = new k();

    static {
        Covode.recordClassIndex(588071);
        $stable = 8;
    }

    public List<Pair<String, List<z0>>> extraIsolateProcessWidgets() {
        return CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to("multi_genre_short_video_recommend", CollectionsKt__CollectionsJVMKt.listOf(new MultiGenreShortVideoAppWidget(AppWidgetProviderType.ISOLATE_PROCESS))));
    }

    public List<a1> extraGuides() {
        List<a1> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a1[]{new p(), new n(), new m(), new o(), new q(), this.catchDramasGuide});
        return listOf;
    }

    public List<Pair<String, List<z0>>> extraRegisteredWidgets() {
        List listOf;
        List<Pair<String, List<z0>>> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MultiGenreShortVideoAppWidget[]{new MultiGenreShortVideoAppWidget(AppWidgetProviderType.DEFAULT), new MultiGenreShortVideoAppWidget(AppWidgetProviderType.VIVO), new MultiGenreShortVideoAppWidget(AppWidgetProviderType.ISOLATE_PROCESS)});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("short_video_recommend", CollectionsKt__CollectionsJVMKt.listOf(new l())), TuplesKt.to("multi_genre_audio_recommend", CollectionsKt__CollectionsJVMKt.listOf(new com.dragon.read.appwidget.multigenre.q())), TuplesKt.to("multi_genre_comic_recommend", CollectionsKt__CollectionsJVMKt.listOf(new h0())), TuplesKt.to("multi_genre_short_video_recommend", listOf), TuplesKt.to("multi_genre_movie_recommend", CollectionsKt__CollectionsJVMKt.listOf(new x0())), TuplesKt.to("multi_genre_teleplay_recommend", CollectionsKt__CollectionsJVMKt.listOf(new j4()))});
        return listOf2;
    }

    public boolean shouldShowGuideForCep(String str) {
        return BsAppWidgetExtensionService.b.a(this, str);
    }

    public a getWidgetPendant(String widgetName, Context context, SaasVideoDetailModel saasVideoDetailModel, Runnable hideAction) {
        Intrinsics.checkNotNullParameter(widgetName, "widgetName");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hideAction, "hideAction");
        if (!Intrinsics.areEqual(widgetName, "multi_genre_short_video_recommend")) {
            return null;
        }
        return this.catchDramasGuide.M(context, saasVideoDetailModel, hideAction);
    }
}

package fo4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoInnerNextItem;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsBookmallApi;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.util.kotlin.ContextKt;
import io4.g;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ym4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final Lazy b;
    public static final int c;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b() {
        return "RankingListCardClickHelper";
    }

    private final String d() {
        return (String) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609016);
        a = new e();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fo4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String b2;
                b2 = e.b();
                return b2;
            }
        });
        b = lazy;
        c = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c(io4.g r4, android.content.Context r5, ym4.k r6) {
        /*
            r3 = this;
            com.bytedance.kmp.reading.model.om0 r4 = r4.getVideoData()
            if (r4 == 0) goto L7d
            com.bytedance.kmp.reading.model.jm0 r4 = r4.R0
            if (r4 != 0) goto Lc
            goto L7d
        Lc:
            java.util.List r0 = r4.m
            r1 = 0
            if (r0 == 0) goto L22
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.bytedance.kmp.reading.model.pm0 r0 = (com.bytedance.kmp.reading.model.pm0) r0
            if (r0 == 0) goto L22
            java.lang.Long r0 = r0.a
            if (r0 == 0) goto L22
            java.lang.String r0 = r0.toString()
            goto L23
        L22:
            r0 = r1
        L23:
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r2 = new com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs
            r2.<init>()
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r5 = r2.setContext(r5)
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r5 = r5.setSeriesId(r0)
            if (r6 == 0) goto L36
            com.dragon.read.report.PageRecorder r1 = bd4.b.a(r6)
        L36:
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r5 = r5.setPageRecorder(r1)
            r6 = 105(0x69, float:1.47E-43)
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r5 = r5.setTraceFrom(r6)
            java.lang.String r6 = "playlist"
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r5 = r5.setFeedType(r6)
            java.lang.Long r4 = r4.a
            java.lang.String r6 = ""
            if (r4 == 0) goto L52
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L53
        L52:
            r4 = r6
        L53:
            r5.setAlbumId(r4)
            if (r0 != 0) goto L59
            r0 = r6
        L59:
            r5.setAlbumSeriesId(r0)
            com.dragon.read.rpc.model.VideoDetailSource r4 = com.dragon.read.rpc.model.VideoDetailSource.FromShortVideoTab
            int r6 = r4.getValue()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r5.setAlbumDetailSource(r6)
            int r4 = r4.getValue()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5.setSource(r4)
            com.dragon.read.NsCommonDepend r4 = com.dragon.read.NsCommonDepend.IMPL
            com.dragon.read.component.interfaces.NsAppNavigator r4 = r4.appNavigator()
            r4.openShortSeriesActivity(r5)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fo4.e.c(io4.g, android.content.Context, ym4.k):void");
    }

    public final void e(g model, int i, View view, Context context, k kVar) {
        PageRecorder pageRecorder;
        Serializable serializable;
        Intrinsics.checkNotNullParameter(model, "model");
        if (context == null) {
            context = ContextKt.getCurrentContext();
        }
        Context context2 = context;
        boolean z = false;
        LogWrapper.info(d(), "context = " + context2 + ",currentContext = " + ContextKt.getCurrentContext() + "， time = " + System.currentTimeMillis(), new Object[0]);
        VideoTabModel a2 = bd4.c.a.a(model.a);
        if (a2 == null) {
            LogWrapper.error(a.d(), "convertKmpToAndroidData error", new Object[0]);
            return;
        }
        if (model.b()) {
            c(model, context2, kVar);
            return;
        }
        VideoInnerNextItem videoInnerNextItem = model.c;
        if (videoInnerNextItem != null && videoInnerNextItem.getValue() == com.dragon.read.rpc.model.VideoInnerNextItem.NextVideo.getValue()) {
            z = true;
        }
        PageRecorder pageRecorder2 = null;
        if (z) {
            Object b2 = NsBookmallApi.IMPL.getSeriesBookMallKmpService().b(a2);
            if (b2 == null) {
                om0 videoData = model.getVideoData();
                if (videoData != null) {
                    b2 = videoData.p;
                } else {
                    b2 = null;
                }
            }
            Bundle bundle = new Bundle();
            if (b2 instanceof Serializable) {
                serializable = (Serializable) b2;
            } else {
                serializable = null;
            }
            bundle.putSerializable("key_first_data_provider", serializable);
            ShortSeriesLaunchArgs context3 = new ShortSeriesLaunchArgs().setContext(context2);
            if (kVar != null) {
                pageRecorder2 = bd4.b.a(kVar);
            }
            ShortSeriesApi.Companion.c().openShortSeriesActivity(context3.setPageRecorder(pageRecorder2).setTraceFrom(101).setInnerScene(12).setPlayerSubTag("MixedDistributionRecommendFeed").setExtraBundle(bundle));
            return;
        }
        ez2.c seriesBookMallKmpService = NsBookmallApi.IMPL.getSeriesBookMallKmpService();
        if (kVar != null) {
            pageRecorder = bd4.b.a(kVar);
        } else {
            pageRecorder = null;
        }
        seriesBookMallKmpService.a(context2, a2, i, view, pageRecorder);
    }
}

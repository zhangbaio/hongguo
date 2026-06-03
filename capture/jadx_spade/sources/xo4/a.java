package xo4;

import android.content.Context;
import android.os.Bundle;
import bd4.b;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.base.ssconfig.template.ShortSeriesTransitionConfig;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.component.interfaces.NsAppNavigator;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.model.ProfileType;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.rpc.model.VideoContentType;
import com.dragon.read.rpc.model.VideoDetailSource;
import com.dragon.read.util.kotlin.UIKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ym4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609144);
        a = new a();
    }

    private a() {
    }

    public final void a(String userId, int i) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        NsShortVideoApi.IMPL.notifyUserRelationChange(userId, i);
    }

    public final void d(om0 videoData, k kVar, Context context) {
        PageRecorder pageRecorder;
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        ShortSeriesLaunchArgs seriesId = new ShortSeriesLaunchArgs().setContext(context).setSeriesId(videoData.p);
        if (kVar != null) {
            pageRecorder = b.a(kVar);
        } else {
            pageRecorder = null;
        }
        NsCommonDepend.IMPL.appNavigator().openShortSeriesActivity(seriesId.setPageRecorder(pageRecorder).setTraceFrom(700));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002e A[Catch: Exception -> 0x0035, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:3:0x000a, B:5:0x0021, B:21:0x002e), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(com.bytedance.kmp.reading.model.om0 r7, ym4.k r8, android.content.Context r9) {
        /*
            r6 = this;
            java.lang.String r0 = "videoData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.dragon.read.kmp.utils.x r0 = com.dragon.read.kmp.utils.x.a
            r0 = 1
            r1 = 0
            com.dragon.read.kmp.utils.v r2 = com.dragon.read.kmp.utils.v.a     // Catch: java.lang.Exception -> L35
            gn6.a r2 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Exception -> L35
            r2.getSerializersModule()     // Catch: java.lang.Exception -> L35
            com.bytedance.kmp.reading.model.om0$b r3 = com.bytedance.kmp.reading.model.om0.Companion     // Catch: java.lang.Exception -> L35
            kotlinx.serialization.KSerializer r3 = r3.serializer()     // Catch: java.lang.Exception -> L35
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3     // Catch: java.lang.Exception -> L35
            java.lang.String r2 = r2.a(r3, r7)     // Catch: java.lang.Exception -> L35
            if (r2 == 0) goto L2a
            int r3 = r2.length()     // Catch: java.lang.Exception -> L35
            if (r3 != 0) goto L28
            goto L2a
        L28:
            r3 = 0
            goto L2b
        L2a:
            r3 = 1
        L2b:
            if (r3 == 0) goto L2e
            goto L5a
        L2e:
            java.lang.Class<com.dragon.read.rpc.model.VideoData> r3 = com.dragon.read.rpc.model.VideoData.class
            java.lang.Object r2 = com.dragon.read.base.util.JSONUtils.fromJson(r2, r3)     // Catch: java.lang.Exception -> L35
            goto L5b
        L35:
            r2 = move-exception
            com.dragon.read.kmp.utils.q r3 = com.dragon.read.kmp.utils.q.a
            boolean r3 = r3.a()
            if (r3 != 0) goto Laf
            com.dragon.read.kmp.j r3 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "convertKmpToAndroidData,error = "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "KmpDataConvertUtil"
            r3.d(r4, r2)
        L5a:
            r2 = r1
        L5b:
            com.dragon.read.rpc.model.VideoData r2 = (com.dragon.read.rpc.model.VideoData) r2
            com.dragon.read.pages.bookmall.model.VideoTabModel$VideoData r2 = com.dragon.read.pages.bookmall.model.VideoTabModel.VideoData.parseVideoData(r2)
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r3 = new com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs
            r3.<init>()
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r9 = r3.setContext(r9)
            java.lang.String r7 = r7.p
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r7 = r9.setSeriesId(r7)
            if (r8 == 0) goto L76
            com.dragon.read.report.PageRecorder r1 = bd4.b.a(r8)
        L76:
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r7 = r7.setPageRecorder(r1)
            r8 = 700(0x2bc, float:9.81E-43)
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r7 = r7.setTraceFrom(r8)
            java.lang.String r8 = "DoubleColumnFeed"
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r7 = r7.setPlayerSubTag(r8)
            com.dragon.base.ssconfig.template.ShortSeriesTransitionConfig$a r8 = com.dragon.base.ssconfig.template.ShortSeriesTransitionConfig.a
            boolean r8 = r8.b()
            if (r8 == 0) goto L9b
            com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs r8 = r7.setUseFadingTransition(r0)
            r9 = 8
            float r9 = com.dragon.read.util.kotlin.UIKt.getFloatDp(r9)
            r8.setAnimationDrawableRadius(r9)
        L9b:
            com.dragon.read.NsCommonDepend r8 = com.dragon.read.NsCommonDepend.IMPL
            com.dragon.read.component.interfaces.NsAppNavigator r9 = r8.appNavigator()
            r9.openShortSeriesActivity(r7)
            qo3.m0 r7 = r8.recordDataManager()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r7.r(r2)
            return
        Laf:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "convertKmpToAndroidData data:"
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = ", error:"
            r9.append(r7)
            r9.append(r2)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: xo4.a.g(com.bytedance.kmp.reading.model.om0, ym4.k, android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #1 {Exception -> 0x0036, blocks: (B:3:0x000b, B:5:0x0022, B:34:0x002f), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(com.bytedance.kmp.reading.model.om0 r8, ym4.k r9, android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xo4.a.f(com.bytedance.kmp.reading.model.om0, ym4.k, android.content.Context):void");
    }

    public final void b(String postId, String userId, Context context, k kVar) {
        PageRecorder pageRecorder;
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        NsAppNavigator appNavigator = NsCommonDepend.IMPL.appNavigator();
        if (kVar != null) {
            pageRecorder = b.a(kVar);
        } else {
            pageRecorder = null;
        }
        appNavigator.openPicTextDetail(context, pageRecorder, postId, userId);
    }

    public final void c(String seriesId, k kVar, Context context, List<om0> curDataList) {
        PageRecorder pageRecorder;
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(curDataList, "curDataList");
        wo4.a aVar = new wo4.a(curDataList);
        int M1 = aVar.M1(seriesId);
        ShortSeriesLaunchArgs seriesId2 = new ShortSeriesLaunchArgs().setContext(context).setSeriesId(seriesId);
        if (kVar != null) {
            pageRecorder = b.a(kVar);
        } else {
            pageRecorder = null;
        }
        ShortSeriesLaunchArgs innerScene = seriesId2.setPageRecorder(pageRecorder).setTraceFrom(204).setProfileType(ProfileType.SUBJECT_V2).setPlayerSubTag("History").setVideoForcePos(M1).setInnerScene(10);
        NsShortVideoApi.IMPL.setGusetPugcDataSource(aVar);
        ShortSeriesApi.Companion.c().openShortSeriesActivity(innerScene);
    }

    public final void e(String seriesId, String str, int i, k kVar, Context context) {
        PageRecorder pageRecorder;
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        ShortSeriesLaunchArgs seriesId2 = new ShortSeriesLaunchArgs().setContext(context).setSeriesId(seriesId);
        if (kVar != null) {
            pageRecorder = b.a(kVar);
        } else {
            pageRecorder = null;
        }
        ShortSeriesLaunchArgs playerSubTag = seriesId2.setPageRecorder(pageRecorder).setEnterFrom(1).setSource(String.valueOf(VideoDetailSource.FromPlayer.getValue())).setTraceFrom(204).setPlayerSubTag("History");
        if (str != null) {
            playerSubTag.setVidForce(str);
        }
        if (i == VideoContentType.Album.getValue()) {
            playerSubTag.setAlbumId(seriesId);
            VideoDetailSource videoDetailSource = VideoDetailSource.FromHistory;
            playerSubTag.setAlbumDetailSource(String.valueOf(videoDetailSource.getValue()));
            playerSubTag.setSource(String.valueOf(videoDetailSource.getValue()));
        } else if (i == VideoContentType.PUGC.getValue()) {
            playerSubTag.setInnerScene(3);
            playerSubTag.setFeedType("history_pugc_feed");
            playerSubTag.setTargetUgcId(seriesId);
            Bundle bundle = new Bundle();
            bundle.putInt("key_series_sub_inner_scene", 4);
            playerSubTag.setExtraBundle(bundle);
        }
        if (ShortSeriesTransitionConfig.a.b()) {
            playerSubTag.setUseFadingTransition(true).setAnimationDrawableRadius(UIKt.getFloatDp(12));
        } else {
            playerSubTag.setUseFadingTransition(false).setAnimationDrawableRadius(0.0f);
        }
        NsCommonDepend.IMPL.appNavigator().openShortSeriesActivity(playerSubTag);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x002f A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #0 {Exception -> 0x0036, blocks: (B:3:0x000b, B:5:0x0022, B:63:0x002f), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(com.bytedance.kmp.reading.model.om0 r11, ym4.k r12, com.bytedance.kmp.reading.model.a8 r13, android.content.Context r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xo4.a.h(com.bytedance.kmp.reading.model.om0, ym4.k, com.bytedance.kmp.reading.model.a8, android.content.Context, java.lang.String):void");
    }
}

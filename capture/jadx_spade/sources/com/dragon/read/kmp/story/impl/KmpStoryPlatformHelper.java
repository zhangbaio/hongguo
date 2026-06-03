package com.dragon.read.kmp.story.impl;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.r20;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.base.ssconfig.model.AuthorConfig;
import com.dragon.read.base.ssconfig.model.CommunityConfig;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryPlatformHelper {
    public static final KmpStoryPlatformHelper a;

    static {
        Covode.recordClassIndex(609196);
        a = new KmpStoryPlatformHelper();
    }

    private KmpStoryPlatformHelper() {
    }

    public final String h(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return url;
    }

    public final boolean a() {
        return il5.a.a.i();
    }

    public final boolean b() {
        return il5.a.a.k();
    }

    public final r20 e() {
        AuthorConfig b = CommunityConfig.a.b();
        return new r20(b.titleText, b.titleTextColorLight, b.titleTextColorDark, b.titleBgColorLight, b.titleBgColorDark, b.titleTextAlphaLight, b.titleTextAlphaDark, b.titleBgAlphaLight, b.titleBgAlphaDark, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, 65024, (DefaultConstructorMarker) null);
    }

    public final void f(String userId, Map<String, String> extra) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        PageRecorder parentPage = PageRecorderUtils.getParentPage(currentActivity);
        Intrinsics.checkNotNullExpressionValue(parentPage, "getParentPage(...)");
        NsCommonDepend.IMPL.appNavigator().openProfileView(currentActivity, parentPage, userId);
    }

    public final Object c(String str, float[] fArr, Continuation<? super float[]> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KmpStoryPlatformHelper$extractHslFromImage$2(str, CompletableDeferredKt.CompletableDeferred$default(null, 1, null), fArr, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(KmpStoryPlatformHelper kmpStoryPlatformHelper, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        kmpStoryPlatformHelper.f(str, map);
    }

    public static /* synthetic */ Object d(KmpStoryPlatformHelper kmpStoryPlatformHelper, String str, float[] fArr, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            fArr = new float[]{0.0f, 0.0f, 0.25f};
        }
        return kmpStoryPlatformHelper.c(str, fArr, continuation);
    }
}

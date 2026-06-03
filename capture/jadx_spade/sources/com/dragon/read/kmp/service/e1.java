package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import com.dragon.read.hybrid.WebUrlManager;
import com.dragon.read.report.PageRecorderUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e1 {
    public static final e1 a;

    static {
        Covode.recordClassIndex(608895);
        a = new e1();
    }

    private e1() {
    }

    public final String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return url;
    }

    public final String b(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return WebUrlManager.getInstance().getGuestProfileReportUrl(userId);
    }

    public final String c(String str, String userName) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        return WebUrlManager.getInstance().getTargetUserFansPageUrl(str, com.dragon.read.kmp.utils.f1.a.a(userName), PageRecorderUtils.getCurrentPageRecorder());
    }

    public final String d(String str, String userName) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        return WebUrlManager.getInstance().getTargetUserFollowPageUrl(str, com.dragon.read.kmp.utils.f1.a.a(userName), PageRecorderUtils.getCurrentPageRecorder());
    }
}

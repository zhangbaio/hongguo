package com.dragon.read.component.shortvideo.api;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.base.Args;
import com.dragon.read.report.PageRecorder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSOpenProfilePageService extends IService {
    public static final a Companion;
    public static final BSOpenProfilePageService IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598107);
            a = new a();
        }

        private a() {
        }
    }

    boolean enableClickAvatarOpenSeriesProfilePage(String str);

    void openSeriesProfilePage(Context context, PageRecorder pageRecorder, String str, Args args);

    static {
        Covode.recordClassIndex(598106);
        Companion = a.a;
        Object service = ServiceManager.getService(BSOpenProfilePageService.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (BSOpenProfilePageService) service;
    }
}

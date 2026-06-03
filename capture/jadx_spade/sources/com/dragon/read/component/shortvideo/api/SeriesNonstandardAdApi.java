package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.api.docker.provider.ProviderScene;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface SeriesNonstandardAdApi extends IService {
    public static final a Companion;
    public static final SeriesNonstandardAdApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598180);
            a = new a();
        }

        private a() {
        }
    }

    void clearPauseAdFrequency();

    void createShortVideoProviders(Map<Set<ProviderScene>, ? extends List<? extends br3.e<?>>> map);

    static {
        Covode.recordClassIndex(598179);
        Companion = a.a;
        Object service = ServiceManager.getService(SeriesNonstandardAdApi.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (SeriesNonstandardAdApi) service;
    }
}

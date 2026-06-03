package com.dragon.read.nonstandard.ad.adapter;

import br3.e;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.SeriesNonstandardAdApi;
import com.dragon.read.component.shortvideo.api.docker.provider.ProviderScene;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import qs4.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NonstandardAdApiImpl implements SeriesNonstandardAdApi {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(612453);
    }

    @Override // com.dragon.read.component.shortvideo.api.SeriesNonstandardAdApi
    public void clearPauseAdFrequency() {
        a.j.b();
    }

    @Override // com.dragon.read.component.shortvideo.api.SeriesNonstandardAdApi
    public void createShortVideoProviders(Map<Set<ProviderScene>, ? extends List<? extends e<?>>> allProviders) {
        Set<ProviderScene> of;
        List<? extends e<?>> list;
        Map<Set<ProviderScene>, ? extends List<? extends e<?>>> map;
        Set<ProviderScene> of2;
        List<? extends e<?>> list2;
        Intrinsics.checkNotNullParameter(allProviders, "allProviders");
        ProviderScene providerScene = ProviderScene.SHORT;
        ProviderScene providerScene2 = ProviderScene.PORTRAIT;
        of = SetsKt__SetsKt.setOf((Object[]) new ProviderScene[]{providerScene, providerScene2, ProviderScene.LANDSCAPE});
        List<? extends e<?>> list3 = allProviders.get(of);
        if (TypeIntrinsics.isMutableList(list3)) {
            list = list3;
        } else {
            list = null;
        }
        if (TypeIntrinsics.isMutableMap(allProviders)) {
            map = allProviders;
        } else {
            map = null;
        }
        if (map != null) {
            if (list == null) {
                map.put(of, CollectionsKt__CollectionsJVMKt.listOf(new g()));
            } else {
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                mutableList.add(new g());
                map.put(of, mutableList);
            }
        }
        of2 = SetsKt__SetsKt.setOf((Object[]) new ProviderScene[]{providerScene, providerScene2});
        List<? extends e<?>> list4 = allProviders.get(of2);
        if (TypeIntrinsics.isMutableList(list4)) {
            list2 = list4;
        } else {
            list2 = null;
        }
        if (!TypeIntrinsics.isMutableMap(allProviders)) {
            allProviders = null;
        }
        if (allProviders != null) {
            if (list2 == null) {
                allProviders.put(of2, CollectionsKt__CollectionsJVMKt.listOf(new a()));
                return;
            }
            List mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
            mutableList2.add(new a());
            allProviders.put(of2, mutableList2);
        }
    }
}

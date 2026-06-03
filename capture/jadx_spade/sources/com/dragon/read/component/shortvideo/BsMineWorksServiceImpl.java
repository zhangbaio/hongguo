package com.dragon.read.component.shortvideo;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.BsMineWorksServiceImpl;
import com.dragon.read.component.shortvideo.brickservice.BsMineWorksService;
import com.dragon.read.component.shortvideo.brickservice.a;
import com.dragon.read.component.shortvideo.impl.userworks.b;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x14.f0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BsMineWorksServiceImpl implements BsMineWorksService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(598098);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public void registerEventBus() {
        b.h();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public void clearCache() {
        f0.a.C();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public int getAndResetPreloadType() {
        return f0.a.Z();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public String getPreloadStrategy() {
        return f0.a.a0();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public boolean hasEnteredDynamicTabRecently() {
        return f0.a.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a tryGetPreloadDataAsync$lambda$0(f0.b preloadResult) {
        Intrinsics.checkNotNullParameter(preloadResult, "preloadResult");
        return new a(preloadResult.a, preloadResult.b);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public void tryPreload(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        f0.a.k0(from);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMineWorksService
    public Single<a> tryGetPreloadDataAsync(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Single h0 = f0.a.h0(from);
        final Function1 function1 = new Function1() { // from class: jq3.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                com.dragon.read.component.shortvideo.brickservice.a tryGetPreloadDataAsync$lambda$0;
                tryGetPreloadDataAsync$lambda$0 = BsMineWorksServiceImpl.tryGetPreloadDataAsync$lambda$0((f0.b) obj);
                return tryGetPreloadDataAsync$lambda$0;
            }
        };
        Single<a> map = h0.map(new Function() { // from class: jq3.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                com.dragon.read.component.shortvideo.brickservice.a tryGetPreloadDataAsync$lambda$1;
                tryGetPreloadDataAsync$lambda$1 = BsMineWorksServiceImpl.tryGetPreloadDataAsync$lambda$1(Function1.this, obj);
                return tryGetPreloadDataAsync$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a tryGetPreloadDataAsync$lambda$1(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (a) function1.invoke(p0);
    }
}

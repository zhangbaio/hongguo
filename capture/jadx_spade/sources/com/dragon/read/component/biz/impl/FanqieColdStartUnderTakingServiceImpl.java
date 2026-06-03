package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.component.biz.impl.brickservice.BsColdStartUnderTakingService;
import com.dragon.read.component.biz.impl.brickservice.ConsumerType;
import com.dragon.read.component.biz.model.AttributionType;
import com.dragon.read.polaris.cold.start.g;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FanqieColdStartUnderTakingServiceImpl implements BsColdStartUnderTakingService {
    public static final int $stable = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(588057);
            int[] iArr = new int[AttributionType.values().length];
            try {
                iArr[AttributionType.SINGLE_BOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttributionType.RED_PACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttributionType.SINGLE_SHORT_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AttributionType.SINGLE_LISTEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AttributionType.DEEP_LINK_LISTEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(588056);
    }

    public boolean canShowNewUserSignIn() {
        return true;
    }

    public boolean directToBookmallWhenSecondStart() {
        return false;
    }

    public boolean speciallyBanRedPackEvenIfNewUserSignInDone() {
        return false;
    }

    public boolean speciallyShowNewUserSignInBeforeRedPack() {
        return false;
    }

    public boolean speciallyQingjingjuShowRedPackInBookmall() {
        return Intrinsics.areEqual(g.a.i(), "v2");
    }

    private final void addTaskWhenRedPack() {
        g gVar = g.a;
        if (Intrinsics.areEqual(gVar.l(), "v1")) {
            gVar.b();
        }
    }

    private final void addTaskWhenSingleBook() {
        g gVar = g.a;
        if (Intrinsics.areEqual(gVar.i(), "v2")) {
            gVar.a();
        }
    }

    private final void addTaskWhenSingleListen() {
        g gVar = g.a;
        if (Intrinsics.areEqual(gVar.j(), "v3")) {
            gVar.a();
        }
    }

    private final void addTaskWhenSingleShortVideo() {
        g gVar = g.a;
        if (Intrinsics.areEqual(gVar.n(), "v2")) {
            gVar.b();
        }
    }

    private final void addTaskWhenDeepLinkListen() {
        g gVar = g.a;
        if (Intrinsics.areEqual(gVar.k(), "v1")) {
            gVar.a();
        }
        if (Intrinsics.areEqual(gVar.k(), "v2")) {
            gVar.b();
        }
    }

    public boolean enableRedPackInBookMall() {
        boolean isFirstStart = NsCommonDepend.IMPL.attributionManager().isFirstStart();
        if ((!isFirstStart && Intrinsics.areEqual(g.a.k(), "v2")) || (!isFirstStart && Intrinsics.areEqual(g.a.m(), "v2"))) {
            return true;
        }
        return false;
    }

    public boolean speciallyBanPreferenceWhenColdStartUndertaking() {
        g gVar = g.a;
        if (!Intrinsics.areEqual(gVar.i(), "v2") && !Intrinsics.areEqual(gVar.j(), "v2") && !Intrinsics.areEqual(gVar.j(), "v3")) {
            return false;
        }
        return true;
    }

    public boolean speciallyBanRedPackWhenExitConsumer() {
        g gVar = g.a;
        if (!Intrinsics.areEqual(gVar.n(), "v1") && !Intrinsics.areEqual(gVar.n(), "v2") && !Intrinsics.areEqual(gVar.m(), "v2") && !Intrinsics.areEqual(gVar.m(), "v3")) {
            return false;
        }
        return true;
    }

    public boolean speciallyBanLoginSuccessJsbInvoke() {
        g gVar = g.a;
        if (!Intrinsics.areEqual(gVar.l(), "v1") && !Intrinsics.areEqual(gVar.l(), "v2") && !Intrinsics.areEqual(gVar.l(), "v3") && !Intrinsics.areEqual(gVar.k(), "v1") && !Intrinsics.areEqual(gVar.k(), "v2") && !Intrinsics.areEqual(gVar.k(), "v3")) {
            return false;
        }
        return true;
    }

    public boolean banRedPackInBookMall() {
        if (NsCommonDepend.IMPL.attributionManager().isFirstStart()) {
            g gVar = g.a;
            if (!ArraysKt___ArraysKt.contains(new String[]{"v1", "v6", "v7"}, gVar.i()) && !Intrinsics.areEqual(gVar.l(), "v1") && !Intrinsics.areEqual(gVar.l(), "v2") && !Intrinsics.areEqual(gVar.n(), "v1") && !Intrinsics.areEqual(gVar.n(), "v2") && !Intrinsics.areEqual(gVar.m(), "v1") && !Intrinsics.areEqual(gVar.m(), "v2") && !Intrinsics.areEqual(gVar.m(), "v3") && !Intrinsics.areEqual(gVar.j(), "v1") && !Intrinsics.areEqual(gVar.j(), "v2") && !Intrinsics.areEqual(gVar.k(), "v2") && !Intrinsics.areEqual(gVar.k(), "v3")) {
                return false;
            }
        } else {
            g gVar2 = g.a;
            if (!ArraysKt___ArraysKt.contains(new String[]{"v1", "v2", "v6", "v7"}, gVar2.i()) && !Intrinsics.areEqual(gVar2.l(), "v2") && !Intrinsics.areEqual(gVar2.n(), "v1") && !Intrinsics.areEqual(gVar2.n(), "v2") && !Intrinsics.areEqual(gVar2.m(), "v1") && !Intrinsics.areEqual(gVar2.m(), "v3") && !Intrinsics.areEqual(gVar2.j(), "v1") && !Intrinsics.areEqual(gVar2.j(), "v2") && !Intrinsics.areEqual(gVar2.j(), "v3") && !Intrinsics.areEqual(gVar2.k(), "v1") && !Intrinsics.areEqual(gVar2.k(), "v3")) {
                return false;
            }
        }
        return true;
    }

    public void performTaskWhenColdStartUnderTaking(AttributionType attributeType) {
        Intrinsics.checkNotNullParameter(attributeType, "attributeType");
        int i = a.a[attributeType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            addTaskWhenDeepLinkListen();
                            return;
                        }
                        return;
                    }
                    addTaskWhenSingleListen();
                    return;
                }
                addTaskWhenSingleShortVideo();
                return;
            }
            addTaskWhenRedPack();
            return;
        }
        addTaskWhenSingleBook();
    }

    public void performTaskWhenExitConsumer(ConsumerType consumerType) {
        Intrinsics.checkNotNullParameter(consumerType, "consumerType");
        if (consumerType == ConsumerType.SHORT_VIDEO_PLAYER) {
            g gVar = g.a;
            if (Intrinsics.areEqual(gVar.m(), "v1")) {
                gVar.a();
            }
            if (Intrinsics.areEqual(gVar.m(), "v2")) {
                gVar.b();
            }
        }
    }
}

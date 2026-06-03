package com.xs.fm.player.base.component.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class FMPlayService$Companion$scheduleUpdateNotification$1$1 extends Lambda implements Function0<Unit> {
    public static final FMPlayService$Companion$scheduleUpdateNotification$1$1 INSTANCE = new FMPlayService$Companion$scheduleUpdateNotification$1$1();

    FMPlayService$Companion$scheduleUpdateNotification$1$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FMPlayService.m.s();
    }
}

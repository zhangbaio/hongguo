package kotlinx.io;

import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class SinksJvmKt$asByteChannel$isClosed$1 extends MutablePropertyReference0Impl {
    SinksJvmKt$asByteChannel$isClosed$1(Object obj) {
        super(obj, c.class, "closed", "getClosed()Z", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Boolean.valueOf(((c) this.receiver).b);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((c) this.receiver).b = ((Boolean) obj).booleanValue();
    }
}

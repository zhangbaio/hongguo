package kotlinx.io;

import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class SourcesJvmKt$asInputStream$isClosed$1 extends MutablePropertyReference0Impl {
    SourcesJvmKt$asInputStream$isClosed$1(Object obj) {
        super(obj, d.class, "closed", "getClosed()Z", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Boolean.valueOf(((d) this.receiver).b);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((d) this.receiver).b = ((Boolean) obj).booleanValue();
    }
}

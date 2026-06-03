package com.dragon.read.component.shortvideo.api.docker.viewmamanager;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final HandlerStyleType a;

    static {
        Covode.recordClassIndex(598700);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.a == ((b) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ShortSeriesTemplateStyle(type=" + this.a + ')';
    }

    public final HandlerStyleType getType() {
        return this.a;
    }

    public b(HandlerStyleType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
    }
}

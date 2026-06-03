package ht3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.docker.viewmamanager.HandlerStyleType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final boolean a;
    public final HandlerStyleType b;

    static {
        Covode.recordClassIndex(599218);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b;
    }

    public int hashCode() {
        int a = androidx.compose.animation.m.a(this.a) * 31;
        HandlerStyleType handlerStyleType = this.b;
        return a + (handlerStyleType == null ? 0 : handlerStyleType.hashCode());
    }

    public String toString() {
        return "PlayerImmersiveEvent(isEnterImmerse=" + this.a + ", style=" + this.b + ')';
    }

    public f(boolean z, HandlerStyleType handlerStyleType) {
        this.a = z;
        this.b = handlerStyleType;
    }
}

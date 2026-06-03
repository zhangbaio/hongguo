package yr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.scheduledstopplay.ScheduledStopPlayOptionType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public final ScheduledStopPlayOptionType a;
    public final String b;

    static {
        Covode.recordClassIndex(598852);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && Intrinsics.areEqual(this.b, jVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ScheduledStopPlayOptionData(type=" + this.a + ", desc=" + this.b + ')';
    }

    public final ScheduledStopPlayOptionType getType() {
        return this.a;
    }

    public j(ScheduledStopPlayOptionType type, String desc) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.a = type;
        this.b = desc;
    }
}

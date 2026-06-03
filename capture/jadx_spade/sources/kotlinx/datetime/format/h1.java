package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.StringFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h1 extends StringFieldFormatDirective<v> {
    private final Set<String> c;

    static {
        Covode.recordClassIndex(659515);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(Set<String> knownZones) {
        super(DateTimeComponentsKt.b(), knownZones);
        Intrinsics.checkNotNullParameter(knownZones, "knownZones");
        this.c = knownZones;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof h1) && Intrinsics.areEqual(((h1) obj).c, this.c)) {
            return true;
        }
        return false;
    }
}

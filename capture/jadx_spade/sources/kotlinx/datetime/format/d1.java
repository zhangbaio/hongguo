package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d1 extends NamedUnsignedIntFieldFormatDirective<g> {
    private final MonthNames d;

    static {
        Covode.recordClassIndex(659504);
    }

    public int hashCode() {
        return this.d.a.hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(MonthNames names) {
        super(DateFields.a.c(), names.a, "monthName");
        Intrinsics.checkNotNullParameter(names, "names");
        this.d = names;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d1) && Intrinsics.areEqual(this.d.a, ((d1) obj).d.a)) {
            return true;
        }
        return false;
    }
}

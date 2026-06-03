package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.api.model.PanelItemType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final PanelItemType a;
    public final String b;
    public final Args c;

    static {
        Covode.recordClassIndex(598780);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.a && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Args args = this.c;
        return hashCode2 + (args != null ? args.hashCode() : 0);
    }

    public String toString() {
        return "PanelItemClickInfo(type=" + this.a + ", content=" + this.b + ", extraArgs=" + this.c + ')';
    }

    public final PanelItemType getType() {
        return this.a;
    }

    public h(PanelItemType type, String str, Args args) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
        this.b = str;
        this.c = args;
    }

    public /* synthetic */ h(PanelItemType panelItemType, String str, Args args, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(panelItemType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : args);
    }
}

package ms4;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.pages.bookmall.model.ItemDataModel;
import com.dragon.read.rpc.model.ApiBookInfo;
import com.dragon.read.util.UiConfigSetter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ls4.f;
import ms4.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements com.dragon.read.multigenre.factory.a {
    public static final a d;
    public static final int e;
    private final UiConfigSetter a;
    private b b;
    private final Lazy c;

    public static final class a {
        static {
            Covode.recordClassIndex(612392);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        String a();
    }

    static {
        Covode.recordClassIndex(612391);
        d = new a(null);
        e = 8;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return g().a;
    }

    private final c g() {
        return (c) this.c.getValue();
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_SOLE_ICON, 125.0f, CoverExtendViewExclusiveZone.TOP_RIGHT);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return new f.b(new f.a(g().b, this.a));
    }

    @Override // com.dragon.read.multigenre.factory.a
    public View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ls4.f(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(ms4.g.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "depend"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r0, r0, r1, r0)
            r2.b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ms4.g.<init>(ms4.g$b):void");
    }

    private final c h(Object obj) {
        String str;
        boolean z;
        int hashCode;
        b bVar = this.b;
        String str2 = null;
        if (bVar != null) {
            str = bVar.a();
        } else if (obj instanceof ItemDataModel) {
            str = ((ItemDataModel) obj).getIconTag();
        } else if (obj instanceof ApiBookInfo) {
            str = ((ApiBookInfo) obj).iconTag;
        } else {
            str = null;
        }
        if (str != null && ((hashCode = str.hashCode()) == 92457424 ? str.equals("authorize_type") : hashCode == 94843483 ? str.equals("comic") : !(hashCode != 1686617758 || !str.equals("exclusive")))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str2 = str;
        }
        return new c(z, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c {
        public final boolean a;
        public final String b;

        static {
            Covode.recordClassIndex(612394);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && Intrinsics.areEqual(this.b, cVar.b);
        }

        public int hashCode() {
            int a = m.a(this.a) * 31;
            String str = this.b;
            return a + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SoleIconInfo(enable=" + this.a + ", iconTag=" + this.b + ')';
        }

        public c(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c i(g gVar, Object obj) {
        return gVar.h(obj);
    }

    public g(final Object obj, UiConfigSetter uiConfigSetter) {
        Lazy lazy;
        this.a = uiConfigSetter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ms4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g.c i;
                i = g.i(g.this, obj);
                return i;
            }
        });
        this.c = lazy;
    }

    public /* synthetic */ g(Object obj, UiConfigSetter uiConfigSetter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : uiConfigSetter);
    }
}

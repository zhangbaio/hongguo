package ds3;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final C0146b h;
    public final CharSequence a;
    public final long b;
    public final String c;
    public final e d;
    public final a e;
    public final d f;
    public c g;

    public interface a {
        void a();

        void b();
    }

    public interface c {
        void a(boolean z);
    }

    static {
        Covode.recordClassIndex(598887);
        h = new C0146b(null);
    }

    public /* synthetic */ b(CharSequence charSequence, long j, String str, e eVar, a aVar, d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, str, eVar, aVar, dVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e) && Intrinsics.areEqual(this.f, bVar.f);
    }

    public int hashCode() {
        CharSequence charSequence = this.a;
        int hashCode = (((charSequence == null ? 0 : charSequence.hashCode()) * 31) + j.a(this.b)) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        e eVar = this.d;
        int hashCode3 = (hashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31;
        a aVar = this.e;
        int hashCode4 = (hashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        d dVar = this.f;
        return hashCode4 + (dVar != null ? dVar.hashCode() : 0);
    }

    public String toString() {
        return "CommonTitleBarTipRequest(text=" + ((Object) this.a) + ", autoDismissDurationMs=" + this.b + ", frequencyKey=" + this.c + ", style=" + this.d + ", callback=" + this.e + ", dismissScene=" + this.f + ')';
    }

    public static final class d {
        private int a;

        static {
            Covode.recordClassIndex(598891);
        }

        public final d a() {
            this.a |= 31;
            return this;
        }

        public final d b() {
            this.a |= 28;
            return this;
        }

        public final boolean c(int i) {
            if ((i & this.a) != 0) {
                return true;
            }
            return false;
        }
    }

    public final void a(boolean z) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public static final class e {
        public final int a;
        public final int b;
        public final boolean c;

        static {
            Covode.recordClassIndex(598892);
        }

        public final void a(ViewGroup viewGroup, TextView textView) {
            if (viewGroup != null) {
                UIKt.updateMargin$default(viewGroup, (Integer) null, Integer.valueOf(this.a), (Integer) null, (Integer) null, 13, (Object) null);
            }
            if (textView != null) {
                UIKt.updateMargin$default(textView, (Integer) null, (Integer) null, Integer.valueOf(this.b), (Integer) null, 11, (Object) null);
            }
        }

        public e(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    private b(CharSequence charSequence, long j, String str, e eVar, a aVar, d dVar) {
        this.a = charSequence;
        this.b = j;
        this.c = str;
        this.d = eVar;
        this.e = aVar;
        this.f = dVar;
    }

    /* renamed from: ds3.b$b, reason: collision with other inner class name */
    public static final class C0146b {
        static {
            Covode.recordClassIndex(598889);
        }

        private C0146b() {
        }

        public /* synthetic */ C0146b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(CharSequence text, long j, String str, e eVar, a aVar, d dismissScene) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(dismissScene, "dismissScene");
            return new b(text, j, str, eVar, aVar, dismissScene, null);
        }

        public static /* synthetic */ b b(C0146b c0146b, CharSequence charSequence, long j, String str, e eVar, a aVar, d dVar, int i, Object obj) {
            long j2;
            String str2;
            e eVar2;
            d dVar2;
            if ((i & 2) != 0) {
                j2 = 5000;
            } else {
                j2 = j;
            }
            a aVar2 = null;
            if ((i & 4) != 0) {
                str2 = null;
            } else {
                str2 = str;
            }
            if ((i & 8) != 0) {
                eVar2 = null;
            } else {
                eVar2 = eVar;
            }
            if ((i & 16) == 0) {
                aVar2 = aVar;
            }
            if ((i & 32) != 0) {
                dVar2 = new d().b();
            } else {
                dVar2 = dVar;
            }
            return c0146b.a(charSequence, j2, str2, eVar2, aVar2, dVar2);
        }
    }
}

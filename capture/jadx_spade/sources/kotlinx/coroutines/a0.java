package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a0 extends AbstractCoroutineContextElement implements u1<String> {
    public static final a b;
    public final long a;

    public static final class a implements CoroutineContext.Key<a0> {
        static {
            Covode.recordClassIndex(658937);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658936);
        b = new a(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && this.a == ((a0) obj).a;
    }

    public int hashCode() {
        return j.a(this.a);
    }

    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }

    @Override // kotlinx.coroutines.u1
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public String u(CoroutineContext coroutineContext) {
        String str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            lastIndexOf$default = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + lastIndexOf$default + 10);
        String substring = name.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.a);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        currentThread.setName(sb2);
        return name;
    }

    @Override // kotlinx.coroutines.u1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void e(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }
}

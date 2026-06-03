package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<E> {
    static {
        Covode.recordClassIndex(659231);
    }

    public static <E> Object a(Object obj) {
        return obj;
    }

    public static final Object c(Object obj, E e) {
        if (obj == null) {
            return a(e);
        }
        if (obj instanceof ArrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return a(arrayList);
    }

    public static /* synthetic */ Object b(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }
}

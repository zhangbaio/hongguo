package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.a0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SignedFormatStructure<T> implements q<T> {
    public final n<T> a;
    public final boolean b;
    private final Set<l<T>> c;

    static {
        Covode.recordClassIndex(659618);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b);
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        return new bn6.g(this.a.b(), new SignedFormatStructure$formatter$1(this), this.b);
    }

    public String toString() {
        return "SignedFormatStructure(" + this.a + ')';
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new kotlinx.datetime.internal.format.parser.u[]{new kotlinx.datetime.internal.format.parser.u(CollectionsKt__CollectionsJVMKt.listOf(new a0(new Function2() { // from class: kotlinx.datetime.internal.format.v
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit f;
                f = SignedFormatStructure.f(SignedFormatStructure.this, obj, ((Boolean) obj2).booleanValue());
                return f;
            }
        }, this.b, "sign for " + this.c)), CollectionsKt__CollectionsKt.emptyList()), this.a.a()});
        return kotlinx.datetime.internal.format.parser.q.c(listOf);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SignedFormatStructure) {
            SignedFormatStructure signedFormatStructure = (SignedFormatStructure) obj;
            if (Intrinsics.areEqual(this.a, signedFormatStructure.a) && this.b == signedFormatStructure.b) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean e(SignedFormatStructure<? super T> signedFormatStructure, T t) {
        boolean z = false;
        for (l<? super T> lVar : ((SignedFormatStructure) signedFormatStructure).c) {
            if (Intrinsics.areEqual(lVar.isNegative().a(t), Boolean.TRUE)) {
                z = true;
            } else if (!lVar.a(t)) {
                return false;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SignedFormatStructure(n<? super T> format, boolean z) {
        List b;
        Set<l<T>> set;
        Intrinsics.checkNotNullParameter(format, "format");
        this.a = format;
        this.b = z;
        b = o.b(format);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            l sign = ((k) it2.next()).c().getSign();
            if (sign != null) {
                arrayList.add(sign);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        this.c = set;
        if (!set.isEmpty()) {
        } else {
            throw new IllegalArgumentException("Signed format must contain at least one field with a sign".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(SignedFormatStructure this$0, Object obj, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (l<T> lVar : this$0.c) {
            boolean areEqual = Intrinsics.areEqual(lVar.isNegative().a(obj), Boolean.TRUE);
            b<T, Boolean> isNegative = lVar.isNegative();
            if (z != areEqual) {
                z2 = true;
            } else {
                z2 = false;
            }
            isNegative.c(obj, Boolean.valueOf(z2));
        }
        return Unit.INSTANCE;
    }
}

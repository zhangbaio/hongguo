package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.j1;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m1 {
    private static final List<Character> a;

    static {
        List plus;
        List listOf;
        Covode.recordClassIndex(659564);
        plus = CollectionsKt___CollectionsKt.plus((Iterable) new kotlin.ranges.c('a', 'z'), (Iterable) new kotlin.ranges.c('A', 'Z'));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'[', ']', '\''});
        a = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(y alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void p(j1.b bVar) {
        throw new IllegalArgumentException("Unknown length " + bVar.a() + " for the " + bVar.b() + " directive");
    }

    public static final void i(y yVar, String pattern) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        j(yVar, j1.a.a(pattern));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(j1 format, y alternativeParsing) {
        Intrinsics.checkNotNullParameter(format, "$format");
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        j(alternativeParsing, ((j1.c) format).b);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void m(j1.b bVar, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("The directive '");
        sb.append(bVar);
        sb.append("' is locale-dependent, but locales are not supported in Kotlin");
        if (str != null) {
            str2 = ". " + str;
        } else {
            str2 = "";
        }
        sb.append(str2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void q(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("kotlinx.datetime formatting does not support the ");
        sb.append(str);
        sb.append(" field. ");
        if (str2 != null) {
            str3 = str2 + ' ';
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append("Please report your use case to https://github.com/Kotlin/kotlinx-datetime/issues");
        throw new UnsupportedOperationException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void s(j1.b bVar, int i) {
        throw new UnsupportedOperationException("Padding do " + i + " digits is not supported for the " + bVar.b() + " directive");
    }

    private static final void j(y yVar, final j1 j1Var) {
        if (j1Var instanceof j1.e) {
            yVar.q(((j1.e) j1Var).b);
            return;
        }
        if (j1Var instanceof j1.d) {
            Iterator<T> it2 = ((j1.d) j1Var).b.iterator();
            while (it2.hasNext()) {
                j(yVar, (j1) it2.next());
            }
            return;
        }
        if (j1Var instanceof j1.c) {
            z.a(yVar, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.k1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k;
                    k = m1.k((y) obj);
                    return k;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.l1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l;
                    l = m1.l(j1.this, (y) obj);
                    return l;
                }
            });
            return;
        }
        if (j1Var instanceof j1.b) {
            j1.b bVar = (j1.b) j1Var;
            if (bVar instanceof j1.b.c) {
                if (yVar instanceof y.d) {
                    ((j1.b.c) j1Var).c((y.d) yVar);
                    return;
                }
                throw new IllegalArgumentException(("A time-based directive " + j1Var + " was used in a format builder that doesn't support time components").toString());
            }
            if (bVar instanceof j1.b.a) {
                if (yVar instanceof y.a) {
                    ((j1.b.a) j1Var).c((y.a) yVar);
                    return;
                }
                throw new IllegalArgumentException(("A date-based directive " + j1Var + " was used in a format builder that doesn't support date components").toString());
            }
            if (bVar instanceof j1.b.d) {
                if (yVar instanceof y.c) {
                    ((j1.b.d) j1Var).c((y.c) yVar);
                    return;
                }
                throw new IllegalArgumentException(("A time-zone-based directive " + j1Var + " was used in a format builder that doesn't support time-zone components").toString());
            }
            if (bVar instanceof j1.b.AbstractC0219b) {
                if (yVar instanceof y.e) {
                    ((j1.b.AbstractC0219b) j1Var).c((y.e) yVar);
                    return;
                }
                throw new IllegalArgumentException(("A UTC-offset-based directive " + j1Var + " was used in a format builder that doesn't support UTC offset components").toString());
            }
            if (bVar instanceof n1) {
                throw new IllegalArgumentException("The meaning of the directive '" + j1Var + "' is unknown");
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j1 o(char c, int i) {
        if (c == 'G') {
            return new j1.b.a.f(i);
        }
        if (c == 'y') {
            return new j1.b.a.s(i);
        }
        if (c == 'Y') {
            return new j1.b.a.o(i);
        }
        if (c == 'u') {
            return new j1.b.a.r(i);
        }
        if (c == 'U') {
            return new j1.b.a.C0217a(i);
        }
        if (c == 'r') {
            return new j1.b.a.k(i);
        }
        if (c == 'Q') {
            return new j1.b.a.j(i);
        }
        if (c == 'q') {
            return new j1.b.a.n(i);
        }
        if (c == 'M') {
            return new j1.b.a.i(i);
        }
        if (c == 'L') {
            return new j1.b.a.m(i);
        }
        if (c == 'w') {
            return new j1.b.a.q(i);
        }
        if (c == 'W') {
            return new j1.b.a.p(i);
        }
        if (c == 'd') {
            return new j1.b.a.C0218b(i);
        }
        if (c == 'D') {
            return new j1.b.a.e(i);
        }
        if (c == 'F') {
            return new j1.b.a.d(i);
        }
        if (c == 'g') {
            return new j1.b.a.h(i);
        }
        if (c == 'E') {
            return new j1.b.a.c(i);
        }
        if (c == 'e') {
            return new j1.b.a.g(i);
        }
        if (c == 'c') {
            return new j1.b.a.l(i);
        }
        if (c == 'a') {
            return new j1.b.c.C0221b(i);
        }
        if (c == 'h') {
            return new j1.b.c.a(i);
        }
        if (c == 'H') {
            return new j1.b.c.C0222c(i);
        }
        if (c == 'm') {
            return new j1.b.c.d(i);
        }
        if (c == 's') {
            return new j1.b.c.e.a(i);
        }
        if (c == 'S') {
            return new j1.b.c.f.a(i);
        }
        if (c == 'A') {
            return new j1.b.c.f.C0223b(i);
        }
        if (c == 'n') {
            return new j1.b.c.f.d(i);
        }
        if (c == 'N') {
            return new j1.b.c.f.C0224c(i);
        }
        if (c == 'V') {
            return new j1.b.d.C0225b(i);
        }
        if (c == 'v') {
            return new j1.b.d.a(i);
        }
        if (c == 'z') {
            return new j1.b.d.c(i);
        }
        if (c == 'O') {
            return new j1.b.AbstractC0219b.a(i);
        }
        if (c == 'X') {
            return new j1.b.AbstractC0219b.C0220b(i);
        }
        if (c == 'x') {
            return new j1.b.AbstractC0219b.c(i);
        }
        if (c == 'Z') {
            return new j1.b.AbstractC0219b.d(i);
        }
        return new n1(c, i);
    }

    static /* synthetic */ Void n(j1.b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return m(bVar, str);
    }

    static /* synthetic */ Void r(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return q(str, str2);
    }
}

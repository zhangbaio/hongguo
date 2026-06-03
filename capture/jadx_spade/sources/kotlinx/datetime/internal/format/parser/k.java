package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k<Output> implements r<Output> {
    public final List<e<Output>> a;
    private final int b;
    private final boolean c;

    static {
        Covode.recordClassIndex(659648);
    }

    public String toString() {
        return h();
    }

    private final String h() {
        String str;
        List<e<Output>> list = this.a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            StringBuilder sb = new StringBuilder();
            Integer b = eVar.b();
            if (b == null) {
                str = "at least one digit";
            } else {
                str = b + " digits";
            }
            sb.append(str);
            sb.append(" for ");
            sb.append(eVar.b);
            arrayList.add(sb.toString());
        }
        if (this.c) {
            return "a number with at least " + this.b + " digits: " + arrayList;
        }
        return "a number with exactly " + this.b + " digits: " + arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Unexpected end of input: yet to parse " + this$0.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends e<? super Output>> consumers) {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        int i2;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(consumers, "consumers");
        this.a = consumers;
        Iterator it2 = consumers.iterator();
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (!it2.hasNext()) {
                break;
            }
            Integer b = ((e) it2.next()).b();
            if (b != null) {
                i4 = b.intValue();
            }
            i3 += i4;
        }
        this.b = i3;
        List<e<Output>> list = this.a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                if (((e) it4.next()).b() == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        this.c = z2;
        List<e<Output>> list2 = this.a;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                Integer b2 = ((e) it5.next()).b();
                if (b2 != null) {
                    i = b2.intValue();
                } else {
                    i = Integer.MAX_VALUE;
                }
                if (i > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z4 = false;
                    break;
                }
            }
        }
        z4 = true;
        if (z4) {
            List<e<Output>> list3 = this.a;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i2 = 0;
            } else {
                Iterator<T> it6 = list3.iterator();
                i2 = 0;
                while (it6.hasNext()) {
                    if (((e) it6.next()).b() == null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5 && (i2 = i2 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i2 <= 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (!z6) {
                List<e<Output>> list4 = this.a;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list4) {
                    if (((e) obj).b() == null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    arrayList2.add(((e) it7.next()).b);
                }
                throw new IllegalArgumentException(("At most one variable-length numeric field in a row is allowed, but got several: " + arrayList2 + ". Parsing is undefined: for example, with variable-length month number and variable-length day of month, '111' can be parsed as Jan 11th or Nov 1st.").toString());
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Ref$IntRef digitsInRow, k this$0) {
        Intrinsics.checkNotNullParameter(digitsInRow, "$digitsInRow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Only found " + digitsInRow.element + " digits in a row, but need to parse " + this$0.h();
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public Object a(Output output, CharSequence input, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.b + i > input.length()) {
            return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String f;
                    f = k.f(k.this);
                    return f;
                }
            });
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        while (ref$IntRef.element + i < input.length() && an6.f.b(input.charAt(ref$IntRef.element + i))) {
            ref$IntRef.element++;
        }
        if (ref$IntRef.element < this.b) {
            return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String g;
                    g = k.g(Ref$IntRef.this, this);
                    return g;
                }
            });
        }
        int size = this.a.size();
        final int i3 = 0;
        while (i3 < size) {
            Integer b = this.a.get(i3).b();
            if (b != null) {
                i2 = b.intValue();
            } else {
                i2 = (ref$IntRef.element - this.b) + 1;
            }
            int i4 = i2 + i;
            final g a = this.a.get(i3).a(output, input, i, i4);
            if (a != null) {
                final String obj = input.subSequence(i, i4).toString();
                return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String e;
                        e = k.e(obj, this, i3, a);
                        return e;
                    }
                });
            }
            i3++;
            i = i4;
        }
        return m.a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(String numberString, k this$0, int i, g gVar) {
        Intrinsics.checkNotNullParameter(numberString, "$numberString");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Can not interpret the string '" + numberString + "' as " + this$0.a.get(i).b + ": " + gVar.errorMessage();
    }
}

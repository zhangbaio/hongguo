package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class StringSetParserOperation<Output> implements r<Output> {
    private final kotlinx.datetime.internal.format.parser.a<Output, String> a;
    private final String b;
    private final a c;

    static {
        Covode.recordClassIndex(659662);
    }

    private static final void c(a aVar) {
        Iterator<Pair<String, a>> it2 = aVar.a.iterator();
        while (it2.hasNext()) {
            c(it2.next().component2());
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, a> pair : aVar.a) {
            String component1 = pair.component1();
            a component2 = pair.component2();
            if (!component2.b && component2.a.size() == 1) {
                Pair pair2 = (Pair) CollectionsKt___CollectionsKt.single((List) component2.a);
                String str = (String) pair2.component1();
                arrayList.add(TuplesKt.to(component1 + str, (a) pair2.component2()));
            } else {
                arrayList.add(TuplesKt.to(component1, component2));
            }
        }
        aVar.a.clear();
        aVar.a.addAll(CollectionsKt___CollectionsKt.sortedWith(arrayList, new b()));
    }

    private static final class a {
        public final List<Pair<String, a>> a;
        public boolean b;

        static {
            Covode.recordClassIndex(659663);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public a(List<Pair<String, a>> children, boolean z) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.a = children;
            this.b = z;
        }

        public /* synthetic */ a(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? false : z);
        }
    }

    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            return compareValues;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        r1.element += r4.length();
        r0 = r3;
     */
    @Override // kotlinx.datetime.internal.format.parser.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(Output r12, final java.lang.CharSequence r13, final int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.datetime.internal.format.parser.StringSetParserOperation$a r0 = r11.c
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            r1.element = r14
            r2 = 0
        Lf:
            int r3 = r1.element
            int r4 = r13.length()
            if (r3 > r4) goto L57
            boolean r3 = r0.b
            if (r3 == 0) goto L21
            int r2 = r1.element
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L21:
            java.util.List<kotlin.Pair<java.lang.String, kotlinx.datetime.internal.format.parser.StringSetParserOperation$a>> r0 = r0.a
            java.util.Iterator r0 = r0.iterator()
        L27:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L57
            java.lang.Object r3 = r0.next()
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r4 = r3.component1()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.component2()
            kotlinx.datetime.internal.format.parser.StringSetParserOperation$a r3 = (kotlinx.datetime.internal.format.parser.StringSetParserOperation.a) r3
            int r7 = r1.element
            r8 = 0
            r9 = 4
            r10 = 0
            r5 = r13
            r6 = r4
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r6, r7, r8, r9, r10)
            if (r5 == 0) goto L27
            int r0 = r1.element
            int r4 = r4.length()
            int r0 = r0 + r4
            r1.element = r0
            r0 = r3
            goto Lf
        L57:
            if (r2 == 0) goto L70
            kotlinx.datetime.internal.format.parser.a<Output, java.lang.String> r0 = r11.a
            int r1 = r2.intValue()
            java.lang.CharSequence r13 = r13.subSequence(r14, r1)
            java.lang.String r13 = r13.toString()
            int r1 = r2.intValue()
            java.lang.Object r12 = kotlinx.datetime.internal.format.parser.t.d(r0, r12, r13, r14, r1)
            goto L7b
        L70:
            kotlinx.datetime.internal.format.parser.m$a r12 = kotlinx.datetime.internal.format.parser.m.a
            kotlinx.datetime.internal.format.parser.b0 r0 = new kotlinx.datetime.internal.format.parser.b0
            r0.<init>()
            java.lang.Object r12 = r12.a(r14, r0)
        L7b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.format.parser.StringSetParserOperation.a(java.lang.Object, java.lang.CharSequence, int):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StringSetParserOperation(Collection<String> strings, kotlinx.datetime.internal.format.parser.a<? super Output, String> setter, String whatThisExpects) {
        boolean z;
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.a = setter;
        this.b = whatThisExpects;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        boolean z2 = false;
        int i = 3;
        this.c = new a(null, z2, i, 0 == true ? 1 : 0);
        for (String str : strings) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a aVar = this.c;
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    List<Pair<String, a>> list = aVar.a;
                    final String valueOf = String.valueOf(charAt);
                    int binarySearch = CollectionsKt__CollectionsKt.binarySearch(list, 0, list.size(), new Function1<Pair<? extends String, ? extends a>, Integer>() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$special$$inlined$binarySearchBy$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Integer invoke(Pair<? extends String, ? extends StringSetParserOperation.a> pair) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(pair.getFirst(), valueOf);
                            return Integer.valueOf(compareValues);
                        }
                    });
                    if (binarySearch < 0) {
                        a aVar2 = new a(objArr2 == true ? 1 : 0, z2, i, objArr == true ? 1 : 0);
                        aVar.a.add((-binarySearch) - 1, TuplesKt.to(String.valueOf(charAt), aVar2));
                        aVar = aVar2;
                    } else {
                        aVar = aVar.a.get(binarySearch).getSecond();
                    }
                }
                if (!aVar.b) {
                    aVar.b = true;
                } else {
                    throw new IllegalArgumentException(("The string '" + str + "' was passed several times").toString());
                }
            } else {
                throw new IllegalArgumentException(("Found an empty string in " + this.b).toString());
            }
        }
        c(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(StringSetParserOperation this$0, CharSequence input, int i, Ref$IntRef index) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(input, "$input");
        Intrinsics.checkNotNullParameter(index, "$index");
        return "Expected " + this$0.b + " but got " + input.subSequence(i, index.element).toString();
    }
}

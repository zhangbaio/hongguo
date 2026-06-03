package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.c;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n<Output extends c<Output>> {
    static {
        Covode.recordClassIndex(659653);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Output extends c<Output>> u<Output> a(u<? super Output> commands) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        return commands;
    }

    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((l) t2).a), Integer.valueOf(((l) t).a));
            return compareValues;
        }
    }

    private static final class a<Output> {
        public final Output a;
        public final u<Output> b;
        public final int c;

        static {
            Covode.recordClassIndex(659654);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Output output, u<? super Output> parserStructure, int i) {
            Intrinsics.checkNotNullParameter(parserStructure, "parserStructure");
            this.a = output;
            this.b = parserStructure;
            this.c = i;
        }
    }

    public static final Output b(u<? super Output> uVar, CharSequence input, Output initialContainer, int i) {
        List mutableListOf;
        Object removeLastOrNull;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        ArrayList arrayList = new ArrayList();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new a(initialContainer, uVar, i));
        while (true) {
            removeLastOrNull = CollectionsKt__MutableCollectionsKt.removeLastOrNull(mutableListOf);
            a aVar = (a) removeLastOrNull;
            if (aVar == null) {
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new b());
                }
                throw new ParseException(arrayList);
            }
            Output output = (Output) ((c) aVar.a).copy();
            int i2 = aVar.c;
            u<Output> uVar2 = aVar.b;
            int size = uVar2.a.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    Object a2 = ((r) uVar2.a.get(i3)).a(output, input, i2);
                    if (a2 instanceof Integer) {
                        i2 = ((Number) a2).intValue();
                        i3++;
                    } else if (a2 instanceof l) {
                        arrayList.add((l) a2);
                    } else {
                        throw new IllegalStateException(("Unexpected parse result: " + a2).toString());
                    }
                } else if (uVar2.b.isEmpty()) {
                    if (i2 == input.length()) {
                        return output;
                    }
                    arrayList.add(new l(i2, o.a));
                } else {
                    int size2 = uVar2.b.size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i4 = size2 - 1;
                            mutableListOf.add(new a(output, (u) uVar2.b.get(size2), i2));
                            if (i4 < 0) {
                                break;
                            }
                            size2 = i4;
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ c c(u uVar, CharSequence charSequence, c cVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return b(uVar, charSequence, cVar, i);
    }
}

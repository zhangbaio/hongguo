package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v {
    public static final v a;
    private static final boolean b;
    public static final MainCoroutineDispatcher c;

    private v() {
    }

    static {
        Covode.recordClassIndex(659249);
        v vVar = new v();
        a = vVar;
        b = g0.f("kotlinx.coroutines.fast.service.loader", true);
        c = vVar.a();
    }

    private final MainCoroutineDispatcher a() {
        Sequence asSequence;
        List<u> list;
        Object next;
        MainCoroutineDispatcher e;
        try {
            if (b) {
                list = l.a.c();
            } else {
                asSequence = SequencesKt__SequencesKt.asSequence(ServiceLoader.load(u.class, u.class.getClassLoader()).iterator());
                list = SequencesKt___SequencesKt.toList(asSequence);
            }
            Iterator<T> it2 = list.iterator();
            if (!it2.hasNext()) {
                next = null;
            } else {
                next = it2.next();
                if (it2.hasNext()) {
                    int b2 = ((u) next).b();
                    do {
                        Object next2 = it2.next();
                        int b3 = ((u) next2).b();
                        if (b2 < b3) {
                            next = next2;
                            b2 = b3;
                        }
                    } while (it2.hasNext());
                }
            }
            u uVar = (u) next;
            if (uVar == null || (e = w.e(uVar, list)) == null) {
                return w.b(null, null, 3, null);
            }
            return e;
        } catch (Throwable th) {
            return w.b(th, null, 2, null);
        }
    }
}

package pl6;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static final List<b> a;
    private static WeakReference<TTNetworkStateCallback> b;
    public static final c c;

    public interface b {
        void a(int i, int i2);
    }

    private c() {
    }

    static {
        Covode.recordClassIndex(655963);
        c = new c();
        a = Collections.synchronizedList(new ArrayList());
        b = new WeakReference<>(a.a);
        TTNetWorkListener.getInstance().startListen(b);
    }

    public static final /* synthetic */ List a(c cVar) {
        return a;
    }

    public final void c(b bVar) {
        List<b> listeners = a;
        Intrinsics.checkExpressionValueIsNotNull(listeners, "listeners");
        synchronized (listeners) {
            listeners.remove(bVar);
        }
    }

    public final void b(b bVar) {
        List<b> listeners = a;
        Intrinsics.checkExpressionValueIsNotNull(listeners, "listeners");
        synchronized (listeners) {
            if (!listeners.contains(bVar)) {
                listeners.add(bVar);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static final class a implements TTNetworkStateCallback {
        public static final a a = new a();

        a() {
        }

        @Override // com.ss.ttvideoengine.TTNetworkStateCallback
        public final void onAccessChanged(int i, int i2, int i3) {
            if (i == 0) {
                c cVar = c.c;
                List listeners = c.a(cVar);
                Intrinsics.checkExpressionValueIsNotNull(listeners, "listeners");
                synchronized (listeners) {
                    int size = c.a(cVar).size();
                    for (int i4 = 0; i4 < size; i4++) {
                        List listeners2 = c.a(c.c);
                        Intrinsics.checkExpressionValueIsNotNull(listeners2, "listeners");
                        b bVar = (b) CollectionsKt___CollectionsKt.getOrNull(listeners2, i4);
                        if (bVar != null) {
                            bVar.a(i2, i3);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}

package pm4;

import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.dispatcher.IReceiver;
import com.dragon.reader.lib.model.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements e {
    public static final int c;
    private final ReaderClient a;
    private final List<f> b;

    static {
        Covode.recordClassIndex(608509);
        c = 8;
    }

    public static final class a extends jx5.d {
        a() {
        }

        public void a(int i) {
            Iterator it2 = d.this.b.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).a(i);
            }
        }
    }

    @Override // pm4.e
    public void a(f configChangedListener) {
        Intrinsics.checkNotNullParameter(configChangedListener, "configChangedListener");
        this.b.add(configChangedListener);
    }

    public d(ReaderClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.a = client;
        this.b = new ArrayList();
        client.getConfigObservable().o0(new a());
        client.getRawDataObservable().register(m45.a.class, new IReceiver() { // from class: pm4.b
            public final void onReceive(Object obj) {
                d.d(d.this, (m45.a) obj);
            }
        });
        client.getRawDataObservable().register(f0.class, new IReceiver() { // from class: pm4.c
            public final void onReceive(Object obj) {
                d.e(d.this, (f0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d dVar, m45.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Iterator<T> it2 = dVar.b.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).b(args.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d dVar, f0 args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Iterator<T> it2 = dVar.b.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).c(args.a);
        }
    }
}

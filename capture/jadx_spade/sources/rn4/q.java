package rn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uh1.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class q implements uh1.a {
    public static final int f;
    public un4.a a;
    public uh1.e b;
    public List<bh1.a> c;
    public Function3<? super bh1.a, Object, ? super String, Unit> d;
    public wn4.k e;

    static {
        Covode.recordClassIndex(608911);
        f = 8;
    }

    public void b(List<bh1.a> list, Object obj, Object obj2) {
        a.a.a(this, list, obj, obj2);
    }

    public void a(bh1.b params, uh1.e datasource, List<bh1.a> channels, final a.b listener) {
        un4.a aVar;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(datasource, "datasource");
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (params instanceof un4.a) {
            aVar = (un4.a) params;
        } else {
            aVar = null;
        }
        this.a = aVar;
        this.b = datasource;
        this.c = channels;
        this.d = new Function3() { // from class: rn4.p
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit e;
                e = q.e(q.this, listener, (bh1.a) obj, obj2, (String) obj3);
                return e;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(q qVar, a.b bVar, bh1.a channel, Object obj, String str) {
        yn4.b bVar2;
        Intrinsics.checkNotNullParameter(channel, "channel");
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        un4.a aVar = qVar.a;
        if (aVar != null) {
            bVar2 = aVar.h;
        } else {
            bVar2 = null;
        }
        cVar.h(bVar2, channel.a, str);
        bVar.a(channel, obj);
        return Unit.INSTANCE;
    }
}

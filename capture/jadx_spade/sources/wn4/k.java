package wn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k implements b {
    public static final int c;
    private final b a;
    private final un4.a b;

    static {
        Covode.recordClassIndex(608951);
        c = 8;
    }

    @Override // wn4.b
    public void init(Function1<? super String, Unit> onClose) {
        Intrinsics.checkNotNullParameter(onClose, "onClose");
    }

    @Override // wn4.b
    public void show() {
        yn4.b bVar;
        b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.show();
        }
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        un4.a aVar = this.b;
        if (aVar != null) {
            bVar = aVar.h;
        } else {
            bVar = null;
        }
        cVar.j(bVar);
    }

    @Override // wn4.b
    public void dismiss(String closeReason) {
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        b bVar = this.a;
        if (bVar != null) {
            bVar.dismiss(closeReason);
        }
    }

    public k(b bVar, un4.a aVar) {
        this.a = bVar;
        this.b = aVar;
        if (bVar != null) {
            bVar.init(new Function1() { // from class: wn4.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b;
                    b = k.b(k.this, (String) obj);
                    return b;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(k kVar, String closeReason) {
        yn4.b bVar;
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        un4.a aVar = kVar.b;
        if (aVar != null) {
            bVar = aVar.h;
        } else {
            bVar = null;
        }
        cVar.i(bVar, closeReason);
        return Unit.INSTANCE;
    }

    @Override // wn4.b
    public void C(String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        yn4.b bVar;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.C(title, shareChannelList, onClickListener);
        }
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        un4.a aVar = this.b;
        if (aVar != null) {
            bVar = aVar.h;
        } else {
            bVar = null;
        }
        cVar.j(bVar);
    }
}

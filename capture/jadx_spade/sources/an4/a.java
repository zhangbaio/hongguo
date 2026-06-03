package an4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.ApiBookInfo;
import readersaas.com.dragon.read.saas.rpc.model.PubPayType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int g;
    public final ApiBookInfo a;
    public String b;
    public String c;
    public Boolean d;
    public String e;
    public Integer f;

    static {
        Covode.recordClassIndex(608714);
        g = 8;
    }

    public a(ApiBookInfo delegate) {
        Integer num;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.a = delegate;
        this.b = delegate.bookId;
        this.c = delegate.novelTextType;
        this.d = Boolean.valueOf(delegate.isPubPay);
        this.e = delegate.opTag;
        PubPayType pubPayType = delegate.payType;
        if (pubPayType != null) {
            num = Integer.valueOf(pubPayType.getValue());
        } else {
            num = null;
        }
        this.f = num;
    }
}

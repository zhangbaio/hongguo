package ws4;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.m;
import com.bytedance.rpc.serialize.SerializeType;
import com.dragon.read.origin.rpc.model.DropUserVideoRequest;
import com.dragon.read.origin.rpc.model.DropUserVideoResponse;
import io.reactivex.Observable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a {

    /* renamed from: ws4.a$a, reason: collision with other inner class name */
    private interface InterfaceC0290a {
        @RpcOperation("$GET /app/book/video/delete/v1/")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        Observable<DropUserVideoResponse> a(DropUserVideoRequest dropUserVideoRequest);
    }

    static {
        Covode.recordClassIndex(613577);
    }

    private static InterfaceC0290a b() {
        return (InterfaceC0290a) m.f(InterfaceC0290a.class);
    }

    public static Observable<DropUserVideoResponse> a(DropUserVideoRequest dropUserVideoRequest) {
        return b().a(dropUserVideoRequest);
    }
}

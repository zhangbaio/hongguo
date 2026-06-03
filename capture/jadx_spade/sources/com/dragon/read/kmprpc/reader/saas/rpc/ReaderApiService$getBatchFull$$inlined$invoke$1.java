package com.dragon.read.kmprpc.reader.saas.rpc;

import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.bytedance.multi.rpc.core.proxy.ProxyInvoker$_transport$1", f = "ProxyInvoker.kt", i = {}, l = {156, 160, 164}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderApiService$getBatchFull$$inlined$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ zn0.g $config;
    final /* synthetic */ Ref$ObjectRef $iHttpResponse;
    final /* synthetic */ com.bytedance.multi.rpc.core.proxy.c $req;
    Object L$0;
    int label;
    final /* synthetic */ com.bytedance.multi.rpc.core.proxy.a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderApiService$getBatchFull$$inlined$invoke$1(Ref$ObjectRef ref$ObjectRef, com.bytedance.multi.rpc.core.proxy.c cVar, com.bytedance.multi.rpc.core.proxy.a aVar, zn0.g gVar, Continuation continuation) {
        super(2, continuation);
        this.$iHttpResponse = ref$ObjectRef;
        this.$req = cVar;
        this.this$0 = aVar;
        this.$config = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderApiService$getBatchFull$$inlined$invoke$1(this.$iHttpResponse, this.$req, this.this$0, this.$config, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReaderApiService$getBatchFull$$inlined$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        T t;
        iu0.c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        cVar = (iu0.c) obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    cVar = (iu0.c) obj;
                }
            } else {
                ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (iu0.c) obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef = this.$iHttpResponse;
            int i2 = h.a[this.$req.b.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            t = 0;
                            ref$ObjectRef.element = t;
                            return Unit.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    iu0.b bVar = this.this$0.b.a.c;
                    com.bytedance.multi.rpc.core.proxy.c cVar2 = this.$req;
                    String str = cVar2.a;
                    Map map = cVar2.d;
                    Map map2 = cVar2.e;
                    Object obj2 = cVar2.f;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    zn0.g gVar = this.$config;
                    this.L$0 = ref$ObjectRef;
                    this.label = 3;
                    Object b = bVar.b(str, map, map2, (Map) obj2, gVar, this);
                    if (b == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$ObjectRef2 = ref$ObjectRef;
                    obj = b;
                    cVar = (iu0.c) obj;
                } else {
                    iu0.b bVar2 = this.this$0.b.a.c;
                    com.bytedance.multi.rpc.core.proxy.c cVar3 = this.$req;
                    String str2 = cVar3.a;
                    Map map3 = cVar3.d;
                    Map map4 = cVar3.e;
                    Object obj3 = cVar3.f;
                    zn0.g gVar2 = this.$config;
                    this.L$0 = ref$ObjectRef;
                    this.label = 2;
                    Object a = bVar2.a(str2, map3, map4, obj3, gVar2, this);
                    if (a == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$ObjectRef2 = ref$ObjectRef;
                    obj = a;
                    cVar = (iu0.c) obj;
                }
            } else {
                iu0.b bVar3 = this.this$0.b.a.c;
                com.bytedance.multi.rpc.core.proxy.c cVar4 = this.$req;
                String str3 = cVar4.a;
                Map map5 = cVar4.d;
                Map map6 = cVar4.e;
                zn0.g gVar3 = this.$config;
                this.L$0 = ref$ObjectRef;
                this.label = 1;
                Object c = bVar3.c(str3, map5, map6, gVar3, this);
                if (c == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef2 = ref$ObjectRef;
                obj = c;
                cVar = (iu0.c) obj;
            }
        }
        Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef2;
        t = cVar;
        ref$ObjectRef = ref$ObjectRef3;
        ref$ObjectRef.element = t;
        return Unit.INSTANCE;
    }
}

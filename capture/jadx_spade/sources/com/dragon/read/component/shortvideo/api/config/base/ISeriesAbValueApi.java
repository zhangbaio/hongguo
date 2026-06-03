package com.dragon.read.component.shortvideo.api.config.base;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface ISeriesAbValueApi extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598306);
        Companion = a.a;
    }

    <T> T getABValue2(String str, T t, boolean z);

    public static final class a {
        static final /* synthetic */ a a;
        private static final Lazy<ISeriesAbValueApi> b;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ISeriesAbValueApi b() {
            return (ISeriesAbValueApi) ServiceManager.getService(ISeriesAbValueApi.class);
        }

        public final ISeriesAbValueApi c() {
            ISeriesAbValueApi value = b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return value;
        }

        static {
            Lazy<ISeriesAbValueApi> lazy;
            Covode.recordClassIndex(598307);
            a = new a();
            lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: qq3.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ISeriesAbValueApi b2;
                    b2 = ISeriesAbValueApi.a.b();
                    return b2;
                }
            });
            b = lazy;
        }
    }

    /* renamed from: com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a aVar = ISeriesAbValueApi.Companion;
        }

        public static /* synthetic */ Object getABValue2$default(ISeriesAbValueApi iSeriesAbValueApi, String str, Object obj, boolean z, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    z = true;
                }
                return iSeriesAbValueApi.getABValue2(str, obj, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getABValue2");
        }
    }
}

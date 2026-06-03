package com.weekend.recorder.api;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import dk6.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AutoRecorderProxy implements IAutoRecorder {
    private static final Lazy a;
    public static final AutoRecorderProxy b;

    private AutoRecorderProxy() {
    }

    private final IAutoRecorder a() {
        return (IAutoRecorder) a.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(655229);
        b = new AutoRecorderProxy();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IAutoRecorder>() { // from class: com.weekend.recorder.api.AutoRecorderProxy$recorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAutoRecorder invoke() {
                try {
                    Object newInstance = a.q("com.weekend.recorder.RecorderWrapper").newInstance();
                    if (newInstance != null) {
                        return (IAutoRecorder) newInstance;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.weekend.recorder.api.IAutoRecorder");
                } catch (Exception unused) {
                    return null;
                }
            }
        });
        a = lazy;
    }

    @Override // com.weekend.recorder.api.IAutoRecorder
    public boolean getWeekEndRecorderSwitch(Context context) {
        IAutoRecorder a2 = a();
        if (a2 != null && a2.getWeekEndRecorderSwitch(context)) {
            return true;
        }
        return false;
    }

    @Override // com.weekend.recorder.api.IAutoRecorder
    public void switchEnable(Context context, boolean z) {
        IAutoRecorder a2 = a();
        if (a2 != null) {
            a2.switchEnable(context, z);
        }
    }

    @Override // com.weekend.recorder.api.IAutoRecorder
    public void init(String str, String str2, b bVar, dk6.a aVar) {
        IAutoRecorder a2 = a();
        if (a2 != null) {
            a2.init(str, str2, bVar, aVar);
        }
    }
}

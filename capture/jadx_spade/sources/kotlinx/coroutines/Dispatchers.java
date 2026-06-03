package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Dispatchers {
    private static final CoroutineDispatcher Default;
    public static final Dispatchers INSTANCE;
    private static final CoroutineDispatcher IO;
    private static final CoroutineDispatcher Unconfined;

    private Dispatchers() {
    }

    public static /* synthetic */ void getDefault$annotations() {
    }

    public static /* synthetic */ void getIO$annotations() {
    }

    public static /* synthetic */ void getMain$annotations() {
    }

    public static /* synthetic */ void getUnconfined$annotations() {
    }

    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    public static final CoroutineDispatcher getIO() {
        return IO;
    }

    public static final MainCoroutineDispatcher getMain() {
        return kotlinx.coroutines.internal.v.c;
    }

    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    public final void shutdown() {
        c0.g.shutdown();
        kotlinx.coroutines.scheduling.b.f.z();
    }

    static {
        Covode.recordClassIndex(658962);
        INSTANCE = new Dispatchers();
        Default = kotlinx.coroutines.scheduling.b.f;
        Unconfined = c2.a;
        IO = kotlinx.coroutines.scheduling.a.a;
    }
}

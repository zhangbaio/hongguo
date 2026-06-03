package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.ss.android.ugc.bytex.taskmonitor.proxy.SingleDelegate;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v implements p {
    public static final int b;
    private final p a;

    static {
        Covode.recordClassIndex(598929);
        b = 8;
    }

    public void c(SaasVideoData saasVideoData, PreloaderVideoModelItem preloaderVideoModelItem) {
        throw null;
    }

    public v(p realFactory) {
        Intrinsics.checkNotNullParameter(realFactory, "realFactory");
        this.a = realFactory;
    }

    @Override // is3.p
    public Single<PreloaderVideoModelItem> a(final SaasVideoData videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Single<PreloaderVideoModelItem> create = SingleDelegate.create(new SingleOnSubscribe() { // from class: is3.u
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                v.d(v.this, videoData, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(v vVar, SaasVideoData saasVideoData, SingleEmitter it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        PreloaderVideoModelItem blockingGet = vVar.a.a(saasVideoData).blockingGet();
        Intrinsics.checkNotNull(blockingGet);
        vVar.c(saasVideoData, blockingGet);
        it2.onSuccess(blockingGet);
    }
}

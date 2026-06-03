package us4;

import com.bytedance.covode.number.Covode;
import com.ss.android.videoshop.api.IVideoContext;
import com.ss.android.videoshop.api.IVideoPlayListener;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.command.IVideoLayerCommand;
import com.ss.android.videoshop.entity.PlayEntity;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f extends IVideoPlayListener.Stub {
    public static final int d;
    private final String a;
    private final String b;
    private final Function0<Pair<String, String>> c;

    static {
        Covode.recordClassIndex(612512);
        d = 8;
    }

    public f() {
        this(null, null, null, 7, null);
    }

    public void A(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void B(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, boolean z) {
    }

    public void C(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String str, boolean z, boolean z2) {
    }

    public void D(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void E(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void F(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void G(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, VideoEngineInfos videoEngineInfos) {
    }

    public void H(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void I(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void J(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void K(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void L(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void M(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void N(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void O(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public void P(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
    }

    public void Q(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void R(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void S(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, int i) {
    }

    public void a(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String str) {
    }

    public void c(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void d(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void e(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void f(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void g(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void h(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void i(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Error error) {
    }

    public boolean j(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoLayerCommand iVideoLayerCommand) {
        return false;
    }

    public void k(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String str) {
    }

    public void l(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String str, Error error) {
    }

    public void m(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public void n(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void o(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, Map<Object, Object> map) {
    }

    public void p(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2, boolean z3) {
    }

    public boolean q(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2) {
        return false;
    }

    public void r(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void s(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void t(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoContext iVideoContext, boolean z, int i, boolean z2, boolean z3) {
    }

    public void u(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void v(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
    }

    public void w(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void x(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void y(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void z(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public final void onBufferEnd(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            d(videoStateInquirer, playEntity);
        }
    }

    public final void onBufferStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            e(videoStateInquirer, playEntity);
        }
    }

    public final void onEngineInitPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            g(videoStateInquirer, playEntity);
        }
    }

    public final void onFirstPlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            n(videoStateInquirer, playEntity);
        }
    }

    public final void onPreRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            u(videoStateInquirer, playEntity);
        }
    }

    public final void onPrepare(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            w(videoStateInquirer, playEntity);
        }
    }

    public final void onPrepared(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            x(videoStateInquirer, playEntity);
        }
    }

    public final void onRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            A(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            F(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoPause(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            H(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            I(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoPreCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            J(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoPreRelease(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            K(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoReleased(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            L(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoReplay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            M(videoStateInquirer, playEntity);
        }
    }

    public final void onVideoRetry(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            N(videoStateInquirer, playEntity);
        }
    }

    private final boolean T(String str, String str2) {
        Function0<Pair<String, String>> function0 = this.c;
        if (function0 != null) {
            Pair<String, String> invoke = function0.invoke();
            if (Intrinsics.areEqual(str, invoke.getFirst()) && Intrinsics.areEqual(str2, invoke.getSecond())) {
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(this.a, str) && Intrinsics.areEqual(this.b, str2)) {
            return true;
        }
        return false;
    }

    public f(String str, String str2, Function0<Pair<String, String>> function0) {
        this.a = str;
        this.b = str2;
        this.c = function0;
    }

    public final void onBufferCount(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            c(videoStateInquirer, playEntity, i);
        }
    }

    public final void onBufferingUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            f(videoStateInquirer, playEntity, i);
        }
    }

    public final void onEnginePlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            h(videoStateInquirer, playEntity, i);
        }
    }

    public final void onError(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Error error) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            i(videoStateInquirer, playEntity, error);
        }
    }

    public final boolean onExecCommand(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoLayerCommand iVideoLayerCommand) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            return j(videoStateInquirer, playEntity, iVideoLayerCommand);
        }
        return false;
    }

    public final void onFetchVideoModel(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            m(videoStateInquirer, playEntity, z);
        }
    }

    public final void onLoadStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            r(videoStateInquirer, playEntity, i);
        }
    }

    public final void onPlaybackStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            s(videoStateInquirer, playEntity, i);
        }
    }

    public final void onPreVideoSeek(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            v(videoStateInquirer, playEntity, j);
        }
    }

    public final void onRenderSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            z(videoStateInquirer, playEntity, z);
        }
    }

    public final void onStreamChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            D(videoStateInquirer, playEntity, i);
        }
    }

    public final void onVideoEngineInfos(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, VideoEngineInfos videoEngineInfos) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            G(videoStateInquirer, playEntity, videoEngineInfos);
        }
    }

    public final void onVideoSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            O(videoStateInquirer, playEntity, z);
        }
    }

    public final void onVideoSeekStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            P(videoStateInquirer, playEntity, j);
        }
    }

    public final void onVideoStatusException(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            R(videoStateInquirer, playEntity, i);
        }
    }

    public final void onBarrageMaskCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String str) {
        String str2;
        String str3 = null;
        if (playEntity != null) {
            str2 = playEntity.getTag();
        } else {
            str2 = null;
        }
        if (playEntity != null) {
            str3 = playEntity.getSubTag();
        }
        if (T(str2, str3)) {
            a(videoStateInquirer, playEntity, i, str);
        }
    }

    public final void onExternalSubtitlesCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String str) {
        String str2;
        String str3 = null;
        if (playEntity != null) {
            str2 = playEntity.getTag();
        } else {
            str2 = null;
        }
        if (playEntity != null) {
            str3 = playEntity.getSubTag();
        }
        if (T(str2, str3)) {
            k(videoStateInquirer, playEntity, i, str);
        }
    }

    public final void onExternalSubtitlesPathInfoCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String str, Error error) {
        String str2;
        String str3 = null;
        if (playEntity != null) {
            str2 = playEntity.getTag();
        } else {
            str2 = null;
        }
        if (playEntity != null) {
            str3 = playEntity.getSubTag();
        }
        if (T(str2, str3)) {
            l(videoStateInquirer, playEntity, str, error);
        }
    }

    public final void onFrameDraw(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, Map<Object, Object> map) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            o(videoStateInquirer, playEntity, i, map);
        }
    }

    public final void onProgressUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            y(videoStateInquirer, playEntity, i, i2);
        }
    }

    public final void onResolutionChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, boolean z) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            B(videoStateInquirer, playEntity, resolution, z);
        }
    }

    public final void onSubSwitchCompletedCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            E(videoStateInquirer, playEntity, i, i2);
        }
    }

    public final void onVideoSizeChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            Q(videoStateInquirer, playEntity, i, i2);
        }
    }

    public final void onVideoStreamBitrateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, int i) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            S(videoStateInquirer, playEntity, resolution, i);
        }
    }

    public final boolean onInterceptFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            return q(videoStateInquirer, playEntity, z, i, z2);
        }
        return false;
    }

    public final void onResolutionChangedByQuality(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String str, boolean z, boolean z2) {
        String str2;
        String str3 = null;
        if (playEntity != null) {
            str2 = playEntity.getTag();
        } else {
            str2 = null;
        }
        if (playEntity != null) {
            str3 = playEntity.getSubTag();
        }
        if (T(str2, str3)) {
            C(videoStateInquirer, playEntity, str, z, z2);
        }
    }

    public /* synthetic */ f(String str, String str2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : function0);
    }

    public final void onFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2, boolean z3) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            p(videoStateInquirer, playEntity, z, i, z2, z3);
        }
    }

    public final void onPreFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoContext iVideoContext, boolean z, int i, boolean z2, boolean z3) {
        String str;
        String str2 = null;
        if (playEntity != null) {
            str = playEntity.getTag();
        } else {
            str = null;
        }
        if (playEntity != null) {
            str2 = playEntity.getSubTag();
        }
        if (T(str, str2)) {
            t(videoStateInquirer, playEntity, iVideoContext, z, i, z2, z3);
        }
    }
}

package is3;

import com.bytedance.covode.number.Covode;
import com.ss.android.videoshop.api.IVideoContext;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.command.IVideoLayerCommand;
import com.ss.android.videoshop.entity.PlayEntity;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f implements n {
    static {
        Covode.recordClassIndex(598910);
    }

    @Override // is3.n
    public void b(boolean z) {
    }

    public void handleOtherSensorRotateAnyway(boolean z, int i) {
    }

    public void onBarrageMaskCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String maskInfo) {
        Intrinsics.checkNotNullParameter(maskInfo, "maskInfo");
    }

    public void onBufferCount(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onBufferEnd(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onBufferStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onBufferingUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onEngineInitPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onEnginePlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onError(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    public boolean onExecCommand(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoLayerCommand iVideoLayerCommand) {
        return false;
    }

    public void onExternalSubtitlesCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String maskInfo) {
        Intrinsics.checkNotNullParameter(maskInfo, "maskInfo");
    }

    public void onExternalSubtitlesPathInfoCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String subPathInfo, Error error) {
        Intrinsics.checkNotNullParameter(subPathInfo, "subPathInfo");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    public void onFetchVideoModel(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public void onFirstPlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onFrameDraw(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, Map<?, ?> map) {
    }

    public void onFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2, boolean z3) {
    }

    public boolean onInterceptFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2) {
        return false;
    }

    public void onLoadStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onPlaybackStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onPreFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoContext videoContext, boolean z, int i, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoContext, "videoContext");
    }

    public void onPreRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onPreVideoSeek(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
    }

    public void onPrepare(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onPrepared(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onProgressUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void onRenderSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public void onRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onResolutionChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, boolean z) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
    }

    public void onResolutionChangedByQuality(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String resolutionQuality, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(resolutionQuality, "resolutionQuality");
    }

    public void onStreamChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onSubSwitchCompletedCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void onUpdateVideoSize(VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
    }

    public void onVideoCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoEngineInfos(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, VideoEngineInfos videoEngineInfos) {
        Intrinsics.checkNotNullParameter(videoEngineInfos, "videoEngineInfos");
    }

    public void onVideoPause(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoPreCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoPreRelease(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoReleased(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoReplay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoRetry(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
    }

    public void onVideoSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
    }

    public void onVideoSeekStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
    }

    public void onVideoSizeChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
    }

    public void onVideoStatusException(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
    }

    public void onVideoStreamBitrateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, int i) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
    }
}

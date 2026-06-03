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
public class b implements n {
    public static final int b;
    public n a;

    static {
        Covode.recordClassIndex(598906);
        b = 8;
    }

    public b(n nVar) {
        this.a = nVar;
    }

    @Override // is3.n
    public void b(boolean z) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.b(z);
        }
    }

    public void onUpdateVideoSize(VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onUpdateVideoSize(videoInfo);
        }
    }

    public void handleOtherSensorRotateAnyway(boolean z, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.handleOtherSensorRotateAnyway(z, i);
        }
    }

    public void onBufferEnd(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onBufferEnd(videoStateInquirer, playEntity);
        }
    }

    public void onBufferStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onBufferStart(videoStateInquirer, playEntity);
        }
    }

    public void onEngineInitPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onEngineInitPlay(videoStateInquirer, playEntity);
        }
    }

    public void onFirstPlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onFirstPlayStart(videoStateInquirer, playEntity);
        }
    }

    public void onPreRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPreRenderStart(videoStateInquirer, playEntity);
        }
    }

    public void onPrepare(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPrepare(videoStateInquirer, playEntity);
        }
    }

    public void onPrepared(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPrepared(videoStateInquirer, playEntity);
        }
    }

    public void onRenderStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onRenderStart(videoStateInquirer, playEntity);
        }
    }

    public void onVideoCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoCompleted(videoStateInquirer, playEntity);
        }
    }

    public void onVideoPause(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoPause(videoStateInquirer, playEntity);
        }
    }

    public void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoPlay(videoStateInquirer, playEntity);
        }
    }

    public void onVideoPreCompleted(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoPreCompleted(videoStateInquirer, playEntity);
        }
    }

    public void onVideoPreRelease(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoPreRelease(videoStateInquirer, playEntity);
        }
    }

    public void onVideoReleased(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoReleased(videoStateInquirer, playEntity);
        }
    }

    public void onVideoReplay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoReplay(videoStateInquirer, playEntity);
        }
    }

    public void onVideoRetry(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoRetry(videoStateInquirer, playEntity);
        }
    }

    public void onBufferCount(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onBufferCount(videoStateInquirer, playEntity, i);
        }
    }

    public void onBufferingUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onBufferingUpdate(videoStateInquirer, playEntity, i);
        }
    }

    public void onEnginePlayStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onEnginePlayStart(videoStateInquirer, playEntity, i);
        }
    }

    public void onFetchVideoModel(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onFetchVideoModel(videoStateInquirer, playEntity, z);
        }
    }

    public void onLoadStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onLoadStateChanged(videoStateInquirer, playEntity, i);
        }
    }

    public void onPlaybackStateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPlaybackStateChanged(videoStateInquirer, playEntity, i);
        }
    }

    public void onPreVideoSeek(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPreVideoSeek(videoStateInquirer, playEntity, j);
        }
    }

    public void onRenderSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onRenderSeekComplete(videoStateInquirer, playEntity, z);
        }
    }

    public void onStreamChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onStreamChanged(videoStateInquirer, playEntity, i);
        }
    }

    public void onVideoSeekComplete(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoSeekComplete(videoStateInquirer, playEntity, z);
        }
    }

    public void onVideoSeekStart(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, long j) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoSeekStart(videoStateInquirer, playEntity, j);
        }
    }

    public void onVideoStatusException(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoStatusException(videoStateInquirer, playEntity, i);
        }
    }

    public void onError(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onError(videoStateInquirer, playEntity, error);
        }
    }

    public boolean onExecCommand(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoLayerCommand iVideoLayerCommand) {
        n nVar = this.a;
        if (nVar != null) {
            return nVar.onExecCommand(videoStateInquirer, playEntity, iVideoLayerCommand);
        }
        return false;
    }

    public void onVideoEngineInfos(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, VideoEngineInfos videoEngineInfos) {
        Intrinsics.checkNotNullParameter(videoEngineInfos, "videoEngineInfos");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoEngineInfos(videoStateInquirer, playEntity, videoEngineInfos);
        }
    }

    public void onFrameDraw(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, Map<?, ?> map) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onFrameDraw(videoStateInquirer, playEntity, i, map);
        }
    }

    public void onProgressUpdate(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onProgressUpdate(videoStateInquirer, playEntity, i, i2);
        }
    }

    public void onSubSwitchCompletedCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onSubSwitchCompletedCallback(videoStateInquirer, playEntity, i, i2);
        }
    }

    public void onVideoSizeChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, int i2) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoSizeChanged(videoStateInquirer, playEntity, i, i2);
        }
    }

    public void onBarrageMaskCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String maskInfo) {
        Intrinsics.checkNotNullParameter(maskInfo, "maskInfo");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onBarrageMaskCallback(videoStateInquirer, playEntity, i, maskInfo);
        }
    }

    public void onExternalSubtitlesCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, int i, String maskInfo) {
        Intrinsics.checkNotNullParameter(maskInfo, "maskInfo");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onExternalSubtitlesCallback(videoStateInquirer, playEntity, i, maskInfo);
        }
    }

    public void onResolutionChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, boolean z) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onResolutionChanged(videoStateInquirer, playEntity, resolution, z);
        }
    }

    public void onVideoStreamBitrateChanged(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, Resolution resolution, int i) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onVideoStreamBitrateChanged(videoStateInquirer, playEntity, resolution, i);
        }
    }

    public void onExternalSubtitlesPathInfoCallback(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String subPathInfo, Error error) {
        Intrinsics.checkNotNullParameter(subPathInfo, "subPathInfo");
        Intrinsics.checkNotNullParameter(error, "error");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onExternalSubtitlesPathInfoCallback(videoStateInquirer, playEntity, subPathInfo, error);
        }
    }

    public boolean onInterceptFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2) {
        n nVar = this.a;
        if (nVar != null) {
            return nVar.onInterceptFullScreen(videoStateInquirer, playEntity, z, i, z2);
        }
        return false;
    }

    public void onResolutionChangedByQuality(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, String resolutionQuality, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(resolutionQuality, "resolutionQuality");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onResolutionChangedByQuality(videoStateInquirer, playEntity, resolutionQuality, z, z2);
        }
    }

    public void onFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, boolean z, int i, boolean z2, boolean z3) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.onFullScreen(videoStateInquirer, playEntity, z, i, z2, z3);
        }
    }

    public void onPreFullScreen(VideoStateInquirer videoStateInquirer, PlayEntity playEntity, IVideoContext videoContext, boolean z, int i, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoContext, "videoContext");
        n nVar = this.a;
        if (nVar != null) {
            nVar.onPreFullScreen(videoStateInquirer, playEntity, videoContext, z, i, z2, z3);
        }
    }
}

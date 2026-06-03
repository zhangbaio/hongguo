package com.xs.fm.player.sdk.play.player.audio.segment;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import com.xs.fm.player.base.play.player.audio.segment.ISegmentsInfoProvider;
import com.xs.fm.player.base.play.player.audio.segment.controller.ISegmentDownloader;
import com.xs.fm.player.base.play.player.audio.segment.model.PlaySegmentInfo;
import com.xs.fm.player.base.play.player.audio.segment.model.SegmentModel;
import com.xs.fm.player.sdk.play.player.audio.engine.EngineLooperMonitor;
import com.xs.fm.player.sdk.play.player.audio.engine.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TtsAudioPlayer<T> implements IAudioPlayer, ISegmentsInfoProvider.RequestCallback<T>, ISegmentDownloader.Callback<T> {
    protected wk6.a durationController;
    private long initStartTime;
    private volatile boolean isCompleteAfterPaused;
    private boolean isFirstPlaySuccess;
    private volatile boolean isPaused;
    private volatile boolean isPlaying;
    private volatile boolean isSegmentReqEnd;
    protected volatile boolean isWaitingNextSegment;
    protected volatile boolean lastPlayingStatus;
    protected IPlayer.PlayerListener mAudioPlayListener;
    private int mCurrentChapterProgress;
    protected int mCurrentPlayIndex;
    protected PlaySegmentInfo<T> mCurrentSegmentInfo;
    protected bl6.a mLogger;
    protected PlayEngineInfo mPlayEngineInfo;
    protected ISegmentDownloader<T> mSegmentDownloader;
    private IAudioPlayer mSegmentPlayer;
    protected final List<PlaySegmentInfo<T>> mSegments;
    private final ISegmentsInfoProvider<T> mSegmentsInfoProvider;
    private T mTargetSegmentInfo;
    private final IPlayer.PlayerListener segmentPlayerListener;
    private b<T> ttsPlayListener;

    public interface b<T> {
        void a(PlaySegmentInfo<T> playSegmentInfo);

        void b(PlaySegmentInfo<T> playSegmentInfo);

        void e();

        void onComplete();
    }

    static {
        Covode.recordClassIndex(655982);
    }

    protected boolean canPlayingChange() {
        return true;
    }

    protected boolean isPlayInfoValid(PlaySegmentInfo<T> playSegmentInfo) {
        return true;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void removePlayerListener() {
        this.mAudioPlayListener = null;
    }

    public int updateSegmentVideoDuration(PlayEngineInfo playEngineInfo, int i) {
        return 0;
    }

    public PlaySegmentInfo<T> getCurrentSegmentInfo() {
        return this.mCurrentSegmentInfo;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getPosition() {
        return this.mCurrentChapterProgress;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPaused() {
        return this.isPaused;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPlaying() {
        return this.isPlaying;
    }

    private void clearCache() {
        ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
        if (iSegmentDownloader != null) {
            iSegmentDownloader.clearCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSegmentDownloaded$0() {
        if (this.isWaitingNextSegment) {
            tryPlayNextSegment();
        }
    }

    private void releaseDownloader() {
        ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
        if (iSegmentDownloader != null) {
            iSegmentDownloader.release();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay() {
        return this.mSegmentPlayer.getCurrentAudioDeviceInfoForPlay();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayEngineInfo getCurrentPlayInfo() {
        return this.mSegmentPlayer.getCurrentPlayInfo();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getDuration() {
        return (int) this.durationController.b();
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public TTVideoEngine getEngine() {
        return this.mSegmentPlayer.getEngine();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayAddress getPlayAddress() {
        return this.mSegmentPlayer.getPlayAddress();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isOsPlayer() {
        return this.mSegmentPlayer.isOsPlayer();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isReleased() {
        return this.mSegmentPlayer.isReleased();
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void promoteThreadPriority() {
        IAudioPlayer iAudioPlayer = this.mSegmentPlayer;
        if (iAudioPlayer != null) {
            iAudioPlayer.promoteThreadPriority();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void resetThreadPriority() {
        IAudioPlayer iAudioPlayer = this.mSegmentPlayer;
        if (iAudioPlayer != null) {
            iAudioPlayer.resetThreadPriority();
        }
    }

    class a extends IPlayer.PlayerListener.Stub {
        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onBufferingUpdate(int i) {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPlay() {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPrepare() {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPrepared() {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onUIStateChange(IPlayer iPlayer, int i) {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onAbandonAudioFocus() {
            IPlayer.PlayerListener playerListener = TtsAudioPlayer.this.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onAbandonAudioFocus();
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerRenderStart() {
            IPlayer.PlayerListener playerListener = TtsAudioPlayer.this.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onPlayerRenderStart();
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onRequestAudioFocus() {
            IPlayer.PlayerListener playerListener = TtsAudioPlayer.this.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onRequestAudioFocus();
            }
        }

        a() {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onAudioFocusChange(int i) {
            IPlayer.PlayerListener playerListener = TtsAudioPlayer.this.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onAudioFocusChange(i);
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayCompletion(IPlayer iPlayer) {
            if (TtsAudioPlayer.this.isPaused) {
                TtsAudioPlayer.this.mLogger.b("already paused", new Object[0]);
                TtsAudioPlayer.this.isCompleteAfterPaused = true;
            } else {
                if (TtsAudioPlayer.this.isPlayingLastSegment()) {
                    TtsAudioPlayer.this.mLogger.b("AudioCoreListenerTransform onPlayCompletion", new Object[0]);
                    TtsAudioPlayer.this.setPause();
                    TtsAudioPlayer ttsAudioPlayer = TtsAudioPlayer.this;
                    IPlayer.PlayerListener playerListener = ttsAudioPlayer.mAudioPlayListener;
                    if (playerListener != null) {
                        playerListener.onPlayCompletion(ttsAudioPlayer);
                        return;
                    }
                    return;
                }
                TtsAudioPlayer.this.tryPlayNextSegment();
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayStateChange(IPlayer iPlayer, int i) {
            if (!TtsAudioPlayer.this.isFirstPlaySuccess && i == 103) {
                TtsAudioPlayer.this.isFirstPlaySuccess = true;
                TtsAudioPlayer ttsAudioPlayer = TtsAudioPlayer.this;
                IPlayer.PlayerListener playerListener = ttsAudioPlayer.mAudioPlayListener;
                if (playerListener != null) {
                    playerListener.onPlayStateChange(ttsAudioPlayer, i);
                }
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onError(IPlayer iPlayer, int i, String str) {
            TtsAudioPlayer.this.doOnSegmentFailed(i, str);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onProgressUpdate(IPlayer iPlayer, int i, int i2) {
            TtsAudioPlayer.this.durationController.f(r4.updateSegmentVideoDuration(r4.mSegmentPlayer.getCurrentPlayInfo(), i2));
            TtsAudioPlayer ttsAudioPlayer = TtsAudioPlayer.this;
            ttsAudioPlayer.mCurrentChapterProgress = ttsAudioPlayer.getCurrentSegmentStartTime() + i;
            TtsAudioPlayer ttsAudioPlayer2 = TtsAudioPlayer.this;
            IPlayer.PlayerListener playerListener = ttsAudioPlayer2.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onProgressUpdate(ttsAudioPlayer2, ttsAudioPlayer2.mCurrentChapterProgress, (int) TtsAudioPlayer.this.durationController.b());
            }
        }
    }

    private void doOnSegmentRequestEnd() {
        this.isSegmentReqEnd = true;
        this.durationController.e();
    }

    private void stopGenerateAndDownload() {
        this.mSegmentsInfoProvider.stopRequest();
        ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
        if (iSegmentDownloader != null) {
            iSegmentDownloader.stop();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public boolean isEngineLooperBlock() {
        IAudioPlayer iAudioPlayer = this.mSegmentPlayer;
        if (iAudioPlayer != null) {
            return iAudioPlayer.isEngineLooperBlock();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isStopped() {
        IAudioPlayer iAudioPlayer = this.mSegmentPlayer;
        if (iAudioPlayer != null) {
            return iAudioPlayer.isStopped();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        this.mSegmentPlayer.release();
        setStop();
        releaseDownloader();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void stop() {
        this.mSegmentPlayer.stop();
        setStop();
    }

    private void doOnComplete() {
        this.isPaused = false;
        this.isPlaying = false;
        this.isWaitingNextSegment = false;
        this.lastPlayingStatus = false;
        stopGenerateAndDownload();
        clearCache();
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onPlayCompletion(this);
        }
        b<T> bVar = this.ttsPlayListener;
        if (bVar != null) {
            bVar.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPause() {
        this.isPaused = true;
        this.isPlaying = false;
        this.lastPlayingStatus = false;
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onUIStateChange(this, 301);
        }
    }

    private void setPlaying() {
        this.isPaused = false;
        this.isPlaying = true;
        if (this.mAudioPlayListener != null && canPlayingChange()) {
            this.mAudioPlayListener.onUIStateChange(this, 303);
        }
        this.lastPlayingStatus = true;
    }

    private void setStop() {
        this.isPaused = false;
        this.isPlaying = false;
        this.lastPlayingStatus = false;
        stopGenerateAndDownload();
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onUIStateChange(this, 301);
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public float getPercentage() {
        if (this.mCurrentChapterProgress <= 0 || getDuration() <= 0) {
            return 0.0f;
        }
        return this.mCurrentChapterProgress / (getDuration() + 0.0f);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void resume() {
        if (this.isCompleteAfterPaused) {
            tryPlayNextSegment();
        } else {
            setPlaying();
            this.mSegmentPlayer.resume();
        }
        this.isCompleteAfterPaused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayingLastSegment() {
        int size = this.mSegments.size();
        if (this.mCurrentSegmentInfo != null && !this.mSegments.isEmpty() && this.mCurrentSegmentInfo == this.mSegments.get(size - 1)) {
            return true;
        }
        return false;
    }

    private void reset() {
        this.isFirstPlaySuccess = false;
        stopGenerateAndDownload();
        this.isWaitingNextSegment = false;
        this.isSegmentReqEnd = false;
        this.lastPlayingStatus = false;
        synchronized (this.mSegments) {
            this.mSegments.clear();
        }
        this.mCurrentPlayIndex = -1;
        this.isPaused = false;
        this.isPlaying = false;
        this.mCurrentChapterProgress = 0;
        this.mPlayEngineInfo = null;
        this.mCurrentSegmentInfo = null;
        this.isCompleteAfterPaused = false;
        this.durationController.d();
        b<T> bVar = this.ttsPlayListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    public int getCurrentSegmentStartTime() {
        int i;
        synchronized (this.mSegments) {
            int size = this.mSegments.size();
            i = 0;
            for (int i2 = 0; i2 < this.mCurrentPlayIndex && i2 < size; i2++) {
                i += this.mSegments.get(i2).getDuration();
            }
        }
        return i;
    }

    protected void waitNextSegment() {
        this.mLogger.d("waitNextSegment, index:%d", Integer.valueOf(this.mCurrentPlayIndex));
        this.isWaitingNextSegment = true;
        this.lastPlayingStatus = false;
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onUIStateChange(this, 302);
        }
    }

    private boolean trySeekToTargetSegment() {
        T t = this.mTargetSegmentInfo;
        if (t != null) {
            seekTo((TtsAudioPlayer<T>) t);
            this.initStartTime = 0L;
            this.mLogger.d("seek to sentence args= %s,currentPlayIndex=%s", this.mTargetSegmentInfo, Integer.valueOf(this.mCurrentPlayIndex));
            if (this.mCurrentPlayIndex != -1) {
                return true;
            }
            return false;
        }
        long j = this.initStartTime;
        if (j == 0 || this.mCurrentPlayIndex != -1) {
            return false;
        }
        this.mLogger.d("try seek to initStartTime:%d", Long.valueOf(j));
        seekTo(this.initStartTime);
        this.initStartTime = 0L;
        this.mLogger.d("seek to index:%d", Integer.valueOf(this.mCurrentPlayIndex));
        if (this.mCurrentPlayIndex != -1) {
            return true;
        }
        return false;
    }

    protected void tryPlayNextSegment() {
        synchronized (this.mSegments) {
            if (this.mSegments.size() == 0) {
                waitNextSegment();
            } else {
                if (this.mCurrentPlayIndex != this.mSegments.size() - 1 && this.mCurrentPlayIndex + 1 <= this.mSegments.size() - 1) {
                    if (trySeekToTargetSegment()) {
                        return;
                    }
                    PlaySegmentInfo<T> playSegmentInfo = this.mSegments.get(this.mCurrentPlayIndex + 1);
                    this.mCurrentSegmentInfo = playSegmentInfo;
                    if (!isPlayInfoExist(playSegmentInfo)) {
                        this.mLogger.d("continue to waitNextSegment with info.uri is empty", new Object[0]);
                        waitNextSegment();
                        if (this.mSegmentsInfoProvider.isSegmentInfoValid(playSegmentInfo)) {
                            this.mSegmentDownloader.a(this.mSegments, this.mCurrentPlayIndex + 1);
                        } else {
                            this.mSegmentsInfoProvider.requestSegmentsTts(playSegmentInfo.getSegmentInfo(), this);
                        }
                    } else {
                        this.mLogger.d("going to play next ,current_index = %s, initStartTime=%s ", Integer.valueOf(this.mCurrentPlayIndex), Long.valueOf(this.initStartTime));
                        this.mCurrentPlayIndex++;
                        if (isPlayInfoValid(playSegmentInfo)) {
                            startPlay(playSegmentInfo, true);
                        } else {
                            this.mLogger.b("isPlayInfoValid trigger tryPlayNextSegment ,current_index = %s, initStartTime=%s ", Integer.valueOf(this.mCurrentPlayIndex), Long.valueOf(this.initStartTime));
                            tryPlayNextSegment();
                        }
                    }
                }
                this.mLogger.d("reach last segment, isSegmentReqEnd:%b", Boolean.valueOf(this.isSegmentReqEnd));
                if (this.isSegmentReqEnd) {
                    doOnComplete();
                } else {
                    waitNextSegment();
                }
            }
        }
    }

    public void setTargetSegmentInfo(T t) {
        this.mTargetSegmentInfo = t;
    }

    public void setTtsPlayListener(b bVar) {
        this.ttsPlayListener = bVar;
    }

    public TtsAudioPlayer(ISegmentsInfoProvider<T> iSegmentsInfoProvider) {
        this(iSegmentsInfoProvider, "default");
    }

    protected boolean canSeek(long j) {
        return this.durationController.a(j);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioEffect(pk6.a aVar) {
        this.mSegmentPlayer.changeAudioEffect(aVar);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioLoudestInfo(pk6.a aVar) {
        this.mSegmentPlayer.changeAudioLoudestInfo(aVar);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo) {
        this.mSegmentPlayer.changeVoiceBgmInfo(voiceBgmInfo);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void configAudioResolution(Resolution resolution) {
        this.mSegmentPlayer.configAudioResolution(resolution);
    }

    public void setSegmentDownloader(ISegmentDownloader<T> iSegmentDownloader) {
        this.mSegmentDownloader = iSegmentDownloader;
        iSegmentDownloader.b(this);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void pause(boolean z) {
        this.mSegmentPlayer.pause(z);
        setPause();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.mAudioPlayListener = playerListener;
        this.mSegmentPlayer.setPlayerListener(this.segmentPlayerListener);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlaySpeed(int i) {
        Iterator<PlaySegmentInfo<T>> it2 = this.mSegments.iterator();
        while (it2.hasNext()) {
            it2.next().updateSpeed(i);
        }
        this.mSegmentPlayer.setPlaySpeed(i);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void switchPlayer(IAudioPlayer iAudioPlayer) {
        iAudioPlayer.setPlayerListener(this.mAudioPlayListener);
        this.mAudioPlayListener = null;
        this.mSegmentPlayer.removePlayerListener();
        release();
        IAudioPlayer iAudioPlayer2 = this.mSegmentPlayer;
        if (iAudioPlayer2 instanceof g) {
            ((g) iAudioPlayer2).M();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.controller.ISegmentDownloader.Callback
    public void onDownloaderInitFailed(String str) {
        if (this.isWaitingNextSegment) {
            this.mLogger.b("onDownloaderInitFailed, reason is:" + str, new Object[0]);
            IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
            if (playerListener != null) {
                playerListener.onError(this, -1116, str);
            }
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.controller.ISegmentDownloader.Callback
    public void onStartSegmentDownload(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLogger.a("start download segment, itemId is " + str, new Object[0]);
    }

    protected boolean isPlayInfoExist(PlaySegmentInfo<T> playSegmentInfo) {
        String str;
        if (playSegmentInfo.playAddress == null) {
            return false;
        }
        if (playSegmentInfo.isPlayByLocal()) {
            ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
            if (iSegmentDownloader != null) {
                str = iSegmentDownloader.c(playSegmentInfo);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(playSegmentInfo.playAddress.playFile)) {
                return false;
            }
            return true;
        }
        PlayAddress playAddress = playSegmentInfo.playAddress;
        if (playAddress.playType == 0 && !TextUtils.isEmpty(playAddress.playUrl)) {
            return true;
        }
        PlayAddress playAddress2 = playSegmentInfo.playAddress;
        if (playAddress2.playType == 1 && !TextUtils.isEmpty(playAddress2.playFile)) {
            return true;
        }
        PlayAddress playAddress3 = playSegmentInfo.playAddress;
        if (playAddress3.playType != 2 || TextUtils.isEmpty(playAddress3.playVideoModel)) {
            return false;
        }
        return true;
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.ISegmentsInfoProvider.RequestCallback
    public void onRefreshSegmentModel(SegmentModel<T> segmentModel) {
        synchronized (this.mSegments) {
            if (segmentModel.isEnd) {
                doOnSegmentRequestEnd();
            }
            this.durationController.c(segmentModel.realDuration, segmentModel.predictDuration);
            List<PlaySegmentInfo<T>> list = segmentModel.segments;
            this.mSegments.clear();
            this.mSegments.addAll(list);
            ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
            if (iSegmentDownloader != null) {
                int i = this.mCurrentPlayIndex;
                if (i != -1) {
                    iSegmentDownloader.a(list, i);
                } else {
                    iSegmentDownloader.d(list);
                }
            }
            if (this.isWaitingNextSegment) {
                this.mLogger.d("tryPlayNextSegment onRefreshSegmentModel", new Object[0]);
                tryPlayNextSegment();
            }
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void play(PlayEngineInfo playEngineInfo) {
        int i;
        reset();
        this.mPlayEngineInfo = playEngineInfo;
        EngineLooperMonitor.j(playEngineInfo, this.mSegmentPlayer.isEngineLooperBlock(), true);
        if (this.mSegmentPlayer.isReleased() || this.mSegmentPlayer.isOsPlayer() != playEngineInfo.isOsPlayer || (c.a.l.N() && this.mSegmentPlayer.isEngineLooperBlock())) {
            if (c.a.l.N() && this.mSegmentPlayer.isEngineLooperBlock()) {
                EngineLooperMonitor.i(true);
            }
            if (this.mSegmentPlayer.isOsPlayer()) {
                i = 2;
            } else {
                i = 0;
            }
            g gVar = new g(i);
            this.mLogger.d("switchPlayer player os=%s success!", Boolean.valueOf(playEngineInfo.isOsPlayer));
            this.mSegmentPlayer.switchPlayer(gVar);
            this.mSegmentPlayer = gVar;
        }
        T targetSegment = this.mSegmentsInfoProvider.getTargetSegment();
        if (targetSegment != null) {
            this.mTargetSegmentInfo = targetSegment;
        }
        this.initStartTime = playEngineInfo.playPosition;
        ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
        if (iSegmentDownloader != null) {
            iSegmentDownloader.prepare();
        }
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onPlayerPrepare();
        }
        this.mSegmentsInfoProvider.requestSegments(playEngineInfo, this);
        promoteThreadPriority();
        tryPlayNextSegment();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void seekTo(long j) {
        synchronized (this.mSegments) {
            this.mLogger.d("seek to:%d", Long.valueOf(j));
            if (!canSeek(j)) {
                this.mLogger.b("can not seek, current real duration is:%d", Long.valueOf(this.durationController.a));
                return;
            }
            int size = this.mSegments.size();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < size) {
                PlaySegmentInfo<T> playSegmentInfo = this.mSegments.get(i);
                i2 += playSegmentInfo.getDuration();
                long j2 = i2;
                if (j2 > j) {
                    playSegmentInfo.playPosition = Math.max(0, r13);
                    this.mCurrentPlayIndex = i;
                    this.mLogger.d("seek succeed, targetIndex:%d, lastSumDuration:%d, targetProgress:%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf((int) (j - i3)));
                    this.mSegmentPlayer.stop();
                    if (isPlayInfoExist(playSegmentInfo)) {
                        if (isPlayInfoValid(playSegmentInfo)) {
                            startPlay(playSegmentInfo, false);
                        } else {
                            tryPlayNextSegment();
                        }
                    } else {
                        if (this.mSegmentsInfoProvider.isSegmentInfoValid(playSegmentInfo)) {
                            this.mSegmentDownloader.a(this.mSegments, this.mCurrentPlayIndex);
                        } else {
                            this.mSegmentsInfoProvider.requestSegmentsTts(playSegmentInfo.getSegmentInfo(), this);
                        }
                        this.mCurrentSegmentInfo = this.mSegments.get(this.mCurrentPlayIndex);
                        this.mCurrentPlayIndex--;
                        waitNextSegment();
                    }
                    return;
                }
                if (i == size - 1 && j == j2) {
                    if (this.isSegmentReqEnd) {
                        this.mLogger.d("seek to end, do onComplete", new Object[0]);
                        this.mSegmentPlayer.stop();
                        doOnComplete();
                    } else {
                        this.mLogger.d("seek to end, tryPlayNext", new Object[0]);
                        this.mCurrentPlayIndex = i;
                        this.mSegmentPlayer.stop();
                        tryPlayNextSegment();
                    }
                    return;
                }
                i++;
                i3 = i2;
            }
        }
    }

    public void seekTo(T t) {
        boolean z;
        int size = this.mSegments.size();
        PlaySegmentInfo<T> playSegmentInfo = null;
        int i = 0;
        while (true) {
            if (i < size) {
                playSegmentInfo = this.mSegments.get(i);
                T segmentInfo = playSegmentInfo.getSegmentInfo();
                if (segmentInfo != null && this.mSegmentsInfoProvider.isTargetSegmentIncluded(t, segmentInfo)) {
                    this.mCurrentPlayIndex = i;
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            this.mSegmentPlayer.stop();
            if (isPlayInfoExist(playSegmentInfo)) {
                if (isPlayInfoValid(playSegmentInfo)) {
                    startPlay(playSegmentInfo, false);
                    this.mLogger.d("request segment :查询到readerPoint，isWaitingNextSegment=%s, info=%s", Boolean.valueOf(this.isWaitingNextSegment), playSegmentInfo);
                    return;
                } else {
                    this.mLogger.b("isPlayInfoValid trigger tryPlayNextSegment ,current_index = %s", Integer.valueOf(this.mCurrentPlayIndex));
                    this.mTargetSegmentInfo = null;
                    tryPlayNextSegment();
                    return;
                }
            }
            this.mLogger.d("request segment :查询readerPoint 该段音频为空，seek不到，所以重新请求,info=%s", playSegmentInfo);
            if (this.mSegmentsInfoProvider.isSegmentInfoValid(playSegmentInfo)) {
                this.mSegmentDownloader.a(this.mSegments, this.mCurrentPlayIndex);
            } else {
                this.mSegmentsInfoProvider.requestSegmentsTts(playSegmentInfo.getSegmentInfo(), this);
            }
            this.mCurrentSegmentInfo = this.mSegments.get(this.mCurrentPlayIndex);
            this.mCurrentPlayIndex--;
            waitNextSegment();
            return;
        }
        this.mLogger.b("request segment :无法查询到有效的readerPoint ", new Object[0]);
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.ISegmentsInfoProvider.RequestCallback
    public void onSegmentRequestFailed(int i, String str) {
        doOnSegmentFailed(i, str);
    }

    private boolean interceptOffline(String str, boolean z) {
        PlaySegmentInfo<T> playSegmentInfo;
        if (z) {
            if (TextUtils.isEmpty(str) || (playSegmentInfo = this.mCurrentSegmentInfo) == null || !TextUtils.equals(str, playSegmentInfo.getSegmentKey())) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected void doOnSegmentFailed(int i, String str) {
        this.mLogger.b("failed, index:%d, code:%d", Integer.valueOf(this.mCurrentPlayIndex), Integer.valueOf(i));
        this.isPaused = false;
        this.isPlaying = false;
        this.lastPlayingStatus = false;
        stopGenerateAndDownload();
        this.mSegmentPlayer.stop();
        IPlayer.PlayerListener playerListener = this.mAudioPlayListener;
        if (playerListener != null) {
            playerListener.onError(this, i, str);
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.controller.ISegmentDownloader.Callback
    public void onSegmentDownloaded(String str, boolean z) {
        if (!interceptOffline(str, z) && this.isWaitingNextSegment) {
            this.mLogger.d("[onSegmentDecrypted]segmentInfo = " + str, new Object[0]);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                tryPlayNextSegment();
            } else {
                xk6.g.e(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.segment.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TtsAudioPlayer.this.lambda$onSegmentDownloaded$0();
                    }
                });
            }
        }
    }

    public TtsAudioPlayer(ISegmentsInfoProvider<T> iSegmentsInfoProvider, String str) {
        this.mSegments = new ArrayList();
        this.mCurrentPlayIndex = -1;
        this.mCurrentChapterProgress = 0;
        this.isFirstPlaySuccess = false;
        this.isWaitingNextSegment = false;
        this.isSegmentReqEnd = false;
        this.durationController = new wk6.a();
        this.isPaused = false;
        this.isPlaying = false;
        this.lastPlayingStatus = false;
        this.isCompleteAfterPaused = false;
        this.initStartTime = 0L;
        this.mSegmentPlayer = new g();
        a aVar = new a();
        this.segmentPlayerListener = aVar;
        this.mLogger = new bl6.a("TtsAudioPlayer-" + str);
        this.mSegmentsInfoProvider = iSegmentsInfoProvider;
        this.mSegmentPlayer.setPlayerListener(aVar);
    }

    private void startPlay(PlaySegmentInfo<T> playSegmentInfo, boolean z) {
        String str;
        b<T> bVar = this.ttsPlayListener;
        if (bVar != null) {
            bVar.b(playSegmentInfo);
        }
        if (playSegmentInfo.playAddress.playType != 1 || playSegmentInfo.isPlayByLocal()) {
            ISegmentDownloader<T> iSegmentDownloader = this.mSegmentDownloader;
            if (iSegmentDownloader != null) {
                str = iSegmentDownloader.c(playSegmentInfo);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                PlayAddress playAddress = playSegmentInfo.playAddress;
                playAddress.playType = 1;
                playAddress.playFile = str;
            } else if (playSegmentInfo.isPlayByLocal()) {
                this.mLogger.b("本地tts还没下载完，先不播放, targetSentenceArgs = " + this.mTargetSegmentInfo + ", info = " + playSegmentInfo, new Object[0]);
                waitNextSegment();
                if (z) {
                    this.mCurrentPlayIndex--;
                    this.mLogger.b("本地tts还未下载完，回退index = " + this.mCurrentPlayIndex, new Object[0]);
                    return;
                }
                return;
            }
        }
        this.mCurrentSegmentInfo = playSegmentInfo;
        this.mLogger.d("start play, targetSentenceArgs=%s, info=%s", this.mTargetSegmentInfo, playSegmentInfo);
        this.mTargetSegmentInfo = null;
        this.isWaitingNextSegment = false;
        this.mSegmentPlayer.play(playSegmentInfo);
        setPlaying();
        b<T> bVar2 = this.ttsPlayListener;
        if (bVar2 != null) {
            bVar2.a(playSegmentInfo);
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.segment.controller.ISegmentDownloader.Callback
    public void onSegmentDownloadFailed(String str, int i, int i2, String str2) {
        PlaySegmentInfo<T> playSegmentInfo;
        if (!TextUtils.isEmpty(str) && (playSegmentInfo = this.mCurrentSegmentInfo) != null && i == 1 && TextUtils.equals(str, playSegmentInfo.getSegmentKey()) && this.isWaitingNextSegment) {
            this.mLogger.b("onSegmentDownloadFailed, itemId is:" + str + ", code is" + i2 + ", msg is" + str2 + " tryPlayNextSegment", new Object[0]);
            this.mCurrentPlayIndex = this.mCurrentPlayIndex + 1;
            tryPlayNextSegment();
        }
    }
}

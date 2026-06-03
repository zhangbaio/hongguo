package com.xs.fm.player.sdk.component.event.monior.evetnmonitor;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PlayEventEntity implements Serializable {
    public static final a Companion;
    private int duration;
    private long endTime;
    private int endType;
    private int errorCode;
    private boolean hasIntercept;
    private boolean hasTip;
    private long hitCacheSize;
    private int hitCacheSizeAudio;
    private int hitCacheSizeVideo;
    private boolean hitMdlPreload;
    private boolean hitPrepare;
    private boolean hitVideoModelCache;
    private boolean isBackground;
    private boolean isEnginePrepare;
    private boolean isFirstPlay;
    private boolean isLocalFile;
    private int isNewUserFirstLaunchFirstPlay;
    private boolean isScreenLock;
    private boolean isScreenOn;
    private long jumpAudioPageTime;
    private long mdlCacheFileSize;
    private long mdlCacheMediaSize;
    private float mdlCachePercent;
    private long mdlCacheSizeFromZero;
    private int playListCacheType;
    private int playType;
    private float prepareAndPlayGapTime;
    private boolean radioMode;
    private Resolution resolution;
    private float sourceLoudness;
    private int sourceType;
    private int speed;
    private int startPosition;
    private int toneId;
    private int videoModelCacheType;
    private int volume;
    private String playTrackId = "";
    private String bookId = "";
    private String itemId = "";
    private String genreType = "";
    private String tag = "";
    private String subTag = "";
    private String vType = "";
    private String startResolution = "";
    private String bgnType = "";
    private String playTipName = "";
    private String interceptStage = "";
    private String interceptName = "";
    private String netType = "";
    private String netRank = "";
    private int isEarphone = -1;
    private String portName = "";
    private String isPlayOrResume = "";
    private String startCase = "";
    private String playEntrance = "";
    private final LinkedHashMap<String, Long> stageNameToDuration = new LinkedHashMap<>();
    private String errorType = "";
    private String errorInfo = "";
    private ArrayList<String> eventListOne = new ArrayList<>();
    private String openAudioPageFrom = "";
    private int volumeBalanceVersion = -1;
    private String mdlLocalFilePath = "";

    static {
        Covode.recordClassIndex(655896);
        Companion = new a(null);
    }

    public final String getBgnType() {
        return this.bgnType;
    }

    public final String getBookId() {
        return this.bookId;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getEndType() {
        return this.endType;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorInfo() {
        return this.errorInfo;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final ArrayList<String> getEventListOne() {
        return this.eventListOne;
    }

    public final String getGenreType() {
        return this.genreType;
    }

    public final boolean getHasIntercept() {
        return this.hasIntercept;
    }

    public final boolean getHasTip() {
        return this.hasTip;
    }

    public final long getHitCacheSize() {
        return this.hitCacheSize;
    }

    public final int getHitCacheSizeAudio() {
        return this.hitCacheSizeAudio;
    }

    public final int getHitCacheSizeVideo() {
        return this.hitCacheSizeVideo;
    }

    public final boolean getHitMdlPreload() {
        return this.hitMdlPreload;
    }

    public final boolean getHitPrepare() {
        return this.hitPrepare;
    }

    public final boolean getHitVideoModelCache() {
        return this.hitVideoModelCache;
    }

    public final String getInterceptName() {
        return this.interceptName;
    }

    public final String getInterceptStage() {
        return this.interceptStage;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final long getJumpAudioPageTime() {
        return this.jumpAudioPageTime;
    }

    public final long getMdlCacheFileSize() {
        return this.mdlCacheFileSize;
    }

    public final long getMdlCacheMediaSize() {
        return this.mdlCacheMediaSize;
    }

    public final float getMdlCachePercent() {
        return this.mdlCachePercent;
    }

    public final long getMdlCacheSizeFromZero() {
        return this.mdlCacheSizeFromZero;
    }

    public final String getMdlLocalFilePath() {
        return this.mdlLocalFilePath;
    }

    public final String getNetRank() {
        return this.netRank;
    }

    public final String getNetType() {
        return this.netType;
    }

    public final String getOpenAudioPageFrom() {
        return this.openAudioPageFrom;
    }

    public final String getPlayEntrance() {
        return this.playEntrance;
    }

    public final int getPlayListCacheType() {
        return this.playListCacheType;
    }

    public final String getPlayTipName() {
        return this.playTipName;
    }

    public final String getPlayTrackId() {
        return this.playTrackId;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final String getPortName() {
        return this.portName;
    }

    public final float getPrepareAndPlayGapTime() {
        return this.prepareAndPlayGapTime;
    }

    public final boolean getRadioMode() {
        return this.radioMode;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final float getSourceLoudness() {
        return this.sourceLoudness;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final LinkedHashMap<String, Long> getStageNameToDuration() {
        return this.stageNameToDuration;
    }

    public final String getStartCase() {
        return this.startCase;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final String getStartResolution() {
        return this.startResolution;
    }

    public final String getSubTag() {
        return this.subTag;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getToneId() {
        return this.toneId;
    }

    public final String getVType() {
        return this.vType;
    }

    public final int getVideoModelCacheType() {
        return this.videoModelCacheType;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final int getVolumeBalanceVersion() {
        return this.volumeBalanceVersion;
    }

    public final boolean isBackground() {
        return this.isBackground;
    }

    public final int isEarphone() {
        return this.isEarphone;
    }

    public final boolean isEnginePrepare() {
        return this.isEnginePrepare;
    }

    public final boolean isFirstPlay() {
        return this.isFirstPlay;
    }

    public final boolean isLocalFile() {
        return this.isLocalFile;
    }

    public final int isNewUserFirstLaunchFirstPlay() {
        return this.isNewUserFirstLaunchFirstPlay;
    }

    public final String isPlayOrResume() {
        return this.isPlayOrResume;
    }

    public final boolean isScreenLock() {
        return this.isScreenLock;
    }

    public final boolean isScreenOn() {
        return this.isScreenOn;
    }

    public final void setBackground(boolean z) {
        this.isBackground = z;
    }

    public final void setBgnType(String str) {
        this.bgnType = str;
    }

    public final void setBookId(String str) {
        this.bookId = str;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setEarphone(int i) {
        this.isEarphone = i;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setEndType(int i) {
        this.endType = i;
    }

    public final void setEnginePrepare(boolean z) {
        this.isEnginePrepare = z;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public final void setErrorType(String str) {
        this.errorType = str;
    }

    public final void setEventListOne(ArrayList<String> arrayList) {
        this.eventListOne = arrayList;
    }

    public final void setFirstPlay(boolean z) {
        this.isFirstPlay = z;
    }

    public final void setGenreType(String str) {
        this.genreType = str;
    }

    public final void setHasIntercept(boolean z) {
        this.hasIntercept = z;
    }

    public final void setHasTip(boolean z) {
        this.hasTip = z;
    }

    public final void setHitCacheSize(long j) {
        this.hitCacheSize = j;
    }

    public final void setHitCacheSizeAudio(int i) {
        this.hitCacheSizeAudio = i;
    }

    public final void setHitCacheSizeVideo(int i) {
        this.hitCacheSizeVideo = i;
    }

    public final void setHitMdlPreload(boolean z) {
        this.hitMdlPreload = z;
    }

    public final void setHitPrepare(boolean z) {
        this.hitPrepare = z;
    }

    public final void setHitVideoModelCache(boolean z) {
        this.hitVideoModelCache = z;
    }

    public final void setInterceptName(String str) {
        this.interceptName = str;
    }

    public final void setInterceptStage(String str) {
        this.interceptStage = str;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final void setJumpAudioPageTime(long j) {
        this.jumpAudioPageTime = j;
    }

    public final void setLocalFile(boolean z) {
        this.isLocalFile = z;
    }

    public final void setMdlCacheFileSize(long j) {
        this.mdlCacheFileSize = j;
    }

    public final void setMdlCacheMediaSize(long j) {
        this.mdlCacheMediaSize = j;
    }

    public final void setMdlCachePercent(float f) {
        this.mdlCachePercent = f;
    }

    public final void setMdlCacheSizeFromZero(long j) {
        this.mdlCacheSizeFromZero = j;
    }

    public final void setMdlLocalFilePath(String str) {
        this.mdlLocalFilePath = str;
    }

    public final void setNetRank(String str) {
        this.netRank = str;
    }

    public final void setNetType(String str) {
        this.netType = str;
    }

    public final void setNewUserFirstLaunchFirstPlay(int i) {
        this.isNewUserFirstLaunchFirstPlay = i;
    }

    public final void setOpenAudioPageFrom(String str) {
        this.openAudioPageFrom = str;
    }

    public final void setPlayEntrance(String str) {
        this.playEntrance = str;
    }

    public final void setPlayListCacheType(int i) {
        this.playListCacheType = i;
    }

    public final void setPlayOrResume(String str) {
        this.isPlayOrResume = str;
    }

    public final void setPlayTipName(String str) {
        this.playTipName = str;
    }

    public final void setPlayTrackId(String str) {
        this.playTrackId = str;
    }

    public final void setPlayType(int i) {
        this.playType = i;
    }

    public final void setPortName(String str) {
        this.portName = str;
    }

    public final void setPrepareAndPlayGapTime(float f) {
        this.prepareAndPlayGapTime = f;
    }

    public final void setRadioMode(boolean z) {
        this.radioMode = z;
    }

    public final void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public final void setScreenLock(boolean z) {
        this.isScreenLock = z;
    }

    public final void setScreenOn(boolean z) {
        this.isScreenOn = z;
    }

    public final void setSourceLoudness(float f) {
        this.sourceLoudness = f;
    }

    public final void setSourceType(int i) {
        this.sourceType = i;
    }

    public final void setSpeed(int i) {
        this.speed = i;
    }

    public final void setStartCase(String str) {
        this.startCase = str;
    }

    public final void setStartPosition(int i) {
        this.startPosition = i;
    }

    public final void setStartResolution(String str) {
        this.startResolution = str;
    }

    public final void setSubTag(String str) {
        this.subTag = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final void setToneId(int i) {
        this.toneId = i;
    }

    public final void setVType(String str) {
        this.vType = str;
    }

    public final void setVideoModelCacheType(int i) {
        this.videoModelCacheType = i;
    }

    public final void setVolume(int i) {
        this.volume = i;
    }

    public final void setVolumeBalanceVersion(int i) {
        this.volumeBalanceVersion = i;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(655897);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

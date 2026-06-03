package al6;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.sdk.component.event.monior.evetnmonitor.BeforeTrackerData;
import com.xs.fm.player.sdk.component.event.monior.evetnmonitor.PlayEventEntity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xk6.g;
import xk6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final bl6.a a;
    private static PlayEventEntity b;
    private static boolean c;
    private static TTVideoEngine d;
    public static final b e;

    private b() {
    }

    private final boolean h() {
        gl6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.k) != null) {
            return bVar.k();
        }
        return false;
    }

    private final boolean i() {
        gl6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.k) != null) {
            return bVar.f();
        }
        return false;
    }

    public final boolean o() {
        if (n() != null && b != null) {
            return false;
        }
        return true;
    }

    public final void p() {
        if (c) {
            PlayEventEntity playEventEntity = b;
            if (playEventEntity != null) {
                playEventEntity.setFirstPlay(true);
            }
            c = false;
        }
    }

    public final void u() {
        if (!i()) {
            return;
        }
        g.d(RunnableC0004b.a);
    }

    static {
        Covode.recordClassIndex(655898);
        e = new b();
        a = new bl6.a("FMSDKPlayerTrace-PlayEventMonitor");
        c = true;
    }

    private final void m() {
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = new PlayEventEntity();
        playEventEntity.setPlayTrackId(l(e, null, 1, null));
        b = playEventEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        lk6.b bVar;
        gl6.b bVar2;
        if (i() && (bVar = lk6.c.a) != null && (bVar2 = bVar.k) != null) {
            bVar2.j("local_play_monitor_data", "local_play_monitor_data");
        }
    }

    static final class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PlayEventEntity n;
            if (this.a == 1) {
                n = b.b(b.e);
            } else {
                n = b.e.n();
            }
            if (n != null) {
                n.setEndType(this.a);
            }
            if (n != null) {
                n.setEndTime(System.currentTimeMillis());
            }
            b bVar = b.e;
            bVar.t(n, this.a);
            bVar.r();
            b.b = null;
        }
    }

    /* renamed from: al6.b$b, reason: collision with other inner class name */
    static final class RunnableC0004b implements Runnable {
        public static final RunnableC0004b a = new RunnableC0004b();

        RunnableC0004b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            lk6.b bVar;
            gl6.b bVar2;
            b bVar3 = b.e;
            if (b.b(bVar3) != null && (bVar = lk6.c.a) != null && (bVar2 = bVar.k) != null) {
                PlayEventEntity b = b.b(bVar3);
                if (b == null) {
                    Intrinsics.throwNpe();
                }
                bVar2.c("local_play_monitor_data", "local_play_monitor_data", b, Integer.MAX_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayEventEntity n() {
        gl6.b bVar;
        PlayEventEntity playEventEntity = null;
        if (!i()) {
            return null;
        }
        if (b != null) {
            a.d("getPlayMonitorData from mem-cache: playEntity=" + b, new Object[0]);
            return b;
        }
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.k) != null) {
            playEventEntity = bVar.b("local_play_monitor_data", "local_play_monitor_data");
        }
        a.d("getPlayMonitorData from disk cache: currentSaveEntity=" + playEventEntity, new Object[0]);
        return playEventEntity;
    }

    static final class c implements Runnable {
        final /* synthetic */ PlayEngineInfo a;
        final /* synthetic */ Resolution b;

        c(PlayEngineInfo playEngineInfo, Resolution resolution) {
            this.a = playEngineInfo;
            this.b = resolution;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoModel videoModel;
            VideoModel videoModel2;
            PlayAddress playAddress;
            String str;
            long j;
            PlayEventEntity b;
            long j2;
            String str2;
            long j3;
            long j4;
            String str3;
            PlayAddress playAddress2;
            PlayAddress playAddress3;
            try {
                PlayEngineInfo playEngineInfo = this.a;
                VideoInfo videoInfo = null;
                if (playEngineInfo != null && (playAddress3 = playEngineInfo.playAddress) != null) {
                    videoModel = playAddress3.videoModel;
                } else {
                    videoModel = null;
                }
                if (videoModel == null) {
                    h hVar = h.a;
                    if (playEngineInfo != null && (playAddress2 = playEngineInfo.playAddress) != null) {
                        str3 = playAddress2.playVideoModel;
                    } else {
                        str3 = null;
                    }
                    videoModel2 = hVar.c(str3, "setPlayEngineInfoForMdlCache");
                } else if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null) {
                    videoModel2 = playAddress.videoModel;
                } else {
                    videoModel2 = null;
                }
                if (videoModel2 != null) {
                    Resolution resolution = this.b;
                    if (resolution == null) {
                        PlayEngineInfo playEngineInfo2 = this.a;
                        if (playEngineInfo2 != null) {
                            resolution = playEngineInfo2.resolution;
                        } else {
                            resolution = null;
                        }
                    }
                    videoInfo = videoModel2.getVideoInfo(resolution, (Map<Integer, String>) null, true);
                }
                String str4 = "";
                if (videoInfo == null || (str = videoInfo.getValueStr(15)) == null) {
                    str = "";
                }
                DataLoaderHelper.DataLoaderCacheInfo cacheInfo = TTVideoEngine.getCacheInfo(str);
                long quickGetCacheFileSize = TTVideoEngine.quickGetCacheFileSize(str);
                b bVar = b.e;
                PlayEventEntity b2 = b.b(bVar);
                if (b2 != null) {
                    b2.setMdlCacheFileSize(quickGetCacheFileSize);
                }
                PlayEventEntity b3 = b.b(bVar);
                long j5 = 0;
                if (b3 != null) {
                    if (cacheInfo != null) {
                        j4 = cacheInfo.mMediaSize;
                    } else {
                        j4 = 0;
                    }
                    b3.setMdlCacheMediaSize(j4);
                }
                PlayEventEntity b4 = b.b(bVar);
                if (b4 != null) {
                    if (cacheInfo != null) {
                        j3 = cacheInfo.mCacheSizeFromZero;
                    } else {
                        j3 = 0;
                    }
                    b4.setMdlCacheSizeFromZero(j3);
                }
                PlayEventEntity b5 = b.b(bVar);
                if (b5 != null) {
                    if (cacheInfo != null && (str2 = cacheInfo.mLocalFilePath) != null) {
                        str4 = str2;
                    }
                    b5.setMdlLocalFilePath(str4);
                }
                PlayEventEntity b6 = b.b(bVar);
                if (b6 != null) {
                    j = b6.getMdlCacheMediaSize();
                } else {
                    j = 0;
                }
                if (j > 0 && (b = b.b(bVar)) != null) {
                    PlayEventEntity b7 = b.b(bVar);
                    if (b7 != null) {
                        j2 = b7.getMdlCacheSizeFromZero();
                    } else {
                        j2 = 0;
                    }
                    float f = j2;
                    PlayEventEntity b8 = b.b(bVar);
                    if (b8 != null) {
                        j5 = b8.getMdlCacheMediaSize();
                    }
                    b.setMdlCachePercent(f / j5);
                }
            } catch (Exception e) {
                b.a(b.e).b("setPlayEngineInfoForDebug error", e);
            }
        }
    }

    public static final /* synthetic */ bl6.a a(b bVar) {
        return a;
    }

    public static final /* synthetic */ PlayEventEntity b(b bVar) {
        return b;
    }

    public final void C(boolean z) {
        PlayEventEntity playEventEntity;
        if (i() && (playEventEntity = b) != null) {
            playEventEntity.setHitPrepare(z);
        }
    }

    public final void D(String str) {
        PlayEventEntity playEventEntity;
        if (i() && (playEventEntity = b) != null) {
            playEventEntity.setPlayOrResume(str);
        }
    }

    public final void g(String str) {
        ArrayList<String> eventListOne;
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null && (eventListOne = playEventEntity.getEventListOne()) != null) {
            eventListOne.add(str);
        }
        u();
    }

    private final String k(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("-");
        }
        sb.append(Long.toString(System.currentTimeMillis()));
        sb.append("-");
        sb.append(Integer.toString((int) (Math.random() * 65535)));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "builder.toString()");
        return sb2;
    }

    public final void s(int i) {
        if (!i()) {
            return;
        }
        a.d("reportInnerPlayMonitor endType=" + i, new Object[0]);
        a aVar = new a(i);
        if (c && h()) {
            g.d(aVar);
        } else {
            aVar.run();
        }
    }

    public final String j(long j) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            if (j == 0) {
                return "0B";
            }
            if (j < 1048576) {
                return decimalFormat.format(j / 1024) + "KB";
            }
            if (j < 1073741824) {
                return decimalFormat.format(j / 1048576) + "MB";
            }
            return decimalFormat.format(j / 1073741824) + "GB";
        } catch (Exception unused) {
            return "0B";
        }
    }

    public final void B(boolean z, long j) {
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null) {
            playEventEntity.setHitMdlPreload(z);
        }
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            playEventEntity2.setHitCacheSize(j);
        }
    }

    public final void v(boolean z, int i) {
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null) {
            playEventEntity.setHitVideoModelCache(z);
        }
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            playEventEntity2.setVideoModelCacheType(i);
        }
    }

    public final void w(boolean z, float f) {
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null) {
            playEventEntity.setEnginePrepare(z);
        }
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            playEventEntity2.setPrepareAndPlayGapTime(f);
        }
    }

    public final void q(String str, long j) {
        PlayEventEntity playEventEntity;
        LinkedHashMap<String, Long> stageNameToDuration;
        PlayEventEntity playEventEntity2;
        LinkedHashMap<String, Long> stageNameToDuration2;
        if (i() && (playEventEntity = b) != null && playEventEntity != null && (stageNameToDuration = playEventEntity.getStageNameToDuration()) != null && !stageNameToDuration.containsKey(str) && (playEventEntity2 = b) != null && (stageNameToDuration2 = playEventEntity2.getStageNameToDuration()) != null) {
            stageNameToDuration2.put(str, Long.valueOf(j));
        }
    }

    public final void E(pk6.c cVar, kl6.a aVar) {
        Object obj;
        PlayEventEntity playEventEntity;
        Object obj2;
        int i;
        String valueOf;
        String str;
        String str2;
        long j;
        if (!i()) {
            return;
        }
        int i2 = 0;
        a.d("startPlay monitor, genrePlayEventEntity", new Object[0]);
        m();
        al6.a aVar2 = al6.a.e;
        BeforeTrackerData a2 = aVar2.a();
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            if (a2 != null) {
                j = a2.getJumpAudioPageTime();
            } else {
                j = 0;
            }
            playEventEntity2.setJumpAudioPageTime(j);
        }
        PlayEventEntity playEventEntity3 = b;
        String str3 = "";
        if (playEventEntity3 != null) {
            if (a2 == null || (str2 = a2.getOpenAudioPageFrom()) == null) {
                str2 = "";
            }
            playEventEntity3.setOpenAudioPageFrom(str2);
        }
        aVar2.b();
        PlayEventEntity playEventEntity4 = b;
        if (playEventEntity4 != null) {
            AbsPlayList absPlayList = cVar.a;
            if (absPlayList == null || (str = absPlayList.getListId()) == null) {
                str = "";
            }
            playEventEntity4.setBookId(str);
        }
        PlayEventEntity playEventEntity5 = b;
        if (playEventEntity5 != null) {
            String str4 = cVar.b;
            Intrinsics.checkExpressionValueIsNotNull(str4, "playParam.playItem");
            playEventEntity5.setItemId(str4);
        }
        PlayEventEntity playEventEntity6 = b;
        if (playEventEntity6 != null) {
            AbsPlayList absPlayList2 = cVar.a;
            if (absPlayList2 != null && (valueOf = String.valueOf(absPlayList2.getGenreType())) != null) {
                str3 = valueOf;
            }
            playEventEntity6.setGenreType(str3);
        }
        PlayEventEntity playEventEntity7 = b;
        if (playEventEntity7 != null) {
            playEventEntity7.setToneId(cVar.c);
        }
        PlayEventEntity playEventEntity8 = b;
        if (playEventEntity8 != null) {
            playEventEntity8.setSpeed(cVar.d);
        }
        PlayEventEntity playEventEntity9 = b;
        if (playEventEntity9 != null) {
            playEventEntity9.setPlayEntrance(aVar.a);
        }
        PlayEventEntity playEventEntity10 = b;
        if (playEventEntity10 != null) {
            Intrinsics.checkExpressionValueIsNotNull(xk6.a.g(), "AppLifecycleMonitor.getInstance()");
            playEventEntity10.setBackground(!r3.b);
        }
        PlayEventEntity playEventEntity11 = b;
        Object obj3 = null;
        if (playEventEntity11 != null) {
            HashMap<String, Object> hashMap = aVar.b;
            if (hashMap != null) {
                obj2 = hashMap.get("is_new_user_first_launch_first_play");
            } else {
                obj2 = null;
            }
            if (!(obj2 instanceof Integer)) {
                obj2 = null;
            }
            Integer num = (Integer) obj2;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            playEventEntity11.setNewUserFirstLaunchFirstPlay(i);
        }
        HashMap<String, Object> hashMap2 = aVar.b;
        if (hashMap2 != null && hashMap2.containsKey("business_start_case")) {
            HashMap<String, Object> hashMap3 = aVar.b;
            if (hashMap3 != null) {
                obj = hashMap3.get("business_start_case");
            } else {
                obj = null;
            }
            if ((obj instanceof String) && (playEventEntity = b) != null) {
                HashMap<String, Object> hashMap4 = aVar.b;
                if (hashMap4 != null) {
                    obj3 = hashMap4.get("business_start_case");
                }
                if (obj3 != null) {
                    playEventEntity.setStartCase((String) obj3);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        PlayEventEntity playEventEntity12 = b;
        if (playEventEntity12 != null) {
            AbsPlayList absPlayList3 = cVar.a;
            if (absPlayList3 != null) {
                i2 = absPlayList3.cacheType;
            }
            playEventEntity12.setPlayListCacheType(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(PlayEventEntity playEventEntity, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ik6.a aVar;
        gl6.b bVar;
        if (!i()) {
            return;
        }
        if (playEventEntity == null) {
            a.d("reportPlayMonitor: entity is null, return", new Object[0]);
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (bVar = bVar2.k) != null) {
                bVar.d(i);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("session_id", playEventEntity.getPlayTrackId());
            jSONObject.putOpt("book_id", playEventEntity.getBookId());
            jSONObject.putOpt("item_id", playEventEntity.getItemId());
            jSONObject.putOpt("genre_type", playEventEntity.getGenreType());
            jSONObject.putOpt("tone_id", String.valueOf(playEventEntity.getToneId()));
            jSONObject.putOpt("tag", playEventEntity.getTag());
            jSONObject.putOpt("subtag", playEventEntity.getSubTag());
            jSONObject.putOpt("speed", Integer.valueOf(playEventEntity.getSpeed()));
            jSONObject.putOpt("source_type", String.valueOf(playEventEntity.getSourceType()));
            jSONObject.putOpt("is_local_file", Boolean.valueOf(playEventEntity.isLocalFile()));
            jSONObject.putOpt("play_type", Integer.valueOf(playEventEntity.getPlayType()));
            jSONObject.putOpt("vtype", playEventEntity.getVType());
            jSONObject.putOpt("bgm_type", playEventEntity.getBgnType());
            jSONObject.putOpt("radio_mode", Boolean.valueOf(playEventEntity.getRadioMode()));
            jSONObject.putOpt("start_position", Integer.valueOf(playEventEntity.getStartPosition()));
            jSONObject.putOpt("start_resolution", playEventEntity.getStartResolution());
            jSONObject.putOpt("duration", Integer.valueOf(playEventEntity.getDuration()));
            jSONObject.putOpt("net_type", playEventEntity.getNetType());
            jSONObject.putOpt("net_rank", playEventEntity.getNetRank());
            int i6 = 1;
            if (playEventEntity.isScreenLock()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject.putOpt("is_screen_lock", Integer.valueOf(i2));
            if (playEventEntity.isScreenOn()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.putOpt("is_screen_on", Integer.valueOf(i3));
            jSONObject.putOpt("is_background", Boolean.valueOf(playEventEntity.isBackground()));
            jSONObject.putOpt("is_earphone", Integer.valueOf(playEventEntity.isEarphone()));
            jSONObject.putOpt("port_name", playEventEntity.getPortName());
            if (playEventEntity.getHitPrepare()) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            jSONObject.putOpt("hit_prepare", Integer.valueOf(i4));
            jSONObject.putOpt("hit_cache_size", Long.valueOf(playEventEntity.getHitCacheSize()));
            jSONObject.putOpt("hit_cache_size_audio", Integer.valueOf(playEventEntity.getHitCacheSizeAudio()));
            jSONObject.putOpt("hit_cache_size_video", Integer.valueOf(playEventEntity.getHitCacheSizeVideo()));
            jSONObject.putOpt("hit_videomodel_cache", Boolean.valueOf(playEventEntity.getHitVideoModelCache()));
            jSONObject.putOpt("videomodel_cache_type", Integer.valueOf(playEventEntity.getVideoModelCacheType()));
            jSONObject.putOpt("play_list_cache_type", Integer.valueOf(playEventEntity.getPlayListCacheType()));
            jSONObject.putOpt("is_engine_prepare", Boolean.valueOf(playEventEntity.isEnginePrepare()));
            jSONObject.putOpt("prepare_and_play_gap_time", Float.valueOf(playEventEntity.getPrepareAndPlayGapTime()));
            jSONObject.putOpt("mdl_cache_percent", Float.valueOf(playEventEntity.getMdlCachePercent()));
            jSONObject.putOpt("mdl_cache_file_size", Long.valueOf(playEventEntity.getMdlCacheFileSize()));
            jSONObject.putOpt("mdl_cache_media_size", Long.valueOf(playEventEntity.getMdlCacheMediaSize()));
            b bVar3 = e;
            jSONObject.putOpt("mdl_cache_media_size_unit", bVar3.j(playEventEntity.getMdlCacheMediaSize()));
            jSONObject.putOpt("mdl_cache_size_from_zero", Long.valueOf(playEventEntity.getMdlCacheSizeFromZero()));
            jSONObject.putOpt("mdl_cache_size_from_zero_unit", bVar3.j(playEventEntity.getMdlCacheSizeFromZero()));
            jSONObject.putOpt("mdl_local_file_path", playEventEntity.getMdlLocalFilePath());
            jSONObject.putOpt("is_play_or_resume", playEventEntity.isPlayOrResume());
            jSONObject.putOpt("start_case", playEventEntity.getStartCase());
            jSONObject.putOpt("play_entrance", playEventEntity.getPlayEntrance());
            jSONObject.putOpt("has_tip", Boolean.valueOf(playEventEntity.getHasTip()));
            jSONObject.putOpt("play_tip_name", playEventEntity.getPlayTipName());
            jSONObject.putOpt("is_intercept", Boolean.valueOf(playEventEntity.getHasIntercept()));
            jSONObject.putOpt("intercept_play_stage", playEventEntity.getInterceptStage());
            jSONObject.putOpt("intercept_play_name", playEventEntity.getInterceptName());
            jSONObject.putOpt("volume_balance_version", Integer.valueOf(playEventEntity.getVolumeBalanceVersion()));
            jSONObject.putOpt("source_loudness", Float.valueOf(playEventEntity.getSourceLoudness()));
            jSONObject.putOpt("report_time_range", Integer.valueOf(Calendar.getInstance().get(11)));
            Resolution resolution = playEventEntity.getResolution();
            if (resolution != null) {
                jSONObject.putOpt("resolution", resolution.toString());
            }
            String str = "";
            int i7 = -1;
            long j = 0;
            boolean z = true;
            long j2 = 0;
            long j3 = 0;
            for (Map.Entry<String, Long> entry : playEventEntity.getStageNameToDuration().entrySet()) {
                i7 += i6;
                if (z) {
                    str = entry.getKey();
                    long longValue = entry.getValue().longValue();
                    long longValue2 = entry.getValue().longValue();
                    jSONObject.putOpt("start_t", entry.getValue());
                    z = false;
                    j2 = longValue2;
                    j3 = longValue;
                } else {
                    String str2 = i7 + '_' + str + "_to_" + entry.getKey();
                    long longValue3 = entry.getValue().longValue() - j3;
                    j += longValue3;
                    jSONObject.putOpt(str2, Long.valueOf(longValue3));
                    a.d(str2 + '=' + longValue3 + " ms", new Object[0]);
                    str = entry.getKey();
                    j3 = entry.getValue().longValue();
                }
                i6 = 1;
            }
            jSONObject.putOpt("total_play_cost_time", Long.valueOf(j));
            long jumpAudioPageTime = playEventEntity.getJumpAudioPageTime();
            bl6.a aVar2 = a;
            StringBuilder sb = new StringBuilder();
            sb.append("total_play_cost_time=");
            sb.append(j);
            sb.append(" ms, render_audio_page_cost=");
            long j4 = j2 - jumpAudioPageTime;
            sb.append(j4);
            sb.append(" ms");
            aVar2.d(sb.toString(), new Object[0]);
            if (0 < j4 && j4 < 20000) {
                jSONObject.putOpt("render_audio_page_cost", Long.valueOf(j4));
                jSONObject.putOpt("total_play_cost_time_with_audio_page", Long.valueOf((j + j2) - jumpAudioPageTime));
                jSONObject.putOpt("open_audio_page_from", playEventEntity.getOpenAudioPageFrom());
            }
            jSONObject.putOpt("event_list_0", playEventEntity.getEventListOne());
            jSONObject.putOpt("error_type", playEventEntity.getErrorType());
            jSONObject.putOpt("error_code", String.valueOf(playEventEntity.getErrorCode()));
            jSONObject.putOpt("error_info", playEventEntity.getErrorInfo());
            jSONObject.putOpt("end_type", String.valueOf(playEventEntity.getEndType()));
            jSONObject.putOpt("end_t", Long.valueOf(playEventEntity.getEndTime()));
            if (playEventEntity.isFirstPlay()) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            jSONObject.putOpt("is_first_play_after_launch", Integer.valueOf(i5));
            jSONObject.putOpt("is_new_user_first_launch_first_play", Integer.valueOf(playEventEntity.isNewUserFirstLaunchFirstPlay()));
            lk6.b bVar4 = lk6.c.a;
            if (bVar4 != null && (aVar = bVar4.f) != null) {
                aVar.onEvent("play_monitor", jSONObject);
            }
        } catch (Exception e2) {
            a.b("reportPlayMonitor: failed report play monitor, e=" + e2.getMessage(), new Object[0]);
        }
    }

    public final void x(PlayEngineInfo playEngineInfo, TTVideoEngine tTVideoEngine, Resolution resolution) {
        lk6.b bVar;
        gl6.b bVar2;
        PlayAddress playAddress;
        if (i() && (bVar = lk6.c.a) != null && (bVar2 = bVar.k) != null && bVar2.e()) {
            d = tTVideoEngine;
            if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null && playAddress.playType == 2) {
                g.d(new c(playEngineInfo, resolution));
            }
        }
    }

    public final void y(String str, Integer num, String str2) {
        int i;
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null) {
            playEventEntity.setErrorType(str);
        }
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            playEventEntity2.setErrorCode(i);
        }
        PlayEventEntity playEventEntity3 = b;
        if (playEventEntity3 != null) {
            if (str2 == null) {
                str2 = "null";
            }
            playEventEntity3.setErrorInfo(str2);
        }
        p();
    }

    static /* synthetic */ String l(b bVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            lk6.b bVar2 = lk6.c.a;
            str = "";
        }
        return bVar.k(str);
    }

    public final void z(String str, boolean z, String str2, boolean z2, String str3) {
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity = b;
        if (playEventEntity != null) {
            playEventEntity.setInterceptStage(str);
        }
        PlayEventEntity playEventEntity2 = b;
        if (playEventEntity2 != null) {
            playEventEntity2.setHasTip(z);
        }
        PlayEventEntity playEventEntity3 = b;
        if (playEventEntity3 != null) {
            playEventEntity3.setPlayTipName(str2);
        }
        PlayEventEntity playEventEntity4 = b;
        if (playEventEntity4 != null) {
            playEventEntity4.setHasIntercept(z2);
        }
        PlayEventEntity playEventEntity5 = b;
        if (playEventEntity5 != null) {
            playEventEntity5.setInterceptName(str3);
        }
    }

    public final void A(String str, String str2, Integer num, Integer num2, Integer num3, Resolution resolution, int i, float f) {
        int i2;
        String str3;
        PlayEventEntity playEventEntity;
        int i3;
        PlayEventEntity playEventEntity2;
        int i4;
        if (!i()) {
            return;
        }
        PlayEventEntity playEventEntity3 = b;
        if (playEventEntity3 != null) {
            if (str == null) {
                str = "null";
            }
            playEventEntity3.setTag(str);
        }
        PlayEventEntity playEventEntity4 = b;
        if (playEventEntity4 != null) {
            if (str2 == null) {
                str2 = "null";
            }
            playEventEntity4.setSubTag(str2);
        }
        PlayEventEntity playEventEntity5 = b;
        if (playEventEntity5 != null) {
            if (num3 != null) {
                i4 = num3.intValue();
            } else {
                i4 = -1;
            }
            playEventEntity5.setPlayType(i4);
        }
        if (resolution != null && (playEventEntity2 = b) != null) {
            playEventEntity2.setResolution(resolution);
        }
        PlayEventEntity playEventEntity6 = b;
        int i5 = 0;
        if (playEventEntity6 != null) {
            i2 = playEventEntity6.getStartPosition();
        } else {
            i2 = 0;
        }
        if (i2 <= 0 && (playEventEntity = b) != null) {
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            playEventEntity.setStartPosition(i3);
        }
        PlayEventEntity playEventEntity7 = b;
        if (playEventEntity7 != null) {
            if (resolution == null || (str3 = resolution.toString()) == null) {
                str3 = "";
            }
            playEventEntity7.setStartResolution(str3);
        }
        PlayEventEntity playEventEntity8 = b;
        if (playEventEntity8 != null) {
            if (num2 != null) {
                i5 = num2.intValue();
            }
            playEventEntity8.setDuration(i5);
        }
        PlayEventEntity playEventEntity9 = b;
        if (playEventEntity9 != null) {
            playEventEntity9.setVolumeBalanceVersion(i);
        }
        PlayEventEntity playEventEntity10 = b;
        if (playEventEntity10 != null) {
            playEventEntity10.setSourceLoudness(f);
        }
    }
}

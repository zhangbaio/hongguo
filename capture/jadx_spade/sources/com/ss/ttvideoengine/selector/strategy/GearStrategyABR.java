package com.ss.ttvideoengine.selector.strategy;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.abrmodule.ABRResult;
import com.bytedance.vcloud.abrmodule.DefaultABRModule;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.abr.ABRPool;
import com.ss.ttvideoengine.info.HARInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.gracie.GracieSelector;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import rs1.a;
import rs1.c;
import rs1.e;
import rs1.f;
import rs1.g;
import ss1.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class GearStrategyABR {
    static {
        Covode.recordClassIndex(652660);
    }

    GearStrategyABR() {
    }

    private static class GearInput {
        public int abrOnceType;
        public int abrWithSR;
        public final DisplayInfo displayInfo;
        public final ResolutionInfo downgradeResolution;
        public HAR har;
        public final ResolutionInfo mobile4GMaxResolution;
        public NetInfo netInfo;
        public int quickGetFileCache;
        public final SRInput srInput;
        public int startupSpeedType;
        public String subTag;
        public String tag;
        public final ResolutionInfo userExpectedResolution;
        public final ResolutionInfo wifiDefaultResolution;
        public final ResolutionInfo wifiMaxResolution;

        public static class DisplayInfo {
            public int displayHeight;
            public int displayWidth;
            public int screenHeight;
            public int screenWidth;

            static {
                Covode.recordClassIndex(652662);
            }
        }

        private static class HAR {
            public int harScore;
            public int harStatus;

            static {
                Covode.recordClassIndex(652663);
            }

            private HAR() {
            }
        }

        public static class ResolutionInfo {
            public int index;
            public String quality;

            static {
                Covode.recordClassIndex(652665);
            }
        }

        public static class SRInput {
            public Map<Integer, List<Integer>> srBenchmark;
            public SRStrategyConfig srConfig;
            public int srEnabled;
            public int srSatisfied;
            public List<Integer> srSupportBitrateList;

            static {
                Covode.recordClassIndex(652666);
            }
        }

        static {
            Covode.recordClassIndex(652661);
        }

        private static class NetInfo {
            public float avgDownloadSpeed;
            public float avgStartupEndNetworkSpeed;
            public float downloadSpeed;
            public float networkSpeed;
            public float networkSpeedConfidence;
            public int networkState;

            static {
                Covode.recordClassIndex(652664);
            }

            private NetInfo() {
                this.downloadSpeed = 0.0f;
                this.networkSpeed = 0.0f;
                this.networkSpeedConfidence = 0.0f;
                this.avgDownloadSpeed = 0.0f;
                this.avgStartupEndNetworkSpeed = 0.0f;
            }
        }

        private GearInput() {
            this.srInput = new SRInput();
            this.displayInfo = new DisplayInfo();
            this.mobile4GMaxResolution = new ResolutionInfo();
            this.wifiDefaultResolution = new ResolutionInfo();
            this.userExpectedResolution = new ResolutionInfo();
            this.downgradeResolution = new ResolutionInfo();
            this.wifiMaxResolution = new ResolutionInfo();
        }
    }

    private static class GearOutput {
        public long audioBitrate;
        public int downgradeType;
        public GearLogInfo logInfo;
        public long videoBitrate;
        public long videoBitrateOrigin;

        static {
            Covode.recordClassIndex(652667);
        }

        private GearOutput() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized GearLogInfo logInfo() {
            if (this.logInfo == null) {
                this.logInfo = new GearLogInfo();
            }
            return this.logInfo;
        }

        private static class GearLogInfo {
            public String abrSrInfo;
            public String abrStartupInfo;
            public String abrVersion;
            public long bitrateBeforeFitScreen;
            public long maxCacheBitrate;
            public float startupAverageSpeed;
            public float startupPredictSpeed;
            public float startupSpeed;
            public int userEnterFullScreen;
            public float userQualitySensitivity;

            static {
                Covode.recordClassIndex(652668);
            }

            private GearLogInfo() {
            }

            public void recordABRSettingsLog(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.userQualitySensitivity = (float) jSONObject.optDouble("user_quality_sensitivity");
                this.userEnterFullScreen = jSONObject.optInt("user_enter_full_screen");
            }

            public void recordABRModuleLog(g gVar) {
                this.maxCacheBitrate = gVar.getLongOption(15, -1L);
                this.bitrateBeforeFitScreen = gVar.getLongOption(44, -1L);
                this.startupSpeed = gVar.getFloatOption(16, -1.0f);
                this.startupPredictSpeed = gVar.getFloatOption(17, -1.0f);
                this.startupAverageSpeed = gVar.getFloatOption(18, -1.0f);
                this.abrVersion = gVar.getVersion();
                this.abrSrInfo = gVar.k(74, "");
                this.abrStartupInfo = gVar.k(77, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init(Map<String, Object> map) {
            this.videoBitrate = TTHelper.safeGetLong(map, "video_bitrate", 0L);
            this.audioBitrate = TTHelper.safeGetLong(map, "audio_bitrate", 0L);
            this.videoBitrateOrigin = TTHelper.safeGetLong(map, "video_bitrarte_origin", 0L);
            this.downgradeType = TTHelper.safeGetInt(map, "downgrade_type", 0);
        }
    }

    private static class Utils {
        static {
            Covode.recordClassIndex(652669);
        }

        private Utils() {
        }

        public static GearInput.HAR gatheringHARInfo() {
            HARInfo hARInfo = TTVideoEngine.getHARInfo();
            if (hARInfo == null) {
                return null;
            }
            GearInput.HAR har = new GearInput.HAR();
            har.harScore = hARInfo.getHARScore();
            har.harStatus = hARInfo.getHARStatus();
            return har;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String toString(Object obj) {
            return com.ss.ttvideoengine.utils.Utils.toString(obj);
        }

        public static GearInput.NetInfo gatheringSpeedInfo(int i) {
            GearInput.NetInfo netInfo = new GearInput.NetInfo();
            netInfo.networkState = TTNetWorkListener.getInstance().getCurrentAccessType();
            b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            if (bVar != null) {
                Map f = bVar.f(VideoRef.TYPE_VIDEO);
                if (f != null && f.get("download_speed") != null) {
                    netInfo.downloadSpeed = Float.parseFloat((String) f.get("download_speed"));
                }
                netInfo.networkSpeed = bVar.d(0);
                netInfo.networkSpeedConfidence = bVar.a();
                netInfo.avgDownloadSpeed = bVar.c(VideoRef.TYPE_VIDEO, 1, true);
                netInfo.avgStartupEndNetworkSpeed = bVar.c(VideoRef.TYPE_VIDEO, i, false);
            }
            return netInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int checkBitrateIsInSupportedList(GearInput gearInput, int i) {
            List<Integer> list = gearInput.srInput.srSupportBitrateList;
            if (list != null && list.contains(Integer.valueOf(i))) {
                return 1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long calDowngradeBitrate(IVideoModel iVideoModel, GearInput gearInput) {
            if (gearInput.downgradeResolution.index > Resolution.Undefine.getIndex() || !TextUtils.isEmpty(gearInput.downgradeResolution.quality)) {
                GearInput.ResolutionInfo resolutionInfo = gearInput.downgradeResolution;
                if (findVideoInfo(iVideoModel, resolutionInfo.index, resolutionInfo.quality, false) != null) {
                    return r2.getValueInt(3);
                }
            }
            return -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long calUserExpectedBitrate(IVideoModel iVideoModel, GearInput gearInput) {
            if (gearInput.userExpectedResolution.index != Resolution.Auto.getIndex() && (gearInput.userExpectedResolution.index > Resolution.Undefine.getIndex() || !TextUtils.isEmpty(gearInput.userExpectedResolution.quality))) {
                GearInput.ResolutionInfo resolutionInfo = gearInput.userExpectedResolution;
                if (findVideoInfo(iVideoModel, resolutionInfo.index, resolutionInfo.quality, true) != null) {
                    return r2.getValueInt(3);
                }
            }
            return -1L;
        }

        public static void safePut(Map<String, String> map, String str, Object obj) {
            map.put(str, String.valueOf(obj));
        }

        private static VideoInfo findVideoInfo(IVideoModel iVideoModel, int i, String str, boolean z) {
            Resolution resolution;
            HashMap hashMap = null;
            if (i >= 0) {
                resolution = Resolution.valueOf(i);
            } else {
                resolution = null;
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap = new HashMap();
                hashMap.put(32, str);
            }
            return iVideoModel.getVideoInfo(resolution, hashMap, z);
        }

        private static VideoInfo findVideoInfo(VideoModel videoModel, int i, long j, boolean z) {
            for (VideoInfo videoInfo : videoModel.getVideoInfoList()) {
                int mediatype = videoInfo.getMediatype();
                long valueLong = videoInfo.getValueLong(3);
                long valueLong2 = videoInfo.getValueLong(44);
                if (i == mediatype) {
                    if (z) {
                        if (j == valueLong2) {
                            return videoInfo;
                        }
                    } else if (j == valueLong) {
                        return videoInfo;
                    }
                }
            }
            return null;
        }
    }

    static void setGlobalConfig(GearStrategyConfig gearStrategyConfig) {
        c.H(gearStrategyConfig.getIntValue(44));
        c.w(gearStrategyConfig.getIntValue(45));
        c.B(gearStrategyConfig.getIntValue(46));
        c.A(gearStrategyConfig.getFloatValue(47));
        c.C(gearStrategyConfig.getDoubleValue(48));
        c.E(gearStrategyConfig.getDoubleValue(49));
        c.F(gearStrategyConfig.getDoubleValue(50));
        c.D(gearStrategyConfig.getDoubleValue(51));
        c.G(gearStrategyConfig.getIntValue(52));
        c.s(gearStrategyConfig.getStringValue(53));
        c.t(gearStrategyConfig.getStringValue(54));
        c.u(gearStrategyConfig.getStringValue(55));
        boolean z = true;
        if (gearStrategyConfig.getIntValue(56) != 1) {
            z = false;
        }
        ABRPool.setEnabled(z);
    }

    static Map<String, Object> parseABRResult(ABRResult aBRResult) {
        long j;
        long j2;
        long j3;
        HashMap hashMap = new HashMap();
        long j4 = 0;
        if (aBRResult != null) {
            long j5 = 0;
            j2 = 0;
            j3 = 0;
            for (int i = 0; i < aBRResult.b(); i++) {
                e a = aBRResult.a(i);
                long j6 = a.a;
                int i2 = a.c;
                int i3 = a.b;
                if (VideoRef.TYPE_VIDEO == i3) {
                    if (i2 == 0) {
                        j5 = j6;
                    } else if (1 == i2) {
                        j2 = j6;
                    } else if (2 == i2) {
                        j3 = j6;
                    }
                } else if (VideoRef.TYPE_AUDIO == i3) {
                    j4 = j6;
                }
            }
            j = j4;
            j4 = j5;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
        }
        hashMap.put("video_bitrate", Long.valueOf(j4));
        hashMap.put("audio_bitrate", Long.valueOf(j));
        if (j2 > j4) {
            hashMap.put("video_bitrarte_origin", Long.valueOf(j2));
            hashMap.put("downgrade_type", 1);
        } else if (j3 > j4) {
            hashMap.put("video_bitrarte_origin", Long.valueOf(j3));
            hashMap.put("downgrade_type", 2);
        } else {
            hashMap.put("video_bitrarte_origin", Long.valueOf(j4));
            hashMap.put("downgrade_type", 0);
        }
        return hashMap;
    }

    private static GearInput transGearInput(GearStrategyConfig gearStrategyConfig) {
        GearInput gearInput = new GearInput();
        gearInput.abrOnceType = gearStrategyConfig.getIntValue(16);
        gearInput.quickGetFileCache = gearStrategyConfig.getIntValue(23);
        gearInput.abrWithSR = gearStrategyConfig.getIntValue(12);
        gearInput.srInput.srEnabled = gearStrategyConfig.getIntValue(13);
        gearInput.srInput.srSatisfied = gearStrategyConfig.getIntValue(14);
        gearInput.srInput.srBenchmark = (Map) gearStrategyConfig.getObjectValue(15);
        gearInput.srInput.srSupportBitrateList = (List) gearStrategyConfig.getObjectValue(43);
        gearInput.srInput.srConfig = (SRStrategyConfig) gearStrategyConfig.getObjectValue(30);
        gearInput.displayInfo.displayWidth = gearStrategyConfig.getIntValue(26);
        gearInput.displayInfo.displayHeight = gearStrategyConfig.getIntValue(27);
        gearInput.displayInfo.screenWidth = gearStrategyConfig.getIntValue(24);
        gearInput.displayInfo.screenHeight = gearStrategyConfig.getIntValue(25);
        gearInput.startupSpeedType = gearStrategyConfig.getIntValue(9);
        gearInput.mobile4GMaxResolution.index = gearStrategyConfig.getIntValue(19);
        gearInput.mobile4GMaxResolution.quality = gearStrategyConfig.getStringValue(20);
        gearInput.wifiDefaultResolution.index = gearStrategyConfig.getIntValue(17);
        gearInput.wifiDefaultResolution.quality = gearStrategyConfig.getStringValue(18);
        gearInput.userExpectedResolution.index = gearStrategyConfig.getIntValue(5);
        gearInput.userExpectedResolution.quality = gearStrategyConfig.getStringValue(6);
        gearInput.downgradeResolution.index = gearStrategyConfig.getIntValue(7);
        gearInput.downgradeResolution.quality = gearStrategyConfig.getStringValue(8);
        gearInput.wifiMaxResolution.index = gearStrategyConfig.getIntValue(21);
        gearInput.wifiMaxResolution.quality = gearStrategyConfig.getStringValue(22);
        gearInput.netInfo = Utils.gatheringSpeedInfo(gearInput.startupSpeedType);
        gearInput.har = Utils.gatheringHARInfo();
        gearInput.tag = gearStrategyConfig.getStringValue(28);
        gearInput.subTag = gearStrategyConfig.getStringValue(29);
        c.y(gearStrategyConfig.getIntValue(31));
        return gearInput;
    }

    private static void setDisplayInfo(g gVar, GearInput gearInput) {
        gVar.h(34, gearInput.displayInfo.screenWidth);
        gVar.h(35, gearInput.displayInfo.screenHeight);
        gVar.h(6, gearInput.displayInfo.displayWidth);
        gVar.h(7, gearInput.displayInfo.displayHeight);
    }

    private static GearOutput selectPreload(IVideoModel iVideoModel, GearInput gearInput) {
        SRStrategyConfig sRStrategyConfig = gearInput.srInput.srConfig;
        GracieSelector gracieSelector = new GracieSelector(0);
        GracieSelector.Params params = new GracieSelector.Params();
        GearInput.DisplayInfo displayInfo = gearInput.displayInfo;
        GracieSelector.Params displaySize = params.displaySize(displayInfo.displayWidth, displayInfo.displayHeight);
        GearInput.DisplayInfo displayInfo2 = gearInput.displayInfo;
        GracieSelector.Params screenSize = displaySize.screenSize(displayInfo2.screenWidth, displayInfo2.screenHeight);
        GearInput.ResolutionInfo resolutionInfo = gearInput.wifiDefaultResolution;
        GracieSelector.Params wifiDefault = screenSize.wifiDefault(resolutionInfo.index, resolutionInfo.quality);
        GearInput.ResolutionInfo resolutionInfo2 = gearInput.wifiMaxResolution;
        GracieSelector.Params abrMax = wifiDefault.abrMax(resolutionInfo2.index, resolutionInfo2.quality);
        GearInput.ResolutionInfo resolutionInfo3 = gearInput.mobile4GMaxResolution;
        GracieSelector.Params srStrategyConfig = abrMax.cellularMax(resolutionInfo3.index, resolutionInfo3.quality).srStrategyConfig(sRStrategyConfig);
        GearInput.ResolutionInfo resolutionInfo4 = gearInput.downgradeResolution;
        GracieSelector.Params downgrade = srStrategyConfig.downgrade(resolutionInfo4.index, resolutionInfo4.quality);
        GearInput.ResolutionInfo resolutionInfo5 = gearInput.userExpectedResolution;
        Map<String, Object> gearResult = gracieSelector.select(iVideoModel, downgrade.userExpected(resolutionInfo5.index, resolutionInfo5.quality).tags(gearInput.tag, gearInput.subTag).build()).getGearResult();
        GearOutput gearOutput = new GearOutput();
        gearOutput.init(gearResult);
        return gearOutput;
    }

    private static GearOutput selectStartup(IVideoModel iVideoModel, GearInput gearInput) {
        boolean z;
        GearOutput gearOutput = new GearOutput();
        DefaultABRModule fromPreloaded = ABRPool.getInstance().getFromPreloaded(iVideoModel.getVideoRefStr(2));
        if (fromPreloaded == null) {
            fromPreloaded = ABRPool.getInstance().getFromCache();
            if (fromPreloaded == null) {
                fromPreloaded = new DefaultABRModule();
                z = false;
            } else {
                z = true;
            }
            setMediaInfo2Abr(gearInput, fromPreloaded, iVideoModel);
        } else {
            z = true;
        }
        fromPreloaded.i(22, Utils.calUserExpectedBitrate(iVideoModel, gearInput));
        fromPreloaded.i(33, Utils.calDowngradeBitrate(iVideoModel, gearInput));
        setMediaBuffer2Abr(gearInput, fromPreloaded, iVideoModel);
        setDisplayInfo(fromPreloaded, gearInput);
        fromPreloaded.h(14, 1);
        GearInput.NetInfo netInfo = gearInput.netInfo;
        if (netInfo != null) {
            fromPreloaded.m(25, netInfo.downloadSpeed);
            fromPreloaded.m(23, netInfo.networkSpeed);
            fromPreloaded.m(24, netInfo.networkSpeedConfidence);
            fromPreloaded.m(27, netInfo.avgDownloadSpeed);
            fromPreloaded.m(28, netInfo.avgStartupEndNetworkSpeed);
            fromPreloaded.h(21, netInfo.networkState);
        }
        GearInput.HAR har = gearInput.har;
        if (har != null) {
            fromPreloaded.h(70, har.harStatus);
            fromPreloaded.h(71, har.harScore);
        }
        JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("abr_params");
        if (vodJsonObject != null) {
            float optDouble = (float) vodJsonObject.optDouble("user_quality_sensitivity");
            int optInt = vodJsonObject.optInt("user_enter_full_screen");
            fromPreloaded.m(72, optDouble);
            fromPreloaded.h(73, optInt);
            gearOutput.logInfo().recordABRSettingsLog(vodJsonObject);
        }
        GearInput.SRInput sRInput = gearInput.srInput;
        if (gearInput.abrWithSR == 1) {
            fromPreloaded.h(39, sRInput.srEnabled);
            fromPreloaded.h(40, sRInput.srSatisfied);
            fromPreloaded.a(sRInput.srBenchmark);
        }
        fromPreloaded.j(75, gearInput.tag);
        fromPreloaded.j(76, gearInput.subTag);
        gearOutput.init(GearStrategy.parseABRResult(fromPreloaded.g(gearInput.abrOnceType, 1)));
        gearOutput.logInfo().recordABRModuleLog(fromPreloaded);
        if (z) {
            ABRPool.getInstance().giveBack(fromPreloaded);
        } else {
            fromPreloaded.release();
        }
        return gearOutput;
    }

    private static void transGearOutput(Map<String, String> map, GearOutput gearOutput) {
        if (map == null) {
            return;
        }
        Utils.safePut(map, "video_bitrate", Long.valueOf(gearOutput.videoBitrate));
        Utils.safePut(map, "audio_bitrate", Long.valueOf(gearOutput.audioBitrate));
        Utils.safePut(map, "downgrade_type", Integer.valueOf(gearOutput.downgradeType));
        Utils.safePut(map, "video_bitrarte_origin", Long.valueOf(gearOutput.videoBitrateOrigin));
        GearOutput.GearLogInfo gearLogInfo = gearOutput.logInfo;
        if (gearLogInfo != null) {
            Utils.safePut(map, "user_quality_sen", Float.valueOf(gearLogInfo.userQualitySensitivity));
            Utils.safePut(map, "user_enter_fullscreen", Integer.valueOf(gearLogInfo.userEnterFullScreen));
            Utils.safePut(map, "max_cache_bitrate", Long.valueOf(gearLogInfo.maxCacheBitrate));
            Utils.safePut(map, "bitrate_before_fit_screen", Long.valueOf(gearLogInfo.bitrateBeforeFitScreen));
            Utils.safePut(map, "startup_speed", Float.valueOf(gearLogInfo.startupSpeed));
            Utils.safePut(map, "predict_speed", Float.valueOf(gearLogInfo.startupPredictSpeed));
            Utils.safePut(map, "average_speed", Float.valueOf(gearLogInfo.startupAverageSpeed));
            Utils.safePut(map, "abr_ver", gearLogInfo.abrVersion);
            Utils.safePut(map, "sr_info", gearLogInfo.abrSrInfo);
            Utils.safePut(map, "startup_info", gearLogInfo.abrStartupInfo);
        }
    }

    private static void setMediaBuffer2Abr(GearInput gearInput, g gVar, IVideoModel iVideoModel) {
        List<VideoInfo> videoInfoList;
        long cacheFileSize;
        if (iVideoModel != null && (videoInfoList = iVideoModel.getVideoInfoList()) != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null) {
                    String valueStr = videoInfo.getValueStr(15);
                    if (gearInput.quickGetFileCache == 1) {
                        cacheFileSize = TTVideoEngine.quickGetCacheFileSize(valueStr);
                    } else {
                        cacheFileSize = TTVideoEngine.getCacheFileSize(valueStr);
                    }
                    gVar.d(videoInfo.getMediatype(), valueStr, videoInfo.getValueInt(3), cacheFileSize, videoInfo.getValueInt(38));
                }
            }
        }
    }

    private static void setMediaInfo2Abr(GearInput gearInput, g gVar, IVideoModel iVideoModel) {
        HashMap hashMap;
        HashMap hashMap2;
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null) {
                    if (videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                        int valueInt = videoInfo.getValueInt(3);
                        f fVar = new f();
                        String valueStr = videoInfo.getValueStr(15);
                        fVar.a = valueStr;
                        fVar.g = valueInt;
                        fVar.b = videoInfo.getValueStr(8);
                        fVar.j = videoInfo.getValueInt(44);
                        int valueInt2 = videoInfo.getValueInt(1);
                        int valueInt3 = videoInfo.getValueInt(2);
                        fVar.d = valueInt2;
                        fVar.e = valueInt3;
                        fVar.f = -1;
                        fVar.c = 5000;
                        if (!TextUtils.isEmpty(valueStr)) {
                            arrayList.add(fVar);
                        }
                        fVar.h = Utils.checkBitrateIsInSupportedList(gearInput, valueInt);
                        fVar.i = SRStrategy.getResolutionIndex(videoInfo);
                    } else {
                        a aVar = new a();
                        String valueStr2 = videoInfo.getValueStr(15);
                        aVar.a = valueStr2;
                        aVar.e = videoInfo.getValueInt(3);
                        aVar.b = videoInfo.getValueStr(8);
                        aVar.f = videoInfo.getValueInt(44);
                        aVar.d = -1;
                        aVar.c = 5000;
                        if (!TextUtils.isEmpty(valueStr2)) {
                            arrayList2.add(aVar);
                        }
                    }
                }
            }
            gVar.l(arrayList, arrayList2);
            Resolution valueOf = Resolution.valueOf(gearInput.mobile4GMaxResolution.index);
            HashMap hashMap3 = null;
            if (valueOf != null || !TextUtils.isEmpty(gearInput.mobile4GMaxResolution.quality)) {
                if (!TextUtils.isEmpty(gearInput.mobile4GMaxResolution.quality)) {
                    hashMap = new HashMap();
                    hashMap.put(32, gearInput.mobile4GMaxResolution.quality);
                } else {
                    hashMap = null;
                }
                if (iVideoModel.getVideoInfo(valueOf, (Map<Integer, String>) hashMap, true) != null) {
                    gVar.i(2, r3.getValueInt(3));
                }
            }
            Resolution valueOf2 = Resolution.valueOf(gearInput.wifiDefaultResolution.index);
            if (valueOf2 != null || !TextUtils.isEmpty(gearInput.wifiDefaultResolution.quality)) {
                if (!TextUtils.isEmpty(gearInput.wifiDefaultResolution.quality)) {
                    hashMap2 = new HashMap();
                    hashMap2.put(32, gearInput.wifiDefaultResolution.quality);
                } else {
                    hashMap2 = null;
                }
                if (iVideoModel.getVideoInfo(valueOf2, (Map<Integer, String>) hashMap2, true) != null) {
                    gVar.i(12, r3.getValueInt(3));
                }
            }
            Resolution valueOf3 = Resolution.valueOf(gearInput.wifiMaxResolution.index);
            if (valueOf3 != null || !TextUtils.isEmpty(gearInput.wifiMaxResolution.quality)) {
                if (!TextUtils.isEmpty(gearInput.wifiMaxResolution.quality)) {
                    hashMap3 = new HashMap();
                    hashMap3.put(32, gearInput.wifiMaxResolution.quality);
                }
                if (iVideoModel.getVideoInfo(valueOf3, (Map<Integer, String>) hashMap3, true) != null) {
                    gVar.i(13, r0.getValueInt(3));
                }
            }
            gVar.h(66, iVideoModel.getVideoRefInt(3));
            String videoRefStr = iVideoModel.getVideoRefStr(237);
            if (!TextUtils.isEmpty(videoRefStr)) {
                gVar.j(69, videoRefStr);
            }
        }
    }

    static void select(IVideoModel iVideoModel, int i, GearStrategyConfig gearStrategyConfig, Map<String, String> map) {
        GearOutput selectPreload;
        String videoRefStr = iVideoModel.getVideoRefStr(2);
        GearInput transGearInput = transGearInput(gearStrategyConfig);
        if (TTVideoEngineLog.d()) {
            TTVideoEngineLog.d("TTVideoEngine.GearStrategy.ABR", String.format(Locale.getDefault(), "select input %s %d %s", videoRefStr, Integer.valueOf(i), Utils.toString(transGearInput)));
        }
        if (i == 1) {
            selectPreload = selectStartup(iVideoModel, transGearInput);
        } else {
            selectPreload = selectPreload(iVideoModel, transGearInput);
        }
        transGearOutput(map, selectPreload);
        if (TTVideoEngineLog.d()) {
            TTVideoEngineLog.d("TTVideoEngine.GearStrategy.ABR", String.format(Locale.getDefault(), "select output %s %d %s", videoRefStr, Integer.valueOf(i), Utils.toString(selectPreload)));
        }
    }
}

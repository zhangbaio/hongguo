package com.ss.ttvideoengine.selector.strategy;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.abrmodule.ABRResult;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ss1.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class GearStrategy {
    private static GearStrategyConfig mGlobalConfig;
    private static LruCache<String, Map<Long, Map<String, Object>>> mPreloadCache;
    private static Lock mPreloadCacheLock;

    public static GearStrategyConfig getGlobalConfig() {
        return mGlobalConfig;
    }

    static {
        Covode.recordClassIndex(652659);
        mGlobalConfig = new GearStrategyConfig();
        mPreloadCacheLock = new ReentrantLock();
        mPreloadCache = new LruCache<>(100);
    }

    public static Map<String, Object> parseABRResult(ABRResult aBRResult) {
        return GearStrategyABR.parseABRResult(aBRResult);
    }

    public static void setGlobalConfig(GearStrategyConfig gearStrategyConfig) {
        if (gearStrategyConfig == null) {
            return;
        }
        mGlobalConfig = gearStrategyConfig;
        gearStrategyConfig.parse();
        int intValue = mGlobalConfig.getIntValue(1, -1);
        int intValue2 = mGlobalConfig.getIntValue(2, -1);
        if (2 == intValue && 1 == intValue2) {
            GearStrategyABR.setGlobalConfig(gearStrategyConfig);
        }
    }

    public static String getMediaInfoString(IVideoModel iVideoModel, int i) {
        JSONArray mediaInfoJson = getMediaInfoJson(iVideoModel, i);
        if (mediaInfoJson != null) {
            return mediaInfoJson.toString();
        }
        return "";
    }

    public static Map<String, Object> getPreloadInfo(String str, long j) {
        Map<String, Object> map = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        mPreloadCacheLock.lock();
        Map<Long, Map<String, Object>> map2 = mPreloadCache.get(str);
        if (map2 != null) {
            map = map2.get(Long.valueOf(j));
        }
        mPreloadCacheLock.unlock();
        return map;
    }

    public static IVideoInfo getVideoInfo(IVideoModel iVideoModel, long j) {
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (j > 0 && videoInfoList != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && videoInfo.getMediatype() != VideoRef.TYPE_AUDIO && videoInfo.getResolution() != null && videoInfo.getValueInt(3) == j) {
                    return videoInfo;
                }
            }
        }
        return null;
    }

    public static JSONArray getMediaInfoJson(IVideoModel iVideoModel, int i) {
        int i2;
        long cacheFileSize;
        JSONArray jSONArray = new JSONArray();
        if (iVideoModel == null) {
            return jSONArray;
        }
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            try {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null) {
                        JSONObject jSONObject = new JSONObject();
                        if (videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                            jSONObject.put("mtype", videoInfo.getMediatype());
                            jSONObject.put("bitrate", videoInfo.getValueInt(3));
                            Resolution resolution = videoInfo.getResolution();
                            if (resolution != null) {
                                i2 = resolution.getIndex();
                            } else {
                                i2 = -1;
                            }
                            jSONObject.put("res", i2);
                            jSONObject.put("quality", videoInfo.getValueStr(32));
                            jSONObject.put("width", videoInfo.getValueInt(1));
                            jSONObject.put("height", videoInfo.getValueInt(2));
                            if (i != -1) {
                                String valueStr = videoInfo.getValueStr(15);
                                if (1 == i) {
                                    cacheFileSize = TTVideoEngine.quickGetCacheFileSize(valueStr);
                                } else {
                                    cacheFileSize = TTVideoEngine.getCacheFileSize(valueStr);
                                }
                                jSONObject.put("cache", cacheFileSize);
                            }
                        } else {
                            jSONObject.put("mtype", videoInfo.getMediatype());
                            jSONObject.put("bitrate", videoInfo.getValueInt(3));
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    private static void speedInfoToStrategyParam(GearStrategyConfig gearStrategyConfig, Map<String, String> map) {
        float f;
        float f2;
        float f3;
        float f4;
        b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        float f5 = 0.0f;
        if (bVar != null) {
            Map f6 = bVar.f(VideoRef.TYPE_VIDEO);
            if (f6 != null && f6.get("download_speed") != null) {
                f5 = Float.parseFloat((String) f6.get("download_speed"));
            }
            f2 = StrategyCenter.sNetAbrSpeedPredictor.d(0);
            f3 = StrategyCenter.sNetAbrSpeedPredictor.a();
            f4 = StrategyCenter.sNetAbrSpeedPredictor.c(VideoRef.TYPE_VIDEO, 1, true);
            f = StrategyCenter.sNetAbrSpeedPredictor.c(VideoRef.TYPE_VIDEO, gearStrategyConfig.getIntValue(9, 4), false);
        } else {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
        }
        map.put(Integer.toString(36), Float.toString(f5));
        map.put(Integer.toString(37), Float.toString(f2));
        map.put(Integer.toString(38), Float.toString(f3));
        map.put(Integer.toString(39), Float.toString(f4));
        map.put(Integer.toString(40), Float.toString(f));
    }

    private static void srInfoToStrategyParam(GearStrategyConfig gearStrategyConfig, Map<String, String> map) {
        configIntToStrategyParam(gearStrategyConfig, 13, map, 0);
        configIntToStrategyParam(gearStrategyConfig, 14, map, 0);
        Object objectValue = gearStrategyConfig.getObjectValue(15, null);
        if (objectValue != null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) objectValue).entrySet()) {
                JSONArray jSONArray = new JSONArray();
                Object value = entry.getValue();
                if (value != null && (value instanceof List)) {
                    Iterator it2 = ((List) value).iterator();
                    while (it2.hasNext()) {
                        jSONArray.put(((Integer) it2.next()).toString());
                    }
                }
                try {
                    jSONObject.put(((Integer) entry.getKey()).toString(), jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            map.put(Integer.toString(15), jSONObject.toString());
        }
        Object objectValue2 = gearStrategyConfig.getObjectValue(43, null);
        if (objectValue2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            Iterator it4 = ((List) objectValue2).iterator();
            while (it4.hasNext()) {
                jSONArray2.put((Integer) it4.next());
            }
            try {
                jSONObject2.put("bitrates", jSONArray2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            map.put(Integer.toString(43), jSONObject2.toString());
        }
    }

    public static int intMapGet(Map<String, Integer> map, String str, int i) {
        Integer num = map.get(str);
        if (num != null) {
            return num.intValue();
        }
        return i;
    }

    public static float stringMapGetFloat(Map<String, String> map, String str, float f) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                return Float.parseFloat(str2);
            } catch (NumberFormatException unused) {
                return f;
            }
        }
        return f;
    }

    public static int stringMapGetInt(Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                return Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public static long stringMapGetLong(Map<String, String> map, String str, long j) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                return Long.parseLong(str2);
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    public static String stringMapGetString(Map<String, String> map, String str, String str2) {
        String str3 = map.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public static void setPreloadInfo(String str, long j, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            mPreloadCacheLock.lock();
            Map<Long, Map<String, Object>> map2 = mPreloadCache.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                mPreloadCache.put(str, map2);
            }
            map2.put(Long.valueOf(j), map);
            mPreloadCacheLock.unlock();
        }
    }

    private static void cacheInfoToStrategyParam(IVideoModel iVideoModel, GearStrategyConfig gearStrategyConfig, Map<String, String> map) {
        long cacheFileSize;
        int intValue = gearStrategyConfig.getIntValue(23);
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null) {
                        String valueStr = videoInfo.getValueStr(15);
                        if (intValue == 1) {
                            cacheFileSize = TTVideoEngine.quickGetCacheFileSize(valueStr);
                        } else {
                            cacheFileSize = TTVideoEngine.getCacheFileSize(valueStr);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bitrate", videoInfo.getValueInt(3));
                        jSONObject2.put("fileSize", cacheFileSize);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("caches", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            map.put(Integer.toString(57), jSONObject.toString());
        }
    }

    public static void getSrSupportBitrate(IVideoModel iVideoModel, SRStrategy sRStrategy, GearStrategyConfig gearStrategyConfig) {
        LinkedList linkedList = new LinkedList();
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() > 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                    int valueInt = videoInfo.getValueInt(3);
                    if (sRStrategy.videoInfoSupportSR(videoInfo, videoInfoList).booleanValue()) {
                        linkedList.add(Integer.valueOf(valueInt));
                    }
                }
            }
        }
        gearStrategyConfig.setObjectValueIfNotExist(43, linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.ss.ttvideoengine.model.IVideoInfo getVideoInfoByBitrate(com.ss.ttvideoengine.model.IVideoModel r7, int r8, int r9) {
        /*
            java.util.List r7 = r7.getVideoInfoList()
            if (r7 == 0) goto L48
            java.util.Iterator r7 = r7.iterator()
        La:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L48
            java.lang.Object r0 = r7.next()
            com.ss.ttvideoengine.model.VideoInfo r0 = (com.ss.ttvideoengine.model.VideoInfo) r0
            if (r0 == 0) goto La
            int r1 = r0.getMediatype()
            int r2 = com.ss.ttvideoengine.model.VideoRef.TYPE_AUDIO
            if (r1 == r2) goto La
            com.ss.ttvideoengine.Resolution r1 = r0.getResolution()
            if (r1 != 0) goto L27
            goto La
        L27:
            r1 = 1
            r2 = 3
            if (r1 != r9) goto L3d
            r1 = 44
            int r1 = r0.getValueInt(r1)
            long r3 = (long) r1
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 > 0) goto L42
            int r1 = r0.getValueInt(r2)
            goto L41
        L3d:
            int r1 = r0.getValueInt(r2)
        L41:
            long r3 = (long) r1
        L42:
            long r1 = (long) r8
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto La
            goto L49
        L48:
            r0 = 0
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.selector.strategy.GearStrategy.getVideoInfoByBitrate(com.ss.ttvideoengine.model.IVideoModel, int, int):com.ss.ttvideoengine.model.IVideoInfo");
    }

    private static void checkSRInfo(IVideoModel iVideoModel, GearStrategyConfig gearStrategyConfig, Map<String, Object> map) {
        int i;
        Object objectValue = gearStrategyConfig.getObjectValue(30, null);
        if (objectValue != null && (objectValue instanceof SRStrategyConfig)) {
            SRStrategyConfig sRStrategyConfig = (SRStrategyConfig) objectValue;
            SRStrategy sRStrategy = new SRStrategy();
            boolean z = false;
            if (iVideoModel.hasFormat(IVideoModel.Format.DASH)) {
                i = 2;
            } else {
                i = 0;
            }
            if (iVideoModel.hasFormat(IVideoModel.Format.MP4)) {
                i |= 1;
            }
            sRStrategyConfig.setCurrentVideoFormatType(i);
            sRStrategyConfig.setCurrentDuration(iVideoModel.getVideoRefInt(3));
            List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
            if (videoInfoList != null && videoInfoList.size() > 0) {
                Iterator<VideoInfo> it2 = videoInfoList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String valueStr = it2.next().getValueStr(7);
                    if (valueStr != null && valueStr.toLowerCase(Locale.getDefault()).contains("hdr")) {
                        z = true;
                        break;
                    }
                }
            }
            sRStrategyConfig.setIsHdr(z);
            sRStrategy.updateConfig(sRStrategyConfig);
            gearStrategyConfig.setIntValue(13, sRStrategy.isSREnabled() ? 1 : 0);
            gearStrategyConfig.setIntValue(14, sRStrategy.isSRSatisfied() ? 1 : 0);
            gearStrategyConfig.setObjectValue(15, sRStrategy.getSRBenchmark());
            getSrSupportBitrate(iVideoModel, sRStrategy, gearStrategyConfig);
            map.put("ess", 1);
            map.put("eas", 1);
            map.put("sfr", Integer.valueOf(sRStrategy.getSRNotUseReason()));
            map.put("srs", Integer.valueOf(sRStrategy.isSRSatisfied() ? 1 : 0));
        }
    }

    private static void setPreloadInfo(IVideoModel iVideoModel, GearStrategyConfig gearStrategyConfig, Map<String, String> map) {
        String videoRefStr = iVideoModel.getVideoRefStr(2);
        HashMap hashMap = new HashMap();
        hashMap.put("sw", Integer.valueOf(gearStrategyConfig.getIntValue(24, -1)));
        hashMap.put("sh", Integer.valueOf(gearStrategyConfig.getIntValue(25, -1)));
        hashMap.put("dw", Integer.valueOf(gearStrategyConfig.getIntValue(26, -1)));
        hashMap.put("dh", Integer.valueOf(gearStrategyConfig.getIntValue(27, -1)));
        hashMap.put("ue", Integer.valueOf(gearStrategyConfig.getIntValue(34, -1)));
        hashMap.put("ud", Integer.valueOf(gearStrategyConfig.getIntValue(35, -1)));
        hashMap.put("ns", Integer.valueOf(TTNetWorkListener.getInstance().getCurrentAccessType()));
        hashMap.put("vbitrateo", Integer.valueOf(stringMapGetInt(map, "video_bitrarte_origin", -1)));
        int stringMapGetInt = stringMapGetInt(map, "video_bitrate", -1);
        hashMap.put("vbitrate", Integer.valueOf(stringMapGetInt));
        hashMap.put("downgrade", Integer.valueOf(stringMapGetInt(map, "downgrade_type", -1)));
        JSONArray mediaInfoJson = getMediaInfoJson(iVideoModel, -1);
        if (mediaInfoJson != null) {
            hashMap.put("minfo", mediaInfoJson);
        }
        setPreloadInfo(videoRefStr, stringMapGetInt, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea A[EDGE_INSN: B:48:0x00ea->B:49:0x00ea BREAK  A[LOOP:0: B:26:0x00a2->B:47:0x00a2], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.ss.ttvideoengine.selector.SelectedInfo selectBitrate(com.ss.ttvideoengine.model.IVideoModel r17, int r18, java.util.Map<java.lang.String, java.lang.String> r19) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.selector.strategy.GearStrategy.selectBitrate(com.ss.ttvideoengine.model.IVideoModel, int, java.util.Map):com.ss.ttvideoengine.selector.SelectedInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x036b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> select(com.ss.ttvideoengine.model.IVideoModel r21, int r22, com.ss.ttvideoengine.selector.strategy.GearStrategyConfig r23) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.selector.strategy.GearStrategy.select(com.ss.ttvideoengine.model.IVideoModel, int, com.ss.ttvideoengine.selector.strategy.GearStrategyConfig):java.util.Map");
    }

    private static void configIntToStrategyParam(GearStrategyConfig gearStrategyConfig, int i, Map<String, String> map, int i2) {
        map.put(Integer.toString(i), Integer.toString(gearStrategyConfig.getIntValue(i, i2)));
    }

    private static void configStringToStrategyParam(GearStrategyConfig gearStrategyConfig, int i, Map<String, String> map, String str) {
        map.put(Integer.toString(i), gearStrategyConfig.getStringValue(i, str));
    }

    public static int getBitrateFromVideoModel(IVideoModel iVideoModel, int i, String str, int i2) {
        Resolution valueOf = Resolution.valueOf(i);
        if (valueOf != Resolution.Undefine || !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(32, str);
            VideoInfo videoInfo = iVideoModel.getVideoInfo(valueOf, (Map<Integer, String>) hashMap, false);
            if (videoInfo != null) {
                if (1 == i2) {
                    return videoInfo.getValueInt(44);
                }
                return videoInfo.getValueInt(3);
            }
        }
        return -1;
    }
}

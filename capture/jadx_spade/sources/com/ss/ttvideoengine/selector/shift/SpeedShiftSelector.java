package com.ss.ttvideoengine.selector.shift;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.SelectedInfo;
import com.ss.ttvideoengine.selector.Selector;
import com.ss.ttvideoengine.selector.strategy.GearStrategyContext;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SpeedShiftSelector implements Selector {
    protected IAutoBitrateSet autoBitrateSet;
    protected List<? extends IBandwidthSet> bandwidthSets;
    protected final IGearConfig gearConfig;
    protected List<? extends IGearSet> gearSets;
    private Shift[] mShifts;

    static {
        Covode.recordClassIndex(652657);
    }

    public static class Params {
        private double mSpeed;

        static {
            Covode.recordClassIndex(652658);
        }

        public Map<Integer, Object> build() {
            HashMap hashMap = new HashMap();
            hashMap.put(1, Double.valueOf(this.mSpeed));
            return hashMap;
        }

        public Params speed(double d) {
            this.mSpeed = d;
            return this;
        }
    }

    public SpeedShiftSelector(SpeedShiftConfig speedShiftConfig) {
        if (speedShiftConfig != null) {
            this.gearConfig = speedShiftConfig.getIGearConfig();
            this.gearSets = speedShiftConfig.getIGearSets();
            this.bandwidthSets = speedShiftConfig.getIBandwidthSets();
            this.autoBitrateSet = speedShiftConfig.getIAutoBitrateSet();
        } else {
            this.gearConfig = null;
        }
        initShifts(this.gearSets);
    }

    private BitrateInfo calculateBitrateInfoByGearSet(double d) {
        Shift[] shiftArr;
        if (d > 0.0d && (shiftArr = this.mShifts) != null) {
            double d2 = Double.MAX_VALUE;
            Shift shift = null;
            for (Shift shift2 : shiftArr) {
                double abs = Math.abs(shift2.getMedianThreshold() - d);
                if (abs < d2) {
                    shift = shift2;
                    d2 = abs;
                }
            }
            if (shift != null) {
                return new BitrateInfo(shift.mRate, false);
            }
        }
        return null;
    }

    private BitrateInfo calculateBitrateInfoByAutoBitrateSet(double d) {
        IAutoBitrateSet iAutoBitrateSet;
        if (d > 0.0d && (iAutoBitrateSet = this.autoBitrateSet) != null) {
            return new BitrateInfo(Math.max((iAutoBitrateSet.getFirstParam() * d * d * d) + (this.autoBitrateSet.getSecondParam() * d * d) + (this.autoBitrateSet.getThirdParam() * d) + this.autoBitrateSet.getFourthParam(), this.autoBitrateSet.getMinBitrate()), true);
        }
        return null;
    }

    private BitrateInfo calculateBitrateInfoByBandwidthSet(double d) {
        List<? extends IBandwidthSet> list;
        IBandwidthSet iBandwidthSet;
        if (d <= 0.0d || (list = this.bandwidthSets) == null || list.size() == 0) {
            return null;
        }
        Iterator<? extends IBandwidthSet> it2 = this.bandwidthSets.iterator();
        while (true) {
            if (it2.hasNext()) {
                iBandwidthSet = it2.next();
                if (iBandwidthSet != null && d <= iBandwidthSet.getSpeed()) {
                    break;
                }
            } else {
                iBandwidthSet = null;
                break;
            }
        }
        if (iBandwidthSet == null) {
            List<? extends IBandwidthSet> list2 = this.bandwidthSets;
            iBandwidthSet = list2.get(list2.size() - 1);
        }
        if (iBandwidthSet == null) {
            return null;
        }
        return new BitrateInfo(iBandwidthSet.getBitrate(), true);
    }

    private void initShifts(List<? extends IGearSet> list) {
        if (list != null && !list.isEmpty()) {
            this.mShifts = new Shift[list.size()];
            for (int i = 0; i < list.size(); i++) {
                IGearSet iGearSet = list.get(i);
                this.mShifts[i] = new Shift(iGearSet.getBitRate(), iGearSet.getNetworkLower() * 8000.0d, 8000.0d * iGearSet.getNetworkUpper());
            }
        }
    }

    protected <T extends IVideoInfo> T getDefaultBitrate(List<T> list) throws BitrateNotMatchException {
        String defaultGearName = this.gearConfig.getDefaultGearName();
        double defaultBitrate = this.gearConfig.getDefaultBitrate();
        if (defaultBitrate <= 0.0d) {
            for (T t : list) {
                if (TextUtils.equals(t.getValueStr(7), defaultGearName)) {
                    return t;
                }
            }
            throw new BitrateNotMatchException(4, "defaultGearName = " + defaultGearName + " bitrates = " + list.toString());
        }
        T t2 = null;
        double d = Double.MAX_VALUE;
        for (T t3 : list) {
            double abs = Math.abs(t3.getValueInt(3) - defaultBitrate);
            if (d > abs) {
                t2 = t3;
                d = abs;
            }
        }
        return t2;
    }

    protected <T extends IVideoInfo> List<T> filter(List<T> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (this.gearConfig != null && !list.isEmpty()) {
            Pair<Double, Double> bitrateInterval = this.gearConfig.getBitrateInterval();
            Set<String> gearGroup = this.gearConfig.getGearGroup();
            if (bitrateInterval != null && this.gearConfig.getDefaultBitrate() > 0.0d) {
                z = true;
            } else {
                z = false;
            }
            for (T t : list) {
                if (z) {
                    double valueInt = t.getValueInt(3);
                    if (valueInt >= ((Double) bitrateInterval.first).doubleValue() && valueInt <= ((Double) bitrateInterval.second).doubleValue()) {
                        arrayList.add(t);
                    }
                } else if (gearGroup != null && gearGroup.contains(t.getValueStr(7))) {
                    arrayList.add(t);
                }
            }
            if (arrayList.isEmpty()) {
                if (z) {
                    T t2 = null;
                    for (T t3 : list) {
                        if (t2 == null || Math.abs(t3.getValueInt(3) - this.gearConfig.getDefaultBitrate()) < Math.abs(t2.getValueInt(3) - this.gearConfig.getDefaultBitrate())) {
                            t2 = t3;
                        }
                    }
                    arrayList.add(t2);
                } else {
                    arrayList.add(list.get(0));
                }
            }
        }
        return arrayList;
    }

    private <T extends IVideoInfo> T findBitRate(BitrateInfo bitrateInfo, List<T> list) throws BitrateNotMatchException {
        if (bitrateInfo == null) {
            if (this.gearConfig != null) {
                return (T) getDefaultBitrate(list);
            }
            throw new BitrateNotMatchException(6, "gear config is null");
        }
        List<T> filter = filter(list);
        if (filter != null && !filter.isEmpty()) {
            if (bitrateInfo.maxBitrate) {
                return (T) findMaxBitrate(bitrateInfo.bitrate, filter);
            }
            return (T) findNearestBitrate(bitrateInfo.bitrate, filter);
        }
        throw new BitrateNotMatchException(5, "Intersection bitrate list is empty.");
    }

    private <T extends IVideoInfo> T findMaxBitrate(double d, List<T> list) {
        T t = null;
        if (list != null) {
            for (T t2 : list) {
                if (t != null) {
                    if (t.getValueInt(3) > d) {
                        if (t2.getValueInt(3) < t.getValueInt(3)) {
                        }
                    } else if (d >= t2.getValueInt(3) && t2.getValueInt(3) >= t.getValueInt(3)) {
                    }
                }
                t = t2;
            }
        }
        return t;
    }

    private <T extends IVideoInfo> T findNearestBitrate(double d, List<T> list) {
        T t = null;
        if (list != null) {
            for (T t2 : list) {
                if (t == null || Math.abs(t2.getValueInt(3) - d) < Math.abs(t.getValueInt(3) - d)) {
                    t = t2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(12:14|15|16|(1:18)(2:32|(1:34)(1:35))|19|20|21|22|(1:24)|25|(1:27)|28)|39|16|(0)(0)|19|20|21|22|(0)|25|(0)|28) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        r4 = new com.ss.ttvideoengine.utils.Error("kTTVideoSelector", -7998, r2.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.ttvideoengine.selector.SelectedInfo select(java.util.List<? extends com.ss.ttvideoengine.model.IVideoInfo> r7, java.util.Map<java.lang.Integer, java.lang.Object> r8) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto Lc
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto Lc
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            java.lang.String r3 = "kTTVideoSelector"
            if (r2 != 0) goto L20
            com.ss.ttvideoengine.utils.Error r7 = new com.ss.ttvideoengine.utils.Error
            r8 = -7999(0xffffffffffffe0c1, float:NaN)
            java.lang.String r0 = "bitrate list is empty..."
            r7.<init>(r3, r8, r0)
            com.ss.ttvideoengine.selector.SelectedInfo r8 = new com.ss.ttvideoengine.selector.SelectedInfo
            r8.<init>(r7)
            return r8
        L20:
            if (r8 == 0) goto L3d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r8 = r8.get(r0)
            if (r8 == 0) goto L3d
            java.lang.Double r8 = (java.lang.Double) r8     // Catch: java.lang.ClassCastException -> L33
            double r4 = r8.doubleValue()     // Catch: java.lang.ClassCastException -> L33
            goto L3f
        L33:
            r8 = move-exception
            java.lang.String r0 = "Selector"
            java.lang.String r8 = r8.getMessage()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r0, r8)
        L3d:
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L3f:
            com.ss.ttvideoengine.selector.shift.IAutoBitrateSet r8 = r6.autoBitrateSet
            if (r8 == 0) goto L48
            com.ss.ttvideoengine.selector.shift.BitrateInfo r8 = r6.calculateBitrateInfoByAutoBitrateSet(r4)
            goto L55
        L48:
            java.util.List<? extends com.ss.ttvideoengine.selector.shift.IBandwidthSet> r8 = r6.bandwidthSets
            if (r8 == 0) goto L51
            com.ss.ttvideoengine.selector.shift.BitrateInfo r8 = r6.calculateBitrateInfoByBandwidthSet(r4)
            goto L55
        L51:
            com.ss.ttvideoengine.selector.shift.BitrateInfo r8 = r6.calculateBitrateInfoByGearSet(r4)
        L55:
            r0 = 0
            com.ss.ttvideoengine.model.IVideoInfo r2 = r6.findBitRate(r8, r7)     // Catch: com.ss.ttvideoengine.selector.shift.BitrateNotMatchException -> L5d
            r4 = r0
            r0 = r2
            goto L69
        L5d:
            r2 = move-exception
            com.ss.ttvideoengine.utils.Error r4 = new com.ss.ttvideoengine.utils.Error
            r5 = -7998(0xffffffffffffe0c2, float:NaN)
            java.lang.String r2 = r2.getMessage()
            r4.<init>(r3, r5, r2)
        L69:
            if (r0 != 0) goto L72
            java.lang.Object r7 = r7.get(r1)
            r0 = r7
            com.ss.ttvideoengine.model.IVideoInfo r0 = (com.ss.ttvideoengine.model.IVideoInfo) r0
        L72:
            com.ss.ttvideoengine.selector.SelectedInfo r7 = new com.ss.ttvideoengine.selector.SelectedInfo
            r7.<init>(r0, r4)
            if (r8 == 0) goto L7e
            double r2 = r8.bitrate
            r7.setDoubleValue(r1, r2)
        L7e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.selector.shift.SpeedShiftSelector.select(java.util.List, java.util.Map):com.ss.ttvideoengine.selector.SelectedInfo");
    }

    @Override // com.ss.ttvideoengine.selector.Selector
    public SelectedInfo select(IVideoModel iVideoModel, Map<Integer, Object> map) {
        Error error;
        double d;
        VideoInfo videoInfo;
        VideoInfo videoInfo2;
        Error error2;
        if (iVideoModel == null) {
            return new SelectedInfo(new Error("kTTVideoSelector", -7999, "null video model"));
        }
        if (StrategyHelper.helper().moduleSwitch(804) != 0) {
            TTVideoEngineLog.i("Selector", "[GearStrategy] SpeedShiftSelector native select enabled");
            HashMap hashMap = new HashMap();
            GearStrategyContext gearStrategyContext = new GearStrategyContext(null);
            gearStrategyContext.setVideoModel(iVideoModel);
            gearStrategyContext.setGearStrategyListener(new IGearStrategyListener() { // from class: com.ss.ttvideoengine.selector.shift.SpeedShiftSelector.1
                @Override // com.ss.ttvideoengine.selector.strategy.IGearStrategyListener
                public void onBeforeSelect(IVideoModel iVideoModel2, Map<String, String> map2, int i, Object obj) {
                }

                @Override // com.ss.ttvideoengine.selector.strategy.IGearStrategyListener
                public /* synthetic */ Map selectBitrate(IVideoModel iVideoModel2, Map map2, int i) {
                    return IGearStrategyListener.CC.$default$selectBitrate(this, iVideoModel2, map2, i);
                }

                @Override // com.ss.ttvideoengine.selector.strategy.IGearStrategyListener
                public void onAfterSelect(IVideoModel iVideoModel2, Map<String, String> map2, int i, Object obj) {
                    ((Map) obj).putAll(map2);
                }
            });
            gearStrategyContext.setUserData(hashMap);
            Map<String, Integer> selectResolution = StrategyHelper.helper().selectResolution(iVideoModel, 1, hashMap, gearStrategyContext);
            String str = (String) hashMap.get("error_desc");
            int i = 0;
            if (str != null && !str.isEmpty()) {
                try {
                    i = Integer.parseInt((String) hashMap.get("error_code"));
                } catch (Exception unused) {
                }
                return new SelectedInfo(new Error("kTTVideoSelector", i, str));
            }
            if (selectResolution != null) {
                int intValue = selectResolution.get("video").intValue();
                try {
                    d = Double.parseDouble((String) hashMap.get("video_calc_bitrate"));
                } catch (Exception unused2) {
                    d = 0.0d;
                }
                List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
                if (intValue > 0 && videoInfoList != null) {
                    new HashMap();
                    Iterator<VideoInfo> it2 = videoInfoList.iterator();
                    while (it2.hasNext()) {
                        videoInfo2 = it2.next();
                        if (videoInfo2 != null && videoInfo2.getMediatype() != VideoRef.TYPE_AUDIO && videoInfo2.getResolution() != null && videoInfo2.getValueInt(3) == intValue) {
                            break;
                        }
                    }
                }
                videoInfo2 = null;
                if (videoInfo2 == null) {
                    error2 = new Error("kTTVideoSelector", -7999, "null video info fit bitrate");
                } else {
                    error2 = null;
                }
                error = error2;
                videoInfo = videoInfo2;
            } else {
                error = new Error("kTTVideoSelector", -7997, "native select result null");
                d = 0.0d;
                videoInfo = null;
            }
            SelectedInfo selectedInfo = new SelectedInfo(videoInfo, error);
            if (d > 0.0d) {
                selectedInfo.setDoubleValue(0, d);
            }
            return selectedInfo;
        }
        TTVideoEngineLog.i("Selector", "[GearStrategy] SpeedShiftSelector native select disabled");
        return select(iVideoModel.getVideoInfoList(), map);
    }
}

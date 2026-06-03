package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.info.networkRTTLevelListener;
import com.ss.ttvideoengine.portrait.IPortrait;
import com.ss.ttvideoengine.portrait.NetworkPortraitData;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PortraitNetworkScore implements IPortrait {
    private static PortraitNetworkScore mInstance;
    private static double mLastTargetBitrate;
    private NetworkQualityAlgorithm mQualityAlg = null;
    private final NetworkPortraitData mPortraitData = new NetworkPortraitData();

    public interface NetworkQualityAlgorithm {
        double calculateTargetBitrate(List<Integer> list, List<Float> list2);

        int getLastNetworkScore();

        int getNetworkScore();

        void init();

        void setStringOption(int i, String str);
    }

    @Override // com.ss.ttvideoengine.portrait.IPortrait
    public int getId() {
        return 1;
    }

    public double getLastTargetBitrate() {
        return mLastTargetBitrate;
    }

    public NetworkPortraitData getPortraitData() {
        return this.mPortraitData;
    }

    private class NetworkQualityAlgorithmV1 implements NetworkQualityAlgorithm {
        private Map<String, Double> mRttCodeMap = null;
        private Map<String, Double> mSigCodeMap = null;
        private Map<String, Integer> mLevelCodeMap = null;
        private int mLastNetworkScore = -1;

        static {
            Covode.recordClassIndex(652481);
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public double calculateTargetBitrate(List<Integer> list, List<Float> list2) {
            return -1.0d;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getNetworkScore() {
            calculateNetworkScore();
            return this.mLastNetworkScore;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getLastNetworkScore() {
            if (this.mLastNetworkScore == -1) {
                calculateNetworkScore();
            }
            return this.mLastNetworkScore;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void init() {
            setDefaultRttMap();
            setDefaultSigMap();
            setDefaultLevelMap();
        }

        private void setDefaultRttMap() {
            HashMap hashMap = new HashMap();
            this.mRttCodeMap = hashMap;
            hashMap.put("-1", Double.valueOf(1.8d));
            this.mRttCodeMap.put("2", Double.valueOf(93.0d));
            this.mRttCodeMap.put("3", Double.valueOf(70.0d));
            this.mRttCodeMap.put("4", Double.valueOf(26.0d));
            this.mRttCodeMap.put("5", Double.valueOf(12.0d));
            this.mRttCodeMap.put("6", Double.valueOf(7.0d));
            this.mRttCodeMap.put("7", Double.valueOf(2.0d));
            this.mRttCodeMap.put("8", Double.valueOf(1.0d));
        }

        private void setDefaultSigMap() {
            HashMap hashMap = new HashMap();
            this.mSigCodeMap = hashMap;
            hashMap.put("excellent", Double.valueOf(1.0d));
            this.mSigCodeMap.put("good", Double.valueOf(2.4d));
            this.mSigCodeMap.put("unknown", Double.valueOf(5.4d));
            this.mSigCodeMap.put("medium", Double.valueOf(7.6d));
            this.mSigCodeMap.put("weak", Double.valueOf(20.6d));
            this.mSigCodeMap.put("unavailable", Double.valueOf(36.0d));
        }

        private void setDefaultLevelMap() {
            HashMap hashMap = new HashMap();
            this.mLevelCodeMap = hashMap;
            hashMap.put("1_1", 0);
            this.mLevelCodeMap.put("1_2", 1);
            this.mLevelCodeMap.put("1_3", 2);
            this.mLevelCodeMap.put("2_1", 3);
            this.mLevelCodeMap.put("2_2", 4);
            this.mLevelCodeMap.put("1_4", 5);
            this.mLevelCodeMap.put("2_3", 6);
            this.mLevelCodeMap.put("3_1", 7);
            this.mLevelCodeMap.put("3_2", 8);
            this.mLevelCodeMap.put("3_3", 9);
            this.mLevelCodeMap.put("2_4", 10);
            this.mLevelCodeMap.put("3_4", 11);
            this.mLevelCodeMap.put("4_1", 12);
            this.mLevelCodeMap.put("4_2", 13);
            this.mLevelCodeMap.put("4_3", 14);
            this.mLevelCodeMap.put("4_4", 15);
        }

        public void calculateNetworkScore() {
            int i;
            double d;
            double d2;
            List<Integer> rttList = PortraitNetworkScore.this.mPortraitData.getRttList();
            List<String> signalStrengthList = PortraitNetworkScore.this.mPortraitData.getSignalStrengthList();
            if (this.mRttCodeMap != null && this.mSigCodeMap != null && this.mLevelCodeMap != null && rttList != null && signalStrengthList != null && !rttList.isEmpty() && !signalStrengthList.isEmpty()) {
                int size = rttList.size();
                double d3 = 0.0d;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        String valueOf = String.valueOf(rttList.get(i2).intValue());
                        if (this.mRttCodeMap.containsKey(valueOf)) {
                            d2 = this.mRttCodeMap.get(valueOf).doubleValue();
                        } else {
                            d2 = 0.0d;
                        }
                        d3 += d2;
                    } catch (Exception e) {
                        TTVideoEngineLog.e("PortraitNetworkScore", e.toString());
                    }
                }
                d3 /= size;
                if (d3 < 1.0d) {
                    return;
                }
                int size2 = signalStrengthList.size();
                double d4 = 0.0d;
                for (int i3 = 0; i3 < size2; i3++) {
                    try {
                        String str = signalStrengthList.get(i3);
                        if (str != null) {
                            if (this.mSigCodeMap.containsKey(str)) {
                                d = this.mSigCodeMap.get(str).doubleValue();
                            } else {
                                d = 0.0d;
                            }
                            d4 += d;
                        }
                    } catch (Exception e2) {
                        TTVideoEngineLog.e("PortraitNetworkScore", e2.toString());
                    }
                }
                d4 /= size2;
                if (d4 < 1.0d) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (d3 <= 2.0d) {
                    sb.append('1');
                } else if (d3 <= 11.0d) {
                    sb.append('2');
                } else if (d3 <= 26.0d) {
                    sb.append('3');
                } else {
                    sb.append('4');
                }
                sb.append('_');
                if (d4 == 1.0d) {
                    sb.append('1');
                } else if (d4 <= 3.0d) {
                    sb.append('2');
                } else if (d4 <= 7.0d) {
                    sb.append('3');
                } else {
                    sb.append('4');
                }
                String sb2 = sb.toString();
                if (this.mLevelCodeMap.containsKey(sb2)) {
                    i = this.mLevelCodeMap.get(sb2).intValue();
                } else {
                    i = -1;
                }
                this.mLastNetworkScore = i;
                TTVideoEngineLog.d("PortraitNetworkScore", "rtt score:" + d3 + " sig score:" + d4 + " level:" + sb2);
            }
        }

        public NetworkQualityAlgorithmV1() {
            init();
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void setStringOption(int i, String str) {
            if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        try {
                            this.mLevelCodeMap = _jsonStringToMap(str, true);
                            return;
                        } catch (Exception unused) {
                            setDefaultLevelMap();
                            return;
                        }
                    }
                    return;
                }
                try {
                    this.mSigCodeMap = _jsonStringToMap(str, false);
                    return;
                } catch (Exception unused2) {
                    setDefaultSigMap();
                    return;
                }
            }
            try {
                this.mRttCodeMap = _jsonStringToMap(str, false);
            } catch (Exception unused3) {
                setDefaultRttMap();
            }
        }

        private Map _jsonStringToMap(String str, boolean z) throws Exception {
            HashMap hashMap;
            try {
                if (z) {
                    hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, Integer.valueOf(jSONObject.getInt(next)));
                    }
                } else {
                    hashMap = new HashMap();
                    JSONObject jSONObject2 = new JSONObject(str);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, Double.valueOf(jSONObject2.getDouble(next2)));
                    }
                }
                return hashMap;
            } catch (Exception e) {
                TTVideoEngineLog.e("PortraitNetworkScore", e.toString());
                throw e;
            }
        }
    }

    public NetworkQualityAlgorithm genNetworkQualityAlg() {
        return new NetworkQualityAlgorithmV2();
    }

    public int getNetworkRTTLevel() {
        return this.mPortraitData.getNetworkRTTLevel();
    }

    public int getNetworkRTTMS() {
        return this.mPortraitData.getNetworkRTTMS();
    }

    public void stop() {
        this.mPortraitData.stop();
    }

    static {
        Covode.recordClassIndex(652478);
        mInstance = null;
        mLastTargetBitrate = -1.0d;
    }

    private PortraitNetworkScore() {
    }

    public static PortraitNetworkScore getInstance() {
        if (mInstance == null) {
            mInstance = new PortraitNetworkScore();
        }
        return mInstance;
    }

    public int getLastPortraitResult() {
        NetworkQualityAlgorithm networkQualityAlgorithm = this.mQualityAlg;
        if (networkQualityAlgorithm == null) {
            return -1;
        }
        return networkQualityAlgorithm.getLastNetworkScore();
    }

    public int getPortraitResult() {
        NetworkQualityAlgorithm networkQualityAlgorithm = this.mQualityAlg;
        if (networkQualityAlgorithm == null) {
            return -1;
        }
        return networkQualityAlgorithm.getNetworkScore();
    }

    public void start() {
        this.mPortraitData.start();
        this.mQualityAlg = new NetworkQualityAlgorithmV1();
    }

    public static class BitrateCalculationTask extends TimerTask {
        private NetworkQualityAlgorithm mAlgorithm;
        private NetworkPortraitData mData;

        static {
            Covode.recordClassIndex(652479);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            List<Integer> rttList = this.mData.getRttList();
            List<Float> mdlSeepList = this.mData.getMdlSeepList();
            NetworkQualityAlgorithm networkQualityAlgorithm = this.mAlgorithm;
            if (networkQualityAlgorithm != null && rttList != null && mdlSeepList != null) {
                StrategyHelper.helper().getCenter().h(31213, String.valueOf(networkQualityAlgorithm.calculateTargetBitrate(rttList, mdlSeepList)));
            }
        }

        public BitrateCalculationTask(NetworkPortraitData networkPortraitData, NetworkQualityAlgorithm networkQualityAlgorithm) {
            this.mData = networkPortraitData;
            this.mAlgorithm = networkQualityAlgorithm;
        }
    }

    private static class NetworkQualityAlgorithmV2 implements NetworkQualityAlgorithm {
        private double mLinkFuncOffset;
        private double[] mParameters = {0.54551238d, -0.03129748d, 0.19721764d, 0.24254935d, 0.01385684d, -1.56912212d, -0.40001913d, -0.57657028d, -0.63627456d, -0.13389704d, 0.0628909d, -0.13203807d, -0.08140563d, -0.09929551d, 0.10024534d, 0.31530643d};
        private String mVarsToParse = null;

        static {
            Covode.recordClassIndex(652482);
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getLastNetworkScore() {
            return -1;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getNetworkScore() {
            return -1;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void init() {
        }

        public NetworkQualityAlgorithmV2() {
            double optDouble;
            JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("net_quality");
            if (vodJsonObject == null) {
                optDouble = 1.0d;
            } else {
                optDouble = vodJsonObject.optDouble("link_function_offset", 1.0d);
            }
            this.mLinkFuncOffset = optDouble;
            if (optDouble < 0.0d) {
                this.mLinkFuncOffset = 1.0d;
            }
            TTVideoEngineLog.i("PortraitNetworkScore", "link function offset: " + this.mLinkFuncOffset);
        }

        private void parseVariable(String str) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                this.mParameters[i2] = Double.valueOf(split[i]).doubleValue();
                if (i3 != this.mParameters.length) {
                    i++;
                    i2 = i3;
                } else {
                    return;
                }
            }
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void setStringOption(int i, String str) {
            if (i == 4) {
                this.mVarsToParse = str;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0260  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0275  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0281  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x027a  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x026e  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x019d  */
        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public double calculateTargetBitrate(java.util.List<java.lang.Integer> r32, java.util.List<java.lang.Float> r33) {
            /*
                Method dump skipped, instructions count: 690
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithmV2.calculateTargetBitrate(java.util.List, java.util.List):double");
        }
    }

    public void setNetworkRTTLevelListener(networkRTTLevelListener networkrttlevellistener) {
        this.mPortraitData.setNetworkRTTLevelListener(networkrttlevellistener);
    }

    public void setStringOption(int i, String str) {
        this.mQualityAlg.setStringOption(i, str);
    }

    public void setIntOption(int i, int i2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4 || i2 < 0) {
                    return;
                }
                this.mPortraitData.setMinDataSize(i2);
                return;
            }
            if (i2 > 0) {
                this.mPortraitData.setSampleInterval(i2);
                start();
                return;
            }
            return;
        }
        this.mPortraitData.setMaxCount(i2);
    }
}

package com.ss.ttvideoengine.selector.gracie;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.selector.Selector;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class GracieSelector implements Selector {
    private static int sSpeedType;
    private final int mOnceT;
    private final int mScene;

    public static class Params {
        Map<Integer, Object> mMaps = new HashMap();

        static {
            Covode.recordClassIndex(652646);
        }

        public Map<Integer, Object> build() {
            return this.mMaps;
        }

        public Params aggressivePortraitLowBitrate(int i) {
            this.mMaps.put(Integer.valueOf(ParamsKey.AGGR_PORTRAIT_LOW_BIT.ordinal()), Integer.valueOf(i));
            return this;
        }

        public Params srStrategyConfig(SRStrategyConfig sRStrategyConfig) {
            if (sRStrategyConfig == null) {
                return this;
            }
            sRStrategyConfig.setStrategyType(0);
            this.mMaps.put(Integer.valueOf(ParamsKey.SR_STRATEGY_CONFIG.ordinal()), sRStrategyConfig);
            return this;
        }

        public Params abrMax(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.GRACIE_MAX_RESOLUTION_QUALITY.ordinal()), str);
            }
            if (i >= 0) {
                this.mMaps.put(Integer.valueOf(ParamsKey.GRACIE_MAX_RESOLUTION_INDEX.ordinal()), Integer.valueOf(i));
            }
            return this;
        }

        public Params cellularMax(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.CELLULAR_MAX_RESOLUTION_QUALITY.ordinal()), str);
            }
            if (i >= 0) {
                this.mMaps.put(Integer.valueOf(ParamsKey.CELLULAR_MAX_RESOLUTION_INDEX.ordinal()), Integer.valueOf(i));
            }
            return this;
        }

        public Params displaySize(int i, int i2) {
            this.mMaps.put(Integer.valueOf(ParamsKey.DISPLAY_WIDTH.ordinal()), Integer.valueOf(i));
            this.mMaps.put(Integer.valueOf(ParamsKey.DISPLAY_HEIGHT.ordinal()), Integer.valueOf(i2));
            return this;
        }

        public Params downgrade(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.DOWNGRADE_RESOLUTION_QUALITY.ordinal()), str);
            }
            if (i >= 0) {
                this.mMaps.put(Integer.valueOf(ParamsKey.DOWNGRADE_RESOLUTION_INDEX.ordinal()), Integer.valueOf(i));
            }
            return this;
        }

        public Params screenSize(int i, int i2) {
            this.mMaps.put(Integer.valueOf(ParamsKey.SCREEN_WIDTH.ordinal()), Integer.valueOf(i));
            this.mMaps.put(Integer.valueOf(ParamsKey.SCREEN_HEIGHT.ordinal()), Integer.valueOf(i2));
            return this;
        }

        public Params tags(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.TAG.ordinal()), str);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.SUB_TAG.ordinal()), str2);
            }
            return this;
        }

        public Params userExpected(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.USER_EXPECTED_RESOLUTION_QUALITY.ordinal()), str);
            }
            if (i >= 0) {
                this.mMaps.put(Integer.valueOf(ParamsKey.USER_EXPECTED_RESOLUTION_INDEX.ordinal()), Integer.valueOf(i));
            }
            return this;
        }

        public Params wifiDefault(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mMaps.put(Integer.valueOf(ParamsKey.WIFI_DEFAULT_RESOLUTION_QUALITY.ordinal()), str);
            }
            if (i >= 0) {
                this.mMaps.put(Integer.valueOf(ParamsKey.WIFI_DEFAULT_RESOLUTION_INDEX.ordinal()), Integer.valueOf(i));
            }
            return this;
        }
    }

    static {
        Covode.recordClassIndex(652645);
        sSpeedType = 4;
    }

    private enum ParamsKey {
        SCREEN_WIDTH,
        SCREEN_HEIGHT,
        DISPLAY_WIDTH,
        DISPLAY_HEIGHT,
        WIFI_DEFAULT_RESOLUTION_INDEX,
        WIFI_DEFAULT_RESOLUTION_QUALITY,
        CELLULAR_MAX_RESOLUTION_INDEX,
        CELLULAR_MAX_RESOLUTION_QUALITY,
        USER_EXPECTED_RESOLUTION_INDEX,
        USER_EXPECTED_RESOLUTION_QUALITY,
        GRACIE_MAX_RESOLUTION_INDEX,
        GRACIE_MAX_RESOLUTION_QUALITY,
        DOWNGRADE_RESOLUTION_INDEX,
        DOWNGRADE_RESOLUTION_QUALITY,
        SR_STRATEGY_CONFIG,
        TAG,
        SUB_TAG,
        AGGR_PORTRAIT_LOW_BIT;

        static {
            Covode.recordClassIndex(652647);
        }
    }

    public static void setSpeedType(int i) {
        sSpeedType = i;
    }

    public GracieSelector(int i) {
        this(i, 8);
    }

    public GracieSelector(int i, int i2) {
        this.mScene = i;
        this.mOnceT = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05b8  */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [int] */
    /* JADX WARN: Type inference failed for: r11v26 */
    @Override // com.ss.ttvideoengine.selector.Selector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ss.ttvideoengine.selector.SelectedInfo select(com.ss.ttvideoengine.model.IVideoModel r26, java.util.Map<java.lang.Integer, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 1485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.selector.gracie.GracieSelector.select(com.ss.ttvideoengine.model.IVideoModel, java.util.Map):com.ss.ttvideoengine.selector.SelectedInfo");
    }

    private static int getBitrate(int i, int i2, Map<Integer, Object> map, IVideoModel iVideoModel) {
        int i3;
        Object obj = map.get(Integer.valueOf(i));
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
        } else {
            i3 = -1;
        }
        Object obj2 = map.get(Integer.valueOf(i2));
        if ((i3 == -1 || i3 == Resolution.Auto.getIndex()) && obj2 == null) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.clear();
        if (obj2 instanceof String) {
            hashMap.put(32, (String) obj2);
        }
        VideoInfo videoInfo = iVideoModel.getVideoInfo(Resolution.valueOf(i3), (Map<Integer, String>) hashMap, true);
        if (videoInfo == null) {
            return -1;
        }
        return videoInfo.getValueInt(3);
    }
}

package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.networkpredictor.DefaultSpeedPredictor;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Locale;
import java.util.Map;
import ss1.a;
import ss1.b;
import ss1.e;
import ss1.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyCenter {
    private static Map sConfigInfo;
    public static b sNetAbrSpeedPredictor;
    public static b sNetSpeedPredictor;
    private static e speedPredictorListener;
    private static f speedPredictorMlConfig;

    static {
        Covode.recordClassIndex(652713);
    }

    private StrategyCenter() {
    }

    public static void setSpeedPredictorListener(e eVar) {
    }

    public static void setSpeedPredictorMlConfig(f fVar) {
    }

    private static class StrategyCenterHolder {
        private static final StrategyCenter instance;

        private StrategyCenterHolder() {
        }

        static {
            Covode.recordClassIndex(652714);
            instance = new StrategyCenter();
        }
    }

    public static void closeNewStartAndSelectGearSpeedPredictor() {
        sNetSpeedPredictor.release();
    }

    public static StrategyCenter getInstance() {
        return StrategyCenterHolder.instance;
    }

    public static void setConfigInfo(Map map) {
        sConfigInfo = map;
    }

    public static void setSpeedQueueSize(int i) {
        b bVar = sNetSpeedPredictor;
        if (bVar != null) {
            bVar.h(i);
        }
    }

    public static void createNewStartAndSelectGearSpeedPredictor(int i) {
        if (sNetSpeedPredictor != null) {
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine", String.format(Locale.US, "[IESSpeedPredictor] start new speed predictor, type:%d", Integer.valueOf(i)));
        DefaultSpeedPredictor defaultSpeedPredictor = new DefaultSpeedPredictor(i);
        sNetSpeedPredictor = defaultSpeedPredictor;
        defaultSpeedPredictor.g(sConfigInfo);
    }

    public static void createSpeedPredictor(int i) {
        if (sNetSpeedPredictor != null) {
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine", String.format(Locale.US, "[IESSpeedPredictor] start speed predictor, type:%d", Integer.valueOf(i)));
        if (i != 1 && i != 0 && i != 2 && i != 3) {
            try {
                a aVar = new a((e) null);
                sNetSpeedPredictor = aVar;
                a aVar2 = aVar;
                aVar.k(i, (f) null);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        sNetSpeedPredictor = new DefaultSpeedPredictor(i);
    }

    public static void createAbrSpeedPredictor(int i, int i2) {
        if (sNetAbrSpeedPredictor != null) {
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine", String.format(Locale.US, "[ABR] start speed predictor, type:%d，intervalMs:%d", Integer.valueOf(i), Integer.valueOf(i2)));
        sNetAbrSpeedPredictor = new DefaultSpeedPredictor(i);
    }
}

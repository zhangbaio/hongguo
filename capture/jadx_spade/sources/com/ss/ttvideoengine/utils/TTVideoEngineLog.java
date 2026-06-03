package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.setting.SettingsHelper;
import rs1.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineLog {
    static {
        Covode.recordClassIndex(652762);
    }

    public static int getLogNotifyLevel() {
        return TTVideoEngineInternalLog.LogNotifyLevel;
    }

    public static int getLogTurnOn() {
        return TTVideoEngineInternalLog.LogTurnOn;
    }

    public static boolean e() {
        return TTVideoEngineInternalLog.e();
    }

    public static boolean i() {
        return TTVideoEngineInternalLog.i();
    }

    public static boolean k() {
        return TTVideoEngineInternalLog.k();
    }

    public static boolean t() {
        return TTVideoEngineInternalLog.t();
    }

    public static boolean w() {
        return TTVideoEngineInternalLog.w();
    }

    public static boolean d() {
        return TTVideoEngineInternalLog.d();
    }

    public static void enablePredicateLoglevelTurn(boolean z) {
        TTVideoEngineInternalLog.enablePredicateLoglevelTurn(z);
    }

    public static void setListener(TTVideoEngineLogListener tTVideoEngineLogListener) {
        TTVideoEngineInternalLog.setListener(tTVideoEngineLogListener);
    }

    public static void d(Throwable th) {
        TTVideoEngineInternalLog.d(th);
    }

    public static boolean isPredicateLoglevelTurnOn(int i) {
        return TTVideoEngineInternalLog.isPredicateLoglevelTurnOn(i);
    }

    private static void _notifyListener(String str, String str2) {
        TTVideoEngineInternalLog._notifyListener(str, str2);
    }

    public static void d(String str, String str2) {
        TTVideoEngineInternalLog.d(str, str2);
    }

    public static void e(String str, String str2) {
        TTVideoEngineInternalLog.e(str, str2);
    }

    public static void i(String str, String str2) {
        TTVideoEngineInternalLog.i(str, str2);
    }

    public static void k(String str, String str2) {
        TTVideoEngineInternalLog.k(str, str2);
    }

    public static void setLogNotifyLevel(int i, int i2) {
        TTVideoEngineInternalLog.setLogNotifyLevel(i, i2);
    }

    public static void t(String str, String str2) {
        TTVideoEngineInternalLog.t(str, str2);
    }

    public static void w(String str, String str2) {
        TTVideoEngineInternalLog.w(str, str2);
    }

    public static void turnOn(int i, int i2) {
        TTVideoEngineInternalLog.turnOn(i, i2);
        if (i == 1 && i2 == 1) {
            c.x(1);
            GearStrategyConfig globalConfig = GearStrategy.getGlobalConfig();
            globalConfig.setIntValue(33, 1);
            GearStrategy.setGlobalConfig(globalConfig);
            SettingsHelper.helper().setDebug(true);
        } else {
            SettingsHelper.helper().setDebug(false);
        }
        if (i2 > 0) {
            DataLoaderHelper.getDataLoader().setPreloadLogLevel(i);
        } else {
            DataLoaderHelper.getDataLoader().setPreloadLogLevel(6);
        }
    }
}

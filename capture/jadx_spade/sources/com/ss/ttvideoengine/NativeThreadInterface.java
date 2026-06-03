package com.ss.ttvideoengine;

import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface NativeThreadInterface {

    /* renamed from: com.ss.ttvideoengine.NativeThreadInterface$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getPowerMode(NativeThreadInterface nativeThreadInterface) {
            return 0;
        }

        public static int $default$getThermalStatus(NativeThreadInterface nativeThreadInterface) {
            return 0;
        }

        public static void $default$onLowPowerModeChanged(NativeThreadInterface nativeThreadInterface, int i) {
        }

        public static void $default$onTempStatusChanged(NativeThreadInterface nativeThreadInterface, int i) {
        }
    }

    void carethreadList(List<Integer> list);

    int getPowerMode();

    float getProcessCpuUsage();

    int getThermalStatus();

    float getThreadCpuUsage(int i);

    void onLowPowerModeChanged(int i);

    void onTempStatusChanged(int i);
}

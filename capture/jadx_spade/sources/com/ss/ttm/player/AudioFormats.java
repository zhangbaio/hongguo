package com.ss.ttm.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AudioFormats {
    private static boolean sDetectDlbDevices;
    private static boolean sDlbDevice;
    private static final int[] validSampleRates;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        int length = queryEffects.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (queryEffects[i].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
            i++;
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }

    static {
        Covode.recordClassIndex(652085);
        validSampleRates = new int[]{4000, 8000, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
        sDetectDlbDevices = false;
        sDlbDevice = false;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length;
        int i = Build.VERSION.SDK_INT >= 23 ? length - 3 : length - 5;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = validSampleRates[i2];
        }
        return i;
    }
}

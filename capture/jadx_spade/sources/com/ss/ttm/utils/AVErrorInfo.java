package com.ss.ttm.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AVErrorInfo {
    private static StringBuilder PHONE_INFO;

    static {
        Covode.recordClassIndex(652224);
    }

    public static final void setupPhoneInfo(Context context, StringBuilder sb) {
        String[] version = VersionInfo.getVersion();
        if (version != null) {
            sb.append(String.format("version:%s,%s,%s\r\n", version[0], version[1], version[2]));
            sb.append("\r\n");
        }
        long[] romMemroy = MemoryInfo.getRomMemroy();
        if (romMemroy != null) {
            sb.append(String.format(Locale.US, "rom memory totle:%d,availe:%d\r\n", Long.valueOf(romMemroy[0]), Long.valueOf(romMemroy[1])));
            sb.append("\r\n");
        }
        long availMemory = MemoryInfo.getAvailMemory(context);
        long tolalMemory = MemoryInfo.getTolalMemory();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "ram memory totle:%d,availe:%d\r\n", Long.valueOf(tolalMemory), Long.valueOf(availMemory)));
        sb.append("\r\n");
        long[] sDCardSize = HardWareInfo.getSDCardSize(context);
        if (sDCardSize != null) {
            sb.append(String.format(locale, "sdcard totle:%d,availe:%d\r\n", Long.valueOf(sDCardSize[0]), Long.valueOf(sDCardSize[1])));
            sb.append("\r\n");
        }
    }

    public static void setupErrorInfo(Context context, StringBuilder sb, String str, String str2, String str3) {
        if (PHONE_INFO == null) {
            StringBuilder sb2 = new StringBuilder();
            PHONE_INFO = sb2;
            setupPhoneInfo(context, sb2);
        }
        sb.append((CharSequence) PHONE_INFO);
        sb.append("\r\n");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
    }
}

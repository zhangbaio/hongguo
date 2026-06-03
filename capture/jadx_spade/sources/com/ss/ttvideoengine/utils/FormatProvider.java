package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface FormatProvider {
    public static final FormatProvider DEFAULT;

    int provideFormat(String str);

    public static class FormatProviderHolder {
        private static FormatProvider sInstance;

        public static FormatProvider get() {
            FormatProvider formatProvider = sInstance;
            if (formatProvider == null) {
                return FormatProvider.DEFAULT;
            }
            return formatProvider;
        }

        static {
            Covode.recordClassIndex(652748);
            sInstance = FormatProvider.DEFAULT;
        }

        public static void set(FormatProvider formatProvider) {
            sInstance = formatProvider;
        }

        public static boolean isM3u8(String str) {
            if (str == null || get().provideFormat(str) != 1) {
                return false;
            }
            return true;
        }

        public static boolean isMpd(String str) {
            if (str == null || get().provideFormat(str) != 2) {
                return false;
            }
            return true;
        }
    }

    static {
        Covode.recordClassIndex(652746);
        DEFAULT = new Default();
    }

    public static class Default implements FormatProvider {
        static {
            Covode.recordClassIndex(652747);
        }

        private static boolean isMpd(String str) {
            if (!str.endsWith(".mpd") && !str.contains(".mpd?")) {
                return false;
            }
            return true;
        }

        @Override // com.ss.ttvideoengine.utils.FormatProvider
        public int provideFormat(String str) {
            if (str == null) {
                return 0;
            }
            String lowerCase = str.toLowerCase();
            if (isM3u8(lowerCase)) {
                return 1;
            }
            if (!isMpd(lowerCase)) {
                return 0;
            }
            return 2;
        }

        private static boolean isM3u8(String str) {
            if (!str.contains(".m3u8?") && !str.endsWith(".m3u8") && !str.contains(".m3u?") && !str.endsWith(".m3u")) {
                return false;
            }
            return true;
        }
    }
}

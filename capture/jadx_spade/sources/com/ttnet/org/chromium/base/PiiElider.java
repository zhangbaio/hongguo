package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PiiElider {
    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    private static final Pattern d;
    private static final String[] e;
    private static final String[] f;

    static {
        Covode.recordClassIndex(654244);
        a = Pattern.compile("(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
        b = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.|Caused by: java.lang.(ClassNotFoundException|NoClassDefFoundError):");
        c = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        d = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        e = new String[]{"com.ttnet.org.chromium.", "com.google.", "com.chrome."};
        f = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    private static boolean b(String str) {
        try {
            Class.forName(str, false, c.f().getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str) {
        for (String str2 : e) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(String str) {
        if (b(str)) {
            return true;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return false;
        }
        return b(str.substring(0, lastIndexOf));
    }

    private static boolean e(String str) {
        for (String str2 : f) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String sanitizeStacktrace(String str) {
        String[] split = str.split("\\n");
        split[0] = a(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (split[i].startsWith("Caused by:")) {
                split[i] = a(split[i]);
            }
        }
        return TextUtils.join("\n", split);
    }

    public static String a(String str) {
        try {
            if (b.matcher(str).find()) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            Matcher matcher = a.matcher(sb);
            int i = 0;
            while (matcher.find(i)) {
                int start = matcher.start();
                int end = matcher.end();
                String substring = sb.substring(start, end);
                if (!c(substring) && !e(substring) && !d(substring)) {
                    sb.replace(start, end, "HTTP://WEBADDRESS.ELIDED");
                    i = start + 24;
                    matcher = a.matcher(sb);
                } else {
                    i = end;
                }
            }
            return sb.toString();
        } catch (IllegalArgumentException unused) {
            return "";
        }
    }
}

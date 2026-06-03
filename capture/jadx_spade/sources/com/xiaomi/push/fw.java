package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.Random;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fw {
    private static Random a;

    /* renamed from: a, reason: collision with other field name */
    private static final char[] f473a;
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;
    private static char[] f;

    static {
        Covode.recordClassIndex(655541);
        f473a = "&quot;".toCharArray();
        b = "&apos;".toCharArray();
        c = "&amp;".toCharArray();
        d = "&lt;".toCharArray();
        e = "&gt;".toCharArray();
        a = new Random();
        f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String a(byte[] bArr) {
        return String.valueOf(ax.a(bArr));
    }

    public static String a(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = f[a.nextInt(71)];
        }
        return new String(cArr);
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 <= '>') {
                if (c2 == '<') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(d);
                } else if (c2 == '>') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(e);
                } else if (c2 == '&') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                        i2 = i + 1;
                        sb.append(c);
                    }
                } else if (c2 == '\"') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f473a);
                } else if (c2 == '\'') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(b);
                }
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb.toString();
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf >= 0) {
            char[] charArray = str.toCharArray();
            char[] charArray2 = str3.toCharArray();
            int length = str2.length();
            StringBuilder sb = new StringBuilder(charArray.length);
            sb.append(charArray, 0, indexOf);
            sb.append(charArray2);
            int i = indexOf + length;
            while (true) {
                int indexOf2 = str.indexOf(str2, i);
                if (indexOf2 > 0) {
                    sb.append(charArray, i, indexOf2 - i);
                    sb.append(charArray2);
                    i = indexOf2 + length;
                } else {
                    sb.append(charArray, i, charArray.length - i);
                    return sb.toString();
                }
            }
        } else {
            return str;
        }
    }
}

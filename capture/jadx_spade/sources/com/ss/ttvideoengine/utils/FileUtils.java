package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FileUtils {
    static {
        Covode.recordClassIndex(652745);
    }

    public static void checkAndMkdir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String readString(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new PolarisFileReaderWrapper(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } finally {
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

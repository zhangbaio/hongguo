package com.ss.ttm.utils;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VersionInfo {
    private static String[] mVersion;

    static {
        Covode.recordClassIndex(652241);
    }

    public static String[] getVersion() {
        PolarisFileReaderWrapper polarisFileReaderWrapper;
        if (mVersion == null) {
            String[] strArr = {"null", "null", "null", "null"};
            BufferedReader bufferedReader = null;
            try {
                try {
                    polarisFileReaderWrapper = new PolarisFileReaderWrapper("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(polarisFileReaderWrapper, 8192);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            try {
                                bufferedReader2.close();
                                polarisFileReaderWrapper.close();
                            } catch (Throwable th) {
                                try {
                                    th.printStackTrace();
                                    polarisFileReaderWrapper.close();
                                } finally {
                                    try {
                                        polarisFileReaderWrapper.close();
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    try {
                                        th3.printStackTrace();
                                        if (polarisFileReaderWrapper != null) {
                                            polarisFileReaderWrapper.close();
                                        }
                                    } catch (Throwable th4) {
                                        if (polarisFileReaderWrapper != null) {
                                        }
                                        throw th4;
                                    }
                                }
                            }
                            if (polarisFileReaderWrapper != null) {
                                polarisFileReaderWrapper.close();
                            }
                            strArr[1] = Build.VERSION.RELEASE;
                            strArr[2] = Build.MODEL;
                            strArr[3] = Build.DISPLAY;
                            mVersion = strArr;
                            return mVersion;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable unused3) {
                polarisFileReaderWrapper = null;
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}

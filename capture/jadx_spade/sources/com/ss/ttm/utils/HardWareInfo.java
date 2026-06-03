package com.ss.ttm.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HardWareInfo {
    private static int[] mArmArchitecture;
    private static int mCpuType;

    private static boolean isAndroidJB2() {
        return true;
    }

    static {
        Covode.recordClassIndex(652233);
        mCpuType = 0;
        mArmArchitecture = new int[3];
    }

    public static int getCpuFamily() {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }

    public static int[] getCpuArchitecture() {
        try {
            PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(polarisFileInputStreamWrapper);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.replace("\t", "").split(":");
                    if (split.length == 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                String str = trim2.charAt(indexOf) + "";
                                if (!str.matches("\\d")) {
                                    break;
                                }
                                sb.append(str);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (trim.compareToIgnoreCase("model name") == 0) {
                            if (trim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (trim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(trim2);
                        }
                    }
                } finally {
                    bufferedReader.close();
                    inputStreamReader.close();
                    polarisFileInputStreamWrapper.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mArmArchitecture;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x006f, code lost:
    
        com.ss.ttm.utils.HardWareInfo.mArmArchitecture[0] = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] getCpuInfo() {
        /*
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Exception -> Ldd
            java.lang.String r1 = "/proc/cpuinfo"
            r0.<init>(r1)     // Catch: java.lang.Exception -> Ldd
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Ldd
            r1.<init>(r0)     // Catch: java.lang.Exception -> Ldd
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Ldd
            r2.<init>(r1)     // Catch: java.lang.Exception -> Ldd
            java.lang.String r3 = "processor"
            java.lang.String r4 = "features"
            java.lang.String r5 = "model name"
        L17:
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> Ld2
            if (r6 != 0) goto L1f
            goto Lc8
        L1f:
            java.lang.String r7 = "\t"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.replaceAll(r7, r8)     // Catch: java.lang.Throwable -> Ld2
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = r6.toLowerCase(r7)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> Ld2
            int r7 = r6.length     // Catch: java.lang.Throwable -> Ld2
            r8 = 2
            if (r7 == r8) goto L38
            goto L17
        L38:
            r7 = 0
            r9 = r6[r7]     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> Ld2
            r10 = 1
            r6 = r6[r10]     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            if (r9 != 0) goto L4b
            goto L17
        L4b:
            int r11 = r9.compareTo(r3)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r12 = "intel"
            if (r11 != 0) goto L74
            java.lang.String r9 = "armv"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> Ld2
            if (r9 != 0) goto L6f
            java.lang.String r9 = "aarch64"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto L64
            goto L6f
        L64:
            boolean r6 = r6.contains(r12)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r8     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        L6f:
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r10     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        L74:
            int r11 = r9.compareToIgnoreCase(r4)     // Catch: java.lang.Throwable -> Ld2
            if (r11 != 0) goto Lab
            java.lang.String r8 = "neon"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "thumb"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "vfpv"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "asimd"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "simd"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
        La5:
            int[] r6 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r6[r7] = r10     // Catch: java.lang.Throwable -> Ld2
            goto L17
        Lab:
            int r9 = r9.compareToIgnoreCase(r5)     // Catch: java.lang.Throwable -> Ld2
            if (r9 != 0) goto L17
            boolean r9 = r6.contains(r12)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto Lbc
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r8     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        Lbc:
            java.lang.String r8 = "arm"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r10     // Catch: java.lang.Throwable -> Ld2
        Lc8:
            r2.close()     // Catch: java.lang.Exception -> Ldd
            r1.close()     // Catch: java.lang.Exception -> Ldd
            r0.close()     // Catch: java.lang.Exception -> Ldd
            goto Le1
        Ld2:
            r3 = move-exception
            r2.close()     // Catch: java.lang.Exception -> Ldd
            r1.close()     // Catch: java.lang.Exception -> Ldd
            r0.close()     // Catch: java.lang.Exception -> Ldd
            throw r3     // Catch: java.lang.Exception -> Ldd
        Ldd:
            r0 = move-exception
            r0.printStackTrace()
        Le1:
            int[] r0 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.utils.HardWareInfo.getCpuInfo():int[]");
    }

    public static long getProcessCpuInfo() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
            } catch (ArrayIndexOutOfBoundsException unused2) {
                return 0L;
            }
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(context.getFilesDir().getParent());
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(context.getFilesDir().getParent());
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }
}

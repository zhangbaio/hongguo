package com.tencent.tinker.lib.dexopt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.tinker.commons.util.DigestUtil;
import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.DirUtils;
import com.tencent.tinker.lib.utils.FileUtils;
import com.tencent.tinker.ziputils.ziputil.AlignedZipOutputStream;
import dalvik.system.PathClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DexAlign {
    static {
        Covode.recordClassIndex(653736);
    }

    public static final class Result {
        public int mCode;
        public String mMsg;

        static {
            Covode.recordClassIndex(653737);
        }

        public boolean isSuccess() {
            if (this.mCode == 1) {
                return true;
            }
            return false;
        }

        public Map<String, Object> formatMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("alignCode", Integer.valueOf(this.mCode));
            String str = this.mMsg;
            if (str != null) {
                hashMap.put("alignMsg", str);
            }
            return hashMap;
        }

        public String format2Json() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mCode", this.mCode);
                jSONObject.put("mMsg", this.mMsg);
                String jSONObject2 = jSONObject.toString();
                MuteLog.i("Mute.DexAlign", "format2Json %s", jSONObject2);
                return jSONObject2;
            } catch (JSONException e) {
                MuteLog.w("Mute.DexAlign", "format2Json write JSON failed. %s", e);
                return "";
            }
        }

        public Result(int i) {
            this.mCode = i;
        }

        public Result(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mCode = jSONObject.optInt("mCode");
                this.mMsg = jSONObject.optString("mMsg");
            } catch (JSONException e) {
                MuteLog.w("Mute.DexAlign", "formatFromJson failed. %s", e);
            }
        }

        public Result(int i, String str) {
            this.mCode = i;
            this.mMsg = str;
        }
    }

    private boolean waitTimeSeq(File file, Long... lArr) {
        if (lArr == null || lArr.length <= 0) {
            lArr = new Long[]{1000L, 2000L, 4000L, 8000L, 16000L};
        }
        for (int i = 0; !FileUtils.isLegalFile(file) && i < lArr.length; i++) {
            MuteLog.i("Mute.DexAlign", "waitTimeSeq[%d] file[%s]", lArr[i], file.getName());
            SystemClock.sleep(lArr[i].longValue());
        }
        boolean isLegalFile = FileUtils.isLegalFile(file);
        if (isLegalFile) {
            MuteLog.i("Mute.DexAlign", "waitTimeSeq[true] file[%s]", file.getName());
        } else {
            MuteLog.w("Mute.DexAlign", "waitTimeSeq[false] file[%s]", file.getName());
        }
        return isLegalFile;
    }

    public Result align(File file, File file2) {
        File polarisFileWrapper;
        Result result;
        File file3 = null;
        try {
            try {
                polarisFileWrapper = new PolarisFileWrapper(file.getParentFile(), "unzipDir");
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!polarisFileWrapper.exists()) {
                polarisFileWrapper.mkdir();
            }
            FileUtils.unZipFolder(file, polarisFileWrapper);
            MuteLog.i("Mute.DexAlign", "uncompress mPatchFile --> unzipDir", new Object[0]);
            mergeClassNDex(polarisFileWrapper.listFiles(new FileFilter() { // from class: com.tencent.tinker.lib.dexopt.DexAlign.1
                @Override // java.io.FileFilter
                public boolean accept(File file4) {
                    return file4.getName().endsWith(".dex");
                }
            }), polarisFileWrapper.listFiles(new FileFilter() { // from class: com.tencent.tinker.lib.dexopt.DexAlign.2
                @Override // java.io.FileFilter
                public boolean accept(File file4) {
                    return !file4.getName().endsWith(".dex");
                }
            }), file2);
            FileUtils.setOnlyReadable(file2);
            new PathClassLoader(file2.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
            MuteLog.i("Mute.DexAlign", "RunBackgroundVerification", new Object[0]);
            File oatFile = DirUtils.getOatFile(file2);
            if (waitTimeSeq(new PolarisFileWrapper(oatFile.getParent(), oatFile.getName().substring(0, oatFile.getName().lastIndexOf(".")) + ".vdex"), new Long[0])) {
                MuteLog.i("Mute.DexAlign", "align[T]", new Object[0]);
                result = new Result(1);
            } else {
                MuteLog.w("Mute.DexAlign", "align[F]", new Object[0]);
                result = new Result(2, "align_err[vdex invalid]");
            }
            FileUtils.deleteDir(polarisFileWrapper);
            return result;
        } catch (Exception e2) {
            e = e2;
            file3 = polarisFileWrapper;
            MuteLog.w("Mute.DexAlign", "align failed. %s", e);
            Result result2 = new Result(2, "align_err[" + e.getCause() + "]");
            FileUtils.deleteDir(file3);
            return result2;
        } catch (Throwable th2) {
            th = th2;
            file3 = polarisFileWrapper;
            FileUtils.deleteDir(file3);
            throw th;
        }
    }

    private void compressRes(File[] fileArr, String str, AlignedZipOutputStream alignedZipOutputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(str)) {
                        name = str + "/" + file.getName();
                    }
                    ZipEntry zipEntry = new ZipEntry(name);
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            alignedZipOutputStream.putNextEntry(zipEntry);
                            IOHelper.copyStream(bufferedInputStream, alignedZipOutputStream);
                            alignedZipOutputStream.closeEntry();
                            IOHelper.closeQuietly(bufferedInputStream);
                        } catch (Throwable th2) {
                            alignedZipOutputStream.closeEntry();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream2 = bufferedInputStream;
                        IOHelper.closeQuietly(bufferedInputStream2);
                        throw th;
                    }
                } else {
                    File[] listFiles = file.listFiles();
                    String name2 = file.getName();
                    if (!TextUtils.isEmpty(str)) {
                        name2 = str + "/" + file.getName();
                    }
                    compressRes(listFiles, name2, alignedZipOutputStream);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.BufferedInputStream, java.io.InputStream, java.lang.Object] */
    private void mergeClassNDex(File[] fileArr, File[] fileArr2, File file) throws IOException {
        AlignedZipOutputStream alignedZipOutputStream = null;
        try {
            AlignedZipOutputStream alignedZipOutputStream2 = new AlignedZipOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(file)));
            if (fileArr != null) {
                try {
                    for (File file2 : fileArr) {
                        ZipEntry zipEntry = new ZipEntry(file2.getName());
                        zipEntry.setMethod(0);
                        zipEntry.setCompressedSize(file2.length());
                        zipEntry.setSize(file2.length());
                        zipEntry.setCrc(DigestUtil.getCRC32(file2));
                        try {
                            ?? bufferedInputStream = new BufferedInputStream(new PolarisFileInputStreamWrapper(file2));
                            try {
                                try {
                                    alignedZipOutputStream2.putNextEntry(zipEntry);
                                    IOHelper.copyStream(bufferedInputStream, alignedZipOutputStream2);
                                    IOHelper.closeQuietly(bufferedInputStream);
                                } finally {
                                }
                            } catch (Throwable th) {
                                th = th;
                                alignedZipOutputStream = bufferedInputStream;
                                IOHelper.closeQuietly(alignedZipOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    MuteLog.i("Mute.DexAlign", "mergeClassNDex", new Object[0]);
                } catch (Throwable th3) {
                    th = th3;
                    alignedZipOutputStream = alignedZipOutputStream2;
                    IOHelper.closeQuietly(alignedZipOutputStream);
                    throw th;
                }
            }
            if (fileArr2 != null) {
                compressRes(fileArr2, null, alignedZipOutputStream2);
                MuteLog.i("Mute.DexAlign", "compressRes", new Object[0]);
            }
            IOHelper.closeQuietly(alignedZipOutputStream2);
        } catch (Throwable th4) {
            th = th4;
        }
    }
}

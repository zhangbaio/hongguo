package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.JniUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTHelper {
    private static String mAppPath;
    private static String sBoeSuffix;
    private static volatile String sLastExternalStorageState;
    private static volatile long sLastGetExternalStorageStateTime;

    public static boolean isAndroidJB2() {
        return true;
    }

    public static <T> T nonNullElse(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static HashMap<String, Resolution> defaultAudioResolutionMap() {
        return new HashMap<String, Resolution>() { // from class: com.ss.ttvideoengine.utils.TTHelper.2
            {
                put("medium", Resolution.Standard);
                put("higher", Resolution.High);
                put("highest", Resolution.SuperHigh);
                put("original", Resolution.ExtremelyHigh);
                put("lossless", Resolution.FourK);
            }
        };
    }

    public static HashMap<String, Resolution> defaultVideoResolutionMap() {
        return new HashMap<String, Resolution>() { // from class: com.ss.ttvideoengine.utils.TTHelper.1
            {
                put("240p", Resolution.L_Standard);
                put("360p", Resolution.Standard);
                put("480p", Resolution.High);
                put("540p", Resolution.H_High);
                put("720p", Resolution.SuperHigh);
                put("1080p", Resolution.ExtremelyHigh);
                Resolution resolution = Resolution.TwoK;
                put("2k", resolution);
                put("1440p", resolution);
                put("4k", Resolution.FourK);
                put("hdr", Resolution.HDR);
                put("1080p 50fps", Resolution.ExtremelyHigh_50F);
                put("2k 50fps", Resolution.TwoK_50F);
                put("4k 50fps", Resolution.FourK_50F);
                put("1080p 60fps", Resolution.ExtremelyHigh_60F);
                put("2k 60fps", Resolution.TwoK_60F);
                put("4k 60fps", Resolution.FourK_60F);
                put("1080p 120fps", Resolution.ExtremelyHigh_120F);
                put("2k 120fps", Resolution.TwoK_120F);
                put("4k 120fps", Resolution.FourK_120F);
                put("240p HDR", Resolution.L_Standard_HDR);
                put("360p HDR", Resolution.Standard_HDR);
                put("480p HDR", Resolution.High_HDR);
                put("540p HDR", Resolution.H_High_HDR);
                put("720p HDR", Resolution.SuperHigh_HDR);
                put("1080p HDR", Resolution.ExtremelyHigh_HDR);
                put("2k HDR", Resolution.TwoK_HDR);
                put("4k HDR", Resolution.FourK_HDR);
                put("8k", Resolution.EightK);
                put("1080p+", Resolution.ExtremelyHighPlus);
            }
        };
    }

    public static Looper getLooper() {
        if (Looper.myLooper() != null) {
            return Looper.myLooper();
        }
        return Looper.getMainLooper();
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(safeGetExternalStorageState());
    }

    static {
        Covode.recordClassIndex(652759);
        mAppPath = null;
        sBoeSuffix = "";
        sLastGetExternalStorageStateTime = -1L;
        sLastExternalStorageState = null;
    }

    public static String safeGetExternalStorageState() {
        if (!TextUtils.isEmpty(sLastExternalStorageState) && System.currentTimeMillis() - sLastGetExternalStorageStateTime < 5000) {
            return sLastExternalStorageState;
        }
        try {
            sLastGetExternalStorageStateTime = System.currentTimeMillis();
            sLastExternalStorageState = Environment.getExternalStorageState();
            return sLastExternalStorageState;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void configBoeSuffix(String str) {
        sBoeSuffix = str;
    }

    public static String base64Decode(String str) {
        return base64Decode(str, null);
    }

    public static float getVolume(Context context) {
        return TTVideoEngineInternalHelper.getVolume(context);
    }

    public static boolean isBase64(String str) {
        return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", str);
    }

    public static String encodeQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Uri.encode(str, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~#[]!\\()*%");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static long getFreeSize(Context context) {
        if (context == null || !isExternalStorageWritable()) {
            return -1L;
        }
        return getAvailableStorageSize(context);
    }

    public static boolean isEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isStringHex(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[A-Fa-f0-9]+$");
    }

    public static String buildHttpUrl(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("https")) {
            return str.replace("https", "http");
        }
        return str;
    }

    public static String buildHttpsUrl(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("http://127.0.0.1")) {
            return str.replaceAll("http:", "https:");
        }
        return str;
    }

    public static String computeMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decodeUrl(String str) {
        String str2 = "";
        while (!str2.equals(str)) {
            try {
                str2 = str;
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return str;
    }

    public static String getAppFilesPath(Context context) {
        String str = mAppPath;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = context.getApplicationContext().getFilesDir().getAbsolutePath();
            mAppPath = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(context.getFilesDir().getParent());
    }

    public static String hmacSha1(String str) {
        byte[] settingSignature = JniUtils.getSettingSignature(str);
        if (settingSignature == null) {
            TTVideoEngineLog.d("TTHelper", "hmacSha1 signature is null");
            return null;
        }
        return getHexString(settingSignature);
    }

    public static boolean isEmpty(Map map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isTranscodeUrlList(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (isTranscodeUrl(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long safelyUnbox(Long l) {
        return ((Long) nonNullElse(l, 0L)).longValue();
    }

    public static byte[] base64DecodeToBytes(String str) {
        TTVideoEngineLog.d("TTHelper", "base64DecodeToBytes " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.decode(str, 0);
            } catch (Throwable th) {
                TTVideoEngineLog.e("TTHelper", "base64DecodeToBytes " + th);
            }
        }
        return null;
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return null;
    }

    public static String customBase64Decode(String str) {
        if (str != null && str.length() != 0) {
            return str.replace("$", "_").replace("@", "/").replace("#", ".");
        }
        return str;
    }

    public static String customBase64Encode(String str) {
        if (str != null && str.length() != 0) {
            return str.replace("_", "$").replace("/", "@").replace(".", "#");
        }
        return str;
    }

    public static long getDirectoryAvailableSize(String str) {
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

    public static String getHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            return false;
        }
        return true;
    }

    public static int parseInt(Object obj) {
        if (obj != null) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            throw new NumberFormatException("Can't format " + obj.getClass() + " to int");
        }
        throw null;
    }

    public static void recursionDeleteFile(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    recursionDeleteFile(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static int versionStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            if (i2 == 0) {
                try {
                    i = Integer.parseInt(split[i2]);
                } catch (Exception unused) {
                }
            } else {
                i = (i * 100) + Integer.parseInt(split[i2]);
            }
        }
        return i;
    }

    public static String buildBoeUrl(String str) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(sBoeSuffix)) {
            return str;
        }
        boolean contains = str.contains(sBoeSuffix);
        boolean isIP = isIP(str);
        if (str.startsWith("https")) {
            str = str.replace("https", "http");
        }
        if (!isIP && str.indexOf("http") == 0 && !contains) {
            try {
                String host = new URL(str).getHost();
                StringBuilder sb = new StringBuilder();
                sb.append(host);
                sb.append(String.format(".%s", sBoeSuffix));
                return str.replace(host, sb);
            } catch (Exception e) {
                TTVideoEngineLog.d(e);
                return str;
            }
        }
        return str;
    }

    public static StringBuilder buildUrlEncodedQuery(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                try {
                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
                    sb.append("&");
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    public static void deleteBeforeDirFiles(Context context) {
        String appFilesPath;
        File[] listFiles;
        if (context == null || (appFilesPath = getAppFilesPath(context)) == null) {
            return;
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(appFilesPath);
        if (polarisFileWrapper.exists() && polarisFileWrapper.isDirectory() && (listFiles = polarisFileWrapper.listFiles()) != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().matches("^[0-9]{1,15}\\.cach$")) {
                    file.delete();
                }
            }
        }
    }

    public static Error errorWithJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new Error(jSONObject.optString("domain"), jSONObject.optInt("code"), jSONObject.optInt("innerCode"), jSONObject.optString("des"));
        } catch (Throwable th) {
            TTVideoEngineLog.e("TTVideoEngineTTHelper", "generate error fail. " + th + " " + jSONObject);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0049: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:17104969), block:B:32:0x0049 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileMd5(java.io.File r7) {
        /*
            boolean r0 = r7.isFile()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r0]
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r4 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
        L17:
            r7 = 0
            int r5 = r4.read(r2, r7, r0)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L48
            r6 = -1
            if (r5 == r6) goto L23
            r3.update(r2, r7, r5)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L48
            goto L17
        L23:
            r4.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r7 = move-exception
            r7.printStackTrace()
        L2b:
            byte[] r7 = r3.digest()
            java.lang.String r7 = bytesToHexString(r7)
            return r7
        L34:
            r7 = move-exception
            goto L3a
        L36:
            r7 = move-exception
            goto L4a
        L38:
            r7 = move-exception
            r4 = r1
        L3a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L47
            r4.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r7 = move-exception
            r7.printStackTrace()
        L47:
            return r1
        L48:
            r7 = move-exception
            r1 = r4
        L4a:
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.io.IOException -> L50
            goto L54
        L50:
            r0 = move-exception
            r0.printStackTrace()
        L54:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.utils.TTHelper.getFileMd5(java.io.File):java.lang.String");
    }

    public static boolean isEmpty(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean isIP(String str) {
        if (str != null) {
            String str2 = "";
            if (!str.equals("")) {
                try {
                    str2 = new URL(str).getHost();
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                }
                if (Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str2).find()) {
                    return true;
                }
                int indexOf = str.indexOf("[");
                int indexOf2 = str.indexOf("]");
                if (indexOf > 0 && indexOf2 > indexOf && str.substring(indexOf, indexOf2).indexOf(":") > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTranscodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TTVideoEngineLog.d("isTranscodeUrl", "----start check url:" + str);
        String queryParameter = Uri.parse(str).getQueryParameter("btag");
        if (TextUtils.isEmpty(queryParameter)) {
            TTVideoEngineLog.d("isTranscodeUrl", "get query value is null");
            return false;
        }
        TTVideoEngineLog.d("isTranscodeUrl", "get query value is:" + queryParameter);
        if (!isStringHex(queryParameter)) {
            TTVideoEngineLog.d("isTranscodeUrl", "not hex string");
            return false;
        }
        BigInteger bigInteger = new BigInteger(queryParameter, 16);
        BigInteger bigInteger2 = new BigInteger("80000", 16);
        if (bigInteger.and(bigInteger2).compareTo(bigInteger2) == 0) {
            TTVideoEngineLog.d("isTranscodeUrl", "end url is transcoded");
            return true;
        }
        TTVideoEngineLog.d("isTranscodeUrl", "****end url is not transcoded");
        return false;
    }

    public static JSONObject jsonWithError(Error error) {
        JSONObject jSONObject = null;
        if (error == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("domain", error.domain);
                jSONObject2.put("code", error.code);
                jSONObject2.put("innerCode", error.internalCode);
                jSONObject2.put("des", error.description);
                return jSONObject2;
            } catch (Throwable th) {
                th = th;
                jSONObject = jSONObject2;
                TTVideoEngineLog.e("TTVideoEngineTTHelper", "error to json fail. " + th + " " + jSONObject.toString());
                return jSONObject;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            TTVideoEngineLog.d(e);
            return "";
        }
    }

    public static String keyFromFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (context != null) {
            String appFilesPath = getAppFilesPath(context);
            if (!TextUtils.isEmpty(appFilesPath)) {
                str.replace(appFilesPath, "");
            }
        }
        return md5(str);
    }

    public static String base64Decode(String str, String str2) {
        if (!TextUtils.isEmpty(str) && isBase64(str)) {
            try {
                byte[] decode = Base64.decode(str, 0);
                if (TextUtils.isEmpty(str2)) {
                    return new String(decode, "utf-8");
                }
                return JniUtils.getDecodedStrWithKey(decode, Base64.decode(str2, 0));
            } catch (Throwable th) {
                TTVideoEngineLog.d("TTHelper", th.toString());
                return "";
            }
        }
        return str;
    }

    public static String genTrackID(String str, long j) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append("T");
        }
        sb.append(j);
        sb.append("T");
        sb.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return sb.toString();
    }

    public static Class<?> getClzUsingPluginLoader(int i, String str) throws Exception {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            ClassLoader classLoader = TTVideoEngineConfig.getClassLoader(i);
            if (classLoader == null) {
                return l3.a.q(str);
            }
            return Class.forName(str, true, classLoader);
        }
        throw new Exception("pluginName or/and className is empty");
    }

    public static String replaceHostInURL(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            String host = new URI(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return str;
            }
            return str.replaceFirst(host, str2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String appendQueryString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains(str2)) {
                return str;
            }
            if (!str.contains("?")) {
                return str + "?" + str2;
            }
            return str + "&" + str2;
        }
        return str;
    }

    public static String getParam(String str, String str2) {
        List<String> urlSlices = getUrlSlices(str, str2);
        if (urlSlices != null && urlSlices.size() != 0) {
            for (String str3 : urlSlices) {
                if (str3.startsWith(str2 + "=")) {
                    return str3.substring(str2.length() + 1);
                }
            }
        }
        return null;
    }

    private static List<String> getUrlSlices(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("[?]");
        if (split.length < 2) {
            return null;
        }
        String str3 = split[0];
        String str4 = split[1];
        int indexOf = str4.indexOf(str2 + "=");
        if (indexOf == -1) {
            return null;
        }
        arrayList.add(str3);
        arrayList.add("?");
        arrayList.add(str4.substring(0, indexOf));
        int indexOf2 = str4.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            arrayList.add(str4.substring(indexOf));
            return arrayList;
        }
        arrayList.add(str4.substring(indexOf, indexOf2));
        arrayList.add(str4.substring(indexOf2));
        return arrayList;
    }

    public static String safeGetString(Map<String, Object> map, String str, String str2) {
        Object obj;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str);
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return str2;
    }

    public static float safeGetFloat(Map<String, Object> map, String str, float f) {
        Object obj;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str);
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return f;
    }

    public static int safeGetInt(Map<String, Object> map, String str, int i) {
        Object obj;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str);
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i;
    }

    public static long safeGetLong(Map<String, Object> map, String str, long j) {
        Object obj;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str);
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return j;
    }

    public static double safeParseDouble(JSONObject jSONObject, String str, double d) {
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return d;
        }
        try {
            return Double.parseDouble(optString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return d;
        }
    }

    public static float safeParseFloat(JSONObject jSONObject, String str, float f) {
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return f;
        }
        try {
            return Float.parseFloat(optString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return f;
        }
    }

    public static String overrideUrlParam(String str, String str2, String str3) {
        List<String> urlSlices = getUrlSlices(str, str2);
        if (urlSlices != null && urlSlices.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (String str4 : urlSlices) {
                if (str4.startsWith(str2 + "=")) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                } else {
                    sb.append(str4);
                }
            }
            return sb.toString();
        }
        return str;
    }
}

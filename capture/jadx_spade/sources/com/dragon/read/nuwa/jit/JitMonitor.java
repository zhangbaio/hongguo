package com.dragon.read.nuwa.jit;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.Nuwa;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class JitMonitor {
    public static native String dumpJit();

    public static native String dumpProfileSaver();

    public static native void init();

    public static native void terminate();

    static {
        Covode.recordClassIndex(612616);
        Nuwa.loadLibrary();
    }

    public static JitInfo readJintInfo() {
        String dumpJit = dumpJit();
        if (TextUtils.isEmpty(dumpJit)) {
            return null;
        }
        JitInfo jitInfo = new JitInfo();
        for (Pair<String, String> pair : parseLine2KVPair(dumpJit, ":")) {
            try {
                if (((String) pair.first).contains("code cache entries")) {
                    jitInfo.code_cache_entries = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("baseline compilations")) {
                    jitInfo.baseline_compilations = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("optimized compilations")) {
                    jitInfo.optimized_compilations = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("compilations for on stack replacement")) {
                    jitInfo.OSR_compilations = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("code cache collections")) {
                    jitInfo.code_cache_collections = Integer.parseInt((String) pair.second);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jitInfo;
    }

    public static ProfileInfo readProfileSaverInfo() {
        String dumpProfileSaver = dumpProfileSaver();
        if (TextUtils.isEmpty(dumpProfileSaver)) {
            return null;
        }
        ProfileInfo profileInfo = new ProfileInfo();
        for (Pair<String, String> pair : parseLine2KVPair(dumpProfileSaver, "=")) {
            try {
                if (((String) pair.first).contains("total_bytes_written")) {
                    profileInfo.profile_bytes_written = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("total_number_of_writes")) {
                    profileInfo.profile_number_of_writes = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("total_ms_of_sleep")) {
                    profileInfo.profile_ms_of_sleep = Integer.parseInt((String) pair.second);
                } else if (((String) pair.first).contains("total_ms_of_work")) {
                    profileInfo.profile_ms_of_work = Integer.parseInt((String) pair.second);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return profileInfo;
    }

    private static Pair<String, String>[] parseLine2KVPair(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (String str3 : str.split("\\r?\\n")) {
            String trim = str3.trim();
            if (!trim.isEmpty() && trim.length() - trim.replace(str2, "").length() == 1) {
                int indexOf = trim.indexOf(str2);
                String trim2 = trim.substring(0, indexOf).trim();
                String trim3 = trim.substring(indexOf + 1).trim();
                if (!TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim3)) {
                    arrayList.add(new Pair(trim2, trim3));
                }
            }
        }
        return (Pair[]) arrayList.toArray(new Pair[0]);
    }
}

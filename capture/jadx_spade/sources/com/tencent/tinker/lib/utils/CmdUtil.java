package com.tencent.tinker.lib.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CmdUtil {
    static {
        Covode.recordClassIndex(653923);
    }

    private static Process com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec(Runtime runtime, String[] strArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(102900, "java/lang/Runtime", "exec", runtime, new Object[]{strArr}, "java.lang.Process", new ExtraInfo(false, "([Ljava/lang/String;)Ljava/lang/Process;"));
        return preInvoke.isIntercept() ? (Process) preInvoke.getReturnValue() : runtime.exec(strArr);
    }

    private static void consumeInputStream(InputStream inputStream) {
    }

    public static boolean execCmd(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec = com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec(Runtime.getRuntime(), strArr);
            InputStream errorStream = com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec.getErrorStream();
            InputStream inputStream = com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec.getInputStream();
            consumeInputStream(errorStream);
            consumeInputStream(inputStream);
            if (com_tencent_tinker_lib_utils_CmdUtil_java_lang_Runtime_exec.waitFor() != 0) {
                MuteLog.e("CmdUtil", "exec dex2oat failed : " + strArr.toString(), new Object[0]);
                return false;
            }
            return true;
        } catch (IOException | InterruptedException unused) {
            return false;
        }
    }
}

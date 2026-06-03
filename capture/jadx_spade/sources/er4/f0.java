package er4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.ProcessUtils;
import com.tencent.mmkv.MMKV;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class f0 {
    static {
        Covode.recordClassIndex(611480);
    }

    public static MMKV a(String str, boolean z) {
        int i;
        if (!z && !AppUtils.isOfficialBuild() && !ProcessUtils.isMainProcess(AppUtils.context())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cacheId", str);
                jSONObject.put("process", ProcessUtils.getCurProcessName(AppUtils.context()));
                com.dragon.read.base.depend.g.b.d("non_main_process_mmkv_ids", jSONObject, (JSONObject) null, (JSONObject) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        return MMKV.mmkvWithID(str, i);
    }
}

package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteSP;
import com.tencent.tinker.lib.utils.ResTranUtils;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class OverridePendingTransition extends AbsMethodDelegate {
    private final String mTag;

    static {
        Covode.recordClassIndex(653763);
    }

    public OverridePendingTransition(String str) {
        this.mTag = str;
    }

    @Override // com.tencent.tinker.lib.hook.AbsMethodDelegate
    public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        if (objArr != null && objArr.length >= 4) {
            int intValue = ((Integer) objArr[2]).intValue();
            int intValue2 = ((Integer) objArr[3]).intValue();
            MuteSP.getInst();
            if (MuteSP.getHookAnim()) {
                MuteLog.w(this.mTag, "<< %s hook, enterResId[0x%s] exitResId[0x%s]", method.getName(), Integer.toHexString(intValue), Integer.toHexString(intValue2));
                int[] transAnim = ResTranUtils.transAnim(intValue, intValue2, false);
                if (transAnim != null) {
                    objArr[2] = Integer.valueOf(transAnim[0]);
                    objArr[3] = Integer.valueOf(transAnim[1]);
                } else {
                    objArr[2] = 0;
                    objArr[3] = 0;
                }
            } else {
                MuteLog.i(this.mTag, "<< %s, enterResId[0x%s] exitResId[0x%s]", method.getName(), Integer.toHexString(intValue), Integer.toHexString(intValue2));
            }
        } else {
            MuteLog.e(this.mTag, "<< %s", method.getName());
        }
        return super.beforeInvoke(obj, method, objArr);
    }
}

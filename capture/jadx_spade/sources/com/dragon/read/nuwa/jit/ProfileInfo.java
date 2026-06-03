package com.dragon.read.nuwa.jit;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ProfileInfo {
    public int profile_bytes_written;
    public int profile_ms_of_sleep;
    public int profile_ms_of_work;
    public int profile_number_of_writes;

    static {
        Covode.recordClassIndex(612617);
    }

    public String toString() {
        return "profile_bytes_written:" + this.profile_bytes_written + ", profile_number_of_writes:" + this.profile_number_of_writes + ", profile_ms_of_sleep:" + this.profile_ms_of_sleep + ", profile_ms_of_work:" + this.profile_ms_of_work + ", ";
    }
}

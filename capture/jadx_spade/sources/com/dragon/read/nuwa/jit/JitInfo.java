package com.dragon.read.nuwa.jit;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class JitInfo {
    public int OSR_compilations;
    public int baseline_compilations;
    public int code_cache_collections;
    public int code_cache_entries;
    public int optimized_compilations;

    static {
        Covode.recordClassIndex(612615);
    }

    public String toString() {
        return "code_cache_entries:" + this.code_cache_entries + ", baseline_compilations:" + this.baseline_compilations + ", optimized_compilations:" + this.optimized_compilations + ", OSR_compilations:" + this.OSR_compilations + ", code_cache_collections:" + this.code_cache_collections + ", ";
    }
}

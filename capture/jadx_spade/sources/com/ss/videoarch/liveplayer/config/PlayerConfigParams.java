package com.ss.videoarch.liveplayer.config;

import bj6.a;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerConfigParams {

    public static class NNSRParams {
        public a<Integer> Enabled = new a<>(0);
        public a<Integer> VBitrateLowerBoundInKbps = new a<>(0);
        public a<Integer> LongerSideUpperBound = new a<>(0);
        public a<Integer> ShorterSideUpperBound = new a<>(0);
        public a<Integer> FrameRateUpperBound = new a<>(0);
        public a<Integer> SRAlgType = new a<>(0);
        public a<Integer> EnableBMFSR = new a<>(0);
        public a<Integer> BMFSRScaleType = new a<>(0);
        public a<Integer> BMFSRBackEnd = new a<>(0);
        public a<Integer> BMFSRPoolSize = new a<>(0);
        public a<Integer> EnableDynamicSR = new a<>(0);
        public a<Integer> EnableUseSRAfterInit = new a<>(0);
        public a<String> SRModuleName = new a<>("");

        static {
            Covode.recordClassIndex(653024);
        }
    }

    static {
        Covode.recordClassIndex(653023);
    }
}

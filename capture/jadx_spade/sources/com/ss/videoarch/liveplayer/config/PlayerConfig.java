package com.ss.videoarch.liveplayer.config;

import bj6.a;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.config.PlayerConfigParams;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerConfig {
    public a<Integer> VeLivePlayerKeySetHWAsyncMode = new a<>(0);
    public a<Integer> VeLivePlayerKeySetMaxCacheSeconds = new a<>(10);
    public a<Integer> VeLivePlayerKeySetDefaultBufferingEndMs = new a<>(-1);
    public a<Integer> VeLivePlayerKeySetBufferingEndIgnoreVideo = new a<>(0);
    public a<Integer> VeLivePlayerKeySetStartPlayAudioBufferThresholdMs = new a<>(0);
    public a<Integer> VeLivePlayerKeySetKernelOpenFailRetry = new a<>(-1);
    public a<Integer> VeLivePlayerKeySetABRAlgorithm = new a<>(0);
    public a<Integer> VeLivePlayerKeySetOpenTextureRender = new a<>(-1);
    public a<Integer> VeLivePlayerKeySetNTPEnable = new a<>(1);
    public a<Integer> VeLivePlayerKeySetHardwareDecode = new a<>(0);
    public a<Integer> VeLivePlayerKeySetSoftwareDecodeForidden = new a<>(1);
    public a<Integer> VeLivePlayerKeySetHurryEnable = new a<>(0);
    public a<Integer> VeLivePlayerKeySetHurryTime = new a<>(2000);
    public a<Float> VeLivePlayerKeySetHurrySpeed = new a<>(Float.valueOf(1.2f));
    public a<Integer> VeLivePlayerKeySetSlowTime = new a<>(200);
    public a<Float> VeLivePlayerKeySetSlowSpeed = new a<>(Float.valueOf(0.9f));
    public a<Integer> VeLivePlayerKeySetReportApplogEnable = new a<>(1);
    public a<Integer> VeLivePlayerKeySetReportKernelLogEnable = new a<>(0);
    public PlayerConfigParams.NNSRParams SRConfig = new PlayerConfigParams.NNSRParams();
    public a<Integer> VeLivePlayerKeySetOptimizeLivePtsRollback = new a<>(0);

    static {
        Covode.recordClassIndex(653022);
    }
}

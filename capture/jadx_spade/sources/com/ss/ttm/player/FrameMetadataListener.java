package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface FrameMetadataListener {

    /* renamed from: com.ss.ttm.player.FrameMetadataListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$didReceivePacket(FrameMetadataListener frameMetadataListener, int i, long j, long j2, Map map) {
        }

        public static void $default$onAbrDecisionInfo(FrameMetadataListener frameMetadataListener, long j, String str) {
        }

        public static void $default$receiveBinarySei(FrameMetadataListener frameMetadataListener, ByteBuffer byteBuffer) {
        }

        public static void $default$willRenderFrame(FrameMetadataListener frameMetadataListener, int i, long j, long j2, String str) {
        }
    }

    void didReceivePacket(int i, long j, long j2, Map<Integer, String> map);

    void frameDTSNotify(int i, long j, long j2);

    void onAbrDecisionInfo(long j, String str);

    void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map);

    void receiveBinarySei(ByteBuffer byteBuffer);

    void updateFrameTerminatedDTS(int i, long j, long j2);

    void willRenderFrame(int i, long j, long j2, String str);
}

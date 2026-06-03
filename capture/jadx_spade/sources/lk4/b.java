package lk4;

import bw4.d0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.goldcoinbox.pendant.video.PolarisVideoPendantMgr;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements pg1.c {
    static {
        Covode.recordClassIndex(607898);
    }

    public Map<String, String> getCustomProps() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PolarisVideoPendantMgr polarisVideoPendantMgr = PolarisVideoPendantMgr.a;
        linkedHashMap.put("enter_counter", String.valueOf(polarisVideoPendantMgr.b1()));
        linkedHashMap.put("exit_counter", String.valueOf(polarisVideoPendantMgr.c1()));
        linkedHashMap.put("coutering", String.valueOf(polarisVideoPendantMgr.d1()));
        linkedHashMap.put("show_counter", String.valueOf(polarisVideoPendantMgr.i1()));
        linkedHashMap.put("show_red_packet", String.valueOf(polarisVideoPendantMgr.k0()));
        linkedHashMap.put("show_red_packet_active", polarisVideoPendantMgr.j1().toString());
        linkedHashMap.put("show_red_packet_reward_btn", String.valueOf(polarisVideoPendantMgr.l0()));
        linkedHashMap.put("negative_pendant_pause", String.valueOf(d0.a.e("short_video")));
        return linkedHashMap;
    }
}

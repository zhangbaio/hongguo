package us4;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.NsUtilsDepend;
import com.dragon.read.component.interfaces.IBaseGlobalPlayer;
import com.dragon.read.video.layer.AbsVideoPlayEventLayer;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import eh6.l;
import pu4.e2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class j extends AbsVideoPlayEventLayer {
    private final com.dragon.read.pages.video.a f = new com.dragon.read.pages.video.a();
    public Boolean g = Boolean.FALSE;

    static {
        Covode.recordClassIndex(612518);
    }

    private void d0() {
        VideoStateInquirer videoStateInquirer;
        int i;
        if (!this.g.booleanValue() && !com.dragon.read.video.d.b().i(c0()) && (videoStateInquirer = getVideoStateInquirer()) != null) {
            if (videoStateInquirer.getDuration() != 0) {
                i = (videoStateInquirer.getCurrentPosition() * 100) / videoStateInquirer.getDuration();
            } else {
                i = 0;
            }
            SimpleMediaView Y = Y();
            this.f.p3(e2.m(Y)).g2(e2.n(Y)).N2().y2().s2().K2(Integer.valueOf(i)).H(true);
        }
    }

    private void e0() {
        if (!this.g.booleanValue() && !com.dragon.read.video.d.b().i(c0())) {
            if (getVideoStateInquirer() != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String d = i.d(Y(), "");
                com.dragon.read.video.d.b().l(c0() + d, elapsedRealtime);
            }
            SimpleMediaView Y = Y();
            this.f.p3(e2.m(Y)).g2(e2.n(Y)).N2().y2().s2().S0(true);
        }
    }

    public boolean handleVideoEvent(l lVar) {
        IBaseGlobalPlayer globalPlayManager = NsCommonDepend.IMPL.globalPlayManager();
        int type = lVar.getType();
        if (type != 105) {
            if (type != 106) {
                if (type != 115) {
                    if (type == 300 && (lVar instanceof eh6.k) && !((eh6.k) lVar).c) {
                        globalPlayManager.tryAttachToCurrentActivity(false);
                    }
                } else {
                    d0();
                }
            } else {
                d0();
            }
        } else {
            e0();
            if (NsUtilsDepend.IMPL.useNewPlayControlUI()) {
                execCommand(new wg6.b(217, Float.valueOf(r0.getCurrentPlaySpeed() / 100.0f)));
            }
        }
        return super.handleVideoEvent(lVar);
    }
}

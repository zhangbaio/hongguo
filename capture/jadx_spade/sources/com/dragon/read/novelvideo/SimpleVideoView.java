package com.dragon.read.novelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.covode.number.Covode;
import com.dragon.read.video.BaseVideoView;
import com.dragon.read.video.e;
import com.dragon.read.video.t;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SimpleVideoView extends BaseVideoView {
    static {
        Covode.recordClassIndex(612513);
    }

    public void play() {
        n();
        BaseVideoView.d.d("play target info = %s", new Object[]{t.g(this)});
        super/*com.ss.android.videoshop.mediaview.SimpleMediaView*/.play();
    }

    protected void n() {
        String str;
        boolean z;
        if (getPlayEntity() != null) {
            boolean z2 = true;
            if (getPlayEntity().getBundle() != null) {
                str = (String) getPlayEntity().getBundle().get("video_position");
                z = getPlayEntity().getBundle().getBoolean("key_mute_config");
            } else {
                str = "";
                z = true;
            }
            if ("position_book_mall".equals(str)) {
                setMute(e.b().a);
                return;
            }
            if ("position_book_detail".equals(str)) {
                if (!e.b().a || isFullScreen()) {
                    z2 = false;
                }
                setMute(z2);
                return;
            }
            if ("position_book_detail_new".equals(str)) {
                if (isFullScreen() || !z) {
                    z2 = false;
                }
                setMute(z2);
            }
        }
    }

    public SimpleVideoView(Context context) {
        super(context);
    }

    public SimpleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

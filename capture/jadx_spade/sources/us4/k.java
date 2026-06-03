package us4;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.novelvideo.SuperResolutionScene;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.video.m;
import com.ss.android.videoshop.api.IVideoPlayListener;
import com.ss.android.videoshop.api.VideoStateInquirer;
import com.ss.android.videoshop.entity.PlayEntity;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k extends com.dragon.read.video.a {
    private IVideoPlayListener h;

    static {
        Covode.recordClassIndex(612519);
    }

    protected void k() {
        super.k();
        ((com.dragon.read.video.a) this).a.registerVideoPlayListener(this.h);
        ((com.dragon.read.video.a) this).a.addOnAttachStateChangeListener(new b());
    }

    class a extends IVideoPlayListener.Stub {
        a() {
        }

        public void onVideoPreRelease(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            super.onVideoPreRelease(videoStateInquirer, playEntity);
            if (videoStateInquirer.getVideoEngine() != null) {
                m.a.a(videoStateInquirer.getVideoEngine(), SuperResolutionScene.BOOK_REC_VIDEO.name());
            }
        }

        public void onVideoPlay(VideoStateInquirer videoStateInquirer, PlayEntity playEntity) {
            super.onVideoPlay(videoStateInquirer, playEntity);
            LogWrapper.debug("VideoPlayer", "onVideoPlay, resolution: " + videoStateInquirer.getResolution(), new Object[0]);
        }
    }

    class b implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view instanceof SimpleMediaView) {
                ((SimpleMediaView) view).unregisterVideoPlayListener(k.this.h);
            }
        }
    }

    public k L(int i) {
        ((com.dragon.read.video.a) this).b.setId(i);
        return this;
    }

    public k(SimpleMediaView simpleMediaView) {
        super(simpleMediaView);
        this.h = new a();
    }

    public k D(String str) {
        if (str != null) {
            ((com.dragon.read.video.a) this).b.getBundle().putString("book_id", str);
        }
        return this;
    }

    public k E(boolean z) {
        ((com.dragon.read.video.a) this).b.getBundle().putBoolean("has_next_video_chapter", z);
        return this;
    }

    public k F(PageRecorder pageRecorder) {
        if (pageRecorder != null) {
            ((com.dragon.read.video.a) this).b.getBundle().putSerializable("video_book_page_recorder", pageRecorder);
        }
        return this;
    }

    public com.dragon.read.video.a G(String str) {
        if (str != null) {
            ((com.dragon.read.video.a) this).b.getBundle().putString("video_position", str);
        }
        return this;
    }

    public k H(String str) {
        ((com.dragon.read.video.a) this).b.getBundle().putString("series_id", str);
        return this;
    }

    public k I(boolean z) {
        ((com.dragon.read.video.a) this).b.getBundle().putBoolean("hide_next_button", z);
        return this;
    }

    public k J(boolean z) {
        ((com.dragon.read.video.a) this).b.getBundle().putBoolean("is_common_preview_mode", z);
        return this;
    }

    public k K(boolean z) {
        ((com.dragon.read.video.a) this).b.getBundle().putBoolean("is_from_video_editor", z);
        return this;
    }
}

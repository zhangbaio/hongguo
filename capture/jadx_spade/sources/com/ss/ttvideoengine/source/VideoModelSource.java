package com.ss.ttvideoengine.source;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.strategy.source.StrategySource;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoModelSource implements StrategySource {
    private final Resolution resolution;
    private final Object tag;
    private final String vid;
    private final IVideoModel videoModel;

    static {
        Covode.recordClassIndex(652688);
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return 0;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public /* synthetic */ boolean isCodecStrategyValid() {
        boolean isCodecStrategyValid;
        isCodecStrategyValid = Source.CC.isCodecStrategyValid(codecStrategy());
        return isCodecStrategyValid;
    }

    public Resolution resolution() {
        return this.resolution;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.VIDEO_MODEL_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    public IVideoModel videoModel() {
        return this.videoModel;
    }

    public static class Builder {
        private Resolution resolution;
        private Object tag;
        private String vid;
        private IVideoModel videoModel;

        static {
            Covode.recordClassIndex(652689);
        }

        public VideoModelSource build() {
            return new VideoModelSource(this);
        }

        public Builder setResolution(Resolution resolution) {
            this.resolution = resolution;
            return this;
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setVid(String str) {
            this.vid = str;
            return this;
        }

        public Builder setVideoModel(IVideoModel iVideoModel) {
            this.videoModel = iVideoModel;
            return this;
        }
    }

    public String toString() {
        return "VideoModelSource{vid='" + this.vid + "', videoModel=" + this.videoModel + ", resolution=" + this.resolution + '}';
    }

    private VideoModelSource(Builder builder) {
        this.vid = builder.vid;
        this.videoModel = builder.videoModel;
        this.resolution = builder.resolution;
        this.tag = builder.tag;
    }
}

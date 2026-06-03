package com.ss.ttvideoengine.source;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VidPlayAuthTokenSource implements StrategySource {
    public static final List<String> DEFAULT_SUPPORTED_ENCODE_TYPES;
    private final int codecStrategy;
    private final String encodeType;
    private final String playAuthToken;
    private final Resolution resolution;
    private final List<String> supportedEncodeTypes;
    private final Object tag;
    private final String vid;

    @Override // com.ss.ttvideoengine.source.Source
    public /* synthetic */ boolean isCodecStrategyValid() {
        boolean isCodecStrategyValid;
        isCodecStrategyValid = Source.CC.isCodecStrategyValid(codecStrategy());
        return isCodecStrategyValid;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public String encodeType() {
        return this.encodeType;
    }

    public String playAuthToken() {
        return this.playAuthToken;
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
        return Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    public List<String> supportedEncodeTypes() {
        return Collections.unmodifiableList(this.supportedEncodeTypes);
    }

    static {
        Covode.recordClassIndex(652686);
        DEFAULT_SUPPORTED_ENCODE_TYPES = Collections.unmodifiableList(Arrays.asList("h264", "bytevc1", "bytevc2"));
    }

    public static class Builder {
        private int codecStrategy;
        private String encodeType;
        private String playAuthToken;
        private Resolution resolution;
        private List<String> supportedEncodeTypes;
        private Object tag;
        private String vid;

        static {
            Covode.recordClassIndex(652687);
        }

        public Builder() {
        }

        public VidPlayAuthTokenSource build() {
            String str;
            if (this.vid != null) {
                if (this.playAuthToken != null) {
                    if (this.resolution == null) {
                        this.resolution = Resolution.Standard;
                    }
                    List<String> list = this.supportedEncodeTypes;
                    if (list != null && (str = this.encodeType) != null && !list.contains(str)) {
                        throw new IllegalArgumentException("supportedEncodeTypes:" + this.supportedEncodeTypes + " must contains encodeType:" + this.encodeType);
                    }
                    List<String> list2 = this.supportedEncodeTypes;
                    if (list2 == null || list2.isEmpty()) {
                        this.supportedEncodeTypes = VidPlayAuthTokenSource.DEFAULT_SUPPORTED_ENCODE_TYPES;
                    }
                    return new VidPlayAuthTokenSource(this);
                }
                throw new NullPointerException("playAuthToken is null");
            }
            throw new NullPointerException("vid is null");
        }

        public Builder setCodecStrategy(int i) {
            this.codecStrategy = i;
            return this;
        }

        public Builder setEncodeType(String str) {
            this.encodeType = str;
            return this;
        }

        public Builder setResolution(Resolution resolution) {
            this.resolution = resolution;
            return this;
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setPlayAuthToken(String str) {
            if (str != null) {
                this.playAuthToken = str;
                return this;
            }
            throw new NullPointerException("playAuthToken is null");
        }

        public Builder setVid(String str) {
            if (str != null) {
                this.vid = str;
                return this;
            }
            throw new NullPointerException("vid is null");
        }

        public Builder setSupportedEncodeTypes(List<String> list) {
            if (list != null && !list.isEmpty()) {
                this.supportedEncodeTypes = new ArrayList(list);
                return this;
            }
            throw new IllegalArgumentException("supportedEncodeTypes can't be null or empty!");
        }

        public Builder(VidPlayAuthTokenSource vidPlayAuthTokenSource) {
            this.vid = vidPlayAuthTokenSource.vid;
            this.playAuthToken = vidPlayAuthTokenSource.playAuthToken;
            this.encodeType = vidPlayAuthTokenSource.encodeType;
            this.resolution = vidPlayAuthTokenSource.resolution;
            this.codecStrategy = vidPlayAuthTokenSource.codecStrategy;
        }
    }

    public String toString() {
        return "VidPlayAuthTokenSource{vid='" + this.vid + "', playAuthToken='" + this.playAuthToken + "', encodeType='" + this.encodeType + "', supportedEncodeTypes=" + this.supportedEncodeTypes + ", resolution=" + this.resolution + ", codecStrategy=" + this.codecStrategy + '}';
    }

    private VidPlayAuthTokenSource(Builder builder) {
        this.vid = builder.vid;
        this.playAuthToken = builder.playAuthToken;
        this.encodeType = builder.encodeType;
        this.supportedEncodeTypes = builder.supportedEncodeTypes;
        this.resolution = builder.resolution;
        this.codecStrategy = builder.codecStrategy;
        this.tag = builder.tag;
    }
}

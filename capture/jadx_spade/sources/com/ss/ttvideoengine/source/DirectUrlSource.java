package com.ss.ttvideoengine.source;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DirectUrlSource implements StrategySource {
    private final int codecStrategy;
    private final boolean smartUrlEnabled;
    private final int smartUrlVersion;
    private final Object tag;
    private final List<UrlItem> urlItems;
    private final String vid;

    static {
        Covode.recordClassIndex(652679);
    }

    @Override // com.ss.ttvideoengine.source.Source
    public /* synthetic */ boolean isCodecStrategyValid() {
        boolean isCodecStrategyValid;
        isCodecStrategyValid = Source.CC.isCodecStrategyValid(codecStrategy());
        return isCodecStrategyValid;
    }

    public static class UrlItem {
        private final int bitrate;
        private final String cacheKey;
        private final String encodeType;
        private final String format;
        private final String playAuth;
        private final long urlExpiredTime;
        private final String[] urlExpires;
        private final String[] urls;

        static {
            Covode.recordClassIndex(652681);
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public String getCacheKey() {
            return this.cacheKey;
        }

        public String getEncodeType() {
            return this.encodeType;
        }

        public String getFormat() {
            return this.format;
        }

        public String getPlayAuth() {
            return this.playAuth;
        }

        public long getUrlExpiredTime() {
            return this.urlExpiredTime;
        }

        public String[] getUrlExpires() {
            return this.urlExpires;
        }

        public String[] getUrls() {
            return this.urls;
        }

        public static class Builder {
            private int bitrate;
            private String cacheKey;
            private String encodeType;
            private String format;
            private String playAuth;
            private long urlExpiredTime;
            private String[] urlExpires;
            private String[] urls;

            static {
                Covode.recordClassIndex(652682);
            }

            public Builder() {
                this.bitrate = -1;
            }

            public UrlItem build() {
                checkUrls(this.urls);
                return new UrlItem(this);
            }

            public Builder setBitrate(int i) {
                this.bitrate = i;
                return this;
            }

            public Builder setCacheKey(String str) {
                this.cacheKey = str;
                return this;
            }

            public Builder setEncodeType(String str) {
                this.encodeType = str;
                return this;
            }

            public Builder setFormat(String str) {
                this.format = str;
                return this;
            }

            public Builder setPlayAuth(String str) {
                this.playAuth = str;
                return this;
            }

            Builder setUrlExpiredTime(long j) {
                this.urlExpiredTime = j;
                return this;
            }

            public Builder setUrlExpires(String[] strArr) {
                this.urlExpires = strArr;
                return this;
            }

            public Builder setUrls(String[] strArr) {
                checkUrls(strArr);
                this.urls = strArr;
                return this;
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.urls = new String[]{str};
                    return this;
                }
                throw new NullPointerException("url = null");
            }

            public Builder setUrlExpire(String str) {
                if (str != null) {
                    this.urlExpires = new String[]{str};
                    return this;
                }
                throw new NullPointerException("expire = null");
            }

            public Builder(UrlItem urlItem) {
                this.bitrate = -1;
                this.urls = urlItem.urls;
                this.urlExpires = urlItem.urlExpires;
                this.urlExpiredTime = urlItem.urlExpiredTime;
                this.cacheKey = urlItem.cacheKey;
                this.playAuth = urlItem.playAuth;
                this.encodeType = urlItem.encodeType;
                this.format = urlItem.format;
                this.bitrate = urlItem.bitrate;
            }

            private static void checkUrls(String[] strArr) {
                if (strArr != null) {
                    if (strArr.length != 0) {
                        if (!TextUtils.isEmpty(strArr[0])) {
                            return;
                        } else {
                            throw new IllegalArgumentException("urls[0] = null");
                        }
                    }
                    throw new IllegalArgumentException("urls is empty");
                }
                throw new NullPointerException("urls = null");
            }
        }

        public String getUrl() {
            return this.urls[0];
        }

        public String getUrlExpire() {
            String[] strArr = this.urlExpires;
            if (strArr != null) {
                return strArr[0];
            }
            return null;
        }

        public String toString() {
            return "UrlItem{urls=" + Arrays.toString(this.urls) + ", urlExpires=" + Arrays.toString(this.urlExpires) + ", urlExpiredTime=" + this.urlExpiredTime + ", cacheKey='" + this.cacheKey + "', playAuth='" + this.playAuth + "', encodeType='" + this.encodeType + "', format='" + this.format + "', bitrate=" + this.bitrate + '}';
        }

        private UrlItem(Builder builder) {
            a.a(builder.urls);
            this.urls = builder.urls;
            this.urlExpires = builder.urlExpires;
            this.urlExpiredTime = builder.urlExpiredTime;
            this.cacheKey = builder.cacheKey;
            this.playAuth = builder.playAuth;
            this.encodeType = builder.encodeType;
            this.format = builder.format;
            this.bitrate = builder.bitrate;
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public boolean isSmartUrlEnabled() {
        return this.smartUrlEnabled;
    }

    public int smartUrlVersion() {
        return this.smartUrlVersion;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.DIRECT_URL_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    public List<UrlItem> allItems() {
        return Collections.unmodifiableList(this.urlItems);
    }

    public boolean isEmpty() {
        return this.urlItems.isEmpty();
    }

    public boolean isSmartUrlValid() {
        int i;
        if (this.smartUrlEnabled && ((i = this.smartUrlVersion) == 2 || i == 1)) {
            return true;
        }
        return false;
    }

    public static class Builder {
        private int codecStrategy;
        private boolean smartUrlEnabled;
        private Object tag;
        private String vid;
        private final List<UrlItem> items = new ArrayList();
        private int smartUrlVersion = 1;

        static {
            Covode.recordClassIndex(652680);
        }

        public DirectUrlSource build() {
            if (!this.items.isEmpty()) {
                return new DirectUrlSource(this);
            }
            throw new IllegalArgumentException("items is empty");
        }

        public Builder setCodecStrategy(int i) {
            this.codecStrategy = i;
            return this;
        }

        public Builder setSmartUrlEnabled(boolean z) {
            this.smartUrlEnabled = z;
            return this;
        }

        public Builder setSmartUrlVersion(int i) {
            this.smartUrlVersion = i;
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

        public Builder addItem(UrlItem urlItem) {
            if (urlItem != null) {
                this.items.add(urlItem);
                return this;
            }
            throw new NullPointerException("urlItem = null");
        }
    }

    public UrlItem firstItem() {
        if (this.urlItems.isEmpty()) {
            return null;
        }
        return this.urlItems.get(0);
    }

    public String toString() {
        return "DirectUrlSource{vid='" + this.vid + "', urlItems=" + this.urlItems + ", codecStrategy=" + this.codecStrategy + ", smartUrlEnabled=" + this.smartUrlEnabled + ", smartUrlVersion=" + this.smartUrlVersion + '}';
    }

    public UrlItem findItemByEncodeType(String str) {
        for (UrlItem urlItem : this.urlItems) {
            if (TextUtils.equals(urlItem.encodeType, str)) {
                return urlItem;
            }
        }
        return null;
    }

    private DirectUrlSource(Builder builder) {
        String str;
        ArrayList arrayList = new ArrayList();
        this.urlItems = arrayList;
        if (builder.vid != null) {
            str = builder.vid;
        } else {
            str = UUID.randomUUID().toString();
        }
        this.vid = str;
        arrayList.addAll(builder.items);
        this.codecStrategy = builder.codecStrategy;
        this.smartUrlEnabled = builder.smartUrlEnabled;
        this.smartUrlVersion = builder.smartUrlVersion;
        this.tag = builder.tag;
    }
}

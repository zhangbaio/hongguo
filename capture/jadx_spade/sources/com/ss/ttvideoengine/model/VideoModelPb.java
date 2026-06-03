package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface VideoModelPb {

    public static final class Audio {
        public AudioMeta audioMeta;
        public String backupUrl;
        public BaseRangeInfo baseRangeInfo;
        public CheckInfo checkInfo;
        public EncryptInfo encryptInfo;
        public String mainUrl;
        public P2PInfo p2PInfo;

        static {
            Covode.recordClassIndex(652554);
        }
    }

    public static final class AudioMeta {
        public String atype;
        public long bitrate;
        public String codecType;
        public String definition;
        public String fileHash;
        public String fileId;
        public String quality;
        public String qualityDesc;
        public long size;

        static {
            Covode.recordClassIndex(652555);
        }
    }

    public static final class BarrageInfo {
        public String barrageMaskOffset;

        static {
            Covode.recordClassIndex(652556);
        }
    }

    public static final class BaseRangeInfo {
        public String indexRange;
        public String initRange;

        static {
            Covode.recordClassIndex(652557);
        }
    }

    public static final class BigThumb {
        public double duration;
        public String fext;
        public long imgNum;
        public String imgUri;
        public String imgUrl;
        public long imgXLen;
        public long imgXSize;
        public long imgYLen;
        public long imgYSize;
        public double interval;

        static {
            Covode.recordClassIndex(652558);
        }
    }

    public static final class CheckInfo {
        public String checkInfo;

        static {
            Covode.recordClassIndex(652559);
        }
    }

    public static final class DNS {
        public String[] dns;

        static {
            Covode.recordClassIndex(652560);
        }
    }

    public static final class DNSInfo {
        public Map<String, DNS> dnsInfo;
        public long dnsTime;

        static {
            Covode.recordClassIndex(652561);
        }
    }

    public static final class DynamicVideo {
        public String backupUrl;
        public Audio[] dynamicAudioList;
        public String dynamicType;
        public Video[] dynamicVideoList;
        public String mainUrl;

        static {
            Covode.recordClassIndex(652562);
        }
    }

    public static final class EncryptInfo {
        public boolean encrypt;
        public String kid;
        public String spadeA;

        static {
            Covode.recordClassIndex(652563);
        }
    }

    public static final class P2PInfo {
        public String p2PVerifyUrl;

        static {
            Covode.recordClassIndex(652565);
        }
    }

    public static final class SeekOffSet {
        public double ending;
        public double opening;

        static {
            Covode.recordClassIndex(652566);
        }
    }

    public static final class Video {
        public String backupUrl;
        public BarrageInfo barrageInfo;
        public BaseRangeInfo baseRangeInfo;
        public CheckInfo checkInfo;
        public EncryptInfo encryptInfo;
        public String mainUrl;
        public P2PInfo p2PInfo;
        public VideoMeta videoMeta;

        static {
            Covode.recordClassIndex(652567);
        }
    }

    public static final class VideoInfo {
        public String barrageMaskUrl;
        public BigThumb[] bigThumbs;
        public DNSInfo dnsInfo;
        public DynamicVideo dynamicVideo;
        public boolean enableSsl;
        public FallBackAPI fallbackApi;
        public String mediaType;
        public String message;
        public SeekOffSet seekTs;
        public long status;
        public long urlExpire;
        public long version;
        public double videoDuration;
        public String videoId;
        public Video[] videoList;

        static {
            Covode.recordClassIndex(652568);
        }
    }

    public static final class FallBackAPI {
        private static volatile FallBackAPI[] _emptyArray;
        public String fallbackApi;
        public String keySeed;

        static {
            Covode.recordClassIndex(652564);
        }

        public static FallBackAPI[] emptyArray() {
            return _emptyArray;
        }
    }

    public static final class VideoMeta {
        public long bitrate;
        public String codecType;
        public String definition;
        public String fileHash;
        public String fileId;
        public long fps;
        public String quality;
        public String qualityDesc;
        public long size;
        public long vheight;
        public String vtype;
        public long vwidth;

        static {
            Covode.recordClassIndex(652569);
        }

        public VideoMeta clear() {
            return this;
        }

        public VideoMeta() {
            clear();
        }
    }
}

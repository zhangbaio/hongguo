package com.ss.ttvideoengine.source.strategy;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.selector.BestResolution;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CodecStrategy {
    public static final List<Dimension> COST_SAVING_FIRST_LIST;
    public static final List<Dimension> FALLBACK_LIST;
    public static final List<Dimension> HARDWARE_DECODE_FIRST_LIST;

    public static boolean isCodecStrategyValid(int i) {
        return i == 1 || i == 2;
    }

    public static final class SmartUrlVod {
        private static final Resolution SMART_URL_DEFAULT_RESOLUTION;

        public static String encodeType() {
            return "bytevc1";
        }

        public static Resolution videoResolution() {
            return SMART_URL_DEFAULT_RESOLUTION;
        }

        public static String getApiHost() {
            return AppInfo.getSmartUrlApiHost();
        }

        static {
            Covode.recordClassIndex(652694);
            SMART_URL_DEFAULT_RESOLUTION = Resolution.SuperHigh;
        }

        public static boolean isSettingsEnable() {
            if (InfoWrapper.getSmartUrlEnabled() == 1) {
                return true;
            }
            return false;
        }

        public static Resolution findTargetResolution(IVideoModel iVideoModel) {
            return BestResolution.findDefaultResolution(iVideoModel, videoResolution());
        }

        public static boolean isEnable(DirectUrlSource directUrlSource) {
            if (directUrlSource.isSmartUrlValid() && isSettingsEnable()) {
                return true;
            }
            return false;
        }
    }

    public static final class Decoder {
        static {
            Covode.recordClassIndex(652691);
        }

        private static boolean isSupportByteVC1HardwareDecode() {
            if (InfoWrapper.getByteVC1HardwareEnable() == 1) {
                return true;
            }
            return false;
        }

        private static boolean isSupportByteVC1SoftwareCapability() {
            if (InfoWrapper.getByteVC1SoftwareCapabilityEnable() == 1) {
                return true;
            }
            return false;
        }

        private static boolean isSupportByteVC1SoftwareDecode() {
            if (InfoWrapper.getByteVC1SoftwareEnable() == 1) {
                return true;
            }
            return false;
        }

        private static boolean isSupportByteVC2SoftWareDecode() {
            if (InfoWrapper.getByteVC2SoftwareEnable() == 1) {
                return true;
            }
            return false;
        }

        private static boolean isSupportH264HardwareDecode() {
            if (InfoWrapper.getH264HardwareEnable() == 1) {
                return true;
            }
            return false;
        }

        public static boolean isSupport(Dimension dimension) {
            if (isDeviceSupport(dimension) && isSDKSupport(dimension)) {
                return true;
            }
            return false;
        }

        private static boolean isSDKSupport(Dimension dimension) {
            int i = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[dimension.ordinal()];
            if (i == 1) {
                return true;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 || i == 5) {
                        return true;
                    }
                    throw new IllegalArgumentException("unsupported dimension! " + dimension);
                }
                return FeatureManager.hasPermission("bytevc2");
            }
            return isSupportByteVC1SoftwareCapability();
        }

        private static boolean isDeviceSupport(Dimension dimension) {
            int i = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[dimension.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return true;
                            }
                            throw new IllegalArgumentException("unsupported dimension! " + dimension);
                        }
                        return isSupportH264HardwareDecode();
                    }
                    if (isSupportByteVC1SoftwareDecode()) {
                        return isSupportByteVC2SoftWareDecode();
                    }
                    return false;
                }
                return isSupportByteVC1SoftwareDecode();
            }
            return isSupportByteVC1HardwareDecode();
        }
    }

    /* renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$Source$Type;
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension;

        static {
            int[] iArr = new int[Source.Type.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type = iArr;
            try {
                iArr[Source.Type.DIRECT_URL_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Dimension.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension = iArr2;
            try {
                iArr2[Dimension.BYTEVC1_HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC1_SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC2_SOFTWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_HARDWARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_SOFTWARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum Dimension {
        BYTEVC1_HARDWARE(1, "bytevc1"),
        BYTEVC1_SOFTWARE(0, "bytevc1"),
        BYTEVC2_SOFTWARE(0, "bytevc2"),
        H264_HARDWARE(1, "h264"),
        H264_SOFTWARE(0, "h264");

        public final int decoder;
        public final String encodeType;

        static {
            Covode.recordClassIndex(652692);
        }

        Dimension(int i, String str) {
            this.decoder = i;
            this.encodeType = str;
        }
    }

    public static class ResolveResult {
        public Dimension correctedDimension;
        public final Dimension dimension;
        public final DirectUrlSource.UrlItem requestItem;
        public final StrategySource source;
        public final DirectUrlSource.UrlItem urlItem;

        static {
            Covode.recordClassIndex(652693);
        }

        public String toString() {
            return "ResolveResult{vid=" + this.source.vid() + ", sourceType=" + this.source.type() + ", dimension=" + this.dimension + ", correctedDimension=" + this.correctedDimension + ", urlItem=" + this.urlItem + ", requestItem=" + this.requestItem + '}';
        }

        public ResolveResult(VidPlayAuthTokenSource vidPlayAuthTokenSource, Dimension dimension) {
            this.source = vidPlayAuthTokenSource;
            this.dimension = dimension;
            this.urlItem = null;
            this.requestItem = null;
        }

        public ResolveResult(DirectUrlSource directUrlSource, Dimension dimension, DirectUrlSource.UrlItem urlItem, DirectUrlSource.UrlItem urlItem2) {
            this.source = directUrlSource;
            this.dimension = dimension;
            this.urlItem = urlItem;
            this.requestItem = urlItem2;
        }
    }

    static {
        Covode.recordClassIndex(652690);
        Dimension dimension = Dimension.BYTEVC2_SOFTWARE;
        Dimension dimension2 = Dimension.BYTEVC1_HARDWARE;
        Dimension dimension3 = Dimension.BYTEVC1_SOFTWARE;
        Dimension dimension4 = Dimension.H264_HARDWARE;
        Dimension dimension5 = Dimension.H264_SOFTWARE;
        COST_SAVING_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(dimension, dimension2, dimension3, dimension4, dimension5));
        HARDWARE_DECODE_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(dimension2, dimension4, dimension, dimension3, dimension5));
        FALLBACK_LIST = Collections.unmodifiableList(Arrays.asList(dimension5, dimension4, dimension3, dimension2, dimension));
    }

    public static String dump() {
        return "smartUrl=" + InfoWrapper.getSmartUrlEnabled() + ", 4_h=" + InfoWrapper.getH264HardwareEnable() + ", b_h=" + InfoWrapper.getByteVC1HardwareEnable() + ", b_s=" + InfoWrapper.getByteVC1SoftwareEnable() + ", b_s_cap=" + InfoWrapper.getByteVC1SoftwareCapabilityEnable() + ", b2_s=" + InfoWrapper.getByteVC2SoftwareEnable();
    }

    public static List<Dimension> fallbackDimensions(StrategySource strategySource) {
        return supportedDimensions(strategySource, FALLBACK_LIST);
    }

    public static List<Dimension> dimensions(StrategySource strategySource) {
        int codecStrategy = strategySource.codecStrategy();
        if (codecStrategy == 1) {
            return supportedDimensions(strategySource, COST_SAVING_FIRST_LIST);
        }
        if (codecStrategy == 2) {
            return supportedDimensions(strategySource, HARDWARE_DECODE_FIRST_LIST);
        }
        throw new IllegalArgumentException("unsupported strategy! " + codecStrategy);
    }

    public static ResolveResult resolveFallback(StrategySource strategySource, List<Dimension> list) {
        List<Dimension> fallbackDimensions = fallbackDimensions(strategySource);
        Source.Type type = strategySource.type();
        int i = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return resolveVidPlayAuthToken((VidPlayAuthTokenSource) strategySource, fallbackDimensions, list);
            }
            throw new IllegalArgumentException("unsupported type! " + type);
        }
        return resolveDirectUrl((DirectUrlSource) strategySource, fallbackDimensions, list);
    }

    private static List<Dimension> supportedDimensions(StrategySource strategySource, List<Dimension> list) {
        List<String> list2;
        if (strategySource.type() == Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE) {
            list2 = ((VidPlayAuthTokenSource) strategySource).supportedEncodeTypes();
        } else {
            list2 = null;
        }
        ArrayList arrayList = new ArrayList();
        for (Dimension dimension : list) {
            if (Decoder.isSupport(dimension) && (list2 == null || list2.contains(dimension.encodeType))) {
                arrayList.add(dimension);
            }
        }
        return arrayList;
    }

    public static ResolveResult resolveStartPlayback(StrategySource strategySource, boolean z) {
        List<Dimension> dimensions = dimensions(strategySource);
        Source.Type type = strategySource.type();
        int i = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return resolveVidPlayAuthToken((VidPlayAuthTokenSource) strategySource, dimensions, null);
            }
            throw new IllegalArgumentException("unsupported type! " + type);
        }
        DirectUrlSource directUrlSource = (DirectUrlSource) strategySource;
        if (SmartUrlVod.isEnable(directUrlSource) && z) {
            return resolveSmartUrl(directUrlSource, dimensions, null);
        }
        return resolveDirectUrl(directUrlSource, dimensions, null);
    }

    private static ResolveResult resolveDirectUrl(DirectUrlSource directUrlSource, List<Dimension> list, List<Dimension> list2) {
        if (directUrlSource.allItems().isEmpty()) {
            return null;
        }
        for (Dimension dimension : list) {
            if (list2 == null || !list2.contains(dimension)) {
                DirectUrlSource.UrlItem findItemByEncodeType = directUrlSource.findItemByEncodeType(dimension.encodeType);
                if (findItemByEncodeType != null) {
                    return new ResolveResult(directUrlSource, dimension, findItemByEncodeType, null);
                }
            }
        }
        return null;
    }

    private static ResolveResult resolveVidPlayAuthToken(VidPlayAuthTokenSource vidPlayAuthTokenSource, List<Dimension> list, List<Dimension> list2) {
        for (Dimension dimension : list) {
            if (list2 == null || !list2.contains(dimension)) {
                if (vidPlayAuthTokenSource.encodeType() == null || TextUtils.equals(vidPlayAuthTokenSource.encodeType(), dimension.encodeType)) {
                    return new ResolveResult(vidPlayAuthTokenSource, dimension);
                }
            }
        }
        return null;
    }

    public static Dimension resolveWithEncoderType(String str, StrategySource strategySource, List<Dimension> list) {
        for (Dimension dimension : dimensions(strategySource)) {
            if (list == null || !list.contains(dimension)) {
                if (TextUtils.equals(str, dimension.encodeType)) {
                    return dimension;
                }
            }
        }
        return null;
    }

    private static ResolveResult resolveSmartUrl(DirectUrlSource directUrlSource, List<Dimension> list, List<Dimension> list2) {
        if (directUrlSource.allItems().isEmpty()) {
            return null;
        }
        ArrayList<Dimension> arrayList = new ArrayList();
        for (Dimension dimension : list) {
            if (list2 == null || !list2.contains(dimension)) {
                arrayList.add(dimension);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        for (Dimension dimension2 : arrayList) {
            DirectUrlSource.UrlItem findItemByEncodeType = directUrlSource.findItemByEncodeType(dimension2.encodeType);
            if (findItemByEncodeType != null) {
                return new ResolveResult(directUrlSource, dimension2, findItemByEncodeType, null);
            }
            if (TextUtils.equals(dimension2.encodeType, SmartUrlVod.encodeType())) {
                return new ResolveResult(directUrlSource, dimension2, null, directUrlSource.firstItem());
            }
        }
        return null;
    }
}

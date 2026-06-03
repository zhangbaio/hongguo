package cj6;

import android.os.Bundle;
import cj6.b;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.videoarch.liveplayer.AdaptiveGradingConfig;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements b {
    private String c;
    private AdaptiveGradingConfig d;
    public int a = 1920;
    public int b = 1920;
    private long e = 2000;

    static {
        Covode.recordClassIndex(653031);
    }

    private void f(b.a aVar) {
        VideoSurface videoSurface;
        AdaptiveGradingConfig adaptiveGradingConfig;
        if (aVar != null && (videoSurface = aVar.b) != null && (adaptiveGradingConfig = aVar.a) != null) {
            c(adaptiveGradingConfig, videoSurface);
        }
    }

    public void b(VideoSurface videoSurface) {
        if (videoSurface == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 21);
        bundle.putInt("effect_type", 14);
        bundle.putInt("max_height", this.b);
        bundle.putInt("max_width", this.a);
        bundle.putString("cache_file", this.c);
        bundle.putLong("gop_time_ms", this.e);
        AdaptiveGradingConfig adaptiveGradingConfig = this.d;
        if (adaptiveGradingConfig != null) {
            float[] fArr = adaptiveGradingConfig.mBrightnessThreshold;
            if (fArr != null) {
                bundle.putFloatArray("brightness_threshold", fArr);
            }
            float[] fArr2 = this.d.mContrastThreshold;
            if (fArr2 != null) {
                bundle.putFloatArray("contrast_threshold", fArr2);
            }
            float[] fArr3 = this.d.mSaturationThreshold;
            if (fArr3 != null) {
                bundle.putFloatArray("saturation_threshold", fArr3);
            }
        }
        bundle.putInt("int_value", 1);
        videoSurface.setEffect(bundle);
    }

    public void e(VideoSurface videoSurface) {
        if (videoSurface == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 19);
        bundle.putInt("effect_type", 14);
        bundle.putInt("int_value", 1);
        videoSurface.setEffect(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 140);
        bundle2.putInt("effect_type", 14);
        bundle2.putBoolean("is_new_frame", true);
        bundle2.putInt("int_value", 1);
        AdaptiveGradingConfig adaptiveGradingConfig = this.d;
        if (adaptiveGradingConfig != null) {
            bundle2.putFloat("dst_brightness", adaptiveGradingConfig.mBrightness);
            bundle2.putFloat("dst_contrast", this.d.mContrast);
            bundle2.putFloat("dst_saturation", this.d.mSaturation);
        }
        videoSurface.setEffect(bundle2);
    }

    private void g(String str, VideoSurface videoSurface) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("video_color_hist")) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("video_color_hist");
            if (jSONObject2.optInt("valid") != 1) {
                return;
            }
            AdaptiveGradingConfig adaptiveGradingConfig = new AdaptiveGradingConfig();
            adaptiveGradingConfig.mBrightness = (float) jSONObject2.optDouble("constract");
            adaptiveGradingConfig.mContrast = (float) jSONObject2.optDouble("brightness");
            adaptiveGradingConfig.mSaturation = (float) jSONObject2.optDouble("saturation");
            d(adaptiveGradingConfig, videoSurface);
        } catch (Exception unused) {
        }
    }

    public void c(AdaptiveGradingConfig adaptiveGradingConfig, VideoSurface videoSurface) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 140);
        bundle.putInt("effect_type", 14);
        bundle.putFloat("dst_brightness", adaptiveGradingConfig.mBrightness);
        bundle.putFloat("dst_contrast", adaptiveGradingConfig.mContrast);
        bundle.putFloat("dst_saturation", adaptiveGradingConfig.mSaturation);
        videoSurface.setEffect(bundle);
    }

    public void d(AdaptiveGradingConfig adaptiveGradingConfig, VideoSurface videoSurface) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 140);
        bundle.putInt("effect_type", 14);
        bundle.putFloat("src_saturation", adaptiveGradingConfig.mSaturation);
        bundle.putFloat("src_contrast", adaptiveGradingConfig.mContrast);
        bundle.putFloat("src_brightness", adaptiveGradingConfig.mBrightness);
        videoSurface.setEffect(bundle);
    }

    @Override // cj6.b
    public void a(int i, int i2, String str, Object obj) {
        switch (i) {
            case 100:
                if (obj instanceof b.a) {
                    f((b.a) obj);
                    break;
                } else if (obj instanceof AdaptiveGradingConfig) {
                    this.d = (AdaptiveGradingConfig) obj;
                    break;
                }
                break;
            case 101:
                if (obj instanceof VideoSurface) {
                    b((VideoSurface) obj);
                    break;
                }
                break;
            case 102:
                if (obj instanceof VideoSurface) {
                    e((VideoSurface) obj);
                    break;
                }
                break;
            case 103:
                this.e = i2;
                break;
            case 104:
                this.c = str;
                break;
            case 105:
                if (obj instanceof VideoSurface) {
                    g(str, (VideoSurface) obj);
                    break;
                }
                break;
        }
    }
}

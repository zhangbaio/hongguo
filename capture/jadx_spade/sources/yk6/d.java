package yk6;

import android.util.Log;
import com.audiosdk.audiometrics.AudioMetricsLite;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import xk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d implements c {
    private boolean b;
    private AudioMetricsLite c;
    public e f;
    private PlayEngineInfo h;
    private final String a = "[{\"type\":\"alg_param\",\"param\":{\"sample_rate\":44100,\"num_channel\":2,\"max_block_size\":8000,\"online\":true}}]";
    public int d = 2;
    private final bl6.a e = new bl6.a("MonitorAudioProcessor");
    public int g = -1;
    public final c.a i = new a();

    static {
        Covode.recordClassIndex(655883);
    }

    private final void g() {
        xk6.c.e.g(this.i);
        this.g = -1;
        this.f = null;
    }

    private final void f() {
        if (this.g < 0) {
            xk6.c cVar = xk6.c.e;
            cVar.f(this.i);
            this.g = 0;
            e eVar = new e();
            eVar.c = cVar.d();
            this.f = eVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cc, code lost:
    
        if (r2 != null) goto L57;
     */
    @Override // yk6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yk6.d.c():void");
    }

    public static final class a implements c.a {
        public int a = xk6.c.e.d();

        a() {
        }

        @Override // xk6.c.a
        public void a(int i) {
            d.this.e.d("MonitorAudioProcessor", "onVolumeChanged, currentVolume = " + i);
            d dVar = d.this;
            int i2 = dVar.g;
            if (i2 >= 0) {
                if (this.a != i) {
                    dVar.g = i2 + 1;
                }
                this.a = i;
            }
        }
    }

    @Override // yk6.c
    public void b(int i) {
        if (!this.b) {
            return;
        }
        g();
        AudioMetricsLite audioMetricsLite = this.c;
        if (audioMetricsLite != null) {
            audioMetricsLite.f();
        }
        AudioMetricsLite audioMetricsLite2 = this.c;
        if (audioMetricsLite2 != null) {
            audioMetricsLite2.e();
        }
        this.e.d("MonitorAudioProcessor", "audioRelease, reason = " + i);
    }

    @Override // yk6.c
    public void a(PlayEngineInfo playEngineInfo, ByteBuffer[] byteBufferArr, int i, long j) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        if (!this.b) {
            return;
        }
        this.e.a("MonitorAudioProcessor", "audioProcess, samples = " + i + ", timestamp = " + j + ", this = " + hashCode());
        f();
        Integer num = null;
        if (byteBufferArr != null) {
            byteBuffer = byteBufferArr[0];
        } else {
            byteBuffer = null;
        }
        if (byteBuffer != null) {
            if (byteBufferArr != null) {
                byteBuffer3 = byteBufferArr[1];
            } else {
                byteBuffer3 = null;
            }
            if (byteBuffer3 != null) {
                float[] a2 = xk6.d.a(byteBufferArr[0]);
                float[] a3 = xk6.d.a(byteBufferArr[1]);
                ArrayList arrayList = new ArrayList();
                if (a2 != null && a3 != null) {
                    arrayList.add(a2);
                    arrayList.add(a3);
                    float[] fArr = new float[a2.length + a3.length];
                    if (xk6.d.b(arrayList, fArr)) {
                        AudioMetricsLite audioMetricsLite = this.c;
                        if (audioMetricsLite != null) {
                            num = Integer.valueOf(audioMetricsLite.d(fArr, i, this.d));
                        }
                        this.e.a("MonitorAudioProcessor", "audioProcess, processRes = " + num);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (byteBufferArr != null) {
            byteBuffer2 = byteBufferArr[0];
        } else {
            byteBuffer2 = null;
        }
        if (byteBuffer2 != null) {
            AudioMetricsLite audioMetricsLite2 = this.c;
            if (audioMetricsLite2 != null) {
                audioMetricsLite2.d(xk6.d.a(byteBufferArr[0]), i, this.d);
                return;
            }
            return;
        }
        bl6.a aVar = this.e;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("invalid channel num is ");
        if (byteBufferArr != null) {
            num = Integer.valueOf(byteBufferArr.length);
        }
        sb.append(num);
        objArr[0] = sb.toString();
        aVar.b("MonitorAudioProcessor", objArr);
    }

    @Override // yk6.c
    public void d(PlayEngineInfo playEngineInfo, int i, int i2, int i3, int i4) {
        int i5;
        JSONObject jSONObject;
        boolean z;
        gk6.b bVar = lk6.c.a.r;
        if (bVar != null) {
            i5 = bVar.b();
        } else {
            i5 = -1;
        }
        int nextInt = Random.Default.nextInt(100000000);
        if (i5 > 0) {
            if (nextInt % i5 == 0) {
                z = true;
            } else {
                z = false;
            }
            this.b = z;
        } else {
            this.b = false;
        }
        if (!this.b) {
            return;
        }
        this.e.d("MonitorAudioProcessor", "audioOpen, samplerate = " + i + ", channels = " + i2 + ", duration = " + i3 + ", format = " + i4 + ", randomNum = " + nextInt + ", this = " + hashCode());
        AudioMetricsLite audioMetricsLite = new AudioMetricsLite();
        this.c = audioMetricsLite;
        this.h = playEngineInfo;
        Integer valueOf = Integer.valueOf(audioMetricsLite.b());
        if (valueOf == null || valueOf.intValue() != 0) {
            this.e.b("MonitorAudioProcessor", "AudioMetricsLite init failed! code = " + valueOf);
        }
        try {
            JSONArray jSONArray = new JSONArray(this.a);
            Object obj = jSONArray.get(0);
            Integer num = null;
            if (!(obj instanceof JSONObject)) {
                obj = null;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2 != null) {
                jSONObject = jSONObject2.optJSONObject("param");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                jSONObject.putOpt("sample_rate", Integer.valueOf(i));
            }
            if (jSONObject != null) {
                jSONObject.putOpt("num_channel", Integer.valueOf(i2));
            }
            this.d = i2;
            if (i2 > 2) {
                this.d = 2;
            }
            AudioMetricsLite audioMetricsLite2 = this.c;
            if (audioMetricsLite2 != null) {
                num = Integer.valueOf(audioMetricsLite2.c(jSONArray.toString()));
            }
            if (num != null && num.intValue() == 0) {
                return;
            }
            this.e.b("MonitorAudioProcessor", "audioOpen, audioMetricsLite.prepare failed! code = " + num);
        } catch (Exception e) {
            this.e.b("MonitorAudioProcessor", "audioOpen crash, stacktrace = " + Log.getStackTraceString(e));
        }
    }
}

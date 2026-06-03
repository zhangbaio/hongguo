package yk6;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.AudioProcessor;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends AudioProcessor {
    private c b;
    private c c;
    private c d;
    private PlayEngineInfo g;
    private final bl6.a a = new bl6.a("CustomAudioProcessor");
    private int e = 2;
    private int f = 44100;

    static {
        Covode.recordClassIndex(655880);
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public synchronized void audioClose() {
        this.a.d("audioClose", new Object[0]);
        c cVar = this.b;
        if (cVar != null) {
            cVar.c();
        }
        c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.c();
        }
        c cVar3 = this.d;
        if (cVar3 != null) {
            cVar3.c();
        }
    }

    public final void a(PlayEngineInfo playEngineInfo) {
        this.g = playEngineInfo;
        bl6.a aVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("setPlayEngineInfo, playEngineInfo changed = ");
        sb.append(!Intrinsics.areEqual(playEngineInfo, this.g));
        sb.append("， audioeffect = ");
        sb.append((Object) null);
        sb.append(", this = ");
        sb.append(this);
        aVar.d(sb.toString(), new Object[0]);
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public synchronized void audioRelease(int i) {
        this.a.d("audioRelease", new Object[0]);
        c cVar = this.b;
        if (cVar != null) {
            cVar.b(i);
        }
        c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.b(i);
        }
        c cVar3 = this.d;
        if (cVar3 != null) {
            cVar3.b(i);
        }
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public synchronized void audioProcess(ByteBuffer[] byteBufferArr, int i, long j) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(this.g, byteBufferArr, i, j);
        }
        c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.a(this.g, byteBufferArr, i, j);
        }
        c cVar3 = this.d;
        if (cVar3 != null) {
            cVar3.a(this.g, byteBufferArr, i, j);
        }
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public synchronized void audioOpen(int i, int i2, int i3, int i4) {
        int i5;
        gk6.b bVar;
        gk6.b bVar2;
        gk6.b bVar3;
        gk6.b bVar4;
        c cVar;
        gk6.b bVar5;
        bl6.a aVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("audioOpen, samplerate = ");
        sb.append(i);
        sb.append(", channels = ");
        sb.append(i2);
        sb.append(", audioeffect = ");
        PlayEngineInfo playEngineInfo = this.g;
        c cVar2 = null;
        sb.append((Object) null);
        sb.append(", this = ");
        sb.append(this);
        sb.append(", playEngineInfo = ");
        sb.append(this.g);
        aVar.d(sb.toString(), new Object[0]);
        this.e = i2;
        this.f = i;
        lk6.b bVar6 = lk6.c.a;
        if (bVar6 != null && (bVar4 = bVar6.r) != null && bVar4.g()) {
            lk6.b bVar7 = lk6.c.a;
            if (bVar7 != null && (bVar5 = bVar7.r) != null) {
                cVar = bVar5.f();
            } else {
                cVar = null;
            }
            this.b = cVar;
        }
        c cVar3 = this.b;
        if (cVar3 != null) {
            cVar3.d(this.g, i, i2, i3, i4);
        }
        lk6.b bVar8 = lk6.c.a;
        if (bVar8 != null && (bVar2 = bVar8.r) != null && bVar2.d()) {
            lk6.b bVar9 = lk6.c.a;
            if (bVar9 != null && (bVar3 = bVar9.r) != null) {
                cVar2 = bVar3.a();
            }
            this.c = cVar2;
        }
        c cVar4 = this.c;
        if (cVar4 != null) {
            cVar4.d(this.g, i, i2, i3, i4);
        }
        lk6.b bVar10 = lk6.c.a;
        if (bVar10 != null && (bVar = bVar10.r) != null) {
            i5 = bVar.b();
        } else {
            i5 = -1;
        }
        if (i5 > 0) {
            this.d = new d();
        }
        c cVar5 = this.d;
        if (cVar5 != null) {
            cVar5.d(this.g, i, i2, i3, i4);
        }
    }
}

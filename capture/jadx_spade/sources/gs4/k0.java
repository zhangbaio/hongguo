package gs4;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.net.TTCallerContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k0 extends BaseRequestListener {
    public static final int h;
    private long a;
    private long b;
    private int c;
    private int d;
    public int e;
    private final HashSet<String> f;
    private final ConcurrentHashMap<String, Pair<Long, Boolean>> g;

    static {
        Covode.recordClassIndex(612332);
        h = 8;
    }

    public final int d() {
        if (h()) {
            return this.c;
        }
        return 0;
    }

    public final int e() {
        if (h()) {
            return this.d;
        }
        return 0;
    }

    public final long f() {
        if (h()) {
            return this.a;
        }
        return 0L;
    }

    public final long i() {
        if (h()) {
            return this.b;
        }
        return 0L;
    }

    private final boolean h() {
        if (this.a != Long.MAX_VALUE && this.b != Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public final void j() {
        b();
        c();
        Iterator<T> it2 = this.f.iterator();
        while (it2.hasNext()) {
            LogWrapper.warn("FirstScreenBookCoverWatcher", "not valid request uri: " + ((String) it2.next()), new Object[0]);
        }
        this.f.clear();
        this.g.clear();
    }

    private final void c() {
        for (Map.Entry<String, Pair<Long, Boolean>> entry : this.g.entrySet()) {
            String key = entry.getKey();
            Pair<Long, Boolean> value = entry.getValue();
            if (value.getSecond().booleanValue()) {
                long longValue = value.getFirst().longValue();
                if (this.f.remove(key)) {
                    LogWrapper.info("FirstScreenBookCoverWatcher", "load by preload: " + key, new Object[0]);
                    update(longValue, true);
                }
            }
        }
    }

    private final void b() {
        Iterator<Map.Entry<String, String>> it2 = z.a.k().entrySet().iterator();
        while (it2.hasNext()) {
            String value = it2.next().getValue();
            Pair pair = (Pair) TypeIntrinsics.asMutableMap(this.g).remove(value);
            if (pair == null) {
                LogWrapper.warn("FirstScreenBookCoverWatcher", "no requestStart event uri: " + value, new Object[0]);
            } else {
                long longValue = ((Number) pair.getFirst()).longValue();
                if (((Boolean) pair.getSecond()).booleanValue()) {
                    LogWrapper.info("FirstScreenBookCoverWatcher", "load by preload: " + value, new Object[0]);
                    update(longValue, true);
                } else {
                    LogWrapper.info("FirstScreenBookCoverWatcher", "load by view: " + value, new Object[0]);
                    update(longValue, false);
                }
                TypeIntrinsics.asMutableCollection(this.f).remove(value);
            }
        }
    }

    public final void a(String str) {
        if (str != null) {
            this.f.add(str);
            this.e++;
        }
    }

    private final boolean g(Object obj) {
        if (obj instanceof TTCallerContext) {
            TTCallerContext tTCallerContext = (TTCallerContext) obj;
            if (Intrinsics.areEqual("1", tTCallerContext.getExtra("is_first_screen")) || tTCallerContext.getExtra("tab_type") != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final void update(long j, boolean z) {
        this.a = Math.min(j, this.a);
        this.b = Math.max(j, this.b);
        if (z) {
            this.c++;
        } else {
            this.d++;
        }
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        String str2;
        Uri sourceUri;
        if (z.a.l() && str != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (imageRequest != null && (sourceUri = imageRequest.getSourceUri()) != null) {
                str2 = sourceUri.toString();
            } else {
                str2 = null;
            }
            boolean g = g(obj);
            if (str2 != null) {
                this.g.putIfAbsent(str2, new Pair<>(Long.valueOf(elapsedRealtime), Boolean.valueOf(g)));
            }
        }
    }

    public k0(long j, long j2, int i, int i2, int i3, HashSet<String> visibleUris, ConcurrentHashMap<String, Pair<Long, Boolean>> submitRecords) {
        Intrinsics.checkNotNullParameter(visibleUris, "visibleUris");
        Intrinsics.checkNotNullParameter(submitRecords, "submitRecords");
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = visibleUris;
        this.g = submitRecords;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ k0(long r10, long r12, int r14, int r15, int r16, java.util.HashSet r17, java.util.concurrent.ConcurrentHashMap r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19 & 1
            if (r0 == 0) goto La
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto Lb
        La:
            r0 = r10
        Lb:
            r2 = r19 & 2
            if (r2 == 0) goto L12
            r2 = -9223372036854775808
            goto L13
        L12:
            r2 = r12
        L13:
            r4 = r19 & 4
            r5 = 0
            if (r4 == 0) goto L1a
            r4 = 0
            goto L1b
        L1a:
            r4 = r14
        L1b:
            r6 = r19 & 8
            if (r6 == 0) goto L21
            r6 = 0
            goto L22
        L21:
            r6 = r15
        L22:
            r7 = r19 & 16
            if (r7 == 0) goto L27
            goto L29
        L27:
            r5 = r16
        L29:
            r7 = r19 & 32
            if (r7 == 0) goto L33
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            goto L35
        L33:
            r7 = r17
        L35:
            r8 = r19 & 64
            if (r8 == 0) goto L3f
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r8.<init>()
            goto L41
        L3f:
            r8 = r18
        L41:
            r10 = r9
            r11 = r0
            r13 = r2
            r15 = r4
            r16 = r6
            r17 = r5
            r18 = r7
            r19 = r8
            r10.<init>(r11, r13, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gs4.k0.<init>(long, long, int, int, int, java.util.HashSet, java.util.concurrent.ConcurrentHashMap, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

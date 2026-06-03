package uo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.EventInterceptor;
import com.dragon.read.report.ReportManager;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m implements ReportManager.b {
    public static final a d;
    public static final int e;
    private final Lazy a;
    private final Lazy b;
    private EventInterceptor c;

    public static final class a {
        static {
            Covode.recordClassIndex(609139);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609138);
        d = new a(null);
        e = 8;
    }

    private final e f() {
        return (e) this.b.getValue();
    }

    private final e g() {
        return (e) this.a.getValue();
    }

    public m() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: uo4.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                e e2;
                e2 = m.e();
                return e2;
            }
        });
        this.a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: uo4.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                e d2;
                d2 = m.d();
                return d2;
            }
        });
        this.b = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e d() {
        return new e(d.a("watch_comic_video_tab"), null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e e() {
        return new e(d.a("watch_short_story_tab"), null, 0, 6, null);
    }

    private final boolean h(JSONObject jSONObject, Map<String, ? extends List<String>> map) {
        String str;
        boolean contains;
        if (jSONObject == null || map == null) {
            return false;
        }
        for (Map.Entry<String, ? extends List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            Object opt = jSONObject.opt(entry.getKey());
            if (opt != null) {
                str = opt.toString();
            } else {
                str = null;
            }
            contains = CollectionsKt___CollectionsKt.contains(value, str);
            if (!contains) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        if (f().C() != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            com.dragon.read.NsCommonDepend r0 = com.dragon.read.NsCommonDepend.IMPL
            boolean r0 = r0.isSsConfigInit()
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            com.dragon.read.base.ssconfig.template.SpringFestivalClient$a r0 = com.dragon.read.base.ssconfig.template.SpringFestivalClient.a
            com.dragon.read.base.ssconfig.template.SpringFestivalClient r2 = r0.a()
            boolean r2 = r2.enable
            if (r2 != 0) goto L15
            return r1
        L15:
            com.dragon.read.base.ssconfig.template.EventInterceptor r2 = r5.c
            if (r2 != 0) goto L21
            com.dragon.read.base.ssconfig.template.SpringFestivalClient r0 = r0.a()
            com.dragon.read.base.ssconfig.template.EventInterceptor r0 = r0.eventInterceptor
            r5.c = r0
        L21:
            com.dragon.read.base.ssconfig.template.EventInterceptor r0 = r5.c
            r2 = 1
            if (r0 == 0) goto L38
            com.dragon.read.base.ssconfig.template.EventInterceptItem r0 = r0.shortStory
            if (r0 == 0) goto L38
            java.util.Set r0 = r0.eventList
            if (r0 == 0) goto L38
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r0 = kotlin.collections.CollectionsKt.contains(r0, r6)
            if (r0 != r2) goto L38
            r0 = 1
            goto L39
        L38:
            r0 = 0
        L39:
            java.lang.String r3 = "is_from_chunjie_task"
            r4 = 0
            if (r0 == 0) goto L60
            com.dragon.read.base.ssconfig.template.EventInterceptor r0 = r5.c
            if (r0 == 0) goto L49
            com.dragon.read.base.ssconfig.template.EventInterceptItem r0 = r0.shortStory
            if (r0 == 0) goto L49
            java.util.Map r0 = r0.conditions
            goto L4a
        L49:
            r0 = r4
        L4a:
            boolean r0 = r5.h(r7, r0)
            if (r0 == 0) goto L60
            uo4.e r0 = r5.g()
            boolean r0 = r0.C()
            if (r0 == 0) goto L60
            if (r7 == 0) goto L5f
            r7.put(r3, r2)
        L5f:
            return r1
        L60:
            com.dragon.read.base.ssconfig.template.EventInterceptor r0 = r5.c
            if (r0 == 0) goto L76
            com.dragon.read.base.ssconfig.template.EventInterceptItem r0 = r0.shortVideo
            if (r0 == 0) goto L76
            java.util.Set r0 = r0.eventList
            if (r0 == 0) goto L76
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r6 = kotlin.collections.CollectionsKt.contains(r0, r6)
            if (r6 != r2) goto L76
            r6 = 1
            goto L77
        L76:
            r6 = 0
        L77:
            if (r6 == 0) goto La0
            com.dragon.read.component.shortvideo.api.NsShortVideoApi r6 = com.dragon.read.component.shortvideo.api.NsShortVideoApi.IMPL
            boolean r6 = r6.isWatchSeriesTaskRunning()
            if (r6 != 0) goto L9b
            com.dragon.read.base.ssconfig.template.EventInterceptor r6 = r5.c
            if (r6 == 0) goto L8b
            com.dragon.read.base.ssconfig.template.EventInterceptItem r6 = r6.shortVideo
            if (r6 == 0) goto L8b
            java.util.Map r4 = r6.conditions
        L8b:
            boolean r6 = r5.h(r7, r4)
            if (r6 == 0) goto La0
            uo4.e r6 = r5.f()
            boolean r6 = r6.C()
            if (r6 == 0) goto La0
        L9b:
            if (r7 == 0) goto La0
            r7.put(r3, r2)
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uo4.m.a(java.lang.String, org.json.JSONObject):boolean");
    }
}

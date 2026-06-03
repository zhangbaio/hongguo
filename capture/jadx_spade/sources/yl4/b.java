package yl4;

import android.content.Context;
import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.ReaderAddVideoButton;
import com.dragon.read.base.ssconfig.template.ReaderAddVideoButtonV2;
import com.dragon.read.base.ssconfig.template.VideoButtonTextOpt;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.reader.services.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sm4.k;
import yl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(608236);
        a = new b();
    }

    private b() {
    }

    public static final class a extends k {
        a() {
            super("漫剧/原著进度定位同步功能", "仅部分书籍和漫剧支持该功能", "book_video_match_progress", "motion_comic_auto_sync_setting");
            this.e = f34.a.a.a();
            c(new Function3() { // from class: yl4.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit e;
                    e = b.a.e(((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                    return e;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(boolean z, Context context, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<unused var>");
            f34.a.a.c(z);
            return Unit.INSTANCE;
        }
    }

    public final k a(i reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (ReaderAddVideoButton.a.g() && ReaderAddVideoButtonV2.a.c()) {
            return new a();
        }
        return null;
    }

    public final k b(i reader) {
        String str;
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (ReaderAddVideoButton.a.g()) {
            if (VideoButtonTextOpt.a.c()) {
                str = "阅读器展示「剧」悬浮球";
            } else {
                str = "阅读器展示「看」悬浮球";
            }
            return new C0300b(reader, str);
        }
        return null;
    }

    /* renamed from: yl4.b$b, reason: collision with other inner class name */
    public static final class C0300b extends k {
        C0300b(final i iVar, String str) {
            super(str, "", "show_video_playball", "show_video_button");
            this.e = f34.c.a.a();
            c(new Function3() { // from class: yl4.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit e;
                    e = b.C0300b.e(i.this, ((Boolean) obj).booleanValue(), (Context) obj2, (CoroutineScope) obj3);
                    return e;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(i iVar, boolean z, Context context, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<unused var>");
            f34.c.a.c(z);
            m readerOtherService = NsReaderServiceApi.IMPL.readerOtherService();
            NsReaderActivity b = iVar.b();
            Intrinsics.checkNotNull(b, "null cannot be cast to non-null type com.dragon.read.component.biz.interfaces.NsReaderActivity");
            readerOtherService.b(b);
            return Unit.INSTANCE;
        }
    }
}

package com.dragon.read.kmp.story.impl.feeds.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.z0;
import com.dragon.read.kmp.utils.AppUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ec4.p;
import kh4.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.i;
import xn0.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpCssManager implements cp4.b {
    public static final KmpCssManager a;
    private static final Lazy b;
    private static String c;
    private static final tp4.b d;
    public static final int e;

    private KmpCssManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xn0.b O3() {
        return c.a("ShortStory-Reading-Setting");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xn0.b u2() {
        return (xn0.b) b.getValue();
    }

    private final String j2() {
        return z0.a.a() + "/css";
    }

    @Override // cp4.b
    public void l7() {
        i.e(CoroutineScopeKt.MainScope(), null, null, new KmpCssManager$loadCss$1(p.Companion.a(), null), 3, null);
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609252);
        a = new KmpCssManager();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.config.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xn0.b O3;
                O3 = KmpCssManager.O3();
                return O3;
            }
        });
        b = lazy;
        d = new tp4.b("KmpCssManager");
        e = 8;
    }

    public final String H2() {
        String decodeToString;
        boolean z;
        String str = c;
        if (str != null) {
            return str;
        }
        String l3 = l3("story_post.css");
        String str2 = "";
        if (new rn0.c(l3).exists()) {
            try {
                decodeToString = StringsKt__StringsJVMKt.decodeToString(com.dragon.read.kmp.base.util.a.a.a(l3));
                str2 = decodeToString;
            } catch (Exception unused) {
            }
        }
        if (str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str2 = "p, h1, h2, blockquote, hr, *[data-story-title=\"1\"] {\n    margin-left: 22px;\n    margin-right: 22px;\n}\n\np, h1, h2 {\n    font-size: 1rem;\n    font-weight: normal;\n    theme-color: \"color1#1\";\n}\n\n*[data-story-title=\"1\"] {\n    text-align: center;\n    font-size: 1rem;\n    font-weight: bold;\n    theme-color: \"color1#1\";\n}\n\np.picture {\n    text-align: center;\n}\n\nblockquote {\n    border-left: solid 2px color3#1;\n    padding-left: 8px;\n}\n\nblockquote p {\n    theme-color: \"color2#1\";\n    margin: 0;\n}\n\nhr {\n    border-top: 0.5px color4#1;\n}\n\na {\n    theme-color: \"color5#1\";\n}\n\n@media (max-font-size:16) and (spacing-mode:0) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 26px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 10px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 10px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 16px;\n    }\n\n}\n\n@media (max-font-size:16) and (spacing-mode:1) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 28px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 18px;\n    }\n\n}\n\n@media (max-font-size:16) and (spacing-mode:2) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 32px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 16px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 16px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 22px;\n    }\n\n}\n\n@media (min-font-size:17) and (max-font-size:19) and (spacing-mode:0) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 30px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 18px;\n    }\n\n}\n\n@media (min-font-size:17) and (max-font-size:19) and (spacing-mode:1) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 32px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 14px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 14px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 20px;\n    }\n\n}\n\n@media (min-font-size:17) and (max-font-size:19) and (spacing-mode:2) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 36px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 18px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 18px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 24px;\n    }\n\n}\n\n@media (min-font-size:20) and (max-font-size:23) and (spacing-mode:0) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 32px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 12px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 18px;\n    }\n\n}\n\n@media (min-font-size:20) and (max-font-size:23) and (spacing-mode:1) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 36px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 16px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 16px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 22px;\n    }\n\n}\n\n@media (min-font-size:20) and (max-font-size:23) and (spacing-mode:2) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 40px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 20px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 20px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 26px;\n    }\n\n}\n\n@media (min-font-size:24) and (spacing-mode:0) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 38px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 14px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 14px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 20px;\n    }\n\n}\n\n@media (min-font-size:24) and (spacing-mode:1) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 42px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 18px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 18px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 24px;\n    }\n\n}\n\n@media (min-font-size:24) and (spacing-mode:2) {\n    p, h1, *[data-story-title=\"1\"], h2 {\n        line-height: 46px;\n    }\n\n    h1, *[data-story-title=\"1\"] {\n        margin-top: 22px;\n    }\n\n    p+p, p+div, div+p, blockqupte+blockquote, p+blockquote, blockquote+p, h1+p, h2+p, h1+blockquote, h2+blockquote, *[data-story-title=\"1\"]+p, *[data-story-title=\"1\"]+blockquote, p+h1, p+*[data-story-title=\"1\"], p+h2, blockquote+h1, blockquote+*[data-story-title=\"1\"], blockquote+h2, h1+h2, *[data-story-title=\"1\"]+h2, h2+h1, h2+*[data-story-title=\"1\"] {\n        margin-top: 22px;\n    }\n\n    p+hr, hr+p, h1+hr, hr+h1, *[data-story-title=\"1\"]+hr, hr+*[data-story-title=\"1\"], h2+hr, hr+h2, blockquote+hr, hr+blockquote {\n        margin-top: 28px;\n    }\n}";
        }
        c = str2;
        d.d("cachedCss = " + c);
        return str2;
    }

    public static final class a implements kh4.a {
        final /* synthetic */ rn0.c a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        public void onCanceled(DownloadInfo downloadInfo) {
            a.a.a(this, downloadInfo);
        }

        public void onFirstStart(DownloadInfo downloadInfo) {
            a.a.b(this, downloadInfo);
        }

        public void onFirstSuccess(DownloadInfo downloadInfo) {
            a.a.c(this, downloadInfo);
        }

        public void onPause(DownloadInfo downloadInfo) {
            a.a.d(this, downloadInfo);
        }

        public void onPrepare(DownloadInfo downloadInfo) {
            a.a.e(this, downloadInfo);
        }

        public void onProgress(DownloadInfo downloadInfo) {
            a.a.f(this, downloadInfo);
        }

        public void onStart(DownloadInfo downloadInfo) {
            a.a.i(this, downloadInfo);
        }

        public void onSuccessed(DownloadInfo entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (this.a.exists()) {
                KmpCssManager.d.d("css资源文件下载成功: " + this.b);
                KmpCssManager.a.u2().storeString(this.b, this.c);
                return;
            }
            tp4.b.c(KmpCssManager.d, "css资源文件下载失败: " + this.b, null, 2, null);
        }

        public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
            a.a.g(this, downloadInfo, baseException);
        }

        public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
            a.a.h(this, downloadInfo, baseException);
        }

        public void onFailed(DownloadInfo entity, BaseException e) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(e, "e");
            tp4.b.c(KmpCssManager.d, "css资源文件下载失败: " + this.b + ", error_code=" + e.getErrorCode() + ", error_msg=" + e.getErrorMessage(), null, 2, null);
        }

        a(rn0.c cVar, String str, String str2) {
            this.a = cVar;
            this.b = str;
            this.c = str2;
        }
    }

    private final String l3(String str) {
        return j2() + '/' + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I1(String str, String str2, Continuation<? super Unit> continuation) {
        boolean z;
        if (!Intrinsics.areEqual(str, u2().getString(str2, ""))) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                rn0.c cVar = new rn0.c(l3(str2));
                if (cVar.exists()) {
                    cVar.delete();
                }
                rn0.c cVar2 = new rn0.c(j2());
                if (!cVar2.exists()) {
                    cVar2.mkdirs();
                }
                mh4.a.a.a(AppUtils.a.a()).f(str).d(j2()).c(str2).e(new a(cVar, str2, str)).a();
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}

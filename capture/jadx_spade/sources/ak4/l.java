package ak4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.SeriesStatus;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.kmp.reader.utils.o;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final l a;

    static {
        Covode.recordClassIndex(607750);
        a = new l();
    }

    private l() {
    }

    public final boolean d(com.dragon.read.kmp.mine.data.b bVar) {
        if (bVar == null || bVar.d != SeriesStatus.SeriesUpdating.getValue()) {
            return false;
        }
        return true;
    }

    public final String c(x7 x7Var) {
        List list;
        Object firstOrNull;
        om0 om0Var;
        Long l;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(x7Var, "<this>");
        Integer num = x7Var.G0;
        int value = CandidateDataType.Video.getValue();
        if (num != null && num.intValue() == value) {
            List list2 = x7Var.v;
            if (list2 != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                om0Var = (om0) firstOrNull2;
            } else {
                om0Var = null;
            }
            boolean z = false;
            if (om0Var != null) {
                Integer num2 = om0Var.y;
                int value2 = VideoContentType.Album.getValue();
                if (num2 != null && num2.intValue() == value2) {
                    z = true;
                }
            }
            if (z) {
                jm0 jm0Var = om0Var.R0;
                if (jm0Var == null || (l = jm0Var.a) == null) {
                    return null;
                }
                return l.toString();
            }
            if (om0Var == null) {
                return null;
            }
            return om0Var.p;
        }
        Integer num3 = x7Var.G0;
        int value3 = CandidateDataType.Book.getValue();
        if (num3 == null || num3.intValue() != value3 || (list = x7Var.w) == null) {
            return null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        d1 d1Var = (d1) firstOrNull;
        if (d1Var == null) {
            return null;
        }
        return d1Var.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(com.dragon.read.kmp.mine.data.a r19) {
        /*
            r18 = this;
            r0 = r19
            if (r0 != 0) goto L7
            java.lang.String r0 = ""
            return r0
        L7:
            int r1 = r0.r
            java.lang.String r2 = r0.p
            r3 = 0
            if (r2 == 0) goto L19
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L19
            int r2 = r2.intValue()
            goto L1a
        L19:
            r2 = 0
        L1a:
            float r2 = (float) r2
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 * r4
            int r4 = r0.q
            float r4 = (float) r4
            float r2 = r2 / r4
            float r4 = r0.s
            nc4.a r5 = nc4.a.a
            java.lang.Integer r0 = r0.o
            boolean r0 = r5.s(r0)
            com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r5 = com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType.READ
            com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r1 = mc4.b.a(r5, r1)
            r6 = 1
            if (r5 != r1) goto L38
            r1 = 1
            goto L39
        L38:
            r1 = 0
        L39:
            java.lang.String r5 = "已读完"
            java.lang.String r7 = "已听完"
            java.lang.String r8 = "已读"
            java.lang.String r9 = "已听"
            r10 = 0
            java.lang.String r11 = "%%"
            r12 = 100
            int r13 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r13 <= 0) goto L7c
            double r2 = (double) r4
            r13 = 4606912202822375178(0x3fef0a3d70a3d70a, double:0.97)
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 < 0) goto L5d
            if (r1 == 0) goto L5b
            goto L5c
        L5b:
            r5 = r7
        L5c:
            return r5
        L5d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r1 == 0) goto L68
            r0.<init>()
            r0.append(r8)
            goto L6e
        L68:
            r0.<init>()
            r0.append(r9)
        L6e:
            float r1 = (float) r12
            float r4 = r4 * r1
            r0.append(r4)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            return r0
        L7c:
            double r13 = (double) r2
            r15 = 4607177915200390038(0x3feffbe76c8b4396, double:0.9995)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 < 0) goto L88
            r15 = 1
            goto L89
        L88:
            r15 = 0
        L89:
            if (r0 == 0) goto L96
            r15 = 4606641986844732948(0x3fee147ae147ae14, double:0.94)
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 < 0) goto L95
            r3 = 1
        L95:
            r15 = r3
        L96:
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 > 0) goto La4
            if (r1 == 0) goto La0
            java.lang.String r0 = "未读过"
            goto La3
        La0:
            java.lang.String r0 = "未听过"
        La3:
            return r0
        La4:
            if (r15 == 0) goto Lab
            if (r1 == 0) goto La9
            goto Laa
        La9:
            r5 = r7
        Laa:
            return r5
        Lab:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r1 == 0) goto Lb6
            r0.<init>()
            r0.append(r8)
            goto Lbc
        Lb6:
            r0.<init>()
            r0.append(r9)
        Lbc:
            float r1 = (float) r12
            float r4 = r4 * r1
            r0.append(r4)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ak4.l.b(com.dragon.read.kmp.mine.data.a):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(com.dragon.read.kmp.mine.data.b r8, androidx.compose.runtime.Composer r9, int r10) {
        /*
            r7 = this;
            java.lang.String r0 = "historyData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -327923135(0xffffffffec744a41, float:-1.1813142E27)
            r9.startReplaceGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L17
            r1 = -1
            java.lang.String r2 = "com.dragon.read.kmp.mine.search.SearchHolderHelper.getPercentProgressForMovie (SearchHolderHelper.kt:25)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r1, r2)
        L17:
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L8a
            java.lang.String r10 = r8.i     // Catch: java.lang.Throwable -> L8a
            r0 = 0
            if (r10 == 0) goto L2a
            java.lang.Long r10 = kotlin.text.StringsKt.toLongOrNull(r10)     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L2a
            long r2 = r10.longValue()     // Catch: java.lang.Throwable -> L8a
            goto L2b
        L2a:
            r2 = r0
        L2b:
            java.lang.String r10 = r8.j     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L3a
            java.lang.Long r10 = kotlin.text.StringsKt.toLongOrNull(r10)     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L3a
            long r4 = r10.longValue()     // Catch: java.lang.Throwable -> L8a
            goto L3c
        L3a:
            r4 = -1
        L3c:
            r10 = 0
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 == 0) goto L50
            float r0 = (float) r2     // Catch: java.lang.Throwable -> L8a
            r1 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r1
            float r1 = (float) r4     // Catch: java.lang.Throwable -> L8a
            float r0 = r0 / r1
            double r0 = (double) r0     // Catch: java.lang.Throwable -> L8a
            double r0 = java.lang.Math.ceil(r0)     // Catch: java.lang.Throwable -> L8a
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L8a
            int r0 = (int) r0     // Catch: java.lang.Throwable -> L8a
            goto L51
        L50:
            r0 = 0
        L51:
            r1 = 1
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r1)     // Catch: java.lang.Throwable -> L8a
            r1 = -1601501780(0xffffffffa08b05ac, float:-2.355127E-19)
            r9.startReplaceGroup(r1)     // Catch: java.lang.Throwable -> L8a
            r1 = 100
            if (r0 < r1) goto L6b
            com.dragon.read.component.biz.impl.mine.x6 r0 = com.dragon.read.component.biz.impl.mine.x6.a     // Catch: java.lang.Throwable -> L8a
            org.jetbrains.compose.resources.i r0 = com.dragon.read.component.biz.impl.mine.y6.u(r0)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r10 = org.jetbrains.compose.resources.j.c(r0, r9, r10)     // Catch: java.lang.Throwable -> L8a
            goto L82
        L6b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a
            r10.<init>()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "看到"
            r10.append(r1)     // Catch: java.lang.Throwable -> L8a
            r10.append(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = 37
            r10.append(r0)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L8a
        L82:
            r9.endReplaceGroup()     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r10 = kotlin.Result.m773constructorimpl(r10)     // Catch: java.lang.Throwable -> L8a
            goto L95
        L8a:
            r10 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m773constructorimpl(r10)
        L95:
            java.lang.Throwable r0 = kotlin.Result.m776exceptionOrNullimpl(r10)
            if (r0 == 0) goto Lc4
            yn0.b r1 = yn0.b.b
            java.lang.String r2 = "SearchHolderHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "BookHolderHelper getPercentProgressForMovie VideoRecord fail, seriesId:"
            r3.append(r4)
            java.lang.String r8 = r8.h
            r3.append(r8)
            java.lang.String r8 = ", "
            r3.append(r8)
            java.lang.String r8 = kotlin.ExceptionsKt.stackTraceToString(r0)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            yn0.a.a.b(r1, r2, r3, r4, r5, r6)
        Lc4:
            boolean r8 = kotlin.Result.m779isFailureimpl(r10)
            if (r8 == 0) goto Lcc
            java.lang.String r10 = ""
        Lcc:
            java.lang.String r10 = (java.lang.String) r10
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto Ld7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Ld7:
            r9.endReplaceGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ak4.l.a(com.dragon.read.kmp.mine.data.b, androidx.compose.runtime.Composer, int):java.lang.String");
    }

    public final void e(String str, String str2, String str3, String str4, ym4.k kVar) {
        o oVar = new o(ig4.f.b(), str, str2, str3);
        oVar.f(str4);
        oVar.c(true);
        oVar.h(false);
        if (kVar != null) {
            oVar.i(kVar);
        }
        oVar.a();
    }
}

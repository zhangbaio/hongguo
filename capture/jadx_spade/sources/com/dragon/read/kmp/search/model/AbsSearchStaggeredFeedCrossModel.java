package com.dragon.read.kmp.search.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.repo.AbsSearchModel;
import com.dragon.read.rpc.model.CellViewData;
import gn4.c;
import hn4.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsSearchStaggeredFeedCrossModel<KM extends c> extends AbsSearchModel {
    public static final int $stable;
    private final CellViewData cellViewData;
    private final x7 kmpCellViewData;
    private KM kmpModel;

    static {
        Covode.recordClassIndex(608774);
        $stable = 8;
    }

    protected abstract KM generateKmpModel();

    public final CellViewData getCellViewData() {
        return this.cellViewData;
    }

    protected final x7 getKmpCellViewData() {
        return this.kmpCellViewData;
    }

    public final KM getKmpModel() {
        return this.kmpModel;
    }

    protected final void syncPropertiesToKmpModel(KM kmpModel) {
        Intrinsics.checkNotNullParameter(kmpModel, "kmpModel");
        d dVar = kmpModel.g;
        if (dVar != null) {
            dVar.p = ((AbsSearchModel) this).searchSourceBookId;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0027 A[Catch: Exception -> 0x0089, TryCatch #1 {Exception -> 0x0089, blocks: (B:10:0x0011, B:12:0x0019, B:18:0x0027, B:20:0x002b, B:25:0x005b, B:27:0x0061, B:28:0x0080, B:34:0x0051, B:24:0x0036), top: B:9:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AbsSearchStaggeredFeedCrossModel(com.dragon.read.rpc.model.CellViewData r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cellViewData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r9.<init>()
            r9.cellViewData = r10
            com.dragon.read.kmp.utils.x r0 = com.dragon.read.kmp.utils.x.a
            r0 = 0
            if (r10 != 0) goto L11
            goto Lae
        L11:
            java.lang.String r1 = com.dragon.read.base.util.JSONUtils.toJson(r10)     // Catch: java.lang.Exception -> L89
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L22
            int r4 = r1.length()     // Catch: java.lang.Exception -> L89
            if (r4 != 0) goto L20
            goto L22
        L20:
            r4 = 0
            goto L23
        L22:
            r4 = 1
        L23:
            if (r4 == 0) goto L27
            goto Lae
        L27:
            com.dragon.read.kmp.utils.v r4 = com.dragon.read.kmp.utils.v.a     // Catch: java.lang.Exception -> L89
            if (r1 == 0) goto L31
            int r4 = r1.length()     // Catch: java.lang.Exception -> L89
            if (r4 != 0) goto L32
        L31:
            r2 = 1
        L32:
            if (r2 == 0) goto L36
            goto Lae
        L36:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L50
            gn6.a r2 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Throwable -> L50
            r2.getSerializersModule()     // Catch: java.lang.Throwable -> L50
            com.bytedance.kmp.reading.model.x7$b r3 = com.bytedance.kmp.reading.model.x7.Companion     // Catch: java.lang.Throwable -> L50
            kotlinx.serialization.KSerializer r3 = r3.serializer()     // Catch: java.lang.Throwable -> L50
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3     // Catch: java.lang.Throwable -> L50
            java.lang.Object r1 = r2.c(r3, r1)     // Catch: java.lang.Throwable -> L50
            java.lang.Object r1 = kotlin.Result.m773constructorimpl(r1)     // Catch: java.lang.Throwable -> L50
            goto L5b
        L50:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Exception -> L89
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)     // Catch: java.lang.Exception -> L89
            java.lang.Object r1 = kotlin.Result.m773constructorimpl(r1)     // Catch: java.lang.Exception -> L89
        L5b:
            java.lang.Throwable r2 = kotlin.Result.m776exceptionOrNullimpl(r1)     // Catch: java.lang.Exception -> L89
            if (r2 == 0) goto L80
            yn0.b r3 = yn0.b.b     // Catch: java.lang.Exception -> L89
            java.lang.String r4 = "JSONUtils"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89
            r5.<init>()     // Catch: java.lang.Exception -> L89
            java.lang.String r6 = "fromJson json error "
            r5.append(r6)     // Catch: java.lang.Exception -> L89
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Exception -> L89
            r5.append(r2)     // Catch: java.lang.Exception -> L89
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L89
            r6 = 0
            r7 = 4
            r8 = 0
            yn0.a.a.b(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L89
        L80:
            boolean r10 = kotlin.Result.m779isFailureimpl(r1)     // Catch: java.lang.Exception -> L89
            if (r10 == 0) goto L87
            goto Lae
        L87:
            r0 = r1
            goto Lae
        L89:
            r1 = move-exception
            com.dragon.read.kmp.utils.q r2 = com.dragon.read.kmp.utils.q.a
            boolean r2 = r2.a()
            if (r2 != 0) goto Lc1
            com.dragon.read.kmp.j r10 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "convertToData,error = "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KmpDataConvertUtil"
            r10.d(r2, r1)
        Lae:
            com.bytedance.kmp.reading.model.x7 r0 = (com.bytedance.kmp.reading.model.x7) r0
            if (r0 != 0) goto Lb8
            yh4.p r10 = yh4.p.a
            com.bytedance.kmp.reading.model.x7 r0 = r10.a()
        Lb8:
            r9.kmpCellViewData = r0
            gn4.c r10 = r9.generateKmpModel()
            r9.kmpModel = r10
            return
        Lc1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "convertToData data:"
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = ", error:"
            r2.append(r10)
            r2.append(r1)
            java.lang.String r10 = r2.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.search.model.AbsSearchStaggeredFeedCrossModel.<init>(com.dragon.read.rpc.model.CellViewData):void");
    }
}

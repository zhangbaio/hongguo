package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.p2;
import com.dragon.read.kmprpc.reader.saas.model.r3;
import com.dragon.read.kmprpc.reader.saas.model.s3;
import com.dragon.read.reader.download.ChapterInfo;
import com.dragon.read.util.NumberUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import readersaas.com.dragon.read.saas.rpc.model.AnnotationDescription;
import readersaas.com.dragon.read.saas.rpc.model.AnnotationType;
import readersaas.com.dragon.read.saas.rpc.model.GenreTypeEnum;
import readersaas.com.dragon.read.saas.rpc.model.PositionInfoV1;
import readersaas.com.dragon.read.saas.rpc.model.PositionInfoV2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(608407);
    }

    public static final AnnotationDescription b(com.dragon.read.kmprpc.reader.saas.model.h hVar) {
        int i;
        PositionInfoV1 positionInfoV1;
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        AnnotationDescription annotationDescription = new AnnotationDescription();
        Integer num = hVar.a;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        annotationDescription.annotationType = AnnotationType.findByValue(i);
        r3 r3Var = hVar.b;
        PositionInfoV2 positionInfoV2 = null;
        if (r3Var != null) {
            positionInfoV1 = d(r3Var);
        } else {
            positionInfoV1 = null;
        }
        annotationDescription.posInfoV1 = positionInfoV1;
        annotationDescription.quoteContent = hVar.c;
        annotationDescription.referenceBookIds = hVar.d;
        s3 s3Var = hVar.e;
        if (s3Var != null) {
            positionInfoV2 = e(s3Var);
        }
        annotationDescription.posInfoV2 = positionInfoV2;
        return annotationDescription;
    }

    public static final List<AnnotationDescription> c(List<com.dragon.read.kmprpc.reader.saas.model.h> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(b((com.dragon.read.kmprpc.reader.saas.model.h) it2.next()));
        }
        return arrayList;
    }

    public static final PositionInfoV1 d(r3 r3Var) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        PositionInfoV1 positionInfoV1 = new PositionInfoV1();
        Integer num = r3Var.a;
        int i4 = 0;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        positionInfoV1.startParaIndex = i;
        Integer num2 = r3Var.b;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        positionInfoV1.endParaIndex = i2;
        Integer num3 = r3Var.c;
        if (num3 != null) {
            i3 = num3.intValue();
        } else {
            i3 = 0;
        }
        positionInfoV1.startWordPos = i3;
        Integer num4 = r3Var.d;
        if (num4 != null) {
            i4 = num4.intValue();
        }
        positionInfoV1.endWordPos = i4;
        return positionInfoV1;
    }

    public static final PositionInfoV2 e(s3 s3Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(s3Var, "<this>");
        PositionInfoV2 positionInfoV2 = new PositionInfoV2();
        Integer num = s3Var.a;
        int i6 = 0;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        positionInfoV2.startContainerIndex = i;
        Integer num2 = s3Var.b;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        positionInfoV2.startElementIndex = i2;
        Integer num3 = s3Var.c;
        if (num3 != null) {
            i3 = num3.intValue();
        } else {
            i3 = 0;
        }
        positionInfoV2.startElementOffset = i3;
        Integer num4 = s3Var.d;
        if (num4 != null) {
            i4 = num4.intValue();
        } else {
            i4 = 0;
        }
        positionInfoV2.endContainerIndex = i4;
        Integer num5 = s3Var.e;
        if (num5 != null) {
            i5 = num5.intValue();
        } else {
            i5 = 0;
        }
        positionInfoV2.endElementIndex = i5;
        Integer num6 = s3Var.f;
        if (num6 != null) {
            i6 = num6.intValue();
        }
        positionInfoV2.endElementOffset = i6;
        return positionInfoV2;
    }

    public static final ChapterInfo a(p2 resp, boolean z) {
        boolean z2;
        com.dragon.read.kmprpc.reader.saas.model.j jVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        int i2;
        short s;
        Map emptyMap;
        String str7;
        int mapCapacity;
        Integer num;
        String str8;
        Intrinsics.checkNotNullParameter(resp, "resp");
        String str9 = resp.a;
        boolean z3 = true;
        short s2 = 0;
        if (str9 != null && str9.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        String str10 = null;
        if (z2 || (jVar = resp.b) == null) {
            return null;
        }
        if (jVar != null) {
            str = jVar.u;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z3 = false;
        }
        if (!z3) {
            com.dragon.read.kmprpc.reader.saas.model.j jVar2 = resp.b;
            if (jVar2 != null) {
                str2 = jVar2.u;
            } else {
                str2 = null;
            }
        } else {
            str2 = resp.e;
        }
        com.dragon.read.kmprpc.reader.saas.model.j jVar3 = resp.b;
        String str11 = "";
        if (jVar3 == null || (str3 = jVar3.e) == null) {
            str3 = "";
        }
        if (jVar3 != null && (str8 = jVar3.r) != null) {
            str11 = str8;
        }
        ChapterInfo chapterInfo = new ChapterInfo(str3, str11);
        chapterInfo.name = str2;
        chapterInfo.content = resp.a;
        int i3 = Integer.MIN_VALUE;
        if (z && (num = resp.d) != null) {
            i3 = num.intValue();
        }
        chapterInfo.keyVersion = i3;
        com.dragon.read.kmprpc.reader.saas.model.j jVar4 = resp.b;
        if (jVar4 != null) {
            str4 = jVar4.f;
        } else {
            str4 = null;
        }
        chapterInfo.bookName = str4;
        if (jVar4 != null) {
            str5 = jVar4.Q;
        } else {
            str5 = null;
        }
        chapterInfo.version = str5;
        if (jVar4 != null) {
            str6 = jVar4.U;
        } else {
            str6 = null;
        }
        chapterInfo.contentMd5 = str6;
        Integer num2 = resp.j;
        if (num2 != null) {
            i = num2.intValue();
        } else {
            i = 0;
        }
        chapterInfo.contentType = i;
        Integer num3 = resp.k;
        if (num3 != null) {
            i2 = num3.intValue();
        } else {
            i2 = 0;
        }
        chapterInfo.parseMode = i2;
        Short sh = resp.l;
        if (sh != null) {
            s = sh.shortValue();
        } else {
            s = 0;
        }
        chapterInfo.compressStatus = s;
        Map<Integer, ? extends List<com.dragon.read.kmprpc.reader.saas.model.h>> map = resp.m;
        if (map != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            emptyMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                emptyMap.put(entry.getKey(), c((List) entry.getValue()));
            }
        } else {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        chapterInfo.extendInfoMap = emptyMap;
        com.dragon.read.kmprpc.reader.saas.model.j jVar5 = resp.b;
        if (jVar5 != null) {
            str7 = jVar5.d0;
        } else {
            str7 = null;
        }
        chapterInfo.relatedComicInfo = str7;
        Short sh2 = resp.n;
        if (sh2 != null) {
            s2 = sh2.shortValue();
        }
        chapterInfo.paragraphsNum = s2;
        com.dragon.read.kmprpc.reader.saas.model.j jVar6 = resp.b;
        if (jVar6 != null) {
            str10 = jVar6.a0;
        }
        chapterInfo.genreType = NumberUtils.parseInt(str10, GenreTypeEnum.NOVEL.getValue());
        return chapterInfo;
    }
}

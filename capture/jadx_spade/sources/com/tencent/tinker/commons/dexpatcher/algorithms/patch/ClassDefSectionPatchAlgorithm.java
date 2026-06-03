package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ClassDefSectionPatchAlgorithm extends DexSectionPatchAlgorithm<ClassDef> {
    private Dex.Section patchedClassDefSec;
    private TableOfContents.Section patchedClassDefTocSec;

    static {
        Covode.recordClassIndex(653660);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(ClassDef classDef) {
        return classDef.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().classDefs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public ClassDef nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readClassDef();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(ClassDef classDef) {
        this.patchedClassDefTocSec.size++;
        return this.patchedClassDefSec.writeClassDef(classDef);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public ClassDef adjustItem(AbstractIndexMap abstractIndexMap, ClassDef classDef) {
        return abstractIndexMap.adjust(classDef);
    }

    public ClassDefSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedClassDefTocSec = null;
        this.patchedClassDefSec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().classDefs;
            this.patchedClassDefTocSec = section;
            this.patchedClassDefSec = dex2.openSection(section);
        }
    }
}

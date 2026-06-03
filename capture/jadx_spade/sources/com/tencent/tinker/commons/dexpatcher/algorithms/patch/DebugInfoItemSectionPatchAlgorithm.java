package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DebugInfoItemSectionPatchAlgorithm extends DexSectionPatchAlgorithm<DebugInfoItem> {
    private Dex.Section patchedDebugInfoItemSec;
    private TableOfContents.Section patchedDebugInfoItemTocSec;

    static {
        Covode.recordClassIndex(653662);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(DebugInfoItem debugInfoItem) {
        return debugInfoItem.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().debugInfos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public DebugInfoItem nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readDebugInfoItem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(DebugInfoItem debugInfoItem) {
        this.patchedDebugInfoItemTocSec.size++;
        return this.patchedDebugInfoItemSec.writeDebugInfoItem(debugInfoItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public DebugInfoItem adjustItem(AbstractIndexMap abstractIndexMap, DebugInfoItem debugInfoItem) {
        return abstractIndexMap.adjust(debugInfoItem);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markDebugInfoItemDeleted(i2);
    }

    public DebugInfoItemSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedDebugInfoItemTocSec = null;
        this.patchedDebugInfoItemSec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().debugInfos;
            this.patchedDebugInfoItemTocSec = section;
            this.patchedDebugInfoItemSec = dex2.openSection(section);
        }
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapDebugInfoItemOffset(i2, i4);
        }
    }
}

package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StringDataSectionPatchAlgorithm extends DexSectionPatchAlgorithm<StringData> {
    private Dex.Section patchedStringDataSec;
    private TableOfContents.Section patchedStringDataTocSec;
    private Dex.Section patchedStringIdSec;
    private TableOfContents.Section patchedStringIdTocSec;

    static {
        Covode.recordClassIndex(653668);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(StringData stringData) {
        return stringData.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().stringDatas;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public StringData nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readStringData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(StringData stringData) {
        int writeStringData = this.patchedStringDataSec.writeStringData(stringData);
        this.patchedStringIdSec.writeInt(writeStringData);
        this.patchedStringDataTocSec.size++;
        this.patchedStringIdTocSec.size++;
        return writeStringData;
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markStringIdDeleted(i);
    }

    public StringDataSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedStringDataTocSec = null;
        this.patchedStringIdTocSec = null;
        this.patchedStringDataSec = null;
        this.patchedStringIdSec = null;
        if (dex2 != null) {
            this.patchedStringDataTocSec = dex2.getTableOfContents().stringDatas;
            this.patchedStringIdTocSec = dex2.getTableOfContents().stringIds;
            this.patchedStringDataSec = dex2.openSection(this.patchedStringDataTocSec);
            this.patchedStringIdSec = dex2.openSection(this.patchedStringIdTocSec);
        }
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapStringIds(i, i3);
        }
    }
}

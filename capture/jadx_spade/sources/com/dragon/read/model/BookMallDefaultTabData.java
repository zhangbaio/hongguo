package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsBookmallDepend;
import com.dragon.read.feed.bookmall.card.model.MallCell;
import com.dragon.read.feed.bookmall.subtab.model.BookMallTabData;
import com.dragon.read.pbrpc.BookstoreTabType;
import com.dragon.read.rpc.model.ClientTemplate;
import com.dragon.read.rpc.model.ColdStartInfo;
import com.dragon.read.rpc.model.TabDataList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookMallDefaultTabData implements Serializable {
    private static final long serialVersionUID = -3682488126781388206L;
    private ColdStartInfo coldStartInfo;
    private ClientTemplate defaultTabClientTemplate;
    private int defaultTabType;
    private boolean isCacheData;
    private transient boolean isFirstScreenCache;
    private transient Integer responseCode;
    private int selectIndex;
    private String url;
    private List<BookMallTabData> bookMallTabDataList = new ArrayList();
    private List<MallCell> defaultTabDataList = new ArrayList();
    private TabDataList originalDataList = new TabDataList();
    private transient boolean disableStreamRequest = false;

    static {
        Covode.recordClassIndex(612036);
    }

    public List<BookMallTabData> getBookMallTabDataList() {
        return this.bookMallTabDataList;
    }

    public ColdStartInfo getColdStartInfo() {
        return this.coldStartInfo;
    }

    public ClientTemplate getDefaultTabClientTemplate() {
        return this.defaultTabClientTemplate;
    }

    public List<MallCell> getDefaultTabDataList() {
        return this.defaultTabDataList;
    }

    public int getDefaultTabType() {
        return this.defaultTabType;
    }

    public TabDataList getOriginalDataList() {
        return this.originalDataList;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public int getSelectIndex() {
        return this.selectIndex;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheData() {
        return this.isCacheData;
    }

    public boolean isDisableStreamRequest() {
        return this.disableStreamRequest;
    }

    public boolean isFirstScreenCache() {
        return this.isFirstScreenCache;
    }

    public void setColdStartInfo(ColdStartInfo coldStartInfo) {
        this.coldStartInfo = coldStartInfo;
    }

    public void setDefaultTabClientTemplate(ClientTemplate clientTemplate) {
        this.defaultTabClientTemplate = clientTemplate;
    }

    public void setDefaultTabDataList(List<MallCell> list) {
        this.defaultTabDataList = list;
    }

    public void setDefaultTabType(int i) {
        this.defaultTabType = i;
    }

    public void setDisableStreamRequest(boolean z) {
        this.disableStreamRequest = z;
    }

    public void setFirstScreenCache(boolean z) {
        this.isFirstScreenCache = z;
    }

    public void setIsCacheData(boolean z) {
        this.isCacheData = z;
    }

    public void setOriginalDataList(TabDataList tabDataList) {
        this.originalDataList = tabDataList;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setBookMallTabDataList(List<BookMallTabData> list, int i) {
        int filterSearchTabs = filterSearchTabs(list, i);
        this.bookMallTabDataList = list;
        if (filterSearchTabs >= 0 && filterSearchTabs < list.size()) {
            this.selectIndex = filterSearchTabs;
        } else {
            this.selectIndex = 0;
        }
    }

    private int filterSearchTabs(List<BookMallTabData> list, int i) {
        if (list != null && !list.isEmpty() && !NsBookmallDepend.IMPL.isECEnable()) {
            Iterator<BookMallTabData> it2 = list.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (it2.next().tabType == BookstoreTabType.ecom_book.getValue()) {
                    it2.remove();
                    if (i2 == i) {
                        i = 0;
                    } else if (i2 < i) {
                        i--;
                    }
                }
                i2++;
            }
        }
        return i;
    }
}

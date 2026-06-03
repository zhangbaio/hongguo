package cm6;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.PreviewItemFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends FragmentPagerAdapter {
    private ArrayList<Item> a;
    protected com.zhihu.matisse.internal.entity.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface a {
    }

    static {
        Covode.recordClassIndex(656144);
    }

    public int getCount() {
        return this.a.size();
    }

    public void a(List<Item> list) {
        this.a.addAll(list);
    }

    public Item b(int i) {
        return this.a.get(i);
    }

    public Fragment getItem(int i) {
        return PreviewItemFragment.xf(this.a.get(i), this.b);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    public c(FragmentManager fragmentManager, a aVar, com.zhihu.matisse.internal.entity.a aVar2) {
        super(fragmentManager);
        this.a = new ArrayList<>();
        this.b = aVar2;
    }
}

package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class Font {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Font[] $VALUES;
    public static final Font CHYMDHRJ;
    public static final Font CKYHDY;
    public static final Font COPPERPLATE;
    public static final Font DEFAULT;
    public static final Font FYTWSJ;
    public static final Font FZFengYaKaiSongJF;
    public static final Font FZKTPY03;
    public static final Font FZLanTingHeiS_R_G;
    public static final Font FZPinShangHeiS_DB_GB;
    public static final Font FZShengShiKaiShuS_B_GB;
    public static final Font FZShengShiKaiShuS_DB_GB;
    public static final Font FZShengShiKaiShuS_M_GB;
    public static final Font FZShuLangTiS;
    public static final Font FZSongKeBenXiuKaiS;
    public static final Font FZXKTK;
    public static final Font FZXiaoManTiS;
    public static final Font FZYanSongS_M_GB;
    public static final Font FZYouHeiSVF;
    public static final Font FZYouSJVFWT1;
    public static final Font FZZJ_FXGXSJW;
    public static final Font FZZhaoGeYuanS;
    public static final Font HHRLNLT;
    public static final Font HUIWEN_MINCHO;
    public static final Font HYKongShanKai;
    public static final Font HYQiHei;
    public static final Font HYShuFang_55W;
    public static final Font HYShuFang_65W;
    public static final Font HYXinRenWenSong;
    public static final Font HYZhengYuan;
    public static final Font HanyiSentyTea;
    public static final Font LXGW_WenKai;
    public static final Font NHZXHN;
    public static final Font Noto_Sans_SC;
    public static final Font Oswald_Medium;
    public static final Font QDHGG;
    public static final Font SourceHanSerifCN;
    public static final Font TsangerGuLi;
    public static final Font TsangerJinKai04;
    public static final Font TsangerLingGang_W03;
    public static final Font TsangerMingHei;
    public static final Font TsangerQHT_GL;
    public static final Font TsangerXuanSan04;
    public static final Font TsangerYunHei;
    public static final Font ZiYuYongLeTi;
    private final String fontFamily;
    private final String fontTitle;

    private static final /* synthetic */ Font[] $values() {
        return new Font[]{DEFAULT, FYTWSJ, CHYMDHRJ, QDHGG, HHRLNLT, CKYHDY, HYShuFang_55W, NHZXHN, FZYouSJVFWT1, HYQiHei, HYXinRenWenSong, SourceHanSerifCN, FZXKTK, HYZhengYuan, FZShengShiKaiShuS_M_GB, FZYouHeiSVF, ZiYuYongLeTi, FZShengShiKaiShuS_DB_GB, HanyiSentyTea, FZZJ_FXGXSJW, FZPinShangHeiS_DB_GB, FZZhaoGeYuanS, Noto_Sans_SC, HYShuFang_65W, Oswald_Medium, LXGW_WenKai, HYKongShanKai, TsangerQHT_GL, TsangerGuLi, TsangerXuanSan04, TsangerJinKai04, TsangerYunHei, TsangerMingHei, TsangerLingGang_W03, FZFengYaKaiSongJF, FZXiaoManTiS, FZShuLangTiS, FZShengShiKaiShuS_B_GB, FZLanTingHeiS_R_G, FZSongKeBenXiuKaiS, FZYanSongS_M_GB, FZKTPY03, HUIWEN_MINCHO, COPPERPLATE};
    }

    public static EnumEntries<Font> getEntries() {
        return $ENTRIES;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontTitle() {
        return this.fontTitle;
    }

    public static Font[] values() {
        return (Font[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608428);
        DEFAULT = new Font("DEFAULT", 0, "Default", "系统字体");
        FYTWSJ = new Font("FYTWSJ", 1, "FYTWSJ", "瘦金体");
        CHYMDHRJ = new Font("CHYMDHRJ", 2, "CHYMDHRJ", "月明楷体");
        QDHGG = new Font("QDHGG", 3, "QDHGG", "飞扬飘逸体");
        HHRLNLT = new Font("HHRLNLT", 4, "HHRLNLT", "奶酪手写体");
        CKYHDY = new Font("CKYHDY", 5, "CKYHDY", "茶卡手写体");
        HYShuFang_55W = new Font("HYShuFang_55W", 6, "HYShuFang-55W", "汉仪书仿");
        NHZXHN = new Font("NHZXHN", 7, "NHZXHN", "可爱体");
        FZYouSJVFWT1 = new Font("FZYouSJVFWT1", 8, "FZYouSJVFWT1", "方正悠宋");
        HYQiHei = new Font("HYQiHei", 9, "HYQiHei", "汉仪旗黑");
        HYXinRenWenSong = new Font("HYXinRenWenSong", 10, "HYXinRenWenSong", "汉仪文宋");
        SourceHanSerifCN = new Font("SourceHanSerifCN", 11, "SourceHanSerifCN", "思源宋体");
        FZXKTK = new Font("FZXKTK", 12, "FZXKTK", "方正新楷");
        HYZhengYuan = new Font("HYZhengYuan", 13, "HYZhengYuan", "汉仪正圆");
        FZShengShiKaiShuS_M_GB = new Font("FZShengShiKaiShuS_M_GB", 14, "FZShengShiKaiShuS-M-GB", "方正盛世楷书简体_准");
        FZYouHeiSVF = new Font("FZYouHeiSVF", 15, "FZYouHeiSVF", "方正悠黑");
        ZiYuYongLeTi = new Font("ZiYuYongLeTi", 16, "ZiYuYongLeTi", "字语咏乐体");
        FZShengShiKaiShuS_DB_GB = new Font("FZShengShiKaiShuS_DB_GB", 17, "FZShengShiKaiShuS-DB-GB", "方正盛世楷书简体_中");
        HanyiSentyTea = new Font("HanyiSentyTea", 18, "HanyiSentyTea", "汉仪新蒂下午茶体");
        FZZJ_FXGXSJW = new Font("FZZJ_FXGXSJW", 19, "FZZJ-FXGXSJW", "方正字迹-范笑歌行书");
        FZPinShangHeiS_DB_GB = new Font("FZPinShangHeiS_DB_GB", 20, "FZPinShangHeiS-DB-GB", "方正品尚黑");
        FZZhaoGeYuanS = new Font("FZZhaoGeYuanS", 21, "FZZhaoGeYuanS", "方正朝歌圆");
        Noto_Sans_SC = new Font("Noto_Sans_SC", 22, "Noto Sans SC", "思源黑体");
        HYShuFang_65W = new Font("HYShuFang_65W", 23, "HYShuFang-65W", "汉仪书仿65W");
        Oswald_Medium = new Font("Oswald_Medium", 24, "Oswald-Medium", "Oswald-Medium");
        LXGW_WenKai = new Font("LXGW_WenKai", 25, "LXGW WenKai", "霞鹜文楷");
        HYKongShanKai = new Font("HYKongShanKai", 26, "HYKongShanKai", "汉仪空山楷");
        TsangerQHT_GL = new Font("TsangerQHT_GL", 27, "TsangerQHT-GL", "仓耳青禾");
        TsangerGuLi = new Font("TsangerGuLi", 28, "TsangerGuLi", "仓耳谷力");
        TsangerXuanSan04 = new Font("TsangerXuanSan04", 29, "TsangerXuanSan04", "仓耳玄三");
        TsangerJinKai04 = new Font("TsangerJinKai04", 30, "TsangerJinKai04", "仓耳今楷");
        TsangerYunHei = new Font("TsangerYunHei", 31, "TsangerYunHei", "仓耳云黑");
        TsangerMingHei = new Font("TsangerMingHei", 32, "TsangerMingHei", "仓耳明黑");
        TsangerLingGang_W03 = new Font("TsangerLingGang_W03", 33, "TsangerLingGang-W03", "仓耳凌刚体");
        FZFengYaKaiSongJF = new Font("FZFengYaKaiSongJF", 34, "FZFengYaKaiSongJF", "方正风雅楷宋");
        FZXiaoManTiS = new Font("FZXiaoManTiS", 35, "FZXiaoManTiS", "方正小满体");
        FZShuLangTiS = new Font("FZShuLangTiS", 36, "FZShuLangTiS", "方正舒朗体");
        FZShengShiKaiShuS_B_GB = new Font("FZShengShiKaiShuS_B_GB", 37, "FZShengShiKaiShuS-B-GB", "方正盛世楷书简体_粗");
        FZLanTingHeiS_R_G = new Font("FZLanTingHeiS_R_G", 38, "FZLanTingHeiS-R-GB", "方正兰亭黑");
        FZSongKeBenXiuKaiS = new Font("FZSongKeBenXiuKaiS", 39, "FZSongKeBenXiuKaiS", "方正宋刻本秀");
        FZYanSongS_M_GB = new Font("FZYanSongS_M_GB", 40, "FZYanSongS-M-GB", "方正颜宋");
        FZKTPY03 = new Font("FZKTPY03", 41, "FZKTPY03", "方正楷体拼音");
        HUIWEN_MINCHO = new Font("HUIWEN_MINCHO", 42, "Huiwen-MinchoGBK", "汇文明朝体汇文明朝体");
        COPPERPLATE = new Font("COPPERPLATE", 43, "Copperplate", "Copperplate");
        Font[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Font valueOf(String str) {
        return (Font) Enum.valueOf(Font.class, str);
    }

    private Font(String str, int i, String str2, String str3) {
        this.fontFamily = str2;
        this.fontTitle = str3;
    }
}

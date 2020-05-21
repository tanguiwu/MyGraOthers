package com.example.mygraothers.bean;



public class AccountItemInfo {
    private int viewType;
    private String sectionTitle;
    private String sectionSubContent;
    private int resLeftId;
    private int resRightId;

    private int itemType;

    private int childUserId;
    private String childUserName;
    private String childUserLogo;


    public static final int ACTION_VIEWTYPE_0 = 0;
    public static final int ACTION_VIEWTYPE_1 = 1;
    public static final int ACTION_VIEWTYPE_2 = 2;
    public static final int ACTION_VIEWTYPE_3 = 3;

    public static final int ACTION_VIEWTYPE_4 = 4;
    //user avatar
    public static final int ACTION_VIEWTYPE_5 = 5;
    //账号
    public static final int ACTION_VIEWTYPE_6 = 6;
    //工号
    public static final int ACTION_VIEWTYPE_7 = 7;
    public static final int ACTION_VIEWTYPE_8 = 8;
    public static final int ACTION_VIEWTYPE_9 = 9;
    public static final int ACTION_VIEWTYPE_10 = 10;
    public static final int ACTION_VIEWTYPE_11 = 11;
    public static final int ACTION_VIEWTYPE_12 = 12;
    // 家长绑定学生
    public static final int ACTION_VIEWTYPE_13 = 13;
    // 帮助文档
    public static final int ACTION_VIEWTYPE_14 = 14;
    // 应用权限设置
    public static final int ACTION_VIEWTYPE_15 = 15;
    // 设置护眼
    public static final int ACTION_VIEWTYPE_16 = 16;
    // 研发说明
    public static final int ACTION_VIEWTYPE_17 = 17;
    //用户反馈
    public static final int ACTION_VIEWTYPE_18 = 18;
    //护眼功能说明
    public static final int ACTION_VIEWTYPE_19 = 19;
    // 退出
    public static final int ACTION_VIEWTYPE_20 = 20;
    //客服qq
    public static final int ACTION_VIEWTYPE_21 = 21;
    //登陆的设备信息
    public static final int ACTION_VIEWTYPE_22 = 22;
    // 面容id
    public static final int ACTION_VIEWTYPE_23 = 23;

    //快捷按钮
    public static final int ACTION_VIEWTYPE_24 = 24;

    public AccountItemInfo() {

    }


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionSubContent() {
        return sectionSubContent;
    }

    public void setSectionSubContent(String sectionSubContent) {
        this.sectionSubContent = sectionSubContent;
    }

    public int getResLeftId() {
        return resLeftId;
    }

    public void setResLeftId(int resLeftId) {
        this.resLeftId = resLeftId;
    }

    public int getResRightId() {
        return resRightId;
    }

    public void setResRightId(int resRightId) {
        this.resRightId = resRightId;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getChildUserId() {
        return childUserId;
    }

    public void setChildUserId(int childUserId) {
        this.childUserId = childUserId;
    }

    public String getChildUserName() {
        return childUserName;
    }

    public void setChildUserName(String childUserName) {
        this.childUserName = childUserName;
    }

    public String getChildUserLogo() {
        return childUserLogo;
    }

    public void setChildUserLogo(String childUserLogo) {
        this.childUserLogo = childUserLogo;
    }

    @Override
    public String toString() {
        return "AccountItemInfo{" +
                "viewType=" + viewType +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", sectionSubContent='" + sectionSubContent + '\'' +
                ", resLeftId=" + resLeftId +
                ", resRightId=" + resRightId +
                ", itemType=" + itemType +
                ", childUserId=" + childUserId +
                ", childUserName='" + childUserName + '\'' +
                ", childUserLogo='" + childUserLogo + '\'' +
                '}';
    }
}

package com.example.mygraothers.fragment;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mygraothers.R;
import com.example.mygraothers.adapter.AccountInfoAdapter;
import com.example.mygraothers.base.AbstractBaseFragment;
import com.example.mygraothers.bean.AccountItemInfo;
import com.example.mygraothers.utils.DebugLog;
import com.example.mygraothers.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguiwu
 */
public class UserFragment extends AbstractBaseFragment implements View.OnClickListener, AccountInfoAdapter.OnItemClickListener {
    private TextView txtNavTitle;
    private TextView txtNaveBack;

    private RecyclerView recyclerView;
    private AccountInfoAdapter mAdapter;
    private List<AccountItemInfo> listData;
    private TextView txtUserName;
    private TextView txtAccountId;
    private ImageView imgAvatar;
//    private FrameLayout frameLayout;

    //add by
    private LinearLayout llUserDetails, llToolbarSpace;
    private String userLogoUrl;
    private CardView userCardView;

    public UserFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.user_main_fragment;
    }

    @Override
    protected void initView(View v) {
        final Toolbar toolbar = (Toolbar) v.findViewById(R.id.anim_toolbar);
        txtNavTitle = (TextView) v.findViewById(R.id.nav_toolbar_title);
        txtNaveBack = (TextView) v.findViewById(R.id.nav_toolbar_back);
        txtNavTitle.setText("我的");
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            toolbar.getLayoutParams().height = toolbar.getLayoutParams().height + getStatusBarHeight();
//            toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
//        }


        userCardView = (CardView) v.findViewById(R.id.cv_user_bg);
        txtUserName = (TextView) v.findViewById(R.id.user_account_info_userName);
        llUserDetails = (LinearLayout) v.findViewById(R.id.user_account_info_details);
        llToolbarSpace = (LinearLayout) v.findViewById(R.id.ll_toolbar_space);
        txtAccountId = (TextView) v.findViewById(R.id.user_account_info_accountId);
        imgAvatar = (ImageView) v.findViewById(R.id.user_account_info_user_avatar);
        recyclerView = (RecyclerView) v.findViewById(R.id.user_fragment_account_recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        listData = new ArrayList<>();
        mAdapter = new AccountInfoAdapter(getActivity(), listData, this);
        recyclerView.setAdapter(mAdapter);
        txtUserName.setOnClickListener(this);
        llUserDetails.setOnClickListener(this);
        txtNaveBack.setOnClickListener(this);
        userCardView.setOnClickListener(this);

        // 对于某些页面需要隐藏返回按钮
        llToolbarSpace.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);


    }

    @Override
    protected void initData() {
        initAccountInfo();
    }

    private void initAccountInfo() {
        listData.clear();


        txtUserName.setText("tgw" + "-");

        txtAccountId.setText(String.format("账号：%s", "tgw"));
        //empty
        AccountItemInfo info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_0);
        listData.add(info);


        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_1);
        info.setSectionTitle("绑定手机号");
        info.setSectionSubContent("123456789");
        info.setResLeftId(R.drawable.tel);
        info.setResRightId(R.drawable.arrow_right_icon);
        listData.add(info);


        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_2);
        info.setSectionTitle("修改密码");
        info.setSectionSubContent("");
        info.setResLeftId(R.drawable.code);
        info.setResRightId(R.drawable.arrow_right_icon);
        listData.add(info);

        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_3);
        info.setSectionTitle("清空记录");
        info.setSectionSubContent("");
        info.setResLeftId(R.drawable.records);
        info.setResRightId(R.drawable.arrow_right_icon);
        listData.add(info);

        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_4);
        info.setSectionTitle("清空缓存");
        info.setSectionSubContent("2M");
        info.setResLeftId(R.drawable.cache);
        info.setResRightId(R.drawable.arrow_right_icon);
        listData.add(info);


        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_0);
        listData.add(info);


        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_14);
        info.setSectionTitle("用户积分");
        info.setSectionSubContent("32分");
        info.setResRightId(R.drawable.arrow_right_icon);
        listData.add(info);

//        info = new AccountItemInfo();
//        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_15);
//        info.setSectionTitle("应用权限设置");
//        info.setSectionSubContent("点击设置");
//        info.setResRightId(R.drawable.arrow_right_icon);
//        listData.add(info);
//
//        info = new AccountItemInfo();
//        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_18);
//        info.setSectionTitle("用户反馈");
//        info.setSectionSubContent("点击反馈");
//        info.setResRightId(R.drawable.arrow_right_icon);
//        listData.add(info);
//
//        info = new AccountItemInfo();
//        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_19);
//        info.setSectionTitle("护眼功能说明");
////        info.setSectionSubContent("点击查看说明");
//        info.setSectionSubContent("");
//        info.setResRightId(R.drawable.arrow_right_icon);
//        listData.add(info);


        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_0);
        listData.add(info);

        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_20);
        info.setSectionSubContent("");
        listData.add(info);

        info = new AccountItemInfo();
        info.setViewType(AccountItemInfo.ACTION_VIEWTYPE_21);
        info.setSectionSubContent("");
        listData.add(info);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

    }


    @Override
    public void onItemClicked(int position, View v) {
        Log.d("", "onItemClicked: " + listData.get(position).getViewType());
        int viewType = listData.get(position).getViewType();
        if (viewType == AccountItemInfo.ACTION_VIEWTYPE_1) {
            //绑定手机号

        } else if (viewType == AccountItemInfo.ACTION_VIEWTYPE_2) {
            //修改密码

        } else if (viewType == AccountItemInfo.ACTION_VIEWTYPE_3) {
            //清空记录

        } else if (viewType == AccountItemInfo.ACTION_VIEWTYPE_4) {
            //清空缓存
            showClearCacheData();
        } else if (viewType == AccountItemInfo.ACTION_VIEWTYPE_14) {
            //用户积分

        } else if (viewType == AccountItemInfo.ACTION_VIEWTYPE_20) {
            //退出
            getActivity().finish();
        }
    }

    private void showClearCacheData() {
        DebugLog.showIOSAlert(getContext(), "警告", "是否删除缓存", "取消", "确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteFileCache();
                    }
                });

    }

    /**
     * 清楚缓存
     */
    private void deleteFileCache() {
        //缓存目录
        File file = getActivity().getCacheDir();
        try {
            FileUtils.deleteFolderFile(file.getCanonicalPath(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (AccountItemInfo info : listData) {
            if (info.getViewType() == AccountItemInfo.ACTION_VIEWTYPE_4) {
                info.setSectionSubContent("0M");
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}

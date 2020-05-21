package com.example.mygraothers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.mygraothers.R;
import com.example.mygraothers.bean.AccountItemInfo;

import java.util.List;


public class AccountInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AccountItemInfo> listData;
    private LayoutInflater mIflater;
    private OnItemClickListener listener;


    public AccountInfoAdapter(Context mContext, List<AccountItemInfo> listData,OnItemClickListener listener) {
        this.mContext = mContext;
        this.listData = listData;
        this.mIflater = LayoutInflater.from(mContext);
        this.listener = listener;

    }


    @Override
    public int getItemViewType(int position) {
        int viewType = super.getItemViewType(position);
        try {
            viewType = listData.get(position).getViewType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case AccountItemInfo.ACTION_VIEWTYPE_0:
                convertView = mIflater.inflate(R.layout.user_account_info_empty_line_layout, parent, false);
                holder = new ViewEmptyHolder(convertView);

                break;
            case AccountItemInfo.ACTION_VIEWTYPE_1:
            case AccountItemInfo.ACTION_VIEWTYPE_2:
            case AccountItemInfo.ACTION_VIEWTYPE_3:
            case AccountItemInfo.ACTION_VIEWTYPE_4:
            case AccountItemInfo.ACTION_VIEWTYPE_6:
            case AccountItemInfo.ACTION_VIEWTYPE_7:
            case AccountItemInfo.ACTION_VIEWTYPE_8:
            case AccountItemInfo.ACTION_VIEWTYPE_9:
            case AccountItemInfo.ACTION_VIEWTYPE_10:
            case AccountItemInfo.ACTION_VIEWTYPE_11:
            case AccountItemInfo.ACTION_VIEWTYPE_12:
            case AccountItemInfo.ACTION_VIEWTYPE_14:
            case AccountItemInfo.ACTION_VIEWTYPE_15:
            case AccountItemInfo.ACTION_VIEWTYPE_16:
            case AccountItemInfo.ACTION_VIEWTYPE_17:
            case AccountItemInfo.ACTION_VIEWTYPE_18:
            case AccountItemInfo.ACTION_VIEWTYPE_19:
            case AccountItemInfo.ACTION_VIEWTYPE_22:
            case AccountItemInfo.ACTION_VIEWTYPE_23:
            case AccountItemInfo.ACTION_VIEWTYPE_24:
                convertView = mIflater.inflate(R.layout.user_account_info_item_select_layout, parent, false);
                holder = new ViewItemHolder(convertView);
                break;
            case AccountItemInfo.ACTION_VIEWTYPE_5:
                convertView = mIflater.inflate(R.layout.user_account_info_item_avatar_layout, parent, false);
                holder = new ViewAvatarHolder(convertView);
                break;
            case AccountItemInfo.ACTION_VIEWTYPE_20:
                convertView = mIflater.inflate(R.layout.user_account_info_item_exit_layout, parent, false);
                holder = new ViewExitHolder(convertView);
                break;
            case AccountItemInfo.ACTION_VIEWTYPE_13:
                convertView = mIflater.inflate(R.layout.user_account_info_item_select_child_layout, parent, false);
                holder = new ViewSelectChildHolder(convertView);
                break;
            case AccountItemInfo.ACTION_VIEWTYPE_21:
                convertView = mIflater.inflate(R.layout.user_account_info_item_contact_layout, parent, false);
                holder = new ViewContactHolder(convertView);
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AccountItemInfo itemInfo = listData.get(position);
        if (holder instanceof ViewItemHolder) {
            initSelectItem((ViewItemHolder) holder, itemInfo,position);
        } else if (holder instanceof ViewExitHolder) {
            initExitItem((ViewExitHolder) holder, itemInfo,position);
        } else if (holder instanceof ViewAvatarHolder) {
            initUserAvatar((ViewAvatarHolder) holder, itemInfo,position);
        } else if (holder instanceof ViewSelectChildHolder) {
            initSelectChild((ViewSelectChildHolder) holder, itemInfo,position);
        } else if (holder instanceof ViewContactHolder) {
            initContactItem((ViewContactHolder) holder, itemInfo,position);
        }
    }

    @Override
    public int getItemCount() {
        if (listData == null)
            return 0;
        return listData.size();
    }

    /**
     * init
     *
     * @param holder
     * @param itemInfo
     */
    private void initSelectItem(ViewItemHolder holder, AccountItemInfo itemInfo, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });
        holder.txtSection.setText(itemInfo.getSectionTitle());
        holder.txtContent.setText(itemInfo.getSectionSubContent());
        holder.txtSection.setCompoundDrawablesWithIntrinsicBounds(itemInfo.getResLeftId(), 0, 0, 0);
        holder.txtContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, itemInfo.getResRightId(), 0);
    }

    /**
     * init exit
     *
     * @param holder
     * @param itemInfo
     */
    private void initExitItem(ViewExitHolder holder, AccountItemInfo itemInfo, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });


    }


    /**
     * init contact
     *
     * @param holder
     * @param itemInfo
     */
    private void initContactItem(ViewContactHolder holder, AccountItemInfo itemInfo, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });


    }

    private void initUserAvatar(ViewAvatarHolder holder, AccountItemInfo itemInfo, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });
        Glide.with(mContext).load(itemInfo.getSectionTitle()).into(holder.imgAvatar);
        holder.txtContent.setText(itemInfo.getSectionSubContent());
        holder.txtContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, itemInfo.getResRightId(), 0);
    }

    private void initSelectChild(ViewSelectChildHolder holder, AccountItemInfo itemInfo, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onItemClicked(position,v);
                }
            }
        });
        if (TextUtils.isEmpty(itemInfo.getChildUserLogo())) {
            holder.civAvatar.setVisibility(View.GONE);
        } else {
            holder.civAvatar.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(itemInfo.getChildUserLogo()).into(holder.civAvatar);
        }
        if (TextUtils.isEmpty(itemInfo.getChildUserName())) {
            holder.txtContent.setText("未绑定");
        } else {
            holder.txtContent.setText(itemInfo.getChildUserName());
        }
        holder.txtContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, itemInfo.getResRightId(), 0);
        holder.txtSection.setText(itemInfo.getSectionTitle());
        holder.txtSection.setCompoundDrawablesWithIntrinsicBounds(itemInfo.getResLeftId(), 0, 0, 0);
    }

    /**
     * select item
     */
    class ViewItemHolder extends RecyclerView.ViewHolder {
        TextView txtSection;
        TextView txtContent;


        public ViewItemHolder(View itemView) {
            super(itemView);
            txtSection = (TextView) itemView.findViewById(R.id.user_account_info_item_select_section_title);
            txtContent = (TextView) itemView.findViewById(R.id.user_account_info_item_select_section_content);
        }

    }

    /**
     * avatar item
     */
    class ViewAvatarHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView txtContent;


        public ViewAvatarHolder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.user_account_info_item_img_avatar);
            txtContent = (TextView) itemView.findViewById(R.id.user_account_info_item_select_section_content);
        }

    }

    class ViewExitHolder extends RecyclerView.ViewHolder {

        public ViewExitHolder(View itemView) {
            super(itemView);
        }
    }

    class ViewContactHolder extends RecyclerView.ViewHolder {

        public ViewContactHolder(View itemView) {
            super(itemView);
        }
    }

    class ViewEmptyHolder extends RecyclerView.ViewHolder {

        public ViewEmptyHolder(View itemView) {
            super(itemView);
        }
    }

    class ViewSelectChildHolder extends RecyclerView.ViewHolder {
        TextView txtSection;
        TextView txtContent;
        ImageView civAvatar;

        public ViewSelectChildHolder(View itemView) {
            super(itemView);
            txtSection = (TextView) itemView.findViewById(R.id.user_account_info_item_select_section_title);
            txtContent = (TextView) itemView.findViewById(R.id.user_account_info_item_select_section_content);
            civAvatar = (ImageView) itemView.findViewById(R.id.user_account_info_item_select_child_user_logo);
        }
    }


    public interface OnItemClickListener {
        void onItemClicked(int position, View v);
    }

}

package com.singularitycoder.folkcaller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class AdapterContactCallerAdminChatNotif extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelItemContactCallerAdminChatNotif> mAdminList;
    private OnItemClickListener clickListener;

    public AdapterContactCallerAdminChatNotif() {
    }

    public AdapterContactCallerAdminChatNotif(Context context, ArrayList<ModelItemContactCallerAdminChatNotif> adminList) {
        mContext = context;
        mAdminList = adminList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_caller_admin_chat_notif, parent, false);
        return new AdminViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ModelItemContactCallerAdminChatNotif modelItemContactCallerAdminChatNotif = mAdminList.get(position);

        ((AdminViewHolder) holder).imgProfileImage.setImageResource(modelItemContactCallerAdminChatNotif.getImgProfileImage());
        ((AdminViewHolder) holder).imgProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity homeActivity = new HomeActivity();
                homeActivity.showQuickInfoDialog(mContext);
            }
        });

        ((AdminViewHolder) holder).tvName.setText(modelItemContactCallerAdminChatNotif.getStrName());
        ((AdminViewHolder) holder).tvSubTitle1.setText(modelItemContactCallerAdminChatNotif.getStrSubTitle1());
        ((AdminViewHolder) holder).tvSubTitle2.setText(modelItemContactCallerAdminChatNotif.getStrSubTitle2());
        ((AdminViewHolder) holder).tvDate.setText(modelItemContactCallerAdminChatNotif.getStrDate());
        ((AdminViewHolder) holder).tvChatCount.setText(modelItemContactCallerAdminChatNotif.getStrChatCount());
    }


    @Override
    public int getItemCount() {
        return mAdminList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class AdminViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircularImageView imgProfileImage;
        TextView tvName, tvSubTitle1, tvSubTitle2, tvDate, tvChatCount;

        public AdminViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfileImage = itemView.findViewById(R.id.img_profile_pic);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSubTitle1 = itemView.findViewById(R.id.tv_subtitle_1);
            tvSubTitle2 = itemView.findViewById(R.id.tv_subtitle_2);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvChatCount = itemView.findViewById(R.id.tv_count);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

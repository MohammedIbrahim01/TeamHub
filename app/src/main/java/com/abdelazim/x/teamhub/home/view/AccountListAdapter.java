package com.abdelazim.x.teamhub.home.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.repository.Account;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolder> {

    private OnListItemClickListener onListItemClickListener;

    private List<Account> accountList = new ArrayList<>();

    public void setAccountList(List<Account> accountList) {

        this.accountList = accountList;
        notifyDataSetChanged();
    }

    public void addAccount(Account account) {

        accountList.add(account);
        notifyDataSetChanged();
    }

    public interface OnListItemClickListener {
        void onListItemClick(String accountName);
    }

    public AccountListAdapter(OnListItemClickListener onListItemClickListener) {

        this.onListItemClickListener = onListItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Account currentAccount = accountList.get(position);

        holder.setAvatar(currentAccount.getAvatar_url());
        holder.setAccountName(currentAccount.getLogin());
        holder.setRepositoriesCount(currentAccount.getRepos());
    }

    @Override
    public int getItemCount() {

        return accountList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView avatarImageView;
        private TextView accountNameTextView, repositoriesCountTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatar_imageView);
            accountNameTextView = itemView.findViewById(R.id.account_name_textView);
            repositoriesCountTextView = itemView.findViewById(R.id.repositories_count_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListItemClickListener.onListItemClick(accountList.get(getAdapterPosition()).getLogin());
                }
            });
        }

        public void setAvatar(String avatar_url) {
            Picasso.get().load(avatar_url)
                    .resize(140, 140)
                    .into(avatarImageView, new Callback() {
                @Override
                public void onSuccess() {

                    Bitmap imageBitmap = ((BitmapDrawable) avatarImageView.getDrawable()).getBitmap();
                    RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(avatarImageView.getResources(), imageBitmap);
                    imageDrawable.setCircular(true);
                    imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                    avatarImageView.setImageDrawable(imageDrawable);
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        public void setAccountName(String accountName) {

            accountNameTextView.setText(accountName);
        }

        public void setRepositoriesCount(String repos) {

            repositoriesCountTextView.setText("Repos : " + repos);
        }
    }
}

package com.abdelazim.x.teamhub.account_details;

import com.abdelazim.x.teamhub.repository.Account;

public interface AccountContract {

    interface AccountView{
        void displayDetails(Account account);
    }




    interface AccountPresenterCallBacks{
       void detailsFetched(Account account);
    }
}

package com.abdelazim.x.teamhub.account_details;

import com.abdelazim.x.teamhub.repository.Account;

public interface AccountContract {


   interface AccountModelCallBacks{
       void detailsFetched(Account account);
    }

    interface AccountPresenterCallBacks{
       void detailsFetched(Account account);
    }
}

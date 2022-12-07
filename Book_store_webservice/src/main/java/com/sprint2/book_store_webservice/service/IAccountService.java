package com.sprint2.book_store_webservice.service;

import com.sprint2.book_store_webservice.model.Account;

public interface IAccountService {
    Account findByEmail (String email);
}

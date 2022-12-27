package com.example.borrow_books.service;

import com.example.borrow_books.model.Oder;

public interface IOderService extends IGeneralService<Oder> {

    Oder findByCode(long code);

}

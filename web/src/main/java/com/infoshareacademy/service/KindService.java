package com.infoshareacademy.service;


import com.infoshareacademy.dao.KindDao;
import com.infoshareacademy.domain.entity.LiteratureKind;

import javax.inject.Inject;

public class KindService {


    @Inject
    private KindDao kindDao;

    public long addKind(KindDao kind){

        return this.kindDao.addKind(kind);
    }

}

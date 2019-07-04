package com.mercury.service;

import com.mercury.dao.BaseDictDao;
import com.mercury.domain.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseDiceService {
    @Autowired
    private BaseDictDao baseDictDao;


    public List<BaseDict> findByTypeCode(String dictTypeCode) {
        return baseDictDao.findByTypeCode(dictTypeCode);
    }
}

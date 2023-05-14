package com.softwarefoundation.booksellerapi.service.impl;

import com.softwarefoundation.booksellerapi.model.PucharseHistory;
import com.softwarefoundation.booksellerapi.repository.IPucharseHistoryRepository;
import com.softwarefoundation.booksellerapi.repository.projection.IPucharseItem;
import com.softwarefoundation.booksellerapi.service.IPucharseHistoryService;

import java.time.LocalDateTime;
import java.util.List;

public class PucharseHistoryService implements IPucharseHistoryService {

    private final IPucharseHistoryRepository pucharseHistoryRepository;

    public PucharseHistoryService(IPucharseHistoryRepository pucharseHistoryRepository) {
        this.pucharseHistoryRepository = pucharseHistoryRepository;
    }

    @Override
    public PucharseHistory savePucharseHistory(PucharseHistory pucharseHistory) {
        pucharseHistory.setPucharseTime(LocalDateTime.now());
        return pucharseHistoryRepository.save(pucharseHistory);
    }

    @Override
    public List<IPucharseItem> findPucharseItemOfUser(Long userId){
        return pucharseHistoryRepository.findAllPucharseesOfUser(userId);
    }


}

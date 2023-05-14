package com.softwarefoundation.booksellerapi.service;

import com.softwarefoundation.booksellerapi.model.PucharseHistory;
import com.softwarefoundation.booksellerapi.repository.projection.IPucharseItem;

import java.util.List;

public interface IPucharseHistoryService {
    PucharseHistory savePucharseHistory(PucharseHistory pucharseHistory);

    List<IPucharseItem> findPucharseItemOfUser(Long userId);
}

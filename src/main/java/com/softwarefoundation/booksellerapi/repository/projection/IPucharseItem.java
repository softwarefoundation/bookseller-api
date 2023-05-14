package com.softwarefoundation.booksellerapi.repository.projection;

import java.time.LocalDateTime;

public interface IPucharseItem {

    String getTitle();

    Double getPrice();

    LocalDateTime getPucharseTime();

}

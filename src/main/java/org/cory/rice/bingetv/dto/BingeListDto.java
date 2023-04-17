package org.cory.rice.bingetv.dto;

import org.cory.rice.bingetv.models.Users;

import java.time.Instant;

public class BingeListDto {

    private Long showId;
    private boolean watched;
    private Instant dateAdded;
    private Instant dateUpdated;
    private Users users;
}


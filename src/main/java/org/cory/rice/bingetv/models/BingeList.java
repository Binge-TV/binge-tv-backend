package org.cory.rice.bingetv.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "bingeList")
public class BingeList {

    @Id
    @Column
    private Long showId;
    @Column
    private boolean watched;
    @Column
    private Instant dateAdded;
    @Column
    private Instant dateUpdated;

    @JsonBackReference
    @ManyToOne(targetEntity = Users.class, fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "users_user_id")
    @ToString.Exclude
    private Users users;

    public BingeList(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BingeList bingeList = (BingeList) o;
        return getShowId() != null && Objects.equals(getShowId(), bingeList.getShowId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.project.Covid19Statistics.model.entity.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    public BaseEntity setId(UUID id) {
        this.id = id;
        return this;
    }
}

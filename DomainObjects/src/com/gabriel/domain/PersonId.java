package com.gabriel.domain;

import java.util.Objects;
import java.util.UUID;

public final class PersonId {
    private final UUID id;

    public PersonId() {
        id = UUID.randomUUID();
    }

    public PersonId(UUID id) {
        this.id = Objects.requireNonNull(id);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonId personId = (PersonId) o;
        return id.equals(personId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

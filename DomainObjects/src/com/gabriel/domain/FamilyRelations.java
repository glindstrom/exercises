package com.gabriel.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FamilyRelations {
    private final List<PersonId> parents;
    private final List<PersonId> children;
    private final Person spouse;

    private FamilyRelations(Builder builder) {
        this.parents = builder.parents;
        this.children = builder.parents;
        this.spouse = builder.spouse;
    }

    public List<PersonId> getParents() {
        return new ArrayList<>(parents);
    }

    public List<PersonId> getChildren() {
        return new ArrayList<>(children);
    }

    public Person getSpouse() {
        return spouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FamilyRelations that = (FamilyRelations) o;
        return Objects.equals(parents, that.parents) &&
                Objects.equals(children, that.children) &&
                Objects.equals(spouse, that.spouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parents, children, spouse);
    }

    @Override
    public String toString() {
        return "FamilyRelations{" +
                "parents=" + parents +
                ", children=" + children +
                ", spouse=" + spouse +
                '}';
    }

    public static class Builder {
        private List<PersonId> parents;
        private List<PersonId> children;
        private Person spouse;

        public Builder() {
        }

        public Builder(Builder source) {
            this.parents = source.parents;
            this.children = source.children;
            this.spouse = source.spouse;
        }

        public Builder setParents(List<PersonId> parents) {
            if (parents.size() > 2) {
                throw new IllegalArgumentException(String.format("%d parents, max 2 allowed", parents.size()));
            }
            this.parents = parents;
            return this;
        }

        public Builder setChildren(List<PersonId> children) {
            this.children = children;
            return this;

        }

        public Builder setSpouse(Person spouse) {
            this.spouse = spouse;
            return this;
        }

        public FamilyRelations build() {
            return new FamilyRelations(this);
        }
    }
}

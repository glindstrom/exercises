package com.gabriel.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class Person {
    private final PersonId id;
    private final PersonIdentityCode personIdentityCode;
    private final String name;
    private final Address address;
    private final FamilyRelations familyRelations;
    private final String citizenship;
    private final String nativeLanguage;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfDeath;

    private Person(Builder builder) {
        this.id = builder.id;
        this.personIdentityCode = builder.personIdentityCode;
        this.name = builder.name;
        this.address = builder.address;
        this.familyRelations = builder.familyRelations;
        this.citizenship = builder.citizenship;
        this.nativeLanguage = builder.nativeLanguage;
        this.dateOfBirth = builder.dateOfBirth;
        this.dateOfDeath = builder.dateOfDeath;
    }

    public PersonId getId() {
        return id;
    }

    public PersonIdentityCode getPersonIdentityCode() {
        return personIdentityCode;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public FamilyRelations getFamilyRelations() {
        return familyRelations;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personIdentityCode=" + personIdentityCode +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", familyRelations=" + familyRelations +
                ", citizenship=" + citizenship +
                ", nativeLanguage=" + nativeLanguage +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                '}';
    }

    public static class Builder {
        private PersonId id;
        private PersonIdentityCode personIdentityCode;
        private String name;
        private Address address;
        private FamilyRelations familyRelations;
        private String citizenship;
        private String nativeLanguage;
        private LocalDate dateOfBirth;
        private LocalDate dateOfDeath;

        public Builder() {
        }

        public Builder(Person source) {
            this.id = source.id;
            this.personIdentityCode = source.personIdentityCode;
            this.name = source.name;
            this.address = source.address;
            this.familyRelations = source.familyRelations;
            this.citizenship = source.citizenship;
            this.nativeLanguage = source.nativeLanguage;
            this.dateOfBirth = source.dateOfBirth;
            this.dateOfDeath = source.dateOfDeath;
        }

        public Builder setId(PersonId id) {
            this.id = id;
            return this;
        }

        public Builder setPersonIdentityCode(PersonIdentityCode personIdentityCode) {
            this.personIdentityCode = personIdentityCode;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setFamilyRelations(FamilyRelations familyRelations) {
            this.familyRelations = familyRelations;
            return this;
        }

        public Builder setCitizenship(String citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public Builder setNativeLanguage(String nativeLanguage) {
            this.nativeLanguage = nativeLanguage;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            if (LocalDate.now().isBefore(dateOfBirth)) {
                throw new IllegalArgumentException(String.format("Date of birth %s is in the future", dateOfBirth));
            }
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setDateOfDeath(LocalDate dateOfDeath) {
            this.dateOfDeath = dateOfDeath;
            return this;
        }

        public Person build() {
            if (id == null) {
                id = new PersonId();
            }
            if (dateOfBirth != null && dateOfDeath != null && dateOfBirth.isAfter(dateOfDeath)) {
                throw new IllegalStateException(String.format("Date of death %s must be after date of birth %s",
                        dateOfDeath, dateOfBirth));
            }
            return new Person(this);
        }
    }

}

package com.gabriel.domain;

import java.util.Objects;

public final class Address {
    private final String streetAddress;
    private final String city;
    private final String zipCode;

    private Address(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(streetAddress, address.streetAddress) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, city, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static class Builder {
        private String streetAddress;
        private String city;
        private String zipCode;

        public Builder() {
        }

        public Builder(Builder source) {
            this.streetAddress = source.streetAddress;
            this.city = source.city;
            this.zipCode = source.zipCode;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }
    }
}

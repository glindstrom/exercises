package com.gabriel.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void twoPersonsWithSameIdAreEqual() {
        var id = new PersonId();
        var person1 = new Person.Builder().setId(id).setName("Walter White").build();
        var person2 = new Person.Builder().setId(id).setName("Heisenberg").build();

        assertEquals(person1, person2);
    }

    @Test
    void twoPersonsWithDifferentIdAreNotEqual() {
        var person1 = new Person.Builder().setId(new PersonId()).setName("Walter White").build();
        var person2 = new Person.Builder().setId(new PersonId()).setName("Heisenberg").build();

        assertNotEquals(person1, person2);
    }

    @Test
    void idIsSetAutomaticallyIfOmitted() {
        var person = new Person.Builder().setName("Walter White").build();

        assertNotNull(person.getId());
    }

    @Nested
    class WhenBuildingPerson {
        Person.Builder personBuilder;

        @BeforeEach
        void setUp() {
            personBuilder = new Person.Builder();
        }

        @Test
        void exceptionIsThrownWhenDateOfBirthIsInTheFuture() {
            assertThrows(IllegalArgumentException.class,
                    () -> personBuilder.setDateOfBirth(LocalDate.now().plusDays(1)));
        }

        @Test
        void exceptionIsThrownWhenDateOfDeathIsBeforeDateOfBirth() {
            personBuilder
                    .setDateOfDeath(LocalDate.of(1940, 1, 1))
                    .setDateOfBirth(LocalDate.of(1960, 1, 1));

            assertThrows(IllegalStateException.class, () -> personBuilder.build());

        }

        @Test
        void dateOfBirthInThePastIsOk() {
            var dateOfBirth = LocalDate.of(2000, 12, 12);

            Person person = personBuilder
                    .setDateOfBirth(dateOfBirth)
                    .build();

            assertEquals(dateOfBirth, person.getDateOfBirth());
        }

        @Test
        void dateOfdeathAfterDateOfBirthIsOk() {
            var dateOfBirth = LocalDate.of(1940, 1, 1);
            var dateOfDeath = LocalDate.of(1960, 1, 1);

            Person person = personBuilder
                    .setDateOfBirth(dateOfBirth)
                    .setDateOfDeath(dateOfDeath)
                    .build();

            assertEquals(dateOfDeath, person.getDateOfDeath());
        }
    }


}
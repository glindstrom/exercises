package com.gabriel.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FamilyRelationsTest {

    @Nested
    class WhenAddingParents {

        @Test
        void twoParentsIsOk() {
            List<PersonId> parents = List.of(new PersonId(), new PersonId());

            var familyRelations = new FamilyRelations.Builder()
                    .setParents(parents)
                    .build();

            assertEquals(parents, familyRelations.getParents());
        }

        @Test
        void exceptionIsThrownWithMoreThanTwoParents() {

            var builder = new FamilyRelations.Builder();

            assertThrows(IllegalArgumentException.class, () -> builder.setParents(List.of(new PersonId(),
                    new PersonId(), new PersonId())));
        }
    }

}
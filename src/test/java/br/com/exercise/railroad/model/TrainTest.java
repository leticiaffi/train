package br.com.exercise.railroad.model;

import static br.com.exercise.railroad.dataprovider.CommonsProvider.provideId;
import static br.com.exercise.railroad.dataprovider.PassengerDataProvider.providePassenger;
import static br.com.exercise.railroad.dataprovider.PassengerDataProvider.providePassengerWithoutTicket;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.exercise.railroad.helpers.CamelCaseDisplayNameGenerator;

@CamelCaseDisplayNameGenerator
class TrainTest {

    @Test
    void shouldBuildTrain() {
        final Train train = new Train(provideId());

        assertNotNull(train);
    }

    @Test
    void shouldThrowExceptionIfTrainIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Train(null));
    }

    @Test
    void shouldReturnId() {
        String trainId = provideId();
        final Train train = new Train(trainId);

        assertEquals(trainId, train.getId());
    }

    @Test
    void shouldReturnEmptyPassengerListAfterCreatingTrain() {
        final Train train = new Train(provideId());

        assertNotNull(train.getPassengers());
        assertTrue(train.getPassengers().isEmpty());
    }

    @Test
    void shouldReturnFalseWhenPassengerHasNoTicket() {
        final Passenger passenger = providePassengerWithoutTicket();
        final Train train = new Train(provideId());

        final boolean embarked = train.embarkPassenger(passenger);
        assertFalse(embarked);
    }

    @Test
    void shouldReturnTrueIfPassengerIsAlreadyOnTheList() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());
        train.getPassengers().add(passenger);

        final boolean embarked = train.embarkPassenger(passenger);
        assertTrue(embarked);
    }

    @Test
    void shouldReturnFalseIfPassengerIsAlreadyOnTheListButHaveNoTicket() {
        final Passenger passenger = providePassenger();
        final Passenger passengerWithoutTicket = new Passenger(passenger.getId(), passenger.getName(), null);
        final Train train = new Train(provideId());
        train.getPassengers().add(passenger);

        final boolean embarked = train.embarkPassenger(passengerWithoutTicket);
        assertFalse(embarked);
    }

    @Test
    void shouldReturnTrueWhenPassengerHasTicket() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());

        final boolean embarked = train.embarkPassenger(passenger);
        assertTrue(embarked);
    }

    @Test
    void shouldAddPassengerOnTheListWhenPassengerHasTicket() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());

        final List<Passenger> expectedPassengers = new ArrayList<>();
        expectedPassengers.add(passenger);

        assertTrue(train.embarkPassenger(passenger));
        assertEquals(expectedPassengers, train.getPassengers());
    }

    @Test
    void shouldReturnTrueWhenPassengerIsOnTheList() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());
        assertTrue(train.embarkPassenger(passenger));

        boolean disembarked = train.disembarkPassenger(passenger);
        assertTrue(disembarked);
    }

    @Test
    void shouldRemovePassengerFromTheList() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());
        assertTrue(train.embarkPassenger(passenger));
        assertFalse(train.getPassengers().isEmpty());

        assertTrue(train.disembarkPassenger(passenger));
        assertTrue(train.getPassengers().isEmpty());
    }

    @Test
    void shouldReturnFalseWhenPassengerIsNotOnTheList() {
        final Passenger passenger = providePassenger();
        final Train train = new Train(provideId());

        assertTrue(train.getPassengers().isEmpty());
        assertFalse(train.disembarkPassenger(passenger));
    }

    @Test
    void shouldReturnTrueIfTrainsAreEqual() {
        String trainId = provideId();

        final Train train1 = new Train(trainId);
        final Train train2 = new Train(trainId);

        assertEquals(train1, train2);
    }

    @Test
    void shouldReturnFalseIfTrainsAreNotEqual() {
        final Train train1 = new Train(provideId());
        final Train train2 = new Train(provideId());

        assertNotEquals(train1, train2);
    }

    @Test
    void shouldReturnTrueIfTrainsHaveSameId() {
        String trainId = provideId();

        final Train train1 = new Train(trainId);
        final Train train2 = new Train(trainId);
        train2.embarkPassenger(providePassenger());

        assertEquals(train1, train2);
    }
}
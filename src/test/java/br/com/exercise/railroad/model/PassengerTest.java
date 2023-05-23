package br.com.exercise.railroad.model;

import static br.com.exercise.railroad.dataprovider.CommonsProvider.provideId;
import static br.com.exercise.railroad.dataprovider.PassengerDataProvider.provideName;
import static br.com.exercise.railroad.dataprovider.PassengerDataProvider.providePassenger;
import static br.com.exercise.railroad.dataprovider.PassengerDataProvider.provideTicket;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.exercise.railroad.helpers.CamelCaseDisplayNameGenerator;

@CamelCaseDisplayNameGenerator
class PassengerTest {

    @Test
    void shouldBuildPassengerWithAllParameters() {
        final Passenger passenger = new Passenger(provideId(), provideName(), provideTicket());

        assertNotNull(passenger);
    }

    @Test
    void shouldAllowBuildingPassengerWithNullTicket() {
        final Passenger passenger = new Passenger(provideId(), provideName(), null);

        assertNotNull(passenger);
    }

    @Test
    void shouldThrowExceptionIfIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Passenger(null, provideName(), provideTicket()));
    }

    @Test
    void shouldThrowExceptionIfNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Passenger(provideId(), null, provideTicket()));
    }

    @Test
    void shouldReturnPassengerId() {
        String passengerId = provideId();
        final Passenger passenger = new Passenger(passengerId, provideName(), provideTicket());

        assertEquals(passengerId, passenger.getId());
    }

    @Test
    void shouldReturnPassengerName() {
        String passengerName = provideName();
        final Passenger passenger = new Passenger(provideId(), passengerName, provideTicket());

        assertEquals(passengerName, passenger.getName());
    }

    @Test
    void shouldReturnTicketWhenPresent() {
        String ticket = provideTicket();
        final Passenger passenger = new Passenger(provideId(), provideName(), ticket);

        assertEquals(ticket, passenger.getTicket());
    }

    @Test
    void shouldReturnNullWhenTicketIsNotPresent() {
        final Passenger passenger = new Passenger(provideId(), provideName(), null);

        assertNull(passenger.getTicket());
    }

    @Test
    void shouldReturnTrueIfPassengerHasTicket() {
        final Passenger passenger = new Passenger(provideId(), provideName(), provideTicket());

        assertTrue(passenger.hasTicket());
    }

    @Test
    void shouldReturnFalseIfPassengerHasNoTicket() {
        final Passenger passenger = new Passenger(provideId(), provideName(), null);

        assertFalse(passenger.hasTicket());
    }

    @Test
    void shouldReturnTrueIfPassengersAreEqual() {
        String passengerId = provideId();
        String passengerName = provideName();
        String ticket = provideTicket();

        final Passenger passenger1 = new Passenger(passengerId, passengerName, ticket);
        final Passenger passenger2 = new Passenger(passengerId, passengerName, ticket);

        assertEquals(passenger1, passenger2);
    }

    @Test
    void shouldReturnFalseIfPassengersAreNotEqual() {
        final Passenger passenger1 = providePassenger();
        final Passenger passenger2 = providePassenger();

        assertNotEquals(passenger1, passenger2);
    }

    @Test
    void shouldReturnTrueIfPassengersHaveSameId() {
        String passengerId = provideId();

        final Passenger passenger1 = new Passenger(passengerId, provideName(), provideTicket());
        final Passenger passenger2 = new Passenger(passengerId, provideName(), null);

        assertEquals(passenger1, passenger2);
    }
}
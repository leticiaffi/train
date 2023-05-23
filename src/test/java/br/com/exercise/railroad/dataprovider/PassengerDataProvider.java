package br.com.exercise.railroad.dataprovider;


import static br.com.exercise.railroad.dataprovider.CommonsProvider.provideId;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import br.com.exercise.railroad.model.Passenger;

public final class PassengerDataProvider {

    private static final Faker FAKER = new Faker();

    private PassengerDataProvider() {
    }

    public static String provideName() {
        return FAKER.name().fullName();
    }

    public static String provideTicket() {
        return UUID.randomUUID().toString();
    }

    public static Passenger providePassenger() {
        return new Passenger(provideId(), provideName(), provideTicket());
    }

    public static Passenger providePassengerWithoutTicket() {
        return new Passenger(provideId(), provideName(), null);
    }
}

package br.com.exercise.railroad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * This model represents a Train entity
 */
public class Train {

    private final String id;
    private final List<Passenger> passengers;

    /**
     * Build a new train with id and an empty list of passengers to be managed
     * This method should throw an exception if the train id is null.
     *
     * @param id String representing the id of the Train
     *
     * @throws IllegalArgumentException if the Id parameter is null
     */
    public Train(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Train ID cannot be null");
        }
        this.id = id;
        this.passengers = new ArrayList<>();
    }

    /**
     * Return the Id of the Train
     *
     * @return String representing the Id of the train
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the list of passengers in the train
     *
     * @return The list of passengers currently in the train
     */
    public List<Passenger> getPassengers() {

        return passengers;
    }

    /**
     * Embark a new Passenger in the train following the given rules (in this specific order):
     *    1. If the passenger does not have a ticket, don't add it to the list of passengers and return False
     *    2. If the passenger is already in the passenger list, return True
     *    3. If the passenger has a ticket, add it to the list of passengers and return True
     *
     * @param passenger Passenger to be embarked
     *
     * @return True if the passenger has been embarked or False if not
     */
    public boolean embarkPassenger(final Passenger passenger) {
        if (passenger == null || !passenger.hasTicket()) {
            return false;
        }

        if (passengers.contains(passenger)) {
            return true;
        }

        passengers.add(passenger);
        return true;
    }

    /**
     * Disembark a Passenger out of the train following the given rules (in this specific order):
     *   1. If the passenger is in the Passenger list, remove it and return True
     *   2. If the passenger is not in the Passenger List, return False
     *
     * @param passenger Passenger to be disembarked
     *
     * @return True if the passenger has been disembarked or False if not
     */
    public boolean disembarkPassenger(final Passenger passenger) {

        return passengers.remove(passenger);
    }

    public boolean isAtStation() {

        return isAtStation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
       final Train train = (Train) o;
        return Objects.equals(id, train.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

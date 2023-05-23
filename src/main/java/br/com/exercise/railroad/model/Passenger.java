package br.com.exercise.railroad.model;

import java.util.Objects;

/**
 * This Model represents a passenger on a Train
 */
public class Passenger {

    private final String id;
    private final String name;
    private final String ticket;

    /**
     * Builds a new Passenger with it's name and ticket
     * This method should throw an exception if the passenger id or name is null.
     * The Ticket parameter could be null
     *
     * @param name Name of the passenger
     * @param ticket Ticket to board the train
     * @throws IllegalArgumentException if the Id or Name parameter is null
     */
    public Passenger(final String id, final String name, final String ticket) {
        if (id == null) {
            throw new IllegalArgumentException("Passenger ID cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Passenger name cannot be null");
        }
        this.id = id;
        this.name = name;
        this.ticket = ticket;
    }

    /**
     * Return the Id of the passenger
     *
     * @return String representing the Id of the passenger
     */
    public String getId() {
        return id;

    }

    /**
     * Return the Name of the passenger
     *
     * @return Name of the passenger
     */
    public String getName() {
        return name;

    }

    /**
     * Return the Ticket of the passenger, or null if the passenger doesn't have one
     *
     * @return The passenger Ticket if exists or null if it doesn't
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Return if the passenger has a Ticket or not
     *
     * @return True if the passenger has a ticket or False if it doesn't
     */
    public Boolean hasTicket() {
        return ticket != null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package br.com.exercise.railroad.controller;

import java.util.ArrayList;
import java.util.List;


import br.com.exercise.railroad.model.Passenger;
import br.com.exercise.railroad.model.Train;

/**
 * Train station to control Trains currently on the station
 * Also controls the passengers boarding and disembarking from trains
 */
public class TrainStation {

    private final List<Train> trains;

    /**
     * Builds a new Train Station with a Empty List of Trains
     */
    public TrainStation() {
        trains = new ArrayList<>();
    }

    /**
     * Return the trains currently on the station
     *
     * @return List of Trains
     */
    public List<Train> getTrains() {
        return trains;
    }

    /**
     * Returns the train by it's id, if not found on station, return null
     *
     * @param trainId Long representing the train id
     * @return Train entity if found on station or null if not found
     */
    public Train getTrain(final String trainId) {
        for (Train train : trains) {
            if (train.getId().equals(trainId)) {
                return train;
            }
        }
        return null;
    }

    /**
     * Allows a train to arrive at the station following the given rules (in this specific order):
     * 1. If this train is already on station, return true
     * 2. If the station has 5 trains or less, add the train to the list and return true
     * 3. If the station has more than 5 trains, return false
     *
     * @param train Train to arrive at the station
     * @return True if the train arrived at the station and False it not
     */
    public boolean arrive(final Train train) {
        if (trains.contains(train)) {
            return true;
        } else if (trains.size() < 5) {
            trains.add(train);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Allows a train to departure from the station following the given rules (in this specific order):
     * 1. If this train is not in the station, return False
     * 2. If this train is in the station, remove it from the trains list and return True
     *
     * @param train Train to departure from the station
     * @return True if the train departures from the station and False it not
     */
    public boolean departure(final Train train) {
        if (trains.contains(train)) {
            trains.remove(train);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if the Train is currently on the station or not
     *
     * @param train Train to check if it's on the station
     * @return True if the Train is on the station or False it not
     */

    public boolean isOnStation(final Train train) {
        return trains.contains(train);
    }

    /**
     * Returns if the Train is currently on the station or not by it's id
     *
     * @param trainId String representing the Id of the train to check if it's on the station
     * @return True if the Train is on the station or False it not
     */
    public boolean isOnStation(final String trainId) {
        for (Train train : trains) {
            if (train.getId().equals(trainId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Embark a new passenger on a train following the given rules (in this specific order):
     * 1. Is the train is not in the station, return False
     * 2. If the passenger embarked successfully, return True
     * 3. If the passenger did not embark successfully, return False
     *
     * @param train     Train that the passenger will be boarded
     * @param passenger Passenger to be boarded on the Train
     * @return True if the passenger boarded or false it not
     */
    public boolean embarkPassenger(Train train, Passenger passenger) {
        if (!train.isAtStation()) {
            return false;
        }

        if (train.getPassengers().contains(passenger)) {
            return true;
        }

        if (passenger.hasTicket()) {
            return train.getPassengers().add(passenger);
        }

        return false;
    }

}


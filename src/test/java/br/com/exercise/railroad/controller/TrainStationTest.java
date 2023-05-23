package br.com.exercise.railroad.controller;

import static br.com.exercise.railroad.dataprovider.CommonsProvider.provideId;
import static br.com.exercise.railroad.dataprovider.TrainDataProvider.provideTrain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.exercise.railroad.helpers.CamelCaseDisplayNameGenerator;
import br.com.exercise.railroad.model.Train;

@CamelCaseDisplayNameGenerator
class TrainStationTest {

    private TrainStation trainStation;

    @BeforeEach
    void setUp() {
        trainStation = new TrainStation();
    }

    @Test
    void shouldBuildTrainStationWithEmptyList() {
        assertNotNull(trainStation.getTrains());
        assertTrue(trainStation.getTrains().isEmpty());
    }

    @Test
    void shouldReturnTrainsOnStation() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));

        final List<Train> expectedTrains = new ArrayList<>();
        expectedTrains.add(train);

        assertEquals(expectedTrains, trainStation.getTrains());
    }

    @Test
    void shouldReturnTrainById() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));

        assertEquals(train, trainStation.getTrain(train.getId()));
    }

    @Test
    void shouldReturnNullWhenTrainIsNotFound() {
        assertNull(trainStation.getTrain(provideId()));
    }

    @Test
    void shouldReturnTrueWhenTrainIsAlreadyOnStation() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));

        assertTrue(trainStation.arrive(train));
    }

    @Test
    void shouldReturnTrueWhenTrainIsAddedToStation() {
        final Train train = provideTrain();

        assertTrue(trainStation.arrive(train));
    }

    @Test
    void shouldAddTrainToTrainListWhenTrainIsAddedToStation() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));

        final List<Train> expectedTrains = new ArrayList<>();
        expectedTrains.add(train);

        assertEquals(expectedTrains, trainStation.getTrains());
    }

    @Test
    void shouldReturnFalseWhenStationAlreadyHas5Trains() {
        for (int i = 0; i < 5; i++) {
            assertTrue(trainStation.arrive(provideTrain()));
        }

        assertFalse(trainStation.arrive(provideTrain()));
    }

    @Test
    void shouldReturnFalseWhenStationHasMoreThan5Trains() {
        for (int i = 0; i < 10; i++) {
            trainStation.arrive(provideTrain());
        }

        assertFalse(trainStation.arrive(provideTrain()));
    }

    @Test
    void shouldReturnFalseIfTrainIsNotInTheStation() {
        assertFalse(trainStation.departure(provideTrain()));
    }

    @Test
    void shouldReturnTrueIfTheTrainIsInTheStation() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));

        assertTrue(trainStation.departure(train));
    }

    @Test
    void shouldRemoveTrainFromStationIfTheTrainIsInTheStation() {
        final Train train = provideTrain();
        assertTrue(trainStation.arrive(train));
        assertTrue(trainStation.getTrains().contains(train));

        assertTrue(trainStation.departure(train));
        assertTrue(trainStation.getTrains().isEmpty());
    }
}
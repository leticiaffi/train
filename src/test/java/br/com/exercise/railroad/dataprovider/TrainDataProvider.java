package br.com.exercise.railroad.dataprovider;

import static br.com.exercise.railroad.dataprovider.CommonsProvider.provideId;

import br.com.exercise.railroad.model.Train;

public final class TrainDataProvider {

    private TrainDataProvider() {
    }

    public static Train provideTrain() {
        return new Train(provideId());
    }

}

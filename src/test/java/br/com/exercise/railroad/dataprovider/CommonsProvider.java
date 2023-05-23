package br.com.exercise.railroad.dataprovider;

import java.util.UUID;

public final class CommonsProvider {

    private CommonsProvider() {
    }

    public static String provideId() {
        return UUID.randomUUID().toString();
    }

}

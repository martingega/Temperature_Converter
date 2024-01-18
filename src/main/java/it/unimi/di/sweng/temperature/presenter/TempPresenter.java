package it.unimi.di.sweng.temperature.presenter;

import it.unimi.di.sweng.temperature.Observable;
import it.unimi.di.sweng.temperature.model.Model;
import it.unimi.di.sweng.temperature.view.View;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class TempPresenter implements Presenter {
    private final Model model;
    private final View view;
    private final ScaleStrategy scale;

    public TempPresenter(Model model, View view, ScaleStrategy scale) {
        this.model = model;
        this.view = view;
        this.scale = scale;
    }

    @Override
    public void update(@NotNull Observable<Double> subject, @NotNull Double state) {
        double scaledTemp = scale.convertFromCelsius(state);
        view.setValue(String.format(Locale.US,"%.2f", scaledTemp));
    }

    @Override
    public void updateModel(@NotNull String text) {
        String scaledTemp = view.getValue();
        double celsiusTemp = scale.convertToCelsius(Double.parseDouble(scaledTemp));
        model.setTemp(celsiusTemp);
    }
}


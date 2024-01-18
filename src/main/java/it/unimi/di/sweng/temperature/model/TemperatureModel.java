package it.unimi.di.sweng.temperature.model;

import it.unimi.di.sweng.temperature.Observer;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TemperatureModel implements Model {

  private double val = 0.0;
  private final List<Observer<Double>> observers = new ArrayList<>();
  public static final double PRECISION = 0.01;

  @Override
  public void notifyObservers() {
    for (Observer<Double> observer : observers){
      observer.update(this, getTemp());
    }
  }

  @Override
  public void addObserver(@NotNull Observer<Double> obs) {
    observers.add(obs);
  }

  @Override
  public @NotNull Double getState() {
    return getTemp();
  }

  @Override
  public double getTemp() {
    return val;
  }

  @Override
  public void setTemp(double temp) {
    if (Math.abs(val - temp) >= PRECISION) {
      val = temp;
      notifyObservers();
    }
  }
}

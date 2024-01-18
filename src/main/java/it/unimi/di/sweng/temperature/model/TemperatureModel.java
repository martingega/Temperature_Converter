package it.unimi.di.sweng.temperature.model;

import it.unimi.di.sweng.temperature.Observer;
import org.jetbrains.annotations.NotNull;

public class TemperatureModel implements Model {

  private double val = 0.0;

  @Override
  public void notifyObservers() {

  }

  @Override
  public void addObserver(@NotNull Observer<Double> obs) {

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
    val = temp;
  }

  //TODO implementare i doveri ereditati dalla interfaccia

}

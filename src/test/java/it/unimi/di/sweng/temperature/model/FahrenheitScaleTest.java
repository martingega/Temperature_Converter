package it.unimi.di.sweng.temperature.model;

import static org.assertj.core.api.Assertions.assertThat;
import it.unimi.di.sweng.temperature.presenter.FahrenheitScale;
import it.unimi.di.sweng.temperature.presenter.ScaleStrategy;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FahrenheitScaleTest {

    @ParameterizedTest
    @CsvSource({"0, 32", "21, 69.8", "-7, 19.4"})
    void convertFromCelsius(double c, double f) {
        ScaleStrategy SUT = new FahrenheitScale();
        assertThat(SUT.convertToCelsius(32))
                .isCloseTo(0, Offset.offset(TemperatureModel.PRECISION));
    }

    @ParameterizedTest
    @CsvSource({"0, 32", "21, 69.8", "-7, 19.4"})
    void convertToCelsius(double c, double f) {
        ScaleStrategy SUT = new FahrenheitScale();
        assertThat(SUT.convertToCelsius(f))
                .isCloseTo(c, Offset.offset(TemperatureModel.PRECISION));
    }
}


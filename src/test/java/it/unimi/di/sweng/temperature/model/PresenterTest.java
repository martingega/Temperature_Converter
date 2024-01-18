package it.unimi.di.sweng.temperature.model;

import static org.mockito.Mockito.*;

import it.unimi.di.sweng.temperature.presenter.Presenter;
import it.unimi.di.sweng.temperature.presenter.ScaleStrategy;
import it.unimi.di.sweng.temperature.presenter.TempPresenter;
import it.unimi.di.sweng.temperature.view.View;
import org.junit.jupiter.api.Test;

class PresenterTest {

    @Test
    void updateModel() {

        View view = mock(View.class);
        when(view.getValue()).thenReturn("424242.42");
        ScaleStrategy scale = mock(ScaleStrategy.class);
        when(scale.convertToCelsius(424242.42)).thenReturn(242.24);
        Model model = mock(Model.class);

        Presenter SUT = new TempPresenter(model, view, scale);

        SUT.updateModel("4.42");

        verify(view).getValue();
        verify(scale).convertToCelsius(424242.42);
        verify(model).setTemp(242.24);
    }

    @Test
    void updateTest() {

        View view = mock(View.class);
        ScaleStrategy scale = mock(ScaleStrategy.class);
        when(scale.convertFromCelsius(4422.22)).thenReturn(2222.44);
        Model model = mock(Model.class);

        Presenter SUT = new TempPresenter(model, view, scale);

        SUT.update(model, 4422.22);

        verify(scale).convertFromCelsius(4422.22);
        verify(view).setValue("2222.44");
    }

    @Test
    void update2DigitTest() {

        View view = mock(View.class);
        ScaleStrategy scale = mock(ScaleStrategy.class);
        when(scale.convertFromCelsius(4422.22)).thenReturn(2222.4);
        Model model = mock(Model.class);

        Presenter SUT = new TempPresenter(model, view, scale);

        SUT.update(model, 4422.22);

        verify(scale).convertFromCelsius(4422.22);
        verify(view).setValue("2222.40");
    }

}


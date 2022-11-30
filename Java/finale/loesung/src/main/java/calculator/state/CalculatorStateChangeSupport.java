package calculator.state;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatorStateChangeSupport {
    private final PropertyChangeSupport inputValueChange;
    private final PropertyChangeSupport inputBufferChange;
    private final PropertyChangeSupport allButtonsEnabledChange;
    private final PropertyChangeSupport commaButtonEnabledChange;
    private final PropertyChangeSupport calculationResultChange;
    private final PropertyChangeSupport inputForegroundChange;

    public CalculatorStateChangeSupport(CalculatorState state) {
        inputValueChange = new PropertyChangeSupport(state);
        inputBufferChange = new PropertyChangeSupport(state);
        allButtonsEnabledChange = new PropertyChangeSupport(state);
        commaButtonEnabledChange = new PropertyChangeSupport(state);
        calculationResultChange = new PropertyChangeSupport(state);
        inputForegroundChange = new PropertyChangeSupport(state);
    }

    // region Register Listeners

    public void registerForInputValueChange(PropertyChangeListener listener) {
        inputValueChange.addPropertyChangeListener(listener);
    }

    public void registerForInputBufferChange(PropertyChangeListener listener) {
        inputBufferChange.addPropertyChangeListener(listener);
    }

    public void registerForAllButtonsEnabledChange(PropertyChangeListener listener) {
        allButtonsEnabledChange.addPropertyChangeListener(listener);
    }

    public void registerForCommaButtonEnabledChange(PropertyChangeListener listener) {
        commaButtonEnabledChange.addPropertyChangeListener(listener);
    }

    public void registerForCalculationResultChange(PropertyChangeListener listener) {
        calculationResultChange.addPropertyChangeListener(listener);
    }

    public void registerForInputForegroundChange(PropertyChangeListener listener) {
        inputForegroundChange.addPropertyChangeListener(listener);
    }

    // endregion

    // region Notify Listeners

    public void fireInputValueChange(Object oldValue, Object newValue) {
        inputValueChange.firePropertyChange("inputValue", oldValue, newValue);
    }

    public void fireInputBufferChange(Object oldValue, Object newValue) {
        inputBufferChange.firePropertyChange("inputBuffer", oldValue, newValue);
    }

    public void fireAllButtonsEnabledChange(Object oldValue, Object newValue) {
        allButtonsEnabledChange.firePropertyChange("allButtonsEnabled", oldValue, newValue);
    }

    public void fireCommaButtonEnabledChange(Object oldValue, Object newValue) {
        commaButtonEnabledChange.firePropertyChange("commaButtonEnabled", oldValue, newValue);
    }

    public void fireCalculationResultChange(Object oldValue, Object newValue) {
        calculationResultChange.firePropertyChange("calculationResult", oldValue, newValue);
    }

    public void fireInputForegroundChange(Object oldValue, Object newValue) {
        inputForegroundChange.firePropertyChange("inputForeground", oldValue, newValue);
    }

    // endregion
}

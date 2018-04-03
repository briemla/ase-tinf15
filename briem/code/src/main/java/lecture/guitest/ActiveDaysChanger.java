package lecture.guitest;


import java.time.DayOfWeek;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public final class ActiveDaysChanger implements ChangeListener<Boolean> {
    private final ObjectProperty<ActiveDays> daysProperty;
    private final DayOfWeek dayOfWeek;

    public ActiveDaysChanger(ObjectProperty<ActiveDays> daysProperty, DayOfWeek dayOfWeek) {
        this.daysProperty = daysProperty;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> change, Boolean oldValue, Boolean newValue) {
        ActiveDays activeDays = daysProperty.get();
        if (newValue) {
            daysProperty.set(activeDays.with(dayOfWeek));
            return;
        }
        daysProperty.set(activeDays.without(dayOfWeek));
    }
}
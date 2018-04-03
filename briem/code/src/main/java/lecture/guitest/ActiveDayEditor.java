package lecture.guitest;


import java.time.DayOfWeek;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ActiveDayEditor extends GridPane {

    @FXML
    private CheckBox monday;
    @FXML
    private CheckBox tuesday;
    @FXML
    private CheckBox wednesday;
    @FXML
    private CheckBox thursday;
    @FXML
    private CheckBox friday;
    @FXML
    private CheckBox saturday;
    @FXML
    private CheckBox sunday;
    @FXML
    private CheckBox workdays;
    @FXML
    private CheckBox weekend;
    @FXML
    private CheckBox daily;

    private final ObjectProperty<ActiveDays> daysProperty;

    public ActiveDayEditor() {
        FXUtil.load(this, this);
        daysProperty = new SimpleObjectProperty<>(new ActiveDays());
        initWorkdaysBinding();
        initWeekendBinding();
        initDailyBinding();
        initUpdateActiveDays();
        initDaysListener();
        updateValues();
    }

    private void initWorkdaysBinding() {
        EventHandler<MouseEvent> workdaysChanger = (event) -> workdays.setSelected(isWorkdays());
        monday.addEventHandler(MouseEvent.MOUSE_CLICKED, workdaysChanger);
        tuesday.addEventHandler(MouseEvent.MOUSE_CLICKED, workdaysChanger);
        wednesday.addEventHandler(MouseEvent.MOUSE_CLICKED, workdaysChanger);
        thursday.addEventHandler(MouseEvent.MOUSE_CLICKED, workdaysChanger);
        friday.addEventHandler(MouseEvent.MOUSE_CLICKED, workdaysChanger);
        workdays.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            boolean selected = workdays.isSelected();
            monday.setSelected(selected);
            tuesday.setSelected(selected);
            wednesday.setSelected(selected);
            thursday.setSelected(selected);
            friday.setSelected(selected);
        });
    }

    private void initWeekendBinding() {
        EventHandler<MouseEvent> weekendChanger = (event) -> weekend.setSelected(isWeekend());
        saturday.addEventHandler(MouseEvent.MOUSE_CLICKED, weekendChanger);
        sunday.addEventHandler(MouseEvent.MOUSE_CLICKED, weekendChanger);
        weekend.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            boolean selected = weekend.isSelected();
            saturday.setSelected(selected);
            sunday.setSelected(selected);
        });
    }

    private void initDailyBinding() {
        EventHandler<MouseEvent> dailyChanger = (event) -> daily.setSelected(isDaily());
        monday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        tuesday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        wednesday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        thursday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        friday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        saturday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        sunday.addEventHandler(MouseEvent.MOUSE_CLICKED, dailyChanger);
        daily.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            boolean selected = daily.isSelected();
            monday.setSelected(selected);
            tuesday.setSelected(selected);
            wednesday.setSelected(selected);
            thursday.setSelected(selected);
            friday.setSelected(selected);
            saturday.setSelected(selected);
            sunday.setSelected(selected);
        });
    }

    private void initUpdateActiveDays() {
        monday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.MONDAY));
        tuesday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.TUESDAY));
        wednesday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.WEDNESDAY));
        thursday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.THURSDAY));
        friday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.FRIDAY));
        saturday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.SATURDAY));
        sunday.selectedProperty().addListener(new ActiveDaysChanger(daysProperty, DayOfWeek.SUNDAY));
    }

    private void initDaysListener() {
        daysProperty.addListener((change, oldValue, newValue) -> updateValues());
    }

    private void updateValues() {
        monday.setSelected(daysProperty.get().contains(DayOfWeek.MONDAY));
        tuesday.setSelected(daysProperty.get().contains(DayOfWeek.TUESDAY));
        wednesday.setSelected(daysProperty.get().contains(DayOfWeek.WEDNESDAY));
        thursday.setSelected(daysProperty.get().contains(DayOfWeek.THURSDAY));
        friday.setSelected(daysProperty.get().contains(DayOfWeek.FRIDAY));
        saturday.setSelected(daysProperty.get().contains(DayOfWeek.SATURDAY));
        sunday.setSelected(daysProperty.get().contains(DayOfWeek.SUNDAY));
        workdays.setSelected(isWorkdays());
        weekend.setSelected(isWeekend());
        daily.setSelected(isDaily());
    }

    private Boolean isWorkdays() {
        return monday.isSelected() && tuesday.isSelected() && wednesday.isSelected() && thursday.isSelected() && friday.isSelected();
    }

    private boolean isWeekend() {
        return saturday.isSelected() && sunday.isSelected();
    }

    private boolean isDaily() {
        return monday.isSelected() && tuesday.isSelected() && wednesday.isSelected() && thursday.isSelected() && friday.isSelected() && saturday.isSelected()
                && sunday.isSelected();
    }

    public ObjectProperty<ActiveDays> daysProperty() {
        return daysProperty;
    }

}

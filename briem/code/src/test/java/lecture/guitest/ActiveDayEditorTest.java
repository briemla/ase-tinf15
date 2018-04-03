package lecture.guitest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.util.EnumSet;

import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import lecture.guitest.ActiveDayEditor;
import lecture.guitest.ActiveDays;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;

public class ActiveDayEditorTest extends GuiTest {

	private CheckBox monday;
	private CheckBox tuesday;
	private CheckBox wednesday;
	private CheckBox thursday;
	private CheckBox friday;
	private CheckBox saturday;
	private CheckBox sunday;
	private CheckBox workdays;
	private CheckBox weekend;
	private CheckBox daily;
	private ActiveDayEditor activeDayEditor;

	@Override
	protected Parent getRootNode() {
		activeDayEditor = new ActiveDayEditor();
		return activeDayEditor;
	}

	@Before
	public void initialize() {
		monday = find("#monday");
		tuesday = find("#tuesday");
		wednesday = find("#wednesday");
		thursday = find("#thursday");
		friday = find("#friday");
		saturday = find("#saturday");
		sunday = find("#sunday");
		workdays = find("#workdays");
		weekend = find("#weekend");
		daily = find("#daily");
		allChecked();
	}

	@Test
	public void checkMonday() throws Exception {
		click(monday);
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		weekendChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.MONDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(monday);
		allChecked();
	}

	@Test
	public void checkTuesday() throws Exception {
		click(tuesday);
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		weekendChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.TUESDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(tuesday);
		allChecked();
	}

	@Test
	public void checkWednesday() throws Exception {
		click(wednesday);
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		weekendChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.WEDNESDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(wednesday);
		allChecked();
	}

	@Test
	public void checkThursday() throws Exception {
		click(thursday);
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		weekendChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.THURSDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(thursday);
		allChecked();
	}

	@Test
	public void checkFriday() throws Exception {
		click(friday);
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		weekendChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.FRIDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(friday);
		allChecked();
	}

	@Test
	public void checkSaturday() throws Exception {
		click(saturday);
		assertThat(saturday.isSelected(), is(false));
		assertThat(sunday.isSelected(), is(true));
		assertThat(weekend.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		workdaysChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.SATURDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(saturday);
		allChecked();
	}

	@Test
	public void checkSunday() throws Exception {
		click(sunday);
		assertThat(saturday.isSelected(), is(true));
		assertThat(sunday.isSelected(), is(false));
		assertThat(weekend.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));
		workdaysChecked();

		ActiveDays allWithoutOne = new ActiveDays(EnumSet.complementOf(EnumSet.of(DayOfWeek.SUNDAY)));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allWithoutOne)));

		click(sunday);
		allChecked();
	}

	@Test
	public void checkOnlyMonday() throws Exception {
		clickWeekendDays();
		click(tuesday);
		click(wednesday);
		click(thursday);
		click(friday);
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
		weekendUnchecked();
		assertThat(daily.isSelected(), is(false));

		ActiveDays workdaysActive = new ActiveDays(EnumSet.of(DayOfWeek.MONDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(workdaysActive)));
	}

	@Test
	public void checkOnlyTuesday() throws Exception {
		clickWeekendDays();
		click(monday);
		click(wednesday);
		click(thursday);
		click(friday);
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
		weekendUnchecked();
		assertThat(daily.isSelected(), is(false));

		ActiveDays workdaysActive = new ActiveDays(EnumSet.of(DayOfWeek.TUESDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(workdaysActive)));
	}

	@Test
	public void checkOnlyWednesday() throws Exception {
		clickWeekendDays();
		click(monday);
		click(tuesday);
		click(thursday);
		click(friday);
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
		weekendUnchecked();
		assertThat(daily.isSelected(), is(false));

		ActiveDays workdaysActive = new ActiveDays(EnumSet.of(DayOfWeek.WEDNESDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(workdaysActive)));
	}

	@Test
	public void checkOnlyThursday() throws Exception {
		clickWeekendDays();
		click(monday);
		click(tuesday);
		click(wednesday);
		click(friday);
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
		weekendUnchecked();
		assertThat(daily.isSelected(), is(false));

		ActiveDays workdaysActive = new ActiveDays(EnumSet.of(DayOfWeek.THURSDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(workdaysActive)));
	}

	@Test
	public void checkOnlyFriday() throws Exception {
		clickWeekendDays();
		click(monday);
		click(tuesday);
		click(wednesday);
		click(thursday);
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(false));
		weekendUnchecked();
		assertThat(daily.isSelected(), is(false));

		ActiveDays workdaysActive = new ActiveDays(EnumSet.of(DayOfWeek.FRIDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(workdaysActive)));
	}

	@Test
	public void checkOnlySaturday() throws Exception {
		clickWorkDays();
		click(sunday);
		workdaysUnchecked();
		assertThat(saturday.isSelected(), is(true));
		assertThat(sunday.isSelected(), is(false));
		assertThat(weekend.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));

		ActiveDays weekendActive = new ActiveDays(EnumSet.of(DayOfWeek.SATURDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(weekendActive)));
	}

	@Test
	public void checkOnlySunday() throws Exception {
		clickWorkDays();
		click(saturday);
		workdaysUnchecked();
		assertThat(saturday.isSelected(), is(false));
		assertThat(sunday.isSelected(), is(true));
		assertThat(weekend.isSelected(), is(false));
		assertThat(daily.isSelected(), is(false));

		ActiveDays weekendActive = new ActiveDays(EnumSet.of(DayOfWeek.SUNDAY));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(weekendActive)));
	}

	@Test
	public void allCheckedWhenLastGetUnchecked() throws Exception {
		clickWorkDays();
		clickWeekendDays();

		allChecked();
	}

	@Test
	public void checkWorkDays() throws Exception {
		clickWorkDays();
		workdaysUnchecked();
		click(workdays);
		workdaysChecked();
	}

	@Test
	public void checkWeekend() throws Exception {
		clickWeekendDays();
		weekendUnchecked();
		click(weekend);
		weekendChecked();
	}

	@Test
	public void checkDaily() throws Exception {
		clickWorkDays();
		workdaysUnchecked();
		click(daily);
		allChecked();

		clickWeekendDays();
		weekendUnchecked();
		click(daily);
		allChecked();
	}

	private void allChecked() {
		workdaysChecked();
		weekendChecked();
		assertThat(daily.isSelected(), is(true));
		ActiveDays allActive = new ActiveDays(EnumSet.allOf(DayOfWeek.class));
		ActiveDays activeDays = activeDayEditor.daysProperty().get();

		assertThat(activeDays, is(equalTo(allActive)));
	}

	private void workdaysChecked() {
		assertThat(monday.isSelected(), is(true));
		assertThat(tuesday.isSelected(), is(true));
		assertThat(wednesday.isSelected(), is(true));
		assertThat(thursday.isSelected(), is(true));
		assertThat(friday.isSelected(), is(true));
		assertThat(workdays.isSelected(), is(true));
	}

	private void weekendChecked() {
		assertThat(saturday.isSelected(), is(true));
		assertThat(sunday.isSelected(), is(true));
		assertThat(weekend.isSelected(), is(true));
	}

	private void workdaysUnchecked() {
		assertThat(monday.isSelected(), is(false));
		assertThat(tuesday.isSelected(), is(false));
		assertThat(wednesday.isSelected(), is(false));
		assertThat(thursday.isSelected(), is(false));
		assertThat(friday.isSelected(), is(false));
		assertThat(workdays.isSelected(), is(false));
	}

	private void weekendUnchecked() {
		assertThat(saturday.isSelected(), is(false));
		assertThat(sunday.isSelected(), is(false));
		assertThat(weekend.isSelected(), is(false));
	}

	private void clickWorkDays() {
		click(monday);
		click(tuesday);
		click(wednesday);
		click(thursday);
		click(friday);
	}

	private void clickWeekendDays() {
		click(saturday);
		click(sunday);
	}

}

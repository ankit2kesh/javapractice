import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Chronounit {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println(nextMonth);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println(nextYear);
		;
	}
}
package lab2;


// объединил 2 класса в 1
/**
 * класс для представления полного имени человека
 * (фамилия, имя, отчество).
 */
public final class Name {
	private final String lastName;

	private final String firstName;

	private final String patronymic;

	/**
	 * конструктор с только личным именем (задание 1.3).
	 *
	 * @param firstName личное имя
	 */
	public Name(final String firstName) {
		this.lastName = null;
		this.firstName = firstName;
		this.patronymic = null;
	}

	/**
	 * конструктор с фамилией и личным именем (задание 4.5).
	 *
	 * @param lastName фамилия
	 * @param firstName личное имя
	 */
	public Name(
		final String lastName,
		final String firstName
	) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.patronymic = null;
	}

	/**
	 * конструктор со всеми параметрами (задание 4.5).
	 *
	 * @param lastName фамилия
	 * @param firstName личное имя
	 * @param patronymic отчество
	 */
	public Name(
		final String lastName,
		final String firstName,
		final String patronymic
	) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.patronymic = patronymic;
	}

	/**
	 * возвращает строковое представление имени.
	 *
	 * @return строка с указанными компонентами имени
	 */
	@Override
	public String toString() {
		// stringbuilder для оптимизации
		final StringBuilder result = new StringBuilder();

		if (lastName != null && !lastName.isEmpty()) {
			result.append(lastName);
		}

		if (firstName != null && !firstName.isEmpty()) {
			if (result.length() > 0) {
				result.append(" ");
			}
			result.append(firstName);
		}

		if (patronymic != null && !patronymic.isEmpty()) {
			if (result.length() > 0) {
				result.append(" ");
			}
			result.append(patronymic);
		}

		return result.toString();
	}
}

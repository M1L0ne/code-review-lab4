package lab2;


/**
 * класс для представления сотрудника с
 * принадлежностью к отделу (задание 2.4).
 */
public final class Employee {
	private final String name;

	private final Department department;

	/**
	 * конструктор для создания сотрудника.
	 *
	 * @param name имя сотрудника
	 * @param department отдел сотрудника
	 */
	public Employee(
		final String name,
		final Department department
	) {
		this.name = name;
		this.department = department;
		department.addEmployee(this);
	}

	/**
	 * возвращает строковое представление сотрудника.
	 *
	 * @return строка с информацией о сотруднике
	 */
	@Override
	public String toString() {
		if (this == department.getHead()) {	
			final String result = name + " начальник отдела "
				+ department.getName();
			return result;
		}

		final String headName = (department.getHead() != null)
				? department.getHead().getName()
				: "не назначен";

		final String result = name + " работает в отделе " 
			+ department.getName() + ", начальник которого "
			+ headName;

		return result;
	}
    
	/**
	 * возвращает имя сотрудника.
	 *
	 * @return имя сотрудника
	 */
	public String getName() {
		return name;
	}

	/**
	 * возвращает отдел сотрудника.
	 *
	 * @return отдел сотрудника
	 */
	public Department getDepartment() {
		return department;
	}
}
package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * класс для представления отдела с сотрудниками
 * и начальником (задание 2.4).
 */
public final class Department {
	private final String name;

	private final List<Employee> employees;

	private Employee head;

	/**
	 * конструктор для создания отдела.
	 *
	 * @param name название отдела
	 */
	public Department(final String name) {
		this.name = name;
		this.employees = new ArrayList<>();
		this.head = null;
	}

	/**
	 * устанавливает начальника отдела.
	 *
	 * @param head сотрудник - начальник
	 */
	public void setHead(final Employee head) {
		this.head = head;
	}

	/**
	 * возвращает название отдела.
	 *
	 * @return название отдела
	 */
	public String getName() {
		return name;
	}

	/**
	 * возвращает начальника отдела.
	 *
	 * @return сотрудник - начальник отдела
	 */
	public Employee getHead() {
		return head;
	}

    /**
     * добавляет сотрудника в отдел.
     *
     * @param employee сотрудник для добавления
     */
    public void addEmployee(final Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }

	/**
	 * возвращает неизменяемый список сотрудников отдела.
	 *
	 * @return список сотрудников
	 */
    public List<Employee> getEmployees() {
        return employees;
    }
}
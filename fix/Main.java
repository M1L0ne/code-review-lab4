package lab2;

import java.util.List;
import java.util.Scanner;


/**
 * главный класс для демонстрации лабораторной работы №2.
 */
public final class Main {
	private static final Scanner SCANNER =
		new Scanner(System.in);

	private static final int EXIT_CODE = -1;

	/**
	 * главный метод программы.
	 *
	 * @param args аргументы командной строки
	 */
	public static void main(final String[] args) {
		try {
			int taskNum = 0;

			System.out.println(
				"=== Лабораторная работа №2 (Вариант 4) ==="
			);
			System.out.println(
				"Для выхода введите '-1'"
			);

			while (true) {
				System.out.print(
					"Введите номер задачи (1-6): "
				);

				taskNum = readInt();

				if (taskNum == EXIT_CODE) {
					break;
				}

				switch (taskNum) {
					case 1:
						taskHuman();
						break;
					case 2:
						taskName();
						break;
					case 3:
                        taskDepartmentEmployees();
						break;
					case 4:
						taskDeptEmployeesList();
						break;
					case 5:
						taskNames();
						break;
					case 6:
						taskGun();
						break;
					default:
						System.out.println(
							"Ошибка: номер задачи"
							+ " должен быть от 1 до 6"
						);
				}
			}
		} catch (Exception exception) {
			System.out.println(
				"Ошибка: " + exception.getMessage()
			);
		} finally {
			if (SCANNER != null) {
				SCANNER.close();
			}
		}
	}

	/**
	 * читает целое число из ввода с обработкой ошибок.
	 *
	 * @return прочитанное целое число
	 */
	private static int readInt() {
		while (true) {
			try {
				final String line = SCANNER.nextLine().trim();

				if (line.isEmpty()) {
					continue;
				}

				final int value = Integer.parseInt(line);

				return value;
			} catch (NumberFormatException exception) {
				System.out.print(
					"Ошибка: введите целое число: "
				);
			}
		}
	}

	/**
	 * читает положительное целое число с
	 * проверкой корректности.
	 *
	 * @param prompt подсказка для пользователя
	 * @return прочитанное положительное число
	 */
	private static int readPositiveInt(final String prompt) {
		while (true) {
			System.out.print(prompt);

			final int value = readInt();

			if (value > 0) {
				return value;
			}

			System.out.println(
				"Ошибка: число должно быть строго больше нуля."
			);
		}
	}

	/**
	 * читает неотрицательное целое число с
	 * проверкой корректности.
	 *
	 * @param prompt подсказка для пользователя
	 * @return прочитанное неотрицательное число
	 */
	private static int readNonNegativeInt(
		final String prompt
	) {
		while (true) {
			System.out.print(prompt);

			final int value = readInt();

			if (value >= 0) {
				return value;
			}

			System.out.println(
				"Ошибка: число не может быть отрицательным."
			);
		}
	}

	/**
	 * выполняет задачу 1.2: создание и вывод человека.
	 */
	private static void taskHuman() {
		System.out.println(
			"\n--- Задача 1.2: Человек ---"
		);

		System.out.print("Введите имя: ");

		final String name = SCANNER.nextLine().trim();

		final int height =
			readPositiveInt("Введите рост (см): ");

		final Human human = new Human(name, height);

		System.out.println(human);
		System.out.println();
	}

	/**
	 * выполняет задачу 1.3: создание и вывод имени.
	 */
	private static void taskName() {
		System.out.println("\n--- Задача 1.3: Имя ---");
		System.out.print("Введите фамилию (или Enter): ");

		final String lastName = SCANNER.nextLine().trim();

		System.out.print("Введите личное имя: ");

		final String firstName = SCANNER.nextLine().trim();

		System.out.print("Введите отчество (или Enter): ");

		final String patronymic = SCANNER.nextLine().trim();

		final Name nameObj = new Name(
            lastName.isEmpty() ? null : lastName, firstName,
			patronymic.isEmpty() ? null : patronymic
		);

		System.out.println(nameObj);
		System.out.println();
	}

	/**
	 * выполняет задачу 2.4: создание сотрудников и отделов.
	 */
	private static void taskDepartmentEmployees() {
		System.out.println(
			"\n--- Задача 2.4: Сотрудники и отделы ---"
		);
		System.out.print("Название отдела: ");

		final String departmentName =
                SCANNER.nextLine().trim();

		final Department department =
                new Department(departmentName);

		System.out.print("Имя сотрудника 1: ");
		final Employee employee1 = new Employee(
            SCANNER.nextLine().trim(), department
        );

		System.out.print(
			"Имя сотрудника 2 (будет начальником): "
		);

		final Employee employee2 = new Employee(
            SCANNER.nextLine().trim(), department
        );

		System.out.print("Имя сотрудника 3: ");

		final Employee employee3 = new Employee(
            SCANNER.nextLine().trim(), department
        );

        department.setHead(employee2);

		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		System.out.println();
	}

	/**
	 * выполняет задачу 3.4: получение
	 * списка сотрудников отдела.
	 */
	private static void taskDeptEmployeesList() {
		System.out.println(
			"\n--- Задача 3.4: Список сотрудников ---"
		);
		System.out.print("Название отдела: ");

		final Department department = new Department(
				SCANNER.nextLine().trim()
			);

		System.out.print("Имя сотрудника 1: ");

		final Employee employee1 = new Employee(
            SCANNER.nextLine().trim(), department
        );

		System.out.print("Имя сотрудника 2 (начальник): ");

		final Employee employee2 = new Employee(
            SCANNER.nextLine().trim(), department
        );

        department.setHead(employee2);

		System.out.print("Имя сотрудника 3: ");

		new Employee(SCANNER.nextLine().trim(), department);

		final List<Employee> employees =
                employee1.getDepartment().getEmployees();

		System.out.println(
			"\nКоллеги сотрудника '"
			+ employee1.getName() + "':"
		);

		for (final Employee employee : employees) {
			System.out.println("  - " + employee.getName());
		}

		System.out.println();
	}

	/**
	 * выполняет задачу 4.5: создание имен с
	 * разными конструкторами.
	 */
	private static void taskNames() {
		System.out.println(
			"\n--- Задача 4.5: Имена (разные конструкторы) ---"
		);

		System.out.print("1. Только личное имя: ");

		final Name name1 = new Name(SCANNER.nextLine().trim());

		System.out.println(name1);

		System.out.print("2. Фамилия и личное имя:\n");

		System.out.print("   Фамилия: ");

		final String lastName = SCANNER.nextLine().trim();

		System.out.print("   Личное имя: ");

		final Name name2 = new Name(lastName,
			SCANNER.nextLine().trim()
		);

		System.out.println(name2);
		System.out.print("3. Полное ФИО:\n");
		System.out.print("   Фамилия: ");

		final String lastNameFull = SCANNER.nextLine().trim();

		System.out.print("   Личное имя: ");

		final String firstNameFull = SCANNER.nextLine().trim();

		System.out.print("   Отчество: ");

		final String patronymic = SCANNER.nextLine().trim();

		final Name name3 = new Name(
			lastNameFull,
			firstNameFull,
			patronymic
		);

		System.out.println(name3);
		System.out.println();
	}

	/**
	 * выполняет задачу 5.1: создание пистолета и выстрелы.
	 */
	private static void taskGun() {
		System.out.println(
			"\n--- Задача 5.1: Пистолет ---"
		);

		final int bullets =
			readNonNegativeInt("Количество патронов: " );

		final int fireTimes =
			readNonNegativeInt("Сколько раз стрелять: " );

		final Gun gun = new Gun(bullets);
		for (int i = 0; i < fireTimes; i++) {
			gun.fire();
		}

		System.out.println();
	}
}
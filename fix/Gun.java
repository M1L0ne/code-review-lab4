package lab2;


/**
 * класс для представления пистолета с возможностью стрельбы
 * (задание 5.1).
 */
public final class Gun {
	// переделал в константу в верхнем регистре
	private static final int DEFAULT_BULLETS = 5;

	private int bullets;
    
	/**
	 * конструктор с указанным количеством патронов.
	 *
	 * @param bullets количество патронов
	 */
	public Gun(final int bullets) {
		this.bullets = bullets;
	}

	/**
	 * конструктор с количеством патронов по умолчанию
     * (5 штук).
	 */
	public Gun() {
		this.bullets = DEFAULT_BULLETS;
	}

	/**
	 * выполняет выстрел. выводит "бах!"
	 * если есть патроны, "клац!" если нет.
	 */
	public void fire() {
		if (bullets > 0) {
			bullets--;
			System.out.println("Бах!");
		} else {
			System.out.println("Клац!");
		}
	}
}

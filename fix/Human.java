package lab2;


/**
 * класс для представления человека с именем и ростом.
 */
public final class Human {
	private final String name;

	private final int height;

	/**
	 * конструктор класса human.
	 *
	 * @param name имя человека
	 * @param height рост человека в сантиметрах
	 */
	public Human(final String name, final int height) {
		this.name = name;
		this.height = height;
	}
    
	/**
	 * возвращает строковое представление человека.
	 *
	 * @return строка в формате "имя, рост: высота"
	 */
	@Override
	public String toString() {
		final String result = name + ", рост: " + height;
		return result;
	}
}

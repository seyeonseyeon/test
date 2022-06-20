package vo;

public class AnimalVo {
	
	private int id;
	private String species;
	private int age;
	
	public AnimalVo() {
	}

	public AnimalVo(int id, String species, int age) {
		this.id = id;
		this.species = species;
		this.age = age;
	}

	public AnimalVo(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AnimalVo [id=" + id + ", species=" + species + ", age=" + age + "]";
	}

}
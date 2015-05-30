package builderDesign;

public class IndianMealBuilder implements MealBuilder {

	Meal newMeal;
	
	public IndianMealBuilder(){
		
		newMeal = new Meal();
	}
	
	@Override
	public void buildDrink() {

		newMeal.setDrink("Lassi");
	}

	@Override
	public void buildMainCourse() {
		
		newMeal.setMainCourse("Thali");
	}

	@Override
	public void buildSide() {
		
		newMeal.setSide("Kheer");
	}

	@Override
	public Meal getMeal() {
		
		return newMeal;
	}

	
}

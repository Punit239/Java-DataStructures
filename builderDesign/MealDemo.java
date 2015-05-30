package builderDesign;

public class MealDemo {

	public static void main(String[] args) {

		MealBuilder indianMealBuilder = new IndianMealBuilder();
		MealDirector mealDirector = new MealDirector(indianMealBuilder);
		
		mealDirector.constructMeal();
		Meal meal = mealDirector.getMeal();
		System.out.println(meal);
	}

}

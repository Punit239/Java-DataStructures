package builderDesign;

public class MealDirector {
	
	MealBuilder mealBuilder = null;
	
	public MealDirector(MealBuilder mealBuilder){
		
		this.mealBuilder = mealBuilder; 
	}
	
	public void constructMeal(){
		
		mealBuilder.buildDrink();
		mealBuilder.buildMainCourse();
		mealBuilder.buildSide();
	}

	public Meal getMeal(){
		
		return mealBuilder.getMeal();
	}
}

class FoodRatings {

    class FoodMeta {

      String food;
      String cuisine;
      Integer rating;

      FoodMeta(String food, String cuisine, Integer rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
      }
    }

    Map<String, PriorityQueue<FoodMeta>> cuisnieMap = new HashMap<>();
    Map<String, FoodMeta> foodMap = new HashMap<>();

    // 요리 이름, 유형, 초기 평점
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
      for (int i = 0; i < foods.length; i++) {
        FoodMeta foodMeta = new FoodMeta(foods[i], cuisines[i], ratings[i]);
        if (this.cuisnieMap.containsKey(cuisines[i])) {
          PriorityQueue<FoodMeta> foodQueue = cuisnieMap.get(cuisines[i]);
          foodQueue.add(foodMeta);
        } else {
          PriorityQueue<FoodMeta> foodQueue = new PriorityQueue<>((t1, t2) -> {
            int result = t2.rating - t1.rating;
            if (result == 0) {
              return t1.food.compareTo(t2.food);
            }
            return result;
          });
          foodQueue.add(foodMeta);
          cuisnieMap.put(cuisines[i], foodQueue);
        }

        foodMap.put(foods[i], foodMeta);
      }

    }

    // 요리 평점 변경
    public void changeRating(String food, int newRating) {
      FoodMeta prev = foodMap.get(food);
      FoodMeta current = new FoodMeta(food, prev.cuisine, newRating);
      foodMap.put(food, current);
      prev.food = "";
      cuisnieMap.get(prev.cuisine).add(current);
    }

    // 요리 유형중 가장 높은 평점을 받은 요리 이름을 반환, 평점이 동점일 경우 사전적으로 더 작은 이름의 항목을 반환
    public String highestRated(String cuisine) {
      PriorityQueue<FoodMeta> foodMetaPriorityQueue = cuisnieMap.get(cuisine);
      while (foodMetaPriorityQueue.peek().food.equals("")) {
        foodMetaPriorityQueue.remove();
      }
      return foodMetaPriorityQueue.peek().food;

    }
  }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
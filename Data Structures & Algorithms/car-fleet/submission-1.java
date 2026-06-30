class Solution {

      record Pair(int first, int second) {
  };
    
  public int carFleet(int target, int[] position, int[] speed) {
    List<Pair> cars = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      cars.add(new Pair(position[i], speed[i]));
    }

    Collections.sort(cars, (a, b) -> a.first() - b.first());

    ArrayDeque<Double> st = new ArrayDeque<>();

    for (int i = cars.size() - 1; i >= 0; i--) {
      double time = (double) (target - cars.get(i).first) / cars.get(i).second;

      if (st.isEmpty() || time > st.peek()) {
        st.push(time); // new fleet
      }
      // else joins fleet ahead
    }
    return st.size();

  }
}

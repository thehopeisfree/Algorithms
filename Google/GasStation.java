public class GasStation {
  public static void main(String[] args) {
    int[] gas = new int[] {4, 5, 3, 1, 4};
    int[] cost = new int[] {5, 4, 3, 4, 2};
    
    System.out.print(canCompleteCircuitBruteForce(gas, cost));
  }

  public static int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
    int length = gas.length;
    int[] remain = new int[length];
    for (int i = 0; i < length; ++i) {
      remain[i] = gas[i] - cost[i];
    }

    for (int i = 0; i < length; ++i) {
      // The gas left for moving from the station i to (i + 1)
      int sum = remain[i];
      // The index of the station (i + 1)
      int x = (i + 1) % length;

      while (x != i) {
        // If the left gas <= 0, tank cannot leave station i and go to (i + 1) station
        if (sum <= 0) break;
        // The gas left for x = (i + 1) station
        sum += remain[x];
        // Tank leaves x = (i + 1) station and goes to (i + 2) station
        x = (x + 1) % length;
      }

      // If x = i again, check whether the left gas is enough.
      if (x == i && sum >= 0) return i;
    }

    return -1;    
  }
}
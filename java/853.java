// 2ND VERSION: array of time for each position
// time: max(O(n), O(target))
// space: O(1) = arr.length = target

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeArr = new double[target];  // create a time array for all possible positions <= target
        for (int i = 0; i < position.length; i++) {
            timeArr[position[i]] = (double)(target - position[i]) / speed[i];
        }
        int fleets = 0;
        double longestTime = 0;
        for (int i = timeArr.length - 1; i >= 0; i--) {
            if (timeArr[i] > longestTime) {
                fleets++;
                longestTime = timeArr[i];
            }
        }
        return fleets;
    }
}


// 1ST VERSION: Inner Class +  Arrays.sort()
// time: O(nlog(n))
// space: O(n)
// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int numOfCars = position.length;
//         if ( numOfCars == 1 || numOfCars == 0) return numOfCars;

//         int fleets = 0;
//         double longestTime = 0;
//         Car[] cars = new Car[numOfCars];

//         for (int i = 0; i < numOfCars; i++) {
//             cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
//         }
//         Arrays.sort(cars, (c1, c2) -> c2.pos - c1.pos);
        
//         for (Car car : cars) {
//             if (car.time > longestTime) {
//                 longestTime = car.time;
//                 fleets++;
//             }
//         }
//         return fleets;
//     }

//     class Car {
//         int pos;
//         double time;

//         Car(int pos, double time) {
//             this.pos = pos;
//             this.time = time;
//         }

//     }
// }

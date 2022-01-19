package keys_and_rooms;

import java.util.LinkedList;
import java.util.List;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(new LinkedList<>());
        rooms.add(new LinkedList<>());
        rooms.add(new LinkedList<>());
        rooms.add(new LinkedList<>());
        rooms.get(0).add(1);
        rooms.get(0).add(2);
        rooms.get(1).add(2);
        rooms.get(2).add(3);
        rooms.get(3).add(3);
        BasicFunctions.print(solution.canVisitAllRooms(rooms));
    }
}

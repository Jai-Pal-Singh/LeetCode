package the_skyline_problem;

/**
 * Represents either start or end of building
 */
public class BuildingPoint implements Comparable<BuildingPoint> {
    int x;
    boolean isStart;
    int height;

    @Override
    public int compareTo(BuildingPoint o) {
        // first compare by x.
        // If they are same then use this logic
        // if two starts are compared then higher height building should be picked first
        // if two ends are compared then lower height building should be picked first
        // if one start and end is compared then start should appear before end
        if (this.x != o.x) {
            return this.x - o.x;
        } else {
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }
}

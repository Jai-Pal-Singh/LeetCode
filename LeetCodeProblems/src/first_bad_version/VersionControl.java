package first_bad_version;

public class VersionControl {
    boolean[] arr;

    public VersionControl() {
    }

    public VersionControl(boolean[] arr) {
        this.arr = arr;
    }

    public boolean[] getArr() {
        return this.arr;
    }

    public void setArr(boolean[] arr) {
        this.arr = arr;
    }

    public VersionControl arr(boolean[] arr) {
        setArr(arr);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " arr='" + getArr() + "'" +
            "}";
    }

    public boolean isBadVersion(int version) {
        return arr[version - 1];
    }
}

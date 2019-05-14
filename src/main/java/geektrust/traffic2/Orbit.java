package geektrust.traffic2;

/**
 * Created by kraghunathan on 5/9/18.
 */
public class Orbit {

    private String name,end1,end2;
    private float megaMiles;
    private int craters;


    public Orbit(Builder b){
        this.name = b.name;
        this.end1 = b.end1;
        this.end2 = b.end2;
        this.megaMiles = b.megaMiles;
        this.craters = b.craters;
    }

    public int getCraters() {
        return craters;
    }

    public String getEnd1() {
        return end1;
    }

    public String getEnd2() {
        return end2;
    }

    public float getMegaMiles() {
        return megaMiles;
    }

    public String getName() {
        return name;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public static class Builder {
        private String name;
        public String end1;
        public String end2;
        public float megaMiles;
        public int craters;

        public Builder(String name){
            this.name = name;
        }

        public Builder craters(int craters) {
            this.craters = craters;
            return this;
        }

        public Builder end1(String end1) {
            this.end1 = end1;
            return this;
        }

        public Builder end2(String end2) {
            this.end2 = end2;
            return this;
        }

        public Builder megaMiles(float megaMiles) {
            this.megaMiles = megaMiles;
            return this;
        }

        public Orbit build() {
            return new Orbit(this);
        }
    }

}

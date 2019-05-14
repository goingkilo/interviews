package geektrust.traffic2;

public enum WeatherType implements Weather {

    SUNNY () {
        @Override
        public float getImpactOnCraters() {
            return -10f;
        }

        @Override
        public String getType() {
            return "SUNNY";
        }
    },
    RAINY() {
        @Override
        public float getImpactOnCraters() {
            return 20f;
        }

        @Override
        public String getType() {
            return "RAINY";
        }

    },
    WINDY() {
        @Override
        public float getImpactOnCraters() {
            return 0;
        }

        @Override
        public String getType() {
            return "WINDY";
        }

    };

}

public class Functions {
    public static void main(String[] args) {

        int gryffindor = 500;
        int ravenclaw = 100;
        int pointsMargin = gryffindor - ravenclaw;
        int ranking = ranking(pointsMargin);
        System.out.println(ranking);

    }

    public static int ranking(int pointsMargin) {
        if (pointsMargin > 300) {
            return 1;
        } else if (pointsMargin > 0) {
            return 2;
        } else if (pointsMargin > -100) {
            return 3;
        } else {
            return 4;
        }
    }

}

import org.apache.log4j.Logger;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class AgeNegativeException extends Exception {
    public AgeNegativeException(String message) {
        super(message);
    }
}

class Operation {
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Operation operation = new Operation();
        int result = operation.multiply(9, 5);
        log.info("ნამრავლი: " + result);
        System.out.println("ნამრავლი: " + result);

        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[15];
        System.out.println("შეიყვანეთ 15 მთელი რიცხვი:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("შეიყვანეთ რიცხვი " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("შეყვანილი რიცხვები:");
        for (int number : numbers) {
            System.out.println(number);
        }

        int[][] matrix = new int[6][6];
        Random random = new Random();
        System.out.println("6x6 მატრიცა შემთხვევითი რიცხვებით (-150 - 150):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(301) - 150;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }


        int lowerDiagonalSum = lowerDiagonalSum(matrix);
        System.out.println("დიაგონალის ქვედა ელემენტების ჯამი: " + lowerDiagonalSum);

        try {
            System.out.print("შეიყვანეთ თქვენი ასაკი: ");
            int age = scanner.nextInt();

            if (age < 0) {
                throw new AgeNegativeException("Age must be positive");
            }

            System.out.println("თქვენი ასაკია: " + age);
        } catch (AgeNegativeException e) {
            System.out.println(e.getMessage());
        }

        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("გიორგი", 16);
        ageMap.put("ვაჟა", 20);
        ageMap.put("მერაბი", 30);
        ageMap.put("ნუცა", 21);
        ageMap.put("ნიკა", 25);

        Integer vazhasAge = ageMap.get("ვაჟა");
        System.out.println("ვაჟას ასაკი: " + vazhasAge);

        scanner.close();
    }


    public static int lowerDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}

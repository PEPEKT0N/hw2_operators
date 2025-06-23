//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Уровень 1 – Стажёр");

        System.out.println("""
                Задание 1.
                Пользователь вводит первый член арифметической прогрессии,
                кол-во элементов в прогрессии, а также шаг между двумя соседними
                членами прогрессии. Найти сумму всех членов этой прогрессии от
                первого до последнего, введенного пользователем. Циклы использовать нельзя.
                """);

        System.out.print("Введите первый член арифметической прогрессии: ");
        int firstItem = Integer.parseInt(sc.nextLine());
        System.out.print("Введите количество элементов: ");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.print("Введите шаг: ");
        int step = Integer.parseInt(sc.nextLine());
        // на случай если пользователь введет 0 или отрицальное число
        amount = Math.max(1, Math.abs(amount));

        int lastItem = firstItem + (amount- 1) * step;
        int sum = amount * (firstItem + lastItem) / 2;
        System.out.printf("Сумма арифметической прогрессии: %d", sum);

        System.out.println("""
                \nЗадание 2.\s
                Пользователь вводит две стороны произвольного треугольника
                и значение угла между ними. Необходимо найти третью сторону
                по теореме косинусов (см. в интернете). Проверить для
                прямоугольных и непрямоугольных треугольников, использовать
                проверку через онлайн-калькулятор.
                """);
        System.out.print("Введите длину стороны А: ");
        double sideA = Double.parseDouble(sc.nextLine());
        System.out.print("Введите длину стороны B: ");
        double sideB = Double.parseDouble(sc.nextLine());
        System.out.print("Введите значение угла между ними (в градусах): ");
        int angle = Integer.parseInt(sc.nextLine());

        sideA = Math.max(1, Math.abs(sideA));
        sideB = Math.max(1, Math.abs(sideB));
        if (angle <= 0 || angle >= 180) {
            System.out.println("Угол должен быть от 1 до 179 градусов.");
            return;
        }
        double angleRad = Math.toRadians(angle);

        double sideC = Math.sqrt((sideA * sideA) + (sideB * sideB) - (2 * sideA * sideB * Math.cos(angleRad)));
        System.out.printf("Третья сторона: %.2f", sideC);

        System.out.println("""
                \nЗадание 3.\s
                Пользователь вводит шестизначное число. Оно считается счастливым
                если суммы первых трех цифр и последних трех равны.
                Вывести информацию о том, является ли введенное число счастливым.
                """);

        System.out.print("Введите шестизначное число: ");
        int userNum = Integer.parseInt(sc.nextLine());
        boolean isLucky = false;
        if (userNum < 100_000 || userNum > 999_999) {
            System.out.println("Число должно быть в диапазоне [100,000; 999,999]");
            return;
        }

        int sum1 = 0, sum2 = 0;
        sum1 += userNum / 10_0000 % 10;
        sum1 += userNum / 10_000 % 10;
        sum1 += userNum / 1_000 % 10;

        sum2 += userNum / 100 % 10;
        sum2 += userNum / 10 % 10;
        sum2 += userNum % 10;

        isLucky = sum1 == sum2;
        if (isLucky) {
            System.out.printf("%d - счастливое число", userNum);
        }
        else {
            System.out.printf("%d - несчастливое число", userNum);
        }


        System.out.println("\nУровень 2 – Джун");

        System.out.println("""
                \nЗадание 1.
                Пользователь вводит стоимость шоколадки (в рублях и копейках)
                а также кол-во денег у него в кармане (в рублях и копейках).
                Программа должна посчитать, сколько шоколадок может купить
                пользователь, и какая у него останется сдача, если он купит
                максимальное кол-во шоколадок. Все вычисления делать в
                целочисленных типах. При вводе значений копеек больше 100
                делать приведение к канонической форме либо выводить ошибку.
                """);

        System.out.print("Введите цену шоколадки в рублях и копейках: ");
        String price = sc.nextLine();
        System.out.print("Введите свой баланс в рублях и копейках: ");
        String pocketMoney = sc.nextLine();

        int rublesPrice = 0, kopecksPrice = 0;
        int rublesPocketMoney = 0, kopecksPocketMoney = 0;
        if (price.contains(".")) {
            String[] parts = price.split("\\.");
            rublesPrice = Integer.parseInt(parts[0]);
            kopecksPrice = Integer.parseInt(parts[1]);
        }
        else {
            rublesPrice = Integer.parseInt(price);
        }

        if (pocketMoney.contains(".")) {
            String[] parts = pocketMoney.split("\\.");
            rublesPocketMoney = Integer.parseInt(parts[0]);
            kopecksPocketMoney = Integer.parseInt(parts[1]);
        }
        else {
            rublesPocketMoney = Integer.parseInt(pocketMoney);
        }

        int chocolateAmount = (kopecksPocketMoney + rublesPocketMoney * 100) / (kopecksPrice + rublesPrice * 100);

        rublesPrice += kopecksPrice / 100;
        kopecksPrice %= 100;
        rublesPocketMoney += kopecksPocketMoney / 100;
        kopecksPocketMoney %= 100;

        System.out.printf("За %dр, %dк можно купить %d шоколадок за %dр, %dк", rublesPocketMoney, kopecksPocketMoney,
                chocolateAmount, rublesPrice, kopecksPrice);

        System.out.println("""
                \nЗадание 2.\s
                Пользователь вводит 3 стороны треугольника a, b,c - сказать,
                существует ли такой треугольник (условие существования по сторонам)
                """);

        System.out.println("Введите 3 стороны треугольника: ");
        double a = Double.parseDouble(sc.nextLine());
        double b = Double.parseDouble(sc.nextLine());
        double c = Double.parseDouble(sc.nextLine());

        if (a <=0 || b <= 0 || c <= 0) {
            System.out.println("Длина сторон не может быть отрицательной");
            return;
        }

        if (a + b > c && a + c > b && b + c > a) {
            System.out.printf("Треугольник со сторонами %.2f - %.2f - %.2f существует", a, b, c);
        }
        else {
            System.out.printf("Треугольника со сторонами %.2f - %.2f - %.2f не существует", a, b, c);
        }

        System.out.println("Уровень 3 – Джун плюс плюс");

        System.out.println("""
                \nЗадание 1.
                Пользователь вводит число int, необходимо посчитать количество битов,
                равных единице в этом числе не используя циклы.
                """);

        System.out.print("Введите число: ");
        int num = Integer.parseInt(sc.nextLine());

        int bitCount = Integer.bitCount(num);
        System.out.printf("В числе '%d' - %d битов", num, bitCount);

        System.out.println("""
                \nЗадание 2.
                Пользователь вводит целое неотрицательное число.
                Необходимо возвести число 2 в степень, равную этому числу.
                Циклы использовать нельзя. Переполнения не обрабатывать.
                """);

        System.out.print("Введите целое неотрицательное число: ");
        userNum = Integer.parseInt(sc.nextLine());

        int result = (int)Math.pow(2, userNum);
        System.out.printf("2^%d = %d\n", userNum, result);

        System.out.println("""
                \nЗадание 3.
                Пользователь вводит 2 числа – a, b. Необходимо сказать,
                какой бит стоит на позиции b в числе a. Циклы использовать нельзя.
                Позиция битов отсчитывается по разрядам числа – справа-налево
                начиная с нуля (нулевой разряд).
                """);

        System.out.println("Введите два целых числа: ");
        int numA = Integer.parseInt(sc.nextLine());
        int numB = Integer.parseInt(sc.nextLine());

        int bit = (numA >> numB) & 1;
        System.out.printf("в числе %d на позиции %d стоит бит - %d", numA, numB, bit);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
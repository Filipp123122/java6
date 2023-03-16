import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public final static Scanner sc = new Scanner(System.in);       

    public static void sortNotebooks(int ramUser, int storUser, double digUser,  Set<Notebooks> unicNotebooks)
{

    System.out.println("Введите желаемую характеристику для отбора 1-память, 2-накопитель, 3-диагональ ");
    int sort = sc.nextInt();

    switch (sort) {
        case 1:
            System.out.println("объем оперативной памяти: ");
            ramUser = sc.nextInt();
            break;
        case 2:
            System.out.println("объем накопителя: ");
            storUser = sc.nextInt();
            break;
        case 3:
            System.out.println("диагональ");
            digUser = sc.nextDouble();
            break;
        default:
        break;
    }
    for(Notebooks lap: unicNotebooks) {
        if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser)  && lap.getDiagonal() >= digUser) {
            System.out.println(lap.toString());
        }
    }
}
    
    public static void main(String[] args) throws Exception {
        
        Notebooks Notebooks1 = new Notebooks("Lenovo IdealPad 5", 8, 256, "Windows 11", "синий", 15.6);
        Notebooks Notebooks2 = new Notebooks("Honor MagicBook 16", 16, 512, "без ОС", "серый", 16.1);
        Notebooks Notebooks3 = new Notebooks("Apple MacBook Air 13", 8, 256, "MacOs", "золотистый", 13.3);
        Notebooks Notebooks4 = new Notebooks("HP 250 G7", 4, 1024, "без ОС", "черный", 15.6);
        Notebooks Notebooks5 = new Notebooks("Xiomi RedmiBook 15", 8, 256, "Windows 11", "серый", 15.6);
        Notebooks Notebooks6 = Notebooks1;

        int ramUser=0;
        int storUser=0;
        double digUser=0;

        Set<Notebooks> unicNotebooks = new HashSet<Notebooks>();
        unicNotebooks.add(Notebooks1);
        unicNotebooks.add(Notebooks2);
        unicNotebooks.add(Notebooks3);
        unicNotebooks.add(Notebooks4);
        unicNotebooks.add(Notebooks5);
        unicNotebooks.add(Notebooks6);
        System.out.println(Notebooks1.equals(Notebooks6));
        System.out.printf("Всего уникалных ноутбуков: %d \n", unicNotebooks.size());
  
        System.out.println("Добро пожаловать в каталог ноутбуков!  \n Введите желаемое действие  1 - Печать всех товаров 2 - Поиск по каталогу 0 - Выход ");
        int pointUser = sc.nextInt();
        
        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "объем оперативной памяти");
        mapCrit.put(2, "объем накопителя");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "цвет");
        mapCrit.put(5, "диагональ");

        switch (pointUser) {
            case 1:
            for(Notebooks lap: unicNotebooks) 
            {
                if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser)  && lap.getDiagonal() >= digUser) {
                    System.out.println(lap.toString());
                }
            }
                break;
            case 2:
                sortNotebooks(ramUser, storUser, digUser, unicNotebooks);
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }



    }

}
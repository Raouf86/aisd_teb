package myPackage.exam.colections;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Task2 {
    //przynajmniej 10 elementów, pokrywająca większość przypadków i umożliwiająca po wyświetlonych danych ocenić działanie programu
    private static List<Car> carList; //todo ma być posortowana po roczniku, auta nowesze jako pierwsze a starsze później, i stale utzymywać porządek

    public static List<Car> getCarList(){ //TIP singleton
        //zwraca aktualny stan listy aut
        //todo
        if(carList == null) {
            carList = new ArrayList<>();
        }

        carList.sort((o1, o2) -> {
            if(o1.getYearOfProduction() > o2.getYearOfProduction()){
                return 1;
            }
            else if (o1.getValue() < o2.getValue()){
                return -1;
            }

            return 0;
        });

        return carList;
    }

    public static void printSortedCars() {
        //Wypisz na konsolę listę aut (listę należy zrobić samodzielnie, przygotowanie DOBRYCH danych testowych jest cześcią zadania)
        //lista ma być posotrowana po atrybutach w następującej kolejności:
        //- auta ekskluzywne mają znajdować się na początku listy
        //- auta najnowsze, o najwyższym roku produkcji, mają być wyświetlane przed autami starszymi
        //- auta o wyższym poziomie wyposażenia mają być przed autami o niższym poziomie wyposażenia
        //- auta droższe mają być wyświetlane przed tańszymi

        getCarList().add(new Car(false, 2001, 2, new UUID(1,2), 30500));
        getCarList().add(new Car(true, 1999, 1, new UUID(3,4), 20100));
        getCarList().add(new Car(true, 2000, 2, new UUID(5,6), 15000));
        getCarList().add(new Car(false, 2020, 3, new UUID(7,8), 150000));
        getCarList().add(new Car(true, 2015, 3, new UUID(9,10), 958000));
        getCarList().add(new Car(false, 1994, 1, new UUID(11,12), 70555));
        getCarList().add(new Car(false, 2021, 1, new UUID(13,14), 36000));
        getCarList().add(new Car(true, 2015, 3, new UUID(15,16), 5000));
        getCarList().add(new Car(false, 2002, 2, new UUID(17,18), 10200));
        getCarList().add(new Car(false, 2000, 1, new UUID(19,20), 36000));

        Comparator<Car> carComparator = Comparator
                .comparing(Car::isExclusive)
                .reversed()
                .thenComparing(reverseOrder(comparing(Car::getYearOfProduction)))
                .thenComparing(reverseOrder(comparing(Car::getLevelOfEquipment)))
                .thenComparing(reverseOrder(comparing(Car::getValue)));

        List<Car> sortedCar = getCarList().stream().sorted(carComparator).collect(Collectors.toList());

        for (Car car: sortedCar) {
            System.out.println(car.toString());
        }
    }

    public static void printCarsToValueAndLevelOfEquipment(double maxValue, int levelOfEquipment){
        //Kontekst biznesowy: klient wchodzi na stronę salonu samochodów używanych i chce zobaczyć auta do pewnej kwoty "maxValue"
        // oraz mające konkretny poziom wyposażenia np: poziom 2 = auto ma klimatyzację, a poziom 1 auto klimatyzacji nie ma itp
        //ZADANIE: wyfiltruj a następnie wypisz auta od najtańszego do najdroższego z listy aut

        getCarList().add(new Car(false, 2001, 2, new UUID(1,2), 30500));
        getCarList().add(new Car(true, 1999, 1, new UUID(3,4), 20100));
        getCarList().add(new Car(true, 2000, 2, new UUID(5,6), 15000));
        getCarList().add(new Car(false, 2020, 3, new UUID(7,8), 150000));
        getCarList().add(new Car(true, 2015, 3, new UUID(9,10), 958000));
        getCarList().add(new Car(false, 1994, 1, new UUID(11,12), 70555));
        getCarList().add(new Car(false, 2021, 1, new UUID(13,14), 36000));
        getCarList().add(new Car(true, 2015, 3, new UUID(15,16), 5000));
        getCarList().add(new Car(false, 2002, 2, new UUID(17,18), 10200));
        getCarList().add(new Car(false, 2000, 1, new UUID(19,20), 36000));

        List<Car> filteredList =  getCarList()
                .stream()
                .filter(x -> x.getLevelOfEquipment() == levelOfEquipment && x.getValue() <= maxValue)
                .sorted((o1, o2) -> {
                    if(o1.getValue() < o2.getValue()){
                        return -1;
                    }
                    else if (o1.getValue() > o2.getValue()){
                        return 1;
                    }

                    return 0;
                }).collect(Collectors.toList());

        for (Car car: filteredList) {
            System.out.println(car.toString());
        }
        //todo tutaj wykonaj zadanie
    }

    public static void addCarsToList() {
        getCarList().add(new Car(false, 2001, 2, new UUID(1,2), 30500));
        getCarList().add(new Car(true, 1999, 1, new UUID(3,4), 20100));
        getCarList().add(new Car(true, 2000, 2, new UUID(5,6), 15000));
        getCarList().add(new Car(false, 2020, 3, new UUID(7,8), 150000));
        getCarList().add(new Car(true, 2015, 3, new UUID(9,10), 958000));
        getCarList().add(new Car(false, 1994, 1, new UUID(11,12), 70555));
        getCarList().add(new Car(false, 2021, 1, new UUID(13,14), 36000));
    }

    public static void removeCarFromList() {
        getCarList().remove(2);
        getCarList().remove(4);
    }

    public static void printCarListAfterSomeModification(){
        addCarsToList();

        for (Car car: getCarList()) {
            System.out.println(car.toString());
        }

        removeCarFromList();
    }

}
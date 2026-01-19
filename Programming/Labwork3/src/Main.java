import Classes.*;
import Enums.BowlType;
import Interfaces.*;

public class Main {
    public static void main(String[] args) {
        Location bridge = new Bridge();
        PoliceVan van = new PoliceVan(bridge);
        Location shipHold = new Shiphold();

        Shorty neznayka = new Shorty("Незнайка", "Мужской");
        Shorty ponchik = new Shorty("Пончик", "Мужской");
        Shorty kozlik = new Shorty("Козлик", "Мужской");
        Shorty klukva = new Shorty("Клюква", "Женский");
        Shorty mizinchik = new Shorty("Мизинчик", "Мужской");
        Shorty chizik = new Shorty("Чижик", "Мужской");
        Shorty fatShorty = new Shorty("Толстенький коротышка", "Мужской");
        Shorty zakadr = new Shorty("Аноним", "Неизвестно");
        fatShorty.setClothing("Без рубашки, босиком, шляпа и шарф");

        Policeman patrol = new Policeman("Полицейский патруль", "Мужской");
    /*
        neznayka.setCurrentLocation(bridge);
        ponchik.setCurrentLocation(bridge);
        fatShorty.setCurrentLocation(bridge);
        kozlik.setCurrentLocation(bridge);
        klukva.setCurrentLocation(bridge);
        mizinchik.setCurrentLocation(bridge);
        chizik.setCurrentLocation(bridge);

     */

        //1 сцена

        Bowl porridge = new Bowl(bridge, "каша", BowlType.DEEP);
        zakadr.bring(porridge.getName(), ponchik);

        ponchik.eat(porridge.getName() + " " + porridge.getDescription());

        ponchik.say("То, что рассказал о Незнайке Пончик, была правда. Мы на Дурацком острове.");

        //2 сцена

        patrol.arrest(klukva);
        patrol.arrest(mizinchik);
        patrol.arrest(chizik);
        patrol.arrest(neznayka);
        patrol.arrest(kozlik);
        patrol.arrest(fatShorty);

        //3 сцена

        klukva.setCurrentLocation(van);
        mizinchik.setCurrentLocation(van);
        chizik.setCurrentLocation(van);
        neznayka.setCurrentLocation(van);
        fatShorty.setCurrentLocation(van);
        kozlik.setCurrentLocation(van);

        van.drive(shipHold);

        //4 сцена

        klukva.setCurrentLocation(shipHold);
        mizinchik.setCurrentLocation(shipHold);
        chizik.setCurrentLocation(shipHold);
        neznayka.setCurrentLocation(shipHold);
        fatShorty.setCurrentLocation(shipHold);
        kozlik.setCurrentLocation(shipHold);

        klukva.cry();
        mizinchik.cry();
        chizik.cry();
        kozlik.cry();
        neznayka.cry();

        Barrel barrel = new Barrel(shipHold, "пустая бочка");

        fatShorty.climb(barrel.getName());
        System.out.println(fatShorty.getName() + " был одет в " +fatShorty.getClothing());
        fatShorty.soothe(neznayka);
        fatShorty.soothe(kozlik);
        fatShorty.soothe(klukva);
        fatShorty.soothe(mizinchik);
        fatShorty.soothe(chizik);

    }
}
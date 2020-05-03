/*
Имеется набор вещей, которые необходимо поместить в рюкзак.
Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
*/

package com.task6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {

        FillBackpack fb = new FillBackpack();
        fb.AddItems();
        fb.rez();
    }

    static class FillBackpack{
        private ArrayList<Item> items;
        public void AddItems()
        {
            items = new ArrayList<Item>();

            items.add(new Item("Веревка", 2, 5000));
            items.add(new Item("Палатка", 5, 25000));
            items.add(new Item("Топор", 4, 2000));
            items.add(new Item("Сапоги", 3, 4000));
            items.add(new Item("Телефон", 2, 60000));
            items.add(new Item("Котелок", 1, 700));
            items.add(new Item("Пиво", 1, 150));
        }
        private void rez()
        {
            Backpack bp = new Backpack(5); // задаю вес рюкзака

            bp.MakeAllSets(items);

            ArrayList<Item> solve = bp.GetBestSet();

            if(solve == null) {
                System.out.println("Упс!");
            }
            else{
                ShowItems(solve);
            }
        }

        private void ShowItems(ArrayList<Item> _items) {
            for(Item i : _items)
            {
                System.out.println("" + i.name +" "+ i.weigth + " " + i.price);
            }
        }
    }

    static class Item{
        public String name;
        public double weigth;
        public double price;
        public Item (String _name, double _weigth, double _price)
        {
            name = _name;
            weigth = _weigth;
            price = _price;
        }

    }

    static class Backpack {
        private ArrayList<Item> bestItems = null;

        private double maxWeigth;

        private double bestPrice;

        public Backpack(double _maxWeigth) {
            maxWeigth = _maxWeigth;
        }

        //общий вес набора предметов
        private double CalcWeigth(ArrayList<Item> items) {
            double sumW = 0;

            for (Item i : items) {
                sumW += i.weigth;
            }

            return sumW;
        }

        //общая стоимость набора предметов
        private double CalcPrice(ArrayList<Item> items) {
            double sumPrice = 0;

            for (Item i : items) {
                sumPrice += i.price;
            }

            return sumPrice;
        }

        //проверяем, лучший ли это набор
        private void CheckSet(ArrayList<Item> items) {
            if (bestItems == null) {
                if (CalcWeigth(items) <= maxWeigth) {
                    bestItems = items;
                    bestPrice = CalcPrice(items);
                }
            } else {
                if (CalcWeigth(items) <= maxWeigth && CalcPrice(items) > bestPrice) {
                    bestItems = items;
                    bestPrice = CalcPrice(items);
                }
            }
        }

        //создание всех наборов перестановок значений
        public void MakeAllSets(ArrayList<Item> items) {
            if (items.size() > 0)
                CheckSet(items);

            for (int i = 0; i < items.size(); i++) {
                ArrayList<Item> newSet = new ArrayList<Item>(items);

                newSet.remove(i);

                MakeAllSets(newSet);
            }

        }

        //возвращает набор вещей
        public ArrayList<Item> GetBestSet() {
            return bestItems;
        }
    }
}


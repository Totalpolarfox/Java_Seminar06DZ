// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и
// выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию: 
//     1 - ОЗУ
//     2 - Объем ЖД
//     3 - Операционная система
//     4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
// можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.*;

public class HardwareStore {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Apple", 16, 512, "macOS", "white"));
        notebooks.add(new Notebook("Maibenben", 8, 256, "Linux", "silver"));
        notebooks.add(new Notebook("ASUS", 16, 1000, "Windows", "white"));
        notebooks.add(new Notebook("ASUS", 8, 256, "Windows", "black"));
        notebooks.add(new Notebook("Apple", 16, 1000, "macOS", "silver"));
        notebooks.add(new Notebook("Lenovo", 16, 512, "Linux", "black"));
        notebooks.add(new Notebook("Huawei", 8, 256, "Windows", "black"));
        notebooks.add(new Notebook("Maibenben", 8, 512, "Linux", "silver"));
        notebooks.add(new Notebook("ASUS", 16, 512, "Windows", "black"));
    } 

    private static Map<Integer, Object> requestFilteringCriteria() {
        Map<Integer, Object> criteries = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - производитель");
        System.out.println("2 - объём оперативной памяти");
        System.out.println("3 - объём HDD");
        System.out.println("4 - операционная система");
        System.out.println("5 - цвет");

    }
}

class Notebook {
    private String vendor;
    private int ram;
    private int volumeHDD;
    private String os;
    private String color;


    public Notebook(String vendor, int ram, int volumeHDD, String os, String color) {
        this.vendor = vendor;
        this.ram = ram;
        this.volumeHDD = volumeHDD;
        this.os = os;
        this.color = color;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getVolumeHDD() {
        return volumeHDD;
    }
    public void setVolumeHDD(int volumeHDD) {
        this.volumeHDD = volumeHDD;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notebook [vendor=" + vendor + ", ram=" + ram + ", volumeHDD=" + volumeHDD + ", os=" + os + ", color="
                + color + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (vendor == null) {
            if (other.vendor != null)
                return false;
        } else if (!vendor.equals(other.vendor))
            return false;
        if (ram != other.ram)
            return false;
        if (volumeHDD != other.volumeHDD)
            return false;
        if (os == null) {
            if (other.os != null)
                return false;
        } else if (!os.equals(other.os))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
        result = prime * result + ram;
        result = prime * result + volumeHDD;
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }
}

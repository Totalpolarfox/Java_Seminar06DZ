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

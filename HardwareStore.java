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
        notebooks.add(new Notebook("Apple MacBook Pro", 16, 512, "macOS", "white"));
        notebooks.add(new Notebook("Maibenben M545", 8, 256, "Linux", "silver"));
        notebooks.add(new Notebook("ASUS ExpertBook 15", 16, 1000, "Windows", "white"));
        notebooks.add(new Notebook("ASUS Vivobook Go", 8, 256, "Windows", "black"));
        notebooks.add(new Notebook("Apple MacBook Air", 16, 1000, "macOS", "silver"));
        notebooks.add(new Notebook("Lenovo ThinkPad X1", 16, 512, "Linux", "black"));
        notebooks.add(new Notebook("Huawei MateBook D", 8, 256, "Windows", "black"));
        notebooks.add(new Notebook("Maibenben X677", 8, 512, "Linux", "silver"));
        notebooks.add(new Notebook("ASUS TUF Gaming", 16, 512, "Windows", "black"));

        Map<Integer, Object> filteringCriteria = requestFilteringCriteria();
        Set<Notebook> result = filteringNotebooks(notebooks, filteringCriteria);

        System.out.println("Найденные результаты:");
        for (Notebook notebook : result) {
            System.out.println(notebook.getVendor());
        }
    } 

    private static Map<Integer, Object> requestFilteringCriteria() {
        Map<Integer, Object> criteries = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём оперативной памяти");
        System.out.println("2 - объём HDD");
        System.out.println("3 - операционная система");
        System.out.println("4 - цвет");

        int selectionCriteria = scanner.nextInt();
        switch (selectionCriteria) {
            case 1:
                System.out.println("Введите минимальное значение объёма оперативной памяти:");
                int ram = scanner.nextInt();
                criteries.put(1, ram);
                break;
            case 2:
                System.out.println("Введите минимальное значение объёма HDD:");
                int volumeHDD = scanner.nextInt();
                criteries.put(2, volumeHDD);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                criteries.put(3, os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                criteries.put(4, color);
                break;   
            default:
                System.out.println("Неверный выбор критерия");
                break;
        }
        return criteries;
    }

    private static Set<Notebook> filteringNotebooks(Set<Notebook> notebooks, Map<Integer, Object> criteries) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean passesCondition = true;

            for (Map.Entry<Integer, Object> entry : criteries.entrySet()) {
                int criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case 1:
                        if (notebook.getRam() < (int) value) {
                            passesCondition = false;
                        }
                        break;
                    case 2:
                        if (notebook.getVolumeHDD() < (int) value) {
                            passesCondition = false;
                        }
                        break;
                    case 3:
                        if (notebook.getOs().equals(value)) {
                            passesCondition = false;
                        }
                        break;            
                    case 4:
                        if (notebook.getColor().equals(value)) {
                            passesCondition = false;
                        }
                        break;   
                    default:
                        passesCondition = false;
                        break;
                }
                
            }
            if (passesCondition) {
                result.add(notebook);
            }
        }
        return result;

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

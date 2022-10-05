package Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainComparator {
    public static void main(String[] args) {
        LocalDate dataNascimentoThiago = LocalDate.of(2000,12,11);
        LocalDate dataNascimentoDerik = LocalDate.of(1991,06,30);
        LocalDate dataNascimentoAna = LocalDate.of(1990,07,27);
        LocalDate dataNascimentoLucas = LocalDate.of(2002,1,30);
        LocalDate dataNascimentoEllen = LocalDate.of(1996,11,25);
        LocalDate dataNascimentoAry = LocalDate.of(1991,11,20);

        List<LocalDate> listaDatasNascimento = new ArrayList<>();
        listaDatasNascimento.add(dataNascimentoThiago);
        listaDatasNascimento.add(dataNascimentoDerik);
        listaDatasNascimento.add(dataNascimentoAna);
        listaDatasNascimento.add(dataNascimentoLucas);
        listaDatasNascimento.add(dataNascimentoEllen);
        listaDatasNascimento.add(dataNascimentoAry);

        //convencional
        ordenarBubbleSort(listaDatasNascimento);

        for (LocalDate d: listaDatasNascimento) {
            System.out.println(d);
        }

        System.out.println("============");

        // classe anônima
        Comparator<LocalDate> comparator = new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate a, LocalDate b) {
                if(a.isBefore(b)){
                    return -1;
                } else if (a.isAfter(b)) {
                    return 1;
                }else {
                    return 0;
                }
            }
        };
        listarOrdenado(listaDatasNascimento,comparator);

        // lambda
        listarOrdenado(listaDatasNascimento, (a,b)-> {
            if(a.isBefore(b)){
                return -1;
            } else if (a.isAfter(b)) {
                return 1;
            }else {
                return 0;
            }
        } );


    }

    private static void listarOrdenado(List<LocalDate> lista, Comparator<LocalDate> comparator){
        lista.sort(comparator);
        for (LocalDate d: lista) {
            System.out.println(d);
        }
    }

    public static void ordenarBubbleSort(List<LocalDate> datas) {
        final int n = datas.size() - 1;
        LocalDate aux;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (datas.get(j).isAfter(datas.get(j + 1))){
                    aux = datas.get(j);
                    datas.set(j, datas.get(j + 1));
                    datas.set(j + 1, aux);
                }
            }
        }
    }
}

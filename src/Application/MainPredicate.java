package Application;

import java.time.LocalDate;
import java.util.function.Predicate;

public class MainPredicate {
    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.of(2000,12,11);
        LocalDate dataInicioGenZ = LocalDate.of(1995,1,1);
        LocalDate dataFimGenZ = LocalDate.of(2010,12,31);

        //convencional
        if(dataNascimento.isAfter(dataInicioGenZ) || dataNascimento.isBefore(dataFimGenZ)){
            System.out.println("Você é geração Z");
        }

        //classe anônima
        Predicate<LocalDate> ehGeracaoZcomClasseAnonima = new Predicate<LocalDate>() {
            @Override
            public boolean test(LocalDate aniversario) {
                return aniversario.isAfter(dataInicioGenZ) || aniversario.isBefore(dataFimGenZ);
            }
        };

        System.out.println(ehGeracaoZcomClasseAnonima.test(dataNascimento));
        System.out.println(verificarGeracaoZ(dataNascimento,ehGeracaoZcomClasseAnonima));

        //lambda
        Predicate<LocalDate> ehGeracaoZComLambida = (aniversario) -> {
            return aniversario.isAfter(dataInicioGenZ) || aniversario.isBefore(dataFimGenZ);
        };

        System.out.println(ehGeracaoZComLambida.test(dataNascimento));
        System.out.println(verificarGeracaoZ(dataNascimento,(data) -> {
            return  data.isAfter(dataInicioGenZ) || data.isBefore(dataFimGenZ);
        }));

    }

    public static boolean verificarGeracaoZ(LocalDate dataNascimento, Predicate<LocalDate> predicate) {
        return predicate.test(dataNascimento);
    }


}

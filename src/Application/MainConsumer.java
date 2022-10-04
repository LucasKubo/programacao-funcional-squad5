package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class MainConsumer {
    public static void main(String[] args) {
        //Convencional
        LocalDateTime dataTest = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(formatter.format(dataTest));

        //Classe anônima
        Consumer<LocalDateTime> consumerDataFormatada = new Consumer<LocalDateTime>() {
            @Override
            public void accept(LocalDateTime localDateTime) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                System.out.println(formatter.format(localDateTime));
            }
        };

        printDataFormatada(consumerDataFormatada,dataTest);

        //Lambda
        printDataFormatada((data)->{
            System.out.println(formatter.format(data));
        },dataTest);
    }
    private static void printDataFormatada(Consumer<LocalDateTime> consumer, LocalDateTime data){
        consumer.accept(data);
    }

}

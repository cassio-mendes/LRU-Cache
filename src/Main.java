import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Cache cache;

    private static void put(String key, int value) {
        String[] keys = cache.getKeys();
        int[] frequency = cache.getFrequency();
        int[] values = cache.getValues();
        
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] == null) {
                keys[i] = key;
                values[i] = value; 
                cache.setKeys(keys);
                cache.setValues(values);

                frequency[i] = cache.getActualFrequency();
                cache.setFrequencyList(frequency);
                cache.increaseActualFrequency();
                return;
            }
        }

        int lowestFrequency = frequency[0];
        int lowestFrequencyIndex = 0;

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] < lowestFrequency) {
                lowestFrequency = frequency[i];
                lowestFrequencyIndex = i;
            }
        }

        keys[lowestFrequencyIndex] = key;
        values[lowestFrequencyIndex] = value;
        cache.setKeys(keys);
        cache.setValues(values);

        frequency[lowestFrequencyIndex] = cache.getActualFrequency();
        cache.setFrequencyList(frequency);
        cache.increaseActualFrequency();
    }

    private static String get(String key) {
        String[] keys = cache.getKeys();

        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null && keys[i].equalsIgnoreCase(key)) {
                return String.valueOf(cache.getValues()[i]);
            }
        }

        return "-1";
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Informe o tamanho da lista de cache: ");
        cache = new Cache(Integer.parseInt(input.nextLine()));

        String option, line, key = "";
        int value;
        ArrayList<String> results = new ArrayList<>();

        System.out.println("Por fim informe cada operação que deseja realizar no cache: put (adicionar uma chave e um valor), ou " +
        "get (informar uma chave e receber seu valor correspondente). Escreva -1 quanto terminar. ");

        do {
            System.out.print("Operação: ");
            option = input.nextLine();

            switch (option) {
                case "put": {
                    System.out.println("Informe a chave e o valor a serem inseridos no cache, numa mesma linha, separados por um espaço em branco (o resultado na lista de retornos será null).");

                    line = input.nextLine();
                    key = line.split(" ")[0];
                    value = Integer.parseInt(line.split(" ")[1]);

                    put(key, value);
                    results.add(null);
                    break;
                }

                case "get": {
                    System.out.print("Informe a chave do valor a ser buscado (caso não haja um valor correspondente no cache, o resultado será -1): ");

                    key = input.nextLine();
                    results.add(get(key));
                    break;
                }
   
                default: break;
            }

        } while (!option.equals("-1"));

        input.close();

        System.out.println("\nLista de retornos das funções put e get, em ordem de execução: " + results);
        System.out.print("Cache final: [");

        String[] keys = cache.getKeys();
        int[] values = cache.getValues();
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + " : " + values[i]);

            if (i == keys.length - 1) {
                System.out.print("]");
            } else {
                System.out.print(", ");
            }
        }
    }

}

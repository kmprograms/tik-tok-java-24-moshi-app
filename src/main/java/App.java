import adapter.BigDecimalAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import model.Address;
import model.Hobby;
import model.Person;
import model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------(1)---------------------------------");
            System.out.println("------------------------------------------------------------------");

            Moshi moshi = new Moshi.Builder().add(new BigDecimalAdapter()).build();
            JsonAdapter<Person> personJsonAdapter = moshi.adapter(Person.class);

            var person = Person.builder()
                    .name("ADAM")
                    .age(11)
                    .address(Address.builder()
                            .city("Warszawa")
                            .street("Zielona")
                            .number(3)
                            .build())
                    .hobbies(Set.of(Hobby.BOOKS, Hobby.MUSIC))
                    .build();

            var json = personJsonAdapter
                    .nullSafe()
                    .indent("   ")
                    .toJson(person);
            System.out.println(json);

            var personFromJson = personJsonAdapter.fromJson(json);
            System.out.println(personFromJson);

            System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------(2)---------------------------------");
            System.out.println("------------------------------------------------------------------");

            JsonAdapter<List<Person>> peopleJsonAdapter = moshi.adapter(Types.newParameterizedType(List.class, Person.class));

            var people = List.of(
                    Person.builder()
                            .name("IZA")
                            .age(22)
                            .address(Address.builder()
                                    .city("Kraków")
                                    .street("Zielona")
                                    .number(3)
                                    .build())
                            .hobbies(Set.of(Hobby.SPORT, Hobby.MUSIC))
                            .build(),
                    Person.builder()
                            .name("OLA")
                            .age(21)
                            .address(Address.builder()
                                    .city("Wrocław")
                                    .street("Biała")
                                    .number(13)
                                    .build())
                            .hobbies(Set.of(Hobby.SPORT, Hobby.BOOKS))
                            .build()
            );

            var json2 = peopleJsonAdapter
                    .nullSafe()
                    .indent("   ")
                    .toJson(people);
            System.out.println(json2);

            var peopleFromJson = peopleJsonAdapter.fromJson(json2);
            System.out.println(peopleFromJson);

            System.out.println("------------------------------------------------------------------");
            System.out.println("------------------------------(3)---------------------------------");
            System.out.println("------------------------------------------------------------------");

            JsonAdapter<Product> productJsonAdapter = moshi.adapter(Product.class);

            var product = Product.builder().name("PROD A").price(new BigDecimal("120")).build();
            var json3 = productJsonAdapter.toJson(product);
            System.out.println(json3);

            var productFromJson = productJsonAdapter.fromJson(json3);
            System.out.println(productFromJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

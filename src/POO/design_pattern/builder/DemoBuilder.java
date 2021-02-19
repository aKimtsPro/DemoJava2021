package POO.design_pattern.builder;

import java.time.LocalDate;

public class DemoBuilder {

    public static void main(String[] args) {
        Employe.Builder employe = Employe.builder("dubois","luc") // avantage : si les constructeurs sont en private
                .dateNaiss(LocalDate.now());

        Employe employe1 = new EmployeBuilder() // inconvéniant : si les constructeurs sont en private
                .nom("dubois")
                .prenom("luc")
                .dateNaiss(LocalDate.now())
                .surnom("luke")
                .numTel("0")
                .build();

        employe.surnom("luke")
                .numTel("0");
        Employe rslt = employe.build();
    }
}

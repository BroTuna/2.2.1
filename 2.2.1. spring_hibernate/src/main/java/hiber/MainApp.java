package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServise;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarServise carServise = context.getBean(CarServise.class);

      userService.add(new User("Николай", "Попов", "pop1@mail.ru",
              carServise.add(new Car("kia", 3))));
      userService.add(new User("Капитан", "Крюк", "naabordaj2@mail.ru",
              carServise.add(new Car("Lada", 9))));
      userService.add(new User("Виктор", "Гречка", "mopedonelove3@mail.ru",
              carServise.add(new Car("Мопед", 99))));
      userService.add(new User("Крейзи", "Безымянный", "666@mail.ru",
              carServise.add(new Car("Opel", 66))));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Модель = "+user.getCarsEmp().getModel());
      }

      User userCar = userService.getUserCar("Lada", 9);
      System.out.println("Id = " + userCar.getId());
      System.out.println("First Name = "+userCar.getFirstName());
      System.out.println("Last Name = "+userCar.getLastName());
      System.out.println("Email = "+userCar.getEmail());
      System.out.println("Model = "+ userCar.getCarsEmp().getModel());
      System.out.println("Series = "+ userCar.getCarsEmp().getSeries());

            context.close();
   }
}
